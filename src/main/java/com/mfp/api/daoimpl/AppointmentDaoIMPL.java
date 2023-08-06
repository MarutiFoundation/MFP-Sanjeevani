package com.mfp.api.daoimpl;

import java.sql.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mfp.api.dao.AppointmentDao;
import com.mfp.api.entity.Appointment;

@Repository
public class AppointmentDaoIMPL implements AppointmentDao {

	@Autowired
	private SessionFactory sf;

	private static Logger LOG = LogManager.getLogger(AppointmentDao.class);

	@Override
	public Appointment addAppointment(Appointment appointment) {
		return null;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> getAllAppointments() {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> getTop5AppointmentsByDate(Date date) {
		return null;
	}

}
