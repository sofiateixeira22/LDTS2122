package org.example;

import org.example.Controller.GameController;
import org.example.Controller.MenuController;
import org.example.Model.GameModel;
import org.example.View.GameView;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Application {
    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        GameModel model = new GameModel(50,32);
        GameView view = new GameView(model);
        //GameController controller = new GameController(model,view);
        MenuController menu = new MenuController(model, view);
        menu.start();
        //controller.start();


    }


}
