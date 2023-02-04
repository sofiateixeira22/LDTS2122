package view;

import org.example.Model.GhostModel;
import org.example.Model.PositionModel;
import org.example.View.GhostView;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;


public class testGhostView {
    @Test
    public void testDraw() {
        GhostModel ghostmodel = new GhostModel();
        ghostmodel.addGhost(new PositionModel(5,5));
        // A TerminalScreen Mock
        TextGraphics graphics = mock(TextGraphics.class);
        // Execute
        GhostView view = new GhostView();
        view.draw(graphics, ghostmodel);

        // Verify
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#eb0e2b"));
        Mockito.verify(graphics, Mockito.times(1)).enableModifiers(SGR.BOLD);
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(5,5),"$");
    }
}
