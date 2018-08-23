
/*
 *
 * @project - MonsterGame
 * @author - ujjwalbatra on 22/08/18
 *
 */

package model.unittest;

import model.Cell;
import model.Map;
import model.Movable;
import model.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Movable player;
    Map map;
    @BeforeEach
    void setUp() {
        map = new Map();
        player = new Player(map, 0, 0);
    }

    @Test
    public void checkPlayerMovement(){

        player.setxCorrdinate(4);
        player.setyCoordinate(4);

        player.move(map, "right");

        assertEquals(5, player.getyCoordinate());
        assertEquals(4, player.getxCorrdinate());

        assertTrue(map.getMap()[4][4] instanceof Cell);
        assertTrue(map.getMap()[4][5] instanceof Player);

        player.move(map, "left");
        player.move(map, "left");

        assertTrue(map.getMap()[4][4] instanceof Cell);
        assertTrue(map.getMap()[4][5] instanceof Cell);
        assertTrue(map.getMap()[4][3] instanceof Player);

        player.move(map, "right");
        player.move(map, "down");

        assertTrue(map.getMap()[4][3] instanceof Cell);
        assertTrue(map.getMap()[4][4] instanceof Cell);
        assertTrue(map.getMap()[5][4] instanceof Player);

        player.move(map, "up");
        player.move(map, "up");

        assertTrue(map.getMap()[5][4] instanceof Cell);
        assertTrue(map.getMap()[4][4] instanceof Cell);
        assertTrue(map.getMap()[3][4] instanceof Player);
    }

    @Test
    public void checkIfPlayerRunOutOfMap(){

        player.move(map,"left");
        assertEquals(0, player.getyCoordinate());
        assertEquals(0, player.getxCorrdinate());
    }

    @Test
    public void checkIfPlayerRunIntoWall(){

        player.move(map,"right");
        player.move(map,"down");

        assertEquals(1, player.getyCoordinate());
        assertEquals(0, player.getxCorrdinate());

        player.move(map,"down");
        player.move(map,"down");
        player.move(map,"down");

        assertEquals(1, player.getyCoordinate());
        assertEquals(0, player.getxCorrdinate());

    }

    @AfterEach
    void tearDown() {
    }
}