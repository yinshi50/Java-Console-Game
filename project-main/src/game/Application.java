package game;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.*;
import game.actors.*;
import game.ground.*;
import game.items.*;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * Chong Woon Kai, Gerard
 * Tong Zhi Enn
 */
public class Application {

    public static void main(String[] args) {

        World world = new World(new Display());

        //new
        HashMap<String, GameMap> worldList = new HashMap<>();
        HashMap<GameMap, Location> travelDestination = new HashMap<>();
        //

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(),
                new Wall(), new Floor(), new Puddle(), new ComputerTerminal());

        Ground terminal = new ComputerTerminal();


        List<String> map = Arrays.asList(
                        "...~~~~.........~~~...........",
                        "...~~~~.......................",
                        "...~~~........................",
                        "..............................",
                        ".............#####............",
                        ".............#__=#...........~",
                        ".............#___#..........~~",
                        ".............##_##.........~~~",
                        ".................~~........~~~",
                        "................~~~~.......~~~",
                        ".............~~~~~~~........~~",
                        "......~.....~~~~~~~~.........~",
                        ".....~~~...~~~~~~~~~..........",
                        ".....~~~~~~~~~~~~~~~~........~",
                        ".....~~~~~~~~~~~~~~~~~~~....~~");

        GameMap gameMap = new GameMap(groundFactory, map);
        world.addGameMap(gameMap);
        worldList.put("Polymorphia", gameMap);
        Location location = gameMap.at(16,5);
        location.setGround(terminal);
        travelDestination.put(gameMap, location);

        List<String> factoryMap = Arrays.asList(
                ".......",
                ".#####.",
                ".#__=#.",
                ".#___#.",
                ".##_##.",
                ".......",
                ".......",
                ".......",
                ".......",
                "......."
        );

        GameMap factory = new GameMap(groundFactory, factoryMap);
        world.addGameMap(factory);
        worldList.put("Factory", factory);
        Location location2 = factory.at(4, 2);
        location2.setGround(terminal);
        travelDestination.put(factory, location2);

        List<String> RefactorioMap = Arrays.asList(
                "..........................~~~~",
                "..........................~~~~",
                "..........................~~~~",
                "~..........................~..",
                "~~...........#####............",
                "~~~..........#__=#............",
                "~~~..........#___#............",
                "~~~..........##_##............",
                "~~~..................~~.......",
                "~~~~................~~~~......",
                "~~~~...............~~~~~......",
                "..~................~~~~.......",
                "....................~~........",
                ".............~~...............",
                "............~~~~..............");

        GameMap refactorio = new GameMap(groundFactory, RefactorioMap);
        world.addGameMap(refactorio);
        worldList.put("Refactorio", refactorio);
        Location location3 = refactorio.at(16, 5);
        location3.setGround(terminal);
        travelDestination.put(refactorio, location3);

        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        gameMap.at(7, 9).addActor(new HuntsmanSpider());

        // Uncomment to test
//        HuntsmanSpiderTest test = new HuntsmanSpiderTest(gameMap);
//        test.spiderSpaceshipFloorTest();
//        test.spiderAttackSpiderTest();
//        test.craterExitFullTest();


        Player player = new Player("Intern", '@', 4, worldList, travelDestination);
        player.addBalance(10000);
        world.addPlayer(player, gameMap.at(15, 6));
//        world.addPlayer(player, factory.at(3, 2));
//        world.addPlayer(player, newMoon.at(15, 6));

        Item largeBolts1 = new LargeBolts();
        gameMap.at(21, 5).addItem(largeBolts1);

        Item largeBolts2 = new LargeBolts();
        gameMap.at(24, 2).addItem(largeBolts2);

        Item largeBolts3 = new LargeBolts();
        gameMap.at(9, 3).addItem(largeBolts3);

//        Item largeBolts4 = new LargeBolts();
//        gameMap.at(15, 5).addItem(largeBolts4);

        Item metalSheets1 = new MetalSheets();
        gameMap.at(15, 10).addItem(metalSheets1);

        Item metalSheets2 = new MetalSheets();
        gameMap.at(15, 10).addItem(metalSheets2);

        Item metalSheets3 = new MetalSheets();
        gameMap.at(15, 12).addItem(metalSheets3);

        Ground polyTree1 = new PolymorphiaTree();
        gameMap.at(4, 4).setGround(polyTree1);

        Ground polyTree2 = new PolymorphiaTree();
        gameMap.at(13, 1).setGround(polyTree2);

        Ground polyTree3 = new PolymorphiaTree();
        gameMap.at(26, 4).setGround(polyTree3);

        Ground crater1 = new Crater(new HuntsmanSpider());
        gameMap.at(18, 2).setGround(crater1);

        Ground crater2 = new Crater(new AlienBug());
        gameMap.at(25, 11).setGround(crater2);

        Ground crater3 = new Crater(new SuspiciousAstronaut());
        gameMap.at(20, 9).setGround(crater3);

        Item metalPipe = new MetalPipe();
        gameMap.at(15, 8).addItem(metalPipe);

        Ground refacTree1 = new RefactorioTree();
        refactorio.at(4, 4).setGround(refacTree1);

        Ground refacTree2 = new RefactorioTree();
        refactorio.at(13, 1).setGround(refacTree2);

        Ground refacTree3 = new RefactorioTree();
        refactorio.at(26, 4).setGround(refacTree3);

//        Enemy alienBug1 = new AlienBug();
//        gameMap.at(12,10).addActor(alienBug1);
//
//        Enemy alienBug2 = new AlienBug();
//        gameMap.at(20,4).addActor(alienBug2);

//        Enemy alienBug3 = new AlienBug();
//        gameMap.at(14,10).addActor(alienBug3);


        Item gold = new Gold();
        gameMap.at(19, 11).addItem(gold);

        Item pickleJar = new PickleJar();
        gameMap.at(9, 13).addItem(pickleJar);

//        Ground terminal = new ComputerTerminal();
//        gameMap.at(16, 5).setGround(terminal);

        Ground humanoidFigure = new HumanoidFigure();
        factory.at(3, 6).setGround(humanoidFigure);

        world.run();

        for (String line : FancyMessage.YOU_ARE_FIRED.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
