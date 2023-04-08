package tech.method.tourney.core.competitor.internal.usecase;
import tech.method.tourney.core.competitor.api.model.BeltGrade;
import tech.method.tourney.core.competitor.api.model.Competitor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CompetitorParser {

    private static final String CSV_DELIMITER = ";";

    public static List<Competitor> parse(InputStream inputStream) {
        List<Competitor> competitors = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(CSV_DELIMITER);

                if(values[0].equals("NAME")) {
                    continue;
                }

                String name = values[0];
                Integer age = Integer.parseInt(values[1]);
                Double weight = Double.parseDouble(values[2]);
                BeltGrade beltGrade = BeltGrade.valueOf(values[3]);
                Boolean seed = Boolean.parseBoolean(values[4]);

                Competitor competitor = new Competitor(name, age, weight, beltGrade, seed);
                competitors.add(competitor);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return competitors;
    }
}

