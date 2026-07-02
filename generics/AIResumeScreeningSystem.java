import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private String title;
    private int requiredExperience;

    public JobRole(String title, int requiredExperience) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title must not be empty");
        }
        if (requiredExperience < 0) {
            throw new IllegalArgumentException("Required experience must not be negative");
        }
        this.title = title;
        this.requiredExperience = requiredExperience;
    }

    public String getTitle() {
        return title;
    }

    public int getRequiredExperience() {
        return requiredExperience;
    }
}

class SoftwareEngineer extends JobRole {
    private String preferredLanguage;

    public SoftwareEngineer(int requiredExperience, String preferredLanguage) {
        super("Software Engineer", requiredExperience);
        if (preferredLanguage == null || preferredLanguage.trim().isEmpty()) {
            throw new IllegalArgumentException("Preferred language must not be empty");
        }
        this.preferredLanguage = preferredLanguage;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }
}

class DataScientist extends JobRole {
    private String preferredTool;

    public DataScientist(int requiredExperience, String preferredTool) {
        super("Data Scientist", requiredExperience);
        if (preferredTool == null || preferredTool.trim().isEmpty()) {
            throw new IllegalArgumentException("Preferred tool must not be empty");
        }
        this.preferredTool = preferredTool;
    }

    public String getPreferredTool() {
        return preferredTool;
    }
}

class ProductManager extends JobRole {
    private int teamSizeManaged;

    public ProductManager(int requiredExperience, int teamSizeManaged) {
        super("Product Manager", requiredExperience);
        if (teamSizeManaged < 0) {
            throw new IllegalArgumentException("Team size managed must not be negative");
        }
        this.teamSizeManaged = teamSizeManaged;
    }

    public int getTeamSizeManaged() {
        return teamSizeManaged;
    }
}

class Resume<T extends JobRole> {
    private String candidateName;
    private int candidateExperience;
    private T targetRole;

    public Resume(String candidateName, int candidateExperience, T targetRole) {
        if (candidateName == null || candidateName.trim().isEmpty()) {
            throw new IllegalArgumentException("Candidate name must not be empty");
        }
        if (candidateExperience < 0) {
            throw new IllegalArgumentException("Candidate experience must not be negative");
        }
        if (targetRole == null) {
            throw new IllegalArgumentException("Target role must not be null");
        }
        this.candidateName = candidateName;
        this.candidateExperience = candidateExperience;
        this.targetRole = targetRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public int getCandidateExperience() {
        return candidateExperience;
    }

    public T getTargetRole() {
        return targetRole;
    }

    public boolean isQualified() {
        return candidateExperience >= targetRole.getRequiredExperience();
    }

    public String toString() {
        return candidateName + " -> " + targetRole.getTitle() + " (" + candidateExperience + " yrs, qualified: " + isQualified() + ")";
    }
}

public class AIResumeScreeningSystem {

    public static void screenResumes(List<? extends JobRole> roles) {
        if (roles == null) {
            throw new IllegalArgumentException("Roles list must not be null");
        }
        for (JobRole role : roles) {
            System.out.println(role.getTitle() + " requires " + role.getRequiredExperience() + " years");
        }
    }

    public static void main(String[] args) {
        SoftwareEngineer engineerRole = new SoftwareEngineer(2, "Java");
        DataScientist scientistRole = new DataScientist(3, "Python");
        ProductManager managerRole = new ProductManager(5, 8);

        Resume<SoftwareEngineer> resume1 = new Resume<SoftwareEngineer>("Aditya", 1, engineerRole);
        Resume<DataScientist> resume2 = new Resume<DataScientist>("Simran", 4, scientistRole);
        Resume<ProductManager> resume3 = new Resume<ProductManager>("Rohit", 3, managerRole);

        List<Resume<?>> resumes = new ArrayList<Resume<?>>();
        resumes.add(resume1);
        resumes.add(resume2);
        resumes.add(resume3);

        System.out.println("Resume Screening Results:");
        for (Resume<?> resume : resumes) {
            System.out.println(resume);
        }

        List<JobRole> roles = new ArrayList<JobRole>();
        roles.add(engineerRole);
        roles.add(scientistRole);
        roles.add(managerRole);

        System.out.println("Job Role Requirements:");
        screenResumes(roles);
    }
}
