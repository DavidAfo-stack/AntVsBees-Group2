package Test;

import ants.HarvesterAnt;
import ants.ThrowerAnt;
import ants.WallAnt;
import core.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Ant ant;
    private AntColony antColony;
    private Bee bee1, bee2, bee3, bee4;
    private Place place1, place2, place3, entrance;
    private WallAnt wallAnt;
    private ThrowerAnt throwerAnt;
    private HarvesterAnt harvesterAnt;

    @BeforeEach
    void setUp() {
        /**
         * set up a new place
         */
        place1 = new Place("AntQueen");
        place2 = new Place("WallAnt");
        place3 = new Place("ThrowerAnt");
        entrance = new Place("Bee");
        /**
         *  add bees to the array
         */
        bee1 = new Bee(4);
        bee2 = new Bee(3);
        bee3 = new Bee(5);
        bee4 = new Bee(1);

        /**
         * set up ants
         */
        wallAnt = new WallAnt();
        throwerAnt = new ThrowerAnt();
        harvesterAnt = new HarvesterAnt();

        antColony = new AntColony(3, 8, 0, 5);
    }

    @AfterEach
    void tearDown() {
        ant = null;
        bee1 = null;
        bee2 = null;
        bee3 = null;
        bee4 = null;
        place1 = null;
        place2=null;
        place3=null;
        wallAnt = null;
        throwerAnt=null;
        harvesterAnt = null;
    }
    /**
     * this tests the method showing the place where the bee is located
     */
    @Test
    void getThePlaceOfABee() {
        bee1.setPlace(place1);
        assertEquals(place1, bee1.getPlace());
    }
    /**
     * checks the name of the place
     */
    @Test
    void checkPlaceName() {
        assertEquals("WallAnt", place2.getName());
    }
    /**
     * this is used to check the entrance of an insect
     */
    @Test
    void checkPlaceEntrance() {
        place1.setEntrance(place1);
        assertNotEquals(entrance, place1.getEntrance());
    }
    /**
     * this should assert null because the exit has been set to null in the Place class
     */
    @Test
    void checkPlaceExit() {
        assertNull(place2.getExit());
    }
    /**
     * This checks for the foodCost of an ant
     */
    @Test
    void getTheFoodCostOfAnAnt() {
        assertSame(4, wallAnt.getFoodCost());
    }

    @Test
    void checkIfAntArmorIsReduced() {
        wallAnt.reduceArmor(2);
        assertSame(2, wallAnt.getArmor());
    }

    /**
     * checks if a bee is blocked by an ant
     * here we set the bee to replace the ant in place1
     */
    @Test
    void checkIfABeeIsBlocked() {
        bee1.setPlace(place1);
       assertFalse(bee1.isBlocked());
    }

    /**
     * this checks the particular ant that is in a place
     */
    @Test
    void checkWhichAntIsInAPlace() {
        place3.addInsect(harvesterAnt);
        assertSame(harvesterAnt, place3.getAnt());
    }

    /**
     * checks if the bee armor has been reduced
     */
    @Test
    void checkIfBeeArmorIsReduced() {
        bee3.reduceArmor(2);
        assertEquals(3, bee3.getArmor());
    }

    /**
     * checks the available food in the ant colony
     */
    @Test
    void checkTheAvailableFoodInTheAntColony() {
       assertEquals(5, antColony.getFood());
    }

}