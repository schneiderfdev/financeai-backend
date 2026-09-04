package com.financeai.service;

import com.financeai.model.Gasto;
import com.financeai.repository.GastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GastoService {

    @Autowired
    private GastoRepository gastoRepository;

    public Gasto salvar(Gasto gasto) {
        return gastoRepository.save(gasto);
    }

    public List<Gasto> listarTodos() {
        return gastoRepository.findAll();
    }

    public Gasto buscarPorId(Long id) {
        return gastoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gasto não encontrado com id: " + id));
    }

    public void deletar(Long id) {
        gastoRepository.deleteById(id);
    }
}