public class Node<E> {
    private E element;
    private Node nextNode;


    public Node(E element) {
        this.element = element;
        this.nextNode = null;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "Node{" +
                "element=" + element + ")";
    }
}
