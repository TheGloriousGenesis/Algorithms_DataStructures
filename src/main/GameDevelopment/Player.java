import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    Random r = new Random();


    public Player(int x, int y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH - 45);
        y = Game.clamp(y, 0, Game.HEIGHT - 67);
    }

    @Override
    public void render(Graphics g) {
        if (id == ID.Player) {
            g.setColor(Color.green);
        }
        g.fillRect(x,y, 32, 32);
    }



}
