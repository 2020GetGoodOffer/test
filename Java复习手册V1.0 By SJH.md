# Java复习手册 By SJH

# 基础语法

## 概述

### Java的特性

- **简单性**

  为了便于系统理解，Java语法在设计时尽可能地接近C++，但Java语法是C++语法的一个“纯净”版本，剔除了C++中许多很少使用、难以理解、容易混淆的特性。不过设计者没有试图清除C++中所有的特性，例如switch语句的语法在Java中就没有改变。

  “简单”的另一方面是小，Java的目标之一是支持开发能够在小型机器上独立运行的软件。

- **面向对象**

  面向对象设计是一种程序设计技术，它将重点放在数据（即对象）和对象的接口上。用木匠打一个比方，“面向对象的”木匠始终首先关注的是所制作的椅子，其次才是所使用的工具；“非面向对象的”木匠主要 关注的是所用的工具。在本质上Java的面向对象能力和C++是一样的。

- **分布式**

  Java有一个丰富的例程库，用于处理像HTTP和FTP之类的TCP/IP协议。Java应用程序能够通过URL打开和访问网络上的对象，其便捷程度就好像访问本地文件一样。

- **健壮性**

  Java的设计目标之一在于使得Java编写的程序具有多方面的可靠性。Java特别强调进行早期的问题检查、后期动态的（运行时）检测，以及消除容易出错的情况。Java编译器能够检测许多在其它语言中仅在运行时才能检测出的问题，Java与C/C++最大的不同在于Java采用的指针模型可以消除重写内存和损坏数据的可能性。

- **安全性**

  Java要适用于网络/分布式环境，为了实现这个目标，安全性颇受重视。从一开始，Java就设计成能够防范各种攻击的语言，包括：运行时堆栈溢出，这是蠕虫和病毒的常用攻击手段；破坏自己的进程空间之外的内存；未经授权读写文件。

- **体系结构中立**

  编译器生成一个体系结构中立的目标文件格式，这是一种编译过的代码，只要有Java运行时系统，这些编译后的代码可以在许多处理器上运行。Java编译器通过生成与特定计算机体系结构无关的字节码指令来实现这一特性，精心设计的字节码不仅可以很容易地在任何机器上解释执行，而且还可以动态地转换成本地机器代码。

  解释型虚拟机指令肯定比全速运行机器指令慢很多，但虚拟机有一个选项，可以将执行最频繁的字节码序列转换成机器码，这一过程称为即时编译。Java虚拟机还有一些其他优点，可以检查指令序列的行为，从而提高安全性。

- **可移植性**

  与C/C++不同，Java规范中没有“依赖具体实现”的地方，基本数据类型的大小以及有关运算的行为都有明确的说明。例如Java中的int永远是32位整数，而C/C++中可能是16位，32位，也可能是编译器开发商指定的其他任何大小。

  在Java中，数值类型有固定的字节数，这消除了代码移植时一个主要问题，二进制数据以固定格式进行存储和传输，消除了字节顺序的困扰，字符串则采用标准的Unicode格式存储。

  除了与用户界面有关的部分外，所有其他Java库确实能很好地支持平台独立性。你可以处理文件、正则表达式、XML、日期和时间、数据库、网络连接、线程等，而不用关心底层操作系统。不仅程序是可移植的，Java API往往也比原生API质量更高。

- **解释型**

  Java解释器可以在任何移植了解释器的机器上直接执行Java字节码，由于连接是一个增量式且轻量级的过程，所以开发过程也变得更加快捷，更加具有探索性。

- **高性能**

  尽管对解释后的字节码性能已较为满意，但在有些场合下还需要更高的性能。字节码可以（在运行时）动态地转换成对应运行这个应用地特定CPU的机器码。

  现在的即时编译器已经非常出色，可以与传统编译器相媲美，在某些情况下甚至超越了传统编译器，原因是它们有更多的可用信息。例如即时编译器可以监控哪些代码频繁执行，并优化这些代码以提高速度。更为复杂的优化是消除函数调用（内联）。即时编译器知道哪些类已经加载，基于当前加载的类集合，如果一个特定函数不会被覆盖就可以使用内联，必要时还可以撤销这种优化。

- **多线程**

  多线程可以带来更快的交互响应和实时行为。在当时，Java是第一个支持并发程序设计的主流语言。

- **动态性**

  从很多方面看，Java相比C/C++更具有动态性，它能够适应不断发展的环境。库中可以自由地添加新方法和实例变量，而对客户端却没有任何影响。在Java中找出运行时类型信息十分简单。

----

### Java发展史

| 版本 | 年份 | 新语言特性                                                   |
| ---- | ---- | ------------------------------------------------------------ |
| 1.0  | 1996 | 语言本身                                                     |
| 1.1  | 1997 | 内部类                                                       |
| 1.2  | 1998 | strictfp修饰符                                               |
| 1.3  | 2000 | 无                                                           |
| 1.4  | 2002 | 断言                                                         |
| 5    | 2004 | 泛型类、for each循环、可变参数、自动装箱、元数据、枚举、静态导入 |
| 6    | 2006 | 无                                                           |
| 7    | 2011 | 基于字符串的选择语句、菱形运算符、二进制字面量、异常增强处理 |
| 8    | 2014 | lambda表达式、包含默认方法的接口、流和日期/时间库            |
| 9    | 2017 | 模块、其他的语言和类库增强                                   |

---

## 基本程序设计结构

### 数据类型

Java是一种强类型语言，因此必须为每一个变量声明一种类型。在Java中一共有8种基本类型，其中有4种整形、2种浮点类型、1种字符类型char和1种用于表示真值的boolean类型。

- 整形

  整形用于表示没有小数部分的数值，允许是负数，Java提供了4种整形。

  | 类型  | 存储需求 | 取值范围                                 |
  | ----- | -------- | ---------------------------------------- |
  | byte  | 1字节    | -128~127                                 |
  | short | 2字节    | -32767~32767                             |
  | int   | 4字节    | -2147483648~2147483647（刚刚超过20亿）   |
  | long  | 8字节    | -9223372036854775808~9223372036854775807 |

  int类型最常用，数量很大时需要使用long。byte和short类型主要用于特定场合，例如底层的文件处理或者存储空间很宝贵时的大数组。

  在Java中，整形的范围与运行Java代码的机器无关，这就解决了软件从一个平台移植到另一个平台，或者在同一个平台的不同操作系统之间进行移植给程序员带来的诸多问题。与此相反，C/C++程序会针对不同处理器选择最为高效的整形，这样就会造成在32位处理器上运行的程序在16位系统上运行时却发生整数溢出。由于Java程序必须保证在所有机器上都得到相同的运行结果，所以各种数据类型的取值范围必须固定。

  长整型数值有一个后缀L或者l，十六进制数有一个前缀0x或0X，八进制有一个前缀0，很显然八进制数容易混淆所以尽量不要使用八进制常数。

  从Java7开始，加上前缀0b或0B就可以表示二进制数，还可以为数字字面量加下划线，例如1_000，这些下划线只是为了易读性，编译器会去除这些下划线。

- **浮点类型**

  浮点类型用于表示有小数部分的数值，Java中有2种浮点型。

  | 类型   | 存储需求 | 取值范围                      |
  | ------ | -------- | ----------------------------- |
  | float  | 4字节    | 大约±3.40282347E+38F          |
  | double | 8字节    | 大约±1.79769313486231570E+308 |

  double这种类型的精度是float的2倍，因此也称为双精度数值，很多情况下float类型的精度（6~7位有效数字）并不能满足需求，只有很少的情况下适合float，例如需要单精度的库或者需要存储大量数据时。

  float类型的数值有一个后缀F或f，如果没有后缀的浮点数总认为是double类型，当然也可以在浮点数值后面添加后缀D或d。

  常量Double.POSITIVE_INFINITY、DoubleNEGATIVE_INFINITY和Double.NaN分别表示正无穷大、负无穷大和NaN（不是一个数字）。

  浮点数值不适用于无法接受舍入误差的金融计算，舍入误差的主要原因是浮点数值采用二进制系统表示，在二进制系统中无法精确地表示分数。如果在数值计算中不允许有任何舍入误差就应该使用BigDecimal类。

  可移植性是Java语言的设计目标之一，无论在哪个虚拟机上执行，同一运算应该得到同样的结果。对于浮点数而言，实现这样的可移植性是十分困难的。Java虚拟机的最初规范要求所有中间计算必须进行截断，之后改进为默认情况下允许对中间计算采用扩展精度，但是对于使用了strictfp关键字标记的方法必须使用严格的浮点计算。

- **char类型**

  char类型（2字节）原本用于表示单个字符，不过现在情况有所变化，有些Unicode字符需要1个char值描述，有些Unicode字符需要2个char值描述。char类型的值可以表示为16进制值，范围从\u0000到\uFFFF。

  一些特殊字符的转义序列：

  | 转义序列 | 名称   | Unicode值 |
  | -------- | ------ | --------- |
  | \b       | 退格   | \u0008    |
  | \t       | 制表   | \u0009    |
  | \n       | 换号   | \u000a    |
  | \r       | 回车   | \u000d    |
  | \\"      | 双引号 | \u0022    |
  | \\'      | 单引号 | \u0027    |
  | \\\      | 反斜杠 | \u005c    |

  

- **boolean类型**

  boolean类型（1字节）有两个值：false和true，用来判断逻辑条件。整型值和布尔值之间不能相互转换。

---

### 变量与常量

- **变量**

  变量名必须是一个以字母开头并由字母或数字构成的序列，与大多数语言相比，Java中的字母和数字的范围更大，字母包括'A'~'Z'，'a'~'z'，'_'，'$'或在某种语言中表示字母的任何Unicode字符。同样数字也包括'0'~'9'和在某种语言中表示数字的任何Unicode字符。不可使用空格，并且变量名是大小写敏感的，长度基本没有限制。

  从Java10开始，对于局部变量，如果可以从变量的初始值推断出它的类型，就不再需要声明它的类型，只需要使用关键字var而无需指定类型。

- **常量**

  利用关键字final指示常量，final表示这个变量只能被赋值一次，一旦赋值之后就不能再更改了，习惯上变量名使用全大写。如果希望某个常量可以在一个类的多个方法使用，通常将这些常量称为类常量，使用关键字static final修饰。

---

### 运算符

- **算术运算符**

  当参与/运算的两个操作数都是整数时表示整数除法，否则表示浮点除法。整数被0除会产生一个异常，浮点数被0除会得到无穷大或NaN结果。

- **数学函数**

  计算平方根：`Math.sqrt(double a)`

  计算幂运算：`Math.pow(doube a,double b)`

  如果计算溢出，数学运算符只是返回一个错误结果而不做任何提醒，但如果是Math中的方法就会生成异常。

- **数值类型转换**

  无信息丢失的转换：byte->short、short->int、char->int、int->long、int->double、float->double

  可能有精度损失的转换：int->float、long->float、long->double

  当用二元运算符连接两个值时，先要将两个操作数转换为同一种类型再进行计算，如果两个操作数有一个是double类型，另一个操作数就转为double；否则如果有一个是float类型，另一个操作数就转为float；否则如果有一个操作数是long类型，另一个操作数就转为long；否则两个操作数都转为int。

- **强制类型转换**

  可能丢失信息的转换要通过强制类型转换完成，如果想对浮点数进行舍入运算，以便得到最接近的整数，可以使用Math.round(float/double a)方法。

- **结合赋值和运算符**

  可以在赋值时使用二元运算符，例如`x+=4`，等价于`x=x+4`，如果运算符右边的值类型和左边不一致就会发生强制类型转换，例如x是int类型，`x+=3.5`等价于`x=(int)(x+3.5)`。

- **自增和自减运算符**

  自增和自减运算符改变的是变量的值，不能应用于数值本身，因此1++不是一个合法的语句。

  后缀和前缀形式都会使变量值加1或减1，不同的是前缀形式会先完成运算，后缀形式会先使用变量原来的值。

- **关系和boolean运算符**

  Java沿用了C++的做法，使用&&表示逻辑“与”运算符，使用||表示逻辑"或"运算符，感叹号！就是逻辑非运算符。&&和||是按照"短路"方式来求值的，如果第一个操作数已经能够确定表达式的值，第二个操作数就不必计算了。

- **位运算符**

  位运算符包括`&`（与）、`|`（或）、`^`（异或）、`~`（非）。

  `>>`和`<<`可以将位模式左移或右移，`>>>`会用0填充高位，`>>`会用符号位填充高位，不存在`<<<`运算符。移位运算符的右操作数要完成模32的运算（除非左操作数是long类型，这种情况下需要模64），例如1<<35的值等于1<<3或者8。

- **括号与运算符级别**

  不使用括号就按照运算符优先级次序计算，同一级别的运算符按照从左到右的次序计算（右结合运算符除外）。

---

### 字符串

从概念上讲，Java字符串就是Unicode字符序列。Java没有内置的字符串类型，而是在标准Java类库中提供了一个与定义类，叫做String，每个用双引号引起来的字符串都是String类的一个实例。

- **子串**

  String类的substring方法可以从一个较大的字符串提取出一个字串。

  substring方法的第一个参数是要复制的第一个位置，第二个参数是不想复制的第一个位置，例如substring(0,3)复制了0，1和2，不包括3。

  substring的工作方式有一个优点：容易计算字串的长度，substring(a,b)的长度为b-a。

- **拼接**

  与绝大多数程序设计语言一样，Java语言允许使用+号连接（拼接）两个字符串。

  当将一个字符串与一个非字符串的值拼接起来时，后者会转换成字符串（任何一个Java对象都可以转换成字符串）。例如`int age=13`，`String rating="PG"+age`，将rating设置为"PG13"。

  如果需要把多个字符串放在一起，用一个界定符分隔，可以使用静态方法join，例如`String str=String.join("/","S","M","L")`将str设置为"S/M/L"。

  在Java11中，还提供了repeart方法，例如`String str="Java".repeat(3)`将str的值设为"JavaJavaJava"。

- **不可变字符串**

  String类没有提供修改字符串中某个字符的方法，由于不能修改Java字符串中的单个字符，所以Java文档中将String类对象称为不可变的，不过可以修改字符串变量，让它引用另一个字符串，就如同可以让原本存3的数值变量改成存放4一样。

  通过拼接两个字符串来创建一个新字符串的效率确实不高，但是不可变字符串有一个优点：编译器可以让字符串共享。可以想象将各种字符串存放在公共的存储池中，字符串变量指向存储池中相应的位置，如果复制一个字符串变量，原始字符串与复制的字符串共享相同的字符。Java认为共享带来的高效率远胜于提取字串、拼接字符串所带来的低效率。

- **检查字符串是否相等**

  可以使用equals方法比较两个字符串的值是否相等，如果不区分大小写，可以使用equalsIgnoreCase方法。

  ==运算符只能确定两个字符串是否存放在同一个位置上，如果虚拟机始终将相同的字符串共享，就可以使用==运算符检测是否相等。但实际上只有字符串字面量是共享的，而+或substring等操作得到的字符串并不共享，不要使用==运算符测试字符串的相等性。

- **空串与Null串**

  空串""是长度为0的字符串，空串是一个Java对象，有自己的串长度(0)和内容(空)，不过String变量还可以存放一个特殊的值，名为null，表示目前没有任何对象与该变量关联。

- **String类常用API**

  `int compareTo(String other)`:按字典顺序比较，在other之前返回负数，之后返回正数，相等返回0。

  `boolean equals(String other)`:比较两个字符串值是否相等。

  `boolean startWith(String prefix)`:是否以prefix开头。

  `boolean endsWith(String suffix)`:是否以suffix结尾。

  `int indexOf(String str[,int fromIndex])`:返回与字符串str匹配的第一个子串的开始位置，从索引0或者fromIndex开始，不存在返回-1。

  `int indexOf(int cp[,int fromIndex])`:返回与码点cp匹配的第一个子串的开始位置，从索引0或者fromIndex开始，不存在返回-1。

  `int length()`:返回字符串代码单元的长度。

  `String replace(CharSequence old,CharSequence new)`:返回新字符串，用new代替所有的old。

  `String substring(int begin[,int end])`:返回新字符串，包含原始字符串从begin到末尾或end-1的所有代码单元。

  `String trim()`:返回一个新字符串，删除原始字符串头部和尾部小于等于U+0020的字符。

- **构建字符串**

  有时候需要由较短的字符串构建字符串，如果采用字符串拼接的方式来达到目的，效率会比较低。每次拼接字符串时都会构建一个新的String对象，既耗时又浪费空间。可以使用StringBuilder来解决该问题。

  StringBuilder在Java5中引入，这个类的前身是StringBuffer，它的效率低但是线程安全。如果所有字符串编辑操作都在单个线程中执行（通常都是这样），则应该使用StringBuilder。

----

### 输入与输出

- **读取输入**

  读取标准输入流首先需要构造一个与标准输入流关联的Scanner对象，`nextLine()`方法将读取一整行输入；如果想要读取一个单词（以空白符作为分隔符），可以使用`next()`方法；如果想要读取一个整数，可以使用`nextInt()`方法；如果想要读取下一个浮点数就是要`nextDouble()`方法；`hasNext()`可以检测输入中是否还有其他单词，`hashNextInt()`和`hashNextDouble()`检测是否还有下一个表示整数或浮点数的字符序列。

- **格式化输出**

  可以使用printf方法实现格式化输出，例如x的值为10000.0/3.0调用printf("%8.2f",x)将输出` 3333.33`，8代表输出的字符宽度，精度是小数点后2个字符，由于3333.33只有7个字符宽，所以还会打印一个前导的空格。

  每一个以%后面的转换符都说明了要格式化的数值类型，除了f表示浮点数，还有s表示字符串，d表示十进制整数，c表示字符，b表示布尔等。除了printf也可以用静态方法`String.format`创建一个格式化的字符串。

---

### 控制流程

与任何程序设计语言一样，Java使用条件语句和循环结构确定控制流程。

- **块作用域**

  块（即复合语句）是指由若干条Java语句组成的语句，并用一对大括号括起来。块确定了变量的作用域，一个块可以嵌套在另一个块中。不能在嵌套的两个块中声明同名的变量。

- **条件语句**

  if中的条件为true时会执行对应语句，else是可选的，总是与最近的if构成一组。

- **for循环**

  for循环语句是支持迭代的一种通用结构，由一个计数器或类似的变量控制迭代次数，每次迭代后这个变量将会更新。for语句的第1部分通常是对计数器初始化，第2部分给出每次新一轮循环执行前要检测的循环条件，第3部分指定如何更新计数器。

  for语句内部定义的变量，不能在循环体之外使用。因此如果希望在for循环体之外使用循环计数器的最终值，就要确保这个变量在循环之外声明。

- **while循环**

  while语句在最前面检测循环条件，因此循环体中的代码有可能一次都不执行。如果希望循环体至少执行一次可以使用do-while循环，这种循环语句先执行语句再检测循环条件。

- **多重选择：switch语句**

  在处理多个选项时，使用if/else会显得有些笨拙，Java有一个和C/C++完全相同的switch语句。switch语句将从选项值相匹配的case标签开始执行，直到遇到break语句，或者执行到switch语句的结束处为止。如果没有匹配的case语句而有default语句就执行这个default子句。

  case标签可以是char、byte、short、或int的常量表达式，枚举常量，从Java7开始，还可以支持字符串字面量。当使用枚举常量时，不必在每个标签中指明枚举名，可以由switch的表达式值推导得出。

- **中断控制流程的语句**

  不带标签的break语句，和用于退出swicth语句的break语句一样，可以用于直接退出循环。

  还可以使用带标签的break语句，可以用于跳出多重循环的嵌套语句。标签必须放在最外层循环之前，并且紧跟一个冒号。

  continue语句将中断正常的控制流程，将控制转移到最内层循环的首部，如果continue用于for循环，就可以跳到for循环的更新部分，还有一种带标签的continue，将跳到与标签匹配的循环的首部。

---

### 大数

如果基本的整数和浮点数精度不能够满足需求，那么可以使用java.math包中的两个很有用的类：BigInteger和BigDecimal，这两个类可以处理包含任意长度数字序列的数值。BigInteger类实现任意精度的整数运算，BigDecimal类实现任意精度的浮点数运算。

使用静态的`valueOf`方法可以将普通的数值转换为大数，对于更大的数，可以使用一个带字符串参数的构造器。不能使用算术运算符处理大数，例如+和*，而需要大数类的add和multiply方法。除此之外的其他方法：substract求差，divide求商，mod求余，sqrt求平方根，compareTo比较两个数。

---

### 数组

- **声明**

  数组是一种数据结构，用来存储同一类型值的集合。通过一个整形下标（index，或称索引）可以访问数组中的每一个值。在声明数组变量时，需要指出数组类型和数组变量的名字。

  一旦创建了数组就不能再改变它的长度，如果程序运行中需要经常扩展数组的大小，就应该使用另一种数据结构：数组列表ArrayList。

- **访问元素**

  创建一个数字数组时，所有元素都初始化为0，boolean数组的元素会初始化为false，对象数组的元素则初始化为一个特殊值null，表示这些元素还未存放任何对象。

  Java可以使用增强for循环来依次处理数组（或者其他元素集合）中的每一个元素，而不必考虑指定下标值。可以使用的必须是一个数组或者一个实现了Iterable接口的类对象。如果想打印数组中的所有值可以调用静态的`Arrays.toString`方法。

- **数组拷贝**

  如果希望将一个数组的所有值拷贝到一个新的数组中去，可以使用`Arrays.copyOf(int[] arr,int len)`方法，第2个参数是新数组的长度，这个方法通常用于增加数组的大小，如果数组元素是数值型那么额外的元素将被赋值0，如果数组元素是布尔型则赋值false。相反如果长度小于原始数组的长度，则只拷贝前面的值。这个方法实际上调用了`System.arraycopy`方法，效率一般。

  使用`System.arraycopy(Object src,int srcPos,Object dest,int destPos,int length)`拷贝数组，前2个参数是原数组和拷贝位置，之后2个参数是目标数组和拷贝位置，最后一个参数代表拷贝长度，这是一个本地方法，效率最高，尤其在数组很大时尤为明显。也可以使用for循环和clone方法拷贝数组，for循环适合于小数组的拷贝，数组越大效率越低。

- **数组排序**

  可以使用Arrays类中的sort方法，这个方法使用了优化的快速排序，快速排序算法对于大多数数据集合来说都是效率比较高的。

---

## 面向对象

### 概述

面向对象程序涉设计（OOP）是当今主流的程序设计泛型，面向对象的程序是由对象组成的，每个对象包含对用户公开的特定部分和隐藏的实现部分。传统的结构化程序通过设计一系列算法求解问题，首先考虑的是如何操作数据，然后再考虑组织数据的结构，而面向对象中数据是第一位的，然后再考虑操作数据的算法。对于规模较小的问题，面向过程开发比较理性，面向对象更加适合解决规模较大的问题。

---

### 类

类是构造对象的模板或蓝图，由类构造对象的过程称为创建类的实例。

封装是处理对象的一个重要概念，从形式上看封装就是将数据和行为组合在一个包中，并对对象的使用者隐藏具体的实现方式。对象中的数据称为实例字段，操作数据的过程称为方法。作为一个类的实例，特定对象都有一组特定的实例字段值，这些值的集合就是这个对象的当前状态。

封装给予了对象黑盒特征，这是提高重用性和可靠性的关键。这意味着一个类完全可以改变数据存储的方式，只要仍使用同样的方法操作数据，其他对象就不会知道也不用关心这个类的变化。

类之间的关系：

- 依赖，即uses-a关系，如果一个类的方法使用或操纵另一个类的对象，我们就说一个类依赖于另一个类。
- 聚合，即has-a关系，即一个对象包含另一个对象。
- 继承，即is-a关系，表示一个更特殊的类与一个更一般的类之间的关系。

---

### 构造器

Java语言中要使用构造器用来构造新实例，构造器是一种特殊的方法，用来构造并初始化对象。

构造器的名字与类名相同，想要构造一个新实例需要在构造器前加上new操作符。在Java中，任何对象变量的值都是对存储在另一个地方的某个对象的引用，new操作符返回值也是一个引用。

每个类可以有一个以上的构造器，构造器可以0或多个参数，构造器没有返回值，构造器总是伴随new操作符一起使用。

---

### 静态字段和方法

如果将一个字段定义为static，每个类只有一个这样的字段，而对于非静态的实例字段，每个对象都有自己的一个副本。

静态方法是用static修饰的方法，静态方法不在对象上指向，可以认为静态方法是没有this参数的方法（在一个非静态方法中，this参数指示这个方法的隐式参数）。可以使用对象调用静态方法，但容易造成混淆，建议使用类名调用。

可以使用静态方法的情况：

- 方法不需要方法对象的状态，因为它所需要的所有参数都通过显示参数提供。
- 方法只需要访问类的静态字段。

静态方法还有一种常见用途，就是使用静态工厂方法来构造对象。

---

### 方法参数

按值调用表示方法接收的是调用者提供的值，按引用调用表示方法接收的是调用者提供的变量地址。方法可以修改按引用传递的变量的值，而不能修改按值传递的变量的值。Java中总是采用按值调用，也就是说方法得到的是所有参数值的一个副本，方法不能修改传递给它的任何参数变量的内容，实际上对象引用是按值传递的。

---

### 对象构造

- **重载**

  如果多个方法具有相同的名字、不同的参数，便出现了重载。如果编译器找不到匹配的参数就会产生编译时错误，查找匹配的过程叫做重载解析。

  Java允许重载任何方法，要完整描述一个方法需要指定方法名和参数类型，这叫做方法的签名。返回类型不是方法签名的一部分，因此不能有两个名字相同、参数类型也相同却有不同返回类型的方法。

- **默认字段初始化**

  如果在构造器中没有显示地为字段设置初值，那么就会被自动赋为默认值：数值为0、布尔值为false、对象引用为null。

  方法中的局部变量必须明确地初始化，不能不设置初始值。

- **无参构造器**

  很多类都包含无参构造器，由无参构造器创建对象时，对象的状态会设置为适当的默认值。如果没有为一个类编写构造器，就为为你提供一个无参构造器，这个构造器将所有字段设置为默认值。

  如果类中至少提供了一个构造器，但是没有提供无参构造器，那么构造对象时就不能使用无参构造器。

- **调用构造器**

  关键字this指代一个方法的隐式参数，除此之外，还可以使用this来调用同一个类的其他构造器。

- **初始化块**

  除了在构造器中赋值和在声明中赋值，还可以使用初始化块，即类中的代码块。

  构造器调用的具体处理步骤：

  - 如果构造器的第一行调用了另一个构造器，则基于所提供的参数执行第二个构造器。
  - 否则将所有数据字段初始化为默认值，按照在类声明中出现的顺序，执行所有字段初始化方法和初始化块。
  - 执行构造器主体代码。

- **finalize方法**

  该方法在垃圾回收器清理对象之前调用，不要使用该方法来回收资源，因为并不能知道它什么时候调用而且它已被废弃。

---

### 类设计技巧

- 保证数据私有
- 一定要对数据进行初始化
- 不要在类中使用过多基本类型
- 不是所有字段都需要单独的字段访问器和字段更改器
- 分解有过多职责的类
- 类名和方法名要能体现它们的职责
- 优先使用不可变类

---

## 继承

### 子类和父类

关键字extends表示正在构造的新类派生于一个已存在的类，这个已存在的类称为超类、基类或父类；新类称为子类、派生类或孩子类。Java中不支持多继承。

- **方法重写**

  子类可以重写父类的方法，也可以通过关键字super调用父类的方法。

  重写方法的方法签名必须和父类一致，返回值小于等于父类方法，抛出的异常类型小于等于父类方法，访问修饰符大于等于父类方法。

- **子类构造器**

  可以使用super调用父类的构造器，使用super调用构造器的语句必须是子类构造器的第一条语句。

  如果子类的构造器没有显式地调用父类构造器，将自动调用父类无参构造器。如果父类没有无参构造器，在子类的构造器又没有显式调用父类的其他构造器，Java编译器就会报告错误。

  this的两个作用：①隐式参数的引用。②调用该类的其他构造器。

  super的两个作用：①调用父类的方法。②调用父类的构造器。

- **多态**

  在Java中对象变量是多态的，既可以引用本类型的对象，也可以引用子类的对象。

  方法调用的过程：

  - 编译器查看对象的声明类型和方法名。
  - 编译器确定方法调用中提供的参数类型，这个过程称为重载解析。
  - 如果是private、static或final修饰的方法或者构造器，编译器可以准确地知道要调用哪个方法，这称为静态绑定，与此对应地是如果要调用的方法依赖于隐式参数的实际类型，那么必须在运行时动态绑定。
  - 程序运行并采用动态绑定调用方法时，虚拟机必须调用引用对象的实际类型对应的方法。

  每次调用都要完成时间开销很大的搜素，因此虚拟机预先为每个类计算了一个方法表，其中列出了所有方法的签名和要调用的实际方法，当真正调用方法时虚拟机仅查找这个表就可以了。

  动态绑定有一个重要特性：无须对现有的代码进行修改就可以对程序进行扩展。

- **阻止继承：final类和方法**

  不允许扩展的类称为final类，不允许子类重写的方法称为final方法。

  将类或方法声明为final的主要原因是：确保它们不会在子类中改变语义。

- **强制类型转换**

  将一个类强制转换成另外一个类型的过程称为强制类型转换。

  进行强制类型转换的唯一原因是：要在暂时忽视对象的实际类型之后使用对象的全部功能。将子类的引用赋值给父类变量，编译器是允许的。但如果将一个父类引用赋值给子类变量，就必须进行强制类型转换，这样才能通过运行时的检查。

  只能在继承层次内使用强制类型转换，并且强制转换前应该是有instance of进行检查。

- **抽象类**

  使用abstract修饰抽象类，抽象类更具有一般性。

  抽象类不能实例化，但抽象类的非抽象子类可以实例化，一个抽象类对象变量只能引用非抽象子类对象。

  抽象类可以不含抽象方法，但有抽象方法的类一定是抽象类。

  扩展抽象类有两种选择：

  - 在子类中保留抽象类中的部分或所有抽象方法，将子类也标记为抽象类。
  - 实现全部方法，子类是非抽象类。

- **受保护访问**

  如果希望限制父类的某个方法只允许子类访问，或者希望允许子类的方法能访问父类的某个字段，就可以将这些类方法或字段声明为protected。

  Java中有4个访问修饰符：①public，对外部完全可见。②protected，对本包和所有子类可见。③默认，不需要修饰符，对本包可见。④private，仅对本类可见。

---

### Object类

Object类是所有类的父类，可以使用Object类型的变量引用任何类型的对象。

- **equals方法**

  Object类中的equals方法用于检测一个对象是否等于另一个对象，它将确定两个对象的引用是否相等。

  当使用equals比较字符串和基本数据数据类型时，比较的是值而不是引用，因为重写了equals方法。

  如果要比较两个数组的值，可以使用Arrays.euqals方法。

- **hashCode方法**

  哈希值是由对象导出的一个整型值，哈希值是没有规律的，两个不同的对象调用hashCode方法，结果基本不会相同。每个对象都有一个默认的哈希值，由对象的存储地址得出，而字符串的哈希值由内容导出。

  如果重写了equals方法，就必须为可能插入HashMap或HashSet的对象重写hashCode方法。如果equals方法返回true，hashCode就必须相同；但是如果hashCode相同，equals未必相等。

- **toString方法**

  它返回表示对象值的一个字符串，直接打印某个对象就是打印了它的toString方法结果。如果要打印数组的内容可以使用Arrays.toString方法，如果是多维数组可以使用Arrays.deepToString方法。

---

### 对象包装器和自动拆装箱

所有的基本类型都有一个与之对应的类，例如int对应Integer类，这些类称为包装器。这些包装器类见名知意，包括Short、Byte、Integer、Long、Float、Double、Character和Boolean（前6个派生自公共父类Number）。

包装器类是不可变的，一旦构造了包装器，就不允许更改包装器在其中的值，并且包装器类是final类，因此不能被继承。将一个基本类型的值赋给包装器类会自动将其包装为一个包装器类的对象，这叫做自动装箱，将一个包装器类对象赋值给一个基本类型变量时，就会自充拆箱。

如果要比较包装器类的值要使用equals方法，如果使用==会比较对象的地址。

常用API：

- `int intValue()`：将Integer对象作为int值返回
- `static String toString(int i)`：将i的十进制字符串形式返回
- `static String toString(int i,int radix)`：将i的radix进制字符串形式返回
- `static int parseInt(String s)`：将字符串s表示的整数转换为10进制整数
- `static int parseInt(String s,int radix)`：将字符串s表示的整数转换为radix进制
- `static Integer valueOf(String s)`：将parseIntt(String s)的结果封装为包装器对象
- `static Integer valueOf(String s,int radix)`：将parseIntt(String s,int radix)的结果封装为包装器对象

---

### 枚举类

在比较两个枚举类型的值时，不需要调用equals，直接使用==就可以了。

枚举的构造器总是私有的，如果将enum的构造器声明为public或protected，就会报语法错误。所有枚举类型都是Enum类的子类。

常用API：

- `static Enum valueOf(Class enumClass,String name)`：返回给定类中有指定名字的枚举常量。
- `String toString()`：返回枚举常量名。
- `int ordinal()`：返回枚举常量在enum声明中的为止，从0开始计数。
- `int compareTo(E other)`：如果枚举常量出现在other之前，返回一个负整数；如果this==other，返回0；否则返回一个正整数。枚举常量出现次序在enum声明中给出。

---

### 反射

反射库提供了一个丰富且精巧的工具集，可以用来编写能够动态操纵Java代码的程序。能够分析类能力的程序称为反射，反射机制的功能很强大，主要包括：

- **在运行时分析类的能力**。
- **在运行时检查对象**。
- **实现泛型数组操作代码。**
- **利用Method对象。**

在程序运行期间，Java运行时系统始终为所有对象维护一个运行时类型标识，这个信息会跟踪每个对象所属的类，虚拟机利用运行时类型信息选择要执行的正确方法。也可以使用一个特殊的Java类方法这些信息，保存这些信息的类名为Class。

获取Class对象的三种方法：

- 使用Object类中的`getClass()`方法，该方法返回一个Class类型的实例。
- 使用静态方法`Class.forName(String className)`获得类名对应的Class对象。
- 如果T是Java类型，T.class将代表匹配的类对象。

Class类实际上是一个泛型类，例如Student.class的类型是`Class<Student>`，虚拟机为每个类型管理一个唯一的Class对象，因此可以利用==运算符实现两个类对象的比较。

如果有一个Class类型的对象，可以使用它来构造类的实例。调用getConstructor()方法将得到一个Constructor类型的对象（相当于获取该类的无参构造器），然后使用newInstance方法来构造一个实例。如果这个类没有无参构造器就会抛出一个异常。

- **利用反射分析类的能力**

  java.lang.reflect包中有三个类Field、Method和Constructor分别用于描述类的字段、方法和构造器。这三个类都有一个getName()方法，用来返回字段、方法或构造器的名称。Field类有一个getType方法，用来返回描述字段类型的一个对象，这个对象的类型同样是Class。

  Method和Constructor类有报告参数类型的方法，Method类还有一个报告返回类型的方法。这三个类都有一个getModifiers方法，它将返回一个整数，用不同的0/1位描述所使用的修饰符，如public和static。另外还可以使用Modifier类的静态方法分析getModifiers返回的这个整数，例如可以使用isPublic、isPrivate或isFinal判断方法或构造器是否是public、private、final修饰的。

  Class类中的getFields、getMethods和getConstructors方法将分别返回这个类支持的公有字段、方法和构造器的数组，其中包括父类的公共成员（父类字段和方法可以获得，但不包含父类公有构造器）。

  Class类中的getDeclaredFields、getDeclaredMethods和getDeclaredConstructors方法将分别返回这个类中声明的全部字段、方法和构造器的数组，其中包括私有成员、包成员和受保护成员，但不包括父类成员。

- **在运行时分析对象**

  反射机制的默认行为受限于Java的访问控制，不过可以调用Field、Method或Constructor对象的setAccessible方法覆盖Java的访问控制。

- **调用方法和构造器**

  Method类有一个invoke方法，可以调用包装在当前Method对象中的方法，可以使用方法名获取对应的Method对象。类似的，可以使用构造器的参数类型获取对应的构造器对象，然后利用newInstance方法构建对象实例。
  
- **注解**

  - 注解是一种标记，可以使类或接口附加额外的信息，是帮助编译器和JVM完成一些特定功能的。
  - 元注解是自定义注解的注解，包括
    - `@Target`：用来约束注解的位置，值是ElementType枚举类，包括METHOD方法、VARIABLE变量、TYPE类/接口、PARAMETER方法参数、CONSTRUCTORS构造器和LOACL_VARIABLE局部变量；
    - `@Rentention`：用来约束注解的生命周期，值是RetentionPolicy枚举类，包括：SOURCE源码、CLASS字节码和RUNTIME运行时。
    - `@Documented`：表明这个注解应该被javadoc工具记录。
    - `@Inherited`：表明某个被标注的类型是被继承的。

---

### 继承的设计技巧

- 将公共操作和字段放在父类中。
- 不要使用受保护的字段。
- 使用继承实现is-a的关系。
- 除非所有继承的方法都有意义，否则不要使用继承。
- 在重写方法时，不要改变预期的行为。
- 使用多态，而不要使用类型信息。
- 不要滥用反射。

---

## 接口、lambda表达式和内部类

### 接口

接口不是类，而是对希望符合这个接口的类的一组需求。

接口中的所有方法都默认是public的，因此在接口中声明方法时不必提供关键字public。

接口还可以定义常量，但接口不能提供实例字段，也不能实例化，只有接口的实现类可以实例化。

每个类只能有一个父类，但是可以实现多个接口，这为定义类的行为提供了极大的灵活性。

- **接口与抽象类**

  使用抽象类表示通用属性存在一个严重的问题，每个类只能扩展一个类。Java选择了不支持多重继承，主要原因是多重继承会让语言变得非常复杂，或者效率会降低。接口可以提供多重继承的大多数好处，同时还能避免多重继承的复杂性和低效性。

  接口和抽象类都不能被实例化，但抽象类具有构造器而接口没有构造器。

  抽象类中定义变量和方法没有限制，接口中只能定义常量，在Java8前只能定义public方法，Java8开始支持默认方法和静态方法，Java9开始支持私有方法，私有方法可以是静态方法或实例方法，由于私有方法只能在接口本身的方法中使用，所以其用法很有限，只能作为接口中其他方法的辅助方法。

- **默认方法**

  默认方法的一个重要用法是接口演化，假如为接口增加了一个新的方法，其实现类将不能编译，因为它没有实现这个新方法，为接口增加一个非默认方法不能保证源代码兼容。将方法实现为一个默认方法就可以解决该问题。

  如果在接口中定义了默认方法，父类中也有方法签名一样的具体方法，会优先使用父类方法，接口中的方法会被忽略。

  如果两个接口提供了相同的默认方法，就必须在实现类重写来解决二义性问题，否则会编译报错。

---

### lambda表达式

lambda表达式是一个可传递的代码块，可以在以后执行一次或多次。

即使lambda表达式没有参数，仍然要提供空括号，就像无参数方法一样。如果可以推导出一个lambda表达式的参数类型，则可以忽略其类型。如果方法只有一个参数，而且这个参数的类型可以推导得出，那么可以省略小括号。

无须指定lambda表达式的返回类型，lambda表达式的返回类型总会是由上下文推导得出。

如果一个lambda表达式只在某些分支返回一个值，而另外一些分支不返回值，就是不合法的。

-  **函数式接口**

  对于只有一个抽象方法的接口，需要这种接口的对象时，就可以提供一个lambda表达式，这种接口称为函数式接口。通过`@FunctionalInterface`标识一个接口为函数式接口，如果不满足有且仅有一个抽象方法的要求就会报错。

- **方法引用**

  可以直接把某个方法作为参数传递，主要有三种情况：

  - 传递某个对象的实例方法，例如`System.out::println`，对象是System.out。
  - 传递某个类的实例方法，第一个参数作为隐式参数，例如`String::compareTo`。
  - 传递某个类的静态方法，例如`Math::pow`。

  只有当lambda表达式只调用一个方法而不进行其他操作时，才能把lambda表达式重写为方法引用。

  一个常用转换，List数组转换为int数组：`list.stream().mapToInt(Integer::intValue).toArray()`

- **构造器引用**

  构造器引用和方法引用很类似，只不过方法名为new。例如`Person::new`是Person构造器的一个引用，具体是哪个构造器取决于上下文。

- **变量作用域**

  在lambda表达式中，只能引用值不会改变的变量。因为如果在lambda表达式中更高变量，并发执行时就会不安全。另外如果在lambda表达式中引用一个变量，而这个变量可能在外部更改，也是不合法的，例如for循环中的计数器不能在lambda表达式中引用，lambda表达式中捕获的值必须实际上是最终变量，即这个变量初始化后就不会再为它赋新值。

  lambda表达式的体与嵌套块具有相同的作用域，在lambda表达式中声明与一个局部变量同名的参数或局部变量是不合法的。

  在一个lambda表达式中使用this关键字时，是指创建这个lambda表达式的方法的this参数。

- **处理lambda表达式**

  使用lambda表达式的重点是延迟执行，之所以希望之后再执行代码，有很多原因，如：

  - 在一个单独的线程中运行代码
  - 多次运行代码
  - 在算法的适当位置运行代码
  - 发生某种情况时执行代码
  - 只在必要时运行代码

---

### 内部类

内部类是定义在另一个类中的类，使用内部类的原因主要有两个：

- 内部类可以对同一个包中的其他类隐藏。
- 内部类方法可以访问定义这个类的作用域中的数据，包括原本私有的数据。

内部类的分类：

- **成员内部类**

  普通的内部类，可以自由引用外部类的字段和方法，无论这些字段和方法是静态还是非静态的。成员内部类属于外部类实例对象，只有外部类被实例化后这个内部类才能被实例化。

  成员内部类的构造语法：`new Outer().new Inner()`

- **静态内部类**

  被声明为static的内部类，属于外部类本身，不依赖于外部类的实例对象。静态内部类只能访问外部类中静态成员和方法。

  有时使用内部类只是为了把一个类隐藏在另一个类内部，并不需要内部类有外部类对象的一个引用，为此可以将内部类声明为静态内部类。

  静态内部类的构造语法：`new Outer.Inner()`

- **局部内部类**

  局部内部类是定义在一个代码块中的累，作用范围仅在其所在代码块。局部内部类就像局部变量一样，不能被访问修饰符修饰。

  局部内部类有一个很大的优势，即对外部世界完全隐藏。

- **匿名内部类**

  没有类名的内部类，没有构造器，必须继承或实现其他接口，一般使用lambda表达式实现。

---

## 异常

### 异常分类

在Java中所有异常对象都是派生自Throwable类的一个实例，Throwable分为Error和Exception。

- **Error**

  Error类层次结构描述了Java运行时系统的内部错误和资源耗尽错误，如果出现了这样的内部错误，一般是无力解决的。

- **Exception**

  - **RuntimeException**

    由编程错误导致的异常属于RuntimeException，常见的RuntimeException包括：错误的强制类型转换、数组访问越界、空指针异常。

  - **其他异常**

    程序本身没有问题，但由于像IO错误这类问题导致的异常属于其他异常，常见的非RuntimeException包括：试图超越文件末尾继续读取数据、试图打开一个不存在的文件、根据字符串查找Class对象而这个字符串表示的类并不存在。

派生自Error和RuntimeException的异常称为非检查型异常，所有其他的异常称为检查型异常，检查型异常必须全部声明，否则编译器会报错。

---

### 异常处理

- **异常抛出**

  可以在方法上使用thorws关键字抛出异常给上层调用者，或者在方法中使用throw语句抛出异常。

- **异常捕获**

  使用try-catch代码块，如果try代码块中出现了异常，程序会跳过try中的剩余语句并执行catch代码块，如果没有出现异常会跳过catch代码块。

  可以在try-catch代码块中使用finally代码块，用于资源的清理，从Java7开始可以使用try-with-resources，资源是指实现了Closeable接口的类，try块退出时会自动调用资源的close方法来释放资源。

  无论try中是否遇到了异常，finally代码块都会执行。

一般经验是捕获那些你知道如何处理的异常，而继续传播那些你不知道如何处理的异常交给调用者来处理。

---

### 使用异常的技巧

- 异常处理不能替代简单的测试。
- 不要过分地细化异常。
- 充分利用异常的层次结构。
- 不要压制异常。
- 在检测错误时，苛刻比放任更好，异常应该尽早抛出。

---

## 容器

Java中的容器可以分为两类，Collection和Map。

### Collection

Collection用来存储独立的元素，其中包括List、Set和Queue。

- **List**

  List是一种线性的列表结构，是一种有序集合，List中的元素可以根据索引进行查找、插入或删除。

  - **ArrayList**

    ArrayList是用数组实现的List，它与数组有很多同样的特点：①随机访问（相对顺序访问）效率高。②读快写慢，由于写操作涉及元素的移动，因此写操作效率低。

    ArrayList的父类是AbstractList，该抽象类是大部分List的共同父类，它提供了一些基本的方法封装以及通用的迭代器实现。

    ArrayList实现了RandomAcess接口，这是一个标记接口，没有提供任何方法。如果一个类实现了该接口，那么表示这个类使用索引遍历比迭代器更快。

    **ArrayList有三个重要的成员变量和两个常量：**

    - ```java
      transient Object[] elementData;
      ```

      elementData是ArrayList的数据域，transient表示它不会被序列化，但是ArrayList的序列化和反序列化都是可以成功的，这是因为ArrayList实现了Serializable接口的writeObject方法，该方法是private的，当ArrayList对象被序列化时，序列化方法会反射调用该方法来替代默认的序列化方式。

      不使用elementData直接序列化是因为elementData是一个缓存数组，出于性能考虑，它通常会预留一些容量，当容量不足时会扩充容量，因此可能会有大量空间没有存储元素，采用这样的方式可以保证只序列化实际有值的那些元素而不需要序列化整个数组。

    - ```java
      private int size;
      ```

      size表示当前List的长度，elementData的长度是大于等于size的，因为elementData是缓存数组，size变量标识了真正的List大小。

    - ```java
      protected transient int modCount = 0;
      ```

      该成员变量继承自AbstractList，记录了ArrayList结构性变化的次数。在ArrayList中所有涉及结构变化的方法都会增加modCount的值，包括add()、remove()、addAll()、removeRange()及clear()。

    - ```java
      private static final long serialVersionUID = 8683452581122892189L;
      ```

      序列化版本UID，提供给序列化接口使用，该UID是为了维持序列化版本一致的。

    - ```java
      private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
      ```

      数组长度的上限，Integer的最大值减8。

    **ArrayList有三个重载的构造器：**

    ```java
    public ArrayList()
    public ArrayList(int initialCapacity)
    public ArrayList(Collection<? extends E> c) 
    ```

    其中`initialCapacity`表示初始化的elementData的长度，如果使用无参构造器，那么默认长度为10，当构造器的参数为集合时，它会把elementData的长度设置为集合的大小，然后再复制所有集合的元素到elementData。

    **ArrayList的一些常用方法：**

    - **indexOf/lastIndexOf/contains**

      indexOf方法用于查询指定对象的索引index，实现的方式是对数组顺序遍历，调用指定元素的equals方法来比较，如果查询不到返回-1。

      lastIndexOf与indexOf相反，是对数组倒序遍历。

      contains方法直接调用indexOf方法，根据返回值是否为-1来判断查找的元素是否存在。

    - **set/add/addAll**

      set方法的实现很简单，即替换数组里的对应索引处的值。

      add和addAll方法实现相对复杂，首先要检查当前elementData的长度，如果添加后的大小超出了elementData的长度，那么需要对其容量进行修正。

      修正的主要方法是两个：多余和不足。涉及的关键方法是grow(int)，该方法的int参数制定了“本次扩容所允许的最小容量”。grow的逻辑很简单，首先找出当前容量，把新容量设置为旧容量的1.5倍，如果新容量比可用最小容量要小，那么设置新容量为最小容量；如果新容量比极限容量常量要大，那么设置为极限容量常量和最大的整形数的较大值，接着使用该新容量初始化一个新的数组，将原有的elementData中的元素等位复制过去。

    - remove/removeAll/retainAll

      remove方法有两种重载形式，当参数为int类型时表示移除位于指定index的数组，如果移除的不是最后一位，会调用System.arraycopy方法把index之后的数据向前移动一位，该方法的返回值指向被删除的元素，效率较低。当参数为Object类型时，表示移除指定的对象，该方法会遍历整个数组找到第一个与之相等的对象，该方法的返回值表示删除是否成功。

      removeAll方法用于移除指定集合里的所有元素，与之相对的retainAll则是保留指定集合里存在的元素，这两个方法调用的都是batchRemove方法，区别是传入的参数一个为false一个为true。

    在使用迭代器遍历ArrayList时，不能修改元素，modCount是统计ArrayList修改的次数的，expectedModCount则是在迭代器初始化时记录modCount的值，每次访问新元素时都会调用检查方法检查modCount的值和expectedModCount是否相等，如果发现ArrayList被修改了就会抛出异常。

  - **LinkedList**

    LinkedList的两个主要特性为：顺序访问和写快读慢。

    LinkedList的父类是AbstractSequentialList，该抽象类继承自AbstractList，提供了顺序方法存储结构，它提供了get/set/add/addAll/remove等方法的迭代器实现，前提是必须实现Iterator接口。

    LinkedList实现了Deque双向队列接口，因为队列的特性是FIFO，因此LinkedList可在尾部增加数组，在头部获取数据，还能操作头尾之间任意节点。

    **LinkedList的主要成员变量和常量：**

    - ```java
      transient int size = 0;
      ```

      用于标记序列的大小，因为链表由单个节点组成，除了统计节点个数以外没有方法获取size，所以提供了标识量来做记录，提高效率。

    - ```java
      transient Node<E> first;
      ```

      链表的头节点。

    - ```java
      transient Node<E> last;
      ```

      链表的尾节点，同时提供头尾节点是为了实现Deque双向队列接口要求的功能。

      可以发现所有成员变量都被transient修饰，序列化原理和ArrayList类似。

    - ```java
      private static final long serialVersionUID = 876323262645176354L;
      ```

      序列化版本UID。

    **LinkedList有两个重载的构造器：**

    ```java
    public LinkedList()
    public LinkedList(Collection<? extends E> c) 
    ```

    与ArrayList不同，链表无需初始化任何对象，所以无参构造器没有做任何操作，带参构造器调用了addAll方法。

    **双向队列的实现：**

    LinkedList是一个在双向队列基础上搭建的双向链表，双向链表的关键方法有：addFirst队首添加元素、addLast队尾添加元素、removeFirst队首移除元素、removeLast队尾移除元素。这些方法都是操作成员变量first和last来实现的，first和last都是Node类型。

    Node的实现很简单：

    ```java
    	private static class Node<E> {
    		E item;//数据域，存储数据
            Node<E> next;//指向后继节点
            Node<E> prev;//指向前驱节点
    
            Node(Node<E> prev, E element, Node<E> next) {
                this.item = element;
                this.next = next;
                this.prev = prev;
            }
    	}
    ```

    例如addLast方法，新建一个Node节点n，然后将前驱设置为当前的last，将last.next设置为n，即可完成需求，其他方法类似。

    **getFirst/getLast/get方法：**

    getFirst和getLast这两个方法分别用于取出队首或队尾的数据，直接返回fisrt.item和last.item即可实现。

    get方法则不同，LinkedList是顺序存储结构，时间复杂度为O(n)。具体实现时进行了优化，如果index小于size的一半就正序变量，否则倒序遍历。

    **set/add/addAll方法：**

    与ArrayList不同，LinkedList的add方法比set方法更迅速，add方法的本质是在尾部增加一个节点，根据last指针很快就能实现，而set则需要遍历查找到指定节点并替换，addAll等价于调用多次add。

    **removeFirst/removeLast/remove方法：**

    removeFirst和removeLast方法用于移除首尾节点并返回数据，remove则是遍历到指定节点然后移除。remove方法的删除操作只需要修改待删除节点后继节点的pre和前驱节点的next指向，而不需要像ArrayList一样移动数据因此删除操作更高效。

  - **Vector和Stack**

    Vector的实现和ArrayList基本一致，底层使用的也是数组，它和ArrayList的区别主要在于：

    - Vector是线程安全的，Vector的所有public方法都是用了synchronized修饰。
    - Vector多了一个成员变量capacityIncrement，用于标明扩容的增量。

    Stack是Vector的子类，它的实现和Vector基本一致，与之相比它多提供了以下方法表达栈的含义：

    - E push：入栈，相等于在末尾增加一个元素
    - E pop：出栈，移除末尾元素并返回
    - E peek：查看栈顶，返回最末尾元素
    - empty：用于检查栈是否空
    - search：查找元素的栈深度，栈顶元素深度为1，当找不到时返回-1。

  - **总结**
    - ArrayList是用数组实现的，数组本身是随机访问的结构。
    - LinkedList是顺序访问结构，在双向队列应用中得到体现。
    - Vector与ArrayList相比是线程安全的，而且容量增长策略不同。
    - Stack是Vector的子类，提供了一些具有栈特性的方法。

- **Set**

  Set是一个接口，这个接口约定了在其中的数据是不能重复的，主要的实现类有三个：

  - **HashSet**

    HashSet中不允许有重复的元素，HashSet中最多只能有一个null。

    HashSet的内部是通过HashMap实现的，HashSet的部分源码：

    ```java
    public class HashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, java.io.Serializable{
        static final long serialVersionUID = -5024744406713321676L;
    	
        //底层使用HashMap来实现
        private transient HashMap<E,Object> map;
    
        //定义一个虚拟的Object对象作为HashMap的value值
        private static final Object PRESENT = new Object();
    
    	//初始化一个空的HashMap，并使用默认初始容量16和加载因子0.75
        public HashSet() {
            map = new HashMap<>();
        }
        
        ...
            
    }
    ```

    HashSet的底层是通过HashMap实现的，只是对于HashMap来说每个key有自己对应的value，而在HashSet中之关系key，所以所有的key都使用相同的value即PRESENT。由于PRESENT被定义为静态的，因此会被所有变量共享，节约空间。

    HashSet是非线程安全的，如果想使用线程安全的Set，可以使用CopyOnWriteArraySet、Collections.synchronizedSet等。

    HashSet不会维护数据插入的顺序，如果想维护插入顺序可以使用LinkedHashSet。

    HashSet不会对数据排序，如果想对数据排序可以使用TreeSet。

  - **LinkedHashSet**

    LinkedHashSet是对HashSet的扩展，可以维护数据插入的顺序，内部通过LinkedHashMap实现。

  - **TreeSet**

    有HashSet的所有特性，而且支持排序，默认使用的是数据的自然顺序，可以在创建TreeSet时指定Comparator来对数据进行排序。

    底层使用TreeMap来存储数据，将数据有序的功能交给了TreeMap。当使用add方法添加一个元素时，如果新增key是唯一会返回null，如果新增key已经存在了会返回对应的value值。

---

### Map

Map用来存储key-value键值对，通过键来查找值，其中key是不能重复的。

- **HashMap**

  - **Java8之前的HashMap**

    在Java8之前，HashMap的底层实现是数组和链表，HashMap的主要成员变量包括：

    ```java
    //存储数据的核心成员变量
    transient Entry<K,V>[] table;
    //键值对数量
    transient int size;
    //加载因子，用于决定table的扩容量
    final float loadFactor;
    ```

    table是HashMap和核心成员变量，该数组用于记录HashMap的所有数据，它的每一个下标都对应一条链表，所有哈希冲突的数组都会被存放到同一条链表中，Entry<K,V>则是该链表的节点元素，包含以下成员变量：

    ```java
    //存放键值对中的key
    final K key;
    //存放键值对中的value
    V value;
    //指向下一个节点的引用
    Entry<K,V> next;
    //key对应的hashCode
    int hash;
    ```

    HashMap的核心实现是一个单向链表数组，所有方法都是通过操作该数组来完成的，HashMap规定了该数组的两个特性：

    - 在特定的时刻，根据需要来扩容。
    - 长度始终保持为2的幂次方。

    在HashMap中，数据都是以键值对的形式存在的，键值所对应的hashCode将会作为其在数组里的下标，如果两个元素key的hashCode一样，就会被放到同一个下标中的相同链表上，为了使HashMap的查询效率尽可能高，要使键值的hashCode尽可能分散。

    **HashMap的常量：**

    ```java
    //默认的初始化容量，必须为2的幂次方
    static final DEFAULT_INITIAL_CAPACITY=16;
    //最大容量，在构造器指定HashMap容量时做比较
    static final int MAXIMUM_CAPACITY=1<<30;
    //默认加载因子，如果没有指定就会使用该常量
    static final DEFAULT_LOAD_FACTOR=0.75f;
    ```

    **put方法：**

    ```java
    public V put(K key, V value) {
        if (table == EMPTY_TABLE) {
            inflateTable(threshold);
        }
        if (key == null)//如果关键字为null，就存入table[0]
        	return putForNullKey(value); 
        int hash = hash(key);//关键字不为null，就计算key的hash值
        int i = indexFor(hash, table.length);//根据hash值和table的长度来计算下标
        for (Entry<K,V> e = table[i]; e != null; e = e.next) {//存入table[i]
            Object k;
            //如果key已经存在，就更新其value值然后返回旧的value值
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;
      	     }
        }
        //如果key不存在，将集合修改值加1，然后添加节点
        modCount++;
        addEntry(hash, key, value, i);
        return null;
    }
    ```

    **计算键值的hash方法：**

    ```java
    final int hash(Object k) {
        int h = hashSeed;
        if (0 != h && k instanceof String) {
            return sun.misc.Hashing.stringHash32((String) k);
        }
        h ^= k.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
    ```

    当处理String类型的数据时，直接调用对应方法来获取最终的hash值。

    当处理其他类型数据时，提供一个相对于HashMap事例唯一不变的随机值hashSeed作为计算的初始量。

    执行的异或和无符号右移操作是为了使hash值更加离散，减小哈希冲突。

    **计算元素下标的indexFor方法：**

    ```java
    static int indexFor(int h,int length){
    	return h&(length-1);
    }
    ```

    h是目标key的hash值，要根据该值计算下标，和数组的长度-1进行与操作可以保证计算后的index不会超过table的长度范围。

    使用addEntry添加键值对时，如果键值对将要占用的位置不是null，并且size>threshold，那么就会调用扩容方法`resize(2*table.length)`将长度扩大为原来的2倍，扩容之后会重新计算hash值和下标。

    **扩容的resize方法：**

    据新的容量newCapacity来确定新的扩容阈值threshold

    ```java
    void resize(int newCapacity) {
        Entry[] oldTable = table;
        int oldCapacity = oldTable.length;
        //如果当前容量已经达到了最大容量，就将阈值设置为Integer的最大值
        if (oldCapacity == MAXIMUM_CAPACITY) {
            //当阈值被设置为Integer最大值后，扩容就不会再触发
            threshold = Integer.MAX_VALUE;
            return;
        }
        //否则用新计算的容量×加载因子，和最大容量+1进行比较，取较小值作为新的扩容阈值
        Entry[] newTable = new Entry[newCapacity];
        //使用transfer方法重写计算当前节点转移到新数组后的下标
        transfer(newTable, initHashSeedAsNeeded(newCapacity));
        table = newTable;
        threshold = (int)Math.min(newCapacity * loadFactor, MAXIMUM_CAPACITY + 1);
    }
    ```

    **重新计算下标的transfer方法：**

    ```java
    void transfer(Entry[] newTable, boolean rehash) {
        int newCapacity = newTable.length;
        //遍历所有键值对，根据键的hash值和新的数组长度重新确定下标
        for (Entry<K,V> e : table) {
            while(null != e) {
                Entry<K,V> next = e.next;
                //判断是否需要哈希重构，如果key值不为null则重写计算hash值
                if (rehash) {
                    e.hash = null == e.key ? 0 : hash(e.key);
                }
                int i = indexFor(e.hash, newCapacity);
                e.next = newTable[i];
                newTable[i] = e;
                e = next;
            }
        }
    }
    ```

    **get方法：**

    ```java
    public V get(Object key) {
        	//key为null就返回table[0]的数据
            if (key == null)
                return getForNullKey();
        	//根据key值找到对应节点，找到就返回value，否则返回null
            Entry<K,V> entry = getEntry(key);
            return null == entry ? null : entry.getValue();
    }
    
    //key为null的get方法
    private V getForNullKey() {
        if (size == 0) {//size为0代表链表为空，返回null
            return null;
        }
        //遍历table[0]的链表，如果key为null返回对应value值
        for (Entry<K,V> e = table[0]; e != null; e = e.next) {
            if (e.key == null)
                return e.value;
        }
        //没有找到，返回null
        return null;
    }
    
    //根据key的hash值获取value的get方法
    final Entry<K,V> getEntry(Object key) {
        if (size == 0) //size为0表示链表为空，返回null
            return null;
        //key不为null提供hash方法计算hash值，否则hash值为0
    	int hash = (key == null) ? 0 : hash(key);
        //遍历该下标下链表的所有节点
    	for (Entry<K,V> e = table[indexFor(hash, table.length)];e != null;e = e.next){
        	Object k;
            //如果hash值和key值都相同，找到了对应元素，返回其value值
        	if (e.hash==hash&&((k=e.key)== key||(key != null && key.equals(k))))
            return e;
    	}
    	return null;//没有找到就返回null值
    }
    ```

    **性能优化：**

    HashMap执行写操作（put）时，比较消耗资源的是遍历链表，扩容数组；HashMap执行读操作（get）时，比较消耗资源的是遍历链表。

    影响遍历链表的因素是链表的长度，在HashMap中，链表的长度由哈希冲突的频率决定。哈希冲突的频率又受数组长度决定，长度越长则冲突概率越小，但同时闲置的内存空间也越多。所以需要在时间和空间取得一个平衡点。哈希冲突的概率也受key的hash值影响，所以计算的hash值越离散，冲突概率越低。链表遍历中需要调用key值得equals方法，不合理的equals方法会导致HashMap效率低下甚至异常。

    因此提高HashMap的效率可以从以下方面入手：

    - 根据业务需求测试出合理的加载因子，否则使用默认的0.75。
    - 合理重写键值对象的equals方法和hashCode方法。

  - **Java8之后的HashMap**

    Java8的HashMap数据结构发生了较大的变化，之前的HashMap使用的是数组+链表的形式，新的HashMap使用的是数组+链表/红黑树的形式，虽然使用的依旧是table数组，但数据类型发生了变化，代表节点的Entry换成了Node：

    ```java
    static class Node<K,V> implements Map.Entry<K,V> {
    	final int hash;//hash值
    	final K key;//key值
    	V value;//value值
    	Node<K,V> next;//下一个Node节点的引用
    	...
    }
    ```

    **put方法：**

    ```java
    //调用putvalue方法
    public V put(K key, V value) {
        //通过hash方法计算出key的hash值，作为参数传递
    	return putVal(hash(key), key, value, false, true);
    }
    
    //根据key的hash值存放元素
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,boolean evict) {
        Node<K,V>[] tab; 
        Node<K,V> p; 
        int n, i;
        //如果table为空或没有元素时就进行扩容
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        //元素下标位置依旧通过hash和数组长度-1进行与操作得出，如果不存在就新创建一个节点
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            //如果首节点和待插入元素得hash值和key值都一样，记录下来
            if (p.hash==hash&&((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            //如果首节点是红黑树类型，使用putTreeVal方法增加一个树节点
            else if (p instanceof TreeNode)
                //每一次都比较插入节点和当前节点的大小，待插入节点小就往左子树查找，否则往右子树查找，找到空位后执行两个方法：1 balanceInsert方法，平衡插入，一方面把节点插入红黑树，一方面对红黑树进行调整使之平衡。2 moveRootToFront，由于红黑树调整平衡后root节点可能变化，table里记录的节点不再是根节点，需要重置。
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                //如果是链表节点，就遍历链表，根据hash值和key判断是否重复，决定是更新值还是新增节点
                for (int binCount = 0; ; ++binCount) {
                    //遍历到了链表末尾，添加链表元素
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        //如果达到了建树阈值，把链表重构位红黑树
                        if (binCount >= TREEIFY_THRESHOLD - 1) 
                            treeifyBin(tab, hash);
                        break;
                    }
                    //找到了和待插入元素相同key值的元素，记录下类并退出
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            //说明待插入元素已在HashMap中，更新其value值就可以
            if (e != null) { 
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;//修改次数增加1
        //如果节点数+1大于阈值，就要进行扩容
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
    ```

    **计算hash值的方法：**

    Java8也进行了哈希分散，但是计算过程简单了许多，如果key非空就将key的hashCode值的高低16位进行异或操作，这主要是为了让尽可能多的位参与运算，让结果中的0和1分布得更加均匀，从而降低哈希冲突的概率。

    ```java
    static final int hash(Object key) {
    	int h;
    	return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    ```

    **resize方法：**

    重新规划长度和阈值，如果长度发生了变化，部分数据节点也要重新排列。

    - **重新规划长度**

      如果size超出扩容阈值，进行扩容，把table的容量增加为之前的2倍。

      如果新的table容量小于默认的初始化容量16，那么将table容量重置为16。

      如果新的table容量大于等于最大容量，那么将阈值设为Integer的最大值，并且return终止resize过程，由于size不可能超过Integer最大值因此之后不会再发生扩容。

    - **重新排列数据节点**

      如果节点为null，则不进行处理。

      如果节点不为null且没有next节点，那么重新计算其hash值然后存入新的table中。

      如果节点为树节点，那么调用树节点的split方法进行处理，该方法用于对红黑树调整，如果太小会退化回链表。

      如果节点是链表节点，需要将链表拆分为hashCode超出旧容量的链表和未超出容量的链表。对于	`hash&oldCap==0`的部分不需要做处理，反之需要放到新的下标位置上，新下标=旧下标+旧容量。

- **LinkedHashMap**

  - **Java8之前的LinkedHashMap**

    存储结构是数组+链表，并维护了一个环形链表来实现有序访问的目的，该链表的表头header既是头又是尾，但它本身只是一个标记，不包含数据域。

    LinkedHashMap中的createEntry方法除了创建Hash桶中的链表节点，还需要把该链表的引用插入环形链表中。

  - **Java8之后的LinkedHashMap**

    有3个关键的成员变量：

    ```java
    //双向链表的表头，最旧的节点
    transient LinkedHashMap.Entry<K,V> head;
    //双向链表的表尾，最新的节点
    transient LinkedHashMap.Entry<K,V> tail;
    //迭代顺序，true表示顺序，false表示逆序
    final boolean accessOrder;
    ```

    存储结构是数组+链表/红黑树，并维护了一个双向链表实现有序访问。

    newNode方法和newTreeNode方法继承自HashMap，LinkedHashMap重写了这两个方法，负责在创建节点的同时将其插入双向链表，实现了保存数据节点副本到双向链表的功能。

- **TreeMap**

  TreeMap是完全由红黑树实现的。

  **有四个构造器：**

  ```java
   //无参构造器，初始化比较器为null
   public TreeMap()
   //使用外部传入的比较器作为TreeMap的比较器
   public TreeMap(Comparator<? super K> comparator)
   //使用外部传入的Map初始化TreeMap
   public TreeMap(Map<? extends K, ? extends V> m)
   //使用外部传入的SortedMap初始化TreeMap，并且用其比较器初始化TreeMap比较器
   public TreeMap(SortedMap<K, ? extends V> m)
  ```

  **put方法原理：**

  - 如果TreeMap为空，那么使用指定数据作为根节点。
  - TreeMap非空，使用比较器来决定插入位置，如果比较器为空，那么默认key实现了Comparable接口，调用其compareTo方法来决定插入位置，如果没有实现该接口会抛出类型转换异常。
  - 插入完成后调整红黑树的平衡。

- **HashTable**

  HashTable的实现和HashMap很类似，方法被synchronized修饰，是线程安全的，但是效率很低。此外，HashTable中不能存放键值为null的元素。
  
- **补充：红黑树**

  红黑树是一种自平衡的二叉查找树。

  - **特性**

    - 红黑树的每个节点只能是红色或者黑色。
    - 根节点是黑色的。
    - 每个叶子节点都是黑色的。
    - 如果一个叶子节点是红色的，它的子结点必须是黑色的。
    - 从一个节点到该节点的叶子节点的所有路径都包含相同数目的黑色节点。

  - **左旋和右旋**

    - **左旋：**对a节点进行左旋，指将a节点的右节点作为a的父节点，即将a变成一个左节点，因此左旋意味着被旋转的节点变成一个左节点。
    - **右旋：**对a节点进行右旋，指将a节点的左节点作为a的父节点，即将a变成一个右节点，因此右旋意味着被旋转的节点变成一个右节点。

  - **添加**

    红黑树的添加分为3步：①将红黑树看作一颗二叉查找树，并以二叉树的插入规则插入新节点。②将插入的节点设为红色或黑色。③通过左旋、右旋或变色，使之重新成为一棵红黑树。

    根据被插入节点的父节点情况，可以将插入分为3种情况处理：

    - 被插入的节点是根节点，直接将其涂为黑色。
    - 被插入节点的父节点是黑色的，不做处理，节点插入后仍是红黑树。
    - 被插入节点的父节点是红色的，一定存在非空祖父节点，进一步分为三种情况处理：
      - 叔叔节点是红色的，将父节点设为黑色，叔叔节点设为黑色，祖父节点设为红色，将祖父节点作为当前节点。
      - 叔叔节点是黑色的且当前节点是右节点，则将父节点设为当前节点，以新节点为支点左旋。
      - 叔叔节点是黑色的且当前节点是左节点，则将父节点设为黑色，祖父节点设为红色，以祖父节点为支点右旋。

  - **删除**

    红黑树的添加分为3步：①将红黑树看作一颗二叉查找树，并以二叉树的删除规则删除新节点。②通过左旋、右旋或变色，使之重新成为一棵红黑树。

    根据被删除节点的情况，可以将删除分为3种情况处理：

    - 被删除的节点没有子节点，直接将其删除。
    - 被删除节点只有一个子节点，直接删除该节点，并用其唯一子节点替换其位置。
    - 被插入节点有两个子节点，先找出该节点的替换节点，然后把替换节点的数值复制给该节点，删除替换节点。

    通过左旋、右旋或变色使其重新成为红黑树。如果当前节点的子节点是一红一黑，直接将该节点设为黑色。如果当前节点的子结点都是黑色，且当前节点是根节点，则不做处理。如果当前节点的子节点都是黑色且当前节点不是根节点，分为以下几种情况：

    - 当前节点的兄弟节点是红色的，就将当前节点的兄弟节点设为黑色，将父节点设为红色，对父节点左旋，重新设置当前节点的兄弟节点。
    - 当前节点的兄弟节点是黑色的，兄弟节点的两个子节点也都是黑色的，则将当前节点的兄弟节点设为红色，将当前节点的父节点作为新节点。
    - 当前节点的兄弟节点是黑色的，兄弟节点的左节点是红色右节点是黑色，将当前节点的左子结点设为黑色，将兄弟节点设为红色，对兄弟节点右旋、重新设置兄弟节点。
    - 当前节点的兄弟节点是黑色的，兄弟节点的右节点是红色的，将当前节点的父节点赋给兄弟节点，将父节点设为黑色，将兄弟节点的右子节点设为黑色，对父节点左旋，设置当前节点为根节点。

---

## IO

IO是input和output的缩写，在Java中通常表达的是数据的流入和流出。

流是指数据的无结构化传递，以无结构的字节序列或者字符序列进行输入和输出。IO流即是进行输入和输出操作的流。

字节流以一个字节（8bit）为最小操作单位，字符流的最小操作单位是一个字符，字符即是字节加上编码表，单字符占用1到多个字节。

---

### 同步与异步、阻塞与非阻塞

**在多线程语境下的概念**

在多线程语境下，用于描述任务的线程访问执行机制，同步和异步关注的是任务能否可以被同时调用，阻塞和非阻塞则关注的是线程的状态。

- 同步：指代码的同步执行，一个执行块同一时间只有一个线程可以访问。
- 异步：指代码的异步执行，多个执行块可以同时被多个线程访问。
- 阻塞：线程处于阻塞状态，表示线程挂起。
- 非阻塞：线程处于非阻塞状态，表示线程没有被挂起。

**在IO语境下的概念**

在IO语境下，用于描述IO的操作，同步和异步关注的是消息发起和接收的机制，阻塞和非阻塞则表达发起者等待结果时的状态。

- 同步：是指发起一个IO操作时，在没有得到结果之前，该操作不返回结果，只有调用结束后才能获取返回值并继续执行后续的操作。
- 异步：是指发起一个IO操作后，不会得到返回，结果由发起者自己轮询，或者IO操作的执行者发起回调。
- 阻塞：是指发起者在发起IO操作后，不能再处理其他业务。
- 非阻塞：是指发起者不会等待IO操作完成。

---

### IO常见问题

- **File对象表示的是什么、File类有哪些常用方法**
  - File对象表示的是操作系统上的文件或目录。
  - 获取：getAbsolutePath() 获取绝对路径；getPath() 获取文件定义时使用的路径；getName() 获取文件名，带后缀；length() 返回文件长度，单位是字节。
  - 判断：exists() 判断File对象表示的文件或目录是否存在；isDirectory() 判断是否是目录； isFile() 判断是否是文件。
  - 创建和删除：createNewFile() 不存在时创建新文件；delete() 删除文件，目录（非空目录不能删除）；mkdir() 创建一级目录；mkdirs() 创建多级目录，推荐使用；
  - 遍历：list 获取当前目录下所有一级文件名称到一个字符串数组并返回；listFiles 获取当前目录下所有一级File对象到File数组返回。

- **英文、数字和中文字符在文件中分别占多大的空间**
  - 英文和数字在任何编码中都占1个字节。
  - 中文字符在GBK编码下占2个字节，在UTF-8编码下占3个字节。

- **传统IO的分类**
  - **按流的方向**
    - 输出流：把内存中的数据写出到磁盘文件或网络介质中。
    - 输入流：把磁盘文件或网络介质中的数据读取到内存中。
  - **按流的内容**
    - 字节流：流中数据的最小单位是字节。
    - 字符流：流中数据的最小单位是字符（针对文本内容）。顶层的抽象类包括InputStream、OutputStream、Reader、Writer，它们都实现了Closeable接口。
    - 缓冲流（BufferedInputStream/BufferedOutputStream/BufferedReader/BufferedWriter）：自带一个8KB大小的缓冲池，可以将字节/字符流为缓冲字节/缓冲字符流。
    - 字符转换流（InputStreamReader/OutputStreamWriter）：可以将对应的字节流转换为字符流。
    - 打印流：PrintStream，方便快速打印数据，参数是什么就打印什么。

- **BIO、NIO、AIO的区别和原理**
  - BIO是同步阻塞的，数据的读写会阻塞在一个线程中，适用于连接数目比较小且固定的架构，对服务器资源要求高，JDK1.4前的唯一选择。
  - NIO是同步非阻塞的，通过Selector监听Channel上事件的变化，在Channel上有数据发生变化时通知该线程进行读写操作。适用于连接数目比较多且连接比较短的架构，如聊天服务器，从 JDK1.4开始支持。
  - AIO是异步非阻塞的，异步是指服务端线程接收到客户端管道后就交给底层处理IO通信，自己可以做其他事情。适用于连接数目比较多且连接比较长的架构，从JDK1.7开始支持。

- **序列化和反序列化**
  - Java在JVM运行时被创建、更新和消耗，当JVM退出时，对象也会随之销毁。可以通过Java序列化实现持久化存储，保存对象及其状态信息到字节数组中。
  - 反序列化就是再将字节数组中存储的信息转换回Java对象。
  - 序列化和反序列化要求类必须实现序列化接口，并且序列化和反序列化必须保持序列化的ID一致。
  - 静态变量和被transient修饰的变量不会被序列化。

---

# 并发

## 引入

### 线程上下文切换

- **线程数量和程序执行速度的关系**

  并发编程的目的是为了让程序运行得更快，但是并不是启动得线程越多就能让程序最大限度地并发执行。在并发编程时，如果希望通过多线程执行任务让程序运行得更快会面临很多挑战，比如上下文切换的问题、死锁的问题，以及受限于硬件和软件的资源限制问题。

- **多线程并发的实现**

  即使是单核处理器也支持多线程执行代码，CPU通过给每个线程分配CPU时间片来实现这个机制。时间片是CPU分配给各个线程的时间，因为时间片非常短（一般是几十毫秒），所以CPU通过不停地切换线程执行，让我们感觉多个线程是同时执行的。

- **上下文切换的概念**

  CPU是通过时间片分配算法来循环执行任务，当前任务执行一个时间片后会切换到下一个任务。但是在切换前会保存上一个任务的状态，以便下次再切换回这个任务时可以再加载这个任务的状态。所以任务从保存到再加载的过程就是一次上下文切换。

- **减少上下文切换的方法**

  - 无锁并发编程：多线程竞争锁时会引起上下文切换，所以多线程处理数据时，可以通过一些方法来避免使用锁，例如将数据的id按照hash算法取模分段，不同的线程处理不同数据段的数据。

  - CAS算法：Java的atomic包使用CAS算法来更新数据而不需要加锁。

  - 使用最少线程：避免创建不需要的线程，比如任务很少，但是创建了很多线程来处理，这样会造成大量线程都处于等待状态。

  - 协程：在单线程里实现多任务的调度，并在单线程里维持多个任务间的切换。

- **多线程避免死锁的方法**
  - 避免一个线程同时获得多个锁。
  - 避免一个线程在锁内同时占用多个资源，尽量保证每个锁只占用一个资源。
  - 尝试使用定时锁，使用lock.tryLock(timeout)来替代使用内部锁机制。
  - 对于数据库锁，加锁和解锁必须在一个数据库连接里，否则会出现解锁失败的问题。

---



## JMM

### **定义**

JMM的设计是为了屏蔽各种硬件和操作系统的内存方法差异，以实现Java程序在各种平台下都能达到一直的内存访问效果。在此之前的主流程序语言，例如C、C++等直接使用物理硬件和操作系统的内存模型，因此不同平台上内存模型的差异可能导致程序在一套平台上并发正常运行，而在另一套平台经常出错。

JMM必须定义得足够严谨，才能让Java的并发内存访问操作不会产生歧义；但又必须定义得足够宽松，使得虚拟机的实现能有足够的自由空间去利用硬件的各种特性来获取更好的执行执行速度。直到JDK5，即实现了JSR-133之后，Java内存模型才算成熟完善了起来。

---

### **主内存与工作内存**

Java内存模型的主要目的是定义程序中各种变量的访问规则，即关注在虚拟机中把变量值存储到内存和从内存中取出变量值这样的底层细节。此处的变量和Java语言中的变量有所区别，它包括了实例字段、静态字段和构成数组对象的元素，但是不包括局部变量与方法参数，因为局部变量和方法参数是线程私有的，不会被共享，也就自然不存在竞争问题。为了获得更好的执行效率，Java内存模型没有限制执行引擎使用处理器的特定寄存器或缓存来和主内存进行交互，也没有限制即时编译器是否要进行调整代码执行顺序这类优化措施。

Java内存模型规定了所有变量都存储在主内存中，每条线程还有自己的工作内存，线程的工作内存中保存了被该线程使用的变量的主内存副本，线程对变量的所有操作都必须在工作空间中进行，而不能直接读写主内存中的数据。不同的线程之间也无法直接访问对方工作内存中的变量，线程间变量值的传递均需要通过主内存来完成。

- **内存间的交互操作**

  关于主内存与工作内存之间的交互协议，即一个变量如何从主内存拷贝到工作内存、如何从工作内存同步回主内存这一类的实现细节，Java内存模型定义了以下8种操作来完成。Java虚拟机实现时必须保证这些操作是原子性的、不可再分的（对于double和long类型的变量来说，load、store、read和write操作在某些平台有例外）。

  - **lock（锁定）：**作用于主内存的变量，它把一个变量标识为一条线程独占的状态。
  - **unlock（解锁）：**作用于主内存的变量，它把一个处于锁定状态的变量释放出来，释放后的变量才能被其他线程锁定。
  - **read（读取）：**作用于主内存的变量，它把一个变量的值从主内存传输到线程的工作内存中，以便随后的load操作使用。
  - **load（载入）：**作用于工作内存的变量，它把read操作从主存中得到的变量值放入工作内存的变量副本中。
  - **use（使用）：**作用于工作内存的变量，它把工作内存中一个变量的值传递给执行引擎，每当虚拟机遇到一个需要使用变量的值的字节码执行时会执行这个操作。
  - **assign（赋值）：**作用于工作内存的变量，它把一个从执行引擎接收的值赋给工作内存的变量，每当虚拟机遇到一个给变量赋值的字节码指令时执行这个操作。
  - **store（存储）：**作用于工作内存的变量，它把工作内存中一个变量的值传送到主内存中，以便随后的write操作使用。
  - **write（写入）：**作用于主内存的变量，它把store操作从工作内存取到的变量值放入主内存的变量中。

  如果要把一个变量从主内存拷贝到工作内存，那就要按顺序执行read和load操作，如果要把变量从工作内存同步回主内存，就要按顺序执行store和write操作。注意Java内存模型只要求这两种操作必须按顺序执行，但不要求是连续执行，也就是说read与load之间、store和write之间是可插入其他指令的，如对主内存的变量a、b进行访问时，一种可能的顺序是read a、read b、load b、load a。

  除了这8种操作外，Java内存模型还规定了必须满足的一些规则：

  - 不允许read和load、store和write操作之一单独出现，即不允许一个变量从主存读取出来了但工作内存不接受，或者工作内存发起了回写但主内存不接受的情况。
  - 不允许一个线程丢弃它最近的assign操作，即变量在工作内存中改变了之后必须把该变化同步回主内存。
  - 不允许一个线程在没有发生过任何assign操作的情况下把数据从线程的工作内存同步回主内存。
  - 一个新的变量只能在主内存中诞生，但不允许在工作内存中直接使用一个未被初始化（load和assign）的变量，即对一个变量实施use或store操作之前，必须先执行assign和load。
  - 一个变量在同一个时刻只允许一条线程对其进行lock操作，但lock操作可以被同一条线程重复执行多次，多次执行lock后，只有执行相同次数的unlock操作，变量才会被解锁。
  - 如果对一个变量执行lock操作，将会清空工作内存中此变量的值，在执行引擎使用这个变量前，需要重新执行load或assign操作以初始化变量的值。
  - 如果一个变量事先没有被lock操作锁定就不允许对其执行unlock操作，也不允许去unlock一个被其他线程锁定的变量。
  - 对一个变量执行unlock操作之前，必须先把此变量同步回主内存（执行store和write操作）。

  这8种内存访问的操作和这些规则，加上针对volatile的一些特殊规定，就能准确地描述出Java程序中哪些内存访问操作在并发下才是安全的。这种定义十分严谨但是过于复杂，之后Java将内存操作简化为lock、unlock、read和write四种，但这只是语言描述上的等价化简，Java内存模型的基础设计并未改变。

---

### 针对volatile的特殊规则

- **作用：**

  关键字volatile是Java虚拟机提供的最轻量级的同步机制，Java内存模型为volatile定义了一些特殊的访问规则。当一个变量被定义为volatile之后，它具备两种特性：
  - **保证此变量对所有线程的可见性**

    可见性是指当一条线程修改了这个变量的值，新值对于其他线程来说是立即可以得知的。而普通变量并不能做到这一点，普通变量的值在线程间传递时均需要通过主内存来完成。

    volatile变量在各个线程的工作内存中不存在一致性问题（从物理存储的角度看，各个线程的工作内存中volatile变量也可以存在不一致的情况，但是由于每次使用前都要刷新，执行引擎看不到不一致的情况，因此可以认为不存在一致性问题），但是Java中的运算操作符并非原子操作，这导致volatile变量的运算在并发下仍是不安全的。

    - **静态变量i执行多线程i++的不安全问题**

      通过反编译会发现一个自增语句是由4条字节码指令构成的，按顺序依次为getstatic、iconst_1、iadd、putstatic，当getstatic把i的值取到操作栈顶时，volatile关键字保证了i的值在此刻是正确的，但是在执行iconst_1、iadd这些指令时，其他线程可能已经改变了i的值，而操作栈顶的值就变成了过期的数据，所以putstatic指令执行后就可能把较小的i值同步回了主内存之中。 

    注意：即使编译出来只有一条字节码指令也不能意味着这条指令就是一个原子操作，一条字节码指令在解释执行时，解释器要运行很多行代码才能实现它的语义。如果是编译执行，一条字节码指令也可能转化成若干条本地机器码指令。

    ​	由于volatile变量只能保证可见性，在不符合以下两条规则的运算场景中，仍然需要使用锁（synchronized、juc中的锁或原子类）来保证原子性：

    - 运算结果并不依赖变量的当前值，或者能够确保只有单一的线程修改变量的值。
    - 变量不需要与其他状态变量共同参与不变约束。

  - **禁止指令重排序优化**

  普通的变量仅会保证在该方法的执行过程中所有依赖赋值结果的地方都能获取到正确的结果，而不能保证变量赋值操作的顺序与程序代码中的执行顺序一致。在同一个线程的方法执行过程中无法感知到实际顺序与代码顺序的不同，这就是Java内存模型中描述的”线程内as-if-serial语义“。

  使用volatile的变量进行写操作，汇编指令操作是带有lock前缀的，这个操作的作用相当于一个内存屏障，后面的指令不能重排到内存屏障之前的位置。只有一个处理器时不需要使用内存屏障，但如果有两个或更多的处理器访问同一块内存，且其中有一个在观测另一个，就需要使用内存屏障来保证一致性了。

  使用lock前缀的指令在多核处理器中会引发两件事：

  - 将当前处理器缓存行的数据写回到系统内存
  - 这个写回内存的操作会使其他在CPU里缓存了该内存地址的数据无效。

  这种操作相当于对缓存中的变量做了一次store和write操作，可以让volatile变量的修改对其他处理器立即可见。

- **volatile的内存语义**

  从JSR-133开始，volatile变量的写-读可以实现线程之间的通信。从内存语义的角度来说，volatile的写-读与锁的释放-获取具有相同的内存效果。

  - **volatile写的内存语义：**当写一个volatile变量时，JMM会把该线程对应的本地内存中的共享变量值刷新到主内存。

  - **volatile读的内存语义：**当读一个volatile变量时，JMM会把该线程对应的本地内存置为无效，线程接下来将从主内存中读取共享变量。

  线程A写一个volatile变量，实质上是线程A向接下来要读这个volatile变量的某个线程发出了（其对共享变量所修改的）消息。线程B读一个volatile变量，实质上是线程B接收了之前某个线程发出的（在写这个volatile变量之前对共享变量所做修改的）消息。线程A写一个volatile变量，线程B读一个volatile变量，实质上是线程A通过主内存向线程B发送消息。

- **volatile指令重排序的特点**

  - 当第二个操作是volatile写时，不管第一个操作是什么都不能重排序，这个规则确保volatile写之前的操作不会被编译器重排序到volatile写之后。
- 当第一个操作是volatile读时，不管第二个操作是什么都不能重排序，这个规则确保volatile读之后的操作不会被编译器重排序到volatile读之前。
  
- 当第一个操作是volatile写，第二个操作是volatile读时不能重排序。
  
- **volatile的内存屏障插入策略**

  - 在每个volatile写操作之前插入一个Store Store屏障,禁止之前的普通写和之后的volatile写重排序。

  - 在每个volatile写操作之后插入一个Store Load屏障，防止之前的volatile写与之后可能有的volatile读/写重排序，也可以在每个volatile变量读之前插入该屏障，考虑到一般是读多于写所以选择用这种方式提升执行效率，也可以看出JMM在实现上的一个特点：首先确保正确性，然后再去追求效率。

  - 在每个volatile读操作之后插入一个Load Load屏障，禁止之后的普通读操作和之前的volatile读重排序。

  - 在每个volatile读操作之后插入一个Load Store屏障，禁止之后的普通写操作和之前的volatile读重排序。

- **关于volatile的优化**

  可以通过追加字节的方式优化性能，例如JDK7中的队列集合类LinkedTransferQueue就是使用了追加字节的方式来优化队列出队和入队的性能。由于一些处理器的高速缓存行是64个字节宽，不支持部分填充缓存行，如果队列的头节点和尾节点都不足64字节，当一个处理器试图修改头节点时就会将整个缓存行锁定，那么在缓存一致性的作用下会导致其他处理器不能访问自己高速缓存中的尾节点，而队列的入队和出队又会频繁修改头节点和尾节点，因此多处理器情况下会严重影响队列的入队和出队效率。追加到64字节后就可以填满高速缓冲区的缓存行，避免头节点和尾节点加载到同一个缓存行，使它们的操作不会互相锁定。	

  但以下两种场景不应该使用这种方式：①缓存行非64字节宽的处理器。②共享变量不会被频繁地写，因为使用追加字节的方式需要处理器读取更多的字节到高速缓冲区，这本身就会带来一定性能消耗。如果共享变量不被频繁写，锁的几率很小没有必要避免互相锁定。不过这种追加字节的方式在Java7可能不生效，因为Java7可以淘汰或重新排列无用字段，需要使用其他追加字节的方式。

- **JSR-133增强volatile语义的原因**

  在旧的内存模型中，虽然不允许volatile变量之间重排序，但允许volatile变量与普通变量重排序，可能导致内存不可见问题。在旧的内存模型中volatile的写-读没有锁的释放-获取所具有的内存语义，为了提供一种比锁更轻量级的线程通信机制，严格限制了编译器和处理器对volatile变量与普通变量的重排序，确保volatile的写-读和锁的释放-获取具有相同的内存语义。只要volatile变量与普通变量之间的重排序可能会破坏volatile的内存语义这种重排序就会被编译器重排序规则和处理器内存屏障插入策略禁止。

- 关于指令重排序的补充

  - **指令重排序的概念**

    重排序指从源代码到指令序列的重排序，在执行程序时为了提高性能，编译器和处理器通常会对指令进行重排序，重排序分为三种类型：

    - 编译器优化的重排序：编译器在不改变单线程程序语义的前提下可以重新安排语句的执行顺序。

    - 指令级并行的重排序：现代处理器才以来指令级并行技术ILP来将多条指令重叠执行，如果不存在数据依赖性，处理器可以改变语句对应机器指令的执行顺序。

    - 内存系统的重排序：由于处理器使用缓存和读/写缓冲区，这使得加载和存储操作操作看上去可能是乱序执行。

  - **指令重排序的问题**

    从Java源代码到最终实际执行的指令序列，会分别经历编译器优化重排序、指令级并行重排序和内存系统重排序，这些重排序可能会导致多线程程序出现内存可见性问题。

    - 对于编译器，JMM的编译器重排序规则会禁止特定类型的编译器重排序。对于处理器重排序，JMM的处理器重排序规则会要求Java编译器在生成指令序列时，插入特定类型的内存屏障指令（一组用于实现对内存操作顺序限制的处理器指令），通过内存屏障指令来禁止特定类型的处理器重排序。

    JMM属于语言级的内存模型，它确保在不同的编译器和不同的处理器平台之上，通过禁止特定类型的编译器重排序和处理器重排序，为程序员提供一致的可见性内存保证。

---

### 针对long和double类型变量的特殊规则

Java内存模型要求lock、unlock、read、load、assign、use、store、write这八种操作都具有原子性，但是对于64位的数据类型（long和double），在模型中定义了一条宽松的规定：允许虚拟机将没有被volatile修饰的64位数据的读写操作划分为两次32位的操作来进行，即允许虚拟机实现自行选择是否要保证64位数据类型的load、store、read和write四个操作的原子性，这就是”long和double的非原子性协定“。

如果有多个线程共享一个未声明为volatile的long或double类型变量，并且同时对它们进行读取和修改操作，那么某些线程可能会读取到一个既不是原值，也不是其他线程修改值的代表了”半个变量“的数值。这种情况很罕见，但带对于一些32位的Java虚拟机确实存在非原子性访问的风险。

---

### 原子性、可见性和有序性

- **原子性**

  由Java内存模型直接保证的原子性变量操作包括read、load、assign、use、store和write这六个，基本数据类型的访问读写都是具备原子性的（例外就是long和double的非原子性协定）。

  如果应用场景需要一个更大范围的原子性保证，Java内存模型还提供了lock和unlock操作来满足需求，尽管虚拟机还没有把lock和unlock开放给用户使用，但却提供了更高层次的字节码指令monitorenter和monitorexit来隐式地使用这两个操作。这两个字节码指令反映到Java代码中就是同步块synchronized关键字，因此synchronized具有原子性。

  - **原子操作**

    原子操作即不可被中断的一个或一系列操作，处理器提供总线锁定和缓存锁定两个机制来保证复杂内存操作的原子性。

    - 通过总线锁定保证原子性：如果多个处理器同时对共享变量进行读改写操作（例如i++），那么共享变量就会被多个处理器同时进行操作，这样读改写操作就不是原子性的，操作完之后共享变量的值会和期望的不一样。例如i=1，进行两次i++操作，但是结果可能为2。这是因为多个处理器同时从各自的缓存读取变量i，分别进行加1操作，然后分别写入系统内存中。如果想要保证读改写操作的原子性，就必须保证CPU1读改写共享变量时CPU2不能操作缓存了该共享变量内存地址的缓存。处理器使用总线锁来解决这个问题，总线锁就是使用处理器提供的一个LOCK#信号，当一个处理器在总线上输出此信号时，其他处理器的请求将被阻塞，该处理器就可以独占共享内存。

    - 通过缓存锁定来保证原子性：同一时刻只需要保存对某个内存地址的访问是原子性即可，但总线锁定把CPU和内存之间的通信锁住了，这使得锁定期间其他处理器不能操作其他内存地址的数据，开销比较大，目前的处理器在某些场合下使用缓存锁定代替总线锁定来进行优化。频繁使用的内存会缓存在处理器的高速缓存里，原子操作就可以直接在处理器内部缓存中进行，并不需要声明总线锁。缓存锁定是指内存区域如果被缓存在处理器的缓存行中并且在Lock操作期间被锁定，那么当它执行锁操作回写内存时，处理器不在总线上声言LOCK#信号，而是修改内部的内存地址，并允许它的缓存一致性机制来保证操作原子性，因为缓存一致性会阻止同时修改由两个以上处理器缓存的内存区域，当其他处理器回写已被锁定的缓存行数据时会使缓存行无效。

  - **Java中的原子操作实现**

    Java中可以通过锁和循环CAS的方式来实现原子操作。

    - 锁机制保证了只有获得锁的线程才能操作锁定的内存区域，JVM内部实现了很多锁，除了偏向锁JVM实现锁的方式都用了循环CAS，即当一个线程想进入同步代码块时使用循环CAS方式获取锁，退出时使用循环CAS释放锁。

    - JVM中的CAS操作利用了处理器提供的交换指令CMPXCHG实现，自旋CAS的基本思路就是循环进行CAS操作直到成功为止。从Java1.5开始JDK的并发包里提供了一些类来支持原子操作，例如AtomicBoolean（用原子方式更新的boolean值），AtomicInteger（用原子方式更新的int值）和AtomicLong（用原子方式更新的long值），这些原子包装类还提供了有用的工具方法，比如以原子的方式将当前值自增1和自减1。

- **可见性**

  可见性就是指当一个线程修改了共享变量的值时，其他线程能够立即得知这个修改。Java内存模型是通过在变量修改后将值同步回主内存，在变量读取前从主内存刷新变量值这种依赖主内存作为传递媒介的方式来实现可见性的，无论是普通变量还是volatile变量都是如此。区别是volatile的特殊规则保证了新值能立即同步到主内存，以及每次使用前立即从主内存刷新，因此volatile保证了多线程操作时变量的可见性。

  除了volatile之外，Java还有两个关键字能实现可见性，分别是synchronized和final。

  - **synchronized：**同步块的可见性是指”对一个变量执行unlock之前，必须先把此变量同步回主内存中（执行store、write操作）。

  - **final：**final的可见性是指被final修饰的字段在构造器中一旦被初始化完成，并且构造器没有把this的引用传递出去（this引用逃逸是一件很危险的事，其他线程有可能通过这个引用访问到初始化了一般的对象），那么在其他线程中就能看见final字段的值。

    - **final域的重排序规则**

      对于final域，编译器和处理器要遵守两个重排序规则：①在构造方法内对一个final域的写入，与随后把这个被构造对象的引用赋值给一个引用变量，这两个操作之间不能重排序。②初次读一个包含final域的对象的引用，与随后初次读这个final域，这两个操作之间不能重排序。 

    - **写final域重排序的实现原理**

      写final域的重排序规则禁止把final域的写重排序到构造方法之外，这个规则的实现包含以下两方面：①JMM禁止编译器把final域的写重排序到构造方法之外。②编译器会在final域的写之后，构造方法的return之前，插入一个Store Store屏障，这个屏障禁止把final域的写重排序到构造方法之外。

      写final域的重排序可以确保在对象引用为任意线程可见之前，对象的final域已经被正确初始化过了，而普通域不具有这个保障。

    - **读final域重排序的实现原理**

      读final域的重排序规则是，在一个线程中，初次读对象引用和初次读该对象包含的final域，JMM禁止处理器重排序这两个操作（仅针对处理器）。编译器会在读final域操作的前面插入一个Load Load屏障。

      初次读对象引用与初次读该对象包含的final域，这两个操作之间存在间接依赖关系。由于编译器遵守间接依赖关系因此编译器不会重排序这两个操作。大多数处理器也会遵守间接依赖，也不会重排序这两个操作。但有少数处理器允许对存在间接依赖关系的操作做重排序（例如alpha处理器），因此该规则就是专门针对这种处理器的。

      读final域的重排序规则可以确保在读一个对象的final域之前，一定会先读包含这个final域的对象的引用。

    - **final域为引用对象时重排序的特点**

      对于引用类型，写final域的重排序规则对编译器和处理器增加了如下约束：在构造方法内对一个final引用的对象的成员域的写入，与随后在构造方法外把这个被构造对象的引用赋值给一个引用变量，这两个操作之间不能重排序。 

    - **final语义在X86处理器的实现原理**

      写final域的重排序规则是要求编译器在final域的写之后，构造方法return之前插入一个Store Store屏障，读final域的重排序规则是要求编译器在读final域的操作前插入一个Load Load屏障。

      由于X86处理器不会对写-写操作重排序，所以写final域需要的Store Store屏障会被省略。同样，由于X86处理器不会对存在间接依赖关系的操作做重排序，所以在X86处理器中读final域需要的Load Load屏障也会被省略掉。也就是说，X86处理器不会对final域的读/写插入任何内存屏障。

    - **JSR133增强final语义的原因**

      在旧的Java内存模型中，一个最严重的缺陷就是线程可能看到final域的值会改变。比如一个线程看到一个int类型final域的值为0（还未初始化之前的默认值），过一段时间之后这个线程再去读这个final域的值会发现值变为1（被某个线程初始化之后的值）。最常见的例子就是旧的Java内存模型中String的值可能会改变。

      为了修复该漏洞，JSR-133通过为final域增加写和读重排序规则，可以为Java程序员提供初始化安全保证：只要对象是正确构造的（被构造对象的引用在构造方法中没有逸出），那么不需要使用同步（指lock和volatile的使用）就可以保证任意线程都能看到这个final域在构造方法中被初始化之后的值。

- **有序性**

  Java内存模型的有序性可以总结为：在本线程内观察所有操作是有序的，在一个线程内观察另一个线程，所有操作都是无序的。前半句是指”线程内的as-if-serial语义“，后半句是指“指令重排序”和”工作内存与主内存同步延迟“现象。

  Java提供了volatile和synchronized两个关键字来保证线程之间操作的有序性，volatile关键字本身就包含了禁止指令重排序的语义，而synchronized则是由”一个变量在同一个时刻只允许一条线程对其进行lock操作“这条规则获得的，这个规则决定了持有同一个锁的两个同步块只能串行地进入。

---

### as-if-serial语义

- **数据依赖性**

  如果两个操作访问同一个变量，且这两个操作中有一个为写操作，此时两个操作之间就存在数据依赖性。数据依赖分为以下三种类型：①写后读，写一个变量之后再读这个位置。②读后写，读一个变了之后再写这个变量。③写后写，写一个变量之后再写这个变量。

  上述三种情况只要重排序两个操作的执行顺序，程序的执行结果就会被改变。编译器和处理器为了性能优化可能会对操作重排序，在重排序时会遵守数据依赖性，不会改变存在数据依赖关系的两个操作的执行顺序。这里说的数据依赖性仅针对单个处理器中执行的指令序列和单个线程中执行的操作，不同处理器之间和不同线程之间的数据依赖性不被编译器和处理器考虑。

- **as- if-serial**

  as-if-serial指不管怎么重排序（编译器和处理器为了提高并行度），（单线程）程序的执行结果不能被改变。编译器、runtime和处理器都必须遵循该语义。为了遵循该语义，编译器和处理器不会对存在数据依赖关系的操作做重排序，因为这种重排序会改变执行结果。但如果操作之间不存在数据依赖关系，这些操作就可能被重排序。

  as-if-serial语义将单线程保护了起来，遵循as-if-serial语义的编译器、runtime和处理器共同为编写单线程程序的程序员创建了一个幻觉：单线程程序是按照程序的顺序执行的。as-if-serial使单线程程序员无需担心重排序会干扰他们，也无需担心内存可见性问题。

  as-if-serial实例：例如计算一个圆的面积，A操作给半径赋值，B操作给圆周率赋值，C操作计算圆的面积。由于C依赖于A和B因此不会被重排到A和B的前面，但A和B之间没有数据依赖关系，所以程序的执行顺序可以是ABC或BAC，结果是一样的。

- **控制依赖关系对指令重排序的影响**

  当代码中存在控制依赖性时（例如A操作判断某标志位，B操作根据A的结果执行对应逻辑），会影响指令序列执行的并行度。为此编译器和处理会采用猜测执行来克服控制相关性对并行度的影响，可以提前计算出值保存到名为重排序缓冲的硬件缓存中，如果之前的控制条件满足就执行对应操作。

  在单线程程序中，对存在控制依赖的操作重排序并不会改变程序的执行结果（这也是as-if-serial语义允许对存在控制依赖的操作做重排序的原因）。但在多线程程序中，对存在控制依赖的操作从排序可能会改变程序的执行结果。

---

### happens-before原则

如果Java内存模型中所有有序性都依靠volatile和synchronized来完成，许多操作会变得过于繁杂，Java语言中有一个先行发生原则（happens-before），这个原则非常重要，它是判断数据是否存在竞争，线程是否安全的非常有用的手段。依赖这个原则，可以通过几条简单规则解决并发环境下两个操作之间可能存在冲突的所有问题。

先行发生是Java内存模型中定义的两项操作之间的偏序关系，比如说操作A先行发生于操作B，其实就是说发生操作B之前，操作A产生的影响能被操作B观察到，“影响”包括修改内存中共享变量的值、发送了消息、调用了方法等。

Java内存模型存在一些天然的happens-before关系，这些happens-before关系无需任何同步器协助，可以在编码中直接使用。如果两个操作的关系不在此列，并且无法从这些规则推导出来，它们就没有顺序性保障，虚拟机可以对它们随意进行重排序。

- **程序次序规则**：在一个线程内，按照控制流顺序，书写在前面的操作先行发生于书写在后面的操作。
- **管程锁定规则**：一个unlock操作先行发生于后面对同一个锁的lock操作。
- **volatile变量规则**：对一个volatile变量的写操作先行发生于后面对这个变量的读操作。
- **线程启动规则**：线程对象的start方法先行发生于此线程的每一个动作。
- **线程终止规则**：线程中的所有操作都先行发生于对此线程的终止检测，可以通过join方法是否结束或isAlive方法的返回值等手段检测线程是否已经终止执行。
- **线程中断规则**：对线程interrupt方法的调用先行发生于被中断线程的代码检测到中断事件的发生，可以通过interruptted方法检测是否有中断发生。
- **对象终结规则**：一个对象的初始化完成先行发生于它的finalize方法的开始。
- **传递性**：如果操作A先行发生于操作B，操作B先行发生于操作C，那么可以得出操作A先行发生于操作C的结论。

**happens-before的重排序策略：**

JMM将happens-before要求禁止的重排序分为了下面两类：会改变程序执行结果的重排序和不会改变程序执行结果的重排序。JMM对这两种不同性质的重排序采取了不同的策略，对于会改变程序执行结果的重排序JMM要求编译器和处理器必须禁止这种重排序；对于不会改变程序执行结果的重排序，JMM对编译器和处理器不做要求（JMM允许这种重排序）。

JMM向程序员提供happens-before规则能满足程序员的需求，其规则不但简单易懂而且也向程序员提供了足够强的内存可见性保证（有些内存保证性不一定真实存在，例如不改变执行结果的指令重排序对程序员是透明的）。

JMM对编译器和处理器的束缚已经尽可能地少，JMM遵循一个基本原则：只要不改变程序执行结果，编译器和处理器怎么优化都行。例如编译器分析某个锁只会单线程访问就消除该锁，某个volatile变量只会单线程访问就把它当作普通变量。

**happens-before的具体含义：**

①如果一个操作happens-before另一个操作，那么第一个操作的执行结果对第二个操作可见，并且第一个操作的执行顺序排在第二个操作之前。这是JMM对程序员的承诺。

②两个操作之间存在happens-before关系，并不意味着Java平台的具体实现必须要按照happens-before关系指定的顺序执行，如果重排序之后的执行结果与按照happens-before关系的执行结果一致，那么这种重排序是可以允许的。这是JMM对编译器和处理器的约束规则，JMM遵循一个基本原则：只要不改变程序执行结果，编译器和处理器怎么优化都行。JMM这么做的原因是程序员对于这两个操作是否真的被重排序并不关心，程序员关心的是程序执行的语义不能被改变（即执行结果不能被改变）。因此happens-before关系的本质和as-if-serial一样。

**happens-before和as-if-serial的区别：**

as-if-serial语义保证单线程程序的执行结果不被改变，happens-before保证正确同步的多线程程序的执行结果不被改变。

as-if-serial语义给编写单线程程序的程序员创造了一种单线程程序是顺序执行的幻觉，happens-before关系给编写正确同步的多线程程序员创造了一种多线程程序是按照happens-before指定顺序执行的幻觉。

这两种语义的目的都是为了在不改变程序执行结果的前提下尽可能提高程序执行的并行度。

---

### 其他补充

- **JMM内存屏障分类**

  - Load Load，确保Load1的数据装载先于Load2及所有后续装载指令的装载。
  - Store Store，确保Store1数据对其他处理器可见（刷新到内存）先于Store2及所有后续存储指令的存储。
  - Load Store，确保Load1数据装载先于Store2及所有后续存储指令刷新到内存。
  - Store Load，确保Store1数据对其他处理器变得可见（刷新到内存）先于Load2及所有后续装载指令的装载。

  Store Load会使该屏障之间的所有内存访问指令（存储和装载指令）完成之后才执行该屏障之后的内存访问指令。该指令是一个“全能型”屏障，同时具备其他三个屏障的效果，现代的多处理器大多支持该屏障，执行该屏障的开销很昂贵，因为当前处理器通常要把写缓冲区的数据全部刷新到内存中。

- **数据竞争和顺序一致性**

  当程序未正确同步时就可能存在数据竞争。JMM规范对数据竞争的定义如下：在一个线程中写一个变量，在另一个线程中读同一个变量，而且写和读没有通过同步来排序。当代码中包含数据竞争时程序的执行往往产生违反直觉的结果，如果一个多线程程序能正确同步，这个程序将是一个没有数据竞争的程序。

  JMM对正确同步的多线程程序的内存一致性做了如下保证：如果程序是正确同步的，程序的执行将具有顺序一致性，即程序的执行结果与该程序在顺序一致性内存模型中的执行结果相同。这里的同步是指广义上的同步，包括对常用同步用语（synchronized、volatile和final）的正确使用。

  - **顺序一致性内存模型的特点**

    顺序一致性内存模型是一个理想化的理论参考模型，它为程序员提供了极强的内存可见性保证。顺序一致性内存模型有两大特性：①一个线程中的所有操作必须按照程序的顺序来执行。②不管程序是否同步，所有线程都只能看到一个单一的操作执行顺序，在顺序一致性的内存模型中，每个操作都必须原子执行并且立即对所有线程可见。

    在概念上，顺序一致性模型有一个单一的全局内存，这个内存通过一个左右摆动的开关可以连接到任意一个线程，同时每一个线程必须按照程序的顺序来执行内存读/写操作。在任意时间点最多只能有一个线程可以连接到内存，当多个线程并发执行时，开关装置能把线程的所有内存读/写操作串行化（即在顺序一致性模型中所有操作之间具有全序关系）

- **未同步程序**

  - **未同步程序的问题**

    未同步程序在顺序一致性模型中虽然整体执行顺序无序但是所有线程都能看到一个一致的整体执行顺序。之所以能得到这个保证是因为顺序一致性内存模型中的每个操作必须立即对任意线程可见。

    JMM中没有这个保证，未同步程序在JMM中不但整体的执行顺序无序，并且所有线程看到的操作执行顺序也可能不一致。比如当前线程把写过的数据缓存到本地内存，在没有刷新到主内存前，这个写操作仅对当前线程可见。从其他线程的角度会认为这个写操作并没有执行，只有当前线程把本地内存中写过的数据刷新回主内存之后这个写操作才对其他线程可见，这种情况下当前线程和其他线程看到的操作执行顺序不一致。

  - **未同步程序的执行特性**

    对于未同步或未正确同步的多线程程序，JMM只提供最小安全性：线程执行时读取到的值要么是之前某个线程写入的值，要么是默认值，JMM保证线程读操作读取到的值不会无中生有。为了实现最小安全性，JVM在堆上分配对象时首先会对内存空间进行清零，然后才会在上面分配对象（JVM内部同步这两个操作）。因此在已清零的内存空间分配对象时，域的默认初始化已经完成了。

    JMM不保证未同步程序的执行结果与该程序在顺序一致性模型的执行结果一致，因为如果想要保证一致需要禁止大量的处理器和编译器优化，这对程序执行性能会有很大影响。而且未同步程序在顺序一致性模型中执行时整体是无序的，结果无法预知，因此保证未同步执行程序在两个模型的执行结果一致没什么意义。

  - **未同步程序在JMM和顺序一致性模型的执行区别**
    - 顺序一致性模型保证单线程内的操作会按程序的顺序执行，而JMM不保证单线程内的操作会按程序的顺序执行。
    - 顺序一致性模型保证所有线程只能看到一致的操作执行顺序，而JMM不保证所有线程能看到一致的操作执行顺序。
    - JMM不保证对64位的long类型和double类型变量的写操作具有原子性，而顺序一致性模型保证对所有的内存读/写操作都具有原子性。

- **总线的工作机制和好处**

  在计算机中，数据通过总线在处理器和内存之间传递。每次处理器和内存之间的数据传递都是通过一系列步骤来完成的，这一系列步骤称为总线事务。总线事务包括读事务和写事务。读事务从内存中传输数据到处理器，写事务从处理器传送数据到内存，每个事务会读/写内存中的一个或多个物理上连续的字，总线会同步试图并发使用总线的事务。在一个处理器执行总线事务期间，总线会禁止其他的处理器和IO设备执行内存的读/写。

  总线的工作机制可以把所有处理器对内存的访问以串行化的方式来执行，在任意时间点最多只能有一个处理器访问内存，这个特性确保了单个总线事务之中的内存读/写操作具有原子性。

- **处理器内存模型的分类以及JMM对不同处理器的处理**

  - **处理器分类**
    - 放松程序中写-读操作的顺序，由此产生了TSO内存模型。
    - 在TSO的基础上继续放松程序中写-写操作的顺序，由此产生了PSO内存模型。
    - 在TSO和PSO的基础上，继续放松程序中读-写（以两个操作之间不存在数据依赖性为前提）和读-读操作的顺序，由此产生了RMO和PowerPC内存模型。

  - **JMM对不同处理器模型的处理**

    不同的处理器模型，性能越好，内存模型的设计越弱，因为处理器希望内存模型对它们的束缚越少越好，这样它们就可以做尽可能多的优化来提高性能。由于常见的处理器内存模型比JMM要弱，Java编译器在生成字节码时，会在执行指令序列的适当位置插入内存屏障来限制处理器的重排序。同时由于各种处理器内存模型的强弱不同，为了在不同的处理器平台向程序员展示一个一致的内存模型，JMM在不同的处理器中需要插入的内存屏障的数量和种类也不同。JMM屏蔽了不同处理器内存模型的差异，它在不同的处理器平台之上为Java程序员呈现了一个一致的内存模型。

- **Java程序内存可见性保证的分类**

  - 单线程程序：单线程程序不会出现内存可见性问题。编译器、runtime和处理器会共同确保单线程程序的执行结果与该程序在一致性模型中的执行结果相同。

  - 正确同步的多线程程序：正确同步的多线程程序的执行将具有顺序一致性（程序的执行结果与该程序在一致性模型中的执行结果相同）。这是JMM关注的重点，JMM通过限制编译器和处理器的重排序来为程序员提供内存可见性保证。

  - 未同步/未正确同步的多线程程序：JMM为它们提供了最小安全性保证，线程执行读取到的值要么是之前某个线程写入的值，要么是默认值，但不保证该值是正确的。

- **JSR-133对旧内存模型的修补**

  - 增强volatile的内存语义，旧内存模型允许volatile变量与普通变量重排序。JSR-133严格限制volatile变量与普通变量的重排序，使volatile的写-读和锁的释放-获取具有相同的内存语义。
  - 增强final的内存语义，旧内存模型中多次读取同一个final变量的值可能会不相同，为此JSR-133为final增加了两个重排序规则。在保证final引用不会从构造方法逸出的情况下，final具有了初始化安全性。

---

## Java和线程

### 线程的实现

线程是比进程更轻量级的调度执行单位，线程的引入可以把一个进程的资源分配和执行调度分开，各个线程既可以共享进程资源（内存地址、文件IO等），又可以独立调度。目前线程是Java中进行处理器资源调度的最基本单位。

主流的操作系统都提供了线程实现，Java则提供了在不同硬件和操作系统平台下对线程操作的统一处理，每个已经调用过start方法且还未结束的java.lang.Thread类的实例就代表着一个线程。Thread类的所有关键方法都被声明为native，一个native方法往往意味着这个方法没有使用或无法使用平台无关的手段来实现（也有可能是为了执行效率而使用native方法，通常最高效率的手段都是平台相关的手段）。

实现线程主要有三种方式：

- **使用内核线程实现（1:1实现）**

  使用内核线程实现的方式也被称为1:1实现，内核线程（Kernel-Level Thread，KLT）就是直接由操作系统内核支持的线程，这种线程由内核来完成线程切换，内核通过操纵调度器对线程进行调度，并负责将线程的任务映射到各个处理器上。每个内核线程可以视为一个内核的分身，这样操作系统就有能力同时处理多件事情，支持多线程的内核就称为多线程内核。

  程序一般不会直接使用内核线程，而是使用内核线程的另一种高级接口即轻量级进程（Light Weight Process，LWP），轻量级进程就是通常所说的线程，由于每个轻量级进程都由一个内核线程支持，因此只有先支持内核线程，才能有轻量级进程，这种轻量级进程与内核线程之间1:1的关系称为一对一的线程模型。

  由于内核线程的支持，每个轻量级进程都成为一个独立的调度单元，即使其中某一个轻量级进程已经在系统调用中被阻塞了，也不会影响整个进程继续工作。轻量级进程也具有它的局限性：首先由于是基于内核线程实现的，所以各种线程操作，如创建、析构和同步等，都需要进行系统调用。而系统调用的代价相对较高，需要在用户态和内核态中来回切换。其次每个轻量级进程都需要有一个内核线程的支持，因此轻量级进程要消耗一定的内核资源（如内核线程的栈空间），因此一个系统支持轻量级进程的数量是有限的。

- **使用用户线程实现（1:N实现）**

  使用用户线程实现的方式被称为1:N实现，从广义上说，一个线程只要不是内核线程就可以认为是用户线程（User Thread，UT）的一种，因此从该定义上来说轻量级进程也属于用户线程，但轻量级进程的实现始终是建立在内核之上的，许多操作都要进行系统调用因此效率会受到限制，并不具备通常意义上的用户线程的优点。

  狭义上的用户线程是指完全建立在用户空间的线程库上，系统内核不能感知到用户线程的存在及如何实现的。用户线程的建立、同步、销毁和调度完全在用户态中完成，不需要内核的帮助。如果程序实现得当，这种线程不需要切换到内核态，因此操作可以是非常快速且低消耗的，也能够支持更大规模的线程数量，部分高性能数据库中的多线程就是由用户线程实现的。这种进程与用户线程之间1:N的关系称为一对多的线程模型。

  用户线程的优势在于不需要系统内核支援，劣势也在于没有系统内核支援，所有的线程操作都需要用户程序自己去处理。线程的创建、销毁、切换和调度都是用户必须考虑的问题，而且由于操作系统只把处理器资源分配到进程，诸如“阻塞如何处理”、“多处理器系统中如何将线程映射到其他处理器上”等问题变得难以解决。因为基于用户线程的实现的程序一般比较复杂，除了有明确的需求外一般的应用程序都不倾向使用用户线程，Java曾经使用过但最终又放弃了它。今年来许多新的以高并发为卖点的编程语言又普遍支持了用户线程，如Golang、Erlang等，使用户线程的使用率有所回升。

- **使用用户线程加轻量级进程混合实现（N:M实现）**

  线程除了依赖内核线程实现和用户程序自己实现之外，还有一种将内核线程与用户线程一起使用的实现方式，被称为N:M实现。在这种混合实现下，既存在用户线程，也存在轻量级进程。用户线程还是完全建立在用户空间中，因此用户线程的创建、切换、析构等操作依然消耗低并且可以支持大规模的用户线程并发。而操作系统支持的轻量级进程则作为用户线程和内核线程之间的桥梁，这样可以使用内核提供的线程调度功能及处理器映射，并且用户线程的系统调用要通过轻量级进程来完成，这大大降低了整个进程被完全阻塞的风险。在这种混合模式中，用户线程和轻量级进程的数量比是不定的，是N:M的关系。

  许多UNIX系列的操作系统都提供了这种混合的线程模型实现。

----

### Java线程的实现

Java线程如何实现并不受Java虚拟机规范的约束 ，这是一个与具体虚拟机相关的问题。Java线程早期在Classic虚拟机（JDK1.2之前）上是基于一种被称为绿色线程的用户线程实现的，但从JDK1.3开始，主流平台上的主流商用Java虚拟机的线程模型普遍都被替换为基于操作系统原生线程模型来实现。即采用1:1的线程模型。

以HotSpot为例，它的每一个Java线程都是直接映射到一个操作系统原生线程来实现的，而且中间没有额外的间接结构，所以HotSpot自己不会去干涉线程调度（可以设置线程优先级供操作系统调度参考），全权交给底层的操作系统处理。所以何时冻结或唤醒线程、该给线程分配多少CPU时间片、该把线程安排给哪个CPU核心去执行等都是由操作系统完成的，也都是由操作系统全权决定的。

还有一些例外的情况，例如用于JavaME的CLDC虚拟机，它同时支持两种线程模型，默认使用1:N的用户线程实现的线程模型，所有Java线程都映射到一个内核线程上；但它也可以使用另一种特殊的混合模型，Java线程依旧全部映射到一个内核线程上但是当Java线程要执行一个阻塞调用时，CLDC会为该调用单独开一个内核线程并且调度执行其他Java线程，等到那个阻塞调用完成之后再重新调度之前的Java线程继续执行。

另外一个例子时Solaris平台上的HotSpot虚拟机，由于操作系统的现场特性本来就可以同时支持1:1和N:M的线程模型，因此该平台上的虚拟机也对应提供了两个平台专有的虚拟机参数来明确指定虚拟机使用哪种线程模型。

操作系统支持怎样的线程模型，在很大程度上会影响上面的Java虚拟机的线程的是怎样映射的，这一点在不同平台上很难达成一致，因此《Java虚拟机规范》中没有限定Java线程实现的线程模型，线程模型只对线程的并发规模和操作成本产生影响，对Java程序的编程和运行过程来说这些差异都是完全透明的。

---

### Java线程的调度

线程调度是指系统为线程分配处理器使用权的过程，调度方式主要有两种，分别是协同式线程调度和抢占式线程调度。

如果使用协同式调度的多线程系统，线程的执行时间由线程本身来控制，线程把自己的工作执行完成之后，要主动通知系统切换到另一个线程上去。协同式多线程最大的好处就是实现简单，由于线程要把自己的事情干完之后才会进行线程切换，切换操作对线程自身是可知的，所以一般没有线程同步问题。它的缺点也很明显：线程执行的时间不可控制，甚至如果一个线程的代码编写有问题，一直不告知系统进行线程切换，那么程序就会一直阻塞。

如果使用抢占式调度的多线程系统，那么每个线程将由系统来分配执行时间，线程切换不由线程本身来决定。例如Java中的yield方法可以主动让出执行时间，但是如果想要主动获取执行时间，线程自身是没有什么办法的。这种实现线程调度的方式下，线程的执行时间是系统可控的，也不会有一个线程导致整个进程甚至整个系统阻塞的问题。Java使用的线程调度方式就是抢占式调度。

虽然Java线程调度是系统自动完成的，但我们依旧可以通过setPriority方法为线程设置优先级来为系统提供建议，为某些线程多分配一些时间，其他的一些线程可以少分配一些时间。Java中一共设置了10个级别的线程优先级，在两个线程同时处于可运行状态时优先级高的线程容易被操作系统选择执行。

不过线程优先级并不是一项稳定的调节手段，因为主流虚拟机上的Java线程是被映射到系统的原生线程上来实现的，所以线程调度最终的决定权还是在操作系统。尽管现代操作系统基本都提供了线程优先级的概念，但是并不见得能和Java线程的优先级一一对应，如Solaris中线程有2147483648种线程优先级，而Windows系统中就只有7种。如果操作系统的线程优先级比Java线程优先级更多，问题还比较容易处理，但如果比Java的优先级少，就不得不出现几个线程优先级对应一个操作系统优先级的情况了，在Windows种设置线程优先级1和2、3和4、6和7、8和9的效果是完全一样的。

---

### Java线程的通信

通信是指线程之间以何种机制来交换信息，在命令式编程中线程之间的通信机制有两种，共享内存和消息传递。在共享内存的并发模型里线程之间共享程序的公共状态，通过写-读内存中的公共状态进行隐式通信。在消息传递的并发模型里线程之间没有公共状态，线程之间必须通过发送消息来显示通信。

同步是指程序中用于控制不同线程间操作发生相对顺序的机制，在共享内存的并发模型里同步是显示进行的，程序员必须显示指定某个方法或代码需要在线程之间互斥执行。在消息传递的并发模型里，由于消息的发送必须在接受之前，同步是隐式进行的。

Java并发采用共享内存模型，线程之间的通信总是隐式进行，整个通信过程对程序员完全透明。

---

### 线程状态

- **NEW：**初始状态，创建后还没有启动的线程处于这种状态，此时还没有调用start()方法。

- **RUNNABLE：**运行状态，Java线程将操作系统中的就绪（Ready）和运行（Running）两种状态统称为运行中，此时线程有可能正在等待操作系统分配CPU时间片，也有可能正在执行。

- **BLOCKED：**阻塞状态，阻塞状态与等待状态的区别是阻塞状态在等待一个排它锁，在程序等待进入同步区域时线程将进入这种状态。

- **WAITING：**等待状态，表示线程进入等待状态，处于该状态的线程不会被分配CPU时间片，进入该状态表示当前线程需要等待其他线程做出一些特定动作（通知或中断）。

  会导致线程陷入等待状态的方法：

  - 没有设置timeout参数的wait方法。
  - 没有设置timeout参数的join方法。
  - LockSupport的park方法。

- **TIME_WAITING：**限期等待状态，该状态不同于WAITING，可以在指定时间内自行返回。

  会导致线程陷入限期等待状态的方法：

  - 设置了timeout参数的wait方法。
  - 设置了timeout参数的join方法。
  - LockSupport的parkNanos方法。
  - LockSupport的parkUntil方法。

- **TERMINATED：**终止状态，表示当前线程已经执行完毕。

---

## 线程安全与锁

### Java中的线程安全

当多个线程同时访问一个对象时，如果不用考虑这些线程在运行时环境下的调度和交替执行，也不需要进行额外地同步，或者在调用方进行任何其他地协调操作，调用这个对象的行为都可以获得正确的结果，那就称这个对象是线程安全的。

这个定义要求线程安全的代码都必须具备一个共同特征：代码本身封装了所有必要的正确性保障手段，令调用者无须关心多线程下的调用问题，更无须自己实现任何措施来保证多线程环境下的正确调用。

在Java中，按照线程安全的“安全程度”由强到弱，可以把Java中各种操作共享的数据分为以下五类：不可变、绝对线程安全、相对线程安全、线程兼容和线程对立。

- **不可变**

  在Java中，不可变对象一定是线程安全的，无论是对象的方法实现还是方法的调用者，都不需要再进行任何线程安全的保障措施。只要一个不可变的对象被正确地构建出来（即没有发生this引用逃逸的情况），那其外部的可见状态永远都不会改变，永远都不会看到它在多个线程中处于不一致的状态。“不可变”带来的安全性是最直接、最纯粹的。

  在Java中，如果多线程共享的数据是一个基本类型数据，那么只要定义时使用final关键字修饰就可以保证它是不可变的。如果共享的数据是一个对象，需要保证对象自身的行为不会对其状态产生任何影响，才能保证这个对象的不可变性，例如可以将对象中带有状态的变量都声明为final类型，这样在构造器执行结束后它就是不可变的，例如Integer类将自己的成员变量使用fianl修饰保证不可变性。

  不可变类型还有String、常用的枚举类型以及Long、Double等包装器类型、BigInterger和BigDecimal大数据类型，但不包括AtomicInteger和AtomicLong类型。

- **绝对线程安全**

  绝对线程安全的定义很严格，大部分Java API中标注自己是线程安全的类都不是绝对线程安全的，例如Vector容器，虽然它的方法都被synchronized修饰，保证了原子性、可见性和有序性、但是并不意味着调用它时就永远不需要同步手段了，例如多线程同时执行对Vector对象的get和remove操作，如果一个线程恰好在错误的时间删除了一个元素，导致get操作中遍历的索引不可用，那么get操作就会抛出索引越界异常。

- **相对线程安全**

  相对线程安全就是通常意义上讲的线程安全，它需要保证对这个对象单次的操作是线程安全的，我们在调用时不需要进行额外地保障措施，但是对于一些特定顺序地连续调用，就可能需要在调用端使用额外地同步手段来保证调用的正确性。

  在Java中，大部分声称线程安全的类都属于这种类型，例如Vector、HashTable、Colletcions的synchronizedCollection()方法包装的集合等。

- **线程兼容**

  线程兼容是指对象本身并不是线程安全的，但是可以通过在调用端正确地使用同步手段来保证对象在并发环境中可以安全地使用。我们常说的一个类不是线程安全的通常就是这种情况，Java类库API中大部分的类都是线程兼容的，例如ArrayList和HashMap等。

- **线程对立**

  线程对立是指不管调用端是否采取了同步措施都无法在多线程环境中并发使用代码。由于Java语言天生支持多线程特性，线程对立这种排斥多线程的代码很少出现，而且通常都是有害的，应当尽量避免。

  一个线程对立的例子就是Thread类的suspend和resume方法，如果有两个线程同时持有一个线程对象，一个尝试去中断，另一个尝试去恢复，在并发进行的情况下无论调用时是否进行了同步，目标线程都存在死锁风险：假如suspend中断的线程就是即将要执行resume的那个线程，那肯定就会产生死锁。因此这两个方法都已经被废弃了，常见线程对立的操作还有System.setIn()、System.setOut()等方法。

---

### 线程安全的实现方法

- **互斥同步**

  互斥同步是一种最常见的也是最主要的并发正确性保障手段。同步是指多个线程并发访问共享数据时，保证共享数据在同一个时刻只被一条（或者是一些，当使用信号量的时候）线程使用。而互斥是实现同步的一种手段，临界区、互斥量和信号量都是常见的互斥实现方式。互斥是方法，同步是目的。

  在Java中最基本的互斥同步手段就是synchronized关键字，它是一种块结构的同步语法。synchronized关键字经过Javac编译后，会在同步块的前后分别形成monitorenter和monitorexit这两个字节码指令。这两个字节码指令都需要一个引用类型的参数来指明要锁定和解锁的对象，如果代码中指定了对象参数，那么就以该对象作为锁定对象，如果没有明确指定，那么根据synchronized修饰的是方法类型（实例方法或类方法）来决定锁对象是实例对象还是类型对应的Class对象。

  根据《Java虚拟机规范》的要求，在执行monitorenter指令时，首先要去尝试获取对象的锁。如果这个对象没有被锁定，或者当前线程已经持有了那个对象的锁，那么就把锁的计数器的值增加1，而在执行monitorexit指令时会将锁计数器的值减1。一旦计数器的值为0，锁随即就被释放了。如果获取锁对象失败，那当前线程就应该被阻塞等待，直到请求锁定的对象被持有它的线程释放为止。

  根据《Java虚拟机规范》对monitorenter和monitorexit的行为描述，可以得出两个关于synchronized的直接推论：

  - 被synchronized修饰的同步块对一条线程来说是可重入的，这意味同一条线程反复进入同步块也不会出现将自己锁死的情况。
  - 被synchronized修饰的同步块在持有锁的线程执行完毕并释放锁之前，会无条件地阻塞后面其他线程的进入。这意味着无法像处理某些数据库的锁那样强制已获得锁的线程释放锁，也无法强制正在等待锁的线程中断等待或超时退出。

  从执行成本的角度看，持有锁是一个重量级的操作。在主流Java虚拟机实现中，Java的线程是映射到操作系统的原生内核线程之上的，如果要阻塞或唤醒一条线程，则需要操作系统来帮忙完成，这就不可避免陷入用户态到核心态的转换中，进行这些状态转换需要耗费很多的处理器时间。尤其是对于代码很简单的同步块，例如被synchronized修饰的getter和setter方法，状态转换消耗的时间甚至比用户代码本身执行的时间还要长。因此才说synchronized是Java中的一个重量级操作，不过Java之后也进行了相关的锁优化措施。

  除了synchronized关键字之外，自JDK5起Java类库新提供了juc包，其中的Lock接口成为了另一种全新的互斥同步手段。基于Lock接口，用户能够以非块结构来实现互斥同步，从而摆脱了语言特性的束缚，改为在类库层面上去实现同步。

  重入锁ReentrantLock是Lock接口最常见的一种实现，它与synchronized一样是可重入的，在基本用法上与synchronized也很相似，不过它增加了一些高级功能，主要包括以下三项：

  - **等待可中断：**是指持有锁的线程长期不释放锁时，正在等待的线程可以选择放弃等待而处理其他事情。可中断特性对处理执行时间非常长的同步块很有帮助。
  - **公平锁：**是指多个线程在等待同一个锁时，必须按照申请锁的时间顺序来依次获得锁，而非公平锁则不保证这一点，在锁被释放时，任何一个等待锁的线程都有机会获得锁。synchronized中的锁是非公平的，ReentrantLock在默认情况下也是非公平的，但可以通过带有布尔值的构造器要求使用公平锁。不过一旦使用了公平锁，将会导致性能急剧下降，明显影响吞吐量。
  - **锁绑定多个条件：**是指一个ReentrantLock对象可以同时绑定多个Condition对象。在synchronized中，锁对象的wait()跟它的notify()或者notifyAll()方法配合可以实现一个隐含的条件，如果要和多于一个的条件关联时就不得不额外添加一个锁，而ReentrantLock无须这样做，可以多次调用newCondition()方法。

  在JDK5时ReentrantLock比synchronized性能有显著优势，而在JDK6中进行锁优化之后，二者的性能基本能够持平。

  当synchronized和ReentrantLock都可以满足要求时可以优先考虑使用synchronized：

  - synchronized是Java语法层面的同步，足够清晰也足够简单。
  - Lock应该确保在finally中释放锁，否则一旦受同步保护的代码块中抛出异常，则有可能永远不会释放持有的锁。这一点必须由程序员自己来保证，而使用synchronized的话可以由Java虚拟机来确保即使出现异常锁也能被正常释放。
  - 尽管在JDK5时ReentrantLock的性能领先于synchronized，但从长远来看Java虚拟机更容易针对synchronized进行优化，因为Java虚拟机可以在线程和对象的元数据中记录synchronized中锁的相关信息，而使用Lock的话，Java虚拟机很难得知具体哪些锁对象是由特定线程持有的。

- **非阻塞同步**

  互斥同步面临的主要问题是进行线程阻塞和唤醒带来的性能开销，因此这种同步也被称为阻塞同步。从解决方式来看，互斥同步属于一种悲观的并发策略，其总是认为只要不去做正确的同步措施那就肯定会出现问题，无论共享的数据是否真的会发生竞争，它都会进行加锁，这会导致用户态到核心态转换、维护锁计数器和检查是否有被阻塞的线程需要被唤醒等开销。

  随着硬件指令集的发展，我们已经有了其他选择：基于冲突检测的乐观并发策略，通俗地说就是不管风险，先进性操作，如果没有其他线程竞争共享数据操作就直接成功了；如果共享数据的确存在竞争，那再进行其他措施，例如不断重试直到出现没有竞争的共享数据为止。这种乐观并发策略的实现不再需要把线程阻塞挂起，因此这种同步操作被称为非阻塞同步，使用这种措施的代码也被称为无锁编程。

  之所以说乐观并发策略需要“硬件指令集的发展”，是因为我们必须要求操作和冲突检测这两个步骤具备原子性。如果在使用互斥同步来保证原子性就完全失去意义了，因此只能考硬件来实现这件事，硬件保证某些从语义上看起来需要多次操作的行为可以通过一条处理器指令就能完成，这类指令常用的有：测试并设置、获取并增加、交换、比较并交换（CAS）、加载链接/条件存储（LL/SC）。

  其中测试并设置、获取并增加、交换这三条是20世纪就已经存在于大多数指令集中的处理器指令，后面两条是现代处理器新增的，而且这两条指令的目的和功能也是类似的。Java中最终暴露出来的是CAS操作。

  - **CAS**

    CAS指令需要有三个操作数，分别是内存位置（在Java中可以理解为变量的内存地址，用V表示）、旧的预期值（用A表示）和准备设置的新值（用B表示）。CAS指令执行时，当且仅当V符合A时，处理器才会用B更新V的值，否则它就不执行更新。但是不管是否更新了V的值都会返回V的旧值，上述的处理过程是原子操作，执行期间不会被其他线程打断。

  在JDK5之后，Java类库中才开始使用CAS操作，该操作由sun.misc.Unsafe类里面的`compareAndSwapInt()`和`compareAndSwapLong()`等几个方法包装提供。HotSpot虚拟机在内部对这些方法做了特殊处理，即时编译出来的结果就是一条平台相关的处理器CAS指令，没有方法调用的过程，或者可以认为是无条件地内联进去了。不过由于Unsafe类设计时就不是给用户程序调用的类（Unsafe的getUnsafe方法限制了只有启动类加载器加载的Class才能访问它），因此在JDK9之前只有Java类库可以使用CAS，譬如juc包里的AtomicInteger类，其中的`compareAndSet()`和`getAndIncrement()`等方法都使用了Unsafe类的CAS操作来实现。如果用户程序也有使用CAS操作的需求，要么就采用反射手段突破Unsafe的访问限制，要么只能通过Java类库API来间接使用它。直到JDK9之后，Java类库才在VarHandle类中开放了面向用户程序使用的CAS操作。

  AtomicIntegr的`incrementAndGet()`方法在一个无限循环中，不断尝试将一个比当前值大1的新值赋值给自己，如果失败了就说明执行CAS操作的时候旧值已经发生了变化，于是再次循环进行下一次操作直到成功为止。

  尽管CAS既简单又高效，但这种操作无法涵盖互斥同步的所有使用场景，并且CAS从语义上来说并不是完美的，它存在一个逻辑漏洞：如果一个变量V初次读取的时候是A，并且在准备赋值的时候检查到它的值仍为A，这依旧不能说明它的值没有被其他线程更改过，因为这段时间内假设它的值先改为了B又改回了A，那么CAS操作就会误认为它从来没有被改变过。这个漏洞称为CAS操作的ABA问题，juc包为了解决这个问题提供了一个带有标记的原子引用类AtomicStampedReference，它可以通过控制变量值得版本来保证CAS的正确性。不过目前这个类并不常用，大部分情况下ABA问题不会影响程序并发的正确性，如果需要解决ABA问题，改用传统的互斥同步可能会比原子类更高效。

- **无同步方案**

  要保证线程安全，也并非一定要进行阻塞同步或非阻塞同步，同步与线程安全没有必然联系。同步只是保障存在共享数据竞争时正确性的手段，如果能让一个方法本来就不涉及共享数据，那它自然就不需要任何同步措施去保证其正确性，因此有一些代码天生就是线程安全的。

  - **可重入代码：**这种代码又称纯代码，是指可以在代码执行的任何时刻中断它，转而去执行另外一段代码（包括递归调用它本身），而在控制权返回后，原来的程序不会出现任何错误，也不会对结果有所影响。在特指多线程的上下文语境里，可以认为可重入代码是线程安全代码的一个真子集，这意味着相对线程安全来说，可重入性是更为基础的特性，它可以保证代码线程安全，即所有可重入的代码都是线程安全的，但并非所有线程安全的代码都是可重入的。

    可重入代码有一些共同特征，例如不依赖全局变量、存储在堆上的数据和公用的系统资源，用到的状态量都由参数传入，不调用非可重入方法等。如果一个方法的返回结果是可预测的，只要输入了相同的数据就都能返回同样的结果，那它就满足可重入性的要求，当然也就是线程安全的。

  - **线程本地存储：**如果一段代码中所需要的数据必须与其他代码共享，那就判断这些共享数据的代码能否保证在同一线程中执行，如果可以就把共享数据的可见性限制在一个同一线程之内，这样无须同步也能保证线程之间不出现数据竞争的问题。

    符合这种特定的应用并不少见，大部分使用消费队列的架构模式（如生产者-消费者模式）都会将产品的消费过程限制在一个线程中消费完，其中最重要的一种应用实例就是Web交互模型中的“一个请求对应一个服务器线程”的处理方式，这种处理方式的广泛使用使很多Web服务端应用都可以使用线程本地存储来解决线程安全问题。

    在Java中可以使用ThreadLocal类来实现线程本地存储的功能，每个线程的Thread对象中都有一个ThreadLocalMap对象，这个对象存储了一组以`ThreadLocal.threadLocalHashCode`为键，本地线程变量为值的K-V键值对，ThreadLocal对象就是当前线程的ThreadLocalMap的访问入口，每一个ThreadLocal对象都包含了一个独一无二的`threadLocalHashCode`值，使用这个值就可以在线程K-V键值对中找到对应的本地线程变量。

---

### 锁优化

- **锁的内存语义和实现**

  当线程释放锁时，JMM会把该线程对应的本地内存中的共享变量刷新到主内存中。当线程获取锁时，JMM会把线程对应的本地内存置为无效，从而使得被监视器保护的临界区代码必须从主内存中读取共享变量。

  锁的释放与volatile写具有相同的内存语义，锁获取与volatile读具有相同的内存语义。线程A释放一个锁，实质上是线程A向接下来将要获取这个锁的某个线程发出了（线程A对共享变量所做修改的）消息。线程B获取一个锁，实质上是线程B接收了之前某个线程发出的（在释放这个锁之前对共享变量所做修改的）消息。线程A释放这个锁，随后线程B获取这个锁，这个过程实质上是线程A通过主内存向线程B发送消息。

  公平锁和非公平锁释放时，最后都要写一个volatile变量state。公平锁获取锁时，首先会去读volatile变量，非公平锁获取锁时，首先会用CAS更新volatile变量的值，这个操作同时具有volatile读和volatile写的内存语义。因此锁的释放-获取内存语义的实现方式为：①利用volatile变量的写-读具有的内存语义。②利用CAS所附带的volatile读和volatile写的内存语义。

高效并发是从JDK5升级到JDK6后的一项重要的改进项，HotSpot虚拟机开发团队在这个版本上花费了大量资源去实现各种锁优化技术，如适应性自旋、锁消除、锁膨胀、轻量级锁、偏向锁等，这些技术都是为了在线程之间更高效地共享数据及解决竞争问题，从而提高程序地执行效率。

- **自旋锁与自适应自旋**

  互斥同步对性能最大地影响是阻塞的实现，挂起线程和恢复线程的操作都需要转入内核态中完成，这些操作给Java虚拟机的并发性能带来了很大的压力。同时虚拟机开发团队也注意到了在许多应用上，共享数据的锁定状态只会持续很短的一段时间，为了这段时间去挂机和恢复线程并不值得。现在绝大多数的个人电脑和服务器都是多核心处理器系统，如果物理机器有一个以上的处理器或者处理器核心，能让两个或以上的线程同时并行执行，我们就可以让后面请求锁的那个线程“稍等一会”，但不放弃处理器的执行时间，看看持有锁的线程是否很快就会释放锁。为了让线程等待，我们只需让线程执行一个忙循环（自旋），这项技术就是所谓的自旋锁。

  自旋锁在JDK1.4.2中就已经引入，只不过默认是关闭的，可以使用`-XX:+UseSpinning`参数来开启，在JDK6中就已经改为默认开启了。自旋等待不能代替阻塞，不说对处理器数量的要求，自选等待本身虽然避免了线程切换的开销，但它是要占用处理器时间的，所以如果锁被占用的时间很短，自选等待的效果就会非常好，反之如果锁被占用的时间很长，那么自旋的线程只会白白消耗处理器资源，而不会做任何有价值的工作，这就会带来性能浪费。因此自旋等待的时间必须有一定的限度，如果自旋超过了限定的次数仍然没有成功获得锁，就应当使用传统的方式去挂起线程。自旋次数的默认次数是十次，用户可以使用`-XX:PreBlockSpin`来指定。

  不过无论是默认值还是用户指定的自旋次数，对整个Java虚拟机中所有的锁来说都是相同的。在JDK6中对自旋锁的优化，引入了自适应的自旋。自适应意味着自旋的时间不再是固定的了，而是由前一次在同一个锁上的自旋时间及锁的拥有者的状态来决定的。如果在同一个锁对象上，自旋等待刚刚成功获得过锁，并且持有锁的线程正在运行中，那么虚拟机就会认为这次自旋也很有可能再次成功，进而允许自旋等待持续相对更长的时间。另一方面，如果对于某个锁，自旋很少成功获得过锁，那在以后要获取这个锁时将有可能之间省略掉自旋过程，以避免浪费处理器资源。有了自适应自旋，随着程序运行时间的增长以及性能监控信息的不断完善，虚拟机对程序锁的状况预测就会越来越精准。

- **锁消除**

  锁消除是指虚拟机即时编译器在运行时，对一些代码要求同步，但是对被检测到不可能存在共享数据竞争的锁进行消除。锁消除的主要判定依据来源于逃逸分析的数据支持，如果判断到一段代码中，在堆上的所有数据都不会逃逸出去被其他线程访问到，那就可以把它们当作栈上的数据对待，认为它们是线程私有的，同步加锁自然就无须再进行。

- **锁粗化**

  原则上我们在编写代码时，总是推荐将同步块的作用范围限制得尽量小，只在共享数据得实际作用域中才进行同步，这样是为了使得需要同步的操作数量尽可能变少，即使存在锁竞争，等待锁得线程也能尽可能快拿到锁。

  大多数情况下这种原则是正确的，但是如果一系列的连续操作都对同一个对象反复加锁和解锁，甚至加锁操作是出现在循环体之外的，那么即使没有线程竞争，频繁地进行互斥同步操作也会导致不必要的性能消耗。

  如果虚拟机探测到有一串零碎的操作都对同一个对象加锁，将会把加锁同步的范围扩展（粗化）到整个操作序列的外部。

- **轻量级锁**

  轻量级锁是JDK6时加入的新型锁机制，它名字中的“轻量级”是相对于操作系统互斥量来实现的传统锁而言的，因此传统的锁机制就被称为“重量级”锁。不过需要强调的是，轻量级锁并不是用来代替重量级锁的，它设计的初衷是在没有多线程竞争的前提下，减少传统的重量级锁使用操作系统互斥量产生的性能消耗。

  要理解轻量级锁以及偏向锁的原理和运作过程，就必须要对HotSpot虚拟机对象的内存布局（尤其是对象头部分）有所了解。HotSpot虚拟机的对象头分为两部分，第一部分是用于存储对象自身的运行时数据的，如哈希码、GC分代年龄等。这部分数据的长度在32位和64位的Java虚拟机中分别会占用32个或64个比特，官方称为”Mark Word“。这部分是实现轻量级锁和偏向锁的关键。另外一部分用于存储指向方法区对象数据类型的指针，如果是数组对象，还会有一个额外的部分用于存储数组长度。

  由于对象头信息是与对象自身定义的数据无关的额外存储成本，考虑到Java虚拟机的空间使用效率，Mark Word被设计成一个非固定的动态数据结构，以便在极小的空间内存储尽量多的信息。它会根据对象的状态复用自己的存储空间。对象除了未被锁定的正常状态外，还有轻量级锁定、重量级锁定、GC标记、可偏向等几种不同的状态。

  - **轻量级锁的工作过程**

    在代码即将进入同步块的时候，如果此同步对象没有被锁定（锁标志位为01状态），虚拟机首先将在当前线程的栈帧中建立一个名为锁记录的空间，用于存储锁对象目前的Mark Word的拷贝。

    然后虚拟机将使用CAS操作尝试把对象的Mark Word更新为指向锁记录的指针，如果这个更新操作成功了，即代表该线程拥有了这个对象的锁，并且对象Mark Word的锁标志位将转变为”00“，表示此对象处于轻量级锁定状态。

    如果这个更新操作失败了，那就意味着至少存在一条线程与当前线程竞争获取该对象的锁。虚拟机首先会检查对象的Mark Word是否指向当前线程的栈帧，如果是，说明当前线程以及拥有了这个对象的锁，那直接进入同步块继续执行就可以了，否则就说明这个锁对象已经被其他线程抢占了。如果出现两条以上的线程争用同一个锁的情况，那轻量级锁就不再有效，必须要膨胀为重量级锁，锁标志的状态变为"10"，此时Mark Word中存储的就是指向重量级锁的指针，后面等待锁的线程也必须进入阻塞状态。

  - **轻量级锁的解锁过程**

    它的解锁操作也同样是通过CAS操作来进行的，如果对象的Mark Word仍然指向线程的锁记录，那就用CAS操作把对象当前的Mark Word和线程复制的Mark Word替换回来。假如能够替换成功，那整个同步过程就顺利完成了，如果替换失败，则说明有其他线程尝试过获取该锁，就要在释放锁的同时唤醒被挂起的线程。

  轻量级锁能提升程序同步性能的依据是”对于绝大部分的锁，在整个同步周期内都是不存在竞争的“这一经验法则。如果没有竞争，轻量级锁便通过CAS操作成功避免了使用互斥量的开销，但如果确实存在锁竞争，除了互斥量的本身开销外，还额外发生了CAS操作的开销。因此在有竞争的情况下，轻量级锁反而会比传统的重量级锁更慢。

- **偏向锁**

  偏向锁也是JDK6中引入的一项锁优化措施，它的目的是消除数据在无竞争情况下的同步原语，进一步提高程序的运行性能。如果说轻量级锁是在无竞争的情况下使用CAS操作去消除同步使用的互斥量，那偏向锁就是在无竞争的情况下把整个同步都去掉，连CAS操作都不去做了。

  偏向锁的意思就是这个锁会偏向于第一个获得它的线程，如果在接下来的执行过程中，该锁一直没有被其他线程获取，则持有偏向锁的线程将永远不需要再进行同步。

  假设当前虚拟机启用了偏向锁（启用参数`-XX:UseBiasedLocking`，这是自JDK6起HotSpot虚拟机的默认值），那么当锁对象第一次被线程获取的时候，虚拟机将会把对象头中的标志位设置为”01“，把偏向模式设置为”1”，表示进入偏向模式。同时使用CAS操作把获取到这个锁的线程ID记录在对象的Mark Word中，如果CAS操作成功，持有偏向锁的线程以后每次进入这个锁相关的同步块时，虚拟机都可以不再进行任何同步操作。

  一旦出现另外一个线程去尝试获取这个锁的情况，偏向模式马上就宣告结束。根据锁对象目前是否处于被锁定的状态决定是否撤销偏向（偏向模式设置为“0”），撤销后标志位恢复到未锁定（标志位为“01”）或轻量级锁定（标志位为“00”）的状态，后续的同步操作就按照轻量级锁那样去执行。

  偏向锁可以提高带有同步但无竞争的程序性能，但它同样是一个带有效益权衡性质的优化，也就是说它并非总是对程序运行有利。如果程序中大多数的锁都总是被多个不同的线程访问，那偏向模式就是多余的，有时使用参数`-XX:UseBiasedLocking`来禁止偏向锁优化反而能提升性能。

- **锁优化问题总结**

  - **锁优化**

    JDK1.6为了减少获得锁和释放锁带来的性能消耗，引入了偏向锁和轻量级锁，在JDK1.6中，锁一共有4个状态，级别从低到高依次是：无锁状态、偏向锁状态、轻量级锁状态和重量级锁状态，这几个状态会随着竞争情况逐渐升级。锁可以升级但不能降级，如果偏向锁升级成轻量级锁后就不能降级成偏向锁，这种只能升级不能降级的锁策略是为了提高获得锁和释放锁的效率。

  - **偏向锁的获得原理**

    大多数情况下，锁不仅不存在多线程竞争，而且总是由同一线程多次获得，为了让线程获得锁的代价更低而引入了偏向锁。当一个线程访问同步代码块并获取锁时，会在对象头和帧栈中的锁记录里存储锁偏向的线程ID，以后该线程再进入和退出同步代码块不需要进行CAS操作来加锁和解锁，只需要简单地测试一下对象头（synchronized用的锁存在Java的对象头里）的Mark Word里是否存储着指向当前线程的偏向锁。

    如果测试成功表示线程已经获得了锁，如果测试失败则需要再测试一下Mark Word（主要存储锁状态、对象的hashCode、对象的分代年龄、是否是偏向锁、锁标志位）中偏向锁的标识是否设置成了1（表示当前是偏向锁），如果设置了就尝试使用CAS将对象头的偏向锁指向当前线程，否则使用CAS竞争锁。 

  - **偏向锁的撤销原理**

    偏向锁使用了一种等到竞争出现才释放锁的机制，所以当其他线程尝试竞争偏向锁时，持有偏向锁的线程才会释放锁。偏向锁的撤销，需要等待全局安全点（该时间点上没有正在执行的字节码），它会首先暂停拥有偏向锁的线程，然后检查持有偏向锁的线程是否活着，如果线程不处于活动状态则将对象头设为无锁状态；如果线程还活着，拥有偏向锁的栈会被执行，遍历偏向对象的锁记录，栈中的锁记录和对象头的Mark Word要么重新偏向于其他线程，要么恢复到无锁或者标记对象不适合作为偏向锁，最后唤醒暂停的线程。 

  - **偏向锁的打开和关闭**

    偏向锁在Java6和Java7中默认是开启的，但是它在应用程序启动几秒后才激活，如果有必要可以使用JVM参数来关闭延迟：-XX：BiasedLockingStartupDelay=0。如果你确定应用程序里所有的锁通常情况处于竞争状态，可以通过JVM参数来关闭偏向锁：-XX：UseBiasedLocking=false，那么程序默认会进入轻量级锁状态。

  - **轻量级锁的加锁原理**

    线程在执行同步块之前，JVM会先在当前线程的栈帧中创建用于存储锁记录的空间，并将对象头中的Mark Word复制到锁记录中，称为Displaced Mark Word。然后线程尝试使用CAS将对象头中的Mark Word替换为指向锁记录的指针，如果成功那么当前线程获得锁，如果失败表示其他线程竞争锁，当前线程便尝试使用自旋来获取锁。 

  - **轻量级锁的解锁原理**

    轻量级锁解锁时，会使用原子的CAS操作将Displaced Mark Word替换回到对象头，如果成功则表示没有竞争发生。如果失败则表示当前存在锁竞争，锁就会膨胀为重量级锁。

    因为自旋会消耗CPU，为了避免无用的自旋（比如获得锁的线程被阻塞了），一旦锁升级为重量级锁，就不会再恢复到轻量级锁的状态。在这种情况下，其他线程视图获取锁时都会被阻塞，当持有锁的线程释放锁后才会唤醒这些线程，被唤醒的线程就会对锁资源进行新一轮的争夺。

  - **偏向锁、轻量级锁和重量级锁的区别**

    ①偏向锁的优点是加锁和解锁不需要额外的消耗，和执行非同步方法相比仅存在纳秒级的差距，缺点是如果线程间存在锁竞争会带来额外锁撤销的消耗，适用于只有一个线程访问同步代码块的场景。

    ②轻量级锁的优点是竞争的线程不会阻塞，提高了程序的响应速度，缺点是如果线程始终得不到锁会自旋消耗CPU，适用于追求响应时间和同步代码块执行非常快的场景。

    ③重量级锁的优点是线程竞争不使用自旋不会消耗CPU，缺点是线程会被阻塞，响应时间很慢，适应于追求吞吐量，同步代码块执行较慢的场景。

---

### AQS相关问题

- **概念**

  AQS是抽象队列同步器Abstract Queued Synchronizer，是用来构建锁或者其他同步组件的基础框架，它使用了一个int成员变量表示同步状态，通过内置的FIFO队列来完成资源获取线程的排队工作，并发包的作者期望它成为实现大部分同步需求的基础。

- **AQS的主要实现方式**

  同步器的主要使用方式是继承，子类通过继承同步器并实现它的抽象方法来管理同步状态，在抽象方法的实现过程中免不了要对同步状态进行更改，这时就需要使用同步器提供的3个方法（getState、setState和compareAndSetState）来进行操作，因为它们能够保证状态的改变是安全的。子类推荐被定义为自定义同步组件的静态内部类，同步器自身没有实现任何同步接口，它仅仅是定义了若干同步状态获取和释放的方法来供自定义同步组件使用，同步器既可以支持独占式地获取同步状态，也可以支持共享式地获取同步状态，这样就可以方便实现不同类型地同步组件（ReentrantLock、ReentrantReadWriteLock和CountDownLacth等）。

- **基于AQS实现的同步器有什么共同点**

  ①至少有一个acquire操作，这个操作阻塞调用线程，直到AQS的状态允许这个线程继续执行。FutureTask中的acquire操作为get方法调用。②至少有一个release操作，这个操作改变AQS的状态，改变后的状态可允许一个多多个阻塞线程解除阻塞。FutureTask中的release操作包括run方法和cancel方法。

- **同步器和锁的联系**

  同步器是实现锁的关键，在锁的实现中聚合同步器，利用同步器实现锁的语义。锁是面向使用者的，它定义了使用者与锁交互的接口，隐藏了实现细节；同步器面对的是锁的实现者，它简化了锁的实现方式，屏蔽了同步状态管理、线程的排队、等待与唤醒等底层操作。锁和同步器很好地隔离了使用者和实现者所关注的领域。

- **AQS的实现包括哪些方面**

  队列同步器的从实现角度分为多方面，主要包括同步队列、独占式同步状态的获取与释放、共享式同步状态的获取与释放，以及超时获取同步状态等同步器的核心数据与模板方法。

- **同步队列的原理**

  同步器依赖内部的同步队列（一个FIFO双向队列）来完成同步状态的管理，当前线程获取同步状态失败时，同步器会将当前线程以及等待状态等构造成一个节点并将其加入同步队列，同时会阻塞当前线程，当同步状态释放时，会把首节点中的线程唤醒，使其再次尝试获取同步状态。

- **同步队列的节点保存哪些信息**

  同步队列中的节点用来保存获取同步状态失败的线程引用、等待状态以及前驱和后继节点。节点是构成同步队列的基础，同步器拥有首节点和尾节点，没有成功获取同步状态的线程将会成为节点加入该队列的尾部。

- **同步队列节点的等待状态有哪些类型**

  ①CANCELLED，值为1，由于在同步队列中等待的线程等待超时或者被中断需要从同步队列中取消等待，节点进入该状态将不会变化。②SIGNAL，值为-1，后继节点的线程处于等待状态，而当前节点的线程如果释放了同步状态或者被取消，将会通知后继节点，使后继节点的线程得以运行。③CONDITION，值为-2，节点在等待队列中，节点线程等待在Condition上，当其他线程对Condition调用了signal方法后该节点将会从等待队列转移到同步队列中，加入到对同步状态的获取中。④PROPAGATE，值为-3，表示下一次共享式同步状态获取将会无条件地被传播下去。⑤INITIAL，值为0，初始状态。

- **独占式同步状态的获取和释放流程**

  在获取同步状态时，同步器调用acquire方法，维护一个同步队列，使用tryAcquire方法安全地获取线程同步状态，获取状态失败的线程会构造同步节点并通过addWaiter方法被加入到同步队列的尾部，并在队列中进行自旋。之后会调用acquireQueued方法使得该节点以死循环的方式获取同步状态，如果获取不到则阻塞节点中的线程，而被阻塞线程的唤醒主要依靠前驱节点的出队或阻塞节点被中断实现，移出队列或停止自旋的条件是前驱节点是头结点并且成功获取了同步状态。

  在释放同步状态时，同步器调用tryRelease方法释放同步状态，然后调用unparkSuccessor方法（该方法使用LockSupport唤醒处于等待状态的线程）唤醒头节点的后继节点，进而使后继节点重新尝试获取同步状态。

- **为什么只有当前驱节点是头节点时才能够尝试获取同步状态**

  头节点是成功获取到同步状态的节点，而头节点的线程释放同步状态之后，将会唤醒其后继节点，后继节点的线程被唤醒后需要检查自己的前驱节点是否是头节点。

  维护同步队列的FIFO原则，节点和节点在循环检查的过程中基本不相互通信，而是简单地判断自己的前驱是否为头节点，这样就使得节点的释放规则符合FIFO，并且也便于对过早通知的处理（过早通知是指前驱节点不是头结点的线程由于中断而被唤醒）。

- **共享式同步状态的获取和释放流程**

  在获取同步状态时，同步器调用acquireShared方法，该方法调用tryAcquireShared方法尝试获取同步状态，返回值为int类型，当返回值大于等于0时，表示能够获取到同步状态。因此在共享式获取锁的自旋过程中，成功获取到同步状态并退出自旋的条件就是该方法的返回值大于等于0。

  释放同步状态时，调用releaseShared方法，释放同步状态之后将会唤醒后续处于等待状态的节点。对于能够支持多线程同时访问的并发组件，它和独占式的主要区别在于tryReleaseShared方法必须确保同步状态（或资源数）线程安全释放，一般通过循环和CAS来保证，因为释放同步状态的操作会同时来自多个线程。

- **独占式超时获取同步状态的流程**

  通过调用同步器的doAcquireNanos方法可以超时获取同步状态，即在指定的时间段内获取同步状态，如果获取到同步状态则返回true，否则返回false。该方法提供了传统Java同步操作（例如synchronized关键字）所不具备的特性。

- **响应中断的同步状态获取过程**

  在JDK1.5之前当一个线程获取不到锁而被阻塞到synchronized之外时，对该线程进行中断操作，此时该线程的中断标志位会被修改，但线程依旧阻塞在synchronized上等待着获取锁。在JDK1.5中，同步器提供了acquireInterruptibly方法，这个方法在等待获取同步状态时，如果当前线程被中断，会立即返回并抛出InterruptedException。

- **独占式超时获取同步状态的原理**

  超时获取同步状态的过程可以被视为响应中断获取同步状态过程的“增强版”，doAcquireNanos方法在支持响应中断的基础上增加了超时获取的特性，针对超时获取，主要需要计算出需要睡眠的时间间隔nanosTimeout，为了防止过早通知，nanosTimeout的计算公式为nanosTimeout-=now-lastTime，其中now为当前唤醒时间，lastTime为上次唤醒时间，如果nanosTimeout大于0则表示超时时间未到，需要继续睡眠nanosTimeout纳秒，否则表示已经超时。

- **独占式超时获取同步状态和独占式获取同步状态的区别**

  在独占式超时获取同步状态的过程的doAcquireNanos中，当节点的前驱节点为头节点时尝试获取同步状态，如果获取成功则从该方法返回，这个过程和独占式同步获取的过程类似，但是在同步状态获取失败的处理上有所不同。

  如果当前线程获取同步状态失败，独占式超时获取同步状态中会判断是否超时，如果没有超时就重新计算超时间隔，然后使当前线程等待该间隔时间，如果在该时间内没有获取到同步状态就会从等待逻辑中自动返回。而独占式获取同步状态的过程中如果没有获取到同步状态就会使当前线程一直处于等待状态。

- **超时时间过小时对超时等待的影响**

  nanosTimeout过小时（小于等于1000纳秒），将不会使线程进行超时等待，而是进入快速自旋过程。因为非常短的超市等待无法做到精确，如果这时再进行超时等待相反会让nanosTimeout的超时从整体上表现得反而不精确，因此在超市非常短的情况下同步器会进入无条件的快速自旋。

---

### Lock相关问题

- **可重入锁**

  重入锁就是支持重进入的锁，它表示该锁能够支持一个线程对资源的重复加锁，除此之外该锁还支持获取锁的公平和非公平性选择。synchronized关键字隐式地支持重进入，ReentrantLock虽然不能像synchronized关键字一样支持隐式的重进入，但是在调用lock方法时已经获取到锁的线程能够再次调用lock方法获取锁而不被阻塞。

- **锁的公平性**

  如果在绝对时间上，先对锁进行获取的请求一定先被满足，那么这个锁是公平的，反正就是不公平的。公平的获取锁也就是等待时间最长的线程优先获取锁，也可以说锁的获取是顺序的，ReentrantLock的构造方法中可以通过设置参数控制锁的公平性。

  公平锁机制往往没有非公平锁的效率高，非公平锁地吞吐量更大，但是公平锁能够减少饥饿发生的概率，保证了锁地获取按照FIFO顺序，等待越久的请求越是能优先得到满足。

- **重进入**

  重进入指的是任意线程在获取到锁之后能够再次获取该锁而不会被锁所阻塞，该特性的实现需要解决两个问题：①线程再次获取锁，锁需要去识别获取锁的线程是否为当前占有锁的线程，如果是则再次获取成功。②锁的最终释放，线程重复n次获取了锁，随后在第n次释放该锁后，其他现场能够获取到该锁。锁的最终释放要求锁对于获取进行计数自增，计数表示当前锁被重复获取的次数，而被锁释放时，技术自减，当计数为0时表示锁已经成功释放。

- **ReentrantLock的可重入的实现**

  以非公平锁为例，通过nonfairTryAcquire方法获取锁，该方法增加了再次获取同步状态的处理逻辑：通过判断当前线程是否为获取锁的线程来决定获取操作是否成功，如果是获取锁的线程再次请求则将同步状态值进行增加并返回true，表示获取同步状态成功。

  成功获取锁的线程再次获取锁，只是增加了同步状态值，这就要求ReentrantLock在释放同步状态时减少同步状态值。如果该锁被获取了n次，那么前（n-1）次tryRelease方法必须都返回fasle，只有同步状态完全释放了才能返回true，可以看到该方法将同步状态是否为0作为最终释放的条件，当同步状态为0时，将占有线程设置为null，并返回true，表示释放成功。

  对于非公平锁只要CAS设置同步状态成功则表示当前线程获取了锁，而公平锁则不同。公平锁使用tryAcquire方法，该方法与nonfairTryAcquire的唯一区别就是判断条件中多了对同步队列中当前节点是否有前驱节点的判断，如果该方法返回true表示有线程比当前线程更早地请求获取锁，因此需要等待前驱线程获取并释放锁之后才能继续获取锁。 

- **读写锁**

  像Mutex和ReentrantLock都是排他锁，这些锁在同一时刻只允许一个线程进行访问，而读写锁在同一时刻可以允许多个读线程访问，但是在写线程访问时，所有的读线程和其他写线程均被阻塞。读写锁维护了一对锁，一个读锁和一个写锁，通过分离读写锁使得并发性相比一般的排他锁有了很大提升。

- **读写锁的特点**

  除了保证写操作对读操作的可见性以及并发性的提升之外，读写锁能够简化读写交互场景的编程方式。只需要在读操作时获取读锁，写操作时获取写锁即可，当写锁被获取时后续（非当前写操作线程）的读写操作都会被阻塞，写锁释放之后所有操作继续执行，编程方式相对于使用等待/通知机制的实现方式而言变得简单明了。

- **读写锁ReentrantReadWriteLock的特性**
  - 公平性选择：支持非公平（默认）和公平的锁获取方式吞吐量还是非公平性优于公平。
  - 重进入：该锁支持重进入，以读写线程为例：读线程在获取了读锁之后能够再次获得读锁。而写线程在获取了写锁之后能再次获得写锁，同时也可以获取读锁。
  - 锁降级：遵循获取写锁、获取读锁再释放写锁的次序，写锁能够降级为读锁。

- **读写锁的状态的设计**

  读写锁同样依赖自定义同步器来实现同步功能，而读写状态就是其同步器的同步状态。读写锁的自定义同步器需要在同步状态（一个整形变量）上维护多个读线程和一个写线程的状态。如果在一个int型变量上维护多种状态，就一定需要“按位切割使用”这个变量，读写锁将变量切分成了两个部分，高16位表示读，低16位表示写。

  假设同步状态值为S，写状态等于S&0x0000FFFF（将高17位全部抹去），读状态等于S>>>16（无符号右移16位），当写状态增加1时，等于S+1，当读状态增加1时，等于S+（1<<16）。根据状态的划分能得出一个推论：S不等于0时，当写状态等于0时，则读状态大于0，即读锁已被获取。

- **写锁的获取和释放过程**

  写锁是一个支持重进入的排他锁，如果当前线程已经获得了写锁则增加写状态，如果当前线程在获取写锁时，读锁已经被获取（读状态不为0）或者该线程不是已经获得写锁的线程则当前线程进入等待状态。写锁的释放与ReentrantLock的释放过程基本类似，每次释放均减少写状态，当写状态为0时表示写锁已被释放，从而等待的读写线程能够继续访问读写锁，同时前次写线程的修改对后续读写线程可见。

- **为什么存在读锁时写锁会阻塞**

  读写锁要确保写锁的操作对读锁可见，如果允许读锁在已被获取的情况下对写锁的获取，那么正在运行的其他读线程就无法感知到当前写线程的操作。因此只有等待其他读线程都释放了读锁，写锁才能被当前线程获取，而写锁一旦被获取则其他读写线程的后续访问均被阻塞。

- **读锁的获取和释放过程**

  读锁是一个支持重进入的共享锁，它能够被多个线程同时获取，在没有其他写线程访问（或者写线程为0）时，读锁总会被成功地获取，而所做的只是线程安全地增加读状态。如果当前线程已经获取了读锁，则增加读状态。如果当前线程在获取读锁时，写锁已被其他线程获取则进入等待状态。如果当前线程获取了写锁或者写锁未被获取，则当前线程（线程安全，依靠CAS保证）增加读状态，成功获取读锁。

  读锁的每次释放均会减少读状态，减少的值是（1<<16），读锁的每次释放是线程安全的，可能有多个读线程同时释放读锁。

- **JDK1.6对读锁的改动**

  获取读锁的实现从JDK1.5到JDK1.6变得复杂许多，主要原因是新增了一些功能，例如getReadHoldCount方法，作用是返回当前线程获取读锁的次数。读状态是所有线程获取读锁次数的总和，而每个线程各自获取读锁的次数只能选择保存在ThreadLocal中，由线程自身维护，这使获取读锁的实现变得复杂。

- **锁降级**

  锁降级指的是写锁降级成为读锁，如果当前线程拥有写锁，然后将其释放，最后再获取读锁，这种分段完成的过程不能称之为锁降级。锁降级指的是把持住（当前拥有的）写锁，再获取到读锁，随后释放先前拥有的写锁的过程。

- **锁降级中读锁的获取是否有必要**

  是必要的，主要是为了保证数据的可见性，如果当前线程不获取读锁而是直接释放写锁，假设此刻另一个线程A获取了写锁修改了数据，那么当前线程是无法感知线程A的数据更新的。如果当前线程获取读锁，即遵循锁降级的步骤，线程A将会被阻塞，直到当前线程使用数据并释放读锁之后，线程A才能获取写锁并进行数据更新。

---

### Condition

- **Condition的作用**

  Condition接口提供了类似Object监视器方法，与Lock配合可以实现等待/通知模式。Condition对象是由Lock对象创建出来的，因此Condition是依赖Lock对象的。一般会将Condition对象作为成员变量，当调用await方法后当前线程会释放锁并在此等待，而其他线程调用Condition对象的signal方法，通知当前线程后，当前线程才从await方法返回并且在返回前已经获取了锁。

- **Condition的实现**

  ConditionObject是同步器AQS的内部类，因为Condition的操作需要获取相关的锁，所以作为同步器的内部类也较为合理。每个Condition对象都包含着一个等待队列，该等待队列是Condition对象实现等待/通知功能的关键。Condition的实现主要包括了等待队列、等待和通知。

- **等待队列的原理**

  等待队列是一个FIFO队列，在队列中的每个节点都包含了一个线程引用，该线程就是在ConditionObject对象上等待的线程，如果一个线程调用了await方法，那么该线程会释放锁、构造成节点加入等待队列并进入等待状态。事实上，节点的定义复用了同步其中节点的定义，也就是说同步队列和等待队列中的节点类型都是同步器的静态内部类Node。

  一个ConditionObject包含一个等待队列，ConditionObject拥有首节点和尾节点。Object拥有首尾节点的引用，而新增节点只需要将原有的尾节点nextWaiter指向它，并且更新尾节点即可。节点引用更新的过程并没有用CAS保证，因为调用await方法的线程必定是获取了锁的线程，也就是说该过程是由锁来保证线程安全的。

- **await方法的原理**

  如果从队列的角度看await方法，当调用await方法时相当于同步队列的首节点（获取了锁的节点）移动到Condition对象的等待队列中，首节点不会直接加入等待队列，而是通过addConditionWaiter方法把当前线程构造成一个新的节点并将其加入等待队列中。加入等待队列后，释放同步状态，唤醒同步队列中的后继节点然后进入等待状态。如果不是通过其他线程调用signal方法唤醒而是对await线程进行中断，会抛出InterruptedException。

- **signal方法的原理**

  该方法会唤醒在等待队列中等待时间最长的节点（首节点），在唤醒节点之前，会将节点移到同步队列中。调用该方法的前置条件是当前线程必须获取了锁，signal方法进行了检查，判断当前线程是否是获取了锁的线程，接着获取等待队列的首节点，将其移动到同步队列并使用LockSupport唤醒节点中的线程。被唤醒后的线程将从await方法中的while循环退出，进而调用同步器的acquireQueued方法加入到获取同步状态的竞争中。成功获取同步状态（或者说锁）后，被唤醒的线程将从先前调用的await方法返回，此时该线程已成功获取了锁。signalAll方法相当于对等待队列中的每个节点执行一次signal方法，效果就是将等待队列中的节点全部移到到同步队列中并唤醒每个节点的线程。

- **阻塞队列**

  阻塞队列是一个支持两个附加操作的队列，这两个附加的操作支持阻塞的插入和移除方法。当队列满时，队列会阻塞插入元素的线程，直到队列不满。当队列为空时，获取元素的线程会等待队列变为非空。阻塞队列常用于生产者和消费者的场景，生产者向队列里添加元素，消费者从队列中获取元素，阻塞队列就是生产者用来存放元素，消费者用来获取元素的容器。

  - **Java中的阻塞队列**

    - ArrayBlockingQueue，一个由数组结构组成的有界阻塞队列，按照FIFO的原则对元素排序，默认情况下不保证线程公平地访问队列，有可能先阻塞地线程最后才访问队列。

    - LinkedBlockingQueue，一个由链表结构组成的有界阻塞队列，队列的默认和最大长度为Integer的最大值，按照FIFO原则排序。

    - PriorityBlockingQueue，一个支持优先级排序的无界阻塞队列，默认情况下元素按照顺序升序排序。也可以自定义compareTo方法指定元素排序规则，或者初始化时指定构造方法的参数Comparator对元素排序，不能保证同优先级元素的顺序。

    - DelayQueue，一个支持延时获取元素的无界阻塞队列，使用优先级队列实现。队列中的元素必须实现Delayed接口，在创建元素时可以指定多久才能从队列中获取当前元素，只有延时期满时才能从队列中获取元素。适用于以下场景：①缓存系统的设计，一旦能从延迟队列获取元素说明缓存有效期到了。②定时任务调度，保存当天将要执行的任务和执行时间，一旦获取到任务就立刻开始执行。

    - SynchronousQueue，一个不存储元素的阻塞队列，每一个put操作必须等待一个take操作，否则不能继续添加元素。默认使用非公平策略，也支持公平策略，适用于传递性场景，吞吐量高于ArrayBlockingQueue和LinkedBlockingQueue。

    - LinkedTransferQueue，一个由链表结构组成的无界阻塞队列，相对于其他阻塞队列多了tryTransfer和transfer方法。transfe方法：如果当前有消费者正在等待接收元素，transfer方法可以把生产者传入的元素立刻传输给消费者，如果没有，会将元素放在队列的尾节点等到该元素被消费者消费了才返回。tryTransfer方法：用来试探生产者传入的元素能否直接传给消费者，如果没有消费者等待接收元素返回false，和transfer的区别时无论消费者是否接受都会立即返回，transfer是等到消费者消费了才返回。

    - LinkedBlockingDeque，一个由链表结构组成的双向阻塞队列，可以从队列的两端插入和移除元素，多了一个操作队列的入口，在多线程同时入队时就少了一半竞争。

  - **阻塞队列的实现原理**

    使用通知模式实现，所谓通知模式就是当生产者往满的队列里添加元素时会阻塞住生产者，当消费者消费了一个队列中的元素后，会通知生产者当前队列可用。JDK中使用了Condition条件对象来实现。当往队列里插入一个元素，如果队列不可用，那么阻塞生产者主要通过LockSupport.park(this)实现。

---

### 并发工具

- **CountDownLatch**

  允许一个或多个线程等待其他线程完成操作，构造方法接收一个int类型的参数作为计数器，如果要等待n个点就传入n。每次调用countDown方法时n就会减1，await方法会阻塞当前线程直到n变为0，由于countDown方法可用在任何地方，所以n个点既可以是n个线程也可以是1个线程里的n个执行步骤。用在多线程时，只需要把这个CountDownLatch的引用传递到线程里即可。

- **CyclicBarrier**

  CyclicBarrier是同步屏障，它的作用是让一组线程到达一个屏障（或同步点）时被阻塞，直到最后一个线程到达屏障时，屏障才会开门，所有被拦截的线程才会继续运行。构造方法中的参数表示屏障拦截的线程数量，每个线程调用await方法告诉CyclicBarrier自己已到达屏障，然后当前线程被阻塞。还支持在构造方法中传入一个Runable类型的任务，当线程到达屏障时会优先执行该任务。适用于多线程计算数据，最后合并计算结果的应用场景。

  - **CountDownLacth和CyclicBarrier的区别**

    CountDownLacth的计数器只能用一次，而CyclicBarrier的计数器可使用reset方法重置，所以CyclicBarrier能处理更为复杂的业务场景，例如计算错误时可用重置计数器重新计算。CyclicBarrier还提供了其他有用的方法，例如getNumberWaiting可以获取CyclicBarrier阻塞的线程数量，isBroken方法用来了解阻塞的线程是否被中断。

- **Semaphore**

  Semaphore是信号量，用来控制同时访问特定资源的线程数量，它通过协调各个线程以保证合理的使用公共资源。信号量可以用于流量控制，特别是公共资源有限的应用场景，比如数据库连接。Semaphore的构造方法参数接收一个int型数字，表示可用的许可证数量，即最大并发数。使用acquire获得一个许可证，使用release方法归还许可证，还可以用tryAcquire尝试获得许可证。

- **Exchanger**

  Exchanger交换者是用于线程间协作的工具类，用于进行线程间的数据交换。它提供一个同步点，在这个同步点，两个线程可以交换彼此的数据。这两个线程通过exchange方法交换数据，如果第一个线程先执行exchange方法它会一直等待第二个线程也执行exchange方法，当两个线程都到达同步点时这两个线程就可以交换数据，将本线程生产出的数据传递给对方。应用场景包括遗传算法、校对工作等。

---

## 线程池和Executor框架

### 线程池

- **线程池的好处**
  - 降低资源消耗，通过重复利用已创建的线程降低线程创建和消耗的开销。
  - 提高响应速度，当任务到达时，任务可以不需要等到线程创建就可以立即执行。
  - 提高线程的可管理性，线程是稀缺资源，如果无限制地创建不仅会消耗系统资源，还会降低系统的稳定性，使用线程池可以进行统一分配、调优和监控。

- **线程池的工作流程**

  - 线程池判断核心线程池是否已满，如果不是则创建一个新的工作线程来执行任务（工作线程数<corePoolSize，这一步需要获取全局锁）。
  - 如何核心线程池已经满了，判断工作队列是否已满，如果没有就将任务存储在工作队列中（工作线程数>=corePoolSize）。
  - 如果工作队列满了，判断线程池是否已满，如果没有就还是创建一个新的工作线程来执行任务（工作线程数<maximumPoolSize）。
  - 如果线程池已满，就按照线程池的拒绝执行策略来处理无法执行的任务（工作线程数>maximumPoolSize）。

  线程池采取这种设计思路是为了在执行execute方法时尽可能地避免获取全局锁，在线程池完成预热之后，即当前工作线程数>=corePoolSzie时，几乎所有的execute方法都是执行步骤2，不需要获取全局锁。

- **工作线程的任务**

  线程池创建线程时，会将线程封装成工作线程Worker，Worker在执行完任务之后，还会循环获取工作队列中的任务来执行。线程池中的线程执行任务分为两种情况：①在execute方法中创建一个线程时会让这个线程执行当前任务。②这个线程执行完任务之后，就会反复从阻塞工作队列中获取任务并执行。

- **ThreadPoolExecutor创建参数**
  - corePoolSize：线程池的基本大小，当提交一个任务到线程池时，线程池会创建一个线程来执行任务，即使其他空闲的基本线程能够执行新任务也会创建线程，等到需要执行的任务数大于线程池的基本大小时就不再创建。如果调用了线程池的prestartAllCoreThreads方法，线程池会提前创建并启动所有的基本线程。
  - workQueue：工作队列，用于保存等待执行任务的阻塞队列，可以选择以下的阻塞队列：ArrayBlockQueue、LinkedBlockingQueue、SynchronousQueue、PriorityBlockQueue等。
  - maximumPoolSize：线程池允许的最大线程数，如果工作队列已满，并且创建的线程数小于最大线程数，则线程池还会创建新的线程执行任务，如果使用的时无界阻塞队列该参数是无意义的。
  - threadFactory：用于设置创建线程的工厂，可以通过线程工厂给每个创建出来的线程设置更有意义的名字。
  - handler：拒绝策略，当队列和线程池都满了说明线程池处于饱和状态，那么必须采取一种拒绝策略处理新提交的任务，默认情况下使用AbortPolicy直接抛出异常，CallerRunsPolicy表示重新尝试提交该任务，DiscardOldestPolicy表示抛弃队列里最近的一个任务并执行当前任务，DiscardPolicy表示直接抛弃当前任务不处理。也可以自定义该策略。
  - keepAliveTime：线程活动的保持时间，线程池工作线程空闲后保持存活的时间，所以如果任务很多，且每个任务的执行时间较短，可以调大时间提高线程的利用率。
  - unit：线程活动保持时间的单位，有天、小时、分钟、毫秒、微秒、纳秒。

- **如何像线程池提交任务**

  可以使用execute和submit方法向线程池提交任务。execute方法用于提交不需要返回值的任务，所以无法判断任务是否被线程池执行成功了。submit方法用于提交需要返回值的任务，线程池会返回一个Future类型的对象，通过该对象可以判断任务是否执行成功，并且可以通过该对象的get方法获取返回值，get方法会阻塞当前线程直到任务完成，带超时参数的get方法会在指定时间内返回，这时任务可能还没有完成。

- **关闭线程池的原理**

  可以通过调用线程池的shutdown或shutdownNow方法来关闭线程池，它们的原理是遍历线程池中的工作线程，然后逐个调用线程的interrupt方法来中断线程，所以无法响应中断的任务可能永远无法终止。区别是shutdownNow首先将线程池的状态设为STOP，然后尝试停止所有正在执行或暂停任务的线程，并返回等待执行任务的列表，而shutdown只是将线程池的状态设为SHUTDOWN，然后中断所有没有正在执行任务的线程。

  只要调用了这两个方法中的一个，isShutdown方法就会返回true，当所有任务都已关闭后才表示线程池关闭成功，这时调用isTerminated方法会返回true。通常调用shutdown方法来关闭线程池，如果任务不一定要执行完则可以调用shutdownNow方法。

- **合理设置线程池**

  首先可以从以下角度分析：①任务的性质：CPU密集型任务、IO密集型任务和混合型任务。②任务的优先级：高、中和低。③任务的执行时间：长、中和短。④任务的依赖性：是否以来其他系统资源，如数据库连接。

  性质不同的任务可以用不同规模的线程池分开处理，CPU密集型任务应配置尽可能小的线程，如配置Ncpu+1个线程的线程池。由于IO密集型任务线程并不是一直在执行任务，则应配置尽可能多的线程，如2*Ncpu。混合型任务如果可以拆分将其拆分为一个CPU密集型任务和一个IO密集型任务，只要这两个任务执行的时间相差不是太大那么分解后的吞吐量将高于串行执行的吞吐量，如果相差太大则没必要分解。

  优先级不同的任务可以使用优先级队列PriorityBlockingQueue处理。

  执行时间不同的任务可以交给不同规模的线程池处理，或者使用优先级队列。

  以来数据库连接池的任务，由于线程提交SQL后需要等待数据库返回的结果，等待的时间越长CPU空闲的时间就越长，因此线程数应该尽可能地设置大一些提高CPU的利用率。

  建议使用有界队列，能增加系统的稳定性和预警能力，可以根据需要设置的稍微大一些。

- 线程池的监控

  - taskCount，线程池需要执行的任务数量。
  - completedTaskCount，线程池在运行过程中已经完成的任务数量，小于或等于taskCount。
  - largestPoolSize，线程池里曾经创建过的最大线程数量，通过这个数据可以知道线程池是否曾经满过，如果该数值等于线程池的最大大小表示线程池曾经满过。
  - getPoolSize，获取线程池的线程数量，如果线程池不销毁的化线程池里的线程不会自动销毁，所以这个数值只增不减。
  - getActiveCount，获取活动的线程数。

  通过扩展线程池进行监控，可以继承线程池来自定义，重写线程池的beforeExecute、afterExecute和terminated方法，也可以在任务执行前、执行后和线程池关闭前来执行一些代码进行监控，例如监控任务的平均执行时间、最大执行时间和最小执行时间。

- **使用无界阻塞队列对线程池的影响**

  ①当线程池中的线程数达到corePoolSize之后新任务将在无界队列中等待，因此线程池中的数量不会超过corePoolSize。②因此使用无界队列时maximumPoolSize和keepAliveTime均是无效参数。③由于使用无界队列，线程池不会拒绝任务。

---

### Executor框架

- **Executor框架的调度模型**

  在HotSpot VM的线程模型中，Java线程被一对一映射为本地操作系统线程，Java线程启动时会创建一个本地操作系统线程，当该Java线程终止时，这个操作系统线程也会被回收，操作系统会调度所有线程并将它们分配给可用的CPU。

  Executor框架的调度模型是一种两级调度模型。在上层，Java多线程程序通常把应用分解为若干任务，然后使用用户级的调度器即Executor框架将这些任务映射为固定数量的线程；在底层，操作系统内核将这些线程映射到硬件处理器上。

- **Executor框架的结构**

  主要由以下三部分组成：

  ①任务，包括被执行任务需要实现的接口，Runnable或Callable接口。

  ②任务的执行，包括任务执行机制的核心接口Executor（Executor框架的基础，将任务的提交和执行分离开来），以及继承自Executor的ExecutorService接口（ThreadPoolExecutor和ScheduledThreadPoolExecutor）。

  ③异步计算的结果，包括接口Future和实现Future接口的FutureTask类。当我们把Runnable接口或Callable接口的实现类提交（submit）给ThreadPoolExecutor或ScheduledThreadPoolExecutor时，ThreadPoolExecutor或ScheduledThreadPoolExecutor会向我们返回一个FutureTask对象。

- **ThreadPoolExecutor**

  ThreadPoolExecutor是Executor框架最核心的类，是线程池的实现类，主要有三种。

  ①FixedThreadPool，可重用固定线程数的线程池，corePoolSize和maximumPoolSize都被设置为创建时的指定参数nThreads，当线程池中的线程数大于corePoolSize时，keepAliveTime为多余的空闲线程等待新任务的最长时间，超过这个时间后多余的线程将被终止，这里将其设置为0L表示多余空闲线程将被立即终止。该线程池使用的工作队列是无界阻塞队列LinkedBlockingQueue（队列容量为Integer的最大值）。适用于为了满足资源管理的需求，而需要限制当前线程数量的应用场景，适用于负载比较重的服务器。

  ②SingleThreadExecutor，使用单个线程的线程池，corePoolSize和maximumPoolSize都被设置为1，其他参数和FiexedThreadPool相同。适用于需要保证顺序执行各个任务，并且在任意时间点不会有多个线程是活动的的应用场景。

  ③CachedThreadPool，一个根据需要创建线程的线程池，corePoolSize被设置为0，maximumPoolSize被设置为Integer的最大值，将keepAliveTime设为60L，意味着空闲线程等待时间最长为1分钟。该线程池使用的工作队列是没有容量的SynchronousQueue，但是maximumPoolSize设为Integer最大值，如果主线程提交任务的速度高于线程处理的速度，线程池会不断创建新线程，极端情况下会创建过多线程而耗尽CPU和内存资源。适用于执行很多短期异步任务的小程序，或者负载较轻的服务器。

- **ScheduledThreadPoolExecutor**

  ScheduledThreadPoolExecutor继承自ThreadPoolExecutor，主要用来在给定的延迟之后运行任务，或者定期执行任务。其功能与Timer类似，但是功能更加强大、更灵活。Timer对应的是单个后台线程，而ScheduledThreadPoolExecutor可以在构造方法中指定多个后台线程数。为了实现周期性的执行任务，使用DelayQueue作为工作队列，获取任务和执行周期任务后的处理都不同，主要有两种。

  ①ScheduledThreadPool：包含若干线程的ScheduledThreadPoolExecutor，创建固定线程个数的线程池。适用于需要多个后台线程执行周期任务，同时为了满足资源管理的需求而需要限制后台线程数量的应用场景。

  ②SingleThreadScheduledExecutor：只包含一个线程的ScheduledThreadPoolExecutor，适用于单个后台线程执行周期任务，同时需要保证顺序执行各个任务的应用场景。

  - **ScheduledThreadPoolExecutor的原理**

    将待调度任务放入一个DelayQueue中，调度任务主要有三个参数，long类型的time表示这个任务将要被执行的具体时间，long类型的sequenceNumber表示这个任务被添加到线程池的序号，long类型的period表示任务执行时间间隔。DelayQueue封装了一个PriorityQueue，队列按照time进行排序，如果time相同则比较sequenceNumber，越小的排在前面，即如果两个任务的执行时间相同，先提交的任务先被执行。

- **Runnable接口和Callable接口的区别**

  两个接口的相同点是Runnable接口和Callable接口的实现类都可以被ThreadPoolExecutor或ScheduledThreadPoolExecutor执行，不同点是Runnable不会返回结果，Callable可以返回结构。除了可以自己创建Callable接口的对象外，还可以使用工厂类Executors将一个Runnable对象包装为一个Callable对象。

- **FutureTask**

  FutureTask除了实现了Future接口之外，还实现了Runnable接口。因此FutureTask可以交给Executor执行，也可以由调用线程直接执行即调用FutureTask对象的run方法，根据run方法被执行的时机，FutureTask可以处于三种状态：①未启动，当FutureTask对象被创建，且没有执行run方法之前的状态。②已启动，当run方法处于被执行过程中，FutureTask对象处于已启动状态。③已完成，当run方法执行后正常完成或执行run方法中抛出异常或调用cancel方法取消时，FutureTask对象处于已完成状态。

  当处于未启动或已启动状态时，get方法将阻塞线程，当处于已完成状态时会立即返回结果或抛出异常。当处于未启动状态时，cancel方法会导致此任务永远不会执行，当处于已启动状态时，执行cancel(true)方法，将以中断执行此任务的方式来试图停止该任务，执行cancel(false)方法，将不会对正在执行此任务的线程产生应用，当处于已完成状态时，cancel方法返回false。

  - **FutureTask的实现原理**

    FutureTask的实现基于AQS，基于合成复用的设计原则，FutureTask声明了一个内部私有的继承于AQS的子类Sync，对Future的所有公有方法的调用都会委托给这个内部的子类。AQS被作为模板方法模式的基础类提供给FutureTask的内部子类Sync，这个内部的子类只需要实现状态检查和更新的方法即可，这些方法将控制FutureTask的获取和释放操作。具体来说，Sync实现了AQS的tryAcquireShared和tryReleaseShared方法来检查和更新同步状态。

  - **FutureTask的get方法原理**

    ①调用AQS的acquireSharedInterruptibly方法，首先回调在子类Sync中实现的tryAcquireShared方法来判断acquire操作是否可以成功。acquire操作成功的条件为：state为执行完成状态或取消状态，且runner不为null。②如果成功get方法立即返回，如果失败则到线程等待队列中去等待其他线程执行release操作。③当其他线程执行release操作唤醒当前线程后，当前线程再次执行tryAcquireShared将返回1，当前线程将理课线程等待队列并唤醒它的后继线程。④返回最终结果或抛出异常。

   

  - **FutureTask的run方法原理**

    ①执行在构造方法中的指定任务。②以原子方式更新同步状态，如果操作成功就设置代表计算结果的变量result的值为Callable的call方法的返回值，然后调用AQS的releaseShared方法。③AQS的releaseShared方法首先回调子类Sync中实现的tryReleaseShared来执行release操作（设置运行任务的线程runner为null，然后返回true），然后唤醒线程等待队列的第一个线程。④调用FutureTask的done方法。

---

# JVM

## 内存区域与内存回收异常

### 运行时数据区

Java虚拟机在执行Java程序的过程中会把它所管理的内存划分为若干个不同的数据区域。这些区域有各自的用途，以及创建和销毁的时间，有的区域随着虚拟机的进程的启动而一直存在，有些区域则是依赖用户线程的启动和结束而建立和销毁。根据《Java虚拟机规范》，Java虚拟机所管理的内存将包括以下几个运行时数据区：

- **程序计数器**

  程序计数器是一块较小的内存空间，它可以看作是当前线程所执行的字节码的行号指示器。在Java虚拟机的概念模型中，字节码解释器工作时就是通过改变这个计数器的值来选取下一条需要执行的字节码指令，它是程序控制流的指示器，分支、循环、跳转、异常处理、线程恢复等基础功能都需要依赖这个计数器完成。

  由于Java虚拟机的多线程是通过线程轮流切换、分配处理器执行时间的方式来实现的，在任何一个确定的时刻，一个处理器都只会执行一条线程中的指令。因此为了线程切换后能恢复到正确的执行位置，每条线程都需要有一个独立的程序计数器，各条线程之间计数器互不影响，独立存储，我们称这类内存区域为“线程私有”的内存区域。

  如果线程正在执行的是一个Java方法，这个计数器记录的是正在执行的虚拟机字节码指令的地址；如果正在执行的是本地（Native）方法，这个计数器值则应为空（Undefined）。此内存区域是唯一一个在《Java虚拟机规范》中没有规定任何内存溢出情况的区域。

- **Java虚拟机栈**

  与程序计数器一样，Java虚拟机栈也是线程私有的，它的生命周期与线程相同。虚拟机栈描述的是Java方法执行的线程内存模型：每个方法被执行的时候，Java虚拟机都会同步创建一个帧栈用于存储局部变量表、操作数栈、动态连接、方法出口等信息。每一个方法被调用直至执行完毕的过程，就对应着一个帧栈在虚拟机中从入栈到出栈的过程。

  局部变量表存放了编译器可知的各种Java虚拟机基本数据类型（boolean、byte、char、short、int、float、long、double）、对象引用（reference类型，它并不等同于对象本身，可能是一个指向对象起始地址的引用指针，也可能是一个代表对象的句柄或者其他与此对象相关的位置）和returnAddress类型（指向了一条字节码指令的地址）。

  这些数据类型在局部变量表中的存储空间以局部变量槽（Slot）表示，其中64位长度的long和double类型数据会占用两个变量槽，其余数据类型只占用一个。局部变量表所需的内存空间在编译期间完成分配，当进入一个方法时，这个方法需要在帧栈中分配多大的局部变量空间是完全确定的，在方法运行期间不会改变局部变量表的大小（大小指槽的数量）。

  该区域有两类异常情况：如果线程请求的栈深度大于虚拟机所允许的深度，将抛出StackOverflowError异常；如果Java虚拟机栈容量可以动态扩展，当栈扩展时无法申请到足够的内存会抛出OutOfMemoryError异常（HotSpot虚拟机栈容量不可以动态扩展，不存在此问题）。

- **本地方法栈**

  本地方法栈与虚拟机栈的作用非常相似，不同的是虚拟机栈为虚拟机执行Java方法（字节码）服务，而本地方法栈则是为虚拟机栈用到的本地（Native）方法服务。

  《Java虚拟机规范》对本地方法栈中方法所用的语言、使用方式与数据结构无强制规定，因此具体的虚拟机可根据需要自由实现，甚至有的虚拟机（例如HotSpot）直接将虚拟机栈和本地方法栈合二为一。与虚拟机栈一样，本地方法栈也会在栈深度异常和栈扩展失败时分别抛出StackOverflowError和OutOfMemoryError异常。

- **Java堆**

  Java堆是虚拟机所管理的内存中最大的一块。堆是被所有线程共享的一块内存区域，在虚拟机启动时创建。此区域的唯一目的就是存放对象实例，Java里几乎所有的对象实例都在这里分配内存。

  Java堆是垃圾收集器管理的内存区域，从内存回收的角度看，由于现代垃圾收集器大部分都是基于分代收集理论设计的，所以Java堆中经常会出现”新生代“，”老年代“等名词，这些区域划分其实是不够准确的。这些区域划分只是一部分垃圾收集器的共同特性或设计风格，并非某个Java虚拟机具体实现的固有内存布局，更不是《Java虚拟机规范》中的划分。由于垃圾收集技术已经发生了很大的改变，HotSpot中也出现了不采用分代设计的新垃圾收集器，因此把堆分代划分的说法就有许多需要商榷的地方。

  Java堆可以处于物理上不连续的内存空间中，但在逻辑上它应该被视为连续的。但对于大对象（例如数组），多数虚拟机实现出于简单、存储高效的考虑，很可能会要求连续的内存空间。

  Java堆既可以被实现成固定大小的，也可以是可扩展的，不过当前主流的Java虚拟机都是按照可扩展来实现的（通过参数-Xmx和-Xms设定）。如果在堆中没有内存完成实例分配，并且堆也无法再扩展时，虚拟机将抛出OutOfMemoryError异常。

- **方法区**

  方法区和Java堆一样，是各个线程共享的内存区域，它用于存储被虚拟机加载的类型信息、常量、静态变量、即时编译器编译后的代码缓存等数据。虽然《Java虚拟机规范》中把方法区描述为堆的一个逻辑部分，但是它却有一个别名叫做”非堆“，目的是与堆区分开来。

  JDK8之前使用永久代来实现方法区，这种设计导致了Java应用更容易遇到内存溢出问题，因为永久代有`-XX:MaxPermSize`的上限，即使不设置也有默认大小。JDK6时HotSpot的开发团队就准备放弃永久代，改用本地内存来实现方法区，JDK7时已经把原本放在永久代的字符串常量池、静态变量等移出，到了JDK8时永久代被完全废弃了，改用与JRockit一样在本地内存中实现的元空间来代替，把JDK7中永久代剩余内容（主要是类型信息）全部移到元空间。

  《Java虚拟机规范》对方法区的约束很宽松，除了和Java堆一样不需要连续的内存和可以选择固定大小或者可扩展外，甚至还可以选择不实现垃圾回收。垃圾回收行为在该区域出现较少，主要回收目标是针对常量池的回收和对类型的卸载，一般来说该区域的回收效果比较难令人满意，尤其是类型的卸载，条件十分苛刻。

  根据《Java虚拟机规范》如果方法区无法满足新的内存分配需求时，将抛出OutOfMemoryError异常。

- **运行时常量池**

  运行时常量池是方法区的一部分，Class文件中除了有类的版本、字段、方法、接口等描述信息外，还有一项信息是常量池表，用于存放编译器生成的各种字面量与符号引用，这部分内容将在类加载后存放到方法区的运行时常量池中。一般来说，除了保存Class文件中描述的符号引用外，还会把符号引用翻译出来的直接引用也存储在运行时常量池中。

  运行时常量池相对于Class文件常量池的另一个重要特征是具备动态性，Java语言并不要求常量一定只有编译期才能产生，也就是说并非预置入Class文件中常量池的内容才能进入方法区运行时常量池，运行期间也可以将新的常量放入池中，这种特性被利用的较多的是String类的intern()方法。

  既然运行时常量池是方法区的一部分，自然受到方法区内存的限制，当常量池无法再申请到内存时会抛出OutOfMemoryError异常。

- **直接内存**

  直接内存不是Java虚拟机运行时数据区的一部分，也不是《Java虚拟机规范》中定义的内存区域，但是这部分内存也被频繁使用，而且也可能导致内存溢出异常。

  JDK1.4中新加入了NIO类，引入了一种基于通道与缓冲区的IO方式，它可以使用Native函数库直接分配堆外内存，然后通过一个存储在Java堆里的DirectByteBuffer对象作为这块内存的引用进行操作，这样能在一些场景中显著提高性能，避免了在Java堆和Native堆中来回复制数据。

  本机直接内存的分配不会收到Java堆大小的限制，但还是会收到本机总内存大小以及处理器寻址空间的限制，一般配置虚拟机参数时会根据实际内存去设置-Xmx等参数信息，但经常忽略掉直接内存，使得各个内存区域总和大于物理内存限制，从而导致动态扩展时出现OutOfMemoryError异常。

---

### HotSpot虚拟机对象揭秘

- **对象的创建**

  当Java虚拟机遇到一条字节码new指令时，首先将检查该指令的参数能否在常量池中定位到一个类的符号引用，并且检查这个符号引用代表的类是否已被加载、解析和初始化过。如果没有就必须先执行相应的类加载过程。

  在类加载检查通过后虚拟机将为新生对象分配内存。对象所需内存的大小在类加载完成后便可完全确定，位对象分配空间的任务实际上等同于把一块确定大小的内存块从Java堆中划分出来。假设Java堆内存是绝对规整的，所有被使用过的内存都被放在一边，空闲的内存被放在另一边，中间放着一个指针作为分结点的指示器，那分配内存就仅是把该指针向空闲方向挪动一段与对象大小相等的距离，这种分配方式叫做“指针碰撞”。

  但如果Java堆中的内存不是规整的，已被使用的内存和空闲内存相互交错，那么虚拟机就必须维护一个列表，记录哪些内存块是可用的，在分配的时候从列表中找到一块足够大的空间划分给对象实例，并更新列表上的记录，这种分配方式叫做“空闲列表”。

  选择哪种分配方式由Java堆是否规整决定，Java堆是否规整又由所采用的垃圾回收器是否带有空间压缩整理能力决定。因此当使用Serial、ParNew等带压缩整理过程的收集器时，系统采用的分配算法时指针碰撞，既简单又高效；当使用CMS这种基于清除算法的垃圾收集器时，理论上只能采用较复杂的空间列表来分配内存。

  除了划分可用空间外还必须考虑分配内存的线程安全问题：对象创建在虚拟机中是十分频繁的，即使仅修改一个指针所指向的位置，在并发情况下也不是线程安全的，可能出现正在给对象A分配内存，指针还没来得及修改，对象B又同时使用了原来的指针来分配内存的情况。解决该问题有两个方法：①对分配内存空间的动作进行同步处理，即虚拟机采用CAS加失败重试的方式保证更新操作的原子性。②把内存分配的动作按照线程划分在不同的空间中进行，即每个线程在Java堆中预先分配一小块内存，叫做本地线程分配缓冲TLAB，哪个线程要分配内存就在哪个线程的本地缓冲区中分配，只有本地缓冲区用完了分配新缓冲区时才需要同步锁定。虚拟机是否使用TLAB，通过`-XX:+/-UseTLAB`参数设定。

  内存分配完成后虚拟机必须将分配到的内存空间（不包括对象头）都初始化为零值，如果使用了TLAB也可以在TLAB分配时提前进行该工作。这步操作保证了对象的实例字段在Java代码中可以不赋初始值就直接使用，使程序能访问到这些字段的数据类型对应的零值。

  之后虚拟机还要对对象进行必要的设置，例如这个对象是哪个类的实例、如何才能找到类的元数据信息、对象的GC分代年龄等信息。这些信息存放在对象头中，根据虚拟机运行状态的不同，对象头有不同的设置方式。

  至此从虚拟机的视角来看一个新的对象已经产生了，但是从Java程序的角度来说，对象创建才刚刚开始。此时构造方法，即Class文件中的init方法还没有执行，所有字段都为默认的零值，对象需要的其他资源和状态信息也还没有按照预定的意图构造好。一般来说new指令后会接着执行init方法，按照程序员的意愿对对象进行初始化，这样一个真正可用的对象才算完全被构造出来。

- **对象的内存布局**

  在HotSpot虚拟机中，对象在堆内存中的存储布局可分为三个部分。

  - **对象头**

    对象头包括两类信息，第一类是用于存储对象自身的运行时数据，如哈希码、GC分代年龄、锁状态标志、线程持有的锁、偏向线程ID、偏向时间戳等，这部分数据叫做“Mark Word”。对象需要存储的运行时数据很多，但对象头里的信息是与对象自身定义的数据无关的额外存储成本，考虑到虚拟机的空间效率，Mark Word被设计为一个有动态定义的数据结果，以便在极小的空间内存储更多的数据，根据对象的状态复用自己的存储空间。

    对象头的另一部分是类型指针，即对象指向它的类型元数据的指针，Java虚拟机通过该指针来确定对象是哪个类的实例。并非所有虚拟机实现都必须在对象数据上保留类型指针，查找对象的元数据不一定要经过对象本身。此外如果对象是一个Java数组，在对象头还必须有一块用于记录数组长度的数据。

  - **实例数据**

    实例数据部分是对象真正存储的有效信息，即程序员在代码里所定义的各种类型的字段内容，无论是从父类继承的还是在子类定义的字段都必须记录起来。这部分的存储顺序会受到虚拟机分配策略参数和字段在Java源码中定义顺序的影响。相同宽度的字段总是被分配到一起存放，在满足该前提条件的情况下父类中定义的变量会出现在子类之前。如果虚拟机的`+XX:CompactFields`参数值为true（默认值），那子类中较窄的变量也允许插入父类变量的空隙以节省内存空间。

  - **对齐填充**

    这部分不是必然存在的，也没有特别含义，仅仅起占位符的作用。由于HotSpot虚拟机的自动内存管理系统要求对象的起始地址必须是8字节的整数倍即任何对象的大小都必须是8字节的整数倍，而对象头已经被设为正好是8字节的整数倍，因此如果对象实例数据部分没有对齐，就需要对齐填充来补全。

- **对象的访问定位**

  Java程序会通过栈上的reference数据来操作堆上的具体对象，而具体对象访问方式是由虚拟机决定的，主流的访问方式主要有使用句柄和直接指针两种。

  - **使用句柄**

    如果使用句柄访问的话，Java堆中将可能会划分出一块内存作为句柄池，reference中存储的就是对象的句柄地址，而句柄中包含了对象实例数据与类型数据各自具体的地址信息。

    使用句柄访问最大的优点就是reference中存储的是稳定句柄地址，在对象被移动（处于垃圾收集过程中）时只会改变句柄中的示例数据指针，而reference本身不需要被修改。

  - **直接指针**

    如果使用直接指针访问的话，Java堆中对象的内存布局就必须考虑如何放置访问类型数据的相关信息，reference中存储的直接就是对象地址，如果只是访问对象本身的话就不需要多一次间接访问的开销。

    使用直接指针最大的优点就是速度更快，节省了一次指针定位的时间开销。HotSpot主要使用的就是直接指针来进行对象访问。

----

### OutOfMemoryError异常

在《Java虚拟机规范》中除了程序计数器外，虚拟机内存的其他几个运行时区域都有发生OOM异常的可能。

- **Java堆溢出**

  - **异常产生**

     Java堆用于存储对象实例，我们只要不断创建对象，并且保证GC Roots到对象有可达路径来避免垃圾回收机制清除这些对象，那么随着对象数量的增加，总容量触及最大堆容量的限制后就会产生OOM异常。

    可通过`-Xms`参数将堆的最小值与`-Xmx`参数将堆的最大值设置为一样来避免堆自动扩展，通过`-XX:+HeapDumpOnOutOfMemoryError`可以让虚拟机在出现OOM时Dump出当前的内存堆转储快照以便进行事后分析。

  - **异常处理**

    Java堆内存的OOM是实际应用中最常见的OOM情况，常规的处理方法是先通过内存映像分析工具对Dump出来的堆转储快照进行分析，确认内存中导致OOM的对象是否是必要的，也就是先分清楚到底是出现了内存泄漏还是内存溢出。

    如果是内存泄漏，可进一步通过工具查看泄漏对象到GC Roots的引用链，找到泄露对象是通过怎样的引用路径、与哪些GC Roots相关联才导致垃圾收集器无法回收它们，根据泄露对象的类型信息以及它到GC Roots引用链的信息，一般可以准确定位到对象创建的位置进而找出产生内存泄漏代码的具体位置。

    如果不是内存泄漏，即内存中的对象确实都是必须存活的那就应当检查Java虚拟机的堆参数设置，与机器的内存相比是否还有向上调整的空间。再从代码上检查是否存在某些对象生命周期过长、持有状态时间过长、存储结构设计不合理等情况，尽量减少程序运行期的内存消耗。

- **虚拟机栈和本地方法栈溢出**

  由于HotSpot虚拟机不区分虚拟机和本地方法栈，因此`-Xoss`（设置本地方法栈大小）的参数没有意义，栈容量只能由`-Xss`参数来设定关于虚拟机栈和本地方法栈，存在两种异常：

  - **StackOverflowError**

    如果线程请求的栈深度大于虚拟机所允许的深度，将抛出StackOverflowError异常。

    - **异常产生**

      使用`-Xss`参数减少栈内存容量，也可以定义大量本地变量增大方法帧中本地变量表的长度。

    - **异常处理**

      无论由于帧栈太大还是虚拟机栈容量太小，当新的帧栈内存无法分配的时候虚拟机都会抛出StackOverflowError异常。该异常有明确错误堆栈可供分析，容易定位到问题所在。

  - **OutOfMemoryError**

    如果Java虚拟机栈容量可以动态扩展，当栈扩展时无法申请到足够的内存会抛出OutOfMemoryError异常。HotSpot虚拟机不支持虚拟机栈的扩展，所以除非在创建线程申请内存时就因无法获得足够内存而出现OOM异常，否则在线程运行时是不会因为扩展而导致内存溢出的，只会因为栈容量无法容纳新的栈帧而导致StackOverflowError异常。

    - **异常产生和处理**

      建立过多线程导致内存耗尽抛出OOM异常，在不能减少线程数量或者更换64位虚拟机的情况下，只能通过减少最大堆和减少栈容量来换取更多的线程。

- **方法区和运行时常量池**

  - **引入**

    String类的intern方法是一个本地方法，它的作用是如果字符串常量池中已经包含一个等于此String对象的字符串，则返回代表池中这个字符串的String对象的引用；否则会将此String对象包含的字符串添加到常量池中，并且返回此String对象的引用。

  - **运行时常量池OOM**

    - **异常产生**

      在JDK6及之前常量池都分配在永久代，因此可以通过`-XX:PermSize`和`-XX:MaxPermSize`限制永久代的大小，间接限制常量池的容量。在while死循环中不断调用intern方法，之后将导致运行时常量池溢出。

    - **异常处理**

      在JDK7及之后版本不会导致该问题，因为存放在永久代的字符串常量池已经被移至Java堆中。此时如果使用-Xmx限制堆大小会导致堆溢出。

  - **方法区OOM**

    - **异常产生**

      方法区的主要职责是用于存放类型的相关信息，如类名、访问修饰符、常量池、字段描述、方法描述等。只要不断在运行时产生大量的类去填满方法区，就会导致溢出。可以使用JDK的反射或CGLib直接操作字节码在运行时生成大量的类来导致溢出。当前的很多主流框架如Spring、Hibernate等对类增强是都会使用CGLib这类字节码技术，增强的类越多，就需要越大的方法区保证动态生成的新类型可以载入内存，也就更容易导致方法区溢出。

    - **异常处理**

      方法区溢出也是常见的OOM，一个类如果要被垃圾回收器回收，条件是很苛刻的。在经常运行时生成大量动态类的应用场景中应该特别关注这些类的回收情况，除了CGLib字节码增强外，还有大量JSP或动态生成JSP文件的应用（JSP第一次运行时需要编译为Java类）、基于OSGi的应用（即使是同一个类文件，被不同的类加载器加载也会视为不同的类）等。

      JDK8之后永久代完全被废弃，取而代之的是元空间。HotSpot提供了一些参数作为元空间的防御措施：

      `-XX:MaxMetaspaceSize`：设置元空间的最大值，默认-1，表示不限制即只受限于本地内存大小。

      `-XX:MetaspaceSize`：指定元空间的初始大小，以字节为单位，达到该值就会触发垃圾收集进行类型卸载，同时收集器会对该值进行调整：如果释放了大量空间就适当降低该值，如果释放了很少的空间就适当提高该值。

      `-XX:MinMetaspaceFreeRatio`：作用是在垃圾收集之后控制最小的元空间剩余容量百分比，可减少因为元空间不足导致的垃圾收集的频率。类似的还有`-XX:MinMetaspaceFreeRatio`，用于控制最大的元空间剩余容量百分比。

- **本机直接内存溢出**

  直接内存的容量大小可通过-XX:MaxDirectMemorySize指定，如果不去指定则默认与Java堆的最大值一致。

  由直接内存导致的内存溢出，一个明显的特征是在Heap Dump文件中不会看见有什么明显的异常情况，如果发现内存溢出后产生的Dump文件很小，而程序中又直接或间接使用了直接内存（典型的间接使用就是NIO），那么就可以考虑重点检查一下直接内存方面的原因了。

---

## 垃圾收集器与内存分配策略

### 概述

对于Java内存运行时区域的各部分，程序计数器、虚拟机栈和本地方法栈3个区域的生命周期和线程相同，栈中的栈帧随着方法的进入和退出而有规律地执行出栈和入栈操作，每一个栈帧中分配多少内存基本上是在类结构确定下来时就已知的（运行期会由即时编译器优化但大体上可认为是编译器已知的），因此这几个区域地内存分配和回收都具备确定性，在这几个区域内不需要过多考虑回收问题，当方法或线程结束时，内存自然就跟着回收了。

而Java堆和方法区这两个区域则有显著的不确定性：一个接口的多个实现类需要的内存可能会不一样，一个方法所执行的不同条件分支所需要的内存也可能不一样，只有处于运行期间，我们才能知道程序究竟会创建哪些对象，创建对象的数量，这部分内存的分配和回收是动态的。垃圾收集器关注的正是这部分内存的管理问题。

---

### 判断对象是否是垃圾

在堆中存放着所有对象实例，垃圾收集器在对堆进行回收前，首先要判断对象是否还存活着。

- **引用计数算法**

  在对象中添加一个引用计数器，如果有一个地方引用它计数器就加1，引用失效时计数器就减1，如果计数器为0则该对象就是不再被使用的。

  该算法原理简单，效率也高，但是在Java中很少使用，因为它存在对象之间互相循环引用的问题，导致计数器无法清零。

- **可达性分析算法**

  当前主流语言的内存管理子系统都是使用可达性分析算法来判断对象是否存活的。这个算法的基本思路就是通过一系列称为GC Roots的根对象作为起始节点集，从这些节点开始，根据引用关系向下搜索，搜索过程所走过的路径称为引用链，如果某个对象到GC Roots之间没有任何引用链相连，则此对象是不可能再被使用的。

  可作为GC Roots的对象包括以下几种：

  - 在虚拟机栈（栈帧中的本地变量表）中引用的对象，如线程被调用的方法堆栈中的参数、局部变量等。
  - 在方法区中类静态属性引用的对象，如类的引用类型静态变量。
  - 在方法区中常量引用的对象，如字符串常量池中的引用。
  - 在本地方法栈中JNI（即Native方法）引用的对象。
  - Java虚拟机内部的引用，如基本数据类型对应的Class对象，一些常驻异常对象，系统类加载器等。
  - 所有被同步锁（synchronized）持有的对象。
  - 反映虚拟机内部情况的JMXBean、JVMTI中注册的回调、本地代码缓存等。

- **再谈引用**

  无论通过引用技术算法还是可达性分析算法判断对象是否存活，都和引用离不开关系。在JDK1.2之前，Java对引用的定义是：如果reference类型数据存储的数值代表另外一块内存的起始地址，那么就称该reference数据是代表某块内存、某个对象的引用。在JDK1.2之后Java对引用的概念进行了扩充，按引用强度分为：

  - **强引用**：最传统的引用定义，指程序代码中普遍存在的引用赋值。无论任何情况下，只要强引用关系还存在，垃圾收集器就永远不会回收掉被引用的对象。
  - **软引用**：描述一些还有用但非必需的对象。只被软引用关联的对象，在系统将要发生内存溢出异常前，会把这些对象列进回收范围之中进行第二次回收，如果这次回收还没有足够的内存才会抛出OOM异常。
  - **弱引用**：描述非必需对象，但引用强度比软引用更弱，被弱引用关联的对象只能生存到下一次垃圾收集发生之前。当垃圾收集器开始工作时无论当前内存是否足够，都会回收只被弱引用关联的对象。
  - **虚引用**：也称幽灵引用或幻影引用，它是最弱的引用关系。一个对象是否有虚引用存在，完全不会对其生存时间造成应用，也无法通过虚引用来取得一个对象实例。该引用的唯一目的就是为了能在这个对象被垃圾收集器回收时收到一个系统通知。

- **finalize方法**

  要宣告一个对象死亡至少要经过两次标记过程，如果对象在进行可达性分析后发现没有与GC Roots连接的引用链，那它将会被第一次标记，随后进行一次筛选，筛选的条件是此对象是否有必要执行finalize方法。假如对象没有重写finalize方法或者该方法已经被虚拟机调用过，那么虚拟机将这两种情况视为没有必要执行。

  如果这个对象被判断为有必要执行finalize方法，就会被放置在一个叫做F-Queue的队列中，并由一条虚拟机自动建立的、低调度优先级的Finalizer线程去执行它们的finalize方法。虚拟机会触发该方法但不保证它会运行结束，这是为了防止某个对象的finalize方法执行缓慢或者发生死循环而影响整个内存回收子系统。只要对象在finalize方法中重新与引用链上的任何一个对象建立关联关系就会在第二次标记时被移出即将回收集合，否则就会被真正回收。

  注意：finalize方法由于运行代价高昂，不确定性大，无法保证各个对象的调用顺序，如今已被官方明确声明为不推荐使用的语法，因此它并不适合释放资源，释放资源完全可以使用try-finally代码块。

- **回收方法区**

  方法区垃圾收集的”性价比“通常较低，主要回收两部分内容：废弃的常量和不再使用的类型。回收废弃常量与回收Java堆中的对象非常类似，判断一个常量是否废弃相对简单，而判断一个类型是否属于不再使用的类需要同时满足以下三个条件：

  - 该类的所有实例都已经被回收，堆中不存在该类及其任何派生子类的实例。
  - 加载该类的类加载器已经被回收。
  - 该类对象的Class对象没有在任何地方被引用，无法在任何地方通过反射访问该类的方法。

  虚拟机被允许对满足这三个条件的无用类进行回收，没有引用了不一定会必然回收，是否回收通过`-Xnoclassge`参数进行控制。还可以通过`-verbose:class`和`-XX:+TraceClassLoading`、`-XX:+TraceClassUnLoading`查看类加载和卸载信息。

  在大量使用反射、动态代理、CGLib等字节码框架，动态生成JSP以及OSGi这类频繁自定义类加载器的场景中，通常都需要Java虚拟机具备类型卸载的能力，保证不会对方法区造成过大内存压力。

---

### 垃圾收集算法

- **分代收集理论**

  当前商业虚拟机的垃圾收集器大多数都遵循了分代收集理论进行设计，分代收集建立在两个假说上：

  - 弱分代假说：绝大多数对象都是朝生夕灭的。
  - 强分代假说：熬过越多次垃圾收集过程的对象就越难以消亡。

  这两个分代假说共同奠定了多款垃圾收集器的一致设计原则：收集器应该将Java堆划分出不同的区域，然后将回收对象依据年龄分配到不同的区域之中。

  把分代收集理论放到商用虚拟机中，设计者一般至少会把Java堆划分为新生代和老年代两个区域。在新生代每次垃圾回收都有大批对象灭亡，而每次回收后存活的少量对象将会逐步晋升到老年代中。

  为了解决跨代引用问题，引入了第三条经验法则：

  - 跨代引用假说：跨代引用相对于同代引用仅占极少数。

  依据这条假说，我们不该再为了少量的跨代引用去扫描整个老年代，也不必浪费空间专门记录每个对象是否存在及存在哪些跨代引用，只需在新生代上建立一个全局的数据结构（记忆集），这个结构把老年代划分为若干小块，标记出老年代的哪一块内存会存在跨代引用。此后发生MinorGC时，只有包含了跨代引用的小块内存中的对象才会被加入到GC Roots进行扫描。

  垃圾收集名词：

  - MinorGC：目标只是新生代的垃圾收集。
  - MajorGC：目标只是老年代的垃圾收集，目前只有CMS会单独收集老年代。
  - MixedGC：混合收集，目前只有G1会有这种行为。
  - FullGC：收集整个Java堆和方法区。

- **标记-清除算法**

  - **原理**

    算法分为标记和清除两个阶段：首先标记出所有需要回收的对象，在标记完成之后，统一回收掉所有被标记的对象，或者标记存活的对象，统一回收所有未被标记的对象。标记过程就是对象是否属于垃圾的判定过程。

  - **特点**

    ① 执行效率不稳定，如果堆中包含大量对象，而且其中大部分是需要被回收的，这时必须进行大量标记和清除动作，导致效率随对象数量增长而降低。

    ② 内存空间碎片化问题，标记、清楚之后会产生大量不连续的内存碎片，空间碎片太多可能会导致以后在程序运行中需要分配较大对象时无法找出足够的连续内存而不得不提前触发另一次垃圾收集。

- **标记-复制算法**

  - **原理**

    将可用内存按容量划分为大小相等的两块，每次只使用其中一块。当这一块的空间用完了，就将还存活着的对象复制到另一块上面，然后再把已使用过的内存空间一次清理掉。

  - **特点**

    ① 实现简单、运行高效，解决了内存空间碎片问题。

    ② 代价是将可用内存缩小为原来的一半，浪费了过多空间。

  - **HotSpot的新生代划分**

    把新生代划分为一块较大的Eden空间和两块较小的Survivor空间，每次分配内存只使用Eden和其中一块Survivor。发生垃圾收集时，将Eden和Survivor中仍然存活的对象一次性复制到另一块Survivor上，然后直接清理掉Eden和已用过的那块Survivor空间。HotSpot虚拟机默认Eden和Survivor的大小比例是8：1，即每次新生代中可用空间为整个新生代的90%。

- **标记-整理算法**

  - **原理**

    标记-复制算法在对象存活率较高时就要进行较多的复制操作，效率将会降低。并且如果不想浪费空间，就需要有额外的空间进行分配担保，以应对被使用内存中所有对象都100%存活的极端情况，所以老年代一般不使用此算法。

    老年代使用标记-整理算法，其中标记过程与标记-清除算法一样，只是后续步骤不是直接对可回收对象进行清理，而是让所有存活的对象都向内存空间一端移动，然后直接清理掉边界以外的内存。

  - **特点**

    标记-清除算法与标记-整理算法的本质差异在于前者是一种非移动式的回收算法，而后者是移动式的。是否移动回收后的存活对象是一项优缺点并存的风险策略：

    如果移动存活对象，尤其是在老年代这种每次回收都有大量对象存活的区域，是一种极为负重的操作，而且这种对象移动必须全程暂停用户应用程序才能进行。但如果不移动对象就会导致空间碎片化问题，只能依赖更复杂的内存分配器和内存访问器来解决。所以是否移动对象都存在弊端，移动则内存回收时更复杂，不移动则内存分配时更复杂。

---

### 经典垃圾收集器

经典的垃圾收集器指JDK11之前的全部可用垃圾收集器。

- **Serial**

  Serial收集器是最基础、历史最悠久的收集器，该收集器是一个使用复制算法的单线程工作收集器，单线程的意义不仅是说明它只会使用一个处理器或一条收集线程去完成垃圾收集工作，更重要的是强调它进行垃圾收集时必须暂停其他所有工作线程直到收集结束。

  Serial是虚拟机运行在客户端模式下的默认新生代收集器，优点是简单且高效，对于内存受限的环境，它是所有收集器中最小的；对于单核处理器或处理器核心较少的环境来说，Serial收集器由于没有线程交互开销，因此可获得最高的单线程收集效率。

- **ParNew**

  ParNew实质上是Serial的多线程版本，除了使用多线程进行垃圾收集外其余行为完全一致。

  ParNew是虚拟机运行在服务端模式下的默认新生代收集器，一个重要原因是除了Serial收集器外，只有它能与CMS收集器配合工作。

  自从JDK9开始，ParNew加CMS收集器的组合就不再是官方推荐的服务端模式下的收集器解决方案了，官方希望他能被G1完全取代，甚至取消了Serial加CMS和ParNew加Serial Old这两组收集器组合。

- **Parallel Scavenge**

  Parallel Scavenge也是新生代收集器，同样基于标记-复制算法，也是可以并行的多线程收集器，与ParNew十分类似。

  它的特点是它的关注点与其他收集器不同，CMS等收集器的关注点是尽可能缩短收集时用户线程的停顿时间，而Parallel Scavenge收集器的目标则是达到一个可控制的吞吐量，吞吐量就是处理器用于运行用户代码的时间与处理器消耗总时间的比值。自适应调节策略也是Parallel Scavenge区别于ParNew的一个重要特性。

- **Serial Old**

  Serial Old是Serial收集器的老年代版本，它同样是一个单线程收集器，使用标记-整理算法。

  Serial Old是虚拟机在客户端模式下的默认老年代收集器，如果用于服务端，它可能有两种用途：一种是JDK5及之前与Parallel Scavenge搭配使用，另外一种是作为CMS收集器发生失败时的后备预案。

- **Parellel Old**

  Parallel Old是Parallel Scavenge收集器的老年代版本，支持多线程收集，基于标记-整理算法实现。这个收集器直到JDK6才开始提供，在注重吞吐量优先的场景可以有效考虑Parallel Scavenge加Parallel Old组合。

- **CMS**

  CMS是一种以获取最短回收时间停顿时间为目标的收集器，如果希望系统停顿时间尽可能短给用户带来更好的交互体验，就可以使用CMS收集器。

  CMS是基于标记-清除算法实现的，但过程相对复杂，整个过程分为四个步骤：

  - **初始标记**
  - **并发标记**
  - **重新标记**
  - **并发清除**

  其中初始标记和重新标记仍然需要STW（Stop The World，表示系统停顿），初始标记仅是标记一下GC Roots能直接关联到的对象，速度很快；并发标记就是从GC Roots的直接关联对象开始遍历整个对象图的过程，这个过程耗时较长但是不需要停顿用户线程，可以与垃圾收集线程并发运行；重新标记阶段则是为了修正并发标记期间，因用户程序运作而导致标记产生变动的那一部分对象的标记记录，该阶段停顿时间比初始标记稍长，但远比并发标记短；最后是并发清除阶段，清理删除标记阶段判断的已死亡对象，由于不需要移动存活对象，因此该阶段也是可以与用户线程并发的。

  由于整个过程中耗时最长的并发标记和并发清除阶段中，垃圾收集器都可以和用户线程一起工作，所以从总体上说，CMS收集器的内存回收过程是与用户线程并发执行的。

  CMS是HotSpot虚拟机追求低停顿的第一次成功尝试，但它还存在三个明显的缺点：

  - 对处理器资源非常敏感，在并发阶段虽然不会导致用户线程暂停，但会降低总吞吐量。
  - 无法处理浮动垃圾，有可能出现并发失败而导致另一次FullGC的产生。
  - 由于CMS基于标记-清除算法，因此会产生大量空间碎片，给大对象分配带来很大麻烦。

- **G1**

  G1开创了收集器面向局部收集的设计思路和基于Region的内存布局形式。G1是一款主要面向服务端应用的垃圾收集器，最初的设计目标是替换JDK5中发布的CMS。

  G1收集器之前的其他收集器，包括CMS，垃圾收集的目标要么是整个新生代，要么是整个老年代，或者整个堆。而G1跳出了这个樊笼，可以面向堆内存任何部分来组成回收集进行回收，衡量标准不再是它属于哪个分代，而是哪块内存中存放的垃圾数量最多，回收受益最大，这就是G1的MixedGC模式。

  G1不再坚持固定大小以及固定数量的分代区域划分，而是把Java堆划分为多个大小相等的独立区域（Region），每一个Region都可以根据需要扮演新生代的Eden空间、Survivor空间或老年代空间。收集器能够对扮演不同角色的Region采用不同的策略去处理，这样无论是新创建的对象还是已经存活了一段时间、熬过多次收集的旧对象都能获取很好的收集效果。

  G1跟踪各个Region里面的垃圾堆积的价值大小，价值即回收所获得的空间大小以及回收所需时间的经验值，然后在后台维护一个优先级列表，每次根据用户设定允许的收集停顿时间优先处理回收价值收益最大的那些Region。这种使用Region划分内存空间，以及具有优先级的区域回收方式，保证了G1在有限的时间内获取尽可能高的收集效率。

  G1收集器的运作过程：

  - **初始标记：**仅仅标记一下GC Roots能直接关联到的对象，并且修改TAMS指针的指，让下一阶段用户线程并发运行时，能正确地在可用Region中分配新对象。该阶段需要STW，但耗时很短，是借用进行MinorGC的时候同步完成的。
  - **并发标记：**从GC Roots开始对堆中对象进行可达性分析，递归扫描整个堆里的对象图，找出需要回收的对象。该阶段耗时长，但可与用户程序并发执行，当对象图扫描完成后还要重新处理SATB记录下的在并发时有引用变动的对象。
  - **最终标记：**对用户线程做另一个短暂的暂停，用于处理并发阶段结束后仍遗留下来的最后那少量的SATB记录。
  - **筛选回收：**负责更新Region的统计数据，对各个Region的回收价值和成本排序，根据用户期望的停顿时间指定回收计划，可自由选择任意多个Region构成回收集然后把决定回收的那一部分Region的存活对象复制到空的Region中，再清理掉整个旧的Region的全部空间。该操作涉及对象的移动必须暂停用户线程，由多条收集器线程并行完成。

  可以由用户指定期望的停顿时间是G1的一个强大功能，但该值不能设得太低，一般设置为100~300毫秒比较合适。G1不会存在内存空间碎片的问题，但G1为了垃圾收集产生的内存占用和程序运行时的额外执行负载都高于CMS。

---

### 低延迟垃圾收集器

指Shenandoah和ZGC，这两个收集器几乎整个工作过程全部都是并发的，只有初始标记、最终标记这些阶段有短暂的停顿，这部分停顿的时间基本上都是固定的，与堆的容量、堆中对象的数量没有正比例关系。

- **Shenandoah**

  相比G1，内存布局同样基于Region，默认的回收策略也是优先处理回收价值最大的Region。但在管理堆内存方面，它与G1有一些不同之处：①支持并发的整理算法，G1的回收阶段是多线程并行的但是不能与用户线程并发。②默认不使用分代收集，不会有专门的新生代Region或老年代Region的存在。③摒弃了在G1中耗费大量内存和计算资源去维护的记忆集，改用名为连接矩阵的全局数据结构来记录跨Region的引用关系，降低了处理跨代指针时的记忆集维护消耗，也降低了伪共享问题的发生概率。

- **ZGC**

  一款JDK11中新加入的具有实验性质的低延迟垃圾收集器，和Shenandoah的目标高度相似，都希望在尽可能对吞吐量影响不大的前提下实现在任意堆大小下都可以把垃圾收集器的停顿时间限制在10ms以内的低延迟。

  ZGC是一款基于Region内存布局的，不设分代的，使用了读屏障、染色指针和内存多重映射等技术来实现可并发的标记-整理算法的，以低延迟为首要目标的一款垃圾收集器。

  ZGC的内存布局与Shenandoah和G1一样，ZGC也采用基于Region的堆内存布局，但不同的是ZGC的Region具有动态性，是动态创建和销毁的，并且区容量大小也是动态变化的。

---

### 垃圾收集器的选择

- **影响因素**

  - 如果是数据分析、科学计算类的任务，目标是尽快算出结果，那吞吐量就是主要关注点；如果是SLA应用，那停顿时间直接影响服务质量，严重的甚至会导致事务超时，那延迟就是主要关注点；如果是客户端应用或嵌入式应用，那垃圾收集的内存占用就是主要关注点。
  - 运行应用的基础设施，例如硬件规格，处理器数量的多少，分配内存的大小，选择的操作系统等。
  - 使用JDK的发行商及版本号，对应的《Java虚拟机规范》版本等。

- **虚拟机和垃圾收集日志**

  阅读分析虚拟机和垃圾收集日志是处理Java虚拟机内存问题必备的基础技能。

  日志级别从低到高包括Trace、Debug、Info、Warning、Error、Off六种级别，默认为Info。

  以G1收集器为例，一些常用参数如下（JDK9之前/JDK9后）：

  - 查看GC基本信息：`-XX:+PrintGC`/`-Xlog:gc`
  - 查看GC详细信息：`-XX:+PrintGCDetails`/`-X-log:gc*`
  - 查看GC前后堆、方法区可用容量的变化：`-XX:+PrintHeapAtGC`/`-Xlog:gc+heap=debug`
  - 查看GC过程中用户线程并发时间以及停顿时间：`-XX:+PrintGCApplicationConcurrentTime`和`-XX:+PrintGCApplicationStoppedTime`/`-Xlog:safepoint`
  - 查看熬过收集后剩余对象的年龄分布信息：`-XX:+PrintTenuringDistribution`/`-Xlog:gc+age=trace`

---

### 内存分配与回收策略

Seial+Serial Old客户端默认收集器组合下的内存分配和回收策略：

- **对象优先在Eden区分配**

  大多数情况下对象在新生代Eden区分配，当Eden区没有足够空间进行分配时，虚拟机将发起一次MinorGC。

  可通过`-XX:Xms`和`-XX:Xmx`设置堆大小，通过`-Xmn`设置新生代的大小，通过`-XX:SurvivorRatio`设置新生代中Eden区和Survivor区的比例。

- **大对象直接进入老年代**

  大对象就是指需要大量连续内存空间的Java对象，最典型的大对象便是那种很长的字符串，或者元素数量很庞大的数组。大对象容易导致内存明明还有不少空间时就提前触发垃圾收集，以获得足够的连续空间才能安置好它们，当复制对象时，大对象就意味着高额内存复制开销。HotSpot提供了`-XX:PretenureSizeThreshold`参数（只有Serial和ParNew支持），大于该值的对象直接在老年代分配，避免在Eden和Survivor区之间来回复制产生大量内存复制操作。

- **长期存活对象进入老年代**

  虚拟机给每一个对象定义了一个对象年龄计数器，存储在对象头。对象通常在Eden区诞生，如果经历过第一次MinorGC仍然存活，并且能被Survivor容纳的话，该对象就会被移动到Survivor中并将年龄设置为1岁。对象在Survivor中每熬过一次MinorGC，年龄就增加1岁，当增加到一定程度（默认15）就会被晋升到老年代中。对象晋升老年代的年龄阈值，可通过参数`-XX:MaxTenuringThreshold`设置。

- **动态对象年龄判定**

  为了更好适应不同程序的内存状况，虚拟机并不是永远要求对象年龄达到晋升阈值才能晋升到老年代，如果在Survivor空间中相同年龄所有对象大小的总和大于Survivor空间的一般，年龄大于等于该年龄的对象就可以直接进入老年代，无需等到`-XX:MaxTenuringThreshold`中要求的年龄。

- **空间分配担保**

  在发生MinorGC之前，虚拟机必须先检查老年代最大可用的连续空间是否大于新生代所有对象的总空间，如果这个条件成立，那这一次MinorGC可以确定是安全的。

  如果不成立，虚拟机会先查看`-XX:HandlePromotionFailure`参数的设置值是否允许担保失败，如果允许会继续检查老年代最大可用连续空间是否大于历次晋升到老年代对象的平均大小，如果大于将冒险尝试一次MinorGC；如果小于或者不允许担保失败，那么就会改成一次FullGC。

  冒险的说明：新生代使用复制收集算法，但为了内存利用率只使用其中一个Survivor空间作为轮换备份，因此当出现大量对象在MinorGC后仍然存活的情况，需要老年代进行分配担保，把Survivor无法容纳的对象直接送入老年代。

---

## 类加载机制

### 概述

在Class文件中描述的各类信息，最终都需要加载到虚拟机只后才能被运行和使用。

Java虚拟机把描述类的数据从Class文件加载到内存，并对数据进行校验、转换解析和初始化，最终形成可以被虚拟机直接使用的Java类型，这个过程被称为虚拟机的类加载机制。

与其他在编译时需要连接的语言不同，在Java中类型的加载、连接和初始化过程都是在程序运行期间完成的，这种策略让Java进行提前编译会面临额外的困难，也会让类加载时稍微增加一些性能开销，但是却为Java应用提供了极高的扩展性和灵活性，Java可以动态扩展的语言特性就是依赖运行期动态加载和动态连接这个特点实现的。例如编写一个面向接口的应用程序，可以等到运行时再指定其实际的实现类，用户可以通过Java预置的或自定义类加载器，让某个本地应用程序在运行时从网络或其他地方加载一个二进制流作为其程序代码的一部分。

---

### 类加载的时机

一个类型从被加载到虚拟机内存开始，到卸载出内存为止，它的整个生命周期将会经历加载、验证、准备、解析、初始化、使用和卸载七个阶段，其中验证、解析和初始化三个部分统称为连接。

加载、验证、准备、初始化和卸载这五个阶段的顺序是确定的，类型的加载过程必须按照这种顺序按部就班地开始，而解析阶段则不一定：它在某些情况下可以在初始化阶段之后再开始，这是为了支持Java语言地运行时绑定特性（动态绑定）。

关于何时需要开始类加载过程的第一个阶段“加载”，《Java虚拟机规范》中并没有强制约束，这点可以交给虚拟机具体实现自由把握。但对于初始化阶段，《Java虚拟机规范》严格规定了有且只有6种情况必须立即对类进行初始化：

- 遇到new、getstatic、putstatic或invokestatic这四条字节码指令时，如果类型没有进行过初始化则需要先触发其初始化阶段。能够生成这四条指令的典型Java代码场景有：
  - 使用new关键字实例化对象。
  - 读取或设置一个类型的静态字段（被final修饰，在编译器把结果放入常量池的静态字段除外）的时候。
  - 调用一个类型的静态方法。
- 使用java.lang.reflect包的方法对类型进行反射调用时，如果类型没有进行过初始化则需要先触发初始化。
- 当初始化类时，如果其父类没有初始化则需要先触发其父类的初始化。
- 当虚拟机启动时，用户需要指定一个要执行的主类（包含main方法的类），虚拟机会先初始化该类。
- 当使用JDK7新加入的动态语言支持时，如果MethodHandle实例的解析结果为指定的4种类型的方法句柄，并且这个方法句柄对应的类没有进行过初始化，则需要先触发其初始化。
- 当一个接口定义了默认方法时，如果该接口的实现类发生了初始化，那接口要在其之前初始化。

除了这6种情况外，其余所有引用类型的方式都不会触发初始化，称为被动引用。

被动引用的实例：

- 子类使用父类的静态字段时，只有直接定义这个字段的父类会被初始化。
- 通过数组定义来使用类。
- 常量在编译期会存入调用类的常量池，因此不会初始化定义常量的类。

接口的加载过程和类加载过程真正有所区别的是6种初始化场景种的第3种，当初始化类时，如果其父类没有初始化则需要先触发其父类的初始化，但在一个接口初始化时并不要求其父接口全部完成了初始化，只有在真正使用到父接口时（如引用接口中定义的常量）才会初始化。

---

### 类加载的过程

- **加载**

  加载是类加载的第一个阶段，在加载阶段，虚拟机需要完成三件事：

  - 通过一个类的全限定类名来获取定义此类的二进制字节流。由于《Java虚拟机规范》没有具体要求，所以这一步的实现多种多样，例如从ZIP压缩包中读取、从网络中获取、运算时动态代理生成、从数据库中读取、从加密文件中获取等。
  - 将这个字节流所代表的静态存储结构转化为方法区的运行时数据区结构。
  - 在内存中生成一个代表这个类的java.lang.Class对象，作为方法区这个类的各种数据的访问入口。

  对于非数组类型，加载阶段既可以使用虚拟机内置的引导类加载器完成也可以由用户自定义的类加载器完成，可以通过定义自己的类加载器去控制字节流的获取方式（重写类加载器的findClass或loadClass方法）。

  数组类本身不通过类加载器创建，它是由虚拟机直接在内存中动态构造出来的。但数组类与类加载器仍然密切相关，因为数组类的元素类型（数组去掉所有维度的类型）最终还是要依靠类加载器来完成加载：

  - 如果是数组的组件类型（数组去掉一个维度的类型）是引用类型就递归采用加载过程去加载这个组件类型，数组将被标识在加载该组件类型的类加载器的命名空间上。
  - 如果不是引用类型（例如int[]数组的组件类型为int），虚拟机会把数组标记为与引导类加载器相关联。
  - 数组类的可访问性与它的组件类型可访问性一致，如果组件类型不是引用类型，数组类的可访问性默认public。

  加载阶段结束后，虚拟机外部的二进制字节流就按照虚拟机所设定的格式存储在方法区中了，方法区中的数据存储格式完全由虚拟机自定义实现。类型数据安置在方法区之后，会在Java堆中实例化一个java.lang.Class对象，这个对象将作为程序员访问方法区中类型数据的外部接口。

  加载阶段与连接阶段的部分动作是交叉进行的，加载阶段尚未完成，连接阶段可能已经开始。

- **验证**

  验证是连接阶段的第一步，这一阶段的目的就是确保Class文件的字节流中包含的信息符合《Java虚拟机规范》的全部约束要求，保证这些信息被当作代码运行后不会危害虚拟机自身的安全。

  Java语言本身是安全的，纯粹的Java代码无法做到诸如访问数组边界之外的数据、将一个对象转型为它并未实现的类型等，但如果虚拟机不检查输入的字节流，对其完全信任的话，很可能因为载入了有错误或者有恶意企图的字节码流而导致整个系统受攻击甚至崩溃，所以验证字节码是Java虚拟机保护自己的一项必要措施。

  验证阶段主要包含了四个阶段：

  - **文件格式验证**：验证字节流是否符合Class文件格式的规范并且能被当前版本的虚拟机处理。
  - **元数据验证：**对字节码描述的信息进行语义分析，保证其描述信息符合《Java虚拟机规范》的要求。
  - **字节码验证：**验证中最复杂的阶段，主要目的是通过数据流分析和控制流分析确定程序语义是合法的。
  - **符号引用验证：**发生在虚拟机将符合引用转为直接引用时（在连接的第三阶段解析中发生），符号引用验证可以看作是对类自身以外的各类信息进行匹配性校验，通俗地说就是该类是否缺少或被禁止访问它依赖的某些外部类、方法、字段等资源。

  验证阶段对于虚拟机的类加载机制来说是一个非常重要但非必需的阶段，因为验证只有通过与否的区别，只要通过了验证其后就对程序运行期没有任何影响了。如果程序运行的全部代码都已被反复使用和验证过，在生产环境的实施阶段就可以考虑用`-Xverify:none`参数来关闭大部分类验证措施以缩短虚拟机类加载的时间。

- **准备**

  准备阶段是正式为类中定义的变量（即静态变量，被static修饰的变量）分配内存并设置为类变量初始值的阶段，在JDK7之前类变量在方法区中分配，JDK8之后类变量会随着Class对象一起存放在Java堆中。

  该阶段进行的内存分配仅包括类变量，而不包括实例变量，实例变量将会在对象实例化时随着对象一起分配在Java堆中，其次这里说的初始值通常情况下是数据类型的零值，如果是数值类型则是0，如果是布尔类型则是false，如果是char类型则是`\u0000`，如果是引用类型则是null。

  通常情况是指变量不存在ConstantValue属性的情况，如果变量被final修饰，编译时Javac会为变量生成ConstantValue属性，那么在准备阶段虚拟机就会将该变量的值设为程序员指定的值。

- **解析**

  解析阶段是Java虚拟机将常量池内的符号引用替换为直接引用的过程。

  - **符号引用：**符合引用以一组符号来描述所引用的目标，符合可以是任何形式的字面量，只要使用时能无歧义地定位到目标即可。符号引用与虚拟机的内存布局无关，引用目标并不一定是已经加载到虚拟机内存中的内容。各种虚拟机实现的内存布局可以不同，但是接受的符号引用必须都是一致的。
  - **直接引用：**直接引用是可以直接指向目标的指针、相对偏移量或者一个能间接定位到目标的句柄。直接引用和虚拟机的内存布局直接相关，同一个符号引用在不同虚拟机实例上翻译出来的直接引用一般不同，如果有了直接引用，那引用目标必须已经在虚拟机的内存中存在。

  解析部分主要针对类或接口、字段、类方法、接口方法、方法类型、方法句柄和调用点限定符这7类符合引用进行。

- **初始化**

  类的初始化是类加载过程的最后一个步骤，直到初始化阶段，Java虚拟机才真正开始执行类中编写的Java程序代码，将主导权移交给应用程序。

  准备阶段时变量已经赋过一次系统要求的初始零值，而在初始化阶段，则会根据程序员通过程序编码指定的主观计划去初始化类变量和其他资源。初始化阶段就是指向类构造器\<client>方法的过程，该方法是Javac编译器的自动生成物。

---

### 类加载器

Java虚拟机设计团队有意把类加载阶段中的”通过一个类的全限定名来获取描述该类的二进制字节流“这个动作放到Java虚拟机外部去实现，以便让应用程序自己决定如何去获取所需的类，实现这个动作的代码称为类加载器。

- **比较两个类是否相等**

  对于任意一个类，都必须由加载它的类加载器和这个类本身一起共同确立其在虚拟机中的唯一性，每一个类加载器，都拥有一个独立的类名称空间。

  只有在这两个类是由同一个类加载器加载的前提下才有意义，否则即使这两个类来源于同一个Class文件，被同一个Java虚拟机加载，只要加载它们的类加载器不同，那这两个类就必定不相等。

  相等的含义包括了代表类的Class对象的equals方法、isAssignableFrom方法、isInstance方法的返回结果，也包括了使用instance of关键字做对象所属关系判定等各种情况。

- **双亲委派模型**

  从Java虚拟机的角度来看，只存在两种不同的类加载器：一种是启动类加载器，这个类加载器使用C++语言实现（限于HotSpot虚拟机），是虚拟机自身的一部分；另一种是其他所有的类加载器，这些类加载器都由Java语言实现，独立存在于虚拟机外部，并且全部继承自抽象类`java.lang.ClassLoader`。

  自JDK1.2起Java一直保持着三层类加载器、双亲委派的类加载结构。

  - **类加载器**

    - **启动类加载器**：负载加载存放在`JAVA_HOME/lib`目录，或者被`-Xbootclasspath`参数所指定路径中存放的而且能够被虚拟机识别的类库加载到虚拟机内存中。启动类加载器无法被Java程序直接引用，如果用户需要把加载请求委派给启动类加载器，直接使用null代替即可。
    - **扩展类加载器**：负载加载`JAVA_HOME/lib/ext`目录中，或者被`java.ext.dirs`系统变量所指定的路径中所有的类库。这种扩展机制在JDK9之后被模块化带来的天然扩展能力所取代，由于扩展类加载器是由Java代码编写的，开发者可以直接在程序中使用扩展类加载器来加载Class文件。
    - **应用程序类加载器**：也称系统类加载器，它负载加载用户类路径上的所有类库，开发者同样可以直接在代码中使用这个类加载器。如果应用程序中没有自定义过类加载器，一般情况下该类加载器就是程序中默认的类加载器。

  - **双亲委派模型**

    双亲委派模型要求除了顶层的启动类加载器外，其余的类加载器都应该有自己的父类加载器。不过这里类加载器之间的父子关系一般不是以继承关系来实现的，而通常使用组合关系来复用父加载器的代码。

    如果一个类加载器收到了类加载请求，它不会自己去尝试加载这个类，而首先将该请求委派给自己的父加载器完成，每一个层次的类加载器都是如此，因此所有的加载请求最终都应该传送到最顶层的启动类加载器中，只有当父加载器反馈自己无法完成该请求时，子加载器才会尝试自己去完成加载。

    双亲委派机制的好处是Java中的类跟随它的类加载器一起具备了一种带有优先级的层次关系，可以保证某个类在程序的各个类加载器环境中都是同一个类，对于保证Java程序的稳定运行极为重要。

  - **破坏双亲委派模型**

    双亲委派模型并不是一个具有强制性约束的模型，而是Java设计者推荐给开发者的类加载器实现方式。大部分类加载器都遵循该模型，但也有例外情况，直到Java模块化出现为止，双亲委派模型经历过3次较大规模”被破坏“的情况。

    - 第一次被破坏发生在双亲委派模型出现之前，由于该模型在JDK1.2之后才被引入，而类加载器的概念和抽象类ClassLoader在Java的第一个版本就已存在，因此在模型引入时不得不做一些妥协，为了兼容这些已有代码，无法再以技术手段避免loadClass()被子类重写的可能性，只能增加一个新的protected方法findClass()，并引导用户编写类加载逻辑时尽可能去重写这个findClass()方法。按照loadClass()方法的逻辑，如果父类加载失败会调用自己的findClass()方法，这样既不影响用户按照自己的意愿去加载类，又可以保证新写出的类加载器是符合双亲委派规则的。

    - 第二次被破坏是由模型自身缺陷造成的，双亲委派很好地解决了各个类加载器协作时基础类型的一致性问题，越基础的类由越上层的类加载器加载，但假如基础类型要调用回用户的代码就会存在问题（例如JNDI服务，它的代码由启动类加载器完成加载，但它存在的目的就是对资源进行查找和集中管理，需要调用其他厂商实现的并部署在应用程序的ClassPath下的JNDI服务提供者接口中的代码，而启动类加载器是不可能认识、加载这些代码的）。

      为解决该问题，Java引入了线程上下文类加载器。这个类加载器可以通过Thread类的`setContextClassLoader`方法进行设置，如果创建线程时还未设置，将从父线程继承一个，如果再应用的全局范围都没设置过的话，将默认是应用程序类加载器。JNDI使用线程上下文类加载器去加载所需的SPI服务代码，这是一种父加载器委托子加载器完成加载的行为，违背了双亲委派模型的一般性原则。Java中涉及SPI的加载基本都采用该方式，例如JNDI、JDBC、JCE、JXAB等。在JDK6时，提供了ServiceLoader类，辅以责任链模式，给SPI的加载提供了相对合理的解决方案。

    - 第三次被破坏是由于用户对程序动态性的追求导致的，动态性是指代码热替换、模块热部署等。

- **Java模块化系统**

  JDK9引入了模块化系统，为了实现模块化的关键目标即可配置的封装隔离机制，Java虚拟机对类加载架构也做出了相应的变动调整。模块化下的类加载器变动主要包括：

  - 扩展类加载器被平台类加载器取代，因为整个JDK都基于模块化构建，Java类库已经天然满足可扩展需求，因此`JAVA_HOME/lib/ext`目录也无需保留，加载这部分的类加载器也自然不需要了。类似地，在新版JDK中也取消了`JAVA_HOME/jre`目录，因为随时可以组合构建出程序运行所需的JRE来。
  - 平台类加载器和应用程序类加载器都不在派生自`URLClassLoader`，如果程序直接依赖了这种继承关系或者依赖了`URLClassLoader`类的特定方法，那代码很可能在JDK9及更高版本崩溃。限制启动类加载器、平台类加载器、应用程序类加载器全部继承于`BuiltinClassLoader`，该类实现了新的模块化架构下来如何从模块加载的逻辑，以及模块中资源可访问性的处理。
  - JDK9中虽然仍然维持着三层类加载器和双亲委派架构，但类加载的委派关系发生了变化。在平台类加载器和应用程序类加载器收到类加载请求时，要先判断该类是否能够归属到某个系统模块中，如果可以就优先委派给负责那个模块的加载器完成。

---

# Spring框架

## 软件设计原则及设计模式

### 设计原则

- **单一职责原则**
  单一职责原则又称单一功能原则，它规定一个类只有一个职责。如果有多个职责（功能）设计在一个类中，这个类就违反了单一职责原则。

- **开闭原则**
  开闭原则规定软件中的对象（类、模块、函数等）对扩展开放，对修改封闭，这意味着一个实体允许在不改变其源代码的前提下改变其行为，该特性在产品化的环境下是特别有价值的，在这种环境下，改变源代码需要经过代码审查，单元测试等过程以确保产品的使用质量。遵循这个原则的代码在扩展时并不发生改变，因此不需要经历上述过程。

- **里氏代换原则**
  里氏代换原则是对开闭原则的补充，规定了在任意父类可以出现的地方，子类都一定可以出现。实现开闭原则的关键就是抽象化，父类与子类的继承关系就是抽象化的具体表现，所以里氏代换原则是对实现抽象化的具体步骤的规范。

- **依赖倒置原则**
  依赖倒置原则指程序要依赖于抽象（Java中的抽象类和接口），而不依赖于具体的实现（Java中的实现类）。简单地说，就是要求对抽象进行编程，不要求对实现进行编程，这就降低了用户与实现模块之间的耦合度。

- **接口隔离原则**
  接口隔离原则是指通过将不同的功能定义在不同的接口中来实现接口的隔离，这样就避免了其他类在依赖该接口（接口上定义的功能）时依赖其不需要的接口，可减少接口之间依赖的冗余性和复杂性。

- **合成/聚合复用原则**
  合成/聚合复用原则指通过在一个新的对象中引入（注入）已有的对象以达到类的功能复用和扩展的目的。它的设计原则是要尽量使用合成或聚合而不要使用继承来扩展类的功能。

- **迪米特法则**
  迪米特法则指一个对象尽可能少地与其他对象发生相互作用，即一个对象对其他对象应该有尽可能少的了解或依赖。其核心思想在于降低模块之间的耦合度，提高模块的内聚性。迪米特法则规定每个模块对其它模块都要有尽可能少的了解和依赖，因此很容易使系统模块之间的功能独立，这使得各个模块的独立运行变得更加简单，同时使得各个模块之间的组合变得更加容易。

---

### 设计模式

- **分类**

  - **创建型模式：**提供了多种优雅创建对象的方法，包括工厂模式、抽象工厂模式、单例模式、建造者模式、原型模式。

  - **结构型模式：**通过类和接口之间的继承和引用实现创建复杂结构对象的功能，包括适配器模式、桥接模式、组合模式、装饰器模式、外观模式、享元模式、代理模式。

  - **行为型模式：**通过类之间不同的通信方式实现不同的行为方式，包括责任链模式、命令模式、解释器模式、迭代器模式、中介者模式、备忘录模式、观察者模式、状态模式、策略模式、模板模式、访问者模式。

- **工厂模式**
  - 工厂模式是最常见的设计模式，该模式属于创建型模式，它提供了一种简单、快速、高效而安全地创建对象的方式。
  - 工厂模式在接口中定义了创建对象的方法，而将具体的创建对象的过程在子类中实现，用户只需通过接口创建需要的对象即可，不用关注对象的具体创建过程。同时，不同的子类可根据需求灵活实现创建对象的不同方法。
  - 通俗地讲，工厂模式的本质就是用工厂方法代替new操作创建一种实例化对象的方式，以便提供一种方便地创建有同种类型接口地产品的复杂对象。

- **抽象工厂模式**

  - 抽象工厂模式在工厂模式上添加了一个创建不同工厂的抽象接口（抽象类或接口实现），该接口可叫做超级工厂。在使用过程中，我们首先通过抽象接口创建出不同的工厂对象，然后根据不同的工厂对象创建不同的对象。

  - 在同一个厂商有多个维度的产品时，如果使用工厂模式，则势必会存在多个独立的工厂，这样的话设计和物理世界是不对应的。正确的做法是通过抽象工厂模式来实现，我们可以将抽象工厂类比成厂商，将通过抽象工厂创建出来的工厂类比成不同产品的生产线，在需要生产产品时根据抽象工厂生产。

- **单例模式**

  - 单例模式是保证系统实例唯一性的重要手段。单例模式首先通过将类的实例化方法私有化来防止程序通过其他方式创建该类的实例，然后通过提供一个全局唯一获取该类实例的方法帮助用户获取类的实例，用户只需也只能通过调用该方法获取类的实例。

  - 单例模式的设计保证了一个类在整个系统中同一时刻只有一个实例存在，主要被用于一个全局类的对象在多个地方被使用并且对象的状态是全局变化的场景下。同时单例模式为系统资源的优化提供了很好的思路，频繁创建或销毁对象都会增加系统的资源消耗，而单例模式保障了整个系统只有一个对象能被使用，很好地节约了资源。

  - 单例模式的实现很简单，每次在获取对象前都判断系统是否已经有这个单例对象，有则返回，无则创建。需要注意的是，单例模型的类构造器是私有的，只能由自身创建和销毁对象，不允许除了该类的其他程序使用new关键字创建对象及破坏单例模式。

- **建造者模式**

  - 建造者模式使用多个简单的对象创建一个复杂的对象，用于将一个复杂的构建与其表示分离，使得同样的构建过程可以创建不同的表示，然后通过一个Builder类（该Builder类是独立于其他对象的）创建最终的对象。
  - 建造者模式主要用于解决软件系统中复杂对象的创建问题，比如有些复杂对象的创建需要通过各部分的子对象用一定的算法构成，在需求变化时这些复杂对象将面临很大的改变，不利于系统稳定。但是使用建造者模式能将它们各部分的算法包装起来，在需求变化后只需调整各个算法的组合方式和顺序，能极大提供系统稳定性。建造者模式常被用于一些基本部件不会变而其组合经常变化的应用场景下。
  - 建造者模式与工厂模式的最大区别是，建造者模式更关注产品的组合方式和装配顺序，而工厂模式关注产品的生产本身。
  - 建造者模式在设计时有以下几种角色：Builder 创建一个复杂产品对象的抽象接口、ConcreteBuilder Builder接口的实现类，用于定义复杂产品各个部件的装配流程、Director 构造一个使用Builder接口的对象、Product 表示被构造的复杂对象，ConcreteBuilder定义了该复杂对象的装配流程，而Product定义了该复杂对象的结构和内部表示。

- **原型模式**

  - 原型模式指通过调用原型实例的Clone方法或其他手段来创建对象。②原型模式属于创建型设计模式，它以当前对象为原型来创建另一个新的对象，而无需知道创建的细节。原型模式在Java中通常使用Clone技术实现，在JavaScript中通常使用对象的原型属性实现。原型模式的Java实现很简单，只需要原型类实现Cloneable接口并重写clone方法即可。

  - **浅复制和深复制的区别**
    Java中的复制分为浅复制和深复制。①浅复制：Java中的浅复制是通过实现Cloneable接口并重写clone方法实现。在浅复制的过程中，对象的基本数据类型的变量值会重新被复制和创建，而引用数据类型仍指向原对象的引用，也就是说浅复制不复制对象的引用数据类型。②深复制：在深复制的过程中，不论是基本数据类型还是引用数据类型，都会被重新复制和创建。简而言之，深复制彻底复制了对象的数据，浅复制的复制不彻底（忽略了引用数据类型）。

- **适配器模式**

  - 适配器模式通过定义一个适配器类作为两个不兼容的接口之间的桥梁，将一个类的接口转换成用户期望的另一个接口，使得两个或多个原本不兼容的接口可以基于适配器类一起工作。
  - 适配器模式主要通过适配器类实现各个接口之间的兼容，该类通过依赖注入或者继承实现各个接口的功能并对外统一提供服务。在适配器模式的实现中有三种角色：source、targetable、adapter。sourc是待适配的类，targetable是目标接口，adapter是适配器。我们在具体应用中通过adapter将source的功能扩展到targetable，以实现接口的兼容。适配器的实现主要分为三类：类适配器模式、对象适配器模式、接口适配器模式。

- **装饰者模式**

  - 装饰者模式指在无需改变原有类及类的继承关系的情况下，动态扩展一个类的功能。它通过装饰者来包裹真实的对象，并动态地向对象添加或者撤销功能。
  - 装饰者模式包括Source和Decorator两种角色，source是被装饰者，decorator是装饰者。装饰者模式通过装饰者可以为被装饰者Source动态地添加一些功能。

- **代理模式**

  - 代理模式指为对象提供一种通过代理的方式来访问并控制该对象行为的方法。在客户端不适合或者不能够直接引用一个对象时，可以通过该对象的代理对象实现对该对象的访问，可以将该代理对象理解为客户端和目标对象之间的中介者。
  - 在代理模式下有两种角色，一种是被代理者，一种是代理（Proxy），在被代理者需要做一项工作时，不用自己做而是交给代理做。以企业招聘为例，不用自己去市场找，可以通过代理去找。

- **外观模式**

  - 外观模式也叫做门面模式，通过一个门面向客户端提供一个访问系统的统一接口，客户端无需关心和知晓系统内部各子模块（系统）之间的复杂关系，其主要目的是降低访问拥有多个子系统的复杂系统的难度，简化客户端与其之间的接口。外观模式将子系统中的功能抽象成一个统一的接口，客户端通过这个接口访问系统，使得系统使用起来更加容易。
  - 简单来说外观模式就是将多个子系统及其之间的复杂关系和调用流程封装到一个统一的接口或类中以对外提供服务，这种模式设计三种角色：子系统角色：实现了子系统的功能；门面角色：外观模式的核心， 熟悉各子系统的功能和调用关系并根据客户端的需求封装统一的方法来对外提供服务；客户角色：通过调用门面来完成业务功能。

- **桥接模式**

  - 桥接模式通过将抽象及其实现解耦，使二者可以根据需求独立变化。这种类型的设计模式属于结构型模式，通过定义一个抽象和实现之间的桥接者来达到解耦的目的。
  - 桥接模型主要用于解决在需求多变的情况下使用继承造成类爆炸的问题，扩展起来不够灵活。可以通过桥接模式将抽象部分与实现部分分离，使其能够独立变化而相互之间的功能不受影响。具体的做法是通过定义一个桥接接口，使得实体类的功能独立于接口实现类，降低他们之间的耦合度。

  - JDBC和DriverManager就使用了桥接模式，JDBC在连接数据库时，在各个数据库之间切换而不需要修改代码，因为JDBC提供了统一的接口，每个数据库都提供了各自的实现，通过一个叫做数据库驱动的程序来桥接即可。

- **组合模式**

  - 组合模式又叫做部分整体模式，主要用于实现部分和整体操作的一致性。组合模式常根据树形结构来表示部分及整体之间的关系，使得用户对单个对象和组合对象的操作具有一致性。
  - 组合模式通过特定的数据结构简化了部分和整体之间的关系，使得客户端可以像处理单个元素一样来处理整体的数据集，而无需关心单个元素和整体数据集之间的内部复杂结构。

- **享元模式**

  - 享元模式主要通过对象的复用减少对象创建的次数和数量，减少系统内存的使用和降低系统负载。享元模式属于结构型模型，在系统需要一个对象时享元模式首先在系统中查找并尝试重用现有的对象，如果未找到匹配对象则创建新对象并将其缓存在系统中。
  - 享元模式主要用于避免在有大量对象时频繁创建和销毁对象造成系统资源的浪费，把其中共同的部分抽象出来，如果有相同的业务请求则直接返回内存中已有的对象。

- **策略模式**

  - 策略模式为同一个行为定义了不同策略，为每种策略实现了不同方法。用户使用时系统根据不同的策略自动切换不同的方法实现策略的改变。同一策略下的不同方法是对同一功能的不同实现，因此在使用时可相互替换而不影响用户的使用。
  - 策略模式的实现是在接口中定义不同的策略，在实现类中完成了对不同策略下具体行为的实现，并将用户的策略状态存储在上下文中来完成策略的存储和状态的改变。

- **模板方法模式**

  - 模板方法模式定义了一个算法框架，并通过继承的方式将算法的实现延迟到子类中，使得子类可以在不改变算法框架及其流程的前提下重新定义该算法在某些特定环节的实现，是一种类行为型模式。
  - 该模式在抽象类中定义了算法的结构并实现了公共部分算法，在子类中实现可变的部分并根据不同的业务需求实现不同的扩展。模板方法模式的优点在于其父类（抽象类）中定义了算法的框架以及保障算法的稳定性，同时在父类中实现了算法公共部分的方法保证代码的复用，将部分算法延迟到子类实现，因此子类可以通过继承扩展或重新定义算法的功能而不影响稳定性，符合开闭原则。
  - 抽象类：定义算法框架，由基本方法和模板方法组成。基本方法定义了算法有哪些环节，模板方法定义了算法各个环节执行的流程。具体子类：对在抽象类中定义的算法根据需求进行不同的实现。

- **观察者模式**

  - 观察者模式指在被观察者的状态发生变化时，系统基于事件驱动理论将其状态通知到订阅其状态的观察者对象中，以完成状态的修改和事件传播。观察者模式是一种对象行为模式，观察者和被观察者之间的关系属于抽象耦合关系，主要优点是观察者与被观察者之间建立了一套事件触发机制，以降低二者之间的耦合度。
  - 观察者模式的主要角色如下：抽象主题Subject：持有订阅了该主题的观察者对象的集合，同时提供了增加删除观察者对象的方法和主题状态变化后的通知方法。具体主题Concrete Subject：实现了抽象主题的通知方法，在主题内部状态发生变化时，调用该方法通知订阅了主题状态的观察者对象。抽象观察者Observer：观察者的抽象类或接口，定义了主题状态变化时需要调用的方法。具体观察者 Concrete Observer：抽象观察者的实现类，在收到主题状态变化的信息后执行具体触发机制。

- **迭代器模式**

  - 迭代器模式提供了顺序访问集合对象中的各种元素，而不暴露该对象内部结构的方法。Java中的集合就是典型的迭代器模式，比如HashMap，当遍历HashMap时，需要迭代器不停地获取Next元素就可以循环遍历集合中所有元素。
  - 迭代器模式将遍历集合中所有元素地操作封装成一个迭代器类，目的是在不暴露集合对象内部结构地情况下，对外提供统一访问集合内部数据的方法。迭代器的实现一般包括一个迭代器，用于执行具体的遍历操作，以及一个Collection，用于存储具体的数据。

- **责任链模式**

  - 责任链模式用于避免请求发送者与多个请求处理者耦合在一起，让所有请求的处理者持有下一个对象的引用，从而将请求串联成一条链，在有请求发生时，可将请求沿着这条链传递，直到遇到该对象的处理器。
  - 该模式下用户只需将请求发送到责任链上即可，无需关心请求的处理细节和传递过程，所以责任链模式优雅地将请求的发送和处理进行了解耦。责任链模式常用于Web模式。
  - 责任链模式包含以下三种角色：Handler接口：规定责任链上要执行的具体方法。AbstractHandler抽象类：持有Handler实例并通过get/set方法将各个具体的业务Handler串联成一个责任链，客户端上的请求在责任链上执行。业务Handler：用户根据具体的业务需求实现的业务逻辑。

- **命令模式**

  - 命令模式将请求封装为命令基于事件驱动异步执行，以实现命令的发送者和命令的执行者之间的解耦，提高命令发送执行的效率和灵活度。
  - 命令模式主要包含以下角色：
    抽象命令类：执行命令的接口，定义执行命令的抽象方法。具体命令类：抽象命令类的实现类，持有接收者对象，并在收到命令后调用命令执行者的方法action()实现命令的调用和执行。命令执行者：命令的具体执行者，定义了命令执行的具体方法action()。命令调用者：接收客户端的命令并异步执行。

- **备忘录模式**

  - 备忘录模式又叫做快照模式，该模式将当前对象的内部状态保存到备忘录中，以便在需要时能将对象的状态恢复到原先保存的状态。备忘录模式提供了一种保存和恢复状态的机制，常用于快照的记录和状态的存储，在系统发生鼓掌或数据发生不一致时能够方便地将数据恢复到某个历史状态。
  - 备忘录的核心是设计备忘录类及用于管理备忘录的管理者类，主要角色如下：发起人Originator：记录当前时刻的内部状态，定义创建备忘录和回复备忘录数据的方法。备忘录Memento：负责存储对象的内部状态。状态管理者Storage：对备忘录的历史状态进行存储，定义了保存和获取备忘录状态的功能。注意备忘录只能被保存或恢复，不能进行修改。

- **状态模式**

  - 状态模式指给对象定义不同的状态，并为不同的状态定义不同的行为，在对象的状态发生变换时自动切换状态的行为。状态模式是一种对象行为型模式，它将对象的不同行为封装到不同的状态中，遵循单一职责原则。
  - 具体角色如下：环境： 也叫做上下文，用于维护对象当前的状态，并在对象状态发生变化时触发对象行为的变化。抽象状态：定义接口，用于定义对象中不同状态对应行为。具体状态：抽象状态的实现类

- **访问者模式**

  - 访问者模式指将数据结构和数据的操作分离开来，使其在不改变数据结构的前提下动态添加作用于这些元素的操作。访问者模式通过定义不同的访问者实现对数据的不同操作，因此在需要给数据添加新的操作时只需为其定义一个新的访问者即可。
  - 访问者模式是一种对象行为型模式，主要特点是将数据结构和作用于结构上的操作解耦，使得集合的操作可自由地演化而不影响其数据结构，它适用于数据结构稳定但操作多变的系统中。
  - 主要角色如下：抽象访问者：定义了一个访问元素的接口，为每类元素都定义了一个访问操作，该操作中的参数类型对应被访问元素的数据类型。具体访问者：抽象访问者的实现类，实现了不同访问者访问元素后具体行为。抽象元素：定义了访问该元素的入口方法，不同访问者类型代表不同访问者。具体元素：实现抽象元素定义的入口方法，根据访问者的不同类型实现不同逻辑业务。

- **中介者模式**

  - 中介者模式指对象和对象之间不直接交互，而是通过一个名为中介者的角色来实现，使原有对象之间的关系变得松散，且可以通过定义不同的中介者来改变它们之间的交互。
  - 主要包含以下角色：抽象中介者：中介者接口，定义了注册同事对象方法和转发同时对象信息的方法。具体中介者：中介者接口的实现类，定义了一个集合保存同事对象，协调各同事角色之间的交互关系。抽象同事类：定义同事的接口类，持有中介者对象，并定义同事对象交互的抽象方法，同时实现同事类的公共方法和功能。具体同事类：抽象同事的实现类，在需要与其他同事对象交互时，通过中介者对象来完成。

- **解释器模式**

  - 解释器模式给定一种语言，并定义该语言的语法表示，然后设计一个解释器来解释语言的语法，这种模式常被用于SQL解析、符号处理引擎等。
  - 解释器模式包含以下主要角色：抽象表达式：定义解释器的接口，约定解释器所包含的操作。终结符表达式：抽象表达式的子类，用来定义语法中和终结符有关的操作，语法中的每一个终结符都应有一个与之对应的终结表达式。非终结符表达式：抽象表达式的子类，用来定义语法中和非终结符有关的操作，语法中的每条规则都有一个非终结符表达式与之对应。环境：定义各个解释器需要的共享数据或公共功能。

---

## IOC和DI

***

### 概念

IOC即控制反转，传统的编程方式中，业务逻辑的流程是由应用程序中被设定好关联关系的对象决定的，在使用IoC的情况下业务逻辑的流程是由对象关系图决定的。IoC就是一种给予应用程序中目标组件更多控制的设计范式，简单来说就是把对象的控制权委托给spring框架，由Spring来管理对象及其依赖关系，作用是降低代码的耦合度。

②DI即依赖注入，是IOC的一种具体实现方式。IoC的实现方式有依赖注入和依赖查找，由于依赖查找使用的很少，所以默认IoC就是DI。依赖注入是编译阶段尚未知所需功能是来自哪个类的情况下，将其他对象所依赖的功能对象实例化的模式。假设一个Car类需要Engine的对象，那么一般需要new一个Engine，利用IOC就是只需要定义一个私有的Engine引用变量，容器会在运行时创建一个Engine的实例对象并将引用自动注入给变量。

---

### DI实现方式

①构造方法注入，IoC Service Provider会检查被注入对象的构造方法，取得它所需要的依赖对象列表，进而为其注入相应的对象。这种方法的优点是在对象构造完成后，就处于就绪状态，可以马上使用。缺点是当依赖对象较多时，构造方法的参数列表会比较长。构造方法无法被继承，无法设置默认值。对于非必需的依赖处理可能需要引入多个构造方法，参数数量的变动可能会造成维护的困难。②Setter方法注入，当前对象只需要为其依赖对象对应的属性添加setter方法，就可以通过setter方法将依赖对象注入到被依赖对象中。Setter方法注入在描述性上要比构造方法注入强，并且可以被继承，允许设置默认值。缺点是无法在对象构造完成后马上进入就绪状态。③接口注入，必须实现某个接口，这个接口提供一个方法来为其注入依赖对象。使用较少，因为它强制要求被注入对象实现不必要的接口，侵入性强。

---

### DI相关注解

①@Autowired自动按类型注入，如果有多个匹配则按照指定bean的id查找，查找不到会报错。②@Qualifier在自动按照类型注入的基础之上，再按照 Bean 的 id 注入，给成员变量注入时必须搭配@Autowired，给方法注入时可单独使用。③@Resource直接按照 Bean 的 id 注入。④@Value用于注入基本数据类型和String。

---

## Bean

### **BeanFactory、FactoryBean、ApplicationContext的区别**

①BeanFactory是一个Bean工厂，是SpringIoC容器最顶级的接口，可以理解为含有Bean集合的工厂类，它的作用是管理Bean，包括实例化、定位、配置应用程序中的对象及建立这些对象之间的依赖。BeanFactory使用了延迟加载，适合多例模式。②FactoryBean是一个工厂Bean，作用是生产其他Bean实例，可以通过实现该接口，提供一个工厂方法来自定义实例化Bean的逻辑。③ApplicationConext是BeanFactory的子接口，扩展了其功能，提供了支持国际化的文本消息，统一的资源文件读取方式，事件传播以及应用层的特别配置等。ApplicationContext是立即加载，适合单例模式，一般推荐使用ApplicationContext。

### **Spring中bean对象的生命周期**

在一个bean实例被初始化时需要执行一系列初始化操作使其达到可用的状态，同样当一个bean不再被调用时需要进行相关的析构操作，并从bean容器中移除。Spring的 Bean Factory负责管理在容器中被创建的bean生命周期，bean的生命周期由两组回调方法组成，初始化之后调用的回调方法，销毁之前调用的回调方法。

Spring提供了4种方式来管理Bean的生命周期：①InitializingBean和DisposableBean接口。②针对特殊行为的其他Aware接口。③Bean配置种的init-Method和destory-Method。④@PostConstruct和@PreConstruct注解。

### **bean的作用范围**

通过scope指定bean的作用范围，有①singleton：单例的，默认的作用域，每次容器返回的对象是同一个。②prototype :多例的，每次返回的对象是新创建的实例。③request：仅作用于HttpRequest，每次Http请求都会创建一个新的bean，在请求完成后bean会失效并被垃圾回收器回收。④session：仅作用于HttpSession，不同的session使用不同的实例，相同的session使用同一个实例，session过期后bean会随之失效。⑤global session ：仅作用于HttpSession，所有的Session使用同一个实例。

### **创建Bean对象的方式**

**XML：**

①通过默认无参构造方法创建Bean。使用bean标签，只需要指明id和class属性，如果没有无参构造方法会报错。②使用静态工厂方法创建Bean，通过bean标签中的class属性指明静态工厂，factory-method属性指明静态工厂方法。③使用实例工厂方法创建Bean，通过bean标签中的factory-bean属性指明实例工厂，factory-method属性指明实例工厂方法。

**注解：**

使用@Bean注解，由@Bean注解的方法将会实例化、配置和初始化一个新对象，这个对象由Spring的IoC容器来管理。

---

## AOP

### 概念和原理

***

①Aop即面向切面编程，简单地说就是将代码中重复的部分抽取出来，在需要执行的时候使用动态代理的技术，在不修改源码的基础上对方法进行增强。优点是可以减少代码的冗余，提高开发效率，维护方便。Spring会根据类是否实现了接口来判断动态代理的方式，如果实现了接口会使用JDK的动态代理，核心是InvocationHandler接口和Proxy类，如果没有实现接口会使用cglib的动态代理，cglib是在运行时动态生成某个类的子类，如果某一个类被标记为final，是不能使用cglib动态代理的。

②JDK的动态代理主要通过重组字节码实现，首先获得被代理对象的引用和所有接口，生成新的类必须实现被代理类的所有接口，动态生成Java代码后编译新生成的.class文件并重新加载到JVM运行。JDK代理直接写Class字节码，CGLib是采用ASM框架写字节码，生成代理类的效率低。但是CGLib调用方法的效率高，因为JDK使用反射来调用方法，CGLib使用FastClass机制为代理类和被代理类各生成一个类，这个类会为代理类或被代理类的方法生成一个index，这个index可以作为参数直接定位要调用的方法。

---

### 相关注解

@Before前置通知，@AfterThrowing异常通知，@AfterReturning后置通知，@After最终通知，@Around环绕通知。最终通知会在后置通知之前执行，为解决此问题一般使用环绕通知。

---

### 相关术语

- Joinpoint(连接点):指那些被拦截到的点，在 spring 中这些点指的是方法，因为 spring 只支持方法类型的连接点。例如业务层实现类中的方法都是连接点。

- Pointcut(切入点):指我们要对哪些 Joinpoint 进行拦截的定义。例如业务层实现类中被增强的方法都是切入点，切入点一定是连接点，但连接点不一定是切入点。

- Advice(通知/增强):指拦截到 Joinpoint 之后所要做的事情。

- Introduction(引介):引介是一种特殊的通知，在不修改类代码的前提下可以在运行期为类动态地添加一些方法或 Field。

- Weaving(织入):是指把增强应用到目标对象来创建新的代理对象的过程。spring 采用动态代理织入，而 AspectJ 采用编译期织入和类装载期织入。

- Proxy（代理）:一个类被 AOP 织入增强后，就产生一个结果代理类。

- Target(目标):代理的目标对象。

- Aspect(切面):是切入点和通知（引介）的结合。

---

# 计算机网络

## 概述

本章重要内容：

（1）互联网边缘部分和核心部分的作用

（2）计算机网络的性能指标

（3）计算机网络分层的体系结构

### 计算机网络在信息时代的作用

21世纪的重要特征：数字化、网络化、信息化，一个以网络为核心的信息时代。

有三类网络：电信网络（提供电话、电报、传真等服务）、有线电视网络（传送电视节目）和计算机网络（在计算机之间传送数据文件）。计算机网络是信息化过程的核心。

20世纪90年代后，以Internet为代表的计算机网络飞速发展，从最初仅供美国人使用的免费教育科研网络，发展为供全球使用的商业网络。

Internet译名：（1）因特网，全国科学技术名词审定委员会推荐，翻译较准确，但未得到推广。（2）互联网，流行译名。Internet由大量各种计算机互联，该译名可体现出Internet的主要特征。

仅在局部范围互连起来的计算机网络只能称为互连网，而不是互联网。互联网之所以能够向用户提供很多服务，基于两个重要特点：连通性（不管距离多远都可以便捷经济地交换信息）和共享（资源共享）。

---

### 互联网概述

起源于美国的互联网已发展未世界上最大的覆盖全球的计算机网络。

计算机网络（简称网络）由若干结点（node）和连接这些结点的链路（link）组成。网络中的结点可以是计算机、集线器、交换器或路由器等。

网络之间通过路由器互连，构成一共覆盖范围更大的计算机网络，称为互连网。互连网是网络的网络。与网络相连的计算机常称为主机（host）。

互联网的基础结构大体上经历了三个阶段的演进。

第一个阶段：从单个网络ARPNET向互连网发展的过程。1969年美国国防部创建了第一个分组交换网ARPNET。1983年TCP/IP协议称为ARPNET的标准协议，所有使用该协议的计算机都能利用互连网通信，因此1983年被作为互连网的诞生时间。

internet（互连网）是一个通用名词，泛指由多个计算机网络互连而成的计算机网络。这些网络之间的通信协议可任意选择。

Internet（互联网，或因特网）是一个专用名词，指当前全球最大开放的、由众多网络相互连接而成的特定互联网，采用TCP/IP协议族作为通信规则，前身是美国的ARPNET。

第二阶段的特点是建成了三级结构的互联网（主干网、地区网、校园网或企业网）。

第三阶段的特点是形成了多层次ISP结构的互联网。互联网服务提供者ISP就是一个进行商业活动的公司，也译为互联网服务提供商（中国电信、中国移动）。所谓上网就是指通过某ISP获得的IP地址接入到互联网。

ISP按照提供服务的覆盖面积大小和拥有IP地址数目的不同分为：主干ISP（由几个专门公司创建和维持，服务面积最大）、地区ISP（较小的ISP，通过主干ISP连接）和本地ISP（给用户提供直接的服务，可以连接到地区ISP或主干ISP）。

互联网交换点IXP的主要作用：允许两个网络直接相连并交换分组，不需要再通过第三个网络来转发分组。IXP由一个或多个网络交换机组成，许多ISP再连接到这些网络交换机的相关端口。IXP常采用工作在数据链路层的交换机，这些交换机都用局域网互连起来。

互联网的迅猛发展始于20世纪90年代，欧洲原子核研究组织CERN开发的万维网WWW被广泛使用在互联网上。

所有的互联网标准都是以RFC（请求评论）的形式在互联网发表的。

制定互联网的正式标准要经历：（1）互联网草案（2）建议标准（此时成为RFC文档）（3）互联网标准

---

### 互联网的组成

从工作方式上可分为：（1）边缘部分，由所有连接在互联网上的主机组成。这部分是用户直接使用的，用来进行通信和资源共享。（2）核心部分，由大量网络和连接这些网络的路由器组成，为边缘部分提供服务（连通性和交换）。

处在互联网边缘的部分就是连接在互联网上的所有主机，又称为端系统。边缘部分利用核心部分的服务使众多主机之间能够互相通信并交换或共享数据。主机A和主机B通信，是指主机A的某个进程和主机B的另一个进程通信，简称为计算机之间通信。

在网络边缘的端系统之间的通信方式可分为：客户-服务器方式（C/S）和对等方式（P2P）。

客户-服务器方式是最常用的，也是传统方式，如发送电子邮件和上网查找资料。客户（client）和服务器（server）都是指通信中设计的两个应用进程。客户-服务器方式描述的是进程之间服务和被服务的关系。客户是服务请求方，服务器是服务提供方。

客户程序特点：被客户调用后主动向远地服务器发起通信，因此必须知道服务器程序的地址。不需要特殊硬件和复杂的操作系统。

服务器程序特点：专门用来提供某种服务的程序，可同时处理多个远地或本地客户请求。系统启动后自动调用并不断运行，被动等待并接受来自各地的客户通信请求。不需要知道客户程序的地址。一般需要强大的硬件和高级操作系统的支持。

对等连接是指两台主机在通信时并不区分哪一个是服务请求方哪一个是服务提供方。从本质上对等连接方式依旧是客户-服务器方式，只是对等连接中的每一台主机既是客户又是服务器。

网络核心部分向网络边缘中的大量主机提供连通性，使边缘部分的任何一台主机都能够向其他主机通信。在网络核心部分起特殊作用的是路由器（router），它是一种专用计算机（不叫主机）。路由器是实现分组交换的关键构建，其任务是转发收到的分组，是网络核心部分最重要的功能。

电路交换：交换就是按照某种方式动态地分配传输线路的资源。必须经过建立连接（占用通信资源）->通话（一直占用通信资源）->释放连接（归还通信资源）三个步骤的交换方式称为电路交换。电路交换的重要特点：在通话的全部时间内，通话的两个用户始终占用端到端的通信资源。电路交换传送计算机数据的效率很低。

分组交换：采用存储转发技术。把要发送的整块数据称为一个报文（message），发送前将其划分为一个个更小的等长数据段，在每一个数据段之前加上一些必要的控制信息组成的首部（header）后就构成了一个分组（packet）。分组又称为包，而分组的首部也可以称为包头。分组是在互联网中传送的数据单元。分组的首部中包含了诸如目的地址和源地址等重要信息，因此每个分组才能在互联网中独立选择传输路径并被正确交付到分组传输的终点。

位于网络边缘的主机和位于网络核心部分的路由器都是计算机，但作用不一样。主机是为用户进行信息处理的，并可以和其他主机通过网络交换信息。路由器是用来转发分组的。

路由器暂时存储的是一个个短分组，不是整个的长报文。短分组暂存在路由器的存储器（内存）中而不是磁盘中，这保证了较高的交换速率。分组交换在传送数据之前不必先占用一条端到端的链路的通信资源，分组是断续占用通信资源的，因而数据传输效率高。

采用存储转发的分组交换，实质上是采用了在数据通信的过程中断续（或动态）分配传输带宽的策略。适合传送突发式的计算机数据。为提高分组交换网的可靠性，互联网的核心部分常采用网状拓扑结构。

分组交换的优点：（1）高效，动态分配传输带宽，逐段占用通信链路。（2）灵活，为每一个分组独立选择最合适的转发路由。（3）迅速，以分组作为单位，可以不先建立连接就能向其他主机发送分组。（4）可靠，保证可靠性的网络协议。

分组交换的问题：（1）存储转发需要排队，存在一定时延。（2）不预先建立连接，无法确保通信时端到端所需的带宽。（3）携带的控制信息造成开销。

电路交换：整个报文的比特流连续地从源点直达终点，好像在一个管道中传送。

报文交换：整个报文先传送到相邻结点，全部存储后查找转发表再转发到下个结点。

分组交换：单个分组传送到相邻结点，存储下来后查找转发表转发到下个结点。

若要连续传送大量数据且传送时间远大于建立时间，则电路交换的传输速率较快。报文交换和分组交换不需要预先分配传输带宽，在传送突发数据时可提高网络的信道利用率。由于分组的长度远小于整个报文的长度，分组交换比报文交换时延小，也具有更好的灵活性。

---

### 计算机网络在我国的发展

最早着手建设专用计算机广域网的是铁道部，1989年我国第一个公用分组交换网CNPAC建成运行。1994年我国用64kbit/s专线正式接入互联网，同年中科院设立了第一个万维网服务器。

---

### 计算机网络的类别

- **按照网络的作用范围**

  - **广域网WAN** 作用范围几十到几千公里，也称远程网。广域网是互联网的核心部分，任务是通过长距离运送主机发送的数据。连接广域网的各结点交换机的链路是高速链路，有较大的通信容量。

  - **城域网MAN** 作用范围一般是城市，约5-50km。用来将多个局域网互连，许多城域网采用以太网技术，因此有时也并入局域网范围讨论。

  - **局域网LAN** 一般用微型计算机或工作站通过高速通信线路相连，地理上局限在较小范围（1km左右）。

  - **个人区域网PAN** 在个人工作的地方把属于个人使用的电子设备用无线技术连接起来的网络，也称无线个人区域网WPAN，范围很小，大约在10m左右。

  若中央处理器之间距离非常近（1m甚至更小），则称多处理机系统而不是计算机网络。

- **按照网络的使用者**

  - 公用网 指电信公司建造的大型网络，所有按规定付费的人都可使用，也称公众网。

  - 专用网 某个部门为满足本单位的特殊业务需要建造的网络，一般不对外提供服务。

-  **用来把用户接入到互联网的网络**

  接入网AN（Access Network），称为本地接入网或居民接入网。接入网本身既不属于互联网的核心部分，也不属于边缘部分。接入网是从某个用户端系统到互联网的第一个路由器（边缘路由器）之间的一种网络。从覆盖范围看属于局域网。初期用户多用电话线拨号接入，速率很低，现在多用宽带接入。

---

### 计算机网络的性能

计算机网络的性能一般指它的几个重要指标，此外一些非性能特征也对计算机网络的性能有很大影响。

- 计算机网络的性能指标：

  - **速率** 

    计算机发出的信号都是数字形式的。网络中速率指数据的传送速率，也称数据率或比特率，一个比特就是二进制数字的一个0或1。

  - **带宽** 

    原指某个信号具有的频带宽度（频域称谓），单位是赫兹。计算机网络中，带宽表示网络中某通道传送数据的能力（时域称谓），网络带宽表示单位时间内某信道能通过的最高数据率，单位即数据率的单位bit/s。

  - **吞吐量** 

    单位时间内通过某个网络（信道/接口）的实际数据量。受到带宽或网络额定速率的限制。

  - **时延** 

    数据从网络（链路）的一端传送到另一端所需的时间，也称迟延或延迟。

    - 发送时延：主机或路由器发送数据帧需要的时间，也就是发送数据帧的第一个比特算起，到该帧的最后一个比特发送完毕所需的时间，也叫传输时延。

      发送时延=数据帧长度（bit）/发送速率（bit/s）

    - 传播时延：电磁波在信道中传播一定的距离需要花费的时间。

      传播时延=信道长度（m）/电磁波在信道上的传播速率（m/s）

      发送时延发生在机器内部的发送器中（一般在网络适配器中），与传输信道的长度（或信号传送的距离）无关。传播时延发生在机器外部的信道媒体上，与信号的发送速率无关。

    - 处理时延：主机或路由器收到分组时要花费一定时间进行处理。

    - 排队时延：分组进入路由器后要再输入队列中排队等待处理。

      对于高速网络链路，提高的仅是数据的发送速率，而不是比特在链路上的传播速率。 

    - 时延带宽积 =传播时延x带宽，又称以比特为单位的链路长度，表示链路可容纳多少个比特。

  - **往返时间RTT** 

    有效数据率=数据长度/（发送时间+RTT）

  - **利用率** 

    有信道利用率和网络利用率，信道利用率指某信道有百分之几的时间是被利用的（有数据通过），完全空闲的信道利用率为0。网络利用率时全网络的信道利用率的加权平均值。

    网络当前时延D=网络空闲时延D0/（1-利用率U）。信道或网络的利用率过高会产生非常大的时延。

- **计算机网络的非性能特征**

  - 费用 ：一般来说网速越高，价格越高
  - 质量 ：取决于网络中构件的质量和构件组成网络的方式
  - 标准化 ：最好采用国际标准，可得到更好的互操作性，易于得到技术支持
  - 可靠性 ：与网络的性能和质量密切相关
  - 可扩展性和可升级性： 性能越高扩展费用和难度越高
  - 易于管理和维护 ：没有良好管理和维护很难达到和保持目标性能

---

### 计算机网络的体系结构

相互通信的两个计算机系统必须高度协调，为设计这样复杂的计算机网络，最初ARPNET设计时就提出了分层的方法。分层可将庞大而复杂的问题转化为若干较小的局部问题，从而易于研究和管理。

为使不同网络体系结构的计算机网络实现互连，国际标准化组织ISO提出了著名的开放系统互连参考模型OSI/RM，简称OSI。开放指非独家垄断，只要遵循OSI标准，系统就可和世界上任何地方的也遵循统一标准的其他任何系统通信。系统指在现实的系统中与互连有关的各部分。OSI是抽象概念，1983年形成了ISO 7498国际标准，即七层协议的体系结构。

- **OSI失败原因**
  - 专家缺乏实际经验
  - 实现复杂，效率低
  - 制订周期太长，按OSI标准生产的设备无法及时进入市场
  - 层次划分不合理，有些功能在多层次重复

- **网络协议**

  为网络中的数据交换建立的规则、标准或约定

  由以下三个要素组成：

  - 语法，数据与控制信息的结构或格式。
  - 语义，需要发出何种控制信息，完成何种动作以及做出何种响应。
  - 同步，事件实现顺序的详细说明。

- **分层好处**
  - 各层之间是独立的。某一层不需要知道它下一层的具体实现，只需要知道该层通过层间接口所提供的服务。降低了整个问题的复杂性。	
  - 灵活性好。任何一层发生变化时，只要层间接口的关系不变，则这层以上或以下均不受影响。
  - 结构上可分隔开 各层都可采用最合适的技术实现
  - 易于实现和维护
  - 可促进标准化工作 分层时应使每一层的功能非常明确，各层的功能主要有以下（可包含一种或多种）：差错控制，使相应层次对等方的通信更加可靠；流量控制，发送端的发送速率必须使接收端来得及接受；分段和重装，发送端将数据库划分，在接收端还原；复用和分用，发送端几个高层会话复用一条低层连接，在接收端再进行分用；连接建立和释放，交换数据前先建立一条逻辑连接，数据传送结束后释放。

网络的体系结构：计算机网络的各层及其协议的集合。体系结构是抽象的，实现是具体的，是真正在运行的计算机硬件和软件。

OSI的七层协议体系结构概念清楚，理论完整，但既复杂又不实用。TCP/IP体系结构则不同，TCP/IP是一个四层体系结构，包含应用层、运输层、网际层和网络接口层。从实质上讲TCP/IP只有最上面的三层，因为网络接口层没有具体内容。因此学习计算机网络原理时往往采取折中方法，综合OSI和TCP/IP的优点，采用一种只有五层协议的体系结构。

- 应用层

  体系结构中的最高层，任务是通过应用进程间的交互来完成特定网络应用。应用层协议定义的是应用进程间通信和交互的规则。应用层协议：DNS、HTTP、SMTP。应用层数据单元：报文（message）。

- 运输层

  运输层的任务就是负责向两台主机中进程之间的通信提供通用的数据传输服务。由于一台主机可同时运行多个进程，因此运输层有复用和分用的功能。复用就是多个应用层进程可同时使用下面运输层的服务，分用是运输层把收到的信息分别交付上面应用层中的相应进程。

  运输层主要使用以下两种协议：

  - 传输控制协议TCP：提供面向连接的、可靠的数据传输服务，数据传输单位是报文段（segment）。

  - 用户数据报协议UDP：提供无连接的、尽最大努力的数据传输服务（不保证数据传输的可靠性），数据传输单位是用户数据报。

- 网络层

  网络层负责为分组交换网上的不同主机提供通信服务，网络层把运输层产生的报文段或用户数据报封装成分组或包进行传送。在TCP/IP体系中，网络层使用IP协议，因此分组也叫做IP数据报，或简称数据报。

  无论哪一层传送的数据单元，都可笼统地用分组来表示，运输层的用户数据报UDP和网络层的IP数据报不同。

  网络层的另一个任务即选择合适的路由，使源主机运输层传下来的分组，能够通过网络中的路由器找到目的主机。网络层中的网络不是通常提到的具体网络，而是计算机网络体系结构模型中的第三层的名称。

  互联网由大量的异构网络通过路由器相互连接起来。互联网使用的网络层协议是无连接的网际协议IP和许多种路由选择协议，因此互联网的网络层也叫做网际层或IP层。

- 数据链路层

  简称为链路层。两个相邻结点之间传送数据时，数据链路层将网络层交下来的IP数据报组装成帧（framing），在两个相邻结点之间的链路上传送帧（frame）。每一帧包括数据和必要的控制信息（如同步信息、地址信息、差错控制等）。

  接收数据时，控制信息使接收端能够知道一个帧从哪个比特开始到哪个比特结束。还使接收端能够检测收到的帧中有无差错，如发现差错就简单地丢弃。

- 物理层

  传送的数据单位是比特。物理层要考虑用多大的电压代表1或0，以及接收方如何识别发送方所发送的比特。物理层还要确定连接电缆的插头应有多少根引脚以及各引脚如何连接。传递信息所利用的物理媒体，如双绞线、同轴电缆、光缆、无线信道等并不在物理层协议内而是其下面。

TCP/IP并不一定单指TCP和IP两个具体的协议而是表示互联网所使用的整个TCP/IP协议族。 

主机1的应用进程M向主机2的应用进程N传送数据时，M将数据交给应用层，应用层加上控制信息后（变为下一层的数据单元）再传给运输层，如此逐层递交，到了第二层（数据链路层）后，控制信息被分为两部分，分别加到本数据单元的首部和尾部，而第一层（物理层）由于是比特流的传送，所以不加控制信息，传送比特流时应从首部开始。OSI将对等层之间传送的数据单位称为该层的协议数据单元PDU。

比特流离开主机1经网络的物理媒体传送到路由器，从路由器的第一层依次上升到第三层，每一层都根据控制信息进行必要操作，然后剥去控制信息，将剩下的数据单元交给更高层。当分组到第三层时根据首部中的目的地址查找路由器中转发表，找出转发分组的接口，然后往下传送到第二层，加上新的首部和尾部，再到第一层，发送比特。

比特流到达主机2时，就从主机2的第一层按上述方式依次上升到第五层，最后把应用进程M发送的数据交给目的站的应用进程N。

使用实体（entity）表示任何发送或接收信息的硬件或软件进程，许多情况下实体就是一个特定的软件模块。

协议是控制两个对等实体进行通信的规则的集合。协议的语法定义了所交换的信息的格式，协议的语义定义了发送者或接收者所要完成的操作。在协议的控制下，两个对等实体间的通信使得本层能够向上一层提供服务。要实现本层协议，还需要使用下面一层提供的服务。

协议和服务是不同的。协议的实现保证了能够向上一层提供服务，使用本层服务的实体只能看见服务而无法看见下面的协议，下面的协议对上面的实体是透明的。

协议是水平的，是控制对等实体直接的通信规则。但服务是垂直的，即由下层向上层通过层间接口提供的。只有能被高一层实体看得见的功能才能称为服务，上层使用下次服务必须通过与下层交换一些命令（在OSI中称为服务原语）。

同一系统中相邻两层的实体进行交互的地方称为服务访问点SAP。SAP是一个抽象概念呢，实际上是一个逻辑接口，OSI把层与层之间交换的数据的单位称为服务数据单元SDU，它可以与PDU不一样，例如可以是多个SDU合为一个PDU，也可以是一个SDU划分为几个PDU。

第n层向第n+1层提供的服务已经包括在它以下的各层提供的服务。第n层的实体对第n+1的实体相当于一个服务提供者，在服务提供者的上一层的实体又称为服务用户，因为它使用下层服务提供者提供的服务。

协议必须把所有不利的条件实现估计到，而不能假定一切都是正常的和非常理想的。因此看一台计算机网络协议是否正确，不能只看正常情况下是否正确，还必须非常仔细检查这个协议能否应付各种异常情况。

TCP/IP协议可为各种应用提供服务，同时TCP/IP协议也允许IP协议在各式各样的网络构成的互联网上允许。IP协议在互联网中起核心作用。

---

###  本章的重要概念

计算机网络（简称网络）把许多计算机连接在一起，而互连网则把许多网络连在一起，是网络的网络。

以i小写开头的internet（互连网）是通用名词，泛指由多个计算机网络互连而成的网络，在这些网络之间的通信协议可以是任意。

以I大写开头的Internet（互联网）是专用名词，指当前全球最大的、开发的、由众多网络相互连接而成的特定互连网，并采用TCP/IP协议族作为通信规则，前身是美国的ARPNET。

互联网采用存储转发的分组交换技术以及三层ISP结构。

互联网按工作方式分为边缘部分与核心部分。主机在网络的边缘部分，作用时进行信息处理。路由器在网络的核心部分，其作用是按存储转发方式进行分组交换。

计算机通信时计算机中进程的通信，通信方式分为客户-服务器方式和对等连接方式（P2P）。

客户和服务器都是通信中涉及的应用进程，客户是服务请求方，服务器是服务提供方。

按作用范围不同，计算机网络分为广域网WAN、城域网MAN、局域网LAN和个人区域网PAN。

计算机网络的常用性能指标：速率、带宽、吞吐量、时延、时延带宽积、防范时间和信道（网络）利用率。

网络协议即协议，是为进行网络中的数据交换而建立的规则，计算机网络的各层及其协议的集合，称为网络的体系结构。

五层协议的体系结构由应用层、运输层、网络层（网际层）、数据链路层和物理层组成。运输层最重要的协议是TCP和UDP协议，而网络层最重要的是IP协议。

---

## 物理层

本章重要内容：

（1）物理层的内容

（2）几种常用的信道复用技术

（3）几种常用的宽带接入技术，主要是ADSL和FTTx

###  物理层的基本概念

物理层考虑的是怎样才能在连接各种计算机的传输媒体上传输数据比特流，而不是指具体的传输媒体。物理层的作用是尽可能屏蔽掉传输媒体和通信手段的差异，使物理层上面的数据链路层感觉不到这些差异，使其只需考虑如何完成本层的协议和服务，而不必考虑网络具体的传输媒体和通信手段。用于物理层的协议也称物理层规程。

将物理层的主要任务描述为确定与传输媒体接口有关的一些特性：

（1）机械特性：指明接口所用接线器的相关规定。

（2）电气特性：指明接口电缆的各条线上出现的电压范围。

（3）功能特性：指明某条线上出现的某一电平的电压的意义。

（4）过程特性：指明对于不同功能的各种可能事件的出现顺序。

数据在计算机内部多采用并行传输，但在通信线路（传输媒体）上的传输方式一般都是串行传输，即逐个比特按照时间顺序传输。因此物理层还要完成传输方式的转换。

物理层协议种类较多，因为物理连接方式很多，而传输媒体的种类也很多，学习物理层时，重点放在掌握基本概念上。

---

### 数据通信的基本知识

一个数据通信系统可划分为三大部分，源系统（发送端、发送方）、传输系统（传输网络）和目的系统（接收端、接收方）。

源系统一般包括以下两部分：

（1）源点（source） 源点设备产生要传输的数据，源点又称源站，或信源。

（2）发送器 源点生成的数字比特流通过发送器编码后才能够在传输系统进行传输，典	型的发送器是调制器。

（3）接收器 接受传输系统传送过来的信号，并把它转换为能够被目的设备处理的信息。	典型的接收器是解调器，它把来自传输线路上的模拟信号解调，提取出在发送端置入的	消息，还原出数字比特流。

（4）终点（destination） 终点设备从接收器获取传送来的数字比特流，然后把信息输	出。终点又称为目的站，或信宿。

源系统和目的系统之间的传输系统可以是简单的传输线，也可以是连接在两系统之间的复杂网络系统。

通信的目的是传送消息（message）。数据（data）是运送消息的实体，数据是使用特定方式表示的信息，通常是有意义的符号序列。信号（signal）是数据的电气或电磁的表现。

根据信号中代表消息的参数的取值方式不同，信号可分为以下两大类：

（1）模拟信号，或连续信号 代表消息的参数的取值是连续的。用户家中的调制解调器到电话端局之间的用户线上传送的就是模拟信号。

（2）数字信号，或离散信号 代表消息的参数的取值是离散的。用户家中的计算机到调制解调器之间，或在电话网中继线上传送的就是数字信号。在使用时间域的剥削表示数字信号时，代表不同离散数值的基本波形称为码元。二进制编码时，只有两种不同的码元，一种代表0状态一种代表1状态。

信道（channel）和电路并不等同，信道一般都是用来表示向某个方向传送信息的媒体。因此一条通信电路往往包含一条发送信道和一条接收信道。

从通信双方的信息交互方式来看，有以下三种基本方式：

（1）单向通信 又称单工通信，即只能有一个方向的通信而没有反方向的交互。例如：无线电广播、有线电广播，电视广播。

（2）双向交替通信 又称半双工通信，即通信双方都可以发送信息，但不能双方同时发送。一方发送而另一方接收，过一段时间后可以再反过来。

（3）双向同时通信 又称全双工通信，即通信的双方可以同时发送和接收信息。

单向通信只需要一条信道，而双向交替通信或双向同时通信都需要两个信道（每个方向各一条）。双向同时通信的传输效率最高。

来自信源的信号常称为基带信号（基本频带信号）。计算机输出的代表各种文字或图像文件的数据信号都属于基带信号。基带信号一般包含较多低频成分，甚至直流成分，许多信道不能传输这种低频分量或直流分量，为解决该问题必须对基带信号进行调制。

调制可分为两大类。一类仅对基带信号的波形进行变换，使它与信道特性相适应，变换后的信号仍是基带信号，这类调制叫基带调制。由于这种调制时把数字信号转换成另一种形式的数字信号，也成为编码（coding）。另一类调制则需要使用载波（carrier）进行调制，把基带信号的频率范围搬移到较高的频段，并转换为模拟信号。经过载波调制的信号为带通信号，使用载波的调制称为带通调制。

---

常用编码方式：

（1）不归零制 正电平=1，负电平=0

（2）归零制 正脉冲=1，负脉冲=0

（3）曼彻斯特编码 位周期中心的向上跳变=0，位周期中心的向下跳变=1，也可反过来定义

（4）差分曼彻斯特编码 每一位的中心处始终有跳变，位开始边界有跳变=0，位开始边界没有跳变=1

基本的带通调制方法：

（1）调幅（AM）载波的振幅随基带数字信号变化，例如1或0分别对应无载波和有载波输出。

（2）调频（FM） 载波的频率随基带数字信号变化，例如1或0分别对应频率f1或f2。

（3）调相（PM） 载波的初始相位随基带数字信号变化，例如1或0分别对应相位0度或180度。

为达到更高信息传输速率，必须采用技术上更为复杂的多元制的振幅相位混合调制，如正交振幅调制QAM。

---

数字通信的优点：虽然信号在信道上产生失真，但接收端只要从失真的波形中识别出原来的信号，那么对通信质量就没有影响。码元传输速率越高，信号传输的距离越远，或噪声干扰越大，传输媒体质量越差，在接收端的波形失真就越严重。

限制码元在信道上传输速率的因素有以下两个：

（1）信道能通过的频率范围

在接收端收到的信号波形失去了码元之间的清晰界限，这种现象叫做码间串扰。1924年内奎斯特推导出了奈式准则。在任何信道中，码元传输的速率是有上限的，传输速率超过此上限，就会出现严重的码间串扰问题，使接收端对码元的判决（识别）成为不可能。

信道频带越宽，能通过的信号高频分量越多，那么就可以用更高速的速率传送码元而不出现码间串扰。

（2）信噪比

噪声存在于所有电子设备和通信设备中，由于噪声随机产生，它的瞬时值有时会很大，因此噪声会使接收端对码元的判决产生错误（1误判为0或0误判为1）。噪声影响是相对的，信号较强噪声的影响就较小。信噪比即信号的平均功率和噪声的平均功率之比，记为S/N，用分贝（dB）作为度量单位。

信噪比（dB）=10 log10(S/N)（dB）

1948年，香农推导出了香农公式，香农公式指出信道的极限信息传输速率C是

C=W log2（1+S/N）

W为信道的带宽（以Hz为单位），S为信道中所传信号的平均功率，N为信道内部的高斯噪声功率。香农公式表明，信道的带宽或信道中的信噪比越大，信息的极限传输速率就越高。该公式的意义在于：只要信息传输速率低于信道的极限信息传输速率，就一定存在某种方法来实现无差错的传输。

若频带宽度已确定的信道，如果信噪比也不能提高，可让每个码元携带更多比特的信息量以提高信息的传输速率。

---

### 物理层下面的传输媒体

传输媒体也称传输媒介或传输介质，它是数据传输系统中在发送器和接收器之间的物理通路。传输媒体可分为两大类，即导引型传输媒体和非导引型传输媒体。在导引型传输媒体中，电磁波被导引沿着固体媒体（铜线或光纤）传播，而非导引型传输媒体就是指自由空间，在非导引型传输媒体中电磁波的传输称为无线传输。

---

导引型传输媒体

（1）双绞线

双绞线也称双扭线，是最古老但又是最常用的传输媒体。把两根互相绝缘的铜导线并排放在一起，然后用规则的方法绞合起来就构成了双绞线。绞合可减少对相邻导线的电磁干扰，使用双绞线最多的是电话系统。从用户电话机到交换机的双绞线称为用户线或用户环路。

模拟传输和数字传输都可使用双绞线，通信距离一般为几到十几公里。距离太长时要加放大器将衰减信号放大（模拟传输）或加上中继器对失真的数字信号整形（数字传输）。导线越粗，通信距离越远，价格越高。

为提高双绞线抗电磁干扰能力，可在双绞线的外面再加一层用金属丝编织成的屏蔽层。这就是屏蔽双绞线，简称STP，价格高于无屏蔽双绞线UTP。

对传送数据来说，最常用的UTP是5类线，相比3类线大大增加了每单位长度的绞合次数，具有更高的绞合度，提高了线路的传输速率。

无论是哪种双绞线，衰减都随频率的升高而增大，使用更粗的导线可以降低衰减，但却增加了导线的重量和价格。信号应有足够大的振幅，以便在噪声干扰下能被接收端正确地检测出来。双绞线的最高速率与数字信号的编码方式有关。

（2）同轴电缆

同轴电缆由导体铜质芯线、绝缘层、网状编制的外导体屏蔽层以及保护塑料外层所组成。由于外导体屏蔽层的作用，同轴电缆有很好的抗干扰性，被广泛用于传输速率较高的数据。

局域网发展初期广泛使用同轴电缆，现在多用双绞线。同轴电缆主要用在有线电视网的居民小区中。同轴电缆的贷款取决于电缆的质量。

（3）光缆

光纤通信就是利用光导纤维传递光脉冲来进行通信。有光脉冲相当于1，没有相当于0。由于可见光频率非常高，因此光纤通信系统的传输带宽远远大于目前其他传输媒体的带宽。

光纤是光纤通信的传输媒体，发送端有光源，可采用发光二极管或半导体激光器，它们在电脉冲的作用下能产生光脉冲，在接收端利用光电二极管做成光检测器，检测到光脉冲时还原出电脉冲。

光纤通常由非常透明的石英玻璃丝拉成细丝，主要有纤芯和包层构成双层通信圆柱体。利用光的折射实现传输。

可以存在多条不同角度入社的光线在一条光纤中传输，这种光纤叫多模光纤。光脉冲在多模光纤中传输时会逐渐展宽，造成失真。因此多模光纤只适合近距离传输。若光线的直径减小到只有一个光的波长，则光线可一直向前传输，不会发生多次反射，这样的光纤称为单模光纤，成本较高，损耗小，可在高速率下传输远距离而不使用中继器。

光纤通信常用三个波段的中心分别位于850nm，1300nm和1550nm。后两种衰减较小，850nm衰减大但其他特性较好。所有三个波段都具有25000-30000GHz带宽，可见光纤通信容量非常大。

光纤除通信容量大，还有其他优点：

1.传输损耗小，中继距离长，对远距离传输经济。

2.抗雷电和电磁干扰性能好。

3.无串音干扰，保密性好，不易被窃听或截取数据。

4.体积小，重量轻。

（4）架空明线

铜线或铁线，在电线杆上架设地互相绝缘的明线，安装简单，通信质量差，已淘汰

---

非导引型传输媒体

当通信距离很远，敷设电缆既昂贵又费时，利用无线电波在自由空间的传播可较快地实现多种通信，由于该通信方式不使用各种导引型传输媒体，因此将自由空间称为非导引型传输媒体。

无线传输可使用的频段很广，紫外线和更高的波段目前还不能用于通信。

短波通信（高频通信）主要靠电离层的反射，但电离层的不稳定产生的衰落现象和电离层反射产生的多径效应（同一信号经过不同反射路径到达同一个接受点，但各反射路径的衰减和时延都不同，使得合成信号失真很大），使得短波信道的通信质量较差。使用短波无线电台传送数据时，一般都是低速传输，除非采用复杂的调制解调技术才能提速。

无线电微波通信在数据通信中占有重要地位，微波在空间主要是直线传播，传统的微波通信主要有两种，地面微波通信接力通信（由于微波直线传输而地球是曲面，传播距离受限，为实现远距离通信必须在一条微波通信信道的两个终端之间建立若干中继站，中继站把前一站送来的信号放大后再发送到下一站，称为接力）和卫星通信。

微波接力可传输电话、电报、图像、数据等信息，主要特点是：

（1）波段频率高，频段范围宽，通信信道容量很大

（2）传输质量高（工业干扰和天电干扰的主要频谱成分比微波频率低很多）

（3）与电缆载波通信比，建设投资小，见效快，易于跨山区，江河

微波缺点：

（1）相邻站之间必须直视（常称为视距LOS）不能有障碍物，否则会失真

（2）有时也会受恶劣天气影响

（3）与电缆通信比，屏蔽性和保密性较差

（4）中继站需要大量人力物力维护

卫星通信是利用人造同步地球卫星作为中继器的一种微波接力通信。主要优缺点和微波接力通信相似，最大特点是通信距离远，且费用和距离无关。另一特点是有较大的传播时延（不等同于传送数据的时延大）。适合偏远处的通信，还非常适合广播通信，覆盖面很广，但保密性较差。

红外通信、激光通信也使用非导引型媒体，可用于近距离的笔记本电脑相互传送数据。

---

### 信道复用技术

复用（multiplexing）是通信技术中的基本概念。

最基本的复用就是频分复用FDM和时分复用TDM。频分复用最简单，用户在分到一定频带后，在通信过程中始终占用这个频带，可见频分复用的所有用户在同样的时间占用不同的带宽资源。时分复用则将时间划分为一段段等长的时分复用帧（TDM帧），每个时分复用用户在每个TDM帧中占用固定序号的时隙。每个用户占用的时隙周期性出现，TDM信号也称等时信号，时分复用的所有用户在不同的时间占用同样的频带宽度。这两种复用的优点是技术成熟，缺点是不灵活。时分复用更有利于数字信号的传输。

在进行通信时，复用器总是和分用器成对使用，复用器和分用器之间的是用户共享的高速信道，分用器的作用和复用器相反，它把高速信道中的数据进行分用，交送到相应用户。

由于计算机数据的突发性质，当用户在某一端时间无数据传输时，已经分配到的子信道是空的且其他用户也无法使用，因此时分复用可能会造成线路资源的浪费。统计时分复用STDM，一种改进的时分复用，能明显提高信道利用率。集中器常使用STDM。

统计时分复用使用STDM帧传送复用数据，但每个STDM帧中的时隙数小于连接在集中器上的用户数。各用户有了数据就发往集中器的输入缓存，集中器按顺序依次扫描输入缓存，把缓存中输入的数据放入STDM帧，没有数据的缓存就跳过，满了就发送，因此STDM帧并非固定分配资源，而是动态按需分配，STDM可以提高线路的利用率。在输出线路上，某个用户的时隙不是周期性出现，因此STDM又称为异步时分复用，而普通的时分复用称为同步时分复用。集中器正常工作的前提是各用户都是间歇性工作，否则缓存将溢出。

由于STDM帧动态分配，因此每个时隙中必须又用户的地址信息。使用STDM的集中器也叫做智能复用器，它能提供对整个报文的存储转发能力。TDM帧和STDM帧都是在物理层传送的比特流中划分的帧，并非数据链路层的帧。

---

波分复用WDM就是光的频分复用，由于光的频率很高，所以习惯用波长而不使用频率来表示所使用的光载波。最初人们只能在一根光纤上复用两路光载波信号，叫做波分复用WDM，现在已能做到在一根光纤上复用几十路或更多路数的光载波信号，于是就使用了密集波分复用DWDM。

波分复用的复用器为光复用器（又称合波器），分用器为光分用器（又称分波器），光信号传输时会衰减，通过掺铒光纤放大器EDFA将光信号转换成电信号，经过电放大器放大后再转换成光信号。

---

码分复用CDM是另一种共享信道的方法。更常用的名词是码分多址CDMA，每个用户可在同样的时间使用同样的频带通信，由于各用户使用经过特殊挑选的不同码型，因此个用户之间不会造成干扰。码分复用最初用于军事通信，因其信号具有很强的抗干扰能力，其频谱类似于白噪声，不易被敌人发现。现已广泛民用，特别是无线局域网中，CDMA可提高通信的话音质量和数据传输的可靠性，减少干扰影响，增大通信系统的容量等等。

CDMA中，每个比特时间再划分为m个短的间隔，称为码片。通常m=64或128。使用CDMA的每一个站被指配一个唯一的m bit码片序列。若要发送比特1，则发送自己的m bit码片序列。若要发送比特0，则发送该码片序列的二进制反码。码片中的0写为-1，1写为+1。假定S站要发送信息的数据率为b bit/s，由于每个比特要转换成m个比特的码片，则发送速率提高至mb bit/s，所占用的频带宽度也提高到m倍。这种通信方式是扩频通信中的一种，扩频通常有两大类，一种是直接序列扩频DSSS，如上述的使用码片序列就是这一种，另一种是跳频扩频FHSS。

CDMA系统的一个重要特点即这种体制给每一个站点分配的码片序列不仅必须各不相同，还必须相互正交。在使用的系统中是使用伪随机码序列。

令向量S表示站S的码片序列，T表示其他任何站的码片向量。两个不同站的码片序列正交，就是向量S和向量T的规格化内积都是0。任何一个码片向量和自己的规格化内积都为1，和自己反码的规格化内积为-1。

---

### 数字传输系统

早期电话网中，从市话局到用户电话机的用户线采用双绞线，而长途干线采用频分复用FDM的模拟传输方式。由于数字通信相比模拟通信无论质量还是经济上都有优势，目前长途干线大多采用时分复用PCM的数字传输方式。模拟线路基本只剩用户电话机到市话交换机之间的几公里长的用户线上。

数字化的同时，光纤开始成为长途干线最主要的传输媒体。光纤的高速带宽是用于承载高速率数据业务和大量服用的低速率业务。早期的数字传输系统存在许多缺点，主要是以下两个：（1）速率标准不统一。（2）非同步传输。为节约经费，各国数字网主要采用准同步方式，准同步系统中各支路信号时钟频率存在一定偏差，给时分复用和分用带来许多麻烦。为解决该问题，1988年美国推出了一个数字传输标准，同步光纤网SONET。

---

### 宽带接入技术

用户要连接到互联网，必须先连接到某个ISP，以获得上网所需的IP地址。从宽带接入的媒体看，可划分为有线宽带接入和无线宽带接入，此处讨论前者。

---

**ADSL技术**

非对称数字用户线ADSL技术使用数字技术对现有的模拟电话用户线进行改造，使它能够承载带宽数字业务。ADSL将低端频谱留给传统电话使用，把原来没有利用的高端频谱留给用户上网使用。由于用户上网主要是下载而非上传文件，因此ADSL的下行带宽（从ISP到用户）都远远大于上行（从用户到ISP）带宽，因此称为“非对称”。

ADSL的传输距离取决于数据率和用户线的线径（用户线粤西，信号传输时的衰减就越大）。此外ADSL所能得到的最高数据传输速率还与实际的用户线上的信噪比密切相关。

ADSL在用户线（铜线）的两端各安装一个ADSL调制解调器。我国目前采用的调制解调器实现方案使离散多音调DMT调制技术。多音调指多载波和多子信道。DMT调制技术采用频分复用FDM，把高端频谱划分为许多子信道，25个子信道用于上行信道，249个子信道用于下行信道，并用不同的载波（不同的音调）进行数字调制。这种做法相当于在一对用户线上使用许多小的调制器并行传送数据。由于用户线的具体条件差异大，因此ADSL采用自适应调制技术使用户线能够传送尽可能高的数据率。ADSL启动时，用户线两端的ADSL调制解调器就测试可用频率，各子信道干扰情况，信号的传输质量。这样ADSL就能选择合适的调制方案以获得较高的数据率，可见ADSL不能保证固定的数据率。

基于ADSL的接入网由以下三大部分组成：数字用户线接入复用器DSLAM，用户线和用户家中的一些设施。DSLAM包括许多ADSL调制解调器，ADSL调制解调器又称为接入端接单元ATU。由于ADSL调制解调器必须成对使用，因此把在电话端局（或远端站）和用户家中的ADSL调制解调器分别记为ATU-C（C表示端局Central Office）和ATU-R（R表示远端Remote）。用户电话通过电话分离器和ATU-R连接，经用户线到端局，并再次经过一个电话分离器把电话连到本地电话交换机。电话分离器是无源的（为在停电时不影响传统电话使用），它利用低通滤波器将电话信号和数字信号分开。

ADSL最大的好处即可以利用现有电话网中的用户线（铜线），而不需要重新布线。ADSL借助在用户线两端安装的ADSL调制解调器对数字信号进行了调制，使得调制后的数字信号的频谱适合在原来的用户线上传输。

第二代ADSL的改进：（1）通过提高调制效率得到了更高的数据率。（2）采用了无缝速率自适应技术SRA，可在运营中不断通信和不产生误码的情况下，根据线路实时状况，自适应调整数据率。（3）改善了线路质量测评和故障定位功能。

ADSL不适合企业，因为企业需要使用上行信道发送大量数据。为满足企业要求ADSL技术有几种变变型。如对称DSL即SDSL，还有一种使用一对线或两队线的DSL叫做HDSL，是用来取代T1线路的高速数字用户线。

---

光纤同轴混合网（HFC网）是在目前覆盖范围很广的有线电视网的基础上开发的一种居民宽带接入网，除可传送电视节目外还能提供电话、数据和其他宽带交换业务。最早的有线电视网是树形拓扑结构的同轴电缆网络，采用模拟技术的FDM对电视节目进行单向广播传输。现在的有线电视网进行了改造，变成了光纤同轴混合网（HFC网），HFC的主要特点如下。

为提高传输的可靠性和电视信号的质量，HFC网把元有线电视网中的同轴电缆主干部分换为光纤。光线从头端连接到光纤结点，在光纤结点光信号被转换为电信号，然后通过同轴电缆传送到用户家庭。

原来的有线电视网的最高传输速率450MHz且只用于电视信号的下行传输，现在的HFC具有双向传输功能，并且扩展了传输频带。

要使现有的模拟电视机能够接收数字电视信号，需要把一个叫做机顶盒的连接设备连接在同轴电缆和用户的电视机之间。为使用户能利用HFC网接入互联网，以及在上行信道中传送交互数字电视所需的一些信息，还需增加一个为HFC网使用的调制解调器，又称电缆调制解调器。电缆调制解调器不需要成对使用，只需要安装到用户端。

---

**FTTx技术**

光纤到户FTTH，即把光纤一直铺设到用户家庭，只有在光纤进入用户家门后，才把光信号转换为电信号，这样做可使用户获得最高上网速率。

两个问题：（1）价格昂贵（2）一般家庭无此高数据率的需求。

因此出现了多种宽带光纤接入方式，FTTx，x表示不同的光纤接入地点。实际上，FTTx就是把光电转换的地方，从用户家中（这时x为H）向外延伸到离用户家门口有一定距离的地方。

信号在陆地上的长距离传输基本都已实现光线话，ADSL和HFC中，用于远距离的传输媒体也早使用了光缆，在临近用户的地方才转为铜缆（用户的电话线和同轴电缆）。一个家庭元雍布拉一根光纤的通信容量，为有效利用光线资源，在光线干线和广大用户之间还需要铺设一段中间的转换装置即光配线网ODN，使得数十个家庭能共享一根光纤。无源的光配线网称为无源光网络PON，无源表示在光配线网中无须配备电源，因此基本不用维护。

光线路终端OLT是连接到光线干线的终端设备。OLT把收到的下行数据发往无源的1：N光分路器，然后用广播方式向所有用户端的光网络单元ONU发送。每个ONU根据特有的标识只接收发送给自己的数据，然后转换为电信号发往用户家中。

当ONU发送上行数据时，先把电信号转换为光信号，光分路器把各ONU发来的上行数据汇总后，以TDMA的方式发往OLT。

光配线网采用波分复用WDM，上行和下行分别使用不同的波长。

无源光网络PON主要有以下两种：

（1）吉比特无源光网络GPON，采用通用封装方法GEM，可承载多业务。

（2）以太网无源光网络EPON，在链路层使用以太网协议，利用PON的拓扑结构实现以太网的接入。优点：与现有以太网的兼容性好，成本低，扩展性强，方便管理。

现有很多种FTTx，除光纤到户FTTH外，还有光纤到路边FTTC（Curb），光纤到小区FTTZ（Zone），广信到大楼FTTB（Building），光纤到楼层FTTF（Floor），光纤到办公室FTTO（Office），光纤到桌面FTTD（Desk）等。

---

### 本章的重要概念

物理层的主要任务就是确定与传输媒体的接口有关的一些特性，如机械特性、电气特性、功能特性和过程特性。

一个数据通信系统可划分为三大部分，即源系统、传输系统和目的系统。源系统包括源点（或源站、信源）和发送器，目的系统包括接收器和终点（或目的站，信宿）。

通信的目的时传送消息，话音、文字、图像、视频等都是消息。数据是运送消息的实体，信号则是数据的电气或电磁的表现。

根据信号中代表消息的参数取值方式的不同，信号可分为模拟信号（连续信号）和数字信号（离散信号）。代表数字信号不同离散值的基本波形为码元。

根据双方信息交互的方式，通信可划分为单向通信（单工通信）、双向交替通信（半双工通信）和双向同时通信（全双工通信）。

来自信源的信号叫做基带信号。信号要在信道上传输就要经过调制，调制有基带调制和带通调制。最基本的带通调制方法有调幅、调频和调相。还有更复杂的调制方法，如正交振幅调制。

要提高数据在信道的传输速率，可使用更好的传输媒体，或使用先进的调制技术，但数据传输速率不可能被任意提高。

传输媒体可分为两大类，即导引型传输媒体（双绞线、同轴电缆或光纤）和非导引型传输媒体（无线或红外或大气激光）。

常用的信道复用技术有频分复用FDM、时分复用TDM、统计时分复用STDM、码分复用CDM和波分复用WDM（光的频分复用）。

最初在数字传输系统中使用的传输标准是脉冲编码调制PCM，现在高速的数字传输系统使用同步光纤网SONET（美国标准）或同步数字系列SDH（国际标准）。

用户到互联网的宽带接入方法有非对称数字用户线ADSL（用数字技术对现有的模拟电话用户线进行改造）、光纤同轴混合网HFC（在有线电视网的基础上开发的）和FTTx（即光纤到...）。

为有效利用光线资源，在光线干线和用户之间广泛使用无源光网络PON。无源光网络无需配备电源，其长期运营成本和管理成本都很低。最流行的无源光网络是以太网无源光网络EPON和吉比特无源光网络GPON。

---

## 数据链路层

数据链路层属于计算机网络的低层，该层使用的信道主要有以下两种：

（1）点对点信道。使用一对一的点对点通信方式。

（2）广播信道。使用一对多的广播信道通信方式，广播信道上连接了很多主机，因此必须使用专用的共享信道协议协调这些主机的数据发送。

网络层讨论分组如何从一个网络通过路由器转发到另一个网络，本章讨论分组怎样从一台主机传送到另一台主机，不经过路由器，从整个网络看，局域网属于数据链路层的范围。

本章最重要的内容是：

（1）数据链路层的点对点信道和广播信道的特点，以及这两种信道所用协议（PPP协议以及CSMA/CD协议）的特点。

（2）数据链路层的三个基本问题：封装成帧、透明传输和差错检测。

（3）以太网MAC层的硬件地址。

（4）适配器、转发器、集线器、网桥、以太网交换机的作用和使用场合。

---

### 使用点到点信道的数据链路层

链路和数据链路不是一回事，链路（link）是从一个结点到相邻结点的一段物理线路（有线或无线），而中间没有其他交换结点。进行数据通信时，两台计算机之间的通信路径往往要经过许多段链路，因此链路只是一条路径的组成部分。

数据链路（data link）是另一个概念。当需要在一条线路上传送数据时，除必须有一条物理线路外，还必须有一些必要的通信协议来控制这些数据的传输。若把实现这些协议的硬件和软件加到链路上，就构成了数据链路。最常用的方法是使用网络适配器（既包括硬件也包括软件）来实现这些协议。一般的适配器都包括数据链路层和物理层这两层的功能。

也有另外的术语，即把链路分为物理链路（上述链路）和逻辑链路（上述数据链路，是物理链路加上必要的通信协议）。

早期数据通信协议叫通信规程（procedure），因此在数据链路层，规程和协议是同义语。

数据链路层的协议数据单元PDU是帧。数据链路层把网络层交下来的数据构成帧发送到链路上，以及把接收到的帧中的数据提出并上交给网络层。互联网中，网络层的协议数据单元就是IP数据报（或简称数据报、包、分组）。

点到点信道的数据链路层在通信时的主要步骤：

（1）结点A的数据链路层把网络层交下来的IP数据报添加首部和尾部封装成帧

（2）结点A把封装好的帧发送给结点B的数据链路层

（3）若结点B的数据链路层收到的帧无差错，则提取出IP数据报上交网络层，否则丢弃这个帧。

---

数据链路层协议有许多种，但有三个基本的共同问题：封装成帧、透明传输和差错控制。

（1）封装成帧

封装成帧（framing）就是在一段数据的前后分别添加首部和尾部，这样就构成了一个帧，接收端在收到物理层上交的比特流后，就能根据首部和尾部的标记，从收到的比特流中识别帧的开始和结束。

一个帧的帧长等于数据长度部分（IP数据报构成）加上帧首部和帧尾部的长度。首部和尾部的一个重要作用就是帧定界（即确定帧的界限）。此外首部和尾部还包括许多控制信息，在发送帧时，是从帧首部开始发送的。为提高帧传输效率，应使帧的数据部分长度仅可能大于首部和尾部，但每一种链路层协议都规定了所能传送的帧的数据部分长度上限——最大传输单元MTU（Maximum Transfer Unit）。

当数据由可打印的ASCII码组成的文本文件时，帧定界可以使用特殊的帧定界符。控制字符SOH（Start Of Header）放在帧的最前面，表示帧的首部开始，另一个控制字符EOT（End Of Transmission）表示帧的结束。SOH和EOT都是控制字符的名字，它们的16进制编码分别是01和04。

当数据在传输中出现差错时，帧定界的作用更加明显。假定发送端在尚未发送完一个帧时发生故障，中断了发送之后恢复正常，从头开始发送刚才未发完的帧，由于使用了帧定界符，接收端就知道前面收到的数据是不完整的帧（只有SOH而没有EOT），必须丢弃。

（2）透明传输

当传送帧是用文本文件组成的帧时，其数据部分不会出现SOH或EOT这样的帧界定控制符。因此不管从键盘上输入什么字符都可以放在这样的帧中传输过去，这样的传输就是透明传输。

但当数据部分时非ASCII码的文本文件时，情况就不同了。如果数据中某个字节的二进制代码恰好和SOH或EOT一样，数据链路层会错误地找到帧的边界收下部分帧而把剩下的数据丢弃。

透明是一个重要术语，它表示：某一个实际存在的事物看起来却好像不存在一样。在数据链路层透明传送数据，表示无论什么样的比特组合的数据，都能按原样没有差错地通过数据链路层。因此对传送数据来说，这些数据就“看不见”数据链路层有什么妨碍数据传输的东西。

为解决透明传输，必须设法使数据中可能出现的控制字符SOH和EOT在接收端不被解释为控制字符。具体的方法是：发送端的数据链路层在数据中的SOH或EOT之前插入一个转义字符ESC（其16进制编码为1B），而在接收端的数据链路层在把数据送往网络层之前删除这个ESC。这种方法称为字节填充或字符填充。如果转义字符也出现在数据，那就在ESC前再加一个ESC。

（3）差错控制

比特在传输过程中可能产生差错：1可能变成0，0可能变成1，这就叫比特差错。比特差错是传输差错的一种。在一段时间内，传输错误的比特占所传输比特总数的比率就叫误码率BER（Error Bit Rate）。误码率和信噪比有关，如果设法提高信噪比，误码率就会减小。为保证数据传输可靠性，必须采用各种差错检测措施，目前在数据链路层广泛使用了循环冗余检测CRC的检错技术。

在发送端，先把数据划分为组，假定每组k个比特。假定待传送数据M=101001（k=6），CRC运算就是在M的后面添加n位供差错检测用的冗余码，然后构成一个（k+n）位的帧发送出去。

n位冗余码用以下方法得出。用二进制的模2运算进行2n乘M，相当于在M后面添加n个0，得到的（k+n）位数除以事先约定的长度为（n+1）的除数P得到商Q和余数R（n位，比除数少一位）。例M=101001，P=1101即n=3，经模2除法得出的结果是商Q=110101（商无用），R=001。这个余数R就作为冗余码拼接在M的后面发送出去，这种为了检错而添加的冗余码称为帧检测码FCS，因此加上FCS后发送的帧是101001001（即2nM+FCS）。

接收端把接收到的数据以帧为单位进行CRC校验：把收到的每一个帧都出以同样的除数P（模2运算），然后检查余数R。如果传输无差错，那么R=0。若R=0，判定帧没有差错，接收，如果R不等于0，则判断帧有差错并舍弃。

一种较简便的方法是用多项式来表示循环冗余检验过程。例如用P(X)=X3+X2+1表示1101。多项式P(X)称为生成多项式。

在数据链路层，发送端帧检验序列FCS和接收端CRC检验都是用硬件完成的，处理迅速，不会延误数据的传输。从上述讨论可知如果不以帧为单位传送数据就无法加入冗余码来进行差错检验，因此要在数据链路层进行差错检验就必须把数据划分位帧，每一帧都加上冗余码，一帧一帧地发送然后在接收端逐帧进行差错检验。

若仅使用CRC，则只能做到对帧的无差错接受，即凡是接收端数据链路层接受的帧，我们都能以非常接近1的概率认为这些帧在传输中没有出现差错。出现差错的帧虽然曾接收到了但最终会被丢弃。

差错传输分类两大类：一类是前述最基本的比特差错，而另一类传输差错更复杂，就是收到的帧没有比特差错，但出现了帧丢失、帧重复或帧失序。

过去OSI的观点是：必须让数据链路层向上提供可靠传输，因此在CRC的基础上增加了帧编号、确认和重传机制。收到正确的帧就要向发送端发送确认，发送端未在时限内收到对方确认就会进行重传直到收到对方确认位置。但现在的通信线路质量已大大提高，互联网以采用了区别对待的方法。

对通信质量良好的有线传输链路，数据链路层协议不使用确认和重传机制，即不要求向上提供可靠的传输服务。如果在数据链路层传输数据时出现差错并需要更正，那么改正差错的任务交给上层协议（如运输层的TCP）来完成。

对通信质量较差的无线传输链路，数据链路层协议使用确认和重传机制，向上提供可靠的服务。实践证明，这样做可以提高通信效率。

---

### 点对点协议PPP

通信线路质量较差的年代，多使用可实现可靠传输的高级数据链路控制HDLC，现在HDLC已很少使用了，对于点对点的链路，简单得多的点对点协议PPP是目前使用的最广泛的数据链路层协议。

互联网用户通常需要连接到某个ISP才能接入互联网，PPP协议就是用户计算机和ISP进行通信时所使用的数据链路层协议。

PPP协议应满足的需求：

（1）简单

IETF设计互联网体系结构时将最复杂的部分放在TCP协议中，而网际协议IP则相对简单，提供不可靠的数据包服务。因此数据链路层没必要提供比IP协议更多的功能，对数据链路层的帧，不需要纠错，不需要序号，也不需要流量控制。IETF把简单作为首要需求。

简单的设计可使协议在实现时不易出错，从而使不同厂商在协议的不同实现上的互操作性提高了。数据链路层的协议非常简单：接收方每接收到一个帧，就进行CRC检验，如果正确就接收，否则丢弃，其他什么也不做。

（2）封装成帧

PPP协议必须规定特殊字符作为帧定界符（即标志一个帧开始和结束的字符），以便接收端从收到的比特流中能准确找出帧的开始和结束位置。

（3）透明性

PPP协议必须保证数据传输的透明性，这就是说如果数据中碰巧出现了和帧定界符一样的比特组合时，就要采取有效的措施解决。

（4）多种网络层协议

PPP协议必须能够在同一条物理链路上同时支持多种网络层协议的运行。当点对点链路所连接的是局域网或路由器时，PPP协议必须同时支持在链路所连接的局域网或路由器上运行的各种网络层协议。

（5）多种类型链路

除要支持多种网络层协议外，PPP还必须能够在多种类型的链路上运行。例如，串行的或并行的，同步的或异步的，低速的或高速的，电的或光的，交换的（动态的）或非交换的（静态的）点对点链路。

在以太网上运行的PPP，即PPPoE，这是PPP协议能适应多种类型链路的一个典型例子。PPPoE是为宽带上网的主机使用的链路层协议，宽带上网时由于传输速率较高，因此可让多个连接在以太网上的用户共享一条到ISP的宽带链路，即使只有一个用户利用ADSL进行宽带上网（不和其他人分享到ISP的宽带链路），也是使用PPPoE协议。

（6）差错检测

PPP协议必须能够对接收端收到的帧进行检测，并立即丢弃有差错的帧。

（7）检测连接状态

PPP协议必须具有一种机制能够及时（不超过几分钟）自动检测出链路是否处于正常工作状态。

（8）最大传送单元

PPP协议必须对每一种类型的点对点链路设置最大传送单元MTU的标准默认值（1500B），这样做是为了促进各种实现之间的互操作性。MTU是数据链路层的帧可以载荷的数据部分的最大长度，不是帧的总长度。

（9）网络层地址协商

PPP协议必须提供一种机制使通信的两个网络层的实体能通过协商知道或能配置彼此的网络层地址。协商算法应尽可能简单，并满足所有情况。对拨号连接的链路尤为重要。

（10）数据压缩协商

PPP协议必须提供一种方法来协商数据压缩算法，但并不要求该算法标准化。

在TCP/IP协议族中，可靠传输由运输层的TCP协议复杂，因此数据链路层的PPP协议不需要进行纠错，不需要设置序号，也不需要进行流量控制。PPP协议不支持多点线路（即一个主站轮流和链路上的多个从站通信），只支持点对点的链路通信，此外PPP只支持全双工链路。

PPP协议的组成：

（1）一个将IP数据报封装到串行链路的方法。PPP既支持异步链路（无奇偶检验的8比特数据），也支持面向比特的同步链路。

（2）一个用来建立、配置和测试数据链路连接的链路控制协议LCP。

（3）一套网络控制协议NCP，其中每个协议支持不同的网络层协议。

---

**PPP协议的帧格式**

首部（FAC协议）+信息部分+尾部（FCSF）

（1）各字段的意义

PPP帧的首部和尾部分别为四个字段和两个字段。首部的第一个字段和尾部的第二个字段都是标志字段F，规定为0x7E，标志字段表示一个帧的开始或结束。因此标志字段就是PPP帧的定界符，连续两帧之间只需要一个标志字段。如果出现连着两个标志字段，就表示一个应当丢弃的空帧。

首部中的四个字段为标志字段F，地址字段A和控制自字段C，2B的协议字段。信息字段的长度可变，不超过1500B。尾部的第一个字段（2B）是使用CRC的帧检验序列FCS，第二个字段是标志字段F。

F、A、C均为1B，协议和FCS为2B，信息部分不超过1500B。

（2）字节填充

当PPP使用异步传输时，它把转义字符定义为0x7D，并使用字节填充。

由于在发送端进行了字节填充，因此在链路上传送的信息字节就超过了原来的信息字节数，但接收端在收到数据后再进行与发送端字节填充的相反变换，就可正确恢复出原有信息。

（3）零比特填充

PPP协议在使用SONET/SDH链路时，使用同步传输（一连串的比特连续发送）而不是异步传输（逐个字符传送）。在这种情况下，PPP采用零比特填充法来实现透明传输。

具体做法：发现有5个连续的1，则填入一个0，保证信息字段不会出现连续6个1。接收端在收到一个帧时，先找到标志字段F确定一个帧的边界，再用硬件对比特流扫描，当发现5个连续的1时就删除后面的0。

---

**PPP协议的工作状态**

当用户拨号接入ISP后，就建立了一条从用户个人电脑到ISP的物理连接，这时用户电脑向ISP发送一系列链路控制协议LCP分组。这些分组及其响应选择了一些需要的PPP参数，接着还要进行网络配置，网络控制协议NCP给新接入的用户分配一个临时IP地址，通信完毕后，NCP释放网络层连接收回IP地址，接着LCP释放数据链路层连接，最后释放物理层连接。

PPP链路的起始和终止状态永远都是链路静止状态，此时用户个人电脑和ISP的路由器之间不存在物理层连接。当用户电脑通过调制解调器呼叫路由器时，路由器能检测到调制解调器发出的载波信号，双方建立了物理层连接后，PPP就进入了链路建立状态，目的是为了建立链路层的LCP连接。

这时LCP开始协商配置选项，即发送LCP的配置请求帧，链路的另一端可发送以下几种响应的一种：

（1）配置确认帧 所有选项都接受

（2）配置否认帧 所有选项都理解但不接受

（3）配置拒绝帧 选项有的无法识别或不能接受，需要协商。

协商结束后双方建立LCP链路，进入鉴别状态。该状态下只允许传送LCP协议的分组、鉴别协议的分组和监测链路质量的分组。若使用口令鉴别协议PAP，则需要发起通信的一方发送身份标识符和口令。还可以使用更复杂的口令握手鉴别协议CHAP。若鉴别失败则转到链路终止状态，若鉴别成功，则进入网络层协议状态。

在网络层协议状态，PPP链路两端的网络控制协议NCP根据网络层的不同协议互相交互网络层特定的网络控制分组。当网络层配置完成后，链路就可进入链路打开状态，链路的两个PPP端点可以彼此向对方发送分组。两个PPP端点还可发送回送请求LCP分组和回送回答LCP分组以检查链路的状态。

数据传输结束后可由链路一端发出终止请求LCP分组请求终止链路连接，在收到对方发来的终止确认LCP分组后，转到链路终止状态。若链路出现故障，也会从链路打开转到链路终止状态。当调制解调器的载波停止后，回到链路静止状态。

从设备之间无链路开始，先建立物理链路，再建立链路控制协议LCP链路。经过鉴别后再建立网络控制协议NCP链路然后才能交换数据。由此可见PPP协议不是纯粹的数据链路层协议，还包含了物理层和网络层的内容。

---

### 使用广播信道的数据链路层

广播信道可以进行一对多的通信，局域网使用的就是广播信道。

局域网最主要的特点：网络为一个单位所有，且地理范围和站点数目有限。

局域网的主要优点：

（1）具有广播功能，从一个站点可以很方便地访问全网。

（2）便于系统的扩展和逐渐演变，各设备的位置可灵活调整。

（3）提高了系统的可靠性、可用性和生存性。

局域网可按网络拓扑分类：

（1）星形网。由于集线器的出现和双绞线大量用于局域网中，星形以太网以及多级星形结构的以太网获得了广泛应用。（2）环形网。（3）总线网，各站直接连在总线上。以传统以太网最为著名。

局域网可使用多种传输媒体，双绞线是主流，当数据率很高时需要使用光纤。

局域网工作的层次跨越了数据链路层和物理层，不仅与数据链路层有关。

共享信道解决众多用户合理方便共享通信媒体资源的两种方法：

（1）静态划分信道，如2.4节中的频分复用FDM、时分复用TDM、波分复用WDM和码分复用CDM等。用户只要分配了信道就不会和其他人冲突，但代价高不适合局域网。

（2）动态媒体介入控制，又称多点接入，特点是信道并非在用户通信时固定分配给用户，又分为两类：①随机接入，特点是所有用户可随机发送信息。如果恰好由两个或以上用户在同一时刻发送信息，在共享媒体上会发生碰撞（冲突）。②受控接入，特点是用户不能随机发送而必须服从控制。代表由分散控制的令牌环局域网和集中控制的多点线路探寻，或称为轮询。

---

**以太网的两个标准**

以太网用无源电缆作为总线传输数据帧，并以曾在历史上表示传播电磁波的以太命名。

DEC公司、英特尔公司和施乐公司礼盒提出了10 Mbit/s以太网规约的第一个版本DIX V1，1982年修改为第二版规约DIX Ethernet V2。

在此基础上，IEEE 802委员会（专门制定局域网和城域网标准的机构）于1983年制定了第一个IEEE的以太网标准IEEE 802.3，数据率约为10Mbit/s。由于DIX Ethernet V2和IEEE的802.3标准很小，因此很多人把802.3局域网称为以太网。

IEEE 802委员会未能形成统一的局域网标准，而是被迫制定了几个不同的局域网标准，如802.4令牌总线网、802.5令牌环网等。为使数据链路层更好适应多种局域网标准，IEEE 802委员会把局域网的数据链路层拆分为两个子层，逻辑链路控制LLC子层和媒体接入控制MAC子层。于介入到传输媒体有关的内容放在MAC子层，而LLC子层与传输媒体无关，不管采用何种传输媒体和MAC子层的局域网对LLC子层来说都是透明的。

随着互联网的发展，局域网只剩下DIX Ethernet V2而不是IEEE 802.3标准中的局域网，因此LLC的作用已经消失了，很多厂商的适配器仅有MAC协议而没有LLC协议。

---

**适配器的作用**

计算机与外界局域网的连接是通过通信适配器进行的。适配器是一块网络接口板，又称网络接口卡NIC简称网卡。适配器和局域网之间的通信是通过电缆或双绞线以串行传输方式进行的，而适配器和计算机之间的通信则是通过计算机主板上的I/O总线以并行传输方式进行的。因此适配器的一个重要功能即进行数据串行传输和并行传输的转换。由于网络和计算机总线上的数据率不同，还需要在适配器中装有对数据进行缓存的存储芯片。在主板插入适配器时，还必须安装管理该适配器的设备驱动程序至计算机的操作系统，该程序将告之计算机应当从存储器的什么位置把多长的数据块发送到局域网，或者在存储器的什么位置把局域网传来的数据块存储下来。适配器还要能够实现以太网协议。

适配器的功能包含了数据链路层和物理层两个层次的功能。

适配器在接受和发送帧时，不使用计算机的CPU。当适配器收到有差错的帧时，直接丢弃而不必通知计算机，当收到正确帧时，使用中断通知计算机，并交付协议栈中的网络层。当计算机要发送IP数据报时，由协议栈把IP数据报向下交给适配器，组装成帧后发到局域网。计算机的硬件地址就在适配器的ROM中，而计算机的软件地址（IP地址）则在计算机的存储器中。

---

**CSMA/CD协议**

最早的以太网是将许多计算机连接到一根总线上。总线的特点是：使用广播通信方式，当一台计算机发送数据时，总线上的所有计算机都能检测到这个数据。为了在总线上实现一对一的通信，可以使每一台计算机的适配器拥有一个与其他适配器都不同的地址，仅当数据帧的目的地址和适配器ROM中的硬件地址一样时，适配器才能接收这个数据帧。

为了通信的简便，以太网采用了以下两种措施：

（1）采用较为灵活的无连接工作方式，即不必先建立连接就可直接发送数据。适配器对发送的数据帧不进行编号，也不要求对方发回确认。因此以太网提供的服务是尽最大努力的交付，即不可靠的交付。对有差错帧是否需要重传由高层决定。例如TCP发现丢失数据后就把数据重新传递给以太网重传，但以太网并不知道这是重传帧，而是当作新数据帧。

总线上只要有一台计算机在发送数据，总线的传输资源就被占用，因此同一时间只允许一台计算机发送数据，否则会计算机之间会互相干扰。以太网采用的协调方法是使用CSMA/CD协议，意思是载波监听多点接入/碰撞检测。

（2）以太网发送的数据都使用曼彻斯特编码的信号。二进制基带数字信号的问题是出现一长串的连0或连1时接收端就无法从收到的比特流中提取同步位。曼彻斯特编码保证了每个码元的正中间出现一次电压转换，而接收端就利用这种转换方便地提取同步信号。缺点是所占的频带宽度增加了一倍。

CSMA/CD协议的要点：

（1）多点接入 说明这是总线型网络，许多计算机以多点接入的方式连接在总线上。协议的实质是载波监听和碰撞检测。
（2）载波监听 用电子技术检测总线上有没有其他计算机也在发送，不管发送前还是发送中，每个站都必须不停地检测信道。

（3）碰撞检测 边发送边监听，即适配器边发送数据边检测信道上的信号电压的变化情况，以判断自己在发送数据时其他站是否也在发送数据，也称冲突检测。

电磁波在1km电缆的传播时延约为5μs。在局域网中，常把总线上的单程端到端传播时延记为τ，站发送数据后最迟要经过两倍的总线端到端传播时延（2τ）或总线的端到端往返传播时延才能知道自己发送的数据和其他站的数据有没有发送碰撞。由于局域网上任意两站间传播时延有长有短，因此局域网必须按照最坏情况设计，即取总线两端的两个站之间的传播时延（这两个站之间距离最大）为端到端传播时延。

显然在使用CSMA/CD协议时一个站不可能同时进行发送和接受（必须边发送边监听信道），因此使用CSNA/CD协议的以太网不可能进行全双工通信而只能进行双向交替通信（半双工通信）。

每个站在自己发送数据之后的一小段时间内，存在着遭遇碰撞的可能性，这一小段时间是不确定的，它取决于另一个发送数据的站到本站的距离。因此以太网不能保证某一时间之内一定能把自己的数据帧成功地发送出去，这一特点称为发送的不确定性。

以太网的端到端往返时间称为争用期，又称为碰撞窗口，因为一个站在发送完数据后，只有通过争用期的“考验”，即经过争用期这段时间还没有检测到碰撞，才能肯定这次发送不会发生碰撞。

以太网使用截断二进制指数退避算法来确定碰撞后重传的时机，这种算法让发生碰撞的站在停止发送数据后，不是等待信道空闲后就立即发送数据，而是推迟（退避）一个随机时间。协议规定了基本退避时间为争用期2τ，具体的争用期时间是51.2μs。对于10Mbit/s以太网，在争用期可发送512bit，即64B，也可以说争用期是512比特时间。

从离散的整数集合[0，1，...，2k-1]中随机取出一个数记为r，重传应退后的时间就是r倍的争用期。重传次数不超过10，k=重传次数，当超过10次时，k=10。当重传达16次仍未成功时，丢弃该帧，并向高层报告。

以太网规定了一个最短帧长64B，即521bit，如果要发送的数据非常少，必须加入一些填充字节。

以太网在发送数据时，如果在争用期（发送64B）没有发生碰撞，那么后续发送的数据就一定不会冲突。如果发生碰撞，一定是在发送之前的64B内，因此凡是长度小于64B的帧都是由于冲突而异常终止的无效帧，收到后应当立即丢弃。

强化碰撞，当发送数据的一战发现发生了碰撞时，除了立即停止发送数据外，还要再继续发送32bit或48bit的人为干扰信号，以便所有用户都知道现在已发生了碰撞。

以太网还规定了帧间最小间隔为9.6μs，相当于96比特时间，这样做是为了使刚收到数据帧的站的接收缓存来得及清理，做好接收下一帧的准备。

**CSMA/CD协议的要点：**

（1）准备发送：适配器从网络层获得一个分组，加上以太网的首部和尾部，组成以太网帧，放入适配器的缓存中。但在发送前必须先检测信道。

（2）检测信道：若检测信道忙，应不停地检测，直到信道转为空闲。若检测信道空闲，并在96比特时间内信道保持空闲（保持了帧间最小间隔），就发送这个帧。

（3）在发送过程中仍不停地检测信道，即网络适配器要边发送边监听。这里只有两种可能性：①发送成功：在争用期未检测到碰撞，发送成功后什么也不做返回（1）。②发送失败：在争用期内检测到碰撞，立即停止发送数据，按规定发送人为干扰信号。适配器执行指数退避算法，等待r倍512比特时间后回到步骤（2）。若重传16次仍不能成功，停止重传上报错误。

以太网每发送一帧，一定要把已发送的帧暂时保留一下，如果在争用期内检测到碰撞，那么还要推迟一段时间后再把这个暂时保留的帧重传一次。

---

传统以太网最初使用同轴电缆，最后发展为使用双绞线。这种以太网采用星形拓扑，在星形中心增加了可靠性很高的设备，叫集线器。双绞线以太网总是和集线器配合使用，由于集线器使用了大规模集成电路芯片，因此可靠性大大提高。1990年IEEE制定出星形以太网10BASE-T的标准802.3i。10代表10Mbit/s的数据率，BASE表示连接线上的信号是基带信号，T表示双绞线。10BASE-T以太网通信距离稍短，每个站到集线器的距离不超过100m。

使双绞线能够传输高速数据的主要措施是把双绞线的绞合度做的非常精确，可使特性阻抗均匀以减少失真，而且大幅度减少了电磁波辐射和无线电频率干扰。

**集线器的特点如下：**

（1）使用集线器的以太网在逻辑上仍是一个总线网，各站共享逻辑上的总线，使用的还是CSMA/CD协议（各站中的适配器执行CSMA/CD协议）。网络中的各站必须竞争对传输媒体的控制，并在同一时刻至多只允许一个站发送数据。

（2）一个集线器有许多接口（硬件端口），每个接口通过RJ-45插头用两对双绞线与一台计算机上的适配器相连。因此一个集线器很像一个多接口的转发器。

（3）集线器工作在物理层，它的每个接口仅仅简单地转发比特，收到1就转发1，收到0就转发0，不进行碰撞检测。若发生碰撞那么所有接口都收不到正确的帧。

（4）采用专门芯片进行自适应串音回波抵消，可使发出地较强信号不致对接收到的较弱信号产生干扰。

集线器本身非常可靠，堆叠式集线器由4-8个集线器堆叠起来使用。集线器一般都有少量的容错能力和网络管理功能。IEEE802.3还可使用光纤作为传输媒体，相应标准是10BASE-F系列，F代表光纤。它主要作用于集线器之间的远程连接。

以太网定义了参数a，它是以太网单程端到端时延τ与帧的发送时间T0之比，以太网的参数a值应尽可能小些，当数据率一定时，以太网的连线长度受到限制（否则τ太大），同时以太网的帧长不能太短（否则T0的值太小）。

极限信道利用率Smax=1/（1+a），当a远小于1时才能得到尽可能高的极限信道利用率。

---

**以太网的MAC层**

MAC层的硬件地址

局域网中，硬件地址又称为物理地址或MAC地址（因为这种地址用在MAC帧中）。IEE802标准为局域网规定了一种48位的全球地址，是局域网上的每一台计算机中固化在适配器的ROM中的地址。因此，

（1）更换了新的适配器后即使计算机的物理位置和接入的局域网没有任何改变，但这台计算机的局域网的地址改变了。

（2）即使改变了计算机的物理位置和接入的局域网，只要适配器不变，那么计算机在局域网中的地址就不变。

严格地讲，局域网的地址应当是每一个站的名字或标识符。如果连接在局域网上的主机或路由器有多个适配器，那么它就有多个地址。更准确地说，这种48位地址应当是某个接口的标识符。

MAC地址也叫硬件地址或物理地址，MAC地址实际上就是适配器地址或适配器标识符EUI-48。当这块适配器插入或嵌入某台计算机后，适配器的标识符EUI-48就成为这台计算机的MAC地址了。

IEEE规定地址字段的第一个字节位的最低位为I/G位，当其为0时，地址字段表示一个单个站地址，为1时表示组地址，用来进行多播。因此IEEE只分配地址段的前三个字节中的23位。IEEE把地址字段第一个字节的最低第二位规定为G/L位，0表示全球管理，1表示本地管理。

当路由器通过适配器连接到局域网时，适配器上的硬件地址就用来标志路由器的某个接口。路由器如果同时连接两个网络，那么它就需要两个适配器和两个硬件地址。

适配器有过滤功能。当适配器从网络收到每个MAC帧就先用硬件检测其目的地址，若是发往本站的帧则收下否则丢弃。发往本站的帧包括以下三种：

（1）单播帧（一对一） 即收到的帧与本站硬件地址相同

（2）广播帧（一对全体） 即发送给本局域网上所有站点的帧

（3）多播帧（一对多） 即发送给本局域网上一部分站点的帧

所有的适配器都应至少能识别前两种帧，即单播和广播地址。

以太网适配器还可设置为一种特殊的工作方式，即混杂方式。该工作方式是黑客常利用来非法获取网上用户口令的方法，适配器只要“听到”有帧在以太网传输就悄悄接收下来而不管这些帧是发往哪个站。但混杂方式有时非常有用，例如网络维护人员用以监视和分析以太网的流量。有一种叫做嗅探器的网络工具就使用了设置为混杂方式的网络适配器。

---

**MAC帧的格式**

常用的以太网MAC帧格式有两种标准，一种是以太网V2标准，一种是IEEE的802.3标准。这里讨论用的最多的以太网V2的MAC帧格式。

以太网V2的MAC帧较为简单，由五个字段组成。前两个字段分别为6B长的目的地址和源地址字段。第三个字段是2B的类型字段，用来标志上一层使用的是什么协议。第四个字段是数据字段，长度在45-1500B之间，46B是由最小长度64B减去18B的首部和尾部得出的数据字段的最小长度。最后一个字段是4B的帧检验序列FCS（使用CRC检验）。

MAC子层通过曼彻斯特编码的特点确定MAC帧中数据字段的结束位置。

为了接收端迅速实现位同步，从MAC子层向下传到物理层时还要在帧的前面插入8字节（由硬件生成），它由两个字段构成。第一个字段时7个字节的前同步码（1和0交替码），它的作用是使接收端的适配器在接收MAC帧时能够迅速调制其时钟频率，使它和发送端的时钟同步。第二个字段是帧开始定界符，定义为10101011，它的前6位和前同步码一样，最后的连续两个1就是告诉接收端适配器MAC帧的信息马上要来了请注意接收。MAC帧的FCS字段检验范围不包括前同步码和帧开始定界符，在使用SONET/SDH进行同步传输时不需要使用前同步码，因为同步传输时收发双方的位同步总是一直保持的。

IEEE802.3标准规定下列情况之一的即为无效MAC帧：

（1）帧长度不是整数个字节

（2）用收到的帧检验序列FCS查出差错

（3）收到的帧MAC客户数据字段长度不在46-1500B之间。考虑到帧的首部和尾部长度共18B，可得出有效的MAC帧长度在64-1518B之间。

对于检测出的无效MAC帧就简单丢弃，以太网不负责重传丢弃的帧。

IEEE802.3规定的MAC帧格式与上述以太网V2MAC帧格式的区别：

（1）IEEE802.3规定的MAC帧第三个字段是“长度/类型”，当这个字段值大于0x0600时就表示类型，和以太网V2的MAC帧完全一样，小于时才表示长度。

（2）当“长度/类型”字段值小于0x6000时，数据字段必须装入上面的逻辑链路控制子层的LLC帧。由于现在广泛使用的局域网只有以太网，因此LLC帧已失去意义。现在市场上流行的都是以太网V2标准的MAC帧，但也称为IEEE802.3标准的MAC帧。

---

### 扩展的以太网

扩展的以太网在网络层看来依然是一个网络。

在物理层扩展以太网：

以太网中主机距离不能太远，否则主机发出的信号经过铜线传输会衰减到CSMA/CD协议不能正常工作。

扩展主机和集线器之间距离的简单方法是使用光纤（一对）和一对光纤调制解调器。由于光纤的时延很小而且带宽很宽，该方法可以很容易地使主机和几公里以外的集线器相连接。若使用多个集线器就可连接覆盖成更大范围的多级星形结构的以太网。

优点：更大范围的通信，扩大以太网的覆盖范围。

缺点：独立的碰撞域（冲突域）再连接后会成为一个冲突域，如果使用不同的以太网技术（如数据率不同），那么就不能用集线器互连。

---

在数据链路层扩展以太网：

最初使用网桥，网桥对收到的帧根据其MAC帧的目的地址进行转发和过滤。

1990年出现交换式集线器淘汰了网桥，又称以太网交换机或第二层交换机，强调其工作在数据链路层。

以太网交换机的特点：

实质是一个多接口的网桥，工作方式为全双工方式。以太网交换机具有并行性，能同时连接多对接口，使多对主机同时通信，相互通信的主机都是独占传输媒体，无碰撞地传输数据。

以太网交换机地接口有存储器，可缓存接收地帧。以太网交换机是一种即插即用设备，内部的帧交换表（地址表）是通过自学习算法自动逐渐建立的。

除了存储转发的方式，有的以太网交换机采用直通的交换方式对收到的帧转发。缺点是可能转发无效帧。

以太网交换机的自学习功能使以太网能够即插即用，不必人工配置。

生成树协议STD不改变网络的实际拓扑，但在逻辑上切断了某些链路，使得一个主机到其他所有主机的路径是无环路的树状结构，消除了无限制的兜圈子问题。

从总线以太网到星形以太网，以太网交换机不使用共享总线没有碰撞问题，不适用CSMA/CD协议，而以全双工方式工作。但因它的帧结构未改变，仍然采用以太网的帧结构，因此还叫作以太网。

---

利用以太网交换机可以方便实现虚拟局域网VLAN。

VLAN是由一些局域网网段构成的与地理位置无关的逻辑组，而这些网段居于某些共同的需求。虚拟局域网实际只是局域网给用户提供的一种服务，而不是新型局域网。

虚拟局域网限制了接收广播信息的计算机数，使得网络不会因为传播过多的广播信息（即广播风暴）引起性能恶化。

虚拟局域网协议在以太网帧格式中插入了一个4字节的标识符，称为VLAN标记，用来指明发送该帧的计算机属于哪个虚拟局域网。插入VLAN标记的帧称为802.1Q帧。

VLAN标记长度为4B，在以太网MAC帧的源地址字段之后，类型字段之前。前2个字节固定，称为标记类型。后两个字节中，前3位是用户优先级，第4位是规范格式指示符CFI，最后12位是VLAN标识符VID，唯一标志了帧的所属VLAN。

由于VLAN的以太网帧首部增加了4个字节所以以太网的最大帧长从1518B变为1522B。

---

### 高速以太网

100BASE-T以太网

在双绞线上传送100Mbit/s基带信号的星形拓扑以太网，仍使用CSMA/CD协议，又称快速以太网。

10/100Mbit/s以太网都使用无屏蔽双绞线布线。

吉比特以太网

特点：

（1）允许在1Gbit/s下以全双工和半双工两种方式工作

（2）使用IEEE802.2协议规定的帧格式

（3）半双工方式下使用CSMA/CD协议，全双工方式下不使用

（4）与10BASE-T和100BASE-T技术向后兼容

吉比特以太网物理层使用两种成熟的技术：一种来自现有以太网，一种来自ANSI制定的光纤通道FC。

---

10吉比特以太网（10GE）和更快的以太网

10GE的以太网帧格式和上述以太网相同，并保留802.3标准规定的以太网最小帧长和最大帧长。只工作在全双工方式，不存在争用问题，因此不使用CSMA/CD协议。

以太网的工作范围已从局域网扩大到城域网和广域网，从而实现了端到端的传输，这种工作方式的好处是：

（1）以太网是一种经过实践证明的成熟技术。

（2）以太网的互操作性很好。

（3）在广域网中使用以太网时，价格低于同步光纤网SONET和异步传递方式ATM。还能适应多种传输媒体，不必重新布线。

（4）端到端的以太网连接使帧的格式全都是以太网的格式，不需要再进行帧的格式转换，简化操作管理。但以太网和其他网络仍需要相应接口才能互连。

---

使用以太网进行宽带接入

以太网接入的一个重要特点是它可以提供双向的宽带通信，并可以根据用户对带宽的需求灵活地升级带宽。

---

### 本章的重要概念

链路是从一个结点到另一个相邻结点的一段物理线路，数据链路则是在链路的基础上增加了一些必要的操作。

数据链路层使用的信道主要有点对点信道和广播信道两种。

数据链路层传送的协议数据单元是帧，三个基本问题是：封装成帧，透明传输和差错检验。

循环冗余CRC是一种检错方法，而帧检验序列FCS是添加在数据后面的冗余码。

点对点协议PPP是数据链路层使用最多的一种协议，它的特点是：简单，只检测差错而不纠正；不使用序号也不使用流量控制；可同时支持多种网络层协议。

PPPoE是为宽带上网的主机使用的链路层协议。

局域网的优点：具有广播功能，从一个站点可很方便的访问全网；便于系统的扩展和逐渐演变；提高了系统的可靠性、可用性和生存性。

共享通信媒体资源的方法有二：一是静态划分信道（各种复用技术），而是动态媒体接入控制，又称为多点接入（随机接入或受控接入）。

IEEE802委员会曾把局域网的数据链路层拆成两个子层，逻辑链路子层（LLC）子层（和传输媒体无关）和媒体接入控制子层（MAC）子层（与传输媒体有关），现在LLC子层已淘汰。

计算机与外界局域网的通信要通过通信适配器（网络适配器），又称为网络接口卡或网卡，计算机的硬件地址就在适配器的ROM中。

以太网采用无连接的工作方式，对发送的数据帧不进行编号，也不要求对方发回确认。目的站收到有差错帧就丢弃，其他什么也不做。

以太网采用的协议是具有冲突检测的载波监听多点接入CSMA/CD。协议的要点是：发送前先监听，边发送边监听，一旦发现总线上出了故障，就立即停止发送。然后按照退避算法等待一段随机时间后再次发送。因此每一个站在自己发送数据之后的一小段时间内，存在着遭遇碰撞的可能性。以太网各站点都平等地争用以太网信道。

传统的总线以太网基本都是使用集线器的双绞线以太网，这种以太网在物理上是星形网，逻辑上则是总线网。集线器工作在物理层，它的每个接口仅仅简单地转发比特，不进行碰撞检测。

以太网地硬件地址，即MAC地址实际上就是适配器地址或适配器标识符，与主机所在地地点无关。源地址和目的地址都是48位长。

以太网地适配器有过滤功能，它只接受单播帧，广播帧或多播帧。

使用集线器可以在物理层扩展以太网（扩展后的以太网仍然是一个网络）。

交换式集线器常称为以太网交换机或第二层交换机（工作在数据链路层）。它就是一个多接口的网桥，而每个接口都直接与某台单主机或另一个集线器相连，且工作在全双工方式。以太网交换机能同时连通许多对接口，使每一对相互连通的主机都能像独占通信媒体那也无碰撞地传输数据。

高速以太网有100Mbit/s地快速以太网，吉比特以太网和10Gbit/s地10吉比特以太网。最近还发展到100吉比特以太网。在宽带接入技术中也常使用高速以太网进行接入。

---

## 网络层

本章最重要的内容是：

（1）虚拟互连网络的概念。

（2）IP地址与物理地址的关系。

（3）传统的分类的IP地址（包括子网掩码）和无分类域间路由选择CIDR。

（4）路由选择协议的工作原理

---

### 网络层提供的两种服务

有些人认为应当模仿打电话所使用的面向连接的通信方式，当两台计算机进行通信时，也应当先建立连接（在分组交换中是建立一条虚电路VC），以预留双方通信所需的一切网络资源。然后双方就沿虚电路发送分组，分组首部不需要填写完整的目的主机地址，只需填写虚电路编号（一个不大的整数），因此减小了分组开销。这种通信方式再使用可靠的网络协议就可使发送的分组无差错按序到达终点也不丢失、不重复在通信结束后要释放连接。

互联网的设计者认为计算具有很强的差错处理能力，因此采用了这样的设计思路：网络层向上只提供简单灵活的、无连接的、尽最大努力交付的数据报（即IP数据报或分组）服务。

网络在发送分组时不需要先建立连接，每个分组独立发送。网络层不提供服务质量的承诺，因此所传送分组可能出错、丢失、重复和失序，也不保证到达时限。如果主机（端系统）中的进程之间的通信需要的是可靠的，那么就由网络的主机中的运输层负责（差错处理、流量控制等）。

OSI体系支持者曾推出虚电路服务的著名标准X.25建议书，但早已过时。

虚电路服务：

（1）可靠通信应由网络层保证。

（2）必须有连接。

（3）终点地址仅在建立连接阶段使用，每个分组使用短的虚电路号。

（4）属于同一条虚电路的分组均按照同一路由转发。

（5）所有出故障的结点的虚电路均不能工作。

（6）分组按序到达。

（7）差错控制和流量控制可以由网络负责，也可以由用户主机负责。

数据报服务：

（1）可靠通信应由用户主机保证。

（2）不要连接。

（3）每个分组都有终点的完整地址。

（4）每个分组独立选择路由转发。

（5）出故障的结点可能会丢失分组，一些路由可能会发生变化。

（6）不一定按序到达。

（7）差错控制和流量控制由主机负责。

---

### 网际协议IP

与IP协议配套的三个协议：

（1）地址解析协议ARP

（2）网际控制报文协议ICMP

（3）网际组管理协议IGMP

逆地址解析协议RARP已被淘汰。

ICMP，IGMP经常要使用IP协议,IP协议经常要使用ARP协议。由于网际协议IP是用来使互连起来的许多计算机网络能够进行通信的，因此TCP/IP体系中的网络层也叫网际层或IP层。

---

**\1. 虚拟互连网络**

由于用户需求是多样的，没有一种单一的网络能适应所有用户的需求。

将网络互相连接起来要使用一些中间设备，根据层次可划分为：

（1）物理层的中间设备叫做转发器

（2）数据链路层的中间设备叫做网桥或桥接器

（3）网络层的中间设备叫路由器

（4）网络层以上的中间设备叫网关，网关连接不兼容的系统要在高层进行协议转换

由于参加互连的计算机都使用相同的网际协议IP，因此可以把互连后的计算机网络看成一个虚拟互连网络，也就是逻辑互联网络，互连起来的各种物理网络的异构性本来是客观存在的，但利用IP协议可以使这些性能各异的网络在网络层看起来好像是一个统一的网络。

当源主机H1要把一个IP数据报发送给目的主机H2时，根据分组交换的存储转发概念，H1先查看自己的路由表，如果目的主机就在本网络则采用直接交付，如果不是就转发给路由器进行间接交付，直到某路由器知道自己是和H2连接在同一个网络上就把数据表直接交付给H2。路由器的协议栈只有下三层，互联网可以由多种异构网络互连组成。

---

**\2. 分类的IP地址**

IP地址及其表示方法

整个的互联网就是一个单一的、抽象的网络。IP地址就是给互联网的每一台主机（或路由器）的每一个接口分配一个在全世界内范围唯一的32位标识符。IP地址由互联网名字和数字分配机构ICANN分配。

IP地址的方法经过三个阶段：

（1）分类的IP地址。最基本的编址方法。

（2）子网的划分。最基本编址方法的改进。

（3）构成超网。比较新的无分类编址方法。

所谓分类的IP地址就是将IP地址划分为若干个固定类，其中的A类、B类和C类地址都由两个固定长度的字段组成，其中第一个字段是网络号，标志主机或路由器所连接到的网络。一个网络号必须是唯一的。第二个字段是主机号，它标志主机或路由器，一台主机号在它前面网络号所指明的网络范围内必须是唯一的。因此一个IP地址在整个互联网范围内唯一。

A类、B类和C类地址的网络号字段分别为1个、2个和3个字节长，而在网络号字段的最前面有1-3位的类别位，分别规定为0，10和110。

A类、B类和C类地址的主机号字段分别为3个、2个和1个字节长。

D类地址（前4位是1110）用于多播（一对多通信）。

E类地址（前4位是1111）保留位以后使用。

IP地址不仅指明主机，还指明了主机所连接的网络。当某个单位申请到一个IP地址时，实际上是获得了具有同样网络号的一块地址。其中各台主机号则由该单位自行分，只要保证在范围内无重复主机号即可。

将32位IP地址的每8位插入一个空格（机器中并没有），并用等效十进制数字表示，并在这些数字之间加上一个点，就叫做点分十进制记法。

---

**常用的三种IP地址**

A类地址的网络号字段占1个字节，只有7位可供使用，可指派网络号是126个。减2的原因是：第一，IP地址中全0表示“这个”，是保留地址，意思是本网络。第二，网络号01111111保留作为本地软件环回测试本主机的进程之间通信之用。

A类地址的主机号占3个字节，因此每个A类网络中最大主机数是224-2，减2的原因是：全0的主机号表示该IP地址是本主机所连接到的单个网络地址，而全1表示所有的，即该网络上的所有主机。

IP地址共有232个地址，A类地址共有231个地址，占整个IP地址空间的50%。

B类网络地址的网络号字段有2个字节，但前两位（1 0）已经固定。B类地址的网络数为214-1，从128.1.0.0开始，B类地址的最大主机数是216-2=65534个，减2是因为要扣除全0和全1的主机号，整个B类地址有230个，占整个IP地址的25%。

C类地址有3个字节的网络号段，最前面的3位是（1 1 0），还有21位可分配。C类地址可指派网络总数221-1个，最小从192.0.1.0开始。最大主机数是254个，整个C类地址空间共229个，占整个IP地址空间的12.5%。

IP地址的特点：

（1）每个IP地址都由网络号和主机号两部分组成，从这个意思来说IP地址是一种分等级的地址结构。好处：IP管理机构只分配网络号，路由器仅根据目的主机所连接的网络号来转发分组，减小了路由表所占的存储空间和查找路由表的时间。

（2）IP地址是标志一台主机或路由器和一条链路的接口。当一台主机同时连到两个网络上该主机就必须具有两个相应的IP地址，称为多归属主机。一个路由器至少应当连接到两个网络，因此一个路由器至少应有两个不同的IP地址。

（3）一个网络是指具有相同网络号的主机的集合，因此用转发器或网桥连接起来的若干个局域网仍为一个网络。

（4）所有分配到网络号的网络都是平等的。

同一个局域网上的主机或路由器的IP地址中的网络号必须是一样的。

当两个路由器直接相连时，可以分配也可以不分配IP地址，如分配了IP地址，这样的特殊网络就叫无编号网络或无名网络。

---

**\3. IP地址与硬件地址**

物理地址是数据链路层和物理层的地址，IP地址是网络层及其之上各层的地址，是一种逻辑地址。

IP地址放在IP数据报的首部，而硬件地址放在MAC帧的首部。

在IP层抽象的互联网上只能看到IP数据报。

虽然在IP数据报首部有源站IP地址，但路由器只根据目的站的IP地址的网络号进行路由选择。

在局域网的链路层，只能看到MAC帧。MAC帧在不同网络传送时，其首部的源地址和目的地址也要变化。

尽管互连在一起的网络的硬件地址体系各不相同，但IP层抽象的互联网却屏蔽了下层这些复杂细节。

---

**\4. 地址解析协议ARP**

地址解析协议ARP用来寻找已知IP地址主机的硬件地址。

ARP在主机ARP高速缓存中存放一个从IP地址到硬件地址的映射表，并且这个映射表还经常动态更新（新增或超时删除）。

每一台主机都设有一个ARP高速缓存，里面有本局域网上的各主机和路由器的IP地址到硬件地址的映射表，这些都是该主机目前知道的一些地址。

当主机A要向本地局域网的某台主机B发送IP数据报时，先在其ARP高速缓存查看有无主机B的IP地址，如有就在ARP高速缓存中查出其对应的硬件地址再把它写入MAC帧，通过局域网把MAC帧发往此硬件地址。

若差不到主机B的IP地址，主机A就自动运行ARP，然后按以下步骤查出主机B的IP地址：

（1）ARP进程在本局域网上广播发送一个ARP请求分组，ARP分组的主要内容是：我的IP地址是...，我的硬件地址是...，我想知道IP地址为...的硬件地址。

（2）在本局域网上的所有主机上运行的ARP进程都收到此ARP请求分组。

（3）主机B的IP地址与ARP请求分组中要查询的IP地址一致，收下这个ARP请求分组，并向主机A发送ARP响应分组。ARP响应分组的主要内容是：我的IP地址是...，我的硬件地址是...。ARP请求分组是广播，但响应是单播。

（4）主机A收到ARP响应后，在ARP高速缓存中写入主机B的IP地址到硬件地址的映射。

为减小网络通信量，当A发送其ARP请求时就把自己的IP地址到硬件地址的映射写入ARP请求分组，B收到后将其写入自己的ARP高速缓存。

ARP对保存在高速缓存中的每一个映射地址项目都设置生存时间，超过生存时间的项目将被删除。ARP是解决同一个局域网上的主机或路由器的IP地址和硬件地址的映射问题，若不在一个局域网上就无法解析。

从IP地址到硬件地址的解析是自动进行的，主机的用户对这种过程是不知道的。

由于全世界存在各种网络，它们使用不同的硬件地址。要使这些异构网络能相互通信就必须进行非常复杂的硬件地址转换工作，IP编址解决了此问题，因此不直接用硬件地址而额外使用抽象的IP地址。

---

**\5. IP数据报的格式**

一个IP数据报由首部和数据两部分组成，首部的前一部分是固定长度，共20字节，是所有IP数据报必须具有的。在首部的固定部分的后面是一些可选字段，长度可变。

IP数据报首部固定部分中的各字段

（1）版本 占4位，指IP协议的版本。通信双方所用版本必须一致。

（2）首部长度 占4位 

（3）区分服务 占8位，在旧标准中叫做服务类型，一般情况不使用

（4）总长度 指首部和数据长度之和，16位，因此数据报的最大长度为216-1为65535字节。在进行分片时，数据报首部中的总长度字段是指分片后的每一个分片的首部长度与该分片的数据长度之和。

（5）标识 占16位，IP软件在存储器中维持一个计数器，每产生一个数据报，计数器加1，并将此值赋给标识字段。当数据报长度由于超过MTU而必须分片后，标识字段的值就被复制到所有的数据报片的标识字段，相同标识字段的值使分片后的各数据报片最后能正确地重装为原有的数据报。

（6）标志 占3位，只有2位有意义。最低位MF，1表示还有分片，0表示无。中间一位记作DF，意思是不能分片，DF=0时才允许分片。

（7）片偏移 占13位，较长的分组在分片后，某片在原分组中地相对位置。除最后一个数据报片外，每个分片地长度一定是8字节的整数倍。

（8）生存时间 占8位 常用英文缩写TTL，表明数据报在网络中的寿命。每经过一个路由器就减去其消耗的时间，为0时丢弃。

后来功能改为“跳数限制”（但名称不变），现在TTL的单位不是秒而是跳数。数据报能在互联网中经过的路由器最大数值为255，若初值设1则只能在本局域网传送。

（9）协议 占8位 指出此数据报携带的数据使用何种协议，以便使目的主机IP层知道应该将数据上交给哪个协议处理。

（10）首部检验和 占16位，只检验数据报的首部不包括数据部分，主要使用反码。

（11）源地址 占32位。

（12）目的地址 占32位。

IP数据报首部的可变部分

用来支持排错、测量以及安全等措施，内容丰富。

---

**\6. IP层转发分组的流程**

在路由表中，对每一条路由最主要的是以下两个信息：（目的网络地址，下一跳地址）。

IP数据报最终一定可以找到目的主机所在目的网络上的路由器（可能需要通过多次间接交付）。只有到达最后一个路由器时，才试图向目的主机进行直接交付。

虽然互联网上所有的分组转发都是基于目的主机所在的网络，但在大多数情况下都允许有这样的特例，即对特定的目的主机指明一个路由，这种路由叫做特定主机路由。

路由器还可采用默认路由以减小路由表所占空间和搜索路由表所用的时间。

当路由器收到一个待转发的数据报，在从路由表中得出下一跳路由器的IP地址后，不是把这个地址填入IP数据报，而是交送数据链路层的网络接口软件。网络接口软件把下一跳路由器的IP地址转换成硬件地址（必须使用ARP），并将此硬件地址放在链路层MAC帧的首部，然后根据这个硬件地址找到下一跳路由器。

归纳分组转发算法如下：

（1）从数据报首部提取出目的主机的IP地址D，得出目的网络地址N。

（2）若N就是与此路由器直接相连的某网络，则直接交付，否则间接交付，执行（3）。

（3）若路由表中有目的地址为D的特定主机路由，则把数据报传送给路由表中所指明的下一跳路由器，否则执行（4）。

（4）若路由表中有到达网络N的路由，则把数据报传送给路由表中所指明的下一跳路由器，否则执行（5）。

（5）若路由表有默认路由，则把数据报传送给路由表中所指明的默认路由器，否则执行（6）。

（6）报告转发分组出错。

---

### 划分子网和构造超网

划分子网

**\1. 从两级IP地址到三级IP地址**

早期IP地址设计不合理处：

（1）空间利用率有时很低。

（2）给每一个物理网络分配一个网络号会使路由表变得太大而降低网络性能。

（3）两级IP地址不灵活。

为解决上述问题，1985年起在IP地址中增加了一个“子网号字段”，这种做法叫做划分子网，或子网寻址或子网路由选择。划分子网已成为互联网正式标准协议。

划分子网的基本思想：

（1）一个拥有许多物理网络的单位，可将所属物理网络划分为若干子网。划分子网纯属一个单位内部的事情，本单位以外的网络看不见这个网络是由多少个子网组成，因为这个单位对外仍表现为一个网络。

（2）从网络的主机号借用若干位作为子网号，当然主机号就相应地减少同样的位数。于是两级IP地址在本单位内部就变为三级IP地址：网络号，子网号和主机号。

（3）凡是从其他网络发送给本单位某台主机的IP数据报，仍然是根据IP数据报的目的网络号找到连接在本单位网络上的路由器。但此路由器收到IP数据报后，再按目的网络号和子网号找到目的子网，把IP数据报交付目的主机。

**\2. 子网掩码**

从IP数据报的首部无法看出源主机或目的主机所连接的网络是否进行了子网划分，因此需要使用子网掩码。

使用子网掩码的好处：不管网络有没有划分子网，只要把子网掩码和IP地址进行逐位的与运算，就立即得出网络地址来。

如果一个网络不划分子网，那么该网络的子网掩码就使用默认的子网掩码。

A类地址的默认子网掩码是255.0.0.0。

B类地址的默认子网掩码是255.255.0.0。

C类地址的默认子网掩码是255.255.255.0。

子网掩码是一个网络或一个子网的重要属性。路由器在和相邻路由器交换路由信息时，必须把自己所在的网络或子网的子网掩码告诉相邻路由器。

在采用固定长度子网划分时，所划分的所有子网掩码的子网掩码都是相同的。子网号不能为全1或全0，但随着无分类域间路由CIDR的广泛使用，现在全1和全0的子网号也能使用了。划分子网增加了灵活性，但却减少了能够连接在网络上的主机总数。

同样的IP地址和不同的子网掩码可以得出相同的网络地址。但是不同的掩码效果是不同的。

---

使用子网时分组的转发

使用子网划分后，路由表必须包含以下三项内容：目的网络地址、子网掩码和下一跳地址。

划分子网的情况下，路由器转发分组的算法如下：

（1）从收到的数据报首部提取目的IP地址D。

（2）先判断是否直接交付。对路由器直接相连的网络逐个检查，用子网掩码与D进行与运算，看结果是否和相应的网络地址匹配。若匹配直接交付，否在就是间接交付，执行3。

（3）若路由表中有目的地址为D的特定主机路由，就把数据报传送给路由表中指明的下一跳路由器，否则执行4。

（4）对路由表每一行，用其中的子网掩码和D逐位与，结果为N。如果N与该行目的地址网络适配，则把数据报传送给改行指明的下一跳路由器，否则执行5。

（5）若路由表有默认路由，则传送给默认路由器，否则报告转发分组错误。

---

**无分类编址CIDR**

**\1. 网络前缀**

1992年互联网面临的问题：

（1）B类地址已分配近一半。（2）互联网主干上路由表项目数急剧增长。（3）整个IPv4的地址空间最终将全部耗尽。

IETF研究出无分类编址的方法解决前两个问题。它的正式名字时无分类域间路由选择CIDR。

CIDR最主要的特点：

（1）消除了传统的A类、B类、C类地址以及划分子网的概念，因而能更有效的分配IPv4的地址空间，并在新的IPv6使用之前容许互联网规模继续增长。CIDR把32位IP地址划分为前后两部分，前面是网络前缀，用来指明网络，后面用来指明主机。因此CIDR使IP地址从三级编址又回到了两级编址（无分类的两级编址）。

使用斜线记法，或称CIDR记法，即在IP地址后加上斜线，写上网络前缀所占位数。

（2）CIDR把网络前缀相同的连续IP地址组成一个CIDR地址块，只要知道地址块中任何一个地址就能知道其中的起始地址和最大地址，以及地址块数。

为方便路由选择，CIDR使用32位的地址掩码。地址掩码由一串1和一串0组成，1的个数是网络前缀的长度，也可继续称为子网掩码。斜线记法中，斜线后面的数字就是地址掩码中的1的个数。

由于一个CIDR地址块中有很多单位，所以路由表就利用CIDR地址块来查找目的网络，这种地址的聚合常称为路由聚合，也称为构成超网。

网络前缀越短，其地址块所包含的地址数就越多。而在三级结构的IP地址中，划分子网是使网络前缀变长。

---

**\2. 最长前缀匹配**

使用CIDR时，路由表中的每个项目由网络前缀和下一跳地址组成。但在查找路由表时可能会得到不止一个匹配结果。应当从匹配结果中选择具有最长网络前缀的路由，这叫做最长前缀匹配，因为网络前缀越长，地址块就越小，因而路由就越具体。最长前缀匹配又称最长匹配或最佳匹配。

---

**\3. 使用二叉线索查找路由表**

为了进行更有效的查找，最常用的是二叉线索。为了简化二叉线索的构造，可以先找出对应于每一个IP地址的唯一前缀。

二叉线索只是提供了一种可以快速在路由表中找到匹配的叶节点的机制，但这是否和网络前缀匹配，还要和子网掩码进行一次逻辑与的运算。

为提高二叉线索的查找速度，广泛使用了各种压缩技术。

---

### 网际控制报文协议ICMP

为了更有效地转发IP数据报和提高交付成功的机会，在网际层使用了网际控制报文协议ICMP。ICMP允许主机或路由器报告差错情况和提供有关异常情况的报告，不是高层协议，作为IP层数据报的数据，加上数据报的首部，组成IP数据报。

ICMP报文的种类有两种，即ICMP差错报告报文和ICMP询问报文。

ICMP的前四个字节是统一的格式，共有三个字段：类型、代码和检验和。接着的4个字节的内容与ICMP的类型有关，最后面是数据字段，长度取决于ICMP的类型。

ICMP差错控制报文共有四种，即：

（1）终点不可达 当路由器或主机不能交付数据时就向源点发送此报文

（2）时间超过 当路由器收到生存时间为0的数据报时，除丢弃该数据报外还要向源点发送该报文。当终点在预先规定时间内不能收到一个数据报的全部数据报片时，就把已收到的数据报片都丢弃，并向源点发送此报文。

（3）参数问题 当路由器或目的主机收到的数据报的首部中有的字段不正确时，就丢弃该数据报，并向源点发送此报文。

（4）改变路由（重定向） 路由器把改变路由报文发送给主机，让主机知道下次应将数据报发送给另外的路由器。

所有的ICMP差错报文报告中的数据字段都具有相同格式，把收到的需要进行差错报告的IP数据报的首部和数据字段的前8个字节提取出来，作为ICMP报文的数据字段，再加上ICMP差错报告报文的前8个字节，就构成了ICMP差错报告报文。

下面是不应发送ICMP差错报告报文的情况：

（1）对ICMP差错报告报文，不再发送

（2）对第一个分片的数据报片的所有后续数据报片，都不发送

（3）对具有多播地址的数据报，都不发送

（4）对具有特殊地址的数据报，不发送

常用的ICMP询问报文有两种：

（1）回送请求和回答 ICMP回送请求报文是由主机或路由器向一个特定的目的主机发出的询问。收到此报文的目的主机必须给源主机或路由器发送ICMP回送回答报文，这种询问报文用来测试目的站是否可达以及了解其有关状态。

（2）时间戳请求和回答 ICMP时间戳请求报文是请某台主机或路由器回答当前的日期和时间。用于时钟同步和时间测量。

---

ICMP的一个重要应用就是分组网间探测PING（Packet Internet Groper），用来测试两台主机之间的连通性。PING使用了ICMP回送请求和回送回答报文。PING是应用层直接使用网络层ICMP的一个例子，没有通过运输层的TCP或UDP。

Windows操作系统的用户在命令提示行输入ping+主机名或ip地址就可测试连通性。

例PING一个服务器时，PC一连发出4个ICMP回送请求报文，如果服务器正常工作而且响应这个ICMP回送请求报文（有的主机为防止恶意攻击而不理睬外界发送的这种报文），那么它就发回ICMP回送回答报文。由于往返的ICMP报文上都是时间戳，因此很容易得出往返时间。最后显示出的是统计结果：发送到哪个机器（IP地址），发送的、收到的和丢失的分组数（但不给出分组丢失原因）以及往返时间的最小值、最大值和平均值。

另一个非常有用的应用是traceroute（这是UNIX系统中的名字），它用来跟踪一个分组从源点到终点的路径，在Windows中这个命令是tracert。

原理：Traceroute从源主机向目的主机发送一连串的IP数据报，数据报中封装的是无法交付的UDP用户数举报（因为使用了非法端口号）。第一个数据报的TTL设为1，当其到达路径上第一个路由器时，路由器先收下它，接着把TTL减1，由于TTL=0，路由器丢弃数据报并向源主机发送一个ICMP时间超过差错报告报文。

接着源主机发送第二个数据报，并把TTL设为2...以此类推直到最后一个数据报刚到达目的主机时，数据报的TTL=1，主机不转发数据报也不把TTL减1，但因为IP数据报中封装的时无法交付的运输层的UDP数据报，因此目的主机要向源主机发送ICMP终点不可达差错报告报文。这样源主机就知道了路由信息——到达目的主机所经过的路由器的IP地址以及到达其中每个路由器的往返时间。每一行有3个时间出现是因为对应于每个TTL，源主机要发送三次同样的IP数据报。

---

### 互联网的路由选择协议

理想的路由算法特点：

（1）算法必须是正确的和完整的。正确指沿着各路由表所指引的路由，分组一定能最终到达目的网络和目的主机。

（2）算法在计算上应简单，不应使网络通信量增加太多额外开销。

（3）算法能适应通信量和网络拓扑的变化，要有自适应性。有时称这种自适应性为稳健性。

（4）算法应具有稳定性，网络通信量和拓扑稳定时不应使路由不停变化。

（5）算法应公平。

（6）算法应是最佳的，找到最好的路由使分组平均时延最小而网络吞吐量最大。

若从路由算法能否随网络的通信量或拓扑自适应地进行调整变化来划分，则只有两大类，即静态路由选择策略（非自适应路由选择）和动态路由选择策略（自适应路由选择）。

---

分层次的路由选择协议

互联网采用的路由选择协议主要是自适应的（动态的）、分布式路由选择协议，主要因为：

（1）互联网规模非常大，如果让所有路由表知道所有网络应怎样到达，开销太大。

（2）许多单位不愿意外界了解自己网络的布局细节和采用的路由选择协议但又希望连接互联网。

为此可把互联网划分为许多较小的自治系统AS。AS是在单一技术管理下的一组路由器，而这些路由器使用一种自治系统内部的路由选择协议和共同的度量。一个AS对其他AS表现出的是一个单一的和一致的路由选择策略。

目前的互联网中，一个大的ISP就是一个自治系统。这样，互联网就把路由选择协议划分为两大类：

（1）内部网关协议IGP 包括RIP和OSPF协议

（2）外部网关协议EGP 目前使用最多的外部网关协议是BGP

自治系统之间的路由选择叫域间路由选择，而在自治系统内部的路由选择叫域内路由选择。

---

**内部网关协议RIP**

RIP是内部网关协议IGP中最先得到广泛使用的协议，中文名为路由信息协议，但很少使用。RIP是一种分布式的基于距离向量的路由选择协议，最大优点是简单。

RIP协议要求网络中每一个路由器都要维护从它自己到其他每个目的网络的距离记录（这一组距离即距离向量）。距离定义如下：

从路由器到直接相连的网络距离为1，从路由器到非直接相连的网络距离为经过的路由器数加1。RIP的距离也成为跳数，RIP允许一条路径最多只能包含15个路由器，因此距离等于16时相当于不可达，因此RIP只适用于小型互联网。

**RIP协议的特点：**

（1）仅和相邻路由器交换信息。

（2）路由器交换的信息是当前本路由器知道的全部信息，即自己现在的路由表。

（3）按固定时间间隔交换路由信息。

路由表中最主要的信息就是：到某个网络的距离（最短距离），以及应经过的下一跳地址。路由表更新的原则是找出到每个目的网络的最短距离，这种更新算法又称距离向量算法。

距离向量算法，基础是Bellman-Ford算法或Ford-Fulkerson算法。

步骤：

（1）对地址X的相邻路由器发来的RIP报文，先修改此报文中的所有项目，把下一跳地址改为X，并把所有距离加1。每个项目都有三个关键数据，目的网络N，距离d，下一跳地址X。

（2）对修改后的项目，若路由表没有目的网络N则添加，若有且下一跳地址是X则替换，若有且下一跳地址不是X，如果d小于原来的距离则更新，否则什么也不做。

（3）3分组内没收到相邻路由表的更新路由表，则记为不可达，即设置距离16。

（4）返回。

RIP协议使得从每一个路由到每一个目的网络的路由都是最短的。

RIP2支持变长子网掩码和无分类域间路由选择CIDR，还提供简单鉴别支持多播。RIP协议使用UDP进行传送（UDP端口520）。

RIP报文由首部和路由组成。

RIP2报文中的路由部分由若干路由信息组成，每个路由信息需要用20字节。地址族标识符（又称地址类别）字段用来标志所使用的地址协议。路由标记填入自治系统号ASN，这是考虑使RIP有可能收到本自治系统外的路由选择信息。再后面指出某个网络地址、该网络的子网掩码、下一跳路由器地址以及到此网络距离。一个RIP报文最多包括25个路由，因而RIP报文最大长度504字节。

RIP问题：当网络故障时，要经过比较长的时间才能将信息传送到所有路由器。这一特点叫：好消息传播得快，坏消息传播得慢。总之RIP协议最大的优点就是实现简单，开销较小，缺点也较多，限制了网络规模，对于规模较大的网络应使用OSPF协议。

---

**内部网关协议OSPF**

这个协议的名字是开放最短路径优先OSPF，为克服RIP缺点开发。开放表明OSPF协议不是受一家厂商控制，而是公开发表。最短路径优先是因为使用了Dijkstra提出的最短路径算法SPF。

主要特征：使用分布式的链路状态协议，而不是RIP那样的距离向量协议。

（1）向本自治系统的所有路由器发送信息，用的是洪泛法。

（2）发送的信息就是与本路由器相邻的所有路由器的链路状态，这只是路由器知道的部分信息。链路状态就是说明本路由器都和哪些路由器相邻，以及该链路的度量（费用、距离、时延、带宽等）。

（3）只有当链路状态发生变化时，路由器才向所有路由器用洪泛法发送此信息。

由于各路由器之间频繁交换链路信息，因此所有路由器最终都能建立一个链路状态数据库，实际上就是全网的拓扑结构图。RIP协议的每个路由器虽然知道到所有网络的距离以及下一跳路由器，但不知道全网的拓扑结构。OSPF的链路状态数据库能较快更新，使各路由器及时更新路由表，OSPF的更新过程收敛得快是其重优点。

为使OSPF能够用于大型网络，OSPF将一个自治系统划分为若干区域。OSPF使用层次结构的区域划分，在上层的区域叫主干区域，作用使连通其他下层区域，从其他区域来的信息都由区域边界路由器进行概括。在主干区域内的路由器叫主干路由器，一个主干路由器可以同时是多个区域边界路由器。在主干区域还有一个路由器专门和本自治系统之外的其他自治系统交换路由信息，叫做自治系统边界路由器。

OSPF不用UDP而是直接用IP数据报传送（IP数据报首部协议字段值89）。OSPF分组使用24字节的固定首部长度，分组的数据部分可以是五种类型分组中的一种。

OSPF首部各字段的意义：

（1）版本 当前版本号为2

（2）类型 五种类型分组中的一种

（3）分组长度 包括OSPF首部在内的分组长度，以字节为单位

（4）路由器标识符 标志发送该分组的路由器的接口的IP地址

（5）区域标识符 分组属于的区域

（6）检验和 用来检验分组中的差错

（7）鉴别类型 0（不用）和1（口令）

（8）鉴别 鉴别类型为0时填入0，为1时填入8个自负的口令

OSPF的其他特点：

（1）对于不同类型的业务可计算不同的路由，链路代价为1-65535

（2）如果到同一个目的网络有多条相同路径，那么可以将通信量分配给这几条路径，这叫做多路径间的负载平衡。

（3）所有在OSPF路由器之间交换的分组都具有鉴别的功能。

（4）OSPF支持可变长度的子网划分和CIDR。

（5）OSPF让每个链路状态都带上一个32位的序号，序号越大状态越新。

OSPF的五种分组类型:

（1）类型1，问候分组。

（2）类型2，数据库描述分组。

（3）类型3，链路状态请求分组。

（4）类型4，链路状态更新分组。

（5）类型5，链路状态确认分组。

---

**外部网关协议BGP**

1989年公布了新的外部网关协议——边界网关协议BGP。

内部网关协议主要设法使数据报在一个AS中尽可能有效从源站传送到目的站，在一根AS内也不需要考虑其他方面策略。然而BGP使用环境不同，主要因为：

（1）互联网规模太大，使得自治系统AS之间路由选择非常困难。

（2）自治系统AS之间的路由选择必须考虑有关策略。

由于上述情况，边界网关协议BGP只能力求寻找一条能够到达目的网络且比较好的路由，而并非寻找一条最佳路由。BGP采用了路径向量路由选择协议。

配置BGP时，每个AS管理员要选择至少一个路由器作为该AS的BGP发言人，一般来说，两个BGP发言人都是通过一个共享网络连接在一起的，而BGP发言人往往就是BGP边界路由器，但也可以不是。

一个BGP发言人与其他AS的BGP发言人要交换路由信息就要先建立TCP连接（端口号179），然后在此连接上交换BGP报文以建立BGP会话，利用BGP会话交换路由信息。使用TCP连接能提供可靠服务，也简化了路由选择协议。使用TCP连接交换路由信息的两个BGP发言人彼此成为对方的临站或对等站。

BGP所交换的网络可达性的信息就是要到达某个网络所要经过的一系列自治系统，当BGP发言人相互交换了网络可达性信息后，各BGP发言人就根据所采用的策略从收到的路由信息中找出到达各自治系统的较好录由。

BGP协议交换路由信息的结点数量级时自治系统个数的量级，要比自治系统的网络数少很多。

BGP支持无分类域间路由选择CIDR，因此BGP的路由表也应当包括目的网络前缀、下一跳路由器以及到达该目的网络所要经过的自治系统序列。

BGP的四种报文：

（1）OPEN打开报文，用来与相邻的另一个BGP发言人建立关系，通信初始化。

（2）UPDATE 更新报文，用来通告某一路由的信息以及列出要撤销的多条路由。

（3）KEEPALIVE保活报文，用来周期性证实临站的连通性。

（4）NOTIFICATION通知报文，用来发送检测到的差错。

四种类型的BGP报文具有同样的通用首部，长度19字节。通用首部分为三各字段。标记字段16字节，用来鉴别收到的BGP报文，当不使用鉴别时，标记字段置为全1。长度字段指出包括通用首部在内的整个BGP报文以字节为单位的长度，最小值19，最大值4096。类型字段的值1-4。

OPEN报文有6个字段，即版本（1字节，当前值4）、本自治系统（2字节）、保持时间（2字节）、BGP标识符（2字节）、可选参数长度和可选参数。

UPDATE报文共有5个字段，即不可行路由长度（2字节）、撤销的路由、路径属性总长度（2字节）、路径属性和网络层可达性NLRI。

KEEPALIVE报文只有BGP的19字节长的通用首部。

NOTIFICATION报文有3个，即差错代码（1字节）、差错子代码（1字节）和差错数据。

---

**路由器的构成**

路由器是一种具有多个输入端口和多个输出端口的专用计算机，其任务是转发分组。路由器的转发分组是网络层的主要工作。路由器的结构可划分为两部分：路由选择部分和转发分组部分。

路由选择部分也叫控制部分，其核心构件是路由选择处理机。路由选择处理机的任务是根据所选定的路由选择协议构造出路由表，同时经常或定期和相邻路由器交换路由信息而不断地更新和维护路由表。

分组转发部分由三部分组成：交换结构、一组输入端口和一组输出端口。这里的端口指硬件接口。

交换结构又称为交换组织，它的作用是根据转发表对分组进行处理，将某个输入端口进入的分组从一个合适的输出端口转发出去。可将交换结构看成在路由器中的网络。

转发就是路由器根据转发表把收到的IP数据报从路由器的合适端口转发出去，仅仅涉及一个路由器，但路由选择涉及到很多路由器，路由表则是多个路由器协同工作的结果。路由表一般仅包含从目的网络到下一跳的映射，而转发表是从路由表得出的。路由表总是用软件实现的，但转发表则甚至可用特殊的硬件实现。当讨论路由选择原理时，往往不去区分转发表和路由表的分别。

若分组处理的速率赶不上分组进入的速率，则队列的存储空间最终必定减少到零，这就使后面再进入队列的分组由于没有存储空间而只能被丢弃。以前所提的分组丢失就是发生在路由器的输入或输出队列产生溢出的时候。设备或线路故障也可能使分组丢失。

交换结构是路由器的关键构件，正是这个交换结构把分组从一个输入端口转移到某个合适的输出端口。实现这样的交换有多种方法。

（1）最早使用的路由器就是利用普通计算机，用计算机的CPU作为路由器的路由选择处理机。许多现代的路由器也通过存储器进行交换，与早期路由器的区别是，目的地址的查找和分组在存储器中的缓存都是在输入端口中进行的。

（2）通过总线进行交换，采用这种方式时，数据报从输入端口通过共享总线直接传送到合适的输出端口，而不需要路由选择处理机的干预。

（3）通过纵横交换结构进行交互，这种交换结构常称为互连网络，它有2N条总线，可以使N个输入端口和N个输出端口相连接，这取决于相应的交叉结点是使水平总线和垂直总线接通还是断开。输入端口将收到的分组发送到与输入端口相连的水平总线，若垂直总线空闲就将其与水平总线连通并转发到输出端口，否则在输入端口排队。

---

### IPV6

解决IP地址耗尽的根本措施就是采用具有更大地址空间的新版本的IP，即IPV6。

IPv6仍支持无连接的传送，但将协议数据单元PDU称为分组，而不是IPv4的数据报。

IPv6的主要变化：

（1）更大的地址空间，从IPv4的32位增大到128位。

（2）扩展的地址层次结构。

（3）灵活的首部格式。IPv6数据报的首部和IPv4不兼容。

（4）改进的选项。IPv6允许数据报包含有选项的控制信息，但IPv6的首部长度是固定的。

（5）允许协议继续扩充。

（6）支持即插即用（自动配置）。不需要使用DHCP。

（7）支持资源的预分配。

（8）IPv6的首部改为8字节对齐（即首部长度必须是8字节的整数倍）。

IPv6数据报由两大部分组成，即基本首部和后面的有效载荷（净负荷），有效载荷允许有零个或多个扩展首部，再后面是数据部分。

与IPv4相比，IPv6对首部的某些字段进行了如下更改：

（1）取消了首部长度字段，因为它的首部长度固定为40字节

（2）取消了服务类型字段

（3）取消了总长度字段

（4）取消了标志、标识和片偏移字段

（5）把TTL字段改为限制条数字段，功能不变

（6）取消了协议字段

（7）取消了检验和字段，加快了路由器处理数据报的速度

（8）取消了选项字段

IPv6首部中各字段的作用：

（1）版本 4位，指明协议版本，值为6

（2）通信量类 8位，为了区分不同IPv6数据报的类别或优先级

（3）流标号 20位，IPv6提出流的抽象概念，所谓流就是互联网上从特定源点到特定终点（单播或多播）的一系列数据报（如实时音频或视频传输），而在这个流所经过的路径上的路由器都保证指明的服务质量。属于同一个流的数据报都具有同样的流标号。

（4）有效载荷长度 16位，指明IPv6数据报除基本首部以外的字节数，最大值64KB。

（5）下一个首部 8位，相当于IPv4的协议字段或可选字段。当没有扩展首部时，下一个首部字段的作用和IPv4的协议字段作用一样，6代表交付运输层TCP，17代表交付UDP。

出现扩展首部时，下一个首部字段的值标识后面第一个扩展首部的类型。

（6）跳数限制 8位，防止数据报在网络无限期存在，最大跳255。

（7）源地址 128位，数据报发送端的IP地址。

（8）目的地址 128位，数据报接收端的IP地址。

IPv6把原来IPv4首部中选项的功能都放在扩展首部，并把扩展首部留给路径两端的源点和终点的主机处理，而数据报途径中经过的路由器都不处理这些扩展首部（除了逐跳选项扩展首部），大大提高了路由器的处理效率。

RFC2460定义了以下6种扩展首部：（1）逐跳选项（2）路由选择（3）分片（4）鉴别（5）封装安全有效载荷（6）目的站选项

---

IPv6的地址是以下三种之一：

（1）单播 传统的点对点通信

（2）多播 一点对多点的通信，数据报发送到一组计算机中的而每一个，IPv6没有采用广播的术语，而是将广播看作多播的一个特例

（3）任播 终点是一组计算机，但数据报只交付其中一个，通常是距离最近的一个。

IPv6把实现IPv6的主机或路由器均称为结点。

---

向IPv6过渡只能采取逐步演进的办法，同时还必须使新安装的IPv6系统能够向后兼容。这就是说IPv6系统必须能够接收和转发IPv4分组，并且能够为IPv4分组选择路由。

向IPv6过渡的策略：

（1）双协议栈

是指在完全过渡到IPv6之前使一部分主机或路由器装有双协议栈：一个IPv4和一个IPv6。它使用域名系统DNS来查询目的主机使用的IP地址类型。

（2）隧道技术

这种方法的要点就是在IPv6数据报要进入IPv4网络时，把IPv6数据报封装称IPv4数据报，要使双协议栈的主机知道IPv4数据报里封装的是一个IPv6数据报就必须把IPv4首部的协议字段值设为41。

---

和IPv4一样，IPv6也不保证数据报的可靠交付，它也需要使用ICMP来反馈一些差错信息，新的版本称为ICMPv6，它比ICMPv4要复杂许多，地址解析协议ARP和网际组管理协议IGMP的功能都已被合并到ICMPv6中。

---

### IP多播

与单播相比，在一对多的通信中，多播可大大节约网络资源。

在互联网范围的多播要靠路由器实现，这些路由器必须增加一些能够识别多播数据报的软件，能够运行多播协议的路由器称为多播路由器。

在互联网上进行多播就叫IP多播。IP多播所传送的分组需要使用多播IP地址。

在多播数据报的目的地址写入的是多播组的标识符，然后设法让加入这个多播组的主机IP地址与多播组的标识符关联起来。其实多播组的标识符就是IP地址中的D类地址。D类地址范围是224.0.0.0到239.255.255.255，用每一个D类地址标志一个多播组。多播数据报和一般IP数据报的区别是它使用D类IP地址作为目的地址，并且首部中的协议字段值为2，表明使用网际管理组协议IGMP。

多播地址只能用于目的地址，而不能用于源地址。对多播报文不产生ICMP差错报文，因此若在PING命令后键入多播地址将永远不会收到响应。

IP多播分为两种：（1）在本局域网上进行硬件多播（2）在互联网范围进行多播。前一种虽然简单但很重要，因为现在大部分主机都是通过局域网接入互联网。在互联网上进行多播的最后阶段还是要把多播数据报在局域网上用硬件多播交付多播组的所有成员。

IP多播需要两种协议

（1）网际组管理协议IGMP

工作可分为两阶段：

第一阶段：当某台主机加入新的多播组时，该主机向多播组的多播地址发送一个IGMP报文，声明自己要成为该组的成员。本地的多播路由器收到IGMP报文后，还要利用多播路由选择协议把这种组成员关系转发给互联网上的其他多播路由器。

第二阶段：组成员关系是动态的，本地多播路由器要周期性地探寻本地局域网上的主机，以便知道这些主机是否还继续是组的成员。只要有一台主机对某个组响应，那么多播路由器就认为这个组是活跃的。但一个组在多次探询后仍然没有一台主机响应，多播路由器就认为本网络上的主机都离开了这个组，也就不再转发组关系至其它多播路由器。

（2）多播路由选择协议

在多播过程中一个多播组中的成员是动态变化的。多播路由实际上就是要找出以源主机为根节点的多播转发树。

转发多播数据报时用到了三种方法：（1）洪泛与剪除。适合于小的多播组，而所有组成员接入的局域网也是相邻的。为了避免兜圈子，采用了反向路径广播RPB。（2）隧道技术，适用于多播组的位置在地理上很分散的情况。（3）基于核心的发现技术，这种方法对于多播组的大小在较大范围内变化时都适合。

---

###  虚拟专用网VPN和网络地址转换NAT

假定一个机构内部的计算机通信也采用TCP/IP协议，那么这些仅在机构内部使用的计算机就可以由本机自行分配其IP地址，这就是说让这些计算机使用仅在本机构内有效的IP地址（本地地址）而不需要向互联网的管理机构申请全球唯一的IP地址（全球地址），这样可大大节约IP地址资源。

在互联网中的所有路由器，对目的地址是专用地址的数据报一律不进行转发。

2013年4月，RFC6890给出了所有特殊用途的IPv4地址：

（1）10.0.0.0到10.255.255.255 即10.0.0.0/8

（2）172.16.0.0到172.31.255.255 即172.16.0.0/12

（3）192.168.0.0到192.168.255.255 即192.169.0.0/16

采用这样的专用IP地址的互连网洛称为专用互联网或本地互联网，或专用网。专用IP地址也叫做可重用地址。

机构利用公用的互连网作为本机构各专用网之间的通信载体，这样的专用网叫做虚拟专用网VPN。之所以叫专用网是因为这种网络时为本机构的主机用于机构内部的通信，而不适用于和网络外费本机构的主机通信。如果专用网不同网点间通信必须经过公用互联网，但又有保密要求，那么所有通过互联网传送的数据都必须加密。虚拟表示好像时，但实际上不是，因为现在并没有真正使用通信专线，而VPN只是在效果上和真正专用网一样。

VPN类型：内联网、外联网（内联网和外联网都基于TCP/IP）、远程接入

---

网络地址转换NAT

这种方法需要在专用网连接到互联网上的路由器安装NAT软件，装有NAT软件的路由器叫做NAT路由器，它至少有一个有效的外部全球IP地址。这样所有使用本地地址的主机在和外界通信时，都要在NAT路由器上将其本地地址转换成全球IP地址，才能和互联网通信。

通过NAT路由器的通信必须由专用网内的主机发起，专用网内的主机不能充当服务器，因为互联网上的客户无法请求专用网内的服务器提供服务。为更加有效利用NAT路由器上的IP地址，现在常用的NAT转换表把运输层的端口号也加上，这样就可使多个拥有本地地址的主机，公用一个NAT路由器上的IP地址，因而可以同时和互联网上的不同主机通信。

采用了端口号的NAT也叫做网络地址与端口号转换NAPT，而不使用端口号的NAT就叫做NAT。普通路由器转发IP数据报时，源地址或目的地址都不改变，但NAT路由器在转发IP数据报时一定要更换其IP地址，且还要查看和转换运输层端口号，不仅仅工作在网络层。

---

### 多协议标记交换MPLS

MPLS利用面向连接技术，使每个分组携带一个叫做标记的小整数，当分组到达交换机时，交换机读取分组的标记，并用标记值来检索分组转发表，这样就比查找路由表来转发分组要快得多。

特点：（1）支持面向连接的服务质量（2）支持流量过程，平衡网络负载（3）有效支持虚拟专用网VPN

MPLS的一个重要特点就是在MPLS域的入口处，给每一个IP数据报打上固定长度的标记，然后对打上标记的IP数据报用硬件转发，大大加快了IP数据报的转发过程。采用硬件技术对打上标记的IP数据报进行转发就成为标记交换。交换也表示在转发时不再上升到第三层查找转发表，而是根据标记在第二层（链路层）用硬件转发。MPLS可使用多种链路层协议：PPP、以太网、ATM以及帧中继等。

MPLS域指该域中有许多彼此相邻的路由器，并且所有路由器都是支持MPLS技术的标记交换路由器LSR。LSR同时具有标记交换和路由选择两种功能。

---

### 本章的重要概念 

TCP/IP体系中的网络层向上只提供简单灵活、无连接的、尽最大努力交付的数据报服务。网络层不提供服务质量的承诺，不保证分组交换的时限，所传送的分组可能出错、丢失、重复或失序。进程之间通信的可靠性由运输层负责。

IP网是虚拟的，因为从网络层上看，IP网就是一个统一的、抽象的网络（实际上是异构的）。IP层抽象的互联网屏蔽了下层网络复杂的细节使我们能够使用统一的、抽象的IP地址处理主机之间的通信问题。

在互联网上的交互有两种：在本网络的直接交付（不经过路由器）和到其他网络的间接交付（至少经过一个路由器但最后一次一定是直接交付）。

一个IP地址在整个互联网范围内是唯一的，分类的IP地址包括A类、B类、C类地址（单播地址）、以及D类地址（多播地址），E类地址未使用。

分类的IP地址由网络号字段（指明网络）和主机号字段（指明主机）组成。网络号字段最前面的类别位指明IP地址的类别。

IP地址是一种分等级的地址结构。IP地址管理机构在分配IP地址时只分配网络号，主机号则由得到该网络号的单位自行分配。路由器仅根据目的主机所连接的网络号来转发分组。

IP地址标志一台主机（或路由器）和一条链路的接口。多归属主机同时连接到两个或更多的网络上。这样的主机同时具有两个或更多的IP地址，其网络号必须是不同的。由于一个路由器至少应连接到两个网络，因此一个路由器至少应当有两个不同的IP地址。

按照互联网的观点，用转发器或网桥连接起来的若干局域网仍为一个网络，所有分配到网络号的网络（无论范围大小）都是平等的。

物理地址（硬件地址）是数据链路层和物理层使用的地址，而IP地址是网络层和以上各层使用的地址，是一种逻辑地址（用软件实现），在数据链路层看不见数据报的IP地址。

IP数据报分为首部和数据两部分，首部的前一部分是固定长度20字节，是所有IP数据报必须具有的（源地址、目的地址、总长度等重要字段都在固定首部中）。一些长度可变的可选字段放在固定首部的后面。

IP首部中的生存时间字段给出了IP数据报在互联网中所能经过的最大路由数，可防止IP数据报在互联网中无限制兜圈。

地址解析协议ARP把IP地址解析为硬件地址，它解决同一个局域网上的主机或路由器的IP地址和硬件地址的映射问题。ARP的高速缓存可以大大减少网络上的通信量。

互联网中我们无法根据硬件地址寻找在某个网络上的某台主机，因此从IP地址到硬件地址的解析是非常必要的。

无分类域间路由选择CIDR是解决目前IP地址紧缺的一个好办法。CIDR记法把IP地址后面加上斜线“/”，然后写上前缀所占的位数。前缀用来指明网络，前缀后面的部分是后缀，用来指明主机。CIDR把前缀都相同的连续IP地址组成一个CIDR地址块，IP地址的分配都以CIDR地址块为单位。

CIDR的32为地址掩码由一串1和一串0组成，1的个数是前缀的长度。只要把IP地址和地址掩码逐位进行与运算，就很容易得出网络地址。A类地址的默认地址掩码是255.0.0，B类地址的默认地址掩码是255.255.0.0，C类地址的默认地址掩码是255.255.255.0。

路由聚合（把许多前缀相同的地址用一个来代替）有利于减少路由表中的项目，减少路由器之间的路由选择信息的交换，从而提高整个网络的性能。

转发和路由选择有区别，转发是单个路由器的动作，路由选择是许多路由器共同协同的过程，这些路由器相互交换信息，目的是生成路由表，再从路由表导出转发表。若采用自适应的路由选择算法，则网络拓扑变化时，路由表和转发表都能够自动更新。许多情况下，可不考虑路由表和转发表的区别而都使用路由表这一名词。

自治系统AS就是在单一的技术管理下的一组路由器，一个自治系统对其他自治系统表现出的是一个单一的和一致的路由选择策略。

路由选择协议有两大类：内部网关协议（或自治系统内部的路由选择协议），如RIP和OSPF；外部网关协议（自治系统之间的路由选择协议），如BGP-4。

RIP是分布式的基于距离向量的路由选择协议，只适用于小型互联网。RIP按固定的时间间隔与相邻路由器交换信息。交换的信息是自己当前的路由表，即到达本自治系统中所有网络的最短距离，以及到每个网络应经过的下一跳路由器。

OSPF是分布式的链路状态协议，适用于大型互联网。OSPF只在链路状态发生变化时，才向本自治系统中的所有路由器用洪泛法发送与本路由器相邻的所有路由器的链路状态信息。链路状态指明本路由器都和哪些路由器相邻，以及该链路的度量。度量表示费用、时延、带宽等，可通称为代价。所有的路由器最终都能建立一个全网的拓扑结构图。

BGP-4是不同AS的路由器之间交换路由信息的协议，是一种路径向量路由选择协议。BGP力求寻找一条能够到达目的网络（可达）且比较好的路由（不兜圈子），而并非寻找一条最佳路由。

网际控制报文协议ICMP是IP层的协议。ICMP报文作为IP数据报的数据，加上首部后组成IP数据报发送出去。使用ICMP并非为了实现可靠传输，ICMP允许主机或路由器报告差错情况和提供有关异常的报告。ICMP报文的种类有两种，即ICMP差错报告报文和ICMP询问报文。

ICMP的一个重要应用就是分组网间探测PING，用来测试两台主机之间的连通性。PING使用了ICMP回送请求和回送回答报文。

要解决IP地址耗尽的问题，最根本的办法就是采用具有更大地址空间的新版本IP协议即IPv6。

IPv6的主要变化是：（1）更大的地址空间（2）灵活的首部格式（3）改进的选项（4）支持即插即用（5）支持资源的预分配（6）IPv6的首部改为8字节对齐。

IPv6数据报在基本首部的后面允许有零个或多个扩展首部，再后面是数据。所有的扩展首部和数据合起来叫做数据报的有效载荷或净负荷。

IPv6数据报的目的地址可以是以下三种基本类型之一：单播、多播和任播。

IPv6的地址使用冒号16进制记法。

向IPv6过渡只能采用逐步演进的办法，必须使新安装的IPv6系统能够向后兼容。向IPv6过渡可以使用双协议栈或隧道技术。

与单播相比，在一对多的通信中，IP多播可大大节约网络资源。IP多播使用D类IP地址，IP多播需要使用网际组管理协议IGMP和多播路由选择协议。

虚拟专用网VPN利用公用的互联网作为本机构各专用网之间的通信载体。VPN内部使用互联网的专用地址，一个VPN至少要有一个路由器具有合法的全球IP地址，这样才能和本系统另一个VPN通过互联网进行通信。所有通过互联网传说的数据都必须加密。

使用网络地址转换NAT技术，可以在专用网络内部使用专用IP地址，而仅在连接到互联网的路由器使用全球IP地址，这样就大大节约了IP地址资源。

MPLS的特点：（1）支持面向连接的服务质量（2）支持流量工程，平衡网络负载（3）有效地支持虚拟专用网VPN

MPLS在入口结点给每一个IP数据报打上固定长度的标记，然后根据标记在第二层（链路层）用硬件进行转发（在标记交换路由器中进行标记对换），因而转发速率大大加快。

---

## 运输层

本章重要内容：

（1）运输层为相互通信的应用进程提供逻辑通信。

（2）端口和套接字的意义。

（3）无连接的UDP的特点。

（4）面向连接的TCP的特点。

（5）在不可靠网络上实现可靠传输的工作原理，停止等待协议和ARQ协议。

（6）TCP的滑动窗口、流量控制、拥塞控制和连接管理。

---

### 运输层协议概述

从通信和信息处理的角度看，运输层向它上面的应用层提供通信服务，它属于面向通信部分的最高层，同时也是用户功能中的最底层。当网络边缘的两台主机利用网络的核心功能进行端到端的通信时，只有主机的协议栈才有运输层，而路由器在转发分组时只用到下三层的功能。

从IP层来说通信的两端是两台主机，IP数据报的首部明确标志了这两台主机的IP地址。但真正进行通信的实体是主机中的进程，因此严格地讲，两台主机进行通信就是两台主机中的应用进程互相通信。IP协议虽然能把分组送到目的主机，但是这个分组还停留在主机的网络层而没有交付主机中的应用进程。从运输层的角度看，通信的真正端点并不是主机而是主机中的进程。也就是说，端到端的通信是应用进程之间的通信。

运输层有一个很重要的功能——复用和分用。复用是指在发送方不同的应用进程都可以使用同一个运输层协议传送数据（加上适当的首部），而分用是指接收方的运输层在剥去报文的首部后能够把这些数据正确交付目的应用进程。运输层提供应用进程之间的逻辑通信，逻辑通信的意思是：从应用层来看，只要把应用层报文交给下面的运输层，运输层就可以把报文送到对方的运输层，好像这种通信就是沿水平方向直接传送数据。但事实上这两个运输层之间并没有一条水平方向的物理连接，数据传送是经过多个层次传送的。

网络层为主机之间提供逻辑通信，而运输层为应用进程之间提供逻辑通信。

运输层还要对收到的报文进行差错检测，在网络层，IP数据报首部中的检验和字段，只检验首部是否出现差错而不检查数据部分。

根据应用程序的不同需求，运输层需要两种协议，即面向连接的TCP和无连接的UDP。

运输层向高层用户屏蔽了下面网络核心的细节（网络拓扑、所采用的路由选择协议等），它使应用进程看见的就好像是在两个运输层实体之间有一条端到端的逻辑通信信道，但这条逻辑通信信道对上层的表现因运输层的不同协议而有很大差别。当运输层采用TCP时，尽管下面的网络是不可靠的，但这种逻辑通信信道就相当于一条全双工的可靠信道。但运输层采用UDP时，这种逻辑通信信道仍然是不可靠的。

按照OSI的术语，两个对等层实体在通信时传送的数据单位叫运输协议数据单元TPDU。但在TCP/IP体系中，根据所选协议分别称为TCP报文段（segment）或UDP用户数据报。

UDP在传送数据前不需要先建立连接，远地主机运输层收到报文后不需要给出任何确认。

TCP提供面向连接的服务，在传送前必须建立连接，传送后要释放连接。TCP不提供广播或多播服务。

使用TCP和UDP的各种应用和应用层协议：

UDP：名字转换 DNS、文件传送TFTP、路由选择协议IP、IP地址配送DHCP、网络管理SNMP、远程文件服务器NFS、IP电话 专用协议、流式多媒体通信 专用协议、多播 IGMP

TCP：电子邮件 SNMP、远程终端接入TELNET、万维网WWW、文件传送 FTP

应用层的所有应用进程都可以通过运输层再传送到IP层（网络层），这就是复用。运输层从IP层收到发送给各应用进程的数据后，必须分别交付指明的各应用进程，这就是分用。

在运输层使用协议端口号，或称端口。虽然通信的终点是应用进程，但只要把传送的报文交到目的主机的某个合适的目的端口，剩下的工作（即交付目的进程）就由TCP或UDP完成。

这种在协议栈层间的端口是软件端口，和路由器或交换机上的硬件端口不同。硬件端口是不同硬件设备进行交互的接口，而软件端口是应用层的各种协议进程与运输实体进行层间交互的一种地址。

TCP和UDP的首部格式中都有源端口和目的端口，当运输层收到IP层上交的运输层报文时，就能根据其首部中的目的端口号把数据交付应用层的目的应用进程。

TCP/IP的运输层使用16位端口号来标志一个端口，端口号只具有本地意义，只是为了标志本计算机应用层中的各个进程在和运输层交互时的层间接口。在互联网不同计算机中，相同的端口号没有关联，16位端口号允许65535个不同的端口号。

两个计算机中的进程要相互通信，不仅要知道对方的IP地址，还要知道对方的端口号。互联网上的计算机通信采用客户-服务器方式，运输层端口号分为以下两种：

（1）服务器端口号 最重要的一类叫做熟知端口号或系统端口号，数值0-1023。如：FTP21 、TELNET23、SMTP25、DNS53、TFTP69、HTTP80、SNMP161、SNMP(trap)162、HTTPS443。

另一类叫做登记端口号，数值1024-49151，为没有熟知端口号的应用进程使用的。

（2）客户端端口号 数值为49152-65535，又叫做短暂端口号。

---

### 用户数据报协议UDP

UDP只在IP的数据报服务上增加了很少一点的功能，复用、分用以及差错检测。UDP的主要特点是：

（1）无连接，发送数据前不需要建立连接，减小了开销和发送时延。

（2）尽最大努力交付，不保证可靠服务，主机不需要维持复杂的连接状态表。

（3）UDP是面向报文的，UDP对应用层交下来的报文，既不合并也不拆分，而是保留这些报文的边界。因此应用程序需要选择合适大小的报文，太长（需要分片）太短（首部相对长度太大）都会降低IP等的效率。

（4）UDP没有拥塞控制，网络出现拥塞不会使源主机的发送速率降低，适合很多实时应用（IP电话，视频会议等），这些应用要求源主机以恒定速率发送数据。

（5）支持一对一、一对多、多对一和多对多的交互通信。

（6）首部开销小，只有8字节，TCP需要20字节。

不使用拥塞控制的UDP有可能使网络产生严重拥塞。

---

**UDP的首部格式**

UDP有两个字段，数据字段和首部字段。首部字段只有8字节，由四个字段组成，每个字端都是2字节长。各字段意义如下：

（1）源端口 源端口号，需要对方回信时使用，不需要全0。

（2）目的端口 目的端口号，在终点交付报文时必须使用。

（3）长度 UDP用户数据报的长度，最小值为8（仅有首部）。

（4）检验和 检测UDP数据报在传输中是否有错，有错则丢弃。（使用12字节的伪首部，既不向下传送也不向上递交）

如果接收方UDP发现接收报文中目的端口号不正确，即不存在对应于该端口号的应用进程，就丢弃该报文，并由网际控制报文协议ICMP发送端口不可达差错报文给发送方。ICMP的traceroute应用就是让发送的UDP数据报故意使用非法UDP端口。

---

### 传输控制协议TCP概述

TCP最主要的特点：

（1）TCP是面向连接的运输层协议。

（2）每一条TCP连接只能有两个端点，只能是点对点的（一对一）。

（3）TCP提供可靠交付的服务，通过TCP传送的数据，无差错、不丢失、不重复并且按序到达。

（4）提供全双工通信，TCP两端都有发送缓存和接收缓存，用来临时存放双向通信的数据。

（5）面向字节流，流指的是流入到进程或从进程中流出的字节序列。面向字节流的含义是，虽然应用进程和TCP的交互是一次一个数据块，但TCP把应用程序交下来的数据仅仅看成一连串的无结构字节流。TCP不保证接收方应用程序收到的数据块和发送方应用程序发出的数据块具有对应大小的关系，但接收方收到的字节流必须和发送的字节流完全一样。

TCP连接是一条虚连接（逻辑连接），而不是一条真正的物理连接。TCP报文端先要传送到IP层，加上IP首部后，再传送到数据链路层。再加上数据链路层的首部和尾部再离开主机发送到物理链路。

TCP发送报文时不关心应用进程一次把多长的报文发送到TCP的缓存中，而是根据对方给出的窗口值和当前网络拥塞的程度决定一个报文段应包含多少字节（UDP发送的报文长度是应用进程给出的）。如果应用进程发送到TCP缓存的数据块太长，TCP就把它划分短一些再传送，如果太短TCP也可以等待积累足够多的字节构成报文段再发送。

TCP把连接作为最基本的抽象，TCP的许多特性都与TCP是面向连接的这个基本特性有关。

TCP连接有两个端点，TCP连接的端点叫做套接字（socket）或插口。端口号拼接到IP地址即构成了套接字。因此套接字的表示方法是在点分十进制的IP地址后写上端口号，中间用冒号或逗号隔开。每一条TCP连接唯一地被通信两端的两个端点（即两个套接字）确定。

一定要记住：TCP连接的端点是个很抽象的套接字，即（IP地址：端口号）。还应记住：同一个IP地址可以有多个不同的TCP连接，而同一个端口号也可以出现在多个不同的TCP连接。

---

### 可靠传输的工作原理

TCP下面的网络所提供的是不可靠的传输，因此TCP必须采用适当的措施才能使两个运输层之间的通信变得可靠。

---

**停止等待协议**

全双工通信的双方既是发送方也是接收方。停止等待协议就是每发送完一个分组就停止发送，等待对方的确认，在收到确认之后再发送下一个分组。

**1 无差错情况**

A发送分组M1，发送完后就暂停发送，等待B的确认。B收到M1就向A发送确认，A收到了对M1的确认后就发送M2，同样在收到B对M2的确认后再发送M3。

**2 出现差错**

B收到M1时检测出来差错就丢弃M1，其他什么也不做（不通知A收到差错分组），也可能是在传输过程中丢失了。这两种情况下B都不会发送任何信息，A只要超过了一段时间仍然没有收到确认，就认为之前发送的分组丢失了，因而重传前面发送的分组，这就叫超时重传。因此要在每发送完一个分组时设置一个超时计时器，如果在计时器到期前收到确认就撤销计时器。

需要注意三点：

（1）A发送完分组后，必须暂时保留已发送分组的副本。只有收到确认后才清除。

（2）分组和确认分组都必须进行编号。

（3）超时计时器设置的重传时间应当比数据在分组传输的平均往返时间更长一些。如果设置的太长就会降低通信效率，如果太短就会导致不必要的重传。

**3 确认丢失和确认迟到**

假定B发送的确认丢失了，A在设定超时重传时间内没收到确认，重传了M1，假定B又收到了重传分组，此时B应采取两个行动。第一，丢弃重复分组M1，不向上层交付。第二，向A发送确认。

当B的确认迟到时，A会收到重复的确认。对此的处理很简单，A收下后就丢弃。B仍然会收到重复的分组M1，并且同样要丢弃掉重复分组，并重传确认分组。

通常A最终总是可以收到对发出所有分组的确认，如果A不断重传分组但总是收不到确认，说明通信线路太差，不能通信。

使用上述的确认和重传机制就可以在不可靠的传输网络实现可靠通信。上述的这种可靠传输协议常称为自动重传请求ARQ，意思是重传的请求是自动进行的。接收方不需要请求发送方重传某个出错的分组。

**4 信道利用率**

停止等待协议的优点是简单，确点是信道利用率太低。

信道利用率U=TD/（TD+RTT+TA）

RTT：往返时间  TD:A发送分组的时间 TA :B发送确认分组时间。

当RTT远大于分组发送时间时，信道利用率会非常低。为提高传输效率，发送方可以不使用低效率的停止等待协议，而采用流水线传输，流水线传输就是发送方可连续发送多个分组，不必发送完每个分组就停顿下来等待确认。当使用流水线传输时，就要使用连续ARQ协议和滑动窗口协议。

---

**连续ARQ协议**

连续ARQ协议规定，发送方每收到一个确认，就把发送窗口向前滑动一个分组的位置。

接收方一般都是采用累积确认的方式，接收方不必对收到的分组逐个发送确认，而是在收到几个分组后，对按序到达的最后一个分组发送确认，这就表示，到这个分组为止的所有分组都已经正确收到了。

累积确认的优点：容易实现，即使确认丢失也不必重传。缺点：不能向发送方反映出接收方已经正确收到的所有分组信息。

例如发送方发送了前5个分组，而第3个分组丢失了。这时接收方只能对前2个分组进行确认，发送方无法知道后面3个分组的下落，只好把后面3个分组再重传一次。这就叫做回退N，表示需要再退回来重传已发送的N个分组。因此通信线路质量不好时，连续ARQ协议会带来负面影响。

---

### TCP报文段的首部格式

TCP虽然面向字节流，但传送的数据单元是报文段。一个TCP报文段分为首部和数据两部分。

TCP报文段首部20字节是固定的，后面有4n字节是根据需要而增加的选项，因此TCP首部的最小长度是20字节。

首部固定部分各字段意义如下：

（1）源端口和目的端口 各占2字节，分别写入源端口号和目的端口号，TCP的分用和UDP相似，也是通过端口实现。

（2）序号 4字节，范围是[0，232-1]。在一个TCP连接中传送的字节流中的每一个字节都按顺序编号，整个要传送的字节流的起始序号必须在连接建立时设置。首部中的序号字段值则是本报文段所发送的数据的第一个字节的序号。这个字段的名称也叫报文段序号。

（3）确认号 4字节，是指期望收到对方下一个报文段的第一个数据字节的序号。若确认号=N，表明到序号N-1为止的所有数据都已正确收到。一般情况下可保证当序号重复使用时旧序号的数据早已通过网络到达终点了。

（4）数据偏移 4位，指出TCP报文段的数据起始处距离TCP报文段的起始处有多远。

（5）保留 6位，目前置为0。

（6）紧急URG 值为1时，表明有效。当URG置1时，发送应用进程就告诉发送方的TCP有紧急数据要传送，于是发送方TCP就把紧急数据插入到本报文段数据的最前面，而在紧急数据后面的数据仍是普通数据。这时要与首部中紧急指针字段配合使用。

（7）确认ACK 仅当ACK=1时确认字段才有效。TCP规定在连接建立后所有传送的报文字段都必须把ACK置1。

（8）推送PSH 当两个应用进程进行交互式通信时，有时在一端的应用进程希望在键入一个命令后立即就能够收到对方的响应，这种情况下TCP就可以使用推送操作。

（9）复位RST 当RST=1时，表明TCP连接中出现严重差错，必须释放连接，然后再重新建立运输连接。RST置1还用来拒绝一个非法的报文段或拒绝打开一个连接。

（10）同步SYN 在连接建立时用来同步序号。当SYN=1而ACK=0时，表明这是一个连接请求报文段。对方若同意建立连接，则在响应的报文段中使SYN=1和ACK=1。因此SYN=1表示这是一个连接请求或连接接受报文。

（11）终止FIN 用来释放一个连接，当FIN=1时，表明此报文段的发送方的数据已发送完毕，并要求释放运输连接。

（12）窗口 2字节，值为[0，216-1]之间的整数，指的是发送本报文段的一方的接收窗口。窗口值告诉对方，从本报文段首部中的确认号算起，接收方目前允许对方发送的数据量。

（13）检验和 2字节，检验的范围包括首部和数据两部分。计算检验和时要在TCP报文段的前面加上12个字节的伪首部。

（14）紧急指针 2字节，仅在URG=1时才有效，指出本报文段中的紧急数据字节数。

（15）选项 长度可变，最长40字节。TCP起初只规定了一种选项，最大报文段长度MSS（数据字段的最大长度）。默认值536字节，为提高网络利用率。

5.6 TCP可靠传输的实现

TCP的滑动窗口是以字节为单位的。发送窗口里的序号表示允许发送的序号，显然窗口越大，发送方就可以在收到对方确认之前连续发送更多的数据，提高传输效率。发送窗口的大小不能超过对方的接收窗口大小。

发送窗口的后沿部分表示已发送并且收到确认的序号，前沿部分表示不允许发送的序号。发送窗口后沿的变化情况有两种，不动（没有收到新的确认）和前移（收到了新的确认）。发送窗口的前沿通常不断向前移动，但也可能不动或向后收缩。

### TCP的流量控制

所谓流量控制，就是让发送方的发送速率不要太快，要让接收方来得及接收。

发送方的发送窗口不能超过接收方给出的接收窗口的数值。TCP窗口的单位是字节，不是报文段。

B向A发送的接收窗口大小报文可能丢失，A一直等待B发送的非零窗口通知，B也在一直等待A发送的数据，如果没有其他措施，可能会形成死锁。

为了解决这个问题，TCP为每一个连接设有一个持续计时器，只要TCP连接的一方收到对方的零窗口通知，就启动持续计时器，若持续计时器的时间到了，就发送一个零窗口探测报文段（仅携带1字节数据），而对方就在确认这个探测报文段时给出了现在的窗口值。如果窗口仍然是0，那么收到这个报文段的一方就重新设置持续计时器。如果窗口不是0，那么死锁的僵局就打破了。

应用进程把数据发送到TCP的发送缓存后，剩下的发送任务就交给TCP来控制了。可以用不同的机制来控制TCP报文段的发送时机，例如第一种机制是TCP维持一个变量，它等于最大报文段长度MSS，只要缓存中数据到达此长度就组成一个TCP报文段发送出去。第二种机制是由发送方的应用进程指明要求发送报文段，即TCP支持的推送操作。第三种机制是发送方的一个计时器时限到了，这就把当前已有的缓存数据装入报文段（长度不超过MSS）发送出去。

5.8 TCP的拥塞控制

拥塞控制的一般原理

某段时间内，若对网络中某一资源的需求超过了该资源所能提供的可用部分，网络的性能就要变坏。这种情况就叫做拥塞。

网络拥塞的原因很多。例如某个结点缓存的容量太小，到达该结点的分组因无存储空间暂存而不得不丢弃。假设将该结点缓存的容量扩展到非常大，于是凡到达该结点的分组均可在结点的缓存队列中排队，不受任何限制。由于输出链路的容量和处理机的速度并未提高，因此队列中的绝大多数分组的排队等待时间将会大大增加，结果上层软件只好把它们重传（超时）。因此简单扩大缓存空间不能解决网络拥塞。

拥塞常常趋于恶化，拥塞引起的重传不会缓解网络拥塞，反而会加剧。

拥塞控制就是防止过多的的数据注入到网络，这样可以使网络中的路由器或链路不致过载。拥塞控制要做的都有一个前提，就是网络能够承受现有的网络载荷。拥塞控制是一个全局性过程，涉及到所有主机，所有的路由器，以及与降低网络传输性能有关的所有因素。TCP连接的端点只要迟迟不能收到对方的确认信息，就猜想当前网络的某处可能发生了拥塞，但发生的地点和原因不从得知。

相反，流量控制是指点对点通信的控制，是个端到端的问题（接收端控制发送端）。流量控制所要做的就是抑制发送端发送数据的速率以便接收端来得及接收。

理想情况下，随着输入负载（单位时间内输入给网络的分组数目）或网络负载的增大，吞吐量应等于提供的负载，当吞吐量饱和时，理想拥塞控制的情况下，吞吐量仍然可以维持最大值。但实际上随着负载增大，网络吞吐量的增长速率逐渐减小，当网络的吞吐量明显小于理想吞吐量时，网络就进入了轻度拥塞的状态。当提供负载到达某一数值时，网络的吞吐量反而随着负载的增大而下降，这时网络就进入了拥塞状态。当负载继续增大时，网络的吞吐量就下降到0，网络无法工作，这就是所谓的死锁。

拥塞控制是一个动态的问题，从大的方面可以将拥塞控制分为开环控制和闭环控制两种方法。开环控制就是在设计网络时事先将有关发生拥塞的因素考虑周到，力求网络工作时不产生拥塞，但系统一旦运行就不在途中进行改正了。

闭环控制是基于反馈环路的概念，主要措施：

（1）监测网络系统以便检测到拥塞在何时、何处发生

（2）把拥塞发生的信息传送到可采取行动的地方

（3）调制网络系统的运行以解决出现的问题

---

TCP拥塞控制的算法有四种：（1）慢开始（2）拥塞避免（3）快重传（4）快恢复。

所谓慢开始，就是基于窗口的拥塞控制，发送端设有一个拥塞窗口，拥塞窗口取决于网络的拥塞程度，发送窗口就等于拥塞窗口，初始时为了防止注入过多的数据引起网络拥塞，所以将拥塞窗口值设为1，然后逐渐增大拥塞窗口，逐渐增大发送窗口，每经过一次传输轮次，拥塞窗口就加倍。有一个慢开始门限，当小于该值时就使用慢开始，等于时既可以使用慢开始也可以使用拥塞避免，大于该值时使用拥塞避免。

拥塞避免就是每经过一个往返时间RRT将拥塞窗口的值增加1，而不是像慢开始那样加倍地增大拥塞窗口。慢开始不是指窗口增大的速度慢，而是在TCP开始发生报文时先设置拥塞窗口为1，使发送方开始只发送一个报文段，相比一下将许多报文注入到网络慢。

但是有时候个报文段丢失，而网络中并没有出现拥塞，错误地导致慢开始，降低了传输效率。这时应该使用快重传来让发送方尽早知道出现了个别分组的丢失，快重传要求接收端不要等待自己发送数据时再捎带确认，而是要立即发送确认。即使收到了乱序的报文段后也要立即发出对已收到报文段的重复确认。当发送端连续收到三个重复的确认后就知道出现了报文段丢失的情况，就会立即重传，快重传可以使整个网络的吞吐量提升约20%。

当发送方知道了只是丢失了个别报文段使，不会使用慢开始，而是使用快恢复来设置阻塞窗口的值，并开始执行拥塞避免算法。

---

###  TCP的运输连接管理

运输连接有三个阶段：连接建立、数据传送、连接释放

TCP连接建立中要解决以下三个问题：

（1）要使每一方能够确知对方的存在

（2）要允许双方协商一些参数

（3）能够对运输实体资源进行分配

TCP连接的建立采用客户服务器方式，主动发起连接建立的应用进程叫做客户，而被动等待连接建立的应用进程叫做服务器。

---

TCP建立连接的过程叫做握手，握手需要在客户和服务器之间交换三个TCP报文段。

最初两端的TCP进程都处于CLOSED状态，假设A主动打开连接，B被动打开连接。

一开始B的TCP服务器进程先创建传输控制块TCB，准备接收客户进程的连接请求。然后服务器进程就处于LISTEN状态，等待客户的连接请求。如有则立即响应。

A的TCP客户进程也是首先创建传输控制块TCB，然后打算建立TCP连接时，先向B发出连接请求报文段，SYN=1，同时选择一个初始序号seq=x。TCP规定SYN报文段不能携带数据，但要消耗掉一个序号，这时TCP客户进程进入SYN-SENT（同步已发送）状态。

B收到连接请求报文段后，如同意建立连接则向A确认。在确认报文段应把SYN和ACK位都置1，确认号是ack+1，同时也为自己选择一个初始序号seq=y。这个报文段也不能携带数据，但同样要消耗一个序号。这时TCP服务器进程进入SYN-RCVD（同步收到）状态。

TCP客户进程收到B的确认后，还要向B给出确认。确认段ACK=1，确认号ack=y+1，而自己的序号seq=x+1。TCP规定ACK的报文段可以携带数据，如果不携带数据则不消耗序号，这种情况下下一个报文段的序号仍是seq=x+1，这时TCP连接已建立，A进入ESTABLISHED（已建立连接）状态。

B收到A的确认后，也进入ESTABLISHED状态。

为什么A要发送一次确认呢，主要是为了防止已失效的连接请求报文段突然又传送到了B，因而产生错误。假设A发出的连接请求报文在网络某些结点滞留了，以至于连接释放后的某个时间才到达B。本来这是失效报文段，但B收到后误认为是A发出的新连接请求，就发出确认。假设不采取报文握手，只要B发出确认，连接就建立了，由于A并没有发出请求因此不会理睬B，但B误认为连接已建立会一直等待A发送数据，白白浪费B中的资源。

---

**TCP的连接释放**

A和B都处于ESTABLISHED状态，A的应用进程先向其TCP发出释放连接报文段，并停止再发送数据，主动关闭TCP连接。A把连接释放报文段首部的终止控制位FIN置1，seq=u，它等于前面已传送的最后一个字节的序号加1。这时A进入FIN-WAIT-1（终止等待1）的状态，等待B的确认。FIN报文段不携带数据也要消耗掉一个序号。

B收到连接释放报文段后发出确认，确认号是ack=u+1，而这个报文段自己的序号是v，等于前面B已传送的最后一个字节的序号加1。然后B就进入CLOSE-WAIT（关闭等待）状态。这时A到B这个方向的连接就释放了，这时TCP的连接处于半关闭状态，即A已经没有数据要发送了，但若B发送数据，A仍要接受。

A收到来自B的确认后，就进入FIN-WAIT-2（终止等待2）状态，等待B发出的连接释放请求报文。若B已经没有要向A发送的数据，其应用进程就通知TCP释放连接，这时B发出的连接释放报文段必须使FIN=1。假定B的序号为w（半关闭状态时B可能又发送了一些数据）。B还必须重复上次已发送过的确认号ack=u+1，这时B就进入了LAST-ACK（最后确认）状态。

A收到B的连接释放报文段后必须对此确认，在确认报文段中把ACK置1，确认号ack=w+1，自己的序号是u+1（前面发送的FIN报文消耗一个序号）。然后进入TIME-WAIT状态。必须经过时间等待计时器设置的时间2MSL后，A才能进入到CLOSED状态。MSL叫做最长报文段寿命。

A必须等待2MSL时间的理由：

（1）为了保证A发送的最后一个ACK报文段能够到达B。这个ACK报文段有可能丢失，B会超时重传这个FIN+ACK报文段，而A就能在2MSL时间内收到这个报文段，接着A再重传一次确认，重新启动2MSL计时器。最后AB都正常进入到CLOSED状态。如果A不等待一段时间就收不到B重传的报文段，也不会再发送一次确认报文段，B就无法按照正常步骤进入CLOSED状态。

（2）为了防止前述的“已失效连接请求报文段”出现在本连接中。

TCP还设有保活计时器，服务器每收到一次客户的数据就重新设置保活计时器，时间的设置通常是2小时，若2小时内没有收到客户的数据，就发送一个探测报文段，以后每隔75秒发送一次，如果连续10个探测报文段后仍无客户的响应，服务器就认为客户端出了故障，关闭连接。

---

###  本章的重要概念

运输层提供应用进程间的逻辑通信，运输层的通信并不是真正在两个运输层之间直接传送数据。运输层向应用层屏蔽了下面的网络细节（网络拓扑、路由选择协议等），它使应用进程看见的就好像在两个运输层实体之间有一条端到端的逻辑通信线路。

网络层为主机之间提供逻辑通信，而运输层为应用进程之间提供端到端的逻辑通信。

运输层有两个主要的协议：TCP和UDP。它们都有复用和分用，以及检错的功能。当运输层采用TCP协议时，尽管下面的网络是不可靠的，但这种逻辑通信信道就相当于一条全双工通信的可靠信道。当运输层采用UDP协议时，这种逻辑通信信道仍然是一条不可靠信道。

运输层用一个16位端口号来标志一个端口，端口号具有本地意义，它只是为了标志本计算机应用层中的各个进程在和运输层交互时的层间接口。在互联网的不同计算机中，相同的端口号没有关联。

两台计算机中的进程要互相通信，不仅要知道对方IP地址，还要知道对方的端口号。

运输层的端口号分为服务器端端口号（0-1023指派给数值端口，1024-49151是登记端口号）和客户端暂时使用的端口号（49152-65535）。

UDP的主要特点：（1）无连接（2）尽最大努力交付（3）面向报文（4）无拥塞控制（5）支持一对一、一对多、多对一和多对多的交互通信（6）首部开销小（只有源端口、目的端口、长度、检验和）。

TCP的主要特点：（1）面向连接（2）每一条TCP连接只能是点对点的（3）提供可靠的交付服务（4）提供全双工通信（5）面向字节流

TCP用主机的IP地址加上主机的端口号作为TCP连接的端点，这样的端点叫做套接字或插口。套接字用（IP地址：端口号）来表示。

停止等待协议能够在不可靠的传输网络实现可靠通信。每发完一个分组就停止发送，等待对方的确认。在收到确认后再发送下一个分组，分组需要编号。

超时重传是只要超过了一段时间仍然没有收到确认，就重传前面发送过的分组。因此每发送完一个分组需要设置一个超时计时器，其重传时间应比数据在分组传输中的平均往返时间更长一些。这种自动重传方式常称为自动重传请求ARQ。

在停止等待协议中，若接收方收到重复分组，就丢弃该分组，但同时还要发送确认。

连续ARQ协议可提高信道利用率，发送方维持一个发送窗口，凡位于发送窗口内部的分组都可以连续发送，而不需要等待确认。接收方一般采用累积确认，对按序到达的最后一个分组发送确认，表明到这个分组为止的所有分组都已正确收到了。

TCP报文段首部的前20个字节是固定的，后面有4N字节是根据需要而增加的选项（N是整数）。在一个TCP连接中传送的字节流中的每一个字节都按顺序编号。首部中的序号字段值指的是本报文段发送的数据的第一个字节的序号。

TCP首部中的确认号是期望收到对方下一个报文段的第一个数据字节的序号，若确认号位N，则表明到序号N-1为止的所有数据都已正确收到。

TCP首部中窗口的字段指出了现在允许对方发送的数据量，窗口是动态变化的。

TCP使用窗口滑动机制，发送窗口里的序号表示允许发送的序号，发送窗口后沿的部分表示已发送并且收到确认的，前沿的前面部分表示不允许发送。发送窗口后沿的变化情况有两种，即不动（没有收到新的确认）和前移（收到了新的确认）。发送窗口前沿通常是不断向前移动的。

流量控制就是让发送方的速率不要太快，要让接收方来得及接收。

某段时间，若对网络中某一资源的需求超过了该资源所能提供的可用部分，网络的性能就要变坏。这种情况叫做拥塞。拥塞控制就是防止过多的数据注入到网络，这样可使网络中的路由器或链路不至于过载。

流量控制是一个端到端的问题，使接收端抑制发送端发送数据的速率，以便使接收端来得及接收。拥塞控制是一个全局性的过程，涉及到所有的主机、所有的路由器，以及与降低网络传输性能有关的所有因素。

为了进行拥塞控制，TCP的发送方要维持一个拥塞窗口cwnd的状态变量。拥塞窗口的大小取决于网络的拥塞程度，并且动态变化。发送方让自己的发送窗口取为拥塞窗口和接收方的接收窗口中较小的一个。

TCP的拥塞控制采取了四种算法，即慢开始、拥塞避免、快重传和快恢复。在网络层也可以使路由器采用适当的分组丢弃策略（如主动队列管理AQM），以减小网络拥塞的发生。

运输连接有三个阶段：连接建立、数据传送、连接释放。

主动发起TCP连接请求的应用进程叫客户，而被动等待连接建立的应用进程叫服务器。TCP的连接建立采用三报文握手机制，服务器要确认客户连接请求，然后客户要对服务器的确认进行确认。

TCP连接的释放采用四报文握手机制，任何一方都可以在数据传送结束后发出连接释放的通知，待对方确认后就进入半关闭状态。当另一方也没有数据再发送时，则发送连接释放通知，对方确认后就完全关闭了TCP连接。

---

## HTTP

### 特点

HTTP是超文本传输协议，规范了浏览器如何向万维网服务器请求万维网文档，服务器如何向浏览器发送万维网文档。从层次的角度看，HTTP是面向事务的应用层协议，是浏览器和服务器之间的传送数据文件的重要基础。

HTTP是无状态的，之所以说无状态是因为HTTP对事务没有记忆性。同一个客户第二次访问同一个服务器，服务器的响应结果和第一次是一样的。HTTP的无状态简化了服务器的设计，允许服务器支持高并发的HTTP请求。如果要解决无状态的问题，可以使用cookie和session。Cookie相当于服务器给浏览器的一个通行证，是一个唯一识别码，服务器发送的响应报文包含 Set-Cookie 首部字段，客户端得到响应报文后把 Cookie 内容保存到浏览器中。客户端之后对同一个服务器发送请求时，会从浏览器中取出 Cookie 信息并通过 Cookie 请求首部字段发送给服务器，服务器就可以识别是否是同一个客户。Session是服务器的会话技术，是存储在服务器的。区别：①Cookie只能存储ASCII 码字符串，而 Session 则可以存储任何类型的数据，因此在考虑数据复杂性时首选Session。②Cookie 存储在浏览器中，容易被恶意查看。如果非要将一些隐私数据存在 Cookie 中，可以将 Cookie 值进行加密，然后在服务器进行解密。③对于大型网站，如果用户所有的信息都存储在 Session 中，那么开销是非常大的，因此不建议将所有的用户信息都存储到 Session 中。 

---

### 结构

HTTP报文分为HTTP请求报文和响应报文，请求报文由请求行（请求方法，请求资源的URL和HTTP的版本）、首部行和实体（通常不用）组成。响应报文由状态行（状态码，短语和HTTP版本）、首部行和实体（有些不用）组成。

### 方法

GET：主要同于获取资源，用于访问被URI统一资源标识符识别的资源。

POST：主要用于传递信息给服务器。

参数：GET和POST的请求都能使用额外的参数，但是 GET 的参数是以查询字符串出现在 URL 中，而POST的参数存储在实体主体中。不能因为 POST 参数存储在实体主体中就认为它的安全性更高，因为照样可以通过一些抓包工具查看。

安全性：安全的HTTP方法不会改变服务器状态，也就是说它只是可读的。GET方法是安全的，而POST却不是，因为 POST 的目的是传送实体主体内容，这个内容可能是用户上传的表单数据，上传成功之后，服务器可能把这个数据存储到数据库中，因此状态也就发生了改变。 

发送数据：XMLHttpRequest是一个 API，在Ajax中大量使用。它为客户端提供了在客户端和服务器之间传输数据的功能。它提供了一个通过URL 来获取数据的简单方式，并且不会使整个页面刷新。这使得网页只更新一部分页面而不会打扰到用户。 

使用XMLHttpRequest时，GET请求发送一个TCP数据包，浏览器同时发送HTTP header和data，服务器响应状态码200。POST每次发送两个TCP数据包，浏览器先发送HTTP header，服务器收到后返回100（continue），浏览器再继续发送data，服务器响应200。

PUT 上传文件 DELETE 删除文件 OPTIONS 查看当前URL支持的HTTP方法 HEAD 获取首部

---

### 流程

①先检查输入的URL是否合法，然后查询浏览器的缓存，如果有则直接显示。

②通过DNS域名解析服务解析IP地址，先从浏览器缓存查询、然后是操作系统和hosts文件的缓存，如果没有查询本地服务器的缓存。

③通过TCP的三次握手机制建立连接，建立连接后向服务器发送HTTP请求，请求数据包。

④服务器收到浏览器的请求后，进行处理并响应。

⑤浏览器收到服务器数据后，如果可以就存入缓存。

⑥浏览器发送请求内嵌在HTML中的资源，例如css、js、图片和视频等，如果是未知类型会弹出对话框。

⑦浏览器渲染页面并呈现给用户。

---

### HTTP1.1

HTTP1.0使用的是非持续连接，每次请求文档就有2倍的RTT开销，另外客户和服务器每一次建立新的TCP连接都要分配缓存和变量，这种非持续连接会给服务器造成很大的压力。

HTTP1.1使用的是持续连接，服务器会在发送响应后在一段时间内继续保持这条连接，使同一个浏览器和服务器可以继续在这条连接上传输后续的HTTP请求和响应报文。HTTP1.1的持续连接有两种工作方式，非流水线和流水线方式。非流水线方式就是客户在收到前一个响应后才能发送下一个请求，流水线方式是客户收到响应前就能连着发送新的请求。

---

### HPPTS

HTTP有很大的安全隐患：使用明文进行通信，内容可能会被窃听。不验证通信方的身份，通信方的身份有可能遭遇伪装。无法证明报文的完整性，报文有可能遭篡改。 

HTTPS是以安全为目标的HTTP通道，S代表security，让HTTP先和SSL通信，再由SSL和TCP 通信，也就是说 HTTPS使用了隧道进行通信。通过使用 SSL，HTTPS 具有了加密（防窃听）、认证（防伪装）和完整性保护（防篡改）。

**流程**

加密算法主要有对称加密和非对称加密，对称加密的运算速度快，但安全性不高。非对称密钥加密，加密和解密使用不同的密钥。公开密钥所有人都可以获得，通信发送方获得接收方的公开密钥之后，就可以使用公开密钥进行加密，接收方收到通信内容后使用私有密钥解密。 

非对称密钥除了用来加密，还可以用来进行签名。因为私有密钥无法被其他人获取，因此通信发送方使用其私有密钥进行签名，通信接收方使用发送方的公开密钥对签名进行解密，就能判断这个签名是否正确。非对称加密的运算速度慢，但是更安全。HTTPS采用混合的加密机制，使用非对称密钥加密用于传输对称密钥来保证传输过程的安全性，之后使用对称密钥加密进行通信来保证通信过程的效率。

①浏览器和服务器建立TCP连接后，会发送一个证书请求，其中包含了自己可以实现的算法列表和一些必要信息，用于商议双方使用的加密算法。

②服务器收到请求后会选择加密算法，然后返回证书，包含了服务器的信息，域名、申请证书的公司、加密的公钥以及加密的算法等。

③浏览器收到之后，检查签发该证书的机构是否正确，该机构的公钥签名是否有效，如果有效就生成对称密钥，并利用公钥对其加密，然后发送给服务器。

④服务器收到密钥后，利用自己的私钥解密。之后浏览器和服务器就可以基于对称加密对数据进行加密和通信。

---

## WEB安全

### 概述

计算机网络面临的威胁主要有被动攻击和主动攻击。

**被动攻击**指攻击者从网络上窃听他人的通信内容，也叫截获。在被动攻击中，攻击者只是观察和分析某一协议数据单元PDU而不干扰信息流。攻击者可以通过观察PDU的协议控制信息部分，了解正在通信的协议的地址和身份，通过研究PDU的长度和发送频度，了解所交换的数据的某种性质。这种攻击又叫做流量分析。

**主动攻击**包括：

①篡改：攻击者故意篡改网络上传输的报文，包括彻底中断传送的报文，甚至把完全伪造的报文发给接收端，这种攻击方式也叫做更改报文流。

②恶意程序：计算机病毒，能够传染其他程序的程序，主要通过修改其他程序来把自身或自身的变种复制进去完成。计算机蠕虫，通过网络通信能把自己从一个结点发往另一个节点并且自动启动运行的程序。特洛伊木马，它执行的功能并非声称的功能而是恶意程序，例如一个编译程序除了完成编译任务外还偷偷地复制源程序。逻辑炸弹，当运行环境满足某种特殊条件时就会执行特殊功能的程序，例如当日期为22号且为周三的时候就会删除所有文件。后门入侵，指利用系统实现中的漏洞通过网络入侵系统。流氓软件，一种未经用户同意就在用户计算机上安装并损害用户利益的软件。

③拒绝服务DoS：攻击者向互联网上某个服务器不停地发送大量分组，使其无法提供正常服务甚至完全瘫痪。如果从互联网成百上千的网站一起攻击一个网站就叫做分布式拒绝服务DDoS，有时也叫网络宽带攻击。

④ARP欺骗：在使用以太网交换机的网络中，攻击者向某个以太网交换机发送大量的伪造源MAC的地址，以太网交换机收到这样的帧就把虚假的MAC源地址填入到交换表中，由于伪造的数量很大很快就填满了表，导致以太网交换机无法正常工作。

对于主动攻击可以采取适当的措施检测，对于被动攻击通常是检测不出来的。根据这些特点，得出计算机网络安全的主要目标如下：①防止报文内容分析和流量分析。②防止恶意程序。③防止更改报文流和拒绝服务。

---

**安全的计算机网络有4个目标**

①保密性，只有信息的发送方和接收方看得懂信息，这是最基本的要求，需要利用密码技术实现。②端点鉴别，鉴别信息的发送方和接收方的真实身份，对于主动攻击非常重要。③信息完整性，确保信息的内容没有被篡改过，和端点鉴别密不可分。④运行安全性，通过访问控制来控制权限，规定每个用户的访问权限。

---

### 密码体制

**对称密码密钥体制**

加密密钥和解密密钥使用相同的密码体制，例如数据加密标准DES，保密性取决于对密钥的保密，而算法是公开的。在DES之后提出了高级加密标准AES来取代DES。

**公钥密码体制**

又叫公开密钥密码体制，加密和解密使用不同的密钥。产生的主要原因是对称密码密钥体制的密钥分配问题，如果事先约定密钥，就会给密钥的管理和分配带来很大的不便。另一个原因是对于数字签名的需要，许多应用中人们需要通过对纯数字的电子信息签名，表明该信息是由某个特定的人产生的。

---

### 数字签名

确保实现以下功能：①报文鉴别，接收者能够核实发送者的身份。②报文的完整性，接收者可以确信收到的报文没有被人篡改过。③不可否认，发送方事后不能抵赖对报文的签名。

---

### 鉴别

**报文鉴别**

鉴别所收到的报文的确是报文发送者自己发送的，而不是其他人伪造或篡改的，包含了端点鉴别和报文完整性的鉴别，通过密码散列函数如MD5、SHA-1，报文鉴别码等实现。

**实体鉴别**

仅鉴别发送报文的实体，可以是一个人也可以是进程和服务器，这就是端点鉴别。报文鉴别需要对每一个报文进行鉴别，实体鉴别是在系统接入的全部时间内对和自己通信的对方实体验证一次。

---

### 网络层安全协议

IPsec，不是一个单独的协议而是IP层提供网络通信安全的协议族，没有限定用户使用哪种加密和鉴别算法，是一个框架，允许通信双方选择合适的算法和参数，为保证互操作性，实现了一套加密算法。

可以划分为三部分：①IP数据报格式的2个协议，鉴别首部AH和封装安全有效载荷ESP。AH可以提供源点鉴别和数据完整性，但是不能保密，而ESP三者皆可。②有关算法的协议。③互联网密钥交换协议IKE。使用AH或ESP的数据报又叫IP安全数据报，有两种工作方式：运输方式，在整个运输层的报文段前后加上若干控制信息，再加上IP首部构成IP安全数据报。隧道形式，在原始IP数据报的前后添加若干控制信息，再加上新的IP首部构成一个IP安全数据报。

---

### 运输层安全协议

SSL安全套接字层/TLS 运输层安全

SSL是Netscape开发的安全协议，广泛用于基于万维网的各种网络应用，SSL作用于端系统的应用层HTTP和运输层之间，在TCP之上建立一个安全的连接通道，为TCP传输的数据提供安全保障。SSL的服务：①SSL服务器鉴别，允许用户鉴别服务器的身份，支持SSL客户端通过验证服务器证书，鉴别服务器身份并获取公钥。②SSL客户鉴别，SSL可选的安全服务，允许服务器证实客户身份。③加密的SSL会话，对客户和服务器发送的所有报文进行加密，并检测报文是否被篡改。

---

### 防火墙与入侵检测

恶意用户或软件通过网络利用系统的漏洞进行入侵，包括病毒、木马、DoS等。之前讨论的所有安全机制都不能有效的解决这些问题。

**防火墙**

一种访问控制技术，严格控制进出网络的分组，禁止任何不必要的通信，从而减少潜在侵入的发生。防火墙是一种特殊编程的路由器，安装在一个网点和网络中的其余部分之间，目的是实施访问控制策略。策略是由防火墙单位自行制定的，一般防火墙内的网络叫做可信任网络，防火墙之外的网络叫做不可信网络。防火墙的主要技术分为分组过滤和应用网关。

**入侵检测IDS**

防火墙应用于入侵发生前，但防火墙不可能组织所有入侵，所以需要第二道防线也就是入侵检测，应用于入侵发生时。①基于特征的入侵检测，维持一个已知攻击特征的数据库，每个特征是一个于某种入侵活动相关联的规则集，缺点是只能检测已知攻击，对未知攻击束手无策。②基于异常的入侵检测，通过观察正常运行的网络流量，学习正常流量的统计特性和规律，当检测到网络中的流量不合规律时就认为可能发生了入侵。

---



---

# 操作系统

### 进程

**概念**

多道程序环境下允许多个程序并发执行，进程就是为了更好地描述和控制程序的并发执行，实现操作系统的并发性和共享性。

进程就是进程实体的运行过程，是系统进行资源分配和调度的一个独立单位。系统资源指的是处理机、存储器和其他设备服务于某个进程的时间，例如把处理机资源理解为处理机的时间片才是准确的。因为进程是这些资源分配和调度的独立单位，这就决定了进程一定是一个动态的、过程性的概念。

---

**结构**

①进程控制块PCB：进程实体的一部分，进程存在的唯一标识，包括进程描述信息、控制和管理信息、资源分配清单和处理机相关信息。

②程序段：就被进程调度程序调度到CPU执行的程序代码段。

③数据段：进程对应的程序加工处理的原始数据，也可以是程序执行时产生的中间或最终结果。

---

**特征**

①动态性 进程是一次程序的执行，具有一定的生命周期，是动态地产生、变化和消亡的。动态性是进程最基本的特征。

②并发性 指多个进程同时存在于内存中，能在一段时间内同时运行。并发性是进程的重要特征，也是操作系统的重要特征。进入进程的目的就是为了使程序能与其他进程的程序并发执行，提高资源利用率。

③独立性 指进程实体是一个能独立运行、独立获得自由和独立接受调度的基本单位。

④异步性 由于进程的相互制约，会使进程具有执行的间断性，即进程按各自独立的，不可预知的速度向前推进。

⑤结构性 每个进程都配置有一个进程控制块PCB对其进行描述，从结构上看进程实体是由程序段、数据段和PCB组成的。

---

**进程的状态和转换**

①运行态 进程正在处理机上运行

②就绪态 进程已处于准备运行的状态，获得了除处理机外的一切资源

③阻塞态 进程正在等待某一事件而暂停运行，如等待某资源可用或等待输入/输出流

④创建态 进程正在被创建，尚未转到就绪态

⑤结束态 进程正从系统中消失，可能是正常结束或其他原因中断退出

就绪->运行：处于就绪状态的进程被调度后，获得处理机资源（分派处理机时间片）

运行->就绪：处于运行态的进程在时间片用完后，不得不让出处理机。在可剥夺的操作系统中，当有更高优先级的进程就绪时，调度程序将正在执行的进程转为就绪态，让更高优先级的进程执行。

运行->阻塞：进程请求某一资源的使用和分配或等待某事件的发生（如IO完成），进程以系统调用的形式请求操作系统提供服务。

阻塞->就绪：进程等待的事件到来时，如IO结束或中断结束时，中断处理程序必须把相应进程的状态由阻塞转为就绪态。

---

**进程控制**

进程控制的主要功能是对系统中的所有进程实施有效的管理，它具有创建新进程、撤销已有进程、实现进程状态转换等功能。

**进程的创建：**

允许一个进程创建另一个进程，创建者为父进程，被创建者为子进程。子进程可以继承父进程所拥有的资源，当子进程被撤销时，应将父进程的资源归还。撤销父进程时，必须同时撤销所有子进程。

**进程的创建过程：**

①为新进程分配一个唯一的进程标识号，并申请一个空白PCB。②为进程分配资源，为新进程的程序和数据分配必要内存空间。若资源不足不会创建失败而是进入阻塞态。③初始化PCB，包括标志信息，处理机状态信息，进程优先级等。④若进程就绪队列未满，就将新进程插入就绪队列等待被调度。

**进程的终止：**

正常结束，表示进程任务已经完成并准备退出运行。异常结束，表示进程在运行时发生了某种异常，使程序无法继续运行，例如非法指令，IO故障等。外界干预，指进程因为外界请求而终止，例如操作系统干预或父进程请求终止等。

**进程终止过程：**

①根据被终止进程的标识符，检索PCB，读出该进程的状态。②若处于执行状态，终止执行，将处理机资源分配给其他进程。③若进程还有子进程，应将所有子进程终止。④将该进程的全部资源归还给父进程或操作系统。⑤将PCB从所在队列删除。

**进程的阻塞过程：**

①找到将要被阻塞进程的PCB。②如果为运行态，保护现场转为阻塞态，停止运行。③把PCB插入相应事件的等待队列。

**进程的唤醒过程**：

①在该事件的等待队列中找到进程对应的PCB。②将其从等待队列中移除，设置状态为就绪态。③将PCB插入就绪队列，等待调度程序调度。

**进程的切换过程：**

①保存处理机上下文，包括程序计数器和其他寄存器。②更新PCB信息。③把进程的PCB移入相应的队列。④选择另一个进程执行并更新其PCB。⑤更新内存管理的数据结构。⑥恢复处理机上下文。

---

**进程通信**

①共享存储：在通信的进程之间存在一块可以直接访问的共享空间，共享存储分为两种：低级的共享基于数据结构，高级的共享基于存储区。操作系统只负责为通信进程提供可共享的存储空间和同步互斥工具，数据交换由用户自己安排读写指令完成。

②消息传递：进程间的数据交换以格式化的消息为单位，进程提供系统提供的发送消息和接收消息两个原语进行数据交换。消息传递分为：直接通信方式，把消息挂在接收进程的消息缓存队列上。间接通信方式，发送进程把消息发送到某个中间实体，中间实体一般称作信箱，相应的通信系统为电子邮件系统。

③管道通信：消息传递的一种特殊方式，管道就是连接一个读进程和一个写进程来实现它们通信的一个共享文件。管道可以理解为共享存储的优化和发展，管道通信中存储空间优化为缓冲区，缓冲区只允许一边写入另一边读出，只要缓冲区有数据进程就能从缓冲区读出，只要有数据写进程就不会往缓冲区写数据，因此管道通信是半双工通信。

---

### 线程

**概念**

引入进程的目的是为了多道程序更好的并发执行，提高资源利用率和吞吐量；引入线程的目的是为了减少程序在并发执行时的时空开销，提高操作系统的并发性能。

线程就是一种轻量级的进程，是一个基本的CPU执行单位，也是程序执行流的最小单元，由线程ID、程序计数器、寄存器集合和堆栈组成。线程是进程中的一个实体，是操作系统独立调度和分配的基本单位，线程自己不拥有系统资源，只拥有一点在运行中必不可少的资源，但它与同一进程下的其他线程共享进程的全部资源。

---

**线程和进程的区别**

①调度：进程是拥有资源的基本单位，而线程是独立调度的基本单位。在同一进程中，线程的切换不会引起进程的切换。在不同进程中线程的切换会引起进程切换。

②拥有资源：不管是传统操作系统还是有线程的操作系统，进程都是拥有资源的基本单位，而线程不拥有系统资源，只有一点运行中必不可少的资源。如果线程也是拥有资源的单位，那么切换线程就需要较大的时空开销，它的引入就没有意义。

③系统开销：创建和撤销进程设计资源的分配和回收，操作系统的开销远大于创建或撤销线程的开销。进程切换也需要涉及CPU环境的保存和新调度到进程CPU环境的设置，但线程切换只需要保存和设置少量的寄存器容量，开销很小。

④地址空间：进程的地址空间之间互相独立，同一进程的各个线程共享进程的资源，进程内的线程对其他进程不可见。

⑤通信：进程间通信需要同步和互斥手段的辅助，保证数据一致性。线程可以直接读写进程数据段（全局变量）来进行通信。

---

**线程的实现方式**

①用户级线程：有关线程管理的所有工作都由应用程序完成，内核意识不到线程的存在。

②内核级线程：线程管理的所有工作都由内核完成，应用程序没有进行线程管理的代码，只有一个到内核级线程的编程接口。

---

### 死锁

**定义**

死锁就是指多个进程因为互相竞争资源而陷入的一种僵局，如果没有外力的作用，这些进程都无法继续向前推进。

**原因**

死锁的原因包含了①不可剥夺资源数量的不足，如果是可剥夺资源是不会造成死锁的。②进程的推进顺序非法，进程请求和释放资源的顺序不当，例如进程P1和P2分别占用资源R1和R2，而此时P1和P2又分别申请资源R2和R1。③信号量的使用不当，彼此等待对方的消息。

死锁有四个必要条件：①互斥条件，进程对资源的占用具有排他性控制，如果进程请求的资源已被占用，请求就会被阻塞。②不可剥夺条件，当一个资源没有被使用完成前是不能被其他进程强行获取的，只有占用它的进程主动释放才可以。③请求和保持条件，一个进程已经占有了某个资源，又要请求其他资源，而该资源被其他进程占用，请求被阻塞，但进程也不会释放自己已经占有的资源。④循环等待条件，存在一个进程资源的循环等待链，链中每个进程已经占有的资源同时是其他进程请求的资源。

**预防**

事先预防，实现起来比较简单，但是条件严格，效率很低。

①破坏互斥条件，系统中的所有资源都允许共享，但是有的资源不能同时访问，不太现实。

②破坏不可剥夺条件，允许剥夺其他进程已经占有的资源，可能会造成前段工作的失效，如果频繁发送就会增加系统开销，严重降低系统的吞吐量。

③破坏请求和保持条件，采用预先资源分配法，一次性分配进程需要的所有资源，缺点是会严重浪费系统资源。

④破坏循环等待条件，采用顺序资源分配法， 确定是会造成编程不便。

**避免**

同样也是事先预防，不同的是动态地根据情况来避免死锁，性能比较好。

①系统安全状态，不安全的系统可能会导致死锁，安全的系统状态不会导致死锁，如果资源分配不会进入不安全的系统状态就给进程分配资源。

②银行家算法，把操作系统视为银行家，操作系统管理的资源视为资金，进程向操作系统申请资源相当于贷款。采用预先资源分配策略，主要的数据结构是可利用的资源向量，分配矩阵，需求矩阵，最大需求矩阵。

**检测**

画出资源分配图，圆圈表示进程，框表示一类资源。进程到资源是请求边，资源到进程是分配边。然后利用死锁定理来简化资源分配图，如果S不可被完全简化那么代表是一个死锁。

**解除**

如果没有采取死锁的预防和避免，就要采用死锁的检测和解除。

①资源剥夺法：挂起某些死锁进程并剥夺其资源。

②撤销进程法：撤销一个甚至全部死锁进程并剥夺其资源。

③进程回退法：让一个或多个进程回到不至于造成死锁的状态。

 

---

# 智力题

## 二进制问题

**金条问题**

有个商人雇用了一位手艺高超的工匠了为他做一个精致产品，工作一星期七天的代价是一条金条。商人手头上有一条金条，刚好有可以付工匠一星期的工钱。但工匠要求工钱要按每天来付。虽然他并不急着用钱，每天有钱进账，老人心里总是踏实一些。但商人家中有个规矩，金条每星期只能切二刀。后来商人想出以了个切割金条的办法，满足了工匠的要求。你知道商人是怎么切割金条才能满足工匠的吗？

解答：

```
切成1、2、4。这三个二进制数的组合能表示0-7中的任何一个。
```

-----

**老鼠和毒药**

实验室有100个瓶子，其中有一瓶装有慢性毒药（第3天发作)，另外99瓶装有蒸馏水。请问至少需要多少只小白鼠才能在3天内找出哪一瓶是慢性毒药？

解答：

```
利用二进制来做，最少的老鼠数量就是计算2的多少次方大于等于瓶子数量，例如本题为7。对100瓶进行二进制编码，这样可以排列出1xxxxxx，x1xxxxxx，...，xxxxxx1这样的七组序列，如果是1xxxxxx和x1xxxxx的老鼠死了，表示1100000有毒。
```



------

## 水桶问题

 **倒水问题1**

一个装了10L水的桶，一个7L的空桶，一个3L的空桶，怎样变成2个5L

 解答：

```
初始时为10，0，0。
第二步7，0，3。
然后7，3，0。
然后4，3，3。
然后4，6，0。
然后1，6，3。
然后1，7，2。
然后8，0，2。
然后8，2，0。
然后5，2，3。
然后5，5，0。
```

\-----

**倒水问题2**

如果你有无穷多的水，一个3夸脱的和一个5夸脱的提桶，你如何准确称出 4夸脱的水？

解答：

```
初始时0，5
然后3，2
然后0，2
然后2，0
然后2，5
然后3，4
```

----

**舀酒问题**

据说有人给酒肆的老板娘出了一个难题：此人明明知道店里只有两个舀酒的勺子，分别能舀7两和11两酒，却硬要老板娘卖给他2两酒。聪明的老板娘毫不含糊，用这两个勺子在酒缸里舀酒，并倒来倒去，居然量出了2两酒，聪明的你能做到吗？

解答：

```
初始0，11
然后7，4
然后0，4
然后4，0
然后4，11
然后7，8
然后0，8
然后7，1
然后0，1
```

```
然后1，11
然后7，5
然后0，5
然后5，0
然后5，11，
然后7，9
然后0，9
然后7，2
```

-----

## 钱问题

**赚钱问题**

一个人花8块钱买了一只鸡，9块钱卖掉了，然后他觉得不划算，花10块钱又买回来了，11块卖给另外一个人。问他赚了多少?

 解答：

```
-8+9-10+11=2
```

----

**假钱问题**

老王30买了双鞋，35卖，客人花100买，老王没零钱于是向老李换了100.补给客人后，客人走远后老李突然说是假钱，于是老王补偿给了老李，问老王一共亏了多少？

 解答：

```
卖鞋赚了35-30=5，假钱赔了100，一共亏95
```

-----

**取硬币问题**

30枚面值不全相同的硬币摆成一排，甲、乙两个人轮流选择这排硬币的其中一端，并取走最外边的那枚硬币。如果你先取硬币，能保证得到的钱不会比对手少吗？

解答：

```
先取者可以让自己总是取奇数位置上的硬币或者总是取偶数位置上的硬币。数一数是奇数位置上的面值总和多还是偶数位置上的面值总和多，然后总是取这些位置上的硬币就可以了。
```



----

 **旅馆问题**

有三个人去住旅馆，住三间房，每一间房$10元，于是他们一共付给老板$30，第二天，老板觉得三间房只需要$25元就够了于是叫小弟退回$5给三位客人，谁知小弟贪心,只退回每人$1，自己偷偷拿了$2，这样一来便等于那三位客人每人各花了九元，于是三个人一共花了$27，再加上小弟独吞了不$2，总共是$29。可是当初他们三个人一共付出$30那么还有$1呢？

解答：

```
他们所消费的27元里已经包括小弟贪污的2元了，再加退还的3元=30元。：这30元现在的分布是：老板拿25元，伙计拿2元，三人各拿1元，正好。
```



----

## 蓝眼问题

**蓝眼睛问题**

有个岛上住着一群人，有一天来了个游客，定了一条奇怪的规矩：所有蓝眼睛的人都必须尽快离开这个岛。每晚8点会有一个航班离岛。每个人都看得见别人眼睛的颜色，但不知道自己的（别人也不可以告知）。此外，他们不知道岛上到底有多少人是蓝眼睛的，只知道至少有一个人的眼睛是蓝色的。所有蓝眼睛的人要花几天才能离开这个岛？

 解答：

```
有多少个蓝眼睛的人就会花多少天。
c=1：
假设岛上所有人都是聪明的，蓝眼睛的人四处观察之后，发现没有人是蓝眼睛的。但他知道至少有一人是蓝眼睛的，于是就能推导出自己一定是蓝眼睛的。因此，他会搭乘当晚的飞机离开。 
c=2：
两个蓝眼睛的人看到对方，并不确定c是1还是2，但是由上一种情况，他们知道，如果c = 1，那个蓝眼睛的人第一晚就会离岛。因此，发现另一个蓝眼睛的人仍在岛上，他一定能推断出c = 2，也就意味着他自己也是蓝眼睛的。于是，两个蓝眼睛的人都会在第二晚离岛。 
c>2：
逐步提高c时，我们可以看出上述逻辑仍旧适用。如果c = 3，那么，这三个人会立即意识到有2到3人是蓝眼睛的。如果有两人是蓝眼睛的，那么这两人会在第二晚离岛。因此，如果过了第二晚另外两人还在岛上，每个蓝眼睛的人都能推断出c = 3，因此这三人都有蓝眼睛。他们会在第三晚离岛。 
不论c为什么值，都可以套用这个模式。所以，如果有c人是蓝眼睛的，则所有蓝眼睛的人要用c晚才能离岛，且都在同一晚离开。 
```

----

**疯狗问题（跟蓝眼睛一样）**

有50家人家，每家一条狗。有一天警察通知，50条狗当中有病狗，行为和正常狗不一样。每人只能通过观察别人家的狗来判断自己家的狗是否生病，而不能看自己家的狗，如果判断出自己家的狗病了，就必须当天一枪打死自己家的狗。结果，第一天没有枪声，第二天没有枪声，第三天开始一阵枪响，问：一共死了几条狗？

 解答：

```
死了3条（第几天枪响就有几条）。
从有一条不正常的狗开始，显然第一天将会听到一声枪响。这里的要点是你只需站在那条不正常狗的主人的角度考虑。
有两条的话思路继续，只考虑有两条不正常狗的人，其余人无需考虑。通过第一天他们了解了对方的信息。第二天杀死自己的狗。换句话说每个人需要一天的时间证明自己的狗是正常的。有三条的话，同样只考虑那三个人，其中每一个人需要两天的时间证明自己的狗是正常的狗。
```

----

**耳光问题（跟蓝眼睛一样）**

一群人开舞会，每人头上都戴着一顶帽子。帽子只有黑白两种，黑的至少有一顶。每个人都能看到其他人帽子的颜色，却看不到自己的。主持人先让大家看看别人头上戴的是什么帽子，然后关灯，如果有人认为自己戴的是黑帽子，就打自己一个耳光。第一次关灯，没有声音。于是再开灯，大家再看一遍，关灯时仍然鸦雀无声。一直到第三次关灯，才有劈劈啪啪打耳光的声音响起。问有多少人戴着黑帽子？

解答：

```
有三个人戴黑帽。假设有N个人戴黑帽，当N＝1时，戴黑帽的人看见别人都为白则能肯定自己为黑。于是第一次关灯就应该有声。可以断定N＞1。对于每个戴黑帽的人来说，他能看见N-1顶黑帽，并由此假定自己为白。但等待N-1次还没有人打自己以后，每个戴黑人都能知道自己也是黑的了。所以第N次关灯就有N个人打自己。
```

----

## 时间问题

**蜡烛燃烧问题**

两根蜡烛，燃烧完都需要1小时，怎么确定15分钟是多久？

 解答：

```
点燃第一根的一端，第二根的两端。
第二根烧完代表半小时后，点燃第一根另一端，烧完代表15分钟。 
```

---

## 重量问题

**乒乓球重量**

 8个乒乓球，其中一个重，有一个秤，问至少几次能够找出重的那个乒乓球

 解答：

2次，分成3堆，3，3，2。

```
（1）称3和3，如果一样重，代表重的在2。
（2）称2个那一堆的。
------
（1）称3和3，不一样重，重的在3里面重的那堆。
（2）3个里面随便取2个，一样重，第三个重。不一样重，重的那个就是。
```

---

**盐重量问题**

有7克、2克砝码各一个，天平一只，如何只用这些物品五次内将140克的盐分成50、90克各一份？

解答： 

```
第一次：先分成70和70
第二次：通过7和2砝码将70分成9和61
第三次：通过9克盐和2砝码将61分成50和11
```

---

**药丸问题**

有20瓶药丸，其中19瓶装有1克/粒的药丸，余下一瓶装有1.1克/粒的药丸。给你一台称重精准的天平，怎么找出比较重的那瓶药丸？天平只能用一次。

 解答：

```
从药瓶#1取出一粒药丸，从药瓶#2取出两粒，从药瓶#3取出三粒，依此类推。如果每粒药丸均重1克，则称得总重量为210克（1 + 2 + … + 20 = 20 * 21 / 2 = 210），“多出来的”重量必定来自每粒多0.1克的药丸。 
药瓶的编号可由算式(weight - 210) / 0.1 得出。因此，若这堆药丸称得重量为211.3克，则药瓶#13装有较重的药丸。 
```

---

**药丸问题2**

你有四个装药丸的罐子，每个药丸都有一定的重量，被污染的药丸是没被污染的重量+1.只称量一次，如何判断哪个罐子的药被污染了？

解答：

```
从第一盒中取出一颗，第二盒中取出2 颗，第三盒中取出三颗。 依次类推，称其总量。减去10，多的数字就是药丸罐子序号。
```

----

## 数学问题

**概率问题1**

一个家庭有两个小孩，其中有一个是女孩，问另一个也是女孩的概率（假定生男生女的概率一样）

 解答：

```
1/3
样本空间为（男男）（女女）（男女）（女男）
A＝（已知其中一个是女孩）＝）（女女）（男女）（女男）
B＝（另一个也是女孩）＝（女女）
于是P（B／A）＝P（AB）／P（A）＝（1／4）／（3／4）＝1／3
```

---

 **概率问题2**

你有两个罐子，每个罐子各有若干红色弹球和蓝色弹球，两个罐子共有50个红色弹球，50个蓝色弹球，随机选出一个罐子，随机从中选取出一个弹球，要使取出的是红球的概率最大，一开始两个罐子应放几个红球，几个蓝球？在你的计划中，得到红球的准确几率是多少？

解答：

```
一个罐子放1红，一个罐子放49红和50蓝，这样得到红球的概率接近3/4。
```

---

**扑克牌问题**

54张扑克牌，其中有十张是翻过来的。现在把你的眼睛蒙上，让你把扑克牌分成两叠（两叠的多少可以不一样）。要求在两叠中翻过来的扑克牌是相等的。请问该怎么做？

 解答：

```
第一步，你在这54张牌中任意取出10张，现在，扑克牌分成了两叠。44张和10张；第二步，44张那叠不动，将10张这叠每张都翻过来，便得到了符合条件的两叠牌。
解释：第一步之后，设44张那叠中正面牌x张，10张那叠中正面牌则为10-x张。第二步之后，44张那叠中正面牌保持x张，10张那叠反过来了：反面牌为10-x张，正面牌x张。
```

---

**扔鸡蛋问题**

有栋建筑物高100层。若从第N层或更高的楼层扔下来，鸡蛋就会破掉。若从第N层以下的楼层扔下来则不会破掉。给你2个鸡蛋，请找出N，并要求最差情况下扔鸡蛋的次数为最少。

解答：

```
14次
首先，让我们试着从10层开始扔鸡蛋，然后是20层，等等。 
如果鸡蛋1第一次扔下楼（10层）就破掉了，那么，最多需要扔10次。 
如果鸡蛋1最后一次扔下楼（100层）才破掉，那么，最多要扔19次（10、20、…、90、100层，然后是91到99层）。 
这么做也挺不错，但我们只考虑了绝对最差情况。我们应该进行“负载均衡”，让这两种情况下扔鸡蛋的次数更均匀。 我们的目标是设计一种扔鸡蛋的方法，使得扔鸡蛋1时，不论是在第一次还是最后一次扔下楼才破掉，次数越稳定越好。 
(1) 完美负载均衡的方法应该是，扔鸡蛋1的次数加上扔鸡蛋2的次数，不论什么时候都一样，不管鸡蛋1是从哪层楼扔下时破掉的。 
(2) 若有这种扔法，每次鸡蛋1多扔一次，鸡蛋2就可以少扔一次。 
(3) 因此，每丢一次鸡蛋1，就应该减少鸡蛋2可能需要扔下楼的次数。例如，如果鸡蛋1先从20层往下扔（不破），然后从30层扔下楼（破），此时鸡蛋2可能就要扔9次（从21到29 一次次试）。若鸡蛋1再扔一次，我们必须让鸡蛋2扔下楼的次数降为8次。也就是说，我们必须让鸡蛋1从39层扔下楼。 
(4) 由此可知，鸡蛋1必须从X层开始往下扔，然后再往上增加X-1层……直至到达100层。  
(5) 求解方程式X + (X-1) + (X-2) + … + 1 = 100，得到X (X + 1) / 2 = 100 → X = 14。
我们先从14层开始，然后是27层，接着是39层，依此类推，最差情况下鸡蛋要扔14次。 
其他情况也是一样的只需要求X (X + 1) / 2 = 楼层数量的X大约值即可。
```

---

**填数字**

0 1 2 3 4 5 6 7 8 9

\_  _  _  _  _  _  _  _  _  _ 在横线上填写数字，使之符合要求。

要求如下：对应的数字下填入的数，代表上面的数在下面出现的次数，比如3下面是1，代表3要在下面出现一次。

解答：

```
6 2 1 0 0 0 1 0 0 0
```

---

**规律**

1，11，21，1211，111221，下一个数是什么？

解答：

```
下行是对上一行的解释 所以新的应该是3个1 2个2 1个1 ：312211
```

-----

**猜数字问题**

教授选出两个从2到9的数，把它们的和告诉学生甲，把它们的积告诉学生乙，让他们轮流猜这两个数， 甲说：“我猜不出”， 乙说：“我猜不出”， 甲说：“我猜到了”，  乙说：“我也猜到了”， 问这两个数是多少？

解答：

```
3和4。设两个数为n1，n2，n1> =n2，甲听到的数为n=n1 n2，乙听到的数为m=n1*n2，证明n1=3，n2=4是唯一解。
证明：要证以上命题为真，不妨先证n=7
1)必要性：
  　i)  n> 5  是显然的，因为n <4不可能，n=4或者n=5甲都不可能回答不知道
  　ii)  n> 6  因为如果n=6的话，那么甲虽然不知道(不确定2 4还是3 3)但是无论是2，4还是3，3乙都不可能说不知道(m=8或者m=9的话乙说不知道是没有道理的)
  　iii)  n <8  因为如果n> =8的话，就可以将n分解成  n=4 x  和  n=6 (x-2)，那么m可以是4x也可以是6(x-2)而4x=6(x-2)的必要条件是x=6即n=10，那样n又可以分解成8 2，所以总之当n> =8时，n至少可以分解成两种不同的合数之和，这样乙说不知道的时候，甲就没有理由马上说知道。以上证明了必要性。
2)充分性
当n=7时，n可以分解成2 5或3 4
显然2 5不符合题意，舍去，容易判断出3 4符合题意，m=12，证毕
于是得到n=7  m=12  n1=3  n2=4是唯一解。 
```

---

## 其他问题

**水果标签问题**

3个箱子里面放了 苹果，梨子，苹果加梨子，标签全错误，只能选择查看一箱的水果来改正所有标签

 解答：

```
查看贴苹果和梨标签那一个，如果拿出来的是苹果，代表这一箱只有苹果，因为如果是苹果和梨就代表标签没错了。
那么剩下的两箱就是梨，苹果和梨，剩下的标签是梨，苹果，由于标签全错，所以贴着苹果的是梨，贴着梨的是苹果和梨。
如果拿出来的是梨，同理代表这一箱只有梨。那么剩下的两箱就是苹果，苹果和梨，剩下的标签就是苹果，梨。由于标签全错，贴着苹果的就是苹果和梨，贴着梨的就是苹果。
```

----

**便士标签问题（和水果标签一样）**

假设在桌上有三个密封的盒，一个盒中有2枚银币(1银币=10便士)，一个盒中有2枚镍币(1镍币=5便士)，还有一个盒中有1枚银币和1枚镍币。这些盒子被标上10便士、 15便士和20便士，但每个标签都是错误的。允许你从一个盒中拿出1枚硬币放在盒前，看到这枚硬币，你能否说出每个盒内装的东西呢？

----

**吃药问题**

某种药方要求非常严格，你每天需要同时服用A、B两种药片各一颗，不能多也不能少。这种药非常贵，你不希望有任何一点的浪费。一天，你打开装药片A的药瓶，倒出一粒药片放在手心；然后打开另一个药瓶，但不小心倒出了两粒药片。现在，你手心上有一颗药片A，两颗药片B，并且你无法区别哪个是A，哪个是B。你如何才能严格遵循药方服用药片，并且不能有任何的浪费？

解答：

```
把手上的三片药各自切成两半，分成两堆摆放。再取出一粒药片A，也把它切成两半，然后在每一堆里加上半片的A。现在，每一堆药片恰好包含两个半片的A和两个半片的B。一天服用其中一堆即可。
```

---

 **硬币问题**

如何用一枚硬币等概率地产生一个1到3之间的随机整数？如果这枚硬币是不公正的呢？

答案：如果是公正的硬币，则投掷两次，“正反”为1，“反正”为2，“正正”为3，“反反”重来。**

解答：

```
如果是不公正的硬币，注意到出现“正反”和“反正”的概率一样，因此令“正反反正”、“反正正反”、“正反正反”分别为1、2、3，其余情况重来。另一种更妙的办法是，投掷三次硬币，“正反反”为1，“反正反”为2，“反反正”为3，其余情况重来。
```

---

**灯管问题**

在房里有三盏灯，房外有三个开关，在房外看不见房内的情况，你只能进门一次，你用什么方法来区分那个开关控制那一盏灯？

解答：

```
打开一个开关。过10分钟后关掉开关，并打开另一个开关。进屋确认可知：
亮的灯是由第二次打开的开关控制；
摸上去发热的不发亮的灯是由第一次打开的开关控制
剩下的第三盏灯是由未操作过的开关控制。
```

---

**盲人问题**

他们都各自买了两对黑袜和两对白袜，八对袜了的布质、大小完全相同，而每对袜了都有一张商标纸连着。两位盲人不小心将八对袜了混在一起。 他们每人怎样才能取回黑袜和白袜各两对呢？

解答： 

```
每一对分开，一人拿一只，因为袜子不分左右脚。
```

-----

**最大钻石问题**

一楼到十楼的每层电梯门口都放着一颗钻石，钻石大小不一。你乘坐电梯从一楼到十楼，每层楼电梯门都会打开一次，只能拿一次钻石，问怎样才能拿到最大的一颗？

解答：

```
选择前五层楼都不拿，观察各层钻石的大小，做到心中有数。后面五个楼层再选择，选择大小接近前五层楼出现过最大钻石大小的钻石。
```

---

# MySQL

## DQL

### 1 基础查询

**语法：**

```sql
select 查询列表 from 表名;
```

**特点：**

> 1. 查询的结果集是一个虚拟表
> 2. select后面的查询列表可以由多个部分组成，中间由逗号隔开
> 3. 执行顺序 例如进行以下查询，是先查询是否存在该表，再查询具体的查询列表是否存在。
>    ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200113100523599.png)
> 4. 查询列表可以是：字段、表达式、常量、函数等

----

**1 查询常量**
`SELECT 100;`

**2 查询表达式**
`SELECT 100%3;`

**3 查询单个字段**
`SELECT last_name FROM employees;`

**4 查询多个字段 选中后按F12可以对齐格式**
`SELECT   last_name,  email FROM  employees ;`

**5 查询所有字段**
`SELECT * FROM employees;`

**6 查询函数（调用函数，获取返回值）**
查询当前所用数据库
`SELECT DATABASE();`
查询版本
`SELECT VERSION(); `
查询用户
`SELECT USER();`

**7 起别名，可以改变查询结果中的列名**
方式一：使用as关键字 语义性更强
`SELECT USER() AS '用户名';`
方式二：使用空格
`SELECT USER() '用户名';`

**8 拼接**
 需求：拼接first_name 和 last_name成为全名
`SELECT 
  CONCAT(first_name, ' ', last_name) AS 'name' 
FROM
  employees ;`

**9 去重** 
需求：查询员工涉及到的所有部门
`SELECT DISTINCT(department_id) FROM employees;`

**10 查看表的结构**
`DESC employees;`
`SHOW COLUMNS FROM employees;`

-----

**补充：mysql中+的作用**

 - 如果两个操作数都是数值型，直接相加
 - 如果其中一个操作数是数值型  将字符型尝试转换为数值型,如果无法解析字符串，当作`0`计算，例如`'abc'+1`结果为`1`
 - 如果其中一个操作数为`null`，结果就为`null`

-----

### 基础查询作业及答案

1. 下面的语句是否可以执行成功（可以）
   `select last_name , job_id , salary as sal from employees;` 

2. 下面的语句是否可以执行成功 （可以）
   `select * from employees;`

3. 找出下面语句中的错误
   `select employee_id , last_name，salary * 12 “ANNUAL SALARY” from employees;`
   错误：应该使用英文的逗号和双引号

4. 显示表 departments 的结构，并查询其中的全部数据	
   `DESC departments;`
   `SELECT * FROM departments;`

5. 显示出表 employees 中的全部 job_id（不能重复）
   `SELECT DISTINCT(job_id) FROM employees;`

6. 显示出表 employees 的全部列，各个列之间用逗号连接，列头显示成 OUT_PUT
   如果其中一个列为`null`，拼接结果就为`null`，使用`ifnull`函数给值为`null`的列赋值
   `ifnull(exp1,exp2)`，如果exp1为null，显示exp2的值，否则显示exp1的值。

   ```sql
   SELECT 
     CONCAT(
       employee_id,',',
       first_name,',',
       last_name,',',
       email,',',
       phone_number,',',
       job_id,',',
       salary,',',
       IFNULL(commission_pct, 0),',',
       manager_id,',',
       department_id, ',',
       hiredate
     ) AS 'OUT_PUT' 
   FROM
     employees ;
   ```

   当奖金率为null时，设为0.00
   ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200113110453923.png)

-----

### 2 条件查询

**语法：**

```sql
select 查询列表 from 表名 where 筛选条件;
```

**特点：**

> 1. 执行顺序 
>    ①from字句
>    ②where字句
>    ③select字句 
>    ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200113112340664.png)
> 2. 按条件表达式筛选 
>    关系运算符：大于`>`,大于等于`>= `,小于`<` ,小于等于`<=`,等于`=`,不等于`<>`
>     逻辑运算符：与`and`，或`or`，非`not`

-----

**按关系表达式筛选**

- 案例1 查询部门编号不是100的员工信息
  `SELECT * FROM employees WHERE department_id <> 100;`

- 案例2 查询工资<15000的姓名，工资
  `SELECT last_name,salary FROM employees WHERE salary<15000;`

-----

**按逻辑表达式筛选**

- 案例1 查询部门编号不是50-100之间的员工信息
  `SELECT * FROM employees WHERE NOT (department_id >50 AND department_id <100);`

- 案例2 查询奖金率大于0.03或者员工编号在60-110之间的员工信息
  `SELECT * FROM employees WHERE commission_pct>0.03 OR (employee_id >=60 AND employee_id <=110);`

----

**模糊查询**
**1 LIKE**  一般和通配符搭配使用，对字符型数据进行部分匹配查询
常见的通配符： `_ `任意单个字符  `% `任意多个字符

- 案例1 查询姓名中包含字符a的员工信息
  `SELECT * FROM employees WHERE last_name LIKE '%a%';`

- 案例2 查询姓名中最后1个字符为e的员工信息
  `SELECT * FROM employees WHERE last_name LIKE '%e';`

- 案例3 查询姓名中第1个字符为e的员工信息
  `SELECT * FROM employees WHERE last_name LIKE '__e%';`

- 案例4 查询姓名中第2个字符为_的员工信息 使用\转义 也可使用escape自定义转义字符
  `SELECT * FROM employees WHERE last_name LIKE '_\_%';`
  `SELECT * FROM employees WHERE last_name LIKE '_$_%' ESCAPE '$';`

 **2 IN**   查询某字段的值是否属于指定的列表值内 

 - 案例1 查询部门编号是30 / 50 / 90 的员工名 
   `SELECT 
     last_name 
   FROM
     employees 
   WHERE department_id IN (30, 50, 90) ;`

- 案例2 查询工种编号不是SH_CLERK或IT_PROG的员工信息 非数值常量值用引号引起
  `SELECT * FROM employees WHERE job_id NOT IN('SH_CLERK','IT_PROG');`

**3 BETWEEN AND**  判断某个字段的值是否介于某区间之间

- 案例1 查询部门编号在30-90之间的员工姓名
  `SELECT last_name FROM employees WHERE department_id BETWEEN 30 AND 90;`

- 案例2 查询年薪不是10000-20000之间的员工姓名，工资，年薪
  `SELECT last_name,salary,salary*12*(1+IFNULL(commission_pct,0)) s FROM employees WHERE salary*12*(1+IFNULL(commission_pct,0)) NOT BETWEEN 10000 AND 20000;`


**4 isnull** 判断空值

- 案例1 查询没有奖金的员工信息
  `SELECT * FROM employees WHERE commission_pct IS NULL;`

`= `只能判断普通数值
`IS` 只能判断null值
`<=>` 既能判断普通数值，又能判断null值

-----

### 条件查询作业及答案

1. 查询工资大于 12000 的员工姓名和工资
   `SELECT last_name,salary FROM employees WHERE salary >12000;`
2. 查询员工号为 176 的员工的姓名和部门号
   `SELECT last_name,department_id FROM employees WHERE employee_id =176;`
3. 选择工资不在 5000 到 12000 的员工的姓名和工资
   `SELECT latst_name,salary FROM employees WHERE salary NOT BETWEEN 5000 AND 12000;`
4. 选择在 20 或 50 号部门工作的员工姓名和部门号
   `SELECT last_name,department_id FROM employees WHERE department_id IN(20,50);`
5. 选择公司中没有管理者的员工姓名及 job_id
   `SELECT last_name,job_id FROM employees WHERE salary >12000;`
6. 选择公司中有奖金的员工姓名，工资和奖金级别
   `SELECT last_name,salary FROM employees WHERE manager_id IS NULL;`
7. 选择员工姓名的第三个字母是 a 的员工姓名
   `SELECT last_name FROM employees WHERE last_name LIKE '__a%';`
8. 选择姓名中有字母 a 和 e 的员工姓名
   `SELECT last_name FROM employees WHERE last_name LIKE '%a%' AND last_name LIKE '%e%';`
9. 显示出表 employees 表中 first_name 以 'e'结尾的员工信息
   `SELECT * FROM employees WHERE first_name LIKE '%e';`
10. 显示出表 employees 部门编号在 80-100 之间 的姓名、职位
    `SELECT last_name,job_id FROM employees WHERE department_id BETWEEN 80 AND 100;`
11. 显示出表 employees 的 manager_id 是 100,101,110 的员工姓名、职位
    `SELECT last_name,job_id FROM employees WHERE department_id IN(100,101,110);`

-----

### 3 排序查询

**语法：**

```sql
select 查询列表 from 表名 where 筛选条件 order by 排序列表;
```

**特点：**

> 1. 执行顺序 
>    ①from字句
>     ②where字句
>      ③select字句 
>    ④order by子句  ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200113145503916.png)
>  2. 排序列表可以是单个字段、多个字段、表达式、函数、列数及以上组合
>  3. 升序，通过asc，默认行；降序，通过desc

------

**1 按单个字段排序**

- 案例1 查询员工编号大于120的员工信息，按工资升序
  `SELECT * FROM employees WHERE employee_id >120 ORDER BY salary ASC;`

**2 按表达式排序** 

- 案例1 对有奖金的员工，按年薪降序查询 

  ```sql
  SELECT  * FROM employees 
  WHERE commission_pct IS NOT NULL 
  ORDER BY salary * 12 * (1+ commission_pct) DESC ;
  ```

**3 按别名排序(WHERE 不能使用别名，因为别名起在select中，select在where后执行)**

- 使用上述案例

  ```sql
  SELECT  *,salary*12*(1+ commission_pct) AS 年薪
  FROM employees 
  WHERE commission_pct IS NOT NULL 
  ORDER BY 年薪 DESC ;
  ```

**4 按函数的结果排序**

- 案例1 按姓名的字数长度进行升序排列
  `SELECT last_name FROM employees ORDER BY LENGTH(last_name);`

**5 按多个字段进行排序**

- 案例1 查询员工的姓名，先按工资升序，再按部门编号降序排列
  `SELECT last_name FROM employees ORDER BY salary ASC,department_id DESC;`

**6 按列数排序**

- 案例1 按第二列进行排序
  `SELECT * FROM employees ORDER BY 2;`
  2代表第二列，相当于 ORDER BY first_name,语义性差

-----

### 排序查询作业及答案

1 查询员工的姓名和部门号和年薪，按年薪降序 按姓名升序 

```sql
SELECT 
  last_name,
  department_id,
  salary * 12 * (1+ IFNULL(commission_pct, 0)) AS 年薪 
FROM
  employees 
ORDER BY 年薪 DESC,
  last_name ;
```

2.选择工资不在 8000 到 17000 的员工的姓名和工资，按工资降序 

```sql
SELECT 
  last_name,
  salary 
FROM
  employees 
WHERE salary NOT BETWEEN 8000 
  AND 17000 
ORDER BY salary DESC ;
```

3 查询邮箱中包含 e 的员工信息，并先按邮箱的字节数降序，再按部门号升序 

```sql
SELECT 
  * 
FROM
  employees 
WHERE email LIKE '%e%' 
ORDER BY LENGTH(email) DESC,
  department_id ASC ;
```

-----

### 4 常见函数

**函数：**
类似于Java中的方法，为了解决某个问题将编写的一系列命令集合封装在一起，对外仅暴露方法名，供外部调用
**常见函数：**
字符函数、数学函数、日期函数、流程控制函数

-----

**1 字符函数**

**1 CONCAT 拼接字符**
`SELECT CONCAT(first_name,last_name) FROM employees;`

**2 LENGTH 获取字节长度**
`SELECT LENGTH('hello');`//5
`SELECT LENGTH('字符');`//6,一个汉字占3个字节

**3 CHAR_LENGTH 获取字符长度**
`SELECT CHAR_LENGTH('hello字符');`//7

**4 SUBSTR 截取字符串**
SUBSTR(str,起始索引，截取的字符长度)
SUBSTR(str,起始索引)
`SELECT SUBSTR('林婉儿是大宗师',1,3);`//林婉儿，sql索引从1开始
`SELECT SUBSTR('大宝是影子',4);`//影子

**5 INSTR 获取字符第一次出现的索引**
`SELECT INSTR('李纯扮演的是司理理，司理理是李纯演的','李纯');`//1

**6 TRIM 去除前后指定字符，默认去掉空格**
`SELECT TRIM(' 范 闲 杀了程巨树 ');`//范 闲 杀了程巨树
`SELECT TRIM(' ' FROM ' 范 闲 杀了程巨树 ');`//范 闲 杀了程巨树

**7 LPAD/RPAD 左填充/右填充**
`SELECT LPAD('陈萍萍',10,'a');`//aaaaaaa陈萍萍
`SELECT RPAD('陈萍萍',10,'a');`//陈萍萍aaaaaaa


**8 UPPER/LOWER变大/小写**
案例：查询员工表中的姓名，要求格式：姓首字符大写，其他字符小写，名所用字符大写，姓名之间用_分隔，起别名name

```sql
SELECT SELECT 
  CONCAT(
    UPPER(SUBSTR(last_name, 1, 1)),
    LOWER(SUBSTR(last_name, 2)),
    '_',
    UPPER(first_name)
  ) AS NAME 
FROM
  employees ;
```

**9 STRCMP 比较两个字符大写** 
1表示大于，-1表示小于,0表示等于  
`SELECT STRCMP('abc','aaa');`//1
`SELECT STRCMP('a','a');`//0  


**10 LEFT/RIGHT 左/右截取**
`SELECT LEFT('二皇子是boss',3);`//二皇子
`SELECT RIGHT('太子喜欢他姑姑',2);`//姑姑

----

**2 数学函数**
**1 ABS 求绝对值**
`SELECT ABS(-3);`//3

**2 CEIL 向上取整**
`SELECT CEIL(4.7);`//5

**3 FLOOR 向下取整**
`SELECT FLOOR(2.9);`//2

**4 ROUND 四舍五入**
`SELECT ROUND(1.82);`//2
`SELECT ROUND(1.82,1);`//1.8

**5 TRUNCATE 截断**
`SELECT TRUNCATE(1.8713,0);`//1
`SELECT TRUNCATE(1.8713,2);`//1.87

**6 MOD 取余**
`SELECT MOD(-10,3);`//-1  

-----

**3 日期函数**
**1 NOW 获取当前日期和时间**
`SELECT NOW();`//2020-01-14 09:14:03

**2 CURDATE 获取当前日期**
`SELECT CURDATE();`//2020-01-14

**3 CURTIME 获取当前时间**
`SELECT CURTIME();`//09:14:03

**4 DATEDIFF 获取两个日期之差**
`SELECT DATEDIFF('1996-02-06','1990-10-22');`//1933(天)

**5 DATE_FORMAT 日期转换字符串**
`SELECT DATE_FORMAT('1998-07-04','%Y年%m月%d日');`//1998年07月04日

**6 STR_TO_DATE 字符串转换日期**
`SELECT STR_TO_DATE('3/15 1997','%m/%d %Y');`//1997-03-15

-----

**4 流程控制函数**

**1 IF 函数**
类似于Java中三元表达式
`SELECT IF(1>0,'成立','不成立');`//成立  

- 案例：如果有奖金，显示奖金，如果没有显示0
  `SELECT IF(commission_pct IS NOT NULL,commission_pct,0) FROM employees;`

**2 CASE 函数**
**情况1：类似于switch，实现等值判断**
语法：

```sql
CASE 表达式 
WHEN 值1 THEN 结果1
WHEN 值1 THEN 结果1
...
ELSE 结果n
END  
```

案例：部门编号是30，工资显示2倍，部门编号50，工资显示3倍，否则不变 

```sql
SELECT 
  department_id AS 部门编号,
  salary AS 旧工资,
  CASE
    department_id 
    WHEN 30 THEN salary * 2 
    WHEN 50 THEN salary * 3 
    ELSE salary 
  END AS 新工资 
FROM
  employees ;
```

**情况2：类似多重if语句，实现区间判断** 
语法： 

```sql
CASE
  WHEN 条件1 
  THEN 结果1 
  WHEN 条件2 
  THEN 结果2...
  ELSE 结果n 
  END 
```

案例：如果工资大于20000，显示A，如果大于15000，显示B，大于10000显示C，否则显示D 

```sql
SELECT 
  salary AS 工资, 
  CASE
    WHEN salary > 20000 THEN 'A' 
    WHEN salary > 15000 THEN 'B' 
    WHEN salary > 10000 THEN 'C' 
    ELSE 'D' 
    END AS 工资等级 
FROM
  employees ;
```

-----

### 常见函数作业及答案

1 显示系统时间(注：日期+时间)
`SELECT NOW();`

2 查询员工号，姓名，工资，以及工资提高百分之 20%后的结果（new salary）
`SELECT employee_id,last_name,salary,salary*1.2 FROM employees;`

3 将员工的姓名按首字母排序，并写出姓名的长度（length）

```sql
SELECT last_name,LENGTH(last_name) 
FROM employees 
ORDER BY SUBSTR(last_name,1,1);
```


4 做一个查询，产生下面的结果：<last_name> earns <salary> monthly but wants <salary*3>,结果命名为dreammoney

```sql
SELECT 
CONCAT(last_name,' earns ',salary,' monthly but wants ',salary*3)
AS dreammoney
FROM employees;
```


5 使用 CASE- when，按照下面的条件： 
`job grade /AD_PRES A /ST_MAN B /IT_PROG C/ SA_REP D /ST_CLERK E` 产生下面的结果 `Last_name/ Job_id /Grade `

```sql
 SELECT 
    last_name,
    job_id,
    CASE
      job_id 
      WHEN 'AD_PRES'  THEN 'A' 
      WHEN 'ST_MAN'   THEN 'B' 
      WHEN 'IT_PROG'  THEN 'C' 
      WHEN 'SA_REP'   THEN 'D' 
      WHEN 'ST_CLERK' THEN 'E' 
    END AS grade 
  FROM
    employees ;
```

--------

### 5 分组函数

分组函数往往用于实现将一组数据进行统计计算，最终得到一个值，又称为聚合函数或统计函数。
分组函数清单：

> sum（字段名） 求和 
> avg（字段名） 求平均值
> max（字段名） 求最大值 
> min（字段名） 求最小值
> count（字段名）计算非空字段值的个数

-----

 案例1 查询员工表中工资和，工资平均值，最高工资，最小工资，有工资的个数
 `SELECT SUM(salary),AVG(salary),MAX(salary),MIN(salary),COUNT(salary) FROM employees;`

 案例2 查询员工表中总记录数
` SELECT COUNT(*) FROM employees;`

 案例3 查询员工表中月薪大于2500的人数
` SELECT COUNT(*) FROM employees WHERE salary>2500;`

 案例4 查询有领导的人数
` SELECT COUNT(manager_id) FROM employees;`

 **count的补充：**
 1 查询结果集的行数，推荐使用*
` SELECT COUNT(*) FROM employees;`

` SELECT COUNT(1) FROM employees;`
 效果和`*`一样，不一定是`1`，也可以是其他常量，相当于在所有行拼接了一个常量列

 2 搭配distinct实现去重的统计
 案例 查询有员工的部门个数
` SELECT COUNT(DISTINCT department_id) FROM employees; `

-----

### 6 分组查询

**语法：**

```sql
SELECT 查询列表
FROM 表名 
WHERE 筛选条件 
GROUP BY 分组列表 HAVING 分组后筛选 
ORDER BY 排序列表
```

---

**特点：**

> 1.查询列表往往时分组函数和被分组的字段  
> 2.分组前筛选使用 WHERE 筛选的表是原始表 位置在 GROUP BY 前   分组后筛选使用 HAVING 筛选的表是分组后的结果集 位置在 GROUP BY 之后  
> 执行顺序 FROM ->WHERE->GROUP BY->HAVING ->SELECT->ORDER BY   
> 分组函数做条件只能放在 HAVING 后面

----

案例1 查询每个工种的员工平均工资

```sql
SELECT AVG(salary),job_id FROM employees GROUP BY job_id;
```

案例2 查询每个领导的手下人数 

```sql
SELECT 
  COUNT(*),
  manager_id 
FROM
  employees 
WHERE manager_id IS NOT NULL 
GROUP BY manager_id ;
```

案例3 查询邮箱中包含a字符的 每个部门的最高工资 

```sql
SELECT 
  MAX(salary),
  department_id 
FROM
  employees 
WHERE email LIKE '%a%' 
GROUP BY department_id ;
```

案例4 查询每个领导手下有奖金员工的平均工资 

```sql
SELECT 
  AVG(salary),
  manager_id 
FROM
  employees 
WHERE commission_pct IS NOT NULL 
GROUP BY manager_id ;
```

在分组结果上筛选，使用having子句：
 案例5 查询哪个部门额员工个数 > 5 

```sql
SELECT 
  department_id,
  COUNT(*) 
FROM
  employees 
GROUP BY department_id 
HAVING COUNT(*) > 5 ;
```

案例6 查询每个工种有奖金的员工的最高工资大于12000的工种编号和最高工资 

```sql
SELECT 
  job_id,
  MAX(salary) 
FROM
  employees 
WHERE commission_pct IS NOT NULL 
GROUP BY job_id 
HAVING MAX(salary) > 12000 ;
```

案例7 查询领导编号 > 102 的每个领导手下的最低工资大于5000的领导编号和最低工资 

```sql
SELECT 
  manager_id,
  MIN(salary) 
FROM
  employees 
WHERE manager_id > 102 
GROUP BY manager_id 
HAVING MIN(salary) > 5000 ;
```

案例8 查询每个工种有奖金，最高工资>6000的员工的工种编号和最高工资，按最高工资升序

```sql
SELECT job_id,MAX(salary)
FROM employees
WHERE commission_pct IS NOT NULL
GROUP BY job_id 
HAVING MAX(salary)>5000
ORDER BY MAX(salary);
```

案例9 查询每个工种每个部门的最低工资，并按最低工资降序 

```sql
SELECT 
  job_id,
  department_id,
  MIN(salary) 
FROM
  employees 
GROUP BY job_id,
  department_id 
ORDER BY MIN(salary) DESC ;
```

------

### 7 连接查询

又称多表查询，当我们要查询的字段涉及多个表时，就会用到连接查询
需要导入新的sql脚本，没有的私我
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200114112153592.png)
girls表的内容：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200114112158378.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
boys表的内容：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200114112202929.png)
如果我们想查询女神名和对应的男朋友名，假如我们使用
`SELECT NAME,boyName FROM beauty,boys`
得到的结果：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200114112432388.png)
这样的结果显然不是我们想要的，这样的现象是因为没有筛选和连接条件，所以每一条都会互相匹配成功，这种现象叫做笛卡尔乘积现象，假设A表有m行，B表有n行，最终的结果为m*n行。
产生问题的原因为没有添加有效的连接条件。
正确的查询sql语句：`SELECT NAME,boyName FROM beauty,boys WHERE boyfriend_id=boys.id;`

----

分类：

- 按年代 
  sql92标准 仅支持内连接
  sql99标准【推荐】支持除了全外连接的连接
- 按功能
  内连接：等值连接/非等值连接/自连接
  外连接：左外连接/右外连接/全外连接（用于查询主表有但从表没有的记录）
  交叉连接

------

#### SQL92语法

内连接
**1 等值连接**
**语法：**

```sql
SELECT 查询列表 FROM 表名1 [AS] 别名1，表名2 [AS] 别名2... WHERE 等值连接条件
```

**特点：**
1.为解决多表字段名称重复问题，往往为表起别名，提高语义性
2.表的顺序无要求

案例1 查询员工名和部门名

```sql
SELECT last_name,department_name FROM employees AS e,departments AS d
WHERE e.department_id = d.department_id;
```

案例2 查询部门编号>100的部门名和所在城市名

```sql
SELECT  d.department_name,l.city
FROM departments d,locations l
WHERE d.location_id=l.location_id AND d.department_id>100;
```

案例3 查询有奖金的员工名，部门名

```sql
SELECT last_name,department_name
FROM employees e,departments d
WHERE commission_pct IS NOT NULL AND e.department_id =d.department_id;
```

案例4 查询城市名中第二个字符为o的部门名和城市名

```sql
SELECT department_name,city
FROM departments d,locations l
WHERE city LIKE '_o%' AND d.location_id=l.location_id;
```

案例5 查询每个城市的部门个数

```sql
SELECT COUNT(department_id),l.city
FROM departments d,locations l
WHERE d.location_id=l.location_id
GROUP BY d.location_id;
```

案例6 查询有奖金的每个部门的部门名，部门的领导编号，该部门的最低工资

```sql
SELECT d.department_name,e.manager_id,MIN(salary)
FROM employees e,departments d
WHERE e.department_id=d.department_id AND commission_pct IS NOT NULL
GROUP BY e.department_id
```



案例7 查询部门中员工个数>10的部门名

```sql
SELECT d.department_name,COUNT(employee_id)
FROM departments d,employees e
WHERE d.department_id=e.department_id 
GROUP BY e.department_id
HAVING COUNT(employee_id)>10;
```

案例8 查询哪个部门的员工个数>5,并按员工个数降序

```sql
SELECT department_name,COUNT(*)
FROM departments d,employees e
WHERE d.department_id=e.department_id
GROUP BY d.department_id
HAVING COUNT(*)>5
ORDER BY COUNT(*) DESC;
```

案例9 查询员工名，部门名和所在城市

```sql
SELECT last_name,department_name,city
FROM employees e,departments d,locations l
WHERE e.department_id = d.department_id AND d.location_id=l.location_id;
```

**2 非等值连接**
需要创建一个工资等级表，创建表和插入数据的sql语句：

```sql
USE  myemployees;
DROP TABLE IF EXISTS sal_grade;
CREATE TABLE sal_grade (
	id INT PRIMARY KEY AUTO_INCREMENT,
	min_salary DOUBLE ,
	max_salary DOUBLE,
	grade CHAR

);

INSERT INTO sal_grade VALUES(NULL,2000,3999,'A');
INSERT INTO sal_grade VALUES(NULL,4000,5999,'B');
INSERT INTO sal_grade VALUES(NULL,6000,9999,'C');
INSERT INTO sal_grade VALUES(NULL,10000,12999,'D');
INSERT INTO sal_grade VALUES(NULL,13000,14999,'E');
INSERT INTO sal_grade VALUES(NULL,15000,99999,'F');
```

案例1 查询员工的姓名，工资和工资级别

```sql
SELECT last_name,e.salary,g.grade
FROM employees e,sal_grade g
WHERE e.salary BETWEEN min_salary AND max_salary;
```

**3 自连接**
案例1 查询员工名和上级的名称

```sql
SELECT e1.last_name,e2.last_name
FROM employees e1,employees e2
WHERE e1.manager_id=e2.employee_id;
```

-----

#### **SQL99语法**

**内连接：**
**语法：**

```sql
SELECT 查询列表 FROM 表名1 别名
[INNER] JOIN 表名2 别名
ON 连接条件
WHERE 筛选条件
GROUP BY 分组列表
HAVING 分组后筛选
ORDER BY 排序列表;
```

**sql92和sql99的区别**
sql99使用了 JOIN 关键字代替了之前的逗号，并将连接条件和筛选条件进行分离，提高可读性。

**1 等值连接**
案例1 查询员工名和部门名

```sql
SELECT last_name,department_name
FROM employees e JOIN departments d
ON e.department_id = d.department_id;
```

案例2 查询部门编号>100的部门名和所在的城市名

```sql
SELECT  d.department_name,l.city
FROM departments d JOIN locations l
ON d.location_id=l.location_id
WHERE d.department_id>100;
```

案例3 查询每个城市的部门个数

```sql
SELECT COUNT(department_id),l.city
FROM departments d JOIN locations l
ON d.location_id=l.location_id
GROUP BY d.location_id;
```

案例4 查询部门中员工个数>10的部门名，并按员工个数降序

```sql
SELECT d.department_name,COUNT(employee_id)
FROM departments d JOIN employees e
ON d.department_id=e.department_id 
GROUP BY e.department_id 
HAVING COUNT(employee_id)>10
ORDER BY COUNT(employee_id) DESC;
```

**2 非等值连接**
案例 查询部门编号在10-90之间的员工的各个工资级别的个数

```sql
SELECT COUNT(*),grade
FROM employees e JOIN sal_grade
ON salary BETWEEN min_salary AND max_salary
WHERE department_id BETWEEN 10 AND 90
GROUP BY grade;
```


**3 自连接**
案例 查询员工名和对应的领导名

```sql
SELECT e1.last_name,e2.last_name
FROM employees e1 JOIN employees e2
ON e1.manager_id=e2.employee_id;
```

------

**测试题**
一、查询员工姓名、入职日期并按入职日期升序
`SELECT last_name,hiredate FROM employees ORDER BY hiredate;`

二、将当前日期显示成 xxxx年xx月xx日
`SELECT DATE_FORMAT(NOW(),'%Y年%m月%d日');`

三、
已知学员信息表stuinfo
	stuId
	stuName 
	gender 
	majorId

已知专业表major
	id	
	majorName
	
已知成绩表result
	id成绩编号
	majorid
	stuid
	score


1、查询所有男生的姓名、专业名和成绩，使用SQL92和SQL99两种语法方式实现
sql92：

```sql
SELECT stuName,majorName,score
FROM stuinfo s,major m,result r
WHERE s.majorId=m.id AND m.id=r.majorId AND s.gender='男';
```

sql99：

```sql
SELECT stuName,majorName,score
FROM stuinfo s JOIN major m 
ON s.majorId=m.id 
JOIN result r ON m.id=r.majorId
WHERE s.gender='男';
```

2、查询每个性别的每个专业的平均成绩，并按平均成绩降序

```sql
SELECT gender,majorName,AVG(score)
FROM stuinfo s JOIN major m ON s.majorId=id
JOIN result r ON m.id=r.majorid
GROUP BY s.gender,m.id
ORDER BY AVG(score) DESC;
```

------

**外连接:**
**说明：** 查询结果为主表中所有记录，如果从表有匹配项则显示，如果从表没有匹配项则显示null。
**应用场景**：一般用于查询主表中有但从表中没有的记录。
**特点：**

1. 外连接分主从表，两表的顺序不能任意调换
2. 左连接的话，左边为主表。右连接的话，右边为主表。
   **语法：**

```sql
SELECT 查询列表 FROM 表1 别名 
LEFT/RIGHT [OUTER]JOIN 表2 别名
ON 连接条件 WHERE 筛选条件
```

案例1 查询所有女神记录以及对应男朋友名，如果没有显示null

```sql
SELECT b.*,bo.boyName
FROM beauty b LEFT JOIN boys bo
ON b.boyfriend_id=bo.id;
```

案例2 查询哪个女神没有男朋友

```sql
SELECT b.*,bo.boyName
FROM beauty b LEFT JOIN boys bo
ON b.boyfriend_id=bo.id
WHERE bo.id IS NULL;
```

案例3 查询哪个部门没有员工，并显示其部门编号和部门名

```sql
SELECT d.department_id,d.department_name
FROM departments d LEFT JOIN employees e
ON d.department_id=e.department_id
WHERE e.employee_id IS NULL;
```

-----

**测试题**
1 查询编号>3的女神的男朋友信息，如果没有用null填充

```sql
SELECT b.id,bo.*
FROM beauty b LEFT JOIN boys bo
ON b.boyfriend_id=bo.id
WHERE b.id>3;
```

2 查询哪个城市没有部门

```sql
SELECT city
FROM locations l LEFT JOIN departments d
ON l.location_id=d.location_id
WHERE d.department_id IS NULL;
```

3 查询部门名为SAL或IT的员工信息

```sql
SELECT e.*
FROM employees e RIGHT JOIN departments d
ON e.department_id=d.department_id
WHERE d.department_name IN ('SAL','IT');
```

-----

**总结join连接**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200114204420982.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200114204434935.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

-----

### 8 子查询

**说明：**
当一个查询语句中又嵌套了另一个完整的select语句，则被嵌套的select语句称为子查询或内查询，外面的select语句称为主查询或外查询。
**分类：**
①select后面 要求子查询的结果为单行单列（标量子查询）
②from后面 子查询的结果可以为多行多列（表子查询）
③where或having后面 子查询的结果必须为单列
④exists后面 要求子查询结果必须为单列（相关子查询）

----

特点：
①子查询放在条件中，一般放在条件的右侧
②子查询一般放在小括号中
③子查询的执行优先于主查询
④单行子查询对应单行操作符 > < >= <= = <>
⑤多行子查询对应多行操作符 any in some all

----

**1 单行子查询** 
案例1 查询和Zlotky相同部门的员工姓名和工资 

```sql
SELECT 
  last_name,salary 
FROM
  employees 
WHERE department_id = 
  (SELECT 
    department_id 
  FROM
    employees 
  WHERE last_name = 'Zlotkey');
```


案例2 查询工资比公司平均工资高的员工的员工号，姓名和工资 

```sql
SELECT 
  employee_id,
  last_name,
  salary 
FROM
  employees 
WHERE salary > 
  (SELECT 
    AVG(salary) 
  FROM
    employees) ;
```

案例3 查询工资最高的员工的姓名，要求first_name和last_name显示为一列，列名为姓名 

```sql
SELECT CONCAT(first_name,' ',last_name) AS '姓名' FROM employees
WHERE salary = (SELECT MAX(salary) FROM employees);
```

----

**2 多行子查询** 
IN 判断某字段是否在指定列表内 
ANY / SOME 判断某字段的值是否满足其中任意一个 
ALL 判断某字段的值是否满足所有的 

----------

案例1 返回location_id是1400或1700的部门中的所有员工姓名 

```sql
SELECT 
  last_name 
FROM
  employees 
WHERE department_id IN 
  (SELECT DISTINCT 
    department_id 
  FROM
    departments 
  WHERE location_id IN (1400, 1700));
```

案例2 返回其他部门中比job_id为'IT_PROG'部门任一工资低的员工的员工号、姓名、job_id和salary

```sql
SELECT employee_id,last_name,salary,job_id
FROM employees
WHERE salary< ANY(SELECT DISTINCT salary FROM employees WHERE job_id = 'IT_PROG')
AND job_id <> 'IT_PROG';
```

案例3 返回其他部门中比job_id为'IT_PROG'部门所有工资都低的员工的员工号、姓名、job_id和salary

```sql
SELECT employee_id,last_name,salary,job_id
FROM employees
WHERE salary< ALL(SELECT DISTINCT salary FROM employees WHERE job_id = 'IT_PROG')
AND job_id <> 'IT_PROG'; 
```

案例4 查询在部门的location_id为1700的部门的员工的员工号  

```sql
SELECT employee_id FROM employees
WHERE department_id IN
(SELECT DISTINCT department_id FROM departments d
 JOIN locations l ON d.location_id=l.location_id
 WHERE l.location_id =1700); 
```

-----

**3 标量子查询**
案例 查询部门编号是50的员工个数

```sql
SELECT (SELECT COUNT(*) FROM employees WHERE department_id =50);  
```

-----

**4 表子查询**
案例 查询每个部门的平均工资的工资级别

```sql
SELECT s.sal,g.grade
FROM sal_grade g
JOIN (SELECT AVG(salary) AS sal FROM employees GROUP BY department_id) s
ON s.sal BETWEEN g.min_salary AND g.max_salary;
```

-----

**5 放在exists后面**
案例 查询有无名字为'abc'的员工信息
`SELECT EXISTS(SELECT * FROM employees WHERE last_name = 'abc');`//0,存在为1

----

### 子查询习题及答案

题1 查询各部门中工资比本部门平均工资高的员工的员工号、姓名和工资 

```sql
SELECT  employee_id,last_name,salary 
FROM employees e1 
JOIN 
  (SELECT AVG(salary) avg_sal,department_id did
  FROM employees 
  GROUP BY department_id) e2 
ON e1.department_id = e2.did 
WHERE e1.salary > e2.avg_sal ;
```

题2 查询和姓名中包含字母u的员工的在相同部门的员工号和姓名

```sql
SELECT employee_id,last_name 
FROM employees 
WHERE department_id IN
(SELECT DISTINCT department_id
FROM employees
WHERE last_name LIKE '%u%');
```


题3 查询管理者是K_ing的员工姓名和工资

```sql
SELECT last_name,salary 
FROM employees
WHERE manager_id IN
(SELECT employee_id FROM employees WHERE last_name ='K_ing');  
```

----

### 子查询经典题目及答案

1 查询工资最低的员工信息: last_name, salary

```sql
SELECT last_name,salary FROM employees
WHERE salary = (SELECT MIN(salary) FROM employees);
```

2 查询平均工资最低的部门信息

```sql
SELECT * FROM departments 
WHERE department_id =
(SELECT department_id
 FROM employees 
 GROUP BY department_id
  ORDER BY AVG(salary) 
  LIMIT 1);
```

3 查询平均工资最低的部门信息和该部门的平均工资

```sql
SELECT d.*,temp_table.asl
FROM departments d
JOIN
(SELECT department_id AS did,AVG(salary) AS asl
 FROM employees 
 GROUP BY department_id 
 ORDER BY asl 
 LIMIT 1) temp_table
ON d.department_id = temp_table.did;
```

4 查询平均工资最高的 job 信息

```sql
SELECT j.*
FROM jobs j
JOIN employees e
ON e.job_id=j.job_id
WHERE e.salary=
(SELECT AVG(salary) 
FROM employees 
GROUP BY job_id
ORDER BY AVG(salary) DESC 
LIMIT 1);
```

5 查询平均工资高于公司平均工资的部门有哪些?

```sql
SELECT t1.did,t1.asl FROM 
(SELECT AVG(salary) asl,department_id did FROM employees e GROUP BY department_id) t1,
(SELECT AVG(salary) asl FROM employees) t2
WHERE t1.asl>t2.asl;
```

6 查询出公司中所有 manager 的详细信息.

```sql
SELECT * FROM employees
WHERE employee_id IN
(SELECT DISTINCT manager_id FROM employees);
```

7 各个部门中,最高工资中最低的那个部门的最低工资是多少

```sql
SELECT MIN(salary) FROM employees 
WHERE department_id =
(SELECT department_id,MAX(salary) 
FROM employees GROUP BY department_id
ORDER BY MAX(salary) LIMIT 1);
```

8 查询平均工资最高的部门的 manager 的详细信息: last_name, department_id, email, salary  

```sql
SELECT e.* FROM employees e
JOIN
 (SELECT department_id FROM employees GROUP BY department_id ORDER BY AVG(salary) DESC LIMIT 1) t
ON e.department_id = t.department_id
WHERE e.employee_id IN 
(SELECT DISTINCT manager_id FROM employees WHERE department_id = t.department_id);
```



-----

### 9 分页查询

**应用场景：**
当页面上的数据一页显示不全，需要分页显示时
分页查询的sql命令请求数据库服务器->服务器响应到多条数据->前台页面
**语法：**

```sql
SELECT 查询列表 FROM 表名 WHERE 筛选条件
GROUP BY 分组条件 HAVING 分组后筛选
ORDER BY 排序列表
LIMIT 起始索引，显示的条目数
```

**执行顺序：**

```sql
FROM->WHERE->GROUP BY ->HAVING->SELECT->ORDER BY->LIMIT  
```

**特点：**
① 起始索引从0开始，不写默认从0开始
② 要显示的是第p页，每页显示s条
   则limit后参数为(p-1)*s,s

------

案例1 查询员工信息表的前5行

```sql
SELECT * FROM employees LIMIT 0,5;
SELECT * FROM employees LIMIT 5;
  
```

案例2 查询有奖金的且工资较高的11-20名

```sql
SELECT * FROM employees WHERE commission_pct IS NOT NULL
ORDER BY salary DESC LIMIT 10,10;
```

----

### 10 联合查询

**说明：**
当查询结果来自多张表，但多张表之间没有关联时，常使用联合查询
**语法：**

```sql
SELECT 查询列表 FROM 表1 WHERE 筛选条件...
UNION
SELECT 查询列表 FROM 表2 WHERE 筛选条件...
```

**特点：**
1 多条待联合的查询语句的查询列数必须一致，查询类型和字段意义最好一致
2 UNION 自动去重 UNION ALL 不去重，支持重复项

----

案例1 查询所有国家年龄大于20岁的用户信息

```sql
SELECT * FROM china WHERE age>20
UNION
SELECT * FROM usa WHERE uage>20;
```

案例2 查询所有国家的用户姓名和年龄

```sql
SELECT NAME,age FROM china
UNION
SELECT uname,uage FROM usa;
```

----

## DDL

Data Define Language 数据定义语言，用于对数据库和表的管理和操作

### 库的管理

**1 创建数据库**

```sql
CREATE DATABASE [IF NOT EXISTS] 数据库名;
```

**2 删除数据库**

```sql
DROP DATABASE IF EXISTS 数据库名;
```

 **3 修改数据库名**
 打开对应数据库文件夹选择重命名，并重启MySQL服务 
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200115102753740.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

-------

### 表的管理

**1 创建表**
语法：

```sql
CREATE TABLE [IF NOT EXISTS]表名(
	字段名 字段类型 [字段约束],
	...
	字段名 字段类型 [字段约束]
);
```

----

案例1 创建没有约束的学生信息表

```sql
CREATE TABLE stuinfo(
	id INT,
	NAME VARCHAR(20),
	sex CHAR,
	birtday DATETIME
);
```

----

**常见的数据类型：**

- `TINYINT/SMALLINT/INT/BIGINT` 
  整形 int最常用
- `DOUBLE/FLOAT(m,n)` 
  浮点型，m,n可选例如 DOUBLE(5,2)代表最多5位，其中必须有2位小数，即最大值999.99
- `DECIMAL(m,n)` 
  高精度浮点型，一般用在金融方面数据
- `CHAR(n)` 
  固定长度字符串类型,n可省略，默认1，不管实际存储都是开辟n个字符空间，空间换时间
- `VARCHAR(n)` 
  可变长度字符串类型，n不可省略，根据实际存储决定开辟的空间，时间换空间
- `TEXT` 
  字符串类型，表示存储较长文本
- `BLOB` 
  字节类型/二进制类型
- `DATE` 
  日期类型 yyyy-MM-dd
- `TIME` 
  时间类型 hh：mm：ss
- `TIMESTAMP/DATETIME` 
  时间戳类型，日期+时间 
  `datetime`，保存范围交大从1900-1-1开始，占字节8
  `timestamp`，保存范围较小，从1970-1-1~2038-12-31，占字节4

**常见的约束**
**说明：** 
用于限制表中字段数据的，用于保证数据表中的数据是一致的、准确的、可靠的

- `NOT NULL` 
  非空，限制字段为必选项
- `DEFAULT `
  默认，用于给没有插入值的字段赋初值
- `PRIMARY KEY`
  主键，限制字段的值不可重复，该字段默认不能为空，只能有一个主键，但可由多个字段组成
- `UNIQUE `
  唯一，限制该字段不能重复，可以为空，可以有多个唯一约束
- `CHECK `
  检查,限制该字段的值必须满足指定条件，MySQL不支持 CHECK 约束
- `FOREIGN KEY `
  外键，限制两个表的关系，要求外键列的值必须来自主表的关联列
  要求：
  ①主表的关联列必须是主键
  ②主表的关联列和从表的关联列的类型必须一致，意思一样，名称无要求
  ③要求在从表设置外键关系
  ④要求插入数据时，先插入主表，再插入从表，删除数据时，先删除从表，再删除主表。

**分类：**
表级约束：`PRIMARY KEY,UNIQUE,FOREIGN KEY`
列级约束：`NOT NULL,DEFAULT,UNIQUE,PRIMARY KEY,CHECK`
表级约束例：

```sql
CREATE TABLE students(
 id INT,
 NAME VARCHAR(10),
 majorId INT,
 CONSTRAINT pk PRIMARY KEY(id),
 CONSTRAINT uq UNIQUE(NAME),
 CONSTRAINT fk FOREIGN KEY(majorId) REFERENCES major(id)
);  
```

-----

案例2 创建有约束的学生信息表

```sql
CREATE TABLE stuinfo(
	id INT PRIMARY KEY,#主键约束
	NAME VARCHAR(20) UNIQUE,#唯一约束 
	sex CHAR DEFAULT '男',#默认约束
	birthday DATETIME NOT NULL#非空约束
	major_id INT,
	CONSTRAINT fk FOREIGN KEY major_id REFERENCES major(id)
	#外键格式 在最后添加 constraint 外键名 foreign key 从表关联列名 references 主表名(主表主键关联列)
);
```

----

**2 修改表**
**语法：**

```sql
ALTER TABLE 表名 ADD/MODIFY/CHANGE/DROP COLUMN 字段名 字段类型 [字段约束]
```

-----

案例1 修改表名

```sql
ALTER TABLE stuinfo RENAME TO stu;
```

案例2 添加字段

```sql
ALTER TABLE stuinfo ADD COLUMN age INT NOT NULL;
```

案例3 修改字段名

```sql
ALTER TABLE stuinfo CHANGE COLUMN sex gender CHAR DEFAULT '男'
```

案例4 修改字段类型

```sql
ALTER TABLE stuinfo MODIFY COLUMN birthday TIMESTAMP;
```

案例5 删除字段

```sql
ALTER TABLE stuinfo DROP COLUMN birthday;
```

----

**3 删除表**
**语法：**

```sql
DROP TABLE IF EXISTS 表名;
```

----

**4 复制表**  
**语法：**

```sql
CREATE TABLE 新表名 LIKE 旧表名; #仅复制表结构
CREATE TABLE 新表名 SELECT * FROM 旧表名;#复制表结构和数据
```

-----

案例 复制员工表的姓名，部门编号，工资字段到新表emp，但不复制数据

```sql
CREATE TABLE emp SELECT last_name,department_id,salary FROM employees WHERE 1=0;
```

-----

### 综合测试及答案

1.使用分页查询实现，查询员工信息表中部门为50号的工资最低的5名员工信息

```sql
SELECT * FROM employees WHERE department_id =50 ORDER BY salary ASC LIMIT 0,5;
```

2.使用子查询实现城市为Toronto的，且工资>10000的员工姓名

```sql
SELECT last_name FROM employees 
WHERE salary>10000 AND department_id IN
(SELECT department_id FROM departments d,locations l 
WHERE d.location_id=l.location_id  AND city = 'Toronto')
```

3.创建表qqinfo，里面包含qqid，添加主键约束、昵称nickname，添加唯一约束、邮箱email（添加非空约束）、性别gender

```sql
CREATE TABLE qqinfo(
	qqid INT PRIMARY KEY,
	nickname VARCHAR(20) UNIQUE,
	email VARCHAR(20) NOT NULL,
	sex CHAR
); 
```

4.删除表qqinfo

```sql
DROP TABLE IF EXISTS qqinfo;
```

5.试写出sql查询语句的定义顺序和执行顺序
定义顺序：

```sql
SELECT->FROM->JOIN ON->WHERE->GROUP BY->HAVING->ORDER BY->LIMIT 
```

执行顺序：

```sql
FROM->JOIN ON->WHERE->GROUP BY->HAVING->SELECT->ORDER BY->LIMIT
```

-----

## DML

Data Manipulation Language 数据操作语言，主要用于对数据的增删改

### 插入

**语法：**

```sql
INSERT INTO 表名(字段名1,字段名2...) VALUES(值1，值2...);
INSERT INTO 表名(字段名1,字段名2...) VALUES(值1，值2...),(值1，值2...)...(值1，值2...);
```

**特点：**
1 字段和值列表一一对应，包含类型、约束等必须匹配
2 数值型的值不用单引号，非数值型的值需要使用单引号
3 字段顺序无要求

----

例1:字段和值列表一一对应

```sql
INSERT INTO stuinfo(id,stuName,gender,seat,age,majorId) VALUES(3,'宁缺','男',3,20,1);
```


例2:可以为 NULL 的字段可以插入 NULL,或不写

```sql
INSERT INTO stuinfo(id,stuName,gender,seat,age,majorId) VALUES(4,'桑桑',NULL,NULL,NULL,NULL);
INSERT INTO stuinfo(id,stuName) VALUES(4,'桑桑');
```

例3:默认字段的插入插入 DEFAULT,或不写

```sql
INSERT INTO stuinfo(id,stuName,age) VALUES(4,'桑桑',DEFAULT);
INSERT INTO stuinfo(id,stuName) VALUES(4,'桑桑');
```

例4：插入所有字段 可省略字段名

```sql
INSERT INTO stuinfo VALUES(3,'宁缺','男',3,20,1);
```

例5：插入自增长字段

```sql
INSERT INTO stuinfo(stuName) VALUES('范闲');
```

**补充：设置自增长字段**
创建表时在字段后追加 AUTO_INCREMENT,必须搭配 PRIMARY KEY 或 UNIQUE,类型为数值型，一个表只能有一个自增长列。例:

```sql
CREATE TABLE t(id INT PRIMARY KEY AUTO_INCREMENT); 
```

-----

### 更新数据

**语法：**

```sql
UPDATE 表名 SET 字段名1=值1,字段名2=值2...
WHERE 筛选条件;
```

例：修改年龄小于20的学生的专业编号为3，且座位号更改为5

```sql
UPDATE students SET majorId=3,seat=5 WHERE age<20;
```

----

### 删除数据

**方式1
语法：**
`DELETE FROM 表名 WHERE 筛选条件;`

案例：删除姓李的所有信息

```sql
DELETE FROM students WHERE stuName LIKE '李%';
```

----

**方式2
语法：**
`TRUNCATE TABLE 表名;`

案例：删除表中所有数据
**TRUNCATE TABLE students;**

----

DELETE 和 TRUNCATE 的区别：
① DELETE 可以添加 WHERE 条件,TRUNCATE 不能，直接删除所有数据
② TRUNCATE 的效率较高，不需要逐行判断
③ 如果删除带自增长列的表，使用 DELETE 删除，插入数据后，记录从断点处开始，如果使用 TRUNCATE 则从1开始
④ DELETE 删除数据返回受影响的函数,TRUNCATE 不返回
⑤ DELETE 删除数据支持事务回滚,TRUNCATE 不支持

----

## 事务

 **什么是事务？**
一个事务是由一条或多条sql语句构成，这一条或者多条sql语句要么全部执行成功，要么全部执行失败。

----

**默认情况下，每条单独的sql语句就是一个单独的事务。**
例：银行转账，A要向B转账1000元，这需要两条sql语句：
①A的账户减去1000元 ②B的账户加上1000元。
设想如果在第一条sql语句执行成功后，在执行第二条sql语句之前程序被中断了，那么B的账户没有增加而A的账户却减少了1000，这肯定不是我们想要的结果。
因此我们需要事务来解决此类问题。

-----

### 事务的特性ACID

**原子性 atomicity**
事务中所有操作是不可分割的原子单位，事务中的所有操作要么全部执行成功，要么全部执行失败。

**一致性 consistency**
事务执行后，数据库状态与其他业务规则保持一致。如转账案例中，无论事务成功与否，参与转账的两个账户的金额之和应保持不变。

**隔离性 isolation**
在并发操作中，不同事务之间是互相隔离的，不会互相干扰。

**持久性 durability**
一旦事务提交成功，事务中所有的数据都必须被持久化到数据库中，即使提交数据后数据库崩溃，在数据库重启时，也必须保证通过某种机制恢复数据。

----

### MySQL中的事务

**1 隐式事务** 
没有明显的开始和结束标记
例如DML语句的 INSERT,UPDATE,DELETE 语句本身就是一条事务

**2 显式事务**
 具有明显的开始和结束标记
一般由多条sql语句组成，必须具有明显的开始和结束标记
**步骤：**
①取消事务的自动提交
②开启事务
③编写sql语句
④结束事务

转账案例

```sql
SET autocommit = 0;
START TRANSACTION;
UPDATE account SET money=money-1000 WHERE NAME = 'A';
UPDATE account SET money=money+1000 WHERE NAME = 'B';
COMMIT;
```

----

### 隔离级别

**脏读：**
对于两个事务T1和T2，T1读取了已被T2 更新但还没有提交 的字段，之后若T2回滚，T1读取的内容是临时且无效的。
比如事务B执行过程中修改了数据D，在未提交前事务A读取了D，而事务B却回滚了，这样事务A就形成了脏读，也就是说，当前事务读到的数据是别的事务想要修改但是没有修改成功的数据。
**不可重复读：**
T1读取了一个字段，T2 更新该字段并提交 ，T1再次读取同一字段，值不同。
比如事务A首先读取了一条数据，然后执行逻辑的时候，事务B将这条数据改变了，然后事务A再次读取的时候，发现数据不匹配了，就是所谓的不可重复读。
也就是说，当前事务先进行了一次数据读取，然后再次读取到的数据是别的事务修改成功的数据，导致两次读取到的数据不匹配。
**幻读：**
T1读取了一个字段，T2在该表中插入了一些新行，之后T1再读取同一个表会多出几行。
比如事务A首先根据条件索引得到N条数据，然后事务B改变了这N条数据之外的M条或者增添了M条符合事务A搜索条件的数据，导致事务A再次搜索发现有N+M条数据了，就产生了幻读。也就是说，当前事务读第一次取到的数据比后来读取到数据条目少。

----

**MySQL支持四个隔离级别**

- 读未提交（存在脏读、不可重复读、幻读）
- 读已提交（解决脏读，存在不可重复读和幻读）
- 可重复读（默认，解决脏读，不可重复读，存在幻读）
- 可串行化（解决所有并发问题，但效率较低）

---

## 视图

**含义：** 
MySQL从5.0.1版本开始提供的功能，是一种虚拟存在的表，行和列的数据来自定义视图的查询中使用的表，并且是在使用视图时动态生成的，只保存了sql逻辑，不保存查询结果。

**应用场景：**
多个地方用到相同的查询结果。
该查询结果使用的sql语句比较复杂。

**好处：**
实现了sql语句的重用
简化了复杂的sql操作，不必知道其细节
保护数据，提高安全性

-----

| 类型 | 关键字 | 是否实际占用物理空间 | 使用                 |
| ---- | ------ | -------------------- | -------------------- |
| 视图 | VIEW   | 仅保持了sql逻辑      | 增删改查，一般只能查 |
| 表   | TABLE  | 保存了数据           | 增删改查             |

------

案例 查询姓张的学生名和专业名
不使用视图

```sql
SELECT stuName,majorName
FROM stuinfo s
INNER JOIN major m ON s.majorId=m.id
WHERE s.stuname LIKE '张%'; 
```

使用视图

```sql
CREATE VIEW v1
AS
SELECT stuName,majorName
FROM stuinfo s
INNER JOIN major m ON s.majorId=m.id;

SELECT * FROM v1
WHERE stuName LIKE '张%';
```

----

### **1 创建视图**

**语法：**

```sql
CREATE VIEW 视图名 AS 查询语句;
```

案例1 查询姓名中包含a字符的员工名，部门名和工种信息

```sql
CREATE VIEW v2 
AS
SELECT last_name,department_name,job_title
FROM employees e
JOIN departments d ON e.department_id=d.department_id
JOIN jobs j ON j.job_id=e.job_id;

SELECT * FROM v2
WHERE last_name LIKE '%a%';
```

----

案例2 查询各部门的平均工资级别

```sql
CREATE VIEW v3
AS
SELECT AVG(salary) asl,department_id 
FROM employees
GROUP BY department_id;

SELECT v3.*,g.`grade` FROM v3
JOIN sal_grade g 
ON v3.`asl` BETWEEN g.`min_salary` AND g.`max_salary`;
```

----

案例3 查询平均工资最低的部门信息

```sql
SELECT * FROM departments 
WHERE department_id=
(SELECT department_id FROM v3 ORDER BY asl LIMIT 1);
```

----

案例4 查询平均工资最低的部门名和工资

```sql
CREATE VIEW v4
AS
SELECT * FROM v3 ORDER BY asl LIMIT 1;

SELECT d.`department_name`,v4.`asl` FROM v4
JOIN departments d
ON d.`department_id`=v4.`department_id`;
```

案例5 创建视图emp_v1,要求查询电话号码以'011'开头的员工姓名和工资、邮箱

```sql
CREATE VIEW emp_v1
AS
SELECT last_name,salary,email FROM employees
WHERE phone_number LIKE '011%';

SELECT * FROM emp_v1;
```

案例6 创建视图emp_v2,要求查询部门的最高工资高于12000的部门信息

```sql
CREATE VIEW emp_v2
AS
SELECT department_id FROM employees
GROUP BY department_id 
HAVING MAX(salary)>12000;

SELECT d.* FROM departments d
JOIN emp_v2 ON d.`department_id` = emp_v2.`department_id`;
```

----

### **2 修改视图**

方式一 存在则修改，不存在则创建

```sql
CREATE OR REPLACE VIEW 视图名 AS 查询语句;
```

方式二 

```sql
ALTER VIEW 视图名 AS 查询语句;
```

----

### **3 删除视图**

**语法：**

```sql
DROP VIEW 视图名1,视图名2...;
```

----

### **4 查看视图**

查看视图结构
**语法：** `desc 视图名;`
例：`desc v3;`

查看视图创建过程
**语法:**`SHOW CREATE VIEW 视图名;`
例: `SHOW CREATE VIEW v3;`

----

### 5 视图的更新

**特点：**
视图的可更新性和视图中查询的定义有关，以下类型的视图不能更新：

- 包含以下关键字: 分组函数,DISTINCT,GROUP BY,HAVING,UNION,UNION ALL

- 常量视图，例: 

  ```sql
  CREATE VIEW v AS SELECT 'abc' NAME;
  ```

- SELECT 中包含子查询，例: 	

  ```sql
  CREATE VIEW v AS SELECT(SELECT 1) AS number;
  ```

- JOIN，例: 

  ```sql
  CREATE VIEW v AS 
  SELECT * FROM employees e JOIN departments d
  ON e.department_id=d.department_id;
  ```

- FROM 一个不能更新的视图，例：

  ```sql
  CREATE VIEW v2 AS 
  SELECT * FROM v;
  ```

- WHERE 子句的子查询引用了 FROM 子句中的表，例：

  ```sql
  CREATE VIEW v AS 
  SELECT * FROM employees
  WHERE employees_id IN (SELECT DISTINCT manager_id FROM employees);
  ```

-----

**环境准备**

```sql
CREATE OR REPLACE VIEW v1
AS
SELECT last_name,email FROM employees;
```

**1 插入数据**

```sql
INSERT INTO v1 VALUES('宁缺','abc@qq.com');
```

**2 修改数据**

```sql
UPDATE v1 SET last_name='桑桑' WHERE last_name='宁缺';
```

**3 删除数据**

```sql
DELETE FROM v1 WHERE last_name='桑桑';
```

----

### 综合练习

1 创建Book表，字段如下：
bid 整形，要求主键
bname 字符型，要求设置唯一非空
price 浮点型，要求默认值10
btypeId 类型编号，要求引用bookType表的id字段
已知bookType表字段如下：id，name

```sql
CREATE TABLE Book(
	bid INT PRIMARY KEY AUTO_INCREMENT,
	bname VARCHAR(10) UNIQUE NOT NULL,
	price FLOAT DEFAULT 10,
	btypeId INT,
	CONSTRAINT fk FOREIGN KEY(btypeId) REFERENCES bookType(id)
);
```

2 开启事务，向表中插入一行数据并结束

```sql
SET autocommit=0;
INSERT INTO Book VALUES(1,'将夜',20,2);
COMMIT;
```

3 创建视图，实现查询价格大于100的书名和类型名

```sql
CREATE VIEW v AS
SELECT bname,btypeId FROM Book b 
JOIN bookType t ON b.btypeId=t.id
WHERE b.price>100;
```

4 修改视图，实现查询价格在90-120之间的书名和价格

```sql
CREATE OR REPLACE v AS
SELECT bname,price
FROM Book
WHERE price BETWEEN 90 AND 120;
```

5 删除刚才创建的视图

```sql
DROP VIEW v;
```

-----

## 变量

### 系统变量

根据作用范围分为全局变量，会话变量
全局变量是由系统提供的，属于服务器范围，服务器重启后重新赋值
会话变量仅针对当前会话（连接）有效

----

语法：
1 查看所有的全局变量

```sql
SHOW GLOBAL VARIABLES;
```

2 查看所有的会话变量

```sql
SHOW SESSION VARIABLES;
SHOW VARIABLES;默认查看会话变量
```

3 查看部分系统变量
例: 查看字符集相关的系统变量

```sql
SHOW GLOBAL VARIABLES LIKE '%char%';
SHOW [SESSION] VARIABLES LIKE '%char%';
```

4 查看某个系统变量

```sql
SELECT @@global.系统变量名;
SELECT @@[session.]系统变量名;不写默认为session
```

例：查看自动提交 

```sql
SELECT @@global.autocommit;
SELECT @@[session.]autocommit;
```

例：查看隔离级别

```sql
SELECT @@global.transaction_isolation;
SELECT @@[session.]transaction_isolation;
```

5 为某个系统变量赋值

```sql
SET GLOBAL|[SESSION] 系统变量名 =值;
SET @@GLOBAL|[SESSION].系统变量名 =值;
```

如果是全局级别需要加global，如果是会话级别加session或不写。

-----

### 自定义变量

**说明：** 变量是用户自定义的，不是由系统提供
**使用步骤：** ①声明②赋值③使用
根据作用范围分为用户变量，局部变量

-----

#### 用户变量

**作用域：** 针对于当前会话（连接）有效，同于会话变量的作用域
应用在任何地方，可以放在 BEGIN END 里面或外面
**①声明并初始化**

```sql
SET @用户变量名= 值;
SET @用户变量名: = 值;
SELECT @用户变量名: = 值;
```

**②赋值（更新用户变量值）**
方式一：通过 SET 或 SELECT

```sql
SET @用户变量名= 值;
SET @用户变量名: = 值;
SELECT @用户变量名: = 值;
```

例：

```sql
SET @name='abc';
SET @name=1;
```

----

方式二：通过 SELECT INTO

```sql
SELECT 字段 INTO @用户变量名 FROM 表;
```

例：

```sql
SET @count=1;
SELECT COUNT(*) INTO @count FROM employees;
SELECT @count;//107
```

----

**③查询**

```sql
SELECT @变量名;
```

案例 声明2个用户变量并赋初值，求和并打印

```sql
SET @num1 = 1;
SET @num2 = 2;
SET @sum = @num1 + @num2;
SELECT @sum; //3
```

----

#### 局部变量

**作用域：** 仅在定义它的 BEGIN END 中有效
应用在 BEGIN END 中的第一句话
**使用：**
**①声明**

```sql
DECLARE 变量名 类型;
DECLARE 变量名 类型 DEFAULT 值;
```

**②赋值**
方式一：通过 SET 或 SELECT

```sql
SET 局部变量名= 值;
SET 局部变量名: = 值;
SELECT @局部变量名: = 值;
```

方式二：通过 SELECT INTO

```sql
SELECT 字段 INTO 局部变量名 FROM 表;
```

**③查询**

```sql
SELECT 局部变量名;
```

-----

| 类型     | 作用域      | 定义和使用的位置               | 语法                        |
| -------- | ----------- | ------------------------------ | --------------------------- |
| 用户变量 | 当前会话    | 会话中的任何地方               | 必须加@符号，不用限定类型   |
| 局部变量 | BEGIN END中 | 只能在 BEGIN END中，且为第一句 | 一般不加@符号，需要限定类型 |

----

## 存储过程

**含义：** 
一组预先定义好的sql语句的集合

**好处：**
提高代码重用性、简化操作、减少编译次数，减少和数据库连接次数

### 1 创建

**语法：**

```sql
CREATE produce 存储过程名(参数列表)
BEGIN
  sql语句...
END
```

注意：

- 1 参数列表包含三部分： 参数模式 参数名 参数类型
  例： IN NAME VARCHAR
  参数模式: 
  IN 该参数可作为输入
  OUT 该参数可作为输出，即返回值
  INOUT 该参数既可以作为输入，也可以作为输出
- 2 如果存储过程里面仅有一句sql语句,BEGIN END 可以省略

- 3 存储过程体中的每条sql语句必须加;，存储过程的结尾可以用 DELIMITER 重新设置
  DELIMITER $ 可将 $作为结束标记

----

### 2 调用

**语法：**

```sql
CALL 存储过程名(实参列表);
```

------

环境准备，admin表：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200117171606418.png)
**1 空参列表**
案例 插入到admin表中2条记录

```sql
DELIMITER $
CREATE PROCEDURE myp1()
BEGIN
   INSERT INTO admin(username,PASSWORD) VALUES('aaa','123'),
   ('bbb','123');
END$
```

注意，需要在命令行中执行
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200117172237615.png)
调用后，再次查询admin表，发现成功插入
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200117172302823.png)

----

**2 带in模式参数的存储过程**

案例1 根据女神名查询对应的男生信息

```sql
DELIMITER $
CREATE PROCEDURE myp2(IN girl_name VARCHAR(20))
BEGIN
   SELECT bo.* FROM boys bo 
   RIGHT JOIN beauty b ON bo.id=b.boyfriend_id
   WHERE b.name=girl_name;
END$
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200117173101626.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

----

案例2 判断admin用户是否登陆成功

```sql
CREATE PROCEDURE myp3(IN usr VARCHAR(20),IN pwd VARCHAR(20))
BEGIN
   DECLARE result VARCHAR(20) DEFAULT '';
   SELECT COUNT(*) INTO result FROM admin
   WHERE username=usr AND PASSWORD=pwd;
   SELECT IF(result=0,'失败','成功');
END$
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200117173730340.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

----

**3 带out模式参数的存储过程**

案例1 根据女神名返回对应男生名

```sql
CREATE PROCEDURE myp4(IN girlName VARCHAR(20),OUT boyName VARCHAR(20))
BEGIN
    SELECT bo.boyName INTO boyName 
    FROM boys bo
    JOIN beauty b ON bo.id=b.boyfriend_id
    WHERE b.name=girlName;
END$
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200117180755890.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

---

案例2 根据女神名，返回对应男生名和其魅力值

```sql
CREATE PROCEDURE myp5(IN girlName VARCHAR(20),OUT boyName VARCHAR(20),OUT usercp INT)
BEGIN
    SELECT bo.boyName,bo.userCP INTO boyName,usercp 
    FROM boys bo
    JOIN beauty b ON bo.id=b.boyfriend_id
    WHERE b.name=girlName;
END$
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/2020011718121174.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

----

**4 带inout模式参数的存储过程**

案例 传入a和b两个值，最终a和b翻倍并返回

```sql
CREATE PROCEDURE myp6(INOUT a INT,INOUT b INT)
BEGIN
    SET a=a*2;
    SET b=b*2;
END$
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200117181757605.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
**3 删除**
**语法：**

```sql
DROP PROCEDURE 存储过程名;
```

**4 查看存储过程的信息**
**语法：**

```sql
SHOW CREATE PROCEDURE 存储过程名;
```

----

### 存储过程习题

1 创建存储过程实现传入用户名和密码，插入到admin表

```sql
CREATE PROCEDURE p(IN username VARCHAR(20),IN PASSWORD VARCHAR(20))
BEGIN
    INSERT INTO admin(username,PASSWORD) VALUES(username,PASSWORD);
END$
```

2 创建存储过程实现传入女神编号，返回女神名称和女神电话

```sql
CREATE PROCEDURE p(IN girl_id INT,OUT girl_name VARCHAR(20),OUT girl_tel VARCHAR(20))
BEGIN
    SELECT NAME,phone INTO girl_name,girl_tel
    FROM beauty WHERE id=girl_id;
END$
```

3 创建存储过程实现传入两个女神生日，返回大小

```sql
CREATE PROCEDURE p(IN date1,IN date2,OUT res)
BEGIN
    SELECT DATEDIFF(date1,date2)
    INTO res;
END$
```

4 创建存储过程实现传入一个日期，格式化为xx年xx月xx日并返回

```sql
CREATE PROCEDURE datep(IN DATE DATE,OUT result VARCHAR(20))
BEGIN
   SELECT DATE_FORMAT(DATE,'%y年%m月%d日')
   INTO result;
END$
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200117183629250.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
5 创建存储过程，实现传入女神名，返回 女神名 AND 男神名 格式的字符串

```sql
CREATE PROCEDURE p(IN NAME VARCHAR(20),OUT str VARCHAR(20))
BEGIN
   SELECT CONCAT(b.name,' and ',bo.boyName)
   FROM beauty b JOIN boys bo
   ON b.boyfriend_id=bo.id
   WHERE b.name=NAME;
END$
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200117184739983.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

6 创建存储过程，根据传入的条目数和起始索引，查询beauty表记录

```sql
CREATE PROCEDURE p(IN INDEX INT,IN num INT)
BEGIN
   SELECT * FROM beauty LIMIT INDEX,num;
END$
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200117185009922.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

------

## 函数

含义和存储过程类似，区别是：
存储过程可以有0或多个返回值，适合做批量插入、批量更新
函数有且仅有一个返回值，适合做处理数据后返回一个结果

----

### 1 创建

**语法：**

```sql
CREATE FUNCTION 函数名(参数列表) RETURNS 返回类型
BEGIN
 函数体
END
```

注意：
参数列表包含 参数名，参数类型
函数体必须有 RETURN 语句
当函数体只有一句话时可以省略 BEGIN END
使用 DELIMITER 设置结束标记

### 2 调用

```sql
SELECT 函数名(参数列表);
```

案例1 无参数有返回值：返回公司的员工个数

```sql
CREATE FUNCTION f1() RETURNS INT
BEGIN
  DECLARE num INT DEFAULT 0;
  SELECT COUNT(*) INTO num FROM employees;
  RETURN num;
END$
```

如果出现1418错误，在客户端上执行`SET GLOBAL log_bin_trust_function_creators = 1$`
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200117221050516.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

-----

案例2 有参数有返回值：根据公司的员工名返回他的工资

```sql
CREATE FUNCTION f2(ename VARCHAR(20)) RETURNS DOUBLE
BEGIN
  DECLARE salary DOUBLE DEFAULT 0;
  SELECT employees.salary INTO salary FROM employees
  WHERE last_name = ename;
  RETURN salary;
END$
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200117221653767.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

--------

案例3 根据部门名返回平均工资

```sql
CREATE FUNCTION f3(dname VARCHAR(20)) RETURNS DOUBLE
BEGIN
  DECLARE sal DOUBLE DEFAULT 0;
  SELECT AVG(salary) INTO sal FROM employees e
  JOIN departments d ON e.department_id=d.department_id
  WHERE d.department_name=dname;
  RETURN sal;
END$
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200117222408260.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
案例4 传入两个float值，返回和

```sql
CREATE FUNCTION fadd(num1 FLOAT,num2 FLOAT) RETURNS FLOAT
BEGIN
   SET @sum=num1+num2;
   RETURN @sum;
END$
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200117223017541.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

----

### 3 查看

**语法：**

```sql
show create function 函数名;
```

----

### 4 删除

**语法：**

```sql
drop function 函数名;
```

-------

## 流程控制结构

顺序结构：程序从上往下依次执行
分支结构：程序从多条路径中选择一条执行
循环结构：程序在满足一定条件的基础上，重复执行一段代码

-------

### 分支结构

**1 IF 函数**
**功能：** 实现简单的双分支
**语法：**

```sql
SELECT IF(exp1,exp2,exp3);
```

如果exp1成立返回exp2的值，否则返回exp3的值

**应用：** 任何地方

----

**2 CASE 结构**
**作为表达式：**
情况1：类似switch ，实现等值判断
**语法：**

```sql
CASE 变量名|表达式|字段
WHEN 值1 THEN 返回值1
...
WHEN 值n THEN 返回值n
ELSE 要返回的值m
END;
```

情况2：类似多重if，实现区间判断
**语法：**

```sql
CASE 
WHEN 条件1 THEN 返回值1
...
WHEN 条件n THEN 返回值n
ELSE 要返回的值m
END;
```

**作为独立语句时：**
情况1：类似switch ，实现等值判断

```sql
CASE 变量名|表达式|字段
WHEN 值1 THEN 语句1;
...
WHEN 值n THEN 语句值n;
ELSE 语句m;
END CASE;
```

情况2：类似多重if，实现区间判断
**语法：**

```sql
CASE 
WHEN 条件1 THEN 语句1;
...
WHEN 条件n THEN 语句n;
ELSE 语句m;
END CASE;
```


**特点：**

- 可以作为表达式，嵌套在其他语句使用，可以放在任何地方
- 可以作为独立语句使用，只能放在 BEGIN END 中,END 后要加 CASE
- 如果when中的值或条件成立，执行对应then后面的语句，结束 CASE,都不满足执行 ELSE 中的语句
- ELSE 可以省略，如果都不满足返回 NULL

案例 创建存储过程，根据传入的成绩，返回等级

```sql
CREATE PROCEDURE p(IN grade INT)
BEGIN
   CASE 
   WHEN grade BETWEEN 90 AND 100 THEN SELECT 'A';
   WHEN grade BETWEEN 80 AND 90 THEN SELECT 'B';
   WHEN grade BETWEEN 60 AND 80 THEN SELECT 'C';
   ELSE SELECT 'D';
   END CASE;
END$
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200118002645133.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

----

**3 IF 结构**
**功能：** 实现多重分支
**限制：** 只能用在 BEGIN END 中
**语法：**

```sql
IF 条件1 THEN 语句1;
ELSEIF 条件2 THEN 语句2;
...
ELSE 语句n;
END IF;
```

案例 根据传入的成绩，返回等级

```sql
CREATE FUNCTION f(grade INT) RETURNS CHAR
BEGIN
   IF grade BETWEEN 90 AND 100 THEN RETURN 'A';
   ELSEIF grade BETWEEN 80 AND 90 THEN RETURN 'B';
   ELSEIF grade BETWEEN 60 AND 80 THEN RETURN 'C';
   ELSE RETURN 'D';
   END IF;
END$
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200118002336776.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

-----

### 循环结构

**分类：**
WHILE LOOP REPEAT
**循环控制：**
ITERATE 类似于continue 结束本次循环，继续下一次
LEAVE 类似于break，结束当前所在循环

**1 WHILE
语法：**

```sql
[标签名:]WHILE 循环条件 DO
循环体;
END WHILE [标签名];
```

**2 LOOP
语法：**

```sql
[标签名:] LOOP
 循环体;
END LOOP [标签名];
```

可以模拟死循环

**3 REPEAT**
**语法：**

```sql
[标签名:] REPEAT
循环体;
UNTIL 结束循环的条件
END REPEAT [标签名];
```

案例 批量插入，根据插入次数插入admin表中多条记录

```sql
DELIMITER $
CREATE PROCEDURE p(IN insert_time INT)
BEGIN
  DECLARE i INT DEFAULT 1;
  WHILE i<=insert_time DO 
  INSERT INTO admin(username,PASSWORD) VALUES ('a','1');
  SET i=i+1;
  END WHILE;
END$
```

案例 批量插入，根据插入次数插入admin表中多条记录，若次数大于5则停止

```sql
DELIMITER $
CREATE PROCEDURE p(IN insert_time INT)
BEGIN
  DECLARE i INT DEFAULT 1;
  a:WHILE i<=insert_time DO
  IF i>20 THEN LEAVE a;
  END IF;
  INSERT INTO admin(username,PASSWORD) VALUES ('a','1');
  SET i=i+1;
  END WHILE;
END$
```

案例 批量插入，根据插入次数插入admin表中多条记录，只插入偶数次

```sql
DELIMITER $
CREATE PROCEDURE p(IN insert_time INT)
BEGIN
  DECLARE i INT DEFAULT 0;
  a:WHILE i<=insert_time DO
  SET i=i+1;
  IF MOD(i,2)<>0 THEN ITERATE a;
  END IF;
  INSERT INTO admin(username,PASSWORD) VALUES ('a','1');
  END WHILE;
END$
```

-------

## Linux下MySQL的安装

这里使用的环境是centos8.0，vm15，linux的安装可以看我之前的文章
打开终端，键入命令：`sudo dnf install @mysql`将自动下载mysql8.0.17，一路按y即可。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200116131004134.png)
安装完成后，启动MySQL并使它以后自动启动：`$ sudo systemctl enable --now mysqld`
（这里如果失败的话可能是安装时选择了自动分区..我换成自定义分区就好了）
要检查MySQL服务器是否正在运行，请输入：`$ sudo systemctl status mysqld`
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200116142334970.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
运行mysql_secure_installation脚本，该脚本执行安全性相关的操作并设置root用户密码：
`$ sudo mysql_secure_installation`
一路按y，并设置密码即可。
之后输入`mysql -uroot -p`和你的密码即可成功登陆mysql。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200116142754911.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

------

## 索引

### 概述

**官方定义：** 索引是帮助MySQL高效获取数据的数据结构（有序）。
除了数据之外，数据库还维护着满足特定查找算法的数据结构，这些数据结构以某种方式指向数据，这样就可以在这些数据结构上实现高级查找算法，这种数据结构就是索引。

**有无索引对比示意图：**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200116102404642.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
 左边是数据表，一共有两列七条记录，最左边的是数据记录的物理地址（逻辑上相邻的记录在磁盘上并不一定物理相邻）。
此时如果我们想要查找Col2这一列值为3的这条记录，**需要从第一条遍历到最后一条**，一共需要7次，当数据增多时效率会更低。

为了加快Col2的查找，可以维护一个右边所示的**二叉查找树**（左孩子小于父结点，右孩子大于父结点），每个结点分别包含索引键值和一个指向对应数据记录物理地址的指针，这样就可以运用二叉查找快速获取到相应数据。
此时如果我们要查找Col2这一列值为3的记录，**只需要查找3次**即可（3小于34，往左子树寻找->3小于5，往左子树寻找->成功）。

 一般来说索引本身也很大，不可能全部存储在内存中，因此索引往往以索引文件的形式存储在磁盘上，索引是数据库中用来提高性能的最常用的工具。

----

###  优缺点

**优点**

> - 类似于书籍的目录索引，提高数据检索的效率，降低数据库的IO成本。
> - 通过索引列对数据进行排序，降低数据排序的成本，降低CPU的消耗。

**缺点**

> - 实际上索引也是一张表，该表中保存了主键与索引字段，并指向实体类的记录，所以索引列也是要占用空间的。
> - 虽然索引大大提高了查询效率，同时却也降低更新表的速度，如对表进行INSERT、UPDATE、DELETE。因为更新表时，MySQL 不仅要保存数据，还要保存一下索引文件每次更新添加了索引列的字段，都会调整因为更新所带来的键值变化后的索引信息。

----

### 结构

索引是在MySQL的**存储引擎层**中实现的，而不是在**服务器层**实现的。
MySQL目前提供了以下4种索引：

> - BTree 索引 ： 最常见的索引类型，大部分索引都支持 BTree索引。
> - Hash 索引：只有Memory引擎支持 ， 使用场景简单 。
> - R-tree 索引（空间索引）：空间索引是MyISAM引擎的一个特殊索引类型，主要用于地理空间数据类型，通常使用较少。
> - Full-text （全文索引） ：全文索引也是MyISAM的一个特殊索引类型，主要用于全文索引，InnoDB从Mysql5.6版本开始支持全文索引。


| 索引        | InnoDB引擎      | MyISAM引擎 | Memory引擎 |
| ----------- | --------------- | ---------- | ---------- |
| BTREE索引   | 支持            | 支持       | 支持       |
| HASH 索引   | 不支持          | 不支持     | 支持       |
| R-tree 索引 | 不支持          | 支持       | 不支持     |
| Full-text   | 5.6版本之后支持 | 支持       | 不支持     |

<center><b>表  MyISAM、InnoDB、Memory三种存储引擎对各种索引类型的支持</b></center>

---

我们平常所说的索引，如果没有特别指明，都是指**B+树**（多路搜索树，并不一定是二叉的）结构组织的索引。其中聚集索引、复合索引、前缀索引、唯一索引默认都是使用 B+tree 索引，统称为索引。

----

 **BTree**
BTree又叫多路平衡搜索树，一颗m叉的BTree特性如下：

> - 树中每个结点最多包含m个孩子。
> - 除根结点与叶子结点外，每个结点至少有[ceil(m/2)]个孩子。
> - 若根结点不是叶子结点，则至少有两个孩子。
> - 所有的叶子结点都在同一层。
> - 每个非叶子结点由n个key与n+1个指针组成，其中[ceil(m/2)-1] <= n <= m-1（ceil为向上取整）。当n>m-1时，中间结点分裂到父节点，两边结点分裂。

以5叉BTree为例，m=5，所以 [ceil(5/2)-1]=2 <= n <=4 。
插入 C N G A H E K Q M F W L T Z D P R X Y S 数据为例。
演变过程如下：
**1) 插入前4个字母 C N G A** 
由于字母顺序A<C<G<N，所以插入结果为ACGN：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200116110043589.png)
**2) 插入H，此时由于n=4+1>4，中间元素G字母向上分裂成为父结点**

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200116110526899.png)

**3) 插入E，K，Q不需要分裂**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200116110557916.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
**4) 插入M，此时图中右下角结点HKMNQ的k=5，因此中间元素M字母向上分裂到父节点G**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200116110705529.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
**5) 插入F，W，L，T不需要分裂**

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200116110913124.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
**6) 插入Z，此时NQTWZ的k=5，中间元素T需要向上分裂到父结点GM中** 
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200116111003517.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
**7)插入D，ACDEF的k=5，中间元素D向上分裂到父结点GMT中。然后插入P，R，X，Y不需要分裂**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200116111053344.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

**8) 最后插入S，NPQRS结点n=5，中间结点Q向上分裂到父结点DGMT中，但分裂后父节点DGMQT的n=5，中间节点M向上分裂**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200116111239127.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
到此该BTREE树就已经构建完成了，对于前面Btree的特点，该数的m=5，因此：

> - 树中每个结点最多包含5个孩子。
> - 除根结点与叶子结点外，每个结点至少有3个孩子。
> - 若根结点不是叶子结点，则至少有两个孩子。
> - 所有的叶子结点都在同一层。
> - 每个非叶子结点由n个key与n+1个指针组成，其中2<= n <=4（ceil为向上取整）。当n>4时，中间结点分裂到父节点，两边结点分裂。

 BTREE和二叉树相比， **查询数据的效率更高**， 因为对于相同的数据量来说，**BTREE的层级结构比二叉树小**（深度小，需要遍历的次数小），因此搜索速度快。

----

**B+Tree**
B+Tree为BTree的变种，B+Tree与BTree的区别为：

> - n叉B+Tree最多含有n个key，而BTree最多含有n-1个key。（之前的5叉树每个结点最多有4个key，如果是B+数则最多有5个，如下图的3叉B+树，每个结点最多3个key）
> - B+Tree的叶子结点保存所有的key信息，依key大小顺序排列。
> - 所有的非叶子结点都可以看作是key的索引部分。
> - 由于B+Tree只有叶子结点保存key信息，查询任何key都要从root走到叶子。所以B+Tree的查询效率更加稳定。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200116112431545.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

----

**MySQL中的B+Tree**
MySql索引数据结构对B+Tree进行了优化，在B+Tree的基础上，**增加一个指向相邻叶子结点的链表指针**，就形成了**带有顺序指针**的B+Tree，提高区间访问的性能。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200116112804119.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

<center><b> MySQL中的 B+Tree 索引结构示意图</b></center>

----

### 分类

1） 单值索引 ：即一个索引只包含单个列，一个表可以有多个单列索引。
2） 唯一索引 ：索引列的值必须唯一，但允许有空值。
3） 复合索引 ：即一个索引包含多个列，例如用身份证号和考生号两列作为复合索引。

----

### 语法及实例

**环境准备**
在Linux终端键入以下sql代码

```sql
CREATE DATABASE test2 DEFAULT CHARSET=utf8mb4;

USE test2;

CREATE TABLE `city` (
  `city_id` INT(11) NOT NULL AUTO_INCREMENT,
  `city_name` VARCHAR(50) NOT NULL,
  `country_id` INT(11) NOT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `country` (
  `country_id` INT(11) NOT NULL AUTO_INCREMENT,
  `country_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`country_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;


INSERT INTO `city` (`city_id`, `city_name`, `country_id`) VALUES(1,'西安',1);
INSERT INTO `city` (`city_id`, `city_name`, `country_id`) VALUES(2,'NewYork',2);
INSERT INTO `city` (`city_id`, `city_name`, `country_id`) VALUES(3,'北京',1);
INSERT INTO `city` (`city_id`, `city_name`, `country_id`) VALUES(4,'上海',1);

INSERT INTO `country` (`country_id`, `country_name`) VALUES(1,'China');
INSERT INTO `country` (`country_id`, `country_name`) VALUES(2,'America');
INSERT INTO `country` (`country_id`, `country_name`) VALUES(3,'Japan');
INSERT INTO `country` (`country_id`, `country_name`) VALUES(4,'UK');
```

此时环境准备完毕，创建了city表和country表：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200116143016629.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

------

**创建索引**
**语法：**

```sql
CREATE 	[UNIQUE|FULLTEXT|SPATIAL]  INDEX 索引名 
[USING  索引类型]#如果不指定则为B+Tree
ON 表名(列名,...)
```

例：给city表的city_name列创建索引

```sql
CREATE INDEX index_city_cityname ON city(city_name);
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200116143106190.png)

-----

**查看索引**
**语法：**

```sql
SHOW INDEX FROM 表名;
```

例：查看city表的索引

```sql
SHOW INDEX FROM city;
```

结果（主键默认有主键索引），可以看到默认索引类型为B+tree。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200116143250586.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

-----

**删除索引**
**语法：**

```sql
DROP INDEX 索引名 ON 表名
```

例：删除刚才在city表创建的索引

```sql
DROP INDEX index_city_citynam ON city;
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200116143350502.png)

-----

 **Alter命令**
1)添加一个主键，这意味着索引值必须是唯一的，且不能为NULL

```sql
ALTER  TABLE  表名 ADD  PRIMARY  KEY(列名);
```

例：给city表的id添加主键索引

```sql
ALTER TABLE city ADD PRIMARY KEY(id);
```

-----

2)这条语句创建索引的值必须是唯一的（除了NULL外，NULL可能会出现多次）

```sql
ALTER  TABLE  表名  ADD  UNIQUE 索引名(列名);	
```

例：给city表的city_name添加唯一索引

```sql
ALTER TABLE city ADD UNIQUE idx_city_name(city_name);
```

----

3)添加普通索引， 索引值可以出现多次。

```sql
 ALTER  TABLE  表名  ADD  INDEX 索引名(列名);	
```

例：给city表的city_name添加普通索引

```sql
ALTER TABLE city ADD INDEX idx_city_name(city_name);
```

-----

4)该语句指定了索引为FULLTEXT， 用于全文索引

```sql
ALTER  TABLE  表名  ADD  FULLTEXT  索引名(列名);
```

-----

### 设计原则

- 对**查询频次较高**，且**数据量比较大**的表建立索引。
- 索引字段的选择，最佳候选列应当**从where子句的条件**中提取，如果where子句中的组合比较多，那么应当挑选最常用、过滤效果最好的列的组合。
- 使用**唯一索引**，区分度越高，使用索引的效率越高。
- 索引可以有效的提升查询数据的效率，但**索引数量不是多多益善**，索引越多，维护索引的代价自然也就越高。**对于插入、更新、删除等DML操作比较频繁的表来说，索引过多，会引入相当高的维护代价，降低DML操作的效率，增加相应操作的时间消耗。**
- 使用**短索引**，索引创建之后也是使用**硬盘**来存储的，因此提升索引访问的I/O效率，也可以提升总体的访问效率。假如构成索引的字段总长度比较短，那么在给定大小的存储块内可以存储更多的索引值，相应的可以有效的提升MySQL访问索引的I/O效率。
- 利用**最左前缀**，N个列组合而成的组合索引，那么相当于是创建了N个索引，如果查询时where子句中使用了组成该索引的前几个字段，那么这条查询SQL可以利用组合索引来提升查询效率。

----

创建复合索引:

```sql
CREATE INDEX idx_name_email_status ON tb_seller(NAME,email,STATUS);
```

就相当于

```sql
对name 创建索引 ;
对name , email 创建了索引 ;
对name , email, status 创建了索引 ;
```

----

## 游标/光标

游标是用来存储查询结果集的数据类型 , 在存储过程和函数中可以使用光标对结果集进行循环的处理。光标的使用包括光标的声明、OPEN、FETCH 和 CLOSE，其语法分别如下。

声明光标：

```sql
DECLARE 游标名 CURSOR FOR 查询语句 ;
```

OPEN 光标：

```sql
OPEN 游标名 ;
```

FETCH 光标：

```sql
FETCH 游标名 INTO 变量名1 [, 变量名2] ...
```

CLOSE 光标：

```sql
CLOSE 游标名 ;
```

----

环境准备

```sql
CREATE TABLE emp(
  id INT(11) NOT NULL AUTO_INCREMENT ,
  NAME VARCHAR(50) NOT NULL COMMENT '姓名',
  age INT(11) COMMENT '年龄',
  salary INT(11) COMMENT '薪水',
  PRIMARY KEY(`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 ;

INSERT INTO emp(id,NAME,age,salary) VALUES
(NULL,'范闲',55,3800),
(NULL,'宁缺',60,4000),
(NULL,'司理理',38,2800),
(NULL,'桑桑',42,1800);
```

----

案例 查询emp表中数据,并获取进行展示

```sql
DELIMITER $
CREATE PROCEDURE p()
BEGIN
 DECLARE eid INT;
 DECLARE ename VARCHAR(20);
 DECLARE eage INT;
 DECLARE esalary INT;
 DECLARE resultSet CURSOR FOR SELECT * FROM emp;

 OPEN resultSet;
 
 FETCH resultSet INTO eid,ename,eage,esalary;
 SELECT CONCAT('id=',eid , ', name=',ename, ', age=', eage, ', 薪资为: ',esalary);

 CLOSE resultSet;
END$
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200118101047961.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

---

案例 查询emp表中数据,并循环获取进行展示

```sql
DELIMITER $
CREATE PROCEDURE p2()
BEGIN
 DECLARE eid INT;
 DECLARE ename VARCHAR(20);
 DECLARE eage INT;
 DECLARE esalary INT;
 DECLARE has_data BOOL DEFAULT TRUE;#默认有数据
 
 DECLARE resultSet CURSOR FOR SELECT * FROM emp;
 DECLARE EXIT HANDLER FOR NOT FOUND SET has_data=FALSE;#查不到时设置boolean变量为false

 OPEN resultSet;
 
 REPEAT
    FETCH resultSet INTO eid,ename,eage,esalary;
    SELECT CONCAT('id=',eid , ', name=',ename, ', age=', eage, ', 薪资为: ',esalary);
    UNTIL has_data=FALSE
 END REPEAT;

 CLOSE resultSet;
END$
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200118103120698.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

----

## 触发器

### 介绍

触发器是与表有关的数据库对象，指在 insert/update/delete 之前或之后，触发并执行触发器中定义的SQL语句集合。触发器的这种特性可以协助应用在数据库端确保数据的完整性 , 日志记录 , 数据校验等操作 。

使用别名 OLD 和 NEW 来引用触发器中发生变化的记录内容，这与其他的数据库是相似的。现在触发器还只支持行级触发，不支持语句级触发。

| 触发器类型      | NEW 和 OLD的使用                                        |
| --------------- | ------------------------------------------------------- |
| INSERT 型触发器 | NEW 表示将要或者已经新增的数据                          |
| UPDATE 型触发器 | OLD 表示修改之前的数据 , NEW 表示将要或已经修改后的数据 |
| DELETE 型触发器 | OLD 表示将要或者已经删除的数据                          |

-----

### 创建

**语法**

```sql
CREATE TRIGGER 触发器名 
BEFORE/AFTER INSERT/UPDATE/DELETE
ON 表名 FOR EACH ROW 

BEGIN
 触发语句 ;
END;
```

案例 通过触发器记录 emp 表的数据变更日志 , 包含增加, 修改 , 删除 ;
首先创建一张日志表 : 

```sql
CREATE TABLE emp_logs(
  id INT PRIMARY KEY AUTO_INCREMENT,
  operation VARCHAR(20) COMMENT '操作类型, insert/update/delete',
  operate_time DATETIME  COMMENT '操作时间',
  operate_id INT COMMENT '操作表的ID',
  operate_params VARCHAR(500) COMMENT '操作参数'
);
```

----

**插入操作触发器**

```sql
CREATE TRIGGER emp_ins
AFTER INSERT
ON emp FOR EACH ROW
BEGIN
  INSERT INTO emp_logs VALUES 
  (NULL,'insert',NOW(),new.id,CONCAT('插入后(id:',new.id,', name:',new.name,', age:',new.age,', salary:',new.salary,')'));
END$
```

插入一条数据后，查看日志表：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200118110623591.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

**更新操作触发器**

```sql
CREATE TRIGGER emp_update
AFTER UPDATE
ON emp FOR EACH ROW
BEGIN
  INSERT INTO emp_logs VALUES 
  (NULL,'update',NOW(),new.id,
  CONCAT('修改前(id:',old.id,', name:',old.name,', age:',old.age,', salary:',old.salary,') , 
  修改后(id',new.id, 'name:',new.name,', age:',new.age,', salary:',new.salary,')')); 
END$
```

更新一条数据后，查看日志表：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200118110920200.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

**删除操作触发器**

```sql
CREATE TRIGGER emp_del
AFTER DELETE
ON emp FOR EACH ROW
BEGIN
  INSERT INTO emp_logs VALUES 
  (NULL,'delete',NOW(),old.id,
  CONCAT('删除前(id:',old.id,', name:',old.name,', age:',old.age,', salary:',old.salary,')'));  
END$
```

删除一条数据后，查看日志表：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200118111052458.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

----

### 删除

**语法结构 :** 

```sql
drop trigger [schema_name.]trigger_name;
```

如果没有指定 schema_name，默认为当前数据库 。

----

### 查看

可以通过执行 SHOW TRIGGERS 命令查看触发器的状态、语法等信息。
**语法结构 ：** 

```sql
show triggers;
```

----

 ## 存储引擎

 存储引擎就是存储数据，建立索引，更新查询数据等等技术的实现方式 。
 存储引擎是**基于表的**，而不是基于库的。所以存储引擎也可被称为表类型。
 可以通过` show engines ;`， 来查询当前数据库支持的存储引擎 ：
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200118120102998.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

----

**几种常用的存储引擎**

| 特点         | InnoDB               | MyISAM   | MEMORY | MERGE | NDB  |
| ------------ | -------------------- | -------- | ------ | ----- | ---- |
| 存储限制     | 64TB                 | 有       | 有     | 没有  | 有   |
| 事务安全     | ==支持==             |          |        |       |      |
| 锁机制       | ==行锁(适合高并发)== | ==表锁== | 表锁   | 表锁  | 行锁 |
| B树索引      | 支持                 | 支持     | 支持   | 支持  | 支持 |
| 哈希索引     |                      |          | 支持   |       |      |
| 全文索引     | 支持(5.6版本之后)    | 支持     |        |       |      |
| 集群索引     | 支持                 |          |        |       |      |
| 数据索引     | 支持                 |          | 支持   |       | 支持 |
| 索引缓存     | 支持                 | 支持     | 支持   | 支持  | 支持 |
| 数据可压缩   |                      | 支持     |        |       |      |
| 空间使用     | 高                   | 低       | N/A    | 低    | 低   |
| 内存使用     | 高                   | 低       | 中等   | 低    | 高   |
| 批量插入速度 | 低                   | 高       | 高     | 高    | 高   |
| 支持外键     | ==支持==             |          |        |       |      |

----

**存储引擎的选择**
在选择存储引擎时，应该根据应用系统的特点选择合适的存储引擎。

- InnoDB : 是Mysql的默认存储引擎，用于事务处理应用程序，支持外键。
- 如果应用对事务的完整性有比较高的要求，在并发条件下要求数据的一致性，数据操作除了插入和查询以外，还包含**很多的更新、删除**操作，那么InnoDB存储引擎是比较合适的选择。InnoDB存储引擎除了有效的降低由于删除和更新导致的锁定， 还可以确保事务的完整提交和回滚，对于类似于计费系统或者财务系统等对**数据准确性要求比较高**的系统，InnoDB是最合适的选择。
- MyISAM ： 如果应用是以**读操作和插入操作为主**，只有**很少的更新和删除操作**，并且**对事务的完整性、并发性要求不是很高**，那么选择这个存储引擎是非常合适的。
- MEMORY：将所有数据保存在RAM中，在需要快速定位记录和其他类似数据环境下，可以提供几块的访问。MEMORY的缺陷就是**对表的大小有限制**，太大的表无法缓存在内存中，其次是要确保表的数据可以恢复，数据库异常终止后表中的数据是可以恢复的。MEMORY表通常用于**更新不太频繁的小表**，用以快速得到访问结果。
- MERGE：用于将**一系列等同的MyISAM表**以逻辑方式组合在一起，并作为一个对象引用他们。MERGE表的优点在于可以突破对单个MyISAM表的大小限制，并且通过将不同的表分布在多个磁盘上，可以有效的改善MERGE表的访问效率。这对于存储诸如数据仓储等VLDB环境十分合适。

----

## SQL优化

### 查看SQL执行频率

通过` show [session|global] status` 命令可以提供服务器状态信息。
`show [session|global] status `可以根据需要加上参数“session”或者“global”来显示 session 级（当前连接）的统计结果和 global 级（自数据库上次启动至今）的统计结果。如果不写，默认使用参数是“session”。

例：显示当前 session 中所有统计参数的值

```sql
SHOW STATUS LIKE 'Com_______';
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/2020011819184268.png)

----

例：显示innoDB引擎的global统计结果

```sql
SHOW GLOBAL STATUS LIKE 'Innodb_rows_%';
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200118191918926.png)

----

Com_xxx 表示每个 xxx 语句执行的次数，通常比较常用的是以下几个统计参数。

| 参数                 | 含义                                                         |
| :------------------- | ------------------------------------------------------------ |
| Com_select           | 执行 select 操作的次数，一次查询只累加 1。                   |
| Com_insert           | 执行 INSERT 操作的次数，对于批量插入的 INSERT 操作，只累加一次。 |
| Com_update           | 执行 UPDATE 操作的次数。                                     |
| Com_delete           | 执行 DELETE 操作的次数。                                     |
| Innodb_rows_read     | select 查询返回的行数。                                      |
| Innodb_rows_inserted | 执行 INSERT 操作插入的行数。                                 |
| Innodb_rows_updated  | 执行 UPDATE 操作更新的行数。                                 |
| Innodb_rows_deleted  | 执行 DELETE 操作删除的行数。                                 |
| Connections          | 试图连接 MySQL 服务器的次数。                                |
| Uptime               | 服务器工作时间。                                             |
| Slow_queries         | 慢查询的次数。                                               |

----

### 定位低效率执行SQL

可以通过以下两种方式定位执行效率较低的 SQL 语句。

- 慢查询日志 : 通过慢查询日志定位那些执行效率较低的 SQL 语句，用--log-slow-queries[=file_name]选项启动时，mysqld 写一个包含所有执行时间超过 long_query_time 秒的 SQL 语句的日志文件。
- `show processlist`  : 慢查询日志在查询结束以后才纪录，所以在应用反映执行效率出现问题的时候查询慢查询日志并不能定位问题，可以使用show processlist命令查看当前MySQL在进行的线程，包括线程的状态、是否锁表等，可以实时地查看 SQL 的执行情况，同时对一些锁表操作进行优化。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200118195836475.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

> 1） id列，用户登录mysql时，系统分配的"connection_id"，可以使用函数connection_id()查看 
> 2） user列，显示当前用户。如果不是root，这个命令就只显示用户权限范围的sql语句 
> 3） host列，显示这个语句是从哪个ip的哪个端口上发的，可以用来跟踪出现问题语句的用户
> 4） db列，显示这个进程目前连接的是哪个数据库
> 5） command列，显示当前连接的执行的命令，一般取值为休眠（sleep），查询（query），连接（connect）等 
> 6） time列，显示这个状态持续的时间，单位是秒
> 7） state列，显示使用当前连接的sql语句的状态，很重要的列。state描述的是语句执行中的某一个状态。一个sql语句，以查询为例，可能需要经过copying to tmp table、sorting result、sending data等状态才可以完成 
> 8） info列，显示这个sql语句，是判断问题语句的一个重要依据

----

### explain分析执行计划

通过以上步骤查询到效率低的 SQL 语句后，可以通过 EXPLAIN或者 DESC命令获取 MySQL如何执行 SELECT 语句的信息，包括在 SELECT 语句执行过程中表如何连接和连接的顺序。

查询SQL语句的执行计划 ： `EXPLAIN SELECT * FROM employees;`
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200118200343542.png)

| 字段          | 含义                                                         |
| ------------- | ------------------------------------------------------------ |
| id            | select查询的序列号，是一组数字，表示的是查询中执行select子句或者是操作表的顺序。 |
| select_type   | 表示 SELECT 的类型，常见的取值有 SIMPLE（简单表，即不使用表连接或者子查询）、PRIMARY（主查询，即外层的查询）、UNION（UNION 中的第二个或者后面的查询语句）、SUBQUERY（子查询中的第一个 SELECT）等 |
| table         | 输出结果集的表                                               |
| type          | 表示表的连接类型，性能由好到差的连接类型为( system  --->  const  ----->  eq_ref  ------>  ref  ------->  ref_or_null---->  index_merge  --->  index_subquery  ----->  range  ----->  index  ------> all ) |
| possible_keys | 表示查询时，可能使用的索引                                   |
| key           | 表示实际使用的索引                                           |
| key_len       | 索引字段的长度                                               |
| rows          | 扫描行的数量                                                 |
| extra         | 执行情况的说明和描述                                         |

----

**环境准备**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200118201111744.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

```sql
CREATE TABLE `t_role` (
  `id` varchar(32) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `role_code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_role_name` (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `t_user` (
  `id` varchar(32) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(96) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_user_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `user_role` (
  `id` int(11) NOT NULL auto_increment ,
  `user_id` varchar(32) DEFAULT NULL,
  `role_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ur_user_id` (`user_id`),
  KEY `fk_ur_role_id` (`role_id`),
  CONSTRAINT `fk_ur_role_id` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ur_user_id` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




insert into `t_user` (`id`, `username`, `password`, `name`) values('1','super','$2a$10$TJ4TmCdK.X4wv/tCqHW14.w70U3CC33CeVncD3SLmyMXMknstqKRe','超级管理员');
insert into `t_user` (`id`, `username`, `password`, `name`) values('2','admin','$2a$10$TJ4TmCdK.X4wv/tCqHW14.w70U3CC33CeVncD3SLmyMXMknstqKRe','系统管理员');
insert into `t_user` (`id`, `username`, `password`, `name`) values('3','itcast','$2a$10$8qmaHgUFUAmPR5pOuWhYWOr291WJYjHelUlYn07k5ELF8ZCrW0Cui','test02');
insert into `t_user` (`id`, `username`, `password`, `name`) values('4','stu1','$2a$10$pLtt2KDAFpwTWLjNsmTEi.oU1yOZyIn9XkziK/y/spH5rftCpUMZa','学生1');
insert into `t_user` (`id`, `username`, `password`, `name`) values('5','stu2','$2a$10$nxPKkYSez7uz2YQYUnwhR.z57km3yqKn3Hr/p1FR6ZKgc18u.Tvqm','学生2');
insert into `t_user` (`id`, `username`, `password`, `name`) values('6','t1','$2a$10$TJ4TmCdK.X4wv/tCqHW14.w70U3CC33CeVncD3SLmyMXMknstqKRe','老师1');



INSERT INTO `t_role` (`id`, `role_name`, `role_code`, `description`) VALUES('5','学生','student','学生');
INSERT INTO `t_role` (`id`, `role_name`, `role_code`, `description`) VALUES('7','老师','teacher','老师');
INSERT INTO `t_role` (`id`, `role_name`, `role_code`, `description`) VALUES('8','教学管理员','teachmanager','教学管理员');
INSERT INTO `t_role` (`id`, `role_name`, `role_code`, `description`) VALUES('9','管理员','admin','管理员');
INSERT INTO `t_role` (`id`, `role_name`, `role_code`, `description`) VALUES('10','超级管理员','super','超级管理员');


INSERT INTO user_role(id,user_id,role_id) VALUES(NULL, '1', '5'),(NULL, '1', '7'),(NULL, '2', '8'),(NULL, '3', '9'),(NULL, '4', '8'),(NULL, '5', '10') ;
```

----

 **explain 之 id**
id 字段是 select查询的序列号，是一组数字，表示的是查询中执行select子句或者是操作表的顺序。id 情况有三种 ： 
1） id 相同表示加载表的顺序是从上到下。

```sql
EXPLAIN SELECT * FROM t_role,t_user,user_role
WHERE user_role.`role_id`=t_role.`id` AND user_role.`user_id`=t_user.`id`;
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200118201503678.png)
2） id 不同id值越大，优先级越高，越先被执行。

```sql
EXPLAIN SELECT * FROM t_role 
WHERE id = 
(SELECT role_id FROM user_role 
WHERE user_id = 
(SELECT id FROM t_user
 WHERE username = 'stu1'));
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/2020011820163592.png)
3） id 有相同，也有不同，同时存在。id相同的可以认为是一组，从上往下顺序执行；在所有的组中，id的值越大，优先级越高，越先执行。

```sql
EXPLAIN SELECT * FROM t_role r , (SELECT * FROM user_role ur WHERE ur.`user_id` = '2') a WHERE r.id = a.role_id ; 
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200118201732277.png)

----

**explain 之 select_type**

 表示查询的类型，如下表，从上到下效率越来越低

| select_type  | 含义                                                         |
| ------------ | ------------------------------------------------------------ |
| SIMPLE       | 简单的select查询，查询中不包含子查询或者UNION                |
| PRIMARY      | 查询中若包含任何复杂的子查询，最外层查询标记为该标识         |
| SUBQUERY     | 在SELECT 或 WHERE 列表中包含了子查询                         |
| DERIVED      | 在FROM 列表中包含的子查询，被标记为 DERIVED（衍生） MYSQL会递归执行这些子查询，把结果放在临时表中 |
| UNION        | 若第二个SELECT出现在UNION之后，则标记为UNION ； 若UNION包含在FROM子句的子查询中，外层SELECT将被标记为 ： DERIVED |
| UNION RESULT | 从UNION表获取结果的SELECT                                    |

---

**explain 之 table**
展示这一行的数据是关于哪一张表的 

----

 **explain 之 type**

type 显示的是访问类型，是较为重要的一个指标，如下表，从上到下效率越来越低，一般要求达到range或ref即可。 

| type   | 含义                                                         |
| ------ | ------------------------------------------------------------ |
| NULL   | MySQL不访问任何表，索引，直接返回结果                        |
| system | 表只有一行记录(等于系统表)，这是const类型的特例，一般不会出现 |
| const  | 表示通过索引一次就找到了，const 用于比较primary key 或者 unique 索引。因为只匹配一行数据，所以很快。如将主键置于where列表中，MySQL 就能将该查询转换为一个常亮。const于将 "主键" 或 "唯一" 索引的所有部分与常量值进行比较 |
| eq_ref | 类似ref，区别在于使用的是唯一索引，使用主键的关联查询，关联查询出的记录只有一条。常见于主键或唯一索引扫描 |
| ref    | 非唯一性索引扫描，返回匹配某个单独值的所有行。本质上也是一种索引访问，返回所有匹配某个单独值的所有行（多个） |
| range  | 只检索给定返回的行，使用一个索引来选择行。 where 之后出现 between ， < , > , in 等操作。 |
| index  | index 与 ALL的区别为  index 类型只是遍历了索引树， 通常比ALL 快， ALL 是遍历数据文件。 |
| all    | 将遍历全表以找到匹配的行                                     |

---

**explain 之  key**

- ` possible_keys` : 显示可能应用在这张表的索引， 一个或多个。 
- `key` ： 实际使用的索引， 如果为NULL， 则没有使用索引。
- `key_len `: 表示索引中使用的字节数， 该值为索引字段最大可能长度，并非实际使用长度，在不损失精确性的前提下， 长度越短越好 。

----

 **explain 之 rows**
扫描行的数量。

---

**explain 之 extra**
其他的额外的执行计划信息，在该列展示 。

| extra            | 含义                                                         |
| ---------------- | ------------------------------------------------------------ |
| using  filesort  | 说明mysql会对数据使用一个外部的索引排序，而不是按照表内的索引顺序进行读取， 称为 “文件排序”, 效率低。 |
| using  temporary | 使用了临时表保存中间结果，MySQL在对查询结果排序时使用临时表。常见于 order by 和 group by； 效率低 |
| using  index     | 表示相应的select操作使用了覆盖索引， 避免访问表的数据行， 效率不错。 |

----

### show profile分析SQL

Mysql从5.0.37版本开始增加了对 `show profiles` 和` show profile` 语句的支持。`show profiles` 能够在做SQL优化时帮助我们了解时间都耗费到哪里去了。
通过 `have_profiling` 参数，能够看到当前MySQL是否支持`profile`：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200118234518770.png)
查看`profiling`是否打开：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200118234618603.png)
通过`profiles`，我们能够更清楚地了解SQL执行的过程。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200118234706485.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
通过`show  profile for  query  query_id`查看具体某一条sql语句的执行各个阶段耗时：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200118234823537.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

----

### trace分析优化器执行计划

MySQL5.6提供了对SQL的跟踪trace, 通过trace文件能够进一步了解为什么优化器选择A计划, 而不是选择B计划。
打开trace ， 设置格式为 JSON，并设置trace最大能够使用的内存大小，避免解析过程中因为默认内存过小而不能够完整展示。

```sql
SET optimizer_trace="enabled=on",end_markers_in_json=on;
set optimizer_trace_max_mem_size=1000000;
```

执行SQL语句 ：

```sql
SELECT * FROM employees WHERE employee_id < 110;
```

最后， 检查information_schema.optimizer_trace就可以知道MySQL是如何执行SQL的 ：

```sql
select * from information_schema.optimizer_trace;
```

----

## 索引的使用

### 验证索引对查询效率的提升

利用存储过程给emp表插入约五万条记录

```sql
delimiter $
CREATE PROCEDURE p()
BEGIN
  DECLARE i INT DEFAULT 1;
  WHILE i<50000 DO
  INSERT INTO emp VALUES (NULL,'a',i,1);
  SET i=i+1;
  END WHILE;
END$
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119122506268.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
其中age字段没有索引，查询age为45000的记录

```sql
SELECT * FROM emp WHERE age=45000;
```

给age添加索引后，再次查询age为45000的记录，可见查询时间变少了（如果数据更多体现的越明显，插入数据太耗时，所以我只插入了5万条）。

```sql
CREATE INDEX idx ON emp(age);
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119134037997.png)

----

### 避免索引失效

**准备环境**

```sql
create table `tb_seller` (
	`sellerid` varchar (100),
	`name` varchar (100),
	`nickname` varchar (50),
	`password` varchar (60),
	`status` varchar (1),
	`address` varchar (100),
	`createtime` datetime,
    primary key(`sellerid`)
)engine=innodb default charset=utf8mb4; 

insert into `tb_seller` (`sellerid`, `name`, `nickname`, `password`, `status`, `address`, `createtime`) values('alibaba','阿里巴巴','阿里小店','e10adc3949ba59abbe56e057f20f883e','1','北京市','2088-01-01 12:00:00');
insert into `tb_seller` (`sellerid`, `name`, `nickname`, `password`, `status`, `address`, `createtime`) values('baidu','百度科技有限公司','百度小店','e10adc3949ba59abbe56e057f20f883e','1','北京市','2088-01-01 12:00:00');
insert into `tb_seller` (`sellerid`, `name`, `nickname`, `password`, `status`, `address`, `createtime`) values('huawei','华为科技有限公司','华为小店','e10adc3949ba59abbe56e057f20f883e','0','北京市','2088-01-01 12:00:00');
insert into `tb_seller` (`sellerid`, `name`, `nickname`, `password`, `status`, `address`, `createtime`) values('itcast','传智播客教育科技有限公司','传智播客','e10adc3949ba59abbe56e057f20f883e','1','北京市','2088-01-01 12:00:00');
insert into `tb_seller` (`sellerid`, `name`, `nickname`, `password`, `status`, `address`, `createtime`) values('itheima','黑马程序员','黑马程序员','e10adc3949ba59abbe56e057f20f883e','0','北京市','2088-01-01 12:00:00');
insert into `tb_seller` (`sellerid`, `name`, `nickname`, `password`, `status`, `address`, `createtime`) values('luoji','罗技科技有限公司','罗技小店','e10adc3949ba59abbe56e057f20f883e','1','北京市','2088-01-01 12:00:00');
insert into `tb_seller` (`sellerid`, `name`, `nickname`, `password`, `status`, `address`, `createtime`) values('oppo','OPPO科技有限公司','OPPO官方旗舰店','e10adc3949ba59abbe56e057f20f883e','0','北京市','2088-01-01 12:00:00');
insert into `tb_seller` (`sellerid`, `name`, `nickname`, `password`, `status`, `address`, `createtime`) values('ourpalm','掌趣科技股份有限公司','掌趣小店','e10adc3949ba59abbe56e057f20f883e','1','北京市','2088-01-01 12:00:00');
insert into `tb_seller` (`sellerid`, `name`, `nickname`, `password`, `status`, `address`, `createtime`) values('qiandu','千度科技','千度小店','e10adc3949ba59abbe56e057f20f883e','2','北京市','2088-01-01 12:00:00');
insert into `tb_seller` (`sellerid`, `name`, `nickname`, `password`, `status`, `address`, `createtime`) values('sina','新浪科技有限公司','新浪官方旗舰店','e10adc3949ba59abbe56e057f20f883e','1','北京市','2088-01-01 12:00:00');
insert into `tb_seller` (`sellerid`, `name`, `nickname`, `password`, `status`, `address`, `createtime`) values('xiaomi','小米科技','小米官方旗舰店','e10adc3949ba59abbe56e057f20f883e','1','西安市','2088-01-01 12:00:00');
insert into `tb_seller` (`sellerid`, `name`, `nickname`, `password`, `status`, `address`, `createtime`) values('yijia','宜家家居','宜家家居旗舰店','e10adc3949ba59abbe56e057f20f883e','1','北京市','2088-01-01 12:00:00');


create index idx_seller_name_sta_addr on tb_seller(name,status,address);
```

---

**全值匹配**
对索引中所有列都指定具体值。

```sql
EXPLAIN
 SELECT * FROM tb_seller WHERE NAME='小米科技' AND STATUS ='1' AND address='西安市';
```

可见索引生效：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119132933246.png)

---

**最左前缀法则**
如果索引了多列，要遵守最左前缀法则。指的是查询从索引的最左前列开始，并且不跳过索引中的列。
举一个上楼的例子，第几列就是第几次层楼，都必须要从第一层开始，可以到第n层，但中间不能跳跃。
匹配最左前缀法则，走索引：

```sql
EXPLAIN SELECT * FROM tb_seller WHERE NAME='小米科技' AND STATUS ='1';
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119133017963.png)

------

违法最左前缀法则 ， 索引失效：

```sql
EXPLAIN SELECT * FROM tb_seller WHERE STATUS =1;
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119132341593.png)

-----

如果符合最左法则，但是**出现跳跃某一列**，只有最左列索引生效：

```sql
EXPLAIN SELECT * FROM tb_seller WHERE NAME='小米科技' AND address='西安市';
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/2020011913245345.png)

------

**范围查询右边的列**，索引失效
将等于改为大于号：

```sql
EXPLAIN 
SELECT * FROM tb_seller WHERE NAME='小米科技' AND STATUS >'1' AND address='西安市';
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119133212602.png)

------

**在索引列上进行运算操作**， 索引将失效。

```sql
EXPLAIN 
SELECT * FROM tb_seller WHERE SUBSTR(NAME,1) = '小米科技' ;
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119133333318.png)

-----

**字符串不加单引号**，MySQL的查询优化器会自动的进行类型转换，造成索引失效。

```sql
EXPLAIN
 SELECT * FROM tb_seller WHERE NAME='小米科技' AND STATUS = 1 AND address='西安市';
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119133444115.png)

---

尽量使用**覆盖索引**，减少select * ，即要查询的字段全部被索引包含
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119135143771.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

---

用or分割开的条件， 如果**or前的条件中的列有索引，而后面的列中没有索引**，那么涉及的索引都不会被用到。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119135533737.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

---

**以%开头的Like模糊查询**，索引失效。
解决方法：使用覆盖索引。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119140128787.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

----

如果MySQL评估**使用索引比全表更慢，则不使用索引**。
给address创建一个单列索引

```sql
CREATE INDEX idx_addr ON tb_seller(address);
```

分别对address为北京市和西安市的记录进行查询
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119140804179.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
可见address为北京市时并没有使用索引，因为12条记录中11条address的值为北京市，所以不如使用全表扫描。即占少部分的记录使用索引，占大部分的使用全表扫描。

---

**尽量使用复合索引**，而少使用单列索引 。
创建复合索引 

```sql
create index idx_name_sta_address on tb_seller(name, status, address);

就相当于创建了三个索引 ： 
	name
	name + status
	name + status + address
```

创建单列索引 

```sql
create index idx_seller_name on tb_seller(name);
create index idx_seller_status on tb_seller(status);
create index idx_seller_address on tb_seller(address);
```

当查询条件包含上述三个字段的值时，数据库会选择一个最优的索引（辨识度最高索引）来使用，并不会使用全部索引 。

----

### 查看索引使用情况

```sql
查看当前会话
SHOW STATUS LIKE 'Handler_read%';	
查看全局
SHOW GLOBAL STATUS LIKE 'Handler_read%';	
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119142701796.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

> - Handler_read_first：索引中第一条被读的次数。如果较高，表示服务器正执行大量全索引扫描（这个值越低越好）。
> - Handler_read_key：如果索引正在工作，这个值代表一个行被索引值读的次数，如果值越低，表示索引得到的性能改善不高，因为索引不经常使用（这个值越高越好）。
> - Handler_read_next ：按照键顺序读下一行的请求数。如果你用范围约束或如果执行索引扫描来查询索引列，该值增加。
>  - Handler_read_last：访问索引的上一条数据，实际上也是封装的ha_innobase::general_fetch函数，用于ORDER BY DESC 索引扫描避免排序
> - Handler_read_prev：按照键顺序读前一行的请求数。该读方法主要用于优化ORDER BY ... DESC。
> - Handler_read_rnd ：根据固定位置读一行的请求数。如果你正执行大量查询并需要对结果进行排序该值较高。你可能使用了大量需要MySQL扫描整个表的查询或你的连接没有正确使用键。这个值较高，意味着运行效率低，应该建立索引来补救。
> - Handler_read_rnd_next：在数据文件中读下一行的请求数。如果你正进行大量的表扫描，该值较高。通常说明你的表索引不正确或写入的查询没有利用索引。

----

## SQL优化

### 优化大批量导入数据

**环境准备 ：** 
创建两个表tb_user_1和tb_user_2，结构完全一样

```sql
CREATE TABLE `tb_user_1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(96) NOT NULL,
  `name` varchar(45) NOT NULL,
  `birthday` datetime DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `qq` varchar(32) DEFAULT NULL,
  `status` varchar(32) NOT NULL COMMENT '用户状态',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_user_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;
```

----

插入ID顺序排列数据：
查询local_infile是否开启，若为off需要开启，否则不能导入文件数据

```sql
SHOW VARIABLES LIKE '%local%';
SET GLOBAL local_infile=1; 
```

```
脚本文件介绍 :
	sql1.log  ----> 主键有序
	sql2.log  ----> 主键无序
```

对于 InnoDB 类型的表，有以下几种方式可以提高导入的效率：

**1） 主键顺序插入**

因为InnoDB类型的表是按照主键的顺序保存的，所以将导入的数据按照主键的顺序排列，可以有效的提高导入数据的效率。如果InnoDB表没有主键，那么系统会自动默认创建一个内部列作为主键，所以如果可以给表创建一个主键，将可以利用这点，来提高导入数据的效率。


导入100万条主键有序数据到tb_user_1

```sql
LOAD DATA LOCAL INFILE 'D:/sql1.log' INTO TABLE `tb_user_1` 
FIELDS TERMINATED BY ',' #属性以，分隔
LINES  TERMINATED BY '\n';#每行以\n分隔
```

耗时49秒：
![在这里插入图片描述](https://img-blog.csdnimg.cn/202001192138406.png)
导入100万条主键无序数据到tb_user_2：

```sql
LOAD DATA LOCAL INFILE 'D:/sql2.log' INTO TABLE `tb_user_2` 
FIELDS TERMINATED BY ',' 
LINES  TERMINATED BY '\n';
```

我等了快1小时都没导入完，直接放弃了...可见主键有序对插入效率影响是很大的。

**2） 关闭唯一性校验**

在导入数据前执行` SET UNIQUE_CHECKS=0`，关闭唯一性校验，在导入结束后执行 `SET UNIQUE_CHECKS=1`，恢复唯一性校验，可以提高导入的效率。

关闭唯一性校验后，导入100万条主键有序的数据仅用40秒，比之前要快10秒左右。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119214550630.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

**3） 手动提交事务**

如果应用使用自动提交的方式，建议在导入前执行 `SET AUTOCOMMIT=0`，关闭自动提交，导入结束后再执行 `SET AUTOCOMMIT=1`，打开自动提交，也可以提高导入的效率。

关闭自动提交事务后，导入100万条主键有序的数据仅用40秒，同样比之前要快10秒左右。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119214836297.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

---

###  优化insert语句

当进行数据的insert操作的时候，可以考虑采用以下几种优化方案。
1 如果需要同时**对一张表插入很多行数据**时，应该尽量**使用多个值表的insert语句**，这种方式将大大的**缩减客户端与数据库之间的连接、关闭等消耗**。
使得效率比分开执行的单个insert语句快。
示例 原始方式为：

```sql
insert into tb_test values(1,'Tom');
insert into tb_test values(2,'Cat');
insert into tb_test values(3,'Jerry');
```

 优化后的方案为 ： 

```sql
insert into tb_test values(1,'Tom'),(2,'Cat')，(3,'Jerry');
```

**2 在事务中进行数据插入**

```sql
set autocommit=0;
start transaction;
insert into tb_test values(1,'Tom');
insert into tb_test values(2,'Cat');
insert into tb_test values(3,'Jerry');
commit;
```

**3 数据有序插入**
跟之前的大批量插入数据同理，主键有序时速度快。

```sql
insert into tb_test values(4,'Tim');
insert into tb_test values(1,'Tom');
insert into tb_test values(3,'Jerry');
insert into tb_test values(5,'Rose');
insert into tb_test values(2,'Cat');
```

 优化后

```sql
insert into tb_test values(1,'Tom');
insert into tb_test values(2,'Cat');
insert into tb_test values(3,'Jerry');
insert into tb_test values(4,'Tim');
insert into tb_test values(5,'Rose');
```

---

### 优化 order by语句

**环境准备**
创建一个员工表，插入数据，并创建一个包含年龄和工资列的复合索引。

```sql
CREATE TABLE `emp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `age` int(3) NOT NULL,
  `salary` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4;

insert into `emp` (`id`, `name`, `age`, `salary`) values('1','Tom','25','2300');
insert into `emp` (`id`, `name`, `age`, `salary`) values('2','Jerry','30','3500');
insert into `emp` (`id`, `name`, `age`, `salary`) values('3','Luci','25','2800');
insert into `emp` (`id`, `name`, `age`, `salary`) values('4','Jay','36','3500');
insert into `emp` (`id`, `name`, `age`, `salary`) values('5','Tom2','21','2200');
insert into `emp` (`id`, `name`, `age`, `salary`) values('6','Jerry2','31','3300');
insert into `emp` (`id`, `name`, `age`, `salary`) values('7','Luci2','26','2700');
insert into `emp` (`id`, `name`, `age`, `salary`) values('8','Jay2','33','3500');
insert into `emp` (`id`, `name`, `age`, `salary`) values('9','Tom3','23','2400');
insert into `emp` (`id`, `name`, `age`, `salary`) values('10','Jerry3','32','3100');
insert into `emp` (`id`, `name`, `age`, `salary`) values('11','Luci3','26','2900');
insert into `emp` (`id`, `name`, `age`, `salary`) values('12','Jay3','37','4500');

create index idx_emp_age_salary on emp(age,salary);
```

**两种排序方式**

第一种是通过对返回数据进行排序，也就是通常说的 filesort 排序，所有不是通过索引直接返回排序结果的排序都叫 FileSort 排序。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119221048499.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
第二种通过有序索引顺序扫描直接返回有序数据，这种情况即为 using index，不需要额外排序，操作效率高。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119221146592.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
多字段排序
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119221311244.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
尽量减少额外的排序，通过索引直接返回有序数据。where 条件和Order by 使用相同的索引，并且**Order By 的顺序和索引顺序相同**， 并且**Order  by 的字段都是升序，或者都是降序** 否则肯定需要额外的操作，这样就会出现FileSort。

---

### 优化 group by 语句

由于GROUP BY 实际上也同样会进行排序操作，而且与ORDER BY 相比，GROUP BY 主要只是多了排序之后的分组操作。当然，如果在分组的时候还使用了其他的一些聚合函数，那么还需要一些聚合函数的计算。所以，在GROUP BY 的实现过程中，与 ORDER BY 一样也可以利用到索引。

如果查询包含 group by 但是用户想要避免排序结果的消耗， 则可以执行order by null 禁止排序。
去除之前的索引，比较order by null的效果。

```sql
DROP INDEX idx_emp_age_salary ON emp;
EXPLAIN SELECT age,COUNT(*) FROM emp GROUP BY age;
EXPLAIN SELECT age,COUNT(*) FROM emp GROUP BY age ORDER BY NULL;
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119222133337.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
之后再次创建索引，比较有无索引的区别。可见有索引时可去除order by null

```sql
CREATE INDEX idx_emp_age_salary ON emp(age,salary);
EXPLAIN SELECT age,COUNT(*) FROM emp GROUP BY age;
EXPLAIN SELECT age,COUNT(*) FROM emp GROUP BY age ORDER BY NULL;
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119222312606.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

----

### 优化子查询

Mysql4.1版本之后，开始支持SQL的子查询。使用子查询可以一次性的完成很多逻辑上需要多个步骤才能完成的SQL操作，同时也可以避免事务或者表锁死，并且写起来也很容易。但是，有些情况下，子查询是可以被更高效的连接（JOIN）替代。

**环境准备**

```sql
CREATE TABLE `t_role` (
  `id` varchar(32) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `role_code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_role_name` (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `t_user` (
  `id` varchar(32) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(96) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_user_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `user_role` (
  `id` int(11) NOT NULL auto_increment ,
  `user_id` varchar(32) DEFAULT NULL,
  `role_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ur_user_id` (`user_id`),
  KEY `fk_ur_role_id` (`role_id`),
  CONSTRAINT `fk_ur_role_id` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ur_user_id` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




insert into `t_user` (`id`, `username`, `password`, `name`) values('1','super','$2a$10$TJ4TmCdK.X4wv/tCqHW14.w70U3CC33CeVncD3SLmyMXMknstqKRe','超级管理员');
insert into `t_user` (`id`, `username`, `password`, `name`) values('2','admin','$2a$10$TJ4TmCdK.X4wv/tCqHW14.w70U3CC33CeVncD3SLmyMXMknstqKRe','系统管理员');
insert into `t_user` (`id`, `username`, `password`, `name`) values('3','itcast','$2a$10$8qmaHgUFUAmPR5pOuWhYWOr291WJYjHelUlYn07k5ELF8ZCrW0Cui','test02');
insert into `t_user` (`id`, `username`, `password`, `name`) values('4','stu1','$2a$10$pLtt2KDAFpwTWLjNsmTEi.oU1yOZyIn9XkziK/y/spH5rftCpUMZa','学生1');
insert into `t_user` (`id`, `username`, `password`, `name`) values('5','stu2','$2a$10$nxPKkYSez7uz2YQYUnwhR.z57km3yqKn3Hr/p1FR6ZKgc18u.Tvqm','学生2');
insert into `t_user` (`id`, `username`, `password`, `name`) values('6','t1','$2a$10$TJ4TmCdK.X4wv/tCqHW14.w70U3CC33CeVncD3SLmyMXMknstqKRe','老师1');



INSERT INTO `t_role` (`id`, `role_name`, `role_code`, `description`) VALUES('5','学生','student','学生');
INSERT INTO `t_role` (`id`, `role_name`, `role_code`, `description`) VALUES('7','老师','teacher','老师');
INSERT INTO `t_role` (`id`, `role_name`, `role_code`, `description`) VALUES('8','教学管理员','teachmanager','教学管理员');
INSERT INTO `t_role` (`id`, `role_name`, `role_code`, `description`) VALUES('9','管理员','admin','管理员');
INSERT INTO `t_role` (`id`, `role_name`, `role_code`, `description`) VALUES('10','超级管理员','super','超级管理员');


INSERT INTO user_role(id,user_id,role_id) VALUES(NULL, '1', '5'),(NULL, '1', '7'),(NULL, '2', '8'),(NULL, '3', '9'),(NULL, '4', '8'),(NULL, '5', '10') ;

```

----

例 ：查找有角色的所有的用户信息 

```sql
EXPLAIN 
SELECT * FROM t_user WHERE t_user.`id` 
IN (SELECT user_role.`user_id` FROM user_role);
```

可以优化为多表连接

```sql
EXPLAIN 
SELECT * FROM t_user JOIN user_role 
ON t_user.`id` = user_role.`user_id`;
```

对比可见多表连接效率更高。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119223841985.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

---

### 优化OR条件

对于包含OR的查询子句，如果要利用索引，则OR之间的每个条件列都必须用到索引 ， 而且不能使用到复合索引； 如果没有索引，则应该考虑增加索引。
查看emp表中的索引：

```sql
SHOW INDEX FROM emp;
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119225130633.png)
**如果or的一个条件不包含索引，索引失效**（name列不包含索引）：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119225213379.png)

**如果使用了复合索引，索引失效：**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119225302141.png)
**使用union优化：**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119225659209.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
我们来比较下重要指标，发现主要差别是 type 和 ref 这两项

type 显示的是访问类型，是较为重要的一个指标，结果值从好到坏依次是：

```sql
system > const > eq_ref > ref > fulltext > ref_or_null  > 
index_merge > unique_subquery > index_subquery > range > index > ALL
```

UNION 语句的 type 值为 ref，OR 语句的 type 值为 index_merge
UNION 语句的 ref 值为 const，OR 语句的 ref值为 null，const 表示是常量值引用，非常快
这两项的差距就说明了 UNION 要优于 OR 。

---

### 优化分页查询

一般分页查询时，通过创建覆盖索引能够比较好地提高性能。
如果我们想要查询之前插入100万数据表的第90万零1页（每页10页）即limit 900000,10  ，此时需要MySQL排序前900010 记录，仅仅返回900000 - 900010 的记录，其他记录丢弃，查询排序的代价非常大 。

```sql
SELECT * FROM tb_user_1 LIMIT 900000,10;
```

此时花费1.29秒
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119230913794.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
使用explain分析其执行计划，没有使用索引，进行全表扫描
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119231406796.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

 **优化思路一**
在索引上完成排序分页操作，最后根据主键关联回原表查询所需要的其他列内容。

```sql
SELECT * FROM tb_user_1 t1,
(SELECT id FROM tb_user_1 ORDER BY id LIMIT 900000,10) t2
WHERE t1.`id`=t2.id;
```

使用explain分析其执行计划，使用了索引
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119231317541.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
 **优化思路二**
该方案适用于主键自增的表，可以把Limit 查询转换成某个位置的查询 。

```sql
SELECT * FROM tb_user_1 WHERE id> 900000 LIMIT 10;
相当于
SELECT * FROM tb_user_1 WHERE id BETWEEN 900001 AND 900010;
```

执行仅需0秒
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119231703577.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
使用explain分析其执行计划：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119231746555.png)

---

### 使用SQL提示

SQL提示，是优化数据库的一个重要手段，简单来说，就是在SQL语句中加入一些人为的提示来达到优化操作的目的。
**环境准备**

```sql
create table `tb_seller` (
	`sellerid` varchar (100),
	`name` varchar (100),
	`nickname` varchar (50),
	`password` varchar (60),
	`status` varchar (1),
	`address` varchar (100),
	`createtime` datetime,
    primary key(`sellerid`)
)engine=innodb default charset=utf8mb4; 

insert into `tb_seller` (`sellerid`, `name`, `nickname`, `password`, `status`, `address`, `createtime`) values('alibaba','阿里巴巴','阿里小店','e10adc3949ba59abbe56e057f20f883e','1','北京市','2088-01-01 12:00:00');
insert into `tb_seller` (`sellerid`, `name`, `nickname`, `password`, `status`, `address`, `createtime`) values('baidu','百度科技有限公司','百度小店','e10adc3949ba59abbe56e057f20f883e','1','北京市','2088-01-01 12:00:00');
insert into `tb_seller` (`sellerid`, `name`, `nickname`, `password`, `status`, `address`, `createtime`) values('huawei','华为科技有限公司','华为小店','e10adc3949ba59abbe56e057f20f883e','0','北京市','2088-01-01 12:00:00');
insert into `tb_seller` (`sellerid`, `name`, `nickname`, `password`, `status`, `address`, `createtime`) values('itcast','传智播客教育科技有限公司','传智播客','e10adc3949ba59abbe56e057f20f883e','1','北京市','2088-01-01 12:00:00');
insert into `tb_seller` (`sellerid`, `name`, `nickname`, `password`, `status`, `address`, `createtime`) values('itheima','黑马程序员','黑马程序员','e10adc3949ba59abbe56e057f20f883e','0','北京市','2088-01-01 12:00:00');
insert into `tb_seller` (`sellerid`, `name`, `nickname`, `password`, `status`, `address`, `createtime`) values('luoji','罗技科技有限公司','罗技小店','e10adc3949ba59abbe56e057f20f883e','1','北京市','2088-01-01 12:00:00');
insert into `tb_seller` (`sellerid`, `name`, `nickname`, `password`, `status`, `address`, `createtime`) values('oppo','OPPO科技有限公司','OPPO官方旗舰店','e10adc3949ba59abbe56e057f20f883e','0','北京市','2088-01-01 12:00:00');
insert into `tb_seller` (`sellerid`, `name`, `nickname`, `password`, `status`, `address`, `createtime`) values('ourpalm','掌趣科技股份有限公司','掌趣小店','e10adc3949ba59abbe56e057f20f883e','1','北京市','2088-01-01 12:00:00');
insert into `tb_seller` (`sellerid`, `name`, `nickname`, `password`, `status`, `address`, `createtime`) values('qiandu','千度科技','千度小店','e10adc3949ba59abbe56e057f20f883e','2','北京市','2088-01-01 12:00:00');
insert into `tb_seller` (`sellerid`, `name`, `nickname`, `password`, `status`, `address`, `createtime`) values('sina','新浪科技有限公司','新浪官方旗舰店','e10adc3949ba59abbe56e057f20f883e','1','北京市','2088-01-01 12:00:00');
insert into `tb_seller` (`sellerid`, `name`, `nickname`, `password`, `status`, `address`, `createtime`) values('xiaomi','小米科技','小米官方旗舰店','e10adc3949ba59abbe56e057f20f883e','1','西安市','2088-01-01 12:00:00');
insert into `tb_seller` (`sellerid`, `name`, `nickname`, `password`, `status`, `address`, `createtime`) values('yijia','宜家家居','宜家家居旗舰店','e10adc3949ba59abbe56e057f20f883e','1','北京市','2088-01-01 12:00:00');

CREATE INDEX idx_seller_name ON tb_seller(NAME);
CREATE INDEX idx_seller_address ON tb_seller(address);
create index idx_seller_name_sta_addr on tb_seller(name,status,address);

```

----

**USE INDEX**
在查询语句中表名的后面，添加 	`use index` 来提供希望MySQL去参考的索引列表，就可以让MySQL不再考虑其他可用的索引。
例如，根据name查询时，由于name属于两个索引，可能使用到两个索引，可以通过use index来让mysql只考虑单列索引。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119233227443.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
 **IGNORE INDEX**

如果用户只是单纯的想让MySQL忽略一个或者多个索引，则可以使用 ignore index。
例如上面的例子，可以使用ignore index忽略单列索引，使用复合索引。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119233500482.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
**FORCE INDEX**
为强制MySQL使用一个特定的索引，可在查询中使用 force index。
之前说过，如果记录占大多数，当全表扫描效率高于使用索引时，将使用全表扫描。
（参考[MYSQL高级总结笔记（上））](https://blog.csdn.net/qq_41112238/article/details/104004400)
可以通过force index强制使用索引。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200119233753885.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

----

## 应用优化

在实际生产环境中，由于数据库本身的性能局限，就必须要对前台的应用进行一些优化，来降低数据库的访问压力。

###  使用连接池

对于访问数据库来说，建立连接的代价是比较昂贵的，因为我们频繁的创建关闭连接，是比较耗费资源的，我们有必要建立 数据库连接池，以提高访问的性能。

----

### 减少对MySQL的访问

 **避免对数据进行重复检索**

在编写应用代码时，需要能够理清对数据库的访问逻辑。能够一次连接就获取到结果的，就不用两次连接，这样可以大大减少对数据库无用的重复请求。

比如 ，需要获取书籍的id 和name字段 ， 则查询如下： 

```sql
 select id , name from tb_book;
```

之后，在业务逻辑中有需要获取到书籍状态信息， 则查询如下：

```sql
select id , status from tb_book;
```

这样，就需要向数据库提交两次请求，数据库就要做两次查询操作。其实完全可以用一条SQL语句得到想要的结果。

```sql
select id, name , status from tb_book;
```

**增加cache层**

在应用中，我们可以在应用中增加**缓存**层来达到减轻数据库负担的目的。缓存层有很多种，也有很多实现方式，只要能达到降低数据库的负担又能满足应用需求就可以。

因此可以部分数据从数据库中抽取出来放到应用端以文本方式存储， 或者使用框架(Mybatis, Hibernate)提供的一级缓存/二级缓存，或者使用redis数据库来缓存数据 。

----

### 负载均衡 

负载均衡是应用中使用非常普遍的一种优化方法，它的机制就是利用某种均衡算法，将固定的负载量分布到不同的服务器上， 以此来降低单台服务器的负载，达到优化的效果。

**利用MySQL复制分流查询**

通过MySQL的主从复制，实现读写分离，使增删改操作走主节点，查询操作走从节点，从而可以降低单台服务器的读写压力。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200120102610630.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

**采用分布式数据库架构**

分布式数据库架构适合大数据量、负载高的情况，它有良好的拓展性和高可用性。通过在多台服务器之间分布数据，可以实现在多台服务器之间的负载均衡，提高访问效率。

---

## Mysql中查询缓存优化

### 概述

开启Mysql的查询缓存，当执行完全相同的SQL语句的时候，服务器就会直接从缓存中读取结果，当数据被修改，之前的缓存会失效，修改比较频繁的表不适合做查询缓存。

### 操作流程

> 1. 客户端发送一条查询给服务器；
> 2. 服务器先会检查查询缓存，如果命中了缓存，则立即返回存储在缓存中的结果。否则进入下一阶段；
> 3. 服务器端进行SQL解析、预处理，再由优化器生成对应的执行计划；
> 4. MySQL根据优化器生成的执行计划，调用存储引擎的API来执行查询；
> 5. 将结果返回给客户端。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200120103808751.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

---

### 查询缓存配置

**1 查看数据库是否支持查询缓存**

```sql
SHOW VARIABLES LIKE 'have_query_cache';
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200120104624610.png)

**2 查看查询缓存是否开启**

```sql
SHOW VARIABLES LIKE 'query_cache_type';
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200120104631314.png)
**3 查看查询缓存的大小**

```sql
SHOW VARIABLES LIKE 'query_cache_size';
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200120104644184.png)
**4 查看查询缓存的状态变量**

```sql
SHOW STATUS LIKE 'Qcache%';
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/2020012010464965.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
各个变量的含义如下：

| 参数                    | 含义                                                         |
| ----------------------- | ------------------------------------------------------------ |
| Qcache_free_blocks      | 查询缓存中的可用内存块数                                     |
| Qcache_free_memory      | 查询缓存的可用内存量                                         |
| Qcache_hits             | 查询缓存命中数                                               |
| Qcache_inserts          | 添加到查询缓存的查询数                                       |
| Qcache_lowmen_prunes    | 由于内存不足而从查询缓存中删除的查询数                       |
| Qcache_not_cached       | 非缓存查询的数量（由于 query_cache_type 设置而无法缓存或未缓存） |
| Qcache_queries_in_cache | 查询缓存中注册的查询数                                       |
| Qcache_total_blocks     | 查询缓存中的块总数                                           |

---

### 开启查询缓存

MySQL的查询缓存默认是关闭的，需要手动配置参数 query_cache_type ， 来开启查询缓存。query_cache_type 该参数的可取值有三个 ：

| 值       | 含义                                                         |
| -------- | ------------------------------------------------------------ |
| OFF 或 0 | 查询缓存功能关闭                                             |
| ON 或 1  | 查询缓存功能打开，SELECT的结果符合缓存条件即会缓存，否则，不予缓存，显式指定 SQL_NO_CACHE，不予缓存 |

| DEMAND 或 2 | 查询缓存功能按需进行，显式指定 SQL_CACHE 的SELECT语句才会缓存；其它均不予缓存 


在MySQL的my.ini配置文件末尾添加`query_cache_type=1`，重启MySQL服务。
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020012010541672.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020012010550381.png)
此时查询缓存已经开启。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200120110504501.png)
通过两次对之前有100万数据的表进行查询比较验证查询缓存：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200120110640243.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

---

### 查询缓存SELECT选项

可以在SELECT语句中指定两个与查询缓存相关的选项 ：

- SQL_CACHE : 
  如果查询结果是可缓存的，并且 query_cache_type 系统变量的值为ON或 DEMAND ，则缓存查询结果 。
- SQL_NO_CACHE : 
  服务器不使用查询缓存。它既不检查查询缓存，也不检查结果是否已缓存，也不缓存查询结果。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200120111607301.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/2020012011165370.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

-----

### 查询缓存失效的情况

1） SQL 语句不一致的情况， 要想命中查询缓存，查询的SQL语句必须一致。

```sql
SQL1 : select count(*) from tb_item;
SQL2 : Select count(*) from tb_item;#大小写不一致也会失效
```

2） 当查询语句中有一些不确定的时，则不会缓存。如 ： now() , current_date() , curdate() , curtime() , rand() , uuid() , user() , database() 。

```sql
SQL1 : select * from tb_item where updatetime < now() limit 1;
SQL2 : select user();
SQL3 : select database();
```

3） 不使用任何表查询语句。

```sql
select 'A';
```

4）  查询 mysql， information_schema或  performance_schema 数据库中的表时，不会走查询缓存。

```sql
select * from information_schema.engines;
```

5） 在存储的函数，触发器或事件的主体内执行的查询。

6） 如果表更改，则使用该表的所有高速缓存查询都将变为无效并从高速缓存中删除。这包括使用`MERGE`映射到已更改表的表的查询。一个表可以被许多类型的语句，如被改变 INSERT， UPDATE， DELETE， TRUNCATE TABLE， ALTER TABLE， DROP TABLE，或 DROP DATABASE 。

---

## Mysql内存管理及优化

### 内存优化原则

1） 将尽量多的内存分配给MySQL做缓存，但要给操作系统和其他程序预留足够内存。

2） MyISAM 存储引擎的数据文件读取依赖于操作系统自身的IO缓存，因此，如果有MyISAM表，就要预留更多的内存给操作系统做IO缓存。

3） 排序区、连接区等缓存是分配给每个数据库会话（session）专用的，其默认值的设置要根据最大连接数合理分配，如果设置太大，不但浪费资源，而且在并发连接较高时会导致物理内存耗尽。

----

### MyISAM 内存优化

myisam存储引擎**使用 key_buffer 缓存索引块**，加速myisam索引的读写速度。对于myisam表的**数据块**，mysql没有特别的缓存机制，**完全依赖于操作系统的IO缓存**。

 **key_buffer_size**

`key_buffer_size`决定MyISAM索引块缓存区的大小，直接影响到MyISAM表的存取效率。可以在MySQL参数文件中设置`key_buffer_size`的值，对于一般MyISAM数据库，建议至少将**1/4**可用内存分配给`key_buffer_size`。

在my.ini 中做如下配置：`key_buffer_size=512M`

----

**read_buffer_size**
如果需要经常**顺序扫描**myisam表，可以通过增大`read_buffer_size`的值来改善性能。但需要注意的是`read_buffer_size`是每个session独占的，如果默认值设置太大，就会造成内存浪费。

----

**read_rnd_buffer_size**
对于需要**做排序**的myisam表的查询，如带有order by子句的sql，适当增加 `read_rnd_buffer_size` 的值，可以改善此类的sql性能。但需要注意的是 `read_rnd_buffer_size` 是每个session独占的，如果默认值设置太大，就会造成内存浪费。

---

### InnoDB 内存优化

innodb用**一块内存**区做IO缓存池，该缓存池不仅用来**缓存innodb的索引块**，而且也用来**缓存innodb的数据块**。

 **innodb_buffer_pool_size**

该变量决定了 innodb **存储引擎表数据和索引数据的最大缓存区**大小。在保证操作系统及其他程序有足够内存可用的情况下，`innodb_buffer_pool_size` 的值越大，**缓存命中率越高**，访问InnoDB表需要的**磁盘I/O 就越少**，性能也就越高。

```
innodb_buffer_pool_size=512M
```

---

**innodb_log_buffer_size**

决定了innodb**重做日志缓存**的大小，对于可能产生大量更新记录的大事务，增加`innodb_log_buffer_size`的大小，可以**避免innodb在事务提交前就执行不必要的日志写入磁盘操作**。

```
innodb_log_buffer_size=10M
```

---

## Mysql并发参数调整

从实现上来说，MySQL Server 是多线程结构，包括后台线程和客户服务线程。多线程可以有效利用服务器资源，提高数据库的并发性能。在Mysql中，控制并发连接和线程的主要参数包括 `max_connections`、`back_log`、`thread_cache_size`、`table_open_cahce`。

**max_connections**

采用`max_connections` 控制**允许连接到MySQL数据库的最大数量**，默认值是 151。如果状态变量 `connection_errors_max_connections` 不为零，并且一直增长，则说明不断有连接请求因数据库连接数已达到允许最大值而失败，这是可以考虑增大`max_connections` 的值。

Mysql 最大可支持的连接数，取决于很多因素，包括给定操作系统平台的线程库的质量、内存大小、每个连接的负荷、CPU的处理速度，期望的响应时间等。

----

**back_log**

`back_log` 参数控制MySQ**L监听TCP端口时设置的积压请求栈大小**。如果MySql的连接数达到`max_connections`时，新来的请求将会被存在堆栈中，以等待某一连接释放资源，该堆栈的数量即back_log，如果等待连接的数量超过back_log，将不被授予连接资源，将会报错。5.6.6 版本之前默认值为 50 ， 之后的版本默认为 50 + （max_connections / 5）， 但最大不超过900。

如果需要数据库在**较短的时间内处理大量连接请求**， 可以考虑适当增大`back_log` 的值。

----

**table_open_cache**

该参数用来控制所有SQL语句执行线程**可打开表缓存的数量**， 而在执行SQL语句时，每一个SQL执行线程至少要打开 1 个表缓存。该参数的值应该根据设置的最大连接数 max_connections 以及每个连接执行关联查询中涉及的表的最大数量来设定

----

 **thread_cache_size**

为了加快连接数据库的速度，MySQL 会**缓存一定数量的客户服务线程**以备重用，通过参数 `thread_cache_size` 可控制 MySQL 缓存客户服务线程的数量。

----

**innodb_lock_wait_timeout**

该参数是用来设置**InnoDB 事务等待行锁的时间**，默认值是50ms ， 可以根据需要进行动态设置。对于需要**快速反馈的业务**系统来说，可以将行锁的等待时间**调小**，以避免事务长时间挂起； 对于**后台运行的批量处理程序**来说， 可以将行锁的等待时间**调大**， 以避免发生大的回滚操作。

----

## Mysql锁问题

### 锁概述

锁是计算机协调多个进程或线程并发访问某一资源的机制（避免争抢）。

在数据库中，除传统的计算资源（如 CPU、RAM、I/O 等）的争用以外，数据也是一种供许多用户共享的资源。如何保证数据并发访问的一致性、有效性是所有数据库必须解决的一个问题，锁冲突也是影响数据库并发访问性能的一个重要因素。

-----

###  锁分类

从对数据操作的**粒度**分 ： 

- 表锁：操作时，会锁定整个表。
- 行锁：操作时，会锁定当前操作行。

从对数据操作的**类型**分：

- 读锁（共享锁）：针对同一份数据，多个读操作可以同时进行而不会互相影响。
- 写锁（排它锁）：当前操作没有完成之前，它会阻断其他写锁和读锁。

----

### Mysql 锁

相对其他数据库而言，MySQL的锁机制比较简单，其最显著的特点是不同的存储引擎支持不同的锁机制。下表中罗列出了各存储引擎对锁的支持情况：

| 存储引擎 | 表级锁 | 行级锁 | 页面锁 |
| -------- | ------ | ------ | ------ |
| MyISAM   | 支持   | 不支持 | 不支持 |
| InnoDB   | 支持   | 支持   | 不支持 |
| MEMORY   | 支持   | 不支持 | 不支持 |
| BDB      | 支持   | 不支持 | 支持   |

MySQL这3种锁的特性可大致归纳如下 ：

| 锁类型 | 特点                                                         |
| ------ | ------------------------------------------------------------ |
| 表级锁 | 偏向MyISAM 存储引擎，开销小，加锁快；不会出现死锁；锁定粒度大，发生锁冲突的概率最高,并发度最低。 |
| 行级锁 | 偏向InnoDB 存储引擎，开销大，加锁慢；会出现死锁；锁定粒度最小，发生锁冲突的概率最低,并发度也最高。 |
| 页面锁 | 开销和加锁时间界于表锁和行锁之间；会出现死锁；锁定粒度界于表锁和行锁之间，并发度一般。 |

仅从锁的角度来说：**表级锁更适合于以查询为主**，只有少量按索引条件更新数据的应用，如Web 应用；而**行级锁则更适合于有大量按索引条件并发更新少量不同数**据，同时又有并查询的应用，如一些在线事务处理（OLTP）系统。

----

### MyISAM 表锁

MyISAM 存储引擎只支持表锁，这也是MySQL开始几个版本中唯一支持的锁类型。

**如何加表锁**
MyISAM 在执行查询语句（SELECT）前，会自动给涉及的所有表加读锁，在执行更新操作（UPDATE、DELETE、INSERT 等）前，会自动给涉及的表加写锁，这个过程并不需要用户干预，因此，用户一般不需要直接用 LOCK TABLE 命令给 MyISAM 表显式加锁。

**显示加表锁语法：**

```sql
加读锁 : lock table table_name read;
加写锁 : lock table table_name write;
解锁:unlock tables;
```

----

**案例环境准备**

```sql
CREATE TABLE `tb_book` (
  `id` INT(11) AUTO_INCREMENT,
  `name` VARCHAR(50) DEFAULT NULL,
  `publish_time` DATE DEFAULT NULL,
  `status` CHAR(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MYISAM DEFAULT CHARSET=utf8 ;

INSERT INTO tb_book (id, NAME, publish_time, STATUS) VALUES(NULL,'庆余年','2088-08-01','1');
INSERT INTO tb_book (id, NAME, publish_time, STATUS) VALUES(NULL,'将夜','2088-08-08','0');



CREATE TABLE `tb_user` (
  `id` INT(11) AUTO_INCREMENT,
  `name` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MYISAM DEFAULT CHARSET=utf8 ;

INSERT INTO tb_user (id, NAME) VALUES(NULL,'范闲');
INSERT INTO tb_user (id, NAME) VALUES(NULL,'宁缺');
```

----

**读锁案例**
1 客户端1获得tb_book 表的读锁 ，客户端1和2都可对该表查询
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200120220948858.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
2 客户端1不可对没获得读锁的表查询，客户端2可以
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020012022105970.png)
3 客户端1执行写操作直接报错，客户端2执行写操作被阻塞
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200120221234599.png)

----

**写锁案例**
客户端1获得tb_book 表的写锁 ，可进行读写操作，客户端2既不可读也不可写。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200120221532303.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

---

读锁会阻塞写，但是不会阻塞读。
写锁，则既会阻塞读，又会阻塞写。

此外，MyISAM 的读写锁调度是**写优先**，这也是MyISAM**不适合做写为主的表的存储引擎**的原因。因为写锁后，其他线程不能做任何操作，大量的更新会使查询很难得到锁，从而造成永远阻塞。

----

**查看锁的争用情况**

```sql
show open tables;
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200120222517401.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

- `In_user` : 表当前被查询使用的次数。如果该数为零，则表是打开的，但是当前没有被使用。
- `Name_locked`：表名称是否被锁定。名称锁定用于取消表或对表进行重命名等操作。

----

```sql
show status like 'Table_locks%';
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/2020012022264082.png)

- `Table_locks_immediate` ： 指的是能够立即获得表级锁的次数，每立即获取锁值加1。
- `Table_locks_waited` ： 指的是不能立即获取表级锁而需要等待的次数，每等待一次，该值加1，此值高说明存在着较为严重的表级锁争用情况。

---

### InnoDB 行锁

 **行锁介绍**

**行锁特点 ：**
偏向InnoDB 存储引擎，开销大，加锁慢；会出现死锁
锁定粒度最小，发生锁冲突的概率最低,并发度也最高。

InnoDB 与 MyISAM 的最大不同有两点：一是支持事务；二是 采用了行级锁。


**事务及其ACID属性**

事务是由一组SQL语句组成的逻辑处理单元。

事务具有以下4个特性，简称为事务ACID属性。

| ACID属性             | 含义                                                         |
| -------------------- | ------------------------------------------------------------ |
| 原子性（Atomicity）  | 事务是一个原子操作单元，其对数据的修改，要么全部成功，要么全部失败。 |
| 一致性（Consistent） | 在事务开始和完成时，数据都必须保持一致状态。                 |
| 隔离性（Isolation）  | 数据库系统提供一定的隔离机制，保证事务在不受外部并发操作影响的 “独立” 环境下运行。 |
| 持久性（Durable）    | 事务完成之后，对于数据的修改是永久的。                       |

----

**并发事务处理带来的问题**

| 问题                               | 含义                                                         |
| ---------------------------------- | ------------------------------------------------------------ |
| 丢失更新（Lost Update）            | 当两个或多个事务选择同一行，最初的事务修改的值，会被后面的事务修改的值覆盖。 |
| 脏读（Dirty Reads）                | 当一个事务正在访问数据，并且对数据进行了修改，而这种修改还没有提交到数据库中，这时，另外一个事务也访问这个数据，然后使用了这个数据。 |
| 不可重复读（Non-Repeatable Reads） | 一个事务在读取某些数据后的某个时间，再次读取以前读过的数据，却发现和以前读出的数据不一致。 |
| 幻读（Phantom Reads）              | 一个事务按照相同的查询条件重新读取以前查询过的数据，却发现其他事务插入了满足其查询条件的新数据。 |

------

**事务隔离级别**

为了解决上述提到的事务并发问题，数据库提供一定的事务隔离机制来解决这个问题。数据库的事务隔离越严格，并发副作用越小，但付出的代价也就越大，因为事务隔离实质上就是使用事务在一定程度上“串行化” 进行，这显然与“并发” 是矛盾的。 

数据库的隔离级别有4个，由低到高依次为Read uncommitted、Read committed、Repeatable read、Serializable，这四个级别可以逐个解决脏写、脏读、不可重复读、幻读这几类问题。

| 隔离级别                | 丢失更新 | 脏读 | 不可重复读 | 幻读 |
| ----------------------- | -------- | ---- | ---------- | ---- |
| Read uncommitted        | ×        | √    | √          | √    |
| Read committed          | ×        | ×    | √          | √    |
| Repeatable read（默认） | ×        | ×    | ×          | √    |
| Serializable            | ×        | ×    | ×          | ×    |

备注 ： √  代表可能出现 ， × 代表不会出现 。

-----

**InnoDB 的行锁模式**

InnoDB  实现了以下两种类型的行锁。

- 共享锁（S）：又称为读锁，简称S锁，共享锁就是多个事务对于同一数据可以共享一把锁，都能访问到数据，但是只能读不能修改。
- 排他锁（X）：又称为写锁，简称X锁，排他锁就是不能与其他锁并存，如一个事务获取了一个数据行的排他锁，其他事务就不能再获取该行的其他锁，包括共享锁和排他锁，但是获取排他锁的事务是可以对数据就行读取和修改。

对于UPDATE、DELETE和INSERT语句，InnoDB会自动给涉及数据集加排他锁（X)；
对于普通SELECT语句，InnoDB不会加任何锁；


可以通过以下语句显示给记录集加共享锁或排他锁 。

```sql
共享锁（S）: SELECT * FROM 表名 WHERE ... LOCK IN SHARE MODE

排他锁（X): SELECT * FROM 表名 WHERE ... FOR UPDATE
```

---

**环境准备**
创建存储引擎为innodb的表，并创建两个单列索引。

```sql
CREATE TABLE test_innodb_lock(
	id INT(11),
	NAME VARCHAR(16),
	sex VARCHAR(1)
)ENGINE = INNODB DEFAULT CHARSET=utf8;

INSERT INTO test_innodb_lock VALUES(1,'100','1');
INSERT INTO test_innodb_lock VALUES(3,'3','1');
INSERT INTO test_innodb_lock VALUES(4,'400','0');
INSERT INTO test_innodb_lock VALUES(5,'500','1');
INSERT INTO test_innodb_lock VALUES(6,'600','0');
INSERT INTO test_innodb_lock VALUES(7,'700','0');
INSERT INTO test_innodb_lock VALUES(8,'800','1');
INSERT INTO test_innodb_lock VALUES(9,'900','1');
INSERT INTO test_innodb_lock VALUES(1,'200','0');

CREATE INDEX idx_test_innodb_lock_id ON test_innodb_lock(id);
CREATE INDEX idx_test_innodb_lock_name ON test_innodb_lock(NAME);
```

**行锁基本演示**

| Session-1                                                    | Session-2                                                    |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200121141253748.png)  关闭自动提交功能 | ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200121141300446.png)关闭自动提交功能 |
| ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200121141343199.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)可以正常的查询出全部的数据 | ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200121141346292.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)可以正常的查询出全部的数据 |
| ![在这里插入图片描述](https://img-blog.csdnimg.cn/2020012114152642.png) 更新id为1的数据，但是不提交； | ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200121141512740.png)更新id为1 的数据,处于等待状态 |
| ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200121141545762.png)通过commit， 提交事务 | ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200121141600623.png)解除阻塞，更新正常进行 |
| 以上， 操作的都是同一行的数据，接下来，演示不同行的数据 ：   |                                                              |
| ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200121141700337.png) 更新id为1数据，正常的获取到行锁 ， 执行更新 ； | ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200121141726835.png) 更新id为2数据，正常的获取到行锁 ， 执行更新 ； |

----

**无索引行锁升级为表锁**

如果不通过索引条件检索数据，那么InnoDB将对表中的所有记录加锁，实际效果跟表锁一样。

| Session-1                                                    | Session-2                                                    |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| 关闭事务的自动提交![在这里插入图片描述](https://img-blog.csdnimg.cn/20200121142917179.png) | 关闭事务的自动提交![在这里插入图片描述](https://img-blog.csdnimg.cn/20200121142913426.png) |
| 执行更新语句 ：![在这里插入图片描述](https://img-blog.csdnimg.cn/20200121142933720.png) | 执行更新语句， 但处于阻塞状态：![在这里插入图片描述](https://img-blog.csdnimg.cn/20200121143005242.png) |
| 提交事务：![在这里插入图片描述](https://img-blog.csdnimg.cn/2020012114301188.png) | 解除阻塞，执行更新成功 ：![在这里插入图片描述](https://img-blog.csdnimg.cn/20200121143028220.png) |

由于执行更新时 ， name字段本来为varchar类型， 我们是作为数组类型使用，存在类型转换，索引失效，最终行锁变为表锁 。
上一篇文章说过，字符串不加引号会导致索引失效。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200121142611317.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

----

 **间隙锁危害**

当我们用范围条件，而不是使用相等条件检索数据，并请求共享或排他锁时，InnoDB会给符合条件的已有数据进行加锁； 对于键值在条件范围内但并不存在的记录，叫做 "间隙（GAP）" ， InnoDB也会对这个 "间隙" 加锁，这种锁机制就是所谓的 间隙锁（Next-Key锁） 。
之前的表中不存在id=2的记录，当session1执行id<4的范围更新时，session2若插入id=2的记录将被锁。

| Session-1                                                    | Session-2                                                    |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| 关闭事务自动提交![在这里插入图片描述](https://img-blog.csdnimg.cn/20200121141253748.png) | 关闭事务自动提交 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200121141253748.png) |
| 根据id范围更新数据 ![在这里插入图片描述](https://img-blog.csdnimg.cn/2020012114424356.png) | 插入id为2的记录， 出于阻塞状态![在这里插入图片描述](https://img-blog.csdnimg.cn/20200121144325715.png) |
| 提交事务 ；   ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200121144336197.png) | 解除阻塞 ， 执行插入操作![在这里插入图片描述](https://img-blog.csdnimg.cn/20200121144347381.png) |

----

**InnoDB 行锁争用情况**
**语法：**

```sql
show  status like 'innodb_row_lock%';
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/202001211445265.png)
`Innodb_row_lock_current_waits`: 当前正在等待锁定的数量
`Innodb_row_lock_time`: 从系统启动到现在锁定总时间长度
`Innodb_row_lock_time_avg` ：每次等待所花平均时长
`Innodb_row_lock_time_max`:从系统启动到现在等待最长的一次所花的时间
`Innodb_row_lock_waits`: 系统启动后到现在总共等待的次数

当等待的次数很高，而且每次等待的时长也不小的时候，我们就需要分析系统中为什么会有如此多的等待，然后根据分析结果着手制定优化计划。

----

**总结**

InnoDB存储引擎由于实现了行级锁定，虽然在锁定机制的实现方面带来了性能损耗可能比表锁会更高一些，但是在整体并发处理能力方面要远远由于MyISAM的表锁的。当系统并发量较高的时候，InnoDB的整体性能和MyISAM相比就会有比较明显的优势。

但是，InnoDB的行级锁同样也有其脆弱的一面，当我们使用不当的时候，可能会让InnoDB的整体性能表现不仅不能比MyISAM高，甚至可能会更差。

优化建议：

> - 尽可能让所有数据检索都能通过索引来完成，避免无索引行锁升级为表锁。
> - 合理设计索引，尽量缩小锁的范围
> - 尽可能减少索引条件，及索引范围，避免间隙锁
> - 尽量控制事务大小，减少锁定资源量和时间长度
> - 尽可使用低级别事务隔离（但是需要业务层面满足需求）

---

## 常用SQL技巧

### SQL执行顺序

编写顺序

```sql
SELECT DISTINCT
	<select list>
FROM
	<left_table> <join_type>
JOIN
	<right_table> ON <join_condition>
WHERE
	<where_condition>
GROUP BY
	<group_by_list>
HAVING
	<having_condition>
ORDER BY
	<order_by_condition>
LIMIT
	<limit_params>
```

执行顺序

```sql
FROM	<left_table>

ON 		<join_condition>

<join_type>		JOIN	<right_table>

WHERE		<where_condition>

GROUP BY 	<group_by_list>

HAVING		<having_condition>

SELECT DISTINCT		<select list>

ORDER BY	<order_by_condition>

LIMIT		<limit_params>
```

------

###  正则表达式使用

正则表达式（Regular Expression）是指一个用来描述或者匹配一系列符合某个句法规则的字符串的单个字符串。

| 符号   | 含义                          |
| ------ | ----------------------------- |
| ^      | 在字符串开始处进行匹配        |
| $      | 在字符串末尾处进行匹配        |
| .      | 匹配任意单个字符, 包括换行符  |
| [...]  | 匹配出括号内的任意字符        |
| [^...] | 匹配不出括号内的任意字符      |
| a*     | 匹配零个或者多个a(包括空串)   |
| a+     | 匹配一个或者多个a(不包括空串) |
| a?     | 匹配零个或者一个a             |
| a1\|a2 | 匹配a1或a2                    |
| a(m)   | 匹配m个a                      |
| a(m,)  | 至少匹配m个a                  |
| a(m,n) | 匹配m个a 到 n个a              |
| a(,n)  | 匹配0到n个a                   |
| (...)  | 将模式元素组成单一元素        |

```sql
select * from emp where name regexp '^T';#以T开头

select * from emp where name regexp '2$';#以2结尾

select * from emp where name regexp '[uvw]';#含uvw任意一个
```

----

#### 6.3 MySQL 常用函数

数字函数

| 函数名称        | 作 用                                                      |
| --------------- | ---------------------------------------------------------- |
| ABS             | 求绝对值                                                   |
| SQRT            | 求二次方根                                                 |
| MOD             | 求余数                                                     |
| CEIL 和 CEILING | 两个函数功能相同，都是返回不小于参数的最小整数，即向上取整 |
| FLOOR           | 向下取整，返回值转化为一个BIGINT                           |
| RAND            | 生成一个0~1之间的随机数，传入整数参数是，用来产生重复序列  |
| ROUND           | 对所传参数进行四舍五入                                     |
| SIGN            | 返回参数的符号                                             |
| POW 和 POWER    | 两个函数的功能相同，都是所传参数的次方的结果值             |
| SIN             | 求正弦值                                                   |
| ASIN            | 求反正弦值，与函数 SIN 互为反函数                          |
| COS             | 求余弦值                                                   |
| ACOS            | 求反余弦值，与函数 COS 互为反函数                          |
| TAN             | 求正切值                                                   |
| ATAN            | 求反正切值，与函数 TAN 互为反函数                          |
| COT             | 求余切值                                                   |

字符串函数

| 函数名称  | 作 用                                                        |
| --------- | ------------------------------------------------------------ |
| LENGTH    | 计算字符串长度函数，返回字符串的字节长度                     |
| CONCAT    | 合并字符串函数，返回结果为连接参数产生的字符串，参数可以使一个或多个 |
| INSERT    | 替换字符串函数                                               |
| LOWER     | 将字符串中的字母转换为小写                                   |
| UPPER     | 将字符串中的字母转换为大写                                   |
| LEFT      | 从左侧字截取符串，返回字符串左边的若干个字符                 |
| RIGHT     | 从右侧字截取符串，返回字符串右边的若干个字符                 |
| TRIM      | 删除字符串左右两侧的空格                                     |
| REPLACE   | 字符串替换函数，返回替换后的新字符串                         |
| SUBSTRING | 截取字符串，返回从指定位置开始的指定长度的字符换             |
| REVERSE   | 字符串反转（逆序）函数，返回与原始字符串顺序相反的字符串     |

日期函数

| 函数名称                | 作 用                                                        |
| ----------------------- | ------------------------------------------------------------ |
| CURDATE 和 CURRENT_DATE | 两个函数作用相同，返回当前系统的日期值                       |
| CURTIME 和 CURRENT_TIME | 两个函数作用相同，返回当前系统的时间值                       |
| NOW 和  SYSDATE         | 两个函数作用相同，返回当前系统的日期和时间值                 |
| MONTH                   | 获取指定日期中的月份                                         |
| MONTHNAME               | 获取指定日期中的月份英文名称                                 |
| DAYNAME                 | 获取指定曰期对应的星期几的英文名称                           |
| DAYOFWEEK               | 获取指定日期对应的一周的索引位置值                           |
| WEEK                    | 获取指定日期是一年中的第几周，返回值的范围是否为 0〜52 或 1〜53 |
| DAYOFYEAR               | 获取指定曰期是一年中的第几天，返回值范围是1~366              |
| DAYOFMONTH              | 获取指定日期是一个月中是第几天，返回值范围是1~31             |
| YEAR                    | 获取年份，返回值范围是 1970〜2069                            |
| TIME_TO_SEC             | 将时间参数转换为秒数                                         |
| SEC_TO_TIME             | 将秒数转换为时间，与TIME_TO_SEC 互为反函数                   |
| DATE_ADD 和 ADDDATE     | 两个函数功能相同，都是向日期添加指定的时间间隔               |
| DATE_SUB 和 SUBDATE     | 两个函数功能相同，都是向日期减去指定的时间间隔               |
| ADDTIME                 | 时间加法运算，在原始时间上添加指定的时间                     |
| SUBTIME                 | 时间减法运算，在原始时间上减去指定的时间                     |
| DATEDIFF                | 获取两个日期之间间隔，返回参数 1 减去参数 2 的值             |
| DATE_FORMAT             | 格式化指定的日期，根据参数返回指定格式的值                   |
| WEEKDAY                 | 获取指定日期在一周内的对应的工作日索引                       |

聚合函数

| 函数名称 | 作用                             |
| -------- | -------------------------------- |
| MAX      | 查询指定列的最大值               |
| MIN      | 查询指定列的最小值               |
| COUNT    | 统计查询结果的行数               |
| SUM      | 求和，返回指定列的总和           |
| AVG      | 求平均值，返回指定列数据的平均值 |

----

## MySql中常用工具

### mysql

该mysql不是指mysql服务，而是指mysql的客户端工具。
**语法 ：**

```
mysql [options] [database]
```

**连接选项**

```
参数 ： 
	-u, --user=name			指定用户名
	-p, --password[=name]	指定密码
	-h, --host=name			指定服务器IP或域名
	-P, --port=#			指定连接端口

示例 ：
	mysql -h 127.0.0.1 -P 3306 -u root -p
	
	mysql -h127.0.0.1 -P3306 -uroot -p2143
	
```

**执行选项**

```
-e, --execute=name		执行SQL语句并退出
```

此选项可以在Mysql客户端执行SQL语句，而不用连接到MySQL数据库再执行，对于一些批处理脚本，这种方式尤其方便。

```
示例：
	mysql -uroot -p test -e "select * from tb_book";
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200121153953729.png)

----

### mysqladmin

mysqladmin 是一个执行管理操作的客户端程序。可以用它来检查服务器的配置和当前状态、创建并删除数据库等。
可以通过 ： `mysqladmin --help`  指令查看帮助文档
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200121154100805.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

示例 ：查询版本 `mysqladmin -uroot -p你的密码 version;`
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200121154209487.png)

----

### mysqlbinlog

由于服务器生成的二进制日志文件以二进制格式保存，所以如果想要检查这些文本的文本格式，就会使用到mysqlbinlog 日志管理工具。
语法 ：

```
mysqlbinlog [options]  log-files1 log-files2 ...

选项：	
	-d, --database=name : 指定数据库名称，只列出指定的数据库相关操作。	
	-o, --offset=# : 忽略掉日志中的前n行命令。	
	-r,--result-file=name : 将输出的文本格式日志输出到指定文件。	
	-s, --short-form : 显示简单格式， 省略掉一些信息。	
	--start-datatime=date1  --stop-datetime=date2 : 指定日期间隔内的所有日志。	
	--start-position=pos1 --stop-position=pos2 : 指定位置间隔内的所有日志。
```

---

### mysqldump

mysqldump 客户端工具用来备份数据库或在不同数据库之间进行数据迁移。备份内容包含创建表，及插入表的SQL语句。
语法 ：

```
mysqldump [options] db_name [tables] 
mysqldump [options] --database/-B db1 [db2 db3...]
mysqldump [options] --all-databases/-A  （备份全部数据库）
```

**连接选项**

```
参数 ： 
	-u, --user=name			指定用户名
	-p, --password[=name]	指定密码
	-h, --host=name			指定服务器IP或域名
	-P, --port=#			指定连接端口
```



**输出内容选项**

```
参数：
	--add-drop-database		在每个数据库创建语句前加上 Drop database 语句
	--add-drop-table		在每个表创建语句前加上 Drop table 语句 , 默认开启 ; 不开启 (--skip-add-drop-table)
	
	-n, --no-create-db		不包含数据库的创建语句
	-t, --no-create-info	不包含数据表的创建语句
	-d --no-data			不包含数据
	
	-T, --tab=name			自动生成两个文件：一个.sql文件，创建表结构的语句；
	 						一个.txt文件，数据文件，相当于select into outfile  
```

示例 ： 

1 备份test2数据库的tb_book表，在数据库创建语句前加上drop database和drop table，导出到book.sql文件

`mysqldump -uroot -psjh2019.  test2  tb_book --add-drop-database --add-drop-table > book.sql`
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200121155611366.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)	
2 备份test2中的tb_book表到tmp目录
`mysqldump -uroot -psjh2019. -T /tmp test2 tb_book`

---

### mysqlimport/source

mysqlimport 是客户端数据导入工具，用来导入mysqldump 加 -T 参数后导出的文本文件。

**语法：**
`mysqlimport [options]  db_name  textfile1  [textfile2...]`

----

如果需要导入sql文件,可以使用mysql中的`source `指令 : 
先将表删除：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200121161640993.png)
再导入：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200121161717736.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200121161737557.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

---

### mysqlshow

mysqlshow 客户端对象查找工具，用来很快地查找存在哪些数据库、数据库中的表、表中的列或者索引。
**语法：**
`mysqlshow [options] [数据库名  [表名  [列名]]]`

参数：

```
--count		显示数据库及表的统计信息（数据库，表 均可以不指定）
-i			显示指定数据库或者指定表的状态信息
```

示例：
**查询每个数据库的表的数量及表中记录的数量**
`mysqlshow -uroot -psjh2019. --count`

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200121162428441.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

---

**查询test2库中每个表中的字段书，及行数**
`mysqlshow -uroot -psjh2019.   --count  test2`
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200121162535432.png)

----

**查询test库中tb_book表的详细情况**
`mysqlshow -uroot -psjh2019. -i test2 tb_book`
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020012116265563.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

---

# JDBC

## 一  概述

###   数据持久化

> - 把数据保存到可掉电式存储设备中以供之后使用。大多数情况下数据持久化意味着将内存中的数据保存到硬盘上加以”固化”，而持久化的实现过程大多通过各种关系数据库来完成。
> - 持久化的主要应用是将内存中的数据存储在关系型数据库中，当然也可以存储在磁盘文件、XML数据文件中。
>
> ###   Java中的数据存储技术
>
> - 在Java中，数据库存取技术可分为3类：
>   - JDBC直接访问数据库
>   - JDO (Java Data Object )技术
>   - 数据库框架，如Hibernate, Mybatis 等
> - JDBC是Java访问数据库的基石，JDO、Hibernate、MyBatis等只是更好的封装了JDBC。
>
>  ###  JDBC概念
>
> - JDBC(Java Database Connectivity)是一个独立于特定数据库管理系统、通用的SQL数据库存取和操作的公共接口（一组API），定义了用来访问数据库的标准Java类库（java.sql,javax.sql），使用这些类库可以以一种标准的方法方便地访问数据库资源。
> - JDBC为访问不同的数据库提供*统一的途径，为开发者屏蔽了一些细节问题。
> - JDBC的目标是使Java程序员使用JDBC可以连接任何提供了JDBC驱动程序的数据库系统，这样就使得程序员无需对特定的数据库系统的特点有过多的了解，从而大大简化和加快了开发过程。
>
> ###   JDBC体系结构
>
> JDBC接口（API）包括两个层次：
>
>   - 面向应用的API：Java API，抽象接口，供应用程序开发人员使用（连接数据库，执行SQL语句，获得结果）。
>   - 面向数据库的API：Java Driver API，供开发商开发数据库驱动程序用。

### JDBC编写步骤

> （1）导入相应的jar包
> （2）加载、注册sql驱动
> （3）获取Connection连接对象
> （4）创建Statement对象并执行SQL语句
> （5）使用ResultSet对象获取查询结果集
> （6）依次关闭ResultSet、Statement、Connection对象

## 二 获取数据库连接

### Driver

> - java.sql.Driver 接口是所有 JDBC 驱动程序需要实现的接口。这个接口是提供给数据库厂商使用的，不同数据库厂商提供不同的实现。
> - 在程序中不需要直接去访问实现了 Driver 接口的类，而是由驱动程序管理器类(java.sql.DriverManager)去调用这些Driver实现。
>   - mySql的驱动： **com.mysql.cj.jdbc.Driver**

### URL

> - JDBC URL 用于标识一个被注册的驱动程序，驱动程序管理器通过这个 URL 选择正确的驱动程序，从而建立到数据库的连接。
> - JDBC URL的标准由三部分组成，各部分间用冒号分隔。 
>   - jdbc:子协议:子名称
>   - 协议：JDBC URL中的协议总是jdbc 
>   - 子协议：子协议用于标识一个数据库驱动程序
>   - 子名称：一种标识数据库的方法。子名称可以依不同的子协议而变化，用子名称的目的是为了定位数据库提供足够的信息。包含主机名(对应服务端的ip地址)，端口号，数据库名

  

### 连接数据库

首先下载jdbc的jar包：[https://dev.mysql.com/downloads/connector/j/](https://dev.mysql.com/downloads/connector/j/)
然后在项目中创建一个lib文件夹并将下载好的jar包导入，右键选择add as library
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191218120740340.png)

- 方式1：

```java
	@Test
    public void test1() throws SQLException {
        //获取jdbc驱动实现类对象
        Driver driver=new Driver();
        //要连接的数据库url
        String url="jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        //用Properties封装数据库用户名和密码
        Properties properties=new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","sjh2019");
        //获取数据库连接
        Connection connect = driver.connect(url,properties);
        //输出连接地址
        System.out.println(connect);
    }

```

- 方式2：为提高可移植性，代码中尽量不要出现第三方API    

```java
	@Test
    public void test2() throws Exception {
        //获取jdbc驱动实现类对象,使用反射
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        //要连接的数据库url
        String url="jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        //用Properties封装数据库用户名和密码
        Properties properties=new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","sjh2019");
        //获取数据库连接
        Connection connect = driver.connect(url,properties);
        //输出连接地址
        System.out.println(connect);
    }
```

- 方式3: 使用DriverManager替换Driver

```java
	 @Test
    public void test3() throws Exception {
        //获取jdbc驱动实现类对象,使用反射
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        //注册驱动
        DriverManager.registerDriver(driver);
        //要连接的数据库url,用户名和密码
        String url="jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String user="root";
        String password="sjh2019";
        //获取数据库连接
        Connection connect = DriverManager.getConnection(url, user, password);
        //输出连接地址
        System.out.println(connect);
    }  
```

- 方式4: 去除冗余代码，Driver类加载时会自动注册

```java
	Driver源码：
	public class Driver extends NonRegisteringDriver implements java.sql.Driver {
		public Driver() throws SQLException {}
		
	    static {
	        try {
	            DriverManager.registerDriver(new Driver());
	        } catch (SQLException var1) {
	            throw new RuntimeException("Can't register driver!");
	        }
	    }
	}

	@Test
    public void test4() throws Exception {
        //注册驱动（也可省略，jar包文件中已配置，不推荐省略！）
        Class.forName("com.mysql.cj.jdbc.Driver");
        //要连接的数据库url,用户名和密码
        String url="jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String user="root";
        String password="sjh2019";
        //获取数据库连接
        Connection connect = DriverManager.getConnection(url, user, password);
        //输出连接地址
        System.out.println(connect);
    }
```

- 方式5:  通过读取配置文件获取连接

> 好处：
> 实现数据和代码的分离，实现了解耦 
> 如果需要修改配置文件信息，可以避免程序重新打包

首先再在src下创建一个配置文件
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191218130958536.png)

```java
url=jdbc:mysql://localhost:3306/test?serverTimezone=UTC
user=root
password=sjh2019
driver=com.mysql.cj.jdbc.Driver
```

```java
	@Test
    public void test5() throws Exception {
        //读取配置文件信息
        InputStream in = DriverTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties=new Properties();
        properties.load(in);
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        //注册驱动
        Class.forName(driver);
        //获取数据库连接
        Connection connect = DriverManager.getConnection(url, user, password);
        //输出连接地址
        System.out.println(connect);
    }
```

## 三 CRUD操作

### 操作和访问数据库

> - 数据库连接被用于向数据库服务器发送命令和 SQL 语句，并接受数据库服务器返回的结果。其实一个数据库连接就是一个Socket连接。
> - 在 java.sql 包中有 3 个接口分别定义了对数据库的调用的不同方式：
>   - Statement：用于执行静态 SQL 语句并返回它所生成结果的对象。 
>   - PrepatedStatement：SQL 语句被预编译并存储在此对象中，可以使用此对象多次高效地执行该语句。
>   - CallableStatement：用于执行 SQL 存储过程

### 使用Statement操作数据表的弊端

> - 通过调用 Connection 对象的 createStatement() 方法创建该对象。该对象用于执行静态的 SQL 语句，并且返回执行结果。
>
> - Statement 接口中定义了下列方法用于执行 SQL 语句：
>   `int excuteUpdate(String sql)`：执行更新操作INSERT、UPDATE、DELETE   
>    `ResultSet executeQuery(String sql)`：执行查询操作SELECT
>
> - 使用Statement操作数据表存在弊端：
>   - **问题一：存在拼串操作，繁琐**
>   - **问题二：存在SQL注入问题**
> - SQL 注入是利用某些系统没有对用户输入的数据进行充分的检查，而在用户输入数据中注入非法的 SQL 语句段或命令，从而利用系统的 SQL 引擎完成恶意行为的做法。
> - 要防范 SQL 注入，只要用 PreparedStatemen取代 Statement 就可以了。

```java
public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("用户名：");
		String userName = scan.nextLine();
		System.out.print("密   码：");
		String password = scan.nextLine();
		String sql = "SELECT user,password FROM user_table WHERE user = '" + userName + "' AND password = '" + password
				+ "'";
		boolean re = get(sql);
		if (re) {
			System.out.println("登陆成功!");
		} else {
			System.out.println("用户名或密码错误！");
		}
	}

	// 使用Statement实现对数据表的查询操作
	private static boolean get(String sql) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// 1.加载配置文件
			InputStream is = StatementTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
			Properties pros = new Properties();
			pros.load(is);
			// 2.读取配置信息
			String user = pros.getProperty("user");
			String password = pros.getProperty("password");
			String url = pros.getProperty("url");
			String driver = pros.getProperty("driver");
			// 3.加载驱动
			Class.forName(driver);
			// 4.获取连接
			conn = DriverManager.getConnection(url, user, password);
			//创建Statement对象
			st = conn.createStatement();
			//执行sql语句
			rs = st.executeQuery(sql);
			//如果结果集存在，返回true
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
}

```

运行结果：

> 用户名：不存在的用户名 ' or
> 密   码：= 123 or '正确'='正确
> 登陆成功!

相当于查询

> SELECT USER,PASSWORD FROM user_table 
> WHERE USER = '不存在的用户名 '
> OR 'AND password =' = 123 
> OR '正确'='正确';

所以即使输入错误也会登陆成功，可见使用Statement是十分不安全的。

### PreparedStatement的使用

- 概念

> - 可以通过调用 Connection 对象的 `preparedStatement(String sql)` 方法获取 PreparedStatement 对象
> - PreparedStatement 接口是 Statement 的子接口，它表示一条预编译过的 SQL 语句
> - PreparedStatement 对象所代表的 SQL 语句中的参数用问号(?)来表示，调用 setXxx() 方法来设置这些参数,Xxx是数据库对应字段的类型。
> - setXxx() 方法有两个参数，第一个参数是要设置的 SQL 语句中的参数的索引(从 1
>   开始)，第二个是设置的 SQL 语句中的参数的值

- 为减少冗余，创建一个JDBC工具类

```java
public class JDBCUtils {
    //获取数据库连接
    public static Connection getConnection() throws Exception {
        //读取配置文件信息
        InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties=new Properties();
        properties.load(in);
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        //注册驱动
        Class.forName(driver);
        //获取数据库连接
        return DriverManager.getConnection(url, user, password);
    }
    
    public static void closeConnection(Connection connection, Statement statement){
        try{
            if(connection!=null)
                connection.close();
        }catch (Exception e){e.printStackTrace();}
        try{
            if(statement!=null)
                statement.close();
        }catch (Exception e){e.printStackTrace();}
    }

	public static void closeConnection(Connection connection, Statement statement, ResultSet resultSet){
        closeConnection(connection,statement);
        try{
            if(resultSet!=null)
                resultSet.close();
        }catch (Exception e){e.printStackTrace();}
    }
}
```

- 增加记录

```java
	//添加一条数据
    @Test
    public void insert(){
        Connection connect=null;
        PreparedStatement ps=null;
        try{
            //1.获取连接
            connect = JDBCUtils.getConnection();
            //2.预编译sql语句，返回preparedStatement实例
            String sql="insert into user_table values(?,?,?)";
            ps = connect.prepareStatement(sql);
            //3.填充占位符 setXxx Xxx表示字段类型
            ps.setString(1,"james");
            ps.setInt(2,1234);
            ps.setInt(3,2000);
            //4.执行sql
            ps.execute();//返回值true代表查询 false代表增删改
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //5.关闭资源
            JDBCUtils.closeConnection(connect,ps);
        }
    }
```

- 更新记录

```java
	//更新一条数据
    @Test
    public void update()  {
        Connection connect=null;
        PreparedStatement ps=null;
        try{
            connect = JDBCUtils.getConnection();
            String sql="update user_table set balance=? where user =?";
            ps = connect.prepareStatement(sql);
            ps.setString(2,"james");
            ps.setInt(1,5000);
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(connect,ps);
        }
```

- 通用的增删改记录

```java
	//通用的增删改操作
    public void commonUpdate(String sql,Object...args){
        Connection connect=null;
        PreparedStatement ps=null;
        try{
            connect = JDBCUtils.getConnection();
            ps = connect.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);//数据库中索引从1开始
            }
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(connect,ps);
        }
    }
```

- 查询操作
  封装查询结果的Customer类

```java
	public class Customer {
	    private Integer id;
	    private String name;
	    private String email;
	
	    public Customer(Integer id, String name, String email) {
	        this.id = id;
	        this.name = name;
	        this.email = email;
	    }
	
	    @Override
	    public String toString() {
	        return "Customer{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", email='" + email + '\'' +
	                '}';
	    }
	}

```

```java
	//查询操作
    @Test
    public void query(){
        Connection connect=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            //1.获取连接
            connect = JDBCUtils.getConnection();
            //2.预编译sql语句，返回preparedStatement实例
            String sql="select * from customers where id=?";
            ps = connect.prepareStatement(sql);
            //3.填充占位符 setXxx Xxx表示字段类型
            ps.setInt(1,1);
            //4.执行sql
            ResultSet resultSet = ps.executeQuery();
            //5.若结果集不为空，对其封装输出
            if(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Customer customer = new Customer(id, name, email);
                System.out.println(customer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(connect,ps,rs);
        }
    }
```

- 针对Customer类的通用查询方法

```java
//通用查询操作
    @Test
    public Customer query(String sql,Object...args){
        Connection connect=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            //1.获取连接
            connect = JDBCUtils.getConnection();
            //2.预编译sql语句，返回preparedStatement实例
            ps = connect.prepareStatement(sql);
            //3.填充占位符 setXxx Xxx表示字段类型
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            //4.执行sql
            ResultSet resultSet = ps.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();//获取元数据
            int columnCount = metaData.getColumnCount();//获取列数
            //5.若结果集不为空，对其封装
            if(resultSet.next()){
               Customer customer=new Customer();
               for(int i=0;i<columnCount;i++){
                   Object value = resultSet.getObject(i + 1);//获取列值
                   String columnName = metaData.getColumnName(i + 1);//获取列名
                   Field field = customer.getClass().getDeclaredField(columnName);//获取该属性名对应属性
                   field.setAccessible(true);//设置可操作权限
                   field.set(customer,value);
               }
               return customer;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(connect,ps,rs);
        }
        return null;
    }
```

- 多表通用查询

```java
	//通用查询操作
    @Test
    public <T>List<T> query(Class<T> clazz,String sql,Object...args){
        Connection connect=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<T> result=new ArrayList<>();
        try{
            connect = JDBCUtils.getConnection();
            ps = connect.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            ResultSet resultSet = ps.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()){
                T t=clazz.newInstance();
               for(int i=0;i<columnCount;i++){
                   Object value = resultSet.getObject(i + 1);
                   String columnName = metaData.getColumnLabel(i + 1);
                   Field field = clazz.getDeclaredField(columnName);
                   field.setAccessible(true);
                   field.set(t,value);
               }
               result.add(t);
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(connect,ps,rs);
        }
        return null;
    }
```

-  PreparedStatement 和Statement的区别

> - PreparedStatement代码的可读性和可维护性更强
> - PreparedStatement 能实现更高效的批量操作
>   - DBServer会对预编译语句提供性能优化。因为预编译语句有可能被重复调用，所以语句在被DBServer的编译器编译后的执行代码被缓存下来，那么下次调用时只要是相同的预编译语句就不需要编译，只要将参数直接传入编译过的语句执行代码中就会得到执行。
>   - 在statement语句中,每执行一次都要对传入的语句编译一次。
> - PreparedStatement 可以防止 SQL 注入
> - PreparedStatement  可操作Blob类数据

- Java与SQL对应数据类型转换表

| Java类型           | SQL类型                  |
| ------------------ | ------------------------ |
| boolean            | BIT                      |
| byte               | TINYINT                  |
| short              | SMALLINT                 |
| int                | INTEGER                  |
| long               | BIGINT                   |
| String             | CHAR,VARCHAR,LONGVARCHAR |
| byte   array       | BINARY  ,    VAR BINARY  |
| java.sql.Date      | DATE                     |
| java.sql.Time      | TIME                     |
| java.sql.Timestamp | TIMESTAMP                |

###  ResultSet

> - PreparedStatement 的 `executeQuery() `方法，查询结果是一个ResultSet 对象
> - ResultSet 对象以逻辑表格的形式封装了执行数据库操作的结果集，ResultSet 接口由数据库厂商提供实现
> - ResultSet 返回的实际上就是一张数据表，有一个指针指向数据表的第一条记录的前面。
> - ResultSet 对象维护了一个指向当前数据行的**游标**，初始的时候，游标在第一行之前，可以通过 ResultSet 对象的` next() `方法移动到下一行。调用 next()方法检测下一行是否存在。若存在，该方法返回
>   true，且指针下移，相当于Iterator对象的 `hasNext()` 和 `next() `方法的结合体。
> - 可以通过调用 getXxx()获取每一列的值。

   **注：Java与数据库交互涉及到的相关Java API中的索引都从1开始。**

### ResultSetMetaData

> - 可用于获取关于 ResultSet 对象中列的类型和属性信息的对象
> - 通过调用ResultSet对象的`getMetaData()`方法获得ResultSetMetaData对象
>   - **getColumnName**(int column)：获取指定列的名称
>   - **getColumnLabel**(int column)：获取指定列的别名
>   - **getColumnCount**()：返回当前 ResultSet 对象中的列数。

### 资源的释放

> - 释放ResultSet, Statement,Connection。
> - 数据库连接（Connection）是非常稀有的资源，用完后必须马上释放，如果Connection不能及时正确的关闭将导致系统问题。Connection的使用原则是**尽量晚创建，尽量早的释放。**
> - 可以在finally中关闭，保证及时其他代码出现异常，资源也一定能被关闭。

### JDBC API小结

- 两种思想

>   - 面向接口编程的思想
>   - ORM思想(object relational mapping)
>     - 一个数据表对应一个java类
>     - 表中的一条记录对应java类的一个对象
>     - 表中的一个字段对应java类的一个属性

- 两种技术

>   - JDBC结果集的元数据：ResultSetMetaData
>     - 获取列数：getColumnCount()
>     - 获取列的别名：getColumnLabel()
>   - 通过反射，创建指定类的对象，获取指定的属性并赋值

## 四 操作BLOB类型字段

### BLOB类型

> - MySQL中，BLOB是一个二进制大型对象，是一个可以存储大量数据的容器，它能容纳不同大小的数据。
> - 插入BLOB类型的数据必须使用PreparedStatement，因为BLOB类型的数据无法使用字符串拼接写的。
> - MySQL的四种BLOB类型(除了在存储的最大信息量上不同外，他们是等同的)

| 类型       | 最大大小（字节） |
| ---------- | ---------------- |
| TinyBlob   | 255              |
| Blob       | 65K              |
| MediumBlob | 16M              |
| LongBlob   | 4G               |

> - 实际使用中根据需要存入的数据大小定义不同的BLOB类型。
> - 需要注意的是：如果存储的文件过大，数据库的性能会下降。
> - 如果在指定了相关的Blob类型以后，还报错：xxx too large，那么在mysql的安装目录下，找my.ini文件加上如下的配置参数：
>   **max_allowed_packet=16M**。同时注意：修改了my.ini文件之后，需要重新启动mysql服务。

### 插入一个Blob类型数据

使用`setBlob(int parameterIndex, InputStream inputStream)`方法，第二个参数传入一个输入流

```java
@Test
    public void blobInsert(){
        Connection connect=null;
        PreparedStatement ps=null;
        try{
            connect = JDBCUtils.getConnection();
            String sql="update customers set photo=? where id=?";
            ps = connect.prepareStatement(sql);
            ps.setBlob(1,new FileInputStream(new File("test.jpg")));
            ps.setInt(2,1);
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(connect,ps);
        }
    }
```

### 读取Blob数据

主要使用`getBinaryStream()`方法将得到的Blob对象转换为二进制流进行输出。

```java
 @Test
    public void blobRead(){
        Connection connect=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        InputStream is = null;
        OutputStream os = null;
        try{
            connect = JDBCUtils.getConnection();
            String sql="select photo from customers where id=?";
            ps = connect.prepareStatement(sql);
            ps.setInt(1,1);
            rs = ps.executeQuery();
            if(rs.next()){
                Blob photo = rs.getBlob("photo");
                is=photo.getBinaryStream();//转换为二进制输入流
                os=new FileOutputStream(new File("a.jpg"));
                byte[] bytes=new byte[1024];
                int len;
                while((len=is.read(bytes))!=-1){
                    os.write(bytes,0,len);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(is!=null)
                    is.close();
            }catch (Exception ignored){}
            try{
                if(os!=null)
                    os.close();
            }catch (Exception ignored){}
            JDBCUtils.closeConnection(connect,ps,rs);
        }
    }
```

## 五 批量插入

### Statement和PreparedStatement的效率

分别插入100条数据

- 创建测试表

```sql
CREATE TABLE insert_test(
id INT PRIMARY KEY AUTO_INCREMENT,
NAME INT
);
```

- 使用statement

```java
	 @Test
    public void insBySta(){
        Connection connect=null;
        Statement ps=null;
        try{
            connect = JDBCUtils.getConnection();
            Statement statement = connect.createStatement();
            long pre = System.currentTimeMillis();
            for (int i = 1; i <=100 ; i++) {
                String sql="insert into insert_test(name) values ('"+i+"');";
                statement.execute(sql);
            }
            long now = System.currentTimeMillis();
            System.out.println("使用Statement批量插入100条数据耗时："+(now-pre)+"毫秒");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //5.关闭资源
            JDBCUtils.closeConnection(connect,ps);
        }
    }
```

结果：

> 使用Statement批量插入100条数据耗时：8228毫秒

- 使用PreparedStatement

```java
@Test
    public void insByPre(){
        Connection connect=null;
        Statement ps=null;
        try{
            connect = JDBCUtils.getConnection();
            String sql="insert into insert_test(name) values (?)";
            PreparedStatement preparedStatement = connect.prepareStatement(sql);
            long pre = System.currentTimeMillis();
            for (int i = 1; i <=100 ; i++) {
                preparedStatement.setInt(1, i);
                preparedStatement.execute();
            }
            long now = System.currentTimeMillis();
            System.out.println("使用PreparedStatement批量插入100条数据耗时："+(now-pre)+"毫秒");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //5.关闭资源
            JDBCUtils.closeConnection(connect,ps);
        }
    }
```

> 使用Statement批量插入100条数据耗时：7992毫秒

###  更高效地批量执行SQL语句

> 当需要成批插入或者更新记录时，可以采用Java的批量**更新**机制，这一机制允许多条语句一次性提交给数据库批量处理。通常情况下比单独提交处理更有效率。
> JDBC的批量处理语句包括下面三个方法：
>
> - **addBatch(String)：添加需要批量处理的SQL语句或是参数；**
> - **executeBatch()：执行批量处理语句；**
> - **clearBatch():清空缓存的数据**
>
> mysql服务器默认是关闭批处理的，我们需要通过一个参数，让mysql开启批处理的支持。将 `?rewriteBatchedStatements=true ` 写在配置文件的url后面

```java
 @Test
    public void insByBatch(){
        Connection connect=null;
        Statement ps=null;
        try{
            connect = JDBCUtils.getConnection();
            String sql="insert into insert_test(name) values (?)";
            PreparedStatement preparedStatement = connect.prepareStatement(sql);
            long pre = System.currentTimeMillis();
            for (int i = 1; i <=100 ; i++) {
                preparedStatement.setInt(1, i);
                preparedStatement.addBatch();
                if(i%10==0) {//类似于缓冲区 每“攒”10个执行
                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();
                }
            }
            long now = System.currentTimeMillis();
            System.out.println("使用batch批量插入100条数据耗时："+(now-pre)+"毫秒");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //5.关闭资源
            JDBCUtils.closeConnection(connect,ps);
        }
```

运行结果：

> 使用batch批量插入100条数据耗时：572毫秒

- 最终优化版 待数据全部插入后再提交

```java
 @Test
    public void insByBatch(){
        Connection connect=null;
        Statement ps=null;
        try{
            connect = JDBCUtils.getConnection();
            connect.setAutoCommit(false);//关闭自动提交
            String sql="insert into insert_test(name) values (?)";
            PreparedStatement preparedStatement = connect.prepareStatement(sql);
            long pre = System.currentTimeMillis();
            for (int i = 1; i <=100 ; i++) {
                preparedStatement.setInt(1, i);
                preparedStatement.addBatch();
                if(i%10==0) {//类似于缓冲区 每“攒”10个执行
                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();
                }
            }
            connect.commit();//手动提交
            long now = System.currentTimeMillis();
            System.out.println("使用batch批量插入100条数据耗时："+(now-pre)+"毫秒");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //5.关闭资源
            JDBCUtils.closeConnection(connect,ps);
        }
    }
```

运行结果：

> 使用batch批量插入100条数据耗时：92毫秒

## 六 数据库事务

### 不安全的转账例子

初始状态：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191219141921865.png)
转账实现类：

```java
@Test
    public void unsafeTest() {
        String sql1="update user_table set balance=balance-? where user=?";
        commonUpdate(sql1, 100,"AA");
        int i=100/0;//模拟错误
        String sql2="update user_table set balance=balance+? where user=?";
        commonUpdate(sql2, 100,"BB");

    }

    public int commonUpdate(String sql,Object...args){
        Connection connect=null;
        PreparedStatement ps=null;
        try{
            connect = JDBCUtils.getConnection();
            ps = connect.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            return ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(connect,ps);
        }
        return 0;
    }
```

结果：

> 发生错误时，AA的账户减少了100元，但是BB的钱并未增加。 可见转账存在不安全问题。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20191219142438474.png)

### 事务

> - **事务：一组逻辑操作单元,使数据从一种状态变换到另一种状态。**
> - **事务处理（事务操作）：**保证所有事务都作为一个工作单元来执行，即使出现了故障，都不能改变这种执行方式。当在一个事务中执行多个操作时，要么所有的事务都**被提交(commit)**，那么这些修改就永久地保存下来；要么数据库管理系统将放弃所作的所有修改，整个事务**回滚(rollback)**到最初状态。
> - 为确保数据库中数据的**一致性**，数据的操纵应当是离散的成组的逻辑单元：当它全部完成时，数据的一致性可以保持，而当这个单元中的一部分操作失败，整个事务应全部视为错误，所有从起始点以后的操作应全部回退到开始状态。

### JDBC事务处理

> - 数据一旦提交，就不可回滚。
> - 数据什么时候意味着提交？
>   - **当一个连接对象被创建时，默认情况下是自动提交事务**：每次执行一个 SQL 语句时，如果执行成功，就会向数据库自动提交，而不能回滚。
>   - **关闭数据库连接，数据就会自动的提交。**如果多个操作，每个操作使用的是自己单独的连接，则无法保证事务。即同一个事务的多个操作必须在同一个连接下。 
> - **JDBC程序中为了让多个 SQL 语句作为一个事务执行：**
>   - 调用 Connection 对象的 **setAutoCommit(false);** 以取消自动提交事务
>   - 在所有的 SQL 语句都成功执行后，调用 **commit();** 方法提交事务
>   - 在出现异常时，调用 **rollback();** 方法回滚事务
>
> 若此时 Connection 没有被关闭，还可能被重复使用，则需要恢复其自动提交状态 setAutoCommit(true)。尤其是在使用数据库连接池技术时，执行close()方法前，建议恢复自动提交状态。

### 使用事务实现安全的转账例子

```java
	@Test
    public void safeTest() {
        Connection connection= null;
        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);

            String sql1="update user_table set balance=balance-? where user=?";
            commonUpdate(connection,sql1, 100,"AA");
            int i=100/0;//模拟错误

            String sql2="update user_table set balance=balance+? where user=?";
            commonUpdate(connection,sql2, 100,"BB");

            connection.commit();
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
       		//若此时 Connection 没有被关闭，还可能被重复使用，则需要恢复其自动提交状态 setAutoCommit(true)。
            // 尤其是在使用数据库连接池技术时，执行close()方法前，建议恢复自动提交状态。
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JDBCUtils.closeConnection(connection,null);
        }


    }

    public int commonUpdate(Connection connect,String sql,Object...args){
        PreparedStatement ps=null;
        try{
            ps = connect.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            return ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //保证使用同一个连接 不关闭
            JDBCUtils.closeConnection(null,ps);
        }
        return 0;
    }
```

结果：数据回滚，未出现不一致性问题。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191219144706131.png)

### ACID属性    

> 1. **原子性（Atomicity）**    原子性是指事务是一个不可分割的工作单位，事务中的操作要么都发生，要么都不发生。 
> 2. **一致性（Consistency）**    事务必须使数据库从一个一致性状态变换到另外一个一致性状态。
> 3. **隔离性（Isolation）**    事务的隔离性是指一个事务的执行不能被其他事务干扰，即一个事务内部的操作及使用的数据对并发的其他事务是隔离的，并发执行的各个事务之间不能互相干扰。
> 4. **持久性（Durability）**    持久性是指一个事务一旦被提交，它对数据库中数据的改变就是永久性的，接下来的其他操作和数据库故障不应该对其有任何影响。

- 并发问题

> - 对于同时运行的多个事务, 当这些事务访问数据库中相同的数据时, 如果没有采取必要的隔离机制, 就会导致各种并发问题:
>   - **脏读**: 对于两个事务 T1, T2, T1 读取了已经被 T2 更新但还**没有被提交**的字段。之后, 若 T2 回滚, T1读取的内容就是临时且无效的。
>   - **不可重复读**: 对于两个事务T1, T2, T1 读取了一个字段, 然后 T2 **更新**了该字段。之后, T1再次读取同一个字段, 值就不同了。
>   - **幻读**: 对于两个事务T1, T2, T1 从一个表中读取了一个字段, 然后 T2 在该表中**插入**了一些新的行。之后, 如果 T1 再次读取同一个表, 就会多出几行。
> - **数据库事务的隔离性**: 数据库系统必须具有隔离并发运行各个事务的能力, 使它们不会相互影响, 避免各种并发问题。
> - 一个事务与其他事务隔离的程度称为隔离级别。数据库规定了多种事务隔离级别, 不同隔离级别对应不同的干扰程度, **隔离级别越高, 数据一致性就越好, 但并发性越弱。**

- 数据库隔离级别

>-  数据库提供的4种事务隔离级别：
>   ![在这里插入图片描述](https://img-blog.csdnimg.cn/20191219162027268.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
>-  Oracle 支持的 2 种事务隔离级别：READ COMMITED, SERIALIZABLE。 Oracle 默认的事务隔离级别为:READ COMMITED 。
>-  Mysql 支持 4 种事务隔离级别。Mysql 默认的事务隔离级别为: REPEATABLE READ。

### 隔离级别不安全问题演示

使用`select @@transaction_isolation;`查询数据库隔离级别，mysql默认可重复读
开启两个命令行窗口，分别连接数据库，并通过`set autocommit=false;`关闭自动提交事务

- 隔离级别为读未提交时（存在脏读、不可重复读、幻读）
  ![在这里插入图片描述](https://img-blog.csdnimg.cn/20191219165025740.png)
  事务1（图左）的未提交数据被事务2读到（脏读）
  ![在这里插入图片描述](https://img-blog.csdnimg.cn/20191219165102772.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
- 隔离级别为读已提交时（存在不可重复读、幻读）
  ![在这里插入图片描述](https://img-blog.csdnimg.cn/20191219165207736.png)事务1（图左）的提交数据被事务2读到（不可重复读）
  ![在这里插入图片描述](https://img-blog.csdnimg.cn/20191219165530937.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
- 隔离级别为可重复读时（存在幻读）
  ![在这里插入图片描述](https://img-blog.csdnimg.cn/20191219165907803.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)
  事务2（图右）提交的插入数据干扰到事务1（幻读）
  事务1查询时并无user为ee的记录，此时事务2插入了该记录并提交，事务1再插入时因主键重复插入失败。（本例user为主键）
  ![在这里插入图片描述](https://img-blog.csdnimg.cn/2019121917101835.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

## 七 DAO及相关实现类

> - DAO：Data Access Object访问数据信息的类和接口，包括了对数据的CRUD（Create、Retrival、Update、Delete），而不包含任何业务相关的信息。
> - 作用：为了实现功能的模块化，更有利于代码的维护和升级。
>
> 基础Dao类

```java
public abstract class Dao {

    //增删改
    public int commonUpdate(Connection connect,String sql,Object...args){
        PreparedStatement ps=null;
        try{
            ps = connect.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            return ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(null,ps);
        }
        return 0;
    }

    //返回一条记录
    public <T>T getInstance(Connection connect,Class<T> clazz,String sql,Object...args){
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps = connect.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            ResultSet resultSet = ps.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            if (resultSet.next()){
                T t=clazz.newInstance();
                for(int i=0;i<columnCount;i++){
                    Object value = resultSet.getObject(i + 1);
                    String columnName = metaData.getColumnLabel(i + 1);
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t,value);
                }
                return t;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(null,ps,rs);
        }
        return null;
    }


    //返回多条记录封装的集合
    public <T> List<T> getList(Connection connect,Class<T> clazz, String sql, Object...args){
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<T> result=new ArrayList<>();
        try{
            connect = JDBCUtils.getConnection();
            ps = connect.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            ResultSet resultSet = ps.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()){
                T t=clazz.newInstance();
                for(int i=0;i<columnCount;i++){
                    Object value = resultSet.getObject(i + 1);
                    String columnName = metaData.getColumnLabel(i + 1);
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t,value);
                }
                result.add(t);
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(null,ps,rs);
        }
        return null;
    }

    //查询特定结果
    public <T>T getValue(Connection connect,String sql,Object...args){
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps = connect.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
                return (T) resultSet.getObject(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(null,ps,rs);
        }
        return null;
    }
}
```

Customer类的Dao接口

```java
public abstract class Dao {

    //增删改
    public int commonUpdate(Connection connect,String sql,Object...args){
        PreparedStatement ps=null;
        try{
            ps = connect.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            return ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(null,ps);
        }
        return 0;
    }

    //返回一条记录
    public <T>T getInstance(Connection connect,Class<T> clazz,String sql,Object...args){
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps = connect.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            ResultSet resultSet = ps.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            if (resultSet.next()){
                T t=clazz.newInstance();
                for(int i=0;i<columnCount;i++){
                    Object value = resultSet.getObject(i + 1);
                    String columnName = metaData.getColumnLabel(i + 1);
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t,value);
                }
                return t;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(null,ps,rs);
        }
        return null;
    }


    //返回多条记录封装的集合
    public <T> List<T> getList(Connection connect,Class<T> clazz, String sql, Object...args){
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<T> result=new ArrayList<>();
        try{
            connect = JDBCUtils.getConnection();
            ps = connect.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            ResultSet resultSet = ps.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()){
                T t=clazz.newInstance();
                for(int i=0;i<columnCount;i++){
                    Object value = resultSet.getObject(i + 1);
                    String columnName = metaData.getColumnLabel(i + 1);
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t,value);
                }
                result.add(t);
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(null,ps,rs);
        }
        return null;
    }

    //查询特定结果
    public <T>T getValue(Connection connect,String sql,Object...args){
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps = connect.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
                return (T) resultSet.getObject(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(null,ps,rs);
        }
        return null;
    }
}
```

Customer类的Dao实现

```java
public class CustomerDaoImpl extends Dao implements CustomerDao {
    @Override
    public void insert(Connection connection, Customer customer) {
        String sql="insert into customers(id,name,email) values (?,?,?)";
        commonUpdate(connection,sql,customer.getId(),customer.getName(),customer.getEmail());
    }

    @Override
    public void deleteById(Connection connection, int id) {
        String sql="delete from customers where id= ?";
        commonUpdate(connection,sql,id);
    }

    @Override
    public void update(Connection connection, Customer customer) {
        String sql="update customers set name = ?,email= ? where id= ?";
        commonUpdate(connection,sql,customer.getName(),customer.getEmail(),customer.getId());
    }

    @Override
    public Customer getCustomerById(Connection connection, int id) {
        String sql="select id,name,email from customers where id=?";
        Customer customer = getInstance(connection, Customer.class, sql, id);
        return customer;
    }

    @Override
    public List<Customer> getAll(Connection connection) {
        String sql="select id,name,email from customers";
        List<Customer> list = getList(connection, Customer.class, sql);
        return list;
    }

    @Override
    public Long getCount(Connection connection) {
        String sql="select count(*) from customers";
        return getValue(connection, sql);
    }
}

```

优化后的Dao类
去掉了方法中的泛型参数，在实现时也免去了对泛型参数的传递

```java
public abstract class Dao<T> {

    private Class<T> clazz=null;

    {
        // getGenericSuperclass()用来获取当前类的父类的类型
        // ParameterizedType表示的是带泛型的类型
        ParameterizedType paramType= (ParameterizedType)this.getClass().getGenericSuperclass();
        // getActualTypeArguments获取具体的泛型的类型
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
        clazz = (Class<T>) actualTypeArguments[0];//泛型第一个参数

    }

    //增删改
    public int commonUpdate(Connection connect,String sql,Object...args){
        PreparedStatement ps=null;
        try{
            ps = connect.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            return ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(null,ps);
        }
        return 0;
    }

    //返回一条记录
    public T getInstance(Connection connect,String sql,Object...args){
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps = connect.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            ResultSet resultSet = ps.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            if (resultSet.next()){
                T t=clazz.newInstance();
                for(int i=0;i<columnCount;i++){
                    Object value = resultSet.getObject(i + 1);
                    String columnName = metaData.getColumnLabel(i + 1);
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t,value);
                }
                return t;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(null,ps,rs);
        }
        return null;
    }


    //返回多条记录封装的集合
    public List<T> getList(Connection connect,String sql, Object...args){
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<T> result=new ArrayList<>();
        try{
            connect = JDBCUtils.getConnection();
            ps = connect.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            ResultSet resultSet = ps.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()){
                T t=clazz.newInstance();
                for(int i=0;i<columnCount;i++){
                    Object value = resultSet.getObject(i + 1);
                    String columnName = metaData.getColumnLabel(i + 1);
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t,value);
                }
                result.add(t);
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(null,ps,rs);
        }
        return null;
    }

    //查询特定结果
    public Object getValue(Connection connect,String sql,Object...args){
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps = connect.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
                return resultSet.getObject(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(null,ps,rs);
        }
        return null;
    }
}
```

优化后的Customer实现类

```java
public class CustomerDaoImpl extends Dao<Customer> implements CustomerDao {
    @Override
    public void insert(Connection connection, Customer customer) {
        String sql="insert into customers(id,name,email) values (?,?,?)";
        commonUpdate(connection,sql,customer.getId(),customer.getName(),customer.getEmail());
    }

    @Override
    public void deleteById(Connection connection, int id) {
        String sql="delete from customers where id= ?";
        commonUpdate(connection,sql,id);
    }

    @Override
    public void update(Connection connection, Customer customer) {
        String sql="update customers set name = ?,email= ? where id= ?";
        commonUpdate(connection,sql,customer.getName(),customer.getEmail(),customer.getId());
    }

    @Override
    public Customer getCustomerById(Connection connection, int id) {
        String sql="select id,name,email from customers where id=?";
        Customer customer = getInstance(connection,sql, id);
        return customer;
    }

    @Override
    public List<Customer> getAll(Connection connection) {
        String sql="select id,name,email from customers";
        List<Customer> list = getList(connection,sql);
        return list;
    }

    @Override
    public Long getCount(Connection connection) {
        String sql="select count(*) from customers";
        return (Long) getValue(connection, sql);
    }
}
```

## 八  数据库连接池

### 数据库连接池的必要性

> - 在使用开发基于数据库的web程序时，传统的模式基本是按以下步骤：　　
>   - 在主程序（如servlet、beans）中建立数据库连接
>   - 进行sql操作
>   - 断开数据库连接
> - 这种模式开发，存在的问题:
>   - 普通的JDBC数据库连接使用 DriverManager 来获取，每次向数据库建立连接的时候都要将 Connection 加载到内存中，数据库的连接资源并没有得到很好的重复利用。若同时有几百人甚至几千人在线，频繁的进行数据库连接操作将占用很多的系统资源，严重的甚至会造成服务器的崩溃。
>   - 对于每一次数据库连接，使用完后都得断开。否则，如果程序出现异常而未能关闭，将会导致数据库系统中的内存泄漏，最终将导致重启数据库。
>   - 不能控制被创建的连接对象数，系统资源会被毫无顾及的分配出去，如连接过多，也可能导致内存泄漏，服务器崩溃。

### 数据库连接池技术

> - 为解决传统开发中的数据库连接问题，可以采用数据库连接池技术。
> - 基本思想：就是为数据库连接建立一个“缓冲池”。预先在缓冲池中放入一定数量的连接，当需要建立数据库连接时，只需从“缓冲池”中取出一个，使用完毕之后再放回去。
> - 数据库连接池负责分配、管理和释放数据库连接，它允许应用程序重复使用一个现有的数据库连接，而不是重新建立一个。
> - 数据库连接池在初始化时将创建一定数量的数据库连接放到连接池中，这些数据库连接的数量是由最小数据库连接数来设定的。无论这些数据库连接是否被使用，连接池都将一直保证至少拥有这么多的连接数量。连接池的最大数据库连接数量**限定了这个连接池能占有的最大连接数，当应用程序向连接池请求的连接数超过最大连接数量时，这些请求将被加入到等待队列中。
>
> 好处： 
> **1. 资源重用**
> 由于数据库连接得以重用，避免了频繁创建，释放连接引起的大量性能开销。在减少系统消耗的基础上，另一方面也增加了系统运行环境的平稳性。
> **2. 更快的系统反应速度**
> 数据库连接池在初始化过程中，往往已经创建了若干数据库连接置于连接池中备用。此时连接的初始化工作均已完成。对于业务请求处理而言，直接利用现有可用连接，避免了数据库连接初始化和释放过程的时间开销，从而减少了系统的响应时间
> **3. 新的资源分配手段** 
> 对于多应用共享同一数据库的系统而言，可在应用层通过数据库连接池的配置，实现某一应用最大可用数据库连接数的限制，避免某一应用独占所有的数据库资源 
> **4. 统一的连接管理，避免数据库连接泄漏** 
> 在较为完善的数据库连接池实现中，可根据预先的占用超时设定，强制回收被占用连接，从而避免了常规数据库连接操作中可能出现的资源泄露

### 数据库连接池分类

> - JDBC 的数据库连接池使用 javax.sql.DataSource 来表示，DataSource 只是一个接口，该接口通常由服务器(Weblogic, WebSphere, Tomcat)提供实现，也有一些开源组织提供实现：
>   - **DBCP** 是Apache提供的数据库连接池。tomcat 服务器自带dbcp数据库连接池。速度相对c3p0较快，但因自身存在BUG，Hibernate3已不再提供支持。
>   - **C3P0** 是一个开源组织提供的一个数据库连接池，**速度相对较慢，稳定性还可以。**hibernate官方推荐使用
>   - **Druid** 是阿里提供的数据库连接池，据说是集DBCP 、C3P0 、Proxool 优点于一身的数据库连接池，但是速度不确定是否有BoneCP快
> - DataSource 通常被称为数据源，它包含连接池和连接池管理两个部分，习惯上也经常把 DataSource 称为连接池
> - **DataSource用来取代DriverManager来获取Connection，获取速度快，同时可以大幅度提高数据库访问速度。**
> - 注意：
>   - 数据源和数据库连接不同，数据源无需创建多个，它是产生数据库连接的工厂，因此**整个应用只需要一个数据源即可。**
>   - 当数据库访问结束后，程序还是像以前一样关闭数据库连接：conn.close(); 但conn.close()并没有关闭数据库的物理连接，它仅仅把数据库连接释放，归还给了数据库连接池。

### C3P0连接池

首先将c3p0的jar包像之前导入mysql的jar包一样导入项目

- 获取连接方式1

```java
    @Test
    public void  getConnection1() throws Exception{
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC");
        cpds.setUser("root");
        cpds.setPassword("sjh2019");
        Connection conn = cpds.getConnection();
        System.out.println(conn);
    }
```

- 获取连接方式2
  使用xml配置文件 c3p0-config.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<c3p0-config>
    <named-config name="myDataSource">
        <!-- 获取连接的4个基本信息 -->
        <property name="user">root</property>
        <property name="password">sjh2019</property>
        <property name="jdbcUrl">jdbc:mysql:///test?serverTimezone=UTC</property>
        <property name="driverClass">com.mysql.cj.jdbc.Driver</property>

        <!-- 涉及到数据库连接池的管理的相关属性的设置 -->
        <!-- 若数据库中连接数不足时, 一次向数据库服务器申请多少个连接 -->
        <property name="acquireIncrement">5</property>
        <!-- 初始化数据库连接池时连接的数量 -->
        <property name="initialPoolSize">5</property>
        <!-- 数据库连接池中的最小的数据库连接数 -->
        <property name="minPoolSize">5</property>
        <!-- 数据库连接池中的最大的数据库连接数 -->
        <property name="maxPoolSize">10</property>
        <!-- C3P0 数据库连接池可以维护的 Statement 的个数 -->
        <property name="maxStatements">20</property>
        <!-- 每个连接同时可以使用的 Statement 对象的个数 -->
        <property name="maxStatementsPerConnection">5</property>

    </named-config>
</c3p0-config>
```

```java
@Test
    public void getConnection2() throws Exception {
        DataSource cpds = new ComboPooledDataSource("myDataSource");
        Connection conn = cpds.getConnection();
        System.out.println(conn);
    }
```

- 封装到JDBC工具类

```java
public class DButils {

    static DataSource cpds = new ComboPooledDataSource("myDataSource");

    public static Connection getConnByC3p0() throws Exception {
        Connection conn = cpds.getConnection();
        return conn;
    }
}
```

### DBCP连接池

首先将DBCP的jar包导入项目

- 获取连接方式1

```java
@Test
    public void  getConnection3() throws Exception {
        BasicDataSource source = new BasicDataSource();
        source.setDriverClassName("com.mysql.cj.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC");
        source.setUsername("root");
        source.setPassword("sjh2019");
        Connection conn = source.getConnection();
        System.out.println(conn);
    }
```

- 获取连接方式2
  使用properties配置文件

```java
driverClassName=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/test?serverTimezone=UTC&rewriteBatchedStatements=true
username=root
password=sjh2019
```

```java
@Test
    public void getConnection4() throws Exception{
        Properties pros = new Properties();
        InputStream is = new FileInputStream("src/dbcp.properties");
        pros.load(is);
        DataSource dataSource = BasicDataSourceFactory.createDataSource(pros);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
```

- 封装到JDBC工具类

```java
public class DButils {
    //使用c3p0连接池
    private static DataSource cpds = new ComboPooledDataSource("myDataSource");
    public static Connection getConnByC3p0() throws Exception {
        Connection conn = cpds.getConnection();
        return conn;
    }


    //使用dbcp连接池
    private static DataSource source = null;
    static{
        try {
            Properties pros = new Properties();
            InputStream is = new FileInputStream("src/dbcp.properties");
            pros.load(is);
            source = BasicDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnByDBCP() throws Exception {
        Connection conn = source.getConnection();
        return conn;
    }
}
```

### DRUID连接池

首先将druid的jar包导入项目，使用配置文件方式

```java
url=jdbc:mysql://localhost:3306/test?serverTimezone=UTC&rewriteBatchedStatements=true
username=root
password=sjh2019
driverClassName=com.mysql.cj.jdbc.Driver

initialSize=10
maxActive=20
maxWait=1000
filters=wall
```

```java
 @Test
    public void test() throws Exception {
        Properties pro=new Properties();
        FileInputStream inputStream = new FileInputStream("src/druid.properties");
        pro.load(inputStream);

        DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);
        Connection connection = dataSource.getConnection();

        System.out.println(connection);

    }
```

封装到工具类

```java
public class DButils {
    //使用c3p0连接池
    private static DataSource cpds = new ComboPooledDataSource("myDataSource");
    public static Connection getConnByC3p0() throws Exception {
        Connection conn = cpds.getConnection();
        return conn;
    }


    //使用dbcp连接池
    private static DataSource source = null;
    static{
        try {
            Properties pros = new Properties();
            InputStream is = new FileInputStream("src/dbcp.properties");
            pros.load(is);
            //根据提供的BasicDataSourceFactory创建对应的DataSource对象
            source = BasicDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnByDBCP() throws Exception {
        Connection conn = source.getConnection();
        return conn;
    }

    //使用druid连接池
    private static DataSource source1 = null;
    static{
        try {
            Properties pros = new Properties();
            InputStream is = new FileInputStream("src/druid.properties");
            pros.load(is);
            //根据提供的DruidDataSourceFactory创建对应的DataSource对象
            source1 = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnByDruid() throws Exception {
        Connection conn = source1.getConnection();
        return conn;
    }
}
```

## 九 Apache-DBUtils实现CRUD操作

### Apache-DBUtils简介

> - commons-dbutils 是 Apache 组织提供的一个开源 JDBC工具类库，它是对JDBC的简单封装，学习成本极低，并且使用dbutils能极大简化jdbc编码的工作量，同时也不会影响程序的性能。
> - API介绍：
>   - org.apache.commons.dbutils.QueryRunner
>   - org.apache.commons.dbutils.ResultSetHandler
>   - 工具类：org.apache.commons.dbutils.DbUtils

### QueryRunner的使用

- 测试添加

```java
	@Test
    public void runnerTest1() throws Exception {
        QueryRunner runner = new QueryRunner();
        Connection connection= DButils.getConnByDruid();
        String sql="insert into user(id,name,password) values (?,?,?)";
        runner.update(connection,sql,50,"david","password");
    }
```

- 测试删除

```java
	@Test
    public void runnerTest2() throws Exception {
        QueryRunner runner = new QueryRunner();
        Connection connection= DButils.getConnByDruid();
        String sql="delete from user where id=?";
        runner.update(connection,sql,50);
    }
```

- 测试查询

>  ResultSetHandler接口及实现类
>
>  - 该接口用于处理 java.sql.ResultSet，将数据按要求转换为另一种形式。
>  - ResultSetHandler 接口提供了一个单独的方法：Object handle (java.sql.ResultSet .rs)。
>  - 接口的主要实现类：
>   - ArrayHandler：把结果集中的第一行数据转成对象数组。
>   - ArrayListHandler：把结果集中的每一行数据都转成一个数组，再存放到List中。
>   - BeanHandler：将结果集中的第一行数据封装到一个对应的JavaBean实例中。
>   - BeanListHandler：将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。
>   - ColumnListHandler：将结果集中某一列的数据存放到List中。
>   - KeyedHandler(name)：将结果集中的每一行数据都封装到一个Map里，再把这些map再存到一个map里，其key为指定的key。
>   - MapHandler：将结果集中的第一行数据封装到一个Map里，key是列名，value就是对应的值。
>   - MapListHandler：将结果集中的每一行数据都封装到一个Map里，然后再存放到List
>   - ScalarHandler：查询单个值对象

```java

	//查询一条
    @Test
    public void queryOne() throws Exception {
        QueryRunner runner = new QueryRunner();
        Connection connection = DButils.getConnByDruid();
        String sql = "select id,name,email from customers where id=?";
        BeanHandler<Customer> handler = new BeanHandler<>(Customer.class);
        Customer query = runner.query(connection, sql, handler, 1);
        System.out.println(query);
    }

	//查询多条
    @Test
    public void queryAll() throws Exception {
        QueryRunner runner = new QueryRunner();
        Connection connection = DButils.getConnByDruid();
        String sql = "select id,name,email from customers where id>?";
        BeanListHandler<Customer> handler = new BeanListHandler<>(Customer.class);
        List<Customer> query = runner.query(connection, sql, handler, 1);
        query.forEach(System.out::println);
    }

	//查询特定
    @Test
    public void query() throws Exception {
        QueryRunner runner = new QueryRunner();
        Connection connection = DButils.getConnByDruid();
        String sql = "select count(*) from customers ";
        ScalarHandler handler=new ScalarHandler();
        long count = (long) runner.query(connection, sql, handler);
        System.out.println(count);
    }
```

---

# 排序

## 总体比较

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200109144500372.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

-------

## 排序接口

```java
public interface Sort {

     void sort(int[] arr);

     void betterSort(int[] arr);
}

```

## 测试类

```java
 //测试
    public void testSort(String className) throws Exception {
        int[] arr =createArray();
        Class<Sort> aClass = (Class<Sort>) Class.forName(className);
        Sort sortObject = aClass.newInstance();
		System.out.println(className);
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        System.out.println("排序后");
        sortObject.sort(arr);
        System.out.println(Arrays.toString(arr));

        arr=createArray();
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        System.out.println("优化排序后");
        sortObject.sort(arr);
        System.out.println(Arrays.toString(arr));

        //排序10000000次比较两种排序算法的性能
        long t1 = System.currentTimeMillis();
        for(int i=0;i<10000000;i++){
            arr=new int[]{50, 31, 93, 68, 37, 70, 15, 10, 21, 39};
            sortObject.sort(arr);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("优化前的排序1000万次花费时间："+(t2-t1)+"ms");
        long t3 = System.currentTimeMillis();
        for(int i=0;i<10000000;i++){
            arr=new int[]{50, 31, 93, 68, 37, 70, 15, 10, 21, 39};
            sortObject.betterSort(arr);
        }
        long t4 = System.currentTimeMillis();
        System.out.println("优化后的排序1000万次花费时间："+(t4-t3)+"ms");
    }
```

-----

## 稳定的排序

------

### 1 插入排序——直接插入排序

#### 直接插入排序

- 原理：
  假设前n-1个数是已经排好序的，将第n个数插入前面已经排好序的数列中，重复此过程直到插入完所有数。
- 时间复杂度  O(n²)
- 适用场景 
  n较小时以及元素基本有序时，可用来做其他排序的优化

```java
    //直接插入排序
    public void sort(int[] arr){
        //从第二个数开始插入
        for(int index=1;index<arr.length;index++){
            //保存目前的数
            int temp=arr[index];
            //寻找要插入的位置,从当前数的前一个开始，直到数列开头
            int i;
            for (i=index-1;i>=0&&arr[i]>temp;i--){
                //每当目前遍历到的数比temp大，就让它往后挪一个，腾出位置
                arr[i+1]=arr[i];
            }
            arr[i+1]=temp;
        }
    }
```

---------

#### 优化的直接插入排序：折半插入

- 原理：
  直接插入并没有利用到要插入的数列已经有序的特点，可以通过二分查找找到要插入的位置i，将i+1到目前遍历到的索引index的之间的元素全部后移后插入。
- 时间复杂度 O(nlogn)

```java
	//优化的插入排序：折半插入
    public void betterSort(int[] arr){
        //从第二个数开始插入
        for(int index=1;index<arr.length;index++){
            //保存目前的数
            int temp=arr[index];
            //寻找要插入的位置
            int insertIndex = -1;
            int start=0;
            int end=index-1;
            while (start<=end){
                //中间索引
                int mid=start+(end-start)/2;
                //如果比temp小，从中间往后面部分找
                if(arr[mid]<temp)
                    start=mid+1;
                    //如果比temp大，从中间往前面部分找
                else if(arr[mid]>temp)
                    end=mid-1;
                else
                    //出现相同元素时保证排序稳定性
                    insertIndex= mid+1;
                    break;
            }
            if(insertIndex==-1)
                insertIndex=start;
            //将插入位置开始直到目前有序数列长度的数全部后移一个腾出位置
            for(int i=index;i>insertIndex;i--)
                arr[i]=arr[i-1];
            arr[insertIndex]=temp;
        }
    }
```

------

#### 测试及性能比较

结果：可以看到优化后的插入排序性能更好

> sort.InsertSort
> 排序前
> [11, 43, 90, 65, 79, 36, 47, 37, 67, 77]
> 排序后
> [11, 36, 37, 43, 47, 65, 67, 77, 79, 90]
> 排序前
> [32, 1, 5, 60, 20, 67, 94, 22, 51, 21]
> 优化排序后
> [1, 5, 20, 21, 22, 32, 51, 60, 67, 94]
> 优化前的排序1000万次花费时间：405ms
> 优化后的排序1000万次花费时间：355ms

------

### 2 交换排序——冒泡排序

#### 冒泡排序

- 原理：
  比较相邻的元素，如果第一个比第二个大，就交换他们两个。 
  对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。
  针对所有的元素重复以上的步骤，除了最后一个，直到没有任何一对数字需要比较。
- 时间复杂度  O(n²)
- 适用场景 
  元素基本有序时

```java
public void sort(int[] arr) {
        //对于n个元素的数组需要执行n-1次
        for(int i=0;i<arr.length-1;i++){
            //由于最后一个就是最大元素，所以不需要比较到最后一个
            for(int index=0;index<arr.length-1-i;index++){
                //如果比后面的元素大则交换
                if(arr[index]>arr[index+1]){
                    int temp=arr[index];
                    arr[index]=arr[index+1];
                    arr[index+1]=temp;
                }
            }
        }
    }
```

-----

#### 优化后的冒泡排序

- 原理：
  例如结束排序前元素序列为1，2，3，4，5，6，7，8，此时数列已经有序，但仍会进行不必要的比较，因此可以设置一个标志位falg，记录是否有元素交换，如果没有直接结束比较。
  例如要对1，4，7，3，8，9，10，11这种前一半无序后一半有序的数列进行排序，为了减少不必要的比较，可以再加上一个临时变量记录最后一次元素交换的位置，作为下次比较的最大边界。
- 时间复杂度  O(n²)

```java
public void betterSort(int[] arr) {
        //记录数列是否有序
        boolean flag=true;
        //记录最后一次交换的数组下标
        int lastIndex =-1;
        //记录数组无序边界,初始为末尾
        int bound=arr.length-1;
        //对于n个元素的数组需要执行n-1次
        for(int i=0;i<arr.length-1;i++){
            for(int index=0;index<bound;index++){
                //如果比后面的元素大则交换
                if(arr[index]>arr[index+1]){
                    int temp=arr[index];
                    arr[index]=arr[index+1];
                    arr[index+1]=temp;
                    lastIndex=index;
                    flag=false;//有元素交换，说明数列无序
                }
            }
            //更新边界值
            bound=lastIndex;
            //如果数列已有序，结束排序
            if(flag)
                break;;
        }
    }
```

-----

#### 测试及性能比较

结果：

> sort.BubbleSort
> 排序前
> [12, 59, 38, 95, 31, 88, 48, 12, 4, 51]
> 排序后
> [4, 12, 12, 31, 38, 48, 51, 59, 88, 95]
> 排序前
> [57, 85, 32, 43, 65, 58, 65, 67, 97, 79]
> 优化排序后
> [32, 43, 57, 58, 65, 65, 67, 79, 85, 97]
> 优化前的排序1000万次花费时间：492ms
> 优化后的排序1000万次花费时间：462ms

-----

### 3  归并排序

Arrays.sort是利用归并排序实现的

#### 归并排序

- 原理
  将数组分成两半，对每部分递归应用归并排序，在两部分都排好序后，对其进行合并。
- 时间复杂度 O(nlogn)
- 适用场景
  数据量大，并且对稳定性有要求的情况

```java
//辅助数组 长度和原数组相同
    private int[] help;

    @Override
    public void sort(int[] arr) {
        help=new int[arr.length];
        sort(arr,0,arr.length-1);
    }

    //排序
    private void sort(int[] arr, int start, int end){
        if(start==end)
            return;
        //防止溢出
        int mid=start+(end-start)/2;
        //对前一半排序
        sort(arr,start,mid);
        //对后一半排序
        sort(arr,mid+1,end);
        //合并
        merge(arr,start,mid,end);
    }
    //
    private void merge(int[] arr, int start, int mid, int end){
        //将待排序序列arr[low...high]拷贝到辅助数组的相同位置
        for(int i=start;i<=end;i++){
            help[i]=arr[i];
        }
        int p=start;//用于遍历前半部分数列的索引
        int q=mid+1;//用于遍历后半部分数列的索引
        int index=start;//遍历arr数组的索引
        while(p<=mid&&q<=end){
            //用较小的那一个更新数组
            if(help[p]<help[q])
                arr[index++]=help[p++];
            else
                arr[index++]=help[q++];
        }
        //如果还有剩余的则依次全部存入，以下两个while只会执行一个
        while(p<=mid)
            arr[index++]=help[p++];
        while(q<=end)
            arr[index++]=help[q++];
    }
```

----

#### 优化的归并排序

- 原理
  由于排序后的左右部分已有序，所以如果下标为mid的元素小于下标为mid+1的元素就不再需要合并。
  同时，当元素个数足够少的时候，我们可以使用直接插入排序。
- 时间复杂度 O(nlogn)

```java
public void betterSort(int[] arr) {
        help=new int[arr.length];
        betterSort(arr,0,arr.length-1);
    }

    //优化排序
    private void betterSort(int[] arr,int start, int end) {
    	//数列小于5时用插入排序优化
        if(end-start<5){
            InsSort(arr);
            return;
        }
        //防止溢出
        int mid=start+(end-start)/2;
        //对前一半排序
        betterSort(arr,start,mid);
        //对后一半排序
        betterSort(arr,mid+1,end);
        //减少不必要的归并，由于前后均有序，若mid<mid+1,不必合并
        if(arr[mid]>arr[mid+1])
            merge(arr,start,mid,end);
    }

    public void InsSort(int[] arr){
        //从第二个数开始插入
        for(int index=1;index<arr.length;index++){
            //保存目前的数
            int temp=arr[index];
            //寻找要插入的位置,从当前数的前一个开始，直到数列开头
            int i;
            for (i=index-1;i>=0&&arr[i]>temp;i--){
                //每当目前遍历到的数比temp大，就让它往后挪一个，腾出位置
                arr[i+1]=arr[i];
            }
            arr[i+1]=temp;
        }
    }
```

-----

#### 测试及性能比较

结果：

> sort.MergeSort
> 排序前
> [78, 69, 13, 93, 47, 91, 30, 59, 33, 59]
> 排序后
> [13, 30, 33, 47, 59, 59, 69, 78, 91, 93]
> 排序前
> [85, 75, 57, 32, 79, 17, 63, 58, 77, 55]
> 优化排序后
> [17, 32, 55, 57, 58, 63, 75, 77, 79, 85]
> 优化前的排序1000万次花费时间：1779ms
> 优化后的排序1000万次花费时间：628ms

-----

## 不稳定的排序

### 1 插入排序——希尔排序

#### 希尔排序

- 原理
  先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录"基本有序"时，再对全体记录进行依次直接插入排序。
- 时间复杂度 O(n^（1.3—2）)
- 适用场景 
  希尔排序是对直接插入排序的一种优化，可以用于大型的数组，希尔排序比插入排序和选择排序要快的多，并且数组越大，优势越大。

```java
//希尔排序
public void sort(int[] arr) {
		//初始增量为数组长度的1/2
        for(int gap=arr.length/2;gap>0;gap/=2){
            //循环直到增量gap为1时结束
            for(int index=gap;index<arr.length;index++){
                //保存目前的数
                int temp=arr[index];
                //寻找要插入的位置,从当前数的前gap个开始，直到数列开头
                int i;
                for(i=index-gap;i>=0&&temp<arr[i];i-=gap){
                    //每当目前遍历到的数比temp大，就让它往后挪gap个，腾出位置
                    arr[i+gap]=arr[i];
                }
                arr[i+gap]=temp;
            }
        }
    }
```

由于希尔排序也是对直接插入排序的优化，所以两者的代码十分相似，和下面的直接插入排序比较，可以发现只是将间隔从1设置为了gap变量，并增加了一个控制gap变量的循环结构。

```java
    //直接插入排序
    public void sort(int[] arr){
        //从第二个数开始插入
        for(int index=1;index<arr.length;index++){
            //保存目前的数
            int temp=arr[index];
            //寻找要插入的位置,从当前数的前一个开始，直到数列开头
            int i;
            for (i=index-1;i>=0&&arr[i]>temp;i--){
                //每当目前遍历到的数比temp大，就让它往后挪一个，腾出位置
                arr[i+1]=arr[i];
            }
            arr[i+1]=temp;
        }
    }
```

---

#### 优化的希尔排序

- 原理：
  使用以下的序列，使性能提高 20%-40% 。1、5、19、41、109、209、505、929、2161、3905、8929、16001、36289、64769、146305、260609（这是通过 9×4k-9×2k+1(k=1,2,3,4,5…) 和 4k-3×2k+1(k=2,3,4,5,6…) 综合得到的）

```java
 public void betterSort(int[] arr) {
        int length = arr.length;
        int gap = 1;
        while (gap < length / 19) {
            gap = 19 * gap + 1;  // 、5、19、41、109、209、505、929、2161、3905、8929、16001、36289、64769、146305、260609
        }
        while (gap>=1){
            //循环直到增量gap为1时结束
            for(int index=gap;index<arr.length;index++){
                //保存目前的数
                int temp=arr[index];
                //寻找要插入的位置,从当前数的前gap个开始，直到数列开头
                int i;
                for(i=index-gap;i>=0&&temp<arr[i];i-=gap){
                    //每当目前遍历到的数比temp大，就让它往后挪gap个，腾出位置
                    arr[i+gap]=arr[i];
                }
                arr[i+gap]=temp;
            }
            gap/=3;
        }
    }
```

-----

#### 测试及性能比较

为了测试此处增加测试数据长度，其余测试时使用最开头的长度为10的数组。

```java
@Test
    public void test() throws Exception {
        testSort("sort.ShellSort");
    }

    //测试
    public void testSort(String className) throws Exception {
        int[] arr =createArray();
        Class<Sort> aClass = (Class<Sort>) Class.forName(className);
        Sort sortObject = aClass.newInstance();
        System.out.println(className);
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        System.out.println("排序后");
        sortObject.sort(arr);
        System.out.println(Arrays.toString(arr));

        arr=createArray();
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        System.out.println("优化排序后");
        sortObject.sort(arr);
        System.out.println(Arrays.toString(arr));

        //排序10000000次比较两种排序算法的性能
        long t1 = System.currentTimeMillis();
        for(int i=0;i<10000000;i++){
            arr=new int[]{50, 31, 93, 68, 37, 70, 15, 10, 21, 39,72,4,9,2,1,5,54,70,35,65,23,65,34,67,23,54,34,25,76,52,23,26,43
                    ,4,55,2,42,65,4,24,56,74,35,745,35,36,75,73,56,45,24,75,45,7,87,24,26};
            sortObject.sort(arr);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("优化前的排序1000万次花费时间："+(t2-t1)+"ms");
        long t3 = System.currentTimeMillis();
        for(int i=0;i<10000000;i++){
            arr=new int[]{50, 31, 93, 68, 37, 70, 15, 10, 21, 39,72,4,9,2,1,5,54,70,35,65,23,65,34,67,23,54,34,25,76,52,23,26,43
            ,4,55,2,42,65,4,24,56,74,35,745,35,36,75,73,56,45,24,75,45,7,87,24,26};
            sortObject.betterSort(arr);
        }
        long t4 = System.currentTimeMillis();
        System.out.println("优化后的排序1000万次花费时间："+(t4-t3)+"ms");
    }
```

结果：

> sort.ShellSort
> 排序前
> [39, 31, 24, 58, 63, 83, 49, 68, 80, 55]
> 排序后
> [24, 31, 39, 49, 55, 58, 63, 68, 80, 83]
> 排序前
> [9, 41, 47, 70, 81, 24, 53, 43, 72, 57]
> 优化排序后
> [9, 24, 41, 43, 47, 53, 57, 70, 72, 81]
> 优化前的排序1000万次花费时间：3815ms
> 优化后的排序1000万次花费时间：2997ms

-----

### 2 选择排序——直接选择排序

#### 直接选择排序

- 原理：
  首先在未排序序列中找到最小元素，存放到排序序列的起始位置。
  再从剩余未排序元素中继续寻找最小元素，然后放到已排序序列的末尾。
  重复直到所有元素均排序完毕。
- 时间复杂度  O(n²)
- 适用场景 
  数据量不大，并且对稳定性没有要求的情况

```java
public void sort(int[] arr) {
        //存储最小元素下标
        int minIndex;
        for(int index=0;index<arr.length-1;index++){
            minIndex=index;
            //寻找最小元素,用其下标更新minIndex
            for(int i=index+1;i<arr.length;i++){
                if(arr[i]<arr[minIndex])
                    minIndex=i;
            }
            //如果最小元素不是当前元素，交换两者位置
            if(index!=minIndex){
                int temp=arr[minIndex];
                arr[minIndex]=arr[index];
                arr[index]=temp;
            }
        }
    }
```

----

#### 优化后的选择排序

- 原理：
  同时在未排序数列中找到最小元素和最大元素，分别存放在数列头部和尾部。
  重复直到所有元素均排序完毕。
- 时间复杂度  O(n²)

```java
public void betterSort(int[] arr) {
        //存储最小元素下标
        int minIndex;
        //存储最大元素下标
        int maxIndex;
        int start;
        int end=arr.length-1;
        for(start=0;start<end;start++,end--){
            minIndex=start;
            maxIndex=end;
            //寻找最小元素,用其下标更新minIndex
            //寻找最大元素,用其下标更新maxIndex
            for(int i=start;i<=end;i++){
                if(arr[i]<arr[minIndex])
                    minIndex=i;
                if(arr[i]>arr[maxIndex])
                    maxIndex=i;
            }
            //如果最小元素不是当前起始元素，交换两者位置
            if(start!=minIndex){
                int temp=arr[minIndex];
                arr[minIndex]=arr[start];
                arr[start]=temp;
            }
            //如果最大元素不是当前末尾元素，交换两者位置
            if(end!=maxIndex){
                int temp=arr[maxIndex];
                arr[maxIndex]=arr[end];
                arr[end]=temp;
            }
        }
    }
```

------

#### 测试及性能比较

```java
@Test
    public void test() throws Exception {
        testSort("sort.SelectSort");
    }
```

结果：由于同时找到了最小和最大元素，几乎节约一半时间

> sort.SelectSort
> 排序前
> [93, 93, 48, 71, 94, 15, 74, 56, 45, 5]
> 排序后
> [5, 15, 45, 48, 56, 71, 74, 93, 93, 94]
> 排序前
> [66, 26, 59, 5, 6, 78, 9, 93, 2, 2]
> 优化排序后
> [2, 2, 5, 6, 9, 26, 59, 66, 78, 93]
> 优化前的排序1000万次花费时间：934ms
> 优化后的排序1000万次花费时间：640ms

------

### 3 选择排序——堆排序

#### 堆排序

- 原理 
  堆排序是将数据看成是完全二叉树、根据完全二叉树的特性来进行排序的一种算法。
  最大堆要求节点的元素都要不小于其孩子，最小堆要求节点元素都不大于其左右孩子。
  那么处于最大堆的根节点的元素一定是这个堆中的最大值。
- 时间复杂度 O(nlogn)
- 适用场景 数据较多时
- 给堆添加结点的思路
  将最后一个结点作为当前结点
  while(当前结点＞它的父结点){
  将当前结点和它的父结点交换
  现在当前结点往上面进了一个层次
  }
- 给堆移除结点的思路
  移除根结点
  将最后一个结点作为根结点
  将根结点作为当前结点
  while(当前结点具有子结点且小于它的子结点){
  将当前结点和较大的子结点交换
  现在当前结点往下面进了一个层次
  }

用集合实现

```java
private ArrayList<Integer> list=new ArrayList<>();

    //建堆
    private void add(int num){
        list.add(num);
        //获取当前索引
        int curIndex=list.size()-1;
        while (curIndex>0){
            //获取父索引
            int parIndex=(curIndex-1)/2;//例如二叉树0，1，2 1和2的父索引都是0
            //如果当前索引的数值比父索引的数值大则交换，否则由于按序插入可直接结束
            if(list.get(parIndex)<list.get(curIndex)){
                int temp=list.get(parIndex);
                list.set(parIndex,list.get(curIndex));
                list.set(curIndex,temp);
            }else break;
            curIndex=parIndex;//如果交换，让当前索引=父索引，继续判断
        }

    }

    //移除堆中最大元素
    private int remove(){
        //获取当前list中最大元素，由于是大根堆，所以是第一个
        int rem=list.get(0);
        //重建大根堆
        list.set(0,list.get(list.size()-1));//让最后一个结点取代根结点
        list.remove(list.size()-1);//移除最后一个结点
        int curIndex=0;//让根结点成为当前结点
        while(curIndex<list.size()){
            int leftIndex=curIndex*2+1;//左孩子结点索引
            int rightIndex=curIndex*2+2;//右孩子结点索引
            if(leftIndex>=list.size()) break;//到达末尾
            //寻找最大孩子结点索引
            int maxIndex=leftIndex;
            if(rightIndex<list.size()){//如果右孩子结点存在
                if(list.get(maxIndex)<list.get(rightIndex))
                    maxIndex=rightIndex;
            }
            //如果最大孩子结点值大于当前结点，则交换
            int temp=list.get(curIndex);
            if(list.get(curIndex)<list.get(maxIndex)){
                list.set(curIndex,list.get(maxIndex));
                list.set(maxIndex,temp);
            }
            else break;
            curIndex=maxIndex;
        }
        //返回最大值
        return rem;
    }

    @Override
    public void sort(int[] arr) {
        //依次添加元素，即建堆
        for (int value : arr) add(value);
        //依次移除最大元素并赋值排序
        for(int i=arr.length-1;i>=0;i--)
            arr[i]=remove();
    }
```

-----

#### 优化的堆排序

- 原理 
  整体思路不变，用数组取代集合

```java
public void betterSort(int[] arr) {
        int[] nums=new int[arr.length];
        int i=0;
        int size=arr.length;
        for (int value : arr)
            badd(nums,i++,value);
        for(int index=arr.length-1;index>=0;index--)
            arr[index]=bremove(nums,size--);
    }

    
    private void badd(int[] nums,int i,int num){
        nums[i]=num;
        int curIndex=i;
        while (curIndex>0){
            int parIndex=(curIndex-1)/2;
            if(nums[parIndex]<nums[curIndex]){
                int temp=nums[curIndex];
                nums[curIndex]=nums[parIndex];
                nums[parIndex]=temp;
            }else break;
            curIndex=parIndex;
        }

    }
    
    private int bremove(int[] nums,int size){
        int rem=nums[0];
        nums[0]=nums[size-1];
        int curIndex=0;
        while(true){
            int leftIndex=curIndex*2+1;
            int rightIndex=curIndex*2+2;
            if(leftIndex>=size) break;
            int maxIndex=leftIndex;
            if(rightIndex<size){
                if(nums[maxIndex]<nums[rightIndex])
                    maxIndex=rightIndex;
            }
            int temp=nums[curIndex];
            if(nums[curIndex]<nums[maxIndex]){
                nums[curIndex]=nums[maxIndex];
                nums[maxIndex]=temp;
            }
            else{
                break;}
            curIndex=maxIndex;
        }
        //返回最大值
        return rem;
    }
```

-----

#### 测试及性能比较

```java
 @Test
    public void test() throws Exception {
        testSort("sort.HeapSort");
    }

    //测试
    public void testSort(String className) throws Exception {
        int[] arr=new int[]{3,5,1,19,11,22,88};
        Class<Sort> aClass = (Class<Sort>) Class.forName(className);
        Sort sortObject = aClass.newInstance();
        System.out.println(className);
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        System.out.println("排序后");
        sortObject.sort(arr);
        System.out.println(Arrays.toString(arr));

        arr=new int[]{3,5,1,19,11,22,88};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        System.out.println("优化排序后");
        sortObject.betterSort(arr);
        System.out.println(Arrays.toString(arr));

        //排序10000000次比较两种排序算法的性能
        long t1 = System.currentTimeMillis();
        for(int i=0;i<10000000;i++){
            arr=new int[]{3,5,1,19,11,22,88};
            sortObject.sort(arr);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("优化前的排序1000万次花费时间："+(t2-t1)+"ms");
        long t3 = System.currentTimeMillis();
        for(int i=0;i<10000000;i++){
            arr=new int[]{3,5,1,19,11,22,88};
            sortObject.betterSort(arr);
        }
        long t4 = System.currentTimeMillis();
        System.out.println("优化后的排序1000万次花费时间："+(t4-t3)+"ms");
    }
```

结果：

> sort.HeapSort
> 排序前
> [3, 5, 1, 19, 11, 22, 88]
> 排序后
> [1, 3, 5, 11, 19, 22, 88]
> 排序前
> [3, 5, 1, 19, 11, 22, 88]
> 优化排序后
> [1, 3, 5, 11, 19, 22, 88]
> 优化前的排序1000万次花费时间：1449ms
> 优化后的排序1000万次花费时间：486ms

------

### 4 交换排序——快速排序

#### 快速排序

- 原理：
  对冒泡排序的优化。
  该算法在数组中选择一个基准（pivot）元素，将数组分为两部分，使得第一部分的元素都小于等于基准元素，第二部分的所有元素都大于基准元素，对第一部分和第二部分分别递归应用快速排序算法。
- 时间复杂度 O(nlogn)
- 适用场景 
  数据量大的情况

```java
public void sort(int[] arr) {
        quickSort(arr,0, arr.length-1);
    }

    public void quickSort(int[] arr,int start,int end){
        //递归条件
        if(start<end){
            //排序并获得基准元素的下标
            int pivotIndex=getPivotIndex(arr,start,end);
            //分别对基准元素的前后部分排序
            quickSort(arr,start,pivotIndex-1);
            quickSort(arr,pivotIndex+1,end);
        }
    }

    private int getPivotIndex(int[] arr, int start, int end) {
        //默认选择第一个作为基准
        int pivot=arr[start];
        int i=start;
        int j=end;
        while(i<j){//循环条件
            //从左起找到第一个大于pivot的元素
            while (i<=j&&arr[i]<=pivot)
                i++;
            //从右起找到第一个小于等于pivot的元素
            while (i<=j&&arr[j]>pivot)
                j--;
            //如果左边元素大于右边则交换
            if(i<j){
                swap(arr,i,j);
            }
        }
        swap(arr,start,j);
        return j;
    }

    public static void swap(int[] arr, int x, int y){
        int temp;
        temp  = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
```

----

#### 优化的快速排序

- 原理
  当规模足够小时，我们可以采用直接插入排序

```java
 public void betterSort(int[] arr) {
        bquickSort(arr,0, arr.length-1);
    }

    public void bquickSort(int[] arr,int start,int end){
        //递归条件
        if(end-start<5){
            InsSort(arr);
        }
        //排序并获得基准元素的下标
        int pivotIndex=getPivotIndex(arr,start,end);
        //分别对基准元素的前后部分排序
        quickSort(arr,start,pivotIndex-1);
        quickSort(arr,pivotIndex+1,end);

    }

    public void InsSort(int[] arr){
        //从第二个数开始插入
        for(int index=1;index<arr.length;index++){
            //保存目前的数
            int temp=arr[index];
            //寻找要插入的位置,从当前数的前一个开始，直到数列开头
            int i;
            for (i=index-1;i>=0&&arr[i]>temp;i--){
                //每当目前遍历到的数比temp大，就让它往后挪一个，腾出位置
                arr[i+1]=arr[i];
            }
            arr[i+1]=temp;
        }
    }
```

-----

#### 测试及性能比较

> sort.QuickSort
> 排序前
> [0, 89, 27, 27, 66, 83, 21, 53, 74, 52]
> 排序后
> [0, 21, 27, 27, 52, 53, 66, 74, 83, 89]
> 排序前
> [81, 0, 83, 5, 86, 39, 7, 61, 43, 88]
> 优化排序后
> [0, 5, 7, 39, 43, 61, 81, 83, 86, 88]
> 优化前的排序1000万次花费时间：621ms
> 优化后的排序1000万次花费时间：495ms

---

# Leetcode 题解

## 二叉树

#### [94. 二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)

给定一个二叉树，返回它的*中序* 遍历。

**示例:**

```
输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
```

**进阶:** 递归算法很简单，你可以通过迭代算法完成吗？

递归解答：

```java
class Solution {

    //保存结果
    List<Integer> result=new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root!=null){
            inorderTraversal(root.left);
            result.add(root.val);
            inorderTraversal(root.right);
        }
        return result;
    }
}
```

迭代解答：

```java
class Solution {

    //保存结果
    List<Integer> result=new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root!=null){
            Stack<TreeNode> stack=new Stack<>();
            while(!stack.empty()||root!=null){
                if(root!=null){
                    stack.push(root);
                    root=root.left;
                }else{
                    TreeNode pop=stack.pop();
                    result.add(pop.val);
                    root=pop.right;
                }
            }
        }
        return result;
    }
}
```

---

#### [95. 不同的二叉搜索树 II](https://leetcode-cn.com/problems/unique-binary-search-trees-ii/)

给定一个整数 *n*，生成所有由 1 ... *n* 为节点所组成的**二叉搜索树**。

**示例:**

```
输入: 3
输出:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
解释:
以上的输出对应以下 5 种不同结构的二叉搜索树：

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
```

解答：

```java
class Solution {

    public List<TreeNode> generateTrees(int n) {
        if(n==0)
            return new ArrayList<TreeNode>();
        return createTree(1,n);
    }

    //生成范围start~end的二叉搜索树
    public List<TreeNode> createTree(int start,int end){
        //保存结果集
        List<TreeNode> result=new ArrayList<>();
        //不存在要添加一个null节点，不能省略，否则其中一个集合空，foreach遍历时无法组合
        if(start>end){
            result.add(null);
            return result;
        }
        //以i为根节点生成二叉搜索树
        for(int i=start;i<=end;i++){
            //i的不同左子树集合
            List<TreeNode> treeListL=createTree(start,i-1);
            //i的不同右子树集合
            List<TreeNode> treeListR=createTree(i+1,end);
            //全组合
            for(TreeNode treeL:treeListL){
                for(TreeNode treeR:treeListR){
                    TreeNode node=new TreeNode(i);
                    node.left=treeL;
                    node.right=treeR;
                    result.add(node);
                }
            }
        }
        return result;
    }

}
```

---

#### [96. 不同的二叉搜索树](https://leetcode-cn.com/problems/unique-binary-search-trees/)

给定一个整数 *n*，求以 1 ... *n* 为节点组成的二叉搜索树有多少种？

**示例:**

```
输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
```

解答：

```java
    public int numTrees(int n) {
        //假设dp(N)为以1，2...N为节点组成的二叉搜索树数量
        //f(x)为以x为根节点的二叉搜索树数量
        //那么dp(N)=f(1)+f(2)+...+f(N)
        //f(x)=dp(x-1)*dp(N-x),因为x左边有x-1个节点，右边有N-x个节点
        //因此dp(N)=dp(0)*dp(N-1)+dp(1)*dp(N-2)+....+dp(N-1)*dp(0)
        int[] dp=new int[n+1];
        //初始化
        dp[0]=1;
        dp[1]=1;
        //动态规划更新
        for(int N=2;N<=n;N++){
            for(int x=1;x<=N;x++){
                dp[N]+=dp[x-1]*dp[N-x];
            }
        }
        return dp[n];
    }
```

---

#### [98. 验证二叉搜索树](https://leetcode-cn.com/problems/validate-binary-search-tree/)

给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

- 节点的左子树只包含**小于**当前节点的数。
- 节点的右子树只包含**大于**当前节点的数。
- 所有左子树和右子树自身必须也是二叉搜索树。

**示例 1:**

```
输入:
    2
   / \
  1   3
输出: true
```

解答：

```java
class Solution {

    //前驱节点
    TreeNode pre=null;
    //是否为二叉搜索树，默认true
    boolean flag=true;

    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        inorder(root);
        return flag;
    }

    public void inorder(TreeNode root){
        if(root!=null){
            inorder(root.left);
            if(pre!=null){
                //二叉搜索树中序排列是升序，如果小于等于说明不符合
                if(root.val<=pre.val){
                    flag=false;
                    return;
                }
            }
            //更新前驱节点
            pre=root;
            inorder(root.right);
        }
    }

}
```

---

#### [100. 相同的树](https://leetcode-cn.com/problems/same-tree/)

给定两个二叉树，编写一个函数来检验它们是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

**示例 1:**

```
输入:       1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

输出: true
```

**示例 2:**

```
输入:      1          1
          /           \
         2             2

        [1,2],     [1,null,2]

输出: false
```

解答：

```java
	public boolean isSameTree(TreeNode p, TreeNode q) {
        //两个树都为空则代表相同
        if(p==null&&q==null)
            return true;
        //一个为空，一个不为空代表不同
        if((p==null&&q!=null)||(p!=null&&q==null))
            return false;
        //如果值不相同则代表不同，值相同再分别比较左子树和右子树
        if(p.val!=q.val)
            return false;
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
```

------

#### [101. 对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/)

给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 `[1,2,2,3,4,4,3]` 是对称的。

```
    1
   / \
  2   2
 / \ / \
3  4 4  3
```

但是下面这个 `[1,2,2,null,3,null,3]` 则不是镜像对称的:

```
    1
   / \
  2   2
   \   \
   3    3
```

**进阶：**

你可以运用递归和迭代两种方法解决这个问题吗？

递归解答：

```java
    public boolean isSymmetric(TreeNode root) {
        //空树肯定对称
        if(root==null)
            return true;
        //判断左右子树是否对称
        return isMirror(root.left,root.right);
    }

    public boolean isMirror(TreeNode p,TreeNode q) {
        //两个树都为空则代表相同
        if(p==null&&q==null)
            return true;
        //一个为空，一个不为空代表不同
        if((p==null&&q!=null)||(p!=null&&q==null))
            return false;
        //如果值不相同则代表不同，值相同再对称比较p左q右/p右q左
        if(p.val!=q.val)
            return false;
        return isMirror(p.left,q.right)&&isMirror(p.right,q.left);
    }
```

迭代解答：

```java
    public boolean isSymmetric(TreeNode root) {
        //空树对称
        if(root==null)
            return true;
        //根节点没有左右子树，是对称的
        if(root.left==null&&root.right==null)
            return true;
        //根节点左右子树只有一边，不对称
        if((root.left!=null&&root.right==null)||(root.left==null&&root.right!=null))
            return false;
        //两个栈，s1保存左子树，s2保存右子树
        Stack<TreeNode> s1=new Stack<>();
        Stack<TreeNode> s2=new Stack<>();
        //左右子树的根节点入栈
        s1.push(root.left);
        s2.push(root.right);
        while(!s1.isEmpty()&&!s2.isEmpty()){
            TreeNode pop1=s1.pop();
            TreeNode pop2=s2.pop();
            //节点值不同不对称
            if(pop1.val!=pop2.val)
                return false;
            //一边节点有子树，对应的另一边没有则不对称，否则将对应子树入栈
            if((pop1.left!=null&&pop2.right==null)||(pop1.left==null&&pop2.right!=null))
                return false;
            if(pop1.left!=null&&pop2.right!=null){
                s1.push(pop1.left);
                s2.push(pop2.right);
            }
            if((pop1.right!=null&&pop2.left==null)||(pop1.right==null&&pop2.left!=null))
                return false;
            if(pop1.right!=null&&pop2.left!=null){
                s1.push(pop1.right);
                s2.push(pop2.left);
            }
        }
        //两个栈同时为空说明全部匹配成功
        return s1.isEmpty()&&s2.isEmpty();
    }
```

------

#### [102. 二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)

给你一个二叉树，请你返回其按 **层序遍历** 得到的节点值。 （即逐层地，从左到右访问所有节点）。

**示例：**
二叉树：`[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

返回其层次遍历结果：

```
[
  [3],
  [9,20],
  [15,7]
]
```

解答：

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //保存结果集
        List<List<Integer>> result=new ArrayList<>();
        //保存节点
        List<TreeNode> trees=new ArrayList<>();
        //保存临时结果
        List<Integer> temp;
        if(root!=null){
            trees.add(root);
            while(!trees.isEmpty()){
                //计算当前层节点数，按数量全部出队，再将其左右节点依次入队
                int n=trees.size();
                temp=new ArrayList<>();
                for(int i=0;i<n;i++){
                    TreeNode remove=trees.remove(0);
                    temp.add(remove.val);
                    //出队节点的左右节点不为空就入队
                    if(remove.left!=null)
                        trees.add(remove.left);
                    if(remove.right!=null)
                        trees.add(remove.right);
                }
                //添加到结果集
                result.add(temp);
            }
        }
        return result;
    }
}
```

---

#### [103. 二叉树的锯齿形层次遍历](https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/)

给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

返回锯齿形层次遍历如下：

```
[
  [3],
  [20,9],
  [15,7]
]
```

解答：

```java
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //相比102题只需要添加一个boolean变量
        List<List<Integer>> result=new ArrayList<>();
        List<TreeNode> trees=new ArrayList<>();
        List<Integer> temp;
        //控制顺序，是否从左到右
        boolean leftToRight=true;
        if(root!=null){
            trees.add(root);
            while(!trees.isEmpty()){
                int n=trees.size();
                temp=new ArrayList<>();
                for(int i=0;i<n;i++){
                    TreeNode remove=trees.remove(0);
                    temp.add(remove.val);
                    if(remove.left!=null)
                        trees.add(remove.left);
                    if(remove.right!=null)
                        trees.add(remove.right);
                }
                //如果是从右往左要逆序
                if(!leftToRight)
                    Collections.reverse(temp);
                result.add(temp);
                leftToRight=!leftToRight;
            }
        }
        return result;
    }
```

---

#### [104. 二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)

给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

**说明:** 叶子节点是指没有子节点的节点。

**示例：**
给定二叉树 `[3,9,20,null,null,15,7]`，

```
    3
   / \
  9  20
    /  \
   15   7
```

返回它的最大深度 3 。

解答：

```java
    public int maxDepth(TreeNode root) {
        //空树高度为0
        if(root==null)
            return 0;
        //左子树高度
        int hL=maxDepth(root.left);
        //右子树高度
        int hR=maxDepth(root.right);
        //返回左右子树的最大高度加上自己的高度1
        return Math.max(hL,hR)+1;
    }
```

------

#### [105. 从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

难度中等426

根据一棵树的前序遍历与中序遍历构造二叉树。

**注意:**
你可以假设树中没有重复的元素。

例如，给出

```
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
```

返回如下的二叉树：

```
    3
   / \
  9  20
    /  \
   15   7
```

解答：

```java
class Solution {

    //存储中序信息，key是节点数值，value是索引
    HashMap<Integer,Integer> map=new HashMap<>();
    //存储前序数组的引用
    int[] pre;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length==0)
            return null;
        pre=preorder;
        //将中序信息存入map集合
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(0,0,inorder.length-1);
    }

    //从前序遍历中获得当前节点，从中序遍历获得其左右节点
    public TreeNode build(int preIndex,int inStart,int inEnd){
        //临界条件
        if(inStart>inEnd)
            return null;
        //获取先序遍历的节点以及其在中序遍历中的位置
        int val=pre[preIndex];
        int inIndex=map.get(val);
        //构建根节点
        TreeNode cur=new TreeNode(val);
        //左子树数量
        int left=inIndex-inStart;
        //递归构建左右子树
        cur.left=build(preIndex+1,inStart,inIndex-1);//前序遍历中当前节点下一个就是左子树节点
        cur.right=build(preIndex+1+left,inIndex+1,inEnd);//前序中右子树的根节点索引要跳过中序左子树节点的数量
        return cur;
    }

}
```

---

#### [106. 从中序与后序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

根据一棵树的中序遍历与后序遍历构造二叉树。

**注意:**
你可以假设树中没有重复的元素。

例如，给出

```
中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
```

返回如下的二叉树：

```
    3
   / \
  9  20
    /  \
   15   7
```

解答：

```java
class Solution {

    //存储中序信息，key是节点数值，value是索引
    HashMap<Integer,Integer> map=new HashMap<>();
    //存储后序数组的引用
    int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder==null||postorder.length==0)
            return null;
        post=postorder;
        //将中序信息存入map集合
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(post.length-1,0,inorder.length-1);
    }

    //从后序遍历中获得当前节点，从中序遍历获得其左右节点
    public TreeNode build(int postIndex,int inStart,int inEnd){
        //临界条件
        if(inStart>inEnd)
            return null;
        //获取后序遍历的节点以及其在中序遍历中的位置
        int val=post[postIndex];
        int inIndex=map.get(val);
        //构建根节点
        TreeNode cur=new TreeNode(val);
        //右子树数量
        int right=inEnd-inIndex;
        //递归构建左右子树
        cur.left=build(postIndex-1-right,inStart,inIndex-1);//后序遍历中当前节点前一个就是右子树节点
        cur.right=build(postIndex-1,inIndex+1,inEnd);//后序中左子树的根节点索引要跳过中序右子树节点的数量
        return cur;
    }
}
```

---

#### [107. 二叉树的层次遍历 II](https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/)

给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

返回其自底向上的层次遍历为：

```
[
  [15,7],
  [9,20],
  [3]
]
```

解答：

```java
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //保存结果集
        LinkedList<List<Integer>> result=new LinkedList<>();
        //保存节点
        List<TreeNode> trees=new LinkedList<>();
        //保存临时结果
        List<Integer> temp;
        if(root!=null){
            trees.add(root);
            while(!trees.isEmpty()){
                //计算当前层节点数，按数量全部出队，再将其左右节点依次入队
                int n=trees.size();
                temp=new LinkedList<>();
                for(int i=0;i<n;i++){
                    TreeNode remove=trees.remove(0);
                    temp.add(remove.val);
                    //出队节点的左右节点不为空就入队
                    if(remove.left!=null)
                        trees.add(remove.left);
                    if(remove.right!=null)
                        trees.add(remove.right);
                }
                //自底向上遍历，将自顶向下的结果反向入队即可
                result.addFirst(temp);
            }
        }
        return result;
    }
```

------

#### [108. 将有序数组转换为二叉搜索树](https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/)

将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树*每个节点* 的左右两个子树的高度差的绝对值不超过 1。

**示例:**

```
给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
```

解答：

```java
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)
            return null;
        return insert(nums,0,nums.length-1);
    }

    public TreeNode insert(int[] nums,int left,int right){
        //递归停止条件
        if(left>right)
            return null;
        //将中间节点作为根节点
        int mid=(left+right)/2;
        TreeNode root=new TreeNode(nums[mid]);
        //中间节点左边作为左子树，因为是升序数组，左边肯定值更小
        root.left=insert(nums,left,mid-1);
        //中间节点右边作为右子树
        root.right=insert(nums,mid+1,right);
        return root;
    }
```

------

#### [110. 平衡二叉树](https://leetcode-cn.com/problems/balanced-binary-tree/)

给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

> 一个二叉树*每个节点* 的左右两个子树的高度差的绝对值不超过1。

**示例 1:**

给定二叉树 `[3,9,20,null,null,15,7]`

```
    3
   / \
  9  20
    /  \
   15   7
```

返回 `true` 。

解答：

```java
    public boolean isBalanced(TreeNode root) {
        //空树是平衡二叉树
        if(root==null)
            return true;
        //左右子树的高度差超过1
        if(Math.abs(depth(root.left)-depth(root.right))>1)
            return false;
        //判断左右子树
        return isBalanced(root.left)&&isBalanced(root.right);
    }

    //求当前节点高度
    public int depth(TreeNode root) {
        if(root==null)
            return 0;
        int hL=depth(root.left);
        int hR=depth(root.right);
        return Math.max(hL,hR)+1;
    }
```

------

#### [111. 二叉树的最小深度](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/)

给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

**说明:** 叶子节点是指没有子节点的节点。

**示例:**

给定二叉树 `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

返回它的最小深度  2.

解答：

```java
	public int minDepth(TreeNode root) {
        //空节点高度0
        if(root==null)
            return 0;
        //没有左右节点高度1
        if(root.left==null&&root.right==null)
            return 1;
        int hL=minDepth(root.left);
        int hR=minDepth(root.right);
        //没有左节点，高度为右节点，反之
        if(hL==0)
            return hR+1;
        if(hR==0)
            return hL+1;
        //左右节点都不为空，返回最小值加上自己的高度1
        return Math.min(hL,hR)+1;
    }
```

------

#### [112. 路径总和](https://leetcode-cn.com/problems/path-sum/)

给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

**说明:** 叶子节点是指没有子节点的节点。

**示例:** 
给定如下二叉树，以及目标和 `sum = 22`，

```
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
```

返回 `true`, 因为存在目标和为 22 的根节点到叶子节点的路径 `5->4->11->2`。

解答：

```java
    public boolean hasPathSum(TreeNode root, int sum) {
        //当前节点为空，寻找失败
        if(root==null)
            return false;
        //当前节点为叶子节点并且值和目标相等，寻找成功
        if(root.val==sum&&root.left==null&&root.right==null)
            return true;
        //在左右子树寻找
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
```

------

#### [113. 路径总和 II](https://leetcode-cn.com/problems/path-sum-ii/)

难度中等213

给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

**说明:** 叶子节点是指没有子节点的节点。

**示例:**
给定如下二叉树，以及目标和 `sum = 22`，

```
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
```

返回:

```
[
   [5,4,11,2],
   [5,8,4,5]
]
```

解答：

```java
class Solution {

    //保存结果
    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        path(root,sum,new ArrayList<>());
        return result;
    }

    public void path(TreeNode root,int sum,List<Integer> list){
        if(root!=null){
            list.add(root.val);
            //如果是叶子节点且值和sum相等，说明找到了
            if(root.val==sum&&root.left==null&&root.right==null){
                result.add(new ArrayList<>(list));
                list.remove(list.size()-1);
            }else{
                //在左子树和右子树分别继续查找
                path(root.left,sum-root.val,list);
                path(root.right,sum-root.val,list);
                //查完后要移除末尾元素，回退之前的状态，进行新的查找
                list.remove(list.size()-1);
           }
        }
    }
}
```

---

#### [114. 二叉树展开为链表](https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/)

给定一个二叉树，[原地](https://baike.baidu.com/item/原地算法/8010757)将它展开为链表。

例如，给定二叉树

```
    1
   / \
  2   5
 / \   \
3   4   6
```

将其展开为：

```
1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
```

解答：

---

#### [116. 填充每个节点的下一个右侧节点指针](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/)

给定一个**完美二叉树**，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

```
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
```

填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 `NULL`。初始状态下，所有 next 指针都被设置为 `NULL`。

**示例：**

<img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/15/116_sample.png" alt="img" style="zoom:50%;" />

解答：

```java
    public Node connect(Node root) {
        if(root!=null){
            //如果还有下一层（只需要判断左右节点的一个，因为是完美二叉树）
            if(root.left!=null){
                //连接同一个父节点的两个节点
                root.left.next=root.right;
                //连接不同父节点的两个节点
                if(root.next!=null)
                    root.right.next=root.next.left;
            }
            connect(root.left);
            connect(root.right);
        }
        return root;
    }
```

---

#### [117. 填充每个节点的下一个右侧节点指针 II](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/)

给定一个二叉树

```
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
```

填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 `NULL`。初始状态下，所有 next 指针都被设置为 `NULL`。

**示例：**

<img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/15/117_sample.png" alt="img" style="zoom:50%;" />

```
输入：root = [1,2,3,4,5,null,7]
输出：[1,#,2,3,#,4,5,7,#]
解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
```

解答：

```java
    public Node connect(Node root) {
        //使用队列进行层序遍历，依次处理节点
        Deque<Node> trees=new ArrayDeque<>();
        if(root!=null){
            trees.add(root);
            while(!trees.isEmpty()){
                int n=trees.size();
                for(int i=0;i<n;i++){
                    Node remove=trees.removeFirst();
                    help(remove);
                    if(remove.left!=null)
                        trees.add(remove.left);
                    if(remove.right!=null)
                        trees.add(remove.right);
                }
            }
        }
        return root;
    }

    public void help(Node root){
        if(root!=null){
            if(root.left!=null&&root.right!=null)
                root.left.next=root.right;
            if(root.left!=null||root.right!=null) {
                //保存当前节点的next节点、左右节点引用，使代码简洁一点
                Node node=root.next;
                Node rL=root.left;
                Node rR=root.right;
                //只要存在next节点
                while (node != null) {
                    if (rR != null) {//当前节点优先连接右节点
                        if (node.left != null) {//next节点优先连接左节点
                            rR.next = node.left;
                            break;
                        } else if (node.right != null) {//next节点没有左节点，判断右节点
                            rR.next = node.right;
                            break;
                        }
                    }
                    //当前节点没有右节点，判断左节点
                    if (node.left != null) {//next节点优先连接左节点
                        rL.next = node.left;
                        break;
                    } else if (node.right != null) {//next节点没有左节点，判断右节点
                        rL.next = node.right;
                        break;
                    }
                    node = node.next;
                }
            }
        }
    }
```

---

#### [129. 求根到叶子节点数字之和](https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/)

给定一个二叉树，它的每个结点都存放一个 `0-9` 的数字，每条从根到叶子节点的路径都代表一个数字。

例如，从根到叶子节点路径 `1->2->3` 代表数字 `123`。

计算从根到叶子节点生成的所有数字之和。

**说明:** 叶子节点是指没有子节点的节点。

**示例 1:**

```
输入: [1,2,3]
    1
   / \
  2   3
输出: 25
解释:
从根到叶子节点路径 1->2 代表数字 12.
从根到叶子节点路径 1->3 代表数字 13.
因此，数字总和 = 12 + 13 = 25.
```

解答：

```java
class Solution {
    //保存结果
    int sum=0;

    //类似257题
    public int sumNumbers(TreeNode root) {
        search(root,0);
        return sum;
    }
    
    //辅助函数
    public void search(TreeNode root,int n){
        if(root!=null){
            int num=n*10+root.val;
            if(root.left==null&&root.right==null) {
                //到达叶子节点，拼接完值就添加到结果集
                sum+=num;
            }else {
                //还没到叶子节点
                search(root.left, num);
                search(root.right, num);
            }
        }
    }
}
```

---



---

#### [144. 二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)

给定一个二叉树，返回它的 *前序* 遍历。

 **示例:**

```
输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [1,2,3]
```

解答：

```java
class Solution {

    //保存结果
    List<Integer> result=new ArrayList<>();

    //递归很简单，直接使用迭代算法
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root!=null){
            Stack<TreeNode> stack=new Stack<>();
            while(!stack.empty()||root!=null){
                if(root!=null){
                    result.add(root.val);
                    stack.push(root);
                    root=root.left;
                }else{
                    TreeNode pop=stack.pop();
                    root=pop.right;
                }
            }
        }
        return result;
    }

}
```

---

#### [145. 二叉树的后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/)

给定一个二叉树，返回它的 *后序* 遍历。

**示例:**

```
输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [3,2,1]
```

**进阶:** 递归算法很简单，你可以通过迭代算法完成吗？

解答：

```java
    //类似二叉树先序遍历，只是利用队列将结果逆序
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result=new LinkedList<>();
        if(root!=null){
            Stack<TreeNode> stack=new Stack<>();
            while(!stack.empty()||root!=null){
                if(root!=null){
                    result.addFirst(root.val);
                    stack.push(root);
                    root=root.right;
                }else{
                    TreeNode pop=stack.pop();
                    root=pop.left;
                }
            }
        }
        return result;
    }
```

---

#### [156. 上下翻转二叉树](https://leetcode-cn.com/problems/binary-tree-upside-down/)

给定一个二叉树，其中所有的右节点要么是具有兄弟节点（拥有相同父节点的左节点）的叶节点，要么为空，将此二叉树上下翻转并将它变成一棵树， 原来的右节点将转换成左叶节点。返回新的根。

**例子:**

```
输入: [1,2,3,4,5]

    1
   / \
  2   3
 / \
4   5

输出: 返回二叉树的根 [4,5,2,#,#,3,1]

   4
  / \
 5   2
    / \
   3   1  
```

解答：

```java
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        //root是空直接返回
        if(root==null)
            return root;
        if(root!=null){
            //左节点为空说明到了叶子节点，直接返回
            if(root.left==null)
                return root;
            //否则新节点是对左节点翻转的结果
            TreeNode newRoot=upsideDownBinaryTree(root.left);
            //找到新节点的最右子结点
            TreeNode n=newRoot;
            while(n.right!=null)
                n=n.right;
            //原节点的右节点作为新节点的左节点
            n.left=root.right;
            //原节点作为新节点的右节点
            n.right=new TreeNode(root.val);
            return newRoot;
        }
        return root;
    }
```

---

#### [173. 二叉搜索树迭代器](https://leetcode-cn.com/problems/binary-search-tree-iterator/)

实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。

调用 `next()` 将返回二叉搜索树中的下一个最小的数。

**示例：**

**![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/25/bst-tree.png)**

```
BSTIterator iterator = new BSTIterator(root);
iterator.next();    // 返回 3
iterator.next();    // 返回 7
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 9
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 15
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 20
iterator.hasNext(); // 返回 false
```

解答：

```java
class BSTIterator {

    List<Integer> list=new ArrayList<>();
    int[] arr=null;
    int index=0;

    public BSTIterator(TreeNode root) {
        inorder(root);
        arr=new int[list.size()];
        for(int i=0;i<arr.length;i++)
            arr[i]=list.get(i);
    }
    
    public int next() {
        return arr[index++];
    }
    
    public boolean hasNext() {
        return index<arr.length;
    }

    //中序遍历保存升序序列
    public void inorder(TreeNode root){
        if(root!=null){
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
    }
}
```

---

#### [199. 二叉树的右视图](https://leetcode-cn.com/problems/binary-tree-right-side-view/)

给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

**示例:**

```
输入: [1,2,3,null,5,null,4]
输出: [1, 3, 4]
解释:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
```

解答：

```java
class Solution {

    List<Integer> result=new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        //初始结果集大小0，所以深度也该设为0
        dfs(root,0);
        return result;
    }

    //使用根-右-左的顺序进行深度优先遍历
    public void dfs(TreeNode root,int depth){
        if(root!=null){
            //根据深度和当前结果集大小判断是否是第一次访问，即该层最右节点
            if(depth==result.size())
                result.add(root.val);
            dfs(root.right,depth+1);
            dfs(root.left,depth+1);
        }
    }
}
```

---

#### [222. 完全二叉树的节点个数](https://leetcode-cn.com/problems/count-complete-tree-nodes/)

给出一个**完全二叉树**，求出该树的节点个数。

解答：

```java
    public int countNodes(TreeNode root) {
        //空树节点0
        if(root==null)
            return 0;
        //没有左子树肯定也没有右子树
        if(root.left==null)
            return 1;
        //左右子树节点+1
        return 1+countNodes(root.left)+countNodes(root.right);
    }
```

---

#### [226. 翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/)

翻转一棵二叉树。

**示例：**

输入：

```
     4
   /   \
  2     7
 / \   / \
1   3 6   9
```

输出：

```
     4
   /   \
  7     2
 / \   / \
9   6 3   1
```

解答：

```java
    public TreeNode invertTree(TreeNode root) {
        if(root!=null){
            //翻转左子树赋值给当前节点的右节点，反之
            TreeNode newLeft=invertTree(root.right);
            TreeNode newRight=invertTree(root.left);
            root.left=newLeft;
            root.right=newRight;
        }
        return root;
    }
```

------

#### [230. 二叉搜索树中第K小的元素](https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/)

给定一个二叉搜索树，编写一个函数 `kthSmallest` 来查找其中第 **k** 个最小的元素。

**说明：**
你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

**示例 1:**

```
输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 1
```

解答：

```java
class Solution {

    //定义一个计数器
    int count=0;
    //保存结果
    int num=0;

    public int kthSmallest(TreeNode root, int k) {
        count=k;
        help(root);
        return num;
    }

    //按中序遍历搜索，第k个值就是第k小
    public void help(TreeNode root){
        if(root!=null){
            help(root.left);
            count--;
            if(count==0){
                num=root.val;
                return;
            }
            help(root.right);
        }
    }
}
```

---

#### [235. 二叉搜索树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)

给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

[百度百科](https://baike.baidu.com/item/%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88/8918834?fr=aladdin)中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（**一个节点也可以是它自己的祖先**）。”

例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/binarysearchtree_improved.png)

 

**示例 1:**

```
输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
输出: 6 
解释: 节点 2 和节点 8 的最近公共祖先是 6。
```

解答：

```java
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //p、q的值都小于root，在左子树寻找
        if(root.val>p.val&&root.val>q.val)
            return lowestCommonAncestor(root.left,p,q);
        //p、q的值都大于root，在右子树寻找
        if(root.val<p.val&&root.val<q.val)
            return lowestCommonAncestor(root.right,p,q);
        //不是左右子树，只能是根节点
        return root;
    }
```

------

#### [236. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)

给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

[百度百科](https://baike.baidu.com/item/最近公共祖先/8918834?fr=aladdin)中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（**一个节点也可以是它自己的祖先**）。”

例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/15/binarytree.png)

 

**示例 1:**

```
输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
```

解答：

```java
class Solution {
    //保存结果
    TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        canFind(root,p,q);
        return res;
    }

    //以当前节点为根搜索，能否找到p，q中的一个
    public boolean canFind(TreeNode root,TreeNode p,TreeNode q){
        if(root==null)
            return false;
        int sum=0;
        //判断当前节点
        sum+=(root==p||root==q)?1:0;
        //判断左子树能否找到
        sum+=canFind(root.left,p,q)?1:0;
        //判断右子树能否找到
        sum+=canFind(root.right,p,q)?1:0;
        //如果sum==2，说明p和q都找到了
        if(sum==2)
            res=root;
        //sum不为0，说明能找到其中一个
        return sum>0;
    }

}
```

---

#### [250. 统计同值子树](https://leetcode-cn.com/problems/count-univalue-subtrees/)

给定一个二叉树，统计该二叉树数值相同的子树个数。

同值子树是指该子树的所有节点都拥有相同的数值。

**示例：**

```
输入: root = [5,1,5,5,5,null,5]

              5
             / \
            1   5
           / \   \
          5   5   5

输出: 4
```

解答：

```java
class Solution {

    //保存同值子树总和
    int sum=0;

    public int countUnivalSubtrees(TreeNode root) {
        isSub(root);
        return sum;
    }

    public boolean isSub(TreeNode root){
        if(root==null)
            return true;
        boolean b1=isSub(root.left);//左子树是否为同值子树
        boolean b2=isSub(root.right);//右子树是否为同值子树
        //根节点和左右任意一个节点值不同就不是
        if(root.left!=null&&root.left.val!=root.val)
            return false;
        if(root.right!=null&&root.right.val!=root.val)
            return false;
        //如果都满足，加1
        if(b1&&b2)
            sum++;
        return b1&&b2;
    }

}
```

---

#### [257. 二叉树的所有路径](https://leetcode-cn.com/problems/binary-tree-paths/)

给定一个二叉树，返回所有从根节点到叶子节点的路径。

**说明:** 叶子节点是指没有子节点的节点。

**示例:**

```
输入:

   1
 /   \
2     3
 \
  5

输出: ["1->2->5", "1->3"]

解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
```

解答：

```java
class Solution {

    //保存结果集
    List<String> res=new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        search(root,new StringBuilder());
        return res;
    }

    //辅助函数，利用StringBuilder拼接
    public void search(TreeNode root,StringBuilder stringBuilder){
        if(root!=null){
            //每次创建一个新的StringBuilder，将上次的值作为拼接初始值
            StringBuilder sb = new StringBuilder(stringBuilder);
            if(root.left==null&&root.right==null) {
                //到达叶子节点，拼接完值就添加到结果集
                sb.append(root.val);
                res.add(sb.toString());
            }else {
                //还没到叶子节点，拼接值之后加一个->
                sb.append(root.val).append("->");
                search(root.left, sb);
                search(root.right, sb);
            }
        }
    }
}
```

---

#### [270. 最接近的二叉搜索树值](https://leetcode-cn.com/problems/closest-binary-search-tree-value/)

给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。

**注意：**

- 给定的目标值 target 是一个浮点数
- 题目保证在该二叉搜索树中只会存在一个最接近目标值的数

**示例：**

```
输入: root = [4,2,5,1,3]，目标值 target = 3.714286

    4
   / \
  2   5
 / \
1   3

输出: 4
```

解答：

```java
class Solution {

    //保存最接近的值
    Integer num=null;

    public int closestValue(TreeNode root, double target) {
        if(root!=null){
            //如果最接近的值不存在或有更接近的值就更新
            if(num==null||Math.abs(root.val-target)<Math.abs(num-target)){
                num=root.val;
            }
            //在左右子树继续寻找
            closestValue(root.left,target);
            closestValue(root.right,target);
        }
        return num;
    }

}
```

---

#### [337. 打家劫舍 III](https://leetcode-cn.com/problems/house-robber-iii/)

在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

**示例 1:**

```
输入: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \ 
     3   1

输出: 7 
解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
```

解答：

```java
class Solution {

    HashMap<TreeNode,Integer> map=new HashMap<>();

    //计算root节点能偷取到的最大值
    public int rob(TreeNode root) {
        if(root==null)
            return 0;
        //避免重复计算，如果计算过直接返回结果
        if(map.containsKey(root))
            return map.get(root);
        //profit1表示当前节点和四个孙子节点能偷的最大值
        int profit1=root.val;
        if(root.left!=null)
            profit1+=rob(root.left.left)+rob(root.left.right);
        if(root.right!=null)
            profit1+=rob(root.right.left)+rob(root.right.right);
        //不偷当前节点，那么就取两个孩子节点的最大值
        int profit2=rob(root.left)+rob(root.right);
        //比较两种情况的最大值
        int max=Math.max(profit1,profit2);
        //存储结果
        map.put(root,max);
        return max;
    }

}
```

---

#### [366. 寻找二叉树的叶子节点](https://leetcode-cn.com/problems/find-leaves-of-binary-tree/)

给你一棵二叉树，请按以下要求的顺序收集它的全部节点：

1. 依次从左到右，每次收集并删除所有的叶子节点
2. 重复如上过程直到整棵树为空 

**示例:**

```
输入: [1,2,3,4,5]
  
          1
         / \
        2   3
       / \     
      4   5    

输出: [[4,5,3],[2],[1]]
```

解答：

```java
class Solution {

    List<List<Integer>> res=new ArrayList<>();//保存结果集
    List<Integer> list=new ArrayList<>();//保存临时结果

    public List<List<Integer>> findLeaves(TreeNode root) {
        if(root==null)
            return res;
        //仍存在叶子节点则递归处理
        while(root.left!=null||root.right!=null){
            help(root,null,list);
            res.add(new ArrayList<>(list));
            list.clear();
        }
        //只剩当前节点
        list.add(root.val);
        res.add(list);
        return res;
    }

    //辅助方法，删除所有叶子节点
    public void help(TreeNode root,TreeNode pre, List<Integer> list){
        if(root!=null){
            //左右节点都为空说明是叶子节点
            if(root.left==null&&root.right==null){
                if(pre!=null){
                    if(pre.left==root)//如果是左叶子则删除
                        pre.left=null;
                    else if(pre.right==root)//如果是右叶子则删除
                        pre.right=null;
                }
                list.add(root.val);
                return;
            }
            //不是叶子节点则递归处理
            help(root.left,root,list);
            help(root.right,root,list);
        }
    }
}
```

---

#### [404. 左叶子之和](https://leetcode-cn.com/problems/sum-of-left-leaves/)

计算给定二叉树的所有左叶子之和。

**示例：**

```
    3
   / \
  9  20
    /  \
   15   7

在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
```

 解答：

```java
    public int sumOfLeftLeaves(TreeNode root) {
        //空节点值0
        if(root==null)
            return 0;
        int sum=0;
        //如果左节点不为空，左节点的左节点或右节点不为空，递归往左子树查找
        if(root.left!=null&&(root.left.left!=null||root.left.right!=null))
            sum+=sumOfLeftLeaves(root.left);
        //如果右节点不为空，右节点的左节点或右节点不为空，递归往右子树查找
        if(root.right!=null&&(root.right.left!=null||root.right.right!=null))
            sum+=sumOfLeftLeaves(root.right);
        //如果左节点不为空，左节点是叶子节点，就直接相加
        if(root.left!=null&&root.left.left==null&&root.left.right==null)
            sum+=root.left.val;
        return sum;
    }
```

---

#### [429. N叉树的层序遍历](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/)

给定一个 N 叉树，返回其节点值的*层序遍历*。 (即从左到右，逐层遍历)。

例如，给定一个 `3叉树` :

<img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/narytreeexample.png" alt="img" style="zoom:33%;" />

 

返回其层序遍历:

```
[
     [1],
     [3,2,4],
     [5,6]
]
```

解答：

```java
    public List<List<Integer>> levelOrder(Node root) {
                List<List<Integer>> result=new ArrayList<>();
        List<Node> trees=new ArrayList<>();
        List<Integer> temp;
        if(root!=null){
            trees.add(root);
            while(!trees.isEmpty()){
                int n=trees.size();
                temp=new ArrayList<>();
                for(int i=0;i<n;i++){
                    Node remove=trees.remove(0);
                    temp.add(remove.val);
                    //和二叉树的层次遍历只有此处不同
                    //遍历孩子节点，不为空就入队
                    for(Node node:remove.children){
                        if(node!=null)
                            trees.add(node);
                    }
                }
                result.add(temp);
            }
        }
        return result;
    }
```

---

#### [437. 路径总和 III](https://leetcode-cn.com/problems/path-sum-iii/)

给定一个二叉树，它的每个结点都存放着一个整数值。

找出路径和等于给定数值的路径总数。

路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。

**示例：**

```
root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

返回 3。和等于 8 的路径有:

1.  5 -> 3
2.  5 -> 2 -> 1
3.  -3 -> 11
```

解答：

```java
    public int pathSum(TreeNode root, int sum) {
        if(root==null)
            return 0;
        //结果是当前节点，左节点，右节点分别为根的结果
        return count(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }

    public int count(TreeNode root,int sum){
        if(root==null)
            return 0;
        int res=root.val==sum?1:0;
        //在左右子树继续寻找
        return res+count(root.left,sum-root.val)+count(root.right,sum-root.val);
    }
```

---

#### [449. 序列化和反序列化二叉搜索树](https://leetcode-cn.com/problems/serialize-and-deserialize-bst/)

序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。

设计一个算法来序列化和反序列化**二叉搜索树**。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。

**编码的字符串应尽可能紧凑。**

**注意**：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。

解答：

```java
public class Codec {
    
    //通过前序遍历序列化
    public String serialize(TreeNode root) {
        if(root==null)
            return null;
        String str=preorder(root,new StringBuilder());
        return str;
    }

    //前序遍历的字符串
    public String preorder(TreeNode root,StringBuilder sb){
        if(root!=null){
            sb.append(root.val).append(" ");
            preorder(root.left,sb);
            preorder(root.right,sb);
        }
        return sb.toString();
    }
    
    //反序列化
    public TreeNode deserialize(String data) {
        if(data==null)
            return null;
        //双向队列
        LinkedList<Integer> nums = new LinkedList<>();
        //将序列化的数字字符串转化为队列
        for(String s : data.split(" "))
            nums.add(Integer.parseInt(s));
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);
    }

    //前序遍历反序列化
    public TreeNode helper(Integer lower, Integer upper, LinkedList<Integer> nums) {
        if (nums.isEmpty()) 
            return null;
        //获取队首节点值
        int val = nums.getFirst();
        //小于最小值或大于最大值返回null
        if (val < lower || val > upper)
             return null;
        //移除队首节点值
        nums.removeFirst();
        TreeNode root = new TreeNode(val);
        //前序遍历，下一个队首节点就是当前节点的左节点
        root.left = helper(lower, val, nums);
        //左子树构成后，下一个队首节点就是当前节点的右节点
        root.right = helper(val, upper, nums);
        return root;
    }

}
```

---

#### [450. 删除二叉搜索树中的节点](https://leetcode-cn.com/problems/delete-node-in-a-bst/)

给定一个二叉搜索树的根节点 **root** 和一个值 **key**，删除二叉搜索树中的 **key** 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。

一般来说，删除节点可分为两个步骤：

1. 首先找到需要删除的节点；
2. 如果找到了，删除它。

**说明：** 要求算法时间复杂度为 O(h)，h 为树的高度。

**示例:**

```
root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7
给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
    5
   / \
  4   6
 /     \
2       7

另一个正确答案是 [5,2,6,null,4,null,7]。
    5
   / \
  2   6
   \   \
    4   7
```

解答：

```java
    //主要思路是替换值，然后将要删除的节点变为叶子节点直接删除
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root!=null){
            if(key<root.val){//key小于当前节点值，在左子树删除
                root.left=deleteNode(root.left,key);
            }else if(key>root.val){//key大于当前节点值，在右子树删除
                root.right=deleteNode(root.right,key);
            }else{
                if(root.right!=null){//右子树不为空，将节点值替换为右子树最小值，再删除该替换节点
                    root.val=getRightMin(root);
                    root.right=deleteNode(root.right,root.val);
                }else if(root.left!=null){//左子树不为空，将节点值替换为左子树最大值，再删除该替换节点
                    root.val=getLeftMax(root);
                    root.left=deleteNode(root.left,root.val);
                }else{
                    root=null;
                }
            }
        }
        return root;
    }


    //找到右子树的最小节点值
    public int getRightMin(TreeNode root){
        //从右子树开始寻找
        root=root.right;
        //最小值一定在最左节点
        while(root.left!=null)
            root=root.left;
        return root.val;
    }

    //找到左子树的最大节点值
    public int getLeftMax(TreeNode root){
        //从左子树开始寻找
        root=root.left;
        //最大值一定在最右节点
        while(root.right!=null)
            root=root.right;
        return root.val;
    }
```

----

#### [501. 二叉搜索树中的众数](https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/)

给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。

假定 BST 有如下定义：

- 结点左子树中所含结点的值小于等于当前结点的值
- 结点右子树中所含结点的值大于等于当前结点的值
- 左子树和右子树都是二叉搜索树

例如：
给定 BST `[1,null,2,2]`,

```
   1
    \
     2
    /
   2
```

`返回[2]`.

**提示**：如果众数超过1个，不需考虑输出顺序

解答：

```java
class Solution {
    //存放众数
    List<Integer> result=new ArrayList<>();
    //前驱节点值
    int pre;
    //当前节点值计数器
    int count;
    //当前某节点值出现最多的次数
    int max;

    public int[] findMode(TreeNode root) {
        //空节点，不存在众数
        if(root==null)
            return new int[0];
        //初始化
        pre=root.val;
        count=0;
        //辅助方法
        help(root);
        //将结果集中元素输出
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    //二叉搜索树中序是升序序列，所以按中序遍历
    public void help(TreeNode root){
        if(root==null)
            return;
        //遍历左子树
        help(root.left);
        //处理当前节点
        if(pre==root.val){//当前节点值=前驱节点值，该值计数器+1
            count++;
        }else {//若不等于，更新前驱节点值，计数器初始化1
            pre=root.val;
            count=1;
        }
        if(count==max){//不止一个众数的情况
            result.add(pre);
        }else if(count>max){//当前值出现次数最多，清空值集合并添加
            result.clear();
            result.add(pre);
            max=count;
        }
        //遍历右子树
        help(root.right);
    }
}
```

---

#### [508. 出现次数最多的子树元素和](https://leetcode-cn.com/problems/most-frequent-subtree-sum/)

给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。

你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。

**示例 1：**
输入:

```
  5
 /  \
2   -3
```

返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。

解答：

```java
class Solution {

    List<Integer> list=new ArrayList<>();
    HashMap<Integer,Integer> map=new HashMap<>();//保存子树和与次数的对应关系
    int max=0;//保存最大次数

    public int[] findFrequentTreeSum(TreeNode root) {
        help(root);
        //遍历次数，如果次数等于最大次数就存入list
        Set<Integer> keys = map.keySet();
        for(int num:keys){
            if(map.get(num)==max)
                list.add(num);
        }
        //list转为int[]
        int[] res=new int[list.size()];
        for(int i=0;i<res.length;i++){
            res[i]=list.get(i);
        }
        return res;
    }

    public int help(TreeNode root){
        if(root==null)
            return 0;
        //当前子树和等于自己的值加上左右子树和
        int val=root.val+help(root.left)+help(root.right);
        //将子树和以及对应出现次数存入map
        int time=map.getOrDefault(val,0)+1;
        map.put(val,time);
        //更新出现最多的次数
        if(time>max)
            max=time;
        return val;
    }

}
```

---

#### [513. 找树左下角的值](https://leetcode-cn.com/problems/find-bottom-left-tree-value/)

给定一个二叉树，在树的最后一行找到最左边的值。

**示例 1:**

```
输入:

    2
   / \
  1   3

输出:
1
```

解答：

```java
class Solution {

    int max=-1;//保存深度
    int val=0;//保存最后一层最左节点值

    public int findBottomLeftValue(TreeNode root) {
        help(root,-1);
        return val;
    }

    public void help(TreeNode root,int depth){
        if(root!=null){
            depth=depth+1;
            //第一次大于最大深度的就是最左节点
            if(depth>max){
                max=depth;
                val=root.val;
            }
            help(root.left,depth);
            help(root.right,depth);
        }
    }
}
```

----

#### [515. 在每个树行中找最大值](https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/)

您需要在二叉树的每一行中找到最大的值。

**示例：**

```
输入: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

输出: [1, 3, 9]
```

解答：

```java
class Solution {

    int max=-1;//保存最大深度
    //key是深度，value是该深度的最大值
    HashMap<Integer,Integer> map=new HashMap<>();
    
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        help(root,-1);
        for(int i=0;i<=max;i++){
            list.add(map.get(i));
        }
        return list;
    }

    public void help(TreeNode root,int depth){
        if(root!=null){
            depth=depth+1;
            //更新最大深度
            if(depth>max){
                max=depth;
            }
            //当前深度还没有值或比当前值大
            if(!map.containsKey(depth)||root.val>map.get(depth))
                map.put(depth,root.val);
            help(root.left,depth);
            help(root.right,depth);
        }
    }
}
```

---

#### [530. 二叉搜索树的最小绝对差](https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/)

给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。

**示例：**

```
输入：

   1
    \
     3
    /
   2

输出：
1

解释：
最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
```

解答：

```java
class Solution {

    //保存最小值
    int min=Integer.MAX_VALUE;
    //保存前驱节点值
    int pre=0;

    //绝对值最小，肯定是相邻数之间产生，用中序遍历辅助
    public int getMinimumDifference(TreeNode root) {
        pre=root.val;
        inorder(root);
        return min;
    }

    //中序遍历，更新差值
    public void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        if(root.val!=pre){
            int temp=Math.abs(root.val-pre);
            if(temp<min)
                min=temp;
            pre=root.val;
        }
        inorder(root.right);
    }
}
```

---

#### [538. 把二叉搜索树转换为累加树](https://leetcode-cn.com/problems/convert-bst-to-greater-tree/)

给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。

**例如：**

```
输入: 原始二叉搜索树:
              5
            /   \
           2     13

输出: 转换为累加树:
             18
            /   \
          20     13
```

解答：

```java
class Solution {

    //保存当前总和
    int sum=0;

    //从最右节点开始累加，采用逆中序遍历
    public TreeNode convertBST(TreeNode root) {
        if(root!=null){
            convertBST(root.right);
            //累加
            sum+=root.val;
            //更新当前节点
            root.val=sum;
            convertBST(root.left);
        }
        return root;
    }
    
}
```

---

#### [543. 二叉树的直径](https://leetcode-cn.com/problems/diameter-of-binary-tree/)

给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。

**示例 :**
给定二叉树

```
          1
         / \
        2   3
       / \     
      4   5    
```

返回 **3**, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。

**注意：**两结点之间的路径长度是以它们之间边的数目表示。

解答：

```java
class Solution {

    //保存最长路径
    int max=0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        maxDepth(root);
        return max;
    }

    //相当于求最大深度时多了一行更新左右深度和的最大值更新操作
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int hL=maxDepth(root.left);
        int hR=maxDepth(root.right);
        //更新直径最大值
        max=Math.max(max,hL+hR);
        return Math.max(hL,hR)+1;
    }

}
```

---

#### [559. N叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/)

给定一个 N 叉树，找到其最大深度。

最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。

例如，给定一个 `3叉树` :

 

<img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/narytreeexample.png" alt="img" style="zoom:33%;" />

 

我们应返回其最大深度，3。

**说明:**

1. 树的深度不会超过 `1000`。
2. 树的节点总不会超过 `5000`。

解答：

```java
    public int maxDepth(Node root) {
        if(root==null)
            return 0;
        //保存子树节点数最大值
        int depth=0;
        //在子树中寻找节点数的最大值，其实和二叉树最大高度一样，只是换了一个形式，使用for循环
        for(Node node:root.children){
            depth=Math.max(depth,maxDepth(node));
        }
        //返回子树最大值加自身节点数1
        return depth+1;
    }
```

---

#### [563. 二叉树的坡度](https://leetcode-cn.com/problems/binary-tree-tilt/)

给定一个二叉树，计算**整个树**的坡度。

一个树的**节点的坡度**定义即为，该节点左子树的结点之和和右子树结点之和的**差的绝对值**。空结点的的坡度是0。

**整个树**的坡度就是其所有节点的坡度之和。

**示例:**

```
输入: 
         1
       /   \
      2     3
输出: 1
解释: 
结点的坡度 2 : 0
结点的坡度 3 : 0
结点的坡度 1 : |2-3| = 1
树的坡度 : 0 + 0 + 1 = 1
```

解答：

```java
class Solution {
    
    //坡度和
    int p=0;

    public int findTilt(TreeNode root) {
        if(root==null)
            return 0;
        postorder(root);
        return p;
    }

    //后序遍历计算某个节点包括自身的节点和，顺便计算该节点的坡度值，累加到结果中
    public int postorder(TreeNode root){
        if(root==null)
            return 0;
        //左子树的节点和
        int sumL=postorder(root.left);
        //右子树的节点和
        int sumR=postorder(root.right);
        //累加当前节点坡度
        p+=Math.abs(sumL-sumR);
        //返回当前节点的节点和
        return sumL+sumR+root.val;
    }
}
```

---

#### [572. 另一个树的子树](https://leetcode-cn.com/problems/subtree-of-another-tree/)

给定两个非空二叉树 **s** 和 **t**，检验 **s** 中是否包含和 **t** 具有相同结构和节点值的子树。**s** 的一个子树包括 **s** 的一个节点和这个节点的所有子孙。**s** 也可以看做它自身的一棵子树。

**示例 1:**
给定的树 s:

```
     3
    / \
   4   5
  / \
 1   2
```

给定的树 t：

```
   4 
  / \
 1   2
```

返回 **true**，因为 t 与 s 的一个子树拥有相同的结构和节点值。

**示例 2:**
给定的树 s：

```
     3
    / \
   4   5
  / \
 1   2
    /
   0
```

给定的树 t：

```
   4
  / \
 1   2
```

返回 **false**。

解答：

```java
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null)
            return false;
        //以当前节点为根，或者在左右子树中继续寻找
        return isSame(s,t)||isSubtree(s.left,t)||isSubtree(s.right,t);
    }

    //判断两个分别以s和t作为根节点的树是否相同
    public boolean isSame(TreeNode s,TreeNode t){
        //都为空为true
        if(s==null&&t==null)
            return true;
        //其中一个为空另一个不为空为false
        if((s!=null&&t==null)||(s==null&&t!=null))
            return false;
        //根节点值不同为false
        if(s.val!=t.val)
            return false;
        //比较对应的左子树和右子树
        return isSame(s.left,t.left)&&isSame(s.right,t.right);
    }
```

---

#### [589. N叉树的前序遍历](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/)

给定一个 N 叉树，返回其节点值的*前序遍历*。

例如，给定一个 `3叉树` :

 

<img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/narytreeexample.png" alt="img" style="zoom:33%;" />

 

返回其前序遍历: `[1,3,5,6,2,4]`。

**说明:** 递归法很简单，你可以使用迭代法完成此题吗?

递归解答：

```java
class Solution {

    List<Integer> list=new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if(root!=null){
            list.add(root.val);
            for(Node node:root.children){
                preorder(node);
            }
        }
        return list;
    }
}
```

迭代解答：

```java
class Solution {

    List<Integer> list=new ArrayList<>();

    public List<Integer> preorder(Node root) {
        Stack<Node> stack=new Stack<>();
        if(root!=null)
            stack.push(root);
        while (!stack.isEmpty()){
            //出栈一个节点
            Node pop = stack.pop();
            //添加当前节点值到结果集
            list.add(pop.val);
            //将子节点逆序入栈
            Collections.reverse(pop.children);
            for(Node node:pop.children){
                stack.push(node);
            }
        }
        return list;
    }
}
```

---

#### [590. N叉树的后序遍历](https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/)

难度简单63

给定一个 N 叉树，返回其节点值的*后序遍历*。

例如，给定一个 `3叉树` :

 

<img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/narytreeexample.png" alt="img" style="zoom:33%;" />

 

返回其后序遍历: `[5,6,3,2,4,1]`.

**说明:** 递归法很简单，你可以使用迭代法完成此题吗?

递归解答：

```java
class Solution {

    List<Integer> list=new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if(root!=null){           
            for(Node node:root.children){
                postorder(node);
            }
            list.add(root.val);
        }
        return list;
    }
}
```

迭代解答：

```java
class Solution {

    List<Integer> list=new ArrayList<>();

    public List<Integer> postorder(Node root) {
        Stack<Node> stack=new Stack<>();
        if(root!=null)
            stack.push(root);
        while (!stack.isEmpty()){
            //出栈一个节点
            Node pop = stack.pop();
            //添加当前节点值到结果集
            list.add(pop.val);
            //将子节点顺序入栈
            for(Node node:pop.children){
                stack.push(node);
            }
        }
        //将结果逆序即为后序遍历结果
        Collections.reverse(list);
        return list;
    }
}
```

---

#### [606. 根据二叉树创建字符串](https://leetcode-cn.com/problems/construct-string-from-binary-tree/)

你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。

空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。

**示例 1:**

```
输入: 二叉树: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     

输出: "1(2(4))(3)"

解释: 原本将是“1(2(4)())(3())”，
在你省略所有不必要的空括号对之后，
它将是“1(2(4))(3)”。
```

解答：

```java
	public String tree2str(TreeNode t) {
        if(t==null)
            return "";
        StringBuilder sb=new StringBuilder();
        sb.append(t.val);
        //左右子树任意一个不为空就要添加左子树
        if(t.left!=null||t.right!=null)
            sb.append("(").append(tree2str(t.left)).append(")");
        //右子树空可以省略
        if(t.right!=null)
            sb.append("(").append(tree2str(t.right)).append(")");
        return sb.toString();
    }
```

---

#### [617. 合并二叉树](https://leetcode-cn.com/problems/merge-two-binary-trees/)

给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。

你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则**不为** NULL 的节点将直接作为新二叉树的节点。

**示例 1:**

```
输入: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
输出: 
合并后的树:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
```

**注意:** 合并必须从两个树的根节点开始。

解答：

```java
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        //t1是空将t2作为新节点
        if(t1==null)
            return t2;
        //t1、t2都不为空，将t2的节点值加到t1上，然后将合并的左子树作为t1的左节点，合并的右子树作为t1的右节点
        if(t2!=null){
            t1.val+=t2.val;
            t1.left=mergeTrees(t1.left,t2.left);
            t1.right=mergeTrees(t1.right,t2.right);
        }
        return t1;
    }
```

---

#### [623. 在二叉树中增加一行](https://leetcode-cn.com/problems/add-one-row-to-tree/)

给定一个二叉树，根节点为第1层，深度为 1。在其第 `d` 层追加一行值为 `v` 的节点。

添加规则：给定一个深度值 `d` （正整数），针对深度为 `d-1` 层的每一**非空**节点 `N`，为 `N` 创建两个值为 `v` 的左子树和右子树。

将 `N` 原先的左子树，连接为新节点 `v` 的左子树；将 `N` 原先的右子树，连接为新节点 `v` 的右子树。

如果 `d` 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 `v`，原先的整棵树将作为 `v` 的左子树。

**示例 1:**

```
输入: 
二叉树如下所示:
       4
     /   \
    2     6
   / \   / 
  3   1 5   

v = 1

d = 2

输出: 
       4
      / \
     1   1
    /     \
   2       6
  / \     / 
 3   1   5   
```

解答：

```java
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        //d为1的特殊情况，创建根节点，直接将原先的树作为左子树
        if(d==1){
            TreeNode newRoot=new TreeNode(v);
            newRoot.left=root;
            return newRoot;
        }
        add(root,v,1,d);
        return root;
    }

    //当depth=d-1时添加树
    public void add(TreeNode root,int v,int depth,int d){
        //当前节点为空不用再继续找了
        if(root==null)
            return;
        //达到目标深度
        if(depth==d-1){
            TreeNode v1=new TreeNode(v);
            v1.left=root.left;
            root.left=v1;
            TreeNode v2=new TreeNode(v);
            v2.right=root.right;
            root.right=v2;
        }else{//继续找
            add(root.left,v,depth+1,d);
            add(root.right,v,depth+1,d);
        }
    }
```

---

#### [637. 二叉树的层平均值](https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/)

给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.

**示例 1:**

```
输入:
    3
   / \
  9  20
    /  \
   15   7
输出: [3, 14.5, 11]
解释:
第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
```

解答：

```java
    public List<Double> averageOfLevels(TreeNode root) {
        //结果集
        List<Double> result=new ArrayList<>();
        //节点队列
        List<TreeNode> list=new ArrayList<>();
        //头结点入队
        list.add(root);
        //保存每一层的节点和
        double sum=0;
        while(!list.isEmpty()){
            sum=0;//初始化和
            //每一层的节点数就是当前队列元素数
            int n=list.size();
            for(int i=0;i<n;i++){
                TreeNode remove=list.remove(0);
                sum+=remove.val;//累加该层节点值
                //如果有左右节点要入队
                if(remove.left!=null)
                    list.add(remove.left);
                if(remove.right!=null)
                    list.add(remove.right);
            }
            //该层平均值
            sum=sum/n;
            result.add(sum);
        }
        return result;
    }
```

---

#### [652. 寻找重复的子树](https://leetcode-cn.com/problems/find-duplicate-subtrees/)

给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意**一棵**的根结点即可。

两棵树重复是指它们具有相同的结构以及相同的结点值。

**示例 1：**

```
        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
```

下面是两个重复的子树：

```
      2
     /
    4
```

和

```
    4
```

因此，你需要以列表的形式返回上述重复子树的根结点。

解答：

```java
class Solution {

    //全局变量用于提供唯一id
    int n=1;
    //保存内容和对应序号id的关系，内容相同id相同
    HashMap<String,Integer> map1=new HashMap<>();
    //保存唯一序号id和出现次数的关系，key是id，value是次数
    HashMap<Integer,Integer> map2=new HashMap<>();
    //结果集
    List<TreeNode> list=new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if(root!=null)
        getID(root);
        return list;
    }

    public int getID(TreeNode root){
        if(root==null)
            return 0;
        //当前节点信息（转为字符串）
        String unique=""+root.val+getID(root.left)+getID(root.right);
        //计算唯一id
        int id=map1.computeIfAbsent(unique,u->n++);
        //获取出现次数
        int time=map2.getOrDefault(id,0)+1;
        map2.put(id,time);
        //只有第二次出现时添加，避免重复
        if(time==2)
            list.add(root);
        return id;
    }
}
```

---

#### [653. 两数之和 IV - 输入 BST](https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/)

给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。

**案例 1:**

```
输入: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

输出: True
```

 解答：

```java
class Solution {
    
    //保存节点值
    HashSet<Integer> set=new HashSet<>();
    
    public boolean findTarget(TreeNode root, int k) {
        if(root!=null){
            //如果集合存在一个加上当前节点值和为k的值，就说明存在
            if(set.contains(k-root.val))
                return true;
            //如果不存在，添加当前值，在左右子树寻找
            set.add(root.val);
            return findTarget(root.left, k)||findTarget(root.right, k);
        }
        return false;
    }

}
```

---

#### [654. 最大二叉树](https://leetcode-cn.com/problems/maximum-binary-tree/)

给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：

1. 二叉树的根是数组中的最大元素。
2. 左子树是通过数组中最大值左边部分构造出的最大二叉树。
3. 右子树是通过数组中最大值右边部分构造出的最大二叉树。

通过给定的数组构建最大二叉树，并且输出这个树的根节点。

**示例 ：**

```
输入：[3,2,1,6,0,5]
输出：返回下面这棵树的根节点：

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
```

解答：

```java
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums,0,nums.length-1);
    }

    public TreeNode buildTree(int[] nums,int start,int end){        
        if(start>end)//开始大于结尾说明空树
            return null;        
        else if(start==end)//相同的话直接创建节点返回
            return new TreeNode(nums[start]);
        else{           
            int index=getMaxIndex(nums,start,end);//计算当前最大值下标           
            TreeNode root=new TreeNode(nums[index]);//创建该节点           
            root.left=buildTree(nums,start,index-1);//下标以左创建左子树
            root.right=buildTree(nums,index+1,end);//下标以右创建右子树
            return root;
        }
    }


    //计算nums数组从start到end范围内的最大值的索引
    public int getMaxIndex(int[] nums,int start,int end){
        int index=start;
        int max=nums[start];
        for(int i=start+1;i<=end;i++){
            if(nums[i]>max){
                max=nums[i];
                index=i;
            }
        }
        return index;
    }
```

---

#### [662. 二叉树最大宽度](https://leetcode-cn.com/problems/maximum-width-of-binary-tree/)

给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与**满二叉树（full binary tree）**结构相同，但一些节点为空。

每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的`null`节点也计入长度）之间的长度。

**示例 1:**

```
输入: 

           1
         /   \
        3     2
       / \     \  
      5   3     9 

输出: 4
解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
```

解答：

```java
class Solution {

    //key是深度，value是该深度第一个出现的节点位置即最左节点
    HashMap<Integer,Integer> map=new HashMap<>();
    //当前最大宽度
    int max=0;

    public int widthOfBinaryTree(TreeNode root) {
        help(root,0,0);
        return max;
    }

    //前序遍历
    public void help(TreeNode root,int depth,int pos){
        if(root!=null){
            depth=depth+1;//当前深度
            //如果当前深度还没有存入map，说明找到了当前深度最左节点
            if(!map.containsKey(depth))
                map.put(depth,pos);
            int len=pos-map.get(depth)+1;
            if(len>max)
                max=len;
            help(root.left,depth,pos*2);
            help(root.right,depth,pos*2+1);
        }
    }
}
```

---

#### [669. 修剪二叉搜索树](https://leetcode-cn.com/problems/trim-a-binary-search-tree/)

给定一个二叉搜索树，同时给定最小边界`L` 和最大边界 `R`。通过修剪二叉搜索树，使得所有节点的值在`[L, R]`中 (R>=L) 。你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。

**示例 1:**

```
输入: 
    1
   / \
  0   2

  L = 1
  R = 2

输出: 
    1
      \
       2
```

解答：

```java
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root!=null){
            if(root.val==L) //当前节点=左临界值，将左子树剪掉
                root.left=null;
            else if(root.val==R)//当前节点=右临界值，将右子树剪掉
                root.right=null;
            else if(root.val<L)//当前节点<左临界值，将右子树作为新的左节点
                return trimBST(root.right,L,R);
            else if(root.val>R)//当前节点>右临界值，将左子树作为新的右节点
                return trimBST(root.left,L,R);
            if(root.left!=null)//左子树不为空，修剪
                root.left=trimBST(root.left,L,R);
            if(root.right!=null)//右子树不为空，修剪
                root.right=trimBST(root.right,L,R);
        }
        return root;
    }
```

---

#### [671. 二叉树中第二小的节点](https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/)

给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 `2` 或 `0`。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 

给出这样的一个二叉树，你需要输出所有节点中的**第二小的值。**如果第二小的值不存在的话，输出 -1 **。**

**示例 1:**

```
输入: 
    2
   / \
  2   5
     / \
    5   7

输出: 5
说明: 最小的值是 2 ，第二小的值是 5 。
```

解答：

```java
    public int findSecondMinimumValue(TreeNode root) {
        //节点空，或者左右节点都为空，返回-1
        if(root==null||(root.left==null&&root.right==null))
            return -1;
        //计算左节点的值，如果等于根节点就递归在左子树计算，右节点同理
        int left=root.left.val;
        if(left==root.val)
            left=findSecondMinimumValue(root.left);
        int right=root.right.val;
        if(right==root.val)
            right=findSecondMinimumValue(root.right);
        //左右节点值都有效，取较小的
        if(left!=-1&&right!=-1)
            return Math.min(left,right);
        //左边有效
        if(left!=-1)
            return left;
        //右边有效
        return right;
    }
```

---

#### [687. 最长同值路径](https://leetcode-cn.com/problems/longest-univalue-path/)

给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。

**注意**：两个节点之间的路径长度由它们之间的边数表示。

**示例 1:**

输入:

```
              5
             / \
            4   5
           / \   \
          1   1   5
```

输出:

```
2
```

解答：

```java
class Solution {
    int max=0;//保存最大结果

    public int longestUnivaluePath(TreeNode root) {
        if(root==null)
            return 0;
        longPath(root);
        return max;    
    }

    //以当前节点值为相同值，求左右子树中相同值较多的节点数
    public int longPath(TreeNode root){
        if(root==null)
            return 0;
        //求左右子树中相同节点数
        int left=longPath(root.left);
        int right=longPath(root.right);
        int pathL=0;
        int pathR=0;
        //如果左节点值和当前值相同，左路径就是左节点的路径长+1
        if(root.left!=null&&root.val==root.left.val)
            pathL=left+1;
        //如果右节点值和当前值相同，右路径就是右节点的路径长+1
        if(root.right!=null&&root.val==root.right.val)
            pathR=right+1;
        //经过当前节点的最大路径长，即当前最大路径长度和当前节点左右路径长度之和的较大值
        max=Math.max(max,pathL+pathR);
        //不经过当前节点，返回左右节点中相同节点较多的那个
        return Math.max(pathL,pathR);
    }
}
```

---

#### [700. 二叉搜索树中的搜索](https://leetcode-cn.com/problems/search-in-a-binary-search-tree/)

给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。

例如，

```
给定二叉搜索树:

        4
       / \
      2   7
     / \
    1   3

和值: 2
```

你应该返回如下子树:

```
      2     
     / \   
    1   3
```

在上述示例中，如果要找的值是 `5`，但因为没有节点值为 `5`，我们应该返回 `NULL`。

解答：

```java
    public TreeNode searchBST(TreeNode root, int val) {
        if(root!=null){
            //找到直接返回
            if(root.val==val)
                return root;
            //在左子树找到就返回，否则返回右子树的结果
            TreeNode res= searchBST(root.left,val);
            if(res!=null)
                return res;
            return searchBST(root.right,val);
        }
        return root;
    }
```

---

#### [701. 二叉搜索树中的插入操作](https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/)

给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 保证原始二叉搜索树中不存在新值。

注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。

解答：

```java
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root!=null){
            if(val<root.val){
                if(root.left==null)
                    root.left=new TreeNode(val);
                else
                    insertIntoBST(root.left,val);
            }else{
                if(root.right==null)
                    root.right=new TreeNode(val);
                else
                    insertIntoBST(root.right,val);
            }
        }
        return root;
    }
```

---

#### [783. 二叉搜索树节点最小距离](https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/)

给定一个二叉搜索树的根节点 `root`，返回树中任意两节点的差的最小值。

和530题一样。

---

#### [814. 二叉树剪枝](https://leetcode-cn.com/problems/binary-tree-pruning/)

给定二叉树根结点 `root` ，此外树的每个结点的值要么是 0，要么是 1。

返回移除了所有不包含 1 的子树的原二叉树。

( 节点 X 的子树为 X 本身，以及所有 X 的后代。)

```
示例1:
输入: [1,null,0,0,1]
输出: [1,null,0,null,1]
 
解释: 
只有红色节点满足条件“所有不包含 1 的子树”。
右图为返回的答案。
```

解答：

```java
    public TreeNode pruneTree(TreeNode root) {
        if(root!=null){
            if(root.val==0&&root.left==null&&root.right==null)
                return null;
            //左节点满足条件就将其移除
            TreeNode removeL=pruneTree(root.left);
            if(removeL==null)
                root.left=null;
            //右节点满足条件就将其移除
            TreeNode removeR=pruneTree(root.right);
            if(removeR==null)
                root.right=null;
            //左右节点都满足条件且该节点为0才满足
            if(root.val==0&&removeL==null&&removeR==null){
                return null;
            }
        }
        return root;
    }
```

---

#### [872. 叶子相似的树](https://leetcode-cn.com/problems/leaf-similar-trees/)

请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 *叶值序列* 。

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/16/tree.png" alt="img" style="zoom:33%;" />

举个例子，如上图所示，给定一颗叶值序列为 `(6, 7, 4, 9, 8)` 的树。

如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 *叶相似* 的。

如果给定的两个头结点分别为 `root1` 和 `root2` 的树是叶相似的，则返回 `true`；否则返回 `false` 。

解答：

```java
class Solution {
    //保存root1的叶子
    List<Integer> res1 = new ArrayList<>();
    //保存root2的叶子
    List<Integer> res2 = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        postOrder(root1,res1);
        postOrder(root2,res2);
        //两个叶子集合长度不等一定不等
        if(res1.size()!=res2.size())
            return false;
        //按顺序比较元素
        for (int i=0;i<res1.size();i++){
            if(!res1.get(i).equals(res2.get(i)))
                return false;
        }
        return true;
    }

    //后序遍历
    public void postOrder(TreeNode root,List<Integer> list){
        if(root!=null){
            postOrder(root.left,list);
            postOrder(root.right,list);
            //是叶子节点就添加值到集合
            if(root.left==null&&root.right==null)
                list.add(root.val);
        }
    }

}
```

---

#### [894. 所有可能的满二叉树](https://leetcode-cn.com/problems/all-possible-full-binary-trees/)

*满二叉树*是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。

返回包含 `N` 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。

答案中每个树的每个`结点`都**必须**有 `node.val=0`。

你可以按任何顺序返回树的最终列表。

**示例：**

```
输入：7
输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
解释：
```

解答：

```java
class Solution {

    public List<TreeNode> allPossibleFBT(int n) {
        if(n==0)
            return new ArrayList<TreeNode>();
        return createTree(n);
    }

    //跟95题类似
    public List<TreeNode> createTree(int n){
        //保存结果集
        List<TreeNode> result=new ArrayList<>();
        if(n==1){
            result.add(new TreeNode(0));
            return result;
        }
        //用n个节点构造满二叉树，除去根节点还有n-1个可用
        //左边1个，右边n-2个、左边3个，右边n-4个、...左边n-2个，右边1个
        for(int i=1;i<n-1;i+=2){
            //左边节点构造的左子树           
            List<TreeNode> listL=createTree(i);
            //右边节点构造的右子树
            List<TreeNode> listR=createTree(n-1-i);
            //左右子树分别取出一个全组和
            for(TreeNode nodeL:listL){
                for(TreeNode nodeR:listR){
                    //节点全部为0
                    TreeNode root=new TreeNode(0);
                    root.left=nodeL;
                    root.right=nodeR;
                    result.add(root);
                }
            }
        }
        return result;
    }

}
```

---

#### [897. 递增顺序查找树](https://leetcode-cn.com/problems/increasing-order-search-tree/)

给你一个树，请你 **按中序遍历** 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。

**示例 ：**

```
输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \ 
1        7   9

输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9  
```

解答：

```java
    //根节点的前一个结点
    TreeNode pre=new TreeNode(-1);
    //因为pre会移动，用cur保存根节点的前一个结点
    TreeNode cur=pre;

    //中序遍历
    public TreeNode increasingBST(TreeNode root) {
        if(root!=null){
            increasingBST(root.left);
            //pre的右节点值是当前结点的值
            pre.right=new TreeNode(root.val);
            //pre移动到自己的右节点形成链
            pre=pre.right;
            increasingBST(root.right);
            //返回初始结点的下一个即根节点
            return cur.right;
        }
        return root;
    }
```

---

#### [938. 二叉搜索树的范围和](https://leetcode-cn.com/problems/range-sum-of-bst/)

给定二叉搜索树的根结点 `root`，返回 `L` 和 `R`（含）之间的所有结点的值的和。

二叉搜索树保证具有唯一的值。

**示例 1：**

```
输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
输出：32
```

解答：

```java
class Solution {

    //保存结果值
    int sum=0;

    //二叉树的中序遍历是递增序列，所以使用中序序列遍历
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root!=null){
            //如果小于L，往左寻找没有意义
            if(root.val>L)
                rangeSumBST(root.left,L,R);
            if(root.val>=L&&root.val<=R)
                sum+=root.val;
            //如果大于R，往右寻找没有意义
            if(root.val<R)
                rangeSumBST(root.right,L,R);
        }
        return sum;
    }
    
}
```

---

#### [965. 单值二叉树](https://leetcode-cn.com/problems/univalued-binary-tree/)

如果二叉树每个节点都具有相同的值，那么该二叉树就是*单值*二叉树。

只有给定的树是单值二叉树时，才返回 `true`；否则返回 `false`。

**示例 1：**

<img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/29/screen-shot-2018-12-25-at-50104-pm.png" alt="img" style="zoom: 33%;" />

```
输入：[1,1,1,1,1,null,1]
输出：true
```

解答：

```java
class Solution {

    //保存单值
    private int unique=0;

    public boolean isUnivalTree(TreeNode root) {
        if(root==null)
            return true;
        unique=root.val;
        return isSame(root);
    }

    //当前节点和左右节点值是否一致
    public boolean isSame(TreeNode root){
        if(root==null)
            return true;
        if(root.val!=unique)
            return false;
        return isSame(root.left)&&isSame(root.right);
    }
}
```

---

#### [993. 二叉树的堂兄弟节点](https://leetcode-cn.com/problems/cousins-in-binary-tree/)

在二叉树中，根节点位于深度 `0` 处，每个深度为 `k` 的节点的子节点位于深度 `k+1` 处。如果二叉树的两个节点深度相同，但**父节点不同**，则它们是一对*堂兄弟节点*。我们给出了具有唯一值的二叉树的根节点 `root`，以及树中两个不同节点的值 `x` 和 `y`。只有与值 `x` 和 `y` 对应的节点是堂兄弟节点时，才返回 `true`。否则，返回 `false`。

**示例 1：
<img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/16/q1248-01.png" alt="img" style="zoom:50%;" />**

```
输入：root = [1,2,3,4], x = 4, y = 3
输出：false
```

解答：

```java
class Solution {

    int dep=0;

    public boolean isCousins(TreeNode root, int x, int y) {
        //第1个节点的深度值
        depth(root,x,0);
        int dx=dep;
        //第2个节点的深度值
        depth(root,y,0);
        int dy=dep;
        //深度值不等，返回false
        if(dx!=dy)
            return false;
        //深度值相同，如果父节点不同就返回true，相同返回false
        return isSameFather(root,x,y);
    }

    //计算节点的深度
    public void depth(TreeNode root,int val,int depth){
        if(root!=null){
            if(root.val==val)
                dep=depth;
            else{
                depth(root.left,val,depth+1);
                depth(root.right,val,depth+1);
            }
        }
    }

    //判断两个节点的父节点是否相同
    public boolean isSameFather(TreeNode root,int x,int y){
        if(root!=null){
            //x和y分别是左-右节点，返回false
            if(root.left!=null&&root.left.val==x&&root.right!=null&&root.right.val==y)
                return false;
            //x和y分别是右-左节点，返回false
            if(root.left!=null&&root.left.val==y&&root.right!=null&&root.right.val==x)
                return false;
            //判断左右子树
            return isSameFather(root.left,x,y)&&isSameFather(root.right,x,y);
        }
        return true;
    }

}
```

---

#### [1008. 先序遍历构造二叉树](https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal/)

返回与给定先序遍历 `preorder` 相匹配的二叉搜索树（binary **search** tree）的根结点。

*(回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于 `node.left` 的任何后代，值总 `<` `node.val`，而 `node.right` 的任何后代，值总 `>` `node.val`。此外，先序遍历首先显示节点的值，然后遍历 `node.left`，接着遍历 `node.right`。）*

**示例：**

```
输入：[8,5,1,7,10,12]
输出：[8,5,10,1,7,null,12]
```

解答：

```java
class Solution {

    //全局变量，标识当前遍历的节点索引
    int index=0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return help(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public TreeNode help(int[] preorder,int min,int max){
        if(index==preorder.length)
            return null;
        //获取当前节点值
        int val=preorder[index];
        //当前节点值不在范围内
        if(val<min||val>max)
            return null;
        TreeNode root=new TreeNode(val);
        index++;//使用了一个节点，继续下一个
        //左节点的值肯定小于val，更新max
        root.left=help(preorder,min,val);
        //右节点的值肯定大于val，更新min
        root.right=help(preorder,val,max);
        return root;
    }
}
```

---

#### [1022. 从根到叶的二进制数之和](https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers/)

给出一棵二叉树，其上每个结点的值都是 `0` 或 `1` 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 `0 -> 1 -> 1 -> 0 -> 1`，那么它表示二进制数 `01101`，也就是 `13` 。

对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。

以 **`10^9 + 7`** 为**模**，返回这些数字之和。

**示例：**

<img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/04/05/sum-of-root-to-leaf-binary-numbers.png" alt="img" style="zoom:50%;" />

```
输入：[1,0,1,0,1,0,1]
输出：22
解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
```

解答：

```java
class Solution {
    
    public int sumRootToLeaf(TreeNode root) {
        return add(root,0);
    }

    public int add(TreeNode root,int num){
        if(root!=null){
            //左移一位加上当前值
            num=(num<<1)+root.val;
            //返回累加到根节点的值
            if(root.left==null&&root.right==null)
                return num;
            //返回左右节点值的和
            return add(root.left,num)+add(root.right,num);
        }
        return 0;
    }
}
```

---

#### [1104. 二叉树寻路](https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree/)

在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 **逐行** 依次按 “之” 字形进行标记。

如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；

而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。

<img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/06/28/tree.png" alt="img" style="zoom:50%;" />

给你树上某一个节点的标号 `label`，请你返回从根节点到该标号为 `label` 节点的路径，该路径是由途经的节点标号所组成的。

**示例 1：**

```
输入：label = 14
输出：[1,3,4,14]
```

解答：

```java
    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> list=new LinkedList<>();
        while(label!=0){
            list.addFirst(label);
            label=label/2;
        }
        if(list.size()%2==0){
            for(int i=0;i<list.size()-1;i+=2){
                //该层起始位置
                int start = (int) Math.pow(2, i);
                //该层偏移位置
                int move=(int)Math.pow(2,i+1)-list.get(i)-1;
                //正确的值
                list.set(i,start+move);
            }
        }else{
            for(int i=1;i<list.size()-1;i+=2){
                //该层起始位置
                int start = (int) Math.pow(2, i);
                //该层偏移位置
                int move=(int)Math.pow(2,i+1)-list.get(i)-1;
                //正确的值
                list.set(i,start+move);
            }
        }
        return list;
    }
```

---

#### [1261. 在受污染的二叉树中查找元素](https://leetcode-cn.com/problems/find-elements-in-a-contaminated-binary-tree/)

给出一个满足下述规则的二叉树：

1. `root.val == 0`
2. 如果 `treeNode.val == x` 且 `treeNode.left != null`，那么 `treeNode.left.val == 2 * x + 1`
3. 如果 `treeNode.val == x` 且 `treeNode.right != null`，那么 `treeNode.right.val == 2 * x + 2`

现在这个二叉树受到「污染」，所有的 `treeNode.val` 都变成了 `-1`。

请你先还原二叉树，然后实现 `FindElements` 类：

- `FindElements(TreeNode* root)` 用受污染的二叉树初始化对象，你需要先把它还原。
- `bool find(int target)` 判断目标值 `target` 是否存在于还原后的二叉树中并返回结果。



**示例 1：**

**![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/11/16/untitled-diagram-4-1.jpg)**

```
输入：
["FindElements","find","find"]
[[[-1,null,-1]],[1],[2]]
输出：
[null,false,true]
解释：
FindElements findElements = new FindElements([-1,null,-1]); 
findElements.find(1); // return False 
findElements.find(2); // return True 
```

解答：

```java
class FindElements {

    HashSet<Integer> set=new HashSet<>();

    public FindElements(TreeNode root) {
        recover(root,0);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }

    public void recover(TreeNode root,int val){
        if(root!=null){
            root.val=val;
            set.add(val);//将正确的值存储在set集合
            recover(root.left,2*val+1);
            recover(root.right,2*val+2);
        }
    }
}
```

---

#### [1302. 层数最深叶子节点的和](https://leetcode-cn.com/problems/deepest-leaves-sum/)

给你一棵二叉树，请你返回层数最深的叶子节点的和。

**示例：**

**<img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/12/28/1483_ex1.png" alt="img" style="zoom:50%;" />**

```
输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
输出：15
```

解答：

```java
class Solution {

    int max=-1;//保存深度
    int sum=0;//保存最后一层的节点和

    public int deepestLeavesSum(TreeNode root) {
        help(root,0);
        return sum;
    }

    public void help(TreeNode root,int depth){
        if(root!=null){
            depth=depth+1;
            if(depth>max){
                max=depth;
                sum=root.val;
            }else if(depth==max){
                sum+=root.val;
            }
            help(root.left,depth);
            help(root.right,depth);
        }
    }
}
```

---

#### [1305. 两棵二叉搜索树中的所有元素](https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/)

给你 `root1` 和 `root2` 这两棵二叉搜索树。

请你返回一个列表，其中包含 **两棵树** 中的所有整数并按 **升序** 排序。.

**示例 1：**

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/12/29/q2-e1.png)

```
输入：root1 = [2,1,4], root2 = [1,0,3]
输出：[0,1,1,2,3,4]
```

解答：

```java
class Solution {

    List<Integer> list=new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        inorder(root1);
        inorder(root2);
        //排序
        Collections.sort(list);
        List<Integer> res=new ArrayList<>(list);
        return res;
    }

    //中序遍历的结果较有序，时间更少
    public void inorder(TreeNode root){
        if(root!=null){
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
    }
}
```

---

#### [1315. 祖父节点值为偶数的节点和](https://leetcode-cn.com/problems/sum-of-nodes-with-even-valued-grandparent/)

给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：

- 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）

如果不存在祖父节点值为偶数的节点，那么返回 `0` 。

**示例：**

**<img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/10/1473_ex1.png" alt="img" style="zoom:50%;" />**

```
输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
输出：18
解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
```

解答：

```java
class Solution {

    int sum=0;

    public int sumEvenGrandparent(TreeNode root) {
        if(root==null)
            return 0;
        if(root.val%2==0){
            //左节点不为空
            if(root.left!=null){
                sum+=root.left.left==null?0:root.left.left.val;
                sum+=root.left.right==null?0:root.left.right.val;
            }
            //右节点不为空
            if(root.right!=null){
                sum+=root.right.left==null?0:root.right.left.val;
                sum+=root.right.right==null?0:root.right.right.val;
            }
        }
        sumEvenGrandparent(root.left);
        sumEvenGrandparent(root.right);
        return sum;
    }
}
```

---

#### [1325. 删除给定值的叶子节点](https://leetcode-cn.com/problems/delete-leaves-with-a-given-value/)

给你一棵以 `root` 为根的二叉树和一个整数 `target` ，请你删除所有值为 `target` 的 **叶子节点** 。

注意，一旦删除值为 `target` 的叶子节点，它的父节点就可能变成叶子节点；如果新叶子节点的值恰好也是 `target` ，那么这个节点也应该被删除。

也就是说，你需要重复此过程直到不能继续删除。

**示例 1：**

**![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/16/sample_1_1684.png)**

```
输入：root = [1,2,3,2,null,2,4], target = 2
输出：[1,null,3,null,4]
解释：
上面左边的图中，绿色节点为叶子节点，且它们的值与 target 相同（同为 2 ），它们会被删除，得到中间的图。
有一个新的节点变成了叶子节点且它的值与 target 相同，所以将再次进行删除，从而得到最右边的图。
```

解答：

```java
    //类似814题
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root!=null){
            if(root.val==target&&root.left==null&&root.right==null)
                return null;
            TreeNode nodeL;
            TreeNode nodeR;
            if((nodeL=removeLeafNodes(root.left,target))==null)
                root.left=null;
            if((nodeR=removeLeafNodes(root.right,target))==null)
                root.right=null;
            if(root.val==target&&nodeL==null&&nodeR==null)
                return null;
        }
        return root;
    }
```

---

#### [1367. 二叉树中的列表](https://leetcode-cn.com/problems/linked-list-in-binary-tree/)

给你一棵以 `root` 为根的二叉树和一个 `head` 为第一个节点的链表。

如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 `head` 为首的链表中每个节点的值，那么请你返回 `True` ，否则返回 `False` 。

一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。

**示例 1：**

**![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/29/sample_1_1720.png)**

```
输入：head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
输出：true
解释：树中蓝色的节点构成了与链表对应的子路径。
```

解答：

```java
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root==null)
            return false;
        return isSub(head,root)||isSubPath(head, root.left)||isSubPath(head, root.right);
    }

    //以当前root为根节点能否匹配
    public boolean isSub(ListNode head,TreeNode root){
        //链表为空，匹配成功
        if(head==null)
            return true;
        //链表不为空但是root为空，代表失败了
        if(root==null)
            return false;
        //节点值不同，失败
        if(root.val!=head.val)
            return false;
        //当前节点匹配成功，匹配下一个，左右子树有一边成功即可
        return isSub(head.next,root.left)||isSub(head.next,root.right);
    }
```

---

#### [1379. 找出克隆二叉树中的相同节点](https://leetcode-cn.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/)

给你两棵二叉树，原始树 `original` 和克隆树 `cloned`，以及一个位于原始树 `original` 中的目标节点 `target`。

其中，克隆树 `cloned` 是原始树 `original` 的一个 **副本** 。

请找出在树 `cloned` 中，与 `target` **相同** 的节点，并返回对该节点的引用（在 C/C++ 等有指针的语言中返回 节点指针，其他语言返回节点本身）。

**注意：**

1. 你 **不能** 对两棵二叉树，以及 `target` 节点进行更改。
2. **只能** 返回对克隆树 `cloned` 中已有的节点的引用。

**进阶：**如果树中允许出现值相同的节点，你将如何解答？

**示例 1:**

<img src="https://assets.leetcode.com/uploads/2020/02/21/e1.png" alt="img" style="zoom:50%;" />

```
输入: tree = [7,4,3,null,null,6,19], target = 3
输出: 3
解释: 上图画出了树 original 和 cloned。target 节点在树 original 中，用绿色标记。答案是树 cloned 中的黄颜色的节点（其他示例类似）。
```

解答：

```java
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        //是克隆树，一个节点不为空，另一个一定不为空
        if(original!=null){
            if(original==target){
                return cloned;
            }
            //没找到，分别在左子树找
            TreeNode res=getTargetCopy(original.left,cloned.left,target);
            if(res!=null)
                return res;
            //左子树也没有，返回右子树寻找的结果
            return getTargetCopy(original.right,cloned.right,target);
        }
        return original;
    }
```

---

#### [1430. Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree](https://leetcode-cn.com/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree/)

Given a binary tree where each path going from the root to any leaf form a **valid sequence**, check if a given string is a **valid sequence** in such binary tree. 

We get the given string from the concatenation of an array of integers `arr` and the concatenation of all values of the nodes along a path results in a **sequence** in the given binary tree.

**Example 1:**

**<img src="https://assets.leetcode.com/uploads/2019/12/18/leetcode_testcase_1.png" alt="img" style="zoom: 33%;" />**

```
Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
Output: true
Explanation: 
The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure). 
Other valid sequences are: 
0 -> 1 -> 1 -> 0 
0 -> 0 -> 0
```

**Example 2:**

**<img src="https://assets.leetcode.com/uploads/2019/12/18/leetcode_testcase_2.png" alt="img" style="zoom:33%;" />**

```
Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
Output: false 
Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.
```

**Example 3:**

**<img src="https://assets.leetcode.com/uploads/2019/12/18/leetcode_testcase_3.png" alt="img" style="zoom:33%;" />**

```
Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
Output: false
Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.
```

解答：

```java
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return isValid(root,arr,0);
    }

    //辅助函数，前序遍历dfs
    public boolean isValid(TreeNode root,int[] arr,int index){
        if(root==null||index==arr.length)//节点空或数组匹配完成但节点非空，匹配失败
            return false;
        if(root.val!=arr[index])//节点值和数组值不同，匹配失败
            return false;
        if(root.left==null&&root.right==null&&index==arr.length-1)//当前是叶子节点，并且数组匹配完毕
            return true;
        //左右子树任意一边匹配成功即可
        return isValid(root.left,arr,index+1)||isValid(root.right,arr,index+1);
    }
```

---

#### [面试题 04.02. 最小高度树](https://leetcode-cn.com/problems/minimum-height-tree-lcci/)

给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。

解答：和108题一样。

---

#### [面试题 04.03. 特定深度节点链表](https://leetcode-cn.com/problems/list-of-depth-lcci/)

给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 `D`，则会创建出 `D` 个链表）。返回一个包含所有深度的链表的数组。

**示例：**

```
输入：[1,2,3,4,5,null,7,8]

        1
       /  \ 
      2    3
     / \    \ 
    4   5    7
   /
  8

输出：[[1],[2,3],[4,5,7],[8]]
```

解答：

```java
    //思路跟二叉树层序遍历一样
	public ListNode[] listOfDepth(TreeNode root) {
        List<ListNode> result=new ArrayList<>();
        //保存节点
        List<TreeNode> trees=new ArrayList<>();
        //保存临时结果
        ListNode temp;
        if(root!=null){
            trees.add(root);
            while(!trees.isEmpty()){
                //计算当前层节点数，按数量全部出队，再将其左右节点依次入队
                int n=trees.size();
                temp=new ListNode(-1);
                ListNode cur=temp;
                for(int i=0;i<n;i++){
                    TreeNode remove=trees.remove(0);
                    cur.next=new ListNode(remove.val);
                    cur=cur.next;
                    //出队节点的左右节点不为空就入队
                    if(remove.left!=null)
                        trees.add(remove.left);
                    if(remove.right!=null)
                        trees.add(remove.right);
                }
                //添加到结果集
                result.add(temp.next);
            }
        }
        ListNode[] res=new ListNode[result.size()];
        for(int i=0;i<res.length;i++)
            res[i]=result.get(i);
        return res;
    }
```

----

#### [面试题 04.04. 检查平衡性](https://leetcode-cn.com/problems/check-balance-lcci/)

实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。

解答：和110题一样。

---

#### [面试题 04.05. 合法二叉搜索树](https://leetcode-cn.com/problems/legal-binary-search-tree-lcci/)

实现一个函数，检查一棵二叉树是否为二叉搜索树。

解答：和98题一样。

---

#### [面试题 04.06. 后继者](https://leetcode-cn.com/problems/successor-lcci/)

设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。

如果指定节点没有对应的“下一个”节点，则返回`null`。

**示例 1:**

```
输入: root = [2,1,3], p = 1

  2
 / \
1   3

输出: 2
```

解答：

```java
class Solution {

    //保存中序节点序列
    List<TreeNode> list=new ArrayList<>();

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorder(root);
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)==p)
                return list.get(i+1);
        }
        return null;
    }


    //中序遍历保存升序序列
    public void inorder(TreeNode root){
        if(root!=null){
            inorder(root.left);
            list.add(root);
            inorder(root.right);
        }
    }
}
```

---

#### [面试题 04.08. 首个共同祖先](https://leetcode-cn.com/problems/first-common-ancestor-lcci/)

设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。

解答：和236题一样。

---

#### [面试题 04.10. 检查子树](https://leetcode-cn.com/problems/check-subtree-lcci/)

检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。

如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。

解答：和572题一样。

---

#### [面试题 04.12. 求和路径](https://leetcode-cn.com/problems/paths-with-sum-lcci/)

给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。

解答：和437题一样。

---

#### [面试题 17.12. BiNode](https://leetcode-cn.com/problems/binode-lcci/)

二叉树数据结构`TreeNode`可用来表示单向链表（其中`left`置空，`right`为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求值的顺序保持不变，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。返回转换后的单向链表的头节点。

解答：和897题一样。

---

#### [面试题07. 重建二叉树](https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/)

输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

解答：和106题一样。

---

#### [面试题26. 树的子结构](https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/)

输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)

B是A的子结构， 即 A中有出现和B相同的结构和节点值。

解答：

```java
    //和572题类似
    public boolean isSubStructure(TreeNode s, TreeNode t) {
        if(s==null||t==null)
            return false;
        //以当前节点为根，或者在左右子树中继续寻找
        return isSame(s,t)||isSubStructure(s.left,t)||isSubStructure(s.right,t);
    }

    //判断两个分别以s和t作为根节点的树是否相同
    public boolean isSame(TreeNode s,TreeNode t){
        if(s==null&&t!=null)
            return false;
        if(t==null)
            return true;
        //根节点值不同为false
        if(s.val!=t.val)
            return false;
        //比较对应的左子树和右子树
        return isSame(s.left,t.left)&&isSame(s.right,t.right);
    }
```

---

#### [面试题27. 二叉树的镜像](https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/)

请完成一个函数，输入一个二叉树，该函数输出它的镜像。

解答：和226题一样。

----

#### [面试题28. 对称的二叉树](https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/)

请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

解答：和101题一样。

---

#### [面试题32 - I. 从上到下打印二叉树](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/)

从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3

   / \
  9  20
    /  \
   15   7
返回：

[3,9,20,15,7]

解答：

```java
    public int[] levelOrder(TreeNode root) {
        //保存结果集
        List<Integer> result=new ArrayList<>();
        //保存节点
        List<TreeNode> trees=new ArrayList<>();
        //保存临时结果
        if(root!=null){
            trees.add(root);
            while(!trees.isEmpty()){
                //计算当前层节点数，按数量全部出队，再将其左右节点依次入队
                int n=trees.size();
                for(int i=0;i<n;i++){
                    TreeNode remove=trees.remove(0);
                    result.add(remove.val);
                    //出队节点的左右节点不为空就入队
                    if(remove.left!=null)
                        trees.add(remove.left);
                    if(remove.right!=null)
                        trees.add(remove.right);
                }
            }
        }
        int[] res=new int[result.size()];
        for(int i=0;i<res.length;i++){
            res[i]=result.get(i);
        }
        return res;
    }
```

---

#### [面试题32 - II. 从上到下打印二叉树 II](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/)

从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

解答：和102题一样。

---

#### [面试题32 - III. 从上到下打印二叉树 III](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/)

请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

解答：和103题一样。

---

#### [面试题34. 二叉树中和为某一值的路径](https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/)

输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。

解答：和113题一样。

---

#### [面试题54. 二叉搜索树的第k大节点](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/)

给定一棵二叉搜索树，请找出其中第k大的节点。

**示例 1:**

```
输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 4
```

解答：

```java
class Solution {

    ArrayList<Integer> list=new ArrayList<>();

    public int kthLargest(TreeNode root, int k) {
        inorder(root);
        return list.get(list.size()-k);
    }

    //中序遍历，结果从小到大保存
    public void inorder(TreeNode root){
        if(root!=null){
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
    }

}
```

---

#### [面试题55 - I. 二叉树的深度](https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/)

输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。

解答：和104题一样。

---

#### [面试题55 - II. 平衡二叉树](https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/)

输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

解答：和110题一样。

---

#### [面试题68 - I. 二叉搜索树的最近公共祖先](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/)

给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

解答：和235题一样。

---

#### [面试题68 - II. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/)

给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

解答：和236题一样。

---

## 数组

#### [1. 两数之和](https://leetcode-cn.com/problems/two-sum/)

给定一个整数数组 `nums` 和一个目标值 `target`，请你在该数组中找出和为目标值的那 **两个** 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

**示例:**

```
给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
```

解答：

```java
    public int[] twoSum(int[] nums, int target) {
        //存储元素和对应下标
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            //left表示还差多少可以组合成目标值
            int left=target-nums[i];
            //如果left存在就返回当前元素下标和left的下标
            if(map.containsKey(left))
                return new int[]{i,map.get(left)};
            else//不存在就存放当前元素及其下标
                map.put(nums[i],i);
        }
        //遍历完也没有找到
        return new int[2];
    }
```

---

#### [26. 删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)

给定一个排序数组，你需要在**[ 原地](http://baike.baidu.com/item/原地算法)** 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在 **[原地 ](https://baike.baidu.com/item/原地算法)修改输入数组** 并在使用 O(1) 额外空间的条件下完成。

**示例 1:**

```
给定数组 nums = [1,1,2], 

函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 

你不需要考虑数组中超出新长度后面的元素。
```

解答：

```java
    public int removeDuplicates(int[] nums) {
        int i=0;//不重复元素的下标
        //j从第2个元素开始
        for(int j=1;j<nums.length;j++){
            //如果当前元素和不重复元素不同，将不重复元素的下一个设位该值
            if(nums[j]!=nums[i]){
                nums[++i]=nums[j];
            }
        }
        //由于从0开始，总个数要加1
        return i+1;
    }
```

---

#### [27. 移除元素](https://leetcode-cn.com/problems/remove-element/)

给你一个数组 *nums* 和一个值 *val*，你需要 **[原地](https://baike.baidu.com/item/原地算法)** 移除所有数值等于 *val* 的元素，并返回移除后数组的新长度。

不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 **[原地 ](https://baike.baidu.com/item/原地算法)修改输入数组**。

元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

**示例 1:**

```
给定 nums = [3,2,2,3], val = 3,

函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

你不需要考虑数组中超出新长度后面的元素。
```

解答：

```java
    //和26题思路差不多
    public int removeElement(int[] nums, int val) {
        int i=0;//非val元素的下标
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=val){
                nums[i++]=nums[j];
            }
        }
        return i;
    }
```

---

#### [35. 搜索插入位置](https://leetcode-cn.com/problems/search-insert-position/)

给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

**示例 1:**

```
输入: [1,3,5,6], 5
输出: 2
```

**示例 2:**

```
输入: [1,3,5,6], 2
输出: 1
```

解答：

```java
    public int searchInsert(int[] nums, int target) {
        //二分搜索
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+((end-start)>>1);
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
                start=mid+1;
            else
                end=mid-1;
        }
        return start;
    }
```

---

#### [53. 最大子序和](https://leetcode-cn.com/problems/maximum-subarray/)

给定一个整数数组 `nums` ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

**示例:**

```
输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
```

解答：

```java
    public int maxSubArray(int[] nums) {
        //初始化，max为最大子序和，temp为当前子序和
        int max=nums[0];
        int temp=nums[0];
        for(int i=1;i<nums.length;i++){
            //temp小于0，直接清零重计，负值只会越加越小
            if(temp<0)
                temp=nums[i];
            else
                temp+=nums[i];
            //如果当前子序和大于当前最大子序和就更新
            if(temp>max)
                max=temp;
        }
        return max;
    }
```

---

#### [66. 加一](https://leetcode-cn.com/problems/plus-one/)

给定一个由**整数**组成的**非空**数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储**单个**数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

**示例 1:**

```
输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
```

解答：

```java
    public int[] plusOne(int[] digits) {
        int carry=0;//进位
        for(int i=digits.length-1;i>=0;i--){
            //末尾数字加1
            if(i==digits.length-1)
                digits[i]+=1;
            digits[i]+=carry;
            carry=digits[i]/10;//大于10进位1
            digits[i]=digits[i]%10;//对10取余就是当前值
        }
        if(carry!=1)
            return digits;
        else{//如果还有进位，创建新数组，首位置1，后面复制原数组
            int[] res=new int[digits.length+1];
            res[0]=1;
            System.arraycopy(res,1,digits,0,digits.length);
            return res;
        }
    }
```

---

#### [88. 合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)

给你两个有序整数数组 *nums1* 和 *nums2*，请你将 *nums2* 合并到 *nums1* 中*，*使 *nums1* 成为一个有序数组。

**说明:**

- 初始化 *nums1* 和 *nums2* 的元素数量分别为 *m* 和 *n* 。
- 你可以假设 *nums1* 有足够的空间（空间大小大于或等于 *m + n*）来保存 *nums2* 中的元素。

**示例:**

```
输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
```

解答：

```java
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=nums1.length-1;//保存数据的遍历指针
        int p=m-1;//nums1数据指针
        int q=n-1;//nums2数据指针
        while(p>=0&&q>=0){
            //如果nums1的元素更大就把遍历指针的值设为nums1当前的值，否则设为nums2的值
            nums1[i--]=nums1[p]>=nums2[q]?nums1[p--]:nums2[q--];
        }
        System.arraycopy(nums2,0,nums1,0,q+1);
    }
```

---

#### [118. 杨辉三角](https://leetcode-cn.com/problems/pascals-triangle/)

给定一个非负整数 *numRows，*生成杨辉三角的前 *numRows* 行。

![img](https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif)

在杨辉三角中，每个数是它左上方和右上方的数的和。

**示例:**

```
输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
```

解答：

```java
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();//保存结果
        List<Integer> pre=new ArrayList<>();//保存上一行
        List<Integer> cur=new ArrayList<>();//保存当前行
        for(int i=0;i<numRows;i++){
            cur=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i)//首尾添加1
                    cur.add(1);
                else
                    cur.add(pre.get(j-1)+pre.get(j));
            }
            result.add(cur);
            pre=cur;
        }
        return result;
    }
```

---

#### [119. 杨辉三角 II](https://leetcode-cn.com/problems/pascals-triangle-ii/)

给定一个非负索引 *k*，其中 *k* ≤ 33，返回杨辉三角的第 *k* 行。

![img](https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif)

在杨辉三角中，每个数是它左上方和右上方的数的和。

**示例:**

```
输入: 3
输出: [1,3,3,1]
```

解答：

```java
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre=new ArrayList<>();//保存上一行
        List<Integer> cur=new ArrayList<>();//保存当前行
        for(int i=0;i<=rowIndex;i++){
            cur=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i)//首尾添加1
                    cur.add(1);
                else
                    cur.add(pre.get(j-1)+pre.get(j));
            }
            pre=cur;
        }
        return cur;
    }
```

---

#### [121. 买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/)

给定一个数组，它的第 *i* 个元素是一支给定股票第 *i* 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。

注意：你不能在买入股票前卖出股票。 

**示例 1:**

```
输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
```

解答：

```java
    //经典的动态规划
    public int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;       
        int max=0;//最大利润
        int minbuy=prices[0];//可以购入的最低价
        for(int i=1;i<prices.length;i++){//最快第二天才能卖
            int cur=prices[i]-minbuy;//此时的收益为此时的卖出价格-之前的最低购入价格
            if(cur>max)//更新最大例如
                max=cur;
            if(prices[i]<minbuy)//因为先买后卖，所以先计算利润再更新最低买入价
                minbuy=prices[i];
        }
        return max;
    }
```

---

#### [122. 买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)

给定一个数组，它的第 *i* 个元素是一支给定股票第 *i* 天的价格。

设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

**注意：**你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

**示例 1:**

```
输入: [7,1,5,3,6,4]
输出: 7
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
```

解答：

```java
    //数学分析法，计算出所有利润的和
    public int maxProfit(int[] prices) {
        int max=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1])
                max+=prices[i]-prices[i-1];
        }
        return max;
    }
```

---

#### [167. 两数之和 II - 输入有序数组](https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/)

给定一个已按照***升序排列\*** 的有序数组，找到两个数使得它们相加之和等于目标数。

函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2*。*

**说明:**

- 返回的下标值（index1 和 index2）不是从零开始的。
- 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。

**示例:**

```
输入: numbers = [2, 7, 11, 15], target = 9
输出: [1,2]
解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
```

解答：

```java
    public int[] twoSum(int[] numbers, int target) {
        //使用双指针
        int start=0;
        int end=numbers.length-1;
        while(start<end){
            if(numbers[start]+numbers[end]<target)
                start++;
            else if(numbers[start]+numbers[end]>target)
                end--;
            else{
                return new int[]{start+1,end+1};
            }
        }
        return new int[2];
    }
```

---

#### [169. 多数元素](https://leetcode-cn.com/problems/majority-element/)

给定一个大小为 *n* 的数组，找到其中的多数元素。多数元素是指在数组中出现次数**大于** `⌊ n/2 ⌋` 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

**示例 1:**

```
输入: [3,2,3]
输出: 3
```

**示例 2:**

```
输入: [2,2,1,1,1,2,2]
输出: 2
```

解答：

```java
    public int majorityElement(int[] nums) {
        //使用投票算法，初始leader为第1个元素，票数为1
        int count=1;
        int leader=nums[0];
        for(int i=1;i<nums.length;i++){
            //当前数字和leader相同就加1票，否则减1票
            count+=nums[i]==leader?1:-1;
            //如果票数为0，选举新leader,该leader的票数为1
            if(count==0){
                leader=nums[i];
                count=1;
            }
        }
        return leader;
    }
```

---

#### [189. 旋转数组](https://leetcode-cn.com/problems/rotate-array/)

给定一个数组，将数组中的元素向右移动 *k* 个位置，其中 *k* 是非负数。

**示例 1:**

```
输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
```

解答：

```java
    public void rotate(int[] nums, int k) {
        k=k%nums.length;//防止越界
        //整体反转
        rotate(nums,0,nums.length-1);
        //翻转前k个
        rotate(nums,0,k-1);
        //翻转后n-k个
        rotate(nums,k,nums.length-1);
    }

    //反转数组start~end范围内的数字
    public void rotate(int[] nums,int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
```

---

#### [217. 存在重复元素](https://leetcode-cn.com/problems/contains-duplicate/)

给定一个整数数组，判断是否存在重复元素。

如果任意一值在数组中出现至少两次，函数返回 `true` 。如果数组中每个元素都不相同，则返回 `false` 。

**示例 1:**

```
输入: [1,2,3,1]
输出: true
```

解答：

```java
    public boolean containsDuplicate(int[] nums) {
        //先进行排序
        Arrays.sort(nums);
        //排序后如果有重复数字肯定相邻
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1])
                return true;
        }
        return false;
    }
```

---

#### [219. 存在重复元素 II](https://leetcode-cn.com/problems/contains-duplicate-ii/)

给定一个整数数组和一个整数 *k*，判断数组中是否存在两个不同的索引 *i* 和 *j*，使得 **nums [i] = nums [j]**，并且 *i* 和 *j* 的差的 **绝对值** 至多为 *k*。

**示例 1:**

```
输入: nums = [1,2,3,1], k = 3
输出: true
```

解答：

```java
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int lastIndex=map.get(nums[i]);
                if(i-lastIndex<=k)
                    return true;
            }
            //不管存不存在都要更新下标，让两个下标最近
            map.put(nums[i],i);
        }
        return false;
    }
```

---

#### [243. 最短单词距离](https://leetcode-cn.com/problems/shortest-word-distance/)

给定一个单词列表和两个单词 *word1* 和 *word2*，返回列表中这两个单词之间的最短距离。

**示例:**
假设 words = `["practice", "makes", "perfect", "coding", "makes"]`

```
输入: word1 = “coding”, word2 = “practice”
输出: 3
输入: word1 = "makes", word2 = "coding"
输出: 1
```

解答：

```java
    public int shortestDistance(String[] words, String word1, String word2) {
        int index1=-1;//word1的下标
        int index2=-1;//word2的下标
        int min=Integer.MAX_VALUE;
        for(int i=0;i<words.length;i++){
            if(word1.equals(words[i]))
                index1=i;
            else if(word2.equals(words[i]))
                index2=i;
            //两个下标都存在
            if(index1!=-1&&index2!=-1){
                min=Math.min(min,Math.abs(index1-index2));
            }
        }       
        return min;
    }
```

---

#### [268. 缺失数字](https://leetcode-cn.com/problems/missing-number/)

给定一个包含 `0, 1, 2, ..., n` 中 *n* 个数的序列，找出 0 .. *n* 中没有出现在序列中的那个数。

**示例 1:**

```
输入: [3,0,1]
输出: 2
```

解答：

```java
    public int missingNumber(int[] nums) {
        //排序
        Arrays.sort(nums);
        //数值0~n，索引0~n-1，如果索引不等于自己对应值说明该值缺失
        for(int i=0;i<nums.length;i++){
            if(i!=nums[i])
                return i;
        }
        return nums.length;
    }
```

---

#### [283. 移动零](https://leetcode-cn.com/problems/move-zeroes/)

给定一个数组 `nums`，编写一个函数将所有 `0` 移动到数组的末尾，同时保持非零元素的相对顺序。

**示例:**

```
输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
```

**说明**:

1. 必须在原数组上操作，不能拷贝额外的数组。
2. 尽量减少操作次数。

解答：

```java
    public void moveZeroes(int[] nums) {
        int index=0;//非0元素下标
        for(int n:nums){
            if(n!=0)
                nums[index++]=n;
        }
        //末尾填充0
        for(int i=index;i<nums.length;i++)
            nums[i]=0;
    }
```

---

#### [414. 第三大的数](https://leetcode-cn.com/problems/third-maximum-number/)

给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。

**示例 1:**

```
输入: [3, 2, 1]

输出: 1

解释: 第三大的数是 1.
```

解答：

```java
    public int thirdMax(int[] nums) {
        //对数组排序
        Arrays.sort(nums);
        //长度小于3，直接返回最大元素
        if(nums.length<3)
            return nums[nums.length-1];
        //计数器为3时，返回该元素
        int count=1;
        int pre=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]!=pre){
                count++;
                pre=nums[i];
            }
            if(count==3)
                return nums[i];
        }
        //未找到，直接返回最大元素
        return nums[nums.length-1];
    }
```

---

#### [448. 找到所有数组中消失的数字](https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/)

给定一个范围在 1 ≤ a[i] ≤ *n* ( *n* = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。

找到所有在 [1, *n*] 范围之间没有出现在数组中的数字。

您能在不使用额外空间且时间复杂度为*O(n)*的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。

**示例:**

```
输入:
[4,3,2,7,8,2,3,1]

输出:
[5,6]
```

解答：

```java
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //如果一个数字n存在，就将其对应下标n-1（因为数字从1开始）设为负数
        //负数的含义是该数字存在，计算时只需要取绝对值计算即可
        for(int i=0;i<nums.length;i++){
            //当前数字对应的下标
            int index=Math.abs(nums[i])-1;
            //如果对应下标的还不是负数，更改它
            if(nums[index]>0)
                nums[index]=-nums[index];
        }
        //遍历数组，如果对应位置n是正数，代表对应的n+1不存在
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                result.add(i+1);
        }
        return result;
    }
```

---

#### [485. 最大连续1的个数](https://leetcode-cn.com/problems/max-consecutive-ones/)

给定一个二进制数组， 计算其中最大连续1的个数。

**示例 1:**

```
输入: [1,1,0,1,1,1]
输出: 3
解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
```

解答：

```java
   	//类似169题
	public int findMaxConsecutiveOnes(int[] nums) {
        int temp=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                temp++;
            }else
                temp=0;
            if(temp>max)
                max=temp;
        }
        return max;
    }
```

---

#### [509. 斐波那契数](https://leetcode-cn.com/problems/fibonacci-number/)

**斐波那契数**，通常用 `F(n)` 表示，形成的序列称为**斐波那契数列**。该数列由 `0` 和 `1` 开始，后面的每一项数字都是前面两项数字的和。也就是：

```
F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
```

给定 `N`，计算 `F(N)`。

**示例 1：**

```
输入：2
输出：1
解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
```

解答：

```java
    public int fib(int N) {
        //简单的动态规划
        int[] f=new int[N+1];
        if(N==0||N==1)
            return N;
        f[0]=0;
        f[1]=1;
        for(int n=2;n<=N;n++)
            f[n]=f[n-1]+f[n-2];
        return f[N];
    }
```

---

#### [532. 数组中的K-diff数对](https://leetcode-cn.com/problems/k-diff-pairs-in-an-array/)

给定一个整数数组和一个整数 **k**, 你需要在数组里找到**不同的** k-diff 数对。这里将 **k-diff** 数对定义为一个整数对 (i, j), 其中 **i** 和 **j** 都是数组中的数字，且两数之差的绝对值是 **k**.

**示例 1:**

```
输入: [3, 1, 4, 1, 5], k = 2
输出: 2
解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
尽管数组中有两个1，但我们只应返回不同的数对的数量。
```

**示例 2:**

```
输入:[1, 2, 3, 4, 5], k = 1
输出: 4
解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
```

解答：

```java
    public int findPairs(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        //排序，顺序遍历防止重复
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                //如果满足条件且不存在于结果集
                if(nums[j]-nums[i]==k&&!set.contains(nums[i])){
                    set.add(nums[i]);
                    break;
                }
                if(nums[j]-nums[i]>k)
                    break;
            }
        }
        return set.size();
    }
```

---

#### [561. 数组拆分 I](https://leetcode-cn.com/problems/array-partition-i/)

给定长度为 **2n** 的数组, 你的任务是将这些数分成 **n** 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。

**示例 1:**

```
输入: [1,4,3,2]

输出: 4
解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
```

解答：

```java
    public int arrayPairSum(int[] nums) {
        //直接排序即可
        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i<nums.length;i+=2)
            sum+=nums[i];
        return sum;
    }
```

---

#### [566. 重塑矩阵](https://leetcode-cn.com/problems/reshape-the-matrix/)

在MATLAB中，有一个非常有用的函数 `reshape`，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。

给出一个由二维数组表示的矩阵，以及两个正整数`r`和`c`，分别表示想要的重构的矩阵的行数和列数。

重构后的矩阵需要将原始矩阵的所有元素以相同的**行遍历顺序**填充。

如果具有给定参数的`reshape`操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。

**示例 1:**

```
输入: 
nums = 
[[1,2],
 [3,4]]
r = 1, c = 4
输出: 
[[1,2,3,4]]
解释:
行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
```

解答：

```java
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int oldR=nums.length;
        int oldC=nums[0].length;
        //如果大小不等，返回原矩阵
        if(oldR*oldC!=r*c)
            return nums;
        int row=0;
        int col=0;
        int index=0;
        int[][] newNums=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                //如果列到达末尾，行下移1，列置0
                if(col==oldC){
                    row++;
                    col=0;
                }
                //按行遍历，每次移动列
                newNums[i][j]=nums[row][col++];
            }
        }
        return newNums;
    }
```

---

#### [581. 最短无序连续子数组](https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/)

给定一个整数数组，你需要寻找一个**连续的子数组**，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

你找到的子数组应是**最短**的，请输出它的长度。

**示例 1:**

```
输入: [2, 6, 4, 8, 10, 9, 15]
输出: 5
解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
```

解答：

```java
    public int findUnsortedSubarray(int[] nums) {
        //克隆数组并排序，比较对应位置
        int[] arr=nums.clone();
        Arrays.sort(arr);
        int start=nums.length;
        int end=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=arr[i]){
                //开始位置取最小的
                start=Math.min(start,i);
                //结束位置取最大的
                end=Math.max(end,i);
            }
        }
        return end>=start?end-start+1:0;
    }
```

---

#### [605. 种花问题](https://leetcode-cn.com/problems/can-place-flowers/)

假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。

给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 **n** 。能否在不打破种植规则的情况下种入 **n** 朵花？能则返回True，不能则返回False。

**示例 1:**

```
输入: flowerbed = [1,0,0,0,1], n = 1
输出: True
```

解答：

```java
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count=0;
        for(int i=0;i<flowerbed.length;i++){
            //当前位置是0，并且前面是0（或是首位），并且后面是0（或是末尾），就可以种花
            if(flowerbed[i]==0&&(i==0||flowerbed[i-1]==0)&&(i==flowerbed.length-1||flowerbed[i+1]==0)){
                count++;
                //当前位置种花，下一个肯定不能种，所以再额外跳过一个单位
                flowerbed[i++]=1;
            }
            if(count>=n)
                return true;
        }
        return count>=n;
    }
```

---

#### [624. 数组列表中的最大距离](https://leetcode-cn.com/problems/maximum-distance-in-arrays/)

给定 `m` 个数组，每个数组都已经按照升序排好序了。现在你需要从两个不同的数组中选择两个整数（每个数组选一个）并且计算它们的距离。两个整数 `a` 和 `b` 之间的距离定义为它们差的绝对值 `|a-b|` 。你的任务就是去找到最大距离

**示例 1：**

```
输入： 
[[1,2,3],
 [4,5],
 [1,2,3]]
输出： 4
解释：
一种得到答案 4 的方法是从第一个数组或者第三个数组中选择 1，同时从第二个数组中选择 5 。
```

解答：

```java
    public int maxDistance(List<List<Integer>> arrays) {
        int max=0;
        //之前列表的最小和最大元素，用第一个数组列表初始化
        int preMin=arrays.get(0).get(0);
        int preMax=arrays.get(0).get(arrays.get(0).size()-1);
        for(int i=1;i<arrays.size();i++){
            List<Integer> nowList=arrays.get(i);
            int nowMin=nowList.get(0);
            int nowMax=nowList.get(nowList.size()-1);
            //更新最大值
            int n1=nowMax-preMin;
            int n2=preMax-nowMin;
            max=Math.max(max,Math.max(n1,n2));
            //更新当前的最小值和最大值
            preMin=Math.min(preMin,nowMin);
            preMax=Math.max(preMax,nowMax);
        }
        return max;
    }
```

---

#### [628. 三个数的最大乘积](https://leetcode-cn.com/problems/maximum-product-of-three-numbers/)

给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。

**示例 1:**

```
输入: [1,2,3]
输出: 6
```

解答：

```java
    public int maximumProduct(int[] nums) {
        //如果只有3个数，直接相乘返回
        if(nums.length==3)
            return nums[0]*nums[1]*nums[2];
        //从小到大，从负到正排序
        Arrays.sort(nums);
        int len=nums.length-1;
        //要么是3个正数最大，就是末尾3个数
        int n1=nums[len]*nums[len-1]*nums[len-2];
        //要么2个最小负数和1个最大整数
        int n2=nums[0]*nums[1]*nums[len];
        return Math.max(n1,n2);
    }
```

---

#### [643. 子数组最大平均数 I](https://leetcode-cn.com/problems/maximum-average-subarray-i/)

给定 `n` 个整数，找出平均数最大且长度为 `k` 的连续子数组，并输出该最大平均数。

**示例 1:**

```
输入: [1,12,-5,-6,50,3], k = 4
输出: 12.75
解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
```

解答：

```java
    public double findMaxAverage(int[] nums, int k) {
        //初始滑动窗口的起始和结束位置
        int start=0;
        int end=k-1;       
        int sum=0;
        for(int i=start;i<=end;i++)
                sum+=nums[i]; 
        double max=sum*1.0/k;    
        while(end<nums.length-1){
            //新的窗口减去旧值的第一个，并使其前进一个单位
            sum-=nums[start++];
            //新的窗口移动一位，加上下一个新值
            sum+=nums[++end];
            max=Math.max(max,sum*1.0/k);    
        }
        return max;
    }
```

---

#### [661. 图片平滑器](https://leetcode-cn.com/problems/image-smoother/)

包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。

**示例 1:**

```
输入:
[[1,1,1],
 [1,0,1],
 [1,1,1]]
输出:
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
解释:
对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
```

解答：

```java
    public int[][] imageSmoother(int[][] M) {
        int[][] res=new int[M.length][M[0].length];
        for(int i=0;i<M.length;i++){
            for(int j=0;j<M[0].length;j++){
                res[i][j]=change(M,i,j);
            }
        }
        return res;
    }

    public int change(int[][] M,int i,int j){
        int count=1;
        int sum=M[i][j];        
        if(i>=1){//上
            count++;
            sum+=M[i-1][j];
            if(j>=1){//上左
                count++;
                sum+=M[i-1][j-1];
            }
            if(j<M[0].length-1){//上右
                count++;
                sum+=M[i-1][j+1];
            }
        }
        if(i<M.length-1){//下
            count++;
            sum+=M[i+1][j];
            if(j>=1){//下左
                count++;
                sum+=M[i+1][j-1];
            }
            if(j<M[0].length-1){//下右
                count++;
                sum+=M[i+1][j+1];
            }
        }
        if(j>=1){//左
            count++;
            sum+=M[i][j-1];
        }
        if(j<M[0].length-1){//右
            count++;
            sum+=M[i][j+1];
        }
        return sum/count;
    }
```

---

#### [665. 非递减数列](https://leetcode-cn.com/problems/non-decreasing-array/)

给你一个长度为 `n` 的整数数组，请你判断在 **最多** 改变 `1` 个元素的情况下，该数组能否变成一个非递减数列。

我们是这样定义一个非递减数列的： 对于数组中所有的 `i` (1 <= i < n)，总满足 `array[i] <= array[i + 1]`。

**示例 1:**

```
输入: nums = [4,2,3]
输出: true
解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
```

**示例 2:**

```
输入: nums = [4,2,1]
输出: false
解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
```

解答：

```java
    public boolean checkPossibility(int[] nums) {
        //计数器
        int count=0;
        //前一个元素值
        int pre=Integer.MIN_VALUE;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                if(++count>1)
                    return false;
                //当前元素的下一个小于当前元素的上一个，为保证非递减，最小应将其设置为当前元素值
                //例如把2，3，1更新为2，3，3
                if(nums[i+1]<pre)
                    nums[i+1]=nums[i];
                else//否则只需要把当前元素更新为下一个元素的值，例如2，4，3更新为2，3，3
                    nums[i]=nums[i+1];
            }
            pre=nums[i];
        }
        return true;
    }
```

---

#### [674. 最长连续递增序列](https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/)

给定一个未经排序的整数数组，找到最长且**连续**的的递增序列。

**示例 1:**

```
输入: [1,3,5,4,7]
输出: 3
解释: 最长连续递增序列是 [1,3,5], 长度为3。
尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。 
```

**示例 2:**

```
输入: [2,2,2,2,2]
输出: 1
解释: 最长连续递增序列是 [2], 长度为1。
```

解答：

```java
    public int findLengthOfLCIS(int[] nums) {
        int max=0;
        int temp=0;
        int pre=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>pre){//比前一个大拼起来
                temp++;
            }else{
                temp=1;//重新计算
            }
            max=Math.max(max,temp);//更新最大值
            pre=nums[i];//更新前一个数
        }
        return max;
    }
```

---

#### [697. 数组的度](https://leetcode-cn.com/problems/degree-of-an-array/)

给定一个非空且只包含非负数的整数数组 `nums`, 数组的度的定义是指数组里任一元素出现频数的最大值。

你的任务是找到与 `nums` 拥有相同大小的度的最短连续子数组，返回其长度。

**示例 1:**

```
输入: [1, 2, 2, 3, 1]
输出: 2
解释: 
输入数组的度是2，因为元素1和2的出现频数最大，均为2.
连续子数组里面拥有相同度的有如下所示:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
最短连续子数组[2, 2]的长度为2，所以返回2.
```

解答：

```java
    public int findShortestSubArray(int[] nums) {
        int maxTime=0;
        //保存当前元素的出现次数
        HashMap<Integer,Integer> map=new HashMap<>();
        //保存当前元素的起始和末尾位置
        HashMap<Integer,Info> map2=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            //更新当前元素的出现次数
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            //更新最大次数
            maxTime=Math.max(maxTime,map.get(nums[i]));
            if(!map2.containsKey(nums[i]))//如果还没保存当前元素的位置信息
                map2.put(nums[i],new Info(i,i));//设置初始位置和结束位置都为当前位置
            else{
                map2.get(nums[i]).end=i;//更新最后出现的位置
            }
        }
        int min=nums.length;
        for(int n:nums){
            //如果当前元素出现次数符合最大次数，计算其长度并更新
            if(map.get(n)==maxTime){
                Info info = map2.get(n);
                int dis=info.end-info.start+1;
                if(dis<min)
                    min=dis;
            }
        }
        return min;
    }

    static class Info{
        int start;
        int end;

        public Info(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
```

---

#### [746. 使用最小花费爬楼梯](https://leetcode-cn.com/problems/min-cost-climbing-stairs/)

数组的每个索引做为一个阶梯，第 `i`个阶梯对应着一个非负数的体力花费值 `cost[i]`(索引从0开始)。

每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。

您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。

**示例 1:**

```
输入: cost = [10, 15, 20]
输出: 15
解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
```

解答：

```java
    public int minCostClimbingStairs(int[] cost) {
        //动态规划
        int[] dp=new int[cost.length];
        //初始化
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<dp.length;i++){
            //从前2个爬2级或者到前1级即可
            dp[i]=Math.min(dp[i-2],dp[i-1])+cost[i];
        }
        //达到最后一个或倒数第二个即可
        return Math.min(dp[dp.length-1],dp[dp.length-2]);
    }
```

---

#### [747. 至少是其他数字两倍的最大数](https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/)

在一个给定的数组`nums`中，总是存在一个最大元素 。

查找数组中的最大元素是否至少是数组中每个其他数字的两倍。

如果是，则返回最大元素的索引，否则返回-1。

**示例 1:**

```
输入: nums = [3, 6, 1, 0]
输出: 1
解释: 6是最大的整数, 对于数组中的其他整数,
6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
```

解答：

```java
    public int dominantIndex(int[] nums) {
        //长度1返回第一个位置
        if(nums.length==1)
            return 0;
        //保存原数组
        int[] arr=nums.clone();
        //排序
        Arrays.sort(nums);
        //找到最大值
        int max=nums[nums.length-1];
        //如果最大值不是次大值的2倍代表寻找失败
        if(max<2*nums[nums.length-2])
            return -1;
        //如果存在就在复制数组找到对应下标
        for(int i=0;i<arr.length;i++){
            if(arr[i]==max)
                return i;
        }
        return -1;
    }
```

---

## 链表

#### [2. 两数相加](https://leetcode-cn.com/problems/add-two-numbers/)

给出两个 **非空** 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 **逆序** 的方式存储的，并且它们的每个节点只能存储 **一位** 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

**示例：**

```
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
```

解答：

```java
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre=new ListNode(-1);
        ListNode cur=pre;
        int carry=0;
        while(l1!=null||l2!=null){
            int sum=carry;
            sum+=l1==null?0:l1.val;
            sum+=l2==null?0:l2.val;
            //创建新节点并前移
            cur.next=new ListNode(sum%10);
            cur=cur.next;
            //计算进位
            carry=sum/10;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        if(carry==1)//还有进位就创建一个新节点
            cur.next=new ListNode(1);
        return pre.next;
    }
```

---

#### [19. 删除链表的倒数第N个节点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)

给定一个链表，删除链表的倒数第 *n* 个节点，并且返回链表的头结点。

**示例：**

```
给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
```

解答：

```java
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre=new ListNode(-1);
        pre.next=head;
        //定义快慢指针，让快指针先走n个
        ListNode slow=pre;
        ListNode fast=pre;
        for(int i=0;i<n;i++)
            fast=fast.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return pre.next;
    }
```

---

#### [21. 合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)

将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

**示例：**

```
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
```

解答：

```java
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre=new ListNode(-1);
        ListNode cur=pre;//遍历指针
        //下一个节点是l1和l2的较小节点
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        //l1和l2最多只有一个剩余，l1为空就指向l2，反之
        cur.next=l1==null?l2:l1;
        return pre.next;
    }
```

---

#### [24. 两两交换链表中的节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs/)

给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

**你不能只是单纯的改变节点内部的值**，而是需要实际的进行节点交换。

**示例:**

```
给定 1->2->3->4, 你应该返回 2->1->4->3.
```

解答：

```java
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
            return head;
        //保存当前节点和下一个节点
        ListNode first=head;
        ListNode second=head.next;
        //将下一个节点作为头节点返回，当前节点递归连接
        first.next=swapPairs(second.next);
        second.next=first;
        return second;
    }
```

---

#### [61. 旋转链表](https://leetcode-cn.com/problems/rotate-list/)

给定一个链表，旋转链表，将链表每个节点向右移动 *k* 个位置，其中 *k* 是非负数。

**示例 1:**

```
输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL
```

解答：

```java
    //右移k个位置，相当于在倒数第k个位置断开，将末尾连上头节点，将倒数第k个节点作为结果返回
	public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null)
            return head;
        //防止越界，先计算k%链表长度
        k=k%len(head);
        //找到倒数第k+1个节点
        ListNode node=kthToLast(head,k+1);
        ListNode end=node;
        //找到末尾节点
        while(end!=null&&end.next!=null)
            end=end.next;
        //末尾连接头
        end.next=head;
        //倒数第k+1个节点断开连接，返回倒数第k个节点
        ListNode res=node.next;
        node.next=null;
        return res;
    }

	//计算链表长度
    public int len(ListNode head){
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }

	//返回倒数第k个节点
    public ListNode kthToLast(ListNode head, int k) {
        ListNode pre=new ListNode(-1);
        pre.next=head;
        //定义快慢指针，让快指针先走k个
        ListNode slow=pre;
        ListNode fast=pre;
        for(int i=0;i<k;i++)
            fast=fast.next;
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
```

---

#### [82. 删除排序链表中的重复元素 II](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/)

给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 *没有重复出现* 的数字。

**示例 1:**

```
输入: 1->2->3->3->4->4->5
输出: 1->2->5
```

**示例 2:**

```
输入: 1->1->1->2->3
输出: 2->3
```

解答：

```java
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;
        //建立头节点的前驱节点
        ListNode pre=new ListNode(-1);
        ListNode res=pre;//因为要移动pre，用res保存pre的初始位置
        pre.next=head;//与头节点连接
        ListNode cur=head;//遍历节点
        ListNode last=head.next;//当前节点的下一个节点
        while(last!=null){
            if(cur.val==last.val){
                while(last!=null&&last.val==cur.val)
                    last=last.next;
                pre.next=last;
                if(last==null)//如果到达末尾
                    break;
                cur=pre.next;
            }else{
                pre=pre.next;
                cur=cur.next;                
            }
            last=last.next;
        }
        return res.next;
    }
```

---

#### [83. 删除排序链表中的重复元素](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/)

给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

**示例 1:**

```
输入: 1->1->2
输出: 1->2
```

**示例 2:**

```
输入: 1->1->2->3->3
输出: 1->2->3
```

解答：

```java
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return head;
        ListNode cur=head;//遍历指针
        while(cur!=null){
            //下一个节点和当前节点值相同就删除
            if(cur.next!=null&&cur.next.val==cur.val)
                cur.next=cur.next.next;
            else
                cur=cur.next;//否则向前移动一个单位
        }
        return head;
    }
```

---

#### [141. 环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)

给定一个链表，判断链表中是否有环。

为了表示给定链表中的环，我们使用整数 `pos` 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 `pos` 是 `-1`，则在该链表中没有环。

**示例 1：**

```
输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。
```

<img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist.png" alt="img" style="zoom:50%;" />

解答：

```java
    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        //定义快慢指针
        ListNode slow=head;
        ListNode fast=head;
        //如果快慢指针可以相遇，代表存在环
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                return true;
        }
        //快指针遍历到了null，说明不存在环
        return false;
    }
```

---

#### [160. 相交链表](https://leetcode-cn.com/problems/intersection-of-two-linked-lists/)

编写一个程序，找到两个单链表相交的起始节点。

如下面的两个链表**：**

[<img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_statement.png" alt="img" style="zoom:50%;" />](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_statement.png)

在节点 c1 开始相交。

 

**示例 1：**

[<img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_example_1.png" alt="img" style="zoom:50%;" />](https://assets.leetcode.com/uploads/2018/12/13/160_example_1.png)

```
输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Reference of the node with value = 8
输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
```

解答：

```java
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //双指针
        ListNode p=headA;
        ListNode q=headB;
        //A的指针遍历到头就从B开始，B的到头就从A开始，因为A+B长度一样，就会相遇
        while(p!=q){
            p=p==null?headB:p.next;
            q=q==null?headA:q.next;
        }
        return p;
    }
```

---

#### [203. 移除链表元素](https://leetcode-cn.com/problems/remove-linked-list-elements/)

删除链表中等于给定值 ***val\*** 的所有节点。

**示例:**

```
输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
```

解答：

```java
    //和83题类似
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre=new ListNode(-1);//建立首节点的前驱节点，因为首节点可能要被删除
        pre.next=head;
        ListNode cur=pre;//遍历指针
        while(cur!=null){
            if(cur.next!=null&&cur.next.val==val)
                cur.next=cur.next.next;
            else
                cur=cur.next;
        }
        return pre.next;
    }
```

---

#### [206. 反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)

反转一个单链表。

**示例:**

```
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
```

**进阶:**
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

解答：

```java
    //迭代
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;//前驱节点
        ListNode cur=head;//遍历节点
        ListNode last=null;//后继节点
        while(cur!=null){    
            last=cur.next;//保存下一个节点      
            cur.next=pre;           
            pre=cur;
            cur=last;
        }
        return pre;
    }

	//递归
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        //获取当前节点之后的反转结果
        ListNode newHead=reverseList(head.next);
        //让当前节点的后继节点的next指向自己
        head.next.next=head;
        //自己指向空
        head.next=null;
        //总是返回头
        return newHead;
    }
```

---

#### [234. 回文链表](https://leetcode-cn.com/problems/palindrome-linked-list/)

请判断一个链表是否为回文链表。

**示例 1:**

```
输入: 1->2
输出: false
```

**示例 2:**

```
输入: 1->2->2->1
输出: true
```

**进阶：**
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

解答：

```java
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)
            return true;
        ListNode halfEnd=getHalfEnd(head);//获取前半部分尾节点
        ListNode secondStart=reverseList(halfEnd.next);
        ListNode firstStart=head;
        boolean flag=true;
        while(flag&&secondStart!=null){
            if(secondStart.val!=firstStart.val)
                flag=false;
            firstStart=firstStart.next;
            secondStart=secondStart.next;
        }
        //恢复后半部分链表
        halfEnd.next=reverseList(secondStart);
        return flag;
    }

    //翻转链表
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;//前驱节点
        ListNode cur=head;//遍历节点
        ListNode last=null;//后继节点
        while(cur!=null){    
            last=cur.next;//保存下一个节点      
            cur.next=pre;           
            pre=cur;
            cur=last;
        }
        return pre;
    }

    //寻找前半链表的尾节点
    private ListNode getHalfEnd(ListNode head){
        if(head==null||head.next==null)
            return head;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
```

---

#### [237. 删除链表中的节点](https://leetcode-cn.com/problems/delete-node-in-a-linked-list/)

请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。

现有一个链表 -- head = [4,5,1,9]，它可以表示为:

<img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/01/19/237_example.png" alt="img" style="zoom:50%;" />

**示例 1:**

```
输入: head = [4,5,1,9], node = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
```

解答：

```java
    public void deleteNode(ListNode node) {
        //将下一个节点的值覆盖当前节点
        node.val=node.next.val;
        //删除下一个节点
        node.next=node.next.next;
    }
```

---

#### [876. 链表的中间结点](https://leetcode-cn.com/problems/middle-of-the-linked-list/)

给定一个带有头结点 `head` 的非空单链表，返回链表的中间结点。

如果有两个中间结点，则返回第二个中间结点。

**示例 1：**

```
输入：[1,2,3,4,5]
输出：此列表中的结点 3 (序列化形式：[3,4,5])
返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
注意，我们返回了一个 ListNode 类型的对象 ans，这样：
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
```

解答：

```java
    public ListNode middleNode(ListNode head) {
        if(head==null||head.next==null)
            return head;
        //快慢指针
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
```

---

#### [1290. 二进制链表转整数](https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/)

给你一个单链表的引用结点 `head`。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。

请你返回该链表所表示数字的 **十进制值** 。

**示例 1：**

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/12/15/graph-1.png)

```
输入：head = [1,0,1]
输出：5
解释：二进制数 (101) 转化为十进制数 (5)
```

解答：

```java
    public int getDecimalValue(ListNode head) {
        int res=0;
        while(head!=null){
            res=res*2+head.val;
            head=head.next;
        }
        return res;
    }
```

---

#### [面试题 02.01. 移除重复节点](https://leetcode-cn.com/problems/remove-duplicate-node-lcci/)

编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。

**示例1:**

```
 输入：[1, 2, 3, 3, 2, 1]
 输出：[1, 2, 3]
```

解答：

```java
    public ListNode removeDuplicateNodes(ListNode head) {
        HashSet<Integer> set=new HashSet<>();
        if(head==null)
            return head;
        ListNode cur=head;//遍历指针
        while(cur!=null){
            if(!set.contains(cur.val))
                set.add(cur.val);
            //下一个节点值已经存在于set集合
            if(cur.next!=null&&set.contains(cur.next.val))
                cur.next=cur.next.next;
            else
                cur=cur.next;//否则向前移动一个单位
        }
        return head;
    }
```

---

#### [面试题 02.02. 返回倒数第 k 个节点](https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/)

实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。

**示例：**

```
输入： 1->2->3->4->5 和 k = 2
输出： 4
```

**说明：**

给定的 *k* 保证是有效的。

解答：

```java
    public int kthToLast(ListNode head, int k) {
        ListNode pre=new ListNode(-1);
        pre.next=head;
        //定义快慢指针，让快指针先走k个
        ListNode slow=pre;
        ListNode fast=pre;
        for(int i=0;i<k;i++)
            fast=fast.next;
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow.val;
    }
```

---

#### [面试题 02.03. 删除中间节点](https://leetcode-cn.com/problems/delete-middle-node-lcci/)

实现一种算法，删除单向链表中间的某个节点（除了第一个和最后一个节点，不一定是中间节点），假定你只能访问该节点。

解答：和237题一样。

---

#### [面试题 02.06. 回文链表](https://leetcode-cn.com/problems/palindrome-linked-list-lcci/)

编写一个函数，检查输入的链表是否是回文的。

解答：和234题一样。

---

#### [面试题 02.07. 链表相交](https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/)

给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交。

解答：和160题一样。

---

#### [面试题18. 删除链表的节点](https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/)

给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

返回删除后的链表的头节点。

解答：和203题一样。

---

#### [面试题22. 链表中倒数第k个节点](https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/)

输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。

**示例：**

```
给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.
```

解答：和面试题02.02一样。

---

#### [面试题24. 反转链表](https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/)

定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

解答：和206题一样。

---

#### [面试题52. 两个链表的第一个公共节点](https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/)

输入两个链表，找出它们的第一个公共节点。

解答：和160题一样。

---

## 动态规划

#### [5. 最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/)

给定一个字符串 `s`，找到 `s` 中最长的回文子串。你可以假设 `s` 的最大长度为 1000。

**示例 1：**

```
输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
```

**示例 2：**

```
输入: "cbbd"
输出: "bb"
```

解答：

```java
    public String longestPalindrome(String s) {
        int length=s.length();
        if(length<2)//空串或单个字符肯定是回文串
            return s;
        int maxLen=1;//最长子串长度
        int start=0;//最长子串起始位置
        //用dp[i][j]表示i到j是否为回文串
        boolean[][] dp=new boolean[length][length];
        //初始化，所有单个字符肯定是回文串
        for(int i=0;i<length;i++)
            dp[i][i]=true;
        for(int j=1;j<length;j++){
            for(int i=0;i<j;i++){
                //只有子串首尾相等才可能是回文
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<3){//首尾相等，长度小于等于3，肯定是回文串
                        dp[i][j]=true;
                    }else
                        dp[i][j]=dp[i+1][j-1];//否则去掉首尾继续判断
                    if(dp[i][j]){//如果是回文，更新最长子串长度
                        maxLen=Math.max(maxLen,j-i+1);
                        start=i;
                    }
                }
            }
        }
        return s.substring(start,start+maxLen);
    }
```

---

#### [62. 不同路径](https://leetcode-cn.com/problems/unique-paths/)

一个机器人位于一个 *m x n* 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/robot_maze.png)

例如，上图是一个7 x 3 的网格。有多少可能的路径？

**示例 1:**

```
输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
```

**示例 2:**

```
输入: m = 7, n = 3
输出: 28
```

解答：

```java
    public int uniquePaths(int m, int n) {
        //m是列，n是行
        int[][] dp=new int[n][m];
        //到第一行和第一列的所有网格都是一种路径
        for(int i=0;i<n;i++)//初始化第一列
            dp[i][0]=1;
        for(int i=0;i<m;i++)//初始化第一行
            dp[0][i]=1;
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++)
                //到i，j的路径数量为到i-1，j的数量加上i，j-1的数量
                //即到某个网格的路径数量=到它左边或上边格子的数量，因为机器人只能右移或下移
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
        }
        return dp[n-1][m-1];
    }
```

---

#### [63. 不同路径 II](https://leetcode-cn.com/problems/unique-paths-ii/)

一个机器人位于一个 *m x n* 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/robot_maze.png)

网格中的障碍物和空位置分别用 `1` 和 `0` 来表示。

**说明：***m* 和 *n* 的值均不超过 100。

**示例 1:**

```
输入:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
输出: 2
解释:
3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右
```

解答：

```java
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1)
            return 0;
        int row=obstacleGrid.length;
        int col=obstacleGrid[0].length;
        int[][] dp=new int[row][col];
        //初始化第一行和第一列
        for(int i=0;i<col;i++){//初始化第一行,如果有阻塞将其设为0（表示不可达）并终止
            if(obstacleGrid[0][i]==0)
                dp[0][i]=1;
            else{
                dp[0][i]=0;
                break;
            }
        }
        for(int i=1;i<row;i++){//初始化第一列,从1开始因为0，0在初始化行时已经初始化了
            if(obstacleGrid[i][0]==0)
                dp[i][0]=1;
            else{
                dp[i][0]=0;
                break;
            }
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(obstacleGrid[i][j]==1)//此处有阻碍设为不可达
                    dp[i][j]=0;
                else
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[row-1][col-1];
    }
```

---

#### [64. 最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/)

给定一个包含非负整数的 *m* x *n* 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

**说明：**每次只能向下或者向右移动一步。

**示例:**

```
输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
```

解答：

```java
    public int minPathSum(int[][] grid) {
        //初始化第一行和第一列，因为只有一种走法，累加前一个数值即可
        for(int c=1;c<grid[0].length;c++){
            grid[0][c]+=grid[0][c-1];
        }
        for(int r=1;r<grid.length;r++){
            grid[r][0]+=grid[r-1][0];
        }
        //动态规划
        for(int r=1;r<grid.length;r++){
            for(int c=1;c<grid[0].length;c++){
                //累加左边和上面较小的值
                grid[r][c]+=Math.min(grid[r-1][c],grid[r][c-1]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
```

---

#### [70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)

假设你正在爬楼梯。需要 *n* 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

**注意：**给定 *n* 是一个正整数。

**示例 1：**

```
输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
```

**示例 2：**

```
输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶
```

解答：

```java
    public int climbStairs(int n) {
        //如果是1级或2级，直接返回1或2
        if(n==1||n==2)
            return n;
        int[] dp=new int[n];
        dp[0]=1;
        dp[1]=2;
        //大于2级，第i级的方法=第i-1级的方法＋第i-2级的方法
        for(int i=2;i<n;i++)
            dp[i]=dp[i-1]+dp[i-2];
        return dp[n-1];
    }
```

---

#### [91. 解码方法](https://leetcode-cn.com/problems/decode-ways/)

一条包含字母 `A-Z` 的消息通过以下方式进行了编码：

```
'A' -> 1
'B' -> 2
...
'Z' -> 26
```

给定一个只包含数字的**非空**字符串，请计算解码方法的总数。

**示例 1:**

```
输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
```

**示例 2:**

```
输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
```

解答：

```java
    public int numDecodings(String s) {
        if(s.charAt(0)=='0')//首字符为0，无效
            return 0;
        //初始化
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<dp.length;i++){
            //如果当前数字不为0，前面有多少种，当前就有多少种
            if(s.charAt(i-1)!='0')
                dp[i]+=dp[i-1];
            //如果当前数字和前一位可以组成两位有效数字，还要加上前2位的解码情况
            if(s.charAt(i-2)=='1'||(s.charAt(i-2)=='2'&&s.charAt(i-1)<='6'))
                dp[i]+=dp[i-2];
        }
        return dp[dp.length-1];
    }
```

---

#### [198. 打家劫舍](https://leetcode-cn.com/problems/house-robber/)

你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，**如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警**。

给定一个代表每个房屋存放金额的非负整数数组，计算你**在不触动警报装置的情况下，**能够偷窃到的最高金额。

**示例 1:**

```
输入: [1,2,3,1]
输出: 4
解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。
```

**示例 2:**

```
输入: [2,7,9,3,1]
输出: 12
解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
```

解答：

```java
    public int rob(int[] nums) {
        //没有房子偷不到钱
        if(nums.length==0)
            return 0;
        int[] dp=new int[nums.length+1];
        //初始化
        dp[0]=0;
        dp[1]=nums[0];
        for(int i=2;i<dp.length;i++){
            //偷到第i个屋子钱的最大值是偷到i-2个加上当前的（dp多了初始化0的位置，所以i对应nums里的i-1），或者偷到第i-1个的
            dp[i]=Math.max(dp[i-2]+nums[i-1],dp[i-1]);
        }
        return dp[dp.length-1];
    }
```

---

#### [256. 粉刷房子](https://leetcode-cn.com/problems/paint-house/)

假如有一排房子，共 *n* 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。

当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 `*n* x *3*` 的矩阵来表示的。

例如，`costs[0][0]` 表示第 0 号房子粉刷成红色的成本花费；`costs[1][2]` 表示第 1 号房子粉刷成绿色的花费，以此类推。请你计算出粉刷完所有房子最少的花费成本。

**注意：**

所有花费均为正整数。

**示例：**

```
输入: [[17,2,17],[16,16,5],[14,3,19]]
输出: 10
解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
     最少花费: 2 + 5 + 3 = 10。
```

解答：

```java
    public int minCost(int[][] costs) {
        int n=costs.length;
        //没有房子，花费0
        if(n==0)
            return 0;
        //n代表房子数，3代表三个颜色
        int[][] dp=new int[n][3];
        //初始化，第一个房子刷三个颜色的最小价钱
        dp[0][0]=costs[0][0];
        dp[0][1]=costs[0][1];
        dp[0][2]=costs[0][2];
        //动态规划
        for(int i=1;i<n;i++){
            //房子的颜色不能跟之前房子颜色相同
            dp[i][0]=costs[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1]=costs[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2]=costs[i][2]+Math.min(dp[i-1][0],dp[i-1][1]);
        }
        //找到最后一个房子涂完的最小值
        return Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2]));
    }
```

---

#### [276. 栅栏涂色](https://leetcode-cn.com/problems/paint-fence/)

有 k 种颜色的涂料和一个包含 n 个栅栏柱的栅栏，每个栅栏柱可以用其中一种颜色进行上色。

你需要给所有栅栏柱上色，并且保证其中相邻的栅栏柱 **最多连续两个** 颜色相同。然后，返回所有有效涂色的方案数。

**注意:**
n 和 k 均为非负的整数。

**示例:**

```
输入: n = 3，k = 2
输出: 6
解析: 用 c1 表示颜色 1，c2 表示颜色 2，所有可能的涂色方案有:

            柱 1    柱 2   柱 3     
 -----      -----  -----  -----       
   1         c1     c1     c2 
   2         c1     c2     c1 
   3         c1     c2     c2 
   4         c2     c1     c1  
   5         c2     c1     c2
   6         c2     c2     c1
```

解答：

```java
    public int numWays(int n, int k) {      
        if(n==0||k==0)//如果栏杆或颜色为0，方案数为0
            return 0;       
        if(n==1)//如果栏杆1个，自然有k种方案
            return k;
        if(n==2)//如果栏杆2个，允许两个重复，就有k²种方案
            return k*k;
        //如果栏杆数大于2，动态规划
        int[] dp=new int[n];
        //初始化
        dp[0]=k;
        dp[1]=k*k;
        for(int i=2;i<n;i++){
            //可以选择和上一个栏杆颜色一样，有dp[i-1]*(k-1)种方案,少了一种是因为要和i-2的颜色不同
            //也可以选择和上一个栏杆颜色不一样，有dp[i-2]*(k-1)种方案，少了一种是因为要和i-1的颜色不同
            dp[i]=dp[i-1]*(k-1)+dp[i-2]*(k-1);
        }
        return dp[n-1];
    }
```

---

#### [303. 区域和检索 - 数组不可变](https://leetcode-cn.com/problems/range-sum-query-immutable/)

给定一个整数数组  *nums*，求出数组从索引 *i* 到 *j* (*i* ≤ *j*) 范围内元素的总和，包含 *i, j* 两点。

**示例：**

```
给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
```

**说明:**

1. 你可以假设数组不可变。
2. 会多次调用 *sumRange* 方法。

解答:

```java
class NumArray {

    int[] arr;

    public NumArray(int[] nums) {
        arr=new int[nums.length+1];
        arr[0]=0;//初始化，防止i为0减1越界
        help(nums);
    }
    
    public int sumRange(int i, int j) {
        //从i到j的和相当于从0到j的和减去从0到i-1的和
        return arr[j+1]-arr[i];
    }

    //计算从0到n的和并存入arr
    public void help(int[] nums){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            arr[i+1]=sum;
        }
    }
}
```

---

#### [392. 判断子序列](https://leetcode-cn.com/problems/is-subsequence/)

给定字符串 **s** 和 **t** ，判断 **s** 是否为 **t** 的子序列。

你可以认为 **s** 和 **t** 中仅包含英文小写字母。字符串 **t** 可能会很长（长度 ~= 500,000），而 **s** 是个短字符串（长度 <=100）。

字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，`"ace"`是`"abcde"`的一个子序列，而`"aec"`不是）。

**示例 1:**
**s** = `"abc"`, **t** = `"ahbgdc"`

返回 `true`.

**示例 2:**
**s** = `"axc"`, **t** = `"ahbgdc"`

解答：

```java
    public boolean isSubsequence(String s, String t) {
        int index=-1;
        for(int i=0;i<s.length();i++){
            //每次从index的下一个位置开始匹配查找
            index=t.indexOf(s.charAt(i),index+1);
            if(index==-1)
                return false;
        }
        return true;
    }
```

---

#### [1025. 除数博弈](https://leetcode-cn.com/problems/divisor-game/)

爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。

最初，黑板上有一个数字 `N` 。在每个玩家的回合，玩家需要执行以下操作：

- 选出任一 `x`，满足 `0 < x < N` 且 `N % x == 0` 。
- 用 `N - x` 替换黑板上的数字 `N` 。

如果玩家无法执行这些操作，就会输掉游戏。

只有在爱丽丝在游戏中取得胜利时才返回 `True`，否则返回 `false`。假设两个玩家都以最佳状态参与游戏。

**示例 1：**

```
输入：2
输出：true
解释：爱丽丝选择 1，鲍勃无法进行操作。
```

**示例 2：**

```
输入：3
输出：false
解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
```

解答：

```java
    public boolean divisorGame(int N) {
        //N为2时，爱丽丝赢，N为3时，爱丽丝输，因此N为4时，爱丽丝选1，相当于N=3鲍勃输，自己可以赢
        //偶数时可以赢
        return N%2==0;
    }
```

---

#### [面试题 08.01. 三步问题](https://leetcode-cn.com/problems/three-steps-problem-lcci/)

三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。

**示例1:**

```
 输入：n = 3 
 输出：4
 说明: 有四种走法
```

**示例2:**

```
 输入：n = 5
 输出：13
```

解答：

```java
    public int waysToStep(int n) {
        if(n==1)//一层楼1种走法，1
            return 1;
        if(n==2)//两层楼2种走法，1 1，2
            return 2;
        if(n==3)//三层楼4种走法，1 1 1，1 2，2 1，3
            return 4;
        //n层楼走法=n-1层走法+n-2层走法+n-3层走法
        int[] dp=new int[n];
        dp[0]=1;
        dp[1]=2;
        dp[2]=4;
        int mod=1000000007;
        for(int i=3;i<n;i++)
            dp[i]=((dp[i-1]%mod+dp[i-2]%mod)%mod+dp[i-3]%mod)%mod;
        return dp[n-1];
    }
```

---

#### [面试题 16.17. 连续数列](https://leetcode-cn.com/problems/contiguous-sequence-lcci/)

给定一个整数数组，找出总和最大的连续数列，并返回总和。

**示例：**

```
输入： [-2,1,-3,4,-1,2,1,-5,4]
输出： 6
解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
```

解答：

```java
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int temp=nums[0];
        for(int i=1;i<nums.length;i++){
            if(temp<0)
                temp=nums[i];
            else
                temp+=nums[i];
            if(temp>max)
                max=temp;
        }
        return max;
    }
```

---

#### [面试题 17.16. 按摩师](https://leetcode-cn.com/problems/the-masseuse-lcci/)

一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。

**示例 1：**

```
输入： [1,2,3,1]
输出： 4
解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
```

**示例 2：**

```
输入： [2,7,9,3,1]
输出： 12
解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
```

解答：和198题一样。

---

#### [面试题42. 连续子数组的最大和](https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/)

输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

解答：和面试题16.17.一样。

---



