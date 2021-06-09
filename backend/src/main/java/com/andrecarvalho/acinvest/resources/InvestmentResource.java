package com.andrecarvalho.acinvest.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andrecarvalho.acinvest.domain.Investment;
import com.andrecarvalho.acinvest.dto.InvestmentDTO;
import com.andrecarvalho.acinvest.service.InvestmentService;

@RestController
@RequestMapping("/investment")
public class InvestmentResource {
	
	@Autowired
	private InvestmentService service;
	

	@GetMapping
	public ResponseEntity<List<InvestmentDTO>> findAll(){
		List<InvestmentDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Investment> findById(@PathVariable Long id) {
		Investment obj = service.findAllById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody InvestmentDTO objDto) {
		Investment obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
