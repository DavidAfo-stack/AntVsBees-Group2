package Test;

import core.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeeTest {
    /**
     * David Afolabi
     */
    private Bee bee;
    private Place place;

    @BeforeEach
    void setUp() {
        /**
         * set up new places
         */
        place = new Place("Bee-Place");
        /**
         *  add bees to the array
         */
        bee = new Bee(4);

    }

    @AfterEach
    void tearDown() {
        bee = null;
        place = null;
    }
    /**
     * this tests the method showing the place where the bee is located
     */
    @Test
    void getThePlaceOfABee() {
        bee.setPlace(place);
        assertEquals(place, bee.getPlace());
    }

    /**
     * checks if a bee is blocked by an ant
     * here we set the bee to replace the ant in place1
     */
    @Test
    void checkIfABeeIsBlocked() {
        bee.setPlace(place);
       assertFalse(bee.isBlocked());
    }

    /**
     * checks if the bee armor has been reduced
     */
    @Test
    void checkIfBeeArmorIsReduced() {
        bee.reduceArmor(2);
        assertEquals(2, bee.getArmor());
    }

    /**
     * check the name of the place the bee is located
     */

    @Test
    void confirmNameOfBeePlace() {
        assertEquals("Bee-Place", place.getName());
    }
}