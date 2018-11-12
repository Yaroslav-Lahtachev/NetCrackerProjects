import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;


public class MainClass {
    public static void main(String[] args) {
        int size = 10000;

        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>(Integer.class);
        LinkedList<Integer> linkedList = new LinkedList<>();

        //создание myLinkedList на величину size элементов
        long startTime1 = System.nanoTime();
        for (int i = 0; i < size; i++) {
            myLinkedList.add(i);
        }
        long estimatedTime1 = System.nanoTime() - startTime1;
        System.out.println("создание myLinkedList на " + size + " элементов: " + estimatedTime1);

        //создание linkedList на величину size элементов
        long startTime2 = System.nanoTime();
        for (int i = 0; i < size; i++) {
            linkedList.add(i);
        }
        long estimatedTime2 = System.nanoTime() - startTime2;
        System.out.println("создание linkedList на " + size + " элементов: " + estimatedTime2);

        //вставка элемента в начало myLinkedList
        startTime1 = System.nanoTime();
        myLinkedList.add(0, -1);
        estimatedTime1 = System.nanoTime() - startTime1;
        System.out.println("вставка элемента в начало myLinkedList: " + estimatedTime1);

        //вставка элемента в начало linkedList
        startTime2 = System.nanoTime();
        linkedList.add(0, -1);
        estimatedTime2 = System.nanoTime() - startTime2;
        System.out.println("вставка элемента в начало linkedList: " + estimatedTime2);

        //вставка элемента в конец myLinkedList
        startTime1 = System.nanoTime();
        myLinkedList.add(-1);
        estimatedTime1 = System.nanoTime() - startTime1;
        System.out.println("вставка элемента в конец myLinkedList: " + estimatedTime1);

        //вставка элемента в конец linkedList
        startTime2 = System.nanoTime();
        linkedList.add(-1);
        estimatedTime2 = System.nanoTime() - startTime2;
        System.out.println("вставка элемента в конец linkedList: " + estimatedTime2);

        //вставка элемента в середину myLinkedList
        startTime1 = System.nanoTime();
        myLinkedList.add(myLinkedList.size() / 2, -1);
        estimatedTime1 = System.nanoTime() - startTime1;
        System.out.println("вставка элемента в середину myLinkedList: " + estimatedTime1);

        //вставка элемента в середину linkedList
        startTime2 = System.nanoTime();
        linkedList.add(myLinkedList.size() / 2, -1);
        estimatedTime2 = System.nanoTime() - startTime2;
        System.out.println("вставка элемента в середину linkedList: " + estimatedTime2);

        //поиск элемента в середине myLinkedList
        startTime1 = System.nanoTime();
        myLinkedList.get(linkedList.size() / 2);
        estimatedTime1 = System.nanoTime() - startTime1;
        System.out.println("поиск элемента в середине myLinkedList: " + estimatedTime1);

        //поиск элемента в середине linkedList
        startTime2 = System.nanoTime();
        linkedList.get(linkedList.size() / 2);
        estimatedTime2 = System.nanoTime() - startTime2;
        System.out.println("поиск элемента в середине linkedList: " + estimatedTime2);


        //поиск элемента в начале myLinkedList
        startTime1 = System.nanoTime();
        myLinkedList.get(0);
        estimatedTime1 = System.nanoTime() - startTime1;
        System.out.println("поиск элемента в начале myLinkedList: " + estimatedTime1);

        //поиск элемента в начале linkedList
        startTime2 = System.nanoTime();
        linkedList.get(0);
        estimatedTime2 = System.nanoTime() - startTime2;
        System.out.println("поиск элемента в начале linkedList: " + estimatedTime2);

        //поиск элемента в конце myLinkedList
        startTime1 = System.nanoTime();
        myLinkedList.get(size - 1);
        estimatedTime1 = System.nanoTime() - startTime1;
        System.out.println("поиск элемента в конце myLinkedList: " + estimatedTime1);

        //поиск элемента в конце linkedList
        startTime2 = System.nanoTime();
        linkedList.get(size - 1);
        estimatedTime2 = System.nanoTime() - startTime2;
        System.out.println("поиск элемента в конце linkedList: " + estimatedTime2);

        //удаление элемента в начале myLinkedList
        startTime1 = System.nanoTime();
        myLinkedList.remove(0);
        estimatedTime1 = System.nanoTime() - startTime1;
        System.out.println("удаление элемента в начале myLinkedList: " + estimatedTime1);

        //удаление элемента в начале linkedList
        startTime2 = System.nanoTime();
        linkedList.remove(0);
        estimatedTime2 = System.nanoTime() - startTime2;
        System.out.println("удаление элемента в начале linkedList: " + estimatedTime2);

        //удаление элемента в середине myLinkedList
        startTime1 = System.nanoTime();
        myLinkedList.remove(linkedList.size() / 2);
        estimatedTime1 = System.nanoTime() - startTime1;
        System.out.println("удаление элемента в середине myLinkedList: " + estimatedTime1);

        //удаление элемента в середине linkedList
        startTime2 = System.nanoTime();
        linkedList.remove(linkedList.size() / 2);
        estimatedTime2 = System.nanoTime() - startTime2;
        System.out.println("удаление элемента в середине linkedList: " + estimatedTime2);

        //удаление элемента в конце myLinkedList
        startTime1 = System.nanoTime();
        myLinkedList.remove(size - 1);
        estimatedTime1 = System.nanoTime() - startTime1;
        System.out.println("удаление элемента в конце myLinkedList: " + estimatedTime1);

        //удаление элемента в конце linkedList
        startTime2 = System.nanoTime();
        linkedList.remove(size - 1);
        estimatedTime2 = System.nanoTime() - startTime2;
        System.out.println("удаление элемента в конце linkedList: " + estimatedTime2);


        //ПРОТЕТСТИМ ОСНОВНЫЕ МЕТОДЫ
        MyLinkedList<Integer> listForTest = new MyLinkedList(Integer.class);
        listForTest.add(1);
        listForTest.add(2);
        listForTest.add(3);
        System.out.println(listForTest.toString());
        listForTest.add(1, 10);
        System.out.println(listForTest.toString());
        System.out.println("значение под индексом 1: " + listForTest.get(1));
        System.out.println("значение 10 хранится под индексом: " + listForTest.indexOf(10));
        System.out.println("удалили значение по индексом 1: " + listForTest.remove(1));
        System.out.println(listForTest.toString());
        System.out.println("изменили значение под индексом 1 на " + listForTest.set(1, 99));
        System.out.println(listForTest.toString());
        System.out.println("размер list: " + listForTest.size());
        System.out.println("записали list в ArrayList: " + Arrays.toString(listForTest.toArray()));

        System.out.println();
        //тест итератора
        System.out.println("протестируем итератор");
        Iterator<Integer> itr = listForTest.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println();


    }
}
