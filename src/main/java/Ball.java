import java.awt.*;

public class Ball {
    static final int DIAMETER = 15;
    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;
    private ventana window;

    public Ball (ventana window) {
        this.window = window;       //Recibe la ventana sobre la cual se va a mostrar
    }

    void move() {
        if (x + xa < 0)
            xa = window.speed;
        if (x + xa > window.getWidth() - DIAMETER)
            xa = -window.speed;
        if (y + ya < 0)
            ya = window.speed;
        if (y + ya > window.getHeight() - DIAMETER)
            window.gameOver();
        if (collision()) {
            ya = -window.speed ;
            y = window.racquet.getTopY() - DIAMETER;
            window.speed++;
        }
        x = x + xa;
        y = y + ya;
    }

    private boolean collision(){
        return window.racquet.getBounds().intersects(getBounds());
    }

    public Rectangle getBounds(){
        return new Rectangle(x , y , DIAMETER , DIAMETER);
    }

    public void paint(Graphics2D g){
        g.fillOval( x , y , DIAMETER ,DIAMETER );
    }



}
