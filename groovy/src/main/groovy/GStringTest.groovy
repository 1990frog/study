/**
 * 单引号无法使用 GString 插入值
 * GString 占位符有两种：${},$
 */
def name = "lilei"
assert '${name} $name' == '${name} $name'
assert "${name} $name" == 'lilei lilei'
assert '''${name} $name''' == '${name} $name'
assert """${name} $name""" == 'lilei lilei'
assert """\${name} \$name""" == '${name} $name'

/**
 * 插入闭包
 */
assert "1 + 2 = 3" == "1 + 2 = ${()->1+2}"
assert "1 + 2 = 3" == "1 + 2 = ${->3}"
/*Here, the closure takes a single java.io.StringWriter argument,
to which you can append content with the << leftShift operator.
In either case, both placeholders are embedded closures*/
assert "1 + 2 = 3" == "1 + 2 = ${ w -> w << 3}"
def add(a,b){
    return a+b
}
assert "1 + 2 = 3" == "1 + 2 = ${->add(1,2)}"

/**
 * 返回字符串
 */
assert "The message is ${'name'}" == 'The message is name'
assert "The message is ${'name'}" instanceof GString

/**
 * 尽管可以使用插值字符串代替纯 Java 字符串，
 * 但它们在特定方面与字符串不同：它们的 hashCode 不同。
 * 纯 Java 字符串是不可变的，
 * 而 GString 的结果字符串表示可能会有所不同，具体取决于其内插值。
 * 即使对于相同的结果字符串，GStrings 和 Strings 也没有相同的 hashCode。
 *
 * groovy 中 == 等同于 java equal
 * groovy 中 is 等同于 ==
 */
def str = "hello world!"
def gstr = "${str}"
assert str == gstr
assert !gstr.is(str)
assert str.hashCode() != gstr.hashCode()

/**
 * 除了通常的引用字符串之外，Groovy 还提供斜线字符串，它使用 / 作为开始和结束分隔符。
 * 斜杠字符串对于定义正则表达式和模式特别有用，因为不需要使用反斜杠进行转义。
 */
def foo = /bar/
//println("${foo}")
//println("${->foo}")
//println(/${foo}/)
//println(/$foo/)
def slashyStr = /one
two
${foo}
three/
println(slashyStr)

/**
 * $/
 * 使用$符号进行转义
 * 它可以转义另一个美元，或正斜杠。 只有在与这些字符的特殊使用发生冲突时才需要对美元和正斜杠字符进行转义。
 */