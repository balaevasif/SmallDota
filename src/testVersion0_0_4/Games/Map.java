package testVersion0_0_4.Games;

import testVersion0_0_4.Heroes.Hero;

public class Map {
    static Hero[][] map = new Hero[5][5];
    Game game = new Game();

//    public void maps(){
//        game.showAllSides();
//        System.out.println("______________");
//        System.out.println("Chose a heroes!");
//        System.out.println("______________");
//        game.choose_person(2);
//
//
//        System.out.println("_______________________________________");
//        System.out.println("Teams are completed! The battle begins!");
//        System.out.println("_______________________________________");
//        game.fight();
//    }

    public void test(){
        game.showAllSides();
        System.out.println("______________");
        System.out.println("Chose a heroes!");
        System.out.println("______________");
        game.choose_person(2);
        System.out.println("______________");
        game.showAllTeam();
    }

    public void chosePosition(){

    }

    public static void showMap(){
        for (Hero[] heroes : map) {
            for (Hero hero : heroes) {
                System.out.print(hero + "\t");
            }
            System.out.println();
        }
    }

    public static void setPosHero(Hero hero, int x, int y){
        map[x][y] = hero;
    }



}
