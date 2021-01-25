// players, coins, enemies all game object

import java.awt.*;

public abstract class GameObject {

    protected int x, y;

    // how does game know if object player or enemy etc? by id
    protected ID id;

    protected int velX, velY;

    public GameObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

//    public abstract Rectangle getBounds();

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public int getX(int x) {
        return this.x;
    }

    public void setID(ID id) {
        this.id = id;
    }

    public ID getID() {
        return this.id;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public int getVelX() {
        return this.velX;
    }

    public int getVelY() {
        return this.velY;
    }
}
