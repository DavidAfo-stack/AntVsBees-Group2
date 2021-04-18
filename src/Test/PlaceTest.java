package Test;

import ants.HarvesterAnt;
import ants.HungryAnt;
import ants.NinjaAnt;
import ants.WallAnt;
import core.Ant;
import core.Bee;
import core.Place;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlaceTest {
    /**
     * David Afolabi
     */
    private Place place1, place2, place3, entrance;
    private Ant harvesterAnt, wallAnt, ninjaAnt;

    @BeforeEach
    void setUp() {
        /**
         * set up new places
         */
        place1 = new Place("AntQueen");
        place2 = new Place("WallAnt");
        place3 = new Place("NinjaAnt");
        entrance = new Place("Ant");
       //set up ants
        harvesterAnt = new HarvesterAnt();
        wallAnt = new WallAnt();
        ninjaAnt = new NinjaAnt();
    }

    @AfterEach
    void tearDown() {
        place1 = null;
        place2 = null;
        place3 = null;
        entrance = null;
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
     * checks the name of the place
     */
    @Test
    void checkPlaceName() {
        assertEquals("WallAnt", place2.getName());
    }

    /**
     * checks the name of the place
     */
    @Test
    void getAntsInTunnel() {
        assertEquals("WallAnt", place2.getName());
        System.out.println(place3.getBees());
    }
}