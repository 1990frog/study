package com.action.mvc.service;

import com.action.mvc.domain.entity.Product;
import com.action.mvc.mapper.ProductMapper;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DataService {

    @Autowired
    private ProductMapper productMapper;

    /**
     * 这样写是错误的，每个线程应该对应自己的sqlSession
     */
    @Autowired
    private SqlSession sqlSession;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public Product query(){
        return productMapper.selectByPrimaryKey(1);
    }

    @Transactional
    public Product mybatisCache1(){
        Product p1 = productMapper.selectByPrimaryKey(1);
        Product p2 = productMapper.selectByPrimaryKey(1);
        return p1;
    }

    public Product mybatisCache2(){
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        Product p1 = mapper.selectByPrimaryKey(1);
        Product p2 = mapper.selectByPrimaryKey(1);
        return p1;
    }

    public Product mybatisCache3(){
        SqlSession session = sqlSessionFactory.openSession(true);
        try {
            ProductMapper mapper = session.getMapper(ProductMapper.class);
            Product p1 = mapper.selectByPrimaryKey(1);
            Product p2 = mapper.selectByPrimaryKey(1);
            return p1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public List<Product> queryAll(){
        return productMapper.selectByExample(null);
    }

    public List<Product> queryAllWithRowBounds(RowBounds rowBound){
        return productMapper.queryAllWithRowBounds(rowBound);
    }

    public List<Product> queryAllWithParam(int pageNum,int pageSize){
        return productMapper.queryAllWithParam(1,20);
    }

    public void insert(Product product){
        productMapper.insertSelective(product);
    }
}
