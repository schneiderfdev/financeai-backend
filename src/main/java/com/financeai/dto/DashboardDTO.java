package com.financeai.dto;

import java.math.BigDecimal;

public class DashboardDTO {

    private BigDecimal totalReceitas;
    private BigDecimal totalGastos;
    private BigDecimal totalInvestimentos;
    private BigDecimal saldo;

    public DashboardDTO(BigDecimal totalReceitas, BigDecimal totalGastos, BigDecimal totalInvestimentos, BigDecimal saldo) {
        this.totalReceitas = totalReceitas;
        this.totalGastos = totalGastos;
        this.totalInvestimentos = totalInvestimentos;
        this.saldo = saldo;
    }

    public BigDecimal getTotalReceitas() {
        return totalReceitas;
    }

    public BigDecimal getTotalGastos() {
        return totalGastos;
    }

    public BigDecimal getTotalInvestimentos() {
        return totalInvestimentos;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}