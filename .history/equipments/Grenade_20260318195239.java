// equipments/Grenade.java
package equipments;
import core.ISoldier;
import visitor.IVisitor;

public class Grenade extends EquipmentDecorator {
    public Grenade(ISoldier soldier) { super(soldier); }
    
    @Override public String getEquipmentString() { return "Grenade"; }
    @Override public int hit() { return mSoldier.hit() + 60; } // Sát thương nổ cực lớn
    @Override public boolean wardOff(int strength) { return mSoldier.wardOff(strength); }
    @Override public String getName() { return mSoldier.getName(); }
    @Override public String getArmName() { return mSoldier.getArmName(); }
    @Override public boolean isDead() { return mSoldier.isDead(); }
    @Override public void accept(IVisitor visitor) { mSoldier.accept(visitor); }
}