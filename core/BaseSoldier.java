package core;

public abstract class BaseSoldier implements ISoldier{ 
    protected int baseHp;
    protected int baseStrength;
    public BaseSoldier(int hp, int strength){
        baseHp = hp;
        baseStrength = strength;
    }
}
