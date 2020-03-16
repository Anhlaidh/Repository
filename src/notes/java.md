# Java

## idea

- ctrl+shift+v:替换变量名
- ctrl+alt+v:抽取并赋值
- ctrl+p:查看参数
- ctrl+alt+o删除多余包
- ctrl+F12 查看当前类中的包
- ctrl+shift+enter 自动完成当前语句
- ctrl+shift+backspace 返回到上次修改位置
- alt+shift+F9 Debug

## 类转型&多态&契约设计

1. 类转型：子类可以转父类，父类不可以转子类（除非父类对象本身就是子类）
2. 多态：子类转型为父类后，调用普通方法，依旧是子类方法
3. 契约设计：类不会直接使用另一个类，而是采用接口的形式，外部可以“空投”这个接口下的任意子类对象

## static、final 和常量设计

### static

1. static 变量：不管有多少个对象，内存中只有一份
2. static 方法：可以使用类名直接引用，无需 new 对象来引用
   - 静态方法不可以调用动态变量
   - 非静态方法可以调用静态方法
   - 静态方法不可调用非静态方法
3. static 块：static 块只执行一次，并且 static 块>匿名块>构造函数

### 单例模式

1. 设计模式：是经过验证的、用于某些特定场合的解决方案
2. GOF 提出 23 中设计模式；创建型、结构性和行为型
3. 单例模式保证一个类在内存空间中只有一个对象
   - 内部初始化一个单例
   - private 不可见，getInstance(static 方法)来取出单例对象

### final

1. final 类：没有子类继承
2. final 方法：不能被子类改写（不能重写，可以重载）
3. final 字段：基本类型被能修改值，对象类型不能修改指针（可以修改内容）

### 常量&常量池

1. java 中的常量：static 和 final
2. Java 接口中的变量都是常量
3. 对象生成有两种：常量赋值（栈内存）和 new 创建（堆内存）
4. 常见包装类
   ![包装类](.java_images/2020-03-11-16-34-12.png)
5. java 编译器会优化已经确定的变量
6. 栈内存与堆内存运算会产生新的堆内存（存疑）

### 不可变对象

1. 不可变对象提高读效率
2. 不可变对象设计的方法
3. 字符串 append 操作速度：StringBuilder>StringBuffer>String

## Java 访问权限

![权限](.java_images/2020-03-11-17-43-27.png)

## Java 类库

### 数字类

1. 根据数字特点选择合适的类
2. 尽量使用类库自带的方法
3. 整数
   ![整数](.java_images/2020-03-12-17-36-09.png)

4. 浮点数需要注意精度
   ![浮点数](.java_images/2020-03-12-17-32-39.png)

5. BigInteger
   - 支持无限大的整数运算
     ![BigInteger](.java_images/2020-03-12-18-45-07.png)
6. BigDecimal -支持无限大的小数运算
   - 注意精度和截断
     ![BigDecimal](.java_images/2020-03-12-17-51-58.png)
7. 随机数

![随机数](.java_images/2020-03-11-18-08-16.png)

### 字符串类

1. String（不可变对象，只读）
2. StringBuffer（字符串加减，同步，性能好）
3. StringBuilder（字符串加减，不同步，性能更好）

### 时间类

1. 当前多数程序还是使用 calendar 类处理时间

![方法](.java_images/2020-03-11-18-07-28.png)
2. DateUtil，Instance 时间戳

### 格式化类

![格式化类](.java_images/2020-03-11-18-29-52.png)
1. NumberFormat
    ![DecimalFormat](.java_images/DecimalFormat.png)
2. MessageFormat
    ![MessageFormat](.java_images/MessageFormat.png)
3. DateFormat
    ![DateFormat](.java_images/DateFormat.png)
    ![DateFormat](.java_images/2020-03-11-20-00-15.png)
4. DateFormatter
    ![DateFormatter](.java_images/DateFormatter.png)
    ![DateFormatter](.java_images/DateFormatter.png)   
