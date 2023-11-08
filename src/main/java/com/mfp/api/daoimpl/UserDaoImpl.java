package com.mfp.api.daoimpl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
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
		Session session = sf.getCurrentSession();
		boolean status;
		
		try {
			session.save(user);
			status = true;
		} catch (Exception e) {
			LOG.error(e.getMessage());
			status  = false;
		}
	
		return status;
		
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
	public String deleteUser(String userName) {
		Session session = sf.getCurrentSession();
		try {
			
			 CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		     CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		     Root<User> root = criteriaQuery.from(User.class);

		     criteriaQuery.select(root);
		     criteriaQuery.where(criteriaBuilder.equal(root.get("username"), userName));

		     List<User> users = session.createQuery(criteriaQuery).getResultList();

		        if (users.size() == 1) {
		        	session.delete(users.get(0));
		            return "success";
		        } else {
		           return "failed";
		        }	        
	    } catch (Exception e) {
	        LOG.error(e);
	        return "failed";
	    }
	}

	@Override
	public User getUserById(String id) {
		Session session = sf.getCurrentSession();
		User user;
		
		try {
			
			user = session.get(User.class, id);
		
		}catch (Exception e) {
			LOG.error(e.getMessage());
			user = null;
		}
		return user;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<User> getAllUsers() {
		List list;
		Session currentSession = sf.getCurrentSession();
		
		try {
			Criteria criteria = currentSession.createCriteria(User.class);
			list = criteria.list();
		}catch (Exception e) {
			LOG.error(e);
			list = null;
		}
		return list;
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
		Role check;
		try{
			Session session = sf.getCurrentSession();
			check = this.getRoleById(role.getId());
			if(check != null) {
				check = null;
			
			}else {
				session.save(role);
				return role;
			}
		}
		catch (Exception e) {
			LOG.info(e.getMessage());
			check = null;
		}
		return check;
	}

	@Override
	public Role getRoleById(int roleId) {
		
		
		try {
			Session session= sf.getCurrentSession();
			return  session.get(Role.class, roleId);
			
		}catch(Exception e) {
			LOG.error(e);
			 return null;
		}
	}

	

	

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Optional<User> findByUserName(String userName) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}


	
}
