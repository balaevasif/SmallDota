package testVersion0_0_4.Heroes;

import testVersion0_0_4.Items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


public abstract class Hero {
    protected static int id = 0;
    protected int lvl = 1;
    public String name;
    public double damage;
    public double agility;
    public double armor;
    public double magicResistance;
    public double HP;
    public double MP;
    public int position_x;
    public int position_y;
    public byte slotsSize = 3;
    public List<Item> items = new ArrayList<>();
    public TreeMap<Integer, Integer> attackOrBuff = new TreeMap<>();
    public List<String> Skills = new ArrayList<>();

    public void setPosition_x(int position_x) {
        this.position_x = position_x;
    }

    public void setPosition_y(int position_y) {
        this.position_y = position_y;
    }

    public void bit(Hero enemy){
        System.out.println(enemy.name + " HP was: " + enemy.HP);
        enemy.HP -= damage - ((enemy.armor + enemy.agility) / 3);
        System.out.println(name + " bites " + enemy.name);
        System.out.println(enemy.name + " HP became " + enemy.HP);
    }

    public abstract void cast(int spell, Hero hero);

    public void showInfo(){
        System.out.println(name + " HP: " + HP + " MP: " + MP + " Damage: " + damage + " Armor: " + armor + " Agility: " + agility + " LVL: " + lvl);
    }

    public boolean isAlive(){
        return HP > 0;
    }

    public void lvlUp(){
        lvl++;
        System.out.println(name + " LVL UP");
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

//    protected void infoAboutAttack(Hero enemy){
//        System.out.println(enemy.name + " HP was: " + enemy.HP);
//        System.out.println(name + " bites " + enemy.name);
//        System.out.println(enemy.name + " HP became " + enemy.HP);
//    }



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
    protected void setMagResist(double magicResistance) {
        this.magicResistance = magicResistance;
    }
    protected void setHP(double HP) {
        this.HP = HP;
    }
    protected void setMP(double MP) {
        this.MP = MP;
    }



}
