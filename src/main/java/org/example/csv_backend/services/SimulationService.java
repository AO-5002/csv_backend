package org.example.csv_backend.services;

import lombok.RequiredArgsConstructor;
import org.example.csv_backend.dtos.SimulationRequestDto;
import org.example.csv_backend.dtos.SimulationResultDto;
import org.example.csv_backend.entities.Portfolio;
import org.example.csv_backend.entities.SimulationResult;
import org.example.csv_backend.exceptions.CsvException;
import org.example.csv_backend.repositories.PortfolioRepository;
import org.example.csv_backend.repositories.SimulationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SimulationService {

    private final SimulationRepository simulationResultRepository;
    private final PortfolioRepository portfolioRepository;
    private final RestTemplate restTemplate = new RestTemplate();

    private static final String FASTAPI_URL = "http://localhost:8000/api/simulate";

    @Transactional
    public SimulationResultDto runSimulation(SimulationRequestDto request) {
        // Get portfolio
        Portfolio portfolio = portfolioRepository.findById(request.getPortfolioId())
                .orElseThrow(() -> new CsvException(
                        "Portfolio not found with id: " + request.getPortfolioId(),
                        HttpStatus.NOT_FOUND
                ));

        // TODO: Call FastAPI here
        // Map<String, Object> fastapiRequest = buildFastApiRequest(portfolio, request);
        // Map<String, Object> fastapiResponse = restTemplate.postForObject(
        //     FASTAPI_URL, fastapiRequest, Map.class
        // );

        // For now, create a dummy result
        SimulationResult result = new SimulationResult();
        result.setPortfolio(portfolio);
        result.setNumSimulations(request.getNumSimulations());
        result.setScenarioType(request.getScenarioType());
        result.setExpectedLossTimeSeries("[100000, 120000, 140000, 160000, 180000, 200000]");
        result.setMeanExpectedLoss(150000.0);
        result.setMedianExpectedLoss(145000.0);
        result.setVar95(250000.0);
        result.setWorstCaseExpectedLoss(300000.0);
        result.setSimulatedAt(LocalDateTime.now());

        SimulationResult saved = simulationResultRepository.save(result);
        return mapToDto(saved);
    }

    public List<SimulationResultDto> getSimulationsByPortfolio(Long portfolioId) {
        List<SimulationResult> results = simulationResultRepository.findByPortfolioIdOrderBySimulatedAtDesc(portfolioId);
        return results.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private SimulationResultDto mapToDto(SimulationResult result) {
        SimulationResultDto dto = new SimulationResultDto();
        dto.setId(result.getId());
        dto.setPortfolioId(result.getPortfolio().getId());
        dto.setNumSimulations(result.getNumSimulations());
        dto.setScenarioType(result.getScenarioType());
        dto.setMeanExpectedLoss(result.getMeanExpectedLoss());
        dto.setMedianExpectedLoss(result.getMedianExpectedLoss());
        dto.setVar95(result.getVar95());
        dto.setWorstCaseExpectedLoss(result.getWorstCaseExpectedLoss());
        dto.setSimulatedAt(result.getSimulatedAt());
        return dto;
    }
}