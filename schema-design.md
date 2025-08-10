## MySQL Database Design

### Table: patients
- patient_id: INT, Primary Key, AUTO_INCREMENT
- name: VARCHAR(100), NOT NULL
- email: VARCHAR(100), UNIQUE, NOT NULL
- phone: VARCHAR(20), UNIQUE
- date_of_birth: DATE, NOT NULL
- gender: ENUM('Male', 'Female', 'Other'), NOT NULL
- created_at: DATETIME, DEFAULT CURRENT_TIMESTAMP
- updated_at: DATETIME, DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
<!-- A patient can have multiple appointments. If a patient is deleted, we may choose to cascade delete their appointments. -->

---

### Table: doctors
- doctor_id: INT, Primary Key, AUTO_INCREMENT
- name: VARCHAR(100), NOT NULL
- email: VARCHAR(100), UNIQUE, NOT NULL
- phone: VARCHAR(20), UNIQUE
- specialization: VARCHAR(100), NOT NULL
- created_at: DATETIME, DEFAULT CURRENT_TIMESTAMP
- updated_at: DATETIME, DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
<!-- Each doctor can have multiple appointments. We should prevent overlapping appointments via application logic. -->

---

### Table: appointments
- appointment_id: INT, Primary Key, AUTO_INCREMENT
- doctor_id: INT, Foreign Key → doctors(doctor_id), NOT NULL
- patient_id: INT, Foreign Key → patients(patient_id), NOT NULL
- appointment_time: DATETIME, NOT NULL
- duration_minutes: INT, NOT NULL
- status: ENUM('Scheduled', 'Completed', 'Cancelled'), DEFAULT 'Scheduled'
- created_at: DATETIME, DEFAULT CURRENT_TIMESTAMP
<!-- If doctor or patient is deleted, we can choose CASCADE or retain appointment history for reporting. -->

---

### Table: admin
- admin_id: INT, Primary Key, AUTO_INCREMENT
- name: VARCHAR(100), NOT NULL
- email: VARCHAR(100), UNIQUE, NOT NULL
- password_hash: VARCHAR(255), NOT NULL
- created_at: DATETIME, DEFAULT CURRENT_TIMESTAMP
<!-- Admins manage doctors, patients, and system settings. -->

---

### Table: clinic_locations (optional)
- location_id: INT, Primary Key, AUTO_INCREMENT
- name: VARCHAR(100), NOT NULL
- address: VARCHAR(255), NOT NULL
- phone: VARCHAR(20), UNIQUE
<!-- If clinics are in multiple locations, doctors and appointments can reference this table. -->

## MongoDB Collection Design

### Collection: prescriptions

```json
{
  "_id": "ObjectId('64fabc1234567890abcdef12')",
  "patientId": 101,
  "patientName": "John Smith",
  "appointmentId": 51,
  "medications": [
    {
      "name": "Paracetamol",
      "dosage": "500mg",
      "instructions": "Take 1 tablet every 6 hours after meals."
    },
    {
      "name": "Ibuprofen",
      "dosage": "200mg",
      "instructions": "Take 1 tablet every 8 hours if pain persists."
    }
  ],
  "doctorNotes": "Monitor temperature daily. Return if fever persists for more than 3 days.",
  "refillCount": 2,
  "issuedDate": "2025-08-10T10:30:00Z",
  "pharmacy": {
    "name": "City Health Pharmacy",
    "location": "123 Main Street, Springfield"
  },
  "tags": ["fever", "pain relief", "general care"]
}
```
