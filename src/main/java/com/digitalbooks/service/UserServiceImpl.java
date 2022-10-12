package com.digitalbooks.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitalbooks.dto.UserDto;
import com.digitalbooks.entity.User;
import com.digitalbooks.exception.DigitalbooksNotFoundException;
import com.digitalbooks.repository.UserDao;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User createUser(UserDto userDto) {
		User user = new User();
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		user.setType(userDto.getType());
		user.setEmail(userDto.getEmail());
		return userDao.save(user);
	}

	@Override
	public User loginUser(User user) {
		User result = userDao.findByNameAndPassword(user.getName(), user.getPassword()).orElse(null);
		if (result == null) {
			throw new DigitalbooksNotFoundException(
					"User name: " + user.getName() + " doesn't exist / Invalid Credentials");
		} else {
			return user;
		}
	}

	@Override
	public User getUserById(Long userId) {
		return userDao.findById(userId).get();
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	public User getUserByName(String userName) {
		return userDao.findByName(userName).get();
	}

	@Override
	public User updateAdminPassword(Long adminId, String password) {
		User result = userDao.findById(adminId).orElse(null);
		if (result == null) {
			throw new DigitalbooksNotFoundException("Admin Id: " + adminId + " doesn't exist");
		} else if (!result.getType().equalsIgnoreCase("ADMIN")) {
			throw new DigitalbooksNotFoundException("This is not an admin Account");
		}
		result.setPassword(password);
		return userDao.save(result);
	}

	@Override
	public User updateUserPassword(Long userId, String password) {
		User result = userDao.findById(userId).orElse(null);
		if (result == null) {
			throw new DigitalbooksNotFoundException("User Id: " + userId + " doesn't exist");
		}
		result.setPassword(password);
		return userDao.save(result);
	}

	@Override
	public User updateUserName(Long userId, String name) {
		User result = userDao.findById(userId).orElse(null);
		if (result == null) {
			throw new DigitalbooksNotFoundException("user Id: " + userId + " doesn't exist");
		}
		result.setName(name);
		return userDao.save(result);
	}

}
