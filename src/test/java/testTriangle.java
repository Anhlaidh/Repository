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
