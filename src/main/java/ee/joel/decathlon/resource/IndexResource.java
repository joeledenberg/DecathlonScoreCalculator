package ee.joel.decathlon.resource;

import ee.joel.decathlon.view.IndexView;
import io.dropwizard.views.View;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("/")
public class IndexResource {

    @GET
    public View indexPage() {
        return new IndexView();
    }
}
