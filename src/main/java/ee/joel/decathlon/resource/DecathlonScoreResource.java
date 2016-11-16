package ee.joel.decathlon.resource;

import ee.joel.decathlon.model.Result;
import ee.joel.decathlon.model.Score;
import ee.joel.decathlon.service.ScoreCalculator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/decathlon")
public class DecathlonScoreResource {

    private ScoreCalculator scoreCalculator;

    public DecathlonScoreResource(ScoreCalculator scoreCalculator) {
        this.scoreCalculator = scoreCalculator;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response indexPage(Result result) {
        Score score = scoreCalculator.calculatePoints(result.getEvent(), result.getResultValue());
        return Response.ok(score).build();
    }
}
