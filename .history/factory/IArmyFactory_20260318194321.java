package factory;

import java.util.List;

import equipments.EquipmentDecorator;
import soldiers.Soldier;

public interface IArmyFactory {
Soldier createInfantryman(String name, int hp, int strength);
    Soldier createHorseman(String name, int hp, int strength);

    List<Class<? extends EquipmentDecorator>> getAllowedEquipments();
}
