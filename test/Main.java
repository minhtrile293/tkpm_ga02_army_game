package test;

import core.ISoldier;
import equipments.Shield;
import equipments.Sword;
import soliders.Horseman;
import soliders.Infantryman;
import soliders.ProxySoldier;

public class Main {
    public static void main(String[] args){
        ISoldier horseman = new Horseman(100, 20);
        ISoldier infantryman = new Infantryman(200, 50); 
        
        // Shield s1 = new Shield(horseman);
        // System.out.println(s1.getClass().getSimpleName());

        // Shield s2 = new Shield(infantryman);
        // Sword sw = new Sword(s2);

        // s1.hit();
        // s2.hit();
        // s1.wardOff(sw.hit());
        
        ProxySoldier proxySoldier = new ProxySoldier(infantryman);
        proxySoldier.addEquipment(Sword.class);
        proxySoldier.addEquipment(Sword.class);
        proxySoldier.addEquipment(Shield.class);
        proxySoldier.hit();
        // proxySoldier.addSword();
        // proxySoldier.addSword();
        // proxySoldier.addShield();
        // proxySoldier.hit();
    }
}
