import java.util.*;

class Driver {
    String name;

    Driver(String name) {
        this.name = name;
    }
}

class Rider {
    String name;

    Rider(String name) {
        this.name = name;
    }
}

abstract class Vehicle {
    abstract double calculateFare(double distance);
}

class Bike extends Vehicle {
    double calculateFare(double distance) {
        return distance * 5;
    }
}

class Auto extends Vehicle {
    double calculateFare(double distance) {
        return distance * 12;
    }
}

class Cab extends Vehicle {
    double calculateFare(double distance) {
        return distance * 12;
    }
}

class Trip {
    Driver driver;
    Rider rider;
    Vehicle vehicle;

    Trip(Driver driver, Rider rider, Vehicle vehicle) {
        this.driver = driver;
        this.rider = rider;
        this.vehicle = vehicle;
    }

    double getFare(double distance) {
        if (distance <= 0) {
            throw new IllegalArgumentException("Invalid distance");
        }
        return vehicle.calculateFare(distance);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Driver driver = new Driver("Driver1");
        Rider rider = new Rider("Rider1");

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double distance = sc.nextDouble();

            Vehicle vehicle;

            if (type.equalsIgnoreCase("Bike")) {
                vehicle = new Bike();
            } 
            else if (type.equalsIgnoreCase("Auto")) {
                vehicle = new Auto();
            } 
            else if (type.equalsIgnoreCase("Cab")) {
                vehicle = new Cab();
            } 
            else {
                System.out.println("Invalid ride type");
                continue;
            }

            try {
                Trip trip = new Trip(driver, rider, vehicle);
                System.out.println((int) trip.getFare(distance));
            } 
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        sc.close();
    }
}
