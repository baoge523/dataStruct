package life.bj.link;

import java.util.Iterator;

/**
 * 单链表
 */
public class Link<T> implements Iterable<T> {

    /**
     * 头结点
     */
    public Node<T> head ;
    /**
     * 尾结点
     */
    public Node<T> tail ;

    public boolean add(Node<T> node){
        if(head == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
        return true;
    }

    /**
     * 有空了，去模仿 LinkedList 写
     * @param index
     * @param node
     * @return
     */
    public boolean add(int index,Node<T> node){
        // 对index进行校验

        return true;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node<T> temp = head;

            @Override
            public boolean hasNext() {

                if(temp == null){
                    return false;
                }
                return true;
            }

            @Override
            public T next() {
                T data = temp.data;
                temp = temp.next;
                return data;
            }
        };
    }

    @Override
    public String toString() {
        Iterator<T> iterator = iterator();
        StringBuilder sb = new StringBuilder();
        while(iterator.hasNext()){
            sb.append(iterator.next());
        }
        return sb.toString();
    }

    public static void print(Node<?> node){
        if(node == null){
            System.out.println("空节点");
        }
        StringBuilder sb = new StringBuilder();
        while(node != null){
            sb.append(node.data).append(",");
            node = node.next;
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        System.out.println(sb.toString());
    }
}
