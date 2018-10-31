import java.math.BigInteger;
import java.util.Arrays;

public class Factorial {
    public static long cycleFactorial(int n) {
        long res = 1;
        for (int i = 1; i <= n; i++)
            res *= i;
        return res;
    }


    public static long recursiveFactorial(int n) {
        long res;
        if (n == 1)
            return 1;
        res = n * recursiveFactorial(n - 1);
        return res;
    }

    public static void main(String[] args) {
        int n = 20;
        long x, y;
        long startTime1 = System.nanoTime();
        x = cycleFactorial(n);
        long estimatedTime1 = System.nanoTime() - startTime1;


        long startTime2 = System.nanoTime();
        y = recursiveFactorial(n);
        long estimatedTime2 = System.nanoTime() - startTime2;

        System.out.println(x == y);
        System.out.println(n + "! = " + x);

        long[] res = new long[2];
        res[0] = estimatedTime1;
        res[1] = estimatedTime2;

        Arrays.sort(res);

        if (res[0] == estimatedTime1)
            System.out.println("вычисление факториала циклом быстрее: " + res[0]);
        else System.out.println("вычисление факториала рекурсией быстрее: " + res[0]);


        if (res[1] == estimatedTime1)
            System.out.println("вычисление факториала циклом медленнее: " + res[1]);
        else System.out.println("вычисление факториала рекурсией медленнее: " + res[1]);


    }
}
