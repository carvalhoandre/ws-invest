package com.andrecarvalho.acinvest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrecarvalho.acinvest.domain.Investimento;

public interface InvestimentoRepository extends JpaRepository<Investimento, Integer>{

}
