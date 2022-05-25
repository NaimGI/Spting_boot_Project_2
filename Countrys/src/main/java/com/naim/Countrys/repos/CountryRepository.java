package com.naim.Countrys.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.naim.Countrys.entities.city;
import com.naim.Countrys.entities.country;
@Repository
public interface CountryRepository extends JpaRepository<country, Long> {
	List<country> findByNomCountry(String nom);
	 List<country> findByNomCountryContains(String nom);
	 @Query("select a from country a where a.city = ?1")
	 List<country> findByCity(city city);
	 List<country> findByCityIdCity(Long id);
	 List<country> findByOrderByNomCountryAsc();
	 @Query("select a from country a order by a.nomCountry ASC")
	 List<country> trierCountrysNoms();
	
}