package com.globetrotter.mcp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class McpService {

    @Value("${mcp.server.name}")
    private String serverName;

    @Value("${mcp.server.version}")
    private String version;

    @Value("${mcp.server.description}")
    private String description;

    public Map<String, Object> getServerInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("name", serverName);
        info.put("version", version);
        info.put("description", description);
        info.put("type", "MCP_SERVER");
        info.put("capabilities", getCapabilities());
        return info;
    }

    public Map<String, Object> getHealthStatus() {
        Map<String, Object> health = new HashMap<>();
        health.put("status", "UP");
        health.put("server", serverName);
        health.put("version", version);
        health.put("timestamp", System.currentTimeMillis());
        return health;
    }

    private Map<String, Object> getCapabilities() {
        Map<String, Object> capabilities = new HashMap<>();
        capabilities.put("protocol_version", "1.0");
        capabilities.put("features", new String[] { "health_check", "server_info" });
        return capabilities;
    }
}
