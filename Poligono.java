import java.awt.*;
import java.util.*;

public class Poligono extends Figura
{
	protected Ponto inicial;
	protected int[] xPontos, yPontos;
	protected int pontos;
	protected Color corPreencimento;
	protected boolean preenchido;
	private int estaPreenchido;
	
	public Poligono(int[] xPontos, int[]yPontos, int points, boolean preenchido)
	{
		this(xPontos, yPontos, points, Color.BLACK,Color.BLACK, preenchido);
	}
	
	public Poligono(int[] xPontos, int[]yPontos, int pontos, Color cor,Color cor2, boolean preenchido)
	{
		super(cor);
		this.corPreencimento=cor2;
		this.inicial = new Ponto(xPontos[0],yPontos[0]);
		this.xPontos = xPontos;
		this.yPontos = yPontos;
		this.pontos = pontos;
		this.preenchido = preenchido;
	}

	public Color getPreenchimento()
	{
		return this.corPreencimento;
	}
	public Ponto getInicial() 
	{
		return inicial;
	}

	public void setInicial(Ponto inicial) 
	{
		this.inicial = inicial;
	}

	public int[] getxPontos() 
	{
		return xPontos;
	}

	public void setxPontos(int[] xPontos) 
	{
		this.xPontos = xPontos;
	}

	public int[] getyPontos() 
	{
		return yPontos;
	}

	public void setyPontos(int[] yPontos) 
	{
		this.yPontos = yPontos;
	}

	public int getPontos() 
	{
		return pontos;
	}

	public void setPontos(int pontos) 
	{
		this.pontos = pontos;
	}

	public Poligono (String s)
	{
		StringTokenizer quebrador = new StringTokenizer(s,":");
	
		quebrador.nextToken();
		
		int   x   = Integer.parseInt(quebrador.nextToken());
        int   y   = Integer.parseInt(quebrador.nextToken());
        
        int[] xPontos = null, yPontos = null;
       
        //problemas com a conversao de string para array
        for(int i = 0; i < quebrador.nextToken().length();i++)
        {
        	try
        	{
        		xPontos[i] = Integer.parseInt(quebrador.nextToken());

        	} catch (NumberFormatException nfe) {};
        }     
        
        for(int i = 0; i < quebrador.nextToken().length();i++)
        {
        	try
        	{
        		yPontos[i] = Integer.parseInt(quebrador.nextToken());
        	} catch (NumberFormatException nfe) {};
        }

		int   point   = Integer.parseInt(quebrador.nextToken());
	
		Color cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
							   Integer.parseInt(quebrador.nextToken()),  // G
							   Integer.parseInt(quebrador.nextToken())   // B
							   ); 
		Color cor2 = new Color (Integer.parseInt(quebrador.nextToken()),  // R
				   				Integer.parseInt(quebrador.nextToken()),  // G
				   				Integer.parseInt(quebrador.nextToken())   // B
				   				);
		
		if(Integer.parseInt(quebrador.nextToken()) == 0)
        {
        	this.preenchido = false;
        }
        else
        {
        	this.preenchido = true;
        }
	

		this.inicial = new Ponto(x,y,cor);
		this.xPontos = xPontos;
		this.yPontos = yPontos;
		this.pontos = point;
		this.corPreencimento = cor2;
	}
    public void torneSeVisivel (Graphics g)
    {
    	if(!preenchido)
    	{
    		g.setColor (this.cor);
        	g.drawPolygon(xPontos, yPontos, pontos );
    	}
    	else
    	{
    		g.setColor (this.corPreencimento);
        	g.fillPolygon(xPontos, yPontos, pontos );
        	
        	g.setColor (this.cor);
        	g.drawPolygon(xPontos, yPontos, pontos );
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
		
		return "p:" +
			   this.xPontos[0] +
			   ":" + 
			   this.yPontos[0] +
			   ":" + 
			   this.pontos +
			   ":" +
		       this.getCor().getRed() +
		       ":" +
		       this.getCor().getGreen() +
		       ":" +
		       this.getCor().getBlue()+
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