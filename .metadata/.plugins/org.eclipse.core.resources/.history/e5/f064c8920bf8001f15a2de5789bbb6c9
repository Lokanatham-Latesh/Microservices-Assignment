package com.mindfire.apigateway;


import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class RateLimitExceptionHandler implements WebFilter {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        if (exchange.getResponse().getStatusCode() == HttpStatus.TOO_MANY_REQUESTS) {
            exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
            exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);

            Map<String, Object> response = new HashMap<>();
            response.put("status", 429);
            response.put("message", "Too many requests. Please try again later.");
            
            byte[] responseBytes;
            try {
                responseBytes = objectMapper.writeValueAsBytes(response);
            } catch (Exception e) {
                responseBytes = "{\"status\": 429, \"message\": \"Too many requests.\"}".getBytes(StandardCharsets.UTF_8);
            }

            DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(responseBytes);
            return exchange.getResponse().writeWith(Mono.just(buffer));
        }
        return chain.filter(exchange);
    }
}
