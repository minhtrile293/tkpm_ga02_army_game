// equipments/Armor.java
package equipments;
import core.ISoldier;
import visitor.IVisitor;

public class Armor extends EquipmentDecorator {
    public Armor(ISoldier soldier) { super(soldier); }
    
    @Override public String getEquipmentString() { return "Armor"; }
    @Override public int hit() { return mSoldier.hit(); } 
    @Override public boolean wardOff(int strength) { 
        // Áo giáp giúp giảm 10 sát thương nhận vào
        int reducedStrength = Math.max(0, strength - 10);
        return mSoldier.wardOff(reducedStrength); 
    }
    @Override public String getName() { return mSoldier.getName(); }
    @Override public String getArmName() { return mSoldier.getArmName(); }
    @Override public boolean isDead() { return mSoldier.isDead(); }
    @Override public void accept(IVisitor visitor) { mSoldier.accept(visitor); }
}