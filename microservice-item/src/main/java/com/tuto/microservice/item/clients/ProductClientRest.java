package com.tuto.microservice.item.clients;

import com.tuto.microservice.item.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-products")
public interface ProductClientRest {
    @GetMapping("/list")
    public List<Product> list();

    @GetMapping("/show/{id}")
    public Product show(@PathVariable Long id);
}
