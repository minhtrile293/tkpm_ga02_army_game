package observer;

import core.ISoldier;

public class DeathCountObserver implements IObserver{

    private static DeathCountObserver _instance;
    private int _deathCount = 0;
    private DeathCountObserver() {}

    public static DeathCountObserver getInstance() {
        if (_instance == null) {
            _instance = new DeathCountObserver();
            return _instance;
        }

        return _instance;
    }

    @Override
    public void update(ISoldier deadSoldier) {
        _deathCount++;
        System.out.println("[DeathCountObserver] Số lượng lính tử trận hiện tại: " + deadCount);
    }    
}


// dự kiến 
