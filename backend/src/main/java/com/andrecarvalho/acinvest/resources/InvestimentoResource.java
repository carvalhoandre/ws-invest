package com.andrecarvalho.acinvest.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrecarvalho.acinvest.domain.Investimento;
import com.andrecarvalho.acinvest.repository.InvestimentoRepository;

@RestController
public class InvestimentoResource {
	
	@Autowired
	private InvestimentoRepository investimentoRepository;

	@GetMapping
	@RequestMapping("/investimentos")
	public List<Investimento> listarTodos(){
		return investimentoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Investimento> buscarPeloCodigo(@PathVariable Integer id) {
		return investimentoRepository.findById(id);
	}
	
	@DeleteMapping
	public void delete(@PathVariable Integer id) {
		investimentoRepository.deleteById(id);
	}
	
	@PostMapping
	public Investimento cadastrar(@RequestBody Investimento investimento) {
		return investimentoRepository.save(investimento);
	}
}
