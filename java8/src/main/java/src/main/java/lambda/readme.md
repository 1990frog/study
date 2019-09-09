# Lumbda

以下是lambda表达式的重要特征:   
+ 可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
+ 可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。 可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
+ 可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值。

## 实例

```
// 1. 不需要参数,返回值为 5  
() -> 5
  
// 2. 接收一个参数(数字类型),返回其2倍的值  
x -> 2 * x  
  
// 3. 接受2个参数(数字),并返回他们的差值  
(x, y) -> x – y  
  
// 4. 接收2个int型整数,返回他们的和  
(int x, int y) -> x + y  
  
// 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)  
(String s) -> System.out.print(s)
```

## 语法 

大致形式就是：
```
(parameters) -> expression

(parameters) ->{ statements; }

{param1, param2, param3, param4…）->{ doing……}； 
```

三部分：
+ 参数列表 
+ 箭头
+ 函数主体

Java中Lambda表达式只有三种形式： 

```
() -> System.out.println("Hello Lambda");  

(number1, number2) -> int a = number1 + number2;  

(number1, number2) -> {
  int a = number1 + number2;
  System.out.println(a);
}
```

## 函数式接口(Functional Interface)

函数式接口(Functional Interface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
函数式接口可以被隐式转换为 lambda 表达式。
Lambda 表达式和方法引用（实际上也可认为是Lambda表达式）上。

```
如定义了一个函数式接口如下：
@FunctionalInterface
interface GreetingService 
{
    void sayMessage(String message);
}
```

接口继承接口的问题（覆盖？）

函数式接口的抽象方法的签名基本上就是Lambda表达式的签名。我们将这种抽象方法叫做函数描述符。


把Lambda付诸实践：环绕执行模式
第一步：记得执行参数化
第二步：使用函数式接口来传递行为
第三步：执行一个行为
第四步：传递Lambda

Lambda表达式允许你直接内联，为函数式接口的抽象方法提供实现，并且将整个表达式作为函数式接口的一个实例。

函数式接口只是定义了一个抽象的方法。函数式接口很有用，因为抽象方法的签名可以描述Lambda表达式的签名。函数式接口的抽象方法的签名称为函数描述符。所以为了应用不同的Lambda表达式，你需要一套能描述常见函数描述符的函数式接口。


### 常见函数式接口：

Predicate 
Consumer
Function

## 流: 

Stream 作为 Java 8 的一大亮点，它与 java.io 包里的 InputStream 和
OutputStream 是完全不同的概念。它也不同于 StAX 对 XML 解析的 Stream，也不是
Amazon Kinesis 对大数据实时处理的 Stream。Java 8 中的 Stream
是对集合（Collection）对象功能的增强，它专注于对集合对象进行各种非常便利、高效的聚合操作（aggregate
operation），或者大批量数据操作 (bulk data operation)。Stream API
借助于同样新出现的 Lambda
表达式，极大的提高编程效率和程序可读性。同时它提供串行和并行两种模式进行汇聚操作，并发模式能够充分利用多核处理器的优势，使用
fork/join 并行方式来拆分任务和加速处理过程。通常编写并行代码很难而且容易出错,
但使用 Stream API
无需编写一行多线程的代码，就可以很方便地写出高性能的并发程序。所以说，Java 8
中首次出现的 java.util.stream 是一个函数式语言+多核时代综合影响的产物。



