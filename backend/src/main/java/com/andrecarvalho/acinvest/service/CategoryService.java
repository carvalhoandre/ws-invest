package com.andrecarvalho.acinvest.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.andrecarvalho.acinvest.domain.Category;
import com.andrecarvalho.acinvest.domain.Investment;
import com.andrecarvalho.acinvest.dto.CategoryDTO;
import com.andrecarvalho.acinvest.repository.CategoryRepository;
import com.andrecarvalho.acinvest.service.exceptions.DataIntegrityException;
import com.andrecarvalho.acinvest.service.exceptions.ObjectNotFoundException;

public class CategoryService {

	@Autowired
	private CategoryRepository repo;
	
	public List<CategoryDTO> findAll(){
		List<Category> result = repo.findAll();
		return result.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
	}
	
	public Category findAllById(Long id) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Não localizado " + id + ", tipo" + Investment.class.getName()));
	}
	
	public void delete(Long id) {
		findAllById(id);
		try {
			repo.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um cliente que possui pedidos pendentes");
		}
	}
	
	public Category fromDTO(CategoryDTO objDto) {
		return new Category(objDto.getId(), objDto.getName(), objDto.getDescription());
	}
	
	public Category insert(Category obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
}
