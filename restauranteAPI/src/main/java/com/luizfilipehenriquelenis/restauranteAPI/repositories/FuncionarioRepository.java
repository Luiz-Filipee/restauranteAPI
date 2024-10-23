package com.luizfilipehenriquelenis.restauranteAPI.repositories;

import com.luizfilipehenriquelenis.restauranteAPI.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Optional<Funcionario> findByNome(String nome);
}