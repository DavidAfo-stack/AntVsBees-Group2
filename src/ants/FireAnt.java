package ants;

import core.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FireAnt extends Ant {
    /**
     * Author: David Afolabi
     * 2021
     */
    protected int damage;

    public FireAnt() {
        super(1, 4);
        this.damage = 3;
    }

     /**
     * this method overrides the reduceArmor method in the ant class
     * First, we get all the bees in the ant's place
     * Once a bee stings the ant, the fire ant dies and thus,
     * any co-located bee in the ant's place dies together with the ant simultaneously
     * @param amount The amount to decrease the armor by
     */
    @Override
    public void reduceArmor(int amount) {
        this.armor -= amount;
        if(armor <= 0) {
            ArrayList<Bee> beesInPlace = place.getAllBees(0,8);
            for (Bee bees : beesInPlace)
            {
                bees.reduceArmor(this.damage);
            }
            this.leavePlace();
        }
    }

    /**
     * This does nothing on its turn
     * @param colony The colony in which this action takes place (to support wide-spread effects)
     */
    @Override
    public void action(AntColony colony) {
                return;
    }
}
