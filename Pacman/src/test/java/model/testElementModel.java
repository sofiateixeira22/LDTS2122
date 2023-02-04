package model;

import org.example.Model.ElementModel;
import org.example.Model.PositionModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testElementModel {
    @Test
    public void testConstructor() {
        ElementModel ele = new ElementModel(new PositionModel(5,5));
        PositionModel pos = new PositionModel(5,5);

        assertEquals(pos, ele.getPosition());
        ele.setPosition(new PositionModel(6,6));
        assertEquals(new PositionModel(6,6), ele.getPosition());
    }

}
