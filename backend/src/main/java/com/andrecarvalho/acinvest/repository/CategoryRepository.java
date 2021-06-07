package com.andrecarvalho.acinvest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrecarvalho.acinvest.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
