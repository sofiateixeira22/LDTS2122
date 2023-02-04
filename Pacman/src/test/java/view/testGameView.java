package view;

import org.example.Model.GameModel;
import org.example.View.GameView;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testGameView {
    @Test
    public void testGetters() throws FontFormatException, IOException, URISyntaxException {
        GameModel model = new GameModel(50,20);
        GameView view = new GameView(model);
        assertEquals(null, view.getScreen().getCursorPosition());
    }

}
