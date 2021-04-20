package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ants.HarvesterAnt;
import core.AntColony;
import core.Place;

class HarvesterAntTest {

	// Niall French-Smith
	
	private HarvesterAnt harvesterAnt;
	private Place harvesterAntPlace;
	private AntColony colony;
	private Place waterPlace;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		colony = new AntColony(1, 1, 0, 0);
		harvesterAnt = new HarvesterAnt(); // costs 2 food, has 1 armour, cannot swim, and cannot overlay
		harvesterAntPlace = new Place("ant's-place");
		harvesterAnt.setPlace(harvesterAntPlace);
		
		waterPlace = new Place("water-place");
		waterPlace.setWater(true);
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		harvesterAnt = null;
		harvesterAntPlace = null;
	}

	@Test
	void armourValueCheck()
	{
		assertEquals(1, harvesterAnt.getArmor());
	}
	
	@Test
	void foodCostCheck()
	{
		assertEquals(2, harvesterAnt.getFoodCost());
	}
	
	@Test
	void placeCheck()
	{
		assertEquals("ant's-place", harvesterAnt.getPlace().getName());
	}
	
	@Test
	void checkUnique()
	{
		assertFalse(harvesterAnt.unique);
	}
	
	@Test
	void checkBuffValue()
	{
		// bodyguardAnt.buff = true; // Use this to make the below test fail.
		
		assertFalse(harvesterAnt.buff);
	}
	
	@Test
	void checkFoodIncrease()
	{
		harvesterAnt.action(colony);
		
		assertEquals(colony.getFood(), 1);
	}
	
	@Test
	void checkWaterPlace()
	{
		waterPlace.addInsect(harvesterAnt);
	}
}
