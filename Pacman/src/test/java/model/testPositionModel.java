package model;

import org.example.Model.PositionModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testPositionModel {
    @Test
    public void testConstructor() {
        PositionModel pos = new PositionModel(5, 10);
        assertEquals(5, pos.getX());
        assertEquals(10, pos.getY());
    }

    @Test
    public void testLeft() {
        PositionModel pos1 = new PositionModel(5, 10);
        PositionModel pos =pos1.moveLeft();
        assertEquals(4, pos.getX());
        assertEquals(10, pos.getY());
    }

    @Test
    public void testDown() {
        PositionModel pos1 = new PositionModel(5, 10);
        PositionModel pos = pos1.moveDown();
        assertEquals(5, pos.getX());
        assertEquals(11, pos.getY());
    }


    @Test
    public void testUp() {
        PositionModel pos1 = new PositionModel(5, 10);
        PositionModel pos =pos1.moveUp();
        assertEquals(5, pos.getX());
        assertEquals(9, pos.getY());
    }

    @Test
    public void testRight() {
        PositionModel pos1 = new PositionModel(5, 10);
        PositionModel pos = pos1.moveRight();
        assertEquals(6, pos.getX());
        assertEquals(10, pos.getY());
    }
}