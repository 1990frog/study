/**
 * 基础数据类型：不可变
 *
 * int
 * long
 * short
 * byte
 * char
 *
 * double
 * float
 *
 * boolean
 * null
 */


/**
 * byte 字节型
 * 字节是二进制数据的单位。一个字节通常8位（bit：二进制的一位，0或1）长。
 * byte是从0-255的无符号类型，所以不能表示负数。
 */
byte b = 256
assert b instanceof Byte

/**
 * char 字符型
 * 表示通常意义上的“字符”（2字节）
 * 使用Unicode编码，故一个字符可以存储一个字母，一个汉字，或其他书面语的一个字符
 * 三种表现形式：
 * 1、单引号('')包括起来的的单个字符：’a'
 * 2、使用转义符(\)开头的字符串常量
 * 3、直接使用Unicode值来表示字符型常量
 */
char c1 = '日'
char c2 = '\n'
char c3 = '\u0021'
println(c1)
println(c2)
println(c3)

/**
 * short 16位
 */
short sMax = 2**15 - 1
short sMin = -2**15
println("short 最大值 ${sMax}")
println("short 最小值 ${sMin}")

/**
 * int 32位
 */
int iMax = 2**31 - 1
int iMin = -2**31
println("int 最大值 ${iMax}")
println("int 最小值 ${iMin}")

/**
 * long 64位
 */
long lMax = 2**63 - 1
long lMin = -2**63
println("long 最大值 ${lMax}")
println("long 最小值 ${lMin}")

/**
 * BigInteger
 * def 默认变量类型
 */

/**
 * 二进制（Binary literal） 0b 开头
 * 八进制（Octal literal） 0 开头
 * 十六进制（Hexadecimal literal）0x 开头
 */
int xbin = 0b10101111
assert xbin == 175
int xoc = 077
assert xoc == 63
int xhex = 0x77
assert xhex == 119
/**
 * 十进制 Decimal literals
 */
// primitive types
float  f = 1.234
double d = 2.345
// infinite precision
BigDecimal bd =  3.456

// 指数
assert 1e3  ==  1_000.0
assert 2E4  == 20_000.0
assert 3e+1 ==     30.0
assert 4E-2 ==      0.04
assert 5e-1 ==      0.5

// 下划线
long creditCardNumber = 1234_5678_9012_3456L
long socialSecurityNumbers = 999_99_9999L
double monetaryAmount = 12_345_132.12
long hexBytes = 0xFF_EC_DE_5E
long hexWords = 0xFFEC_DE5E
long maxLong = 0x7fff_ffff_ffff_ffffL
long alsoMaxLong = 9_223_372_036_854_775_807L
long bytes = 0b11010010_01101001_10010100_10010010

/**
 * Number 类型后缀
 * BigInteger G or g
 * Long L or l
 * Integer I or i
 * BigDecimal G or g
 * Double D or d
 * Float F or f
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

/**
 * boolean
 */
def bol = true
println(bol)