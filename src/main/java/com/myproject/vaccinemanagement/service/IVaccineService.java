package com.myproject.vaccinemanagement.service;

import java.util.List;
import java.util.Optional;

import com.myproject.vaccinemanagement.model.Vaccine;

public interface IVaccineService {

	public String registerVaccineDetails(Vaccine vaccine);
    public List<Vaccine> fetchAllVaccine();
    public List<Vaccine> searchByVaccineNameContaining(String containing);
    public List<Vaccine> searchBySupplierContaining(String containing);
    public List<Vaccine> searchByManufacturingCompanyContaining(String containing);
    public String deleteVaccineRecord(Integer id);;
    public Vaccine fetchVaccineById(Integer id);
	public String updateVaccineInfo(Vaccine vaccine);
	public String updateVaccinePrice(Integer id, Double price);
	public List<Vaccine> searchByPriceBetween(Double start, Double end);
	public List<Vaccine> searchByPriceGreaterThanEqual(Double price);
    public List<Vaccine> searchByPriceLessThanEqual(Double price);
}
