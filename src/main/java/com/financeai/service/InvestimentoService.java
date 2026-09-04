package com.financeai.service;

import com.financeai.model.Investimento;
import com.financeai.repository.InvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestimentoService {

    @Autowired
    private InvestimentoRepository investimentoRepository;

    public Investimento salvar(Investimento investimento) {
        return investimentoRepository.save(investimento);
    }

    public List<Investimento> listarTodos() {
        return investimentoRepository.findAll();
    }

    public Investimento buscarPorId(Long id) {
        return investimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Investimento não encontrado com id: " + id));
    }

    public void deletar(Long id) {
        investimentoRepository.deleteById(id);
    }
}