package visitor;

import core.ISoldier;

public class DisplayVisitor implements IVisitor {
    private int _soldierCount = 0;
    @Override
    public void visit(ISoldier soldier) {
        System.out.printf("%d. %s - %s. Equipped: %s%n",
        ++_soldierCount,
        soldier.getName(),
        soldier.getArmName(),
        soldier.getEquipmentString());
    }
}
