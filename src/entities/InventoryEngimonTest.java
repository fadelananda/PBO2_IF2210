package entities;

import entities.engimon.Beckoo;
import entities.engimon.Geni;
import org.junit.jupiter.api.Test;

import javax.crypto.interfaces.PBEKey;

import static org.junit.jupiter.api.Assertions.*;

class InventoryEngimonTest {

    @Test
    void addItem() {
        Beckoo engimon1 = new Beckoo("Beckoo", 1, 1);
        Geni engimon2 = new Geni("Geni", 1, 1);
        Inventory inven = new InventoryEngimon();
        inven.addItem(engimon1, 1);
        assertEquals(1, inven.getJumlahItem());
        inven.addItem(engimon2, 1);
        assertEquals(2, inven.getJumlahItem());
    }

    @Test
    void deleteItemByIdx() {
        Beckoo engimon1 = new Beckoo("Beckoo", 1, 1);
        Geni engimon2 = new Geni("Geni", 1, 1);
        Inventory inven = new InventoryEngimon();
        inven.addItem(engimon1, 1);
        inven.addItem(engimon2, 1);
        inven.deleteItemByIdx(1, 1);
        assertEquals(1, inven.getJumlahItem());
        inven.deleteItemByIdx(1, 1);
        assertEquals(0, inven.getJumlahItem());
    }

    @Test
    void getItemByIdxShowInventory() {
        Beckoo engimon1 = new Beckoo("Beckoo", 1, 1);
        Geni engimon2 = new Geni("Geni", 1, 1);
        Inventory inven = new InventoryEngimon();
        inven.addItem(engimon1, 1);
        inven.addItem(engimon2, 1);
        assertEquals(engimon1, inven.getItemByIdxShowInventory(1));
        assertNotEquals(engimon2, inven.getItemByIdxShowInventory(1));
    }

    @Test
    void showInventory() {
        System.out.println("Show Inventory Test: ");
        Beckoo engimon1 = new Beckoo("Beckoo", 1, 1);
        Geni engimon2 = new Geni("Geni", 1, 1);
        Inventory inven = new InventoryEngimon();
        inven.addItem(engimon1, 1);
        inven.addItem(engimon2, 1);
        inven.showInventory();
    }
}