package com.myproject.vaccinemanagement.repository;

import com.myproject.vaccinemanagement.model.Vaccine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IVaccineRepo extends CrudRepository<Vaccine, Integer> {
    public List<Vaccine> findByVaccineNameContaining(String containing);
    public List<Vaccine> findBySupplierContaining(String containing);
    public List<Vaccine> findByManufacturingCompanyContaining(String containing);
    public List<Vaccine> findByPriceBetween(Double start, Double end);
    public List<Vaccine> findByPriceGreaterThanEqual(Double price);
    public List<Vaccine> findByPriceLessThanEqual(Double price);
}