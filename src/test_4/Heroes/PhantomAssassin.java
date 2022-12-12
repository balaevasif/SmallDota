package test_4.Heroes;

import java.util.Random;
public class PhantomAssassin extends Hero {

    public double StiflingDaggerDamage = 150;
    public double StiflingDaggerMP = 150;
    public String StiflingDaggerDesc = "throws a dagger at the enemy";

    public double BurningManaPoint = 200;
    public double BurningMP = 50;
    public String BurningManaPointDesc = "burning MP enemy and healing himself";

    public double PhantomStrikeDamage = 400;
    public double PhantomStrikeMP = 200;
    public String PhantomStrikeDesc = "burning MP enemy and healing himself";

    private void getSkills(){
        skills.put("1. Stifling Dagger damage: " + Double.toString(StiflingDaggerDamage) + " Need MP to cast: ", StiflingDaggerMP);
        skills.put("2. Burning Mana Point: " + Double.toString(BurningManaPoint) + " Need MP to cast: ", BurningMP);
        skills.put("3. Phantom Strike: " + Double.toString(PhantomStrikeDamage) + " Need MP to cast: ", PhantomStrikeMP);
    }

    public PhantomAssassin(){
        setName("Phantom Assassin");
        setDamage(200);
        setAgility(100);
        setArmor(30);
        setMagResist(50);
        setHP(900);
        setMP(400);
        getSkills();
        id++;
    }

    public void StiflingDagger(Hero enemy_hero){
        if (StiflingDaggerMP <= MP){
            enemy_hero.HP -= StiflingDaggerDamage - enemy_hero.armor;
            MP -= StiflingDaggerMP;
            System.out.println(name + " casts the Stifling Dagger spell and deals " + enemy_hero.name + " " + (StiflingDaggerDamage - enemy_hero.armor) + " damage");
        }
        else{System.out.println("Недостаточно маны");}
    }

    public void BurningMP(Hero enemy_hero){
        if (BurningMP <= MP){
            enemy_hero.MP -= BurningManaPoint - enemy_hero.magic_resistance;
            HP += BurningManaPoint - enemy_hero.magic_resistance;
            System.out.println(name + " casts the Burning Mana point spell, steals " + (BurningManaPoint - enemy_hero.magic_resistance) + " MP from " + enemy_hero.name + " and healing him self HP +" + (BurningManaPoint - enemy_hero.magic_resistance));

        }
        else{System.out.println("Недостаточно маны");}
    }

    @Override
    public void Bit(Hero enemy_hero) {
        Random rnd = new Random();
        //super.Bit(enemy_hero);
        int critical = rnd.nextInt(0, 5);
        if (critical == 0){
            enemy_hero.HP -= (damage * 3 - enemy_hero.armor);
            System.out.println(name + " strikes a critical blow and deal " + enemy_hero.name + " " + (damage * 3 - enemy_hero.armor) + " damage");
        }
        else {
            enemy_hero.HP -= (damage - enemy_hero.armor);
        }

    }

    @Override
    public void Cast(int spell, Hero enemy) {

    }
}
