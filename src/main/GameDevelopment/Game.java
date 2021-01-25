import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.Serializable;
import java.util.Random;

public class Game extends Canvas implements Runnable, Serializable {

    private static final long serialVersionUID = 190065682132863975L;

    protected static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    private Thread thread;

    private boolean running = false;

    private Random r;

    private Handler handler;

    private HUD hud;

    public Game() {
        this.handler = new Handler();

        this.addKeyListener(new KeyInput(handler));

        new Window(WIDTH, HEIGHT, "Let's Build a Game", this);

        hud = new HUD();

        r = new Random();

        this.handler.addObject(new Player(WIDTH/2-32,HEIGHT/2-32, ID.Player));
        this.handler.addObject(new BasicEnemy(WIDTH/2-32,HEIGHT/2-32, ID.BasicEnemy));
    }

    public synchronized void start() {
        //game will run on this thread
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void run() {
        // dont need to click on the screen to acess game controls
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
        hud.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // renders all objects
        handler.render(g);

        // puts this on top of player...
        hud.render(g);

        g.dispose();
        bs.show();
    }

    public static int clamp(int var, int min, int max) {
        if (var >= max) {
            return var = max;
        } else if (var <= min) {
            return var = min;
        } else {
            return var;
        }
    }

    public static void main(String[] args) {
        new Game();
    }
}
