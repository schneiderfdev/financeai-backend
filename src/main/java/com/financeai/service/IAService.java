package com.financeai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Service
public class IAService {

    @Value("${groq.api.key}")
    private String apiKey;

    @Value("${groq.api.url}")
    private String apiUrl;

    @Autowired
    private DashboardService dashboardService;

    private final RestClient restClient = RestClient.create();

    public String gerarRecomendacaoAutomatica() {
        var dashboard = dashboardService.gerarResumo();

        String resumo = String.format(
                "Receita total: R$ %.2f. Total de gastos: R$ %.2f. Total investido: R$ %.2f. Saldo atual: R$ %.2f.",
                dashboard.getTotalReceitas(), dashboard.getTotalGastos(),
                dashboard.getTotalInvestimentos(), dashboard.getSaldo()
        );

        return gerarRecomendacao(resumo);
    }

    public String gerarRecomendacao(String resumoFinanceiro) {
        String prompt = "Você é um consultor financeiro. Com base neste resumo financeiro do usuário, "
                + "dê uma análise curta (máximo 4 frases) e prática, em português, apontando padrões de gasto "
                + "e sugestões de economia ou investimento:\n\n" + resumoFinanceiro;

        Map<String, Object> body = Map.of(
                "model", "llama-3.3-70b-versatile",
                "messages", List.of(
                        Map.of("role", "user", "content", prompt)
                )
        );

        Map<String, Object> response = restClient.post()
                .uri(apiUrl)
                .header("Authorization", "Bearer " + apiKey)
                .contentType(MediaType.APPLICATION_JSON)
                .body(body)
                .retrieve()
                .body(Map.class);

        return extrairTexto(response);
    }

    @SuppressWarnings("unchecked")
    private String extrairTexto(Map<String, Object> response) {
        List<Map<String, Object>> choices = (List<Map<String, Object>>) response.get("choices");
        Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");
        return (String) message.get("content");
    }
}