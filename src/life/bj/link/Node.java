package life.bj.link;

import lombok.Data;

public class Node<T> {
    public T data;
    public Node next;

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }
}
