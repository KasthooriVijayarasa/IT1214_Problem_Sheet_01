class Vehicle {
    private String licensePlate;
    private String ownerName;
    private int hoursParked;

    public Vehicle(String licensePlate, String ownerName, int hoursParked) {
        this.licensePlate = licensePlate;
        this.ownerName = ownerName;
        this.hoursParked = hoursParked;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getHoursParked() {
        return hoursParked;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setHoursParked(int hoursParked) {
        this.hoursParked = hoursParked;
    }
}

class ParkingLot {
    private Vehicle[] vehicles;
    private int numVehicles;

    public ParkingLot() {
        vehicles = new Vehicle[5];
        numVehicles = 0;
    }

    public void parkVehicle(Vehicle vehicle) {
        if (numVehicles < 5) {
            vehicles[numVehicles] = vehicle;
            numVehicles++;
        } else {
            System.out.println("Parking lot is full.");
        }
    }

    public void removeVehicle(String licensePlate) {
        boolean found = false;
        for (int i = 0; i < numVehicles; i++) {
            if (vehicles[i].getLicensePlate().equals(licensePlate)) {
                for (int j = i; j < numVehicles - 1; j++) {
                    vehicles[j] = vehicles[j + 1];
                }
                vehicles[numVehicles - 1] = null;
                numVehicles--;
                found = true;
                System.out.println("Vehicle with license " + licensePlate + " removed.");
                break;
            }
        }
        if (!found) {
            System.out.println("Vehicle with license " + licensePlate + " not found.");
        }
    }

    public void displayAllVehicles() {
        System.out.println("License\t\tOwner\t\tHours Parked");
        System.out.println("----------------------------------------");
        for (int i = 0; i < numVehicles; i++) {
            System.out.println(vehicles[i].getLicensePlate() + "\t" + vehicles[i].getOwnerName() + "\t" + vehicles[i].getHoursParked());
        }
    }
}

public class ParkingLotTracker {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();
      
        parkingLot.parkVehicle(new Vehicle("ABC123", "John Doe", 2));
        parkingLot.parkVehicle(new Vehicle("XYZ789", "Jane Smith", 4));
        parkingLot.parkVehicle(new Vehicle("LMN456", "Bob Brown", 1));
       
        parkingLot.removeVehicle("XYZ789");
      
        parkingLot.removeVehicle("NON123");
      
        parkingLot.displayAllVehicles();
    }
}