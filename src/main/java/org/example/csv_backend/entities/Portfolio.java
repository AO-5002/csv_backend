package org.example.csv_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "portfolio")
@EntityListeners(AuditingEntityListener.class)
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double lgd;

    @Column(nullable = false)
    private Integer timeHorizonMonths;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts = new ArrayList<>();

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SimulationResult> simulationResults = new ArrayList<>();

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // Helper methods for calculated fields
    public Double getTotalEad() {
        if (accounts == null || accounts.isEmpty()) {
            return 0.0;
        }
        return accounts.stream()
                .mapToDouble(Account::getBalance)
                .sum();
    }

    public Double getDelinquencyRate() {
        if (accounts == null || accounts.isEmpty()) {
            return 0.0;
        }

        long delinquentCount = accounts.stream()
                .filter(acc -> !acc.getDpdState().equals("CURRENT"))
                .count();

        return (double) delinquentCount / accounts.size() * 100;
    }
}