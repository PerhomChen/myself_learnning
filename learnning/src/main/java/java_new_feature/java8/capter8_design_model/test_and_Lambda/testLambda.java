package java_new_feature.java8.capter8_design_model.test_and_Lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

/**
 * @Author: Logan Chen
 * @date: 2019/10/30 17:37
 * @Description:
 */
public class testLambda {

    @Test
    public void testComparingTwoPoints() throws Exception {
        Point p1 = new Point(10, 15);
        Point p2 = new Point(10, 20);
        int result = Point.compareByXAndThenY.compare(p1 , p2);
        assertEquals(-1, result);
    }

    @Test
    public void testMoveAllPointsRightBy() throws Exception{
        List<Point> points =
                Arrays.asList(new Point(5, 5), new Point(10, 5));
        List<Point> expectedPoints =
                Arrays.asList(new Point(15, 5), new Point(20, 5));
        List<Point> newPoints = Point.moveAllPointsRightBy(points, 10);
        //使用断言进行测试
        assertEquals(expectedPoints, newPoints);
    }

    //对高阶函数进行测试，使用不同的lambda表达式进行测试
    @Test
    public void testFilter() throws Exception{
       /* List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> even = filter(numbers, i -> i % 2 == 0);
        List<Integer> smallerThanThree = filter(numbers, i -> i < 3);
        assertEquals(Arrays.asList(2, 4), even);
        assertEquals(Arrays.asList(1, 2), smallerThanThree);*/
    }
}

 class Point{
    public final static Comparator<Point> compareByXAndThenY =
            Comparator.comparing(Point::getX).thenComparing(Point::getY);

     private final int x;
     private final int y;
     public Point(int x, int y) {
         this.x = x;
         this.y = y;
     }
     public int getX() { return x; }
     public int getY() { return y; }
     public Point moveRightBy(int x){
         return new Point(this.x + x, this.y);
     }


     public static List<Point> moveAllPointsRightBy(List<Point> points, int x){
         return points.stream()
                 .map(p -> new Point(p.getX() + x, p.getY()))
                 .collect(toList());
     }

     @Test
     public void testMoveRightBy() throws Exception {
         Point p1 = new Point(5, 5);
         Point p2 = p1.moveRightBy(10);
         assertEquals(15, p2.getX());
         assertEquals(5, p2.getY());
     }
}


//总的来说，我们需要特别注意，涉及Lambda表达式的栈ᡱᢍ可能非常难理解。这是Java编译
//器ల来版本可以改进的一个方面。
 class Debugging{
    public static void main(String[] args) {
        List<Point> points = Arrays.asList(new Point(12, 2), null);
        points.stream().map(p -> p.getX()).forEach(System.out::println);
    }
}