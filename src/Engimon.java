import java.util.*;

public abstract class Engimon {
    // Attribute Engimon
    private String name;
    private int life;
    private int level;
    private Skill[] skills = new Skill[4];
    private Engimon[] parents= new Engimon[2];
    private EnumSet<Elements> elements;
    private boolean hasParent;
    private int exp;
    private int cumulative_exp;

    // Abstract Method
    public abstract void showAura();
    public abstract String getSpeciesName();
    public abstract void showDescription();

    public void printAllSkills() {
        for (int i = 0; i < getJumlahSkill(); i++) {
            System.out.println((i+1) + ". " + this.skills[i].getName());
            System.out.println("Mastery Level :" + this.skills[i].getMasteryLevel());
            System.out.print("Element: ");
            this.skills[i].printElements();
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

    public Set<Elements> getElements() {
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
            this.parents[0] = mom;
            this.parents[1] = dad;
        }
    }

    // Functions for element
    public void addElement(Elements element) {
        this.elements.add(element);
    }

    // Functions for skill
    public boolean isFullSkills() {
        return this.skills.length == 4;
    }

    public int getJumlahSkill() {
        return this.skills.length;
    }

    public void addSkill(Skill skill) {
        if (!isFullSkills() && isSkillValid(skill)) {
            this.skills[this.skills.length - 1] = skill;
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
}
