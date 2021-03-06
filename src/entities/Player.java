package entities;

import GUI.*;
import entities.engimon.*;
import enums.Elements;

import javax.swing.*;
import java.util.*;

public class Player implements GameObject {

    private InventoryEngimon EngiBag;
    private InventorySkillItem SkillItemBag;
    private float[][] elementAdvantage;
    private int idxCurrActiveEngimon;
    private Point plocation;

    /*FIELDS FOR GUI*/
    private Sprite playerAvatar;
    int speed = 10;
    static final int BORDER_UP = 10;
    static final int BORDER_DOWN = 645;
    static final int BORDER_LEFT = 0;
    static final int BORDER_RIGHT = 645;
    private Tiles engiTiles;
    private int xpos = 300; //spawn position
    private int ypos = 450; //spawn position
    private int playerwidth;
    private int playerheight;

    public Player(SpriteSheet avaspritesh, Tiles engiTiles) {
        this.EngiBag = new InventoryEngimon();
        this.SkillItemBag = new InventorySkillItem();
        this.idxCurrActiveEngimon = 0;
        this.plocation = new Point(0, 0);
        this.engiTiles = engiTiles;
        initElmtAdvantage();

        //GUI
        playerAvatar = avaspritesh.getSprite(1, 0);
        playerwidth = playerAvatar.getWidth();
        playerheight = playerAvatar.getHeight();
    }

    //for testing method
    public Player(){
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

    public int getPlayerWidth(){
        return playerwidth;
    }

    public int getPlayerHeight(){
        return playerheight;
    }

    public int getXpos(){
        return xpos;
    }

    public int getYpos(){
        return ypos;
    }

    // Add item
    public void addEngimon(Engimon engimon) {
        engimon.setTame(true);
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
    public void battlePrepare(StatusPanel panel, Engimon Opponent) {
        // anggaplah kalau tidak ada engimon yang aktif
        // idxCurrActiveEngimo = -1
        if(this.idxCurrActiveEngimon == -1){
            JOptionPane.showMessageDialog(null, "Anda tidak memiliki Engimon yang aktif!", "Battle Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else {
            Engimon playerEngimon = this.getActiveEngimon();
            new BattleFrame(panel, this, Opponent, playerEngimon);
        }
    }

    public void battle(float playerPower, float oppPower, Engimon opp, Engimon engiPlayer) {
          if(playerPower >= oppPower){
              JOptionPane.showMessageDialog(null, "Engimon Anda memenangkan battle ini!", "Battle Win", JOptionPane.PLAIN_MESSAGE);
              // Engimon lawan menjadi milik player, jika inventory cukup
              if(this.EngiBag.listInventory.size() < Inventory.MAX_INVENTORY){
                  this.addEngimon(opp);
              }
              //mendapatkan exp sebesar 20 satuan exp
              engiPlayer.addExp(20);

              // Cek cumulative exp melebihi batas maka mati
              if (engiPlayer.getCumExp() >= 80) {
                this.getEngiBag().getEngimonList().remove(engiPlayer);
                this.idxCurrActiveEngimon = -1;
                JOptionPane.showMessageDialog(null, "Engimon Yang Aktif Sudah Mati!", "Pemakaman", JOptionPane.WARNING_MESSAGE);
              }

              //tambahkan ke skill item
              this.SkillItemBag.addItem(new SkillItem(opp.getSkills()[0]), 1);
          }
          else{
              JOptionPane.showMessageDialog(null, "Engimon Anda Kalah!", "Battle Loss", JOptionPane.ERROR_MESSAGE);
              engiPlayer.reduceLife();
              if(engiPlayer.getLife() == 0){
                  JOptionPane.showMessageDialog(null, "Engimon Yang Aktif Sudah Mati!", "Battle Loss", JOptionPane.WARNING_MESSAGE);
                  this.getEngiBag().getEngimonList().remove(engiPlayer);
                  this.idxCurrActiveEngimon = -1;
              }
              return;
          }
   }

   public float calSkillPoint(Engimon e){
        float skillPoint = 0.0f;
        for(Skill s : e.getSkills()){
            if(s != null){
                skillPoint += s.getBasePower()*s.getMasteryLevel();
            }
        }
        return skillPoint;
   }

   public float getAdvantage(EnumSet<Elements> e1, EnumSet<Elements> e2){
        float mxAdvantage = 0.0f;
        for(Elements e_1 : e1){
            for(Elements e_2 : e2){
                mxAdvantage = Math.max(mxAdvantage, checkAdvantage(e_1, e_2));
            }
        }
        return mxAdvantage;
   }



    // BREEDING
    public Engimon breed(Engimon dad, Engimon mom, String nama) throws Exception{
        if (dad.getLevel() >= 4 && mom.getLevel() >= 4 && !nama.equals(null)) {
            // list of inherited parent skills
            Skill[] inheritedSkill = this.inheritSkill(dad, mom);
            // resulting child element
            EnumSet<Elements> inheritedElmt = this.inheritElement(dad, mom);
            // resulting child species
            String inheritedSpecies = this.inheritSpecies(inheritedElmt);


            Engimon child = null;
            if(inheritedSpecies == "Beckoo") child = new Beckoo(this.engiTiles, nama, this.plocation.getX(), this.plocation.getY());
            else if(inheritedSpecies == "Geni") child = new Geni(this.engiTiles, nama, this.plocation.getX(), this.plocation.getY());
            else if(inheritedSpecies == "Gledek") child = new Gledek(this.engiTiles, nama, this.plocation.getX(), this.plocation.getY());
            else if(inheritedSpecies == "Koobong") child = new Koobong(this.engiTiles, nama, this.plocation.getX(), this.plocation.getY());
            else if(inheritedSpecies == "Lapindoo") child = new Lapindoo(this.engiTiles, nama, this.plocation.getX(), this.plocation.getY());
            else if(inheritedSpecies == "Teles") child = new Teles(this.engiTiles, nama, this.plocation.getX(), this.plocation.getY());
            else if(inheritedSpecies == "Wadem") child = new Wadem(this.engiTiles, nama, this.plocation.getX(), this.plocation.getY());
            else if(inheritedSpecies == "Watoo") child = new Watoo(this.engiTiles, nama, this.plocation.getX(), this.plocation.getY());

            Iterator<Elements> iterate = inheritedElmt.iterator();

            while (iterate.hasNext()) {
                Elements itr = iterate.next();
                child.addElement(itr);
            }

            for(Skill s : inheritedSkill){
                if(s == null) continue;
                child.addSkill(s);
            }

            dad.setLevel(dad.getLevel() - 3);
            mom.setLevel(mom.getLevel() - 3);

            return child;
        } else if (nama.equals(null)) {
            throw new Exception("Nama Kosong!");
        } else {
            throw new Exception("Level Orangtua Kurang Tinggi!");
        }
    }

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

        Arrays.sort(combinedSkill, Comparator.nullsFirst(Comparator.comparingInt(Skill::getMasteryLevel)));
        Collections.reverse(Arrays.asList(combinedSkill));

        /*
        for(Skill s : combinedSkill){
            if(s == null) System.out.println("null");
            else System.out.println(s.getName());
        } */
        int nSkill = 0;
        for(Skill skill : combinedSkill) {
            //jika skill sekarang termasuk skill unik engimon
            if(nSkill == 4) break;
            if(skill == null) continue;
            if (dad.hasSkill(skill) && mom.hasSkill(skill)) {
                retSkill[nSkill] = skill;
                Skill currDadSkill = dad.getSkillByName(skill.getName());
                Skill currMomSkill = mom.getSkillByName(skill.getName());
                if(currDadSkill.getMasteryLevel() !=
                        currMomSkill.getMasteryLevel()){
                    retSkill[nSkill].setMasteryLevel(Math.max(currDadSkill.getMasteryLevel(), currMomSkill.getMasteryLevel()));
                }
                else retSkill[nSkill].setMasteryLevel(Math.min(skill.getMasteryLevel()+1, 3));
                nSkill++;
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

    public void setActiveEngimon(ArrayList<GameObject> objc) {
        JDialog selectEngi = new selectActiveFrame(this, objc);
        selectEngi.setVisible(true);
    }

//    public void interactActiveEngimon() {
//        getActiveEngimon().interact();
//    }
//
//    public void useSkillItem(Engimon engimon) {
////        Scanner keyboard = new Scanner(System.in);
////        SkillItemBag.showInventory();
////        System.out.println("=======================================================================");
////        System.out.println("input indeks skill yang ingin di pelajari");
////        System.out.print(">> ");
////        int idx = keyboard.nextInt();
////
////        SkillItemBag.learnSkillItem(idx, engimon);
//    }


    // ISIAN GUInya BELOM
    // GUI sudah
    public void render(RenderHandler renderer, int xzoom, int yzoom){
        renderer.renderSprite(playerAvatar, xpos, ypos, 2, 2);
    }

    public void update(Game game){
        KeyboardListener keyListener = game.getKeyListener();
        ArrayList<GameObject> objc = game.getObjects();

        if(keyListener.up() && (ypos >= BORDER_UP)){
            ypos -= speed;
        }
        if(keyListener.down() && (ypos <= BORDER_DOWN)){
            ypos += speed;
        }
        if(keyListener.left() && (xpos >= BORDER_LEFT)){
            xpos -= speed;
        }
        if(keyListener.right() && (xpos <= BORDER_RIGHT)){
            xpos += speed;
        }
        if(keyListener.q()){
            setActiveEngimon(objc);
        }
    }

    public void setIdxCurrActiveEngimon(int idxCurrActiveEngimon) {
        this.idxCurrActiveEngimon = idxCurrActiveEngimon;
    }

    public static void main(String[] args){

    }
}
