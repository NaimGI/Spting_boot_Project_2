package com.naim.Countrys.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.naim.Countrys.entities.city;
import com.naim.Countrys.entities.country;
public interface CountryService {
country saveCountry(country a);
country updateCountry(country a);
void deleteCountry(country a);
 void deleteCountryById(Long id);
country getCountry(Long id);
List<country> getAllCountry();
Page<country> getAllCountrysParPage(int page, int size);
List<country> findByNomCountry(String nom);
List<country> findByNomCountryContains(String nom);
List<country> findByCity (city groupe);
List<country> findByCityIdCity(Long id);
List<country> findByOrderByNomCountryAsc();
List<country> trierCountrysNoms();
}