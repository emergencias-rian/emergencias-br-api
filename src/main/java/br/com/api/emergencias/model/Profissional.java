package br.com.api.emergencias.model;


import br.com.api.emergencias.enums.Profissao;
import br.com.api.emergencias.enums.TipoContrato;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "t_profissionais")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cidade;
    private String uf;

    @Enumerated(EnumType.STRING)
    private Profissao profissao;
    private String n_conselho;
    private String cnh;
    private Date validade_cnh;
    private String cpf;
    private String rg;
    private String pix;
    private Boolean status = true;

    @Enumerated(EnumType.STRING)
    private TipoContrato contrato;
    private Date validade_contrato;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
