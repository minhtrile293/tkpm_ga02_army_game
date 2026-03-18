package soldiers;

import java.util.ArrayList;
import java.util.List;

import core.ISoldier;
import equipments.EquipmentDecorator;
import equipments.Shield;
import equipments.Sword;
import visitor.IVisitor;

public class ProxySoldier implements Soldier{
    private ISoldier mSoldier;
    private List<EquipmentDecorator> weapons;
    private List<Class <? extends EquipmentDecorator>> allowedEquipments;

    public ProxySoldier(ISoldier soldier, List<Class<? extends EquipmentDecorator>> allowedEquipments){
        mSoldier = soldier;
        weapons = new ArrayList<>();
        this.allowedEquipments = allowedEquipments;
    }
    @Override
    public void addEquipment(Class<? extends EquipmentDecorator> equipmentClass){

        if (allowedEquipments != null && allowedEquipments.)
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
            System.out.println("The Soldier has already equipped the " + equipmentClass.getSimpleName());
        }
    }

    @Override
    public void addSword(){
        addEquipment(Sword.class);
    }

    @Override
    public void addShield(){
        addEquipment(Shield.class);
    }

    @Override
    public int hit(){
        return mSoldier.hit();
    }

    @Override
    public boolean wardOff(int strength){
        return mSoldier.wardOff(strength);
    }

    public String getEquipmentString() {
        if (weapons == null || weapons.isEmpty()) {
            return "No Equipment";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < weapons.size(); i++) {
            sb.append(weapons.get(i).getEquipmentString());
            
            // Chỉ thêm " + " nếu đây chưa phải là phần tử cuối cùng
            if (i < weapons.size() - 1) {
                sb.append(" + ");
            }
        }
        return sb.toString();
    }

    @Override
    public String getName() {
        return mSoldier.getName();
    }

    @Override
    public String getArmName() {
        return mSoldier.getArmName();
    }

    @Override
    public void accept(IVisitor visitor) {
        this.mSoldier.accept(visitor);
    }

    @Override
    public boolean isDead() {
        return this.mSoldier.isDead();
    }
}
