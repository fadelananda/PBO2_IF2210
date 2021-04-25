package entities.engimon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;

class EngimonTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    void getSpeciesName() {
        Beckoo test = new Beckoo("Beckoo", 1, 1);
        assertEquals("Beckoo", test.getSpeciesName());

        Geni test1 = new Geni("Geni", 1, 1);
        assertEquals("Geni", test1.getSpeciesName());

        Gledek test2 = new Gledek("Gledek", 1, 1);
        assertEquals("Gledek", test2.getSpeciesName());

        Koobong test3 = new Koobong("Koobong", 1, 1);
        assertEquals("Koobong", test3.getSpeciesName());

        Lapindoo test4 = new Lapindoo("Lapindoo", 1, 1);
        assertEquals("Lapindoo", test4.getSpeciesName());

        Teles test5 = new Teles("Teles", 1, 1);
        assertEquals("Teles", test5.getSpeciesName());

        Wadem test6 = new Wadem("Wadem", 1, 1);
        assertEquals("Wadem", test6.getSpeciesName());

        Watoo test7 = new Watoo("Watoo", 1, 1);
        assertEquals("Watoo", test7.getSpeciesName());
    }

    @Test
    void getName() {
        Beckoo test = new Beckoo("Beckoo", 1, 1);
        assertEquals("Beckoo", test.getName());

        Geni test1 = new Geni("Geni", 1, 1);
        assertEquals("Geni", test1.getName());

        Gledek test2 = new Gledek("Gledek", 1, 1);
        assertEquals("Gledek", test2.getName());

        Koobong test3 = new Koobong("Koobong", 1, 1);
        assertEquals("Koobong", test3.getName());

        Lapindoo test4 = new Lapindoo("Lapindoo", 1, 1);
        assertEquals("Lapindoo", test4.getName());

        Teles test5 = new Teles("Teles", 1, 1);
        assertEquals("Teles", test5.getName());

        Wadem test6 = new Wadem("Wadem", 1, 1);
        assertEquals("Wadem", test6.getName());

        Watoo test7 = new Watoo("Watoo", 1, 1);
        assertEquals("Watoo", test7.getName());
    }

    @Test
    void getLife() {
        Beckoo test = new Beckoo("Beckoo", 1, 1);
        assertEquals(3, test.getLife());

        Geni test1 = new Geni("Geni", 1, 1);
        assertEquals(3, test1.getLife());

        Gledek test2 = new Gledek("Gledek", 1, 1);
        assertEquals(3, test2.getLife());

        Koobong test3 = new Koobong("Koobong", 1, 1);
        assertEquals(3, test3.getLife());

        Lapindoo test4 = new Lapindoo("Lapindoo", 1, 1);
        assertEquals(3, test4.getLife());

        Teles test5 = new Teles("Teles", 1, 1);
        assertEquals(3, test5.getLife());

        Wadem test6 = new Wadem("Wadem", 1, 1);
        assertEquals(3, test6.getLife());

        Watoo test7 = new Watoo("Watoo", 1, 1);
        assertEquals(3, test7.getLife());
    }

    @Test
    void getLevel() {
        Beckoo test = new Beckoo("Beckoo", 1, 1);
        assertEquals(1, test.getLevel());

        Geni test1 = new Geni("Geni", 1, 1);
        assertEquals(1, test1.getLevel());

        Gledek test2 = new Gledek("Gledek", 1, 1);
        assertEquals(1, test2.getLevel());

        Koobong test3 = new Koobong("Koobong", 1, 1);
        assertEquals(1, test3.getLevel());

        Lapindoo test4 = new Lapindoo("Lapindoo", 1, 1);
        assertEquals(1, test4.getLevel());

        Teles test5 = new Teles("Teles", 1, 1);
        assertEquals(1, test5.getLevel());

        Wadem test6 = new Wadem("Wadem", 1, 1);
        assertEquals(1, test6.getLevel());

        Watoo test7 = new Watoo("Watoo", 1, 1);
        assertEquals(1, test7.getLevel());
    }

    @Test
    void getExp() {
        Beckoo test = new Beckoo("Beckoo", 1, 1);
        assertEquals(0, test.getExp());

        Geni test1 = new Geni("Geni", 1, 1);
        assertEquals(0, test1.getExp());

        Gledek test2 = new Gledek("Gledek", 1, 1);
        assertEquals(0, test2.getExp());

        Koobong test3 = new Koobong("Koobong", 1, 1);
        assertEquals(0, test3.getExp());

        Lapindoo test4 = new Lapindoo("Lapindoo", 1, 1);
        assertEquals(0, test4.getExp());

        Teles test5 = new Teles("Teles", 1, 1);
        assertEquals(0, test5.getExp());

        Wadem test6 = new Wadem("Wadem", 1, 1);
        assertEquals(0, test6.getExp());

        Watoo test7 = new Watoo("Watoo", 1, 1);
        assertEquals(0, test7.getExp());
    }

    @Test
    void getCumExp() {
        Beckoo test = new Beckoo("Beckoo", 1, 1);
        assertEquals(0, test.getCumExp());

        Geni test1 = new Geni("Geni", 1, 1);
        assertEquals(0, test1.getCumExp());

        Gledek test2 = new Gledek("Gledek", 1, 1);
        assertEquals(0, test2.getCumExp());

        Koobong test3 = new Koobong("Koobong", 1, 1);
        assertEquals(0, test3.getCumExp());

        Lapindoo test4 = new Lapindoo("Lapindoo", 1, 1);
        assertEquals(0, test4.getCumExp());

        Teles test5 = new Teles("Teles", 1, 1);
        assertEquals(0, test5.getCumExp());

        Wadem test6 = new Wadem("Wadem", 1, 1);
        assertEquals(0, test6.getCumExp());

        Watoo test7 = new Watoo("Watoo", 1, 1);
        assertEquals(0, test7.getCumExp());
    }

    @Test
    void setName() {
        Koobong test = new Koobong("Test", 1, 1);
        test.setName("Test2");
        assertEquals("Test2", test.getName());
    }

    @Test
    void setLife() {
        Koobong test = new Koobong("Test", 1, 1);
        test.setLife(2);
        assertEquals(2, test.getLife());
    }

    @Test
    void setLevel() {
        Koobong test = new Koobong("Test", 1, 1);
        test.setLevel(5);
        assertEquals(5, test.getLevel());
    }

    @Test
    void setExp() {
        Lapindoo test = new Lapindoo("Test", 1, 1);
        test.setExp(100);
        assertEquals(100, test.getExp());
    }

    @Test
    void setCumExp() {
        Wadem test = new Wadem("Test", 1, 1);
        test.setCumExp(900);
        assertEquals(900, test.getCumExp());

        Watoo test1 = new Watoo("Test1", 1, 1);
        test1.setCumExp(800);
        assertEquals(800, test1.getCumExp());
    }

    @Test
    void interract() {
        System.out.println("Test Interract: ");
        Beckoo test = new Beckoo("Beckoo", 1, 1);
        test.interact();

        Geni test1 = new Geni("Geni", 1, 1);
        test1.interact();

        Gledek test2 = new Gledek("Gledek", 1, 1);
        test2.interact();

        Koobong test3 = new Koobong("Koobong", 1, 1);
        test3.interact();

        Lapindoo test4 = new Lapindoo("Lapindoo", 1, 1);
        test4.interact();

        Teles test5 = new Teles("Teles", 1, 1);
        test5.interact();

        Wadem test6 = new Wadem("Wadem", 1, 1);
        test6.interact();

        Watoo test7 = new Watoo("Watoo", 1, 1);
        test7.interact();
    }

    @Test
    void printInfo() {
        System.out.println("Test Info Engimon: ");
        Beckoo test = new Beckoo("Beckoo", 1, 1);
        test.printInfo();
    }

    @Test
    void printAllSkills() {
        System.out.println("Test Skills: ");
        Beckoo test = new Beckoo("Beckoo", 1, 1);
        test.printAllSkills();
    }

}