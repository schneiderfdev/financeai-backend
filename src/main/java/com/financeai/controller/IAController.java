package com.financeai.controller;

import com.financeai.service.IAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ia")
public class IAController {

    @Autowired
    private IAService iaService;

    @GetMapping("/recomendacoes")
    public String recomendacoes() {
        return iaService.gerarRecomendacaoAutomatica();
    }
}