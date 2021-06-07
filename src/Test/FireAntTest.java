package Test;

import ants.FireAnt;
import core.Place;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FireAntTest {
    /**
     * David Afolabi
     */
    private FireAnt fireAnt;
    private Place fireAntPlace;

    @BeforeEach
    void setUp() {
        fireAnt = new FireAnt();
        fireAntPlace = new Place("fire-ant-place");
    }

    @AfterEach
    void tearDown() {
        fireAnt = null;
    }

    /**
     *get amour value of fire ant
     */
    @Test
    void getArmorValueOfFireAnt() {
        assertEquals(1, fireAnt.getArmor());
    }

    /**
     *test for the food cost of fire ant
     */
    @Test
    void getFoodCosOfFireAnt() {
        assertSame(4, fireAnt.getFoodCost());
    }

    /**
     * test the damage value of the fire ant
     */
    @Test
    void getFireAntDamageValue() {
        assertSame(3, fireAnt.getDamageValue());
    }

    /**
     * test for the place of fire ant
     */
    @Test
    void getPlaceOfFireAnt() {
      fireAnt.setPlace(fireAntPlace);
      assertSame(fireAntPlace, fireAnt.getPlace());
    }
    /**
     * check the place name for the fire ant
     */
    @Test
    void checkFireAntPlaceName() {
        assertEquals("fire-ant-place", fireAntPlace.getName());
    }

    /**
     * check is fire ant is unique
     */
    @Test
    void checkIfFireAntIsUnique() {
        assertFalse(fireAnt.unique);
    }

    /**
     * check is wall ant can buff i.e the wall ant can perform double damage
     */
    @Test
    void checkIfFireAntCanBuff() {
        assertFalse(fireAnt.buff);
    }
}