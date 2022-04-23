/**
 * Container
 *  List 列表、线性表
 *
 */


/**
 * 线性表
 * ArrayList 与 Array 的差别
 * List 是可变的
 * Array 是固定的
 */
/*基础类型*/
def list1 = [1,2,3]
assert list1 instanceof List
assert list1 instanceof ArrayList
assert list1.size() == 3
assert list1[1] == 2
/*bean*/
class Entity{
    def code,value
    Entity(code,value){
        this.code = code
        this.value = value
    }
}
def list2 = [new Entity(1,2),new Entity(3,4),new Entity(5,6)]

/**
 * 指定类型
 */
ArrayList arrayList1 = [1,2,3]
def arrayList2 = [1,2,3]
def arrayList3 = [1,2,3] as ArrayList
def linkedList = [1,2,3] as LinkedList

assert arrayList1 instanceof ArrayList
assert arrayList2 instanceof ArrayList
assert arrayList3 instanceof ArrayList
assert linkedList instanceof LinkedList


/**
 * 数据操作
 */
def list = [1,2,3,4]
list << 5
println(list)
println(list[1])
println(list[-1])
println(list?[3])
list[0..2]=[4,4,4]
println(list)
println(list[0..2])
println(list[0<..<2])
def multi = [[0,1],[2,3]]
println(multi[0][0])

list.every{it->println(it)}


/**
 * Arrays
 */
def str1 = [1,2,3] as int[]
int[] str2 = [1,2,3]
str1.every {println(it)}

assert str1 instanceof int[]
assert !(str1 instanceof List)

int[][][] str3 = new int[3][3][2]
assert str3 instanceof int[][][]

/**
 * Maps
 */
def map = [:]
def colors = [red: '#FF0000', green: '#00FF00', blue: '#0000FF']
assert colors['red'] == '#FF0000'
assert colors.green  == '#00FF00'

println colors.keySet()
println colors.containsValue("FF0000")
println colors.containsValue("#FF0000")
println colors.containsKey("red")









