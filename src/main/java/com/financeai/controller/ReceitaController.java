package com.financeai.controller;

import com.financeai.model.Receita;
import com.financeai.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receitas")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @PostMapping
    public Receita criar(@RequestBody Receita receita) {
        return receitaService.salvar(receita);
    }

    @GetMapping
    public List<Receita> listar() {
        return receitaService.listarTodos();
    }

    @GetMapping("/{id}")
    public Receita buscarPorId(@PathVariable Long id) {
        return receitaService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        receitaService.deletar(id);
    }
}