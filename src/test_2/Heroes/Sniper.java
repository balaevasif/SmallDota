package test_2.Heroes;

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
        setDamage(110);
        setAgility(40);
        setDefence(30);
        setMagResist(10);
        setHP(850);
        setMP(600);
        Hero.id++;
    }

    public void Shrapnel(Hero enemy_hero){
        if (Shrapnel_MP <= MP){
            enemy_hero.defence -= Shrapnel_debuff - enemy_hero.magic_resistance;
            MP -= Shrapnel_MP;
        }
        else{System.out.println("Недостаточно маны");}

    }
    public void Headshot(Hero enemy_hero){
        if (Headshot_MP <= MP) {
            damage += Headshot_damage;
            MP -= Headshot_MP;
            enemy_hero.HP -= damage;
        }
        else{System.out.println("Недостаточно маны");}
    }

    public void TakeAim(Hero enemy_hero){
        if (TakeAim_MP <= MP) {
            enemy_hero.defence -= TakeAim_debuff;
            enemy_hero.HP -= TakeAim_damage;
            enemy_hero.defence += TakeAim_debuff;
            MP -= TakeAim_MP;
        }
        else{System.out.println("Недостаточно маны");}
    }

    public void Assassinate(Hero enemy_hero){
        if (Assassinate_MP <= MP) {
            enemy_hero.HP -= Assassinate_damage - enemy_hero.magic_resistance;
            MP -= Assassinate_MP;
        }
        else{System.out.println("Недостаточно маны");}
    }

}
