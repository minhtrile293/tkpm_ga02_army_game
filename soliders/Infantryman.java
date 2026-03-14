package soliders;

import core.BaseSoldier;

public class Infantryman extends BaseSoldier{

    public Infantryman(int hp, int strength){
        super(hp, strength);
    }

    @Override
    public int hit(){
        System.out.println("Infantryman is hitting the enemy");
        return baseStrength;
    }
    
    @Override
    public boolean wardOff(int strength){
        System.out.println("Infantryman is warding off the enemy");
        if (strength > baseHp){
            return false;
        }
        return true;
    }
}
