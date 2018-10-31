public class InnerCycleUses {
    public static void rectangleHash(int size) {
        int[][] hashArray = new int[size][size];
        for (int i = 0; i < size; i++) {
            System.out.println();
            for (int j = 0; j < size; j++)
                System.out.print('#');
        }
    }

    public static void taskB(int size) {
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
            System.out.println();
            for (int j = 0; j < size; j++)
                if (i >= j) System.out.print('#');

        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.println();
            for (int j = 0; j < size; j++)
                if (i <= j) System.out.print('#');

        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.println();
            for (int j = 0; j < size; j++)
                if (j >= i) System.out.print('#');
                else System.out.print(' ');

        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.println();
            for (int j = 0; j < size; j++)
                if (j <= i) System.out.print('#');
                else System.out.print(' ');

        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.println();
            for (int j = 0; j < size; j++)
                if (i == 0 || i == size - 1)
                    System.out.print('#');
                else if (j == 0 || j == size - 1)
                    System.out.print('#');
                else {

                    if (i == j) System.out.print('#');
                    else System.out.print(' ');
                }
        }

    }

    public static void main(String[] args) {
        int size = 5;
        rectangleHash(size);
        System.out.println();
        taskB(size);
    }
}
