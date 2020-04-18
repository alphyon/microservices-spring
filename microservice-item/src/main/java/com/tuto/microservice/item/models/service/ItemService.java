package com.tuto.microservice.item.models.service;

import com.tuto.microservice.item.models.Item;

import java.util.List;

public interface ItemService {
    public List<Item> findAll();
    public Item findById(Long id, Integer quantity);
}
