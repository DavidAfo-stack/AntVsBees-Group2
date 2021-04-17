package ants;

import core.Ant;
import core.AntColony;

/**
 * An Ant that harvests food
 * @author YOUR NAME HERE
 */
public class HarvesterAnt extends Ant
{
	/**
	 * Creates a new Harvester Ant
	 */
	
	public HarvesterAnt()
	{
		super(1, 2);
		System.out.println("Is this ant a priority? " + priority);
	}

	public void action(AntColony colony)
	{
		colony.increaseFood(1);
		
		//TODO: Should produce one additional food for the colony		
	}
}
