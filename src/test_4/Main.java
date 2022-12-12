package test_4;

import test_4.Game.Game;
import test_4.Heroes.Axe;
import test_4.Heroes.PhantomAssassin;

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

//        Axe axe = new Axe();
//        PhantomAssassin pa = new PhantomAssassin();
//
//        //axe.Culling_Blade(pa);
//
//        System.out.println(axe.HP);
//        pa.Bit(axe);
//        System.out.println(axe.HP);


    }
}
