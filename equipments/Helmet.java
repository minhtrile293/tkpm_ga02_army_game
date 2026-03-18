// equipments/Helmet.java
package equipments;
import core.ISoldier;
import visitor.IVisitor;

public class Helmet extends EquipmentDecorator {
    public Helmet(ISoldier soldier) { super(soldier); }
    
    @Override public String getEquipmentString() { return "Helmet"; }
    @Override public int hit() { return mSoldier.hit(); } 
    @Override public boolean wardOff(int strength) { 
        // Mũ sắt giảm 15 sát thương
        int reducedStrength = Math.max(0, strength - 15);
        return mSoldier.wardOff(reducedStrength); 
    }
    @Override public String getName() { return mSoldier.getName(); }
    @Override public String getArmName() { return mSoldier.getArmName(); }
    @Override public boolean isDead() { return mSoldier.isDead(); }
    @Override public void accept(IVisitor visitor) { mSoldier.accept(visitor); }
}