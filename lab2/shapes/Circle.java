package shapes;

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
}
