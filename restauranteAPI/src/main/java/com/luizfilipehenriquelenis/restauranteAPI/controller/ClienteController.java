package com.luizfilipehenriquelenis.restauranteAPI.controller;

import com.luizfilipehenriquelenis.restauranteAPI.model.Cliente;
import com.luizfilipehenriquelenis.restauranteAPI.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/cliente") // localhost:8080/api/cliente
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<Cliente> getAllClientes(){
        return clienteRepository.findAll();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public Cliente criaCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }
}
