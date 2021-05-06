package ants;

import core.*;

public class QueenAnt extends ThrowerAnt
{
	public QueenAnt()
	{
		super(1, 5, true);
		unique = true;
	}
	
	public void SetBuffs()
	{
		if (place.getEntrance() != null)
		{
			if (place.getEntrance().getAnt() != null)
				place.getEntrance().getAnt().buff = true;
		}
		if (place.getExit() != null)
		{
			if (place.getExit().getAnt() != null)
				place.getExit().getAnt().buff = true;
		}
	}
	
	@Override
	public void action(AntColony colony)
	{
		SetBuffs();
		Bee target = getTarget();
		if(target != null)
		{
			target.reduceArmor(this.damage);
		}
	}
}