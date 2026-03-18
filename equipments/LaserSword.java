// equipments/LaserSword.java
package equipments;
import core.ISoldier;
import visitor.IVisitor;

public class LaserSword extends EquipmentDecorator {
    public LaserSword(ISoldier soldier) { super(soldier); }
    
    @Override public String getEquipmentString() { return "Laser Sword"; }
    @Override public int hit() { return mSoldier.hit() + 100; } // Sát thương khủng
    @Override public boolean wardOff(int strength) { return mSoldier.wardOff(strength); }
    @Override public String getName() { return mSoldier.getName(); }
    @Override public String getArmName() { return mSoldier.getArmName(); }
    @Override public boolean isDead() { return mSoldier.isDead(); }
    @Override public void accept(IVisitor visitor) { mSoldier.accept(visitor); }
}