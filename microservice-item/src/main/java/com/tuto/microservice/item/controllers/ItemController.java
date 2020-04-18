package com.tuto.microservice.item.controllers;

import com.tuto.microservice.item.models.Item;
import com.tuto.microservice.item.models.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    @Qualifier("serviceFeign")
    private ItemService itemService;

    @GetMapping("/list")
    public List<Item> list(){
        return itemService.findAll();
    }

    @GetMapping("/show/{id}/quantity/{quantity}")
    public Item details(@PathVariable Long id, @PathVariable Integer quantity){
        return itemService.findById(id,quantity);
    }
}
