package hu.nive.ujratervezes.kepesitovizsga.rabbitsandeggs;

public class Rabbit {

    private String name;

    private int eggs;

    public Rabbit(String name, int eggs) {
        this.name = name;
        this.eggs = eggs;
    }

    public Rabbit(String line) {
        String[] parts = line.split(";");
        this.name = parts[0];
        this.eggs = Integer.parseInt(parts[1]);
    }

    public String getName() {
        return name;
    }

    public int getEggs() {
        return eggs;
    }
}
