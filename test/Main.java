package test;

import core.Soldier;
import equipments.Shield;
import equipments.Sword;
import soliders.Horseman;
import soliders.Infantryman;

public class Main {
    public static void main(String[] args){
        Soldier horseman = new Horseman(100, 20);
        Soldier infantryman = new Infantryman(200, 50); 
        
        Shield s1 = new Shield(horseman);
        Shield s2 = new Shield(infantryman);
        Sword sw = new Sword(infantryman);

        s1.hit();
        s2.hit();
        s1.wardOff(sw.hit());
    }
}
