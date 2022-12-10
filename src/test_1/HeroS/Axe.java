package test_1.HeroS;

public class Axe extends Hero {

    protected double BerserkCall_buff = 10;
    protected double BerserkCall_MP = 30;
    protected double BattleHunger_damage = 150;
    protected double BattleHunger_MP = 100;
    protected double Counter_Helix_damage = 50;
    protected double Counter_Helix_MP = 25;
    protected double Culling_Blade_damage = 300;
    protected double Culling_Blade_MP = 150;


    Axe(){
        SetDamage(100);
        SetAgility(20);
        SetDefence(40);
        SetHP(1000);
        SetMP(400);
        Hero.id++;
    }

    protected void BerserkCall(){
        if (BerserkCall_MP <= MP) {
            defence += BerserkCall_buff;
            MP -= BerserkCall_MP;
        }
        else{System.out.println("Недостаточно маны");}
    }

    protected void BattleHunger(Hero enemy_hero){

        if (BattleHunger_damage <= MP){
            enemy_hero.HP -= BattleHunger_damage - enemy_hero.magic_resistance;
            MP -= BattleHunger_MP;
        }
        else{System.out.println("Недостаточно маны");}
    }

    protected void Counter_Helix(Hero enemy_hero){
        if (Counter_Helix_MP <= MP){
            enemy_hero.HP -= Counter_Helix_damage;
            MP -= Counter_Helix_MP;
        }
        else{System.out.println("Недостаточно маны");}
    }

    protected void Culling_Blade(Hero enemy_hero){
        if (Culling_Blade_MP <= MP){
            enemy_hero.HP -= Culling_Blade_damage;
            MP -= Culling_Blade_MP;
        }
        else{System.out.println("Недостаточно маны");}
    }
}