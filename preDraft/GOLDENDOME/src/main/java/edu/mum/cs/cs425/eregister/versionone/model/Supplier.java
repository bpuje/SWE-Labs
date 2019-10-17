package edu.mum.cs.cs425.eregister.versionone.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Supplier {
    @Id
    @GeneratedValue
    private Integer supplierId; // : (should be primary key field)

    @NotBlank(message = "Please provide number")
    private String supplierNumber; //: e.g. 000-61-0001 (required)

    @NotBlank(message = "Please provide first name")
    private String name; //: e.g. Anna (required)


    private	String contactPhoneNumber; //: e.g. 3.78 (optional)

    @OneToMany(mappedBy = "supplier")
    private List<Product> products;

    public Supplier() {
        super();
    }

    public Supplier(@NotBlank(message = "Please provide number") String supplierNumber, @NotBlank(message = "Please provide first name") String name, String contactPhoneNumber, List<Product> products) {
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

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId=" + supplierId +
                ", supplierNumber='" + supplierNumber + '\'' +
                ", name='" + name + '\'' +
                ", contactPhoneNumber='" + contactPhoneNumber + '\'' +
                ", products=" + products +
                '}';
    }
}
