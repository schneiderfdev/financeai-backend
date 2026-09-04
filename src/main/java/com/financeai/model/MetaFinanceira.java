package com.financeai.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.math.BigDecimal;

@Entity
@Table(name = "metas_financeiras")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetaFinanceira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome; // ex: "Viagem", "Reserva de emergência"

    private BigDecimal valorObjetivo;

    private BigDecimal valorAtual;

    private LocalDate prazo;
}