package mydatastructure.queue;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    /**
     * front:队列第一个元素位置
     * tail:队列下一个元素位置
     */
    private int front, tail;

    public LoopQueue() {
        this(10);
    }

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front)
            resize(data.length * 2);

//        data[(tail++) % data.length] = e;错了
        data[tail] = e;
        tail = (tail + 1) % data.length;
    }

    public void resize(int capacity) {
        E[] newdata = (E[]) new Object[capacity];
//        for (int i = 0; i < data.length - 1; i++)错了
        for (int i = 0; i < getSize(); i++)
            newdata[i] = data[(front + i) % data.length];
        front = 0;
//        tail = data.length;错了
        tail = getSize();
        data = newdata;

//        E[] newData = (E[])new Object[newCapacity + 1];
//        for(int i = 0 ; i < size ; i ++)
//            newData[i] = data[(i + front) % data.length];
//
//        data = newData;
//        front = 0;
//        tail = size;
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

        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty bobo.playdatastructure.queue.");
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;//1点和13点的差异
        if (getSize() == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);

//        System.out.println(this.toString());
//        System.out.println(String.format("Queue:size=%s,capacity=%s",getSize(),getCapacity()));
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty())//这里忘了...
            throw new IllegalArgumentException("Queue is empty.");
        return data[front];
    }

    @Override
    public int getSize() {
//        if(tail==front){
//            return 0;
//        }else if(front>tail){
//            return getCapacity()-front+tail;
//        }else {
//            return tail-front;
//        }
        if (front > tail) {
            return getCapacity() - front + tail;
        } else {
            return tail - front;
        }
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return tail - front == 0;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("front [");
//        for (int i = 0; i < data.length; i++) {//不应该把null打出来
//            buffer.append(data[i]);
//            if (i != data.length - 1)
//                buffer.append(", ");
//        }

        for (int i = front; i != tail; i = (i + 1) % data.length) {
            buffer.append(data[i]);
            if ((i + 1) % data.length != tail)
                buffer.append(", ");
        }
        buffer.append("] tail");
        return buffer.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 9; i++) {
            loopQueue.enqueue(i);
        }
//        System.out.println(loopQueue);
        loopQueue.dequeue();
//        System.out.println("dequeue");
//        System.out.println(loopQueue);
        loopQueue.dequeue();
//        System.out.println("dequeue");
//        System.out.println(loopQueue);
        loopQueue.enqueue(10);
//        System.out.println("enqueue 10");
//        System.out.println(loopQueue);
        loopQueue.enqueue(11);
//        System.out.println("enqueue 11");
//        System.out.println(loopQueue);
    }
}
