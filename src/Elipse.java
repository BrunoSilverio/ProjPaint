import java.awt.*;
import java.util.*;

public class Elipse extends Figura
{
	protected Ponto p1, p2;
    protected Color corInterna;

    public Elipse (int x1, int y1, int x2, int y2)
    {
        this (x1, y1, x2, y2, Color.BLACK, Color.BLACK);
    }

    public Elipse (int x1, int y1, int x2, int y2, Color cor,  Color corInterna)
    {
        super(cor);

        this.p1 = new Ponto (x1,y1,cor);
        this.p2 = new Ponto (x2,y2,cor);
        this.corInterna = corInterna;
    }

    public Elipse (String s)
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
    	int raiox, raioy;
    	
    	if(Math.abs(this.p1.getX() - this.p2.getX()) < 10) raiox = 10;
    		else raiox = Math.abs(((this.p1.getX() + this.p2.getX())/2) - this.p1.getX());
    	
    	if(Math.abs(this.p1.getY() - this.p2.getY()) < 10) raioy = 10;
    		else raioy = Math.abs(((this.p1.getY() + this.p2.getY())/2) - this.p1.getY());
    	
        g.setColor(this.cor);
        g.drawOval(((this.p1.getX() + this.p2.getX())/2) - raiox,
                   ((this.p1.getY() + this.p2.getY())/2) - raioy,
                   2 * raiox, 2 * raioy);
            
        g.setColor(this.corInterna);
        g.fillOval(((this.p1.getX() + this.p2.getX())/2) - raiox,
                   ((this.p1.getY() + this.p2.getY())/2) - raioy,
                   2 * raiox, 2 * raioy);     
    }

    public String toString()
    {
        return "e:" +
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
