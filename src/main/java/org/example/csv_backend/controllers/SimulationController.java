package org.example.csv_backend.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.csv_backend.dtos.SimulationRequestDto;
import org.example.csv_backend.dtos.SimulationResultDto;
import org.example.csv_backend.services.SimulationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/simulations")
@CrossOrigin(
        origins = "http://localhost:8080",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS}
)
public class SimulationController {

    private final SimulationService simulationService;

    @PostMapping("/run")
    public ResponseEntity<SimulationResultDto> runSimulation(
            @RequestBody @Valid SimulationRequestDto request
    ) {
        SimulationResultDto result = simulationService.runSimulation(request);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/portfolio/{portfolioId}")
    public ResponseEntity<List<SimulationResultDto>> getPortfolioSimulations(
            @PathVariable Long portfolioId
    ) {
        List<SimulationResultDto> results = simulationService.getSimulationsByPortfolio(portfolioId);
        return ResponseEntity.ok(results);
    }
}