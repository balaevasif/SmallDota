package testVersion.Heroes;

public class Axe extends Hero {
    public double BerserkCallBuff = 10;
    public double BerserkCallMP = 30;
    public String BerserkCallBuffDesc = "1. Buff him self armor. Armor +" + BerserkCallBuff + " MP: " + BerserkCallMP;
    public double BattleHungerDamage = 150;
    public double BattleHungerMP = 80;
    public String BattleHungerDesc = "||| 2. Burns enemy. Damage: " + BattleHungerDamage + " MP: " + BattleHungerMP;
    public double CounterHelixDamage = 200;
    public double CounterHelixMP = 100;
    public String CounterHelixDesc = "||| 3. Counter attack enemy. Damage: " + CounterHelixDamage + " MP: " + CounterHelixMP;

    public double CullingBladeDamage = 300;
    public double CullingBladeMP = 150;
    public String CullingBladeDesc = "||| 4. Large damage to enemy. Damage: " + CullingBladeDamage + " MP: " + CullingBladeMP;

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
        setDamage(100);
        setAgility(20);
        setArmor(40);
        setMagResist(10);
        setHP(1000);
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

//    @Override
//    public void cast(int spell, Hero enemy) {
//        switch (spell){
//            case 1:
//                BerserkCall();
//            case 2:
//                BattleHunger(enemy);
//            case 3:
//                Counter_Helix(enemy);
//            case 4:
//                Culling_Blade(enemy);
//        }
//    }

    @Override
    public void Cast(int spell, Hero hero) {
        if (spell == 1){
            BerserkCall();
        }
        else if (spell == 2){
            BattleHunger(hero);
        }
        else if (spell == 3){
            CounterHelix(hero);
        }
        else if (spell == 4){
            CullingBlade(hero);
        }
    }
}
