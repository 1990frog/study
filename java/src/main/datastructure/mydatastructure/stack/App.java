package datastructure.mydatastructure.stack;

public class App {

    public static void main(String[] args) {
        ArrayStack<Integer> queue =new ArrayStack<>();
        for (int i=0;i<10;i++){
            queue.push(i);
        }
        System.out.println(queue.toString());
        queue.pop();
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue);
    }

}
