package testVersion.Heroes;

import testVersion.Items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


public abstract class Hero {
    protected static int id = 0;
    public String name;
    public double damage;
    public double agility;
    public double armor;
    public double magicResistance;
    public double HP;
    public double MP;
    public byte slotsSize = 3;
    public List<Item> items = new ArrayList<>();
    public TreeMap<Integer, Integer> attackOrBuff = new TreeMap<>();
    public TreeMap<String, Double> skills = new TreeMap<>();
    public List<String> Skills = new ArrayList<>();

    public void bit(Hero enemy){
        System.out.println(enemy.name + " HP was: " + enemy.HP);
        enemy.HP -= damage - ((enemy.armor + enemy.agility) / 3);
        //
        System.out.println(name + " bites " + enemy.name);
        System.out.println(enemy.name + " HP became " + enemy.HP);
    }

    public abstract void Cast(int spell, Hero hero);

    public void setName(String name){this.name = name;};
    public void setDamage(double damage){
        this.damage = damage;
    }
    public void setAgility(double agility){
        this.agility = agility;
    }
    public void setArmor(double armor) {
        this.armor = armor;
    }
    public void setMagResist(double magic_resistance) {
        this.magicResistance = magic_resistance;
    }
    public void setHP(double HP) {
        this.HP = HP;
    }
    public void setMP(double MP) {
        this.MP = MP;
    }

    public boolean isAlive(){
        return HP > 0;
    }

    public void showSkills(){
        System.out.println(List.of(Skills));
    }
    public void attOrBuff(){
        System.out.println(List.of(attackOrBuff));
    }

    public void getItem(Item item){
        if (items.size() <= slotsSize){
            items.add(item);
            damage += item.damage;
            armor += item.armor;
            agility += item.agility;
            HP += item.HP;
            MP += item.MP;
            magicResistance += item.magicResistance;
        }
        else {
            System.out.println("Нет места!");
        }
    }


    public int kindOfSpell(int spell){
        if (attackOrBuff.get(spell) == 0){
            return 0;
        } else if (attackOrBuff.get(spell) == 1) {
            return 1;
        } else if (attackOrBuff.get(spell) == 2) {
            return 2;
        }else return 3;
        //return attackOrBuff.get(spell) == 0;
    }


}
