package ee.joel.decathlon.module;

import dagger.Module;
import dagger.Provides;
import ee.joel.decathlon.resource.DecathlonScoreResource;
import ee.joel.decathlon.resource.IndexResource;
import ee.joel.decathlon.service.ScoreCalculator;

import javax.inject.Singleton;

@Module
public class ResourceModule {

    @Provides
    @Singleton
    IndexResource provideIndexResource() {
        return new IndexResource();
    }

    @Provides
    @Singleton
    DecathlonScoreResource provideDecathlonScoreResource(ScoreCalculator scoreCalculator) {
        return new DecathlonScoreResource(scoreCalculator);
    }

}