package org.example.csv_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(name = "auth_id", unique = true, nullable = false, updatable = false)
    private String authId;

    @Column(name = "balance", nullable = false)
    private Double balance;

    @Column(name = "dpd_state", nullable = false)
    private String dpdState;

    @Column(name = "FICO_score", nullable = false)
    private Integer FICOScore;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    @CreatedDate
    private LocalDateTime uploadedAt;
}
