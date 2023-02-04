package org.example.View;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class MenuView {

    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF00"));
        graphics.putString(new TerminalPosition(2, 2), " _ __   __ _  ___ _ __ ___   __ _ _ __  ");
        graphics.putString(new TerminalPosition(2, 3), "| ._ \\ / _. |/ __| ._ . _ \\ / _. | ._ \\ ");
        graphics.putString(new TerminalPosition(2, 4), "| |_) | (_| | (__| | | | | | (_| | | | |");
        graphics.putString(new TerminalPosition(2, 5), "| .__/ \\__._|\\___|_| |_| |_|\\__._|_| |_|");
        graphics.putString(new TerminalPosition(2, 6), "|_|                                     ");

        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#eb0e2b"));
        graphics.putString(new TerminalPosition(20, 12), "PLAY");
        graphics.putString(new TerminalPosition(20, 15), "QUIT");


    }
}