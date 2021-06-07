package com.andrecarvalho.acinvest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrecarvalho.acinvest.domain.Investment;

public interface InvestmentRepository extends JpaRepository<Investment, Long>{

}
