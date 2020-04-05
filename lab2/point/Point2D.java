package point;

public class Point2D implements Point {
  private float x;
  private float y;

  public Point2D(float x, float y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public float getX() {
    return 0;
  }

  @Override
  public float getY() {
    return 0;
  }

  @Override
  public String toString() {
    return "(" + getX() + " " + getY() + ")";
  }
}
