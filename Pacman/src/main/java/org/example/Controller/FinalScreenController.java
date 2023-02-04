package org.example.Controller;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.example.Model.GameModel;
import org.example.View.FinalScreenView;
import org.example.View.GameView;
import java.io.IOException;
import java.net.URISyntaxException;

public class FinalScreenController {
    private final GameModel model;
    private final GameView view;
    private int event;
    private final FinalScreenView fsview = new FinalScreenView();
    private int arrowpos = 20;
    public boolean endgame = false;
    public KeyStroke key;

    public FinalScreenController(GameModel model, GameView view, int event) {
        this.model = model;
        this.view = view;
        this.event = event;
    }

        public void start (int event1) {
            event = event1;
            int temp= 0;
            try {
                while (temp == 0 && !endgame) {
                    view.getScreen().clear();
                    fsview.draw(view.getScreen().newTextGraphics(), event);
                    view.getScreen().newTextGraphics().putString(new TerminalPosition(17, arrowpos), "->");
                    view.getScreen().refresh();
                    key = view.getScreen().readInput();
                    temp = processKey(key);
                    if (key.getKeyType() == KeyType.EOF) endgame = true;
                    if (key.getKeyType() == KeyType.Escape) endgame = true;
                }
                if (temp == 1) {
                    if(event == 1) model.getLevelModel().nextLevel();
                    if(event == 0) model.getLevelModel().resetlevel();
                    model.setNewGame();
                    model.getLevelModel().setupLevel();
                    model.getPacmanModel().resetPacman();
                    model.newPac();
                    new GameController(model, view).start();
                }
                if (temp == 2) {
                    model.setNewGame();
                    model.getLevelModel().setupLevel();
                    model.getPacmanModel().resetPacman();
                    model.newPac();
                    new MenuController(model, view).start();
                }
                if (temp == 3) System.exit(0);
                if (endgame == true) System.exit(0);
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }
    public int processKey(KeyStroke key) {
        if (key.getKeyType() == KeyType.ArrowUp) {
            if(arrowpos == 20) arrowpos = 26;
            else arrowpos -=3;
        }
        if (key.getKeyType() == KeyType.ArrowDown){
            if(arrowpos == 26) arrowpos = 20;
            else arrowpos +=3;
        }
        if (key.getKeyType() == KeyType.Escape) endgame = true;
        if (key.getKeyType() == KeyType.Enter){
            if(arrowpos == 20) return 1;
            if(arrowpos == 23) return 2;
            if(arrowpos == 26) return 3;
        }
        return 0;
    }
    }

