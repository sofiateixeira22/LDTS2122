package org.example.View;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class FinalScreenView {
    public void draw(TextGraphics graphics, int event){
        if(event == 0) {
            graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF00"));
            graphics.putString(new TerminalPosition(15, 5), " #              #");
            graphics.putString(new TerminalPosition(15, 6), "##              ##");
            graphics.putString(new TerminalPosition(15, 7), "  #   ######   #");
            graphics.putString(new TerminalPosition(15, 8), "   # ######## #");
            graphics.putString(new TerminalPosition(15, 9), "    ##########");
            graphics.putString(new TerminalPosition(15, 10), "    ##  ##  ##");
            graphics.putString(new TerminalPosition(15, 11), "    ##  ##  ##");
            graphics.putString(new TerminalPosition(15, 12), "     ########");
            graphics.putString(new TerminalPosition(15, 13), "      ######");
            graphics.putString(new TerminalPosition(15, 14), "     # #### #");
            graphics.putString(new TerminalPosition(15, 15), "    #        #");
            graphics.putString(new TerminalPosition(15, 16), "  ##          ##");
            graphics.putString(new TerminalPosition(15, 17), "   #          #");
            graphics.putString(new TerminalPosition(20, 2), "GAME OVER!");
            graphics.putString(new TerminalPosition(20, 20), "NEW GAME");
            graphics.putString(new TerminalPosition(20, 23), "MENU");
            graphics.putString(new TerminalPosition(20, 26), "QUIT");
        }
        else{
            graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF00"));
            graphics.putString(new TerminalPosition(20, 2), "YOU WON");
            graphics.putString(new TerminalPosition(15, 5), "  ___________");
            graphics.putString(new TerminalPosition(15, 6), " `._==_==_=_.`");
            graphics.putString(new TerminalPosition(15, 7), " .-\\:       /-.");
            graphics.putString(new TerminalPosition(15, 8), "| (|:.     |) |");
            graphics.putString(new TerminalPosition(15, 9), " `-|:.     |-`");
            graphics.putString(new TerminalPosition(15, 10), "   \\::.    /");
            graphics.putString(new TerminalPosition(15, 11), "    `::. .`");
            graphics.putString(new TerminalPosition(15, 12), "      ) (");
            graphics.putString(new TerminalPosition(15, 13), "    _.` `._");
            graphics.putString(new TerminalPosition(15, 14), "   `\"\"\"\"\"\"\"`");
            graphics.putString(new TerminalPosition(20, 20), "PLAY AGAIN");
            graphics.putString(new TerminalPosition(20, 23), "MENU");
            graphics.putString(new TerminalPosition(20, 26), "QUIT");
        }
    }
}
