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
        Patient patient = patientRepository.findById(admission.getPatient().getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Room room = roomRepository.findById(admission.getRoom().getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        if (!room.getAvailability()) {
            throw new RuntimeException("Room is already occupied!");
        }

        room.setAvailability(false);
        roomRepository.save(room);

        admission.setPatient(patient);
        admission.setRoom(room);
        if (admission.getAdmissionDate() == null) {
            admission.setAdmissionDate(LocalDate.now());
        }
        if (admission.getStatus() == null) {
            admission.setStatus("Admitted");
        }

        return admissionRepository.save(admission);
    }

    public List<Admission> getAllAdmissions() {
        return admissionRepository.findAll();
    }
}