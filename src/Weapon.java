import java.awt.*;


public class Weapon extends GameObject{
    Handler handler;

    public Weapon(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 7, 100);
    }

    public void tick(){

    }
    //Rectangle stuff
    public void render(Graphics g) {

       Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.RED);
        g.fillRect((int)x, (int)y,7, 100);
    }
}
