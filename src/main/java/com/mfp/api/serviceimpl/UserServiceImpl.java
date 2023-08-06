package com.mfp.api.serviceimpl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mfp.api.dao.UserDao;
import com.mfp.api.entity.Role;
import com.mfp.api.entity.User;
import com.mfp.api.security.CustomUserDetail;
import com.mfp.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserDao dao;

	@Override
	public boolean addUser(User user) {
		return false;
	}

	@Override
	public User loginUser(User user) {

		return dao.loginUser(user);
	}

	@Override
	public CustomUserDetail loadUserByUserId(String userId) {
		return dao.loadUserByUserId(userId);
	}

	@Override
	public boolean deleteUserById(String id) {
		return dao.deleteUserById(id);
	}

	@Override
	public User getUserById(String id) {
		return dao.getUserById(id);
	}

	@Override
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}

	@Override
	public User updateUser(User user) {
		String password = passwordEncoder.encode(user.getPassword());
		user.setPassword(password);
		return dao.updateUser(user);
	}

	@Override
	public Long getUsersTotalCounts() {
		return dao.getUsersTotalCounts();
	}

	@Override
	public Long getUsersTotalCounts(String type) {
		return dao.getUsersTotalCounts(type);
	}

	@Override
	public Long getUserCountByDateAndType(Date registereddate, String type) {
		return dao.getUserCountByDateAndType(registereddate, type);
	}

	@Override
	public List<User> getUserByFirstName(String firstName) {
		return dao.getUserByFirstName(firstName);
	}

	@Override
	public Role addRole(Role role) {
		return dao.addRole(role);
	}

	@Override
	public Role getRoleById(int roleId) {
		return dao.getRoleById(roleId);
	}

	@Override
	public String generateReport() {
		return null;
	}
}
