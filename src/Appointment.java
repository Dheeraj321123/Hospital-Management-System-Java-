package HospitalManagementSystem;

   class Appointment {
        private String patientId;
        private String doctorId;
        private String appointmentDate;

        // yee Constructor ha  initialize karta ha  appointment details
        public Appointment(String patientId, String doctorId, String appointmentDate) {
            this.patientId = patientId;
            this.doctorId = doctorId;
            this.appointmentDate = appointmentDate;
        }


        public String getPatientId() {
            return patientId;
        }

        public String getDoctorId() {
            return doctorId;
        }

        public String getAppointmentDate() {
            return appointmentDate;
        }


        @Override
        public String toString() {
            return String.format("Appointment{patientId='%s', doctorId='%s', appointmentDate='%s'}", patientId, doctorId, appointmentDate);
        }
    }

