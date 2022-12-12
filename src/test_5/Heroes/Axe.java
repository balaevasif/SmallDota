package test_5.Heroes;

import java.util.Collections;

public class Axe extends Hero {
    public double BerserkCall_buff = 10;
    public double BerserkCall_MP = 30;
    public double BattleHunger_damage = 150;
    public double BattleHunger_MP = 100;
    public double Counter_Helix_damage = 50;
    public double Counter_Helix_MP = 25;
    public double Culling_Blade_damage = 300;
    public double Culling_Blade_MP = 150;


    private void getSkills() {
        skills.put("1. Berserk Call +" + Double.toString(BerserkCall_buff) + " armor. Need MP to cast: ", BerserkCall_MP);
        skills.put("2. Battle Hunger damage: " + Double.toString(BattleHunger_damage) + " Need MP to cast: ", BattleHunger_MP);
        skills.put("3. Counter Helix damage: " + Double.toString(Counter_Helix_damage) + " Need MP to cast: ", Counter_Helix_MP);
        skills.put("4. Culling Blade damage: " + Double.toString(Culling_Blade_damage) + " Need MP to cast: ", Culling_Blade_damage);
    }

    public void show_skills(){
        System.out.println(Collections.singletonList(skills));
    }

    public Axe(){
        setName("Axe");
        setDamage(100);
        setAgility(20);
        setArmor(40);
        setMagResist(10);
        setHP(1000);
        setMP(400);
        getSkills();
        id++;
    }

    public void BerserkCall(){
        if (BerserkCall_MP <= MP) {
            armor += BerserkCall_buff;
            MP -= BerserkCall_MP;
            System.out.println(name + " casts the Berserk Call spell and buff his armor +" + BerserkCall_buff);
        }
        else{System.out.println("Недостаточно маны");}
    }
    public void BattleHunger(Hero enemy_hero){
        if (BattleHunger_damage <= MP){
            enemy_hero.HP -= BattleHunger_damage - enemy_hero.magic_resistance;
            MP -= BattleHunger_MP;
            System.out.println(name + " casts the Battle Hunger spell and deals " + enemy_hero.name + " " + (BattleHunger_damage - enemy_hero.magic_resistance) + " damage");
        }
        else{System.out.println("Недостаточно маны");}
    }
    public void Counter_Helix(Hero enemy_hero){
        if (Counter_Helix_MP <= MP){
            enemy_hero.HP -= Counter_Helix_damage;
            MP -= Counter_Helix_MP;
            System.out.println(name + " casts the Counter Helix spell and deals " + enemy_hero.name + " " + Counter_Helix_damage + " damage");
        }
        else{System.out.println("Недостаточно маны");}
    }
    public void Culling_Blade(Hero enemy_hero){
        if (Culling_Blade_MP <= MP){
            enemy_hero.HP -= Culling_Blade_damage - enemy_hero.magic_resistance;
            MP -= Culling_Blade_MP;
            System.out.println(name + " casts the Culling Blade spell and deals " + enemy_hero.name + " " + (Culling_Blade_damage - enemy_hero.magic_resistance) + " damage");
        }
        else{System.out.println("Недостаточно маны");}
    }

    @Override
    public void cast(int spell, Hero enemy) {
        switch (spell){
            case 1:
                BerserkCall();
            case 2:
                BattleHunger(enemy);
            case 3:
                Counter_Helix(enemy);
            case 4:
                Culling_Blade(enemy);
        }
    }

}
