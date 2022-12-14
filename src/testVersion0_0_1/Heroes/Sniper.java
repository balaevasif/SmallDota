package testVersion0_0_1.Heroes;

public class Sniper extends Hero {
    public double ShrapnelDebuff = 15;
    public double ShrapnelMP = 30;
    public String ShrapnelDebuffDesc = "1. Debuff armor enemy. Armor enemy -" + ShrapnelDebuff + " MP: " + ShrapnelMP;

    public double HeadshotDamage = 20;
    public double HeadshotMP = 10;
    public String HeadshotDesc = "||| 2. Buff damage. Damage +" + HeadshotDamage + ". Damage to enemy " + damage + " MP: " + HeadshotMP;

    public double TakeAimDamage = 50;
    public double TakeAimDebuff = 30;
    public double TakeAimMP = 100;
    public String TakeAimDesc = "||| 3. Debuff armor enemy during move and shot. Armor -" + TakeAimDebuff + " Damage: " + TakeAimDamage + " MP: " + TakeAimMP;

    public double AssassinateDamage = 350;
    public double AssassinateMP = 350;
    public String AssassinateDesc = "||| 4. Find target and make shot to head enemy. Damage: " + AssassinateDamage + " MP: " + AssassinateMP;

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
        setDamage(150);
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
    public void Cast(int spell, Hero hero) {
        if (spell == 1){
            Shrapnel(hero);
        }else if (spell == 2){
            Headshot(hero);
        }else if (spell == 3){
            TakeAim(hero);
        }else if (spell == 4){
            Assassinate(hero);
        }
    }
}