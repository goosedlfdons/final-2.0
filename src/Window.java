import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;


public class Window extends Canvas{
    //creating constructor for window dimensions
        public Window(float width, float height, String title, Game game){
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension((int) width, (int) height));
        frame.setMaximumSize(new Dimension((int) width, (int) height));
        frame.setMinimumSize(new Dimension((int) width, (int) height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }
}
