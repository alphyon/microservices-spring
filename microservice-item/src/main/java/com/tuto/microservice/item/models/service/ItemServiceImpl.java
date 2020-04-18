package com.tuto.microservice.item.models.service;

import com.tuto.microservice.item.models.Item;
import com.tuto.microservice.item.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService {
    @Autowired
    private RestTemplate clientRest;
    @Override
    public List<Item> findAll() {
        List<Product> products = Arrays.asList(
                clientRest.getForObject("http://localhost:8001/list",
                        Product[].class)
        );
        return products.stream().map(p -> new Item(p,1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer quantity) {
        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id", id.toString());
        Product product =  clientRest.getForObject("http://localhost:8001/show/{id}",Product.class,pathVariables);
        return new Item(product, quantity);
    }
}
