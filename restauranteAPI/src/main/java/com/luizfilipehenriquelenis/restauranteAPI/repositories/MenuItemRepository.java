package com.luizfilipehenriquelenis.restauranteAPI.repositories;

import com.luizfilipehenriquelenis.restauranteAPI.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
