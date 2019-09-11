package life.bj.link.Palindromic;

import life.bj.link.Node;

/**
 * 回文数
 */
public class Palindromic {

    public static void main(String[] args) {
//        Node<Character> node1 = new Node<>('a',null);
//        Node<Character> node2 = new Node<>('b',node1);
//        Node<Character> node3 = new Node<>('c',node2);
        Node<Character> node4 = new Node<>('a',null);
        Node<Character> head = new Node<>('a',node4);

        boolean palindromic = isPalindromic(head);
        System.out.println(palindromic);
    }

    /**
     *  思路:
     *   通过快慢指针找到中间节点，
     *   然后反转中间节点后的所有节点
     *   反转后的节点和前面的节点进行比较
     *
     *   时间复杂度为O(n)  空间复杂度为O(1)
     *
     *
     * @param head
     * @return
     */
    public static boolean isPalindromic(Node<?> head){
        if(head == null){
            return false;
        }

        Node<?> slow = head;
        Node<?> fast = head;

        Node<?> temp = null;

        Node<?> compare = head;

        // 找到中间节点
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        // 将满指针后的所有都逆序过来
        while(slow != null){
            Node<?> t = slow;
            slow = slow.next;
            t.next = temp;
            temp = t;
        }
        // 进行比较
        while(temp != null){
            if(!temp.data.equals(compare.data)){
                return false;
            }
            temp = temp.next;
            compare = compare.next;

        }
        return true;
    }

}
