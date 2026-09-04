package com.financeai.controller;

import com.financeai.model.MetaFinanceira;
import com.financeai.service.MetaFinanceiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metas")
public class MetaFinanceiraController {

    @Autowired
    private MetaFinanceiraService metaFinanceiraService;

    @PostMapping
    public MetaFinanceira criar(@RequestBody MetaFinanceira meta) {
        return metaFinanceiraService.salvar(meta);
    }

    @GetMapping
    public List<MetaFinanceira> listar() {
        return metaFinanceiraService.listarTodos();
    }

    @GetMapping("/{id}")
    public MetaFinanceira buscarPorId(@PathVariable Long id) {
        return metaFinanceiraService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        metaFinanceiraService.deletar(id);
    }

    @GetMapping("/{id}/progresso")
    public double progresso(@PathVariable Long id) {
        return metaFinanceiraService.calcularProgresso(id);
    }
}