package view;

import org.example.Model.PacmanModel;
import org.example.View.PacmanView;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;

public class testPacmanView {

    @Test
    public void testDraw() {
        PacmanModel pacman = new PacmanModel(5,5);

        // A TerminalScreen Mock
        TextGraphics graphics = mock(TextGraphics.class);
        // Execute
        PacmanView view = new PacmanView();
        view.draw(graphics, pacman, 3);

        // Verify
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFFF00"));
        Mockito.verify(graphics, Mockito.times(1)).enableModifiers(SGR.BOLD);
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(5,5),"@");
    }
}