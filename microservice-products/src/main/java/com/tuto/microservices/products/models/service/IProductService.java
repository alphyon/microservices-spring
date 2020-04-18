package com.tuto.microservices.products.models.service;

import com.tuto.microservices.products.models.entity.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findAll();
    public Product findById(Long id);
}
