# 中断线程

## 情景1：run方法内没有sleep或wait方法时，停止线程




实际开发中的两种最佳实践
方法一：优先选择传递中断RightWayStopThreadInProd
方法二：不想或无法传递中断时，可选择恢复中断

不应屏蔽中断

中断存在的意义及案例：
语言规范中并没有为中断提供特定的语义，但是在较大的程序中，难于维护除取消外的任何中断语义。取决于是什么活动，用户可以通过一个
GUI 或通过网络机制，例如 JMX 或 Web
服务来请求取消。程序逻辑也可以请求取消。例如，一个 Web
爬行器（crawler）如果检测到磁盘已满，它会自动关闭自己，否则一个并行算法会启动多个线程来搜索解决方案空间的不同区域，一旦其中一个线程找到一个解决方案，就取消那些线程。

疑问： Thread类是怎么获取到当前线程的
Thread.currentThread()和this是一致的，所以打印结果会打印出true


volatile设置boolean标记位
错误原因：
    在面对线程遇到长时间阻塞的情况，是没办法及时唤醒的。如果阻塞发生在while循环体里面，是没有检查逻辑的
修正方式




创建Runnable的两种方式：
1.实现Runnable接口
2.Runnable接受lumbda表达式

java设计sleep函数理念：如果sleep一旦响应中断，便会把interupted这个标记位清除

RightWayStopThreadWithoutSleep 中断未阻塞线程
RightWayStopThreadWithSleep 中断阻塞线程
RightWayStopThreadWithSleepEveryLoop 在循环中中断阻塞线程

CantInterrupt 如果while里面放try/catch，会导致中断失效（while内try/catch问题）
