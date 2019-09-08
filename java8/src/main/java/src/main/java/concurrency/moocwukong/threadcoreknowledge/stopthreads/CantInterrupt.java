package src.main.java.concurrency.moocwukong.threadcoreknowledge.stopthreads;

/**
 * 描述：
 * 如果while里面放try/catch，会导致中断失效
 *
 * java设计sleep函数理念：如果sleep一旦响应中断，便会把interupted这个标记位清除
 */
public class CantInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;

            while (num <= 10000 && !Thread.currentThread().isInterrupted()) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的倍数");
                }
                num++;
                try {
                    Thread.sleep(10);//Thread.currentThread().isInterrupted()状态被清空了
                } catch (InterruptedException e) {
//                    Thread.interrupted();//无效
                    e.printStackTrace();
                }
            }

//            try{
//                while (num <= 10000 && !Thread.currentThread().isInterrupted()) {
//                    if (num % 100 == 0) {
//                        System.out.println(num + "是100的倍数");
//                    }
//                    num++;
//                    Thread.sleep(10);//Thread.currentThread().isInterrupted()状态被清空了
//                }
//            }catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
