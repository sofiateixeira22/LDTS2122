package org.example.Model;

public class PacmanModel extends ElementModel{
    private int lives;
    private int score;
    private PositionModel direction;
    private int dir;

    public PacmanModel(int x, int y) {
        super(x, y);
        this.lives = 3;
        this.score = 0;
        this.direction = new PositionModel(2,1);
        this.dir = 3;
    }
    public int getLives() {
        return lives;
    }

    public void resetPacman(){
        setDir(3);
        lives = 3;
        setPosition(new PositionModel(1,1));
        setDirection(getPosition().moveRight());
    }
    public PositionModel getDirection() {return direction;}

    public void setDirection(PositionModel pos) {
        this.direction = pos;
    }

    public void setDir(int dir) {this.dir = dir;}

    public int getDir() {return dir;}

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void loseLife(){
        this.lives -= 1;
    }
    public void incrementScore(){
        this.score +=1;
    }

    public int getScore(){return score;}
}
