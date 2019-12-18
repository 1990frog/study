适配器模式(Adapter)

# 个人总结
迁就调用者？你的电脑只能用hdmi（Target），但是显示器是dp（Adaptee），那只能将dp转成hdmi。
为了不造成更大的影响。那就不能改dp类，所以产生了适配器模式（Adapter）
灵魂：就是用一个类转接，方法分两种：静态、动态。
# 概览
## 适配器模式的定义
Convert the interface of a class into another interface clients expect
将某个类的接口转换为接口客户所需的类型
适配器模式解决的问题是，使得原本由于接口不兼容而不能一起工作、不能统一管理的那些类可以在一起工作、可以进行统一管理。
将一个接口转换成客户希望的另一个接口，适配器模式使接口不兼容的那些类可以一起工作，其别名为包装器（Wrapper）  
## 角色
+ Target（目标接口）:所要转换的所期待的接口
+ Adaptee（源角色）：需要适配的类
+ Adapter（适配器）：将源角色适配成目标接口，一般持有源接口的引用（或者继承源接口），且实现目标接口。
## 主要优点
+ 将目标类和适配者类解耦，通过引入一个适配器类来重用现有的适配者类，无须修改原有结构。
+ 增加了类的透明性和复用性，将具体的业务实现过程封装在适配者类中，对于客户端类而言是透明的，而且提高了适配者的复用性，同一个适配者类可以在多个不同的系统中复用。
+ 灵活性和扩展性都非常好，通过使用配置文件，可以很方便地更换适配器，也可以在不修改原有代码的基础上增加新的适配器类，完全符合“开闭原则”。
## 适配器的使用场景：
1. 接口转换
2. 想要创建一个可以重复使用的类，同时这些重复的类彼此之间没有关系。
## 种类
1. 类的适配器模式【静态】
2. 对象的适配器模式【动态】
3. 接口的适配器模式（C++）
## 作用
1. **透明：通过适配器，客户端可以调用同一接口，因而对客户端来说是透明的。这样做更简单、更直接、更紧凑。**
2. 重用：复用了现存的类，解决了现存类和复用环境要求不一致的问题。
3. 低耦合：将目标类和适配者类解耦，通过引入一个适配器类重用现有的适配者类，而无需修改原有代码（遵循开闭原则）

# 类适配器
![][../../resources/adapter_01.png]
Adapter extend Adaptee implement Target
## 类适配器的定义
类的是适配器模式把适配的类的API转换为目标类的API
采用继承方式的称为类适配器
特点：通过多重继承不兼容接口，实现对目标接口的匹配，单一的为某个类而实现适配。  
## 总结
+ 类适配器使用对象继承的方式，是静态的定义方式
+ 对于类适配器，适配器可以重定义Adaptee的部分行为。
+ 对于类适配器，仅仅引入了一个对象，并不需要额外的引用来间接得到适配者Adaptee
+ 对于类适配器，由于适配器直接继承了Adaptee，使得适配器Adapter不能和Adaptee的子类一起工作

# 对象适配器
![][../../resources/adapter_02.png]
## 对象适配器定义
与类适配器模式一样，对象的适配器模式把被适配的类的API转换成为目标类的API，与类的适配器模式不同的是，对象的适配器模式不是使用继承关系连接到Adaptee类，而是使用委派关系连接到Adaptee类。
采用组合方式的适配器称为对象适配器
特点：把“被适配者”作为一个对象组合到适配器类中，接口包装被适配者。
## 总结
Adapter只实现了target接口，没有继承Adaptee适配者类。Adapter类持有了Adaptee的引用，实现sampleOperation1()的时候，使用adaptee的引用来直接调用Adaptee适配者类里面的sampleOperation1()，而不是自己再去实现。就通过了一个委托的形式把adapter类和adaptee类进行了关联。
+ 对象适配器使用对象组合的方式，是动态的组合方式。
+ 对于对象适配器，一个适配器可以把多种不同的源适配到同一个目标。（可以把多个不同的adaptee类通过一个Adapter适配器类转换成同一个target目标）
+ 对于对象适配器，要重定义Adaptee的行为比较困难。
+ 对于对象适配器，需要额外的引用来间接得到Adaptee。

# 实战
## 只定义一个适配器实现类
这种方式类似于多功能充电器，一个电源插头上接着多种类型的充电接口。用户在使用时需要使用电器接口与多功能充电器上的充电接口逐个进行对比，接口匹配，则可以充电。
## 为每一个对象都定义一个适配器
## 缺省适配器
缺省适配器模式是由适配器模式简化而来，省略了适配器模式中目标接口，也就是源接口和目标接口相同，源接口为接口，目标接口为类。
典型的缺省适配器模式是JavaEE规范中的Servlet接口与GenericServlet抽象类。
Servlet接口中包含五个抽象方法，而其中的service()方法才是用于实现业务逻辑的、必须要实现的方法，另外四个方法一般都是空实现，或简单实现。
GenericServlet抽象类实现了Servlet接口的service()方法以外的另外四个方法，所以自定义的Servlet只需要继承GenericServlet抽象类，实现service()方法即可。无需再实现Servlet接口了。














---

## Also known as
Wrapper

## Intent
Convert the interface of a class into another interface the clients
expect. Adapter lets classes work together that couldn't otherwise because of
incompatible interfaces.

## Applicability
Use the Adapter pattern when

* you want to use an existing class, and its interface does not match the one you need
* you want to create a reusable class that cooperates with unrelated or unforeseen classes, that is, classes that don't necessarily have compatible interfaces
* you need to use several existing subclasses, but it's impractical to adapt their interface by subclassing every one. An object adapter can adapt the interface of its parent class.

## Real world examples

* [java.util.Arrays#asList()](http://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html#asList%28T...%29)
* [java.util.Collections#list()](https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html#list-java.util.Enumeration-)
* [java.util.Collections#enumeration()](https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html#enumeration-java.util.Collection-)
* [javax.xml.bind.annotation.adapters.XMLAdapter](http://docs.oracle.com/javase/8/docs/api/javax/xml/bind/annotation/adapters/XmlAdapter.html#marshal-BoundType-)

## Credits

* [Design Patterns: Elements of Reusable Object-Oriented Software](http://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612)
* [J2EE Design Patterns](http://www.amazon.com/J2EE-Design-Patterns-William-Crawford/dp/0596004273/ref=sr_1_2)
