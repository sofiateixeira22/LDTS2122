package model;

import org.example.Model.WallModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testWallModel {
    @Test
    public void testConstructor(){
        WallModel wa = new WallModel();
        assertEquals(0, wa.getWalls().size());
    }

}