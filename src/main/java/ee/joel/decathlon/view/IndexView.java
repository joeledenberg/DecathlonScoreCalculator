package ee.joel.decathlon.view;

import ee.joel.decathlon.model.Event;
import io.dropwizard.views.View;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class IndexView extends View {

    public IndexView() {
        super("index.ftl");
    }

    public List<Event> getEvents() {
        return newArrayList(Event.values());
    }

}