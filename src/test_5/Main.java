package test_5;

import test_5.Game.Game;
import test_5.Heroes.Axe;
import test_5.Heroes.Omniknight;

public class Main {
    public static void main(String[] args){

        Game game = new Game();

        //Show all sides
        //game.show_all_sides();

        //Everyone choose hero in his team
        game.choose_person();

        game.radiantTeam();
        game.direTeam();

        game.fight();


    }
}
