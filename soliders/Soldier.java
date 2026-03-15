package soliders;

import core.ISoldier;
import equipments.EquipmentDecorator;

public interface Soldier extends ISoldier{
    void addShield();
    void addSword();
    void addEquipment(Class<? extends EquipmentDecorator> equipmentClass);
}
