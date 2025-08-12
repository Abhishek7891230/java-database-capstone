package com.project.back_end.controllers;

import com.project.back_end.models.Doctor;
import com.project.back_end.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorService.createDoctor(doctor);
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
        return doctorService.updateDoctor(id, doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
    }

    // ✅ New endpoint to retrieve doctor availability
    @GetMapping("/{id}/availability")
    public ResponseEntity<Map<String, String>> getDoctorAvailability(
            @PathVariable Long id,
            @RequestParam String role,
            @RequestParam String date,
            @RequestParam String token) {

        Map<String, String> response = new HashMap<>();

        // Example logic: this should be replaced with actual service logic
        Doctor doctor = doctorService.getDoctorById(id);
        if (doctor == null) {
            response.put("status", "error");
            response.put("message", "Doctor not found");
            return ResponseEntity.badRequest().body(response);
        }

        // Here, you'd check role, date, token, etc.
        response.put("status", "success");
        response.put("message", "Availability retrieved successfully");
        response.put("doctorId", String.valueOf(id));
        response.put("date", date);
        response.put("availableTimes", doctor.getAvailableTimes() != null ? doctor.getAvailableTimes().toString() : "No times available");

        return ResponseEntity.ok(response);
    }
}
