package ee.joel.decathlon.service

import ee.joel.decathlon.model.Score
import spock.lang.Specification

import static ee.joel.decathlon.model.Event.*

class ScoreCalculatorTest extends Specification {

    def "calculates correct points"() {
        given:
        def calculator = new ScoreCalculator();

        expect:
        calculator.calculatePoints(event, result).equals(new Score(points))

        where:
        event                               | result    | points
        HUNDRED_METRES                      | 10.395f   | 1000
        HUNDRED_METRES                      | 10.827f   | 900
        HUNDRED_METRES                      | 11.756f   | 700
        LONG_JUMP                           | 776f      | 1000
        LONG_JUMP                           | 736f      | 900
        LONG_JUMP                           | 694f      | 799
        SHOT_PUT                            | 18.4f     | 1000
        SHOT_PUT                            | 16.79f    | 900
        SHOT_PUT                            | 13.53f    | 700
        HIGH_JUMP                           | 220f      | 992
        HIGH_JUMP                           | 210f      | 896
        HIGH_JUMP                           | 188f      | 696
        FOUR_HUNDRED_METRES                 | 46.17f    | 1000
        FOUR_HUNDRED_METRES                 | 48.19f    | 900
        FOUR_HUNDRED_METRES                 | 52.58f    | 700
        ONE_HUNDRED_AND_TEN_METRES_HURDLES  | 13.8f     | 1000
        ONE_HUNDRED_AND_TEN_METRES_HURDLES  | 14.59f    | 900
        ONE_HUNDRED_AND_TEN_METRES_HURDLES  | 16.29f    | 700
        DISCUS_THROW                        | 56.17f    | 1000
        DISCUS_THROW                        | 51.4f     | 900
        DISCUS_THROW                        | 41.72f    | 700
        POLE_VAULT                          | 528f      | 998
        POLE_VAULT                          | 496f      | 898
        POLE_VAULT                          | 429f      | 699
        JAVELIN_THROW                       | 77.19f    | 1000
        JAVELIN_THROW                       | 70.67f    | 900
        JAVELIN_THROW                       | 57.45f    | 700
        ONE_POINT_FIVE_KILOMETERS           | 233.79f   | 1000
        ONE_POINT_FIVE_KILOMETERS           | 247.42f   | 900
        ONE_POINT_FIVE_KILOMETERS           | 276.96f   | 700
    }


}
