import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler){
        this.handler = handler;
    }

    //all key down events for player
    public void keyPressed(KeyEvent e){
        float key = e.getKeyCode();

        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);


            if(tempObject.getId() == ID.Player){


                if(key == KeyEvent.VK_W) tempObject.setVelY(-10);
                if(key == KeyEvent.VK_A) tempObject.setVelX(-10);
                if(key == KeyEvent.VK_S) tempObject.setVelY(10);
                if(key == KeyEvent.VK_D) tempObject.setVelX(10);
                }
            if(tempObject.getId() == ID.Weapon){
                //weapon swing

               if(key == KeyEvent.VK_SPACE) {

               }
            }
            }
            //System.out.println("got it");
            System.out.println(key);
        }

        //key release statements
        public void keyReleased(KeyEvent e){
            float key = e.getKeyCode();

            for(int i=0; i< handler.object.size();i++){
                GameObject tempObject = handler.object.get(i);

                if(tempObject.getId() == ID.Player){
                    if(key == KeyEvent.VK_W) tempObject.setVelY(0);
                    if(key == KeyEvent.VK_A) tempObject.setVelX(0);
                    if(key == KeyEvent.VK_S) tempObject.setVelY(0);
                    if(key == KeyEvent.VK_D) tempObject.setVelX(0);

                }
            }
        }
}
