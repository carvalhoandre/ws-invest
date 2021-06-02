package com.andrecarvalho.acinvest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrecarvalho.acinvest.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
