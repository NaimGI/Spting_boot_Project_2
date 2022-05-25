package com.naim.Countrys.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naim.Countrys.entities.city;
import com.naim.Countrys.repos.CityRepository;


@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository grpRepository;

    @Override
    public List <city> findAll() {
        return grpRepository.findAll();
    }

	@Override
	public city saveGroupe(city g) {
		return grpRepository.save(g);
	}

	@Override
	public city updateGroupe(city g) {
		return grpRepository.save(g);
	}

	@Override
	public void deleteGroupe(city g) {
		grpRepository.delete(g);
	}

	@Override
	public void deleteGroupeById(Long idGrp) {
		grpRepository.deleteById(idGrp);
	}

	@Override
	public city getGroupe(Long idGrp) {
		return grpRepository.findById(idGrp).get();
	}

   
}