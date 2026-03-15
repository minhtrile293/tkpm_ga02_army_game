package organization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import core.BaseSoldier;
import equipments.EquipmentDecorator;
import soldiers.ProxySoldier;
import soldiers.Soldier;
import visitor.CountVisitor;
import visitor.IVisitor;
import visitor.IVistable;
public class SoldierGroup implements Soldier {
    protected List<SoldierGroup> subGroups = new ArrayList<>();
    protected List<BaseSoldier> soldiers = new ArrayList<>();
    protected Map<BaseSoldier, ProxySoldier> proxySoldiers = new HashMap<BaseSoldier, ProxySoldier>();
    protected boolean isAllDead = false;

    public void addSubGroups (List<SoldierGroup> soldierGroups, List<BaseSoldier> soldiers) {
        for (BaseSoldier _soldier : soldiers) {
            this.soldiers.add(_soldier);
            proxySoldiers.put(_soldier, new ProxySoldier(_soldier));
        }
        for (SoldierGroup group : soldierGroups) {
            if (group != null) {
                this.subGroups.add(group);
            }
        }
    }

    @Override
    public void accept(IVisitor visitor) {
        for (BaseSoldier soldier : soldiers) {
            visitor.visit(proxySoldiers.get(soldier));
        }

        for(SoldierGroup group : subGroups) {
            group.accept(visitor);
        }
    }

    @Override
    public void addShield() {
        for (BaseSoldier soldier : soldiers) {
            proxySoldiers.get(soldier).addShield();
        }

        for(SoldierGroup group : subGroups) {
            group.addShield();
        }
    };
    
    @Override
    public void addSword() {
        for (BaseSoldier soldier : soldiers) {
            proxySoldiers.get(soldier).addSword();
        }

        for(SoldierGroup group : subGroups) {
            group.addShield();
        }
    }
    
    @Override
    public void addEquipment(Class<? extends EquipmentDecorator> equipmentClass) {
        for (BaseSoldier soldier : soldiers) {
            proxySoldiers.get(soldier).addEquipment(equipmentClass);;
        }

        for(SoldierGroup group : subGroups) {
            group.addShield();
        }
    }

    @Override
    public int hit() {
        int totalDamage = 0;
        for (BaseSoldier soldier : soldiers) {
            if (soldier.isDead()) continue;
            totalDamage += proxySoldiers.get(soldier).hit();
        }

        for(SoldierGroup group : subGroups) {
            totalDamage += group.hit();
        }
        
        return totalDamage;
    }

    @Override
    public boolean wardOff(int strength) {
        CountVisitor countService = new CountVisitor();
        countService.setCountDead(false);
        
        accept(countService);

        int totalSoldiers = countService.getTotal();

        int finalStrength = strength / totalSoldiers;
        
        return sufferDamage(finalStrength);
    }

    public boolean sufferDamage(int finalStrength) {
        boolean atLeastOneSurvive = false;
        for (BaseSoldier soldier : soldiers) {
            if (!soldier.isDead()) {
                if (soldier != null) proxySoldiers.get(soldier).wardOff(finalStrength); 
                
                if (!soldier.isDead()) atLeastOneSurvive = true;
            }
        }
        
        for(SoldierGroup group : subGroups) {
            boolean isGroupSurvive = group.sufferDamage(finalStrength);
            if (isGroupSurvive) atLeastOneSurvive = true;
        }

        if (!atLeastOneSurvive) isAllDead = true;

        return atLeastOneSurvive;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getArmName() {
        return "";
    }

    @Override
    public String getEquipmentString() {
        return "None";
    }
    
    @Override
    public boolean isDead() {
        return isAllDead;
    }
}
