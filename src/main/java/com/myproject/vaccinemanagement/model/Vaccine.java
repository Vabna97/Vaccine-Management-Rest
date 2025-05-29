package com.myproject.vaccinemanagement.model;

import jakarta.persistence.*;

@Entity

public class Vaccine {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Integer id;
    String vaccineName;
    String manufacturingCompany;
    Double price;
    Integer currentStock;
    String supplier;
    String supplierContactNumber;

    public Vaccine() {
    }

    public Vaccine(Integer id, String vaccineName, String manufacturingCompany, Double price, Integer currentStock,
			String supplier, String supplierContactNumber) {
		super();
		this.id = id;
		this.vaccineName = vaccineName;
		this.manufacturingCompany = manufacturingCompany;
		this.price = price;
		this.currentStock = currentStock;
		this.supplier = supplier;
		this.supplierContactNumber = supplierContactNumber;
	}

	@Override
	public String toString() {
		return "Vaccine [id=" + id + ", vaccineName=" + vaccineName + ", manufacturingCompany=" + manufacturingCompany
				+ ", price=" + price + ", currentStock=" + currentStock + ", supplier=" + supplier
				+ ", supplierContactNumber=" + supplierContactNumber + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public String getManufacturingCompany() {
		return manufacturingCompany;
	}

	public void setManufacturingCompany(String manufacturingCompany) {
		this.manufacturingCompany = manufacturingCompany;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getCurrentStock() {
		return currentStock;
	}

	public void setCurrentStock(Integer currentStock) {
		this.currentStock = currentStock;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getSupplierContactNumber() {
		return supplierContactNumber;
	}

	public void setSupplierContactNumber(String supplierContactNumber) {
		this.supplierContactNumber = supplierContactNumber;
	}
    
    
}
