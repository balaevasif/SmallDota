package test_1.Items;

public abstract class Item {
    static int id = 0;
    String name;
    double damage;
    double agility;
    double defence;
    double HP;
    double MP;
    double magic_resistance;
    String description;

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public void setAgility(double agility) {
        this.agility = agility;
    }

    public void setDefence(double defence) {
        this.defence = defence;
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
