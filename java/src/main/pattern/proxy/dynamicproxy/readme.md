# 动态代理的优劣
优：
+ 代码重用性强。同样的，如果我们代理类的增强功能都一样，使用动态代理可以大大减少代码的编写量。
+ 代理类与被代理类完全解耦。可以观察到代理类的代码中没有任何与被代理类相关的片段，这就实现了两者的解耦，使得代理类只需要去实现的逻辑，其他的并不关心。
劣：
+ 不易理解。确实不好理解，因为代理类被抽象了。
+ 不够灵活。这怎么说起呢？因为在所有的代理类在访问函数的时候，会转化为对invoke函数的调用，也就是说在invoke函数里面新增的功能（如例子中的前后增强功能），都会去执行，可是有些时候我们并不想去执行这些功能，这就不得不再去实现一个代理类了。

# 代理模式和装饰者模式的区别
如果你去研究一下这两个模式，可能你会发现这两个模式的代码可能是完全一样的，同样是持有被代理对象/被装饰者的一个引用，对这个对象进行进一步的操作；
在Java自带类中，关于装饰者模式非IO流的各种类莫属了（一层层装饰，使得功能多样化）。但是为什么它们使用装饰者模式而不是代理模式呢？
这两个模式的最基本的区别在于，代理模式对其被代理对象有控制权，而装饰者模式对其装饰者没有控制权。
对于代理模式对其被代理对象有控制权的意思是，在代理类中，可以完全不使用被代理对象的方法，而是用自己的方法，也就是尽管持有一个被代理类对象的引用，这个引用也可以不使用。
对于装饰者模式没有对其装饰者的控制权的意思是，装饰者永远是对其被装饰者的功能进行提升的，就是被装饰着原有的东西在装饰者中不可以舍弃。例如你有一个刚刚买了的房子，在装修之后，人把厨房的门砌死了，装修完后少了个厨房，那就亏了，装饰者模式就是这个意思，它只是对被装饰者进行一层修饰，原有的东西不会改变。

