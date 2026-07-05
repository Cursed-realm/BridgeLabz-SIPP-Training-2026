import java.util.ArrayList;
import java.util.List;

public class SmartParkingSlotManager {
    private List<String> parkedVehicles;

    public SmartParkingSlotManager() {
        parkedVehicles = new ArrayList<String>();
    }

    public boolean enterParking(String registrationNumber) {
        if (registrationNumber == null || registrationNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Registration number must not be empty");
        }
        if (parkedVehicles.contains(registrationNumber)) {
            return false;
        }
        parkedVehicles.add(registrationNumber);
        return true;
    }

    public boolean exitParking(String registrationNumber) {
        if (registrationNumber == null || registrationNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Registration number must not be empty");
        }
        return parkedVehicles.remove(registrationNumber);
    }

    public boolean searchVehicle(String registrationNumber) {
        if (registrationNumber == null || registrationNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Registration number must not be empty");
        }
        return parkedVehicles.contains(registrationNumber);
    }

    public void displayParkedVehicles() {
        System.out.println("Parked Vehicles:");
        for (String vehicle : parkedVehicles) {
            System.out.println(vehicle);
        }
        System.out.println("Total occupied slots: " + parkedVehicles.size());
    }

    public static void main(String[] args) {
        SmartParkingSlotManager parkingManager = new SmartParkingSlotManager();

        parkingManager.enterParking("UP80AB1234");
        parkingManager.enterParking("DL05CD5678");
        parkingManager.enterParking("MH12EF9012");

        System.out.println("Search UP80AB1234: " + parkingManager.searchVehicle("UP80AB1234"));
        System.out.println("Search RJ14XY0000: " + parkingManager.searchVehicle("RJ14XY0000"));

        parkingManager.exitParking("DL05CD5678");

        parkingManager.displayParkedVehicles();
    }
}
