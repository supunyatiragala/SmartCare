package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Appointment;
import com.smartcare.hospital.entity.Doctor;
import com.smartcare.hospital.entity.Patient;
import com.smartcare.hospital.repository.AppointmentRepository;
import com.smartcare.hospital.repository.DoctorRepository;
import com.smartcare.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public Appointment createAppointment(Appointment appointment) {
        Patient patient = patientRepository.findById(appointment.getPatient().getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Doctor doctor = doctorRepository.findById(appointment.getDoctor().getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
}