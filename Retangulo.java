
import java.awt.*;
import java.util.*;

public class Retangulo extends Figura{
	
	protected Ponto centro;

	    protected int raio1, raio2;
	    protected Color corPreencimento;
	    protected boolean preenchido;
	    private int estaPreenchido;
		
	    public Retangulo (int x, int y, int r1, int r2, boolean preenchido)
	    {
	        this (x, y, r1, r2, Color.BLACK, Color.BLACK, preenchido);
	    }
		
	    public Retangulo (int x, int y, int r1, int r2, Color corContorno, Color corPreencimento, boolean preenchido)
	    {
	        super (corContorno);
	        
	        this.centro = new Ponto (x,y);
	        this.corPreencimento=corPreencimento;

	        this.raio1  = r1;
	        this.raio2  = r2;
	        this.preenchido = preenchido;
	    }

	    public Retangulo (String s)
	    {
	        StringTokenizer quebrador = new StringTokenizer(s,":");

	        quebrador.nextToken();

	        int   x   = Integer.parseInt(quebrador.nextToken());
	        int   y   = Integer.parseInt(quebrador.nextToken());

	        int   r1  = Integer.parseInt(quebrador.nextToken());
	        int   r2  = Integer.parseInt(quebrador.nextToken());

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
	        this.raio1  = r1;
	        this.raio2  = r2;
	        this.cor    = cor;
	        this.corPreencimento    = cor2;
	    }

	    public void setCentro (int x, int y)
	    {
	        this.centro = new Ponto (x,y,this.getCor());
	    }

	    public void setRaio1 (int r1)
	    {
	        this.raio1 = r1;
	    }

	    public void setRaio2 (int r2)
	    {
	        this.raio2 = r2;
	    }

	    public Ponto getCentro ()
	    {
	        return this.centro;
	    }

	    public int setRaio1 ()
	    {
	        return this.raio1;
	    }

	    public int setRaio2 ()
	    {
	        return this.raio2;
	    }
	    public Color getPreenchimento()
	    {
	    	return corPreencimento;
	    }

	    public void torneSeVisivel (Graphics g)
	    {
	    	if(!preenchido)
	    	{
	    		g.setColor (this.cor);
		        g.drawRect (this.centro.getX()-raio1, this.centro.getY()-raio2, 2*raio1, 2*raio2);
	    	}
	    	else
	    	{
	    		g.setColor (this.corPreencimento);
		        g.fillRect (this.centro.getX()-raio1, this.centro.getY()-raio2, 2*raio1, 2*raio2);
		        
		        g.setColor (this.cor);
		        g.drawRect (this.centro.getX()-raio1, this.centro.getY()-raio2, 2*raio1, 2*raio2);
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
	    	
	        return "r:" +
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
	               this.getPreenchimento().getRed() +
	               ":" +
	               this.getPreenchimento().getGreen() +
	               ":" +
	               this.getPreenchimento().getBlue() +
	               ":" +
	               this.estaPreenchido;
	}

	}