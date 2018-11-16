import java.util.*;

public class CollectionAnalysis {
    static ArrayList arrayList = new ArrayList();
    static LinkedList linkedList = new LinkedList();
    static HashSet hashSet = new HashSet();
    static LinkedHashSet linkedHashSet = new LinkedHashSet();
    static TreeSet treeSet = new TreeSet();
    static HashMap hashMap = new HashMap();
    static LinkedHashMap linkedHashMap = new LinkedHashMap();
    static TreeMap treeMap = new TreeMap();

    public static void testCreatingCollections(Collection[] collections, int size) {

        Long[] estimatedTime = new Long[3];
        for (int i = 0; i < 3; i++) {
            estimatedTime[i] = (long) 0;
        }
        long startTime;

        if (collections[2] != null) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < 3; j++) {
                    startTime = System.nanoTime();
                    collections[j].add(i);
                    estimatedTime[j] += System.nanoTime() - startTime;
                }
            }
            for (int i = 0; i < 3; i++)
                System.out.println("создание " + collections[i].getClass() + " на " + size + " элементов: " + estimatedTime[i]);
        } else {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < 2; j++) {
                    startTime = System.nanoTime();
                    collections[j].add(i);
                    estimatedTime[j] += System.nanoTime() - startTime;
                }
            }
            for (int i = 0; i < 2; i++)
                System.out.println("создание " + collections[i].getClass() + " на " + size + " элементов: " + estimatedTime[i]);
        }
    }


    public static void testAdditionLists(ArrayList arrayList, LinkedList linkedList, int size) {
        List[] lists = new List[2];
        lists[0] = arrayList;
        lists[1] = linkedList;
        long startTime, estimatedTime;
        Integer[] nums = {0, size / 2, size - 1};

        for (List list : lists) {
            for (int i : nums) {
                startTime = System.nanoTime();
                list.add(i, -1);
                estimatedTime = System.nanoTime() - startTime;
                System.out.println("вставка элемента в " + i + " " + lists.getClass() + ": " + estimatedTime);
            }
        }
    }

    public static void testDeletingFromCollections(Collection[] collections, int size) {
        long startTime, estimatedTime;
        Integer[] nums = {0, size / 2, size - 1};
        if (collections[2] != null) {
            for (Collection collection : collections) {
                for (int i : nums) {
                    startTime = System.nanoTime();
                    collection.remove(i);
                    estimatedTime = System.nanoTime() - startTime;
                    System.out.println("удаление элемента из   " + i + " " + collection.getClass() + ": " + estimatedTime);
                }
            }
        } else for (int i = 0; i < 2; i++) {
            startTime = System.nanoTime();
            collections[i].remove(i);
            estimatedTime = System.nanoTime() - startTime;
            System.out.println("удаление элемента из " + i + " " + collections[i].getClass() + ": " + estimatedTime);
        }

    }

    public static void testCreatingMap(Map[] maps, int size) {

        Long[] estimatedTime = new Long[3];
        int rndNum;
        for (int i = 0; i < 3; i++) {
            estimatedTime[i] = (long) 0;
        }
        long startTime;
        for (int i = 0; i < size; i++) {
            rndNum = (int) (Math.random() * size + 1);
            for (int j = 0; j < 3; j++) {
                startTime = System.nanoTime();
                maps[j].put(rndNum, i);
                estimatedTime[j] += System.nanoTime() - startTime;
            }
        }
        for (int i = 0; i < 3; i++)
            System.out.println("создание " + maps[i].getClass() + " на " + size + " элементов: " + estimatedTime[i]);
    }


    public static void testDeletingFromMaps(Map[] maps, int size) {
        long startTime, estimatedTime;
        Integer[] nums = {0, size / 2, size - 1};
        for (Map map : maps)
            for (int i : nums) {
                startTime = System.nanoTime();
                map.remove(i);
                estimatedTime = System.nanoTime() - startTime;
                System.out.println("удаление элемента из  " + i + " " + map.getClass() + ": " + estimatedTime);
            }
    }


    public static void main(String[] args) {
        int size = 100000;

        Collection[] collectionLists = new Collection[3];
        collectionLists[0] = arrayList;
        collectionLists[1] = linkedList;
        collectionLists[2] = null;

        testCreatingCollections(collectionLists, size);

        //Заполнение ArrayList и LinkedList путем последовательного добавления элементов в коллекцию длится приблезительно одинаковое время
        //Немного большее время создание у ArrayList'а связано с не обходимостью динамически расширять массив хранящий данные

        testAdditionLists(arrayList, linkedList, size);

        //Исходя из особенности реализации LinkedList вставка элемента в начало и конец списка занимает меньшее время
        //Однако вставка в середину LinkedList занимает значительно большее время

        testDeletingFromCollections(collectionLists, size);

        //Удаление элемнта в начале списка значительно быстрее LinkedList, удаление с конца занимает примерно одинаковое время
        //Удаление же из середины LinkedList, снова значительно проигрывает ArrayList'у
        //Исходя из таких результатов можно сделать вывод, что использование LinkedList более предпочтительно если есть потребность
        //в частом обращении к элементам хранящимся в начале или конце списка, однако если возникает необходимость
        //получения доступа к элементам хранящимся в середине LinkedList, то с ростом размерности этого списка это становится
        //все более проблематичным. При размерности уже в 100000, разница во времени доступа к элементам из середины
        //достигает уже 20-и кратного разрыва.

        System.out.println();
        System.out.println();

        Collection[] collectionSets = new Collection[3];
        collectionSets[0] = hashSet;
        collectionSets[1] = linkedHashSet;
        collectionSets[2] = treeSet;

        testCreatingCollections(collectionSets, size);

        //очевидно, стандартный HashSet получился самым быстрым в плане добавления элеменитов, следом за нима LinkedHashSet и последний TreeSet

        testDeletingFromCollections(collectionSets, size);

        //самым же быстрым на удаление получился LinkedHashSet, вслед за которым идет HashSet. Самым же неспешным оказался TreeSet
        //Эти результаты оказалиль предсказуемы, т.к. TreeSet следует использовать только в задачах связанных с поиском, временная сложность
        //поиска, вставки, удаления в худшем и в среднем составляет O(log(n)), тогда как в HashSet и LinkedList эти действия состовляют от O(1) до O(n)
        //в среднем и худшем случае соответственно.
        //В общем, быстрее всех ассимптотически и практически LinkedHashSet, однако мы будем испольпользовать больше памяти.
        //Но так как "память больше не ресурс" предпочтительнее во всех отношениях будет LinkedHashSet

        System.out.println();
        System.out.println();

        Map[] maps = new Map[3];
        maps[0] = hashMap;
        maps[1] = linkedHashMap;
        maps[2] = treeMap;


        testCreatingMap(maps, size);

        //Заполнение LinkedHashMap происходит немного быстрее обычного HashMap, а вот TreeMap значительно остстает от лидеров

        testDeletingFromMaps(maps, size);

        //Ситуация у карт такая же как и в множемтвах. LinkedHashMap производительнее двух других коллекций. Этот класс будет предпочтительнее
        //во всех случаях, где память не играет никакой роли и где нам не нужно упорядоченное хранение элементов.
    }
}
