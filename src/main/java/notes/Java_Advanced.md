# Java_Advanced

## Maven

## Junit

### 测试

- 单元测试：对软件中最小可测试单元进行检查和验证，通常是一个函数/方法（属于白盒测试）
    - 集成测试： 将多个单元相互作用，形成一个整体，对整体协调性进行测试

- 白盒测试： 全面了解程序内部逻辑结构，对所有的逻辑路径都进行测试，一般由程序员完成
    - 黑盒测试：又名功能测试，将程序看作不可打开的盒子，一般由独立使用者完成
    
- 自动测试：用程序批量、反复的测试程序，并可自动检查程序结果是否满足预定的要求
    - 手动测试：手动执行程序，手动输入所需要的参数，手动检查程序结果是否满足预定的要求

- 回归测试：修改旧代码后，重新进行测试以确认修改没有引入新的错误或导致其他代码产生错误

- 深入学习：软件测试-基于问题驱动模式 朱少民

#### Junit

- import static     导入该包内的所有静态方法，使用时可不加类名

- Triangle

```java
package JavaLearning_Advanced.Maven;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/23 0023 13:42
 */
public class Triangle {
    public boolean judgeEdges(int a, int b, int c) {
        boolean result = true;
        //边长非负性
        if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        }
        //两边和大于第三边
        if (a+b<=c) return false;
        if (b+c<=a) return false;
        if (c+a<=b) return false;

        return true;
    }
}

``` 
- testTriangle
```java
import JavaLearning_Advanced.Maven.Triangle;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/23 0023 13:44
 */
public class testTriangle {
    @Test
    public void test() {
        assertEquals(false,new Triangle().judgeEdges(1,2,3));
    }
}

```
- 深入学习：Junit实战（第二版），PetarTahchiey

## Java字符编码
- 尽可能使用UTF-8
- 读取写入编码保持一致

## 国际化

- Locale 方法
    - getAvailableLocales()获取所有可用的locale
    - getDefault()返回默认的Locale
    
- native2ascii.exe

- ResourceBundle
    - 根据Locale要求，加载语言文件
    - 存储语言集合中的K-V对
    - getString(String key) 返回对应的value
```java
package JavaLearning_Advanced.International;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/23 0023 14:34
 */
public class HelloWorld {
    public static void main(String[] args) {
        //取得系统默认的国家/语言环境
        Locale myLocale = Locale.getDefault();
        System.out.println(myLocale);//zh_CN
        //根据指定语言，国家环境，加载资源文件
        ResourceBundle bundle = ResourceBundle.getBundle("message", myLocale);
        //从资源文件中获取信息
        System.out.println(bundle.getString("hello"));

    }
}
```

## 高级字符编码

### 正则表达式

- 学习正则表达式：
精通正则表达式（第三版） Jefferry E.F.Friedl

- java.util.regex包
    - Pattern 正则表达式的编译表示
        - compile编译一个正则表达式喂Pattern对象
        - matcher用Pattern对象匹配一个字符串，返回匹配结果
    - Matcher
        - IndexMethod(位置方法) //start(),start(int group),end(),end(group)
        - StudyMethod(查找方法) //lookingAt(),find(),find(int start),matches() 
        - Replacement(替换方法) //replaceAll(String replacement)

Matcher
```java
package JavaLearning_Advanced.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/23 0023 19:21
 */
public class MatcherDemo {
    private static final String REGEX = "\\bdog\\b";//\b表示边界
    private static final String INPUT = "dog dog dog doggie dogg";

    public static void main(String[] args) {
        //检查字符串里有多少个dog
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(INPUT);
        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println("Match number" + count);
            System.out.println("start()" + matcher.start());
            System.out.println("end()" + matcher.end());
//        String f = "fooooooooooooo";
//        matcher.lookingAt();//不完全匹配,匹配foo为true
//        matcher.find();//完全匹配，匹配foo为false
        }
    }
}

```
Replace
```java
package JavaLearning_Advanced.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/23 0023 19:39
 */
public class ReplaceDemo {
    public static void Replace_1() {
        String REGEX = "a*b";//*表示限定前面的a可以有0个或者多个
        String INPUT = "aavfooabfooabafoobcdd";
        String REPLACE = "-";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(INPUT);
        StringBuffer stringBuffer = new StringBuffer();
        // 全部替换
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, REPLACE);
        }
        //最后将尾巴字符串附加上
        matcher.appendTail(stringBuffer);
        System.out.println(stringBuffer.toString());

    }

    public static void Replace_2() {
        String REGEX = "dog";//*表示限定前面的a可以有0个或者多个
        String INPUT = "The dog says meow.All dogs say meow";
        String REPLACE = "cat";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(INPUT);
        INPUT = matcher.replaceAll(REPLACE);
        System.out.println(INPUT);

    }
}

```

- OJ
```java
package JavaLearning_Advanced.regex;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/23 0023 19:55
 */
public class String2inputStream {
    public static void main(String[] args) {
        //构造字符串列表
        List<String> names = new LinkedList<>();
        names.add("xiaohong");
        names.add("xiaoming");
        names.add("Daming");
        names.add("xiaohei");
        //合并为一个字符串，以逗号相连
        String nameStr = String.join(",", names);
        //将字符串作为默认输入流
        InputStream in = IOUtils.toInputStream(nameStr, Charsets.toCharset("UTF-8"));
        //重置系统的输入流
        System.setIn(in);
        //模拟键盘输入，这也是OJ平台测试用例输入的原理
        //此处也可以换成一个文件的输入流
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(",");
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }
}
```

## xml

- 常规语法
    - 任何的起始标签都必须有一个结束标签
    - 简化写法，例如，<name></name>可以写为<name/>
    - 大小写敏感，name和Name不一样
    - 每个文件都要有一个根元素
    - 标签必须按合适的顺序进行嵌套，不可错位
    - 所有的特性都必须有值，且在值的周围加上引号
    - 需要转义字符，如"<"需要用&lt;代替
        - |转义 | 符号 | 意思 |
          | --- | --- | --- |
          |\&lt; | < | 小于|   
          |\&gt; | \> | 大于 |
          |\&amp;|&|和号|
          |\&apos;|'|单引号|
          |\&quot;|"|双引号|
    - 注释：&lt;!--  内容  -->

### xml解析

未完成


## JSON 

- 概念
    - JavaScript Object Notation ，JS对象表示法
    - 是一种轻量级的数据交换格式
    - 类似XML，更小、更快、更易解析
    - 最早用于JavaScript中，容易解析，最后推广到全语言
    - 尽管使用JavaScript语法，但是独立于编程语言
- 用途
    - JSON生成
    - JSON解析
    - JSON校验
    - 和JavaBean对象进行互解析
        - 具有一个无参的构造函数
        - 可以包括多个属性，所有属性都是private
        - 每个属性都有对应的Getter/Setter方法
        - JavaBean 用于封装数据，有可称为POJO(Plain Old Java Object)

```java
package JavaLearning_Advanced.Json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/26 0026 21:42
 */
public class testJackson {
    public static void main(String[] args) throws IOException {
        testJsonObject();
        System.out.println("分割线=====================================================");
        testJsonFile();

    }

    private static void testJsonFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        //从json文件中加载，并重构为java对象
        File json = new File("temp/json/books.json");
        List<Book> books = objectMapper.readValue(json, new TypeReference<List<Book>>() {
        });
        for (Book book : books) {
            System.out.println(book.getAuthor());
            System.out.println(book.getTitle());
        }

    }

    private static void testJsonObject() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        //构造对象
        Person person = new Person();
        person.setName("TOM");
        person.setAge(20);
        person.setScores(Arrays.asList(60, 70, 80));
        //将对象解析为json字符串
        String jsonStr = objectMapper.writeValueAsString(person);
        System.out.println(jsonStr);
        //json字符串重构对象
        Person p2 = objectMapper.readValue(jsonStr, Person.class);
        System.out.println(p2.getName());
        System.out.println(p2.getAge());
        System.out.println(p2.getScores());
        //从json字符串重构JsonNode对象
        JsonNode node = objectMapper.readTree(jsonStr);
        System.out.println(node.get("name").asText());
        System.out.println(node.get("age").asText());
        System.out.println(node.get("scores"));

    }
}
```
```json
[
  {
    "category": "COOKING",
    "title": "Everyday Italian",
    "author": "Giada De Laurentiis",
    "year": "2005",
    "price": 30
  },
  {
    "category": "CHILDREN",
    "title": "Harry Potter",
    "author": "J K Rowling",
    "year": "2005",
    "price": 29
  },
  {
    "category": "WEB",
    "title": "Learning XML",
    "author": "Erik T.Ray",
    "year": "2003",
    "price": 39
  }
]
```
        
- 总结
    - JSON是一种独立于编程语言的、轻量的、数据交换格式
    - 有多种第三方库辅助我们进行JSON生成和解析
    - JSON会丢失顺序性
    
## 图片
    - imageIO
    - 验证码
```java
package JavaLearning_Advanced.picture;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/28 0028 19:56
 */
public class ValidateCode {
    static char[] codeSequence= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','2','3','4','5','6','7','8','9'};
    static int charNum = codeSequence.length;
    public static void main(String[] args) throws IOException {
        generateCode("./temp/validateCode/code.jpg");
    }

    private static void generateCode(String filePath) throws IOException {
        //首先定义验证码图片库
        int width = 140;//验证码图片的宽度
        int height = 40;//验证码图片的高度
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //定义图片上的图形和干扰线
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(Color.GRAY);//将图像填充为浅灰色
        graphics2D.fillRect(0, 0, width, height);
        graphics2D.setColor(Color.BLACK);//画边框
        graphics2D.drawRect(0, 0, width - 1, height - 1);
        //随机产生16条灰色干扰线
        graphics2D.setColor(Color.darkGray);
        //创建一个随机数生成器类，用于随机产生干扰线
        Random random = new Random();
        for (int i = 0; i < 16; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(50);
            int y1 = random.nextInt(50);
            graphics2D.drawLine(x, y, x1, y1);

        }
        //计算字的位置坐标
        int codeCount = 4;//字的个数
        int fontHeight ;//字体高度
        int codeX;//第一个字符的x坐标，因为后面的字符坐标依次递增，所以他们的x轴值是codeX+i的值
        int codeY;//验证字符的y坐标，因为并排所以值一样
        //width-4除去左右多余的位置，使验证码更加集中显示，减的越多越集中
        //codeCount+1//等比分配显示的宽度，包括左右两边的空格
        codeX = (width - 4) / (codeCount + 1);//第一个字母的起始位置
        fontHeight = height - 10;//height-10高度中间区域显示验证码
        codeY = height - 7;
        //创建字体，字体的大小应该根据图片的高度来定
        Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);
        graphics2D.setFont(font);
        //随机产生codeCount数字的验证码
        for (int i = 0; i < codeCount; i++) {
            //每次随机拿一个字母，赋予随机的颜色
            String strRand = String.valueOf(codeSequence[random.nextInt(charNum)]);
            int red = random.nextInt(255);
            int blue = random.nextInt(255);
            int green = random.nextInt(255);
            graphics2D.setColor(new Color(red, green, blue));
            //把字放到图片上
            graphics2D.drawString(strRand, (i + 1) * codeX, codeY);
        }
        ImageIO.write(bufferedImage, "jpg", new File(filePath));

    }
}

```
## 多进程和多线程

### 概念

#### 多进程

- 当前的操作系统都是多任务OS
- 每个独立执行的任务就是一个进程
- OS将时间划分为多个时间片（时间很短）
- 每个时间片内将CPU分配给某一个任务，时间片结束，CPU自动回收，再分配给另外任务。从外部看，所有任务都是同时在执行。
但是在CPU上，任务是按照串行依次运行（单核CPU ）。如果多核，多个进程任务可以并行。但是单个核上，多进程只能串行执行
- 多进程的优点
    - 可以同时运行多个任务
    - 程序因IO堵塞时，可以释放CPU，让CPU为其他程序服务
    - 当系统有多个CPU时，可以为多个程序同时服务
        - 我们的CPU不再提高频率，而是提高核数
        - 多核和并行程序才是提高程序性能的唯一办法
- 多进程的缺点
    - 太笨重，不好管理
    - 太笨重，不好切换
    
#### 多线程

- 一个程序可以包括多个子任务，可串/并行
- 每个子任务可以称为一个线程
- 如果一个子任务阻塞，程序可以将CPU调度另外一个子任务进行工作，这样CPU还是保留在本程序中，而不是被调度到别的程序（进程）去，
这样，提高本程序获得CPU时间和利用率

##### 启动

- start方法，会自动以新进程调用run方法
- 直接调用run方法，会编程串行执行
- 同一个线程，多次start会报错，只执行第一次start方法
- 多个线程启动，其启动的先后顺序是随机的
- 线程无需关闭，只要其run方法执行结束后，自动关闭
- main函数（线程）可能早于新线程结束，整个程序并不终止
- 整个程序终止是等所有的线程都终止（包括main函数线程）

#### 多进程和多线程的对比

- 线程共享数据
- 线程通讯更高效
- 线程更轻量级，更容易切换
- 多个线程更容易管理

