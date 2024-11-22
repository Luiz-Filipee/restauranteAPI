package com.luizfilipehenriquelenis.restauranteAPI.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "autenticacoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class AutenticacaoUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
}
