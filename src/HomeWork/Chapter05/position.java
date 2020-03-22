package HomeWork.Chapter05;

import HomeWork.entity.point;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/21 0021 20:15
 */
public class position {
   public static point[] minPosition(point[] points){
        if (points.length<=2) return points;
       else {
            point[] left = Arrays.copyOfRange(points, 0, points.length / 2);
            point[] right = Arrays.copyOfRange(points, points.length / 2,points.length );
            System.out.println("left"+left);
            System.out.println("right"+right);
            return left;
        }


    }
    public static void main(String[] args) {
        point[] points = point.initPoint(100, 10);
        minPosition(points);

    }
}
