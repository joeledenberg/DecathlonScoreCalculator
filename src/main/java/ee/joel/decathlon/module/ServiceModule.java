package ee.joel.decathlon.module;

import dagger.Module;
import dagger.Provides;
import ee.joel.decathlon.service.ScoreCalculator;

import javax.inject.Singleton;

@Module
public class ServiceModule {

    @Provides
    @Singleton
    ScoreCalculator provideScoreCalculator() {
        return new ScoreCalculator();
    }
}