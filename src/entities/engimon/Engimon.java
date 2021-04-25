package entities.engimon;

import entities.Point;
import entities.Skill;
import enums.Elements;
import interfaces.MoveAction;
import java.util.EnumSet;
import java.util.Random;

import GUI.Game;
import GUI.GameObject;
import GUI.KeyboardListener;
import GUI.RenderHandler;
import GUI.Sprite;
import GUI.Tiles;

public abstract class Engimon implements MoveAction, GameObject {
    // Attribute entities.engimon.Engimon
    private String name;
    private int life;
    private int level;
    private Skill[] skills;
    private Engimon[] parents;
    private EnumSet<Elements> elements;
    private Point location;
    private boolean hasParent;
    private int exp;
    private int cumulative_exp;
    private boolean isTame = false;

    /*ATTRIBUTE FOR GUI*/
    protected Sprite engiImg;
    protected Tiles engiTiles;
    static final int BORDER_UP = 10;
    static final int BORDER_DOWN = 645;
    static final int BORDER_LEFT = 0;
    static final int BORDER_RIGHT = 645;
    protected int xpos = 200;
    protected int ypos = 200;
    protected int speed = 7;
    private int nRandoms = 0;
    private int whereRandom = -1;
    protected int engiwidth;
    protected int engiheight;

    // Constructor
    public Engimon() {
        this.level = 1;
        this.life = 3;
        this.skills = new Skill[4];
        this.elements = EnumSet.noneOf(Elements.class);
        this.location = new Point(0, 0);
        this.exp = 0;
        this.cumulative_exp = 0;
        this.hasParent = false;
    }

    public Engimon(String name, int x, int y) {
        this.name = name;
        this.level = 1;
        this.life = 3;
        this.skills = new Skill[4];
        this.elements = EnumSet.noneOf(Elements.class);
        this.location = new Point(x, y);
        this.exp = 0;
        this.cumulative_exp = 0;
        this.hasParent = false;
        this.xpos = x;
        this.ypos = y;
        this.isTame= true;
    }

    // Abstract Method
    public abstract void interact();
    public abstract String getSpeciesName();
    public abstract void showDescription();

    // Implement Interface
    @Override
    public void moveUp() {
        this.location.setY(this.location.getY() + 1);
    }

    @Override
    public void moveDown() {
        this.location.setY(this.location.getY() - 1);
    }

    @Override
    public void moveRight() {
        this.location.setX(this.location.getX() + 1);
    }

    @Override
    public void moveLeft() {
        this.location.setX(this.location.getX() - 1);
    }

    // Print Methods
    public void printInfo() {
        System.out.println("Nama: " + this.name);
        System.out.println("Species: " + this.getSpeciesName());
        System.out.println("Level: " + this.level);
        System.out.print("Elemen: ");
        for (Elements element: this.elements) {
            printElement(element);
            System.out.print(" ");
        }
        System.out.println();
        System.out.print("Deskripsi Engimon: ");
        showDescription();
        printParents();
        printAllSkills();
        System.out.println();
    }

    public void printParents() {
        System.out.print("Induk: ");
        if (this.hasParent) {
            System.out.println();
            System.out.println("1. " + this.parents[0].getName() + " (" + this.parents[0].getSpeciesName() + ")");
            System.out.println("2. " + this.parents[1].getName() + " (" + this.parents[1].getSpeciesName() + ")");
        } else {
            System.out.println("Tidak punya orang tua.");
        }
    }

    public void printElement(Elements element) {
        if (element == Elements.FIRE) System.out.print("Fire");
        if (element == Elements.WATER) System.out.print("Water");
        if (element == Elements.ELECTRIC) System.out.print("Electric");
        if (element == Elements.GROUND) System.out.print("Ground");
        if (element == Elements.ICE) System.out.print("Ice");
    }

    public void printAllSkills() {
        System.out.println("Daftar Skill: ");
        for (int i = 0; i < getJumlahSkill(); i++) {
            System.out.println((i+1) + ". " + this.skills[i].getName());
            System.out.println("   Mastery Level :" + this.skills[i].getMasteryLevel());
            System.out.print("   Element: ");
            for (Elements element: this.elements) {
                printElement(element);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    // Getter
    public String getName() {
        return this.name;
    }

    public int getLife() {
        return this.life;
    }

    public int getLevel() {
        return this.level;
    }

    public Skill[] getSkills() {
        return this.skills;
    }

    public Engimon[] getParents() {
        return this.parents;
    }

    public EnumSet<Elements> getElements() {
        return this.elements;
    }

    public boolean hasParents() {
        return this.hasParent;
    }

    public int getExp() {
        return this.exp;
    }

    public int getCumExp() {
        return this.cumulative_exp;
    }

    public int getEngiWidth(){
        return engiwidth;
    }

    public int getEngiHeight(){
        return engiheight;
    }

    public int getXpos(){
        return xpos;
    }

    public int getYpos(){
        return xpos;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setCumExp(int cum_exp) {
        this.cumulative_exp = cum_exp;
    }

    public void setParent() {
        this.hasParent = true;
    }

    // Functions for parent
    public void addParent(Engimon mom, Engimon dad) {
        if (!hasParent) {
            this.parents = new Engimon[2];
            this.parents[0] = mom;
            this.parents[1] = dad;
            this.hasParent = true;
        }
    }

    // Functions for element
    public void addElement(Elements element) {
        this.elements.add(element);
    }

    // Functions for skill
    public boolean isFullSkills() {
        return getJumlahSkill() == 4;
    }

    public int getJumlahSkill() {
        int counter = 0;
        for (Skill skill : this.skills) {
            if (skill != null) {
                counter++;
            }
        }

        return counter;
    }

    public boolean hasSkill(Skill skill) {
        for (int i = 0; i < getJumlahSkill(); i++) {
            if (this.skills[i].getName().equals(skill.getName())) {
                return true;
            }
        }

        return false;
    }

    // Dipastikan skill sudah ada
    public Skill getSkillByName(String skillName) {
        for (int i = 0; i < this.getJumlahSkill(); i++) {
            if (this.skills[i].getName().equals(skillName)) {
                return this.skills[i];
            }
        }

        return null;
    }

    public void addSkill(Skill skill) {
        if (!isFullSkills() && isSkillValid(skill) && !hasSkill(skill)) {
            this.skills[this.getJumlahSkill()] = skill;
        }
    }

    public boolean isSkillValid(Skill skill) {
        for (Elements element : this.elements) {
            if (skill.getElements().contains(element)) {
                return true;
            }
        }

        return false;
    }

    public boolean isElementValid(EnumSet<Elements> elements)
    {
        for (Elements elem : elements)
        {
            if (!this.elements.contains(elem))
            {
                return false;
            }
        }
        return true;
    }

    public void replaceSkill(int index, Skill skill) {
        if (isSkillValid(skill)) {
            this.skills[index] = skill;
        }
    }

    // Functions for life
    public void reduceLife() {
        this.life--;
    }

    public void addLife() {
        this.life++;
    }

    // Functions for exp
    public void addExp(int exp) {
        this.exp += exp;
        this.cumulative_exp += exp;

        if (this.exp/100 > 0) {
            this.level += this.exp/100;
            this.exp -= 100*(this.exp/100);
        }
    }

    public String toString()
    {
        return String.format("%s/%s/Lv.%d", this.name, this.getSpeciesName(),this.level);
    }

    // GUI GUI an gaes
    public void render(RenderHandler renderer, int xzoom, int yzoom){
        renderer.renderSprite(engiImg, xpos, ypos, 3, 3);
    }

    public void update(Game game){
        KeyboardListener keyListener = game.getKeyListener();
        if(isTame){
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
        }
        else{
            Random rand = new Random();
            if(nRandoms == 0){
                whereRandom = rand.nextInt(6);
                nRandoms = 25;
            }
            if(whereRandom == 0 && (ypos >= BORDER_UP)){
                ypos -= 1;
                nRandoms--;
            }
            else if(whereRandom == 1 && (ypos <= BORDER_DOWN)){
                ypos += 1;
                nRandoms--;
            }
            else if(whereRandom == 2 && (xpos >= BORDER_LEFT)){
                xpos -= 1;
                nRandoms--;
            }
            else if(whereRandom == 3 && (xpos <= BORDER_RIGHT)){
                xpos += 1;
                nRandoms--;
            }
            else if(whereRandom == 4 || whereRandom == 5){
                nRandoms--;
            }
            else{
                nRandoms--;
            }
        }
    }
}
