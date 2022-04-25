/**
 * Syntax
 * {}
 */

/**
 * defining a closure
 */
def c1 = { -> println() }
def c2 = { 4 }
def c3 = { it -> println it }
def c4 = { String x, int y -> println "hey ${x} the value is ${x}" }
def c5 = { ret = [] << 6 } // { ret = [] << 6, return ret }
def c6 = { -> 6 } // 懒加载
def c7 = { int x = 1, int y = 2 -> x + y }

/**
 * Closures as an object
 */
def fun1 = { e -> println("$e.value") }
assert fun1 instanceof Closure
Closure<Boolean> fun2 = {
    int x -> x == 1
}
fun1([value: "haha"])
println(fun2(10))
println(fun2(1))

/**
 * Calling a closure
 * call 方法
 */
def code = { 123 }
assert code() == 123
assert code() == code.call()
println(code.call())

/**
 * Parameters
 */

/**
 * Normal parameters
 */

/**
 * Implicit parameter
 * it 隐式参数
 *
 * When a closure does not explicitly define a parameter list (using ->),
 * a closure always defines an implicit parameter, named it.
 *
 * 默认会给个隐式参数 it。如 {xx},{it->xx}
 * 如果不想使用任何参数，可以指定一个空参数。如 {-> xx}
 */
def ic1 = { "hello，$it!" }
def ic2 = { it -> "hello，$it!" }
assert ic1("world") == ic2("world")
println(ic1("world"))
println(ic2("world"))

/**
 * Varargs
 * 可变参数
 */
def args1 = { String... args -> args.join(',') }
def args2 = { String[] args -> args.join(',') }
def args3 = { int a, String... args -> args.join('') * a }
println(args1('a', 'b', 'c'))
println(args2('a', 'b', 'c'))
println(args3(3, 'a', 'b', 'c'))


/**
 * Delegation strategy
 * 授权策略
 *
 * Groovy defines closures as instances of the Closure class.
 * It makes it very different from lambda expressions in Java 8.
 * Delegation is a key concept in Groovy closures which has no equivalent in lambdas. The ability to change the delegate or change the delegation strategy of closures make it possible to design beautiful domain specific languages (DSLs) in Groovy.
 *
 * Groovy 将闭包定义为 Closure 类的实例。
 * 它使它与 Java 8 中的 lambda 表达式非常不同。
 * 委托是 Groovy 闭包中的一个关键概念，在 lambda 中没有相同的概念。
 * 更改委托或更改闭包的委托策略的能力使得在 Groovy 中设计漂亮的领域特定语言 (DSL) 成为可能。
 *
 * this
 * corresponds to the enclosing class where the closure is defined
 * 对应于定义闭包的封闭类
 *
 * owner
 * corresponds to the enclosing object where the closure is defined,
 * which may be either a class or a closure
 * 对应于定义闭包的封闭对象，可以是类或闭包
 *
 * delegate
 * corresponds to a third party object where methods calls or properties are resolved whenever the receiver of the message is not defined
 * 委托对应于第三方对象，只要未定义消息的接收者，就会解析方法调用或属性
 *
 */


/**
 * Closures in GStrings
 * ${-> xx} 懒加载
 */
def param = 1
def funs1 = "x = ${param}"
def funs2 = "x = ${-> param}"
assert funs1 == 'x = 1'
assert funs2 == 'x = 1'
assert "$funs1" == 'x = 1'
assert "$funs2" == 'x = 1'
param = 2
println(funs1)
println(funs2)

/**
 * Currying
 * 柯里化
 *
 * In Groovy, currying refers to the concept of partial application. It does not correspond to the real concept of currying in functional programming because of the different scoping rules that Groovy applies on closures. Currying in Groovy will let you set the value of one parameter of a closure, and it will return a new closure accepting one less argument.
 *
 * 在计算机科学中，柯里化（Currying）是把接受多个参数的函数变换成接受一个单一参数(最初函数的第一个参数)的函数，
 * 并且返回接受余下的参数且返回结果的新函数的技术。
 *
 */

/**
 * left currying
 */
def nCopies = { int n, String str -> str * n }
def ldemo = nCopies.curry(2)
assert ldemo('bla') == 'blabla'
assert ldemo('bla') == nCopies(2, 'bla')
/**
 * right currying
 */
def rdemo = nCopies.rcurry('bla')
assert rdemo(2) == 'blabla'
assert rdemo(2) == nCopies(2, 'bla')
/**
 * index based currying
 */
def volume = { double l, double w, double h -> l * w * h }
def fixedWidthVolume = volume.ncurry(1, 2d)
assert volume(3d, 2d, 4d) == fixedWidthVolume(3d, 4d)
def fixedWidthAndHeight = volume.ncurry(1, 2d, 4d)
assert volume(3d, 2d, 4d) == fixedWidthAndHeight(3d)

/**
 * Memoization
 * 记忆化允许缓存调用闭包的结果。
 * 一个典型的例子是斐波那契套件。
 *
 * 递归？
 *
 * 不太懂，为啥快了
 */
def fib
fib = { long n -> n < 2 ? n : fib(n - 1) + fib(n - 2) }
assert fib(15) == 610 // slow!

/**
 * 其他方法：
 * memoizeAtMost will generate a new closure which caches at most n values
 * memoizeAtLeast will generate a new closure which caches at least n values
 * memoizeBetween will generate a new closure which caches at least n values and at most n values
 *
 * The cache used in all memoize variants is a LRU cache.
 * LRU缓存
 *
 */
fib = { long n -> n<2?n:fib(n-1)+fib(n-2) }.memoize()
assert fib(25) == 75025 // fast!

/**
 * Closure composition corresponds to the concept of function composition,
 * that is to say creating a new function by composing two or more functions (chaining calls),
 *
 * 链式调用
 *
 */
def plus2  = { it + 2 }
def times3 = { it * 3 }

def times3plus2 = plus2 << times3
println(times3plus2(2))
assert times3plus2(3) == 11
assert times3plus2(4) == plus2(times3(4))

def plus2times3 = times3 << plus2
assert plus2times3(3) == 15
assert plus2times3(5) == times3(plus2(5))

// reverse composition
assert times3plus2(3) == (times3 >> plus2)(3)

def func1 = {it + 2}
def func2 = {it * 3}
def func21_1 =  func2 << func1
println(func21_1(2))
assert func21_1(2) == func2(func1(2))
def func21_2 = func1 >> func2
assert func21_2(2) == func2(func1(2))
assert func2(func1(2)) == (func1 >> func2)(2)

/**
 * Recursive algorithms are often restricted by a physical limit: the maximum stack height. For example, if you call a method that recursively calls itself too deep, you will eventually receive a StackOverflowException.
 *
 * An approach that helps in those situations is by using Closure and its trampoline capability. Closures are wrapped in a TrampolineClosure. Upon calling, a trampolined Closure will call the original Closure waiting for its result. If the outcome of the call is another instance of a TrampolineClosure, created perhaps as a result to a call to the trampoline() method, the Closure will again be invoked. This repetitive invocation of returned trampolined Closures instances will continue until a value other than a trampolined Closure is returned. That value will become the final result of the trampoline. That way, calls are made serially, rather than filling the stack.
 *
 * 递归算法通常受到物理限制的限制：最大堆栈高度。
 * 例如，如果你调用一个递归调用自身太深的方法，你最终会收到一个 StackOverflowException。
 * 在这些情况下有帮助的一种方法是使用 Closure 及其 trampoline 功能。
 * 闭包被包裹在 TrampolineClosure 中。
 * 调用时，蹦床闭包将调用原始闭包等待其结果。
 * 如果调用的结果是 TrampolineClosure 的另一个实例，可能是由于调用 trampoline() 方法而创建的，则将再次调用 Closure。
 * 返回的 trampoline 闭包实例的这种重复调用将继续，直到返回蹦床闭包以外的值。
 * 该值将成为蹦床的最终结果。 这样，调用是连续进行的，而不是填充堆栈。
 *
 * 当我们调用trampoline()方法时，该闭包会直接返回一个特殊类TrampolineClosure的一个实例。
 * 当我们向该实例传递参数时，比如像factorial(5, 1)中这样，其实是调用了该实例的call()方法。
 * 该方法使用了一个简单的for循环来调用闭包上的call方法，直到不再产生TrampolineClosure的实例。
 * 这种简单的技术在背后将递归调用转换成了一个简单的迭代。
 *
 */
def factorial
factorial = { int n, def accu = 1G ->
    if (n < 2) return accu
    factorial.trampoline(n - 1, n * accu)
}
factorial = factorial.trampoline()

assert factorial(1)    == 1
assert factorial(3)    == 1 * 2 * 3
assert factorial(1000) // == 402387260.. plus another 2560 digits

/**
 * Method pointers
 * 方法指针
 */