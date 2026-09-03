package com.smartcare.hospital.controller;

import com.smartcare.hospital.entity.Doctor;
import com.smartcare.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // 1. Add Doctor
    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctorService.addDoctor(doctor));
    }

    // View All Doctors
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    // 4. Search Doctors (Placed before /{id} to prevent routing conflict)
    @GetMapping("/search")
    public ResponseEntity<List<Doctor>> searchDoctors(@RequestParam("query") String query) {
        return ResponseEntity.ok(doctorService.searchDoctors(query));
    }

    // View Doctor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable String id) {
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }

    // 2. Update Doctor Details
    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable String id, @RequestBody Doctor doctorDetails) {
        return ResponseEntity.ok(doctorService.updateDoctor(id, doctorDetails));
    }

    // 3. Delete Doctor
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable String id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok("Doctor record deleted successfully!");
    }

    // 5. Assign Doctor to Department
    @PutMapping("/{doctorId}/assign-department/{departmentId}")
    public ResponseEntity<Doctor> assignDepartment(
            @PathVariable String doctorId,
            @PathVariable String departmentId) {
        return ResponseEntity.ok(doctorService.assignDepartment(doctorId, departmentId));
    }
}