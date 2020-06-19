package Cliente;
import java.awt.*;
import java.util.*;
 
public class Circulo extends Figura
{
    protected Ponto centro;
    protected int   raio;
    protected Color cor;
    protected Color corPreenchimento; 
    protected boolean preenchido;
    private int estaPreenchido;
    
    public Circulo (int x, int y, int r, boolean preenchido) 
    {
        this (x, y, r, Color.BLACK, Color.BLACK, preenchido);
    }
	
    public Circulo (int x, int y, int r, Color corContorno, Color cordoPreenchimento, boolean preenchido) 
    {
        super (corContorno);
        this.corPreenchimento = cordoPreenchimento;

        this.centro = new Ponto (x,y,cor);
        this.raio   = r;
        this.preenchido = preenchido;
    }

    public Circulo (String s)
    {
        StringTokenizer quebrador = new StringTokenizer(s,":");

        quebrador.nextToken();

        int   x  = Integer.parseInt(quebrador.nextToken());
        int   y  = Integer.parseInt(quebrador.nextToken());

        int   raio = Integer.parseInt(quebrador.nextToken());

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

        this.raio    = raio;
        this.cor     = cor;
    }

    public void setCentro (int x, int y) 
    {
        this.centro = new Ponto (x,y,this.getCor());
    }

    public void setRaio (int r)
    {
        this.raio = r;
    }

    public Ponto getCentro ()
    {
        return this.centro;
    }

    public int getRaio ()
    {
        return this.raio;
    }
    
    public Color getPreenchimento()
    {
    	return this.corPreenchimento;
    }

    public void torneSeVisivel (Graphics g)
    {
    	if(!preenchido)
    	{
    		g.setColor(this.cor);
            g.drawOval(this.centro.getX()-this.raio, 
            		   this.centro.getY()-this.raio,   // canto superior esquerdo de um quadrado imaginario que tangencia o circulo por fora
                       2*this.raio, 
                       2*this.raio);  // largura e altura do circulo
    	}
    	else
    	{
    		g.setColor(this.cor);
    		g.drawOval(this.centro.getX()-this.raio, 
    				this.centro.getY()-this.raio,   // canto superior esquerdo de um quadrado imaginario que tangencia o circulo por fora
                    2*this.raio, 
                    2*this.raio);  // largura e altura do circulo
    		
    		g.setColor(this.corPreenchimento);
        	g.fillOval(this.centro.getX()-this.raio, 
        			   this.centro.getY()-this.raio,   // canto superior esquerdo de um quadrado imaginario que tangencia o circulo por fora
                       2*this.raio, 
                       2*this.raio);// largura e altura do circulo
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
    	
        return "c:" +
               this.centro.getX() +
               ":" +
               this.centro.getY() +
               ":" +
               this.raio +
               ":" +
               this.getCor().getRed() +
               ":" +
               this.getCor().getGreen() +
               ":" +
               this.getCor().getBlue() +
               ":" +
		       this.getPreenchimento().getRed() +
		       ":" +
		       this.getPreenchimento().getGreen() +
		       ":" +
		       this.getPreenchimento().getBlue() +
		       ":" +
               this.estaPreenchido;

    }
}
