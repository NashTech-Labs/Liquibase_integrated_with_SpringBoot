package com.knoldus.example.liquibase.poc.repository;

import com.knoldus.example.liquibase.poc.domain.Poc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PocRepository extends JpaRepository<Poc, Long> {
}