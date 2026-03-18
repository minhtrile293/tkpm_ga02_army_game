package factory;

import core.BaseSoldier;
import soldiers.Soldier;

public class MedievalFactory implement IArmyFactory {
    public Soldier createInfantryman(String name, int hp, int strength) {
        BaseSoldier soldier = new Infantryman(name + " [Medieval]", hp, strength);
        soldier.addObserver(DeathCountObserver.getInstance());
        soldier.addObserver(DeathNotifierObserver.getInstance());
        return new ProxySoldier(soldier, allowedEquipments);
    }
}
