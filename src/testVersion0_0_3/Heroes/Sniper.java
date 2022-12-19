package testVersion0_0_3.Heroes;

public class Sniper extends Hero {
    private double ShrapnelDebuff = 30;
    private double ShrapnelMP = 30;
    private String ShrapnelDebuffDesc = "1. Debuff armor enemy. Armor enemy -" + ShrapnelDebuff + " MP: " + ShrapnelMP;

    private double HeadshotDamage = 20;
    private double HeadshotMP = 10;
    private String HeadshotDesc = "||| 2. Buff damage. Damage +" + HeadshotDamage + ". Damage to enemy " + damage + " MP: " + HeadshotMP;

    private double TakeAimDamage = 50;
    private double TakeAimDebuff = 30;
    private double TakeAimMP = 100;
    private String TakeAimDesc = "||| 3. Debuff armor enemy during move and shot. Armor -" + TakeAimDebuff + " Damage: " + TakeAimDamage + " MP: " + TakeAimMP;

    private double AssassinateDamage = 350;
    private double AssassinateMP = 350;
    private String AssassinateDesc = "||| 4. Find target and make shot to head enemy. Damage: " + AssassinateDamage + " MP: " + AssassinateMP;

    private void attackOrBuffs() {
        attackOrBuff.put(1, 1);
        attackOrBuff.put(2, 1);
        attackOrBuff.put(3, 1);
        attackOrBuff.put(4, 1);
    }
    private void getSkills(){
        Skills.add(ShrapnelDebuffDesc);
        Skills.add(HeadshotDesc);
        Skills.add(TakeAimDesc);
        Skills.add(AssassinateDesc);
    }

    public Sniper() {
        setName("Sniper");
        setDamage(300);
        setAgility(40);
        setArmor(30);
        setMagResist(10);
        setHP(850);
        setMP(600);
        attackOrBuffs();
        getSkills();
        id++;
    }

    private void Shrapnel(Hero enemy){
        if (ShrapnelMP <= MP){
            enemy.armor -= ShrapnelDebuff;
            MP -= ShrapnelMP;
            System.out.println(name + " casts the Shrapnel spell and debaff " + enemy.name + " armor -" + ShrapnelDebuff);
        }
        else{System.out.println("Недостаточно маны");}

    }
    public void Headshot(Hero enemy){
        if (HeadshotMP <= MP) {
            damage += HeadshotDamage;
            MP -= HeadshotMP;
            enemy.HP -= damage - enemy.magicResistance;
            System.out.println(name + " casts the Head Shot spell, buff his damage +" + (HeadshotDamage - enemy.magicResistance) + " and deals " + enemy.name + " " + damage);

        }
        else{System.out.println("Недостаточно маны");}
    }
    public void TakeAim(Hero enemy){
        if (TakeAimMP <= MP) {
            enemy.armor -= TakeAimDebuff;
            enemy.HP -= TakeAimDamage;
            enemy.armor += TakeAimDebuff;
            MP -= TakeAimMP;
            System.out.println(name + " casts the Take Aim spell, reduces " + enemy.name + "'s" + " armor during this move by " + TakeAimDebuff + " and deals: " + TakeAimDamage + " damage");
        }
        else{System.out.println("Недостаточно маны");}
    }
    public void Assassinate(Hero enemy){
        if (AssassinateMP <= MP) {
            enemy.HP -= AssassinateDamage - enemy.magicResistance;
            MP -= AssassinateMP;
            System.out.println(name + " casts the ultimate Assassinate spell, and deals " + enemy.name + " " + (AssassinateDamage - enemy.magicResistance) + " damage");
        }
        else{System.out.println("Недостаточно маны");}
    }

    @Override
    public void cast(int spell, Hero hero) {
        switch (spell) {
            case 1 -> Shrapnel(hero);
            case 2 -> Headshot(hero);
            case 3 -> TakeAim(hero);
            case 4 -> Assassinate(hero);
        }
    }

    @Override
    public void lvlUp() {
        super.lvlUp();
        damage += 80 * lvl;
        armor += 5 * lvl;
        agility += 30 * lvl;

        ShrapnelDebuff += 30 * lvl;
        ShrapnelMP += 30 * lvl;
        HeadshotDamage += 50 * lvl;
        HeadshotMP += 50 * lvl;
        TakeAimDamage += 40 * lvl;
        TakeAimDebuff += 40 * lvl;
        TakeAimMP += 50 * lvl;
        AssassinateDamage += 75 * lvl;
        AssassinateMP += 75 * lvl;

        ShrapnelDebuffDesc = "1. Debuff armor enemy. Armor enemy -" + ShrapnelDebuff + " MP: " + ShrapnelMP;
        HeadshotDesc = "||| 2. Buff damage. Damage +" + HeadshotDamage + ". Damage to enemy " + damage + " MP: " + HeadshotMP;
        TakeAimDesc = "||| 3. Debuff armor enemy during move and shot. Armor -" + TakeAimDebuff + " Damage: " + TakeAimDamage + " MP: " + TakeAimMP;
        AssassinateDesc = "||| 4. Find target and make shot to head enemy. Damage: " + AssassinateDamage + " MP: " + AssassinateMP;

        Skills.clear();
        getSkills();
    }
}