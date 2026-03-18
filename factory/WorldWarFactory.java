// factory/WorldWarFactory.java
package factory;

import java.util.Arrays;
import java.util.List;
import core.BaseSoldier;
import equipments.*; // Chứa Rifle, Grenade, Helmet
import observer.DeathCountObserver;
import observer.DeathNotifierObserver;
import soldiers.Horseman;
import soldiers.Infantryman;
import soldiers.ProxySoldier;
import soldiers.Soldier;

public class WorldWarFactory implements IArmyFactory {
    // Chỉ cho phép vũ khí Thế Chiến
    private final List<Class<? extends EquipmentDecorator>> allowedEquipments = 
        Arrays.asList(Rifle.class, Grenade.class, Helmet.class);

    @Override
    public Soldier createInfantryman(String name, int hp, int strength) {
        BaseSoldier soldier = new Infantryman(name + " [WW]", hp, strength);
        soldier.addObserver(DeathCountObserver.getInstance());
        soldier.addObserver(DeathNotifierObserver.getInstance());
        return new ProxySoldier(soldier, allowedEquipments);
    }

    @Override
    public Soldier createHorseman(String name, int hp, int strength) {
        BaseSoldier soldier = new Horseman(name + " [WW]", hp, strength);
        soldier.addObserver(DeathCountObserver.getInstance());
        soldier.addObserver(DeathNotifierObserver.getInstance());
        return new ProxySoldier(soldier, allowedEquipments);
    }
}