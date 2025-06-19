# Globetrotter MCP Server

A Spring Boot-based MCP (Model Context Protocol) server for the Globetrotter Travel Application.

## Overview

This MCP server provides a standardized interface for AI assistants to interact with the Globetrotter travel system, enabling them to search for flights, manage bookings, and access travel-related information.

## Features

- RESTful API endpoints for MCP operations
- Health monitoring and metrics
- Configurable server settings
- Spring Boot 3.2.5 with Java 17
- Comprehensive logging and monitoring

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

## Getting Started

### Building the Project

```bash
mvn clean install
```

### Running the Application

```bash
mvn spring-boot:run
```

The server will start on port 8082 by default.

### Docker

```bash
# Build the Docker image
docker build -t globetrotter-mcp-server .

# Run the container
docker run -p 8082:8082 globetrotter-mcp-server
```

## API Endpoints

### Health Check
- `GET /api/mcp/health` - Server health status

### Server Information
- `GET /api/mcp/info` - Server information and capabilities

### Management Endpoints
- `GET /actuator/health` - Spring Boot health check
- `GET /actuator/info` - Application information
- `GET /actuator/metrics` - Application metrics

## Configuration

The application can be configured using the `application.yml` file or environment variables:

```yaml
server:
  port: 8082

mcp:
  server:
    name: globetrotter-mcp-server
    version: 1.0.0
    description: MCP Server for Globetrotter Travel Application
```

## Development

### Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/globetrotter/mcp/
│   │       ├── controller/
│   │       ├── service/
│   │       ├── model/
│   │       └── McpServerApplication.java
│   └── resources/
│       └── application.yml
└── test/
    └── java/
        └── com/globetrotter/mcp/
```

### Adding New Endpoints

1. Create a new controller in the `controller` package
2. Add appropriate request/response models in the `model` package
3. Implement business logic in the `service` package
4. Add tests in the `test` directory

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Submit a pull request

## License

This project is licensed under the MIT License.
