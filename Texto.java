import java.awt.*;
import java.util.*;

import javax.swing.JOptionPane;
 
public class Texto extends Figura
{
    protected int x,  y;
    protected String texto;
    protected Font fonte;
	  
    public Texto (int x, int y, Color cor, Font fonte)
    {
        super (cor);
        
        this.fonte = fonte;

        this.x = x;
        this.y = y;
        this.texto = JOptionPane.showInputDialog("Texto");
    }

    public Texto (String s)
    {
        StringTokenizer quebrador = new StringTokenizer(s,":");

        quebrador.nextToken();

        this.x = Integer.parseInt(quebrador.nextToken());
        this.y = Integer.parseInt(quebrador.nextToken());

        this.cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                              Integer.parseInt(quebrador.nextToken()),  // G
                              Integer.parseInt(quebrador.nextToken())); // B
        
        this.texto = quebrador.nextToken();
    }

    public void setX (int x) 
    {
    	
        this.x = x;
    }
	  
    public void setY (int y) 
    {
    	
        this.y = y;
    }
	  
    public int getX ()
    {
        return this.x;
    }
	  
    public int getY ()
    {
    	return this.y;
    }
	  
    public void torneSeVisivel (Graphics g)
    {
    	if(texto!=null)
    	{
	    	g.setColor   (this.cor);
	    	g.setFont    (this.fonte);
	    	g.drawString (""+this.texto+"",this.x,this.y);
    	}
    }

    public String toString()
    {
        return "t:" +
               this.x +
               ":" +
               this.y +
               ":" +
               this.getCor().getRed() +
               ":" +
               this.getCor().getGreen() +
               ":" +
               this.getCor().getBlue() +
               ":" +
               this.texto;
    }
}