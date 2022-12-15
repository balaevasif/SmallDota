package testVersion0_0_2.Heroes;

public class WraithKing extends Hero {
    private double WraithfireBlast = 300;
    private double WraithfireBlastMP = 150;
    private String WraithfireBlastDesc = "1. Pure damage, Attack enemy and deals: " + WraithfireBlast + " damage, MP: " + WraithfireBlastMP;

    private boolean VampiricSpirit = false;
    private double VampiricSpiritMP = 200;
    private String VampiricSpiritDesc = "||| 2. Activation vampirism MP: " + damage / 3;

    public WraithKing(){
        setName("WraithKing");
        setDamage(200);
        setArmor(100);
        setAgility(30);
        setHP(1000);
        setMP(500);
        setMagResist(200);
        getSkills();
        attackOrBuffs();
        id++;

    }

    private void attackOrBuffs() {
        attackOrBuff.put(1, 1);
        attackOrBuff.put(2, 0);
    }

    private void getSkills() {
        Skills.add(WraithfireBlastDesc);
        Skills.add(VampiricSpiritDesc);
    }

    public void WraithfireBlast(Hero hero){
        hero.HP -= WraithfireBlast;

    }

    public void VampiricSpirit(){
        VampiricSpirit = true;
    }

    @Override
    public void bit(Hero enemy) {
        //super.bit(enemy);
        enemy.HP -= damage;
        HP += damage / 3;

        System.out.println(enemy.name + " HP was: " + enemy.HP);
        enemy.HP -= damage;
        //
        System.out.println(name + " bites " + enemy.name);
        System.out.println(enemy.name + " HP became " + enemy.HP);
    }

    @Override
    public void Cast(int spell, Hero hero) {
        switch (spell) {
            case 1 -> WraithfireBlast(hero);
            case 2 -> VampiricSpirit();
        }
    }

    @Override
    public void lvlUp() {
        super.lvlUp();

        damage += 100 * lvl;
        armor += 50 * lvl;
        agility += 10 * lvl;
        WraithfireBlast += 100 * lvl;
        WraithfireBlastMP += 50 * lvl;

        WraithfireBlastDesc = "1. Pure damage, Attack enemy and deals: " + WraithfireBlast + " damage, MP: " + WraithfireBlastMP;
        VampiricSpiritDesc += "||| 2. Activation vampirism MP: " + damage / 3;

        Skills.clear();
        getSkills();
    }
}
