package model;

import org.example.Model.GameModel;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testGameModel {
    @Test
    public void testConstructor() throws URISyntaxException {
        GameModel game = new GameModel(10,10);
        assertEquals(10, game.getHeight());
        assertEquals(10, game.getWidth());
    }

    @Test
    public void testGetters() throws URISyntaxException {
        GameModel game = new GameModel(10,10);
        assertEquals(3, game.getPacmanModel().getLives());
        assertEquals(4, game.getLevelModel().getGhostModel().getGhosts().size());
    }
}