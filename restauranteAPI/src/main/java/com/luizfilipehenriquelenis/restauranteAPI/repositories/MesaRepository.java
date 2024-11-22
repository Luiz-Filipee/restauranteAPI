package com.luizfilipehenriquelenis.restauranteAPI.repositories;

import com.luizfilipehenriquelenis.restauranteAPI.model.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MesaRepository extends JpaRepository<Mesa, Long> {
    List<Mesa> findByCliente_Nome(String nome);

}
