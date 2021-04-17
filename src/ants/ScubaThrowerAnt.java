package ants;

import core.AntColony;
import core.Bee;

public class ScubaThrowerAnt extends ThrowerAnt
{	
	public ScubaThrowerAnt() 
	{
		super(1, 5, true);
		defaultDamage = 1;
        damage = defaultDamage;
        System.out.println("Is this ant a priority? " + priority);
	}

	public Bee getTarget()
	{
		return place.getClosestBee(0, 3);
	}
	
	public void action(AntColony colony)
	{
		if (buff)
    	{
			damage = defaultDamage * 2;
    	}
		else
			damage = defaultDamage;
		
		System.out.println("Ant: " + this + " damage is: " + damage);
		
		Bee target = getTarget();
		if(target != null)
		{
			target.reduceArmor(this.damage);
		}
	}
}
