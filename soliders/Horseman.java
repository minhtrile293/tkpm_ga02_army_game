package soliders;
import core.BaseSoldier;


public class Horseman extends BaseSoldier {

    public Horseman(int hp, int strength){
        super(hp, strength);
    }

    @Override
    public int hit(){
        System.out.println("Horseman is hitting the enemy");
        return baseStrength;
    }
    
    @Override
    public boolean wardOff(int strength){
        System.out.println("Horseman is warding off the enemy");
        if(strength > baseHp){
            return false;
        }
        return true;
    }
}
