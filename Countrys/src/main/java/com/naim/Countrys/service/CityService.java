package com.naim.Countrys.service;

import java.util.List;

import com.naim.Countrys.entities.city;


public interface CityService {

    List <city> findAll();
    
    city saveGroupe(city g);
    city updateGroupe(city g);
    void deleteGroupe(city g);
     void deleteGroupeById(Long id);
     city getGroupe (Long idGrp);

}