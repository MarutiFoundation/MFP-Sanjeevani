package com.mfp.api.serviceimpl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mfp.api.dao.UserDao;
import com.mfp.api.entity.Role;
import com.mfp.api.entity.User;
import com.mfp.api.exception.SomethingWentWrongException;
import com.mfp.api.security.CustomUserDetail;
import com.mfp.api.service.UserService;
import com.mfp.api.validation.ValidateRole;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserDao dao;
	
	@Autowired
	private ValidateRole validateRole;

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
		
		boolean isValid = this.validateRole.validateRole(role);
		
		if(isValid) {
			 Role savedRole = this.dao.addRole(role);
			 if(savedRole == null) {
				 throw new SomethingWentWrongException("Given Role Already Exist..." + "\n" + "Role ID : " + role.getId() + "\n" + "Role Name : " + role.getName());
					
			 }else {
				 return savedRole;
			 }
		}else {
			throw new SomethingWentWrongException("Please Enter Valid Role Name Or Id.." + "\n" + "role id : " + role.getId() + "\n" 
															+ "role name : " + role.getName() + "\n"
															+	"Default Message : Role_Name shold be starts with 'ROLE_ ' also should be starts with charachers only ");
		}
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
