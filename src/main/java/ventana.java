import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
@SuppressWarnings("serial")
public class ventana extends JPanel {
    //Crea un objeto con esta ventana como referencia
    Ball ball = new Ball(this);

    //Mueve todos los elementos que hay en la ventana
    private void move(){
        ball.move();
    }

    @Override
    public void paint (Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2d);

    }


    public static void main (String[] args)throws InterruptedException{
        JFrame frame = new JFrame("Mini Tennis");
        ventana window = new ventana();
        frame.add(window);
        frame.setSize(300,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while(true) {
            window.move();
            window.repaint();
            Thread.sleep(10);
        }
    }
}
