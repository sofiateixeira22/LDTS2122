package org.example.View;

import org.example.Model.PacmanModel;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class PacmanView {
    public void draw(TextGraphics graphics, PacmanModel pacman_model, int dir)
    {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF00"));
        graphics.enableModifiers(SGR.BOLD);
        switch(dir){
            case 1:
                graphics.putString(new TerminalPosition(pacman_model.getPosition().getX(), pacman_model.getPosition().getY()), "y");
                break;
            case 2:
                graphics.putString(new TerminalPosition(pacman_model.getPosition().getX(), pacman_model.getPosition().getY()), "x");
                break;
            case 3:
                graphics.putString(new TerminalPosition(pacman_model.getPosition().getX(), pacman_model.getPosition().getY()), "@");
                break;
            case 4:
                graphics.putString(new TerminalPosition(pacman_model.getPosition().getX(), pacman_model.getPosition().getY()), "z");
                break;
            default: break;
        }
    }
    public void drawLives(TextGraphics graphics, PacmanModel pacmanmodel){
        for(int i=0; i<pacmanmodel.getLives(); i++) {
            graphics.putString(new TerminalPosition(35+i*2, 7), "'");
        }
    }
}

