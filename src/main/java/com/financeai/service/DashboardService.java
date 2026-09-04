package com.financeai.service;

import com.financeai.dto.DashboardDTO;
import com.financeai.repository.GastoRepository;
import com.financeai.repository.ReceitaRepository;
import com.financeai.repository.InvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DashboardService {

    @Autowired
    private GastoRepository gastoRepository;

    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private InvestimentoRepository investimentoRepository;

    public DashboardDTO gerarResumo() {
        BigDecimal totalGastos = gastoRepository.findAll().stream()
                .map(g -> g.getValor())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalReceitas = receitaRepository.findAll().stream()
                .map(r -> r.getValor())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalInvestimentos = investimentoRepository.findAll().stream()
                .map(i -> i.getValor())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal saldo = totalReceitas.subtract(totalGastos).subtract(totalInvestimentos);

        return new DashboardDTO(totalReceitas, totalGastos, totalInvestimentos, saldo);
    }
}