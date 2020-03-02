package com.action.service;

import com.action.domain.entity.Product;
import com.action.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class HelloSpringbootService {

    @Autowired
    private ProductMapper productMapper;

    public Product query(){
        return productMapper.selectByPrimaryKey(1);
    }

    public List<Product> queryAll(){
        return productMapper.selectByExample(null);
    }

    public void insert(Product product){
        productMapper.insertSelective(product);
    }
}
