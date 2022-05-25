package com.naim.Countrys.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.naim.Countrys.entities.city;
import com.naim.Countrys.entities.country;
import com.naim.Countrys.repos.CountryRepository;
@Service
public class CountryServiceImpl implements CountryService {
@Autowired
CountryRepository countryRepository;
	
	@Override
	public country saveCountry(country a) {
		return countryRepository.save(a);
	}
	@Override
	public country updateCountry(country a) {
		// TODO Auto-generated method stub
		return countryRepository.save(a);
	}
	@Override
	public void deleteCountry(country a) {
		// TODO Auto-generated method stub
		countryRepository.delete(a);
	}
	@Override
	public void deleteCountryById(Long id) {
		// TODO Auto-generated method stub
		countryRepository.deleteById(id);
	}
	@Override
	public country getCountry(Long id) {
		// TODO Auto-generated method stub
		return countryRepository.findById(id).get();
	}
	@Override
	public List<country> getAllCountry() {
		// TODO Auto-generated method stub
		return countryRepository.findAll();
	}
	@Override
	public Page<country> getAllCountrysParPage(int page, int size) {
		return countryRepository.findAll(PageRequest.of(page, size));
	}
	@Override
	public List<country> findByNomCountry(String nom) {
		return countryRepository.findByNomCountry(nom);
	}
	@Override
	public List<country> findByNomCountryContains(String nom) {
		// TODO Auto-generated method stub
		return countryRepository.findByNomCountryContains(nom);
	}
	@Override
	public List<country> findByCity(city city) {
		// TODO Auto-generated method stub
		return countryRepository.findByCity(city);
	}
	@Override
	public List<country> findByCityIdCity(Long id) {
		// TODO Auto-generated method stub
		return countryRepository.findByCityIdCity(id) ;
	}
	@Override
	public List<country> findByOrderByNomCountryAsc() {
		// TODO Auto-generated method stub
		return countryRepository.findByOrderByNomCountryAsc();
	}
	@Override
	public List<country> trierCountrysNoms() {
		// TODO Auto-generated method stub
		return countryRepository.trierCountrysNoms();
	}
}