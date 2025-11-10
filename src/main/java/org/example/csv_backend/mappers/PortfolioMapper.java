package org.example.csv_backend.mappers;

import org.example.csv_backend.dtos.PortfolioCreateDto;
import org.example.csv_backend.entities.Portfolio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PortfolioMapper {
    PortfolioCreateDto portfolioToCreateDto(Portfolio portfolio);
    Portfolio portfolioCreateDtoToPortfolio(PortfolioCreateDto portfolioCreateDto);
}
