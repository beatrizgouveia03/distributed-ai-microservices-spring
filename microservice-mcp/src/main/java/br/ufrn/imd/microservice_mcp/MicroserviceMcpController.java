package br.ufrn.imd.microservice_mcp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/mcp")
public class MicroserviceMcpController {

    private static final Logger logger = LoggerFactory.getLogger(MicroserviceMcpController.class);
    private final RestTemplate restTemplate = new RestTemplate(); // Para simular a chamada ao MCP

    @Value("${message:Default message from Microservice1}") // Valor do Config Server
    private String message;



    @RequestMapping("/hello")
    public String hello() {
        return "Hello from Microservice MCP!";
    }

    @RequestMapping("/status")
    public String status() {
        return "Microservice MCP is running!";
    }

    // Simulação de chamada ao MCP Server Terceiros
    @GetMapping("/call-third-party")
    @CircuitBreaker(name = "mcpService", fallbackMethod = "fallbackForMcpService")
    public String callMcpService() {
        logger.info("Attempting to call third-party MCP service.");
        // Simula uma chamada que pode falhar
        // Troque para uma URL real se tiver um serviço de terceiros para testar
        String thirdPartyUrl = "http://localhost:9999/third-party-mcp-simulator/data";
        try {
            String response = restTemplate.getForObject(thirdPartyUrl, String.class);
            logger.info("Received response from third-party: {}", response);
            return "Data from Third-Party MCP: " + response;
        } catch (Exception e) {
            logger.error("Error calling third-party MCP service: {}", e.getMessage());
            throw new RuntimeException("Failed to call third-party service", e);
        }
    }

    // Fallback method para o Circuit Breaker
    public String fallbackForMcpService(Throwable t) {
        logger.warn("Fallback triggered for mcpService. Reason: {}", t.getMessage());
        return "Fallback: Could not get data from Third-Party MCP. Please try again later.";
    }
    
}
