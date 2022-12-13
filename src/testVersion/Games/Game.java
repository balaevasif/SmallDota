package testVersion.Games;

import testVersion.Heroes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    Hero attackHero;
    Hero defendHero;
    Hero turn;
    String gameAction;
    boolean move = false;

    public List<Hero> radiantHeroes = new ArrayList<>();
    public List<Hero> direHeroes = new ArrayList<>();

    public List<Hero> radiant = new ArrayList<>();
    public List<Hero> dire = new ArrayList<>();

    public Game(){
        radiantHeroes.add(new Omniknight());
        radiantHeroes.add(new Sniper());

        direHeroes.add(new Axe());
        direHeroes.add(new PhantomAssassin());
    }
    public void showRadians(){
        int i = 1;
        System.out.println("Heroes of Radian's");
        for (Hero s:
                radiantHeroes) {
            System.out.println(i + ": " + s.name);
            i++;
        }
    }
    public void showDires(){
        int i = 1;
        System.out.println("Heroes of Dire's");
        for (Hero s:
                direHeroes) {
            System.out.println(i + ": " + s.name);
            i++;
        }
    }
    public void showAllSides(){
        showRadians();
        showDires();
    }

    public void radiantTeam(){
        System.out.println("Radiant's team: ");
        int i = 1;
        for (Hero radiantsHero:
                radiant) {
            System.out.println(i + ": " + radiantsHero.name);
            i++;
        }
    }
    public void direTeam(){
        System.out.println("Dire's team: ");
        int i = 1;
        for (Hero direHero:
                dire) {
            System.out.println(i + ": " + direHero.name);
            i++;
        }
    }
    public void choose_person(int vs){
        do {
            showRadians();
            System.out.println("Turn first player");
            Scanner p1 = new Scanner(System.in);
            int turn_p1 = p1.nextInt() - 1;
            radiant.add(radiantHeroes.get(turn_p1));
            radiantHeroes.remove(turn_p1);

            showDires();
            System.out.println("Turn second player");
            Scanner p2 = new Scanner(System.in);
            int turn_p2 = p2.nextInt() - 1;
            dire.add(direHeroes.get(turn_p2));
            direHeroes.remove(turn_p2);

        } while (radiant.size() != vs && dire.size() != vs);
    }

    public void fight(){
        while (true){
            System.out.println("_____________________________");
            System.out.println("Radiant's team is attacking. ");
            System.out.println("Choose a hero to move: ");
            if (move){
                radiantTeam();
            } else {direTeam();}
            Scanner chooseHeroRad = new Scanner(System.in);
            int chosenHero = chooseHeroRad.nextInt() - 1;
            attackHero = radiant.get(chosenHero);
            System.out.println(attackHero.name);

            System.out.println("Attack or cast spell? 1-attack, 2-spell");
            Scanner attOrCast = new Scanner(System.in);
            int chosenMove = attOrCast.nextInt();

            if (chosenMove == 1){
                System.out.println("Which a hero do you want to attack? ");
                direTeam();
                Scanner attack_enemy = new Scanner(System.in);
                int which_enemy = attack_enemy.nextInt() - 1;
                defendHero = dire.get(which_enemy);
                attackHero.bit(defendHero);
            }
            else if (chosenMove == 2) {
                System.out.println("What is the skill do you want to cast?");
                attackHero.showSkills();
                Scanner chooseSkill = new Scanner(System.in);
                int chosenSkill = chooseSkill.nextInt();
                if (attackHero.kindOfSpell(chosenSkill) == 1){
                    System.out.println("What a dire's hero do you want a bit?");
                    direTeam();
                    Scanner attack_enemy = new Scanner(System.in);
                    int which_enemy = attack_enemy.nextInt() - 1;
                    defendHero = dire.get(which_enemy);
                    System.out.println("_________" + defendHero.HP);
                    attackHero.Cast(chosenSkill, defendHero);
                    System.out.println("_________" + defendHero.HP);
                }
                //Buffing him self
                else if (attackHero.kindOfSpell(chosenSkill) == 0) {
                    attackHero.Cast(chosenSkill, defendHero);
                }
                //Healing him self or teammate
                else if (attackHero.kindOfSpell(chosenSkill) == 2) {
                    System.out.println("What a teammate do you want to heal?");
                    radiantTeam();
                    Scanner healTeammate = new Scanner(System.in);
                    int whom = healTeammate.nextInt() - 1;
                    attackHero.Cast(chosenSkill, radiant.get(whom));
                }
            }
//            turn = attackHero;
//            attackHero = defendHero;
//            defendHero = turn;
//            move = true;

        }
    }
    public String toString(){
        return gameAction;
    }

}
