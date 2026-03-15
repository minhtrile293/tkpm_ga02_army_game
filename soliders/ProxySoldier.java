package soliders;

import java.util.ArrayList;
import java.util.List;

import core.ISoldier;
import equipments.EquipmentDecorator;
import equipments.Shield;
import equipments.Sword;

public class ProxySoldier implements Soldier{
    private ISoldier mSoldier;
    private boolean hasSword = false;
    private boolean hasShield = false;
    private List<EquipmentDecorator> weapons;
    
    public ProxySoldier(ISoldier soldier){
        mSoldier = soldier;
        weapons = new ArrayList<>();
    }
    @Override
    public void addEquipment(Class<? extends EquipmentDecorator> equipmentClass){
        if(!weapons.stream().anyMatch(w -> w.getClass() == equipmentClass)){
            try{
                EquipmentDecorator newEquipment = equipmentClass.getConstructor(ISoldier.class).newInstance(mSoldier);
                weapons.add(newEquipment);
                mSoldier = newEquipment;
                System.out.println("The " + equipmentClass.getSimpleName() + " equipped successfully");
            } catch(Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("The Soldier was equipped the "+ equipmentClass.getSimpleName());
        }
    }

    @Override
    public void addSword(){
        if (!hasSword) {
            System.out.println("The Sword equipped successfully");
            mSoldier = new Sword(mSoldier);
            hasSword = true;
        } else {
            System.out.println("The Soldier was equipped the Sword");
        }
    }

    @Override
    public void addShield(){
        if (!hasShield) {
            System.out.println("The Shield equipped successfully");
            mSoldier = new Shield(mSoldier);
            hasShield = true;
        } else {
            System.out.println("The Soldier was equipped the Shield");
        }
    }

    @Override
    public int hit(){
        return mSoldier.hit();
    }

    @Override
    public boolean wardOff(int strength){
        return mSoldier.wardOff(strength);
    }
}
