package test_2.Heroes;

import java.util.Collections;
import java.util.TreeMap;

public class Axe extends Hero {

    public double BerserkCall_buff = 10;
    public double BerserkCall_MP = 30;
    public double BattleHunger_damage = 150;
    public double BattleHunger_MP = 100;
    public double Counter_Helix_damage = 50;
    public double Counter_Helix_MP = 25;
    public double Culling_Blade_damage = 300;
    public double Culling_Blade_MP = 150;
    public TreeMap<String, Double> skills = new TreeMap<>();

    public void getSkills() {
        skills.put("1. Berserk Call +" + Double.toString(BerserkCall_buff) + " defence. Need MP to cast: ", BerserkCall_MP);
        skills.put("2. Battle Hunger damage: " + Double.toString(BattleHunger_damage) + " Need MP to cast: ", BattleHunger_MP);
        skills.put("3. Counter Helix damage: " + Double.toString(Counter_Helix_damage) + " Need MP to cast: ", Counter_Helix_MP);
        skills.put("4. Culling Blade damage: " + Double.toString(Culling_Blade_damage) + " Need MP to cast: ", Culling_Blade_damage);
    }

    public void show_skills(){
        System.out.println(Collections.singletonList(skills));
    }

    public Axe(){
        setDamage(100);
        setAgility(20);
        setDefence(40);
        setMagResist(10);
        setHP(1000);
        setMP(400);
        getSkills();
        Hero.id++;
    }

    public void BerserkCall(){
        if (BerserkCall_MP <= MP) {
            defence += BerserkCall_buff;
            MP -= BerserkCall_MP;
        }
        else{System.out.println("Недостаточно маны");}
    }
    public void BattleHunger(Hero enemy_hero){
        if (BattleHunger_damage <= MP){
            enemy_hero.HP -= BattleHunger_damage - enemy_hero.magic_resistance;
            MP -= BattleHunger_MP;
        }
        else{System.out.println("Недостаточно маны");}
    }
    public void Counter_Helix(Hero enemy_hero){
        if (Counter_Helix_MP <= MP){
            enemy_hero.HP -= Counter_Helix_damage;
            MP -= Counter_Helix_MP;
        }
        else{System.out.println("Недостаточно маны");}
    }
    public void Culling_Blade(Hero enemy_hero){
        if (Culling_Blade_MP <= MP){
            enemy_hero.HP -= Culling_Blade_damage - enemy_hero.magic_resistance;
            MP -= Culling_Blade_MP;
        }
        else{System.out.println("Недостаточно маны");}
    }
}
