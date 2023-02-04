package view;

import org.example.Model.Wall;
import org.example.Model.WallModel;
import org.example.View.WallView;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.mock;

public class testWallView {
    @Test
    public void testDraw() {
        WallModel wallmodel = new WallModel();
        // A TerminalScreen Mock
        TextGraphics graphics = mock(TextGraphics.class);
        // Execute
        WallView view = new WallView();
        view.draw(graphics, wallmodel);
        List<Wall> walls = wallmodel.getWalls();
        for (Wall wal : walls){
            // Verify
            Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFF8DC"));
            Mockito.verify(graphics, Mockito.times(1)).enableModifiers(SGR.BOLD);
            Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(wal.getPosition().getX(), wal.getPosition().getY()), "#");
        }
    }
}