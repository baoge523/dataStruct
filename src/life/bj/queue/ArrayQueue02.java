package life.bj.queue;

/**
 *
 * 挪位置的顺序队列
 */
public class ArrayQueue02<T> {

    private T[] data; // 存放数据

    private int size; // 数组大小

    private int len =0;  // 存放值得个数

    private int head=0; // 指向对头的节点

    private int tail=0; // 指向队尾的节点

    private static final int DEFAULT_SIZE = 16;

    public ArrayQueue02(int size){
        this.data=(T[]) new Object[size];
        this.size =size;
    }

    public ArrayQueue02(){
        this(DEFAULT_SIZE);
    }

    public static void main(String[] args) {
        ArrayQueue02<Integer> queue01 = new ArrayQueue02<>(3);
        queue01.enqueue(1);
        queue01.enqueue(2);
        queue01.enqueue(3);
        queue01.enqueue(4);
        System.out.println(queue01.dequeue());
        queue01.enqueue(4);
        int i = 4;
        while(i>0){
            System.out.println(queue01.dequeue());
            i--;
        }

    }
    /**
     * 入队
     *
     * 这里的时间复杂度，可以用均摊分析法，但是挪动的位置的个数,又是不定的
     *
     *      所以这个的时间复杂度应该还是O(1),只是通过挪位置的方式，然后数组复用了
     *
     * @param t
     */
    public boolean enqueue(T t){
        // 判断队列是否满了
        if (tail == size) {

            // 判断head 是否为0，如果是0,那就是真正的满了，没有可以挪动的位置
            if(head == 0){
                return false;
            }
            // 否则就挪位置-->集合都向前挪动head个位置
            for(int i=head;i<size;i++){
                // 把当前位置上面的值挪到距离head远的位置处
                this.data[i-head] = this.data[i];
            }
            // 重新记录队头和队尾的位置
            this.tail = this.tail -head;
            this.head = 0;
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
            return null;
        }
        return this.data[head++];
    }



}
