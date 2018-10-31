import java.math.BigInteger;

public class Matrix {
    public static void taskA() {
        BigInteger compBI = BigInteger.valueOf(1);
        int[][] array = new int[8][8];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = (int) (Math.random() * 99 + 1);
                System.out.print(" " + array[i][j]);
                if (i == j || j == array.length - i - 1) {
                    sum += array[i][j];
                    compBI = compBI.multiply(BigInteger.valueOf(array[i][j]));
                }
            }
            System.out.println();
        }
        System.out.println(" сумма: " + sum + ", произведение: " + compBI);
    }

    public static void taskB() {
        int[][] array = new int[8][5];
        int max = -100;
        int iId = -1;
        int jId = -1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                array[i][j] = (int) (Math.random() * 200 - 100);
                System.out.print(" " + array[i][j]);
                if (array[i][j] > max) {
                    max = array[i][j];
                    iId = i;
                    jId = j;
                }

            }
            System.out.println();
        }
        System.out.println("максимум: " + max + " в координатах (" + iId + "," + jId + ")");
    }

    public static void taskC() {
        int[][] array = new int[8][5];
        long comp = -1;
        long tmp;
        for (int i = 0; i < 8; i++) {
            tmp = 1;
            for (int j = 0; j < 5; j++) {
                array[i][j] = (int) (Math.random() * 22 - 11);
                System.out.print(" " + array[i][j]);
                tmp *= Math.abs(array[i][j]);
            }
            if (tmp > comp)
                comp = tmp;
            System.out.println();
        }
        System.out.println("произведение: " + comp);
    }

    public static void taskD() {
        int[][] array = new int[10][7];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 7; j++) {
                array[i][j] = (int) (Math.random() * 101);
                System.out.print(" " + array[i][j]);
            }
            System.out.println();
        }
        for (int i = 0; i < 10; i++) {
            SortClass.selectSort(array[i]);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(" " + array[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //taskA();
        //taskB();
        //taskC();
        taskD();
    }
}
