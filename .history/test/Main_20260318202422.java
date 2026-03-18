package test;

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
        System.out.println("========== 1. KHOI TAO LIEN MINH QUAN DOI ==========");
        
        IArmyFactory medievalFactory = new MedievalFactory();
        IArmyFactory wwFactory = new WorldWarFactory();
        IArmyFactory sciFiFactory = new ScienceFictionFactory();

        System.out.println("\n--- Tuyen quan & Phat trang bi ---");
        
        // Nhom 1: Trung Co (Mau thap, sat thuong yeu)
        Soldier m1 = medievalFactory.createInfantryman("Gia Au", 100, 20);
        Soldier m2 = medievalFactory.createHorseman("Minh Tri", 150, 30);
        m1.addEquipment(Sword.class);
        m2.addEquipment(Armor.class);

        // Nhom 2: The Chien (Mau trung binh, sat thuong kha)
        Soldier w1 = wwFactory.createInfantryman("Van Ha", 200, 50);
        Soldier w2 = wwFactory.createHorseman("Minh Luan", 250, 60);
        w1.addEquipment(Rifle.class);
        w2.addEquipment(Grenade.class);

        // Nhom 3: Vien Tuong (Mau trau, sat thuong khung)
        Soldier s1 = sciFiFactory.createInfantryman("Alex", 500, 150);
        Soldier s2 = sciFiFactory.createHorseman("Cyber Bot", 600, 200);
        s1.addEquipment(LaserSword.class);
        s2.addEquipment(NanoArmor.class);

        // Gom nhom vao cac Group
        SoldierGroup medievalGroup = new SoldierGroup();
        medievalGroup.addSubGroups(null, Arrays.asList(m1, m2));

        SoldierGroup wwGroup = new SoldierGroup();
        wwGroup.addSubGroups(null, Arrays.asList(w1, w2));

        SoldierGroup sciFiGroup = new SoldierGroup();
        sciFiGroup.addSubGroups(null, Arrays.asList(s1, s2));

        // Tao Quan Doan Tong
        Army alliedArmy = new Army();
        alliedArmy.addSubGroups(Arrays.asList(medievalGroup, wwGroup, sciFiGroup));

        System.out.println("\n========== 2. DIEM DANH TRUOC GIO G ==========");
        CountVisitor countVisitor = new CountVisitor();
        alliedArmy.accept(countVisitor);
        System.out.println("-> Tong quan so: " + countVisitor.getTotal() + " chien binh.");
        
        DisplayVisitor displayVisitor = new DisplayVisitor();
        alliedArmy.accept(displayVisitor);

        System.out.println("\n========== 3. TRAN CHIEN BAT DAU ==========");

        System.out.println("\n[DIEN BIEN 1] Lien minh chu dong khai hoa!");
        int totalAtk = alliedArmy.hit();
        System.out.println("=> Tong sat thuong giang len dau ke thu: " + totalAtk);

        System.out.println("\n[DIEN BIEN 2] Ke thu phan cong DOT 1 (Sat thuong dien rong nhe)");
        // 600 damage chia cho 6 linh = 100 damage/nguoi. 
        // Gia Au (100 HP) se tu tran ngay lap tuc va trigger Observer!
        int damageWave1 = 600; 
        System.out.println("=> Ke thu tha bom, toan quan ganh chiu: " + damageWave1 + " damage.");
        alliedArmy.wardOff(damageWave1);

        System.out.println("\n[DIEN BIEN 3] Ke thu tang hoa luc DOT 2 (Sat thuong trung binh)");
        // 1000 damage chia cho 5 linh con lai = 200 damage/nguoi.
        // Minh Tri va Van Ha se tuc tuoi nga xuong!
        int damageWave2 = 1000;
        System.out.println("=> Ke thu goi phao binh tiep vien, toan quan ganh chiu: " + damageWave2 + " damage.");
        alliedArmy.wardOff(damageWave2);

        System.out.println("\n[DIEN BIEN 4] Tinh hinh chien chien sau 2 dot thu tuc...");
        countVisitor = new CountVisitor(); // Reset bo dem
        countVisitor.setCountDead(false); // Chi dem lính còn sống
        alliedArmy.accept(countVisitor);
        System.out.println("-> Quan so chi con lai: " + countVisitor.getTotal() + " chien binh kiên cường.");
        
        System.out.println("\n[DIEN BIEN 5] Boss cuoi tung chieu sat thu (Huy diet ca ban do)!");
        // 5000 damage chia cho lính còn lại. Kể cả lính Sci-Fi cũng khó lòng qua khỏi.
        int damageWave3 = 5000;
        System.out.println("=> BAU TRỜI SỤP ĐỔ! Toan quan ganh chiu: " + damageWave3 + " damage.");
        boolean isSurvive = alliedArmy.wardOff(damageWave3);

        System.out.println("\n========== 4. KET THUC TRAN CHIEN ==========");
        if(isSurvive) {
            System.out.println("PHEP MAU! Van con hy vong, lien minh gianh chien thang!");
            alliedArmy.accept(displayVisitor);
        } else {
            System.out.println("TOAN QUAN PHUC MOT! Chien dich that bai tham hai...");
        }
    }
}