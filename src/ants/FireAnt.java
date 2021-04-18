package ants;

import core.*;

import java.util.ArrayList;

public class FireAnt extends Ant {
    /**
     * Author: David Afolabi
     * 2021
     */
    protected int damage;

    public FireAnt() 
    {
        super(1, 4);
        defaultDamage = 3;
        damage = defaultDamage;
        System.out.println("Is this ant a priority? " + priority);
    }
     /**
     * this method overrides the reduceArmor method in the ant class
     * First, we get all the bees in the ant's place
     * Once a bee stings the ant, the fire ant dies and thus,
     * any co-located bee in the ant's place dies together with the ant simultaneously
     * @param amount The amount to decrease the armor by
     */
    @Override
    public void reduceArmor(int amount) 
    {
    	if (buff) // Checks if the ant's damage should be increased
    	{
			damage = defaultDamage * 2;
    	}
		else
			damage = defaultDamage; // Sets the ant's damage to default otherwise
    	
            ArrayList<Bee> beesInPlace = getPlace().getAllBees(0,0);
            for (Bee bees : beesInPlace)
            {
                bees.reduceArmor(this.damage);
            }
            super.reduceArmor(amount);
    }

    /**
     * This does nothing on its turn
     * @param colony The colony in which this action takes place (to support wide-spread effects)
     */
    @Override
    public void action(AntColony colony) {
                return;
    }

    public int getDamageValue(){
        return this.damage;
    }
}
