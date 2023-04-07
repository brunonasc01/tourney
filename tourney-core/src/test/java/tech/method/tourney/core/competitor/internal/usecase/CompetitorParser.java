package tech.method.tourney.core.competitor.internal.usecase;
import tech.method.tourney.core.competitor.api.model.BeltGrade;
import tech.method.tourney.core.competitor.api.model.Competitor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CompetitorParser {
    private final String filePath;

    public CompetitorParser(String filePath) {
        this.filePath = filePath;
    }

    public List<Competitor> parse() throws IOException {
        List<Competitor> competitors = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                String name = values[0];
                Integer age = Integer.parseInt(values[1]);
                Double weight = Double.parseDouble(values[2]);
                BeltGrade beltGrade = BeltGrade.valueOf(values[3]);
                Boolean seed = Boolean.parseBoolean(values[4]);

                Competitor competitor = new Competitor(name, age, weight, beltGrade, seed);
                competitors.add(competitor);
            }
        }

        return competitors;
    }
}

