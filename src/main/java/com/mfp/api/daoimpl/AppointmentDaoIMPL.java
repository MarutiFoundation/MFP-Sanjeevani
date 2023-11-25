package com.mfp.api.daoimpl;

import java.sql.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mfp.api.dao.AppointmentDao;
import com.mfp.api.entity.Appointment;

@Repository
public class AppointmentDaoIMPL implements AppointmentDao {

	@Autowired
	private SessionFactory sf;

	private static final Logger LOG = LogManager.getLogger(AppointmentDao.class);

	@Override
	public Appointment addAppointment(Appointment appointment) {
		Session session = sf.getCurrentSession();
		try {
			 session.save(appointment);	
			 return appointment;
		}catch (Exception e) {
			LOG.error(e);
			return null;
		}
	   
	}
	      

		

	@Override
	public Appointment updateAppointment(Appointment appointment) {
		return null;
	}

	@Override
	public Appointment getAppointmentById(String patientId) {
		
		Session session = sf.getCurrentSession();
		Appointment appointment = null;
		try {
			appointment = session.get(Appointment.class, patientId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return appointment;
	}

		
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> getAppointmentsByPatientsIds(List<String> patientsId) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> getAppointmentsByDoctorIdAndAppointmentDate(String doctorId, Date appointmentDate) {
		List<Appointment>appointments=null;
		Session session=sf.getCurrentSession();
		
		try {
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Appointment> criteriaQuery = criteriaBuilder.createQuery(Appointment.class);
			Root<Appointment> root = criteriaQuery.from(Appointment.class);
			
			Predicate doctorIdPredicate = criteriaBuilder.equal(root.get("doctorid"), doctorId);
	        Predicate datePredicate = criteriaBuilder.equal(root.get("appointmentdate"), appointmentDate);
	            
	        criteriaQuery.where(doctorIdPredicate, datePredicate);
	        return session.createQuery(criteriaQuery).getResultList();
	        
		} catch (Exception e) {
			LOG.error(e);
			return appointments;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> getAppointmentsByDoctorIdAndAppointmentDate(String doctorId, Date appointmentDate,
			String appointmentTime) {
		List<Appointment> resultSet=null;
		
		Session session =sf.getCurrentSession();
		try {
			
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Appointment> criteriaQuery = criteriaBuilder.createQuery(Appointment.class);
			Root<Appointment> root = criteriaQuery.from(Appointment.class);
			
			Predicate doctorIdPredicate = criteriaBuilder.equal(root.get("doctorid"), doctorId);
	        Predicate datePredicate = criteriaBuilder.equal(root.get("appointmentdate"), appointmentDate);
	        Predicate timePredicate = criteriaBuilder.equal(root.get("appointmenttime"), appointmentTime);

	        criteriaQuery.where(doctorIdPredicate, datePredicate, timePredicate);

	        return session.createQuery(criteriaQuery).getResultList();
	    
	
			
		} catch (Exception e) {
			LOG.error(e);
			return resultSet;
			
		}
	}

	@Override
	public List<Appointment> getAppointmentsByDate(Date date) {
		List<Appointment> appointments = null;
		Session session = this.sf.getCurrentSession();
		try {
			
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Appointment> criteriaQuery = criteriaBuilder.createQuery(Appointment.class);
			Root<Appointment> root = criteriaQuery.from(Appointment.class);
			
			criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("appointmentdate"), date));
			
			appointments = session.createQuery(criteriaQuery).getResultList();
			return appointments;

			
		} catch (Exception e) {
			LOG.error(e);
			return appointments;	
		}
	}

	@Override
	public Long getCountByAppointmentDate(Date appointmentDate) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> getAppointmentsByBillingDate(Date billingDate) {
		List<Appointment> resultList=null;
		
		Session session= sf.getCurrentSession();
		
		try {
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Appointment> createQuery = criteriaBuilder.createQuery(Appointment.class);
			Root<Appointment> root = createQuery.from(Appointment.class);
			
			createQuery.where(criteriaBuilder.equal(root.get("billingDate"),billingDate ));
			resultList = session.createQuery(createQuery).getResultList();
			
			return resultList;
			
		} catch (Exception e) {
			LOG.error(e);
			return  resultList;
			
		}
		

		
	}

	@Override
	public Long getAppointmentsTotalCount() {
		return null;
	}

	@Override
	public Long getCountByAppointmentTakenDate(Date appointmentTakenDate) {
		return null;
	}

	@Override
	public Long getCountByTreatmentStatusAndBillingDate(String treatmentStatus, Date billingDate) {
		return null;
	}

	@Override
	public List<Appointment> getAllAppointments() {
		List<Appointment> appointments = null;
		Session session = this.sf.getCurrentSession();
		try {
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Appointment> criteriaQuery = criteriaBuilder.createQuery(Appointment.class);
			Root<Appointment> root = criteriaQuery.from(Appointment.class);
			criteriaQuery.select(root);
			appointments = session.createQuery(criteriaQuery).getResultList();
			
			return appointments;
			
		} catch (Exception e) {
			LOG.error(e);
			return appointments;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> getTop5AppointmentsByDate(Date date) {
		return null;
	}

}
