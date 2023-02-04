package org.example.Controller;

import org.example.Model.*;
import org.example.View.GameView;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GhostController {
    private GameModel model;
    private GameView view;
    private Thread ghos;
    private final FinalScreenController fscontroller;

    public GhostController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
        this.fscontroller = new FinalScreenController(model,view,0);
    }

    public void move() {
        GhostModel ghost = model.getLevelModel().getGhostModel();
        List<Ghost> ghosts = ghost.getGhosts();
        for (Ghost ghos : ghosts) {
            if(!canGhostMove(ghos.getDirection()) | possibleMoves(ghos).size() > 3) chooseDirection(ghos);
            PositionModel pos = ghos.getPosition();
            PositionModel dir = ghos.getDirection();
            ghos.setPosition(dir);
            if(ghos.getPosition().equals(pos.moveUp())) ghos.setDirection(dir.moveUp());
            if(ghos.getPosition().equals(pos.moveDown())) ghos.setDirection(dir.moveDown());
            if(ghos.getPosition().equals(pos.moveLeft())) ghos.setDirection(dir.moveLeft());
            if(ghos.getPosition().equals(pos.moveRight())) ghos.setDirection(dir.moveRight());
            if (model.getPacmanModel().getPosition().equals(ghos.getPosition())) {
                model.getPacmanModel().loseLife();
            if(model.getPacmanModel().getLives() == 0) {
                model.setEndGame();
                stop();
                fscontroller.start(0);
            }
            }
        }
    }
    private boolean canGhostMove(PositionModel position) {
        List<Wall> walls = model.getLevelModel().getWallModel().getWalls();
        if((position.getX() >= 0 && position.getX() < model.getWidth()) && (position.getY() >= 0 && position.getY() < model.getHeight())) {
            for(Wall wall : walls )
                if(wall.getPosition().equals(position)) return false;
            return true;
        }
        return false;
    }
    private List<PositionModel> possibleMoves(Ghost ghost){
        List<PositionModel> possiblemoves = new ArrayList();
        PositionModel pos = ghost.getPosition();
        if(canGhostMove(pos.moveUp()))possiblemoves.add(pos.moveUp());
        if(canGhostMove(pos.moveDown()))possiblemoves.add(pos.moveDown());
        if(canGhostMove(pos.moveLeft()))possiblemoves.add(pos.moveLeft());
        if(canGhostMove(pos.moveRight()))possiblemoves.add(pos.moveRight());
        return possiblemoves;
    }

    private void chooseDirection(Ghost ghost) {
        List<PositionModel> possiblemoves = possibleMoves(ghost);
        PositionModel pos = ghost.getPosition();
        if(canGhostMove(pos.moveUp()))possiblemoves.add(pos.moveUp());
        if(canGhostMove(pos.moveDown()))possiblemoves.add(pos.moveDown());
        if(canGhostMove(pos.moveLeft()))possiblemoves.add(pos.moveLeft());
        if(canGhostMove(pos.moveRight()))possiblemoves.add(pos.moveRight());
        Random rand = new Random();
        PositionModel newpos = possiblemoves.get(rand.nextInt(possiblemoves.size()));
        ghost.setDirection(newpos);
    }

    public void stop(){
        //ghos.interrupt();
        model.setEndGame();
    }

    public void start() throws URISyntaxException {
        ghos = new Thread(new Runnable() {
            @Override
            public void run() {
                for (Ghost ghost : model.getLevelModel().getGhostModel().getGhosts()) {
                    chooseDirection(ghost);
                }
                while (!model.getEndGame()) {
                    try {
                        Thread.sleep(200);
                        move();
                        view.draw();
                    } catch (InterruptedException | IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        ghos.start();
    }
}
