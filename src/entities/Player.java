package entities;

import entities.engimon.Engimon;
import enums.Elements;
import interfaces.MoveAction;

import java.util.*;

public class Player {

    private InventoryEngimon EngiBag;
    private InventorySkillItem SkillItemBag;
    private float[][] elementAdvantage;
    private int idxCurrActiveEngimon;
    private Point plocation;

    public Player() {
        this.EngiBag = new InventoryEngimon();
        this.SkillItemBag = new InventorySkillItem();
        this.idxCurrActiveEngimon = 0;
        this.plocation = new Point(0, 0);
        initElmtAdvantage();
    }

    public void initElmtAdvantage() {
        this.elementAdvantage = new float[5][5];
        this.elementAdvantage[Elements.FIRE.ordinal()][Elements.FIRE.ordinal()] = 1.0f;
        this.elementAdvantage[Elements.FIRE.ordinal()][Elements.WATER.ordinal()] = 0.0f;
        this.elementAdvantage[Elements.FIRE.ordinal()][Elements.ELECTRIC.ordinal()] = 1.0f;
        this.elementAdvantage[Elements.FIRE.ordinal()][Elements.GROUND.ordinal()] = 0.5f;
        this.elementAdvantage[Elements.FIRE.ordinal()][Elements.ICE.ordinal()] = 2.0f;
        this.elementAdvantage[Elements.WATER.ordinal()][Elements.FIRE.ordinal()] = 2.0f;
        this.elementAdvantage[Elements.WATER.ordinal()][Elements.WATER.ordinal()] = 1.0f;
        this.elementAdvantage[Elements.WATER.ordinal()][Elements.ELECTRIC.ordinal()] = 0.0f;
        this.elementAdvantage[Elements.WATER.ordinal()][Elements.GROUND.ordinal()] = 1.0f;
        this.elementAdvantage[Elements.WATER.ordinal()][Elements.ICE.ordinal()] = 1.0f;
        this.elementAdvantage[Elements.ELECTRIC.ordinal()][Elements.FIRE.ordinal()] = 1.0f;
        this.elementAdvantage[Elements.ELECTRIC.ordinal()][Elements.WATER.ordinal()] = 2.0f;
        this.elementAdvantage[Elements.ELECTRIC.ordinal()][Elements.ELECTRIC.ordinal()] = 1.0f;
        this.elementAdvantage[Elements.ELECTRIC.ordinal()][Elements.GROUND.ordinal()] = 0.0f;
        this.elementAdvantage[Elements.ELECTRIC.ordinal()][Elements.ICE.ordinal()] = 1.5f;
        this.elementAdvantage[Elements.GROUND.ordinal()][Elements.FIRE.ordinal()] = 1.5f;
        this.elementAdvantage[Elements.GROUND.ordinal()][Elements.WATER.ordinal()] = 1.0f;
        this.elementAdvantage[Elements.GROUND.ordinal()][Elements.ELECTRIC.ordinal()] = 2.f;
        this.elementAdvantage[Elements.GROUND.ordinal()][Elements.GROUND.ordinal()] = 1.0f;
        this.elementAdvantage[Elements.GROUND.ordinal()][Elements.ICE.ordinal()] = 0.0f;
        this.elementAdvantage[Elements.ICE.ordinal()][Elements.FIRE.ordinal()] = 0.0f;
        this.elementAdvantage[Elements.ICE.ordinal()][Elements.WATER.ordinal()] = 1.0f;
        this.elementAdvantage[Elements.ICE.ordinal()][Elements.ELECTRIC.ordinal()] = 0.5f;
        this.elementAdvantage[Elements.ICE.ordinal()][Elements.GROUND.ordinal()] = 2.0f;
        this.elementAdvantage[Elements.ICE.ordinal()][Elements.ICE.ordinal()] = 1.0f;
    }

    // GETTER
    public InventoryEngimon getEngiBag() {
        return this.EngiBag;
    }

    public InventorySkillItem getSkillItemBag() {
        return this.SkillItemBag;
    }

    public int countBag() {
        return Inventory.getJumlahItem();
    }

    public int getIdxCurrActiveEngimon() {
        return this.idxCurrActiveEngimon;
    }

    public int getX_pl() {
        return this.plocation.getX();
    }

    public int getY_pl() {
        return this.plocation.getY();
    }


    // Add item
    public void addEngimon(Engimon engimon) {
        this.EngiBag.addItem(engimon,1);
    }

    public void addSkillItem(SkillItem item, int n) {
        this.SkillItemBag.addItem(item,n);
    }

    // Setter
    public void setX_pl(int X) {
        this.plocation.setX(X);
    }

    public void setY_pl(int Y) {
        this.plocation.setY(Y);
    }


    // BATTLE
   public void battle(Engimon Opponent, boolean isBattleHasFinished) {
      // anggaplah kalau tidak ada engimon yang aktif
      // idxCurrActiveEngimo = -1
      if(this.idxCurrActiveEngimon == -1){
          System.out.println("Anda tidak memiliki Engimon yang aktif!");
          System.out.println("Silahkan memilih Engimon terlebih dahulu...");
          isBattleHasFinished = true;
          return;
      }
      else{
          Engimon playerEngimon = this.getActiveEngimon();

          // Hitung power
          int playerLevel = playerEngimon.getLevel();
          int oppLevel = Opponent.getLevel();
          float playerElmtAdvantage = this.getAdvantage(playerEngimon.getElements(), Opponent.getElements());
          float oppElmtAdvantage = this.getAdvantage(Opponent.getElements(), playerEngimon.getElements());
          //sum every skill base power * mastery_level
          float playerSkillPoint = calSkillPoint(playerEngimon);
          float oppSkillPoint = calSkillPoint(Opponent);

          float playerPower = playerLevel*playerElmtAdvantage + playerSkillPoint;
          float oppPower = oppLevel*oppElmtAdvantage + oppSkillPoint;

          //tampilkan status lengkap engimon musuh
          Opponent.printInfo();
          System.out.println("Total power level " +  Opponent.getName() + " : " + oppPower + " (OPPONENT)");
          System.out.println("Total power level " +  playerEngimon.getName() + " : " + playerPower + " (PLAYER)");

          //berikan opsi proceed battle/not
          Scanner sc = new Scanner(System.in);

          // Character input
          System.out.print("Proceed the battle (Y/N) : ");
          char opt = sc.next().charAt(0);
          if(opt == 'Y') {
              System.out.println("Memulai Battle...");
              if(playerPower >= oppPower){
                  System.out.println("Engimon Anda memenangkan battle ini!");
                  // Engimon lawan menjadi milik player, jika inventory cukup
                  if(this.EngiBag.listInventory.size() < Inventory.MAX_INVENTORY){
                      System.out.println("Anda mendapatkan Engimon musuh!");
                      this.addEngimon(Opponent);
                      System.out.println("Jumlah items dalam inventory Anda sekarang: " + Inventory.jumlahItem);
                  }
                  //mendapatkan exp sebesar 20 satuan exp
                  playerEngimon.addExp(20);
                  //mendapatkan skill item pada slot pertama musuh
                  System.out.println("Anda mendapatkan skill : " + Opponent.getSkills()[0].getName());
                  //tambahkan ke skill item
                  this.SkillItemBag.addItem(new SkillItem(Opponent.getSkills()[0]), 1);
              }
              else{
                  System.out.println("Engimon Anda kalah");
                  playerEngimon.reduceLife();
                  if(playerEngimon.getLife() == 0){
                      System.out.println("Engimon yang aktif sudah mati");
                      System.out.println("Silahkan memilih Engimon pada inventory Anda");
                      this.idxCurrActiveEngimon = -1;
                  }
                  sc.next();
                  return;
              }
          } else{
              isBattleHasFinished = true;
              return;
          }
      }
   }

   private float calSkillPoint(Engimon e){
        float skillPoint = 0.0f;
        for(Skill s : e.getSkills()){
            if(s != null){
                skillPoint += s.getBasePower()*s.getMasteryLevel();
            }
        }
        return skillPoint;
   }

   private float getAdvantage(EnumSet<Elements> e1, EnumSet<Elements> e2){
        float mxAdvantage = 0.0f;
        for(Elements e_1 : e1){
            for(Elements e_2 : e2){
                mxAdvantage = Math.max(mxAdvantage, checkAdvantage(e_1, e_2));
            }
        }
        return mxAdvantage;
   }


    // BREEDING
//    public Engimon breed(Engimon dad, Engimon mom) {
//        if (dad.getLevel() >= 4 && mom.getLevel() >= 4) {
//            String nama;
//            Skill[] inheritedSkill = this.inheritSkill(dad, mom);
//            EnumSet<Elements> inheritedElmt = this.inheritElement(dad, mom);
//            String inheritedSpecies = this.inheritSpecies(inheritedElmt);
//
//            Scanner keyboard = new Scanner(System.in);
//            System.out.print("Masukkan nama buat engimon anak ini: ");
//            nama = keyboard.nextLine();
//
//            // Engimon child(nama, getX_pl(), getY_pl(), inheritedSpecies);
//
//            Engimon child(nama, this.plocation.getX(), this.plocation.getY());
//
//            Iterator<Elements> iterate = inheritedElmt.iterator();
//
//            while (iterate.hasNext()) {
//                Elements itr = iterate.next();
//                child.addElement(itr);
//            }
//
//            for (list<Skill>::iterator itr = inheritedSkill.begin(); itr != inheritedSkill.end(); ++itr) {
//                if (contains(inheritedElmt, itr->getElement()) && !child.hasSkill(*itr) && !child.IsFullSkills()) {
//                    child.addSkill(*itr);
//                }
//            }
//
//            dad.setLevel(dad.getLevel() - 3);
//            mom.setLevel(mom.getLevel() - 3);
//
//            child.makeParents(*dad,*mom);
//
//            return child;
//        } else {
//            throw "Level Orang Tua Kurang Tinggi!";
//        }
//    }

    public Skill[] inheritSkill(Engimon dad, Engimon mom) {
        Skill[] retSkill = new Skill[4];
        Skill[] combinedSkill = new Skill[8];

        Skill[] dadSkill = dad.getSkills();
        Skill[] momSkill = mom.getSkills();

        for (int i = 0; i < dad.getJumlahSkill(); i++) {
            combinedSkill[i] = dadSkill[i];
        }

        for (int i = 0; i < mom.getJumlahSkill(); i++) {
            combinedSkill[i+4] = momSkill[i];
        }

        Arrays.sort(combinedSkill, Comparator.comparingInt(Skill :: getMasteryLevel));
        Collections.reverse(Arrays.asList(combinedSkill));

        int nSkill = 0;
        for(Skill skill : combinedSkill) {
            if (dad.hasSkill(skill) && mom.hasSkill(skill)) {
//                if (dad.getSkillMasteryLevel(*itr) == mom.getSkillMasteryLevel(*itr)) {
//                    itr->setMasteryLevel(itr->getMasteryLevel() + 1);
//                    retSkill.push_back(*itr);
//                } else {
//                    if (dad.getSkillEngimon(*itr) > mom.getSkillEngi(*itr)) {
//                        retSkill.push_back(dad.getSkillEngi(*itr));
//                    } else {
//                        retSkill.push_back(mom.getSkillEngi(*itr));
//                    }
//                }
            } else {
                retSkill[nSkill] = skill;
                nSkill++;
            }
        }

          return retSkill;
    }

    public boolean compareMasteryLevel(Skill elmt1, Skill elmt2) {
        return elmt1.getMasteryLevel() > elmt2.getMasteryLevel();
    }

    public EnumSet<Elements> inheritElement(Engimon dad, Engimon mom) {
        EnumSet<Elements> inheritedElement = EnumSet.noneOf(Elements.class);

        Iterator<Elements> dadItr = dad.getElements().iterator();
        Elements dadElmt = dadItr.next();
        Iterator<Elements> momItr = mom.getElements().iterator();
        Elements momElmt = momItr.next();

        if (dadElmt.equals(momElmt)) {
            inheritedElement.add(dadElmt);
        } else {
            // Cek element advantage
            if (checkAdvantage(dadElmt, momElmt) > 1) {
                inheritedElement.add(dadElmt);
            } else if (checkAdvantage(dadElmt, momElmt) == 1) {
                inheritedElement.add(dadElmt);
                inheritedElement.add(momElmt);
            } else {
                inheritedElement.add(momElmt);
            }
        }
        return inheritedElement;
    }

    public float checkAdvantage(Elements elmt1, Elements elmt2) {
        return this.elementAdvantage[elmt1.ordinal()][elmt2.ordinal()];
    }

    public String inheritSpecies(EnumSet<Elements> inheritedElmt) {
        if (inheritedElmt.size() == 1) {
            if (inheritedElmt.contains(Elements.FIRE)) {
                return "Geni";
            } else if (inheritedElmt.contains(Elements.WATER)) {
                return "Teles";
            } else if (inheritedElmt.contains(Elements.ELECTRIC)) {
                return "Gledek";
            } else if (inheritedElmt.contains(Elements.GROUND)) {
                return "Watoo";
            } else if (inheritedElmt.contains(Elements.ICE)) {
                return "Wadem";
            }
        } else if (inheritedElmt.size() == 2) {
            if (inheritedElmt.contains(Elements.FIRE) && inheritedElmt.contains(Elements.ELECTRIC)) {
                return "Koobong";
            } else if (inheritedElmt.contains(Elements.WATER) && inheritedElmt.contains(Elements.GROUND)) {
                return "Lapindoo";
            } else if (inheritedElmt.contains(Elements.WATER) && inheritedElmt.contains(Elements.ICE)) {
                return "Beckoo";
            }
        }
        return "";
    }

    // Show somethin'
    public void tampilkanListSkillItem() {
        this.SkillItemBag.showInventory();
    }

    public void tampilkanListEngimon() {
        this.EngiBag.showInventory();
    }

    public void tampilkanDataEngimon(Engimon engimon) {
        engimon.printInfo();
    }

    // Active engimon methods
    public Engimon getActiveEngimon() {
        return this.EngiBag.getItemByIdxShowInventory(this.idxCurrActiveEngimon);
    }

    public void setActiveEngimon() {
        int newActive;
        tampilkanListEngimon();
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Masukkan nomor engimon untuk diaktifkan : ");
        newActive = keyboard.nextInt();
        this.idxCurrActiveEngimon = newActive;
    }

    public void interactActiveEngimon() {
        getActiveEngimon().interact();
    }

    public void useSkillItem(Engimon engimon) {
        Scanner keyboard = new Scanner(System.in);
        SkillItemBag.showInventory();
        System.out.println("=======================================================================");
        System.out.println("input indeks skill yang ingin di pelajari");
        System.out.print(">> ");
        int idx = keyboard.nextInt();

        SkillItemBag.learnSkillItem(idx, engimon);
    }


    // ISIAN GUInya BELOM
    // ...
    public static void main(String[] args){

    }
}