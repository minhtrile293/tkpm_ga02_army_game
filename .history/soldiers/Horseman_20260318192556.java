package soldiers;
import core.BaseSoldier;
import visitor.IVisitor;


public class Horseman extends BaseSoldier {
    public Horseman(String name, int hp, int strength){
        super(name, hp, strength);
    }

    @Override
    public int hit(){
        System.out.printf("%s is hitting the enemy with total damage:%n", name);
        return baseStrength;
    }
    
    @Override
    public boolean wardOff(int strength){
        System.out.printf("%s is warding off the enemy with total absorbed:%n", name);
        this.curHp -= strength;
        if (this.curHp < 0) 
    }

    @Override
    public String getArmName() {
        return "Horseman";
    }

    @Override
    public boolean isDead() {
        return curHp == 0;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getEquipmentString() {
        return "None";
    }
}
