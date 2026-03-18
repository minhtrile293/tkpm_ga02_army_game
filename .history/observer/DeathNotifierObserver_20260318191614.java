package observer;

public class DeathNotifierObserver {
    
}

// publisher sẽ là lính, còn observer sẽ giống như máy nghe lén lính, lính có phương thức để notify tới observer, nhưng lính không biết mình bị observer
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
        System.out.println("[DeathCountObserver] Số lượng lính tử trận hiện tại: " + _deathCount);
    }    
}