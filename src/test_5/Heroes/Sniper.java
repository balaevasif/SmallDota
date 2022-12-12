package test_5.Heroes;

public class Sniper extends Hero {
    public double Shrapnel_debuff = 5;
    public double Shrapnel_MP = 30;

    public double Headshot_damage = 15;
    public double Headshot_MP = 10;

    public double TakeAim_damage = 50;
    public double TakeAim_debuff = 30;
    public double TakeAim_MP = 100;

    public double Assassinate_damage = 350;
    public double Assassinate_MP = 350;

    public Sniper() {
        setName("Sniper");
        setDamage(110);
        setAgility(40);
        setArmor(30);
        setMagResist(10);
        setHP(850);
        setMP(600);
        id++;
    }

    private void Shrapnel(Hero enemy_hero){
        if (Shrapnel_MP <= MP){
            enemy_hero.armor -= Shrapnel_debuff - enemy_hero.magic_resistance;
            MP -= Shrapnel_MP;
            System.out.println(name + " casts the Shrapnel spell and deals " + enemy_hero.name + " " + damage + " урона");
        }
        else{System.out.println("Недостаточно маны");}

    }
    public void Headshot(Hero enemy_hero){
        if (Headshot_MP <= MP) {
            damage += Headshot_damage;
            MP -= Headshot_MP;
            enemy_hero.HP -= damage;
            System.out.println(name + " casts the Head Shot spell, buff his damage +" + (Headshot_damage - enemy_hero.magic_resistance) + " and deals " + enemy_hero.name + " " + damage);

        }
        else{System.out.println("Недостаточно маны");}
    }

    public void TakeAim(Hero enemy_hero){
        if (TakeAim_MP <= MP) {
            enemy_hero.armor -= TakeAim_debuff;
            enemy_hero.HP -= TakeAim_damage;
            enemy_hero.armor += TakeAim_debuff;
            MP -= TakeAim_MP;
            System.out.println(name + " casts the Take Aim spell, reduces " + enemy_hero.name + "'s" + " armor during this move by " + TakeAim_debuff + " and deals: " + TakeAim_damage + " damage");
        }
        else{System.out.println("Недостаточно маны");}
    }

    public void Assassinate(Hero enemy_hero){
        if (Assassinate_MP <= MP) {
            enemy_hero.HP -= Assassinate_damage - enemy_hero.magic_resistance;
            MP -= Assassinate_MP;
            System.out.println(name + " casts the ultimate Assassinate spell, and deals " + enemy_hero.name + " " + (Assassinate_damage - enemy_hero.magic_resistance) + " damage");
        }
        else{System.out.println("Недостаточно маны");}
    }

    @Override
    public void cast(int spell, Hero enemy) {
        switch (spell){
            case 1:
                Shrapnel(enemy);
            case 2:
                Headshot(enemy);
            case 3:
                TakeAim(enemy);
            case 4:
                Assassinate(enemy);
        }
    }

}
