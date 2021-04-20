package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ants.ScubaThrowerAnt;
import core.Place;

class ScubaThrowerAntTest {

	// Niall French-Smith
	
	private ScubaThrowerAnt scubaThrowerAnt;
	private Place scubaThrowerAntPlace;
	private Place waterPlace;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		scubaThrowerAnt = new ScubaThrowerAnt(); // costs 5 food, has 1 armour, cannot swim, and can overlay
		scubaThrowerAntPlace = new Place("ant's-place");
		scubaThrowerAnt.setPlace(scubaThrowerAntPlace);
		
		waterPlace = new Place("water-place"); // Create a new place
		waterPlace.setWater(true); // Set the water place to be full of water
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		scubaThrowerAnt = null;
		scubaThrowerAntPlace = null;
	}

	// Check if the ant's armour value is set correctly.
	@Test
	void armourValueCheck()
	{
		assertEquals(1, scubaThrowerAnt.getArmor());
	}
	
	// Check if the ant's food cost is set correctly.
	@Test
	void foodCostCheck()
	{
		assertEquals(5, scubaThrowerAnt.getFoodCost());
	}
	
	// Check if the ant's place matches
	@Test
	void placeCheck()
	{
		assertEquals("ant's-place", scubaThrowerAnt.getPlace().getName());
	}
	
	// Check if the ant is meant to be unique
	@Test
	void checkUnique()
	{
		assertFalse(scubaThrowerAnt.unique);
	}
	
	// Check the ant's buff value
	@Test
	void checkBuffValue()
	{
		// bodyguardAnt.buff = true; // Use this to make the below test fail.
		
		assertFalse(scubaThrowerAnt.buff);
	}
	
	@Test
	void checkWaterPlace()
	{
		waterPlace.addInsect(scubaThrowerAnt);
	}
}
