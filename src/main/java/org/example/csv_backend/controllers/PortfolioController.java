package org.example.csv_backend.controllers;


import lombok.RequiredArgsConstructor;
import org.example.csv_backend.entities.Portfolio;
import org.example.csv_backend.services.PortfolioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/portfolios")
@CrossOrigin(
        origins = "http://localhost:3000",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS}
)
public class PortfolioController {

    private final PortfolioService portfolioService;

    public ResponseEntity<Portfolio> createPortfolio() {
        return null;
    }
}
