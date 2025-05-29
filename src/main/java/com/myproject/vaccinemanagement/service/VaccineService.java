package com.myproject.vaccinemanagement.service;

import com.myproject.vaccinemanagement.error.VaccineNotFoundException;
import com.myproject.vaccinemanagement.model.Vaccine;
import com.myproject.vaccinemanagement.repository.IVaccineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VaccineService implements IVaccineService{
    IVaccineRepo repo;

    @Autowired
    public void setRepo(IVaccineRepo repo) {
        this.repo = repo;
    }

    @Override
    public String registerVaccineDetails(Vaccine vaccine) {
        repo.save(vaccine);
        return "Vaccine info registered with Id " + vaccine.getId();
    }

    @Override
    public List<Vaccine> fetchAllVaccine() {
        return (List<Vaccine>)repo.findAll();
    }

    @Override
    public List<Vaccine> searchByVaccineNameContaining(String containing) {
        return repo.findByVaccineNameContaining(containing);
    }

    @Override
    public List<Vaccine> searchBySupplierContaining(String containing) {
        return repo.findBySupplierContaining(containing);
    }

    @Override
    public String deleteVaccineRecord(Integer id) {
    	Optional<Vaccine> optional = repo.findById(id);
    	if(optional.isPresent()) {
    		repo.deleteById(id);
    		return "Vaccine details deleted";
    	}
    	else
    		throw new VaccineNotFoundException("Vaccine Not Found");
    }

    @Override
    public Vaccine fetchVaccineById(Integer id) {
        
    	Optional<Vaccine> optional = repo.findById(id); 
    	return optional.get();
    }

    @Override
    public List<Vaccine> searchByManufacturingCompanyContaining(String containing) {
        return repo.findByManufacturingCompanyContaining(containing);
    }

	@Override
	public String updateVaccineInfo(Vaccine vaccine) {
		Optional<Vaccine> optional = repo.findById(vaccine.getId()); 
    	if(optional.isPresent()) {
    		repo.save(vaccine);
    		return "Vaccine details updated";
    	}
    	else
    			throw new VaccineNotFoundException("Vaccine Not Found");
	}

	@Override
	public String updateVaccinePrice(Integer id, Double price) {
		Optional<Vaccine> optional = repo.findById(id); 
    	if(optional.isPresent()) {
    		optional.get().setPrice(price);
    		repo.save(optional.get());
    		return "Vaccine's price updated";
    	}
    	else
			throw new VaccineNotFoundException("Vaccine Not Found");
	}

	@Override
	public List<Vaccine> searchByPriceBetween(Double start, Double end) {
		return repo.findByPriceBetween(start, end);
	}

	@Override
	public List<Vaccine> searchByPriceGreaterThanEqual(Double price) {
		return repo.findByPriceGreaterThanEqual(price);
	}

	@Override
	public List<Vaccine> searchByPriceLessThanEqual(Double price) {
		return repo.findByPriceLessThanEqual(price);
	}
}
