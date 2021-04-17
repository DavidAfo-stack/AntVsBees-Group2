package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

/**
 * @author David Afolabi
 * @version fall 2020 intake
 */

public class WallAnt extends Ant {
    /**
     * the wall ant has been developed with a large amor value
     */
    public WallAnt() {
        super(4, 4); // armor and food added to the wall ant
        System.out.println("Is this ant a priority? " + priority);
    }

    /**
     * the ant does nothing but has a large armor value
     * @param colony The colony in which this action takes place (to support wide-spread effects)
     */
    @Override
    public void action(AntColony colony) {
        return; //do nothing
    }
}
