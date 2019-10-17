package edu.mum.cs.cs425.demowebapps.goldendomemarket.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Supplier {
		
		@Id@GeneratedValue
		private Integer supplierId; // : (should be primary key field)
		
		@NotBlank(message = "Please provide number")
		private String supplierNumber; //: e.g. 000-61-0001 (required)
		
		@NotBlank(message = "Please provide first name")
		private String name; //: e.g. Anna (required)

		private	String contactPhoneNumber; //: e.g. 3.78 (optional)
		
		@OneToMany(mappedBy = "supplier")
		private List<Product> products;
		
//		@NotBlank(message = "Please provide date")
//		@DateTimeFormat(pattern = "MM/dd/yyyy")
//		private String enrollmentDate; //: e.g. 2019-5-12 (required)
		
		
//		private Boolean isInternational; //: (values: "Yes", "No") (required) - Hint: Implement/present this data in a drop-down list

		
		public Supplier() {
		}

public Supplier(@NotBlank(message = "Please provide number") String supplierNumber,
		@NotBlank(message = "Please provide first name") String name, String contactPhoneNumber,
		List<Product> products) {
	super();
	this.supplierNumber = supplierNumber;
	this.name = name;
	this.contactPhoneNumber = contactPhoneNumber;
	this.products = products;
}

public Integer getSupplierId() {
	return supplierId;
}

public void setSupplierId(Integer supplierId) {
	this.supplierId = supplierId;
}

public String getSupplierNumber() {
	return supplierNumber;
}

public void setSupplierNumber(String supplierNumber) {
	this.supplierNumber = supplierNumber;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getContactPhoneNumber() {
	return contactPhoneNumber;
}

public void setContactPhoneNumber(String contactPhoneNumber) {
	this.contactPhoneNumber = contactPhoneNumber;
}

public List<Product> getProducts() {
	return products;
}

public void setProducts(List<Product> products) {
	this.products = products;
}

		


		
}
