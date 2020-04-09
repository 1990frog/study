package springboot.springboot.action;

import springboot.SpringbootApplication;
import springboot.action.mvc.domain.entity.Product;
import springboot.action.mvc.domain.entity.ProductExample;
import springboot.action.mvc.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.beans.Transient;

@SpringBootTest(classes = SpringbootApplication.class)
public class MyBatisTest {

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void insert(){
        Product product = new Product();
        product.setId(3);
        product.setName("hanmeimei");
        product.setPrice(100);
        productMapper.insert(product);
    }

    @Test
    @Transient
    public void update(){
        Product product = new Product();
//        product.setId(2);
        product.setName("hanmeimei");
        product.setPrice(101);
//        productMapper.updateByPrimaryKey(product);
//        productMapper.updateByPrimaryKeySelective(product);

        ProductExample productExample = new ProductExample();
        // createCriteria()方法构造条件
        productExample.createCriteria().andIdBetween(1,3);
        productMapper.updateByExampleSelective(product,productExample);

    }
}
