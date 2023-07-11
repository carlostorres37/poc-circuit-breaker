package br.com.carlos.teste.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class TesteClient {

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name = "msB", fallbackMethod = "fallback")
    public String getMSB() {
        try {
            return restTemplate.exchange("http://localhost:8081/ms-b", HttpMethod.GET, new HttpEntity<Object>(null, null), String.class).getBody();
        } catch (Exception e) {
            log.info("Error ao buscar no msB");
            throw e;
        }
    }

    private String fallback(Throwable e) {
        log.info("retornando fallback");
        return new JSONObject().put("retorno", "CircuitBreaker").toString();
    }
}
