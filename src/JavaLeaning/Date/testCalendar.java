package JavaLeaning.Date;

import java.util.Calendar;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/13 0013 11:28
 */
public class testCalendar {
    Calendar calendar = Calendar.getInstance();
     void test1(){
        int year = calendar.get(Calendar.YEAR);//获取年
        int month = calendar.get(Calendar.MONTH);//获取月
        int day = calendar.get(Calendar.DAY_OF_MONTH);//获取日
        int hour = calendar.get(Calendar.HOUR);//获取时
        int minute = calendar.get(Calendar.MINUTE);//获取分
        int second = calendar.get(Calendar.SECOND);//获取秒
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);//星期，英语国家星期从星期日开始计算
        System.out.println("现在是"+year+"年"+month+"月"+day+"日"+hour+"时"+minute+"分"+second+"秒---"+"星期"+(weekday-1));


    }
    public static void main(String[] args) {
         testCalendar testCalendar = new testCalendar();
         testCalendar.test1();


    }
}
