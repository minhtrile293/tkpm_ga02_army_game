package equipments;

import core.Soldier;

public abstract class EquipmentDecorator implements Soldier {
    protected Soldier mSoldier;
    protected int durability; 
    public EquipmentDecorator(Soldier soldier){
        mSoldier = soldier;
    }

    public Soldier getSoldier(){
        return mSoldier;
    }

    public void setSoldier(Soldier soldier){
        mSoldier = soldier;
    }
}
