package test_3.Heroes;
import test_3.Items.Item;

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
        enemy_hero.HP -= damage - ((enemy_hero.armor + enemy_hero.agility) / 3);
        Random rnd = new Random();
        if (enemy_hero.name.equals("Axe")){
            byte chance_counter_attack = (byte) rnd.nextInt(0, 3);
            if (chance_counter_attack == 0){
                HP -= enemy_hero.damage / 2;
                System.out.println("Axe counterattacks and deals " + enemy_hero.damage / 2 + " damage");
            }
        }
    }

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
        this.magic_resistance = magic_resistance;
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

    public boolean isMP(double skill){
        if (skill <= MP){
            return true;
        }
        else return false;
    }

    public void show_items(){
        String[] item = new String[items.size()];
        for (int i = 0; i < items.size(); i++) {
            item[i] = items.get(i).toString();
        }
//        System.out.println(item.length);
//        for (String itemq:
//             items.toString()) {
//        }
//        for (String s:
//             item) {
//            System.out.println(Collections.singletonList(s));
//        }
//        return new String[]{Arrays.toString(item)};
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
