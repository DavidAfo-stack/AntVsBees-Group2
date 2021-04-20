package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ants.QueenAnt;
import core.Place;

class QueenAntTest {

	// Niall French-Smith
	
	private QueenAnt queenAnt;
	private QueenAnt entranceAnt;
	private QueenAnt exitAnt;
	private Place queenAntPlace;
	private Place exit;
	private Place entrance;
	private Place waterPlace;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		queenAnt = new QueenAnt(); // costs 5 food, has 1 armour, can swim, cannot overlay and is unique.
		entranceAnt = new QueenAnt();
		exitAnt = new QueenAnt();
		
		queenAntPlace = new Place("ant's-place");
		queenAnt.setPlace(queenAntPlace);
		
		exit = new Place("queen's-exit");
		entrance = new Place("queen's-entrance");
		waterPlace = new Place ("water-place");
		
		entranceAnt.setPlace(entrance);
		exitAnt.setPlace(exit);
		entrance.addInsect(entranceAnt);
		exit.addInsect(exitAnt);
		waterPlace.setWater(true);
		
		queenAntPlace.setEntrance(entrance);
		queenAntPlace.setExit(exit);
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		queenAnt = null;
		queenAntPlace = null;
	}

	// Check if the ant's armour value is set correctly.
	@Test
	void armourValueCheck()
	{
		assertEquals(1, queenAnt.getArmor());
	}
	
	// Check if the ant's food cost is set correctly.
	@Test
	void foodCostCheck()
	{
		assertEquals(5, queenAnt.getFoodCost());
	}
	
	// Check if the ant's place matches
	@Test
	void placeCheck()
	{
		assertEquals("ant's-place", queenAnt.getPlace().getName());
	}
	
	// Check if the ant is meant to be unique
	@Test
	void checkUnique()
	{
		assertTrue(queenAnt.unique);
	}
	
	// Check the ant's buff value
	@Test
	void checkBuffValue()
	{
		// queenAnt.buff = true; // Use this to make the below test fail.
		
		assertFalse(queenAnt.buff);
	}
	
	// Test if the queen's Setbuff method works.
	@Test
	void checkBuffMethod()
	{
		queenAnt.SetBuffs(); // Commenting this out will make this test fail
		
		assertTrue(entrance.getAnt().buff);
		assertTrue(exit.getAnt().buff);
	}
	
	@Test
	void checkWaterPlace()
	{
		waterPlace.addInsect(queenAnt);
		
		assertEquals(waterPlace.getAnt(), queenAnt);
	}

}