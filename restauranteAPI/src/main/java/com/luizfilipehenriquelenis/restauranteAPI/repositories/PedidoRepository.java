package com.luizfilipehenriquelenis.restauranteAPI.repositories;

import com.luizfilipehenriquelenis.restauranteAPI.model.Mesa;
import com.luizfilipehenriquelenis.restauranteAPI.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
