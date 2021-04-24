package ants;

import core.AntColony;
import core.Bee;

public class ShortThrowerAnt extends ThrowerAnt{
    /**
     * David Afolabi
     */
    public ShortThrowerAnt()
    {
        super(1, 6);
        defaultDamage = 1;
        damage = defaultDamage;
    }

    public Bee getTarget()
    {
        return place.getClosestBee(0, 2);
    }

    public void action(AntColony colony)
    {
        if (buff)
        {
            damage = defaultDamage * 2;
        }
        else
            damage = defaultDamage;

        Bee target = getTarget();
        if(target != null)
        {
            target.reduceArmor(this.damage);
        }
    }

}
