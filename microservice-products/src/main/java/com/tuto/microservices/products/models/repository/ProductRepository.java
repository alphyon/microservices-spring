package com.tuto.microservices.products.models.repository;

import com.tuto.microservices.products.models.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {
}
