package Test;

import core.AntColony;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AntColonyTest {
    /**
     * David Afolabi
     */
    private AntColony antColony;

    @BeforeEach
    void setUp() {
        antColony = new AntColony(3, 8, 2, 20);
    }

    @AfterEach
    void tearDown() {
        antColony = null;
    }

    /**
     * checks the available food in the ant colony
     */
    @Test
    void checkTheAvailableFoodInTheAntColony() {
        assertEquals(20, antColony.getFood());
    }

    /**
     * increase the food of the ant colony and test using the increase food method
     */

    @Test
    void checkIfFoodIncreases() {
        antColony.increaseFood(5);
        assertEquals(25, antColony.getFood());
    }

    /**
     * this is used to check the speed of the antcolony
     */
    @Test
    void getSpeedOfAntColony() {
        assertEquals(2, antColony.getSpeed());
    }
}