
package observer;

import core.ISoldier;

public class DeathNotifierObserver implements IObserver{

    private static DeathNotifierObserver _instance;
    private DeathNotifierObserver() {}

    public static DeathNotifierObserver getInstance() {
        if (_instance == null) {
            _instance = new DeathNotifierObserver();
            return _instance;
        }

        return _instance;
    }

    @Override
    public void update(ISoldier deadSoldier) {
        _deathCount++;
        System.out.println("[DeathCountObserver] Số lượng lính tử trận hiện tại: " + _deathCount);
    }    
}