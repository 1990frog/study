package com.mvc.service;

import com.mvc.domain.entity.Product;
import com.mvc.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

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
