package Test;

import ants.ShortThrowerAnt;
import core.Ant;
import core.Place;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShortThrowerAntTest {
    /**
     * David Afolabi
     */
    Ant shortThrower;
    Place shortThrowerPlace;

    @BeforeEach
    void setUp() {
        shortThrower = new ShortThrowerAnt();
        shortThrowerPlace = new Place("short-thrower-place");
    }

    @AfterEach
    void tearDown() {
        shortThrower = null;
        shortThrowerPlace = null;
    }

    /**
     * this check the armor of the short thrower ant
     */

    @Test
    void checkIflongThrowerAntArmorIsGreaterThanOne() {
        assertTrue(shortThrower.getArmor()>0);
    }

    /**
     * this will check the armor value of the short thrower ant
     */
    @Test
    void getArmorValue() {
        assertSame(1, shortThrower.getArmor());
    }

    /**
     * test to check the place of the short thrower ant
     */
    @Test
    void checkIfPlaceIsNotNull(){
        shortThrower.setPlace(shortThrowerPlace);
        assertNotNull(shortThrower.getPlace());
    }

    /**
     * when the short thrower ant is not in a place and no ant occupies the place
     * the place should be null in this case
     */
    @Test
    void checkIfPlaceIsNull(){
        assertNull(shortThrower.getPlace());
    }
    /**
     * test to get the food cost of short thrower ant
     */
    @Test
    void getFoodCostOFThrowerAnt(){
        assertSame(3, shortThrower.getFoodCost());
    }

    /**
     * check if short thrower ant is unique
     */
    @Test
    void checkIfThrowerAntIsUnique(){
        assertFalse(shortThrower.unique);
    }
    /**
     * this will check if the short thrower ant can double its damage
     */
    @Test
    void checkIfAntCanBuff() {
        assertFalse(shortThrower.buff);
    }
}