package com.financeai.controller;

import com.financeai.model.Investimento;
import com.financeai.service.InvestimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investimentos")
public class InvestimentoController {

    @Autowired
    private InvestimentoService investimentoService;

    @PostMapping
    public Investimento criar(@RequestBody Investimento investimento) {
        return investimentoService.salvar(investimento);
    }

    @GetMapping
    public List<Investimento> listar() {
        return investimentoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Investimento buscarPorId(@PathVariable Long id) {
        return investimentoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        investimentoService.deletar(id);
    }
}