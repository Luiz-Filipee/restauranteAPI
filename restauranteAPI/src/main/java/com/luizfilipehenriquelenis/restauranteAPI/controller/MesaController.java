package com.luizfilipehenriquelenis.restauranteAPI.controller;

import com.luizfilipehenriquelenis.restauranteAPI.model.Cliente;
import com.luizfilipehenriquelenis.restauranteAPI.model.Mesa;
import com.luizfilipehenriquelenis.restauranteAPI.repositories.ClienteRepository;
import com.luizfilipehenriquelenis.restauranteAPI.repositories.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        mesa.setCliente(cliente);
        Mesa mesaSalva = mesaRepository.save(mesa);
        return ResponseEntity.status(HttpStatus.CREATED).body(mesaSalva);  
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletaMesa(@PathVariable Long id) {
        try {
            if (mesaRepository.existsById(id)) {
                mesaRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro de integridade: não é possível deletar a mesa porque ele está associado a outros registros.");
        }
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{nome}")
    public ResponseEntity<?> buscaMesaPeloNomeDoResponsavel(@PathVariable String nome) {
        List<Mesa> mesas = mesaRepository.findByCliente_Nome(nome);
        if (!mesas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(mesas); // Retorna todas as mesas encontradas
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mesa não encontrada");
        }
    }
}
