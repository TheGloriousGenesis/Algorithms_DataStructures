import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i=0; i< this.handler.objects.size(); i++) {
           GameObject temp = this.handler.objects.get(i);

            if (temp.getID() == ID.Player) {
                //key events for player two
                if (key == KeyEvent.VK_UP) {
                    temp.setVelY(-5);
                }
                if (key == KeyEvent.VK_DOWN) {
                    temp.setVelY(5);
                }
                if (key == KeyEvent.VK_RIGHT) {
                    temp.setVelX(5);
                }
                if (key == KeyEvent.VK_LEFT) {
                    temp.setVelX(-5);
                }
            }
        }

        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(1);
        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i=0; i< this.handler.objects.size(); i++) {
            GameObject temp = this.handler.objects.get(i);
            if (temp.getID() == ID.Player) {
                //key events for player two
                if (key == KeyEvent.VK_UP) {
                    temp.setVelY(0);
                }
                if (key == KeyEvent.VK_DOWN) {
                    temp.setVelY(0);
                }
                if (key == KeyEvent.VK_RIGHT) {
                    temp.setVelX(0);
                }
                if (key == KeyEvent.VK_LEFT) {
                    temp.setVelX(0);
                }
            }
        }

    }
}

