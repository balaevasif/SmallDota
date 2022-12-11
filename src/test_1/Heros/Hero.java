package test_1.Heros;

public abstract class Hero {

    protected static int id = 0;
    protected double damage;
    protected double agility;
    protected double defence;

    protected double magic_resistance;
    protected double HP;
    protected double MP;

    protected void Bit(Hero enemy_hero){
        enemy_hero.HP -= damage - ((enemy_hero.defence + enemy_hero.agility) / 3);
    }

    protected void setDamage(double damage){
        this.damage = damage;
    }

    protected void setAgility(double agility){
        this.agility = agility;
    }

    protected void setDefence(double defence) {
        this.defence = defence;
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


}
