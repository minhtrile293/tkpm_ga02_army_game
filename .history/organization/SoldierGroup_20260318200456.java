// organization/SoldierGroup.java
package organization;

import java.util.ArrayList;
import java.util.List;

import equipments.EquipmentDecorator;
import soldiers.Soldier;
import visitor.CountVisitor;
import visitor.IVisitor;

public class SoldierGroup implements Soldier {
    protected List<SoldierGroup> subGroups = new ArrayList<>();
    
    protected List<Soldier> soldiers = new ArrayList<>();
    // THAY ĐỔI 2: Xóa hoàn toàn Map proxySoldiers vì lính truyền vào đã là Proxy rồi
    
    protected boolean isAllDead = false;

    // THAY ĐỔI 3: Nhận vào List<Soldier> thay vì List<BaseSoldier>
    public void addSubGroups(List<SoldierGroup> soldierGroups, List<Soldier> soldiers) {
        if (soldiers != null) {
            this.soldiers.addAll(soldiers);
        }
        if (soldierGroups != null) {
            for (SoldierGroup group : soldierGroups) {
                if (group != null) {
                    this.subGroups.add(group);
                }
            }
        }
    }

    @Override
    public void accept(IVisitor visitor) {
        // Trực tiếp gọi visitor cho lính
        for (Soldier soldier : soldiers) {
            soldier.accept(visitor);
        }

        for (SoldierGroup group : subGroups) {
            group.accept(visitor);
        }
    }

    @Override
    public void addShield() {
        for (Soldier soldier : soldiers) {
            soldier.addShield();
        }

        for (SoldierGroup group : subGroups) {
            group.addShield();
        }
    }
    
    @Override
    public void addSword() {
        for (Soldier soldier : soldiers) {
            soldier.addSword();
        }

        for (SoldierGroup group : subGroups) {
            group.addSword();
        }
    }
    
    @Override
    public void addEquipment(Class<? extends EquipmentDecorator> equipmentClass) {
        for (Soldier soldier : soldiers) {
            soldier.addEquipment(equipmentClass);
        }

        for (SoldierGroup group : subGroups) {
            group.addEquipment(equipmentClass);
        }
    }

    @Override
    public int hit() {
        int totalDamage = 0;
        for (Soldier soldier : soldiers) {
            if (!soldier.isDead()) {
                totalDamage += soldier.hit();
            }
        }

        for (SoldierGroup group : subGroups) {
            if (!group.isDead()) {
                totalDamage += group.hit();
            }
        }
        
        return totalDamage;
    }

    @Override
    public boolean wardOff(int strength) {
        CountVisitor countService = new CountVisitor();
        countService.setCountDead(false);
        
        accept(countService);

        int totalSoldiers = countService.getTotal();
        if (totalSoldiers == 0) return false; // Tránh chia cho 0

        int finalStrength = strength / totalSoldiers;
        
        return sufferDamage(finalStrength);
    }

    // Đổi logic thành gọi trực tiếp trên interface Soldier
    protected boolean sufferDamage(int finalStrength) {
        boolean atLeastOneSurvive = false;
        
        for (Soldier soldier : soldiers) {
            if (!soldier.isDead()) {
                soldier.wardOff(finalStrength); 
                
                if (!soldier.isDead()) atLeastOneSurvive = true;
            }
        }
        
        for (SoldierGroup group : subGroups) {
            if (!group.isDead()) {
                boolean isGroupSurvive = group.sufferDamage(finalStrength);
                if (isGroupSurvive) atLeastOneSurvive = true;
            }
        }

        if (!atLeastOneSurvive) isAllDead = true;

        return atLeastOneSurvive;
    }

    @Override
    public String getName() {
        return "SoldierGroup";
    }

    @Override
    public String getArmName() {
        return "Group";
    }

    @Override
    public String getEquipmentString() {
        return "Group Equipments";
    }
    
    @Override
    public boolean isDead() {
        return isAllDead;
    }
}