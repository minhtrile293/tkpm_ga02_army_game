package equipments;

import core.ISoldier;
import visitor.IVisitor;

public class Sword extends EquipmentDecorator{
    private ISoldier wrapee;
    
    public Sword(ISoldier soldier){
        super(soldier);

        wrapee = soldier;
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
        return this.wrapee.wardOff(strength);
    }

    @Override
    public String getEquipmentName() {
        return "Sword";
    }

    @Override
    public String getName() {
        return this.wrapee.getName();
    }

    @Override
    public String getArmName() {
        return this.wrapee.getArmName();
    }

    @Override
    public void accept(IVisitor visitor) {
        this.mSoldier.accept(visitor);
    }
    
    @Override
    public String getEquipmentString() {
        String equipmentName = getEquipmentName();
        String previousWeapon = this.wrapee.getEquipmentString();

        if (previousWeapon == null || previousWeapon.equals("None") || previousWeapon.isEmpty()) {
            return equipmentName;
        } else {
            return previousWeapon + " + " + equipmentName;
        }
    }

    @Override
    public boolean isDead() {
        return this.wrapee.isDead();
    }
}
