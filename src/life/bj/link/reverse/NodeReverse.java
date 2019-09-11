package life.bj.link.reverse;

import life.bj.link.Link;
import life.bj.link.Node;


/**
 * 单链表的反转
 *
 * 方式1:
 *   使用一个临时变量来存放值，每次取出单链表的一个值，然后反转
 *
 *   其他方式:百度吧
 *
 */
public class NodeReverse {

    public static void main(String[] args) {
        Link<Character> link = new Link<>();
        link.add(new Node<>('A'));
        link.add(new Node<>('B'));
        link.add(new Node<>('C'));
        link.add(new Node<>('D'));
        System.out.println(link);
        Node<?> node = method1(link.head);

        Link.print(node);


    }



    public static Node<?> method1(Node<?> node){
        if(node == null || node.next == null){
            return null;
        }

        Node<?> temp = null;

        while(node != null){
            Node<?> t = node;
            node = node.next;

            t.next = temp;
            temp = t;
        }
        return temp;
    }


}
