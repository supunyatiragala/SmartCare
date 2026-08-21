package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Admission;
import com.smartcare.hospital.entity.Patient;
import com.smartcare.hospital.entity.Room;
import com.smartcare.hospital.repository.AdmissionRepository;
import com.smartcare.hospital.repository.PatientRepository;
import com.smartcare.hospital.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AdmissionService {

    @Autowired
    private AdmissionRepository admissionRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private RoomRepository roomRepository;

    public Admission admitPatient(Admission admission) {
        String patientId = admission.getPatient().getPersonId();
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + patientId));

        String roomId = admission.getRoom().getRoomId();
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found with ID: " + roomId));

        // Room availability string එකක් බැවින් equalIgnoreCase පරීක්ෂා කිරීම
        if ("Not Available".equalsIgnoreCase(room.getAvailability())) {
            throw new RuntimeException("Room " + roomId + " is not available");
        }

        admission.setPatient(patient);
        admission.setRoom(room);

        if (admission.getAdmissionDate() == null) {
            admission.setAdmissionDate(LocalDate.now());
        }

        if (admission.getAdmissionStatus() == null) {
            admission.setAdmissionStatus("Admitted");
        }

        return admissionRepository.save(admission);
    }

    public List<Admission> getAllAdmissions() {
        return admissionRepository.findAll();
    }

    public Admission getAdmissionById(String id) {
        return admissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admission not found with ID: " + id));
    }
}