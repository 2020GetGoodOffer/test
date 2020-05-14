# Spring入门

## Spring IoC

IoC即控制翻转，传统开发中当需要调用对象时需要调用者手动new操作，Spring中创建对象的工作交给了IoC容器来完成，实现了流程反转，DI则是IoC的一种具体实现方式。

- 创建一个gradle项目，gradle的build.gradle配置文件内容如下：

  ```groovy
  plugins {
      id 'java'
      id 'war'
  }
  
  group 'com.sjh'
  version '1.0-SNAPSHOT'
  
  sourceCompatibility = 1.8
  
  repositories {
      mavenLocal()
      mavenCentral()
  }
  
  dependencies {
      testCompile group: 'junit', name: 'junit', version: '4.12'
      compile group: 'org.springframework', name: 'spring-context', version: '5.0.2.RELEASE'
      providedCompile group: 'org.projectlombok', name: 'lombok', version: '1.16.12'
  }
  ```

- 在src/main/java下创建一个实体类，并使用@Data注解（需要上面的lombok依赖）自动生成getter/setter方法：

  ```java
  @Data
  public class Student {
  
      private Integer id;
  
      private String name;
  
      private Integer age;
  }
  ```

- 在src/test/java下创建一个IoC的测试类，传统方式中，当我们创建一个Student对象会使用如下方式：

  ```java
  public class IoCTest {
  
      @Test
      public void testIoC(){
          Student student = new Student();
          student.setId(1);
          student.setName("sjh");
          student.setAge(24);
          System.out.println(student);
      }
      
  }
  ```

  运行结果如下：

  ![](https://img-blog.csdnimg.cn/20200513173058870.png)

  
  
- 如果要使用Spring实现控制反转，需要先在src/main/resources下创建一个名为spring.xml的XML配置文件：

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <beans xmlns="http://www.springframework.org/schema/beans"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
      
      <!-- 将Student交给spring容器 -->
      <bean id="student" class="com.sjh.entity.Student">
          <property name="id" value="1"/>
          <property name="name" value="sjh"/>
          <property name="age" value="24"/>
      </bean>
      
  </beans>
  ```

- 利用IoC获取对象（通过bean的id）：

  ClassPathXmlApplicationContext获取了配置文件，通过配置文件对象的getBean方法获取一个Student的实例，由于在配置文件中已经注入了属性，此时student是有相关属性的。

  ```java
  @Test
  public void testIoC2(){
      ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
      Student student = (Student) ac.getBean("student");
      System.out.println(student);
  }
  ```

  运行结果如下：

  ![](https://img-blog.csdnimg.cn/20200513173745113.png)

---

### 配置文件

通过`bean`标签来完成对象的管理，bean标签的属性如下：

- `id` ：对象名。

- `class` ：对象的模板类，所有交给IoC容器管理的类必须有无参构造器，因为Spring底层通过反射调用无参构造器创建对象的。

- 对象的成员变量通过`property`标签完成赋值

  - `name` ：成员变量名。

  - `value` ：成员变量的值（基本数据类型和String）。

  - `ref` ：成员变量的值（引用数据类型），将IoC中的另外一个bean赋值给当前成员变量（DI）。

    例如新创建一个Address类作为地址：

    ```java
    @Data
    public class Address {
    
        private String country;
    
        private String city;
    
    }
    ```

    给Student类添加Address地址属性：

    ```java
    @Data
    public class Student {
    
        private Integer id;
    
        private String name;
    
        private Integer age;
    
        private Address address;
    }
    ```

    在spring.xml中使用ref注入Address属性：

    ```xml
    <!-- 将Student交给spring容器 -->
    <bean id="student" class="com.sjh.entity.Student">
        <property name="id" value="1"/>
        <property name="name" value="sjh"/>
        <property name="age" value="24"/>
        <property name="address" ref="address"/>
    </bean>
    
    <bean id="address" class="com.sjh.entity.Address">
        <property name="country" value="China"/>
        <property name="city" value="xi'an"/>
    </bean>
    ```

    此时运行的结果：

    ![](https://img-blog.csdnimg.cn/20200513175358542.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

---

### IoC底层原理

- 读取配置文件，解析XML。
- 通过反射机制实例化配置文件中所配置的所有bean。

实例演示，首先在build.gradle中引入dom4j用来解析XML文件：

```groovy
dependencies {
    testCompile group: 'junit', name: 'junit', version: '4.12'
    compile group: 'org.springframework', name: 'spring-context', version: '5.0.2.RELEASE'
    providedCompile group: 'org.projectlombok', name: 'lombok', version: '1.16.12'
    compile group: 'dom4j', name: 'dom4j', version: '1.6.1'
}
```

自定义ApplicationContext：

```java
public interface MyApplicationContext {

    Object getBean(String id);
}

```

自定义ClassPathXmlApplicationContext：

```java
public class MyClassPathXmlApplicationContext implements MyApplicationContext {

    private Map<String,Object> iocMap = new HashMap<>();

    public MyClassPathXmlApplicationContext(String path) throws Exception {
        SAXReader reader = new SAXReader();
        //获取XML配置文件对象
        Document document = reader.read("./src/main/resources/"+path);
        //获取根节点，即beans标签
        Element root = document.getRootElement();
        //获取迭代器
        Iterator<Element> iterator = root.elementIterator();
        while(iterator.hasNext()){
            Element element = iterator.next();
            //获取bean标签的id内容
            String id = element.attributeValue("id");
            //获取bean标签的class内容
            String className = element.attributeValue("class");
            //通过反射创建对象
            Class clazz = Class.forName(className);
            //通过无参构造器创建对象
            Object instance = clazz.getConstructor().newInstance();
            //给对象的属性赋值
            Iterator<Element> proIter = element.elementIterator();
            while (proIter.hasNext()){
                Element property = proIter.next();//获取property标签对象
                String name = property.attributeValue("name");//获取property标签的name，即成员变量名
                String valueStr = property.attributeValue("value");//获取property标签的value，即成员变量值
                String methodName = "set"+name.substring(0,1).toUpperCase()+name.substring(1);//属性首字母大写
                Field field = clazz.getDeclaredField(name);
                Method method = clazz.getDeclaredMethod(methodName,field.getType());//第二个参数是set方法的参数类型
                Object value;
                if(field.getType().getName().equals("java.lang.Integer")) {//根据成员变量数据类型转换value
                    value = Integer.parseInt(valueStr);
                }else {
                    value = valueStr;
                }
                method.invoke(instance,value);//通过反射赋值
            }
            //把对象存入map
            iocMap.put(id,instance);
        }
        Object address = iocMap.get("address");
        Object student = iocMap.get("student");
        Class<?> clazz = student.getClass();
        Method setAddress = clazz.getDeclaredMethod("setAddress", Address.class);
        setAddress.invoke(student,address);
    }

    @Override
    public Object getBean(String id) {
        return iocMap.get(id);
    }
}
```

测试方法：

```java
    @Test
    public void testIoC3() throws Exception {
        MyApplicationContext ac=new MyClassPathXmlApplicationContext("spring.xml");
        Student student = (Student) ac.getBean("student");
        System.out.println(student);
    }
```

至此成功模拟了IoC的实现原理，运行结果如下：

![](https://img-blog.csdnimg.cn/20200513191248618.png)

----

### 通过运行时类获取bean的问题

```java
@Test
public void testIoC4(){
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
    Student student = ac.getBean(Student.class);
    System.out.println(student);
}
```

可以不使用bean的id而使用bean的.class形式获取实例，这种方法的问题是，配置文件中一个类只能有一个实例，也就是XML文件中只能配置一个Student的实例，不能配置多个。当使用以下配置时运行测试方法就会报错：

```xml
<bean id="student" class="com.sjh.entity.Student">
    <property name="id" value="1"/>
    <property name="name" value="sjh"/>
    <property name="age" value="24"/>
    <property name="address" ref="address"/>
</bean>

<bean id="student2" class="com.sjh.entity.Student">
    <property name="id" value="2"/>
    <property name="name" value="sjh"/>
    <property name="age" value="24"/>
    <property name="address" ref="address"/>
</bean>
```

---

### 通过有参构造器创建bean

在Student类上加上以下注解：

```java
@NoArgsConstructor
@AllArgsConstructor
```

spring.xml中配置如下：

```xml
<!-- 有参构造器创建bean -->
<bean id="student2" class="com.sjh.entity.Student">
    <constructor-arg name="id" value="2"/>
    <constructor-arg name="name" value="sjh"/>
    <constructor-arg name="age" value="25"/>
    <constructor-arg name="address" ref="address"/>
</bean>
```

测试方法：

```java
@Test
public void testIoC5(){
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
    Student student = (Student) ac.getBean("student2");
    System.out.println(student);
}
```

运行结果：

![](https://img-blog.csdnimg.cn/20200513192603904.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

---

### 给bean注入集合

假设此时一个学生不仅有一个地址，那么我们希望一个学生对象可以存储多个地址，首先修改Student类中address为List类型：

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Integer id;

    private String name;

    private Integer age;

    private List<Address> addresses;
}
```

在spring.xml中注入集合：

```xml
<bean id="student" class="com.sjh.entity.Student">
    <property name="id" value="1"/>
    <property name="name" value="sjh"/>
    <property name="age" value="24"/>
    <property name="addresses">
        <list>
            <ref bean="address1"/>
            <ref bean="address2"/>
        </list>
    </property>
</bean>

<bean id="address1" class="com.sjh.entity.Address">
    <property name="country" value="China"/>
    <property name="city" value="xi'an"/>
</bean>

<bean id="address2" class="com.sjh.entity.Address">
    <property name="country" value="China"/>
    <property name="city" value="shanghai"/>
</bean>
```

---

### scope作用域

scope表示bean的作用域，一共有4种：

- **singleton**：单例模式，表示通过Spring容器获取的bean是唯一的。无论是否获取bean，在加载配置文件时，Spring就会对bean进行实例化，加载模式属于立即加载。
- **prototype** ：原型模型，表示通过Spring容器获取的bean是不同的。在获取bean时Spring才会对bean进行实例化，加载模式属于延迟加载。
- **request**：请求模式，表示在一次HTTP请求内有效。
- **session**：会话模式，表示在一次HTTP会话中有效。

request和session只适用与Web项目，大多数情况下使用singleton和prototype较多。

默认情况下，bean是单例模式的，从容器中获取两个Student对象，比较是否相等：

```java
@Test
public void testScope1(){
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
    Student student1 = (Student) ac.getBean("student");
    Student student2 = (Student) ac.getBean("student");
    System.out.println(student1);
    System.out.println(student2);
    System.out.println(student1==student2);
}
```

运行结果：

![](https://img-blog.csdnimg.cn/20200513211326492.png)

在spring.xml中修改scope为原型模式：

```xml
<bean id="student" class="com.sjh.entity.Student" scope="prototype">
//..省略
```

此时再次运行，此时从Spring容器获得的对象已经是不同的实例了：

![](https://img-blog.csdnimg.cn/20200513211454221.png)

---

### Spring的继承

与Java的继承不同，Java是类层面的继承，子类可以继承父类的结构信息，Spring是对象层面的继承，子对象可以继承父对象的属性值。

只需要在bean标签中，加入一个parent属性即可：

```xml
<bean id="student" class="com.sjh.entity.Student" scope="prototype">
    <property name="id" value="1"/>
    <property name="name" value="sjh"/>
    <property name="age" value="24"/>
    <property name="addresses">
        <list>
            <ref bean="address1"/>
            <ref bean="address2"/>
        </list>
    </property>
</bean>

<bean id="student2" class="com.sjh.entity.Student" parent="student"/>
```

测试方法：

```java
@Test
public void testExtends(){
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
    Student student1 = (Student) ac.getBean("student");
    Student student2 = (Student) ac.getBean("student2");
    System.out.println(student1);
    System.out.println(student2);
}
```

可以看到，student2继承了student1的全部值：

![](https://img-blog.csdnimg.cn/20200513212702821.png)

值得一提的是，即使是不同的两个类也可以继承，但是继承的类中的属性要大于等于被继承的类。

例如，创建一个User类，不仅有Student类的四个属性，还有额外的工资属性：

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;

    private String name;

    private Integer age;

    private List<Address> addresses;
    
    private Double salary;
}
```

在spring.xml中实现继承：

```xml
<bean id="student" class="com.sjh.entity.Student" scope="prototype">
    <property name="id" value="1"/>
    <property name="name" value="sjh"/>
    <property name="age" value="24"/>
    <property name="addresses">
        <list>
            <ref bean="address1"/>
            <ref bean="address2"/>
        </list>
    </property>
</bean>

<bean id="user" class="com.sjh.entity.User" parent="student"/>
```

测试方法：

```java
@Test
public void testExtends2(){
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
    Student student = (Student) ac.getBean("student");
    User user = (User) ac.getBean("user");
    System.out.println(student);
    System.out.println(user);
}
```

运行结果如下，可以看到Student对象的全部值都继承了：

![](https://img-blog.csdnimg.cn/20200513213539554.png)

---

### Spring的依赖

与继承类似，依赖也是描述bean之间的一种关系，配置依赖关系后，被依赖的bean一定会先被创建。

默认情况下，创建bean的顺序是按照XML中定义的顺序创建的：

```xml
<bean id="student2" class="com.sjh.entity.Student"/>

<bean id="user" class="com.sjh.entity.User"/>
```

在Student和User类中创建无参构造器，输出一句话帮助测试：

```java
@Data
@AllArgsConstructor
public class Student {

    public Student(){
        System.out.println("创建了Student对象");
    }
    ...
}    

@Data
@AllArgsConstructor
public class User {

    public User(){
        System.out.println("创建了User对象");
    }
    ...
}
```

测试方法：

```java
@Test
public void testDep1(){
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
    ac.getBean("student2");
    ac.getBean("user");
}
```

此时bean的创建顺序：

![](https://img-blog.csdnimg.cn/20200513214310383.png)

为了证明创建bean的顺序和XML文件定义顺序有关，调换其定义顺序：

```xml
<bean id="user" class="com.sjh.entity.User"/>

<bean id="student2" class="com.sjh.entity.Student"/>
```

此时bean的创建顺序：

![](https://img-blog.csdnimg.cn/20200513214416690.png)

为了证明被依赖的对象先被创建，我们可以让User定义在Student前面，让User依赖Student：

```xml
<bean id="user" class="com.sjh.entity.User" depends-on="student2"/>

<bean id="student2" class="com.sjh.entity.Student"/>
```

此时bean的创建顺序：

![](https://img-blog.csdnimg.cn/20200513214612927.png)

---

### Spring的p命名空间

p命名空间是对IoC/DI的简化，使用p命名空间可以更加方便地完成bean的配置以及bean之间的依赖注入。

在beans标签中引入p命名空间：

```xml
xmlns:p="http://www.springframework.org/schema/p"
```

配置bean：

```xml
<!-- 使用p命名空间构建依赖关系 -->
<bean id="stu" class="com.sjh.entity.Student" p:id="1" p:name="sjh" p:age="24" p:addresses-ref="addr"/>

<bean id="addr" class="com.sjh.entity.Address" p:country="China" p:city="beijing"/>
```

---

### Spring的工厂方法

IoC通过工厂模式创建bean的方式有两种：

- **静态工厂方法**

  创建一个实体类Car

  ```java
  @Data
  @AllArgsConstructor
  public class Car {
  
      private Integer id;
  
      private String name;
  
  }
  ```

  创建一个静态工厂类

  ```java
  //创建Car的静态工厂
  public class StaticFactory {
  
      private static Map<Integer, Car> carMap;
  
      static {
          carMap = new HashMap<>();
          carMap.put(1,new Car(1,"宝马"));
          carMap.put(2,new Car(2,"奔驰"));
      }
  
      public static Car getCar(Integer id){
          return carMap.get(id);
      }
  }
  ```

  在XML文件中进行配置

  ```xml
  <!-- 通过静态工厂创建bean-->
  <bean id="car" class="com.sjh.factory.StaticFactory" factory-method="getCar">
      <constructor-arg value="1"/>
  </bean>
  ```

  测试方法：

  ```java
  @Test
  public void testFactory1(){
      ApplicationContext ac = new ClassPathXmlApplicationContext("factory.xml");
      Car car = (Car) ac.getBean("car");
      System.out.println(car);
  }
  ```

  运行结果：

  ![](https://img-blog.csdnimg.cn/20200514102927986.png)

- **实例工厂方法**

  创建一个实例工厂

  ```java
  //创建Car的实例工厂
  public class InstanceFactory {
  
      private Map<Integer, Car> carMap;
  
      public InstanceFactory(){
          carMap = new HashMap<>();
          carMap.put(1,new Car(1,"宝马"));
          carMap.put(2,new Car(2,"奔驰"));
      }
  
      public Car getCar(Integer id){
          return carMap.get(id);
      }
  }
  ```

  在XML中配置

  ```xml
  <!-- 通过实例工厂创建bean-->
  <bean id="car2" factory-bean="instanceFactory" factory-method="getCar">
      <constructor-arg value="2"/>
  </bean>
  
  <bean id="instanceFactory" class="com.sjh.factory.InstanceFactory"/>
  ```

  测试方法：

  ```java
  @Test
  public void testFactory2(){
      ApplicationContext ac = new ClassPathXmlApplicationContext("factory.xml");
      Car car = (Car) ac.getBean("car2");
      System.out.println(car);
  }
  ```

  运行结果：

  ![](https://img-blog.csdnimg.cn/20200514104723105.png)

---

### IoC自动装载（Autowire）

IoC负责创建对象，DI负责完成对象的依赖注入，通过配置property标签的ref属性完成，除此之外还提供了一种更简便的依赖注入方式：自动装载，不需要手动配置property，IoC容器会自动选择bean完成注入。

自动装载有两种方式：

- **byName：通过属性名自动装载**

  创建一个Person类

  ```java
  @Data
  public class Person {
  
      private Integer id;
  
      private String name;
  
      private Car car;
  }
  ```

  在XML中通过自动装载为其注入car属性

  ```xml
  <bean id="car" class="com.sjh.entity.Car">
      <property name="id" value="1"/>
      <property name="name" value="特斯拉"/>
  </bean>
  
  <bean id="person" class="com.sjh.entity.Person" autowire="byName">
      <property name="id" value="1"/>
      <property name="name" value="sjh"/>
  </bean>
  ```

  测试方法：

  ```java
  @Test
  public void testAutowired1(){
      ApplicationContext ac = new ClassPathXmlApplicationContext("autowire.xml");
      Person person = (Person) ac.getBean("person");
      System.out.println(person);
  }
  ```

  运行结果：

  ![](https://img-blog.csdnimg.cn/20200514110656425.png)

- **byType：通过属性的数据类型自动装载**

  当把car这个bean的id改为dog时，byName就会失败：

  ```xml
  <bean id="dog" class="com.sjh.entity.Car">
      <property name="id" value="1"/>
      <property name="name" value="特斯拉"/>
  </bean>
  ```

  运行结果：

  ![](https://img-blog.csdnimg.cn/20200514110940192.png)

  可以通过属性的类型装载：

  ```xml
  <bean id="person" class="com.sjh.entity.Person" autowire="byType">
      <property name="id" value="1"/>
      <property name="name" value="sjh"/>
  </bean>
  ```

  运行结果：

  ![](https://img-blog.csdnimg.cn/20200514110656425.png)

  但是当出现多个类型相同的bean时，就不能使用byType了。

---

## Spring AOP

AOP即Aspect Oriented Programing，面向切面编程。AOP是面向对象编程的一个补充，在运行时动态地将代码切入到类的指定方法、指定位置上的编程思想就是面向切面编程。将不同方法的同一个位置抽象成一个切面对象，对该切面进行编程。

**优点：**

- 降低模块之间的耦合度，使系统更容易扩展，可以更好实现代码复用
- 将复杂需求分层，非业务代码更加集中，便于管理，业务代码更加简单纯粹

---

### 使用动态代理实现AOP

- 在build.gradle的依赖中加入AOP的相关依赖：

  ```groovy
  compile group: 'org.springframework', name: 'spring-aop', version: '5.0.2.RELEASE'
  compile group: 'org.springframework', name: 'spring-aspects', version: '5.0.2.RELEASE'
  ```

- 创建一个计算器接口，定义加减乘除四个方法：

  ```java
  public interface Cal {
      
      //加法
      int add(int a, int b);
      
      //减法
      int sub(int a, int b);
      
      //乘法
      int mul(int a, int b);
      
      //除法
      int div(int a, int b);
      
  }
  ```

- 创建计算器接口的实现类：

  ```java
  public class CalImpl implements Cal {
  
      @Override
      public int add(int a, int b) {
          System.out.println("add方法的参数是："+a+","+b);
          int res = a + b;
          System.out.println("add方法的结果是："+res);
          return res;
      }
  
      @Override
      public int sub(int a, int b) {
          System.out.println("sub方法的参数是："+a+","+b);
          int res = a - b;
          System.out.println("sub方法的结果是："+res);
          return res;
      }
  
      @Override
      public int mul(int a, int b) {
          System.out.println("mul方法的参数是："+a+","+b);
          int res = a * b;
          System.out.println("mul方法的结果是："+res);
          return res;
      }
  
      @Override
      public int div(int a, int b) {
          System.out.println("div方法的参数是："+a+","+b);
          int res = a / b;
          System.out.println("div方法的结果是："+res);
          return res;
      }
  }
  ```

- 创建一个测试类和测试方法：

  ```java
  public class AOPTest {
      
      @Test
      public void testCal1(){
          Cal cal = new CalImpl();
          cal.add(1,1);
          cal.sub(2,2);
          cal.mul(3,3);
          cal.div(4,4);
      }
  }
  ```

  运行结果：

  ![](https://img-blog.csdnimg.cn/20200514113922776.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

  可以发现实现类中除了计算加减乘除的具体逻辑不同之外，前后的输出代码都是大量重复的，日志信息和业务逻辑的耦合度很高，不利于系统维护，我们希望可以把它提取出来统一管理。

  可以使用AOP进行优化，具体可以使用动态代理的方式来实现，这样业务代码只需要关注具体业务即可。

- 创建一个可以获取代理对象的MyInvocationHandler类：

  ```java
  public class MyInvocationHandler implements InvocationHandler {
  
      //委托对象，即计算器实现类
      private Object object = null;
  
      //返回代理对象
      public Object getProxy(Object object){
          this.object = object;
          //动态代理的第一个参数 委托类的类加载器，第二个参数 委托类的接口，代理类必须实现其接口，第三个参数 具体的处理逻辑
          return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(), this);
      }
  
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
          String methodName = method.getName();
          System.out.println(methodName+"方法的参数是："+ Arrays.toString(args));
          Object res = method.invoke(this.object, args);
          System.out.println(methodName+"方法的结果是："+ res);
          return res;
      }
  
  }
  ```

- 此时可以优化原来的计算器实现类，省去冗余代码，只关心具体逻辑：

  ```java
  public class CalImpl implements Cal {
  
      @Override
      public int add(int a, int b) {
          int res = a + b;
          return res;
      }
  
      @Override
      public int sub(int a, int b) {
          int res = a - b;
          return res;
      }
  
      @Override
      public int mul(int a, int b) {
          int res = a * b;
          return res;
      }
  
      @Override
      public int div(int a, int b) {
          int res = a / b;
          return res;
      }
  }
  ```

- 测试方法：

  ```java
  @Test
  public void testCal2(){
      Cal cal = new CalImpl();
      Cal proxy = (Cal) new MyInvocationHandler().getProxy(cal);
      proxy.add(1,1);
      proxy.sub(2,2);
      proxy.mul(3,3);
      proxy.div(4,4);
  }
  ```

  运行结果是相同的：

  ![](https://img-blog.csdnimg.cn/20200514113922776.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

---

### 使用Spring AOP

通过Spring的AOP实现上述功能，Spring中不需要创建InvoationHandler，只需要创建一个切面对象，将所有的非业务代码在切面对象中完成即可，Spring底层会自动根据切面类以及目标类来生成代理对象。

---

**创建一个切面类：**

```java
@Aspect//标识该类是一个切面类
@Component//将该类的对象交给IoC容器管理
public class LoggerAspect {

    @Before("execution(public int com.sjh.utils.impl.CalImpl.*(..))")
    public void before(JoinPoint joinPoint){
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        //获取参数
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(methodName+"方法的参数是："+ args);
    }

    @AfterReturning(value = "execution(public int com.sjh.utils.impl.CalImpl.*(..))",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName+"方法的结果是："+result);
    }

    @After("execution(public int com.sjh.utils.impl.CalImpl.*(..))")
    public void after(JoinPoint joinPoint){
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName+"方法执行完毕");
    }

}
```

**通知的相关注解说明：**

`@Before`：前置通知，指在某个连接点之前执行的通知。

`@After`：后置通知，指某个连接点退出时执行的通知（不论正常返回还是异常退出）。

`@AfterReturning`：返回后通知，指某连接点正常完成之后执行的通知，返回值使用returning属性接收。

`@AfterThrowing`：异常通知，指方法抛出异常导致退出时执行的通知，和`@AfterReturning`只会有一个执行，异常使用throwing属性接收。

---

**在aop.xml中进行配置：**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       http://www.springframework.org/schema/beans/spring-beans.xsd 
       http://www.springframework.org/schema/context 
       http://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/aop 
       http://www.springframework.org/schema/aop/spring-aop.xsd">

    <!-- 自动扫描类，寻找需要被IoC管理的类 -->
    <context:component-scan base-package="com.sjh"/>

    <!-- 使Aspect注解生效，为目标类自动生成代理对象 -->
    <aop:aspectj-autoproxy/>
    
</beans>
```

---

测试方法：

```java
@Test
public void testCal3(){
    ApplicationContext ac = new ClassPathXmlApplicationContext("aop.xml");
    Cal proxy = (Cal) ac.getBean("calImpl");//name默认使用被代理类的类名首字母小写形式
    proxy.add(1,1);
    proxy.sub(2,2);
    proxy.mul(3,3);
    proxy.div(4,4);
}
```

结果：

![](https://img-blog.csdnimg.cn/20200514135244505.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

需要注意的是`@AfterReturning`会在`@After`之后执行。

---

### 环绕通知

除了使用前置通知、后置通知、返回后通知配置通知顺序外，还可以使用环绕通知直接配置，环绕通知是指包围一个连接点的通知：

```java
@Around("pc()")
public Object after(ProceedingJoinPoint pjp){
    Object res;
    String methodName = null;
    try{
        //获取参数
        Object[] args = pjp.getArgs();
        methodName = pjp.getSignature().getName();
        System.out.println(methodName + "方法的参数是：" + Arrays.toString(args));
        //获取方法返回结果
        res = pjp.proceed(args);
        System.out.println(methodName + "方法的执行结果是：" + res);
        return res;
    }catch (Throwable t){
        throw new RuntimeException(t);
    }finally {
        System.out.println(methodName + "方法执行完毕");
        System.out.println("------------------------");
    }
}
```

测试结果：

![](https://img-blog.csdnimg.cn/2020051414403483.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

---

### 切入点表达式说明

可以使用`@Pointcut`提取切入点表达式的配置：

```java
@Pointcut("execution(*  *..CalImpl.*(int,int))")
private void pc(){}

@Before("pc()")
public void before(JoinPoint joinPoint){
    ...
}

@AfterReturning(value = "pc()",returning = "result")
public void afterReturning(JoinPoint joinPoint,Object result){
    ...
}

@After("pc()")
public void after(JoinPoint joinPoint){
    ...
}
```

**表达式语法：**

```java
execution([修饰符] 返回值类型 包名.类名.方法名(参数))
```

---
**全匹配方式：**

```java
public int com.sjh.utils.impl.CalImpl.add(int,int)
```

---

**访问修饰符可以省略:**

```java
int com.sjh.utils.impl.CalImpl.add(int,int)
```

---

**返回值可以使用`*`号，表示任意返回值**

```java
*  com.sjh.utils.impl.CalImpl.add(int,int)
```

---

**包名可以使用`*`号，表示任意包，但是有几级包，需要写几个**

```java
*  *.*.*.*.CalImpl.add(int,int)
```

---

**使用`..`来表示当前包，及其子包**

```java
*  *..CalImpl.add(int,int)
```

---

**类名可以使用`*`号，表示任意类**

```java
*  *..*.add(int,int)
```

---

**方法名可以使用 `*`号，表示任意方法**

```java
*  *..*.*(int,int)
```

---

**参数列表可以使用`*`，表示参数可以是任意数据类型，但是必须有参数**

```java
*  *..*.*(*)
```

---

**参数列表可以使用`..`表示有无参数均可，有参数可以是任意类型**

```java
*  *..*.*(..)
```

---

### **AOP相关概念**

- **JointPoint 连接点：**程序执行过程中的某一行为，即业务层中的所有方法。
- **Pointcut 切点**：匹配的连接点，即要增强的那些连接点。切点一定是连接点，但连接点不一定是切点。

- **Advice 通知：**指切面对于某个连接点所产生的动作，一个切面可以包含多个通知，包括前置通知、后置通知、返回后通知、异常通知、环绕通知。
- **Aspect 切面：**一个关注点的模块化，这个关注点可能会横切多个对象。
- **Target 目标**：一个或多个切面所通知的对象。
- **Proxy 代理：**AOP使用两种代理，JDK动态代理和CGLib代理。
- **Weaving 织入：**是指把增强应用到目标对象来创建新的代理对象的过程。

---

