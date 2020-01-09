package mydatastructure.queue;

public class LoopQueue<E> implements QueueInterface<E> {

    private E[] data;
    /**
     * front:队列第一个元素位置
     * tail:队列下一个元素位置
     */
    private int front, tail;

    public LoopQueue(){
        this(10);
    }

    public LoopQueue(int capacity){
        data = (E[])new Object[capacity+1];
    }

    @Override
    public void enqueue(E e) {
        if((tail+1)%data.length==front)
            resize(data.length*2);
        data[(tail++)%data.length]=e;
    }

    public void resize(int capacity){
        E[] newdata = (E[])new Object[capacity];
        for(int i=0;i<data.length-1;i++)
            newdata[i]=data[(front+i)%data.length];
        front=0;
        tail=data.length;
        data = newdata;
    }

    @Override
    public E dequeue() {
//        if(isEmpty())//这里忘了...
//            throw new IllegalArgumentException("Queue is empty.");
//        if(front+1==data.length){//数组最后一个元素
//            front = 0;
//            return data[front];
//        }else{
//            return data[front++]=null;
//        }

        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty bobo.playdatastructure.queue.");
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;//1点和13点的差异
        if(getSize() == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty())//这里忘了...
            throw new IllegalArgumentException("Queue is empty.");
        return data[front];
    }

    @Override
    public int getSize() {
        return tail-front-1;//data.size()-1这错了
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return tail-front==0;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("front [");
        for(int i=0;i<data.length;i++){
            buffer.append(data[i]);
            if(i != data.length - 1)
                buffer.append(", ");
        }
        buffer.append("] tail");
        return buffer.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for(int i=0;i<9;i++){
            loopQueue.enqueue(i);
        }
        System.out.println(loopQueue);
        loopQueue.dequeue();
        System.out.println("dequeue");
        System.out.println(loopQueue);
        loopQueue.dequeue();
        System.out.println("dequeue");
        System.out.println(loopQueue);
        loopQueue.enqueue(10);
        System.out.println("enqueue 10");
        System.out.println(loopQueue);
        loopQueue.enqueue(11);
        System.out.println("enqueue 11");
        System.out.println(loopQueue);
    }
}
