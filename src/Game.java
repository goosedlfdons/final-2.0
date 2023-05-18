
import javax.xml.stream.Location;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{

    public static final int WIDTH = 1000, HEIGHT = WIDTH / 12 * 9;

    private Thread thread;
    private boolean running = false;

    private Random r;
    private Handler handler;
    private HUD hud;
    private HUD Thud;

    private Spawn spawner;
    public Game(){
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));

        new Window(WIDTH, HEIGHT, "EPIC GAME", this);

        hud = new HUD();
        Thud = new HUD();
        spawner = new Spawn(handler, hud);

        r = new Random();
        //Location loc = Player.getLocation();
        //Create Objects
        handler.addObject(new Player((470), (180), ID.Player, handler));
        handler.addObject(new Tower((470), (310), ID.Tower, handler));
        //handler.addObject(new Enemy((r.nextInt(1000)), (r.nextInt(750)), ID.Enemy, handler));
        handler.addObject(new SmartEnemy((r.nextInt(900)), (r.nextInt(750)), ID.AiEnemy, handler));
        handler.addObject(new SmartEnemy((r.nextInt(900)), (r.nextInt(750)), ID.AiEnemy, handler));
       // handler.addObject(new Weapon(, 100, ID.Weapon, handler));
        //handler.addObject(new Weapon(()));

        //handler.addObject(new Player(200, 200, ID.Player));
    }
    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch (Exception e){
           e.printStackTrace();
        }
    }

    public void run(){
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                //System.out.println("FPS: " + frames);
                frames = 0;
            }

        }
        stop();
    }

    //update function
    private void tick(){
        handler.tick();
        hud.tick();
        Thud.tick();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.LIGHT_GRAY);
        g. fillRect(0, 0, WIDTH,HEIGHT);

        handler.render(g);
        hud.render(g);
        Thud.renderTower(g);

        g.dispose();
        bs.show();
    }
    public static float clamp(float var, float min, float max){
        if(var >= max)
            return var = max;
        else if(var <= min)
            return var = min;
        else return var;
    }
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        new Game();
    }
}