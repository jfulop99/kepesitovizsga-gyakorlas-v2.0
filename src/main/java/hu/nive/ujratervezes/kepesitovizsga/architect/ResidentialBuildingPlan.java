package hu.nive.ujratervezes.kepesitovizsga.architect;

public class ResidentialBuildingPlan implements Plan{


    private PlanType planType;
    private String projectName;
    private House house;
    private int stock;
    private int area;

    public ResidentialBuildingPlan(String projectName, House house, int stock, int area) {
        this.projectName = projectName;
        this.house = house;
        this.stock = stock;
        this.area = area;
        this.planType = PlanType.RESIDENTIAL;
    }

    @Override
    public int calculateSquareMeter() {
        return area * stock;
    }

    @Override
    public PlanType getType() {
        return planType;
    }

    @Override
    public String getProjectName() {
        return projectName;
    }

    public House getHouse() {
        return house;
    }

    public int getStock() {
        return stock;
    }

    public int getArea() {
        return area;
    }
}
