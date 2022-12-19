package testVersion0_0_3.Heroes;

public class Axe extends Hero {
    private double BerserkCallBuff = 50;
    private double BerserkCallMP = 50;
    private String BerserkCallBuffDesc = "1. Buff him self armor. Armor +" + BerserkCallBuff + " MP: " + BerserkCallMP;
    private double BattleHungerDamage = 150;
    private double BattleHungerMP = 80;
    private String BattleHungerDesc = "||| 2. Burns enemy. Damage: " + BattleHungerDamage + " MP: " + BattleHungerMP;
    private double CounterHelixDamage = 200;
    private double CounterHelixMP = 100;
    private String CounterHelixDesc = "||| 3. Counter attack enemy. Damage: " + CounterHelixDamage + " MP: " + CounterHelixMP;

    private double CullingBladeDamage = 300;
    private double CullingBladeMP = 150;
    private String CullingBladeDesc = "||| 4. Large damage to enemy. Damage: " + CullingBladeDamage + " MP: " + CullingBladeMP;

    private void attackOrBuffs() {
        attackOrBuff.put(1, 0);
        attackOrBuff.put(2, 1);
        attackOrBuff.put(3, 1);
        attackOrBuff.put(4, 1);
    }
    private void getSkills() {
        Skills.add(BerserkCallBuffDesc);
        Skills.add(BattleHungerDesc);
        Skills.add(CounterHelixDesc);
        Skills.add(CullingBladeDesc);
    }
    public Axe(){
        setName("Axe");
        setDamage(200);
        setAgility(20);
        setArmor(40);
        setMagResist(10);
        setHP(1500);
        setMP(400);
        getSkills();
        attackOrBuffs();
        id++;
    }

    public void BerserkCall(){
        if (BerserkCallMP <= MP) {
            armor += BerserkCallBuff;
            MP -= BerserkCallMP;
            System.out.println(name + " casts the Berserk Call spell and buff his armor +" + BerserkCallBuff);
        }
        else{System.out.println("Недостаточно маны");}
    }
    public void BattleHunger(Hero enemy){
        if (BattleHungerDamage <= MP){
            enemy.HP -= BattleHungerDamage - enemy.magicResistance;
            MP -= BattleHungerMP;
            System.out.println(name + " casts the Battle Hunger spell and deals " + enemy.name + " " + (BattleHungerDamage - enemy.magicResistance) + " damage");
        }
        else{System.out.println("Недостаточно маны");}
    }
    public void CounterHelix(Hero enemy){
        if (CounterHelixMP <= MP){
            enemy.HP -= CounterHelixDamage;
            MP -= CounterHelixMP;
            System.out.println(name + " casts the Counter Helix spell and deals " + enemy.name + " " + CounterHelixDamage + " damage");
        }
        else{System.out.println("Недостаточно маны");}
    }
    public void CullingBlade(Hero enemy){
        if (CullingBladeMP <= MP){
            enemy.HP -= CullingBladeDamage - enemy.magicResistance;
            MP -= CullingBladeMP;
            System.out.println(name + " casts the Culling Blade spell and deals " + enemy.name + " " + (CullingBladeDamage - enemy.magicResistance) + " damage");
        }
        else{System.out.println("Недостаточно маны");}
    }

    @Override
    public void cast(int spell, Hero hero) {
        switch (spell) {
            case 1 -> BerserkCall();
            case 2 -> BattleHunger(hero);
            case 3 -> CounterHelix(hero);
            case 4 -> CullingBlade(hero);
        }
    }

    @Override
    public void lvlUp() {
        super.lvlUp();
        damage += 15 * lvl;
        armor += 20 * lvl;
        agility += 5 * lvl;
        BerserkCallBuff += 10 * lvl;
        BerserkCallMP += 15 * lvl;
        BattleHungerDamage += 30 * lvl;
        BattleHungerMP += 45 * lvl;
        CounterHelixDamage += 60 * lvl;
        CounterHelixMP += 70 * lvl;
        CullingBladeDamage += 80 * lvl;
        CullingBladeMP += 40 * lvl;

        BerserkCallBuffDesc = "1. Buff him self armor. Armor +" + BerserkCallBuff + " MP: " + BerserkCallMP;
        BattleHungerDesc = "||| 2. Burns enemy. Damage: " + BattleHungerDamage + " MP: " + BattleHungerMP;
        CounterHelixDesc = "||| 3. Counter attack enemy. Damage: " + CounterHelixDamage + " MP: " + CounterHelixMP;
        CullingBladeDesc = "||| 4. Large damage to enemy. Damage: " + CullingBladeDamage + " MP: " + CullingBladeMP;

        Skills.clear();
        getSkills();


    }
}
