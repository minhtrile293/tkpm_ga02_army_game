package core;

import java.util.ArrayList;
import java.util.List;

import observer.IObserver;
import observer.IPublisher;

public abstract class BaseSoldier implements ISoldier, IPublisher{ 
    protected int curHp;    
    protected int baseHp;
    protected int baseStrength;

    protected String name = "BaseSoldier";
    protected List<IObserver> observers = new ArrayList<>();
    public boolean isNotified = false;

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
        if (!observers.contains(observer)) observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(IObserver observer) {
        
    }
}
