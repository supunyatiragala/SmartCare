package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Admission;
import com.smartcare.hospital.entity.Room;
import com.smartcare.hospital.repository.AdmissionRepository;
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
    private RoomRepository roomRepository;

    // 1. Admit Patient & Allocate Room
    public Admission admitPatient(Admission admission) {
        Room room = roomRepository.findById(admission.getRoom().getId())
                .orElseThrow(() -> new RuntimeException("Room not found!"));

        if (!room.getIsAvailable()) {
            throw new RuntimeException("Selected room is already occupied!");
        }

        room.setIsAvailable(false);
        roomRepository.save(room);

        admission.setBedNumber(room.getBedNumber());
        if (admission.getAdmissionDate() == null) {
            admission.setAdmissionDate(LocalDate.now());
        }
        admission.setAdmissionStatus("Admitted");

        return admissionRepository.save(admission);
    }

    // 2. Discharge Patient
    public Admission dischargePatient(String admissionId) {
        Admission admission = admissionRepository.findById(admissionId)
                .orElseThrow(() -> new RuntimeException("Admission not found!"));

        admission.setAdmissionStatus("Discharged");
        admission.setDischargeDate(LocalDate.now());

        Room room = admission.getRoom();
        room.setIsAvailable(true);
        roomRepository.save(room);

        return admissionRepository.save(admission);
    }

    public List<Admission> getAllAdmissions() {
        return admissionRepository.findAll();
    }

    public Admission getAdmissionById(String id) {
        return admissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admission not found with id: " + id));
    }
}