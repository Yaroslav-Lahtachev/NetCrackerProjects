import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Arrays;

public class MyVector {
    public static void taskA() {
        int[] array = new int[50];
        for (int i = 0; i < array.length; i++) {
            array[i] = 2 * i + 1;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(" " + array[i]);
        }
    }

    public static void taskB() {
        int[] array = new int[20];
        int countOdd = 0;
        int countEven = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 11);
            if (array[i] % 2 == 0)
                countEven += 1;
            else
                countOdd += 1;
            System.out.print(" " + array[i]);
        }
        System.out.println();
        System.out.println("четных: " + countEven + " ,нечетных: " + countOdd);
    }

    public static void taskC() {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100 + 1);
            System.out.print(" " + array[i]);
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0)
                array[i] = 0;
            System.out.print(" " + array[i]);
        }
    }

    public static void taskD() {
        int[] array = new int[15];
        int min = 51, max = -51;
        int minId = -1, maxId = -1;

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 102 - 51);
            System.out.print(" " + array[i]);
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                maxId = i;
            }
            if (array[i] < min) {
                min = array[i];
                minId = i;
            }
        }
        System.out.println("min " + min + " под индексом " + minId);
        System.out.println("max " + max + " под индексом " + maxId);
    }

    public static void taskE() {
        int[] array1 = new int[10];
        int sum1 = 0;
        int[] array2 = new int[10];
        int sum2 = 0;

        for (int i = 0; i < array1.length; i++) {
            array1[i] = (int) (Math.random() * 11);
            sum1 += array1[i];
            System.out.print(" " + array1[i]);
        }

        sum1 /= array1.length;

        for (int i = 0; i < array2.length; i++) {
            array2[i] = (int) (Math.random() * 11);
            sum2 += array2[i];
            System.out.print(" " + array2[i]);
        }

        sum2 /= array2.length;

        if (sum1 > sum2)
            System.out.println("среднее арифметическое первого массива больше");
        else if (sum1 < sum2)
            System.out.println("среднее арифметическое второго массива больше");
        else System.out.println("среднее арифметическое массивов равно");
    }

    public static void taskF() {
        int[] array = new int[20];
        int[] counter = new int[3];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 4 - 2);
            if (array[i] == -1)
                counter[0]++;
            else if (array[i] == 0)
                counter[1]++;
            else counter[2]++;
            System.out.print(" " + array[i]);
        }
        int[] counter2 = counter.clone();
        Arrays.sort(counter);

        System.out.println();
        System.out.print("Большинство: ");
        if (counter[2] == counter[1]) {
            if (counter[2] == counter2[0]) {
                System.out.print("-1, ");
                if (counter[1] == counter2[1])
                    System.out.println("0");
                else
                    System.out.println("1");
            } else if (counter[2] == counter2[1]) {
                System.out.print("0, ");
                if (counter[1] == counter2[0])
                    System.out.println("-1");
                else System.out.println("1");

            } else {
                System.out.print("1, ");
                if (counter[1] == counter2[0])
                    System.out.println("-1");
                else
                    System.out.println("0");
            }
        } else {
            if (counter[2] == counter2[0])
                System.out.print("-1 ");
            else if (counter[2] == counter2[1])
                System.out.print("0 ");
            else System.out.print("1 ");
        }


    }

    public static void main(String[] args) {
        taskA();
        System.out.println();
        System.out.println();
        taskB();
        System.out.println();
        System.out.println();
        taskC();
        System.out.println();
        System.out.println();
        taskD();
        System.out.println();
        System.out.println();
        taskE();
        System.out.println();
        System.out.println();
        taskF();
    }
}
