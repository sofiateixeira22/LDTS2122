package org.example.Model;

import java.util.ArrayList;
import java.util.List;

public class WallModel {
    private List<Wall> walls;

    public WallModel() {
        walls = new ArrayList<>();
    }

    public List<Wall> getWalls() {
        return walls;
    }
    public void clearWalls(){
        walls.clear();
    }
    public void addWall(int x, int y)
    {
        walls.add(new Wall(x,y));
    }

}
