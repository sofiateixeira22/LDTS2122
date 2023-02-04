package org.example.Controller;

import org.example.Model.*;
import org.example.View.GameView;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;


public class PacmanController {
    private GameModel model;
    private GameView view;
    private KeyStroke key;
    private Thread pac;
    private final FinalScreenController fscontroller;
    PacmanModel pacman;

    public PacmanController( GameModel model, GameView view)
    {
        this.fscontroller = new FinalScreenController(model,view,1);
        this.model = model;
        this.view = view;
        pacman = model.getPacmanModel();
    }

    public void processKey(KeyStroke key) {
        if (key.getKeyType() == KeyType.ArrowUp) {
            pacman.setDirection(pacman.getPosition().moveUp());
            pacman.setDir(1);
        }
        if (key.getKeyType() == KeyType.ArrowDown) {
            pacman.setDirection(pacman.getPosition().moveDown());
            pacman.setDir(2);
        }
        if (key.getKeyType() == KeyType.ArrowRight) {
            pacman.setDirection(pacman.getPosition().moveRight());
            pacman.setDir(3);
        }
        if (key.getKeyType() == KeyType.ArrowLeft) {
            pacman.setDirection(pacman.getPosition().moveLeft());
            pacman.setDir(4);
        }
        if (key.getKeyType() == KeyType.Escape) System.exit(0);
    }

    private boolean canPacmanMove(PositionModel position) {
        List<Wall> walls = model.getLevelModel().getWallModel().getWalls();
        if((position.getX() >= 0 && position.getX() < model.getWidth()) && (position.getY() >= 0 && position.getY() < model.getHeight())) {
            for(Wall wall : walls )
                if(wall.getPosition().equals(position)) return false;
            return true;
        }
        return false;
    }

    private void movePacman(PositionModel position) throws URISyntaxException {
        if (model.getLevelModel().getCoinModel().coinExists(position)) {
            getCoin(position);
            pacman.incrementScore();
        }
        if (canPacmanMove(position)) {
            pacman.setPosition(position);
        }
        for (Ghost ghos : model.getLevelModel().getGhostModel().getGhosts()) {
            if (model.getPacmanModel().getPosition().equals(ghos.getPosition())) {
                model.getPacmanModel().loseLife();
                if (model.getPacmanModel().getLives() == 0) {
                    model.setEndGame();
                    stop();

                    fscontroller.start(0);
                }
            }
        }
    }


    private void getCoin(PositionModel position) throws URISyntaxException {
        model.getLevelModel().getCoinModel().removeCoin(position);
        if (model.getLevelModel().getCoinModel().getCoins().size() == 0) {
            if(model.getLevelModel().getLevel() == 3) {
                model.setEndGame();
                fscontroller.start(1);
            }
            model.getLevelModel().nextLevel();
            model.getLevelModel().setupLevel();
            pacman.setPosition(new PositionModel(1,1));
            pacman.setDirection(new PositionModel(2,1));
        }

    }
    public void stop(){
        //pac.interrupt();
        //model.setEndGame();
    }


    public void start() throws URISyntaxException {
        pacman.setDir(3);
        pacman.setDirection(pacman.getPosition().moveRight());
        pac = new Thread(new Runnable() {
            @Override
            public void run() {
                KeyStroke prevkey = new KeyStroke(KeyType.ArrowRight);
                while (!model.getEndGame()) {
                    try {
                        key = view.getScreen().pollInput();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (key == null) processKey(prevkey);
                    if (key != null) {
                        processKey(key);
                        prevkey = key;
                    }
                    try {
                        movePacman(pacman.getDirection());
                        Thread.sleep(200);
                        view.draw();
                    } catch (InterruptedException | IOException | URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        pac.start();
    }
}

