package shapes;

import point.Point;

public class Circle implements Ellipse {
  private Point center;
  private float radius;

  public Circle(Point point, float radius) {
    this.center = point;
    this.radius = radius;
  }

  public Point getCenter() {
    return center;
  }

  @Override
  public float getArea() {
    return (float) (Math.PI * Math.pow(radius, 2));
  }

  @Override
  public float getLengthEllipe() {
    return (float) (Math.PI * (2 * radius));
  }
}
