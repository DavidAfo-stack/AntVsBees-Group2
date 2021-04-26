package ants;

import core.AntColony;
import core.Bee;

public class SlowAnt extends ThrowerAnt{
    /**
     * David Afolabi
     */
    public SlowAnt(){
        super(4,1);
    }

    public Bee getTarget()
    {
        return place.getClosestBee(0, 3);
    }

    /**
     * when a bee is attacked
     * it takes no action for a turn
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
