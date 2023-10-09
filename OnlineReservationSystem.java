import java.util.ArrayList;
import java.util.Scanner;

class Train {
    String name, source, destination;
    int availableSeats, totalSeats;
    double fare;

    public Train(String name, String source, String destination, int totalSeats, int availableSeats, double fare) {
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
        this.fare = fare;
    }

    public String toString() {
        return name + "\t" + source + "\t" + destination + "\t" + totalSeats + "\t" + availableSeats + "\t" + fare;
    }
}

class Reservation {
    ArrayList<Train> trains = new ArrayList<Train>();
    Scanner sc = new Scanner(System.in);

    public void addTrain() {
        System.out.print("Enter train name: ");
        String name = sc.nextLine();
        System.out.print("Enter source station: ");
        String source = sc.nextLine();
        System.out.print("Enter destination station: ");
        String destination = sc.nextLine();
        System.out.print("Enter total seats: ");
        int totalSeats = Integer.parseInt(sc.nextLine());
        System.out.print("Enter available seats: ");
        int availableSeats = Integer.parseInt(sc.nextLine());
        System.out.print("Enter fare: ");
        double fare = Double.parseDouble(sc.nextLine());

        Train train = new Train(name, source, destination, totalSeats, availableSeats, fare);
        trains.add(train);
    }

    public void displayTrains() {
        System.out.println("Name\tSource\tDestination\tTotal Seats\tAvailableSeats\tFare");
        for (Train train : trains) {
            System.out.println(train);
        }
    }

    public void bookTicket() {
        System.out.print("Enter train name: ");
        String name = sc.nextLine();
        Train train = null;

        for (Train t : trains) {
            if (t.name.equalsIgnoreCase(name)) {
                train = t;
                break;
            }
        }

        if (train != null) {
            System.out.print("Enter number of seats: ");
            int seats = Integer.parseInt(sc.nextLine());

            if (seats <= train.availableSeats) {
                train.availableSeats -= seats;
                double fare = seats * train.fare;
                System.out.println("Total fare: " + fare);
            } else {
                System.out.println("Sorry, only " + train.availableSeats + " seats available.");
            }
        } else {
            System.out.println("Train not found.");
        }
    }

    public void login() {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if (username.equals("manish") && password.equals("kumar399")) {
            System.out.println("Login successful.");
        } 
        else {
            System.out.println("Invalid username or password.");
            System.exit(0);
        }
    }
}

public class OnlineReservationSystem {
    public static void main(String[] args) {
        Reservation reservation = new Reservation();
        Scanner sc = new Scanner(System.in);
        int choice;

        reservation.login();

        do {
            System.out.println("1. Add train\n2. Display trains\n3. Book ticket\n4. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    reservation.addTrain();
                    break;
                case 2:
                    reservation.displayTrains();
                    break;
                case 3:
                    reservation.bookTicket();
                    break;
                case 4:
                    reservation.login();
                    break;
                case 5:
                    reservation.CancellationForm();
                    break;
                case 6:
                System.out.println("Thank you for using the Online Train Reservation System.");
                break;
                default:
                System.out.println("Invalid choice");

            }
        }while (choice != 5);

    }
}

