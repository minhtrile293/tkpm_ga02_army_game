package factory;

import core.BaseSoldier;
import observer.DeathCountObserver;
import observer.DeathNotifierObserver;
import soldiers.Infantryman;
import soldiers.ProxySoldier;
import soldiers.Soldier;

public class MedievalFactory implement IArmyFactory {
    public Soldier createInfantryman(String name, int hp, int strength) {
        BaseSoldier soldier = new Infantryman(name + " [Medieval]", hp, strength);
        soldier.addObserver(DeathCountObserver.getInstance());
        soldier.addObserver(DeathNotifierObserver.getInstance());
        return new ProxySoldier(soldier, allowedEquipments);
    }
}
