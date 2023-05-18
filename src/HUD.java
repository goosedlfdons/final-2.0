import java.awt.Color;
import java.awt.Graphics;
public class HUD {
public static float Health = 100;
public static float TowerHealth = 200;
private int enemiesSlain = 0;

public void tick(){
//Health--;
//TowerHealth --;
Health = Game.clamp(Health, 0, 100);
TowerHealth = Game.clamp(TowerHealth, 0, 500);

}
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(15, 15,200, 32);
        g.setColor(Color.green);
        g.fillRect(15, 15, (int) (Health * 2), 32);
        g.setColor(Color.BLACK);
        g.drawRect(15, 15,200, 32);

        g.drawString("Enemies Slain: " + enemiesSlain, 15, 170);
        g.drawString("Sir Lancelot: " + Health, 15, 60);

    }

    public void renderTower(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(15, 80, 200, 32);
        g.setColor(Color.darkGray);
        g.fillRect(15, 80, (int) TowerHealth, 32);
        g.setColor(Color.black);
        g.drawRect(15, 80, 200, 32);

        g.drawString("Tower: " + TowerHealth, 15, 130);
    }

}
