package ee.joel.decathlon.acceptancetest.configuration.module;

import dagger.Module;
import dagger.Provides;
import ee.joel.decathlon.acceptancetest.actor.VisitorActor;
import ee.joel.decathlon.service.ScoreCalculator;

@Module
public class ActorsModule {

    @Provides
    public VisitorActor visitorActor(ScoreCalculator scoreCalculator){
        return new VisitorActor(scoreCalculator);
    }

}
