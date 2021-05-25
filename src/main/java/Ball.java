import java.awt.*;

public class Ball {
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
            xa = 1;
        if (x + xa > window.getWidth() - 30)
            xa = -1;
        if (y + ya < 0)
            ya = 1;
        if (y + ya > window.getHeight() - 30)
            ya = -1;

        x = x + xa;
        y = y + ya;
    }

    public void paint(Graphics2D g){
        g.fillOval( x , y ,30 ,30 );
    }



}
