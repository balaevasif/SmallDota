package prod;

public class Hero {
    int id;
    String name;
    double damage;
    double agility;
    double defence;
    double HP;
    double MP;
    public String description;

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

    public void show_info(){
        System.out.printf("ID: %d, Name: %s, Damage: %f, Agility: %f, Defence: %f, HP: %f, MP: %f",
                id, name, damage, agility, defence, HP, MP);
    }
}
