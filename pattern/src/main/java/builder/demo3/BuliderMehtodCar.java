package builder.demo3;

/**
 * 新建静态内部类Builder，也就是汽车制造商，我们的car交给他来制造，car需要的属性全部复制进来
 *
 * 定义Builder空构造，初始化car默认值。这里是为了初始化构造的时候，不要再去特别定义属性，直接使用默认值。
 * 定义Builder构造，传入Car ，构造里面执行Car属性赋值给Builder对应属性的操作，目的是为了重建一个builder。
 *
 * 定义一系列方法进行属性初始化，这些方法跟JavaBeans模式构建中的方法类似，不同的是，返回值为Builder类型，为了方便链式调用。
 * 最后定义方法返回实体Car对象，Car的构造器持有Builder,最终将builder制造的组件赋值给car完成构建。
 *
 * 至此，我们的Builder模式体验就结束了，这里讲的只是Builder模式的一个变种，即在android中应用较为广泛的模式，下面总结一下优缺点：
 *
 * 优点：
 * 1.解耦，逻辑清晰。
 * 统一交由Builder类构造，Car类不用关心内部实现细节，只注重结果。
 *
 * 2.链式调用，使用灵活，易于扩展。
 * 相对于方法一中的构造器方法，配置对象属性灵活度大大提高，支持链式调用使得逻辑清晰不少，而且我们需要扩展的时候，也只需要添加对应扩展属性即可，十分方便。
 *
 * 缺点：
 * 硬要说缺点的话 就是前期需要编写更多的代码，每次构建需要先创建对应的Builder对象。但是这点开销几乎可以忽略吧，前期编写更多的代码是为了以后更好的扩展，这不是优秀程序员应该要考虑的事么
 *
 * 解决方法：
 * 不会偷懒的程序猿不是好程序猿，针对以上缺点，IDEA系列的ide ，有相应的插件InnerBuilder可以自动生成builder相关代码，安装自行google，
 * 使用的时候只需要在实体类中 alt + insert 键，会有个build按钮提供代码生成。
 *
 * 使用场景：
 * 一般如果类属性在4个以上的话，建议使用此模式。还有如果类属性存在不确定性，可能以后还会新增属性时使用，便于扩展。
 *
 */
public final class BuliderMehtodCar {
    /**
     * 必须属性
     */
    final String carBody;//车身
    final String tyre;//轮胎
    final String engine;//发动机
    final String aimingCircle;//方向盘
    final String safetyBelt;//安全带
    /**
     * 可选属性
     */
    final String decoration;//车内装饰品

    /**
     * car 的构造器 持有 Builder,将builder制造的组件赋值给 car 完成构建
     * @param builder
     */
    public BuliderMehtodCar(Builder builder){
        this.carBody = builder.carBody;
        this.tyre = builder.tyre;
        this.engine = builder.engine;
        this.aimingCircle = builder.aimingCircle;
        this.decoration = builder.decoration;
        this.safetyBelt = builder.safetyBelt;
    }

    /**
     * 重新拿回builder，去改造car
     * @return
     */
    public Builder newBuilder(){
        return new Builder(this);
    }

    public static final class Builder{
        String carBody;//车身
        String tyre;//轮胎
        String engine;//发动机
        String aimingCircle;//方向盘
        String decoration;//车内装饰品
        String safetyBelt;//安全带

        public Builder(){
            this.carBody = "宝马";
            this.tyre = "宝马";
            this.engine = "宝马";
            this.aimingCircle = "宝马";
            this.decoration = "宝马";
        }

        /**
         * 回厂重造
         * @param car
         */
        public Builder(BuliderMehtodCar car) {
            this.carBody = car.carBody;
            this.tyre = car.tyre;
            this.engine = car.engine;
            this.aimingCircle = car.aimingCircle;
            this.decoration = car.decoration;
            this.safetyBelt = car.safetyBelt;
        }

        /**
         * 实际属性配置方法
         * @param carBody
         * @return
         */
        public Builder carBody(String carBody){
            this.carBody = carBody;
            return this;
        }

        public Builder tyre(String tyre){
            this.tyre = tyre;
            return this;
        }

        public Builder safetyBelt(String safetyBelt) {
            /**
             * 我们在 Builder 类中的一系列构建方法中还可以加入一些我们对配置属性的限制。
             * 例如我们给 car 添加一个安全带属性
             */
            if (safetyBelt == null)
                throw new NullPointerException("没系安全带，你开个毛车啊");
            this.safetyBelt = safetyBelt;
            return this;
        }

        public Builder engine(String engine) {
            this.engine = engine;
            return this;
        }

        public Builder aimingCircle(String aimingCircle) {
            this.aimingCircle = aimingCircle;
            return this;
        }

        public Builder decoration(String decoration) {
            this.decoration = decoration;
            return this;
        }

        /**
         * 最后创造出实体car
         * @return
         */
        public BuliderMehtodCar build(){
            return new BuliderMehtodCar(this);
        }

    }

    /**
     * 可以看到，我们默认的 car 已经制造出来了，默认的零件都是 "宝马"，滴滴滴~来不及解释了，快上车。
     * 假如我们不使用默认值，需要自己定制的话，非常简单。只需要拿到 Builder 对象之后，依次调用指定方法，
     * 最后再调用 build 返回 car 即可。
     * @param args
     */
    public static void main(String[] args) {
        BuliderMehtodCar car = new BuliderMehtodCar.Builder().build();
    }

}
