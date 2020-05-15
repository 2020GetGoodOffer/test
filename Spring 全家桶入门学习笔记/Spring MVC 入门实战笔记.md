# Spring MVC 入门笔记

## 概述

SpringMVC是目前主流实现MVC设计模式的框架，是Spring框架的一个分支产品，相当于Spring的一个子模块，可以很好地和Spring结合起来开发，是Java Web开发必须要掌握的框架。

**MVC设计模式：**

将应用程序分为`Controller`、`Model`、`View`三层：`Controller`接收客户端请求，调用`Model`生成业务数据，再传递给`View`展示给用户。SpringMVC就是对这套流程的封装，屏蔽了很多底层代码，帮助开发者更便捷地进行Web开发。

---

### Spring MVC 的核心组件

- **DispatcherServlet  ：** SpringMVC中的前端控制器，是整个流程控制的核心，负责接收请求并转发给对应的处理组件。
- **Handler ：**处理器，完成具体业务逻辑，相当于Servlet或Action。
- **HandlerMapping ：**完成URL到Controller映射的组件，DispatcherServlet接收到请求之后，通过HandlerMapping将不同的请求映射到不同的Handler。
- **HandlerInterceptor：**处理器拦截器，是一个接口，如果需要完成一些拦截处理，可以实现该接口。
- **HandlerExecutionChain：**处理器执行链，包括两部分内容：Handler和HandlerInterceptor。
- **HandlerAdapter：**处理器适配器，Handler执行业务方法前需要进行一系列操作，包括表单数据验证、数据类型转换、将表单数据封装到JavaBean等，这些操作都由HandlerAdapter完成。DispatcherServlet通过HandlerAdapter来执行不同的Handler。
- **ModelAndView：**装载了模型数据和视图信息，作为Handler的处理结果返回给DispatcherServlet。
- **ViewResolver：**视图解析器，DispatcherServlet 通过它将逻辑视图解析为物理视图，最终将渲染的结果响应给客户端。

---

### Spring MVC 工作流程

- DispatcherServlet 接收客户端请求，然后根据 HandlerMapping 将请求映射到 Handler。
- 生成 Handler和 HandlerInterceptor，以HandlerExecutionChain的形式一并返回给DispatcherServlet。
- DispatcherServlet 通过 HandlerAdapter 调用 Handler 的方法完成业务逻辑处理，Handler 返回一个 ModelAndView 给DispatcherServlet。
- DispatcherServlet 将 ModelAndView 传给 ViewResolver，ViewResolver将逻辑视图解析为物理视图并返回给DispatcherServlet。
- DispatcherServlet 根据 View 进行视图渲染（将模型数据填充到View中），然后响应给客户端。

---

### 入门案例

- 构建一个gradle的web工程，`build.gradle`配置如下：

  ```groovy
  plugins {
      id 'java'
      id 'war'
  }
  
  group 'com.sjh'
  version '1.0-SNAPSHOT'
  
  sourceCompatibility = 1.8
  
  repositories {
      mavenCentral()
  }
  
  dependencies {
      testCompile group: 'junit', name: 'junit', version: '4.12'
      compile group: 'org.springframework', name: 'spring-context', version: '5.0.2.RELEASE'
      compile group: 'org.springframework', name: 'spring-web', version: '5.0.2.RELEASE'
      compile group: 'org.springframework', name: 'spring-webmvc', version: '5.0.2.RELEASE'
      providedCompile group: 'javax.servlet', name: 'javax.servlet-api', version: '3.0.1'
      providedCompile group: 'javax.servlet', name: 'jsp-api', version: '2.0'
      providedCompile group: 'org.projectlombok', name: 'lombok', version: '1.16.12'
  }
  ```

- 在`src/main/webapp`下新建WEB-INF目录，在该目录下新建一个`web.xml`配置文件：

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns="http://java.sun.com/xml/ns/javaee"
           xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" id="WebApp_ID" version="2.5">
  
      <servlet>
          <servlet-name>dispatcherServlet</servlet-name>
          <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
          <init-param>
              <param-name>contextConfigLocation</param-name>
              <param-value>classpath:springmvc.xml</param-value>
          </init-param>
      </servlet>
  
      <servlet-mapping>
          <servlet-name>dispatcherServlet</servlet-name>
          <url-pattern>/</url-pattern>
      </servlet-mapping>
  
  </web-app>
  ```

- 在`src/main/resources`下新建一个`springmvc.xml`配置文件：

  视图解析器的配置相当于寻找`webapp/`目录下`.jsp`结尾的文件

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <beans xmlns="http://www.springframework.org/schema/beans"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns:context="http://www.springframework.org/schema/context"
         xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">
  
      <!-- 自动扫描 -->
      <context:component-scan base-package="com.sjh"/>
      
      <!-- 配置视图解析器 -->
      <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
          <property name="prefix" value="/"/>
          <property name="suffix" value=".jsp"/>
      </bean>
      
  </beans>
  ```

- 创建Handler：

  ```java
  @Controller//控制器标识
  public class MyController {
      
      @RequestMapping("/index")//请求URL
      public String index(){
          return "index";//返回index.jsp
      }
      
  }
  ```

- 配置tomcat服务器测试

  <img src="https://img-blog.csdnimg.cn/20200514170509482.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom: 67%;" />

  启动tomcat服务器，访问`loclhost:8080/index`：

  <img src="https://img-blog.csdnimg.cn/20200514170617691.png" style="zoom:80%;" />

---

## Spring MVC 注解

### `@RequtestMapping`

将URL请求和业务方法映射起来，在Controller的类定义以及方法定义上都可以添加该注解。

参数：

- `value `：指定URL请求的实际地址，是默认值。

  ```java
  @RequestMapping(value = "/index")
  public String index(){
      return "index";
  }
  ```

- `method`：限制请求的方法类型，包括GET、POST、PUT、DELETE等。如果没有使用指定的请求方法请求URL，会报405 Method Not Allowed 错误。

  ```java
  @RequestMapping(value = "/index",method = RequestMethod.GET)
  public String index(){
      return "index";
  }
  ```

- `params`：限制必须提供的参数，如果没有会报错。

  ```java
  @RequestMapping(value = "/index",params = {"name","id = 1"})
  public String index(){
      return "index";
  }
  ```

  此时如果像之前一样访问，会报400 Bad Request 错误：

  <img src="https://img-blog.csdnimg.cn/2020051417244898.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:80%;" />

  在URL中添加name和id，正常访问：

  <img src="https://img-blog.csdnimg.cn/20200514172538274.png" style="zoom:80%;" />

  还可以限制参数的值：

  ```java
  @RequestMapping(value = "/index",params = {"name","id = 1"})
  public String index(){
      return "index";
  }
  ```

---

### `@Controller`

在类定义处添加，将类交给IoC容器管理。

---

### `@RequestParam`

如果Controller方法的形参和URL参数名一致，不用添加注解。如果不一致可以使用`@RequestParam`：

```java
@RequestMapping(value = "/index")
public String index(@RequestParam("str") String name){
    System.out.println(name);
    return "index";
}
```

URL中输入str参数：

```java
http://localhost:8080/index?str=test%20success
```

控制台输出：

![](https://img-blog.csdnimg.cn/20200514173524884.png)

**属性：**

- **value ：**HTTP请求中的参数名
- **required：** 参数是否必要，默认false
- **defaultValue：** 如果没有给参数赋值时，参数的默认值

---

###  `@PathVariable`

Spring MVC也支持 RESTful 风格的 URL，通过`@PathVariable`完成请求参数与形参的绑定。

例如：

```java
@RequestMapping(value = "/rest/{name}")
public String rest(@PathVariable("name") String name){
    System.out.println(name);
    return "index";
}
```

访问`http://localhost:8080/rest/sjh`，控制台输出：

![](https://img-blog.csdnimg.cn/20200514174247804.png)

----

### `@Cookie`

通过映射可以在业务方法中获取cookie的值：

```java
@RequestMapping(value = "/cookie")
public String cookie(@CookieValue(value = "JSESSIONID") String id){
System.out.println(id);
return "index";
}
```

请求访问：`http://localhost:8080/cookie`，控制台输出：

![](https://img-blog.csdnimg.cn/20200514184000700.png)

---

## Spring MVC 数据绑定

在后端业务方法中直接获取客户端HTTP请求中的参数，将请求参数映射到业务方法的形参中。

Spring MVC中数据绑定的工作是由 Handler Adapter 完成的。

### 基本数据类型

以int为例，创建一个Controller：

```java
@Controller
@RequestMapping("/data")
public class DataBindController {
    
    @RequestMapping("/baseType")
    @ResponseBody//不会进行视图解析，直接将结果返回，如果不加该注解会去找1.jsp这个视图
    public String baseType(int id){
        return id + "";
    }
}
```

访问`localhost:8080/data/baseType?id=24`:

<img src="https://img-blog.csdnimg.cn/20200514194651472.png" style="zoom:80%;" />

---

### 包装类

以Integer为例：

```java
@RequestMapping("/packageType")
@ResponseBody
public String packageType(Integer id){
    return id + "";
}
```

可以接收null，即使没有传入参数也不会抛出异常，访问`localhost:8080/data/packageType`:

<img src="https://img-blog.csdnimg.cn/20200514195523141.png" style="zoom:80%;" />

不传值时，可以指定一个默认值：

```java
@RequestMapping("/packageType")
@ResponseBody
public String packageType(@RequestParam(value = "num",defaultValue = "0") Integer id){
    return id + "";
}
```

---

### 数组

```java
@RequestMapping("/arr")
@ResponseBody
public String arr(String[] name){
    return Arrays.toString(name);
}
```

访问`localhost:8080/data/arr?name=sjh&name=kobe`:

<img src="https://img-blog.csdnimg.cn/20200514200828852.png" style="zoom:80%;" />

如果使用`@RestController`取代`@Controller`，就不用在方法前再添加`@ResponseBody`注解。

`@RestController`会将业务方法的返回值直接响应给客户端而不进行视图解析，作用相当于`@ResponseBody`+`@Controller`。

---

### JavaBean 对象

Spring MVC会根据<font color="red">**请求参数名**</font>和<font color="red"> **JavaBean 属性名**</font>进行自动匹配，自动为对象填充属性，支持级联属性。

创建一个实体类User：

```java
@Data
public class User {

    private Integer id;

    private String name;

}
```

在Controller中添加一个save方法：

```java
@RequestMapping(value = "/save",method = RequestMethod.POST)
public String save(User user){
    System.out.println(user);
    return "index";
}
```

添加一个注册页面`register.jsp`：

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/save" method="post">
        用户id:<input type="text" name="id"><br/>
        用户名:<input type="text" name="name"><br/>
        <input type="submit" value="注册">
    </form>
</body>
</html>

```

访问`localhost:8080/register.jsp`:

<img src="https://img-blog.csdnimg.cn/20200514185318576.png" style="zoom:80%;" />

点击注册按钮，观察控制台输出，此时成功将前端数据封装到了User对象中，只是存在乱码问题：

![](https://img-blog.csdnimg.cn/20200514191424713.png)

接下来通过配置一个过滤器来解决中文乱码问题，在web.xml中增添如下配置：

```xml
<filter>
    <filter-name>encodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
        <param-name>encoding</param-name>
        <param-value>UTF-8</param-value>
    </init-param>
</filter>

<filter-mapping>
    <filter-name>encodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```

此时再次访问该URL，观察控制台输出：

![](https://img-blog.csdnimg.cn/20200514192216984.png)

关于级联操作的演示，先创建一个Address类：

```java
@Data
public class Address {
    
    private String country;
    
    private String city;
    
}
```

将该属性添加到User类：

```java
@Data
public class User {

    private Integer id;

    private String name;
    
    private Address address;
}
```

修改注册页：

```jsp
<form action="/save" method="post">
    用户id:<input type="text" name="id"><br/>
    用户名:<input type="text" name="name"><br/>
    用户国家:<input type="text" name="address.country"><br/>
    用户城市:<input type="text" name="address.city"><br/>
    <input type="submit" value="注册">
</form>
```

访问`localhost:8080/register.jsp`:

<img src="https://img-blog.csdnimg.cn/20200514192725539.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:80%;" />

点击注册，观察控制台输出：

![](https://img-blog.csdnimg.cn/20200514192758193.png)

SpringMVC默认以转发方式响应JSP，如果要使用重定向，可以使用redirect前缀：

```java
return "redirect:index";
```

---

### List 集合

Spring MVC 不支持 List 类型的直接转换，需要对其进行包装。

创建一个User的包装类：

```java
@Data
public class UserList {
    
    private List<User> userList;
    
}
```

Controller方法：

```java
@RequestMapping("/list")
public String list(UserList userList){
    StringBuilder sb = new StringBuilder();
    for(User user : userList.getUserList())
        sb.append(user).append(",");
    return sb.toString();
}
```

前端页面：

```jsp
<form action="/data/list" method="post">
    用户1编号:<input type="text" name="userList[0].id"><br/>
    用户1名称:<input type="text" name="userList[0].name"><br/>
    用户1国家:<input type="text" name="userList[0].address.country"><br/>
    用户1地址:<input type="text" name="userList[0].address.city"><br/>
    <br/>
    用户2编号:<input type="text" name="userList[1].id"><br/>
    用户2名称:<input type="text" name="userList[1].name"><br/>
    用户2国家:<input type="text" name="userList[1].address.country"><br/>
    用户2地址:<input type="text" name="userList[1].address.city"><br/>
    <input type="submit" value="提交">
</form>
```

输入相关数据：

<img src="https://img-blog.csdnimg.cn/20200514202259737.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:80%;" />

点击提交按钮，观察页面结果：

![](https://img-blog.csdnimg.cn/20200514202344899.png)

**@ResponseBody的乱码问题**

如果输入中文，响应时会有乱码问题，通过在sprinmvc.xml中配置消息转换器解决：

```xml
<!-- 配置消息转换器 -->
<mvc:annotation-driven>
    <mvc:message-converters register-defaults="true">
        <bean class="org.springframework.http.converter.StringHttpMessageConverter">
            <property name="supportedMediaTypes" value="text/html;charset=UTF-8"/>
        </bean>
    </mvc:message-converters>
</mvc:annotation-driven>
```

---

### Map 集合

先定义一个封装类

```java
@Data
public class UserMap {
    
    private Map<String,User> userMap;
    
}
```

Controller方法：

```java
@RequestMapping("/map")
public String map(UserMap userMap){
    StringBuilder sb = new StringBuilder();
    for(String key : userMap.getUserMap().keySet()){
        sb.append(userMap.getUserMap().get(key)).append(",");
    }
    return sb.toString();
}
```

前端页面：

```jsp
<form action="/data/map" method="post">
    用户1编号:<input type="text" name="userMap['a'].id"><br/>
    用户1名称:<input type="text" name="userMap['a'].name"><br/>
    用户1国家:<input type="text" name="userMap['a']address.country"><br/>
    用户1地址:<input type="text" name="userMap['a']address.city"><br/>
    <br/>
    用户2编号:<input type="text" name="userMap['b'].id"><br/>
    用户2名称:<input type="text" name="userMap['b'].name"><br/>
    用户2国家:<input type="text" name="userMap['b'].address.country"><br/>
    用户2地址:<input type="text" name="userMap['b'].address.city"><br/>
    <input type="submit" value="提交">
</form>
```

输入相关数据：

<img src="https://img-blog.csdnimg.cn/20200514211138141.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:80%;" />

点击提交按钮：

![](https://img-blog.csdnimg.cn/20200514211303944.png)

----

### JSON 数据

客户端发送 JSON 格式的数据，直接通过Spring MVC 绑定到业务方法的形参中。

首先在web.xml中添加以下配置，使Spring MVC 对静态的`.js`资源放行：

```xml
<servlet-mapping>
    <servlet-name>default</servlet-name>
    <url-pattern>*.js</url-pattern>
</servlet-mapping>
```

前端页面：

```html
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            var user = {
                "id" : 1,
                "name" : "sjh"
            };
            $.ajax({
                url:"/data/json",
                data:JSON.stringify(user),
                type:"POST",
                contentType:"application/json;charset=UTF-8",
                dataType:"JSON",
                success:function (data) {
                    alert(data.id+"->"+data.name);
                }
            })
        });
    </script>
</head>

<body>

</body>
</html>
```

控制器方法：

```java
@RequestMapping("/json")
public User json(@RequestBody User user){
    user.setId(24);
    user.setName("2020GetGoodOffer");
    return user;
}
```

还需要在build.gradle添加fastjson依赖，完成JSON数据到Java对象的转换：

```groovy
compile group: 'com.alibaba', name: 'fastjson', version: '1.2.47'
```

然后在springmvc.xml中配置

```xml
<mvc:annotation-driven>
    <mvc:message-converters register-defaults="true">
        <!-- 配置消息转换器 -->
        <bean class="org.springframework.http.converter.StringHttpMessageConverter">
            <property name="supportedMediaTypes" value="text/html;charset=UTF-8"/>
        </bean>
        <!-- 配置fastjson -->
        <bean class="com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter"/>
    </mvc:message-converters>
</mvc:annotation-driven>
```

访问`localhost:8080/json.jsp`，之前传递的id是1，name是sjh，但成功转换成了User对象，改变了其中的属性，之后又返回给了客户端。

![](https://img-blog.csdnimg.cn/20200514214945729.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

---

## Spring MVC 模型数据解析

JSP 四大作用域对应的内置对象： pageContext、 request、 session、 application。

模型数据的绑定由 ViewResolver 视图解析器完成，实际开发中需要先添加模型数据，再交给 ViewResolver 来绑定。

Spring MVC 提供了以下方式来添加模型数据：

### 向Request域添加数据

#### **Map**

控制器方法：

```java
@Controller
@RequestMapping("/view")
public class ViewController {
    
    @RequestMapping("/map")
    public String map(Map<String,User> map){
        User user = new User();
        user.setId(1);
        user.setName("sjh");
        map.put("user",user);//存入request域
        return "view";
    }
}
```

前端页面：

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    map信息：${requestScope.user}
</body>
</html>
```

访问`localhost:8080/view/map`：

![](https://img-blog.csdnimg.cn/20200515094706305.png)

---

#### Model

控制器方法：

```java
@RequestMapping("/model")//import org.springframework.ui.Model;
public String model(Model model){
    User user = new User();
    user.setId(1);
    user.setName("sjh");
    model.addAttribute("user",user);
    return "view";
}
```

前端页面：

```jsp
...
model信息：${requestScope.user}
...
```

访问`localhost:8080/view/model`：

![](https://img-blog.csdnimg.cn/20200515095126629.png)

---

#### ModelAndView

控制器方法：

```java
@RequestMapping("/modelAndView")
public ModelAndView modelAndView(){
    User user = new User();
    user.setId(1);
    user.setName("sjh");
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("user",user);
    modelAndView.setViewName("view");
    return modelAndView;
}
```

前端页面：

```js
...
model信息：${requestScope.user}
...
```

访问`localhost:8080/view/modelAndView`：

![](https://img-blog.csdnimg.cn/20200515095643443.png)

也可以使用ModelAndView的setView()方法直接设置视图：

```java
modelAndView.setView(new InternalResourceView("/view.jsp"));
```

可以在创建ModelAndView时直接指定视图名：

```java
ModelAndView modelAndView = new ModelAndView("view");
```

可以将View对象作为ModelAndView构造器的参数：

```java
ModelAndView modelAndView = new ModelAndView(new InternalResourceView("/view.jsp"));
```

可以将数据作为构造器的参数：

```java
User user = new User();
user.setId(1);
user.setName("sjh");
Map<String,User> map = new HashMap<>();
map.put("user",user);
ModelAndView modelAndView = new ModelAndView("view",map);
```

或者：

```java
User user = new User();
user.setId(1);
user.setName("sjh");
Map<String,User> map = new HashMap<>();
map.put("user",user);
ModelAndView modelAndView = new ModelAndView(new InternalResourceView("/view.jsp"),map);
```

不使用Map封装直接传递数据：

```java
User user = new User();
user.setId(1);
user.setName("sjh");
ModelAndView modelAndView = new ModelAndView("view","user",user);
```

----

#### `@ModelAttribute`

加上该注解的方法会先于业务方法执行，无论调用哪个方法都会先执行该方法，返回要填充到模型数据的对象。

业务方法中无需再处理模型数据，返回视图即可。

```java
@ModelAttribute
public User getUser(){
    User user = new User();
    user.setId(1);
    user.setName("sjh");
    return user;
}

@RequestMapping("/modelAttribute")
public String modelAttribute(){
    return "view";
}
```

返回值如果为void，需要以下处理才可填充：

```java
@ModelAttribute
public void getUser(Map<String,User> map){
    User user = new User();
    user.setId(1);
    user.setName("sjh");
    map.put("user",user);
}
--------
@ModelAttribute
public void getUser(Model model){
    User user = new User();
    user.setId(1);
    user.setName("sjh");
    model.addAttribute("user",user);
}
```

---

上述所有方法都相当于在request域存值，等同于

```java
@RequestMapping("/request")
public String request(HttpServletRequest request){
    User user = new User();
    user.setId(1);
    user.setName("sjh");
    request.setAttribute("user",user);
    return "view";
}
```

---

### 向Session域添加数据

#### 原生 Servlet API

控制器方法：

```java
@RequestMapping("/session")
public String session(HttpServletRequest request){
    HttpSession session = request.getSession();
    User user = new User();
    user.setId(1);
    user.setName("sjh");
    session.setAttribute("user",user);
    return "view";
}
```

或者

```java
@RequestMapping("/session2")
public String session(HttpSession session){
    User user = new User();
    user.setId(1);
    user.setName("sjh");
    session.setAttribute("user",user);
    return "view";
}
```

前端获取session域数据：

```jsp
...
<body>
    session信息：${sessionScope.user}
</body>
...
```

---

#### `@SessionAttribute`

如果业务方法中有任何一个满足的对象被添加到域中，就会自动添加到session域。由于作用域是全局，不推荐使用。

在类上直接添加该注解即可，通过属性名：

```
@SessionAttributes(value = "user")
public class ViewController {
...
}
```

或者通过类型：

```
@SessionAttributes(types = User.class)
public class ViewController {
...
}
```

---

### 向 application 域添加数据

#### 原生 Servlet API

控制器方法：

```java
@RequestMapping("/application")
public String application(HttpServletRequest request){
    User user = new User();
    user.setId(1);
    user.setName("sjh");
    request.getServletContext().setAttribute("user",user);
    return "view";
}
```

前端获取application域数据：

```jsp
...
<body>
    application信息：${applicationScope.user}
</body>
...
```

不能使用以下方式，因为ServletContext没有无参构造器不能直接创建：

```java
public String application(ServletContext servletContext){
    User user = new User();
    user.setId(1);
    user.setName("sjh");
    servletContext.setAttribute("user",user);
    return "view";
}
```

---

## Spring MVC 自定义数据转换器

数据转换器是指将客户端 HTTP 请求中的参数转换为业务方法中定义的形参，自定义表示开发者可以自主设计转换的方式，HandlerAdapter 通过了通用的转换，例如String 转 int 、String 转 double、表单数据封装，但是特殊业务场景下HandlerAdapter 无法进行转换，需要开发者自定义类型转换器。

### String -> Date

自定义转换器需要实现Converter接口：

```java
public class Str2DateConverter implements Converter<String, Date> {
    
    private String datePattern;
    
    public Str2DateConverter(String datePattern){
        this.datePattern = datePattern;
    }
    
    @Override
    public Date convert(String source) {
        SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
        Date date = null;
        try {
            date = sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
```

在springmvc.xml中配置转换器：

配置完自定义转换器后要在`mvc:annotation-driven` 中注册。

```xml
<mvc:annotation-driven conversion-service="conversionService">
    <mvc:message-converters register-defaults="true">
        <!-- 配置消息转换器 -->
        <bean class="org.springframework.http.converter.StringHttpMessageConverter">
            <property name="supportedMediaTypes" value="text/html;charset=UTF-8"/>
        </bean>
        <!-- 配置fastjson -->
        <bean class="com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter"/>
    </mvc:message-converters>
</mvc:annotation-driven>

<!-- 配置自定义转换器 -->
<bean id="conversionService" class="org.springframework.context.support.ConversionServiceFactoryBean">
    <property name="converters">
        <list>
            <bean class="com.sjh.converter.Str2DateConverter">
                <constructor-arg value="yyyy-MM-dd" type="java.lang.String"/>
            </bean>
        </list>
    </property>
</bean>
```

控制器方法：

```java
@RestController
@RequestMapping("/converter")
public class converterController {
    
    @RequestMapping("/date")
    public String date(Date date){
        return date.toString();
    }
}
```

前端页面`addDate.jsp``：

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/converter/date" method="post">
        请输入日期：<input type="text" name="date"/>(yyyy-MM-dd)<br/>
        <input type="submit" value="提交"> 
    </form>
</body>
</html>
```

访问`localhost:8080/addDate.jsp`:

<img src="https://img-blog.csdnimg.cn/20200515111044115.png" style="zoom:80%;" />

点击提交：

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200515112104414.png" style="zoom:80%;" />

---

### String -> 自定义类

创建一个Student类：

```java
@Data
public class Student {
    
    private Integer id;
    
    private String  name;
    
    private int age;
}
```

控制器方法：

```java
@RequestMapping("/stu")
public String stu(Student student){
    return student.toString();
}
```

前端页面`addStu.jsp`：

注意input中的name属性值一定要和控制器方法的参数名一致

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/converter/stu" method="post">
        请输入学生信息：<input type="text" name="student"/>(格式：id-姓名-年龄)<br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
```

自定义转换器：

```java
public class StudentConverter implements Converter<String, Student> {
    
    @Override
    public Student convert(String source) {
        String[] info = source.split("-");
        Student student = new Student();
        student.setId(Integer.parseInt(info[0]));
        student.setName(info[1]);
        student.setAge(Integer.parseInt(info[2]));
        return student;
    }
    
}
```

在springmvc.xml添加转换器的配置：

```xml
<!-- 配置自定义转换器 -->
<bean id="conversionService" class="org.springframework.context.support.ConversionServiceFactoryBean">
    <property name="converters">
        <list>
            <bean class="com.sjh.converter.Str2DateConverter">
                <constructor-arg value="yyyy-MM-dd" type="java.lang.String"/>
            </bean>
            <bean class="com.sjh.converter.StudentConverter"/>
        </list>
    </property>
</bean>
```

访问`addStu.jsp`:

<img src="https://img-blog.csdnimg.cn/20200515133524456.png" style="zoom:80%;" />

点击提交：

<img src="https://img-blog.csdnimg.cn/20200515134425146.png" style="zoom:80%;" />

---

## Spring MVC REST

REST即Representational State Transfer，资源表现层状态转换，是一种主流的互联网软件架构，特定是结构清晰、标准规范、便于扩展。

**资源：**网络中的一个实体，例如一段文本、一张图片。可以用URL（统一资源定位符）指向它，每个资源都有一个对应的URL。

**表现层：**资源具体呈现的形式，例如文本可以用txt格式表示，也可以用HTML、XML、JSON等格式表示。

**状态转换：**客户端如果希望操作服务器的某个资源，就需要通过某种方式让服务端发生状态转换，而这种状态转换是建立在表现层之上的，所以叫做表现层状态转换。

REST 具体操作就是HTTP协议中四个表示操作方式的动作分别对应CRUD 基本操作：

**GET 获取资源 / POST 提交资源 /PUT 修改资源 / DELETE 删除资源**

---

操作Student对象的持久层接口：

```java
public interface StudentRepo {

    Collection<Student> findAll();

    Student findById(Integer id);

    void update(Student student);

    void deleteById(Integer id);
}
```

---

操作Student对象的持久层实现类：

```java
@Repository
public class StudentRepoImpl implements StudentRepo {

    //模拟数据库信息
    private static Map<Integer,Student> map;

    static {
        map = new HashMap<>();
        map.put(1,new Student(1,"sjh",24));
        map.put(2,new Student(2,"sjh",23));
        map.put(3,new Student(3,"sjh",22));
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

控制器类和方法：

```java
@RestController
@RequestMapping("/rest")
public class RESTController {

    @Autowired
    private StudentRepo sr;

    @GetMapping("/findAll")
    public Collection<Student> findAll(HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");//防止中文乱码
        return sr.findAll();
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") Integer id){
        return sr.findById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        sr.update(student);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        sr.deleteById(id);
    }
}
```

---

## Spring MVC 文件上传/下载

### 单文件上传和预览

底层使用的是Apache的fileupload组件，首先在build.gradle引入依赖：

```groovy
compile group: 'commons-io', name: 'commons-io', version: '2.1'
compile group: 'commons-fileupload', name: 'commons-fileupload', version: '1.3.1'
```

在web.xml中对`.png`静态资源放行：

```xml
<servlet-mapping>
    <servlet-name>default</servlet-name>
    <url-pattern>*.png</url-pattern>
</servlet-mapping>
```

在springmvc.xml中配置文件上传组件：

```xml
<!-- 配置上传组件 -->
<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver"/>
```

前端页面：

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/file/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="img"/>
        <input type="submit" value="上传">
    </form>
    <img src="${path}">
</body>
</html>
```

控制器方法：

```java
@Controller
@RequestMapping("/file")
public class FileUploadController {

    @PostMapping("/upload")
    public String upload(MultipartFile img,HttpServletRequest request){
        if(img.getSize() > 0){
            String path = request.getServletContext().getRealPath("file");
            String fileName = img.getOriginalFilename();
            File file = new File(path,fileName);
            try {
                img.transferTo(file);
                //将文件路径存储到request域
                request.setAttribute("path","/file/"+fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "upload";
    }
}
```

访问`upload.jsp`，选择png图片并上传，结果：

<img src="https://img-blog.csdnimg.cn/20200515153942621.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:80%;" />

---

### 多文件上传

build.gradle引入依赖：

```groovy
compile group: 'jstl', name: 'jstl', version: '1.2'
compile group: 'taglibs', name: 'standard', version: '1.1.2'
```

前端页面：

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/file/uploads" method="post" enctype="multipart/form-data">
        img1:<input type="file" name="imgs"/><br/>
        img2:<input type="file" name="imgs"/><br/>
        <input type="submit" value="上传">
    </form>
    <c:forEach items="${files}" var="file">
        <img src="${file}" width="300px">
    </c:forEach>
</body>
</html>

```

控制器方法：

```java
@PostMapping("/uploads")
public String uploads(MultipartFile[] imgs,HttpServletRequest request){
    List<String> files = new ArrayList<>();
    for(MultipartFile img : imgs){
        if(img.getSize() > 0){
            String path = request.getServletContext().getRealPath("file");
            String fileName = img.getOriginalFilename();
            File file = new File(path,fileName);
            try {
                img.transferTo(file);
                //将文件路径存储到request域
                files.add("/file/"+fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    request.setAttribute("files",files);
    return "upload";
}		
```

访问`upload.jsp`，选择png图片并上传，结果：

<img src="https://img-blog.csdnimg.cn/20200515162031957.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom: 45%;" />

---

### 文件下载

前端`download.jsp`页面：

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="/file/download/1">下载图片</a>
</body>
</html>
```

控制器类和方法：

```java
@GetMapping("/download/{name}")
public void download(@PathVariable("name") String name, HttpServletRequest request, HttpServletResponse response){
    System.out.println("aaaaa");
    if(name != null){
        name += ".png";
        String path = request.getServletContext().getRealPath("file");
        File file = new File(path, name);
        OutputStream os = null;
        if(file.exists()){
            response.setContentType("application/forc-download");
            response.setHeader("Content-Disposition","attachment;filename="+name);
            try {
                os = response.getOutputStream();
                os.write(FileUtils.readFileToByteArray(file));
                os.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(os != null) {
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
```

访问`localhost:8080/download.jsp`测试下载：

<img src="https://img-blog.csdnimg.cn/20200515170059780.png" style="zoom:80%;" />

---

## Spring MVC 表单标签库

先看一个例子，创建一个控制器类：

```java
@Controller
@RequestMapping("/tag")
public class TagController {

    @GetMapping("/get")
    public ModelAndView get(){
        ModelAndView modelAndView = new ModelAndView("show");
        Student student = new Student(1,"sjh",24);
        modelAndView.addObject("student",student);
        return modelAndView;
    }

}
```

前端`show.jsp`页面：

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>学生信息</h2>
    <form>
        学生ID：<input type="text" name="id" value="${student.id}"><br/>
        学生姓名：<input type="text" name="name" value="${student.name}"><br/>
        学生年龄：<input type="text" name="age" value="${student.age}"><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
```

访问`localhost:8080/tag/get`:

<img src="https://img-blog.csdnimg.cn/20200515172411669.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:80%;" />

**可以使用Spring MVC 表单标签库来简化JSP，效果是一样的：**

JSP页面导入表单标签库，将form表单与模型数据绑定，通过`modelAttribute`属性完成，将其值设为控制器`addObject()`方法中的key值。

完成绑定之后，将模型数据的值取出绑定到不同标签中，通过设置标签的`path`属性值为模型数据对应的属性名。

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>学生信息</h2>
    <form:form modelAttribute="student">
        学生ID：<form:input path="id"/><br/>
        学生姓名：<form:input path="name"/><br/>
        学生年龄：<form:input path="age"/><br/>
        <input type="submit" value="提交">
    </form:form>
</body>
</html>
```

---

### 常用的表单标签

- **form**

  ```jsp
  <form:form modelAttribute="student"/>
  ```

  渲染的是HTML中的`<form></form>`，通过modelArrtibute属性绑定具体的模型数据。

- **input**

  ```jsp
  <form:input path="id" />
  ```

  渲染的是HTML中的`<input type="text"/>`，form标签绑定的是模型数据，input标签绑定的是模型数据中的属性值，通过path属性可以与模型数据中的属性名对应，并且支持级联操作。例如：

  ```jsp
  <form:input path="student.id"  />
  ```

- **password**

  ```jsp
  <form:password path="pwd" />
  ```

  渲染的是HTML中的`<input type="password"/>`，值不会在页面显示。

- **checkbox**

  ```jsp
  <form:checkbox path="hobby" value="basketball" />
  ```

  渲染的是HTML中的`<input type="checkbox"/>`。

  如果绑定boolean值，若该变量值为true，表示该复选框选中，反之。

  如果绑定数组或集合，数组或集合中的值等于checkbox的value值代表选中，反之。

- **checkboxes**

  ```jsp
  <form:checkboxes items=${student.hobby} path="selectHobby" />
  ```

  渲染的是HTML中的一组`<input type="checkbox"/>`，items绑定被遍历的集合或数组，path绑定被选中的集合或数组。path可以直接绑定模型数据的属性值，items则需要通过EL表达式从域对象中取值。

  Student中的两个属性：

  ```java
  private List<String> hobby;
  private List<String> selectHobby;
  ```

  控制器方法：

  ```java
  @GetMapping("/get")
  public ModelAndView get(){
      ModelAndView modelAndView = new ModelAndView("show");
      Student student = new Student(1,"sjh",24, Arrays.asList("打球","看电影","游戏"), Arrays.asList("打球", "游戏"));
      modelAndView.addObject("student",student);
      return modelAndView;
  }
  ```

  前端from表单的代码：

  ```jsp
  <form:form modelAttribute="student">
      学生ID：<form:input path="id"/><br/>
      学生姓名：<form:input path="name"/><br/>
      学生年龄：<form:input path="age"/><br/>
      学生爱好：<form:checkboxes items="${student.hobby}" path="selectHobby"/><br/>
      <input type="submit" value="提交">
  </form:form>
  ```

  表单效果，path中的和items交集的两个属性处于选中状态：

  <img src="https://img-blog.csdnimg.cn/20200515193518203.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:67%;" />

- **radiobutton**

  ```jsp
  <form:radiobutton path="radioId" value="0" />
  ```

  渲染的是HTML中的`<input type="radio"/>`，绑定的数据和value属性值相等则为选中，反之。

  与 checkbox / checkboxes 的关系相同，也可以使用radiosbuttons。

- **select**

  ```jsp
  <form:select items=${student.hobby} path="selectHobby"  />
  ```

  渲染的是HTML中的`<input type="select"/>`，items绑定遍历的集合或数组，path绑定被选中的值，用法与 radiobuttons 一致。

- **options**

  `form:select` 可以结合 `form:options` 使用，使用`form:options`设置子标签，设置 items 属性获取遍历集合。

  `form:select`  可以结合 `form:option`  使用，使用`form:option`设置子标签，设置 value 属性，当value 和 path 属性值相同时处于选中状态。

- **textarea**

  渲染 HTML 中的一个 `<textarea/>` ，path 属性绑定模型数据的属性值，作为文本输入域的默认值。

- **errors**

  处理错误信息，一般用于数据校验，需要结合 Spring  MVC 的验证器使用。

---

## Spring MVC 数据校验

Spring MVC 提供了两种数据校验的方式：基于 Validator 接口 / 使用 Annotation JSR-303 标准

基于 Validator 接口的方式需要自定义 Validator 验证器，每一条数据的验证规则需要手动完成。

使用  Annotation JSR-303 标准不需要自定义验证器，通过注解的方式可以直接在实体类中添加每个属性的验证规则，这种方式更加方便。

### 基于 Validator 接口

定义一个实体类Account：

```java
@Data
public class Account {
    
    private String name;
    
    private String password;
    
}
```

自定义验证器：

```java
public class AccountValidator implements Validator{
    
    @Override
    public boolean supports(Class<?> clazz) {
        return Account.class.equals(clazz);//判断是否需要验证
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"name",null,"姓名不能为空");
        ValidationUtils.rejectIfEmpty(errors,"password",null,"密码不能为空");
    }
    
}
```

在springmvc.xml中配置：

```xml
<!-- 配置验证器 -->
<bean id="validator" class="com.sjh.validator.AccountValidator"/>
<mvc:annotation-driven validator="validator"/>
```

控制器类和方法：

```java
@Controller
@RequestMapping("/vali")
public class ValiController {
    
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("account",new Account());
        return "login";
    }
    
    @PostMapping("/login")
    public String login(@Validated Account account, BindingResult result){
        if(result.hasErrors())
            return "login";
        return "index";
    }
    
}
```

创建前端的`login.jsp`:

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form modelAttribute="account" action="/vali/login" method="post">
        姓名：<form:input path="name"/><br/>
        <form:errors path="name"/><br/>
        密码：<form:input path="password"/><br/>
        <form:errors path="password"/><br/>
        <input type="submit" value="登录"> 
    </form:form>
</body>
</html>
```

访问`localhost:8080/vali/login`,直接点击登录，出现了错误提示：

<img src="https://img-blog.csdnimg.cn/2020051520354515.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:80%;" />

---

### 使用 Annotation JSR-303 标准

需要在build.gradle导入以下依赖:

```groovy
compile group: 'org.hibernate', name: 'hibernate-validator', version: '5.3.5.Final'
compile group: 'javax/validation', name: 'validation-api', version: '2.0.1.Final'
compile group: 'org.jboss.logging', name: 'jboss-logging', version: '3.3.2.Final'
```

实体类中直接使用注解验证：

```java
@Data
public class Account {

    @NotEmpty(message = "用户名不能为空")
    private String name;

    @NotEmpty(message = "密码不能为空")
    @Size(min = 6, max = 12, message = "密码是6~12位的")
    private String password;

}
```

控制器代码只有`@Valid`注解不同：

```java
@Controller
@RequestMapping("/vali")
public class ValiController {

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("account",new Account());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid Account account, BindingResult result){
        if(result.hasErrors())
            return "login";
        return "index";
    }
    
}
```

在springmvc.xml中使用`<mvc:annotation-driven>`标签即可。

---

**校验相关注解**：

- `@Null` 元素必须为Null
- `@NotNull`  元素不能为Null
- `@Min(value = min)` 元素必须是数字，必须大于等于min
- `@Max(value = max)` 元素必须是数字，必须小于等于max
- `@Email` 元素必须是电子邮箱的地址
- `@Pattern` 元素必须符合对应正则表达式
- `@Length` 元素大小必须在指定范围内
- `@NotEmpty` 字符串必须非空，和`@NotNull`  不同。