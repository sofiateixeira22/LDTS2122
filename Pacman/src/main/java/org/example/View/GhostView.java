package org.example.View;

import org.example.Model.Ghost;
import org.example.Model.GhostModel;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;

public class GhostView {
    public void draw(TextGraphics graphics, GhostModel ghost_model)
    {
        List<Ghost> ghost_list = ghost_model.getGhosts();
        for (Ghost ghost : ghost_list)
        {
            graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
            graphics.setForegroundColor(TextColor.Factory.fromString("#eb0e2b"));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(ghost.getPosition().getX(), ghost.getPosition().getY()), "$");
        }
    }
}