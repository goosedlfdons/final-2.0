
import java.awt.*;
import java.util.Random;


public class Player extends GameObject {

    Random r = new Random();
    Handler handler;

    public Player(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;

       //velX = 1;
       //velX = r.nextInt(5) + 1;
       //velY = r.nextInt(5);
    }

  
    /*
    public static Location getLocation() {

    }
*/
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 32, 32);
    }



    public void tick() {
        x += velX;
        y += velY;
        if(y <= 0 || y >= Game.HEIGHT - 60) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 40) velX *= -1;
        handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.blue, 32, 32, 0.1f, handler));
        collision();
    }

    private void collision(){
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Enemy || tempObject.getId() == ID.AiEnemy){
                //collision stuff
                if(getBounds().intersects(tempObject.getBounds())){
                    HUD.Health -= 2;
                }
            }
        }
    }
    //Rectangle stuff
    public void render(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.BLUE);
        g.fillRect((int)x, (int)y,32, 32);

        //double degrees = 180;
        //AffineTransform old = g2d.getTransform();
        //g2d.rotate(Math.toRadians(degrees));
        g.setColor(Color.RED);
        g.fillRect((int)x, (int)y,7, 100);
        //draw shape/image (will be rotated)
       // g2d.setTransform(old);
    }
}

/*class Location {
    int lX, lY;
    public Location (int x, int y)
    {
        lX = x;
        lY = y;

    }

    public String toString(){
        String result= "X: " + lX + " Y: " + lY;
        return result;
    }

}*/



