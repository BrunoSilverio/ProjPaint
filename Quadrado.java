import java.awt.*;
import java.util.*;

public class Quadrado extends Figura
{
    protected Ponto centro;
    protected int   raio;
    protected Color corPreencimento;
    protected boolean preenchido;
    private int estaPreenchido;
	
    public Quadrado (int x, int y, int r, boolean preenchido)
    {
        this (x, y, r, Color.BLACK, Color.BLACK, preenchido);
    }
	
    public Quadrado (int x, int y, int r, Color corContorno, Color corPreencimento, boolean preenchido)
    {
        super (corContorno);
        this.corPreencimento=corPreencimento;
        this.centro = new Ponto (x,y);
        this.raio   = r;
        this.preenchido = preenchido;
    }

    public Quadrado (String s)
    {
        StringTokenizer quebrador = new StringTokenizer(s,":");

        quebrador.nextToken();

        int   x   = Integer.parseInt(quebrador.nextToken());
        int   y   = Integer.parseInt(quebrador.nextToken());

        int   r   = Integer.parseInt(quebrador.nextToken());

        Color cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                               Integer.parseInt(quebrador.nextToken()),  // G
                               Integer.parseInt(quebrador.nextToken())); // B
        
        Color cor2 = new Color (Integer.parseInt(quebrador.nextToken()),  // R
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

        this.centro = new Ponto (x,y,cor);
        this.raio   = r;
        this.cor    = cor;
        this.corPreencimento   = cor2;
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

    public int setRaio ()
    {
        return this.raio;
    }
    
    public Color getPreenchimento()
    {
    	return this.corPreencimento;
    }

    public void torneSeVisivel (Graphics g)
    {
    	if(!preenchido)
    	{
    		g.setColor (this.cor);
            g.drawRect (this.centro.getX()-raio, this.centro.getY()-raio, 2*raio, 2*raio);
    	}
    	else
    	{
    		g.setColor (this.corPreencimento);
            g.fillRect (this.centro.getX()-raio, this.centro.getY()-raio, 2*raio, 2*raio);	
            
            g.setColor (this.cor);
            g.drawRect (this.centro.getX()-raio, this.centro.getY()-raio, 2*raio, 2*raio);
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
    	
        return "q:" +
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