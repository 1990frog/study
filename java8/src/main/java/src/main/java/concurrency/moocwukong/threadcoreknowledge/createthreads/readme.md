# 启动线程

## 本质上启动线程的方式
+ Runnable() 
+ Thread()

方法一和方法二，也就是“实现Runnable接口并传入Thread类”和“继承Thread类然后重写run()”在实现多线程的本质上，并没有区别，都是最终调用了start()方法来新建线程。这两个方法的最主要区别在于run()方法的内容来源：

```
@Override
public void run(){
    if(target!=null){
        target.run();
    }
}
```

方法一：最终调用target.run();
方法二：run()整个都被重写

总结：最精准的描述 通常我们可以分为两类，Oracle也是这么说的
准确的讲，创建线程只有一种方式那就是构建Thread类，而实现线程的执行单元有两种
方法一：实现Runnable接口的run方法，并把Runnable实例传给Thread类
方法二：重写Thread的run方法（继承Thread类）

其他衍生启动方式:
+ Timer定时器
+ Lumbda表达式
+ ThreadPool
+ InnerClass

## 实现Runnable接口好在哪里？

继承Thread是不推荐的，因为它有以下的一些缺点：  
1. 从代码架构角度：具体的任务（run方法）应该和“创建和运行线程的机制（Thread类）”解耦，用runnable对象可以实现解耦。
2. 使用继承Thread的方式的话，那么每次想新建一个任务，只能新建一个独立的线程，而这样做的损耗会比较大（比如重头开始创建一个线程、执行完毕以后再销毁等。如果线程的实际工作内容，也就是run()函数里只是简单的打印一行文字的话，那么可能线程的实际工作内容还不如损耗来的大）。如果使用Runnable和线程池，就可以大大减小这样的损耗。
3. 继承Thread类以后，由于Java语言不支持双继承，这样就无法再继承其他的类，限制了可扩展性。





