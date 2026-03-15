package core;

import visitor.IVistable;

public interface ISoldier extends IVistable{
    int hit();
    boolean wardOff(int strength);
    String getName();
    String getArmName();
    String getEquipmentString();
    boolean isDead();
}

