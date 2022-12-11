package test_2.Heroes;

import test_2.Items.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class Hero {

    public static int id = 0;
    public double damage;
    public double agility;
    public double defence;

    public double magic_resistance;
    public double HP;
    public double MP;
    public byte slots = 6;
    public List<Item> items = new ArrayList<>();
    public void Bit(Hero enemy_hero){
        enemy_hero.HP -= damage - ((enemy_hero.defence + enemy_hero.agility) / 3);
    }

    public void setDamage(double damage){
        this.damage = damage;
    }
    public void setAgility(double agility){
        this.agility = agility;
    }
    public void setDefence(double defence) {
        this.defence = defence;
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

    public void getItem(Item item){
        if (items.size() <= slots){
            items.add(item);
            damage += item.damage;
            defence += item.defence;
            agility += item.agility;
            HP += item.HP;
            MP += item.MP;
            magic_resistance += item.magic_resistance;
        }
        else {
            System.out.println("Нет места!");
        }
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
//        defence -= item.defence;
//        agility -= item.agility;
//        HP -= item.HP;
//        MP -= item.MP;
//        magic_resistance -= item.magic_resistance;
//    }
}
