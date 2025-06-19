package com.globetrotter.mcp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/mcp")
public class McpController {

    @Value("${mcp.server.name}")
    private String serverName;

    @Value("${mcp.server.version}")
    private String version;

    @Value("${mcp.server.description}")
    private String description;

    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> health() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");
        response.put("server", serverName);
        response.put("version", version);
        response.put("timestamp", System.currentTimeMillis());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/info")
    public ResponseEntity<Map<String, Object>> info() {
        Map<String, Object> response = new HashMap<>();
        response.put("name", serverName);
        response.put("version", version);
        response.put("description", description);
        response.put("type", "MCP_SERVER");
        return ResponseEntity.ok(response);
    }
}
