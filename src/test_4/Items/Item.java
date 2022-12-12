package test_4.Items;

public abstract class Item {
    public static int id = 0;
    public String name;
    public double damage;
    public double agility;
    public double armor;
    public double HP;
    public double MP;
    public double magic_resistance;
    public String description;

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public void setAgility(double agility) {
        this.agility = agility;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    public void setHP(double HP) {
        this.HP = HP;
    }
    public void setMP(double MP) {
        this.MP = MP;
    }

    public void setMagResist(double magic_resistance) {
        this.magic_resistance = magic_resistance;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
