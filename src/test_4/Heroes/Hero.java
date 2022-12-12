package test_4.Heroes;

import test_4.Items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

public abstract class Hero {

    public static int id = 0;
    public String name;
    public double damage;
    public double agility;
    public double armor;

    public double magic_resistance;
    public double HP;
    public double MP;
    public byte slots = 6;
    public List<Item> items = new ArrayList<>();
    public TreeMap<String, Double> skills = new TreeMap<>();

    public void Bit(Hero enemy_hero){
        System.out.println(enemy_hero.name + " HP was " + enemy_hero.HP);
        enemy_hero.HP -= damage - ((enemy_hero.armor + enemy_hero.agility) / 3);
        Random rnd = new Random();
        if (enemy_hero.name.equals("Axe")){
            int chance_counter_attack = rnd.nextInt(0, 3);
            if (chance_counter_attack == 0){
                HP -= enemy_hero.damage / 2;
                System.out.println("Axe counterattacks and deals " + enemy_hero.damage / 2 + " damage");
            }
        }
        System.out.println(name + " bits " + enemy_hero.name);
        System.out.println(enemy_hero.name + " HP became" + enemy_hero.HP);
    }
    public abstract void Cast(int spell, Hero enemy);
    public boolean isHeal = false;

    protected void setName(String name){this.name = name;};
    protected void setDamage(double damage){
        this.damage = damage;
    }
    protected void setAgility(double agility){
        this.agility = agility;
    }
    protected void setArmor(double armor) {
        this.armor = armor;
    }
    protected void setMagResist(double magic_resistance) {
        this.magic_resistance = magic_resistance;
    }
    protected void setHP(double HP) {
        this.HP = HP;
    }
    protected void setMP(double MP) {
        this.MP = MP;
    }

    public boolean isAlive(){
        return HP > 0;
    }

    public void getItem(Item item){
        if (items.size() <= slots){
            items.add(item);
            damage += item.damage;
            armor += item.armor;
            agility += item.agility;
            HP += item.HP;
            MP += item.MP;
            magic_resistance += item.magic_resistance;
        }
        else {
            System.out.println("Нет места!");
        }
    }

    public void show_skills(){
        System.out.println(List.of(skills));
    }





//    public void delItem(Item item){
//        //if (items.isEmpty())
//        items.remove(item);
//        damage -= item.damage;
//        armor -= item.armor;
//        agility -= item.agility;
//        HP -= item.HP;
//        MP -= item.MP;
//        magic_resistance -= item.magic_resistance;
//    }
}
