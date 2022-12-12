package test_5.Game;

import test_5.Heroes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    Hero attackHero;
    Hero defendHero;
    String gameAction;

    public List<Hero> radiantHeroes = new ArrayList<>();
    public List<Hero> direHeroes = new ArrayList<>();

    public List<Hero> radiant = new ArrayList<>();
    public List<Hero> dire = new ArrayList<>();

    public Game(){
        radiantHeroes.add(new Axe());
        radiantHeroes.add(new Omniknight());

        direHeroes.add(new Sniper());
        direHeroes.add(new PhantomAssassin());
    }
    public void show_radians(){
        int i = 1;
        System.out.println("Heroes of Radian's");
        for (Hero s:
                radiantHeroes) {
            System.out.println(i + ": " + s.name);
            i++;
        }
    }
    public void show_dires(){
        int i = 1;
        System.out.println("Heroes of Dire's");
        for (Hero s:
                direHeroes) {
            System.out.println(i + ": " + s.name);
            i++;
        }
    }
    public void show_all_sides(){
        show_radians();
        show_dires();
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
    
    public void choose_person(){
        do {
            show_radians();
            System.out.println("Turn first player");
            Scanner p1 = new Scanner(System.in);
            int turn_p1 = p1.nextInt() - 1;
            radiant.add(radiantHeroes.get(turn_p1));
            radiantHeroes.remove(turn_p1);

            show_dires();
            System.out.println("Turn second player");
            Scanner p2 = new Scanner(System.in);
            int turn_p2 = p2.nextInt() - 1;
            dire.add(direHeroes.get(turn_p2));
            direHeroes.remove(turn_p2);

        } while (radiant.size() != 2 && dire.size() != 2);
    }

    public void fight(){
        while (true){
            System.out.println("_____________________________");
            System.out.println("Radiant's team is attacking. ");
            System.out.println("Choose a hero to move: ");
            radiantTeam();
            Scanner chooseHeroRad = new Scanner(System.in);
            int chosenHero = chooseHeroRad.nextInt() - 1;
            attackHero = radiant.get(chosenHero);
            System.out.println(attackHero.name);

            System.out.println("Attack or cast spell? 1-attack, 2-spell");
            Scanner attOrCast = new Scanner(System.in);
            int chosenMove = attOrCast.nextInt();

            switch (chosenMove){
                case 1:
                    System.out.println("Which a hero do you want to attack? ");
                    direTeam();
                    Scanner attack_enemy = new Scanner(System.in);
                    int which_enemy = attack_enemy.nextInt() - 1;
                    defendHero = dire.get(which_enemy);
                    attackHero.Bit(defendHero);
                case 2:
                    System.out.println("What is the skill do you want to cast?");
                    attackHero.show_skills();
                    Scanner chooseSkill = new Scanner(System.in);
                    int chosenSkill = chooseSkill.nextInt();
            }


        }
    }
    public String toString(){
        return gameAction;
    }

}
