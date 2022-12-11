package test_3;

import test_3.Game.Game;

public class Main {
    public static void main(String[] args){

        Game game = new Game();

        //Show all sides
        //game.show_all_sides();

        //Everyone choose hero in his team
        game.choose_person();

        game.radiantTeam();
        game.direTeam();

    }
}
