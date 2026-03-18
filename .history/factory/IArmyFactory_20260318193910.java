package factory;

import core.ISoldier;

public interface IArmyFactory {
    ISoldier createSoldier (String name, int hp, int strength);

    List<Class<? extends 
}
