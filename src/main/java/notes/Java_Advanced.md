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

