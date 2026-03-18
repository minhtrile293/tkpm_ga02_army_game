package factory;

import core.ISoldier;
import equipments.EquipmentDecorator;

public interface IArmyFactory {
    ISoldier createSoldier (String name, int hp, int strength);

    List<Class<? extends EquipmentDecorator>> getAllowedEqui
}
