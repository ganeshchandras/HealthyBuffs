package com.surgeon.eye.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.surgeon.eye.model.Doctor;
import com.surgeon.eye.model.DoctorAppointmentDetails;
import com.surgeon.eye.services.impl.DoctorServiceImpl;
import com.surgeon.eye.model.DoctorBySpeciality;
@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	DoctorServiceImpl doctorServiceImpl;
	
	@RequestMapping(value="/bookappointment", method=RequestMethod.POST)
	public Doctor bookAppointment(@RequestBody DoctorAppointmentDetails appointmentDetails,
			@RequestParam("doctorId") String doctorId) {
		Doctor doctor =doctorServiceImpl.saveAppointment(appointmentDetails, doctorId);
			return doctor;
		}
	
	@RequestMapping(value="/details", method=RequestMethod.GET)
	public List <DoctorBySpeciality> getDoctors(@RequestParam("specialisation") String speciality) {
		List<DoctorBySpeciality> doctorList =doctorServiceImpl.getDoctors(speciality);
			return doctorList;
		}
	@RequestMapping(value="/schedule", method=RequestMethod.GET)
	public List <DoctorAppointmentDetails> getAppointments(@RequestParam("doctorId") String doctorId) {
		List<DoctorAppointmentDetails> doctorList =doctorServiceImpl.viewAppointments(doctorId);
			return doctorList;
		}
	
}
