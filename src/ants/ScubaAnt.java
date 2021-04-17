package ants;

import core.Ant;

public abstract class ScubaAnt extends Ant
{
	// Author: Niall French-Smith
	// 2021
	
	/*
	 * This is essentially a separate super class, which is derived from the ant class
	 * It is to be used as the super class of the ants that can be placed in water spots.
	 * This has been made obsolete as the scuba thrower ant now inherits from the thrower ant class, which was more convenient
	 * 
	 * I have left this in as reference to what I attempted, this will likely be removed at some point.
	 */
	
    protected int damage;

    public ScubaAnt(int armor, int food, boolean canSwim) 
    {
        super(armor, food, canSwim);
        this.damage = 3;
    }
}
