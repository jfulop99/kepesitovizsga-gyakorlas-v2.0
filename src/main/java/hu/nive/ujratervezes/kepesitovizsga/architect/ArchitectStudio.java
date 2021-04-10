package hu.nive.ujratervezes.kepesitovizsga.architect;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArchitectStudio {

    private Map<String, Plan> planMap;

    public ArchitectStudio() {

        planMap = new HashMap<>();

    }


    public void addPlan(String workingTitle, Plan plan) {

        if (workingTitle == null || plan == null || workingTitle.isBlank()) {
            throw new IllegalArgumentException("Working title and plan must not be empty!");
        }
        planMap.put(workingTitle, plan);
    }

    public Plan getPlanWithMaxSquareMeter() {
        return planMap.values().stream().max(Comparator.comparing(Plan::calculateSquareMeter)).orElseThrow(()-> new IllegalArgumentException("No max."));
    }

    public Plan getPlanByWorkingTitle(String workingTitle) {
        if (workingTitle == null || workingTitle.isBlank()) {
            throw new IllegalArgumentException("Working title must not be empty!");
        }
        Plan plan = planMap.get(workingTitle);
        if (plan == null) {
            throw new IllegalArgumentException("No such project.");
        }
        return plan;
    }

    public Plan getPlanByProjectName(String projectName) {
        if (projectName == null || projectName.isBlank()) {
            throw new IllegalArgumentException("Project name must not be empty!");
        }
        return planMap.values().stream().filter(plan -> plan.getProjectName().equals(projectName)).findAny().orElseThrow(()-> new IllegalArgumentException("No such project."));
    }

    public List<Plan> getSmallerPlans(int area) {
        return planMap.values().stream().filter(plan -> plan.calculateSquareMeter() < area).collect(Collectors.toList());
    }

    public List<Plan> getListOfPlansByPlanType(PlanType planType) {
        if (planType == null) {
            throw new IllegalArgumentException("Parameter must not be null!");
        }
        return planMap.values().stream().filter(plan -> plan.getType() == planType).collect(Collectors.toList());
    }
}
