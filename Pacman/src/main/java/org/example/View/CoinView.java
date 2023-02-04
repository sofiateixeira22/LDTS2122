package org.example.View;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.Model.Coin;
import org.example.Model.CoinModel;


import java.util.List;

public class CoinView {
    public void draw(TextGraphics graphics, CoinModel coin_model)
    {
        List<Coin> coin_list = coin_model.getCoins();
        for (Coin coin : coin_list)
        {
            graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
            graphics.setForegroundColor(TextColor.Factory.fromString("#FFF8DC"));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(coin.getPosition().getX(), coin.getPosition().getY()), "&");
        }
    }
}