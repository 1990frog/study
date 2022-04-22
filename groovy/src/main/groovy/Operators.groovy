import groovy.transform.EqualsAndHashCode

/**
 * 操作符
 * + addition
 * - subtraction
 * * multiplication
 * / division
 * % remainder
 * ** power
 */

assert  1  + 2 == 3
assert  4  - 3 == 1
assert  3  * 5 == 15
assert  3  / 2 == 1.5
assert 10  % 3 == 1
assert  2 ** 3 == 8

assert +3 == 3
assert -4 == 0 - 4

assert -(-1) == 1

def a = 2
def b = a++ * 3

assert a == 3 && b == 6

def c = 3
def d = c-- * 2

assert c == 2 && d == 6

def e = 1
def f = ++e + 3

assert e == 2 && f == 5

def g = 4
def h = --g + 1

assert g == 3 && h == 4

/**
 * 赋值运算符
 * +=
 * -=
 * *=
 * /=
 * %=
 * **=
 */
def i = 4
i += 3
assert i == 7

def j = 5
j -= 3
assert j == 2

def k = 5
k *= 3
assert k == 15

def l = 10
l /= 2
assert l == 5
//
//def m2 = 10
//m2 %= 3
//assert m2 = 1

def n = 3
n **= 2
assert n == 9

/**
 * 比较运算符
 * == equal
 * != different
 * < less than
 * <= less than or equal
 * > greater than
 * >= greater than or equal
 * === identical
 * !== not identical
 */
assert 1 + 2 == 3
assert 3 != 4

assert -2 < 3
assert 2 <= 2
assert 3 <= 4

assert 5 > 1
assert 5 >= -2

@EqualsAndHashCode
class Creature { String type }

def cat = new Creature(type: 'cat')
def copyCat = cat
def lion = new Creature(type: 'cat')

assert cat.equals(lion) // Java logical equality
assert cat == lion      // Groovy shorthand operator

assert cat.is(copyCat)  // Groovy identity
assert cat === copyCat  // operator shorthand
assert cat !== lion     // negated operator shorthand

/**
 * 逻辑运算符
 * && and
 * || or
 * ! not
 */
assert !false
assert true && true
assert true || false

/**
 * 优先级
 * ! > &&
 * && > ||
 */
assert (!false && false) == false
assert true || true && false

/**
 * 逻辑短路
 */
boolean checkIfCalled() {
    called = true
}

called = false
true || checkIfCalled()
assert !called

called = false
false || checkIfCalled()
assert called

called = false
false && checkIfCalled()
assert !called

called = false
true && checkIfCalled()
assert called

/**
 * 位运算
 * &: bitwise "and"
 * |: bitwise "or"
 * ^: bitwise "xor" (exclusive "or")
 * ~: bitwise negation
 */
//int bita = 0b00101010
//assert bita == 42
//int bitb = 0b00001000
//assert b == 8
///*bitwise and*/
//assert (bita & bita) == bita
///*bitwise and returns common bits*/
//assert (bita & bitb) == bitb
///*bitwise or*/
//assert (bita | bita) == bita
///*bitwise or returns all '1' bits*/
//assert (bita | bitb) == bita
///*setting a mask to check only the last 8 bits*/
//int mask = 0b11111111
///*bitwise exclusive or on self returns 0*/
//assert ((bita ^ bita) & mask) == 0b00000000
///*bitwise exclusive or*/
//assert ((bita ^ bitb) & mask) == 0b00100010
///*bitwise negation*/
//assert ((~bita) & mask)    == 0b11010101

/**
 * 位移运算符
 * <<: left shift
 * >>: right shift
 * >>>: right shift unsigned
 */
assert 12.equals(3 << 2)
assert 24L.equals(3L << 3)
assert 48G.equals(3G << 4)

assert 4095 == -200 >>> 20
assert -1 == -200 >> 20
assert 2G == 5G >> 1
assert -3G == -5G >> 1

/**
 * Not operator
 */
assert (!true)    == false
assert (!'foo')   == false
assert (!'')      == true
/**
 * Ternary operator
 */
def string = "string"
def user = ["name":null]
def result1 = (string!=null && string.length()>0) ? 'Found' : 'Not found'
def result2 = string ? 'Found' : 'Not found'
def displayName1 = user.name ? user.name : 'Anonymous'
def displayName2 = user.name ?: 'Anonymous'

/**
 * Elvis assignment operator
 */
import groovy.transform.ToString
@ToString
class Element {
    String name
    int atomicNumber
}
def he = new Element(name: 'Helium')
he.with {
    name = name ?: 'Hydrogen'   // existing Elvis operator
    atomicNumber ?= 2           // new Elvis assignment shorthand
}
assert he.toString() == 'Element(Helium, 2)'

/**
 * Object operators
 */

/*Safe navigation operator*/
//def person = Person.find { it.id == 123 }
//def name = person?.name
//assert name == null
//println(person)

/*Direct field access operator*/
class User {
    public final String name
    User(String name) { this.name = name}
    String getName() { "Name: $name" }
}
def userInstance = new User('Bob')
assert userInstance.name == 'Name: Bob'

assert userInstance.@name == 'Bob'

println(userInstance.@name)

/**
 * Method pointer operator
 * 方法指针运算符
 */
/*the str variable contains a String*/
def str = 'example of method reference'
/*we store a reference to the toUpperCase method on the str instance inside a variable named fun*/
def fun = str.&toUpperCase
/*fun can be called like a regular method*/
def upper = fun()
/*we can check that the result is the same as if we had called it directly on str*/
assert upper == str.toUpperCase()


class Person{
    String name
    Integer age
}
def transform(List elements, Closure action) {
    def result = []
    elements.each {
        result << action(it)
    }
    result
}
String describe(Person p) {
    "$p.name is $p.age"
}
def action = this.&describe
def list = [
        new Person(name: 'Bob',   age: 42),
        new Person(name: 'Julia', age: 35)]
assert transform(list, action) == ['Bob is 42', 'Julia is 35']

def doSomething(String str) { str.toUpperCase() }
def doSomething(Integer x) { 2*x }
def reference = this.&doSomething
assert reference('foo') == 'FOO'
assert reference(123)   == 246

def foo  = BigInteger.&new
def fortyTwo = foo('42')
assert fortyTwo == 42G

def instanceMethod = String.&toUpperCase
assert instanceMethod('foo') == 'FOO'

/**
 * Method reference operator
 */
import groovy.transform.CompileStatic
import static java.util.stream.Collectors.toList

@CompileStatic
void methodRefs() {
    assert 6G == [1G, 2G, 3G].stream().reduce(0G, BigInteger::add)
    assert [4G, 5G, 6G] == [1G, 2G, 3G].stream().map(3G::add).collect(toList())
    assert [1G, 2G, 3G] == [1L, 2L, 3L].stream().map(BigInteger::valueOf).collect(toList())
    assert [1G, 2G, 3G] == [1L, 2L, 3L].stream().map(3G::valueOf).collect(toList())
}
methodRefs()

@CompileStatic
void constructorRefs() {
    assert [1, 2, 3] == ['1', '2', '3'].stream().map(Integer::new).collect(toList())
    def result = [1, 2, 3].stream().toArray(Integer[]::new)
    assert result instanceof Integer[]
    assert result.toString() == '[1, 2, 3]'
}
constructorRefs()














