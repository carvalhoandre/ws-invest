package com.andrecarvalho.acinvest.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.andrecarvalho.acinvest.domain.Category;
import com.andrecarvalho.acinvest.domain.Investment;


public class InvestmentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String active;
	
	private Double value;
	
	private Integer quota;
	
	private LocalDate purchase;

	private String name;
	
	private String description;

	public InvestmentDTO() {
	}

	public InvestmentDTO(Long id, String active, Double value, Integer quota, LocalDate purchase, String name,
			String description) {
		this.id = id;
		this.active = active;
		this.value = value;
		this.quota = quota;
		this.purchase = purchase;
		this.name = name;
		this.description = description;
	}

	public InvestmentDTO(Investment entity) {
		id = entity.getId();
		active = entity.getActive();
		value = entity.getValue();
		quota = entity.getQuota();
		purchase = entity.getPurchase();
	}
	
	public InvestmentDTO(Category entity) {
		name = entity.getName();
		description = entity.getDescription();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Integer getQuota() {
		return quota;
	}

	public void setQuota(Integer quota) {
		this.quota = quota;
	}

	public LocalDate getPurchase() {
		return purchase;
	}

	public void setPurchase(LocalDate purchase) {
		this.purchase = purchase;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
