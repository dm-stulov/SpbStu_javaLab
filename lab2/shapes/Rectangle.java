package shapes;

/**
 * Представление о прямоугольнике.
 * <p>
 * Прямоугольник — четырехугольник, у которого все углы
 * прямые (равны 90 градусам).
 *
 * @see <a href="https://ru.wikipedia.org/wiki/%D0%9F%D1%80%D1%8F%D0%BC%D0%BE%D1%83%D0%B3%D0%BE%D0%BB%D1%8C%D0%BD%D0%B8%D0%BA">Прямоугольник</a>
 */
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


}