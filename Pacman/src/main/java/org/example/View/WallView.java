package org.example.View;

import org.example.Model.Wall;
import org.example.Model.WallModel;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;

public class WallView {
    public void draw(TextGraphics graphics, WallModel wall_model)
    {
        List<Wall> wall_list = wall_model.getWalls();
        for (Wall wall : wall_list)
        {
            graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
            graphics.setForegroundColor(TextColor.Factory.fromString("#FFF8DC"));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(wall.getPosition().getX(), wall.getPosition().getY()), "#");
        }
    }
}
