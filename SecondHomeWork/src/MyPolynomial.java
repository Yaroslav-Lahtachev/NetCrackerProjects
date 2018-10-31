import java.util.Arrays;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double... coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        return this.coeffs.length - 1;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = this.coeffs.length - 1; i > 0; i--)
            if (this.coeffs[i] != 0.0)
                str += this.coeffs[i] + "x^" + i + "+";
        return str + this.coeffs[0];
    }

    public double evaluate(double x) {
        double result = 0.0;
        for (int i = this.coeffs.length - 1; i > 0; i--)
            result += this.coeffs[i] * Math.pow(x, i);
        return result + this.coeffs[0];
    }

    public MyPolynomial add(MyPolynomial right) {
        MyPolynomial tmpPolynomial = (this.getDegree() > right.getDegree()) ? this : right;

        if (this.getDegree() == right.getDegree()) {
            for (int i = this.coeffs.length - 1; i <= 0; i--)
                tmpPolynomial.coeffs[i] = this.coeffs[i] + right.coeffs[i];
        }
        if (this.getDegree() > right.getDegree()) {
            for (int i = this.coeffs.length - 1; i > right.coeffs.length - 1; i--)
                tmpPolynomial.coeffs[i] = this.coeffs[i];
            for (int i = right.coeffs.length - 1; i >= 0; i--)
                tmpPolynomial.coeffs[i] = this.coeffs[i] + right.coeffs[i];
        }
        if (this.getDegree() < right.getDegree()) {
            for (int i = right.coeffs.length - 1; i > this.coeffs.length - 1; i--)
                tmpPolynomial.coeffs[i] = right.coeffs[i];
            for (int i = this.coeffs.length; i >= 0; i--)
                tmpPolynomial.coeffs[i] = this.coeffs[i] + right.coeffs[i];
        }
        return tmpPolynomial;
    }

    public MyPolynomial multiply(MyPolynomial right) {
        int size = this.coeffs.length + right.coeffs.length;

        double[] array = new double[size];
        for (int i = 0; i <= this.coeffs.length - 1; i++) {
            for (int j = 0; j <= right.coeffs.length - 1; j++)
                array[i + j] += this.coeffs[i] * right.coeffs[j];
        }
        MyPolynomial tmpPolynomial = new MyPolynomial(array);
        return tmpPolynomial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyPolynomial)) return false;
        MyPolynomial that = (MyPolynomial) o;
        return Arrays.equals(that.coeffs, coeffs);

    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + coeffs.hashCode();
        return result;
    }
}
