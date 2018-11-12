import java.util.*;

public class CollectionAnalysis {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();
        int size = 100000;

        long startTime1 = System.nanoTime();
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        long estimatedTime1 = System.nanoTime() - startTime1;
        System.out.println("создание arrayList на " + size + " элементов: " + estimatedTime1);


        long startTime2 = System.nanoTime();
        for (int i = 0; i < size; i++) {
            linkedList.add(i);
        }
        long estimatedTime2 = System.nanoTime() - startTime2;
        System.out.println("создание linkedList на " + size + " элементов: " + estimatedTime2);

        //Заполнение ArrayList и LinkedList путем последовательного добавления элементов в коллекцию длится приблезительно одинаковое время
        //Немного большее время создание у ArrayList'а связано с не обходимостью динамически расширять массив хранящий данные

        startTime1 = System.nanoTime();
        arrayList.add(0, -1);
        estimatedTime1 = System.nanoTime() - startTime1;
        System.out.println("вставка элемента в начало arrayList: " + estimatedTime1);

        startTime2 = System.nanoTime();
        linkedList.add(0, -1);
        estimatedTime2 = System.nanoTime() - startTime2;
        System.out.println("вставка элемента в начало linkedList: " + estimatedTime2);

        startTime1 = System.nanoTime();
        arrayList.add(-1);
        estimatedTime1 = System.nanoTime() - startTime1;
        System.out.println("вставка элемента в конец arrayList: " + estimatedTime1);

        startTime2 = System.nanoTime();
        linkedList.add(-1);
        estimatedTime2 = System.nanoTime() - startTime2;
        System.out.println("вставка элемента в конец linkedList: " + estimatedTime2);

        startTime1 = System.nanoTime();
        arrayList.add(arrayList.size() / 2, -1);
        estimatedTime1 = System.nanoTime() - startTime1;
        System.out.println("вставка элемента в середину arrayList: " + estimatedTime1);

        startTime2 = System.nanoTime();
        linkedList.add(arrayList.size() / 2, -1);
        estimatedTime2 = System.nanoTime() - startTime2;
        System.out.println("вставка элемента в середину linkedList: " + estimatedTime2);

        //Исходя из особенности реализации LinkedList вставка элемента в начало и конец списка занимает меньшее время
        //Однако вставка в середину LinkedList занимает значительно большее время

        arrayList.remove(0);
        estimatedTime1 = System.nanoTime() - startTime1;
        System.out.println("удаление элемента в начале arrayList: " + estimatedTime1);

        startTime2 = System.nanoTime();
        linkedList.remove(0);
        estimatedTime2 = System.nanoTime() - startTime2;
        System.out.println("удаление элемента в начале linkedList: " + estimatedTime2);

        startTime1 = System.nanoTime();
        arrayList.remove(linkedList.size() / 2);
        estimatedTime1 = System.nanoTime() - startTime1;
        System.out.println("удаление элемента в середине arrayList: " + estimatedTime1);

        startTime2 = System.nanoTime();
        linkedList.remove(linkedList.size() / 2);
        estimatedTime2 = System.nanoTime() - startTime2;
        System.out.println("удаление элемента в середине linkedList: " + estimatedTime2);

        startTime1 = System.nanoTime();
        arrayList.remove(size - 1);
        estimatedTime1 = System.nanoTime() - startTime1;
        System.out.println("удаление элемента в конце arrayList: " + estimatedTime1);

        startTime2 = System.nanoTime();
        linkedList.remove(size - 1);
        estimatedTime2 = System.nanoTime() - startTime2;
        System.out.println("удаление элемента в конце linkedList: " + estimatedTime2);

        //Удаление элемнта в начале списка значительно быстрее LinkedList, удаление с конца занимает примерно одинаковое время
        //Удаление же из середины LinkedList, снова значительно проигрывает ArrayList'у
        //Исходя из таких результатов можно сделать вывод, что использование LinkedList более предпочтительно если есть потребность
        //в частом обращении к элементам хранящимся в начале или конце списка, однако если возникает необходимость
        //получения доступа к элементам хранящимся в середине LinkedList, то с ростом размерности этого списка это становится
        //все более проблематичным. При размерности уже в 100000, разница во времени доступа к элементам из середины
        //достигает уже 20-и кратного разрыва.
        System.out.println();
        System.out.println();

        long startTime3;
        long estimatedTime3 = 0;
        int rndNum;
        int minInt = 0;
        int maxInt = 10000;
        int midInt = 5000;

        HashSet hashSet = new HashSet();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        TreeSet treeSet = new TreeSet();


        for (int i = 0; i < size; i++) {
            rndNum = (int) (Math.random() * 10001);
            if (rndNum < 1000)
                minInt = rndNum;
            if (rndNum > 9000)
                maxInt = rndNum;
            if (rndNum > 4500 && rndNum < 5500)
                midInt = rndNum;

            startTime1 = System.nanoTime();
            hashSet.add(rndNum);
            estimatedTime1 += System.nanoTime() - startTime1;


            startTime2 = System.nanoTime();
            linkedHashSet.add(rndNum);
            estimatedTime2 += System.nanoTime() - startTime2;


            startTime3 = System.nanoTime();
            treeSet.add(rndNum);
            estimatedTime3 += System.nanoTime() - startTime3;

        }
        System.out.println("создание hashSet на " + size + " элементов: " + estimatedTime1);
        System.out.println("создание linkedHashSet на " + size + " элементов: " + estimatedTime2);
        System.out.println("создание treeSet на " + size + " элементов: " + estimatedTime3);

        //очевидно, стандартный HashSet получился самым быстрым в плане добавления элеменитов, следом за нима LinkedHashSet и последний TreeSet

        startTime1 = System.nanoTime();
        hashSet.remove(minInt);
        estimatedTime1 = System.nanoTime() - startTime1;
        System.out.println("удаление элемента в начале hashSet: " + estimatedTime1);

        startTime2 = System.nanoTime();
        linkedHashSet.remove(minInt);
        estimatedTime2 = System.nanoTime() - startTime2;
        System.out.println("удаление элемента в начале linkedHashSet: " + estimatedTime2);

        startTime3 = System.nanoTime();
        treeSet.remove(minInt);
        estimatedTime3 = System.nanoTime() - startTime3;
        System.out.println("удаление элемента в начале treeSet: " + estimatedTime3);


        startTime1 = System.nanoTime();
        hashSet.remove(midInt);
        estimatedTime1 = System.nanoTime() - startTime1;
        System.out.println("удаление элемента в середине hashSet: " + estimatedTime1);

        startTime2 = System.nanoTime();
        linkedHashSet.remove(midInt);
        estimatedTime2 = System.nanoTime() - startTime2;
        System.out.println("удаление элемента в середине linkedHashSet: " + estimatedTime2);

        startTime3 = System.nanoTime();
        treeSet.remove(midInt);
        estimatedTime3 = System.nanoTime() - startTime3;
        System.out.println("удаление элемента в середине treeSet: " + estimatedTime3);


        startTime1 = System.nanoTime();
        hashSet.remove(maxInt);
        estimatedTime1 = System.nanoTime() - startTime1;
        System.out.println("удаление элемента в конце hashSet: " + estimatedTime1);

        startTime2 = System.nanoTime();
        linkedHashSet.remove(maxInt);
        estimatedTime2 = System.nanoTime() - startTime2;
        System.out.println("удаление элемента в конце linkedHashSet: " + estimatedTime2);

        startTime3 = System.nanoTime();
        treeSet.remove(maxInt);
        estimatedTime3 = System.nanoTime() - startTime3;
        System.out.println("удаление элемента в конце treeSet: " + estimatedTime3);

        //самым же быстрым на удаление получился LinkedHashSet, вслед за которым идет HashSet. Самым же неспешным оказался TreeSet
        //Эти результаты оказалиль предсказуемы, т.к. TreeSet следует использовать только в задачах связанных с поиском, временная сложность
        //поиска, вставки, удаления в худшем и в среднем составляет O(log(n)), тогда как в HashSet и LinkedList эти действия состовляют от O(1) до O(n)
        //в среднем и худшем случае соответственно.
        //В общем, быстрее всех ассимптотически и практически LinkedHashSet, однако мы будем испольпользовать больше памяти.
        //Но так как "память больше не ресурс" предпочтительнее во всех отношениях будет LinkedHashSet

        System.out.println();
        System.out.println();

        HashMap hashMap = new HashMap();
        LinkedHashMap linkedHashMap= new LinkedHashMap();
        TreeMap treeMap = new TreeMap();


        for (int i = 0; i < size; i++) {
            rndNum = (int) (Math.random() * size+1);

            startTime1 = System.nanoTime();
            hashMap.put(rndNum,i);
            estimatedTime1 += System.nanoTime() - startTime1;


            startTime2 = System.nanoTime();
            linkedHashMap.put(rndNum,i);
            estimatedTime2 += System.nanoTime() - startTime2;


            startTime3 = System.nanoTime();
            treeMap.put(rndNum,i);
            estimatedTime3 += System.nanoTime() - startTime3;

        }
        System.out.println("создание hashMap на " + size + " элементов: " + estimatedTime1);
        System.out.println("создание linkedHashMap на " + size + " элементов: " + estimatedTime2);
        System.out.println("создание treeMap на " + size + " элементов: " + estimatedTime3);

        //Заполнение LinkedHashMap происходит немного быстрее обычного HashMap, а вот TreeMap значительно остстает от лидеров


        startTime1 = System.nanoTime();
        hashMap.remove(0);
        estimatedTime1 = System.nanoTime() - startTime1;
        System.out.println("удаление элемента в начале hashMap: " + estimatedTime1);

        startTime2 = System.nanoTime();
        linkedHashMap.remove(0);
        estimatedTime2 = System.nanoTime() - startTime2;
        System.out.println("удаление элемента в начале linkedHashMap: " + estimatedTime2);

        startTime3 = System.nanoTime();
        treeMap.remove(0);
        estimatedTime3 = System.nanoTime() - startTime3;
        System.out.println("удаление элемента в начале treeMap: " + estimatedTime3);


        startTime1 = System.nanoTime();
        hashMap.remove(hashMap.size()/2);
        estimatedTime1 = System.nanoTime() - startTime1;
        System.out.println("удаление элемента в середине hashMap: " + estimatedTime1);

        startTime2 = System.nanoTime();
        linkedHashMap.remove(hashMap.size()/2);
        estimatedTime2 = System.nanoTime() - startTime2;
        System.out.println("удаление элемента в середине linkedHashMap: " + estimatedTime2);

        startTime3 = System.nanoTime();
        treeMap.remove(hashMap.size()/2);
        estimatedTime3 = System.nanoTime() - startTime3;
        System.out.println("удаление элемента в середине treeMap: " + estimatedTime3);


        startTime1 = System.nanoTime();
        hashMap.remove(size-1);
        estimatedTime1 = System.nanoTime() - startTime1;
        System.out.println("удаление элемента в конце hashMap: " + estimatedTime1);

        startTime2 = System.nanoTime();
        linkedHashMap.remove(size-1);
        estimatedTime2 = System.nanoTime() - startTime2;
        System.out.println("удаление элемента в конце linkedHashMap: " + estimatedTime2);

        startTime3 = System.nanoTime();
        treeMap.remove(size-1);
        estimatedTime3 = System.nanoTime() - startTime3;
        System.out.println("удаление элемента в конце treeMap: " + estimatedTime3);

        //Ситуация у карт такая же как и в множемтвах. LinkedHashMap производительнее двух других коллекций. Этот класс будет предпочтительнее
        //во всех случаях, где память не играет никакой роли и где нам не нужно упорядоченное хранение элементов.
    }
}
