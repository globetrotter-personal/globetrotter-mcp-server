package com.globetrotter.mcp;

import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import com.globetrotter.mcp.travel.service.TravelService;

@SpringBootApplication
@EnableFeignClients
public class McpServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(McpServerApplication.class, args);
    }

    @Bean
    public MethodToolCallbackProvider flightToolCallbackProvider(TravelService travelService) {
        return MethodToolCallbackProvider.builder().toolObjects(travelService).build();
    }
}
