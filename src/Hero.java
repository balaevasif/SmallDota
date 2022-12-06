public class Hero {
    int id;
    String name;
    double damage;
    double agility;
    double defence;
    double HP;
    double MP;
    String description;

    public Hero(int id, String name, double damage, double agility, double defence, double HP, double MP) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.agility = agility;
        this.defence = defence;
        this.HP = HP;
        this.MP = MP;
    }

    public void hit(Hero second_player){
        second_player.HP -= (damage - ((second_player.defence + second_player.agility) / 3));
    }
}
