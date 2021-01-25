// update and render object
// for more than one object per game
// loop through eat object, update and render for the game

import java.awt.*;
import java.util.LinkedList;

public class Handler {

    LinkedList<GameObject> objects = new LinkedList<GameObject>();

    public void tick() {
        objects.forEach(GameObject::tick);
    }

    public void render(Graphics g) {
        objects.forEach(item -> item.render(g));
    }

    public void addObject(GameObject object) {
        this.objects.add(object);
    }

    public void removeObject(GameObject object) {
        this.objects.remove(object);
    }
}
