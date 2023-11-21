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
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> getAppointmentsByPatientsIds(List<String> patientsId) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> getAppointmentsByDoctorIdAndAppointmentDate(String doctorId, Date appointmentDate) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> getAppointmentsByDoctorIdAndAppointmentDate(String doctorId, Date appointmentDate,
			String appointmentTime) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> getAppointmentsByDate(Date date) {
		return null;
	}

	@Override
	public Long getCountByAppointmentDate(Date appointmentDate) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> getAppointmentsByBillingDate(Date billingDate) {
		return null;
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
			
			appointments.stream().forEach(MAMTA -> System.out.println(MAMTA));
			
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
