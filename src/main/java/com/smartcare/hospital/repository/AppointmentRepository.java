package com.smartcare.hospital.repository;

import com.smartcare.hospital.entity.Appointment;
import com.smartcare.hospital.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, String> {

    boolean existsByDoctorAndAppointmentDateAndAppointmentTime(
            Doctor doctor, LocalDate appointmentDate, LocalTime appointmentTime);

    boolean existsByConsultationRoomAndAppointmentDateAndAppointmentTime(
            String consultationRoom, LocalDate appointmentDate, LocalTime appointmentTime);
}