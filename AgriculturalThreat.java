// ==========================================
// 1. ABSTRACTION & INHERITANCE
// ==========================================
abstract class AgriculturalThreat {
    protected String name;
    protected String description;

    public AgriculturalThreat(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }

    public abstract String getThreatCategory();
    public abstract String getTargetOrPathogen();
    public abstract void displayPreventionGuide();
}

class Pest extends AgriculturalThreat {
    private String affectedCrops;
    private String recommendedSolution;

    public Pest(String name, String description, String affectedCrops, String recommendedSolution) {
        super(name, description);
        this.affectedCrops = affectedCrops;
        this.recommendedSolution = recommendedSolution;
    }

    @Override public String getThreatCategory() { return "Pest"; }
    @Override public String getTargetOrPathogen() { return affectedCrops; }
    @Override public void displayPreventionGuide() {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Pest Name            : " + name);
        System.out.println("Affected Crops       : " + affectedCrops);
        System.out.println("Description          : " + description);
        System.out.println("Recommended Solution : " + recommendedSolution);
        System.out.println("------------------------------------------------------------------------");
    }
}

class Disease extends AgriculturalThreat {
    private String pathogenType;
    private String managementStrategy;

    public Disease(String name, String description, String pathogenType, String managementStrategy) {
        super(name, description);
        this.pathogenType = pathogenType;
        this.managementStrategy = managementStrategy;
    }

    @Override public String getThreatCategory() { return "Plant Disease"; }
    @Override public String getTargetOrPathogen() { return pathogenType; }
    @Override public void displayPreventionGuide() {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Disease Name         : " + name);
        System.out.println("Pathogen Type        : " + pathogenType);
        System.out.println("Description          : " + description);
        System.out.println("Management Strategy  : " + managementStrategy);
        System.out.println("------------------------------------------------------------------------");
    }
}
