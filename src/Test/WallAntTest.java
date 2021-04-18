package Test;

import ants.FireAnt;
import ants.WallAnt;
import core.Ant;
import core.AntColony;
import core.Bee;
import core.Place;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WallAntTest {
    /**
     * Author: David Afolabi
     */
    private WallAnt wallAnt;
    private Place wallAntPlace;

    @BeforeEach
    void setUp() {
        wallAnt = new WallAnt();
        wallAntPlace = new Place("wall-ant-place");
    }

    @AfterEach
    void tearDown() {
        wallAnt = null;
    }

    /**
     * test if wall ant blocks the path of a bee
     */

    @Test
    void checkIfWallAntBlocksBee(){
        assertTrue(wallAnt.getBlockBeeAttribute());
    }

    /**
     * test for the armor of the wall ant
     */
    @Test
    void getArmorOfWallAnt() {
        assertEquals(4, wallAnt.getArmor());
    }

    /**
     * test for the food cost of the wall ant
     */
    @Test
    void getFoodOfWallAnt() {
        assertEquals(4, wallAnt.getFoodCost());
    }
    /**
     * test to reduce the armor of the wall ant
     */
    @Test
    void reduceArmorOfWallAnt() {
        wallAnt.reduceArmor(1);
        assertEquals(3, wallAnt.getArmor());
    }

    /**
     * test for the place of wall ant
     */
    @Test
    void getPlaceOfWallAnt() {
        wallAnt.setPlace(wallAntPlace);
        assertSame(wallAntPlace, wallAnt.getPlace());
    }
    /**
     * check the place name for the wall ant
     */
    @Test
    void checkWallAntPlaceName() {
        assertEquals("wall-ant-place", wallAntPlace.getName());
    }

    /**
     * check is wall ant is unique
     */
    @Test
    void checkIfWallAntIsUnique() {
        assertFalse(wallAnt.unique);
    }

    /**
     * check is wall ant can buff i.e the wall ant can perform double damage
     */
    @Test
    void checkIfWallAntCanBuff() {
        assertFalse(wallAnt.buff);
    }

    /**
     * test to check if armor is reduced
     */
    @Test
    void checkIfAntArmorIsReduced() {
        wallAnt.reduceArmor(2);
        assertSame(2, wallAnt.getArmor());
    }

}