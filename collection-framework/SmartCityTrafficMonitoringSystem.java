import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SmartCityTrafficMonitoringSystem {
    private Map<String, Integer> roadTrafficCounts;

    public SmartCityTrafficMonitoringSystem() {
        roadTrafficCounts = new HashMap<String, Integer>();
    }

    public void updateVehicleCount(String roadName, int vehicleCount) {
        if (roadName == null || roadName.trim().isEmpty()) {
            throw new IllegalArgumentException("Road name must not be empty");
        }
        if (vehicleCount < 0) {
            throw new IllegalArgumentException("Vehicle count must not be negative");
        }
        roadTrafficCounts.merge(roadName, vehicleCount, Integer::sum);
    }

    public void displaySortedByRoadName() {
        TreeMap<String, Integer> sortedRoads = new TreeMap<String, Integer>(roadTrafficCounts);
        System.out.println("Roads in sorted order:");
        for (Map.Entry<String, Integer> entry : sortedRoads.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public String getBusiestRoad() {
        if (roadTrafficCounts.isEmpty()) {
            throw new IllegalStateException("No roads are being monitored");
        }
        String busiestRoad = null;
        int maxVehicles = -1;
        for (Map.Entry<String, Integer> entry : roadTrafficCounts.entrySet()) {
            if (entry.getValue() > maxVehicles) {
                maxVehicles = entry.getValue();
                busiestRoad = entry.getKey();
            }
        }
        return busiestRoad;
    }

    public void generateTrafficReport() {
        System.out.println("Traffic Report:");
        for (Map.Entry<String, Integer> entry : roadTrafficCounts.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + " vehicles");
        }
        System.out.println("Total roads monitored: " + roadTrafficCounts.size());
    }

    public static void main(String[] args) {
        SmartCityTrafficMonitoringSystem trafficSystem = new SmartCityTrafficMonitoringSystem();

        trafficSystem.updateVehicleCount("MG Road", 340);
        trafficSystem.updateVehicleCount("Ring Road", 520);
        trafficSystem.updateVehicleCount("Station Road", 210);
        trafficSystem.updateVehicleCount("MG Road", 60);

        trafficSystem.displaySortedByRoadName();

        System.out.println("Busiest road: " + trafficSystem.getBusiestRoad());

        trafficSystem.generateTrafficReport();
    }
}
