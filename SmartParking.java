
import java.util.ArrayList;
import java.util.List;

// Parking Spot class
class ParkingSpot {
    int spotId;
    String status;
    String vehicle;

    ParkingSpot(int spotId) {
        this.spotId = spotId;
        this.status = "Available";
        this.vehicle = null;
    }
}

// ParkingSpotManager class
class ParkingSpotManager {

    List<ParkingSpot> parkings;

    ParkingSpotManager() {
        parkings = new ArrayList<>();
    }

    // Add parking spot
    void addParkingSpot(ParkingSpot spot) {
        parkings.add(spot);
        System.out.println("Parking spot added successfully!");
    }

    // Find available parking spot
    ParkingSpot findParkingSpot() {
        for (ParkingSpot spot : parkings) {
            if (spot.status.equals("Available")) {
                return spot;
            }
        }
        return null;
    }

    // Remove parking spot
    void removeParkingSpot(ParkingSpot spot) {
        if (parkings.remove(spot)) {
            System.out.println("Parking spot removed successfully!");
        } else {
            System.out.println("Parking spot not found!");
        }
    }

    // Park vehicle
    void parkVehicle(String vehicle) {
        ParkingSpot spot = findParkingSpot();

        if (spot != null) {
            spot.status = "Occupied";
            spot.vehicle = vehicle;

            System.out.println("Vehicle " + vehicle +
                    " parked in spot " + spot.spotId);
        } else {
            System.out.println("No parking spots available!");
        }
    }

    // Display parking details
    void displayParkingSpots() {
        System.out.println("\n--- Parking Details ---");

        for (ParkingSpot spot : parkings) {
            System.out.println("Spot ID: " + spot.spotId);
            System.out.println("Status: " + spot.status);
            System.out.println("Vehicle: " + spot.vehicle);
            System.out.println("----------------------");
        }
    }
}

// Main class
public class SmartParking {
    public static void main(String[] args) {

        ParkingSpotManager manager = new ParkingSpotManager();

        manager.addParkingSpot(new ParkingSpot(1));
        manager.addParkingSpot(new ParkingSpot(2));
        manager.addParkingSpot(new ParkingSpot(3));

        manager.parkVehicle("KA01AB1234");
        manager.parkVehicle("KA02CD5678");

        manager.displayParkingSpots();
    }
}
