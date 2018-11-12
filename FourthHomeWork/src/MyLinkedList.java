import java.lang.reflect.Array;
import java.util.*;

public class MyLinkedList<E> implements ILinkedList<E> {

    private int size = 0;
    private Node first;
    private Class<E> eClass;

    public MyLinkedList(Class<E> eClass) {
        this.eClass = eClass;
        this.first = new Node(null);
    }

    public void add(E element) {
        add(this.size(), element);
    }

    public void add(int index, E element) {
        Node node = new Node(element);
        if (index >= 0 && index <= this.size) {
            Node currentNode = this.first;
            int i = 0;
            while (i != index && currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
                i++;
            }
            Node nextNode = currentNode.getNextNode();
            currentNode.setNextNode(node);
            node.setNextNode(nextNode);
        } else {
            throw new IndexOutOfBoundsException("out of index");
        }
        this.size++;
    }

    public void clear() {
        for (Node<E> currentNode = this.first; currentNode != null; ) {
            Node<E> next = currentNode.getNextNode();
            currentNode.setElement(null);
            currentNode.setNextNode(null);
            currentNode = next;
        }
        this.first = null;
        this.size = 0;
    }

    public E get(int index) {
        Node currentNode = this.first;
        int i = 0;
        if (index >= 0 && index < this.size) {
            while (i <= index) {
                currentNode = currentNode.getNextNode();
                i++;
            }
            return (E) currentNode.getElement();
        } else System.out.println("out of index");
        return null;
    }

    public int indexOf(E element) {
        Node currentNode = this.first;
        int index = 0;
        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
            if (currentNode.getElement().equals(element)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public E remove(int index) {
        Node currentNode = this.first;

        if (index >= 0 && index <= this.size) {
            int i = 0;
            while (currentNode.getNextNode() != null) {

                if (i == index) {
                    Node prevNode = currentNode;
                    currentNode = currentNode.getNextNode();
                    prevNode.setNextNode(currentNode.getNextNode());
                    System.out.println("Object at index: " + index + " was removed!");
                    this.size--;
                    break;
                }
                i++;
                currentNode = currentNode.getNextNode();
            }
        } else {
            System.err.println("out of index");
        }
        return (E) currentNode.getElement();
    }


    public E set(int index, E element) {
        Node currentNode = this.first;

        if (index >= 0 && index <= this.size) {

            int i = 0;
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();

                if (i == index) {
                    currentNode.setElement(element);
                    System.out.println("Object at index: " + index + " was updated!");
                    break;
                }
                i++;
            }
        } else {
            System.err.println("out of index");
        }
        return (E) currentNode.getElement();
    }


    public int size() {
        return this.size;
    }

    public E[] toArray() {
        E[] result = (E[]) Array.newInstance(this.eClass, this.size);
        int i = 0;
        Node currentNode = this.first;
        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
            result[i++] = (E) currentNode.getElement();
        }
        return result;
    }

    @Override
    public String toString() {
        if (this.size == 0)
            return "list is empty";
        Node currentNode = this.first;
        String str = "";
        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
            str += " " + currentNode.getElement();
        }
        return str;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> currentNode = first;

            @Override
            public boolean hasNext() {
                return currentNode.getNextNode() != null;
            }

            @Override
            public E next() {
                currentNode = currentNode.getNextNode();
                E result = currentNode.getElement();
                return result;
            }
        };
    }
}
