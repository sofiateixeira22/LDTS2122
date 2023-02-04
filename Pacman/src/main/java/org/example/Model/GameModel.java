package org.example.Model;

import java.net.URISyntaxException;

public class GameModel {
    private int width;
    private int height;
    public PacmanModel pacmanModel = new PacmanModel(1,1);
    public boolean endgame = false;
    private LevelModel levelModel = new LevelModel();


    public GameModel(int width, int height) throws URISyntaxException {
        levelModel.setupLevel();
        this.width = width;
        this.height = height;
    }

    public void newPac(){
        pacmanModel.setPosition(new PositionModel(50,50));
        pacmanModel = new PacmanModel(1,1);
    }
    public PacmanModel getPacmanModel() {
        return pacmanModel;
    }

    public LevelModel getLevelModel(){
        return levelModel;
    }
    public boolean getEndGame(){
        return endgame;
    }
    public void setEndGame(){
        endgame = true;
    }

    public void setNewGame() {
        endgame = false;
        pacmanModel.setPosition(new PositionModel(1,1));
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

}
