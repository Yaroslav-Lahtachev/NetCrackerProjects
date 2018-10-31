import java.util.Arrays;

public class RandomEnum {
    enum Car {LAMBORGHINI, FERRARI, PORSCHE, BUGATTI, MOSKVICH}

    final static Car[] val = Car.values();

    public static void switcher(Car theCar) {
        switch (theCar) {
            case LAMBORGHINI:
                System.out.println("Sweet dream Lambo");
                break;
            case BUGATTI:
                System.out.println("Bugatti Chiron looks better than Veyron");
                break;
            case FERRARI:
                System.out.println("Ferrari it's trite");
                break;
            case PORSCHE:
                System.out.println("Porsche 930 immortal classics");
                break;
            case MOSKVICH:
                System.out.println("Moskvich 412 best car for soviet comrade");
                break;
            default:
                System.out.println("idk, it isn't hypercar");
        }
    }

    public static void ifSwitcher(Car theCar) {
        if (theCar == Car.LAMBORGHINI)
            System.out.println("Sweet dream Lambo");
        else if (theCar == Car.BUGATTI)
            System.out.println("Bugatti Chiron looks better than Veyron");
        else if (theCar == Car.FERRARI)
            System.out.println("Ferrari it's trite");
        else if (theCar == Car.PORSCHE)
            System.out.println("Porsche 930 immortal classics");
        else if (theCar == Car.MOSKVICH)
            System.out.println("Moskvich 412 best car for soviet comrade");
        else System.out.println("idk, it isn't hypercar");
    }

    public static void switcherArray(int[] array) {
        int[] counter = new int[11];
        for (int i = 0; i < array.length; i++) {
            switch (array[i]) {
                case 0:
                    counter[0]++;
                    break;
                case 1:
                    counter[1]++;
                    break;
                case 2:
                    counter[2]++;
                    break;
                case 3:
                    counter[3]++;
                    break;
                case 4:
                    counter[4]++;
                    break;
                case 5:
                    counter[5]++;
                    break;
                case 6:
                    counter[6]++;
                    break;
                case 7:
                    counter[7]++;
                    break;
                case 8:
                    counter[8]++;
                    break;
                case 9:
                    counter[9]++;
                    break;
                case 10:
                    counter[10]++;
                    break;
            }
        }
        System.out.println(Arrays.toString(counter));
    }

    public static void ifSwitcherArray(int[] array) {
        int[] counter = new int[11];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0)
                counter[0]++;
            else if (array[i] == 1)
                counter[1]++;
            else if (array[i] == 2)
                counter[2]++;
            else if (array[i] == 3)
                counter[3]++;
            else if (array[i] == 4)
                counter[4]++;
            else if (array[i] == 5)
                counter[5]++;
            else if (array[i] == 6)
                counter[6]++;
            else if (array[i] == 7)
                counter[7]++;
            else if (array[i] == 8)
                counter[8]++;
            else if (array[i] == 9)
                counter[9]++;
            else if (array[i] == 10)
                counter[10]++;
        }
        System.out.println(Arrays.toString(counter));
    }

    public static void main(String[] args) {
        long startTime1 = System.nanoTime();
        for (Car theCar : Car.values()) {
            switcher(theCar);
        }
        long estimatedTime1 = System.nanoTime() - startTime1;


        long startTime2 = System.nanoTime();
        for (Car theCar : Car.values()) {
            ifSwitcher(theCar);
        }
        long estimatedTime2 = System.nanoTime() - startTime2;
        System.out.println("switch-case enum: " + estimatedTime1);
        System.out.println("if-else enum: " + estimatedTime2);


        int[] array = new int[50];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 11);
            System.out.print(" " + array[i]);
        }


        System.out.println();

        long startTime3 = System.nanoTime();
        switcherArray(array);
        long estimatedTime3 = System.nanoTime() - startTime3;

        System.out.println();

        long startTime4 = System.nanoTime();
        ifSwitcherArray(array);
        long estimatedTime4 = System.nanoTime() - startTime4;

        System.out.println();

        System.out.println("switch-case array: " + estimatedTime3);
        System.out.println("if-else: array " + estimatedTime4);
    }


}
