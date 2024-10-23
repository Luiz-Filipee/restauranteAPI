package com.luizfilipehenriquelenis.restauranteAPI.controller;

import com.luizfilipehenriquelenis.restauranteAPI.model.MenuItem;
import com.luizfilipehenriquelenis.restauranteAPI.repositories.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/menu")
public class MenuItemController {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<MenuItem> getAllItems() {
        return menuItemRepository.findAll();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public MenuItem criaMenuItem(@RequestBody MenuItem data){
        return menuItemRepository.save(data);
    }
}
