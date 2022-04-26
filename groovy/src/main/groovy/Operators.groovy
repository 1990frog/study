/**
 * Arithmetic operators
 * 算术运算符
 *
 */

/**
 * Normal arithmetic operators
 * 普通算术运算符
 * +    addition
 * -    substraction
 * *    multiplication
 * /    division
 * %    remainder
 * **   power
 * ++   increment
 * --   decrement
 */
assert 1 + 2 == 3
assert 4 - 3 == 1
assert 3 * 5 == 15
assert 3 / 2 == 1.5
assert 10 % 3 == 1
assert 2**3 == 8
assert +3 == 3
assert -4 == 0 - 4
assert -(-1) == 1

var a = 1++
var b = a++ + 1
assert a == b

/**
 * Assignment arithmetic operators
 * +=
 * -=
 * *=
 * /=
 * %=
 * **=
 */


/**
 * Relational operators
 * ==   equal
 * !=   different
 * <    less than
 * <=   less than or equal
 * >    greater than
 * >=   greater than or equal
 * ===  identical
 * !==  not identical
 *
 * Both === and !== are supported which are the same as calling the is() method, and negating a call to the is() method respectively.
 *
 */
var arg1 = 'test'
var arg2 = arg1
assert arg1.is(arg2)
assert arg1 === arg2

/**
 * Logical operators
 *
 * &&   and
 * ||   or
 * !    not
 *
 *
 * 优先级（Precedence）
 * not > and
 * and > or
 *
 */
assert true == !false
assert true && true
//assert !(true || false)

/**
 * Short-circuiting
 * 逻辑短路
 * true && false = false
 * true || false = true
 */
def check() {
//    println("check")
    return true
}

false || check()
true || check()

/**
 * Bitwise and bit shift operators
 *
 * bitwise operators
 * &    and
 * |    or
 * ^    xor
 * ~    negation
 *
 * bit shift opeartors
 * <<   left shift
 * >>   right shift
 * >>>  right shift unsigned
 */


/**
 * Conditional operators
 * 条件操作符
 */

/*not operator*/
assert (!true) == false
/*ternary operator*/
if (true) {
    println()
} else {
    println()
}
/*elvis operator*/
var b1 = true ? "true" : "false"
/*Elvis运算符(?:)，符号前为空，返回符号后的值*/
var b2 = null
var b3 = b2 ?: "true"
println(b2)
println(b3)
/*判断引用为空*/
println(null ?: "false")

var map1 = [name: 1, gender: 1]
println map1?.name
println map1?.hello

/**
 * Object operators
 *
 * find 方法咋用？
 *
 */
var Person = [[id: 1, name: 1], [id: 2, name: 2]]
//def person = Person.find { it.id == 123 }
///*null-safe operator*/
//def name = person?.name

/*null-safe operator*/
assert Person ?[0]?.name == 1
/*direct access operator*/
assert Person[0].name == 1

/**
 * Method pointer operator
 * 方法指针
 *
 * The method pointer operator (.&) can be used to store a reference to a method in a variable
 *
 * 不存在c语言那种套娃，只有一个句柄
 *
 */
def fun = { it }
var str = 'hello,world!'
var strp = str.&toUpperCase
var funInStrp = strp >> fun
println(funInStrp())

/**
 *
 *
 */
def applepen(String[] apple, Closure pen) {
    def ret = []
    apple.each { ret << pen(it) }
    return ret
}

var apple = ['a', 'b', 'c', 'd'] as String[]
def pen = String.&toUpperCase
println applepen(apple, pen)

/**
 * new 指向构造函数
 */
def foo = Integer.&new
//def foo = BigInteger.&new
var bar = foo(2**31 - 1)
println bar

/**
 * :: Parrot parser 鹦鹉表达式
 */
/*class instance method reference: add(BigInteger val) is an instance method in BigInteger*/
assert 6G == [1G, 2G, 3G].stream().reduce(0G, BigInteger::add)
/*object instance method reference: add(BigInteger val) is an instance method for object 3G*/
assert [4G, 5G, 6G] == [1G, 2G, 3G].stream().map(3G::add).collect()
/*class static method reference: valueOf(long val) is a static method for class BigInteger*/
assert [1G, 2G, 3G] == [1L, 2L, 3L].stream().map(BigInteger::valueOf).collect()
// 对象静态方法参考： valueOf(long val) 是对象 3G 的静态方法（一般情况下有人认为这种风格不好）
/*object static method reference: valueOf(long val) is a static method for object 3G (some consider this bad style in normal circumstances)*/
assert [1G, 2G, 3G] == [1L, 2L, 3L].stream().map(3G::valueOf).collect()
/*class constructor reference*/
//assert [1, 2, 3] == ['1', '2', '3'].stream().map(Integer::new).collect(toList())

/**
 * Regular expression operators
 */


/**
 * Spread operator
 * 展开运算符(*)
 * cars*.make is equivalent to cars.collect{ it.make }
 *
 * syntax:
 * 1. object list: array*.element
 * 2. mehtod arguments: def func(*args)
 * 3. list: [1,2,3,*sublist,4]
 * 4. map: [a:1,b:2,*:submap]
 *
 */

/**
 * 应用于对象数组
 */
var list = [[name: 'lilei', gender: '男']]
var spreadList1 = list*.gender
/*using the spread operator will not throw a NullPointerException*/
var spreadList2 = list*.address
println(spreadList1)
println(spreadList2)


/**
 * Spreading method arguments
 * 展开方法参数
 */
def func(int x, int y, int z) {
    x**y**z
}

var args = [2, 2, 2]
println(func(args))
/*将[2,2,2]展开为2,2,2*/
println(func(*args))

/**
 * Spread list elements
 */
var subList = [4, 5, 6, 7, 8]
def mylist = [1, 2, 3, *subList, 9]
println(mylist)

/**
 * Spread map elements
 */
def m1 = [c: 3, d: 4]
def map = [a: 1, b: 2, *: m1]
println(map)

/**
 * Range operator
 */
assert (0..5).collect() == [0, 1, 2, 3, 4, 5]
assert (0..<5).collect() == [0, 1, 2, 3, 4]
assert (0<..5).collect() == [1, 2, 3, 4, 5]
assert (0<..<5).collect() == [1, 2, 3, 4]
assert (0..5) instanceof List
assert (0..5).size() == 6

/**
 * Spaceship operator
 * <=> 等同于 compaerTo 方法
 *
 * 结果：
 * > : 1
 * = : 0
 * < : -1
 */
assert (1 <=> 1) == 0
assert (1 <=> 2) == -1
assert (2 <=> 1) == 1
assert ('a' <=> 'z') == -1

/**
 * Subscript operator
 */
var numberList = [1,2,3,4,5]
assert numberList[0..2] == [1,2,3]
numberList[0..2] = [3,3,3]
println(numberList)

/**
 * safe index operator
 * 先校验对象是否存在，类似加个ifnull
 *
 * array?[0]    array存在，输出
 * array?:"error"   array不存在，输出error
 */
String[] array = ['a','b']
array = null
println(array?[0])
var ret = array?:"ff"
println(ret)

/**
 * Membership operator
 */
def dict = [1,2,3]
assert 1 in dict

/**
 * Coercion operator
 * 强制指定类型
 */
var v1 = 1 as Integer
assert v1 instanceof Integer
var v2 = [1,2,3] as int[]
assert v2 instanceof int []

/**
 * Diamond operator
 * 泛型
 */
List<String> strings = new LinkedList<>()

/**
 * Call operator
 */
class Callable{
    int call(int x){
        2*x
    }
}
def mc = new Callable()
//mc = Callable.&new
println mc(2)
println mc.call(2)

/**
 * Operator overloading
 *
 * 所有（非比较器）Groovy 运算符都有相应的方法，您可以在自己的类中实现该方法。
 * 唯一的要求是您的方法是公开的，具有正确的名称，并且具有正确数量的参数。
 * 参数类型取决于您想要在运算符右侧支持的类型。
 *
 * +        a.plus(b)
 * -        a.minus(b)
 * *        a.multiply(b)
 * /        a.div(b)
 * %        a.mod(b)
 * **       a.power(b)
 * |        a.or(b)
 * &        a.and(b)
 * ^        a.xor(b)
 * as       a.asType(b)
 * a()      a.call()
 * a[b]     a.getAt(b)
 * a[b]=c   a.putAt(b,c)
 * a in c   b.isCase(a)
 * <<       a.leftShift(b)
 * >>       a.rightShift(b)
 * >>>      a.rightShiftUnsigned(b)
 * ++       a.next()
 * --       a.previous()
 * +a       a.positive()
 * -a       a.negative()
 * ~a       a.bitwiseNegate()
 *
 */
class Bucket{
    int size;
    Bucket(int size){
        this.size = size
    }
    Bucket plus(Bucket other) {
        return new Bucket(this.size + other.size)
    }
}
def bt1 = new Bucket(1)
def bt2 = new Bucket(2)
println((bt1+bt2).size)




