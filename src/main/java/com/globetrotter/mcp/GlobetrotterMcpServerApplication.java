package com.globetrotter.mcp;

import com.globetrotter.mcp.travel.service.TravelService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class GlobetrotterMcpServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GlobetrotterMcpServerApplication.class, args);
    }

    @Bean
    public ToolCallbackProvider tools(TravelService travelService) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(travelService)
                .build();
    }

}
