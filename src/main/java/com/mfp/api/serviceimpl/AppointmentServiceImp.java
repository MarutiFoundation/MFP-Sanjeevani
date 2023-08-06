package com.mfp.api.serviceimpl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfp.api.dao.AppointmentDao;
import com.mfp.api.entity.Appointment;
import com.mfp.api.service.AppointmentService;

@Service()
public class AppointmentServiceImp implements AppointmentService {

	@Autowired
	private AppointmentDao appointmentDao;

	@Override
	public Appointment addAppointment(Appointment appointment) {
		return null;
	}

	@Override
	public Appointment updateAppointment(Appointment appointment) {
		return null;
	}

	@Override
	public Appointment getAppointmentById(String appointmentId) {
		return null;
	}

	@Override
	public List<Appointment> getAppointmentsByPatientsIds(List<String> patientsId) {
		return null;
	}

	@Override
	public List<Appointment> getAppointmentsByDoctorIdAndAppointmentDate(String doctorId, Date appointmentDate) {
		return null;
	}

	@Override
	public List<Appointment> getAppointmentsByDoctorIdAndAppointmentDate(String doctorId, Date appointmentDate,
			String appointmentTime) {
		return null;
	}

	@Override
	public List<Appointment> getAppointmentsByDate(Date date) {
		return null;
	}

	@Override
	public Long getCountByAppointmentDate(Date appointmentDate) {
		return appointmentDao.getCountByAppointmentDate(appointmentDate);
	}

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
		return appointmentDao.getCountByAppointmentTakenDate(appointmentTakenDate);
	}

	@Override
	public Long getCountByTreatmentStatusAndBillingDate(String treatmentStatus, Date billingDate) {
		return null;
	}

	@Override
	public List<Appointment> getAllAppointments() {
		return null;
	}

	@Override
	public List<Appointment> getTop5AppointmentsByDate(Date date) {
		return null;
	}

}
