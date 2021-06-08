package com.andrecarvalho.acinvest.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.andrecarvalho.acinvest.domain.Category;
import com.andrecarvalho.acinvest.domain.Investment;
import com.andrecarvalho.acinvest.dto.InvestmentDTO;
import com.andrecarvalho.acinvest.dto.InvestmentNewDTO;
import com.andrecarvalho.acinvest.repository.InvestmentRepository;
import com.andrecarvalho.acinvest.service.exceptions.DataIntegrityException;
import com.andrecarvalho.acinvest.service.exceptions.ObjectNotFoundException;

@Service
public class InvestmentService {
	
	@Autowired
	private InvestmentRepository repo;
	
	public List<InvestmentDTO> findAll(){
		List<Investment> result = repo.findAll();
		return result.stream().map(x -> new InvestmentDTO(x)).collect(Collectors.toList());
	}
	
	public Investment findAllById(Long id){
		Optional<Investment> obj = repo.findById(id);
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
	
	public Investment fromDTO(InvestmentDTO objDto) {
		return new Investment(objDto.getId(), objDto.getActive(), objDto.getValue(), objDto.getQuota(), objDto.getPurchase(), null);
	}
	
	public Investment fromDTO(InvestmentNewDTO objDto) {
		Category category = new Category(null, objDto.getName(), objDto.getDescription());
		return new Investment(objDto.getId(), objDto.getActive(), objDto.getValue(), objDto.getQuota(), objDto.getPurchase(), category);
	}
	
	public Investment insert(Investment obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

}
