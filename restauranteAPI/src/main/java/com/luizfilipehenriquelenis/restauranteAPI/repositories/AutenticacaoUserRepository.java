package com.luizfilipehenriquelenis.restauranteAPI.repositories;

import com.luizfilipehenriquelenis.restauranteAPI.model.AutenticacaoUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutenticacaoUserRepository extends JpaRepository<AutenticacaoUser, Long> {
    AutenticacaoUser findByUsername(String username);
}
