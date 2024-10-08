import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Patient {
    private String name;
    private int age;
    private String illness;

    public Patient(String name, int age, String illness) {
        this.name = name;
        this.age = age;
        this.illness = illness;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getIllness() {
        return illness;
    }

    @Override
    public String toString() {
        return "Patient Name: " + name + ", Age: " + age + ", Illness: " + illness;
    }
}

class Hospital {
    private ArrayList<Patient> patients;

    public Hospital() {
        patients = new ArrayList<>();
    }

    public void addPatient(String name, int age, String illness) {
        Patient newPatient = new Patient(name, age, illness);
        patients.add(newPatient);
        System.out.println("Patient added: " + newPatient);
    }

    public void removePatient(String name) {
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                patients.remove(patient);
                System.out.println("Patient removed: " + name);
                return;
            }
        }
        System.out.println("Patient not found: " + name);
    }

    public void searchPatient(String name) {
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                System.out.println("Patient found: " + patient);
                return;
            }
        }
        System.out.println("Patient not found: " + name);
    }

    public void sortPatientsByAge() {
        Collections.sort(patients, new Comparator<Patient>() {
            public int compare(Patient p1, Patient p2) {
                return Integer.compare(p1.getAge(), p2.getAge());
            }
        });
        System.out.println("Patients sorted by age.");
    }

    public void displayPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        }
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Remove Patient");
            System.out.println("3. Search Patient");
            System.out.println("4. Sort Patients by Age");
            System.out.println("5. Display All Patients");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter patient age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter illness: ");
                    String illness = scanner.nextLine();
                    hospital.addPatient(name, age, illness);
                    break;

                case 2:
                    System.out.print("Enter patient name to remove: ");
                    String removeName = scanner.nextLine();
                    hospital.removePatient(removeName);
                    break;

                case 3:
                    System.out.print("Enter patient name to search: ");
                    String searchName = scanner.nextLine();
                    hospital.searchPatient(searchName);
                    break;

                case 4:
                    hospital.sortPatientsByAge();
                    break;

                case 5:
                    hospital.displayPatients();
                    break;

                case 6:
                    System.out.println("Exiting system...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
