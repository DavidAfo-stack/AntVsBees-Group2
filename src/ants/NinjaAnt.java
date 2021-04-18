package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

public class NinjaAnt extends Ant {
    /**
     * Author: David Afolabi
     * 2021
     */
	protected int damage;

    //class constructor for Ninja ant
    public NinjaAnt() {
        super(1, 6);
        this.blockBeePath = false; // does not block the bee in its place
        defaultDamage = 1; //damage value of Ninja ant set by default to 1
        damage = defaultDamage; 
        System.out.println("Is this ant a priority? " + priority);
    }

    /**
     * The Ninja ant action is implemented here
     * The Ninja does not block the path of the bee but kills every bee in the same place as the Ninja ant
     * @param colony The colony in which this action takes place (to support wide-spread effects)
     */
    @Override
    public void action(AntColony colony) 
    {
    	if (buff)
    	{
    		damage = defaultDamage * 2;
    	}
    	else
			damage = defaultDamage;
       Bee[] bees = this.place.getBees();
            for(Bee bee: bees){
                 place.getClosestBee(0,3);
                 bee.reduceArmor(this.damage);

        }
    }

    public int getDamageValue(){
        return this.damage;
    }

    public Boolean getBlockBeeAttribute(){
        return this.blockBeePath;
    }
}
