package JavaBasic04.J135MyLinkedList;

public class Node {
    private Node pervious;
    private Object object;
    private Node next;

    public Node getPervious() {
        return pervious;
    }

    public void setPervious(Node pervious) {
        this.pervious = pervious;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
