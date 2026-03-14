import java.util.*;

class Reservation {
    int pnr;
    String name;
    int age;
    String gender;
    String trainNo;
    String trainName;
    String classType;
    String date;
    String source;
    String destination;

    public Reservation(int pnr, String name, int age, String gender, String trainNo,
                       String trainName, String classType, String date,
                       String source, String destination) {

        this.pnr = pnr;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.classType = classType;
        this.date = date;
        this.source = source;
        this.destination = destination;
    }

    public void display() {
        System.out.println("PNR Number: " + pnr);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Train No: " + trainNo);
        System.out.println("Train Name: " + trainName);
        System.out.println("Class: " + classType);
        System.out.println("Date of Journey: " + date);
        System.out.println("From: " + source);
        System.out.println("To: " + destination);
    }
}

public class OnlineReservationSystem {

    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer, Reservation> reservations = new HashMap<>();
    static Random rand = new Random();

    // LOGIN MODULE
    static boolean login() {
        System.out.println("----- Login Form -----");

        System.out.print("Enter Login ID: ");
        String id = sc.next();

        System.out.print("Enter Password: ");
        String pass = sc.next();

        if (id.equals("admin") && pass.equals("1234")) {
            System.out.println("Login Successful\n");
            return true;
        } else {
            System.out.println("Invalid Login");
            return false;
        }
    }

    // RESERVATION MODULE
    static void reserveTicket() {

        int pnr = rand.nextInt(90000) + 10000;

        System.out.println("----- Reservation Form -----");

        System.out.print("Name: ");
        String name = sc.next();

        System.out.print("Age: ");
        int age = sc.nextInt();

        System.out.print("Gender: ");
        String gender = sc.next();

        System.out.print("Train Number: ");
        String trainNo = sc.next();

        System.out.print("Train Name: ");
        String trainName = sc.next();

        System.out.print("Class Type: ");
        String classType = sc.next();

        System.out.print("Date of Journey: ");
        String date = sc.next();

        System.out.print("From: ");
        String source = sc.next();

        System.out.print("To: ");
        String destination = sc.next();

        Reservation r = new Reservation(pnr, name, age, gender, trainNo,
                trainName, classType, date, source, destination);

        reservations.put(pnr, r);

        System.out.println("Reservation Successful!");
        System.out.println("Your PNR Number: " + pnr);
    }

    // CANCELLATION MODULE
    static void cancelTicket() {

        System.out.print("Enter PNR Number: ");
        int pnr = sc.nextInt();

        if (reservations.containsKey(pnr)) {

            Reservation r = reservations.get(pnr);
            r.display();

            System.out.print("Confirm Cancellation (Y/N): ");
            char confirm = sc.next().charAt(0);

            if (confirm == 'Y' || confirm == 'y') {
                reservations.remove(pnr);
                System.out.println("Ticket Cancelled Successfully");
            } else {
                System.out.println("Cancellation Aborted");
            }

        } else {
            System.out.println("PNR Not Found");
        }
    }

    // MAIN SYSTEM
    public static void main(String[] args) {

        if (!login())
            return;

        int choice;

        do {
            System.out.println("\n--- Online Reservation System ---");
            System.out.println("1. Reserve Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    reserveTicket();
                    break;

                case 2:
                    cancelTicket();
                    break;

                case 3:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 3);
    }
}