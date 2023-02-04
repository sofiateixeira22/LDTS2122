package org.example.Model;

import java.util.ArrayList;
import java.util.List;

public class CoinModel {
    private List<Coin> coins;
    public CoinModel() {
        coins = new ArrayList<>();
    }


    public List<Coin> getCoins() {
        return coins;
    }

    public void addCoins(List<Wall> wallz) {
        coins = createCoins(wallz);
    }
    
    public void addCoin(PositionModel position )
   {coins.add(new Coin(position.getX(), position.getY()));}
    
    
    public void removeCoin(PositionModel position){
        List<Coin> newlist = new ArrayList();
        for (Coin coin : coins) {
            if(coin.getPosition().equals(position)) continue;
            newlist.add(coin);
        }
        coins = newlist;
    }
    public boolean coinExists(PositionModel position){
        List<PositionModel> positions = new ArrayList();
        for (Coin coin : coins) {
            positions.add(coin.getPosition());
        }
        if(positions.contains(new PositionModel(position.getX(), position.getY()))) return true;
        return false;
    }
    public void clearCoins(){
        coins.clear();
    }

    public List<Coin> createCoins(List<Wall> walls) {
        List<Coin> list = new ArrayList<>();
        List<PositionModel> positions = new ArrayList();
        for (Wall wall : walls) {
            positions.add(wall.getPosition());
        }
        for (int x = 0; x < 27; x++) {
            for(int y = 0; y < 30; y++){
                if(positions.contains(new PositionModel(x,y))) continue;
                else list.add(new Coin(x,y));
            }
        }

        return list;
    }
}
