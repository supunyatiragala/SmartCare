package com.smartcare.hospital.repository;

import com.smartcare.hospital.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, String> {

    List<Appointment> findByDoctorDoctorId(String doctorId);

    boolean existsByDoctorDoctorIdAndAppointmentDateAndAppointmentTimeAndAppointmentStatusNot(
            String doctorId, LocalDate appointmentDate, LocalTime appointmentTime, String status);
}