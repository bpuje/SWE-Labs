package edu.mum.cs.cs425.eregister.versionone.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long productId;

    private Long productNumber;

    @NotBlank(message = "* First Name is required")
    private String name;

    @NotNull(message = "* price is required")
    private Double unitPrice;
    private Integer quantityInStock;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateSupplied = LocalDate.now();

    @ManyToOne(optional = false)
    @JoinColumn(name = "supplier_fk")
    private Supplier supplier = new Supplier();

    public Product() {
        super();
    }

    public Product(Long productNumber,
                   @NotBlank(message = "* First Name is required") String name,
                   @NotNull(message = "* price is required") Double unitPrice, Integer quantityInStock, LocalDate dateSupplied, Supplier supplier) {
        this.productNumber = productNumber;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantityInStock = quantityInStock;
        this.dateSupplied = dateSupplied;
        this.supplier = supplier;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Product{" +
                "productId=" + productId +
                ", productNumber=" + productNumber +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantityInStock=" + quantityInStock +
                ", dateSupplied=" + dateSupplied +
                ", supplier=" + supplier +
                '}';
    }
}
