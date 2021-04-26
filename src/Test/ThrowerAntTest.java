package Test;

import ants.ThrowerAnt;
import core.Place;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThrowerAntTest {
    /**#
     * David Afolabi
     */
    private ThrowerAnt throwerAnt;
    private Place throwerAntPlace;

    @BeforeEach
    void setUp() {
        throwerAnt = new ThrowerAnt();
        throwerAntPlace = new Place("thrower-ant-place");
    }

    @AfterEach
    void tearDown() {
        throwerAnt = null;
        throwerAntPlace = null;
    }

    /**
     * test to get the damage value of thrower ant
     */
    @Test
    void getDamageValueOfThrowerAnt() {
        assertEquals(1, throwerAnt.getDamageValue());
    }

    /**
     * test to check the place of the thrower ant
     */
    @Test
    void checkIfPlaceIsNotNull(){
        throwerAnt.setPlace(throwerAntPlace);
       assertNotNull(throwerAnt.getPlace());
    }

    /**
     * when the thrower ant is not in a place and no ant occupies the place
     * the place should be null in this case
     */
    @Test
    void checkIfPlaceIsNull(){
        assertNull(throwerAnt.getPlace());
    }
    /**
     * test to get the food cost of thrower ant
     */
    @Test
    void getFoodCostOFThrowerAnt(){
       assertSame(4, throwerAnt.getFoodCost());
    }

    /**
     * test to check if the thrower ant blocks the bee
     */
    @Test
    void checkIfItBlocksBee(){
        assertTrue(throwerAnt.getBlockBee());
    }

    /**
     * check if thrower ant is unique
     */
    @Test
    void checkIfThrowerAntIsUnique(){
        assertFalse(throwerAnt.unique);
    }


}