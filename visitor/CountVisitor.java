package visitor;

import core.ISoldier;

public class CountVisitor implements IVisitor {
    private boolean _shouldCountDead = true;
    private int horsemanCount = 0;
    private int infantrymanCount = 0;

    public void setCountDead(boolean shouldCountDead) {
        this._shouldCountDead = shouldCountDead;
    }

    @Override
    public void visit(ISoldier soldier) {
        if (soldier.getArmName() == "Horseman") {
            if (!soldier.isDead()) {
            horsemanCount++;;
            } else if (_shouldCountDead) {
                horsemanCount++;
            }
        } else {
            if (!soldier.isDead()) {
                infantrymanCount++;;
            } else if (_shouldCountDead) {
                infantrymanCount++;
            }
        }
    }

    public int getTotal() {
        return horsemanCount + infantrymanCount;
    }
}
