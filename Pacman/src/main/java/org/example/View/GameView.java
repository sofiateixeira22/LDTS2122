package org.example.View;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import org.example.Model.GameModel;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;


import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class GameView {
    public TextGraphics graphics;
    private Screen screen;
    private final CoinView coinView;
    private final GhostView ghostView;
    private final PacmanView pacmanView;
    private final WallView wallView;
    private final GameModel model;

    private AWTTerminalFontConfiguration loadFont() throws FontFormatException, IOException, URISyntaxException {
        URL resource = getClass().getClassLoader().getResource("Square-Regular.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 20);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }


    public GameView(GameModel model) throws IOException, FontFormatException, URISyntaxException
    {
        this.model = model;
        this.coinView = new CoinView();
        this.ghostView = new GhostView();
        this.pacmanView = new PacmanView();
        this.wallView = new WallView();

        AWTTerminalFontConfiguration fontConfig = loadFont();
        TerminalSize ts = new TerminalSize(50,32);
        DefaultTerminalFactory factory = new DefaultTerminalFactory().setInitialTerminalSize(ts);
        factory.setTerminalEmulatorFontConfiguration(fontConfig);
        factory.setForceAWTOverSwing(true);
        factory.setTerminalEmulatorFontConfiguration(fontConfig);

        Terminal terminal = factory.createTerminal();


        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        graphics = screen.newTextGraphics();
        screen.refresh();
    }

    public Screen getScreen()
    {
        return screen;
    }

    public void draw() throws IOException
    {
        screen.clear();
        wallView.draw(graphics,model.getLevelModel().getWallModel());
        coinView.draw(graphics, model.getLevelModel().getCoinModel());
        ghostView.draw(graphics, model.getLevelModel().getGhostModel());
        pacmanView.draw(graphics, model.getPacmanModel(), model.getPacmanModel().getDir());
        wallView.draw(graphics,model.getLevelModel().getWallModel());
        drawStats(graphics, pacmanView);
        screen.refresh();
    }

    public void drawStats(TextGraphics graphics, PacmanView pacman){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF00"));
        graphics.putString(new TerminalPosition(35, 5), "LIVES: ");
        pacman.drawLives(graphics, model.getPacmanModel());
        graphics.putString(new TerminalPosition(35, 10), "SCORE:");
        graphics.putString(new TerminalPosition(35, 12), String.valueOf(model.getPacmanModel().getScore()));

        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#87CEFA"));
        graphics.putString(new TerminalPosition(35,18), "MOVE:");
        graphics.putString(new TerminalPosition(41, 18), "EXIT:");
        graphics.putString(new TerminalPosition(36,21), "{");
        graphics.putString(new TerminalPosition(37, 20), "%");
        graphics.putString(new TerminalPosition(37, 21), "}");
        graphics.putString(new TerminalPosition(38, 21), "~");
        graphics.putString(new TerminalPosition(42, 21), "v");

        graphics.putString(new TerminalPosition(43, 21), "w");
    }
}
