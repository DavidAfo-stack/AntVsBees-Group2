package Test;

import ants.LongThrowerAnt;
import core.Ant;
import core.Place;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongThrowerAntTest {
    /**
     * David Afolabi
     */
    Ant longThrower;
    Place longThrowerPlace;

    @BeforeEach
    void setUp() {
        longThrower = new LongThrowerAnt();
        longThrowerPlace = new Place("long-thrower-ant");
    }

    @AfterEach
    void tearDown() {
        longThrower = null;
        longThrowerPlace = null;
    }

    /**
     * this check the armor of the long thrower ant
     */

    @Test
    void checkIflongThrowerAntArmorIsGreaterThanOne() {
        assertTrue(longThrower.getArmor()>0);
    }

    /**
     * this will check the armor value of the long thrower ant
     */
    @Test
    void getArmorValue() {
        assertSame(1, longThrower.getArmor());
    }

    /**
     * test to check the place of the long thrower ant
     */
    @Test
    void checkIfPlaceIsNotNull(){
        longThrower.setPlace(longThrowerPlace);
        assertNotNull(longThrower.getPlace());
    }

    /**
     * when the long thrower ant is not in a place and no ant occupies the place
     * the place should be null in this case
     */
    @Test
    void checkIfPlaceIsNull(){
        assertNull(longThrower.getPlace());
    }
    /**
     * test to get the food cost of long thrower ant
     */
    @Test
    void getFoodCostOFThrowerAnt(){
        assertSame(3, longThrower.getFoodCost());
    }

    /**
     * check if long thrower ant is unique
     */
    @Test
    void checkIfThrowerAntIsUnique(){
        assertFalse(longThrower.unique);
    }
    /**
     * this will check if the long thrower ant can double its damage
     */
    @Test
    void checkIfAntCanBuff() {
        assertFalse(longThrower.buff);
    }
}