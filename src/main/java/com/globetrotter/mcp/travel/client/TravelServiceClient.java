package com.globetrotter.mcp.travel.client;

import com.globetrotter.mcp.travel.model.FlightSearchRequest;
import com.globetrotter.mcp.travel.model.FlightSearchResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import feign.Request;

@FeignClient(name = "travel-service", url = "${services.travel.url}", configuration = FeignConfig.class)
public interface TravelServiceClient {

    @GetMapping("/travel/flights")
    FlightSearchResponse getFlights(
            @RequestBody FlightSearchRequest request);

    @PostMapping("/travel/flights/search")
    FlightSearchResponse searchFlights(@RequestBody FlightSearchRequest request);
}

@Configuration
class FeignConfig {
    @Bean
    public Request.Options requestOptions() {
        return new Request.Options(5000, 90000); // connectTimeout, readTimeout in milliseconds
    }
}
