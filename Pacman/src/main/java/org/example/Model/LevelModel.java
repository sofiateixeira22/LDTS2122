package org.example.Model;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

public class LevelModel {
    public int level = 1;
    private GhostModel ghostModel = new GhostModel();
    private WallModel wallModel = new WallModel();
    private CoinModel coinModel = new CoinModel();


    public void setupLevel() throws URISyntaxException {
        if(level == 1 && ghostModel.getGhosts().size() == 0) {
        ghostModel.addGhost(new PositionModel(13,13));
        ghostModel.addGhost(new PositionModel(14,13));
        ghostModel.addGhost(new PositionModel(13,14));
        ghostModel.addGhost(new PositionModel(14,14));}
        else for(Ghost ghos: ghostModel.getGhosts()) {
            int i = 0;
            switch(i){
                case 0: ghos.setPosition(new PositionModel(13,13));
                case 1: ghos.setPosition(new PositionModel(14,13));
                case 2: ghos.setPosition(new PositionModel(14,14));
                case 3: ghos.setPosition(new PositionModel(13,14));
            }
            ghos.setDirection(ghos.getPosition().moveLeft());
            i++;
        }
        wallModel.clearWalls();
        readLevel();
        coinModel.clearCoins();
        coinModel.addCoins(wallModel.getWalls());

    }

    private void readLevel() throws URISyntaxException {
        String name = "Level" + getLevel() + ".txt";
        System.out.println("Level " + getLevel());
        URL resource = getClass().getClassLoader().getResource(name);
        File file = new File(resource.toURI());
        int linha=0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));

            String line;
            while ((line = br.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    switch (line.charAt(i))
                    {
                        case '#' :
                            getWallModel().addWall(i, linha);
                            break;
                    }
                }
                linha +=1;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void resetlevel(){
        level=1;
    }
    public int getLevel(){
        return level;
    }
    public void nextLevel(){
        level+=1;
    }

    public WallModel getWallModel(){
        return wallModel;
    }

    public CoinModel getCoinModel(){
        return coinModel;
    }

    public GhostModel getGhostModel(){
        return ghostModel;
    }
}
