// factory/ScienceFictionFactory.java
package factory;

import java.util.Arrays;
import java.util.List;
import core.BaseSoldier;
import equipments.*; // Chứa LaserSword, BioWeapon, NanoArmor
import observer.DeathCountObserver;
import observer.DeathNotifierObserver;
import soldiers.Horseman;
import soldiers.Infantryman;
import soldiers.ProxySoldier;
import soldiers.Soldier;

public class ScienceFictionFactory implements IArmyFactory {
    // Chỉ cho phép vũ khí Viễn Tưởng
    private final List<Class<? extends EquipmentDecorator>> allowedEquipments = 
        Arrays.asList(LaserSword.class, BioWeapon.class, NanoArmor.class);

    @Override
    public Soldier createInfantryman(String name, int hp, int strength) {
        BaseSoldier soldier = new Infantryman(name + " [Sci-Fi]", hp, strength);
        soldier.addObserver(DeathCountObserver.getInstance());
        soldier.addObserver(DeathNotifierObserver.getInstance());
        return new ProxySoldier(soldier, allowedEquipments);
    }

    @Override
    public Soldier createHorseman(String name, int hp, int strength) {
        BaseSoldier soldier = new Horseman(name + " [Sci-Fi]", hp, strength);
        soldier.addObserver(DeathCountObserver.getInstance());
        soldier.addObserver(DeathNotifierObserver.getInstance());
        return new ProxySoldier(soldier, allowedEquipments);
    }
}