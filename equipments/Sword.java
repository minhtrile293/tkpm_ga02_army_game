package equipments;

import core.Soldier;

public class Sword extends EquipmentDecorator{
    public Sword(Soldier solider){
        super(solider);
        durability = 50;
    }
    
    @Override
    public int hit(){
        int damage = mSoldier.hit();
        int totalDamage = damage + durability;
        System.out.println("Sword adds " + durability +  " damage with (" + damage + " -> " + totalDamage + ")");
        if (durability > 0){
            durability -= 10;
        }
        return totalDamage;
    }

    @Override
    public boolean wardOff(int strength){
        int totalStrength = strength - durability;
        System.out.println("Sword reduces enemy strength by " + durability + " with (" + strength + " -> " + totalStrength + ")");
        if (durability > 0){
            durability -= 15;
        } 
        return mSoldier.wardOff(totalStrength);
    }
}
