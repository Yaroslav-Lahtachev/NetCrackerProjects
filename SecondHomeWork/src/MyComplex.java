import java.math.BigDecimal;
import java.util.Objects;

public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex() {
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        if (this.imag < 0.0)
            return "(" + real + "-" + Math.abs(imag) + "i}";
        return "(" + real + "+" + imag + "i}";
    }

    public boolean isReal() {
        if (this.imag == 0.0)
            return true;
        return false;
    }

    public boolean isImaginary() {
        if (this.real == 0.0)
            return true;
        return false;
    }

    public boolean equals(double real, double imag) {
        if (this.real == real && this.imag == imag)
            return true;
        return false;
    }

    public boolean equals(MyComplex another) {
        if (this.real == another.real && this.imag == another.imag)
            return true;
        return false;
    }

    public double magnitude() {
        BigDecimal magnitude = new BigDecimal(Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imag, 2)));
        return magnitude.setScale(5, BigDecimal.ROUND_HALF_EVEN).doubleValue();
    }

    public double argument() {
        BigDecimal magnitude = new BigDecimal(Math.atan(this.imag / this.real));
        return magnitude.setScale(5, BigDecimal.ROUND_HALF_EVEN).doubleValue();
    }

    public MyComplex add(MyComplex right) {
        this.real += right.real;
        this.imag += right.imag;
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        MyComplex tmpComplex = new MyComplex();
        tmpComplex.real = this.real + right.real;
        tmpComplex.imag = this.imag + right.imag;
        return tmpComplex;
    }

    public MyComplex subract(MyComplex right) {
        this.real -= right.real;
        this.imag -= right.imag;
        return this;
    }

    public MyComplex subractNew(MyComplex right) {
        MyComplex tmpComplex = new MyComplex();
        tmpComplex.real = this.real - right.real;
        tmpComplex.imag = this.imag - right.imag;
        return tmpComplex;
    }

    public MyComplex multiply(MyComplex right) {
        double tmp = this.real;
        this.real = this.real * right.real - this.imag * right.imag;
        this.imag = tmp * right.imag + this.imag * right.real;
        return this;
    }

    public MyComplex divide(MyComplex right) {
        double tmp = this.real;
        this.real = (this.real * right.real + this.imag * right.imag) / (Math.pow(right.real, 2) + Math.pow(right.imag, 2));
        this.imag = (this.imag * right.real - tmp * right.imag) / (Math.pow(right.real, 2) + Math.pow(right.imag, 2));
        return this;
    }

    public MyComplex conjugate() {
        this.imag *= -1;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyComplex)) return false;
        MyComplex myComplex = (MyComplex) o;
        return Double.compare(myComplex.getReal(), getReal()) == 0 &&
                Double.compare(myComplex.getImag(), getImag()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isReal(), getImag());
    }
}
