package core;

import observer.IObserver;
import observer.IPublisher;

public abstract class BaseSoldier implements ISoldier, IPublisher{ 
    protected int curHp;    
    protected int baseHp;
    protected int baseStrength;

    protected String name = "BaseSoldier";
    protected List<IObserver> observers = new Arr

    public BaseSoldier(String soldierName, int hp, int strength){
        curHp = hp;
        baseHp = hp;
        baseStrength = strength;
        name = soldierName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getArmName() {
        return "BaseSoldier";
    }

    @Override
    public boolean isDead() {
        return false;
    };

    @Override
    public void addObserver(IObserver observer) {

    }
}
