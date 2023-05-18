import java.awt.*;

public class SmartEnemy extends GameObject{

    private Handler handler;
    private GameObject player;
    private GameObject tower;
    public SmartEnemy(float x, float y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
        for(int i = 0; i < handler.object.size(); i++){
            if(handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
            if(handler.object.get(i).getId() == ID.Tower) tower = handler.object.get(i);
        }

    }
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 30, 30);
    }
    public void tick(){
        x += velX;
        y += velY;

        float diffX = x - player.getX() - 8;
        float diffY = y - player.getY() - 8;
        float towerDiffX = x - tower.getX() - 8;
        float towerDiffY = y - tower.getY() - 8;
        float distance = (float) Math.sqrt((x- player.getX()) * (x- player.getX()) + (y- player.getY()) * (y- player.getY()));
        float towerDistance = (float) Math.sqrt((x- tower.getX()) * (x- tower.getX()) + (y- tower.getY()) * (y- tower.getY()));

        //If statements made so enemy will attack either the player or the tower based on each other's distance
        if (towerDistance<distance){
            velX = (float) ((-1.0/towerDistance) * towerDiffX);
            velY = (float) ((-1.0/towerDistance) * towerDiffY);
        }
        else{
            velX = (float) ((-1.0/distance) * diffX);
            velY = (float) ((-1.0/distance) * diffY);
        }

        if(y <= 0 || y >= Game.HEIGHT - 60) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 40) velX *= -1;

        //handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.gray, 30, 30, 0.1f, handler));
    }

    public void render(Graphics g){
        g.setColor(Color.black);
        g.fillRect((int)x, (int)y, 30, 30);
    }

}