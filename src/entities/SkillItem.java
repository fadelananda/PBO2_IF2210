package entities;

public class SkillItem {
    private int skillItemId;
    private static int skillItemCount = 0;
    private Skill skill;

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
//    public boolean learn(Engimon)
}



//        bool Skill_Item::learn(Engimon* engi){
//        if (engi->isElementValid(this->skill.getElement()))
//        {
//        if (engi->IsSkillValid(this->skill))
//        {
//        if ( engi->getJumlahSkill() < 4)
//        {
//        engi->addSkill(this->skill);
//        cout << this->skill.getSkillName() <<" berhasil dipelajari "<< engi->getName() << endl;
//        return true;
//        }else{
//        engi->printAllSkill();
//        cout <<"=======================================================================" <<endl;
//        cout << "input indeks skill yang ingin di replace\n" << ">>";
//        int indexReplace;
//        cin >> indexReplace;
//        engi->replaceSkill(indexReplace - 1, this->skill);
//        cout <<"=======================================================================" <<endl;
//        cout << this->skill.getSkillName() <<" berhasil dipelajari "<< engi->getName() << endl;
//        return true;
//        }
//
//        }else{
//        cout << "Skill sudah dipelajari "<< engi->getName() << endl;
//        return false;
//        }
//
//        }else{
//        cout << "Element skill item tidak kompatibel dengan " << engi->getName()<< endl;
//        return false;
//        }
//        }