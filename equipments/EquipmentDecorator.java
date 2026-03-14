package equipments;

import core.ISoldier;

public abstract class EquipmentDecorator implements ISoldier {
    protected ISoldier mSoldier;
    protected int durability; 
    public EquipmentDecorator(ISoldier soldier){
        mSoldier = soldier;
    }

    public ISoldier getSoldier(){
        return mSoldier;
    }

    public void setSoldier(ISoldier soldier){
        mSoldier = soldier;
    }
}
