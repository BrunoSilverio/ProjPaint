import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.StringTokenizer;

public class Texto extends Figura
{
    protected int 	 x,  y;
    protected String textoDigitado;
    protected Font   fontStyle;

    public Texto (int x, int y, String texto, Font fontStyle)
    {
        this (x, y, texto, fontStyle, Color.BLACK);
    }

    public Texto (int x, int y, String texto, Font fontStyle, Color cor)
    {
        super (cor);

        this.x = x;
        this.y = y;
        this.textoDigitado = texto;
        this.fontStyle = fontStyle;
        this.cor = cor;
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
        g.setFont(this.fontStyle);
        g.setColor (this.cor);
        g.drawString (this.textoDigitado ,this.x, this.y);
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
                this.getCor().getBlue();
    }
}