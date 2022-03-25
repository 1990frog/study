package optional;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Optional;


/**
 * @see #staticFactory() 构造Optional对象的三种静态方法
 *      1. ofNullable 创建包装对象值允许为空的Optional对象
 *      2. of 创建包装对象值非空的Optional对象
 *      3. empty 创建包装对象值为空的Optional对象
 *
 * @see #get() 获取代理的对象<T>
 *
 * @see #isPresent() 方法用于判断包装对象的值是否非空
 *
 * @see #ifPresent() 接受一个Consumer对象（消费函数，null->return T），如果包装对象的值非空，运行Consumer对象的accept()方法
 *
 * @see #filter() 接受参数为Predicate（谓词，T->return boolean）对象，用于对Optional对象进行过滤，如果符合Predicate的条件，返回Optional对象本身，否则返回一个空的Optional对象
 *
 * @see #map() Optional中的包装对象用Function<T,N>（t->n）函数进行运算，并包装成新的Optional对象（包装对象的类型可能改变）
 *
 * @see #
 *
 * @see #
 */
//@Slf4j
public class OptionalDemo {


    public String ofNullable(Entity entity) {
        return Optional
                .ofNullable(entity)
                .map(Entity::getCode)
                .orElse("Unkown");
    }

    @Test
    public void staticFactory() {
        // 创建一个包装对象值为空的Optional对象
        Optional<String> optStr1 = Optional.empty();
        // 创建包装对象值非空的Optional对象
        Optional<String> optStr2 = Optional.of("optional");
        // 创建包装对象值允许为空的Optional对象
        Optional<String> optStr3 = Optional.ofNullable(null);

        OptionalDemo optionalDemo = new OptionalDemo();
        Entity entity = Entity.builder().name("foo").build();
//        log.info(optionalDemo.ofNullable(entity));
//        log.info(optionalDemo.ofNullable(null));
    }

    @Test
    public void get() {
        Optional<Entity> optional1 = Optional.of(Entity
                .builder()
                .code("1")
                .name("lilei")
                .build());
        Optional<Entity> optional2 = Optional.ofNullable(Entity
                .builder()
                .code("1")
                .name("lilei")
                .build());
//        log.info("of Code = {},Name = {}", optional1.get().getCode(), optional1.get().getName());
//        log.info("ofNullable Code = {},Name = {}", optional2.get().getCode(), optional2.get().getName());
    }


    @Test
    public void isPresent() {
        Optional<Entity> optional = Optional.of(Entity
                .builder()
                .code("1")
                .name("lilei")
                .build());
//        log.info(String.valueOf(optional.isPresent()));
    }

    @Test
    public void ifPresent() {
        Optional.of(Entity
                .builder()
                .code("1")
                .name("lilei")
                .build()).ifPresent((Entity n) -> n.setCode("2"));
    }

    @Test
    public void filter() {
        Optional.ofNullable(Entity
                .builder()
                .code("2")
                .name("lilei")
                .build())
                .filter(n -> Integer.parseInt(n.getCode()) > 1)
                .ifPresent(n -> System.out.println(n.getCode()));
    }

    @Test
    public void map() {
        Optional.ofNullable(Entity
                .builder()
                .code("2")
                .name("lilei")
                .build())
                .map(n -> {
                    n.setCode("3");
                    return n;
                }).ifPresent(n -> System.out.println(n.getCode()));
    }

    /**
     * 入参：Function<T, R>(T->R)
     * 返回值：Optional<U>
     *
     * flatMap()能将一个二维的Optional对象映射成一个一维的对象
     *
     * 对比map与flatMap
     * map:function<t,r> t->r
     * flatmap<t,r> t->Option<r>
     */
    @Test
    public void flatMap() {
        Optional optional = Optional.ofNullable(Entity
                .builder()
                .code("2")
                .name("lilei")
                .build())
                .flatMap(u -> Optional.ofNullable(u.getCode()));
//        log.info(optional.get()+"");
    }

    /**
     * 如果包装对象值非空，返回包装对象值，否则返回入参other的值（默认值）
     */
    @Test
    public void orElse(){

    }

    /**
     * orElseGet()方法与orElse()方法类似
     * 区别在于orElseGet()方法的入参为一个Supplier对象，用Supplier对象的get()方法的返回值作为默认值
     */
    @Test
    public void orElseGet(){

    }

    /**
     * orElseThrow()方法其实与orElseGet()方法非常相似了
     * 入参都是Supplier对象
     * 只不过orElseThrow()的Supplier对象必须返回一个Throwable异常
     * 并在orElseThrow()中将异常抛出
     *
     */
    @Test
    public void orElseThrow(){
        try{
            Optional.ofNullable(null)
                    .orElseThrow(()->new RuntimeException("空值"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
