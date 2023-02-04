package org.example.Model;

public class PositionModel {
    private int x;
    private int y;

    public PositionModel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public PositionModel moveUp() { return new PositionModel(getX(), getY() - 1); }
    public PositionModel moveDown() { return new PositionModel(getX(), getY() + 1); }
    public PositionModel moveRight() { return new PositionModel(getX() + 1, getY()); }
    public PositionModel moveLeft() { return new PositionModel(getX() - 1, getY()); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PositionModel)) return false;
        PositionModel position = (PositionModel) o;
        return x == position.x &&
                y == position.y;
    }


}

