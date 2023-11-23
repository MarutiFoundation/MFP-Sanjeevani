package com.mfp.api.controller;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;import java.sql.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mfp.api.entity.Appointment;
import com.mfp.api.exception.ResourceNotFoundException;
import com.mfp.api.exception.SomethingWentWrongException;
import com.mfp.api.service.AppointmentService;
import com.mfp.api.serviceimpl.AppointmentServiceImp;

@RestController
@RequestMapping(value = "/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService service;

	private static Logger LOG = LogManager.getLogger(AppointmentController.class);

	@PostMapping(value = "/add-appointment")
	public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment) {

		Appointment addedAppointment = service.addAppointment(appointment);
		
		if (addedAppointment != null) {
			LOG.info("Appointment Added !");
			return new ResponseEntity<>(addedAppointment, HttpStatus.OK);
		} else {
			throw new SomethingWentWrongException("Something Went Wrong While Adding Appointment !");
		}
		}
		
	

	@PutMapping(value = "/update-appointment")
	public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment) {
		return null;
	}

	@GetMapping(value = "/get-appointment-by-id/{id}")
	public ResponseEntity<Appointment> getAppointmentById(@PathVariable String id) {
		return null;
	}

	@GetMapping(value = "/get-appointment-by-ids/{ids}")
	public ResponseEntity<List<Appointment>> getAppointmentsByPatientsIds(@PathVariable List<String> ids) {
		return null;
	}

	@GetMapping(value = "/get-appointment-by-drid-apointmentdate/{drid}/{date}")
	public ResponseEntity<List<Appointment>> getAppointmentsByDoctorIdAndAppointmentDate(@PathVariable String drid,
			@PathVariable Date date) {
		return null;
	}

	@GetMapping(value = "/get-appointment-by-drid-and-apointmentdate-and-time")
	public ResponseEntity<List<Appointment>> getAppointmentsByDoctorIdAndAppointmentDate(@RequestParam String doctorId,
			@RequestParam Date appointmentDate, @RequestParam String appointmentTime) {
		return null;
	}

	@GetMapping(value = "/get-appointment-by-apointmentdate")
	public ResponseEntity<List<Appointment>> getAppointmentsByDate(@RequestParam Date appointmentDate) {
		List<Appointment> list = this.service.getAppointmentsByDate(appointmentDate);
		if (list != null) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		} else {
			throw new SomethingWentWrongException("NO APPOINTMENTS ARE THERE...!");
		}
	}

	@GetMapping(value = "/get-count-by-appointment-date")
	public ResponseEntity<Long> getCountByAppointmentDate(@RequestParam Date date) {
		return null;
	}

	@GetMapping(value = "/get-appointment-by-billingdate")
	public ResponseEntity<List<Appointment>> getAppointmentsByBillingDate(@RequestParam Date billingDate) {
		List<Appointment> appointmentsByBillingDate = service.getAppointmentsByBillingDate(billingDate);
		
		if(appointmentsByBillingDate!=null) {
			return new ResponseEntity<>(appointmentsByBillingDate, HttpStatus.FOUND);
		} 
		else {
			throw new ResourceNotFoundException("THERE ARE NO OPPOINTMENTS");
			
			
		}
	}	
		

	@GetMapping(value = "/get-count-of-appointments")
	public ResponseEntity<Long> getAppointmentsTotalCount() {
		return null;
	}

	@GetMapping(value = "/get-count-by-appointmenttaken-date")
	public ResponseEntity<Long> getCountByAppointmentTakenDate(@RequestParam Date appointmentTakenDate) {
		return null;
	}

	@GetMapping(value = "/get-count-by-treatmentstatus-and billingdate")
	public ResponseEntity<Long> getCountByTreatmentStatusAndBillingDate(@RequestParam String treatmentStatus,
			@RequestParam Date billingDate) {
		return null;
	}

	@GetMapping(value = "/get-all-appointments")
	public ResponseEntity<List<Appointment>> getAllAppointments() {
		List<Appointment> allAppointments = this.service.getAllAppointments();
		
		if(allAppointments == null) {
			throw new ResourceNotFoundException("NO APPOINTMENTS ARE THERE...!");
		}else {
			return new ResponseEntity<>(allAppointments, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/get-top5-appointments")
	public ResponseEntity<List<Appointment>> getTop5AppointmentsByDate(@RequestParam Date date) {
		return null;
	}
}
