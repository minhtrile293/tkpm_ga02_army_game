package test

import java.util.Arrays;

import equipments.*;
import factory.*;
import organization.Army;
import organization.SoldierGroup;
import soldiers.Soldier;
import visitor.CountVisitor;
import visitor.DisplayVisitor;

public class Main {
    public static void main(String[] args) {
        System.out.println("========== KHỞI TẠO QUÂN ĐỘI (ABSTRACT FACTORY & SINGLETON) ==========");
        
        // 1. Khởi tạo các nhà máy sản xuất quân lính
        IArmyFactory medievalFactory = new MedievalFactory();
        IArmyFactory sciFiFactory = new ScienceFictionFactory();

        // 2. Tạo lính (Nhà máy tự động bọc Proxy và gắn Observer Singleton)
        Soldier m1 = medievalFactory.createInfantryman("Gia Au", 100, 20);
        Soldier m2 = medievalFactory.createHorseman("Minh Tri", 120, 30);
        
        Soldier s1 = sciFiFactory.createInfantryman("Van Ha", 150, 50);
        Soldier s2 = sciFiFactory.createHorseman("Minh Luan", 200, 80);

        System.out.println("\n========== PHÁT TRANG BỊ (PROXY & DECORATOR) ==========");
        
        System.out.println("--- Thử nghiệm Lính Trung Cổ ---");
        m1.addEquipment(Sword.class); // Hợp lệ
        m1.addEquipment(Shield.class); // Hợp lệ
        m1.addEquipment(LaserSword.class); // Lỗi: Proxy chặn vì sai thế hệ!

        System.out.println("\n--- Thử nghiệm Lính Viễn Tưởng ---");
        s1.addEquipment(LaserSword.class); // Hợp lệ
        s2.addEquipment(NanoArmor.class); // Hợp lệ
        s2.addEquipment(Spear.class); // Lỗi: Proxy chặn vì sai thế hệ!

        System.out.println("\n========== TỔ CHỨC QUÂN ĐỘI (COMPOSITE) ==========");
        
        // Tạo nhóm Trung cổ
        SoldierGroup medievalGroup = new SoldierGroup();
        medievalGroup.addSubGroups(null, Arrays.asList(m1, m2));

        // Tạo nhóm Viễn tưởng
        SoldierGroup sciFiGroup = new SoldierGroup();
        sciFiGroup.addSubGroups(null, Arrays.asList(s1, s2));

        // Gom vào Quân đoàn tổng
        Army myArmy = new Army();
        myArmy.addSubGroups(Arrays.asList(medievalGroup, sciFiGroup));
        System.out.println("Đã thành lập xong quân đoàn hỗn hợp!");

        System.out.println("\n========== DUYỆT ĐỘI HÌNH (VISITOR) ==========");
        
        CountVisitor countVisitor = new CountVisitor();
        myArmy.accept(countVisitor);
        System.out.println("Tổng quân số hiện tại: " + countVisitor.getTotal() + " chiến binh.");

        System.out.println("\n--- Danh sách chi tiết ---");
        DisplayVisitor displayVisitor = new DisplayVisitor();
        myArmy.accept(displayVisitor);

        System.out.println("\n========== GIAO TRANH TỔNG (COMPOSITE ACTIONS) ==========");
        
        int totalAtk = myArmy.hit();
        System.out.println("Toàn quân đồng loạt khai hỏa! Tổng sát thương gây ra: " + totalAtk);

        System.out.println("\n========== THEO DÕI TỬ TRẬN (OBSERVER) ==========");
        
        // Giả lập quân địch phản công một lượng sát thương cực lớn (600 chia đều cho 4 lính = 150 sát thương/người)
        // Lính trung cổ máu ít (100, 120) chắc chắn sẽ tử trận và kích hoạt Observer
        int massiveDamage = 600;
        System.out.println("KẺ THÙ PHẢN CÔNG! Quân đoàn phải gánh chịu " + massiveDamage + " sát thương diện rộng.");
        
        boolean isArmySurvives = myArmy.wardOff(massiveDamage);

        System.out.println("\n========== KẾT QUẢ CUỘC CHIẾN ==========");
        System.out.println("Quân đoàn còn trụ lại được không? " + (isArmySurvives ? "Còn" : "Bị tiêu diệt hoàn toàn"));
        
        System.out.println("\n--- Điểm danh những người sống sót ---");
        myArmy.accept(displayVisitor);
    }
}