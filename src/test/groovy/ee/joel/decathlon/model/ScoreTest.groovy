package ee.joel.decathlon.model

import spock.lang.Specification

import static org.hamcrest.CoreMatchers.nullValue
import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.containsString

class ScoreTest extends Specification {

    def score;

    def "normal score gives no warnings"() {
        when:
        score = new Score(1000, Event.FOUR_HUNDRED_METRES);

        then:
        assertThat(score.getWarning(), nullValue())
    }

    def "detects too small score and notifies of correct measurement units"() {
        when:
        score = new Score(0, Event.FOUR_HUNDRED_METRES);

        then:
        assertThat(score.getWarning(), containsString("Check measurement units"))
        assertThat(score.getWarning(), containsString("in seconds"))
    }

    def "detects too large score and notifies of correct measurement units"() {
        when:
        score = new Score(3000, Event.FOUR_HUNDRED_METRES);

        then:
        assertThat(score.getWarning(), containsString("Check measurement units"))
        assertThat(score.getWarning(), containsString("in seconds"))
    }
}
