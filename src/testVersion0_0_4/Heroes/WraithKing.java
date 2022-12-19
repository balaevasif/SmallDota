package testVersion0_0_4.Heroes;


public class WraithKing extends Hero {
    private double WraithfireBlast = 300;
    private double WraithfireBlastMP = 150;
    private String WraithfireBlastDesc = "1. Pure damage, Attack enemy and deals: " + WraithfireBlast + " damage, MP: " + WraithfireBlastMP;

    private boolean VampiricSpirit = false;
    private double VampiricSpiritMP = 200;
    private String VampiricSpiritDesc = "||| 2. Activation vampirism MP: " + damage / 3;

    //private int lifes = 2;

    public WraithKing(){
        setName("WraithKing");
        setDamage(150);
        setArmor(100);
        setAgility(30);
        setHP(1000);
        setMP(500);
        setMagResist(50);
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
        VampiricSpirit = !VampiricSpirit;
        MP -= VampiricSpiritMP;
    }

    @Override
    public void bit(Hero enemy) {
        super.bit(enemy);
        if (VampiricSpirit){
            HP += damage / 3;
        }
    }

    @Override
    public void cast(int spell, Hero hero) {
        switch (spell) {
            case 1 -> WraithfireBlast(hero);
            case 2 -> VampiricSpirit();
        }
    }

    @Override
    public void lvlUp() {
        super.lvlUp();

        damage += 50 * lvl;
        armor += 50 * lvl;
        agility += 10 * lvl;
        WraithfireBlast += 100 * lvl;
        WraithfireBlastMP += 50 * lvl;

        VampiricSpiritMP += 10 * lvl;

        WraithfireBlastDesc = "1. Pure damage, Attack enemy and deals: " + WraithfireBlast + " damage, MP: " + WraithfireBlastMP;
        VampiricSpiritDesc += "||| 2. Activation vampirism MP: " + damage / 3;

        Skills.clear();
        getSkills();
    }

}

