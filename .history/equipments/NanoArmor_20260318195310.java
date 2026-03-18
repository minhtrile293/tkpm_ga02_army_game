// equipments/NanoArmor.java
package equipments;
import core.ISoldier;
import visitor.IVisitor;

public class NanoArmor extends EquipmentDecorator {
    public NanoArmor(ISoldier soldier) { super(soldier); }
    
    @Override public String getEquipmentString() { return "Nano Armor"; }
    @Override public int hit() { return mSoldier.hit(); } 
    @Override public boolean wardOff(int strength) { 
        // Giáp Nano hấp thụ tới 50 sát thương
        int reducedStrength = Math.max(0, strength - 50);
        return mSoldier.wardOff(reducedStrength); 
    }
    @Override public String getName() { return mSoldier.getName(); }
    @Override public String getArmName() { return mSoldier.getArmName(); }
    @Override public boolean isDead() { return mSoldier.isDead(); }
    @Override public void accept(IVisitor visitor) { mSoldier.accept(visitor); }
}