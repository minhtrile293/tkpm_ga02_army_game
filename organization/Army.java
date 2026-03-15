package organization;

import java.util.ArrayList;
import java.util.List;

import visitor.IVisitor;
import visitor.IVistable;
public class Army implements IVistable {
    protected List<SoldierGroup> subGroups = new ArrayList<>();

    public void addSubGroups (List<SoldierGroup> soldierGroups) {
        for (SoldierGroup group : soldierGroups) {
            if (group != null) {
                this.subGroups.add(group);
            }
        }
    }

    @Override
    public void accept(IVisitor visitor) {
        for(SoldierGroup group : subGroups) {
            group.accept(visitor);
        }
    }

    public int hit() {
        int totalArmyDamage = 0;
        for (SoldierGroup group : subGroups) {
            totalArmyDamage += group.hit();
        }
        return totalArmyDamage;
    }

    public boolean wardOff(int strength) {
        boolean anyGroupSurvives = false;
        
        for (SoldierGroup group : subGroups) {
            if (group.wardOff(strength)) {
                anyGroupSurvives = true;
            }
        }
        
        return anyGroupSurvives;
    }
}
