package br.ufrn.imd.simulator_external_mcp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SimulatorExternalMcpApplication {
 private static final Logger logger = LoggerFactory.getLogger(SimulatorExternalMcpApplication.class);

    @Value("${mcp.simulate.failure:false}")
    private boolean simulateFailure;
    private int requestCount = 0;

    public static void main(String[] args) {
        SpringApplication.run(SimulatorExternalMcpApplication.class, args);
    }

    @GetMapping("/third-party-mcp-simulator/data")
    public String getData() throws Exception {
        requestCount++;
        if (simulateFailure && requestCount % 2 != 0) { // Falha a cada 2 chamadas
            logger.error("Simulating failure for MCP request #{}", requestCount);
            throw new RuntimeException("Simulated MCP Service Down");
        }
        logger.info("Successfully served MCP request #{}", requestCount);
        return "Random Data from Simulated Third-Party MCP at " + System.currentTimeMillis();
    }

}
