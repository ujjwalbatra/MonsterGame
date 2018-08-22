
/*
 *
 * @project - MonsterGame
 * @author - ujjwalbatra on 22/08/18
 *
 */

package model;

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
    public void checkplayerposition(){
        assertTrue(player.getxCorrdinate() == 1);
    }

    @AfterEach
    void tearDown() {
    }
}