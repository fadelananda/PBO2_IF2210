package entities;

import enums.Elements;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.*;

class SkillTest {

    @Test
    void getName() {
        Skill tes = new Skill("tes", 10, 1, EnumSet.of(Elements.FIRE));
        assertEquals("tes", tes.getName());
    }

    @Test
    void getBasePower() {
        Skill tes = new Skill("tes", 10, 1, EnumSet.of(Elements.FIRE));
        assertEquals(10, tes.getBasePower());
    }

    @Test
    void getMasteryLevel() {
        Skill tes = new Skill("tes", 10, 1, EnumSet.of(Elements.FIRE));
        assertEquals(1, tes.getMasteryLevel());
    }

    @Test
    void getElements() {
        Skill tes = new Skill("tes", 10, 1, EnumSet.of(Elements.FIRE));
        assertEquals(EnumSet.of(Elements.FIRE), tes.getElements());
    }

    @Test
    void setBasePower() {
        Skill tes = new Skill("tes", 10, 1, EnumSet.of(Elements.FIRE));
        tes.setBasePower(50);
        assertEquals(50, tes.getBasePower());
    }

    @Test
    void setMasteryLevel() {
        Skill tes = new Skill("tes", 10, 1, EnumSet.of(Elements.FIRE));
        tes.setMasteryLevel(6);
        assertEquals(6, tes.getMasteryLevel());
    }
}