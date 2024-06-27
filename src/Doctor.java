package HospitalManagementSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Doctor {
    private String id;
    private String name;
    private String specialty;
    private List<Appointment> appointments;

    // yee Constructor ha jo  initialize karta ha doctor ke  details ko
    public Doctor(String id, String name, String specialty) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.appointments = new ArrayList<>();
    }

    // Getter methods
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    // yee Method haa to add an appointment for the doctor
    public boolean addAppointment(Appointment appointment) {
        for (Appointment a : appointments) {
            if (a.getAppointmentDate().equals(appointment.getAppointmentDate())) {
                return false; // Appointment slot already taken
            }
        }
        appointments.add(appointment);
        return true;
    }


    public static void addDoctor(List<Doctor> doctors, Doctor doctor) {
        doctors.add(doctor);
        System.out.println("Doctor added succesfull: ");
    }


    public static void viewDoctors(List<Doctor> doctors) {
        System.out.println("Doctors:");
        System.out.println("+------------+--------------------+-----------------+");
        System.out.println("| Doctor Id  | Name               | Specialty       |");
        System.out.println("+------------+--------------------+-----------------+");

        for (Doctor doctor : doctors) {
            System.out.println(String.format("| %-10s | %-18s | %-15s |", doctor.getId(), doctor.getName(), doctor.getSpecialty()));
        }

        System.out.println("+------------+--------------------+-----------------+");
        System.out.println("Total number of doctors: " + doctors.size());
    }


    @Override
    public String toString() {
        return String.format("Doctor{id='%s', name='%s', specialty='%s'}", id, name, specialty);
    }
}

