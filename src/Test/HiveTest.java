package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import core.Hive;

class HiveTest {

	// Niall French-Smith
	
	private Hive hive;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		hive = new Hive(3);
		
		hive.addWave(1, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void getAllBees() 
	{
		
	}

}
