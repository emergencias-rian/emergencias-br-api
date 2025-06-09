package br.com.api.emergencias.model;

import br.com.api.emergencias.enums.TipoPessoa;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "t_clientes")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cidade;
    private String uf;

    @Column(name = "cnpj_ou_cpf")
    private String cnpjOuCpf;

    private String telefone;
    private String email;
    private String endereco;

    @Enumerated(EnumType.STRING)
    private TipoPessoa tipo;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}

