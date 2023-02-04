package view;

import org.example.View.MenuView;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;


public class testMenuView {
    @Test
    public void testDraw() {
        // A TerminalScreen Mock
        TextGraphics graphics = mock(TextGraphics.class);
        // Execute
        MenuView view = new MenuView();
        view.draw(graphics);

        // Verify
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFFF00"));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(2, 2), " _ __   __ _  ___ _ __ ___   __ _ _ __  ");
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(2, 3), "| ._ \\ / _. |/ __| ._ . _ \\ / _. | ._ \\ ");
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(2, 4), "| |_) | (_| | (__| | | | | | (_| | | | |");
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(2, 5), "| .__/ \\__._|\\___|_| |_| |_|\\__._|_| |_|");
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(2, 6), "|_|                                     ");

        Mockito.verify(graphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#000000"));
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#eb0e2b"));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(20, 12), "PLAY");
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(20, 15), "QUIT");
    }
}
