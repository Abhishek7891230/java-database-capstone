# User Stories

## Patient User Stories

### 1. View Doctors Without Logging In
**Title:** As a patient, I want to view a list of doctors without logging in so that I can explore options before registering.

**Acceptance Criteria:**
1. The portal displays a searchable list of doctors.
2. The list includes doctor names, specializations, and availability.
3. The system does not require login for access to this list.

**Priority:** High  
**Story Points:** 3  
**Notes:** Consider limiting the information shown to protect privacy.

---

### 2. Sign Up to Book Appointments
**Title:** As a patient, I want to sign up using my email and password so that I can book appointments.

**Acceptance Criteria:**
1. Registration form accepts email, password, and name.
2. Email is verified before account activation.
3. Successful registration redirects to the booking page.

**Priority:** High  
**Story Points:** 5  
**Notes:** Include password complexity requirements.

---

### 3. Manage My Bookings
**Title:** As a patient, I want to log into the portal so that I can manage my bookings.

**Acceptance Criteria:**
1. I can view upcoming and past appointments.
2. I can reschedule or cancel future bookings.
3. Booking changes trigger email confirmation.

**Priority:** High  
**Story Points:** 5  
**Notes:** Limit cancellations to at least 24 hours before appointment.

---

### 4. Secure My Account
**Title:** As a patient, I want to log out of the portal so that I can secure my account.

**Acceptance Criteria:**
1. Logout button is accessible on all pages after login.
2. Session is terminated immediately.
3. User is redirected to the home page after logout.

**Priority:** Medium  
**Story Points:** 2  
**Notes:** Auto-logout after 15 minutes of inactivity.

---

### 5. Book Hour-Long Appointment
**Title:** As a patient, I want to log in and book an hour-long appointment so that I can consult with a doctor.

**Acceptance Criteria:**
1. Booking form shows available hour-long slots.
2. Booking confirmation email is sent to the patient.
3. Appointment is added to the doctor's schedule automatically.

**Priority:** High  
**Story Points:** 4  
**Notes:** System should prevent double-booking.

---

## Doctor User Stories

### 1. Manage Appointments
**Title:** As a doctor, I want to log into the portal so that I can manage my appointments.

**Acceptance Criteria:**
1. I can view upcoming and past appointments.
2. I can accept, decline, or reschedule appointments.
3. Changes trigger email notifications to patients.

**Priority:** High  
**Story Points:** 5  
**Notes:** Show patient details when viewing appointments.

---

### 2. Protect My Data
**Title:** As a doctor, I want to log out of the portal so that I can protect my data.

**Acceptance Criteria:**
1. Logout button is visible after login.
2. Session ends immediately after logout.
3. User is redirected to the login page.

**Priority:** Medium  
**Story Points:** 2  
**Notes:** Auto-logout after inactivity.

---

### 3. View Appointment Calendar
**Title:** As a doctor, I want to view my appointment calendar so that I can stay organized.

**Acceptance Criteria:**
1. Calendar displays appointments by day, week, and month.
2. Calendar syncs with booking updates in real-time.
3. Canceled appointments are shown with a strike-through.

**Priority:** High  
**Story Points:** 4  
**Notes:** Option to export to external calendar.

---

### 4. Mark Unavailability
**Title:** As a doctor, I want to mark my unavailability so that patients only see available slots.

**Acceptance Criteria:**
1. Doctor can select unavailable dates and times.
2. System prevents bookings during marked periods.
3. Patients see only available slots in their booking view.

**Priority:** High  
**Story Points:** 3  
**Notes:** Allow recurring unavailability (e.g., weekly meetings).

---

### 5. Update Profile Information
**Title:** As a doctor, I want to update my profile with specialization and contact info so that patients have up-to-date information.

**Acceptance Criteria:**
1. Editable profile fields for specialization, phone, and email.
2. Changes reflect instantly on patient views.
3. System validates data before saving.

**Priority:** Medium  
**Story Points:** 3  
**Notes:** Admin approval may be required for certain changes.

---

## Admin User Stories

### 1. Manage User Accounts
**Title:** As an admin, I want to manage user accounts so that I can control system access.

**Acceptance Criteria:**
1. Admin can activate, deactivate, or delete accounts.
2. System logs all admin actions for audit purposes.
3. Email notification sent to users on status change.

**Priority:** High  
**Story Points:** 5  
**Notes:** Ensure role-based access control.

---

### 2. Monitor System Activity
**Title:** As an admin, I want to view system logs so that I can monitor activity.

**Acceptance Criteria:**
1. Logs show login, logout, booking, and cancellation events.
2. Logs are filterable by date and user role.
3. Only admins can access logs.

**Priority:** Medium  
**Story Points:** 4  
**Notes:** Store logs for at least 6 months.

---

### 3. Manage Doctor Listings
**Title:** As an admin, I want to add, edit, or remove doctor listings so that patients see accurate options.

**Acceptance Criteria:**
1. Admin can update doctor profiles and availability.
2. Changes are reflected in patient booking view instantly.
3. Doctor receives email notification for profile changes.

**Priority:** High  
**Story Points:** 4  
**Notes:** Verify doctor credentials before listing.

---

### 4. Configure Appointment Settings
**Title:** As an admin, I want to configure appointment settings so that the system works according to policy.

**Acceptance Criteria:**
1. Admin can set default appointment duration.
2. Admin can define maximum daily appointments per doctor.
3. Changes apply to all new bookings.

**Priority:** Medium  
**Story Points:** 3  
**Notes:** Does not affect already scheduled appointments.

---

### 5. Generate Reports
**Title:** As an admin, I want to generate usage reports so that I can analyze portal performance.

**Acceptance Criteria:**
1. Reports include bookings, cancellations, and active users.
2. Reports can be exported as PDF or CSV.
3. Admin can filter reports by date range.

**Priority:** Medium  
**Story Points:** 4  
**Notes:** Reports should be downloadable.

---
