package edu.mum.cs.cs425.demowebapps.goldendomemarket.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Product {
	
	@Id@GeneratedValue
	private Long productId;
	
	private Long productNumber;
	
	private String productName;
	
	private Double unitPrice;
	
	private Integer quantityInStock;
	
	
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateSupplied = LocalDate.now();
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "supplier_fk")
	private Supplier supplier = new Supplier();

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Long productNumber, String productName, Double unitPrice, Integer quantityInStock,
			LocalDate dateSupplied) {
		super();
		this.productNumber = productNumber;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.quantityInStock = quantityInStock;
		this.dateSupplied = dateSupplied;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(Long productNumber) {
		this.productNumber = productNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(Integer quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public LocalDate getDateSupplied() {
		return dateSupplied;
	}

	public void setDateSupplied(LocalDate dateSupplied) {
		this.dateSupplied = dateSupplied;
	}
	

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productNumber=" + productNumber + ", productName=" + productName
				+ ", unitPrice=" + unitPrice + ", quantityInStock=" + quantityInStock + ", dateSupplied=" + dateSupplied
				+ "]";
	}
	
	
	
	

}
