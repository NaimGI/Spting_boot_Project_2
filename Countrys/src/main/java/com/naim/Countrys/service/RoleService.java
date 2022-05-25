package com.naim.Countrys.service;

import java.util.List;

import com.naim.Countrys.entities.Role;

public interface RoleService {
	 List <Role> findAll();
	    
	 Role saveRole(Role r);
	 Role updateRole(Role r);
	     Role getRole (Long idRole);
}
