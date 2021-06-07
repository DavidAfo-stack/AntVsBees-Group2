package Test;

import ants.HungryAnt;
import core.Place;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HungryAntTest {

    /**
     * David Afolabi
     */
    private HungryAnt hungryAnt;
    private Place hungryAntPlace;

    @BeforeEach
    void setUp() {
        hungryAnt = new HungryAnt();
        hungryAntPlace = new Place("hungry-ant-place");
    }

    @AfterEach
    void tearDown() {
        hungryAnt = null;
    }

    /**
     * test for the amor value of hungry ant
     */
    @Test
    void getArmorOfHungryAnt() {
       assertSame(1, hungryAnt.getArmor());
    }

    /**
     * test for the foodcost of hungry ant
     */

    @Test
    void getFoodCostOfHungryAnt() {
        assertSame(4, hungryAnt.getFoodCost());
    }

    /**
     * test to check if the hungry ant is unique
     */
    @Test
    void checkIfHungryAntIsUnique() {
        assertFalse(hungryAnt.unique);
    }

    /**
     * check if hungry ant can double its damage value through the buff feature
     */
    @Test
    void checkIfHungryAntCanBuff() {
        assertFalse(hungryAnt.buff);
    }

    /**
     * check the place of the hungry ant
     */
    @Test
    void checkPlaceOfHungryAnt() {
        hungryAnt.setPlace(hungryAntPlace);
        assertSame(hungryAntPlace, hungryAnt.getPlace());
    }

    /**
     * test to verify the place name of the hungry ant
     */
    @Test
    void checkPlaceNameOfHungryAnt() {
        assertSame("hungry-ant-place", hungryAntPlace.getName());
    }

}