import java.awt.*;

public class Enemy extends GameObject{

    private Handler handler;
    public Enemy(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
        velX = 5;
        velY = 5;

    }
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 30, 30);
    }
    public void tick(){
        x += velX;
        y += velY;

        if(y <= 0 || y >= Game.HEIGHT - 60) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 40) velX *= -1;
        handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.gray, 30, 30, 0.1f, handler));
    }

    public void render(Graphics g){
        g.setColor(Color.red);
        g.fillRect((int)x, (int)y, 30, 30);
    }

}