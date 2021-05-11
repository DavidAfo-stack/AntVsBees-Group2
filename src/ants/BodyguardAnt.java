package ants;

import core.Ant;
import core.AntColony;

public class BodyguardAnt extends Ant
{
	public boolean overlays;

	public BodyguardAnt()
	{	
		super(2, 4, false, true, true);
		
		// // System.out.println("asdf" + this.overlays);
	}
	
	@Override
	public void action(AntColony colony) 
	{
		// Bodyguard ant does nothing but take damage.
		return;
	}
	
}
