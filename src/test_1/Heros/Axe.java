package test_1.Heros;

import test_1.Items.Item;

import java.util.*;

public class Axe extends Hero {

    protected double BerserkCall_buff = 10;
    protected double BerserkCall_MP = 30;
    protected double BattleHunger_damage = 150;
    protected double BattleHunger_MP = 100;
    protected double Counter_Helix_damage = 50;
    protected double Counter_Helix_MP = 25;
    protected double Culling_Blade_damage = 300;
    protected double Culling_Blade_MP = 150;

    protected List<Item> items = new ArrayList<>();
    protected TreeMap<String, Double> skills = new TreeMap<>();

    protected void getSkills() {
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
            enemy_hero.HP -= Culling_Blade_damage - enemy_hero.magic_resistance;
            MP -= Culling_Blade_MP;
        }
        else{System.out.println("Недостаточно маны");}
    }
}
