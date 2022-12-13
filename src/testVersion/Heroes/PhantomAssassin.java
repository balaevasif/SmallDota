package testVersion.Heroes;
import java.util.Random;
public class PhantomAssassin extends Hero {

    public double StiflingDaggerDamage = 150;
    public double StiflingDaggerMP = 150;
    public String StiflingDaggerDesc = "1. throws a dagger at the enemy. Damage: " + StiflingDaggerDamage + " MP: " + StiflingDaggerMP;

    public double BurningManaPoint = 200;
    public double BurningMP = 50;
    public String BurningManaPointDesc = "||| 2. burning MP enemy and healing himself, Burning: " + BurningManaPoint + " MP: " + BurningMP;

    public double PhantomStrikeDamage = 400;
    public double PhantomStrikeMP = 200;
    public String PhantomStrikeDesc = "||| 3. the hero goes into a rage, causes huge damage, and also injures himself. Damage: " + PhantomStrikeDamage + ". Damage him self :" + PhantomStrikeDamage / 5 + " MP: " + PhantomStrikeMP;

    private void attackOrBuffs(){
        attackOrBuff.put(1, 1);
        attackOrBuff.put(2, 1);
        attackOrBuff.put(3, 1);
    }
    private void getSkills(){
        Skills.add(StiflingDaggerDesc);
        Skills.add(BurningManaPointDesc);
        Skills.add(PhantomStrikeDesc);
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
        attackOrBuffs();
        id++;
    }

    public void StiflingDagger(Hero enemy){
        if (StiflingDaggerMP <= MP){
            enemy.HP -= StiflingDaggerDamage - enemy.armor;
            MP -= StiflingDaggerMP;
            System.out.println(name + " casts the Stifling Dagger spell and deals " + enemy.name + " " + (StiflingDaggerDamage - enemy.armor) + " damage");
        }
        else{System.out.println("Недостаточно маны");}
    }

    public void BurningMP(Hero enemy){
        if (BurningMP <= MP){
            enemy.MP -= BurningManaPoint - enemy.magicResistance;
            HP += BurningManaPoint - enemy.magicResistance;
            System.out.println(name + " casts the Burning Mana point spell, steals " + (BurningManaPoint - enemy.magicResistance) + " MP from " + enemy.name + " and healing him self HP +" + (BurningManaPoint - enemy.magicResistance));
        }
        else{System.out.println("Недостаточно маны");}
    }

    public void PhantomStrike(Hero enemy){
        if (PhantomStrikeMP <= MP){
            enemy.HP -= PhantomStrikeDamage - enemy.armor;
            HP -= PhantomStrikeDamage / 5;
            System.out.println(name + " casts the Phantom Strike spell, deals " + enemy.name + " " + (PhantomStrikeDamage - enemy.armor) + " damage and damage his self: "  + PhantomStrikeDamage / 5 + " damage");
        }
        else{System.out.println("Недостаточно маны");}
    }

    @Override
    public void bit(Hero enemy) {
        Random rnd = new Random();
        //super.bit(enemy);
        int critical = rnd.nextInt(0, 4);
        if (critical == 0){
            enemy.HP -= (damage * 3 - enemy.armor);
            System.out.println(name + " strikes a critical blow and deal " + enemy.name + " " + (damage * 3 - enemy.armor) + " damage");
        }
    }
    @Override
    public void Cast(int spell, Hero hero) {
        if (spell == 1){
            StiflingDagger(hero);
        }else if (spell == 2){
            BurningMP(hero);
        }else if (spell == 3){
            PhantomStrike(hero);
        }
    }
}
