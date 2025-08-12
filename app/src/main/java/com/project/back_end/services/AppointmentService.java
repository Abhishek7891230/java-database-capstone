package com.project.back_end.services;

import com.project.back_end.models.Appointment;
import com.project.back_end.repositories.AppointmentRepository;
import com.project.back_end.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final TokenService tokenService;

    public AppointmentService(AppointmentRepository appointmentRepository,
                               PatientRepository patientRepository,
                               TokenService tokenService) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.tokenService = tokenService;
    }

    @Transactional
    public Appointment bookAppointment(Appointment appointment) {
        // Here you can add logic to check availability, validate patient, etc.
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    @Transactional
    public Appointment updateAppointment(Long id, Appointment updatedAppointment) {
        return appointmentRepository.findById(id)
                .map(existingAppointment -> {
                    existingAppointment.setDate(updatedAppointment.getDate());
                    existingAppointment.setTime(updatedAppointment.getTime());
                    existingAppointment.setDoctor(updatedAppointment.getDoctor());
                    existingAppointment.setPatient(updatedAppointment.getPatient());
                    return appointmentRepository.save(existingAppointment);
                }).orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    @Transactional
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    // ✅ New method to retrieve appointments by doctor and date
    public List<Appointment> getAppointmentsByDoctorAndDate(Long doctorId, LocalDate date) {
        return appointmentRepository.findByDoctorIdAndDate(doctorId, date);
    }
}
