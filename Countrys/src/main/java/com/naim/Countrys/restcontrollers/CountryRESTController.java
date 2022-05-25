package com.naim.Countrys.restcontrollers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.naim.Countrys.entities.country;
import com.naim.Countrys.service.CountryService;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class CountryRESTController {
@Autowired
CountryService countryService;
@RequestMapping(method = RequestMethod.GET)
public List<country> getAllAnimals() {
return countryService.getAllCountry();
}
@RequestMapping(value="/{id}",method = RequestMethod.GET)
public country getAnimalById(@PathVariable("id") Long id) {
return countryService.getCountry(id);
 }
@RequestMapping(method = RequestMethod.POST)
public country createAnimal(@RequestBody country country) {
return countryService.saveCountry(country);
}
@RequestMapping(method = RequestMethod.PUT)
public country updateAnimal(@RequestBody country country) {
return countryService.updateCountry(country);
}
@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
public void deleteAnimal(@PathVariable("id") Long id)
{
	countryService.deleteCountryById(id);
}
@RequestMapping(value="/prodsgrp/{idGrp}",method = RequestMethod.GET)
public List<country> getAnimalsByGrpId(@PathVariable("idGrp") Long idCity) {
return countryService.findByCityIdCity(idCity);
}
}
