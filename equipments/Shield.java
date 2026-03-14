package equipments;

import core.ISoldier;

public class Shield extends EquipmentDecorator{
    public Shield(ISoldier solider){
        super(solider);
        durability = 100;
    }
    
    @Override
    public int hit(){
        int damage = mSoldier.hit();
        int totalDamage = damage + durability;
        System.out.println("Shield adds " + durability +  " damage with (" + damage + " -> " + totalDamage + ")");
        if (durability > 0){
            durability -= 10;
        }
        return totalDamage;
    }

    @Override
    public boolean wardOff(int strength){
        int totalStrength = strength - durability;
        System.out.println("Shield reduces enemy strength by " + durability + " with (" + strength + " -> " + totalStrength + ")");
        if (durability > 0){
            durability -= 20;
        } 
        return mSoldier.wardOff(totalStrength);
    }
}
