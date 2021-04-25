package entities;

import entities.engimon.Wadem;
import enums.Elements;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void addEngimon() {
        Player p1 = new Player();
        Wadem w = new Wadem("Tes", 1, 1);
        p1.addEngimon(w);
    }

    @Test
    void addSkillItem() {
        Player p2 = new Player();
        Skill s = new Skill("duarr", 10, 5, EnumSet.of(Elements.ELECTRIC));
        SkillItem si = new SkillItem(s);
        p2.addSkillItem(si, 1);
    }

    @Test
    void countBag() {
        Player p = new Player();
        Wadem w = new Wadem("Tes", 1, 1);
        p.addEngimon(w);
        Skill s = new Skill("duarr", 10, 5, EnumSet.of(Elements.ELECTRIC));
        SkillItem si = new SkillItem(s);
        p.addSkillItem(si, 1);
        assertEquals(2, p.countBag());
    }
}