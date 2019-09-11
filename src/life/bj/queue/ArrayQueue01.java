package life.bj.queue;

/**
 *
 * 不挪位置的顺序队列
 */
public class ArrayQueue01<T> {

    private T[] data; // 存放数据

    private int size; // 数组大小

    private int len=0;  // 存放值得个数

    private int head=0; // 指向对头的节点

    private int tail=0; // 指向队尾的节点

    private static final int DEFAULT_SIZE = 16;

    public ArrayQueue01(int size){
        this.data=(T[]) new Object[size];
        this.size =size;
    }

    public ArrayQueue01(){
        this(DEFAULT_SIZE);
    }

    public static void main(String[] args) {
        ArrayQueue01<Integer> queue01 = new ArrayQueue01<>(3);
//        queue01.enqueue(1);
//        queue01.enqueue(2);
//        queue01.enqueue(3);
//        queue01.enqueue(4);
        int i = 4;
        while(i>0){
            System.out.println(queue01.dequeue());
            i--;
        }

    }


    /**
     * 入队
     * @param t
     */
    public boolean enqueue(T t){
        // 判断队列是否满了
        if (tail == size) {
            System.out.println("满了");
            return false;
        }
        this.data[tail++] = t;
        return true;
    }

    /**
     * 出队
     * @return
     */
    public T dequeue(){
        // 判断队列是否为空
        if (head == tail) {
            System.out.println("没了");
            return null;
        }
        return this.data[head++];
    }



}
