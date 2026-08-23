package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Appointment;
import com.smartcare.hospital.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // 1. Book Appointment
    public Appointment bookAppointment(Appointment appointment) {
        // Validation 01: Past Date Check
        if (appointment.getAppointmentDate() != null && appointment.getAppointmentDate().isBefore(LocalDate.now())) {
            throw new RuntimeException("Appointment date cannot be in the past!");
        }

        // Validation 02: Time Slot Clash Check
        boolean isBooked = appointmentRepository.existsByDoctorDoctorIdAndAppointmentDateAndAppointmentTimeAndAppointmentStatusNot(
                appointment.getDoctor().getDoctorId(),
                appointment.getAppointmentDate(),
                appointment.getAppointmentTime(),
                "Cancelled"
        );

        if (isBooked) {
            throw new RuntimeException("Doctor is already booked for this time slot!");
        }

        if (appointment.getAppointmentStatus() == null) {
            appointment.setAppointmentStatus("Occupied");
        }

        return appointmentRepository.save(appointment);
    }

    // View All Appointments
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // View Appointment by ID
    public Appointment getAppointmentById(String id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with ID: " + id));
    }

    // 2. Update Appointment Details
    public Appointment updateAppointment(String id, Appointment details) {
        Appointment existing = getAppointmentById(id);

        if (details.getAppointmentDate() != null && details.getAppointmentDate().isBefore(LocalDate.now())) {
            throw new RuntimeException("Appointment date cannot be in the past!");
        }

        existing.setAppointmentDate(details.getAppointmentDate());
        existing.setAppointmentTime(details.getAppointmentTime());
        existing.setConsultationRoom(details.getConsultationRoom());
        if (details.getAppointmentStatus() != null) {
            existing.setAppointmentStatus(details.getAppointmentStatus());
        }

        return appointmentRepository.save(existing);
    }

    // 3. Cancel Appointment
    public Appointment cancelAppointment(String id) {
        Appointment existing = getAppointmentById(id);
        existing.setAppointmentStatus("Cancelled");
        return appointmentRepository.save(existing);
    }

    // 4. View Doctor Schedule
    public List<Appointment> getDoctorSchedule(String doctorId) {
        return appointmentRepository.findByDoctorDoctorId(doctorId);
    }
}