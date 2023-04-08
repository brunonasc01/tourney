package tech.method.tourney.core.competitor.internal.usecase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tech.method.tourney.core.competitor.api.usecase.RetrieveCompetitor;
import tech.method.tourney.core.internal.configuration.TourneyCoreConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(initializers = ConfigDataApplicationContextInitializer.class, classes = {TourneyCoreConfiguration.class})
public class DefaultRetrieveCompetitorTest {

    @Autowired
    RetrieveCompetitor retrieveCompetitor;


    @Test
    void testRetrieveCompetitors() {
        InputStream csvData = this.getFile("competitors.csv");
        Assertions.assertEquals(2,this.retrieveCompetitor.execute(csvData).size());
    }

    private InputStream getFile(String filename) {
        try {
            File file = new ClassPathResource(filename).getFile();
            return new FileInputStream(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
