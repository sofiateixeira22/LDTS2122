package model;

import org.example.Model.Ghost;
import org.example.Model.GhostModel;
import org.example.Model.PositionModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testGhostModel {
    @Test
    public void testConstructor(){
        Ghost ghost = new Ghost(new PositionModel(5,5));
        ghost.setDirection(new PositionModel(6,5));
        assertEquals(new PositionModel(6,5), ghost.getDirection());

    }

    @Test
    public void testGhostList(){
        GhostModel ghostlist = new GhostModel();
        ghostlist.addGhost(new PositionModel(5,5));
        assertEquals(1, ghostlist.getGhosts().size());
    }
}