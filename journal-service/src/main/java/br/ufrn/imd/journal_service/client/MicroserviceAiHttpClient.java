package br.ufrn.imd.journal_service.client;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@HttpExchange("/ms1")
public interface MicroserviceAiHttpClient {
    @PostExchange("/advise")
    @CircuitBreaker(name = "MicroserviceAiCircuitBreaker", fallbackMethod = "fallbackMicroserviceAi")
    @Retry(name = "MicroserviceAiRetry",fallbackMethod = "fallbackMicroserviceAi")
    @Bulkhead(name = "MicroserviceAiBulkHead", fallbackMethod = "fallbackMicroserviceAi")
    @RateLimiter( name = "MicroserviceAiRateLimit", fallbackMethod = "fallbackMicroserviceAi")
    String advise(
        @RequestBody String prompString,
        @RequestParam(name = "id", required = false) String id
    );

    public default String fallbackMicroserviceAi(String prompt, String id, Throwable throwable){
        return "Service unavailable at the moment. Try again later.";
    }
}
