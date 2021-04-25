package entities;
import entities.engimon.Engimon;

import java.util.Scanner;

public class SkillItem {
    private int skillItemId;
    private static int skillItemCount = 0;
    private Skill skill;

    //ctor
    public SkillItem(){}

    public SkillItem(Skill skill)
    {
        this.skill = skill;
        skillItemCount++;
        skillItemId = skillItemCount;
    }

    public static int getSkillItemCount()
    {
        return skillItemCount;
    }

    public int getSkillItemId()
    {
        return this.skillItemId;
    }

    public Skill getSkill()
    {
        return this.skill;
    }

    public String toString()
    {
        return String.format("%s/Pow:%d", this.skill.getName(),this.skill.getBasePower());
    }

    public boolean learn(Engimon engi){
        if (engi.isElementValid(this.skill.getElements()))
        {
            if (engi.isSkillValid(this.skill))
            {
                if (engi.getJumlahSkill() < 4)
                {
                    engi.addSkill(this.skill);
                    System.out.println(this.skill.getName() + " berhasil dipelajari "+ engi.getName());
                    return true;
                }else
                {
                    Scanner keyboard = new Scanner(System.in);
                    engi.printAllSkills();
                    System.out.println("=======================================================================");
                    System.out.println("input indeks skill yang ingin di replace");
                    System.out.println(">>");
                    int indexReplace;
                    indexReplace = keyboard.nextInt();
                    engi.replaceSkill(indexReplace-1,this.skill);
                    System.out.println("=======================================================================");
                    System.out.println(this.skill.getName() + " berhasil dipelajari "+ engi.getName());
                    return true;
                }
            }else
            {
                System.out.println("Skill sudah dipelajari " + engi.getName());
                return false;
            }
        }else
        {
            System.out.println("Element skill item tidak kompatibel dengan " + engi.getName());
            return false;
        }
    }
}