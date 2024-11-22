package com.luizfilipehenriquelenis.restauranteAPI.controller;

import com.luizfilipehenriquelenis.restauranteAPI.model.MenuItem;
import com.luizfilipehenriquelenis.restauranteAPI.repositories.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarItem(@PathVariable Long id) {
        try {
            if (menuItemRepository.existsById(id)) {
                menuItemRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro de integridade: não é possível deletar o item porque ele está associado a outros registros.");
        }
    }
}
