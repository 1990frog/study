package commons.beanutils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

public class BeansutilsCopy {

    /**
     *
     * 避免用Apache Beanutils进行属性的copy。 说明：Apache BeanUtils性能较差，可以使用其他方案比如Spring BeanUtils, Cglib BeanCopier。
     *     TestObject a = new TestObject();
     *     TestObject b = new TestObject();
     *     a.setX(b.getX());
     *     a.setY(b.getY());
     */
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Date date1 = new Date();
        Date date2 = new Date();
        BeanUtils.copyProperties(date1,date2);

        Date date3 = new Date();
        Date date4 = new Date();

    }
}
