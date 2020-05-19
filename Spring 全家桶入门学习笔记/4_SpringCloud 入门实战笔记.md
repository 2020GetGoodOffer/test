# Spring Cloud 入门实战笔记

## 概述

### 单体应用存在的问题

- 随着业务发展，开发越来越复杂。
- 修改、新增某个功能，需要对整个系统进行测试、重新部署。
- 一个模块出现问题，可能导致整个系统崩溃。
- 多个开发团队同时对数据进行管理，容易产生安全漏洞。
- 各个模块使用同一种技术开发，各个模块很难根据实际情况选择更合适的技术框架，局限性很大。

**分布式和集群**

- **集群：**一台服务器无法负荷高并发的数据访问量，就设置多台服务器一起分担压力，是在物理层面解决问题。
- **分布式：**将一个复杂的问题拆分成若干简单的小问题，将一个大型的项目架构拆分成若干个微服务来协同完成，在软件设计层面解决问题。

---

### 微服务的优点

- 各个服务的开发、测试、部署都相互独立，用户服务可以拆分为独立服务，如果用户量很大，可以很容易对其实现负载。
- 当新需求出现时，使用微服务不再需要考虑各方面的问题，例如兼容性、影响度等。
- 使用微服务拆分项目后，各个服务之间消除了很多限制，只需要保证对外提供的接口正常可用，而不限制语言和框架等选择。

---

## 服务治理 Eureka

服务治理的核心由三部分组成：**服务提供者**、**服务消费者**、**注册中心**。

**服务注册：**在分布式系统架构中，每个微服务在启动时，将自己的信息存储在注册中心。

**服务发现：**服务消费者从注册中心获取服务提供者的网络信息，通过该信息调用服务。

Spring Cloud 的服务治理使用 Eureka 实现，Eureka 是 Netflix 开源的基于 REST 的服务治理解决方案，Spring Cloud 集成了 Eureka，提供服务注册和服务发现的功能，可以和基于 Spring Boot 搭建的微服务应用轻松完成整合，将 Eureka 二次封装为 Spring Cloud Eureka。

**Spring Cloud Eureka**

- **Eureka Server**，注册中心。
- **Eureka Client**，所有要进行注册的微服务通过 Eureka Client 连接到 Eureka Server 完成注册。

---

### Server 环境配置

创建一个 maven 工程，配置 `pom.xml` 文件

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.0.7.RELEASE</version>
</parent>

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.16.12</version>
    </dependency>
</dependencies>

<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>Finchley.SR2</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

创建一个 `eurekaserver` 子工程，并配置其 `pom.xml` 文件如下：

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        <version>2.0.2.RELEASE</version>
    </dependency>
</dependencies>
```

在 `eurekaserver` 子工程的 resources 目录下创建 `application.yml` 配置如下：

```yml
server:
  port: 8761 #当前eureka server 服务端口
  
eureka:
  client:
    register-with-eureka: false #是否将当前的 eureka server 服务作为客户端进行注册
    fetch-registry: false #是否获取其他 eureka server 服务的数据
    service-url: 
      defaultZone: http://localhost:8761/eureka/ #注册中心的访问地址
```

在 `eurekakaserver` 子工程的 java 目录下创建启动类：

```java
@SpringBootApplication //SpringBoot 服务的入口
@EnableEurekaServer //声明该类是一个 eureka server 微服务，提供服务注册和服务发现，即注册中心
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class,args);
    }
}
```

之后启动 `EurekaServerApplication`，可以成功访问 `localhost:8761` 。

---

### Client 环境配置

创建一个 `eurekaclient` 子工程，并配置其 `pom.xml` 文件如下：

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        <version>2.0.2.RELEASE</version>
    </dependency>
</dependencies>
```

在 `eurekaclient` 子工程的 resources 目录下创建 `application.yml` 配置如下：

```yml
server:
  port: 8010

spring:
  application:
    name: provider #当前服务注册在 eureka server 的名称

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/ #注册中心的访问地址
  instance:
    prefer-ip-address: true #是否将当前服务的ip注册到 eureka server
```

在 `eurekakaclient` 子工程的 java 目录下创建启动类：

```java
@SpringBootApplication //SpringBoot 服务的入口
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class,args);
    }
}
```

之后启动 `ProviderApplication`，此时 `localhost:8761` 中就多出了一个服务：

<img src="https://img-blog.csdnimg.cn/20200518124208150.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:80%;" />

---

### 提供服务

在 `eurekaclient` 子工程创建一个实体类：

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Integer id;

    private String name;

    private int age;

}
```

创建接口和实现类：

```java
public interface StudentRepo{

    Collection<Student> findAll();

    Student findById(Integer id);

    void update(Student student);

    void deleteById(Integer id);
}
------
@Repository
public class StudentRepoImpl implements StudentRepo {

    private static Map<Integer, Student> map;

    static {
        map = new HashMap<>();
        map.put(1,new Student(1,"sjh",24));
        map.put(2,new Student(2,"ss",23));
    }

    @Override
    public Collection<Student> findAll() {
        return map.values();
    }

    @Override
    public Student findById(Integer id) {
        return map.get(id);
    }

    @Override
    public void update(Student student) {
        map.put(student.getId(),student);
    }

    @Override
    public void deleteById(Integer id) {
        map.remove(id);
    }
}
```

创建控制器类和方法：

```java
@RestController
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return studentRepo.findAll();
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") Integer id){
        return studentRepo.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student){
        studentRepo.update(student);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        studentRepo.update(student);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        studentRepo.deleteById(id);
    }

}
```

再次启动 `ProviderApplication`，可以在`localhost:8010`下访问提供的服务：

<img src="https://img-blog.csdnimg.cn/20200518143423689.png" style="zoom:80%;" align='left'/>

---

### RestTemplate

RestTemplate 是 Spring 框架提供的基于 REST 的服务组件，底层是对 HTTP 请求及响应进行了封装，提供了很多访问 REST 服务的方法，可以简化代码开发。

创建一个 `resttemplate` 子工程，把之前的 Student 实体类复制一份，创建启动类：

```java
@SpringBootApplication
public class RestTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestTemplateApplication.class,args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
```

创建控制器类和方法：

```java
@RestController
@RequestMapping("/rest")
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return restTemplate.getForEntity("http://localhost:8010/stu/findAll",Collection.class).getBody();
        //return restTemplate.getForObject("http://localhost:8010/stu/findAll",Collection.class);
    }


    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") Integer id){
        return restTemplate.getForEntity("http://localhost:8010/stu/findById/{id}",Student.class,id).getBody();
        //return restTemplate.getForObject("http://localhost:8010/stu/findById/{id}",Student.class,id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student){
        restTemplate.postForEntity("http://localhost:8010/stu/save",student,null).getBody();
        //restTemplate.postForObject("http://localhost:8010/stu/save",student,null);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        restTemplate.put("http://localhost:8010/stu/update",student);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        restTemplate.delete("http://localhost:8010/stu/deleteById/{id}",id);
    }
}
```

运行启动类，访问 `localhost:8080/rest`下的各种接口，可以正常提供服务：

<img src="https://img-blog.csdnimg.cn/20200518152058996.png" style="zoom:80%;" align='left'/>

---

### 消费服务

创建一个 `consumer` 子工程，把之前的 Student 实体类复制一份，并配置其 `pom.xml` 文件如下：

```
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        <version>2.0.2.RELEASE</version>
    </dependency>
</dependencies>
```

在 `consumer` 子工程的 resources 目录下创建 `application.yml` 配置如下：

```yml
server:
  port: 8020
  
spring:
  application:
    name: consumer

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/ #注册中心的访问地址
  instance:
    prefer-ip-address: true #是否将当前服务的ip注册到 eureka server
```

创建启动类：

```java
@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);
    }
    
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
```

控制器类和方法：

```java
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return restTemplate.getForEntity("http://localhost:8010/stu/findAll",Collection.class).getBody();
        //return restTemplate.getForObject("http://localhost:8010/stu/findAll",Collection.class);
    }


    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") Integer id){
        return restTemplate.getForEntity("http://localhost:8010/stu/findById/{id}",Student.class,id).getBody();
        //return restTemplate.getForObject("http://localhost:8010/stu/findById/{id}",Student.class,id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student){
        restTemplate.postForEntity("http://localhost:8010/stu/save",student,null).getBody();
        //restTemplate.postForObject("http://localhost:8010/stu/save",student,null);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        restTemplate.put("http://localhost:8010/stu/update",student);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        restTemplate.delete("http://localhost:8010/stu/deleteById/{id}",id);
    }
}
```

此时，启动server、provider和consumer：

<img src="https://img-blog.csdnimg.cn/20200518153826975.png" style="zoom:80%;" align='left'/>

可以在 Eureka 注册中心发现服务提供者和消费者均已注册：

<img src="https://img-blog.csdnimg.cn/20200518153903647.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:80%;" />

访问 `localhost:8020/consumer`下的各种接口，测试服务：

<img src="https://img-blog.csdnimg.cn/20200518154009517.png" style="zoom:80%;" align='left' />

--

## 服务网关 Zuul

Spring Cloud 集成了 Zuul 组件，实现服务网关。

Zuul 是 Netflix 提供的一个开源的 API 网关服务器，是客户端和网站后端所有请求的中间层，对外开放一个 API，将所有请求导入统一的入口，屏蔽了服务端的具体实现逻辑，可以实现方向代理功能，在网关内部实现动态路由、身份认证、IP过滤、数据监控等。

### 环境搭建

创建一个 `zuul` 子工程，`pom.xml` 配置如下：

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        <version>2.0.2.RELEASE</version>
    </dependency>

    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
        <version>2.0.2.RELEASE</version>
    </dependency>
</dependencies>
```

创建 `application.yml` ，配置如下：

```
server:
  port: 8030

spring:
  application:
    name: gateway

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/ #注册中心的访问地址
      
zuul:
  routes: 
    provider: /p/** #给服务提供者设置映射
```

创建启动类：

```java
@EnableZuulProxy//包含了@EnableZuulServer，设置该类为网关的启动类
@EnableAutoConfiguration//可以帮助 SpringBoot 应用将所有符合条件的 @Configuration 加载到当前 SpringBoot 创建并使用的 IoC 容器中。
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class,args);
    }
}
```

依次启动 server、provider、zuul，此时可以通过之前设置的映射来访问服务提供者：

<img src="https://img-blog.csdnimg.cn/20200518160823822.png" style="zoom:80%;" align='left'/>

---

### Zuul 的负载均衡

Zuul 自带了负载均衡功能，修改 provider 的代码：

在 StudentController 加入：

```java
@Value("${server.port}")
private String port;    

...
    
@GetMapping
public String index(){
    return "当前端口："+this.port;
}
```

启动server 和 provider，之后修改端口为8011，然后再创建一个启动类并启动：

```java
@SpringBootApplication //SpringBoot 服务的入口
public class ProviderApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication2.class,args);
    }
}
```

此时就有两个服务提供者：

![](https://img-blog.csdnimg.cn/20200518161831960.png)

分别访问 `localhost:8010/stu` 和  `localhost:8011/stu`：

<img src="https://img-blog.csdnimg.cn/20200518162051253.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:80%;" align='left'/>

之后启动 zuul，访问 `localhost:8030/p/stu` ，客户端请求通过网关请求服务提供者，有两个服务交替响应:

<img src="https://img-blog.csdnimg.cn/20200518162343103.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:80%;" align='left'/>

---

## 负载均衡 Ribbon

Spring Cloud Ribbon 是一个负载均衡的解决方案，Ribbon 是 Netflix 发布的均衡负载器，Spring Cloud Ribbon是基于 Netflix Ribbon 实现的，是一个用于对 HTTP 请求进行控制的负载均衡客户端。

在注册中心对 Ribbon 进行注册之后，Ribbon 就可以基于某种负载均衡算法（轮循、随机、加权轮询、加权随机等）自动帮助服务消费者调用接口，开发者也可以根据具体需求自定义 Ribbon 负载均衡算法。实际开发中 Spring Clooud Ribbon 需要结合 Spring Cloud Eureka 使用，Eureka 提供所有可以调用的服务提供者列表，Ribbon 基于特定的负载均衡算法从这些服务提供者中选择要调用的具体实例。

### 环境搭建

创建一个 `ribbon` 子工程，把之前的 Student 实体类复制一份，`pom.xml` 配置如下：

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        <version>2.0.2.RELEASE</version>
    </dependency>
</dependencies>
```

创建 `application.yml` ，配置如下：

```yml
server:
  port: 8040

spring:
  application:
    name: ribbon

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/ #注册中心的访问地址
  instance:
    prefer-ip-address: true
```

创建启动类：

```java
@SpringBootApplication
public class RibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class,args);
    }
    
    @Bean
    @LoadBalanced//负载均衡注解
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
```

创建控制器类和方法：

```java
@RestController
@RequestMapping("/ribbon")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return restTemplate.getForObject("http://provider/stu/findAll",Collection.class);
    }
    
    @GetMapping
    public String index(){
        return restTemplate.getForObject("http://provider/stu",String.class);
    }
}
```

---

### 实现负载均衡

启动 server、按照之前的步骤启动两个 provider，之后启动 ribbon：

![](https://img-blog.csdnimg.cn/20200518171732615.png)

此时通过 ribbon 来访问服务：

<img src="https://img-blog.csdnimg.cn/20200518171817575.png" style="zoom:80%;" />)

实际上此时实现了负载均衡，每次请求都是不同的端口：

<img src="https://img-blog.csdnimg.cn/20200518171927676.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:80%;" align='left'/>

---

## 声明式接口调用 Feign

Feign 与 Ribbon 一样，Feign 也是 Netflix 提供的，Feign 是一个声明式、模板化的 Web Service 客户端，简化了开发者编写 Web 服务客户端的操作，开发者可以通过简单的接口和注解来调用 HTTP API，Spring Cloud Feign 整合了 Ribbon 和 Hystrix，具有可插拔、基于注解、负载均衡、服务熔断等一系列功能。

相比于 Ribbon + RestTemplate 的方式，Feign 可以大大简化代码开发，支持多种注解，包括 Feign 注解、JAX-RS 注解、Spring MVC 注解等。

### 环境搭建

创建一个 `feign` 子工程，把之前的 Student 实体类复制一份，`pom.xml` 配置如下：

```xml
<dependencies>

    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        <version>2.0.2.RELEASE</version>
    </dependency>

    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-openfeign</artifactId>
        <version>2.0.2.RELEASE</version>
    </dependency>

</dependencies>
```

创建 `application.yml` ，配置如下：

```yml
server:
  port: 8050
  
spring:
  application:
    name: feign

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/ #注册中心的访问地址
  instance:
    prefer-ip-address: true
```

创建启动类：

```java
@SpringBootApplication
@EnableFeignClients
public class FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class,args);
    }
}
```

创建接口：

```java
@FeignClient(value = "provider")//value值是服务提供者的名称
public interface FeignProvider {

    @GetMapping("/stu/findAll")
    Collection<Student> findAll();

    @GetMapping("/stu")
    String index();
}
```

创建控制器类和方法：

```java
@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private FeignProvider feignProvider;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return feignProvider.findAll();
    }

    @GetMapping
    public String index(){
        return feignProvider.index();
    }
}
```

启动 server、按照之前的步骤启动两个 provider，之后启动 feign：

![](https://img-blog.csdnimg.cn/20200518175843698.png)

同样 Feign 实现了负载均衡：

<img src="https://img-blog.csdnimg.cn/2020051817595121.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:80%;" align='left' />

可以对外提供服务：

<img src="https://img-blog.csdnimg.cn/20200518180045809.png" style="zoom:80%;" align='left'/>

---

### Feign 的服务熔断 

在 `application.yml` 进行配置：

```yml
feign:
  hystrix:
    enabled: true #是否开启熔断器
```

创建 `FeignProvider` 的实现类，定义容错处理逻辑，通过 `@Component` 注解将其注入 IoC 容器：

```java
@Component
public class FeignError implements FeignProvider {
    
    @Override
    public Collection<Student> findAll() {
        return null;
    }

    @Override
    public String index() {
        return "服务器维护中";
    }
}
```

在`FeignProvider` 的 `@FeignClient` 注解添加 `fallback` 属性进行降级处理：

```java
fallback = FeignError.class
```

现在不启动服务提供者，只启动 server 和 feign，访问服务，显示如下：

<img src="https://img-blog.csdnimg.cn/20200518203019425.png" style="zoom:80%;" align='left' />

---

## 服务熔断 Hystrix

熔断器的作用：在不改变各个微服务调用关系的前提下，针对错误情况进行预先处理。

**设计原则：**

- 服务隔离机制
- 服务降级机制
- 熔断机制
- 提供实时监控和报警功能
- 提供实时配置修改功能

Hystrix 数据监控需要结合 `Spring Boot Actuator` 使用，Actuator 提供了对服务的数据监控、数据统计，可以通过 `hystirx-stream` 节点获取监控的请求数据，同时提供了可视化监控界面。

### 环境搭建

创建一个 `hystrix` 子工程，把之前的 Student 实体类和 FeignProvider 接口复制一份，`pom.xml` 配置如下：

```xml
<dependencies>

    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        <version>2.0.2.RELEASE</version>
    </dependency>

    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-openfeign</artifactId>
        <version>2.0.2.RELEASE</version>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
        <version>2.0.7.RELEASE</version>
    </dependency>

    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
        <version>2.0.2.RELEASE</version>
    </dependency>

    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
        <version>2.0.2.RELEASE</version>
    </dependency>

</dependencies>
```

创建 `application.yml` ，配置如下：

```yml
server:
  port: 8070

spring:
  application:
    name: hystrix

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/ #注册中心的访问地址
  instance:
    prefer-ip-address: true

feign:
  hystrix:
    enabled: true

management:
  endpoints:
    web:
      exposure:
        include: 'hystrix.stream' #监控数据
```

创建启动类：

```
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker//声明启用数据监控
@EnableHystrixDashboard//声明启用可视化数据监控
public class HystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class,args);
    }
}
```

创建控制器类和方法：

```java
@RestController
@RequestMapping("/hystrix")
public class HystrixController {
    
    @Autowired
    private FeignProvider feignProvider;
    
    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return feignProvider.findAll();
    }
    
    @GetMapping("/index")
    public String index(){
        return feignProvider.index();
    }
}
```

-----

### 数据监控

启动 server、provider、hystrix：

<img src="https://img-blog.csdnimg.cn/20200518230551950.png" style="zoom:80%;" />

访问 `loaclhost:8070/hystrix/findAll` 之后访问 `loaclhost:8070/actuator/hystrix.stream` 查看数据监控： 

<img src="https://img-blog.csdnimg.cn/20200518231036773.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:67%;" align='left'/>

如果要可视化监控，访问`loaclhost:8070/hystrix` ,输入要监控的地址：

<img src="https://img-blog.csdnimg.cn/20200518231451934.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:80%;" />

---

## 服务配置 Config

Spring Cloud Config 通过服务端可以为多个客户端提供配置服务，既可以将配置文件存储在本地，也可以将配置文件存储在远程的 Git 仓库，创建 Config Server，通过它管理所有的配置文件。

### 本地配置

#### 服务端

创建一个 `nativeconfigserver` 子工程，`pom.xml` 配置如下：

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
    <version>2.0.2.RELEASE</version>
</dependency>
```

创建 `application.yml` ，配置如下：

```yml
server:
  port: 8762

spring:
  application:
    name: nativeconfigserver
  profiles:
    active: native #读取本地配置
  cloud:
    config:
      server:
        native:
          search-locations: classpath:/shared #本地配置文件路径
```

在 resources 目录下新建一个 shared 目录，创建 `configclient-dev.yml`，配置如下：

```yml
server:
  port: 8090
  
foo: foo version 1
```

创建启动类：

```java
@SpringBootApplication
@EnableConfigServer //声明配置中心
public class NativeConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NativeConfigServerApplication.class,args);
    }
}
```

----

#### 客户端

创建一个 ` nativeconfigclient` 子工程作为客户端读取配置文件，`pom.xml` 配置如下：

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
    <version>2.0.2.RELEASE</version>
</dependency>
```

创建 `bootstrap.yml`（名字不可变），读取本地配置中心相关信息，配置如下：

```yml
spring:
  application:
    name: configclient # 本地配置文件 “-”前面的内容
  profiles:
    active: dev  # 本地配置文件 “-”后面的内容
  cloud:
    config:
      uri: http://localhost:8762 #本地config server的访问路径
      fail-fast: true #设置客户端优先判断 config server 获取是否正常
```

创建启动类：

```java
@SpringBootApplication
public class NativeConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(NativeConfigClientApplication.class,args);
    }
}
```

创建控制器类和方法：

```java
@RestController
@RequestMapping("/native")
public class NativeConfigController {
    
    @Value("${server.port}")
    private String port;
    
    @Value("${foo}")
    private String foo;
    
    @GetMapping("/index")
    public String index(){
        return this.port + "-" + this.foo;
    }
}
```

启动 server 、configserver 和 configclient：

<img src="https://img-blog.csdnimg.cn/2020051910290974.png" style="zoom:80%;" align='left'/>

访问 `localhost:8090/native/index` ，成功读取:

<img src="https://img-blog.csdnimg.cn/20200519103134854.png" style="zoom:80%;" align='left'/>

---

### 远程配置

在父工程创建一个 config 文件夹，在该文件夹下创建一个 `configclient.yml` ：

```yml
server:
  port: 8070

spring:
  application:
    name: configclient
    
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/ #注册中心的访问地址
```

将其上传至 GitHub：

<img src="https://img-blog.csdnimg.cn/2020051910562229.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:67%;" align='left'/>

#### 服务端

创建一个 `configserver` 子工程，`pom.xml` 配置如下：

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-config-server</artifactId>
        <version>2.0.2.RELEASE</version>
    </dependency>

    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        <version>2.0.2.RELEASE</version>
    </dependency>
</dependencies>
```

创建 `application.yml` ，配置如下：

```yml
server:
  port: 8763

spring:
  application:
    name: configserver
  cloud:
    config:
      server:
        git:
          uri: https://github.com/2020GetGoodOffer/test.git
          search-paths: config
          username: 你的git用户名
          password: 你的git密码
      label: master
    
eureka:
  client:
    service-url: 
      defaultZone: http://localhost:8761/eureka/
```

创建启动类：

```java
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class,args);
    }
}
```

----

#### 客户端

创建一个 ` configclient` 子工程作为客户端读取配置文件，`pom.xml` 配置如下：

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-config</artifactId>
        <version>2.0.2.RELEASE</version>
    </dependency>

    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        <version>2.0.2.RELEASE</version>
    </dependency>
</dependencies>
```

创建 `bootstrap.yml`（名字不可变），读取远程配置中心相关信息，配置如下：

```yml
spring:
  cloud:
    config:
      name: configclient #与远程仓库的配置文件名对应
      label: master #git仓库的分支
      discovery:
        enabled: true #是否开启 config 服务发现支持
        service-id: configserver  #配置中心在 eureka server 的名称

eureka:
  client:
    service-url: 
      defaultZone: http://localhost:8761/eureka/
```

创建启动类：

```java
@SpringBootApplication
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class,args);
    }
}
```

创建控制器类和方法：

```java
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${server.port}")
    private String port;


    @GetMapping("/index")
    public String index(){
        return this.port;
    }
}
```

启动 server 、configserver 和 configclient：

<img src="https://img-blog.csdnimg.cn/20200519113021653.png" style="zoom:80%;" />

访问 `localhost:8070/config/index` ，成功读取:

<img src="https://img-blog.csdnimg.cn/20200519113044112.png" style="zoom:80%;" align='left'/>

---

## 服务跟踪 Zipkin

Spring Cloud Zipkin 是一个可以采集并跟踪分布式系统中请求数据的组件，让开发者更直观地监控到请求在各个微服务耗费的时间，Zipkin 包括两部分 Zipkin Server 和 Zipkin Client。

### 服务端

创建一个 ` zipkin` 子工程，`pom.xml` 配置如下：

```xml
<dependencies>
    <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
    <dependency>
        <groupId>io.zipkin.java</groupId>
        <artifactId>zipkin-server</artifactId>
        <version>2.9.4</version>
    </dependency>

    <dependency>
        <groupId>io.zipkin.java</groupId>
        <artifactId>zipkin-autoconfigure-ui</artifactId>
        <version>2.9.4</version>
    </dependency>
</dependencies>
```

创建 `application.yml` ，配置如下：

```yml
server:
  port: 9090
  
management:
  metrics:
    web:
      server:
        auto-time-requests: false
```

创建启动类：

```java
@SpringBootApplication
@EnableZipkinServer//声明启动 zipkin server
public class ZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinApplication.class,args);
    }
}
```

---

### 客户端

创建一个 ` zipkinclient` 子工程，`pom.xml` 配置如下：

```xml
<dependencies>
    
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-zipkin</artifactId>
        <version>2.0.2.RELEASE</version>
    </dependency>
    
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        <version>2.0.2.RELEASE</version>
    </dependency>
</dependencies>
```

创建 `application.yml` ，配置如下：

```yml
server:
  port: 8090

spring:
  application:
    name: zipkinclient
  sleuth:
    web:
      enabled: true #启动监控
    sampler:
      probability: 1.0 #设置采样比例
  zipkin:
    base-url: http://localhost:9090/ # zipkin服务端地址

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```

创建启动类：

```java
@SpringBootApplication
public class ZipkinClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinClientApplication.class,args);
    }
}
```

创建控制器类和方法：

```java
@RestController
@RequestMapping("/zipkin")
public class ZipkinController {
    
    @Value("${server.port}")
    private String port;
    
    @GetMapping("/index")
    public String index(){
        return this.port;
    }
}
```

启动 server、zipkin server、zipkin client：

<img src="https://img-blog.csdnimg.cn/20200519125825963.png" style="zoom:80%;" align='left' />

在 `localhost:8090/zipkin/index` 访问服务：

<img src="https://img-blog.csdnimg.cn/20200519125904510.png" style="zoom:80%;" align='left'/>

在 `localhost:9090/zipkin/` 监控：

<img src="https://img-blog.csdnimg.cn/20200519130010277.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:80%;" />

---

