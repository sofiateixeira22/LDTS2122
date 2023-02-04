package org.example.Controller;

import org.example.Model.GameModel;
import org.example.View.GameView;
import java.net.URISyntaxException;

public class GameController {
private final PacmanController pacmanController;
private final GhostController ghostController;
private final GameView view;
private final GameModel model;


public GameController(GameModel model, GameView view)
{
    this.view = view;
    this.model = model;
    this.pacmanController = new PacmanController(model,view);
    this.ghostController= new GhostController(model,view);
    }

    public void start() throws URISyntaxException {
        pacmanController.start();
        ghostController.start();

    }


}
