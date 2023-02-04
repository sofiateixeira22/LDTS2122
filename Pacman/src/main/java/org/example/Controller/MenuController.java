package org.example.Controller;

import org.example.Model.GameModel;
import org.example.View.GameView;
import org.example.View.MenuView;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import java.io.IOException;
import java.net.URISyntaxException;

public class MenuController{
        private final GameModel model;
        private final GameView view;
        public GameController controller;
        private final MenuView menuview = new MenuView();
        private int arrowpos = 12;
        public boolean endgame = false;
        public MenuController(GameModel model, GameView view) {
            controller = new GameController(model,view);
            this.model = model;
            this.view = view;

}
    public void start(){
        int temp = 0;
        try {
            while (temp == 0 && !endgame) {
                view.getScreen().clear();
                menuview.draw(view.getScreen().newTextGraphics());
                view.getScreen().newTextGraphics().putString(new TerminalPosition(17, arrowpos), "->");
                view.getScreen().refresh();
                KeyStroke key = view.getScreen().readInput();
                if(key.getKeyType() == KeyType.EOF) endgame = true;
                if(key.getKeyType() == KeyType.Escape) endgame = true;
                temp = processKey(key);
                menuview.draw(view.getScreen().newTextGraphics());
            }
            if(temp == 1){
                controller.start();
            }
            if(temp == 2) System.exit(0);
            if(endgame == true) System.exit(0);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

    }
    public int processKey(KeyStroke key) {
        if (key.getKeyType() == KeyType.ArrowUp) {
            if(arrowpos == 12) arrowpos = 15;
            else arrowpos -=3;
        }
        if (key.getKeyType() == KeyType.ArrowDown){
            if(arrowpos == 15) arrowpos = 12;
            else arrowpos +=3;
        }
        if (key.getKeyType() == KeyType.Escape) endgame = true;
        if (key.getKeyType() == KeyType.Enter){
            if(arrowpos == 12) return 1;
            if(arrowpos == 15) return 2;
        }

        return 0;
    }
}
