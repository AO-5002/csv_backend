package org.example.csv_backend.mappers;

import org.example.csv_backend.dtos.PortfolioCreateDto;
import org.example.csv_backend.dtos.PortfolioResponseDto;
import org.example.csv_backend.dtos.PortfolioSummaryDto;
import org.example.csv_backend.entities.Portfolio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AccountMapper.class})
public interface PortfolioMapper {

    Portfolio dtoToPortfolio(PortfolioCreateDto dto);

    @Mapping(target = "accountCount", expression = "java(portfolio.getAccounts().size())")
    @Mapping(target = "totalEad", expression = "java(portfolio.getTotalEad())")
    @Mapping(target = "delinquencyRate", expression = "java(portfolio.getDelinquencyRate())")
    PortfolioResponseDto portfolioToResponseDto(Portfolio portfolio);

    @Mapping(target = "accountCount", expression = "java(portfolio.getAccounts().size())")
    @Mapping(target = "totalEad", expression = "java(portfolio.getTotalEad())")
    @Mapping(target = "delinquencyRate", expression = "java(portfolio.getDelinquencyRate())")
    PortfolioSummaryDto portfolioToSummaryDto(Portfolio portfolio);
}