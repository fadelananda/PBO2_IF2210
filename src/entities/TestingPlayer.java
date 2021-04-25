package entities;

import entities.engimon.Engimon;
import entities.engimon.Geni;
import entities.engimon.Gledek;
import entities.engimon.Teles;
import enums.Elements;

import java.util.EnumSet;

public class TestingPlayer {
    public static void main(String[] args) {
//        Player tang = new Player();
//
//        Teles engi1 = new Teles("pokemon1", 20,20);
//        Geni engi2 = new Geni("pokemon2", 21,20);
//        Teles engi3 = new Teles("pokemon3", 22,20);
//        Geni engi4 = new Geni("pokemon4", 23,20);
//        engi2.setLevel(5);
//        engi3.setLevel(5);
//
//        tang.addEngimon(engi1);
//        tang.addEngimon(engi2);
//        tang.addEngimon(engi4);
//        tang.addEngimon(engi3);
//
//        System.out.println();
//        System.out.println("===================engi bag");
//        tang.tampilkanListEngimon();
//        System.out.println("===================jml item");
//        System.out.println("total " + tang.countBag());
//        System.out.println();
//
//        System.out.println();
//        tang.setActiveEngimon();
//        System.out.println("===================active engi");
//        tang.tampilkanDataEngimon(tang.getActiveEngimon());
//        System.out.println();
//        System.out.println("===================interact");
//        tang.interactActiveEngimon();
//        System.out.println("===================jml item");
//        System.out.println("total " + tang.countBag());
//        System.out.println();
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
//        tang.addSkillItem(ski1, 1);
//        tang.addSkillItem(ski2,1);
//        tang.addSkillItem(ski3,1);
//        tang.addSkillItem(ski4,1);
//
//        System.out.println();
//        System.out.println("===================skillitem bag");
//        tang.tampilkanListSkillItem();
//        System.out.println("===================jml item");
//        System.out.println("total " + tang.countBag());
//        System.out.println();
//
//        System.out.println();
//        tang.useSkillItem(tang.getActiveEngimon());
//        System.out.println("===================active engi");
//        tang.tampilkanDataEngimon(tang.getActiveEngimon());
//        System.out.println("===================jml item");
//        System.out.println("total " + tang.countBag());
//        System.out.println();
//
//        //TESTING BATTLE
//
//        boolean isBattleFinised = false;
//        tang.battle(engi4, isBattleFinised);
//        System.out.println(tang.getActiveEngimon().getJumlahSkill());
//        //System.out.println("Jumlah skills engi1 : " + engi1)

        //TESTING BREED
        Player tes = new Player();
        Engimon dad = new Geni("geni1", 0, 0);
        Engimon mom = new Gledek("gledek1", 0, 9);

        dad.setLevel(4);
        mom.setLevel(4);

        dad.printInfo();
        mom.printInfo();

        System.out.println(dad.getSkills().length);
        System.out.println(mom.getSkills().length);
        Engimon res = tes.breed(dad, mom);
        res.printInfo();
    }
}
