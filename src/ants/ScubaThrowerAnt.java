package ants;

import core.ScubaAnt;
import core.AntColony;
import core.Bee;

public class ScubaThrowerAnt extends ThrowerAnt
{
	protected int damage;
	
	public ScubaThrowerAnt() 
	{
		super(1, 5, true);
		this.damage = 1;
	}

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
