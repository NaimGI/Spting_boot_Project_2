package com.naim.Countrys.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.naim.Countrys.entities.Role;
import com.naim.Countrys.entities.User;
import com.naim.Countrys.entities.city;
import com.naim.Countrys.entities.country;
import com.naim.Countrys.service.CityService;
import com.naim.Countrys.service.CountryService;
import com.naim.Countrys.service.RoleService;
import com.naim.Countrys.service.UsersService;
@Controller
public class CountryController {
@Autowired
CountryService countryService;
@Autowired
CityService cityService;
@Autowired
UsersService usersService;
@Autowired
RoleService roleService;

@RequestMapping("/showCreate")
public String showCreate(ModelMap modelMap)
{
List<city> grps = cityService.findAll();
modelMap.addAttribute("citys", grps);
modelMap.addAttribute("country", new country());
modelMap.addAttribute("mode", "new");
return "formCountry";
}
@RequestMapping("/saveCountry")
public String saveCountry(ModelMap modelMap,@Valid country country,
BindingResult bindingResult)
{
	List<city> grps = cityService.findAll();
	modelMap.addAttribute("citys", grps);
System.out.println(country);
/*if (bindingResult.hasErrors()) return "formCountry";*/
countryService.saveCountry(country);
return "redirect:/ListeCountry";
}

@RequestMapping("/showCreateGrp")
public String showCreateGrp(ModelMap modelMap)
{
modelMap.addAttribute("citys", new city());
modelMap.addAttribute("mode", "new");
return "formGroupe";
}
@RequestMapping("/saveGroupe")
public String saveGroupe(@ModelAttribute("city") city city,ModelMap modelMap) throws ParseException 
{
city saveGroupe = cityService.saveGroupe(city);
return "redirect:/ListeGrp";
}
@RequestMapping("/saveRole")
public String saveRole(@ModelAttribute("role") Role role,ModelMap modelMap) throws ParseException 
{
	Role saveRole = roleService.saveRole(role);
return "redirect:/ListeUsers";
}
@RequestMapping("/showCreateUser")
public String showCreateUser(ModelMap modelMap)
{
	List<Role> roles = roleService.findAll();
	modelMap.addAttribute("roles", roles);
modelMap.addAttribute("users", new User());
modelMap.addAttribute("mode", "new");
return "FormUser";
}
@RequestMapping("/saveUser")
public String saveUser(@ModelAttribute("user") User user,ModelMap modelMap) throws ParseException 
{
User saveUser = usersService.saveUser(user);
return "redirect:/ListeUsers";
}
@RequestMapping("/ListeUsers")
public String ListeUser(ModelMap modelMap)
{
List <User> users = usersService.findAll();
modelMap.addAttribute("users", users);
return "ListeUsers";
}

@RequestMapping("/ListeGrp")
public String ListeGrp(ModelMap modelMap)
{
List <city> grps = cityService.findAll();
modelMap.addAttribute("citys", grps);
return "ListeGrp";
}

@RequestMapping("/ListeCountry")
public String ListeCountry(ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "3") int size)
{
	List<city> grps = cityService.findAll();
	modelMap.addAttribute("citys", grps);
Page<country> anims = countryService.getAllCountrysParPage(page, size);
modelMap.addAttribute("countrys", anims);
 modelMap.addAttribute("pages", new int[anims.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
return "ListeCountry";
}


@RequestMapping("/supprimerCountry")
public String supprimerAnimal(@RequestParam("id") Long id,
ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "3") int size)
{
	countryService.deleteCountryById(id);
Page<country> anims = countryService.getAllCountrysParPage(page, size);
modelMap.addAttribute("animals", anims);
modelMap.addAttribute("pages", new int[anims.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
modelMap.addAttribute("size", size);
return "ListeCountry";
}
@RequestMapping("/supprimerGroupe")
public String supprimerGroupe(@RequestParam("id") Long id,
 ModelMap modelMap)
{ 
	cityService.deleteGroupeById(id);
List<city> grps = cityService.findAll();
modelMap.addAttribute("groupes", grps);
return "ListeGrp";
}
@RequestMapping("/supprimerUser")
public String supprimerUser(@RequestParam("id") Long id,
 ModelMap modelMap)
{ 
usersService.deleteUserById(id);
List<User> roles = usersService.findAll();
modelMap.addAttribute("users", roles);
return "ListeUsers";
}
@RequestMapping("/modifierCountry")
public String modifierCountry(@RequestParam("id") Long id,ModelMap modelMap)
{
country a= countryService.getCountry(id);
List<city> grps = cityService.findAll();
grps.remove(a.getCity());
modelMap.addAttribute("citys", grps);
modelMap.addAttribute("country", a);
modelMap.addAttribute("mode", "edit");
return "formCountry";
}
@RequestMapping("/updateCountry")
public String updateCountry(@ModelAttribute("country") country country,
@RequestParam("date") String date,ModelMap modelMap) throws ParseException {
	//conversion de la date 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateAjout = dateformat.parse(String.valueOf(date));
	 country.setDateAjout(dateAjout);
	 
	 countryService.updateCountry(country);
	 List<country> anims = countryService.getAllCountry();
	 modelMap.addAttribute("countrys", anims);
	return "ListeCountry";
	}
@RequestMapping("/modifierGroupe")
public String editerGroupe(@RequestParam("id") Long id,ModelMap modelMap)
{
city g= cityService.getGroupe(id);
modelMap.addAttribute("citys", g);
modelMap.addAttribute("mode", "edit");
return "formGroupe";
}
@RequestMapping("/updateGroupe")
public String updateGroupe(@ModelAttribute("groupe") city city,ModelMap modelMap) throws ParseException {
	cityService.updateGroupe(city);
	 List<city> grps = cityService.findAll();
	 modelMap.addAttribute("citys", grps);
	return "ListeGrp";
	}


@RequestMapping("/modifierUser")
public String modifierUser(@RequestParam("id") Long id,ModelMap modelMap)
{
User u= usersService.getUser(id);
List<Role> role = roleService.findAll();
modelMap.addAttribute("roles", role);
modelMap.addAttribute("users", u);
modelMap.addAttribute("mode", "edit");
return "FormUser";
}
@RequestMapping("/updateUser")
public String updateUser(@ModelAttribute("user") User user,ModelMap modelMap) throws ParseException {
	usersService.updateUser(user);
	 List<User> roles = usersService.findAll();
	 modelMap.addAttribute("users", roles);
	return "ListeUsers";
	}


@RequestMapping("/search")
public String recherNom(@RequestParam("nom") String nom,
ModelMap modelMap)
{
	List<city> grps = cityService.findAll();
	modelMap.addAttribute("groupes", grps);
List<country> anims =countryService.findByNomCountry(nom);
modelMap.addAttribute("countrys",anims);
modelMap.addAttribute("mode", "SearchNomP");
return "ListeCountry";
}
@RequestMapping("/searchGrp")
public String recherGrp(@RequestParam("grp") Long grp,ModelMap modelMap)
{
city grps = new city();
System.out.println(grp);
grps.setIdCity(grp);
List<city> grps2 = cityService.findAll();
modelMap.addAttribute("citys", grps2);
List<country> anims = countryService.findByCity(grps);
modelMap.addAttribute("countrys",anims);
modelMap.addAttribute("mode", "Searchgrp");
return "ListeCountry";
}
}