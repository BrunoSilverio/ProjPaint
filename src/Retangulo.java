import java.awt.*;
import java.util.*;

public class Retangulo extends Figura
{
    protected Ponto p1, p2;
    protected Color corInterna;

    public Retangulo (int x1, int y1, int x2, int y2)
    {
        this (x1, y1, x2, y2, Color.BLACK, Color.BLACK);
    }

    public Retangulo (int x1, int y1, int x2, int y2, Color cor, Color corInterna)
    {
        super(cor);

        this.p1 = new Ponto (x1,y1,cor);
        this.p2 = new Ponto (x2,y2,cor);
        this.corInterna = corInterna;
    }

    public Retangulo (String s)
    {
        StringTokenizer quebrador = new StringTokenizer(s,":");

        quebrador.nextToken();

        int   x1  = Integer.parseInt(quebrador.nextToken());
        int   y1  = Integer.parseInt(quebrador.nextToken());

        int   x2  = Integer.parseInt(quebrador.nextToken());
        int   y2  = Integer.parseInt(quebrador.nextToken());

        Color cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                			   Integer.parseInt(quebrador.nextToken()),  // G
                			   Integer.parseInt(quebrador.nextToken())); // B

        this.p1  = new Ponto (x1,y1,cor);
        this.p2  = new Ponto (x2,y2,cor);
        this.cor = cor;
        //this.corInterna = corInterna;
    }

    public void setP1 (int x, int y)
    {
        this.p1 = new Ponto (x,y,this.getCor());
    }

    public void setP2 (int x, int y)
    {
        this.p2 = new Ponto (x,y,this.getCor());
    }

    public Ponto getP1 ()
    {
        return this.p1;
    }

    public Ponto getP2 ()
    {
        return this.p2;
    }

    public void torneSeVisivel (Graphics g)
    {
    	g.setColor(this.cor);
        g.drawRect(((this.p1.getX() + this.p2.getX())/2) - Math.abs(((this.p1.getX() + this.p2.getX())/2) - this.p1.getX()),
                   ((this.p1.getY() + this.p2.getY())/2) - Math.abs(((this.p1.getY() + this.p2.getY())/2) - this.p1.getY()),
                   2 * Math.abs(((this.p1.getX() + this.p2.getX())/2) - this.p1.getX()),
                   2 * Math.abs(((this.p1.getY() + this.p2.getY())/2) - this.p1.getY()));
        
        g.setColor(this.corInterna);
        g.fillRect(((this.p1.getX() + this.p2.getX())/2) - Math.abs(((this.p1.getX() + this.p2.getX())/2) - this.p1.getX()),
                   ((this.p1.getY() + this.p2.getY())/2) - Math.abs(((this.p1.getY() + this.p2.getY())/2) - this.p1.getY()),
                   2 * Math.abs(((this.p1.getX() + this.p2.getX())/2) - this.p1.getX()),
                   2 * Math.abs(((this.p1.getY() + this.p2.getY())/2) - this.p1.getY()));
    }

    public String toString()
    {
        return "r:" +
                this.p1.getX() +
                ":" +
                this.p1.getY() +
                ":" +
                this.p2.getX() +
                ":" +
                this.p2.getY() +
                ":" +
                this.getCor().getRed() +
                ":" +
                this.getCor().getGreen() +
                ":" +
                this.getCor().getBlue();
    }
}