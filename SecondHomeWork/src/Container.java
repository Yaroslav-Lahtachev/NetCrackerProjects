import java.util.Objects;

public class Container {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Container(int x, int y, int width, int height) {
        this.x1 = x;
        this.y1 = y;
        this.x2 = width + x;
        this.y2 = y - height;
    }

    public int getX() {
        return x1;
    }

    public int getY() {
        return y1;
    }

    public int getWidth() {
        return x2;
    }

    public int getHeight() {
        return y2;
    }

    public boolean collides(Ball ball) {
        if (ball.getX() >= x1 + ball.getRadius()
                && ball.getY() <= y1 - ball.getRadius()
                && ball.getX() <= x2 - ball.getRadius()
                && ball.getY() >= y2 + ball.getRadius())
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Container{" +
                "(" + x1 + "," + y1 + "),(" + x2 + "," + y2 + ")}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Container)) return false;
        Container container = (Container) o;
        return x1 == container.x1 &&
                y1 == container.y1 &&
                x2 == container.x2 &&
                y2 == container.y2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, y1, x2, y2);
    }
}
