package tech.method.tourney.core.competitor.internal.usecase;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.method.tourney.core.competitor.api.model.Competitor;
import tech.method.tourney.core.competitor.api.usecase.RetrieveCompetitor;

import java.io.InputStream;
import java.util.List;

@Service
@AllArgsConstructor
public class DefaultRetrieveCompetitor implements RetrieveCompetitor {

    @Override
    public List<Competitor> execute(InputStream inputStream) {
        return CompetitorParser.parse(inputStream);
    }
}
