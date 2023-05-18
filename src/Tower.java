import java.awt.*;

public class Tower extends GameObject{
    Handler handler;

    public Tower(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
    }
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 50, 50);
    }
    public void tick() {
        x += velX;
        y += velY;
        collision();
    }
    private void collision(){
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.AiEnemy){
                //collision stuff
                if(getBounds().intersects(tempObject.getBounds())){
                    HUD.TowerHealth -= 1;
                }
            }
        }
    }
    //Rectangle stuff
    public void render(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect((int)x, (int)y,50, 50);
        g.setColor(Color.gray);
        g.fillRect((int)x,(int)y, 25,25);
    }
}
