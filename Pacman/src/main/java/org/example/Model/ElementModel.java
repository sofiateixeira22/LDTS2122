package org.example.Model;

public class ElementModel {
    private PositionModel position;

    ElementModel(int x, int y) {
        position = new PositionModel(x, y);
    }
    public ElementModel( PositionModel pos) {position = pos;}
    public PositionModel getPosition() {
        return position;
    }

    public void setPosition(PositionModel position) {
        this.position = position;
    }
}
