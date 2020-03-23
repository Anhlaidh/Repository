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

### 国际化

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