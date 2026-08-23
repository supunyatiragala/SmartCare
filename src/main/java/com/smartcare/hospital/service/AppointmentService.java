package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Appointment;
import com.smartcare.hospital.entity.Doctor;
import com.smartcare.hospital.entity.Patient;
import com.smartcare.hospital.repository.AppointmentRepository;
import com.smartcare.hospital.repository.DoctorRepository;
import com.smartcare.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

        if (appointment.getAppointmentDate() != null &&
                appointment.getAppointmentDate().isBefore(LocalDate.now())) {
            throw new RuntimeException("Appointment date cannot be in the past!");
        }

        Patient patient = patientRepository.findById(appointment.getPatient().getPersonId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Doctor doctor = doctorRepository.findById(appointment.getDoctor().getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        boolean doctorBusy = appointmentRepository.existsByDoctorAndAppointmentDateAndAppointmentTime(
                doctor, appointment.getAppointmentDate(), appointment.getAppointmentTime());
        if (doctorBusy) {
            throw new RuntimeException("Doctor is already booked for this time slot!");
        }

        boolean roomBusy = appointmentRepository.existsByConsultationRoomAndAppointmentDateAndAppointmentTime(
                appointment.getConsultationRoom(), appointment.getAppointmentDate(), appointment.getAppointmentTime());
        if (roomBusy) {
            throw new RuntimeException("Consultation room is already allocated for this time slot!");
        }

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
}