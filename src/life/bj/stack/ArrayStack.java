package life.bj.stack;

/**
 * 用数组实现的栈叫做顺序栈
 *
 * 该顺序栈不可以扩容
 *
 */
public class ArrayStack<T> {

    private T[] array;

    private int size;

    private int len;

    private static final int DEFAULT_SIZE = 16;


    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        for (int i=0;i<3;i++){
            System.out.println(stack.pop());
        }

    }

    public ArrayStack(int n){
        this.array = (T[])new Object[n];
        this.size = n;
        this.len =0;
    }

    public ArrayStack(){
        this(DEFAULT_SIZE);
    }

    /**
     * 入栈
     */
    public boolean push(T t){

        // 判断是否栈满了
        if(len == size){
            System.out.println("栈满了");
            return false;
        }
        this.array[len++] = t;
        return true;

    }

    /**
     * 出栈
     * @return
     */
    public T pop(){
        // 判断栈是否为空
        if (len == 0){
            return null;
        }

        T t = this.array[--len];

        return t;
    }






}
