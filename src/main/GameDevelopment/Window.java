import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class Window extends Canvas implements Serializable {

    private static final long serialVersionUID = -5641828237808928700L;

    public Window(int width, int height, String title, Game game) {
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));

        // closes and ends game on press exit
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        // sets game to start in the middle instead of default top left
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }
}
