package Test;

import ants.SlowAnt;
import core.Ant;
import core.Place;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlowAntTest {
    /**
     * David Afolabi
     */
    Ant slowAnt;
    Place slowAntPlace;

    @BeforeEach
    void setUp() {
        slowAnt = new SlowAnt();
        slowAntPlace = new Place("slow");
    }

    @AfterEach
    void tearDown() {
        slowAnt = null;
        slowAntPlace = null;
    }

    /**
     * this check the armor of the slow thrower ant
     */

    @Test
    void checkIflongThrowerAntArmorIsGreaterThanOne() {
        assertTrue(slowAnt.getArmor()>0);
    }

    /**
     * this will check the armor value of the slow thrower ant
     */
    @Test
    void getArmorValue() {
        assertSame(1, slowAnt.getArmor());
    }

    /**
     * test to check the place of the slow thrower ant
     */
    @Test
    void checkIfPlaceIsNotNull(){
        slowAnt.setPlace(slowAntPlace);
        assertNotNull(slowAnt.getPlace());
    }

    /**
     * when the slow thrower ant is not in a place and no ant occupies the place
     * the place should be null in this case
     */
    @Test
    void checkIfPlaceIsNull(){
        assertNull(slowAnt.getPlace());
    }
    /**
     * test to get the food cost of slow thrower ant
     */
    @Test
    void getFoodCostOFThrowerAnt(){
        assertSame(4, slowAnt.getFoodCost());
    }

    /**
     * check if slow thrower ant is unique
     */
    @Test
    void checkIfThrowerAntIsUnique(){
        assertFalse(slowAnt.unique);
    }
    /**
     * this will check if the slow thrower ant can double its damage
     */
    @Test
    void checkIfAntCanBuff() {
        assertFalse(slowAnt.buff);
    }
}