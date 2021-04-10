package hu.nive.ujratervezes.kepesitovizsga.architect;

public class IndustrialBuildingPlan implements Plan{


    private String projectName;
    private int stock;
    private int areaOfOfficeBlock;
    private int areaOfManufacturingHall;
    private PlanType planType;

    public IndustrialBuildingPlan(String projectName, int areaOfOfficeBlock, int stock, int areaOfManufacturingHall) {
        this.projectName = projectName;
        this.stock = stock;
        this.areaOfOfficeBlock = areaOfOfficeBlock;
        this.areaOfManufacturingHall = areaOfManufacturingHall;
        planType = PlanType.INDUSTRIAL;
    }

    @Override
    public String getProjectName() {
        return projectName;
    }

    @Override
    public int calculateSquareMeter() {
        return areaOfManufacturingHall + areaOfOfficeBlock * stock;
    }

    @Override
    public PlanType getType() {
        return planType;
    }

    public int getStock() {
        return stock;
    }

    public int getAreaOfOfficeBlock() {
        return areaOfOfficeBlock;
    }

    public int getAreaOfManufacturingHall() {
        return areaOfManufacturingHall;
    }

    public PlanType getPlanType() {
        return planType;
    }
}
