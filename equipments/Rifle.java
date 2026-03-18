// equipments/Rifle.java
package equipments;
import core.ISoldier;
import visitor.IVisitor;

public class Rifle extends EquipmentDecorator {
    public Rifle(ISoldier soldier) { super(soldier); }
    
    @Override public String getEquipmentString() { return "Rifle"; }
    @Override public int hit() { return mSoldier.hit() + 40; } // Súng trường sát thương cao
    @Override public boolean wardOff(int strength) { return mSoldier.wardOff(strength); }
    @Override public String getName() { return mSoldier.getName(); }
    @Override public String getArmName() { return mSoldier.getArmName(); }
    @Override public boolean isDead() { return mSoldier.isDead(); }
    @Override public void accept(IVisitor visitor) { mSoldier.accept(visitor); }
}