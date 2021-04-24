package ants;

import core.AntColony;
import core.Bee;

public class LongThrowerAnt extends ThrowerAnt {
    /**
     * David Afolabi
     */
    public LongThrowerAnt() {
        super(1, 3);
        defaultDamage = 1;
        damage = defaultDamage;
    }

    public Bee getTarget() {
        return place.getClosestBee(0, 4);
    }

    public void action(AntColony colony) {
        if (buff)
        {
            damage = defaultDamage * 2;
        } else
            damage = defaultDamage;

        Bee target = getTarget();
        if (target != null) {
            target.reduceArmor(this.damage);
        }
    }
}
