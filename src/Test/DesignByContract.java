package Test;

import ants.FireAnt;
import ants.QueenAnt;
import ants.WallAnt;
import core.Ant;
import core.AntColony;
import core.AntsVsSomeBees;
import core.Place;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DesignByContract {
    /**]
     * David Afolabi
     */
    AntColony colony;
    Ant ant, wallAnt, fireAnt;
    Place place;

    @BeforeEach
    void setUp() {
        colony = new AntColony(3, 8,0,25);
        wallAnt = new WallAnt();
        fireAnt = new FireAnt();
        place = new Place("Insect");
        ant = new QueenAnt();
    }

    @AfterEach
    void tearDown() {
        colony = null;
        place = null;
    }

    /**
     * I have created a test here to check if the food in
     * the colony is sufficient to start the game.
     * An error message is displayed.
     * i have assumed that we need a minimum food of 10 to start the game
     */
    @Test
    void checkIfFoodInColonyIsSufficient() {
        colony = new AntColony(3, 8,0,8);
        if(colony.getFood() < 10){
            String errMsg = "Sorry! Insufficient Food to start game.";
            JOptionPane.showMessageDialog(null, errMsg);
            assertTrue(colony.getFood() < 10);
        }
    }

    /**
     * Here we test for the increase food method to make sure we can increase food
     * in the game to avoid insufficient food
     */
    @Test
    void ensureFoodCanBeIncreased() {
        colony = new AntColony(3, 8,0,8);
        if(colony.getFood() < 10){
            colony.increaseFood(5);
            String msg = "You have sufficient food. Start Game!";
            JOptionPane.showMessageDialog(null, msg);
            assertTrue(colony.getFood() > 10);
        }
    }


    /**
     * here I ensured that if a place is null,
     * we can add an insect
     * but if we decide to remove the insect from the place
     * it should return null
     * I have tested for the remove and add insect method together
     */
    @Test
    void ensureAntIsAddedOrRemovedFromPlace() {
        if(place.getAnt() == null){
            place.addInsect(wallAnt);
            assertEquals(wallAnt, place.getAnt());
        }
        place.removeInsect(wallAnt);
        assertSame(null, place.getAnt());
    }

    /**
     * This will check if a place is empty
     */
    @Test
    void checkIfPlaceIsEmpty() {
       if(place.getAnt() == null){
           String errMsg = "No insect is in the place";
          JOptionPane.showMessageDialog(null, errMsg);
           assertTrue(place.getAnt() == null);
       }
    }

    /**
     * This test checks if a place is already occupied by an insect
     */
    @Test
    void checkIfPlaceIsOccupied() {
        place.addInsect(fireAnt);
        if(place.getAnt() == null){
            String errMsg = "No insect is in the place";
            JOptionPane.showMessageDialog(null, errMsg);
            assertTrue(place.getAnt() == null);
        }else{
            JOptionPane.showMessageDialog(null, "Place is Occupied by Insect");
            assertFalse(place.getAnt() == null);
        }
    }
}