package testVersion0_0_4.Heroes;


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
    public void cast(int spell, Hero hero) {
        switch (spell){
            case 1 -> Purification(hero);
            case 2 -> HeavenlyGrace(hero);
            case 3 -> DegenAura(hero);
            case 4 -> GuardianAngels(hero);
        }
    }

    @Override
    public void lvlUp(){
        super.lvlUp();
        damage += 130 * lvl;
        armor += 20 * lvl;
        agility += 80 * lvl;

        PurificationHeal += 100 * lvl;
        PurificationMP += 50 * lvl;
        HeavenlyGraceHealMP += 60 * lvl;
        HeavenlyGraceMP += 30 * lvl;
        DegenAuraDef += 30 * lvl;
        DegenAuraDefMP += 50 * lvl;
        GuardianAngel += 75 * lvl;
        GuardianAngelMP += 100 * lvl;

        PurificationDesc = "1. Heal HP himself or his teammate. HP+ " + PurificationHeal + " takes MP: " + PurificationMP;
        HeavenlyGraceDesc = "||| 2. Heal MP himself or his teammate. MP+ " + HeavenlyGraceHealMP + " takes MP: " + HeavenlyGraceMP;
        DegenAuraDefDesc = "||| 3. Add armor himself or his teammate. Armor+ " + DegenAuraDef + " takes MP: " + DegenAuraDefMP;
        GuardianAngelDesc = "||| 4. Heal: " + GuardianAngel + " HP and Heal: " + GuardianAngel + " MP takes MP: " + GuardianAngelMP;

        Skills.clear();
        getSkills();
    }
}
