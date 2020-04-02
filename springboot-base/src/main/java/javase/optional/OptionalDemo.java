package javase.optional;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Data
@Builder
class Entity {
    private String code;
    private String name;
}

@Slf4j
public class OptionalDemo {

    public String checkNone1(Entity entity) {
        if (entity != null)
            if (!StringUtils.isEmpty(entity.getName()))
                return entity.getCode();
        return null;
    }

    public String checkNone2(Entity entity) {
        return Optional.ofNullable(entity).map(Entity::getCode).orElse("Unkown");
        /**
         *  等价于：
         *  {@code
         *      Optional<Student> stuOpt =  Optional.ofNullable(student);
         *      if(stuOpt.isPresent())
         *      {
         *          return stuOpt.get().getGender();
         *      }
         *      return "Unkown";
         *  }
         */
    }

    /**
     * 空值验证
     */
    @Test
    public void check() {
        OptionalDemo optionalDemo = new OptionalDemo();
        Entity entity = Entity.builder().name("foo").build();
        log.info(optionalDemo.checkNone2(entity));
        log.info(optionalDemo.checkNone2(null));
    }

    /**
     * Optional类的两个构造方法都是private型的
     * 因此类外部不能显示的使用new Optional()的方式来创建Optional对象
     * <p>
     * 但是Optional类提供了三个静态方法：
     * 1.empty()
     * 2.of(T value)
     * 3.ofNullable(T value)
     * 来创建Optinal对象
     */
    @Test
    public void test() {
        // 创建一个包装对象值为空的Optional对象
        Optional<String> optStr1 = Optional.empty();
        // 创建包装对象值非空的Optional对象
        Optional<String> optStr2 = Optional.of("optional");
        // 创建包装对象值允许为空的Optional对象
        Optional<String> optStr3 = Optional.ofNullable(null);
    }

    /**
     *
     */
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
        log.info("of Code = {},Name = {}", optional1.get().getCode(), optional1.get().getName());
        log.info("ofNullable Code = {},Name = {}", optional2.get().getCode(), optional2.get().getName());
    }


    /**
     * isPresent()方法用于判断包装对象的值是否非空
     * 返回boolean
     */
    @Test
    public void isPresent() {
        Optional<Entity> optional = Optional.of(Entity
                .builder()
                .code("1")
                .name("lilei")
                .build());
        log.info(String.valueOf(optional.isPresent()));
    }

    /**
     * ifPresent()方法接受一个Consumer对象（消费函数），如果包装对象的值非空，运行Consumer对象的accept()方法
     */
    @Test
    public void ifPresent() {
        Optional.of(Entity
                .builder()
                .code("1")
                .name("lilei")
                .build()).ifPresent((Entity n) -> n.setCode("2"));
    }

    /**
     * filter()方法接受参数为Predicate对象，用于对Optional对象进行过滤，如果符合Predicate的条件，返回Optional对象本身，否则返回一个空的Optional对象
     */
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

    /**
     * map()方法的参数为Function<n,t>(n->t)
     * map()方法将Optional中的包装对象用Function函数进行运算，并包装成新的Optional对象（包装对象的类型可能改变）
     */
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
     * <p>
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
        log.info(optional.get()+"");
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
