package com.luizfilipehenriquelenis.restauranteAPI.controller;

import com.luizfilipehenriquelenis.restauranteAPI.model.Funcionario;
import com.luizfilipehenriquelenis.restauranteAPI.model.Pedido;
import com.luizfilipehenriquelenis.restauranteAPI.repositories.FuncionarioRepository;
import com.luizfilipehenriquelenis.restauranteAPI.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<?> criaPedido(@RequestBody Pedido pedido) {
        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findByNome(pedido.getFuncionario().getNome());
        if (funcionarioOptional.isPresent()) {
            Funcionario funcionarioSelecionado = funcionarioOptional.get();
            pedido.setFuncionario(funcionarioSelecionado);
            Pedido pedidoSalvo = pedidoRepository.save(pedido);
            return ResponseEntity.status(HttpStatus.CREATED).body(pedidoSalvo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario nao encontrado");
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarPedido(@PathVariable Long id) {
        try {
            if (pedidoRepository.existsById(id)) {
                pedidoRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro de integridade: não é possível deletar o pedido porque ele está associado a outros registros.");
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}/pronto")
    public ResponseEntity<?> marcarComoPronto(@PathVariable Long id) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
        if (pedidoOptional.isPresent()) {
            Pedido pedidoEncontrado = pedidoOptional.get();
            pedidoEncontrado.setStatus("Pronto");
            pedidoRepository.save(pedidoEncontrado);
            return ResponseEntity.ok(new HashMap<String, String>() {{
                put("message", "Status do Pedido alterado com sucesso");
                put("id", String.valueOf(pedidoEncontrado.getId()));
            }});
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrada");
        }
    }
}