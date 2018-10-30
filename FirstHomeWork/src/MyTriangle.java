import java.math.BigDecimal;
import java.util.Objects;

public class MyTriangle {
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;

    public MyTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        v1 = new MyPoint(x1, y1);
        v2 = new MyPoint(x2, y2);
        v3 = new MyPoint(x3, y3);
    }

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    @Override
    public String toString() {
        return "MyTriangle{" +
                "v1=" + v1.toString() +
                ", v2=" + v2.toString() +
                ", v3=" + v3.toString() +
                '}';
    }

    public double getPerimeter() {
        return v1.distance(v2) + v1.distance(v2) + v2.distance(v3);
    }

    public String getType() {

        BigDecimal a = new BigDecimal(v1.distance(v2));
        BigDecimal b = new BigDecimal(v2.distance(v3));
        BigDecimal c = new BigDecimal(v3.distance(v1));

        a = a.setScale(5, BigDecimal.ROUND_HALF_EVEN);
        b = b.setScale(5, BigDecimal.ROUND_HALF_EVEN);
        c = c.setScale(5, BigDecimal.ROUND_HALF_EVEN);

        if (a.doubleValue() == b.doubleValue() && a.doubleValue() == c.doubleValue()) {
            return "Равносторонний";
        } else if (a.doubleValue() == b.doubleValue() || b.doubleValue() == c.doubleValue() || a.doubleValue() == c.doubleValue()) {
            return "Равнобедренный";
        }
        return "Разносторонний";
    }

    public String getTypeAngle() {
        String str = "Не является треугольником";
       
        double max, min1, min2;
        BigDecimal a = new BigDecimal(Math.pow(v1.distance(v2), 2));
        BigDecimal b = new BigDecimal(Math.pow(v2.distance(v3), 2));
        BigDecimal c = new BigDecimal(Math.pow(v3.distance(v1), 2));

        a = a.setScale(5, BigDecimal.ROUND_HALF_EVEN);
        b = b.setScale(5, BigDecimal.ROUND_HALF_EVEN);
        c = c.setScale(5, BigDecimal.ROUND_HALF_EVEN);
        if ((a.doubleValue() + b.doubleValue()) > c.doubleValue() && (a.doubleValue() + c.doubleValue()) > b.doubleValue() && (b.doubleValue() + c.doubleValue()) > a.doubleValue()) {
            if (a.doubleValue() > b.doubleValue() && a.doubleValue() > c.doubleValue()) {
                max = a.doubleValue();
                min1 = b.doubleValue();
                min2 = c.doubleValue();
            } else if (b.doubleValue() > a.doubleValue() && b.doubleValue() > c.doubleValue()) {
                max = b.doubleValue();
                min1 = a.doubleValue();
                min2 = c.doubleValue();
            } else {
                max = c.doubleValue();
                min1 = a.doubleValue();
                min2 = b.doubleValue();
            }
            if (max == min1 + min2)
                str = "Прямоугольный";
            else if (max < min1 + min2)
                str = "Остроугольный";
            else str = "Тупоугольный";
        }
        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyTriangle)) return false;
        MyTriangle that = (MyTriangle) o;
        return Objects.equals(v1, that.v1) &&
                Objects.equals(v2, that.v2) &&
                Objects.equals(v3, that.v3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(v1, v2, v3);
    }
}
