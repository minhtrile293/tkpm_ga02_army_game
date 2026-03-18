
package observer;

import core.ISoldier;

public class DeathNotifierObserver implements IObserver{

    private static DeathNotifierObserver _instance;
    private int _deathCount = 0;
    private DeathNotifierObserver() {}

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
        System.out.println("[DeathCountObserver] Số lượng lính tử trận hiện tại: " + _deathCount);
    }    
}