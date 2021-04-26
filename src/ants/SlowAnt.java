package ants;

import core.AntColony;
import core.Bee;

public class SlowAnt extends ThrowerAnt{
    /**
     * David Afolabi
     */
    public SlowAnt(){
        super(1,4);
    }
    //get target bee
    public Bee getTarget()
    {
        return place.getClosestBee(0, 3);
    }

    /**
     * when a bee is attacked by the slow thrower ant,
     * it takes no action for 3 turns and experiences a slow effect
     * @param colony
     */
    public void action(AntColony colony){
        Bee targetBee = getTarget();
        if(targetBee != null){
            if(this.buff){
                targetBee.slow_effect(6);
            }
            else
                targetBee.slow_effect(3);
        }
    }
}
