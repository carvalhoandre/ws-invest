package com.andrecarvalho.acinvest.dto;

import java.io.Serializable;
import java.util.Date;

import com.andrecarvalho.acinvest.domain.Investment;


public class InvestmentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String active;
	
	private Double value;
	
	private Integer quota;
	
	private Date purchase;


	public InvestmentDTO() {
	}
	
	public InvestmentDTO(Long id, String active, Double value, Integer quota, Date purchase) {
		this.id = id;
		this.active = active;
		this.value = value;
		this.quota = quota;
		this.purchase = purchase;
	}

	public InvestmentDTO(Investment entity) {
		id = entity.getId();
		active = entity.getActive();
		value = entity.getValue();
		quota = entity.getQuota();
		purchase = entity.getPurchase();
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

	public Date getPurchase() {
		return purchase;
	}

	public void setPurchase(Date purchase) {
		this.purchase = purchase;
	}
}
