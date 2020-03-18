package cn.qut.service;

import cn.qut.domain.Product;

import java.util.List;

public interface IProductService {


    public List<Product> findAll() throws Exception;

    void save(Product product);
}
