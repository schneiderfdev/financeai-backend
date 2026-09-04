package com.financeai.service;

import com.financeai.model.MetaFinanceira;
import com.financeai.repository.MetaFinanceiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class MetaFinanceiraService {

    @Autowired
    private MetaFinanceiraRepository metaFinanceiraRepository;

    public MetaFinanceira salvar(MetaFinanceira meta) {
        return metaFinanceiraRepository.save(meta);
    }

    public List<MetaFinanceira> listarTodos() {
        return metaFinanceiraRepository.findAll();
    }

    public MetaFinanceira buscarPorId(Long id) {
        return metaFinanceiraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Meta não encontrada com id: " + id));
    }

    public void deletar(Long id) {
        metaFinanceiraRepository.deleteById(id);
    }

    public double calcularProgresso(Long id) {
        MetaFinanceira meta = buscarPorId(id);
        if (meta.getValorObjetivo().compareTo(BigDecimal.ZERO) == 0) {
            return 0;
        }
        return meta.getValorAtual()
                .divide(meta.getValorObjetivo(), 4, RoundingMode.HALF_UP)
                .doubleValue() * 100;
    }
}