import entities.Skill;
import entities.engimon.*;
import enums.Elements;

import java.util.EnumSet;

public class EngimonTesting {
    public static void main(String[] args) {
        Beckoo b1 = new Beckoo();
        Geni g1 = new Geni("Geni", 1, 0);
        Gledek gledek = new Gledek();
        Koobong k1 = new Koobong();
        Lapindoo l1 = new Lapindoo();
        Teles t1 = new Teles();
        Wadem w1 = new Wadem();
        Watoo w2 = new Watoo("Rafif", 0, 0);
        w1.addParent(g1, w2);

        b1.printInfo();
        g1.printInfo();
        gledek.printInfo();
        k1.printInfo();
        l1.printInfo();
        t1.printInfo();
        w1.printInfo();
        w2.printInfo();

        b1.interact();
        g1.interact();
        gledek.interact();
        k1.interact();
        l1.interact();
        t1.interact();
        w1.interact();
        w2.interact();
    }
}
