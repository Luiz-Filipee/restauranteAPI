package com.luizfilipehenriquelenis.restauranteAPI.controller;

import com.luizfilipehenriquelenis.restauranteAPI.model.AutenticacaoUser;
import com.luizfilipehenriquelenis.restauranteAPI.model.MessageResponse;
import com.luizfilipehenriquelenis.restauranteAPI.repositories.AutenticacaoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/autenticacao")
public class AutenticacaoUserController {
    @Autowired
    private AutenticacaoUserRepository autenticacaoUserRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<AutenticacaoUser> listar() {
        return autenticacaoUserRepository.findAll();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<AutenticacaoUser> criaAutenticacao(@RequestBody AutenticacaoUser newUser) {
        AutenticacaoUser userSalvo = autenticacaoUserRepository.save(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(userSalvo);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/login")
    public ResponseEntity<Object> autenticaUser(@RequestBody AutenticacaoUser loginUser) {
        AutenticacaoUser user = autenticacaoUserRepository.findByUsername(loginUser.getUsername());
        if (user != null && user.getPassword().equals(loginUser.getPassword())) {
            return ResponseEntity.ok().body(new MessageResponse("Autenticado com sucesso"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MessageResponse("Credenciais inválidas"));
        }
    }

}
