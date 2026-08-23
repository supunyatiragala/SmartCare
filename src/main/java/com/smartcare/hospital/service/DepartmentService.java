package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Department;
import com.smartcare.hospital.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // 1. Add Department
    public Department addDepartment(Department department) {
        if (department.getDepartmentName() == null || department.getDepartmentName().trim().isEmpty()) {
            throw new RuntimeException("Department Name cannot be empty!");
        }
        return departmentRepository.save(department);
    }

    // 2. View All Departments
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // View Department by ID
    public Department getDepartmentById(String id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with ID: " + id));
    }

    // 3. Update Department Details
    public Department updateDepartment(String id, Department departmentDetails) {
        Department existing = getDepartmentById(id);

        if (departmentDetails.getDepartmentName() == null || departmentDetails.getDepartmentName().trim().isEmpty()) {
            throw new RuntimeException("Department Name cannot be empty!");
        }

        existing.setDepartmentName(departmentDetails.getDepartmentName());
        existing.setLocation(departmentDetails.getLocation());
        existing.setHeadDoctor(departmentDetails.getHeadDoctor());

        return departmentRepository.save(existing);
    }

    // 4. Delete Department
    public void deleteDepartment(String id) {
        Department existing = getDepartmentById(id);
        departmentRepository.delete(existing);
    }
}