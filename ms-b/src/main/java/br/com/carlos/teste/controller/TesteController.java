package br.com.carlos.teste.controller;

import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ms-b", produces = MediaType.APPLICATION_JSON_VALUE)
public class TesteController {

    @GetMapping
    public String teste() {
        JSONObject json = null;
        json = new JSONObject().put("retorno", "Microservico B");
        return json.toString();
    }
}
