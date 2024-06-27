package HospitalManagementSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Patient {
    private String id;
    private String name;
    private int age;

    private String gender;

    // Constructor to initialize patient details
    public Patient(String id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;

        this.gender = gender;
    }

    // Getter methods
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }



    public String getGender() {
        return gender;
    }


    @Override
    public String toString() {
        return String.format("| %-10s | %-18s | %-8d | %-10s |", id, name, age, gender);
    }


    public static void addPatient(List<Patient> patients, Patient patient) {
        patients.add(patient);
        System.out.println("Patient added succesfull: ");
    }


    public static void viewPatients(List<Patient> patients) {
        System.out.println("Patients:");
        System.out.println("+------------+--------------------+----------+------------+");
        System.out.println("| Patient Id | Name               | Age      | Gender     |");
        System.out.println("+------------+--------------------+----------+------------+");

        for (Patient patient : patients) {
            System.out.println(patient);
        }

        System.out.println("+------------+--------------------+----------+------------+");
    }

    public static void checkPatient(List<Patient> patients, String patientId) {
        for (Patient patient : patients) {
            if (patient.getId().equals(patientId)) {
                System.out.println("Patient found:");
                System.out.println("+------------+--------------------+----------+------------+");
                System.out.println("| Patient Id | Name               | Age      | Gender     |");
                System.out.println("+------------+--------------------+----------+------------+");
                System.out.println(patient);
                System.out.println("+------------+--------------------+----------+------------+");
                return;
            }
        }
        System.out.println("Patient not found.");
    }
}