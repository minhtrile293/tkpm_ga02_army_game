
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
        System.out.printf("[DeathNotifierObserver] Binh lính %s đã tử trận.%n", deadSoldier.getName());
        System.out.printf("   -> [Email System] Đang gửi email xin lỗi đến bạn bè của %s... Hoàn tất.%n", deadSoldier.getName());   
    }    
}