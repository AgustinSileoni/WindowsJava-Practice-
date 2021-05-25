import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class ventana extends JPanel {

    //Crea un objeto con esta ventana como referencia
    Ball ball = new Ball(this);
    Racquet racquet = new Racquet(this);
    int speed=1;

    private int getScore(){
        return speed - 1;
    }

    public ventana() {
        //Clase Anonima para leer los eventos (Se hace esto porque solo se utiliza una vez)
        KeyListener listener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                racquet.keyPressed(keyEvent);
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                racquet.keyReleased();
            }
        };

        addKeyListener(listener);
        setFocusable(true);         //Permite recibir las notificaciones del teclado
    }


    //Mueve todos los elementos que hay en la ventana
    private void move(){
        ball.move();
        racquet.move();
    }

    @Override
    public void paint (Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2d);
        racquet.paint(g2d);

        g2d.setColor(Color.gray);
        g2d.setFont(new Font("Verdana", Font.BOLD,30));
        g2d.drawString(String.valueOf(getScore()),10,30);

    }


    public void gameOver(){
        JOptionPane.showMessageDialog(this ,
                "Your score is: " + getScore() ,
                "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
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

