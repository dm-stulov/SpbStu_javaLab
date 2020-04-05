import point.Point2D;
import shapes.*;


public class Main {
    private static int index;


    private static float maxArea(Shape[] sh) {
        float max = sh[0].getArea();
        int ind = 0;
        for (int i = 1; i < sh.length; i++) {
            if (sh[i].getArea() > max) {
                max = sh[i].getArea();
                ind = i;
            }
        }
        index = ind;
        return sh[ind].getArea();
    }


    public static void main(String[] args) {
        Shape[] shapes;
        shapes = new Shape[10];

        shapes[0] = new Circle(new Point2D(20, 10), 7);
        shapes[1] = new Circle(new Point2D(20, 10), 4);
        shapes[2] = new Circle(new Point2D(20, 10), 18);

<<<<<<< HEAD
        shapes[0] = new Circle(8, 5, 7);
        shapes[1] = new Circle(4, 1, 4);
        shapes[2] = new Circle(9, 1, 18);

        shapes[3] = new Rectangle(3, 7, 4, 3);
        shapes[4] = new Rectangle(5, 4, 5, 3);
        shapes[5] = new Rectangle(1, 2, 3, 2);
        shapes[6] = new Rectangle(5, 7, 2, 6);

        shapes[7] = new Triangle(5, 7, 9, 12, 12, 8);
        shapes[8] = new Triangle(1, 1, 5, 10, 10, 7);
        shapes[9] = new Triangle(5, 5, 10, 8, 15, 5);
=======
        shapes[3] = new Rectangle(new Point2D(3, 7), new Point2D(4, 3));
        shapes[4] = new Rectangle(new Point2D(5, 4), new Point2D(5, 3));
        shapes[5] = new Rectangle(new Point2D(2, 1), new Point2D(4, 7));
        shapes[6] = new Rectangle(new Point2D(111, 9090), new Point2D(90000, 11));
>>>>>>> 0aa741eef0a7b9c4a53016871ac7bf48c7178727

        shapes[7] = new Triangle(new Point2D(5, 7), new Point2D(9, 21), new Point2D(12, 8));
        shapes[8] = new Triangle(new Point2D(1, 1), new Point2D(5, 10), new Point2D(10, 7));
        shapes[9] = new Triangle(new Point2D(5, 5), new Point2D(10, 8), new Point2D(15, 5));
        float size = maxArea(shapes);

        System.out.println("The maximum figure has index: " + index + ", its size is = " + size);
    }
}