package com.luizfilipehenriquelenis.restauranteAPI.controller;

import com.luizfilipehenriquelenis.restauranteAPI.model.Cliente;
import com.luizfilipehenriquelenis.restauranteAPI.model.Mesa;
import com.luizfilipehenriquelenis.restauranteAPI.repositories.ClienteRepository;
import com.luizfilipehenriquelenis.restauranteAPI.repositories.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/mesa")
public class MesaController {

    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<Mesa> getAllMesas() {
        return mesaRepository.findAll();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<Mesa> criaMesa(@RequestBody Mesa mesa) {
        Cliente cliente = clienteRepository.findById(mesa.getCliente().getId()).orElse(null);
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);  // Retorna erro se o cliente não for encontrado
        }
        mesa.setCliente(cliente);
        Mesa mesaSalva = mesaRepository.save(mesa);
        return ResponseEntity.status(HttpStatus.CREATED).body(mesaSalva);  // Retorna a mesa criada com status 201
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletaMesa(@PathVariable Long id) {
        Optional<Mesa> mesaOptional = mesaRepository.findById(id);
        if (mesaOptional.isPresent()) {
            mesaRepository.delete(mesaOptional.get());
            return ResponseEntity.ok("Mesa deletada com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mesa não encontrada");
        }
    }
}
