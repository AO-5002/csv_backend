package org.example.csv_backend.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.csv_backend.dtos.PortfolioCreateDto;
import org.example.csv_backend.dtos.PortfolioResponseDto;
import org.example.csv_backend.dtos.PortfolioSummaryDto;
import org.example.csv_backend.services.PortfolioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/portfolios")
@CrossOrigin(
        origins = "http://localhost:8080",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
                RequestMethod.DELETE, RequestMethod.OPTIONS}
)
public class PortfolioController {

    private final PortfolioService portfolioService;

    @PostMapping
    public ResponseEntity<PortfolioResponseDto> createPortfolio(
            @RequestBody @Valid PortfolioCreateDto portfolioDto
    ) {
        PortfolioResponseDto created = portfolioService.createPortfolio(portfolioDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<PortfolioSummaryDto>> getAllPortfolios() {
        List<PortfolioSummaryDto> portfolios = portfolioService.getAllPortfolios();
        return ResponseEntity.ok(portfolios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PortfolioResponseDto> getPortfolioById(@PathVariable Long id) {
        PortfolioResponseDto portfolio = portfolioService.getPortfolioById(id);
        return ResponseEntity.ok(portfolio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePortfolio(@PathVariable Long id) {
        portfolioService.deletePortfolio(id);
        return ResponseEntity.noContent().build();
    }
}