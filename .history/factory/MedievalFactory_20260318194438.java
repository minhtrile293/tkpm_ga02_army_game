package factory;

import core.BaseSoldier;
import observer.DeathCountObserver;
import soldiers.Soldier;

public class MedievalFactory implement IArmyFactory {
    public Soldier createInfantryman(String name, int hp, int strength) {
        BaseSoldier soldier = new Infantryman(name + " [Medieval]", hp, strength);
        soldier.addObserver(DeathCountObserver.getInstance());
        soldier.addObserver(De.getInstance());
        return new ProxySoldier(soldier, allowedEquipments);
    }
}
