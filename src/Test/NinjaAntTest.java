package Test;

import ants.NinjaAnt;
import core.Place;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NinjaAntTest {
    /**
     * David Afolabi
     */
    private NinjaAnt ninja;
    private Place ninjaAntPlace;

    @BeforeEach
    void setUp() {
        ninja = new NinjaAnt();
        ninjaAntPlace = new Place("ninja-ant-place");
    }

    @AfterEach
    void tearDown() {
       ninja = null;
    }

    /**
     * test to get damage value of ninja ant
     */

    @Test
    void checkDamageValueOfNinjaAnt() {
       assertSame(1, ninja.getDamageValue());
    }


    /**
     * check if the Ninja ant blocks the path of a Bee
     */

    @Test
    void checkIfNinjaAntBlocksBee() {
        assertFalse(ninja.getBlockBeeAttribute());
    }

    /**
     * Test to get food cost of Ninja Ant
     */
    @Test
    void getFoodCostOfNinjaAnt() {
        assertSame(6, ninja.getFoodCost());
    }

    /**
     * test to validate the place of a Ninja Ant
     */

    @Test
    void getPlaceOfNinajaAnt() {
        ninja.setPlace(ninjaAntPlace);
        assertNotNull(ninja.getPlace());
        assertSame(ninjaAntPlace ,ninja.getPlace());
    }

    /**
     * test to check the name of the place for Ninja ant
     */
    @Test
    void checkPlaceName() {
        assertSame("ninja-ant-place", ninjaAntPlace.getName());
    }

    /**
     * check if Ninja ant is unique
     */

    @Test
    void checkIfUnique() {
        assertFalse(ninja.unique);
    }
}