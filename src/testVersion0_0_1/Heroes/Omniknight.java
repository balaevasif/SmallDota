package testVersion0_0_1.Heroes;

public class Omniknight extends Hero {
    private double PurificationHeal = 100;
    private double PurificationMP = 50;
    private String PurificationDesc = "1. Heal HP himself or his teammate. HP+ " + PurificationHeal + " takes MP: " + PurificationMP;

    private double HeavenlyGraceHealMP = 200;
    private double HeavenlyGraceMP = 50;
    private String HeavenlyGraceDesc = "||| 2. Heal MP himself or his teammate. MP+ " + HeavenlyGraceHealMP + " takes MP: " + HeavenlyGraceMP;

    private double DegenAuraDef = 10;
    private double DegenAuraDefMP = 100;
    private String DegenAuraDefDesc = "||| 3. Add armor himself or his teammate. Armor+ " + DegenAuraDef + " takes MP: " + DegenAuraDefMP;

    private double GuardianAngel = 500;
    private double GuardianAngelMP = 300;
    private String GuardianAngelDesc = "||| 4. Heal: " + GuardianAngel + " HP and Heal: " + GuardianAngel + " MP takes MP: " + GuardianAngelMP;

    private void attackOrBuffs() {
        attackOrBuff.put(1, 2);
        attackOrBuff.put(2, 2);
        attackOrBuff.put(3, 2);
        attackOrBuff.put(4, 2);
    }
    private void getSkills() {
        Skills.add(PurificationDesc);
        Skills.add(HeavenlyGraceDesc);
        Skills.add(DegenAuraDefDesc);
        Skills.add(GuardianAngelDesc);
}

    public Omniknight(){
        setName("Omniknight");
        setDamage(130);
        setAgility(60);
        setArmor(80);
        setMagResist(100);
        setHP(1000);
        setMP(1500);
        getSkills();
        attackOrBuffs();
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
    public void GuardianAngels(Hero teammate1){
        if (DegenAuraDefMP <= MP) {
            teammate1.HP += GuardianAngel;
            teammate1.MP += GuardianAngel;
            MP -= GuardianAngelMP;
            System.out.println(name + " casts the Guardian Angel spell and healing " + GuardianAngel + " HP ->" + teammate1.name);
        }
        else{System.out.println("Недостаточно маны");}
    }

    @Override
    public void Cast(int spell, Hero hero) {
        if (spell == 1){
            Purification(hero);
        }else if (spell == 2){
            HeavenlyGrace(hero);
        }else if (spell == 3){
            DegenAura(hero);
        }else if (spell == 4){
            GuardianAngels(hero);
        }
    }
}
