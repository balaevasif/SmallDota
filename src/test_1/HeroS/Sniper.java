package test_1.HeroS;

public class Sniper extends Hero {

    protected double Shrapnel_debuff = 5;
    protected double Shrapnel_MP = 30;

    protected double Headshot_damage = 15;
    protected double Headshot_MP = 10;

    protected double TakeAim_damage = 50;
    protected double TakeAim_debuff = 30;
    protected double TakeAim_MP = 100;

    protected double Assassinate_damage = 350;
    protected double Assassinate_MP = 350;

    Sniper() {
        SetDamage(110);
        SetAgility(40);
        SetDefence(30);
        SetHP(850);
        SetMP(600);
        Hero.id++;
    }

    protected void Shrapnel(Hero enemy_hero){
        if (Shrapnel_MP <= MP){
            enemy_hero.defence -= Shrapnel_debuff;
            MP -= Shrapnel_MP;
        }
        else{System.out.println("Недостаточно маны");}

    }
    protected void Headshot(Hero enemy_hero){
        if (Headshot_MP <= MP) {
            damage += Headshot_damage;
            MP -= Headshot_MP;
            enemy_hero.HP -= damage;
        }
        else{System.out.println("Недостаточно маны");}
    }

    protected void TakeAim(Hero enemy_hero){
        if (TakeAim_MP <= MP) {
            enemy_hero.defence -= TakeAim_debuff;
            enemy_hero.HP -= TakeAim_damage;
            enemy_hero.defence += TakeAim_debuff;
            MP -= TakeAim_MP;
        }
        else{System.out.println("Недостаточно маны");}
    }

    protected void Assassinate(Hero enemy_hero){
        if (Assassinate_MP <= MP) {
            enemy_hero.HP -= Assassinate_damage;
            MP -= Assassinate_MP;
        }
        else{System.out.println("Недостаточно маны");}
    }

}