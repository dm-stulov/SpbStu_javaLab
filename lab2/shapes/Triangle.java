package shapes;


import point.Point;
import point.Point2D;

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

}