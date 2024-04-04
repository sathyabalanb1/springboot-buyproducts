package com.buyproducts.demo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Orderplacement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="product_id")
	private Product prod;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="dealer_id")
	private Dealer dealer;
	
	@Column(name = "status", nullable = false, columnDefinition = "boolean default true")
	private boolean enabled = true;
	
	@CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP ")
    private LocalDateTime creationtime;
    
    @UpdateTimestamp
    @Column(columnDefinition = "TIMESTAMP",insertable = false)
    private LocalDateTime updatetime ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProd() {
		return prod;
	}

	public void setProd(Product prod) {
		this.prod = prod;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public LocalDateTime getCreationtime() {
		return creationtime;
	}

	public void setCreationtime(LocalDateTime creationtime) {
		this.creationtime = creationtime;
	}

	public LocalDateTime getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(LocalDateTime updatetime) {
		this.updatetime = updatetime;
	}
    
    

}