package test;

import java.util.ArrayList;
import java.util.Arrays;

import core.BaseSoldier;
import core.ISoldier;
import equipments.Shield;
import equipments.Sword;
import organization.Army;
import organization.SoldierGroup;
import soldiers.Horseman;
import soldiers.Infantryman;
import soldiers.ProxySoldier;
import visitor.CountVisitor;
import visitor.DisplayVisitor;

public class Main {
    public static void main(String[] args){
        // ISoldier horseman = new Horseman("Horse", 100, 20);
        // ISoldier infantryman = new Infantryman("Infantryman", 200, 50); 
        
        // // Shield s1 = new Shield(horseman);
        // // System.out.println(s1.getClass().getSimpleName());

        // // Shield s2 = new Shield(infantryman);
        // // Sword sw = new Sword(s2);

        // // s1.hit();
        // // s2.hit();
        // // s1.wardOff(sw.hit());
        
        // ProxySoldier proxySoldier = new ProxySoldier(infantryman);
        // proxySoldier.addEquipment(Sword.class);
        // proxySoldier.addEquipment(Sword.class);
        // proxySoldier.addEquipment(Shield.class);
        // proxySoldier.hit();
        // // proxySoldier.addSword();
        // // proxySoldier.addSword();
        // // proxySoldier.addShield();
        // // proxySoldier.hit();

        // 1. Tạo các lính lẻ (BaseSoldier)
        BaseSoldier s1 = new Infantryman("Gia Au", 100, 20);
        BaseSoldier s2 = new Infantryman("Minh Tri", 100, 20);
        BaseSoldier s3 = new Horseman("Van Ha", 100, 20);
        BaseSoldier s4 = new Horseman("Minh Luan", 100, 20);

        // 2. Tạo các Nhóm lính (SoldierGroup)
        SoldierGroup infantryGroup = new SoldierGroup();
        
        // Thêm lính vào nhóm Bộ binh
        infantryGroup.addSubGroups(new ArrayList<>(), Arrays.asList(s1, s2));

        SoldierGroup cavalryGroup = new SoldierGroup();
        // Thêm lính vào nhóm Kỵ binh
        cavalryGroup.addSubGroups(new ArrayList<>(), Arrays.asList(s3, s4));

        // 3. Tạo Nhóm Tổng (Ví dụ: Trung đoàn) chứa 2 nhóm trên
        SoldierGroup regiment = new SoldierGroup();
        regiment.addSubGroups(Arrays.asList(infantryGroup, cavalryGroup), new ArrayList<>());

        // 4. Khởi tạo Army
        Army myArmy = new Army();
        myArmy.addSubGroups(Arrays.asList(regiment));

        // --- TEST THỬ NGHIỆM ---

        System.out.println("\n=== PHAT TRANG BI ===");
        regiment.addShield(); // Phát khiên cho toàn bộ lính trong trung đoàn
        System.out.println("Da phat khien (Shield) cho toan bo binh si");

        System.out.printf("%n=== KIEM TRA QUAN SO ===%n");
        CountVisitor countVisitor = new CountVisitor();
        myArmy.accept(countVisitor);
        System.out.println("Tong luc luong: " + countVisitor.getTotal());

        System.out.printf("%n=== DIEM DANH ===%n");
        DisplayVisitor displayVisitor = new DisplayVisitor();
        myArmy.accept(displayVisitor);

        System.out.println("\n=== TINH SAT THUONG TONG (HIT) ===");
        int totalAtk = regiment.hit();
        System.out.println("Tong sat thuong: " + totalAtk);

        System.out.println("\n=== CHIU SAT THUONG (WARD OFF) ===");
        int damageIn = 100;
        System.out.println("Quan doan chiu " + damageIn + " sat thuong chia deu:");
        boolean survives = regiment.wardOff(damageIn);

        System.out.println("Binh doan con song: " + survives);
    }
}
