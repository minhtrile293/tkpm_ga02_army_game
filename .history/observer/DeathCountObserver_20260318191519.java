package observer;

import core.ISoldier;

public class DeathCountObserver implements IObserver{

    private static DeathCountObserver _instance;
    private int _deathCount = 0;
    private DeathCountObserver() {}

    public static DeathCountObserver getInstance() {
        if (_instance == null) {
            _instance = new DeathCountObserver();
            return 
        }
    }
    public void update(ISoldier deadSoldier) {

    }    
}


// dự kiến 
