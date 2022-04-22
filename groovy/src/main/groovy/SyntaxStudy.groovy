
// reserved keywords can be used for method names if quoted
def "abstract"() { println("abstract") }
// when calling such methods, the name must be qualified using "this."
this.abstract()

/**
 * 合法变量名
 *
 * 'a' to 'z' (lowercase ascii letter)
 * 'A' to 'Z' (uppercase ascii letter)
 * '\u00C0' to '\u00D6'
 * '\u00D8' to '\u00F6'
 * '\u00F8' to '\u00FF'
 * '\u0100' to '\uFFFE'
 */

/*有效变量名*/
def name
def item3
def with_underscore
def $dollarStart
/*无效变量名*/
//def 3tier
//def a+b
//def a#b

/**
 * Quoted identifiers
 * 带引号的标识符
 */
def map = [:]

map."an identifier with a space and double quotes" = "ALLOWED"
map.'with-dash-signs-and-single-quotes' = "ALLOWED"

assert map."an identifier with a space and double quotes" == "ALLOWED"
assert map.'with-dash-signs-and-single-quotes' == "ALLOWED"

/* string 拓展*/
map.'single quote'
map."double quote"
map.'''triple single quote'''
map."""triple double quote"""
map./slashy string/
map.$/dollar slashy string/$

/**
 * String
 */
/*String concatenation*/
assert 'ab' == 'a' + 'b'

/*单引号字符串*/
'a single-quoted string'
/*三引号字符串*/
'''a triple-single-quoted string'''
/*双引号字符串*/
"a double-quoted string"

def aMultilineString = '''
line one
line two
line three
'''

/**
 * 单引号特殊符号
 * \b backspace
 * \f formfeed
 * \n newline
 * \r carriage return
 * \t tabulation
 * \\ backslash
 * \' single quote
 * \"" double quote
 */

def name2 = 'Guillaume' // a plain string
def greeting = "Hello ${name2}"

assert greeting.toString() == 'Hello Guillaume'

/*${}写表达式*/
def sum = "The sum of 2 and 3 equals ${2 + 3}"
assert sum.toString() == 'The sum of 2 and 3 equals 5'

/*除了 ${} 占位符之外，我们还可以使用单独的 $ 符号作为点分表达式的前缀*/
def person = [name: 'Guillaume', age: 36]
assert "$person.name is $person.age years old" == 'Guillaume is 36 years old'

//def number = 3.14
//def shouldFail(MissingPropertyException) {
//    println "$MissingPropertyException.toString()"
//}
//print("${shouldFail(number)}")
//print("${number}") 动态类型 与 弱类型 差别
//print("$shouldFail(number)")

assert '$5' == "\$5"
assert '${name}' == "\${name}"

def sParameterLessClosure = "1 + 2 == ${-> 3}"
assert sParameterLessClosure == '1 + 2 == 3'

def sOneParamClosure = "1 + 2 == ${ w -> w << 3}"
assert sOneParamClosure == '1 + 2 == 3'

def number = 1
def eagerGString = "value == ${number}"
def lazyGString = "value == ${ -> number }"

assert eagerGString == "value == 1"
assert lazyGString ==  "value == 1"

number = 2
assert eagerGString == "value == 1"
assert lazyGString ==  "value == 2"



String takeString(String message) {
    assert message instanceof String
    return message
}
def message = "The message is ${'hello'}"
assert message instanceof GString
def result = takeString(message)
assert result instanceof String
assert result == 'The message is hello'


/**
 * 尽管可以使用插入字符串代替纯 Java 字符串，
 * 但它们在特定方面与字符串不同：它们的 hashCode 不同。
 * 纯 Java 字符串是不可变的，而 GString 的结果字符串表示可能会有所不同，具体取决于其内插值。
 * 即使对于相同的结果字符串，GStrings 和 Strings 也没有相同的 hashCode。
 *
 * 值 or 引用
 */
assert "one: ${1}".hashCode() != "one: 1".hashCode()


def key = "a"
def m = ["${key}": "letter ${key}"]

assert m["a"] == null
println("${key.hashCode()}")
println("${key}".hashCode())
println("a".hashCode())


def name3 = 'Groovy'
def template = """
    Dear Mr ${name3},

    You're the winner of the lottery!

    Yours sincerly,

    Dave
"""
assert template.toString().contains('Groovy')
println(template.toString().contains('Groovy'))

/**
 * Slashy string
 * 正斜杠string
 *
 * Beyond the usual quoted strings, Groovy offers slashy strings, which use / as the opening and closing delimiter.
 * Slashy strings are particularly useful for defining regular expressions and patterns,
 * as there is no need to escape backslashes.
 *
 * Remember that escaping backslashes is not required.
 * An alternative way of thinking of this is that in fact escaping is not supported.
 *
 * 使用 / 正则不需要转义了
 * 其实是不支持转义
 */
def fooPattern = /.*foo.*/
assert fooPattern == '.*foo.*'
def escapeSlash = /The character \/ is a forward slash/
assert escapeSlash == 'The character / is a forward slash'
def multilineSlashy = /one
    two
    three/

assert multilineSlashy.contains('\n')
def color = 'blue'
def interpolatedSlashy = /a ${color} car/

assert interpolatedSlashy == 'a blue car'
println(interpolatedSlashy)

/*不可以使用双正斜杠生成空字符串，会被识别为注释*/
//def '' = //

//def dollar = "\$100"
//def dollarSlashy = $/
//    hello $dollar
//    hello $200
///$
//println(dollarSlashy)

def name4 = "Guillaume"
def date = "April, 1st"

def dollarSlashy = $/
    Hello $name4,
    today we're ${date}.

    $ dollar sign
    $$ escaped dollar sign
    \ backslash
    / forward slash
    $/ escaped forward slash
    $$$/ escaped opening dollar slashy
    $/$$ escaped closing dollar slashy
/$

assert [
        'Guillaume',
        'April, 1st',
        '$ dollar sign',
        '$ escaped dollar sign',
        '\\ backslash',
        '/ forward slash',
        '/ escaped forward slash',
        '$/ escaped opening dollar slashy',
        '/$ escaped closing dollar slashy'
].every { dollarSlashy.contains(it) }

/**
 * '...'
 * '''...'''
 * "..."
 * """..."""
 * /.../
 * $/.../$
 */


/**
 * Characters
 */
char c1 = 'A'
assert c1 instanceof Character

def c2 = 'B' as char
assert c2 instanceof Character

def c3 = (char)'C'
assert c3 instanceof Character

/**
 * Numbers
 */

/**
 * Integral literals
 * 整形
 * byte
 * char
 * short
 * int
 * long
 * java.math.BigInteger
 */

// primitive types
//byte  b = 1
//char  c = 2
//short s = 3
//int   i = 4
//long  l = 5

// infinite precision
BigInteger bi =  6

def a = 1
assert a instanceof Integer

// Integer.MAX_VALUE
def b = 2147483647
assert b instanceof Integer

// Integer.MAX_VALUE + 1
def c = 2147483648
assert c instanceof Long

// Long.MAX_VALUE
def d = 9223372036854775807
assert d instanceof Long

// Long.MAX_VALUE + 1
def e = 9223372036854775808
assert e instanceof BigInteger

def na = -1
assert na instanceof Integer

// Integer.MIN_VALUE
def nb = -2147483648
assert nb instanceof Integer

// Integer.MIN_VALUE - 1
def nc = -2147483649
assert nc instanceof Long

// Long.MIN_VALUE
def nd = -9223372036854775808
assert nd instanceof Long

// Long.MIN_VALUE - 1
def ne = -9223372036854775809
assert ne instanceof BigInteger

/**
 * Binary literal
 */
int xInt = 0b10101111
assert xInt == 175

short xShort = 0b11001001
assert xShort == 201 as short

byte xByte = 0b11
assert xByte == 3 as byte

long xLong = 0b101101101101
assert xLong == 2925l

BigInteger xBigInteger = 0b111100100001
assert xBigInteger == 3873g

int xNegativeInt = -0b10101111
assert xNegativeInt == -175


/**
 * Decimal literals
 */
// primitive types
float  ff = 1.234
double dd = 2.345

// infinite precision
BigDecimal bd =  3.456

assert 1e3  ==  1_000.0
assert 2E4  == 20_000.0
assert 3e+1 ==     30.0
assert 4E-2 ==      0.04
assert 5e-1 ==      0.5

/**
 * Number type suffixes
 * BigInteger G g
 * Long L l
 * Integer I i
 * BigDecimal G g
 * Double D d
 * Float F f
 */
assert 42I == Integer.valueOf('42')
assert 42i == Integer.valueOf('42') // lowercase i more readable
assert 123L == Long.valueOf("123") // uppercase L more readable
assert 2147483648 == Long.valueOf('2147483648') // Long type used, value too large for an Integer
assert 456G == new BigInteger('456')
assert 456g == new BigInteger('456')
assert 123.45 == new BigDecimal('123.45') // default BigDecimal type used
assert .321 == new BigDecimal('.321')
assert 1.200065D == Double.valueOf('1.200065')
assert 1.234F == Float.valueOf('1.234')
assert 1.23E23D == Double.valueOf('1.23E23')
assert 0b1111L.class == Long // binary
assert 0xFFi.class == Integer // hexadecimal
assert 034G.class == BigInteger // octal


// base and exponent are ints and the result can be represented by an Integer
assert    2    **   3    instanceof Integer    //  8
assert   10    **   9    instanceof Integer    //  1_000_000_000

// the base is a long, so fit the result in a Long
// (although it could have fit in an Integer)
assert    5L   **   2    instanceof Long       //  25

// the result can't be represented as an Integer or Long, so return a BigInteger
assert  100    **  10    instanceof BigInteger //  10e20
assert 1234    ** 123    instanceof BigInteger //  170515806212727042875...

// the base is a BigDecimal and the exponent a negative int
// but the result can be represented as an Integer
assert    0.5  **  -2    instanceof Integer    //  4

// the base is an int, and the exponent a negative float
// but again, the result can be represented as an Integer
assert    1    **  -0.3f instanceof Integer    //  1

// the base is an int, and the exponent a negative int
// but the result will be calculated as a Double
// (both base and exponent are actually converted to doubles)
assert   10    **  -1    instanceof Double     //  0.1

// the base is a BigDecimal, and the exponent is an int, so return a BigDecimal
assert    1.2  **  10    instanceof BigDecimal //  6.1917364224

// the base is a float or double, and the exponent is an int
// but the result can only be represented as a Double value
assert    3.4f **   5    instanceof Double     //  454.35430372146965
assert    5.6d **   2    instanceof Double     //  31.359999999999996

// the exponent is a decimal value
// and the result can only be represented as a Double value
assert    7.8  **   1.9  instanceof Double     //  49.542708423868476
assert    2    **   0.1f instanceof Double     //  1.0717734636432956


/**
 * Booleans
 */
def myBooleanVariable = true
boolean untypedBooleanVar = false
booleanField = true

/**
 * List
 */
def numbers = [1, 2, 3]

assert numbers instanceof List
assert numbers.size() == 3

def heterogeneous = [1, "a", true]
println(heterogeneous)

def arrayList = [1, 2, 3]
assert arrayList instanceof java.util.ArrayList

def linkedList = [2, 3, 4] as LinkedList
assert linkedList instanceof java.util.LinkedList

LinkedList otherLinked = [3, 4, 5]
assert otherLinked instanceof java.util.LinkedList

def letters = ['a', 'b', 'c', 'd']

assert letters[0] == 'a'
assert letters[1] == 'b'

assert letters[-1] == 'd'
assert letters[-2] == 'c'

letters[2] = 'C'
assert letters[2] == 'C'

letters << 'e'
assert letters[ 4] == 'e'
assert letters[-1] == 'e'

assert letters[1, 3] == ['b', 'd']
assert letters[2..4] == ['C', 'd', 'e']

def multi = [[0, 1], [2, 3]]
assert multi[1][0] == 2


/**
 * Arrays
 * Groovy 重新定义了数组的列表表示法，要使用数组，您需要声明显式数组的类型，或强制指定。
 */
String[] arrStr = ['Ananas', 'Banana', 'Kiwi']

assert arrStr instanceof String[]
assert !(arrStr instanceof List)

def numArr = [1, 2, 3] as int[]

assert numArr instanceof int[]
assert numArr.size() == 3

def matrix3 = new Integer[3][3]
assert matrix3.size() == 3

Integer[][] matrix2
matrix2 = [[1, 2], [3, 4]]
assert matrix2 instanceof Integer[][]

String[] names = ['Cédric', 'Guillaume', 'Jochen', 'Paul']
assert names[0] == 'Cédric'

names[2] = 'Blackdrag'
assert names[2] == 'Blackdrag'

/**
 * java 风格数组初始化
 */
def primes = new int[] {2, 3, 5, 7, 11}
assert primes.size() == 5 && primes.sum() == 28
assert primes.class.name == '[I'

def pets = new String[] {'cat', 'dog'}
assert pets.size() == 2 && pets.sum() == 'catdog'
assert pets.class.name == '[Ljava.lang.String;'

// traditional Groovy alternative still supported
String[] groovyBooks = [ 'Groovy in Action', 'Making Java Groovy' ]
assert groovyBooks.every{ it.contains('Groovy') }


/**
 * Maps
 */

def colors = [red: '#FF0000', green: '#00FF00', blue: '#0000FF']

assert colors['red'] == '#FF0000'
assert colors.green  == '#00FF00'

colors['pink'] = '#FF00FF'
colors.yellow  = '#FFFF00'

assert colors.pink == '#FF00FF'
assert colors['yellow'] == '#FFFF00'

assert colors instanceof java.util.LinkedHashMap

assert colors.unknown == null

def emptyMap = [:]
assert emptyMap.anyKey == null

def _key = 'name'
def _person = [key: 'Guillaume']

assert !_person.containsKey('name')
assert _person.containsKey('key')

person = [(_key): 'Guillaume']

assert person.containsKey('name')
assert !person.containsKey('key')























