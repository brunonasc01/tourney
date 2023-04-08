package tech.method.tourney.core.competitor.api.usecase;

import tech.method.tourney.core.competitor.api.model.Competitor;

import java.io.InputStream;
import java.util.List;

public interface RetrieveCompetitor {

    List<Competitor> execute(InputStream inputStream);
}
