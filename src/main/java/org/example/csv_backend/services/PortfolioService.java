package org.example.csv_backend.services;

import lombok.RequiredArgsConstructor;
import org.example.csv_backend.dtos.PortfolioCreateDto;
import org.example.csv_backend.dtos.PortfolioResponseDto;
import org.example.csv_backend.dtos.PortfolioSummaryDto;
import org.example.csv_backend.entities.Portfolio;
import org.example.csv_backend.exceptions.CsvException;
import org.example.csv_backend.mappers.PortfolioMapper;
import org.example.csv_backend.repositories.PortfolioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final PortfolioMapper portfolioMapper;

    @Transactional
    public PortfolioResponseDto createPortfolio(PortfolioCreateDto dto) {
        Portfolio portfolio = portfolioMapper.dtoToPortfolio(dto);
        portfolio.setCreatedAt(LocalDateTime.now());

        // Set bidirectional relationship
        if (portfolio.getAccounts() != null) {
            portfolio.getAccounts().forEach(account -> {
                account.setPortfolio(portfolio);
                account.setUploadedAt(LocalDateTime.now());
            });
        }

        Portfolio saved = portfolioRepository.save(portfolio);
        return portfolioMapper.portfolioToResponseDto(saved);
    }

    public List<PortfolioSummaryDto> getAllPortfolios() {
        return portfolioRepository.findAll().stream()
                .map(portfolioMapper::portfolioToSummaryDto)
                .collect(Collectors.toList());
    }

    public PortfolioResponseDto getPortfolioById(Long id) {
        Portfolio portfolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new CsvException(
                        "Portfolio not found with id: " + id,
                        HttpStatus.NOT_FOUND
                ));
        return portfolioMapper.portfolioToResponseDto(portfolio);
    }

    @Transactional
    public void deletePortfolio(Long id) {
        if (!portfolioRepository.existsById(id)) {
            throw new CsvException(
                    "Portfolio not found with id: " + id,
                    HttpStatus.NOT_FOUND
            );
        }
        portfolioRepository.deleteById(id);
    }
}