package Test;

import static org.junit.jupiter.api.Assertions.*;

import ants.BodyguardAnt;
import core.Place;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BodyguardAntTest {

	// Niall French-Smith
	
	private BodyguardAnt bodyguardAnt;
	private Place bodyguardAntPlace;
	private Place waterPlace;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		bodyguardAnt = new BodyguardAnt(); // costs 4 food, has 2 armour, cannot swim, and can overlay
		bodyguardAntPlace = new Place("ant's-place");
		bodyguardAnt.setPlace(bodyguardAntPlace);
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		bodyguardAnt = null;
		bodyguardAntPlace = null;
	}

	// Check if the ant's armour value is set correctly.
	@Test
	void armourValueCheck()
	{
		assertEquals(2, bodyguardAnt.getArmor());
	}
	
	// Check if the ant's food cost is set correctly.
	@Test
	void foodCostCheck()
	{
		assertEquals(4, bodyguardAnt.getFoodCost());
	}
	
	// Check if the ant's place matches
	@Test
	void placeCheck()
	{
		assertEquals("ant's-place", bodyguardAnt.getPlace().getName());
	}
	
	// Check if the ant is meant to be unique
	@Test
	void checkUnique()
	{
		assertFalse(bodyguardAnt.unique);
	}
	
	// Check the ant's buff value
	@Test
	void checkBuffValue()
	{
		// bodyguardAnt.buff = true; // Use this to make the below test fail.
		
		assertFalse(bodyguardAnt.buff);
	}
	
	// Check if the ant should be able to appear/be placed over other ants.
	@Test
	void checkOverlay()
	{
		// This should return true, i don't understand why it doesn't, it works as intended in the actual game
		
		assertTrue(bodyguardAnt.overlays);
	}
	
	@Test
	void checkWaterPlace()
	{
		waterPlace.addInsect(bodyguardAnt);
	}
}
