package life.structure.queue;

import java.util.Random;
import java.util.Scanner;

/**
 *  队列:
 *   受限的线形数据结构  FIFO
 *
 *   基于数组来实现队列---且挪动位置  ---循环利用数组空间
 *
 *   其实就是在入队的时候，多进行了一次判断
 *
 *    tail == length && head ==0 才是真正的满了，否则就可以通过集体移动就可以复用数组了
 *    使用均摊分析法，时间复杂度为O(n)
 *
 *    可以使用 循环队列来实现，但是会浪费一个存储空间，不然无法判断队满
 *
 *
 */
public class Queue {
    /**
     * 存放数据
     */
    private int items[];
    /**
     * 当前存放数据的大小
     */
    private int size;
    /**
     * 数组的长度
     */
    private int length;
    /**
     * 执行队头
     */
    private int head;
    /**
     * 指向队尾
     */
    private int tail;

    public static final int DEFAULT_SIZE = 5;

    public Queue(){
        this(DEFAULT_SIZE);
    }


    public Queue(int size){
        checkNum(size);
        items = new int[size];
        length = size;
        this.size = tail = head = 0;
    }

    private void checkNum(int num){
        if(num <= 0){
            throw new RuntimeException("不能为空");
        }
    }


    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        // 也可以通过size来判断
       if(tail == head){
           return true;
       }
       return false;
    }

    /**
     * 是否满了
     * @return
     */
    public boolean isFull(){
        if(tail == length){
            return true;
        }
        return false;
    }

    /**
     * 摊还分析法
     *
     * @param item
     */
    public void enqueue(int item){
        // 满了--> tail == length 了
        if(isFull()){
           // 如果 head == 0 那是真正的满了
            if(head == 0){
                System.out.println("队列满了");
                return;
            }
            // head 位置后面的数，统统向前移动head个数即可
            for(int i=head;i<length;i++){
                items[i-head] = items[i];
            }
            tail -=head;
            head = 0;

        }
        size++;
        items[tail++] = item;
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("队列为空");
            return -1;
        }
        size--;
        return items[head++];
    }

    /**
     * 查看对头的数据
     * @return
     */
    public int peek(){
        if(isEmpty()){
            System.out.println("队列为空");
            return -1;
        }
        return items[head];
    }

    /**
     * 表示，从哪个位置开始打印，需要打印多少个
     */
    public void print(){
        for (int i=head;i<head+size;i++){
            System.out.print(items[i]+",");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Queue queue = new Queue();

        Scanner print = new Scanner(System.in);

        Random random = new Random();

        boolean flag = true;

        while(flag){
            System.out.println("0 查看");
            System.out.println("1 入队");
            System.out.println("2 出队");
            System.out.println("3 查看对头");
            System.out.println("4 退出");
            int choose = 0;
            System.out.print("请输入:");
            choose = print.nextInt();
            switch(choose){
                case 0:{
                    queue.print();
                    break;
                }
                case 1: {
                    queue.enqueue(random.nextInt(50));
                    break;
                }
                case 2:{
                    System.out.println(queue.dequeue());
                    break;
                }
                case 3:{
                    System.out.println(queue.peek());
                    break;
                }
                case 4:{
                    flag = false;
                }
            }

        }


    }


}
