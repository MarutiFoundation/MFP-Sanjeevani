package com.mfp.api.daoimpl;

import java.sql.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.mfp.api.dao.UserDao;
import com.mfp.api.entity.Otp;
import com.mfp.api.entity.Role;
import com.mfp.api.entity.User;
import com.mfp.api.security.CustomUserDetail;

@Repository
public class UserDaoImpl implements UserDao {
	private static Logger LOG = LogManager.getLogger(UserDaoImpl.class);

	@Autowired
	private SessionFactory sf;

	@Autowired
	public PasswordEncoder passwordEncoder;
	
	@Override
	public boolean addUser(User user) {
		return false;
	}

	@Override
	public User loginUser(User user) {
		Session session = sf.getCurrentSession();
		User usr = null;
		try {
			usr = session.get(User.class, user.getUsername());
			boolean matches = passwordEncoder.matches(user.getPassword(), usr.getPassword());
			if (matches) {
				return usr;
			} else {
				usr = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usr;

	}

	@Override
	public CustomUserDetail loadUserByUserId(String userId) {
		Session session = sf.getCurrentSession();
		CustomUserDetail user = new CustomUserDetail();
		User usr = null;
		try {
			usr = session.get(User.class, userId);
			if (usr != null) {
				user.setUserid(usr.getUsername());
				user.setPassword(usr.getPassword());
				user.setRoles(usr.getRoles());
			}
			System.out.println("dao ..." + user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;

	}

	@Override
	public boolean deleteUserById(String id) {
		Session session = sf.getCurrentSession();
		
		User usr = null;
		try {
			usr = session.get(User.class, id);
					
			if (usr != null) {
				session.delete(usr);
				return true;
			}
			Log.info(usr);
			return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			Log.info(usr);
		}
		
		return false;
	}

	@Override
	public User getUserById(String id) {
		return null;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<User> getAllUsers() {
		return null;
	}

	@Override
	public User updateUser(User user) {
		return null;
	}

	@Override
	public Long getUsersTotalCounts() {
		return null;
	}

	@Override
	public Long getUsersTotalCounts(String type) {
		return null;
	}

	@Override
	public Long getUserCountByDateAndType(Date registeredDate, String type) {
		return null;
	}

	@Override
	public List<User> getUserByFirstName(String firstName) {
		return null;
	}

	@Override
	public boolean saveOtp(Otp otp) {
		return false;
	}

	@Override
	public Otp getOtpByUser(String userId) {
		return null;
	}

	@Override
	public Role addRole(Role role) {
		try {
			Session session = sf.getCurrentSession();
			session.save(role);
		} catch (PersistenceException e) {
			return null;
		}
		catch (Exception e) {
			LOG.info(e.getMessage());
		}
		return role;
	}

	@Override
	public Role getRoleById(int roleId) {
		return null;
	}

}
