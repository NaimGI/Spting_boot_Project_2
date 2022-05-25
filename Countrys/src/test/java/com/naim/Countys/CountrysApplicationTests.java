package com.naim.Countys;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.naim.Countrys.entities.city;
import com.naim.Countrys.entities.country;
import com.naim.Countrys.repos.CountryRepository;
import com.naim.Countrys.service.CountryService;
@SpringBootTest
class CountryApplicationTests {
@Autowired
private CountryRepository AnimalRepository;

@Autowired
private CountryService AnimalService;

}
