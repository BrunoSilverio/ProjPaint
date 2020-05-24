import java.awt.*;
import java.util.*;

public class Apagar extends Figura
{
	protected Ponto p1, p2;
    protected Color corInterna;

    public Apagar (int x1, int y1)
    {
        this (x1, y1, Color.WHITE);
    }

    public Apagar (int x1, int y1, Color corInterna )
    {
        this.p1 = new Ponto (x1,y1);
        this.corInterna = corInterna;
    }

    public Apagar (String s)
    {
        StringTokenizer quebrador = new StringTokenizer(s,":");

        quebrador.nextToken();

        int   x1  = Integer.parseInt(quebrador.nextToken());
        int   y1  = Integer.parseInt(quebrador.nextToken());

        this.p1  = new Ponto (x1,y1,cor);
        //this.corInterna = corInterna;
    }

    public void setP1 (int x, int y)
    {
        this.p1 = new Ponto (x,y);
    }

    public Ponto getP1 ()
    {
        return this.p1;
    }

    public void torneSeVisivel (Graphics g)
    {
        g.setColor(this.corInterna);
        g.fillRect((this.p1.getX()-5),(this.p1.getY()-5),10,10);
    }

    public String toString()
    {
    	return "a:" +
                this.p1.getX() +
                ":" +
                this.p1.getY() +
                ":" +
                this.getCor().getRed() +
                ":" +
                this.getCor().getGreen() +
                ":" +
                this.getCor().getBlue();
    }
}