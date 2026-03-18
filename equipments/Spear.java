// equipments/Spear.java
package equipments;
import core.ISoldier;
import visitor.IVisitor;

public class Spear extends EquipmentDecorator {
    public Spear(ISoldier soldier) { super(soldier); }
    
    @Override public String getEquipmentString() { return "Spear"; }
    @Override public int hit() { return mSoldier.hit() + 15; } // Cộng thêm 15 sát thương
    @Override public boolean wardOff(int strength) { return mSoldier.wardOff(strength); }
    @Override public String getName() { return mSoldier.getName(); }
    @Override public String getArmName() { return mSoldier.getArmName(); }
    @Override public boolean isDead() { return mSoldier.isDead(); }
    @Override public void accept(IVisitor visitor) { mSoldier.accept(visitor); }
}