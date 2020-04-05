package shapes;

<<<<<<< HEAD
public class Circle implements Point, Ellipse {
    private float x, y, r;

    public Circle(float x, float y, float r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    @Override
    public float getArea() {
        return (float) (Math.PI * Math.pow(r, 2));
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getRotation() {
        return 0;
    }

    public float getLengthEllipe() {
        return (float) (Math.PI * (2 * r));
    }
=======
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
>>>>>>> 0aa741eef0a7b9c4a53016871ac7bf48c7178727
}
