package ants;
import java.util.ArrayList;

import core.Ant;
import core.AntColony;
import core.Bee;

/**
 * An ant who throws leaves at bees
 * @author YOUR NAME HERE
 */
public class ThrowerAnt extends Ant
{
	protected int damage;
	
	/**
	 * Creates a new Thrower Ant.
	 * Armor: 1, Food: 0, Damage: 1
	 */
	public ThrowerAnt()
	{
		super(1, 4);
		this.damage = 1;
	}
	/*
	 * ==Niall== Added this extra constructor so that the scuba ant could be placeable in the water spots
	 * but also so that it could use the leaf throwing animation of the thrower ant.
	 */
	public ThrowerAnt(int armor, int food, boolean canSwim)
	{
		super(armor, food, canSwim);
	}
	
	/**
	 * Returns a target for this ant
	 * @return A bee to target
	 */
	public Bee getTarget()
	{
		return place.getClosestBee(0, 3);
	}
	
	public void action(AntColony colony)
	{
		Bee target = getTarget();
		if(target != null)
		{
			target.reduceArmor(this.damage);
		}
	}
}
