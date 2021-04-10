package hu.nive.ujratervezes.kepesitovizsga.rabbitsandeggs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Eggs {


    public Rabbit getRabbitWithMaxEggs() {

        List<Rabbit> rabbits = loadFromFile();

        return rabbits.stream().max(Comparator.comparing(Rabbit::getEggs)).orElseThrow(() -> new IllegalArgumentException("Cannot find"));
    }

    private List<Rabbit> loadFromFile() {
        List<Rabbit> rabbits = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Eggs.class.getResourceAsStream("/eggs.csv")))){
            String line;
            while ((line = reader.readLine()) != null) {
                rabbits.add(new Rabbit(line));
            }

        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file");
        }
        return rabbits;
    }
}
