package com.myproject.vaccinemanagement.rest;

import com.myproject.vaccinemanagement.model.Vaccine;
import com.myproject.vaccinemanagement.service.IVaccineService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Stock Controller", description="Controller will register, update , delete, search and display vaccines")
public class VaccineController {
    @Autowired
    private IVaccineService service;

    @GetMapping("/vaccine-info")
    @Operation(summary = "GET Operation", description = "This API method will display all the vaccines")
    public ResponseEntity<List> getVaccinceInfo(){
        List<Vaccine> vaccines = service.fetchAllVaccine();
        return new ResponseEntity<List>(vaccines, HttpStatus.OK);
    }
    
    @GetMapping("/vaccine-by-name/{vname}")
    @Operation(summary = "GET Operation", description = "This API method will search and display vaccines based on the entered vaccine name")
    public ResponseEntity<List> getVaccinceByName(@PathVariable("vname")String vname){
        List<Vaccine> vaccines = service.searchByVaccineNameContaining(vname);
        return new ResponseEntity<List>(vaccines, HttpStatus.OK);
    }
    
    @GetMapping("/vaccine-by-manufacturer/{cname}")
    @Operation(summary = "GET Operation", description = "This API method will search and display vaccines based on the entered vaccine manufacturer name")
    public ResponseEntity<List> getVaccinceByManufacturingCompanyName(@PathVariable("cname")String cname){
        List<Vaccine> vaccines = service.searchByManufacturingCompanyContaining(cname);
        return new ResponseEntity<List>(vaccines, HttpStatus.OK);
    }
    
    @GetMapping("/vaccine-by-supplier/{sname}")
    @Operation(summary = "GET Operation", description = "This API method will search and display vaccines based on the entered vaccine supplier name")
    public ResponseEntity<List> getVaccinceBySupplierName(@PathVariable("sname")String sname){
        List<Vaccine> vaccines = service.searchBySupplierContaining(sname);
        return new ResponseEntity<List>(vaccines, HttpStatus.OK);
    }
    
    @GetMapping("/vaccine-between-price")
    @Operation(summary = "GET Operation", description = "This API method will search and display vaccines within a given price range")
    public ResponseEntity<List> getVaccinceByPriceBetween(@RequestParam Double p1, @RequestParam Double p2){
        List<Vaccine> vaccines = service.searchByPriceBetween(p1,p2);
        return new ResponseEntity<List>(vaccines, HttpStatus.OK);
    }
    
    @GetMapping("/vaccine-price-geater")
    @Operation(summary = "GET Operation", description = "This API method will search and display vaccines with price above a given value")
    public ResponseEntity<List> getVaccinceByPriceGreaterThanEqual(@RequestParam Double p){
        List<Vaccine> vaccines = service.searchByPriceGreaterThanEqual(p);
        return new ResponseEntity<List>(vaccines, HttpStatus.OK);
    }
    
    @GetMapping("/vaccine-price-lesser")
    @Operation(summary = "GET Operation", description = "This API method will search and display vaccines with price below a given value")
    public ResponseEntity<List> getVaccinceByPriceLessThanEqual(@RequestParam Double p){
        List<Vaccine> vaccines = service.searchByPriceLessThanEqual(p);
        return new ResponseEntity<List>(vaccines, HttpStatus.OK);
    }
    
    @PostMapping("/add-vac")
    @Operation(summary = "POST Operation", description = "This API method will register a new vaccine")
    public ResponseEntity<String> registerVac(@RequestBody Vaccine vaccine) {
    	String str = service.registerVaccineDetails(vaccine);
    	return new ResponseEntity<String>(str, HttpStatus.CREATED);
    }
    
    @PutMapping("/update-vac")
    @Operation(summary = "PUT Operation", description = "This API method will receive the details of the vaccine and check if it is already present, if found it will update the vaccine record, else return BAD Request")
    public ResponseEntity<String> updateVaccineInfo(@RequestBody Vaccine vaccine) {
    	String str = service.updateVaccineInfo(vaccine);
		return new ResponseEntity<String>(str, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete-data/{vId}")
    @Operation(summary = "PUT Operation", description = "This API method will receive the id of the vaccine and check if it is already present, if found it will delete the vaccine record, else return BAD Request")
    public ResponseEntity<String> deleteVaccineInfo(@PathVariable("vId")Integer id) {
    	String str = service.deleteVaccineRecord(id);
    	return new ResponseEntity<String>(str, HttpStatus.OK);
    	
    }
    
    @PatchMapping("/update-vac-price/{vid}/{price}")
    @Operation(summary = "PUT Operation", description = "This API method will receive the ids of the vaccine and check if it is already present, if found update the price of the vaccine, else return BAD Request")
    public ResponseEntity<String> updateVaccinePrice(@PathVariable("vid") Integer id, @PathVariable("price") Double price) {
    	String str = service.updateVaccinePrice(id,price);
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
    
}
