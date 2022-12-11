package test_2.Game;

import test_2.Enums.Heroes;

import test_2.Heroes.Axe;
import test_2.Heroes.Hero;
import test_2.Heroes.Sniper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    Hero attackHero;
    Hero defendHero;
    String gameAction;

    public List<Hero> radiantHeroes = new ArrayList<>();
    public List<Hero> direHeroes = new ArrayList<>();

    public Game(){
        System.out.println("Choose a hero for radiant: ");
        for (Heroes h:
                Heroes.values()) {
            System.out.println(h.name() + "-" + (h.ordinal()+1));
        }

        Scanner sc = new Scanner(System.in);
        int heroChose = sc.nextInt();
        switch (heroChose){
            case 1:
                radiantHeroes.add(new Axe());
            case 2:
                radiantHeroes.add(new Sniper());
        }

        System.out.println("Choose a hero for dire: ");
        for (Heroes h:
                Heroes.values()) {
            System.out.println(h.name() + "-" + (h.ordinal()+1));
        }
        Scanner sc1 = new Scanner(System.in);
        int heroChose1 = sc1.nextInt();
        switch (heroChose1){
            case 1:
                direHeroes.add(new Axe());
            case 2:
                direHeroes.add(new Sniper());

        }







    }

    public String toString(){
        return gameAction;
    }

//    public void turn(){
//        while (true){
//            System.out.println("Choose a hero for radiant: ");
//        }
//    }

}
