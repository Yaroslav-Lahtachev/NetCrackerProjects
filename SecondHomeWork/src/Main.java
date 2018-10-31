
public class Main {
    public static void main(String[] args) {
        Ball b1 = new Ball(5, -5, 1, 1, 2);
        Ball b2 = new Ball(5, -5, 1, 5, 0);
        Container c1 = new Container(0, 0, 10, 10);
        System.out.println(b1.toString() + " <--мяч");
        System.out.println(c1.toString() + " <--контейнер");
        System.out.println(c1.collides(b1) + " помещается ли до начала перемещения");
        b1.move();
        System.out.println(b1.toString() + " <--положение мяча после перемещения");
        System.out.println(c1.collides(b1) + " помещается ли после начала перемещения");


        System.out.println();
        System.out.println(b2.toString() + " <--мяч 2");
        System.out.println(c1.toString() + " <--контейнер");
        System.out.println(c1.collides(b2) + " помещается ли до начала перемещения");
        b2.move();
        System.out.println(b2.toString() + " <--положение мяча 2 после перемещения");
        System.out.println(c1.collides(b2) + " помещается ли после начала перемещения");

        MyPolynomial p1 = new MyPolynomial(1,2,3,45,5);
        MyPolynomial p2 = new MyPolynomial(1,2,3,45,5);
        MyPolynomial p3 = p2;
        System.out.println(p1.equals(p2));
        System.out.println(p2.hashCode());
        System.out.println(p2.toString());
        System.out.println(p1.toString());


    }
}
