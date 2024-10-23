package com.luizfilipehenriquelenis.restauranteAPI.controller;

import com.luizfilipehenriquelenis.restauranteAPI.model.Funcionario;
import com.luizfilipehenriquelenis.restauranteAPI.repositories.FuncionarioRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<Funcionario> getAllFuncionarios(){
        return funcionarioRepository.findAll();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public Funcionario criaFuncionario(@RequestBody Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{nome}")
    public ResponseEntity<?> buscaFuncionarioPorNome(@PathVariable String nome){
        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findByNome(nome);
        if(funcionarioOptional.isPresent()){
            Funcionario funcionarioEncontrado = funcionarioOptional.get();
            return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioEncontrado);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario nao encontrado");
        }
    }

}
