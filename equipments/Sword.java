package equipments;

import core.ISoldier;
import visitor.IVisitor;

public class Sword extends EquipmentDecorator{
    public Sword(ISoldier soldier){
        super(soldier);
        durability = 100;
    }
    
    @Override
    public int hit(){
        int damage = mSoldier.hit();
        int totalDamage = damage + durability;
        System.out.printf("[Shield Bash] Bonus Damage: +%d | Total: (%d + %d) = %d%n", 
    durability, damage, durability, totalDamage);
        if (durability > 0){
            durability -= 10;
        }
        return totalDamage;
    }

    @Override
    public boolean wardOff(int strength){
        return this.mSoldier.wardOff(strength);
    }

    @Override
    public String getName() {
        return this.mSoldier.getName();
    }

    @Override
    public String getArmName() {
        return this.mSoldier.getArmName();
    }

    @Override
    public void accept(IVisitor visitor) {
        this.mSoldier.accept(visitor);
    }
    
    @Override
    public String getEquipmentString() {
        return "Sword";
    }

    @Override
    public boolean isDead() {
        return this.mSoldier.isDead();
    }
}
