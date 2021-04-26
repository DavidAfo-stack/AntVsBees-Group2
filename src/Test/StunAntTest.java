package Test;

import ants.StunAnt;
import core.Ant;
import core.Place;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StunAntTest {
    /**
     * David Afolabi
     */
    Ant stunAnt;
    Place stunAntPlace;

    @BeforeEach
     void setUp() {
        stunAnt = new StunAnt();
        stunAntPlace = new Place("stun-ant-place");
    }

    @AfterEach
    void tearDown() {
        stunAnt = null;
        stunAntPlace = null;
    }

    /**
     * this check the armor of the stun thrower ant
     */

    @Test
    void checkIflongThrowerAntArmorIsGreaterThanOne() {
        assertTrue(stunAnt.getArmor()>0);
    }

    /**
     * this will check the armor value of the stun thrower ant
     */
    @Test
    void getArmorValue() {
        assertSame(1, stunAnt.getArmor());
    }

    /**
     * test to check the place of the stun thrower ant
     */
    @Test
    void checkIfPlaceIsNotNull(){
        stunAnt.setPlace(stunAntPlace);
        assertNotNull(stunAnt.getPlace());
    }

    /**
     * when the stun thrower ant is not in a place and no ant occupies the place
     * the place should be null in this case
     */
    @Test
    void checkIfPlaceIsNull(){
        assertNull(stunAnt.getPlace());
    }
    /**
     * test to get the food cost of stun thrower ant
     */
    @Test
    void getFoodCostOFThrowerAnt(){
        assertSame(6, stunAnt.getFoodCost());
    }

    /**
     * check if stun thrower ant is unique
     */
    @Test
    void checkIfThrowerAntIsUnique(){
        assertFalse(stunAnt.unique);
    }
    /**
     * this will check if the stun thrower ant can double its damage
     */
    @Test
    void checkIfAntCanBuff() {
        assertFalse(stunAnt.buff);
    }
}