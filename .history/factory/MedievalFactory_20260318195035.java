package factory;

import java.util.Arrays;
import java.util.List;

import core.BaseSoldier;
import equipments.Armor;
import equipments.EquipmentDecorator;
import equipments.Shield;
import equipments.Spear;
import equipments.Sword;
import observer.DeathCountObserver;
import observer.DeathNotifierObserver;
import soldiers.Horseman;
import soldiers.Infantryman;
import soldiers.ProxySoldier;
import soldiers.Soldier;

public class MedievalFactory implements IArmyFactory {
    private final List<Class<? extends EquipmentDecorator>> allowedEquipments = 
        Arrays.asList(Sword.class, Shield.class, Spear.class, Armor.class);

    public Soldier createInfantryman(String name, int hp, int strength) {
        BaseSoldier soldier = new Infantryman(name + " [Medieval]", hp, strength);
        soldier.addObserver(DeathCountObserver.getInstance());
        soldier.addObserver(DeathNotifierObserver.getInstance());
        return new ProxySoldier(soldier, allowedEquipments);
    }

    @Override
    public Soldier createHorseman(String name, int hp, int strength) {
        BaseSoldier soldier = new Horseman(name + " [Medieval]", hp, strength);
        soldier.addObserver(DeathCountObserver.getInstance());
        soldier.addObserver(DeathNotifierObserver.getInstance());
        return new ProxySoldier(soldier, allowedEquipments);
    }

};
