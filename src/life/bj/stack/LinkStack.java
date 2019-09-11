package life.bj.stack;

/**
 * 用链表实现的栈叫做链式栈
 *
 */
public class LinkStack<T> {

    public static void main(String[] args) {

        LinkStack<Integer> stack = new LinkStack<>();

        stack.push(new Node<>(1));
        stack.push(new Node<>(2));
        stack.push(new Node<>(3));
        stack.push(new Node<>(4));

        for (int i=0;i<5;i++){
            System.out.println(stack.pop());
        }
    }

    private Node<T> tail;


    public void push(Node<T> node){
        if(tail == null){
            tail = node;
            return;
        }
        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    public Node<T> pop(){
        if(tail == null){
            return null;
        }
        Node<T> t = tail;
        tail = tail.prev;
        return t;
    }

}
