package shapes;

/**
 * Представление о прямоугольнике.
 * <p>
 * Прямоугольник — четырехугольник, у которого все углы
 * прямые (равны 90 градусам).
 *
 * @see <a href="https://ru.wikipedia.org/wiki/%D0%9F%D1%80%D1%8F%D0%BC%D0%BE%D1%83%D0%B3%D0%BE%D0%BB%D1%8C%D0%BD%D0%B8%D0%BA">Прямоугольник</a>
 */
public class Rectangle implements Polygon,Point,Ellipse {
    private float x1, y1, x2, y2;

    public Rectangle(float x1, float y1, float x2, float y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    @Override
    public float getPerimeter() {
        return 2 * (Math.abs(x1 - x2) + Math.abs(y1 - y2));
    }

    @Override
    public float getArea() {
        return Math.abs(x1 - x2) * Math.abs(y1 - y2);
    }

    @Override
    public float getX() {
        return Math.abs(x1-x2);
    }

    @Override
    public float getY1() {
        return Math.abs(y1-y2);
    }

    /*
    @Override
    public int getRotation() {
        return 0;
    }

    @Override
    public float getLengthEllipe() {
        return 0;
    }
    */


    /*
     * TODO: Реализовать класс 'Rectangle'
     * 1. Используйте наследование.
     * 2. Реализуйте все абстрактные методы.
     */


}