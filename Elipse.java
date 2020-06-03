import java.awt.*;
import java.util.*;
 
public class Elipse extends Figura
{
    protected Ponto centro;
    protected int raio1, raio2;
    protected Color corPreenchimento;
    protected boolean preenchido;
    private int estaPreenchido;
    
    public Elipse (int x, int y, int largura, int altura, boolean preenchido) 
    {
        this (x, y, largura, altura, Color.BLACK,Color.BLACK, preenchido);
    }
	
    public Elipse (int x, int y, int raio1,int raio2, Color corContorno,Color cordoPreenchimento, boolean preenchido) 
    {
        super (corContorno);
        
        corPreenchimento=cordoPreenchimento;
       
		this.centro  = new Ponto (x,y,cor);
		
        this.raio1 = raio1;
        this.raio2  = raio2;
        this.preenchido = preenchido;
    }

    public Elipse (String e) 
    {
        StringTokenizer quebrador = new StringTokenizer(e,":");

        quebrador.nextToken();

        int   x  = Integer.parseInt(quebrador.nextToken());
        int   y  = Integer.parseInt(quebrador.nextToken());

        int   raio1 = Integer.parseInt(quebrador.nextToken());
        int   raio2 = Integer.parseInt(quebrador.nextToken());

        Color cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                               Integer.parseInt(quebrador.nextToken()),  // G
                               Integer.parseInt(quebrador.nextToken())); // B
        
        if(Integer.parseInt(quebrador.nextToken()) == 0)
        {
        	this.preenchido = false;
        }
        else
        {
        	this.preenchido = true;
        }

        this.centro  = new Ponto (x,y,cor);
        this.raio1 = raio1;
        this.raio2  = raio2;
        this.cor     = cor;
    }

    public void setCentro (int x, int y) 
    {
        this.centro = new Ponto (x,y,this.getCor());
    }

    public void setEaio1 (int l)
    {
        this.raio1 = l;
    }
    
    public void setRaio2(int a)
    {
    	this.raio2 = a;
    }

    public Ponto getCentro ()
    {
        return this.centro;
    }

    public int getRaio1 ()
    {
        return this.raio1;
    }
    
    public int getRaio2()
    {
    	return this.raio2;
    }

    public void torneSeVisivel (Graphics g)
    {
    	if(!preenchido)
    	{
    		g.setColor (this.cor);
            g.drawOval (this.centro.getX()-raio1, this.centro.getY()-raio2, 2*raio1, 2*raio2);
    	}
    	else
    	{
    		g.setColor (this.cor);
            g.drawOval (this.centro.getX()-raio1, this.centro.getY()-raio2, 2*raio1, 2*raio2);
    		
    		g.setColor (this.corPreenchimento);
            g.fillOval (this.centro.getX()-raio1, this.centro.getY()-raio2, 2*raio1, 2*raio2);
    	}
        
    }

    public String toString()
    {

    	if(this.preenchido == true)
    	{
    		estaPreenchido = 1;
    	}
    	else
    	{
    		estaPreenchido = 0;
    	}
    	
        return "e:" +
               this.centro.getX() +
               ":" +
               this.centro.getY() +
               ":" +
               this.raio1 +
               ":" +
               this.raio2 +
               ":" +
               this.getCor().getRed() +
               ":" +
               this.getCor().getGreen() +
               ":" +
               this.getCor().getBlue() +
               ":" +
               this.estaPreenchido;
    }
}
