package tech.method.tourney.core.competitor.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Competitor {

    private String name;

    private Integer age;

    private Double weight;

    private BeltGrade beltGrade;

    private Boolean seed;
}
