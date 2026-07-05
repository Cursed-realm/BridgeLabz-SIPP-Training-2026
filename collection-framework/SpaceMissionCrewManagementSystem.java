import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Astronaut {
    private String astronautId;
    private String name;
    private String specialization;

    public Astronaut(String astronautId, String name, String specialization) {
        if (astronautId == null || astronautId.trim().isEmpty()) {
            throw new IllegalArgumentException("Astronaut ID must not be empty");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        if (specialization == null || specialization.trim().isEmpty()) {
            throw new IllegalArgumentException("Specialization must not be empty");
        }
        this.astronautId = astronautId;
        this.name = name;
        this.specialization = specialization;
    }

    public String getAstronautId() {
        return astronautId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String toString() {
        return name + " (" + astronautId + ") - " + specialization;
    }
}

public class SpaceMissionCrewManagementSystem {
    private Map<String, List<Astronaut>> missionCrews;
    private Map<String, Set<String>> missionAssignedIds;

    public SpaceMissionCrewManagementSystem() {
        missionCrews = new HashMap<String, List<Astronaut>>();
        missionAssignedIds = new HashMap<String, Set<String>>();
    }

    public void addMission(String missionName) {
        if (missionName == null || missionName.trim().isEmpty()) {
            throw new IllegalArgumentException("Mission name must not be empty");
        }
        if (!missionCrews.containsKey(missionName)) {
            missionCrews.put(missionName, new ArrayList<Astronaut>());
            missionAssignedIds.put(missionName, new HashSet<String>());
        }
    }

    public boolean assignAstronaut(String missionName, Astronaut astronaut) {
        if (!missionCrews.containsKey(missionName)) {
            throw new IllegalStateException("Mission does not exist: " + missionName);
        }
        Set<String> assignedIds = missionAssignedIds.get(missionName);
        if (assignedIds.contains(astronaut.getAstronautId())) {
            return false;
        }
        assignedIds.add(astronaut.getAstronautId());
        missionCrews.get(missionName).add(astronaut);
        return true;
    }

    public void displayAllMissions() {
        for (Map.Entry<String, List<Astronaut>> entry : missionCrews.entrySet()) {
            System.out.println("Mission: " + entry.getKey());
            for (Astronaut astronaut : entry.getValue()) {
                System.out.println(astronaut);
            }
            System.out.println("Total assigned astronauts: " + entry.getValue().size());
        }
    }

    public static void main(String[] args) {
        SpaceMissionCrewManagementSystem crewSystem = new SpaceMissionCrewManagementSystem();

        crewSystem.addMission("Artemis");
        crewSystem.addMission("Mars Explorer");

        Astronaut astronaut1 = new Astronaut("A001", "Aditya", "Pilot");
        Astronaut astronaut2 = new Astronaut("A002", "Zara", "Engineer");
        Astronaut astronaut3 = new Astronaut("A003", "Manav", "Scientist");

        crewSystem.assignAstronaut("Artemis", astronaut1);
        crewSystem.assignAstronaut("Artemis", astronaut2);
        boolean duplicate = crewSystem.assignAstronaut("Artemis", astronaut1);
        System.out.println("Duplicate assignment prevented: " + !duplicate);

        crewSystem.assignAstronaut("Mars Explorer", astronaut3);
        crewSystem.assignAstronaut("Mars Explorer", astronaut1);

        crewSystem.displayAllMissions();
    }
}
