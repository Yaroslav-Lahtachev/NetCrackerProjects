import java.util.Arrays;

public class SortClass {

    public static void bubbleSort(int[] array) {
        int tmp;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] > array[j]) {
                    tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    public static void selectSort(int[] array) {
        int tmp, k;

        for (int i = 0; i < array.length; i++) {
            k = i;
            tmp = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > tmp) {
                    k = j;
                    tmp = array[j];
                }
            }
            array[k] = array[i];
            array[i] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[1000];
        long[] res = new long[3];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 50);
            System.out.print(" " + array[i]);
        }
        int[] tmpArray1 = new int[array.length];
        System.arraycopy(array, 0, tmpArray1, 0, array.length - 1);
        int[] tmpArray2 = new int[array.length];
        System.arraycopy(array, 0, tmpArray2, 0, array.length - 1);

        System.out.println();
        long startTime1 = System.nanoTime();
        bubbleSort(tmpArray1);
        long estimatedTime1 = System.nanoTime() - startTime1;
        //System.out.println(Arrays.toString(tmpArray1));
        //System.out.println("время выполнения сортировки пузырьком--> " + estimatedTime1);

        long startTime2 = System.nanoTime();
        selectSort(tmpArray2);
        long estimatedTime2 = System.nanoTime() - startTime2;
        //System.out.println(Arrays.toString(tmpArray2));
        //System.out.println("время выполнения сортировки выбором--> " + estimatedTime2);

        long startTime3 = System.nanoTime();
        Arrays.sort(array);
        long estimatedTime3 = System.nanoTime() - startTime3;
        //System.out.println(Arrays.toString(array));
        //System.out.println("время выполнения сортировки методом из Класса Array--> " + estimatedTime3);

        res[0] = estimatedTime1;
        res[1] = estimatedTime2;
        res[2] = estimatedTime3;
        Arrays.sort(res);

        if (res[0] == estimatedTime3)
            System.out.println("Arrays.sort - быстрейший: " + res[0]);
        else if (res[0] == estimatedTime1)
            System.out.println("Пузырьком - быстрейший: " + res[0]);
        else System.out.println("Выбором - быстрейший: " + res[0]);

        if (res[1] == estimatedTime3)
            System.out.println("Arrays.sort - второй: " + res[1]);
        else if (res[1] == estimatedTime1)
            System.out.println("Пузырьком - второй: " + res[1]);
        else System.out.println("Выбором - второй: " + res[1]);

        if (res[2] == estimatedTime3)
            System.out.println("Arrays.sort - третий: " + res[2]);
        else if (res[2] == estimatedTime1)
            System.out.println("Пузырьком - третий: " + res[2]);
        else System.out.println("Выбором - третий: " + res[2]);

    }
}
