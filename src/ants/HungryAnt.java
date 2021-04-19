package ants;

import com.sun.org.apache.xpath.internal.operations.Bool;
import core.Ant;
import core.AntColony;
import core.Bee;
import core.Place;

import java.util.ArrayList;

public class HungryAnt extends Ant {
    /**
     * Author:  David Afolabi
     */
    private boolean eatBee;
    private int turns = 0; // track the number of turns

    // class constructor for Hungry Ant
    public HungryAnt() 
    {
        super(1, 4);
    }

    /**
     * get target bee in ant place
     * the getClosestBee method has been set to pick a bee at random in the Place class
     * @return
     */
   public Bee getTarget()
    {
      return this.getPlace().getClosestBee(0,0);
    }

    /**
     *The Hungry ant action is implemented in a way that It eats a bee in its place
     * and takes 3 turns to digest before it can eat another bee
     * @param colony The colony in which this action takes place (to support wide-spread effects)
     */
    @Override
    public void action(AntColony colony) {
        Bee target = getTarget();
        if((target != null) && (!eatBee)){
            int beeArmor = target.getArmor();
            target.reduceArmor(beeArmor);
            eatBee = true;
            turns = 0;
            //System.out.println("Killed");
        }
        //check if ant has digested bee after 3 turns
        if(eatBee){
            turns++;
            if(turns>=3){
                eatBee = false;
                //System.out.println("Ant can now eat bee");
            }
        }

    }
}
