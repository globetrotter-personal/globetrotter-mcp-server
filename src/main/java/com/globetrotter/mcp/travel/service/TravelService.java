package com.globetrotter.mcp.travel.service;

import java.time.LocalDate;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.globetrotter.mcp.travel.client.TravelServiceClient;
import com.globetrotter.mcp.travel.model.FlightSearchResponse;
import com.globetrotter.mcp.travel.model.FlightSearchRequest;

@Service
@RequiredArgsConstructor
public class TravelService {

    private final TravelServiceClient travelServiceClient;

    @Tool(name = "get_flight_info1", description = "Get flight information")
    public FlightSearchResponse getFlightInfo(String from, String to, String fromDate, String toDate,
            int numberOfPassengers, String travelClass) {

        LocalDate fromLocalDate = LocalDate.parse(fromDate);
        LocalDate toLocalDate = LocalDate.parse(toDate);
        FlightSearchRequest request = new FlightSearchRequest();
        request.setFromAirportCode(from);
        request.setToAirportCode(to);
        request.setFromDate(fromLocalDate);
        request.setToDate(toLocalDate);
        request.setNumberOfPassengers(numberOfPassengers);
        request.setTravelClass(travelClass);

        FlightSearchResponse response = travelServiceClient.getFlights(request);
        return response;
    }

}
