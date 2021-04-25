//package entities;
//
//import entities.engimon.Geni;
//import entities.engimon.Teles;
//import enums.Elements;
//
//import java.util.EnumSet;
//
//public class TestingInventory {
//    public static void main(String[] args) {
//        Teles engi1 = new Teles("pokemon1", 20,20);
//        Geni engi2 = new Geni("pokemon2", 21,20);
//        Teles engi3 = new Teles("pokemon3", 22,20);
//        Geni engi4 = new Geni("pokemon4", 23,20);
//
//        engi3.setLevel(5);
//
//        InventoryEngimon engiBag = new InventoryEngimon();//instantiasi
//        engiBag.addItem(engi1,1);
//        engiBag.addItem(engi2,1);
//        engiBag.addItem(engi4,1);
//        engiBag.addItem(engi3,1);
//        engiBag.showInventory();
//        System.out.println("===================jml item");
//        System.out.println(Inventory.getJumlahItem());
//
//        Skill sk1 = new Skill("lari",200,2, EnumSet.of(Elements.WATER));
//        Skill sk2 = new Skill("mangan",300,2,EnumSet.of(Elements.WATER));
//        Skill sk3 = new Skill("turu",200,2,EnumSet.of(Elements.WATER));
//        Skill sk4 = new Skill("nglamun",400,2,EnumSet.of(Elements.ELECTRIC));
//
//        SkillItem ski1 = new SkillItem(sk1);
//        SkillItem ski2 = new SkillItem(sk2);
//        SkillItem ski3 = new SkillItem(sk3);
//        SkillItem ski4 = new SkillItem(sk4);
//
//        InventorySkillItem skillBag = new InventorySkillItem();
//
//        skillBag.addItem(ski1, 1);
//        skillBag.addItem(ski2,1);
//        skillBag.addItem(ski3,1);
//        skillBag.addItem(ski4,1);
//        skillBag.addItem(ski4,1);
//
//        skillBag.showInventory();
//        skillBag.deleteItemByIdx(1,1);
//        skillBag.showInventory();
//        System.out.println("===================jml item");
//        System.out.println(Inventory.getJumlahItem());
////        System.out.println(engiBag.getItemByIdxShowInventory(3));
//        engiBag.deleteItemByIdx(3,1);
//        engiBag.showInventory();
//    }
//}
