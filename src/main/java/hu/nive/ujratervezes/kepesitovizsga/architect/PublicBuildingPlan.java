package hu.nive.ujratervezes.kepesitovizsga.architect;

public class PublicBuildingPlan implements Plan{

    private String projectName;
    private int stock;
    private int area;
    private PlanType planType;

    public PublicBuildingPlan(String projectName, int stock, int area) {
        this.projectName = projectName;
        this.stock = stock;
        this.area = area;
        this.planType = PlanType.PUBLIC;
    }

    @Override
    public String getProjectName() {
        return projectName;
    }

    @Override
    public int calculateSquareMeter() {
        return area * stock;
    }

    @Override
    public PlanType getType() {
        return planType;
    }

    public int getStock() {
        return stock;
    }

    public int getArea() {
        return area;
    }
}
