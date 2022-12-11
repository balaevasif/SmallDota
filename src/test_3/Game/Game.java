package test_3.Game;

import test_3.Heroes.*;

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
            System.out.println(i + ": " + s);
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

        //while (radiant.size() <= 1 && dire.size() <= 1){

        while (true){
            show_radians();
            System.out.println("Turn first player");
            Scanner p1 = new Scanner(System.in);
            int turn_p1 = p1.nextInt()-1;
            radiant.add(radiantHeroes.get(turn_p1));
            radiantHeroes.remove(turn_p1);

            show_dires();
            System.out.println("Turn second player");
            Scanner p2 = new Scanner(System.in);
            int turn_p2 = p2.nextInt()-1;
            dire.add(direHeroes.get(turn_p2));
            direHeroes.remove(turn_p2);

            if (radiant.size() == 2 || dire.size() == 2){
                break;
            }
        }


        //}





    }




//    public Game(){
//        System.out.println("Choose a hero for radiant: ");
//        for (Heroes h:
//                Heroes.values()) {
//            System.out.println(h.name() + "-" + (h.ordinal()+1));
//        }
//
//        Scanner sc = new Scanner(System.in);
//        int heroChose = sc.nextInt();
//        switch (heroChose){
//            case 1:
//                radiantHeroes.add(new Axe());
//            case 2:
//                radiantHeroes.add(new Sniper());
//        }
//
//        System.out.println("Choose a hero for dire: ");
//        for (Heroes h:
//                Heroes.values()) {
//            System.out.println(h.name() + "-" + (h.ordinal()+1));
//        }
//        Scanner sc1 = new Scanner(System.in);
//        int heroChose1 = sc1.nextInt();
//        switch (heroChose1){
//            case 1:
//                direHeroes.add(new Axe());
//            case 2:
//                direHeroes.add(new Sniper());
//
//        }
//    }

    public String toString(){
        return gameAction;
    }

//    public void turn(){
//        while (true){
//            System.out.println("Choose a hero for radiant: ");
//        }
//    }

}
