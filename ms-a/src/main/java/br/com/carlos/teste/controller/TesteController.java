package br.com.carlos.teste.controller;

import br.com.carlos.teste.client.TesteClient;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/ms-a", produces = MediaType.APPLICATION_JSON_VALUE)
public class TesteController {

    @Autowired
    private TesteClient testeClient;

    @GetMapping
    public String teste() {
        JSONObject jsonMSA = null;
        JSONObject jsonMSB = null;

        jsonMSA = new JSONObject().put("retorno", "Microservico A");

        log.info("buscando no msB");
        String msb = testeClient.getMSB();
        jsonMSB = new JSONObject(msb);

        JSONObject json = new JSONObject()
                .put("retorno1", jsonMSA.get("retorno"))
                .put("retorno2", jsonMSB.get("retorno"));

        return json.toString();
    }


}
