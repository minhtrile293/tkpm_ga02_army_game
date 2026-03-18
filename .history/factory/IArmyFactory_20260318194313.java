package factory;

import java.util.List;

import equipments.EquipmentDecorator;
import soldiers.Soldier;

public interface IArmyFactory {
    Soldier createSoldier (String name, int hp, int strength);

    List<Class<? extends EquipmentDecorator>> getAllowedEquipments();
}
