package HospitalManagementSystem;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class HospitalManagementSystem {
    private List<Patient> patients;
    private List<Doctor> doctors;

    // Constructor to initialize lists of patients and doctors
    public HospitalManagementSystem() {
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
    }

    // Method to add a patient
    public void addPatient(Patient patient) {
        Patient.addPatient(patients, patient);
    }

    // Method to view all patients
    public void viewPatients() {
        Patient.viewPatients(patients);
    }

    // ye Method haa  check and display a patient by ID
    public void checkPatient(String patientId) {
        Patient.checkPatient(patients, patientId);
    }

    // ye Method patients ke appointment book karta ha doctors ka sath1
    public void bookAppointment(String patientId, String doctorId, String appointmentDate) {
        Patient patient = null;
        Doctor doctor = null;

        for (Patient p : patients) {
            if (p.getId().equals(patientId)) {
                patient = p;
                break;
            }
        }

        for (Doctor d : doctors) {
            if (d.getId().equals(doctorId)) {
                doctor = d;
                break;
            }
        }

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        Appointment appointment = new Appointment(patientId, doctorId, appointmentDate);
        if (doctor.addAppointment(appointment)) {
            System.out.println("Appointment booked: " + appointment);
        } else {
            System.out.println("Failed to book appointment: Doctor is already booked for this time slot.");
        }
    }

    // ye method haa check the appointment of a patient
    public void checkAppointment(String patientId) {
        for (Doctor doctor : doctors) {
            for (Appointment appointment : doctor.getAppointments()) {
                if (appointment.getPatientId().equals(patientId)) {
                    System.out.println("Appointment found: " + appointment);
                    return;
                }
            }
        }
        System.out.println("No appointment found for patient ID: " + patientId);
    }

    // ye method ha doctor ko add karne ka
    public void addDoctor(Doctor doctor) {
        Doctor.addDoctor(doctors, doctor);
    }

    // ye method ha view all doctors ka
    public void viewDoctors() {
        Doctor.viewDoctors(doctors);
    }

    public static void main(String[] args) {
        HospitalManagementSystem hms = new HospitalManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nHospital Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Check Patient");
            System.out.println("4. Book Appointment");
            System.out.println("5. Check Appointment");
            System.out.println("6. Add Doctor");
            System.out.println("7. View Doctors");
            System.out.println("8. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // newline

            switch (choice) {
                case 1:
                    System.out.print("Enter patient ID: ");
                    String patientId = scanner.nextLine();
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter patient age: ");
                    int patientAge = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter patient ailment: ");
                    String patientAilment = scanner.nextLine();
                    System.out.print("Enter patient gender: ");
                    String patientGender = scanner.nextLine();
                    Patient patient = new Patient(patientId, patientName, patientAge,  patientGender);
                    hms.addPatient(patient);
                    break;

                case 2:
                    hms.viewPatients();
                    break;

                case 3:
                    System.out.print("Enter patient ID: ");
                    String checkPatientId = scanner.nextLine();
                    hms.checkPatient(checkPatientId);
                    break;

                case 4:
                    System.out.print("Enter patient ID: ");
                    String bookAppointmentPatientId = scanner.nextLine();
                    System.out.print("Enter doctor ID: ");
                    String bookAppointmentDoctorId = scanner.nextLine();
                    System.out.print("Enter appointment date: ");
                    String bookAppointmentDate = scanner.nextLine();
                    hms.bookAppointment(bookAppointmentPatientId, bookAppointmentDoctorId, bookAppointmentDate);
                    break;

                case 5:
                    System.out.print("Enter patient ID: ");
                    String checkAppointmentPatientId = scanner.nextLine();
                    hms.checkAppointment(checkAppointmentPatientId);
                    break;

                case 6:
                    System.out.print("Enter doctor ID: ");
                    String doctorId = scanner.nextLine();
                    System.out.print("Enter doctor name: ");
                    String doctorName = scanner.nextLine();
                    System.out.print("Enter doctor specialty: ");
                    String doctorSpecialty = scanner.nextLine();
                    Doctor doctor = new Doctor(doctorId, doctorName, doctorSpecialty);
                    hms.addDoctor(doctor);
                    break;

                case 7:
                    hms.viewDoctors();
                    break;

                case 8:
                    System.out.println("Exiting system...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
