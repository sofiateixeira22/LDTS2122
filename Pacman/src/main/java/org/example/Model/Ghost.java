package org.example.Model;

public class Ghost extends ElementModel{

    PositionModel direction;
    public Ghost(PositionModel position) {
        super(position);
    }
    public PositionModel getDirection() {
        return direction;
    }
    public void setDirection(PositionModel direction) {
        this.direction = direction;
    }
}
