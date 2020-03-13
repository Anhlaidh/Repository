package robot;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/10 0010 17:50
 */
public class chu {


    public static void main(String[] args) throws AWTException {
        Robot ZhaoWenHao = new Robot();


        Point p = MouseInfo.getPointerInfo().getLocation();
        System.out.println(p.x+"  "+p.y);
//        ZhaoWenHao.mouseMove(1142,537);
        ZhaoWenHao.mouseMove(1132,548);
//        if (color.getRGB()!=)

        ZhaoWenHao.mouseMove(1132,548);
        Color color = ZhaoWenHao.getPixelColor(1132,548);
        ZhaoWenHao.delay(200);

        while (true){
            Random random = new Random();
            ZhaoWenHao.delay(random.nextInt(5));
//            if (!(color.getRed()==133&&color.getGreen()==141&color.getBlue()==140)) break;

            ZhaoWenHao.mouseMove(1142,537);
            ZhaoWenHao.delay(2000);
            ZhaoWenHao.mousePress(InputEvent.BUTTON1_DOWN_MASK);

            ZhaoWenHao.delay(random.nextInt(5));
            ZhaoWenHao.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        }
    }
}
