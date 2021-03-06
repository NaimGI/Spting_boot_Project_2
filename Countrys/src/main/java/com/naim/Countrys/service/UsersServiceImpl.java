package com.naim.Countrys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naim.Countrys.entities.User;
import com.naim.Countrys.repos.UserRepository;
@Service
public class UsersServiceImpl implements UsersService{

	 @Autowired
	    private UserRepository userRepository;

	    @Override
	    public List <User> findAll() {
	        return userRepository.findAll();
	    }

		@Override
		public User saveUser(User u) {
			return userRepository.save(u);
		}

		@Override
		public User updateUser(User u) {
			return userRepository.save(u);
		}

		@Override
		public void deleteUser(User u) {
			userRepository.delete(u);
		}

		@Override
		public void deleteUserById(Long idUser) {
			userRepository.deleteById(idUser);
		}

		@Override
		public User getUser(Long idUser) {
			return userRepository.findById(idUser).get();
		}

}
