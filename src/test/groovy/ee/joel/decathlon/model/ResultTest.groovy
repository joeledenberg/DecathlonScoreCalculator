package ee.joel.decathlon.model

import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.containsString

class ResultTest extends Specification {

    def mapper = new ObjectMapper();

    def "can serialize result"() {
        given:
        def result = new Result(Event.DISCUS_THROW, 10f);

        expect:

        assertThat(mapper.writeValueAsString(result), containsString("{\"event\":\"DISCUS_THROW\",\"result\":10.0}"))
    }

}
