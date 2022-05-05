import groovy.transform.PackageScope
import groovy.transform.Synchronized

import java.lang.annotation.ElementType
import java.lang.annotation.Target

/**
 * types
 *
 * primitive types
 *
 * integral types:
 *  byte(8bit)
 *  short(16bit)
 *  int(32bit)
 *  long(65bit)
 *
 * floating-point types:
 *  float(32bit)
 *  double(64bit)
 *
 * boolean type:
 *  one of true or false
 *
 * char(16bit)
 *
 * 自动装箱、拆箱
 *
 */
class Foo {
    static int i
}

assert Foo.class.getDeclaredField('i').type == int.class
assert Foo.i.class != int.class && Foo.i.class == Integer.class

/**
 * Reference Types
 */
var movie = 'The Matrix'
var movieArray = ['Hello', movie]
assert movieArray == ['Hello', 'The Matrix']
movie = 'from hell'
/**
 * 字符串赋值是创建新对象
 */
assert movieArray != ['Hello', 'from hell']

/**
 * Generics
 * 泛型
 */
List<String> roles = ['Trinity', 'Morpheus']

/**
 * Class
 *
 * Groovy类 与 Java类 修饰符的主要区别：
 * 1. 类或方法，没有显示指明，则自动设置为public
 * 2. 没有修饰符的字段会自动转换为属性
 * 3. 类不需要与源文件同名
 * 4. 一个源文件可以包含多个类，不在类中的代码被视为脚本
 *
 *
 * field 与 property
 * field一般是不暴露给外部的，只用作类或对象的内部数据储存只用；而property是需要暴露给外部的，用于控制类或对象的行为的参数
 * field一般没有对应的set/get方法，但property必有对应的set/get方法，以便反射时获取或修改property的值
 *
 */

class Person {

    String name
    Integer age

    def increaseAge(Integer years) {
        this.age += years
    }
}
/**
 * Normal class
 */
def p1 = new Person()
def p2 = Person.newInstance()
//def p3 = Person.&new
def p3 = Person.&new()
p1.age = 1
p2.age = 2
p3.age = 3
assert p1.age + p2.age == p3.age

/**
 * Inner class
 *
 * Inner classes are defined within another classes.
 * The enclosing class can use the inner class as usual.
 * On the other side, a inner class can access members of its enclosing class, even if they are private.
 * Classes other than the enclosing class are not allowed to access inner classes.
 *
 * 使用内部类的原因：
 * 内部类的优势在于如果我们拥有的是抽象的类或者具体的类，而不是接口，那么我们只能去使用内部类了
 * ？？？
 * 内部类实现多重继承
 *
 * groovy 给的原因：
 * 1.They increase encapsulation by hiding the inner class from other classes, which do not need to know about it. This also leads to cleaner packages and workspaces.
 * 2.They provide a good organization, by grouping classes that are used by only one class.
 * 3.They lead to more maintainable codes, since inner classes are near the classes that use them.
 *
 */
class Outer {
    private String privateStr

    def callInnerMethod() {
        new Inner().methodA()
    }

    class Inner {
        def methodA() {
            println "${privateStr}."
        }
    }
}

class Outer2 {
    private String privateStr = 'some string'

    def startThread() {
        new Thread(new Inner2()).start()
    }

    class Inner2 implements Runnable {
        void run() {
            println "${privateStr}."
        }
    }
}

class Computer {
    class Cpu {
        int coreNumber

        Cpu(int coreNumber) {
            this.coreNumber = coreNumber
        }
    }
}

//assert 4 == new Computer().new Cpu(4).coreNumber

/**
 * Anonymous inner class
 * 匿名内部类
 */

class Outer3 {
    private String privateStr = 'some string'

    def startThread() {
        new Thread(new Runnable() {
            void run() {
                println "${privateStr}."
            }
        }).start()
    }
}

/**
 * Abstract class
 * 抽象类
 *
 * 接口也可以写default方法，是类方法
 */
abstract class Abstract {
    String name

    abstract def abstractMethod()

    def concreteMethod() {
        println 'concrete'
    }
}

/**
 * Inheritance
 * 继承
 */


/**
 * Interfaces
 */
interface Greeter {
    void greet(String name)
}

class SystemGreeter implements Greeter {
    void greet(String name) {
        println "Hello $name"
    }
}

def greeter = new SystemGreeter()
assert greeter instanceof Greeter

/**
 * 接口 可以继承 接口
 */
interface ExtendedGreeter extends Greeter {
    void sayBye(String name)
}

/**
 * Class members
 */

/**
 * Constructors
 *
 * Constructors are special methods used to initialize an object with a specific state. As with normal methods, it is possible for a class to declare more than one constructor, so long as each constructor has a unique type signature. If an object doesn’t require any parameters during construction, it may use a no-arg constructor. If no constructors are supplied, an empty no-arg constructor will be provided by the Groovy compiler.
 *
 */

/**
 * Positional parameters
 * 位置参数
 */
class PositionalConstructor {
    String name
    Integer age

    /*Constructor declaration*/

    PositionalConstructor(name, age) {
        this.name = name
        this.age = age
    }

    @Override
    String toString() {
        return "name:$name,age:$age"
    }
}
//def p1 = new PasswordAuthentication();
/*Constructor invocation, classic Java way*/
def pc2 = new PositionalConstructor('hello', 9)
/*Constructor usage, using coercion with as keyword*/
def pc3 = ['hello', 9] as PositionalConstructor
/*Constructor usage, using coercion in assignment*/
PositionalConstructor pc4 = ['hello', 9]

/**
 * Named parameters
 */
class NamedConstructor {
    String name
    Integer age

    @Override
    String toString() {
        return "name:$name,age:$age"
    }
}

def nc1 = new NamedConstructor(name: 'hello')
def nc2 = new NamedConstructor(name: 'hello', age: 9)
assert nc1.name == 'hello'
assert nc2.toString() == 'name:hello,age:9'

/**
 * Methods
 */

/**
 * Method definition
 *
 * A method is defined with a return type or with the def keyword, to make the return type untyped. A method can also receive any number of arguments, which may not have their types explicitly declared. Java modifiers can be used normally, and if no visibility modifier is provided, the method is public.
 *
 */

/*Method with no return type declared and no parameter*/

def someMethod() { 'method called' }
/*Method with explicit return type and no parameter*/

String anotherMethod() { 'another method called' }
/*Method with a parameter with no type defined*/

def thirdMethod(param1) { "$param1 passed" }
/*Static method with a String parameter*/

static String fourthMethod(String param1) { "$param1 passed" }

/**
 * Named parameters
 */
def foo(Map args) {
    "${args.name}:${args.age}"
}
assert foo(name: "Lilei", age: 12) == 'Lilei:12'
/**
 * Mixing named and positional parameters
 *
 * Map 类型接收参数必须设置为第一个参数
 */
def foo(Map args, Integer number) { "${args.name}: ${args.age}, and the number is ${number}" }
foo(name: 'Marie', age: 1, 23)
foo(23, name: 'Marie', age: 1)

//def bar(Integer number, Map args) { "${args.name}: ${args.age}, and the number is ${number}" }
//println bar(name: 'Marie', age: 1, 23)

/**
 * Default arguments
 */
def foo(String par1, Integer par2 = 1) { [name: par1, age: par2] }
assert foo('Marie').age == 1
def baz(a = 'a', int b, c = 'c', boolean d, e = 'e') { "$a $b $c $d $e" }
assert baz(42, true) == 'a 42 c true e'
assert baz('A', 42, true) == 'A 42 c true e'
assert baz('A', 42, 'C', true) == 'A 42 C true e'
assert baz('A', 42, 'C', true, 'E') == 'A 42 C true E'

/**
 * Varargs
 * 可变参数
 */
def foo1(Object... args) { args.length }
assert foo1() == 0
assert foo1(1) == 1
assert foo1(1, 2) == 2

def foo2(Object[] args) { args.length }
assert foo2() == 0
assert foo2(1) == 1
assert foo2(1, 2) == 2

def foo3(Object... args) { args }
assert foo3(null) == null

def foo4(Object... args) { args }
Integer[] ints = [1, 2]
assert foo4(ints) == [1, 2]

/**
 * Method selection algorithm
 * 重载
 * todo 复杂的重载
 */
def method(Object o1, Object o2) { 'o/o' }
def method(Integer i, String  s) { 'i/s' }
def method(String  s, Integer i) { 's/i' }

List<List<Object>> pairs = [['foo', 1], [2, 'bar'], [3, 4]]
assert pairs.collect { a, b -> method(a, b) } == ['s/i', 'i/s', 'o/o']

/**
 * Fields and Properties
 */

/**
 * Fields
 *
 * a mandatory access modifier (public, protected, or private)
 * 强制操作符：public,protected,private
 *
 * one or more optional modifiers (static, final, synchronized)
 * 可选操作符：static,final,synchronized
 *
 */
class Data {
    private int id
    protected String description
    public static final boolean DEBUG = false
}

/**
 * Properties
 *
 * A property is an externally visible feature of a class
 * 外部可见的特征
 */

class Animal {
    int lowerCount = 0
    @Lazy String name = { lower().toUpperCase() }()
    String lower() { lowerCount++; 'sloth' }
}

def a = new Animal()
assert a.lowerCount == 0
assert a.name == 'SLOTH'
assert a.lowerCount == 1


class HasPropertyWithPackagePrivateField {
    String name1
    @PackageScope String name2
}

/**
 * Annotations
 */

/**
 * Annotation definition
 * 注解的声明方式
 */
@interface StringAnnotation {
    String value()
}
@interface DefaultStringAnnotation {
    String value() default 'something'
}
@interface IntAnnotation {
    int step()
}
@interface ClassAnnotation {
    Class appliesTo()
}
@interface AnnAnnotation {}
@interface AnnAnnotations {
    AnnAnnotation[] value()
}
enum DayOfWeek { mon, tue, wed, thu, fri, sat, sun }
@interface ScheduledAnnotation {
    DayOfWeek dayOfWeek()
}

/**
 * Annotation placement
 * 注解位置
 * method
 * class
 * var
 */
@Target([ElementType.METHOD, ElementType.TYPE])
@interface SomeAnnotation {}

/**
 * Annotation member values
 *
 */
@interface Page {
    int statusCode()
}
@Page(statusCode=404)
void notFound() {}

/**
 * value: 默认值
 * we can omit the statusCode because it has a default value, but value needs to be set
 */
@interface Value{
    String value()
}
@Value("hello")
void notFound1() {}

/**
 * Retention policy
 */




































