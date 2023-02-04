package model;

import org.example.Model.PacmanModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testPacmanModel {
    @Test
    public void testConstructor(){
        PacmanModel pacman = new PacmanModel(5,5);
        assertEquals(3, pacman.getLives());
        pacman.setLives(4);
        assertEquals(4, pacman.getLives());
    }
    @Test
    public void testLoseLife(){
        PacmanModel pacman = new PacmanModel(5,5);
        pacman.loseLife();
        assertEquals(2,pacman.getLives());
    }
}