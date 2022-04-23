//import groovy.transform.Canonical
//import groovy.transform.EqualsAndHashCode
//
///**
// * 操作符
// * + addition
// * - subtraction
// * * multiplication
// * / division
// * % remainder
// * ** power
// */
//
//assert  1  + 2 == 3
//assert  4  - 3 == 1
//assert  3  * 5 == 15
//assert  3  / 2 == 1.5
//assert 10  % 3 == 1
//assert  2 ** 3 == 8
//
//assert +3 == 3
//assert -4 == 0 - 4
//
//assert -(-1) == 1
//
//def a = 2
//def b = a++ * 3
//
//assert a == 3 && b == 6
//
//def c = 3
//def d = c-- * 2
//
//assert c == 2 && d == 6
//
//def e = 1
//def f = ++e + 3
//
//assert e == 2 && f == 5
//
//def g = 4
//def h = --g + 1
//
//assert g == 3 && h == 4
//
///**
// * 赋值运算符
// * +=
// * -=
// * *=
// * /=
// * %=
// * **=
// */
//def i = 4
//i += 3
//assert i == 7
//
//def j = 5
//j -= 3
//assert j == 2
//
//def k = 5
//k *= 3
//assert k == 15
//
//def l = 10
//l /= 2
//assert l == 5
////
////def m2 = 10
////m2 %= 3
////assert m2 = 1
//
//def n = 3
//n **= 2
//assert n == 9
//
///**
// * 比较运算符
// * == equal
// * != different
// * < less than
// * <= less than or equal
// * > greater than
// * >= greater than or equal
// * === identical
// * !== not identical
// */
//assert 1 + 2 == 3
//assert 3 != 4
//
//assert -2 < 3
//assert 2 <= 2
//assert 3 <= 4
//
//assert 5 > 1
//assert 5 >= -2
//
//@EqualsAndHashCode
//class Creature { String type }
//
//def cat = new Creature(type: 'cat')
//def copyCat = cat
//def lion = new Creature(type: 'cat')
//
//assert cat.equals(lion) // Java logical equality
//assert cat == lion      // Groovy shorthand operator
//
//assert cat.is(copyCat)  // Groovy identity
//assert cat === copyCat  // operator shorthand
//assert cat !== lion     // negated operator shorthand
//
///**
// * 逻辑运算符
// * && and
// * || or
// * ! not
// */
//assert !false
//assert true && true
//assert true || false
//
///**
// * 优先级
// * ! > &&
// * && > ||
// */
//assert (!false && false) == false
//assert true || true && false
//
///**
// * 逻辑短路
// */
//boolean checkIfCalled() {
//    called = true
//}
//
//called = false
//true || checkIfCalled()
//assert !called
//
//called = false
//false || checkIfCalled()
//assert called
//
//called = false
//false && checkIfCalled()
//assert !called
//
//called = false
//true && checkIfCalled()
//assert called
//
///**
// * 位运算
// * &: bitwise "and"
// * |: bitwise "or"
// * ^: bitwise "xor" (exclusive "or")
// * ~: bitwise negation
// */
////int bita = 0b00101010
////assert bita == 42
////int bitb = 0b00001000
////assert b == 8
/////*bitwise and*/
////assert (bita & bita) == bita
/////*bitwise and returns common bits*/
////assert (bita & bitb) == bitb
/////*bitwise or*/
////assert (bita | bita) == bita
/////*bitwise or returns all '1' bits*/
////assert (bita | bitb) == bita
/////*setting a mask to check only the last 8 bits*/
////int mask = 0b11111111
/////*bitwise exclusive or on self returns 0*/
////assert ((bita ^ bita) & mask) == 0b00000000
/////*bitwise exclusive or*/
////assert ((bita ^ bitb) & mask) == 0b00100010
/////*bitwise negation*/
////assert ((~bita) & mask)    == 0b11010101
//
///**
// * 位移运算符
// * <<: left shift
// * >>: right shift
// * >>>: right shift unsigned
// */
//assert 12.equals(3 << 2)
//assert 24L.equals(3L << 3)
//assert 48G.equals(3G << 4)
//
//assert 4095 == -200 >>> 20
//assert -1 == -200 >> 20
//assert 2G == 5G >> 1
//assert -3G == -5G >> 1
//
///**
// * Not operator
// */
//assert (!true)    == false
//assert (!'foo')   == false
//assert (!'')      == true
///**
// * Ternary operator
// */
//def string = "string"
//def user = ["name":null]
//def result1 = (string!=null && string.length()>0) ? 'Found' : 'Not found'
//def result2 = string ? 'Found' : 'Not found'
//def displayName1 = user.name ? user.name : 'Anonymous'
//def displayName2 = user.name ?: 'Anonymous'
//
///**
// * Elvis assignment operator
// */
//import groovy.transform.ToString
//@ToString
//class Element {
//    String name
//    int atomicNumber
//}
//def he = new Element(name: 'Helium')
//he.with {
//    name = name ?: 'Hydrogen'   // existing Elvis operator
//    atomicNumber ?= 2           // new Elvis assignment shorthand
//}
//assert he.toString() == 'Element(Helium, 2)'
//
///**
// * Object operators
// */
//
///*Safe navigation operator*/
////def person = Person.find { it.id == 123 }
////def name = person?.name
////assert name == null
////println(person)
//
///*Direct field access operator*/
//class User {
//    public final String name
//    User(String name) { this.name = name}
//    String getName() { "Name: $name" }
//}
//def userInstance = new User('Bob')
//assert userInstance.name == 'Name: Bob'
//
//assert userInstance.@name == 'Bob'
//
//println(userInstance.@name)
//
///**
// * Method pointer operator
// * 方法指针运算符
// */
///*the str variable contains a String*/
//def str = 'example of method reference'
///*we store a reference to the toUpperCase method on the str instance inside a variable named fun*/
//def fun = str.&toUpperCase
///*fun can be called like a regular method*/
//def upper = fun()
///*we can check that the result is the same as if we had called it directly on str*/
//assert upper == str.toUpperCase()
//
//
//class Person{
//    String name
//    Integer age
//}
//def transform(List elements, Closure action) {
//    def result = []
//    elements.each {
//        result << action(it)
//    }
//    result
//}
//String describe(Person p) {
//    "$p.name is $p.age"
//}
//def action = this.&describe
//def list = [
//        new Person(name: 'Bob',   age: 42),
//        new Person(name: 'Julia', age: 35)]
//assert transform(list, action) == ['Bob is 42', 'Julia is 35']
//
//def doSomething(String str) { str.toUpperCase() }
//def doSomething(Integer x) { 2*x }
//def reference = this.&doSomething
//assert reference('foo') == 'FOO'
//assert reference(123)   == 246
//
//def foo  = BigInteger.&new
//def fortyTwo = foo('42')
//assert fortyTwo == 42G
//
//def instanceMethod = String.&toUpperCase
//assert instanceMethod('foo') == 'FOO'
//
///**
// * Method reference operator
// */
//import groovy.transform.CompileStatic
//
//import java.util.regex.Matcher
//import java.util.regex.Pattern
//
//import static java.util.stream.Collectors.toList
//
//@CompileStatic
//void methodRefs() {
//    assert 6G == [1G, 2G, 3G].stream().reduce(0G, BigInteger::add)
//    assert [4G, 5G, 6G] == [1G, 2G, 3G].stream().map(3G::add).collect(toList())
//    assert [1G, 2G, 3G] == [1L, 2L, 3L].stream().map(BigInteger::valueOf).collect(toList())
//    assert [1G, 2G, 3G] == [1L, 2L, 3L].stream().map(3G::valueOf).collect(toList())
//}
//methodRefs()
//
//@CompileStatic
//void constructorRefs() {
//    assert [1, 2, 3] == ['1', '2', '3'].stream().map(Integer::new).collect(toList())
//    def result = [1, 2, 3].stream().toArray(Integer[]::new)
//    assert result instanceof Integer[]
//    assert result.toString() == '[1, 2, 3]'
//}
//constructorRefs()
//
///**
// * Regular expression operators
// */
//
///*pattern operator*/
///* The pattern operator (~) provides a simple way to create a java.util.regex.Pattern instance*/
//def p = ~/foo/
//assert p instanceof Pattern
//
//// using single quote strings
//p = ~'foo'
//// using double quotes strings
//p = ~"foo"
//// the dollar-slashy string lets you use slashes and the dollar sign without having to escape them
//p = ~$/dollar/slashy $ string/$
//// you can also use a GString!
//p = ~"${pattern}"
//
///*Find operator*/
///*Alternatively to building a pattern, you can use the find operator =~ to directly create a java.util.regex.Matcher instance*/
//def text = "some text to match"
//// =~ creates a matcher against the text variable, using the pattern on the right hand side
//def m = text =~ /match/
//// the return type of =~ is a Matcher
//assert m instanceof Matcher
//// equivalent to calling if (!m.find(0))
//if (!m) {
//    throw new RuntimeException("Oops, text not found!")
//}
//
///*Match operator*/
///*The match operator (==~) is a slight variation of the find operator, that does not return a Matcher but a boolean and requires a strict match of the input string*/
//m = text ==~ /match/
//assert m instanceof Boolean
//if (m) {
//    throw new RuntimeException("Should not reach that point!")
//}
//
///*Comparing Find vs Match operators*/
//assert 'two words' ==~ /\S+\s+\S+/
//assert 'two words' ==~ /^\S+\s+\S+$/
//assert !(' leading space' ==~ /\S+\s+\S+/)
//
//def m1 = 'two words' =~ /^\S+\s+\S+$/
//assert m1.size() == 1
//def m2 = 'now three words' =~ /^\S+\s+\S+$/
//assert m2.size() == 0
//def m3 = 'now three words' =~ /\S+\s+\S+/
//assert m3.size() == 1
//assert m3[0] == 'now three'
//def m4 = ' leading space' =~ /\S+\s+\S+/
//assert m4.size() == 1
//assert m4[0] == 'leading space'
//def m5 = 'and with four words' =~ /\S+\s+\S+/
//assert m5.size() == 2
//assert m5[0] == 'and with'
//assert m5[1] == 'four words'
//
///**
// * Other operators
// * 扩展点运算符 (*.)，通常缩写为扩展运算符，用于对聚合对象的所有项调用操作。
// * 相当于对每个项目调用动作，并将结果收集到一个列表中
// */
//class Car {
//    String make
//    String model
//}
//// build a list of Car items. The list is an aggregate of objects
//def cars = [
//        new Car(make: 'Peugeot', model: '508'),
//        new Car(make: 'Renault', model: 'Clio')]
//// call the spread operator on the list, accessing the make property of each item
//def makes = cars*.make
//// returns a list of strings corresponding to the collection of make items
//assert makes == ['Peugeot', 'Renault']
//
///**
// * The expression cars*.make is equivalent to cars.collect{ it.make }.
// * Groovy’s GPath notation allows a short-cut when the referenced property isn’t a property of the containing list,
// * in that case it is automatically spread. In the previously mentioned case,
// * the expression cars.make can be used,
// * though retaining the explicit spread-dot operator is often recommended.
// */
//
//cars = [
//        new Car(make: 'Peugeot', model: '508'),
//        null,
//        new Car(make: 'Renault', model: 'Clio')]
//assert cars*.make == ['Peugeot', null, 'Renault']
//assert null*.make == null
//
//class Component {
//    Long id
//    String name
//}
//class CompositeObject implements Iterable<Component> {
//    def components = [
//            new Component(id: 1, name: 'Foo'),
//            new Component(id: 2, name: 'Bar')]
//
//    @Override
//    Iterator<Component> iterator() {
//        components.iterator()
//    }
//}
//def composite = new CompositeObject()
//assert composite*.id == [1,2]
//assert composite*.name == ['Foo','Bar']
//
//class Make {
//    String name
//    List<Model> models
//}
//
//@Canonical
//class Model {
//    String name
//}
//
//def carss = [
//        new Make(name: 'Peugeot',
//                models: [new Model('408'), new Model('508')]),
//        new Make(name: 'Renault',
//                models: [new Model('Clio'), new Model('Captur')])
//]
//
//def makess = carss*.name
//assert makess == ['Peugeot', 'Renault']
//
//def models = carss*.models*.name
//assert models == [['408', '508'], ['Clio', 'Captur']]
//assert models.sum() == ['408', '508', 'Clio', 'Captur'] // flatten one level
//assert models.flatten() == ['408', '508', 'Clio', 'Captur'] // flatten all levels (one in this case)
//
///**
// * Spreading method arguments
// */
//int function(int x, int y, int z) {
//    x*y+z
//}
//def args = [4,5,6]
//assert function(*args) == 26
//args = [4]
//assert function(*args,5,6) == 26
//
//def items = [4,5]
//def list2 = [1,2,3,*items,6]
//assert list2 == [1,2,3,4,5,6]
//
//def m11 = [c:3, d:4]
//def map = [a:1, b:2, *:m11]
//assert map == [a:1, b:2, c:3, d:4]
//
//def m12 = [c:3, d:4]
//def map1 = [a:1, b:2, *:m12, d: 8]
//assert map1 == [a:1, b:2, c:3, d:8]
//
///**
// * Range operator
// * Groovy supports the concept of ranges and provides a notation (..) to create ranges of objects
// */
//def range = 0..5
//// an IntRange, with inclusive bounds
//assert (0..5).collect() == [0, 1, 2, 3, 4, 5]
//// an IntRange, with exclusive upper bound
//assert (0..<5).collect() == [0, 1, 2, 3, 4]
//// an IntRange, with exclusive lower bound
//assert (0<..5).collect() == [1, 2, 3, 4, 5]
//// an IntRange, with exclusive lower and upper bounds
//assert (0<..<5).collect() == [1, 2, 3, 4]
//// a groovy.lang.Range implements the List interface
//assert (0..5) instanceof List
//// meaning that you can call the size method on it
//assert (0..5).size() == 6
//
//assert ('a'..'d').collect() == ['a','b','c','d']
//
///**
// * Spaceship operator
// * The spaceship operator (<=>) delegates to the compareTo method
// */
//assert (1 <=> 1) == 0
//assert (1 <=> 2) == -1
//assert (2 <=> 1) == 1
//assert ('a' <=> 'z') == -1
//
///**
// * Subscript operator
// * The subscript operator is a short hand notation for getAt or putAt, depending on whether you find it on the left hand side or the right hand side of an assignment
// */
//def list8 = [0,1,2,3,4]
//assert list8[2] == 2
//list8[2] = 4
//assert list8[0..2] == [0,1,4]
//list8[0..2] = [6,6,6]
//assert list8 == [6,6,6,3,4]
//
///**
// * Safe index operator
// * Groovy 3.0.0 introduces safe indexing operator, i.e. ?[], which is similar to ?.. For example
// */
//String[] array = ['a', 'b']
//assert 'b' == array?[1]      // get using normal array index
//array?[1] = 'c'              // set using normal array index
//assert 'c' == array?[1]
//
//array = null
//assert null == array?[1]     // return null for all index values
//array?[1] = 'c'              // quietly ignore attempt to set value
//assert null == array?[1]
//
//def personInfo = [name: 'Daniel.Sun', location: 'Shanghai']
//assert 'Daniel.Sun' == personInfo?['name']      // get using normal map index
//personInfo?['name'] = 'sunlan'                  // set using normal map index
//assert 'sunlan' == personInfo?['name']
//
//personInfo = null
//assert null == personInfo?['name']              // return null for all map values
//personInfo?['name'] = 'sunlan'                  // quietly ignore attempt to set value
//assert null == personInfo?['name']
//
///**
// * Membership operator
// *
// * The membership operator (in) is equivalent to calling the isCase method.
// * In the context of a List, it is equivalent to calling contains,
// * like in the following example
// *
// * equivalent to calling list.contains('Emmy') or list.isCase('Emmy')
// */
//def list5 = ['Grace','Rob','Emmy']
//assert ('Emmy' in list5)
//
//
///**
// * Identity operator
// * n Groovy, using == to test equality is different from using the same operator in Java.
// * In Groovy, it is calling equals. If you want to compare reference equality,
// * you should use is like in the following example
// *
// * using ==, we test object equality
// * but using is, we can check that references are distinct
// *
// */
//def list111 = ['Groovy 1.8','Groovy 2.0','Groovy 2.3']
//def list222 = ['Groovy 1.8','Groovy 2.0','Groovy 2.3']
//assert list111 == list222
//assert !list111.is(list222)
//
//
///**
// * Coercion operator
// * The coercion operator (as) is a variant of casting. Coercion converts object from one type to another without them being compatible for assignment. Let’s take an example
// */
//Integer x = 123
//String s = (String) x
//
//Integer x = 123
//String s = x as String
//
//class Identifiable {
//    String name
//}
//class User {
//    Long id
//    String name
//    def asType(Class target) {
//        if (target == Identifiable) {
//            return new Identifiable(name: name)
//        }
//        throw new ClassCastException("User cannot be coerced into $target")
//    }
//}
//def u = new User(name: 'Xavier')
//def p = u as Identifiable
//assert p instanceof Identifiable
//assert !(p instanceof User)
//
///**
// * Diamond operator
// * The diamond operator (<>) is a syntactic sugar only operator added to support compatibility with the operator of the same name in Java 7. It is used to indicate that generic types should be inferred from the declaration
// */
//List<String> strings = new LinkedList<>()
//
///**
// * Call operator
// * The call operator () is used to call a method named call implicitly. For any object which defines a call method, you can omit the .call part and use the call operator instead
// */
//class MyCallable {
//    int call(int x) {
//        2*x
//    }
//}
//
//def mc = new MyCallable()
//assert mc.call(2) == 4
//assert mc(2) == 4
//
//
//
//
//
//
