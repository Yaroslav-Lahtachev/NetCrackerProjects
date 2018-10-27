import java.math.BigDecimal;

public class MyTriangle {
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;

    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3){
        v1 = new MyPoint(x1,y1);
        v2 = new MyPoint(x2,y2);
        v3 = new MyPoint(x3,y3);
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

    public double getPerimeter(){
        return v1.distance(v2)+v1.distance(v2)+v2.distance(v3);
    }

    public String getType(){
        String str = "Не является треугольником";
        double a = v1.distance(v2);
        double b = v2.distance(v3);
        double c = v3.distance(v1);
        double max, min1, min2;
        BigDecimal abd = new BigDecimal(Math.pow(a,2));
        BigDecimal bbd = new BigDecimal(Math.pow(b,2));
        BigDecimal cbd = new BigDecimal(Math.pow(c,2));

        abd=abd.setScale(5,BigDecimal.ROUND_HALF_EVEN);
        bbd=bbd.setScale(5,BigDecimal.ROUND_HALF_EVEN);
        cbd=cbd.setScale(5,BigDecimal.ROUND_HALF_EVEN);
        if ((a + b) > c && (a + c) > b && (b + c) > a) {
            if (a > b && a > c) {
                max = abd.doubleValue();
                min1 = bbd.doubleValue();
                min2 = cbd.doubleValue();
            }
            else if (b > a && b > c){
                max = bbd.doubleValue();
                min1 = abd.doubleValue();
                min2 = cbd.doubleValue();
            }
            else{
                max = cbd.doubleValue();
                min1 = abd.doubleValue();
                min2 = bbd.doubleValue();
            }
            if(max == min1 + min2)
                str = "Прямоугольный";
            else
                if (max < min1 + min2)
                    str = "Остроугольный";
                else str = "Тупоугольный";
        }
        return str;
    }
}
