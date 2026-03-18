
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
        // Hiển thị tên và mô phỏng gửi email theo đúng yêu cầu
        System.out.printf("[DeathNotifierObserver] Binh linh %s đa tu tran.%n", deadSoldier.getName());
        System.out.printf("   -> [Email System] Dang gi email xin loi den ban be của %s... Hoàn tất.%n", deadSoldier.getName());   
    }    
}