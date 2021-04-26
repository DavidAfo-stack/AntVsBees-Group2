package Test;

import static org.junit.jupiter.api.Assertions.*;

import core.Bee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import core.Hive;

import javax.swing.*;

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
		hive = null;
	}
    //David Afolabi
	//by default exit is set to null
	@Test
	void getExit()
	{
		assertNull(hive.getExit());
	}
    // David
	//the number of bees is set to 1
	// we can assert that the hive is not null
	@Test
	void getAllBees()
	{
		assertNotNull(hive.getAllBees());
	}

	/**
	 * David
	 * Another way to test if the hive is occupied or empty
	 */
	@Test
	void checkHiveOccupancy()
	{
		hive.addWave(1, 0);
		if(hive.getAllBees().length > 0){
			JOptionPane.showMessageDialog(null,"Hive is occupied!");
			assertNotEquals(0, hive.getAllBees().length);
		}
		else{
			JOptionPane.showMessageDialog(null,"Hive is Empty!");
			assertSame(0,hive.getAllBees().length);
		}
	}

}
