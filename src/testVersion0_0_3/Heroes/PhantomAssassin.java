package testVersion0_0_3.Heroes;


import java.util.Random;

public class PhantomAssassin extends Hero {

    private double StiflingDagger = 150;
    private double StiflingDaggerMP = 150;
    private String StiflingDaggerDesc = "1. throws a dagger at the enemy. Damage: " + StiflingDagger + " MP: " + StiflingDaggerMP;

    private double BurningManaPoint = 200;
    private double BurningMP = 50;
    private String BurningManaPointDesc = "||| 2. burning MP enemy and healing himself, Burning: " + BurningManaPoint + " MP: " + BurningMP;

    private double PhantomStrike = 400;
    private double PhantomStrikeMP = 200;
    private String PhantomStrikeDesc = "||| 3. the hero goes into a rage, causes huge damage, and also injures himself. Damage: " + PhantomStrike + ". Damage him self :" + PhantomStrike / 5 + " MP: " + PhantomStrikeMP;

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
            enemy.HP -= StiflingDagger - enemy.armor;
            MP -= StiflingDaggerMP;
            System.out.println(name + " casts the Stifling Dagger spell and deals " + enemy.name + " " + (StiflingDagger - enemy.armor) + " damage");
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
            enemy.HP -= PhantomStrike - enemy.armor;
            HP -= PhantomStrike / 5;
            System.out.println(name + " casts the Phantom Strike spell, deals " + enemy.name + " " + (PhantomStrike - enemy.armor) + " damage and damage his self: "  + PhantomStrike / 5 + " damage");
        }
        else{System.out.println("Недостаточно маны");}
    }

    @Override
    public void bit(Hero enemy) {
        Random rnd = new Random();
        //
        int critical = rnd.nextInt(0, 3);
        if (critical == 0){

            System.out.println(enemy.name + " HP was: " + enemy.HP);
            enemy.HP -= (damage * 3 - enemy.armor);
            System.out.println(name + " strikes a critical blow and deal " + enemy.name + " " + (damage * 3 - enemy.armor) + " damage");
            System.out.println(enemy.name + " HP became " + enemy.HP);

        }
        else {
            super.bit(enemy);
//            System.out.println(enemy.name + " HP was: " + enemy.HP);
//            enemy.HP -= damage - enemy.armor;
//            System.out.println(name + " deal " + enemy.name + " " + (damage - enemy.armor) + " damage");
//            System.out.println(enemy.name + " HP became " + enemy.HP);
        }

    }
    @Override
    public void cast(int spell, Hero hero) {
        switch (spell){
            case 1 -> StiflingDagger(hero);
            case 2 -> BurningMP(hero);
            case 3 -> PhantomStrike(hero);
        }
    }

    @Override
    public void lvlUp(){
        super.lvlUp();
        damage += 100 * lvl;
        armor += 10 * lvl;
        agility += 60 * lvl;

        StiflingDagger += 50 * lvl;
        StiflingDaggerMP += 50 * lvl;
        BurningManaPoint += 150 * lvl;
        BurningMP += 50 * lvl;
        PhantomStrike += 100 * lvl;
        PhantomStrikeMP += 100 * lvl;

        StiflingDaggerDesc = "1. throws a dagger at the enemy. Damage: " + StiflingDagger + " MP: " + StiflingDaggerMP;
        BurningManaPointDesc = "||| 2. burning MP enemy and healing himself, Burning: " + BurningManaPoint + " MP: " + BurningMP;
        PhantomStrikeDesc = "||| 3. the hero goes into a rage, causes huge damage, and also injures himself. Damage: " + PhantomStrike + ". Damage him self :" + PhantomStrike / 5 + " MP: " + PhantomStrikeMP;

        Skills.clear();
        getSkills();

    }
}
