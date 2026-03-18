// equipments/BioWeapon.java
package equipments;
import core.ISoldier;
import visitor.IVisitor;

public class BioWeapon extends EquipmentDecorator {
    public BioWeapon(ISoldier soldier) { super(soldier); }
    
    @Override public String getEquipmentString() { return "Bio Weapon"; }
    @Override public int hit() { return mSoldier.hit() + 150; } // Sát thương sinh học diện rộng
    @Override public boolean wardOff(int strength) { return mSoldier.wardOff(strength); }
    @Override public String getName() { return mSoldier.getName(); }
    @Override public String getArmName() { return mSoldier.getArmName(); }
    @Override public boolean isDead() { return mSoldier.isDead(); }
    @Override public void accept(IVisitor visitor) { mSoldier.accept(visitor); }
}