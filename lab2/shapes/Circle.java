package shapes;

public class Circle implements Polygon, Point, Ellipse {
    private float x, y, r;

    public Circle(float x, float y, float r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }


    @Override
    public int getRotation() {
        return 0;
    }

    public float getLength() {
        return 2 * r;
    }

    @Override
    public float getPerimeter() {
        return (float) (2 * Math.PI * r);
    }

    @Override
    public float getArea() {
        return (float) (Math.PI * Math.pow(r, 2));
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY1() {
        return y;
    }

    @Override
    public float getLengthEllipe() {
        return (float) (Math.PI * (2 * r));
    }
}
