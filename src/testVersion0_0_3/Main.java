package testVersion0_0_3;

import testVersion0_0_3.Games.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.showAllSides();
        System.out.println("______________");
        System.out.println("Chose a heroes!");
        System.out.println("______________");
        game.choose_person(2);
        System.out.println("_______________________________________");
        System.out.println("Teams are completed! The battle begins!");
        System.out.println("_______________________________________");
        game.fight();
    }
}