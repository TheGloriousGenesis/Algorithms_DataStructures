import java.awt.*;

public class HUD {

    public static int HEALTH = 100;

    public void tick() {
        HEALTH--;
        // clamps health, this means health cant go higher/lower than whats there
        HEALTH = Game.clamp(HEALTH, 0, 100);
    }

    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);
        g.setColor(Color.green);
        g.fillRect(15, 15, HEALTH * 2, 32);
        g.setColor(Color.white);
        /*this has to be the actual value of what health* 2 is as
        when health decreases you want the white line to be the same
        draw rect draws outline*/
        g.drawRect(15, 15, 200, 32);
    }
}
