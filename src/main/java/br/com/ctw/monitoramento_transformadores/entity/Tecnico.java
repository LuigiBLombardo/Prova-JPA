package br.com.ctw.monitoramento_transformadores.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_tecnico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "cpf",
            nullable = false,
            unique = true,
            length = 20
    )
    private String cpf;

    @Column(
            name = "nome",
            nullable = false,
            length = 100
    )
    private String nome;

    @Column(
            name = "especialidade",
            nullable = false,
            length = 50
    )
    private String especialidade;

    @Column(
            name = "email",
            nullable = false,
            length = 50
    )
    private String email;
}
