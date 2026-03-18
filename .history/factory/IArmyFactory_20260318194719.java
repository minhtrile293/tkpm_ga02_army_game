package factory;

import soldiers.Soldier;

public interface IArmyFactory {
    Soldier createInfantryman(String name, int hp, int strength);
    Soldier createHorseman(String name, int hp, int strength);
}
