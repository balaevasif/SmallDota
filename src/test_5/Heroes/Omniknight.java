package test_5.Heroes;

public class Omniknight extends Hero {
    public double PurificationHeal = 100;
    public double PurificationMP = 50;
    public String PurificationDesc = "Heal HP himself or his teammate";

    public double HeavenlyGraceHealMP = 200;
    public double HeavenlyGraceMP = 50;
    public String HeavenlyGraceDesc = "Heal MP himself or his teammate";

    public double DegenAuraDef = 10;
    public double DegenAuraDefMP = 100;
    public String DegenAuraDefDesc = "Add armor himself or his teammate";

    public double GuardianAngel = 300;
    public double GuardianAngelMP = 300;
    public String GuardianAngelDesc = "Heal HP all teammate";

    //List<List<String>> s = new ArrayList<>();

    private void getSkills() {
        skills.put("1. Purification Heal: " + PurificationDesc + " Heal: " + Double.toString(PurificationHeal) + " MP: ", PurificationMP);
        skills.put("2. Heavenly Grace: " + HeavenlyGraceDesc + " Heal: " + Double.toString(HeavenlyGraceHealMP) + " MP: ", HeavenlyGraceMP);
        skills.put("3. Degen Aura Def: " + DegenAuraDefDesc + " Armor: " + Double.toString(DegenAuraDef) + " MP: ", DegenAuraDefMP);
        skills.put("4. Guardian Angel: " + GuardianAngelDesc + " Heal: " + Double.toString(GuardianAngel) + " MP: ", GuardianAngelMP);
    }

    public Omniknight(){
        setName("Omniknight");
        setDamage(130);
        setAgility(60);
        setArmor(80);
        setMagResist(100);
        setHP(500);
        setMP(500);
        getSkills();
        id++;
    }

    public void Purification(Hero teammate){
        if (PurificationMP <= MP) {
            teammate.HP += PurificationHeal;
            MP -= PurificationMP;
            System.out.println(name + " casts the Purification spell and healing " + PurificationHeal + " HP -> " + teammate.name);
        }
        else{System.out.println("Недостаточно маны");}
    }

    public void HeavenlyGrace(Hero teammate){
        if (HeavenlyGraceMP <= MP) {
            teammate.MP += HeavenlyGraceHealMP;
            MP -= HeavenlyGraceMP;
            System.out.println(name + " casts the Heavenly Grace spell and healing " + HeavenlyGraceHealMP + " MP -> " + teammate.name);
        }
        else{System.out.println("Недостаточно маны");}
    }

    public void DegenAura(Hero teammate){
        if (DegenAuraDefMP <= MP) {
            teammate.armor += DegenAuraDefMP;
            MP -= DegenAuraDefMP;
            System.out.println(name + " casts the Degen Aura spell and adding " + DegenAuraDef + " armor ->" + teammate.name);
        }
        else{System.out.println("Недостаточно маны");}
    }

    public void GuardianAngels(Hero teammate1, Hero teammate2, Hero teammate3, Hero teammate4, Hero teammate5){
        teammate1.HP += GuardianAngel;
        teammate2.HP += GuardianAngel;
        teammate3.HP += GuardianAngel;
        teammate4.HP += GuardianAngel;
        teammate5.HP += GuardianAngel;
        MP -= GuardianAngelMP;
    }

    public void GuardianAngels(Hero teammate1){
        if (DegenAuraDefMP <= MP) {
            teammate1.HP += GuardianAngel;
            MP -= GuardianAngelMP;
            System.out.println(name + " casts the Guardian Angel spell and healing " + GuardianAngel + " HP ->" + teammate1.name);
        }
        else{System.out.println("Недостаточно маны");}
    }

    @Override
    public void cast(int spell, Hero enemy) {
        switch (spell){
            case 1:
                Purification(enemy);
            case 2:
                HeavenlyGrace(enemy);
            case 3:
                DegenAura(enemy);
            case 4:
                GuardianAngels(enemy);
        }
    }
}
