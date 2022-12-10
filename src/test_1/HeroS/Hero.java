package test_1.HeroS;

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

    protected void SetDamage(double damage){
        this.damage = damage;
    }

    protected void SetAgility(double agility){
        this.agility = agility;
    }

    protected void SetDefence(double defence) {
        this.defence = defence;
    }
    protected void Set_MagResist(double magic_resistance) {
        this.magic_resistance = magic_resistance;
    }

    protected void SetHP(double HP) {
        this.HP = HP;
    }

    protected void SetMP(double MP) {
        this.MP = MP;
    }


}
