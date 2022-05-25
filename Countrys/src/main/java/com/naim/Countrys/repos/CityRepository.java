package com.naim.Countrys.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naim.Countrys.entities.city;


@Repository
public interface CityRepository extends JpaRepository<city, Long>{

}