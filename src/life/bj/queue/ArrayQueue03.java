package life.bj.queue;

/**
 *
 * 循环顺序队列
 */
public class ArrayQueue03<T> {

    private T[] data; // 存放数据

    private int size; // 数组大小

    private int len =0;  // 存放值得个数

    private int head=0; // 指向对头的节点

    private int tail=0; // 指向队尾的节点

    private static final int DEFAULT_SIZE = 16;

    public ArrayQueue03(int size){
        this.data=(T[]) new Object[size];
        this.size =size;
    }

    public ArrayQueue03(){
        this(DEFAULT_SIZE);
    }

    public static void main(String[] args) {
        ArrayQueue03<Integer> queue01 = new ArrayQueue03<>(3);
        queue01.enqueue(1);
        queue01.enqueue(2);
        queue01.enqueue(3);
        queue01.enqueue(4);
        System.out.println(queue01.dequeue());
        queue01.enqueue(5);
        System.out.println(queue01.dequeue());
        queue01.enqueue(6);
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

        // 判断是否队列已经满了

        int true_tail = (tail+1)%size;  // 这是需要理解的重点

        if (true_tail == head){
            return false;
        }
        this.data[tail] = t;

        tail = true_tail;

        return true;

    }

    /**
     * 出队
     * @return
     */
    public T dequeue(){
        // 判断队列是否为空
        if (head == tail) {
            return null;
        }
        T t = this.data[head];

        head = (head+1)%size;  // 避免循环过后数字变大
        return t;
    }



}
