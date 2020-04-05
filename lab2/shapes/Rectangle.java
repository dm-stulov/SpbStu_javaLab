package shapes;

import point.Point;
import point.Point2D;

/**
 * Представление о прямоугольнике.
 * <p>
 * Прямоугольник — четырехугольник, у которого все углы
 * прямые (равны 90 градусам).
 *
 * @see <a href="https://ru.wikipedia.org/wiki/%D0%9F%D1%80%D1%8F%D0%BC%D0%BE%D1%83%D0%B3%D0%BE%D0%BB%D1%8C%D0%BD%D0%B8%D0%BA">Прямоугольник</a>
 */
<<<<<<< HEAD
public class Rectangle implements Polygon, Point, Ellipse {
    private float x1, y1, x2, y2, angleOfRotation, centerX, centerY;


    public Rectangle(float x1, float y1, float x2, float y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;

    }

    public float getPerimeter() {
        return 2 * (Math.abs(x1 - x2) + Math.abs(y1 - y2));
    }

    @Override
    public float getArea() {
        return Math.abs(x1 - x2) * Math.abs(y1 - y2);
    }

    public float getX() {
        centerX = Math.abs(x1 - x2);
        return centerX;
    }

    public float getY() {
        centerY = Math.abs(y1 - y2);
        return centerY;
    }

    public int getRotation() {
        x1 = (float) (centerX + (x1 - centerX) * Math.cos(angleOfRotation) - (y1 - centerY) * Math.sin(angleOfRotation));
        y1 = (float) (centerY + (y1 - centerY) * Math.cos(angleOfRotation) + (x1 - centerX) * Math.sin(angleOfRotation));
        x2 = (float) (centerX + (x2 - centerX) * Math.cos(angleOfRotation) - (y2 - centerY) * Math.sin(angleOfRotation));
        y2 = (float) (centerY + (y2 - centerY) * Math.cos(angleOfRotation) + (x2 - centerX) * Math.sin(angleOfRotation));
        return 0;
    }

    public float getLengthEllipe() {
        return 0;
    }


    /*
     * TODO: Реализовать класс 'Rectangle'
     * 1. Используйте наследование.
     * 2. Реализуйте все абстрактные методы.
     */
=======
public class Rectangle implements Polygon {
  private Point A;
  private Point C;

  private Point center;

  private int angle;

  public Rectangle(Point A, Point C) {
    this.A = A;
    this.C = C;
  }

  public Point getCenter() {
    return center;
  }

  public float getPerimeter() {
    return 2 * (Math.abs(A.getX() - C.getX()) + Math.abs(A.getY() - C.getY()));
  }

  @Override
  public float getArea() {
    return Math.abs(A.getX() - C.getX()) * Math.abs(A.getY() - C.getY());
  }

  @Override
  public int getRotation() {
    return angle;
  }

  @Override
  public void rotate(int rotationAngle) {
    int angle = this.angle + rotationAngle;
    var angleInRads = Math.toRadians(angle);

    float x1 =
        (float) (center.getX() + (A.getX() - center.getX()) * Math.cos(angleInRads) - (A.getY()
            - center.getY()) * Math.sin(angleInRads));
    float y1 =
        (float) (center.getY() + (A.getY() - center.getY()) * Math.cos(angleInRads) + (A.getX()
            - center.getX()) * Math.sin(angleInRads));
    float x2 =
        (float) (center.getX() + (C.getX() - center.getX()) * Math.cos(angleInRads) - (C.getY()
            - center.getY()) * Math.sin(angleInRads));
    float y2 =
        (float) (center.getY() + (C.getY() - center.getY()) * Math.cos(angleInRads) + (C.getX()
            - center.getX()) * Math.sin(angleInRads));

    A = new Point2D(x1, y1);
    C = new Point2D(x2, y2);

    this.angle = angle;
  }

  /*
   * TODO: Реализовать класс 'Rectangle'
   * 1. Используйте наследование.
   * 2. Реализуйте все абстрактные методы.
   */
>>>>>>> 0aa741eef0a7b9c4a53016871ac7bf48c7178727


}