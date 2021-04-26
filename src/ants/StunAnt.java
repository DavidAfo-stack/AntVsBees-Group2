package ants;

import core.AntColony;
import core.Bee;

/**
 * David Afolabi
 */

public class StunAnt extends ThrowerAnt {
    public StunAnt(){
        super(1,6);
    }
    //get target bee
    public Bee getTarget()
    {
        return place.getClosestBee(0, 3);
    }

    /**
     * when a bee is attacked by the stun ant,
     *
     * @param colony
     */
    public void action(AntColony colony){
        Bee targetBee = getTarget();
        if(targetBee != null){
            if(this.buff){
                targetBee.stun_effect(2);
            }
            else
                targetBee.stun_effect(1);
        }
    }
}
