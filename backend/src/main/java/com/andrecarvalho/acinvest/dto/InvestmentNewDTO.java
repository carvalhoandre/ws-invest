package com.andrecarvalho.acinvest.dto;

import java.time.LocalDate;

public class InvestmentNewDTO {
	
	private Long id;
	
	private String active;
	
	private Double value;
	
	private Integer quota;
	
	private LocalDate purchase;
	
	private String name;
	
	private String description;

	public InvestmentNewDTO() {
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
