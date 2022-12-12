package test_4.Game;

import test_4.Heroes.*;

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
            Scanner move = new Scanner(System.in);
            int hero_move = move.nextInt() - 1;
            attackHero = radiant.get(hero_move);
            System.out.println(attackHero.name);

            System.out.println("Which a hero do you want to attack? ");

            direTeam();
            Scanner enemies = new Scanner(System.in);
            int which_enemy = enemies.nextInt() - 1;
            defendHero = dire.get(which_enemy);

            System.out.println("Bit or cast spell?");

            Scanner bitOrCast = new Scanner(System.in);

            int bitorcast = bitOrCast.nextInt() - 1;

            switch (bitorcast){
                case 1:
                    attackHero.Bit(defendHero);
                case 2:
                    System.out.println("What is skill do you want to use?");

                    attackHero.show_skills();

                    Scanner sc = new Scanner(System.in);

                    int skill = sc.nextInt();

                    if (attackHero.isHeal){
                        System.out.println("What is teammate do you want to heal?");
                        radiantTeam();

                        Scanner heal = new Scanner(System.in);
                        int heal_teammate = heal.nextInt() - 1;

                        attackHero.Cast(skill, radiantHeroes.get(heal_teammate));

                    }
                    else{

                        attackHero.Cast(skill, defendHero);
                    }



                    //attackHero.Cast(1, defendHero);
            }

            System.out.println("_____________________________");
            System.out.println("Dire's team is attacking. ");
            System.out.println("Choose a hero to move: ");
            Scanner move1 = new Scanner(System.in);
            int hero_move1 = move.nextInt() - 1;
            defendHero = dire.get(hero_move1);
            System.out.println(defendHero.name);

            System.out.println("Which a hero do you want to attack? ");

            radiantTeam();
            Scanner enemies1 = new Scanner(System.in);
            int which_enemy1 = enemies1.nextInt() - 1;
            defendHero = dire.get(which_enemy1);

            System.out.println("Bit or cast spell?");

            Scanner bitOrCast1 = new Scanner(System.in);

            int bitorcast1 = bitOrCast1.nextInt() - 1;

            switch (bitorcast1){
                case 1:
                    defendHero.Bit(attackHero);
                case 2:
                    System.out.println("What is skill do you want to use?");

                    defendHero.show_skills();

                    Scanner sc = new Scanner(System.in);
                    defendHero.Cast(sc.nextInt(), attackHero);



                    //attackHero.Cast(1, defendHero);
            }






        }
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
