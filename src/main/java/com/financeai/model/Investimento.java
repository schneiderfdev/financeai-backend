package com.financeai.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.math.BigDecimal;

@Entity
@Table(name = "investimentos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Investimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; // Tesouro Direto, CDB, Ações, ETF, Cripto, Fundo Imobiliário...

    private BigDecimal valor;

    private BigDecimal rentabilidade; // percentual, ex: 0.85 = 0,85%

    private LocalDate data;
}