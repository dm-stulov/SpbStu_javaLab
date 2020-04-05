package shapes;


<<<<<<< HEAD
=======
import point.Point;
import point.Point2D;

>>>>>>> 0aa741eef0a7b9c4a53016871ac7bf48c7178727
import static java.lang.Math.cos;

/**
 * Представление о треугольнике.
 * <p>
 * Треуго́льник (в евклидовом пространстве) — геометрическая
 * фигура, образованная тремя отрезками, которые соединяют
 * три точки, не лежащие на одной прямой. Указанные три
 * точки называются вершинами треугольника, а отрезки —
 * сторонами треугольника. Часть плоскости, ограниченная
 * сторонами, называется внутренностью треугольника: нередко
 * треугольник рассматривается вместе со своей внутренностью
 * (например, для определения понятия площади).
 *
 * @see <a href="https://ru.wikipedia.org/wiki/%D0%A2%D1%80%D0%B5%D1%83%D0%B3%D0%BE%D0%BB%D1%8C%D0%BD%D0%B8%D0%BA">Треугольник</a>
 */

<<<<<<< HEAD
public class Triangle implements Polygon, Point, Ellipse {

    private float x1, x2, x3, y1, y2, y3, p, p1, p2, p3;

    public Triangle(float x1, float y1, float x2, float y2, float x3, float y3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    public float getPerimeter() {
        p1 = (float) (Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));
        p2 = (float) (Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2)));
        p3 = (float) (Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2)));
        p = p1 + p2 + p3;
        return p;
    }

    @Override
    public float getArea() {
        p = this.getPerimeter();
        p = p / 2;
        return (float) (Math.sqrt(p - p1) * (p - p2) * (p - p3));
    }


    public float getX() {
        return (x1 + x2 + x3) / 3;
    }


    public float getY() {
        return (y1 + y2 + y3) / 3;
    }


    public int getRotation() {
        float centerX = getX(), centerY = getY();
        float angle = 45 * (float) Math.PI / 360;
        angle = angle + 1;
        System.out.println(angle);

        float newCentreX1 = (float) (centerX + (x1 - centerX) * cos(angle) - (y1 - centerY) * Math.sin(angle));
        float newCentreY1 = (float) (centerY + (y1 - centerY) * cos(angle) + (x1 - centerX) * Math.sin(angle));

        float newCentreX2 = (float) (centerX + (x2 - centerX) * cos(angle) - (y2 - centerY) * Math.sin(angle));
        float newCentreY2 = (float) (centerY + (y2 - centerY) * cos(angle) + (x2 - centerX) * Math.sin(angle));

        float newCentreX3 = (float) (centerX + (x3 - centerX) * cos(angle) - (y3 - centerY) * Math.sin(angle));
        float newCentreY3 = (float) (centerY + (y3 - centerY) * cos(angle) + (x3 - centerX) * Math.sin(angle));

        return 0;
    }


    public float getLengthEllipe() {
        return 0;
    }




    /*
     * TODO: Реализовать класс 'Triangle'
     * 1. Используйте наследование.
     * 2. Реализуйте все абстрактные методы.
     */
=======
public class Triangle implements Polygon {
  private Point A;
  private Point B;
  private Point C;

  private Point center;
  private int angle;

  public Triangle(Point a, Point b, Point c) {
    A = a;
    B = b;
    C = c;
    this.angle = 0;

    setCenter();
  }

  public Point getCenter() {
    return center;
  }

  public float getPerimeter() {
    var p1 = (float) (Math.sqrt(Math.pow(A.getX() - B.getX(), 2) + Math.pow(A.getY() - B.getY(), 2)));
    var p2 = (float) (Math.sqrt(Math.pow(B.getX() - C.getX(), 2) + Math.pow(B.getY() - C.getY(), 2)));
    var p3 = (float) (Math.sqrt(Math.pow(C.getX() - A.getX(), 2) + Math.pow(C.getY() - A.getY(), 2)));
    var p = p1 + p2 + p3;

    return p;
  }

  @Override
  public float getArea() {
    float p = this.getPerimeter();
    p = p / 2;

    var p1 = (float) (Math.sqrt(Math.pow(A.getX() - B.getX(), 2) + Math.pow(A.getY() - B.getY(), 2)));
    var p2 = (float) (Math.sqrt(Math.pow(B.getX() - C.getX(), 2) + Math.pow(B.getY() - C.getY(), 2)));
    var p3 = (float) (Math.sqrt(Math.pow(C.getX() - A.getX(), 2) + Math.pow(C.getY() - A.getY(), 2)));

    return (float) (Math.sqrt(p - p1) * (p - p2) * (p - p3));
  }

  @Override
  public int getRotation() {
    return angle;
  }

  @Override
  public void rotate(int rotationAngle) {
    int newAngle = this.angle + rotationAngle;
    var angleInRads = Math.toRadians(newAngle);

    float newCentreX1 =
        (float) (center.getX() + (A.getX() - center.getX()) * cos(angleInRads) - (A.getY() - center.getY()) * Math.sin(angleInRads));
    float newCentreY1 =
        (float) (center.getY() + (A.getY() - center.getY()) * cos(angleInRads) + (A.getX() - center.getX()) * Math.sin(angleInRads));

    float newCentreX2 =
        (float) (center.getX() + (B.getX() - center.getX()) * cos(angleInRads) - (B.getY() - center.getY()) * Math.sin(angleInRads));
    float newCentreY2 =
        (float) (center.getY() + (B.getY() - center.getY()) * cos(angleInRads) + (B.getX() - center.getX()) * Math.sin(angleInRads));

    float newCentreX3 =
        (float) (center.getX() + (C.getX() - center.getX()) * cos(angleInRads) - (C.getY() - center.getY()) * Math.sin(angleInRads));
    float newCentreY3 =
        (float) (center.getY() + (C.getY() - center.getY()) * cos(angleInRads) + (C.getX() - center.getX()) * Math.sin(angleInRads));


    A = new Point2D(newCentreX1, newCentreY1);
    B = new Point2D(newCentreX2, newCentreY2);
    C = new Point2D(newCentreX3, newCentreY3);

    this.angle = newAngle;
  }

  private void setCenter() {
    this.center = new Point2D((A.getX() + B.getX() + C.getX()) / 3,
        (A.getY() + B.getY() + C.getY()) / 3);
  }

  /*
   * TODO: Реализовать класс 'Triangle'
   * 1. Используйте наследование.
   * 2. Реализуйте все абстрактные методы.
   */
>>>>>>> 0aa741eef0a7b9c4a53016871ac7bf48c7178727

}