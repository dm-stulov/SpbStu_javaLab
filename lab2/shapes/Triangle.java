package shapes;


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

    public float getArea() {
        p = this.getPerimeter();
        p = p / 2;
        return (float) (Math.sqrt(p - p1) * (p - p2) * (p - p3));
    }

    public int getRotation() {
        return 50;
    }

    @Override
    public float getLengthEllipe() {
        return 0;
    }

    @Override
    public float getX() {
        return 0;
    }

    @Override
    public float getY1() {
        return 0;
    }


    /*
     * TODO: Реализовать класс 'Triangle'
     * 1. Используйте наследование.
     * 2. Реализуйте все абстрактные методы.
     */

}