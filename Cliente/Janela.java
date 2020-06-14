package Cliente;
import Servidor.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.imageio.*;
import java.io.*;
import java.util.*;
import java.net.*;
 
public class Janela extends JFrame 
{
    protected static final long serialVersionUID = 1L;
    public static final String HOST_PADRAO  = "localhost";
	public static final int    PORTA_PADRAO = 3000;

    protected JButton btnPonto   = new JButton ("Ponto"),
                      btnLinha   = new JButton ("Linha"),
                      btnQuadrado= new JButton ("Quadrado"),
                      btnRetangulo= new JButton ("Retangulo"),
                      btnPoligono= new JButton ("Poligono"),
                      btnCirculo = new JButton ("Circulo"),
                      btnElipse  = new JButton ("Elipse"),
                      btnTexto   = new JButton ("Texto"),
                      btnCor1    = new JButton ("Cor Contorno"),
                      btnCor2    = new JButton ("Cor Preenchimento"),
                      btnAbrir   = new JButton ("Abrir"),
                      btnSalvar  = new JButton ("Salvar");

    protected MeuJPanel pnlDesenho = new MeuJPanel ();
    protected JCheckBox ckPreenchimento = new JCheckBox("Preenchimento");
    protected JLabel statusBar1 = new JLabel ("Mensagem:"),
                     statusBar2 = new JLabel ("Coordenada:");

    protected boolean esperaPonto, 
    				  esperaInicioReta, 
    				  esperaFimReta, 
    				  esperaCentroCirculo, 
    				  esperaRaioCirculo, 
    				  esperaInicioElipse, 
    				  esperaFimElipse,
    				  esperaInicioTexto,
    				  esperaFimTexto,
    				  esperaInicioQuadrado,
    				  esperaFimQuadrado,
    				  esperaInicioPoligono,
    				  esperaFimPoligono,
    				  esperaInicioRetangulo,
    				  esperaFimRetangulo;

    protected boolean preenchimento;
    protected Color corContorno = Color.BLACK;
    private Color corPreenchimento = Color.black;
    private Font fonteAtual = new Font("Arial",Font.PLAIN,10);
    protected Ponto p1;
    
    private int[] xPonto, yPonto, cpyXPonto, cpyYPonto;
    private int i=0;
       
    protected Vector<Figura> figuras = new Vector<Figura>();

    public Janela ()
    {
        super ("Editor Gráfico");
        //Colocar Icone da imagem referente a função PONTO
        try
        {
            Image btnPontoImg = ImageIO.read(getClass().getResource("resources/ponto.jpg"));
            btnPonto.setIcon(new ImageIcon(btnPontoImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo ponto.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }
        //-----------------------------------------------------------------
        
        //Colocar Icone da imagem referente a função LINHA
        try
        {
            Image btnLinhaImg = ImageIO.read(getClass().getResource("resources/linha.jpg"));
            btnLinha.setIcon(new ImageIcon(btnLinhaImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo linha.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }
        //-----------------------------------------------------------------
        
        //Colocar Icone da imagem referente a função CIRCULO
        try
        {
            Image btnCirculoImg = ImageIO.read(getClass().getResource("resources/circulo.jpg"));
            btnCirculo.setIcon(new ImageIcon(btnCirculoImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo circulo.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }
        //-----------------------------------------------------------------
        
        //Colocar Icone da imagem referente a função ELIPSE
        try
        {
            Image btnElipseImg = ImageIO.read(getClass().getResource("resources/elipse.jpg"));
            btnElipse.setIcon(new ImageIcon(btnElipseImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo elipse.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }
        //-----------------------------------------------------------------
        
        //Colocar Icone da imagem referente a função QUADRADO
        try
        {
            Image btnQuadradoImg = ImageIO.read(getClass().getResource("resources/quadrado.jpg"));
            btnQuadrado.setIcon(new ImageIcon(btnQuadradoImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo quadrado.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }
        //-----------------------------------------------------------------
        
        //Colocar Icone da imagem referente a função RETANGULO
        try
        {
            Image btnRetanguloImg = ImageIO.read(getClass().getResource("resources/retangulo.jpg"));
            btnRetangulo.setIcon(new ImageIcon(btnRetanguloImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo retangulo.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }
        //-----------------------------------------------------------------
        
        //Colocar Icone da imagem referente a função POLIGONO
        try
        {
            Image btnPoligonoImg = ImageIO.read(getClass().getResource("resources/poligono.jpg"));
            btnPoligono.setIcon(new ImageIcon(btnPoligonoImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo poligono.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }
        //-----------------------------------------------------------------
        
        //Colocar Icone da imagem referente a função TEXTO
        try
        {
            Image btnTxtImg = ImageIO.read(getClass().getResource("resources/texto.jpg"));
            btnTexto.setIcon(new ImageIcon(btnTxtImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo texto.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }
        //-----------------------------------------------------------------
        
        //Colocar Icone da imagem referente a função CORES
        try
        {
            Image btnCoresImg = ImageIO.read(getClass().getResource("resources/cores.jpg"));
            btnCor1.setIcon(new ImageIcon(btnCoresImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo cores.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }
        //-----------------------------------------------------------------
        
        //Colocar Icone da imagem referente a função CORES
        try
        {
            Image btnCoresImg = ImageIO.read(getClass().getResource("resources/cores.jpg"));
            btnCor2.setIcon(new ImageIcon(btnCoresImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo cores.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }
        //-----------------------------------------------------------------
        
        //Colocar Icone da imagem referente a função ABRIR
        try
        {
            Image btnAbrirImg = ImageIO.read(getClass().getResource("resources/abrir.jpg"));
            btnAbrir.setIcon(new ImageIcon(btnAbrirImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo abrir.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }
        //-----------------------------------------------------------------
        
        //Colocar Icone da imagem referente a função SALVAR
        try
        {
            Image btnSalvarImg = ImageIO.read(getClass().getResource("resources/salvar.jpg"));
            btnSalvar.setIcon(new ImageIcon(btnSalvarImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo salvar.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }
        //-----------------------------------------------------------------

        btnPonto  .addActionListener 	(new DesenhoDePonto());
        btnLinha  .addActionListener 	(new DesenhoDeReta());
        btnCirculo.addActionListener 	(new DesenhoDeCirculo());
        btnCor1   .addActionListener 	(new SelecionaCorPrincipal());
        btnCor2   .addActionListener 	(new SelecionacorPreenchimento());
        btnElipse .addActionListener 	(new DesenhoDeElipse());
        btnQuadrado.addActionListener	(new DesenhoDeQuadrado());
        btnRetangulo.addActionListener 	(new DesenhoDeRetangulo());
        btnTexto  .addActionListener 	(new MostraTexto());
        btnPoligono.addActionListener	(new DesenhoDePoligono());
        btnSalvar.addActionListener		(new Salvar());
        btnAbrir.addActionListener		(new Abrir());

        JPanel     pnlBotoes = new JPanel();
        FlowLayout flwBotoes = new FlowLayout(); 
        pnlBotoes.setLayout (flwBotoes);

        pnlBotoes.add (btnAbrir);
        pnlBotoes.add (btnSalvar);
        pnlBotoes.add (btnPonto);
        pnlBotoes.add (btnLinha);
        pnlBotoes.add (btnQuadrado);
        pnlBotoes.add (btnRetangulo);
        pnlBotoes.add (btnPoligono);
        pnlBotoes.add (btnCirculo);
        pnlBotoes.add (btnElipse);
        pnlBotoes.add (btnTexto);
        pnlBotoes.add (btnCor1);
        pnlBotoes.add (btnCor2);
        pnlBotoes.add (ckPreenchimento);

        JPanel     pnlStatus = new JPanel();
        GridLayout grdStatus = new GridLayout(1,2);
        pnlStatus.setLayout(grdStatus);

        pnlStatus.add(statusBar1);
        pnlStatus.add(statusBar2);

        Container cntForm = this.getContentPane();
        cntForm.setLayout (new BorderLayout());
        cntForm.add (pnlBotoes,  BorderLayout.NORTH);
        cntForm.add (pnlDesenho, BorderLayout.CENTER);
        cntForm.add (pnlStatus,  BorderLayout.SOUTH);
        
        //this.addWindowListener (new Sair());

        this.setSize (1500,1000);
        this.setVisible (true);
    }

    protected class MeuJPanel extends JPanel implements MouseListener, MouseMotionListener
    {
    	public MeuJPanel()
        {
            super();
            this.addMouseListener       (this);
            this.addMouseMotionListener (this);
        }

        public void paint (Graphics g)
        {
            for (int i=0 ; i<figuras.size(); i++)
                figuras.get(i).torneSeVisivel(g);
        }
        
        public void mousePressed (MouseEvent e)
        {
        		if (esperaPonto)
        		{
        			//Insere o Ponto
        			figuras.add (new Ponto (e.getX(), e.getY(), corContorno));
        			figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
        		}
        		else
        			if (esperaInicioReta)
        			{
	                    p1 = new Ponto (e.getX(), e.getY(), corContorno);
	                    esperaInicioReta = false;
	                    esperaFimReta = true;
	                    statusBar1.setText("Mensagem: clique o ponto final da reta");  
        			}
        			else
	                    if (esperaFimReta)
	                    {               	
	                        esperaInicioReta = true;
	                        esperaFimReta = false;
	                        figuras.add (new Linha(p1.getX(), p1.getY(), e.getX(), e.getY(), corContorno));
	                        figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
	                        statusBar1.setText("Mensagem: cique o ponto inicial da reta");   	
	                    }
	                    else
							if (esperaCentroCirculo)
							{
								//Insere a Reta
								p1 = new Ponto (e.getX(), e.getY(), corContorno);
								esperaCentroCirculo = false;
								esperaRaioCirculo = true;
								statusBar1.setText("Mensagem: clique num ponto do circulo");  
							}
							else
								//Insere o Circulo
								if (esperaRaioCirculo)
								{
									esperaCentroCirculo = true;
									esperaRaioCirculo = false;
									figuras.add (new Circulo (p1.getX(), p1.getY(), 
											(int)Math.round(Math.sqrt (Math.pow(p1.getX()-e.getX(),2)+Math.pow(p1.getY()-e.getY(),2))), 
											corContorno,
											corPreenchimento, 
											ckPreenchimento.isSelected()));
									figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
									statusBar1.setText("Mensagem: quique no centro do circulo");  
									
								}
								else
									if(esperaInicioElipse)
									{										
										p1 = new Ponto (e.getX(), e.getY(), corContorno);
										esperaFimElipse = true;
										esperaInicioElipse = false;
										statusBar1.setText("Mensagem: clique no ultimo ponto da elipse"); 										
									}
									else
										//Insere a Elipse
										if(esperaFimElipse)
										{
											figuras.add(new Elipse(p1.getX(), p1.getY(),
													Math.abs(p1.getX() - e.getX()),Math.abs(p1.getY() - e.getY()), 
													corContorno,
													corPreenchimento,
													ckPreenchimento.isSelected()));
					                        figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
					                        statusBar1.setText("Mensagem: clique no primeiro ponto da elipse"); 
											esperaInicioElipse = true;
											esperaFimElipse    = false;
										}
										else
											//Insere o Texto
											if(esperaInicioTexto)
											{
												figuras.add(new Texto(e.getX(),e.getY(),corContorno,fonteAtual));
												figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
											}
											else
												if(esperaInicioRetangulo)
												{
													p1 = new Ponto (e.getX(), e.getY(), corContorno);
								                    esperaInicioRetangulo = false;
								                    esperaFimRetangulo    =true;
								                    statusBar1.setText("Mensagem: clique o ponto final da Retangulo");
												}
												else
													//Insere o Retangulo
								                	if(esperaFimRetangulo)
								                	{
								                		int CoordenadaX, CoordenadaY, Raio1, Raio2;
								                		esperaInicioRetangulo = true;
								                		esperaFimRetangulo    = false;
								                		CoordenadaX = (int)((p1.getX() + e.getX())/2);
								                		CoordenadaY = (int)((p1.getY() + e.getY())/2);
								                		Raio1 = (int) (Math.abs(p1.getX() - e.getX())/2);
								                		Raio2 = (int) (Math.abs(p1.getY() - e.getY())/2);
								                		figuras.add(new Retangulo(CoordenadaX, 
								                								  CoordenadaY, 
								                								  Raio1, 
								                								  Raio2, 
								                								  corContorno,
								                								  corPreenchimento,
								                								  ckPreenchimento.isSelected()));
								                        figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
								                        statusBar1.setText("Mensagem:clique no pont incial do retangulo ");    	
								                	}
									                else
										            	if(esperaInicioQuadrado)
										            	{
										            		p1 = new Ponto (e.getX(), e.getY(), corContorno);
										                    esperaInicioQuadrado = false;
										                    esperaFimQuadrado    =true;
										                    statusBar1.setText("Mensagem: clique o ponto final da Quadrado");
										            	}
											            else
											            	//Insere o Quadrado
											            	if(esperaFimQuadrado)
											            	{
											            		int CoordenadaX, CoordenadaY, Raio1, Raio2;
										                		esperaInicioQuadrado = true;
										                		esperaFimQuadrado    = false;
										                		CoordenadaX = (int)((p1.getX() + e.getX())/2);
										                		CoordenadaY = (int)((p1.getY() + e.getY())/2);
										                		Raio1 = (int) (Math.abs(p1.getX() - e.getX())/2);
										                		Raio2 = (int) (Math.abs(p1.getY() - e.getY())/2);
										                		//Desenha sempre a maior dimensão
										                		if(Raio1 > Raio2)
										                			figuras.add(new Quadrado(CoordenadaX, 
										                									 CoordenadaY, 
										                									 Raio1, 
										                									 corContorno,
										                									 corPreenchimento,
										                									 ckPreenchimento.isSelected()));
										                		else
										                			figuras.add(new Quadrado(CoordenadaX, 
										                									 CoordenadaY, 
										                									 Raio2, 
										                									 corContorno,
										                									 corPreenchimento,
										                									 ckPreenchimento.isSelected()));
										                			
										                        figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
										                        statusBar1.setText("Mensagem:");
											            	}
											            	else
												            	if (esperaInicioPoligono)
												            	{
												            		i = 0;
												            		xPonto = new int[i+1];
												            		yPonto = new int[i+1];
												                    p1 = new Ponto (e.getX(), e.getY(), corContorno);
												                	figuras.add (new Ponto (e.getX(), e.getY(), corContorno));
												                    figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
												                    esperaInicioPoligono = false;
												                    esperaFimPoligono    = true;
												                    statusBar1.setText("Mensagem: clique no pontos do Poligono");
												            		xPonto[i] = e.getX();
												            		yPonto[i] = e.getY();
												            	}
												            	else
												            	{
												            		//Insere o Poligono
												                	if(esperaFimPoligono)
												                	{
												                		  if (e.getClickCount() == 2) 
												                		  {
												                      		esperaFimPoligono    = false;
												                  			figuras.add(new Poligono(xPonto, 
												                  									 yPonto ,
												                  									 xPonto.length, 
												                  									 corContorno, 
												                  									 corPreenchimento,
												                  									 ckPreenchimento.isSelected()));
												                  			figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
												                  			statusBar1.setText("Mensagem:");    
												                  			i = 0;
												                		  }
												                		  if (e.getClickCount() == 1)
												                        		i++;

												                		esperaInicioPoligono = false;
												                		
												                		if(xPonto.length <= i)
												                		{
												                			cpyXPonto = new int[i];
												                			System.arraycopy(xPonto, 0, cpyXPonto, 0, xPonto.length);
												                			cpyYPonto = new int[i];
												                			System.arraycopy(yPonto, 0, cpyYPonto, 0, yPonto.length);
												                			xPonto = new int[i + 1];
												                			yPonto = new int[i + 1];
												                			System.arraycopy(cpyXPonto, 0, xPonto, 0, cpyXPonto.length);
												                			System.arraycopy(cpyYPonto, 0, yPonto, 0, cpyYPonto.length);
												                		}
												                		
												                    	//System.out.println("Entrou no loop (" + i + "). ");
												                    	xPonto[i] = e.getX();
												                    	yPonto[i] = e.getY();
												                			
												                        statusBar1.setText("Mensagem: clique nos pontos do Poligono(" + i + ")");
												                	}
												            	}         						            		
        	}
        
        public void mouseReleased (MouseEvent e)
        {}
        
        public void mouseClicked (MouseEvent e)
        {}
        
        public void mouseEntered (MouseEvent e)
        {}

        public void mouseExited (MouseEvent e)
        {}
        
        public void mouseDragged(MouseEvent e)
        {}

        public void mouseMoved(MouseEvent e)
        {
            statusBar2.setText("Coordenada: "+e.getX()+","+e.getY());
        }
    }

    protected class DesenhoDePonto implements ActionListener
    {
          public void actionPerformed (ActionEvent e)    
          {
              esperaPonto          = true;
              esperaInicioReta     = false;
              esperaFimReta        = false;
              esperaCentroCirculo  = false;
              esperaRaioCirculo    = false;
              esperaInicioElipse   = false;
              esperaFimElipse      = false;
              esperaInicioTexto    = false;
              esperaFimTexto       = false;
              esperaInicioRetangulo= false;
              esperaFimRetangulo   = false;
              esperaInicioQuadrado = false;
              esperaFimQuadrado    = false;

              statusBar1.setText("Mensagem: clique o local do ponto desejado");
          }
    }

    protected class DesenhoDeReta implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
            esperaPonto          = false;
            esperaInicioReta     = true;
            esperaFimReta        = false;
            esperaCentroCirculo  = false;
            esperaRaioCirculo    = false;
            esperaInicioElipse   = false;
            esperaFimElipse      = false;
            esperaInicioTexto    = false;
            esperaFimTexto       = false;
            esperaInicioRetangulo= false;
            esperaFimRetangulo   = false;
            esperaInicioQuadrado = false;
            esperaFimQuadrado    = false;
            esperaInicioPoligono = false;
            esperaFimPoligono    = false;

            statusBar1.setText("Mensagem: clique o ponto inicial da reta");
        }
    }
    
    protected class DesenhoDeCirculo implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
            esperaPonto          = false;
            esperaInicioReta     = false;
            esperaFimReta        = false;
            esperaCentroCirculo  = true;
            esperaRaioCirculo    = false;
            esperaInicioElipse   = false;
            esperaFimElipse      = false;
            esperaInicioTexto    = false;
            esperaFimTexto       = false;
            esperaInicioRetangulo= false;
            esperaFimRetangulo   = false;
            esperaInicioQuadrado = false;
            esperaFimQuadrado    = false;
            esperaInicioPoligono = false;
            esperaFimPoligono    = false;

            statusBar1.setText("Mensagem: clique no centro do circulo");
        }
    }
    
    protected class DesenhoDeElipse implements ActionListener
    {
    	public void actionPerformed (ActionEvent e)    
        {
            esperaPonto          = false;
            esperaInicioReta     = false;
            esperaFimReta        = false;
            esperaCentroCirculo  = false;
            esperaRaioCirculo    = false;
            esperaInicioElipse   = true;
            esperaFimElipse      = false;
            esperaInicioTexto    = false;
            esperaFimTexto       = false;
            esperaInicioRetangulo= false;
            esperaFimRetangulo   = false;
            esperaInicioQuadrado = false;
            esperaFimQuadrado    = false;
            esperaInicioPoligono = false;
            esperaFimPoligono    = false;

            statusBar1.setText("Mensagem: clique no inicio da elipse");
        }
    	
    }
    protected class DesenhoDeRetangulo implements ActionListener
    {
    	public void actionPerformed (ActionEvent e)    
        {
            esperaPonto          = false;
            esperaInicioReta     = false;
            esperaFimReta        = false;
            esperaCentroCirculo  = false;
            esperaRaioCirculo    = false;
            esperaInicioElipse   = false;
            esperaFimElipse      = false;
            esperaInicioTexto    = false;
            esperaFimTexto       = false;
            esperaInicioRetangulo= true;
            esperaFimRetangulo   = false;
            esperaInicioQuadrado = false;
            esperaFimQuadrado    = false;
            esperaInicioPoligono = false;
            esperaFimPoligono    = false;

            statusBar1.setText("Mensagem: clique no pont incial do retangulo");
        }
    	
    }
    
    protected class MostraTexto implements ActionListener
    {
    	public void actionPerformed (ActionEvent e)    
        {
            esperaPonto          = false;
            esperaInicioReta     = false;
            esperaFimReta        = false;
            esperaCentroCirculo  = false;
            esperaRaioCirculo    = false;
            esperaInicioElipse   = false;
            esperaFimElipse      = false;
            esperaInicioTexto    = true;
            esperaFimTexto       = false;
            esperaInicioQuadrado = false;
            esperaFimQuadrado    = false;
            esperaInicioRetangulo= false;
            esperaFimRetangulo   = false;
            esperaInicioPoligono = false;
            esperaFimPoligono    = false;
        }
    	
    }
    protected class DesenhoDeQuadrado implements ActionListener
    {
     	public void actionPerformed (ActionEvent e)    
        {
            esperaPonto          = false;
            esperaInicioReta     = false;
            esperaFimReta        = false;
            esperaCentroCirculo  = false;
            esperaRaioCirculo    = false;
            esperaInicioElipse   = false;
            esperaFimElipse      = false;
            esperaInicioTexto    = false;
            esperaFimTexto       = false;
            esperaInicioQuadrado = true;
            esperaFimQuadrado    = false;
            esperaInicioRetangulo= false;
            esperaFimRetangulo   = false;
            esperaInicioPoligono = false;
            esperaFimPoligono    = false;
        }
    }
    
    protected class DesenhoDePoligono implements ActionListener
    {
          public void actionPerformed (ActionEvent e)    
          {
              esperaPonto          = false;
              esperaInicioReta     = false;
              esperaFimReta        = false;
              esperaCentroCirculo  = false;
              esperaRaioCirculo    = false;
              esperaInicioElipse   = false;
              esperaFimElipse      = false;
              esperaInicioTexto    = false;
              esperaFimTexto       = false;
              esperaInicioRetangulo= false;
              esperaFimRetangulo   = false;
              esperaInicioQuadrado = false;
              esperaFimQuadrado    = false;
              esperaInicioPoligono = true;
              esperaFimPoligono    = false;

              statusBar1.setText("Mensagem: clique no primeiro ponto do poligono");
          }
    }
    
    protected class SelecionaCorPrincipal implements ActionListener
    {

		public void actionPerformed(ActionEvent e) 
		{
			corContorno = JColorChooser.showDialog(Janela.this, "Escolher a color", corContorno);
			if( corContorno == null )
				corContorno = Color.black;
			
		}
    	
    }
    
    protected class SelecionacorPreenchimento implements ActionListener
    {

		public void actionPerformed(ActionEvent e) 
		{
			corPreenchimento = JColorChooser.showDialog(Janela.this, "Escolher a color", corPreenchimento);
			if( corPreenchimento == null )
				corPreenchimento = Color.black;
			
		}
    	
    }
    
    protected class Abrir implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		JFileChooser arquivoEscolhido = new JFileChooser();
    		FileNameExtensionFilter filtroExt = new FileNameExtensionFilter("projetoPoo", "ProjetoPoo");
    		arquivoEscolhido.setFileFilter(filtroExt);
    		int retorno = arquivoEscolhido.showOpenDialog(getContentPane());
    		if(retorno == JFileChooser.APPROVE_OPTION)
    		{
    			try
    			{
    				FileReader leitorArquivo = new FileReader(arquivoEscolhido.getSelectedFile());
    				BufferedReader leitorBuffer = new BufferedReader(leitorArquivo);
    				String line;
    				
    				while((line = leitorBuffer.readLine()) != null)
    				{
    					if(line.charAt(0) == 'd')
    					{
    						figuras.add(new Ponto(line));
    						figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
    					}
    					else
    						if(line.charAt(0) == 'l')
    						{
    							figuras.add(new Linha(line));
    							figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
    						}
    						else
    							if(line.charAt(0) == 'q')
    	    					{
    	    						figuras.add(new Quadrado(line));
    	    						figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
    	    					}
    							else
        							if(line.charAt(0) == 'r')
        	    					{
        	    						figuras.add(new Retangulo(line));
        	    						figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
        	    					}
        							else
            							if(line.charAt(0) == 'p')
            	    					{
            	    						figuras.add(new Poligono(line));
            	    						figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
            	    					}
            							else
                							if(line.charAt(0) == 'c')
                	    					{
                	    						figuras.add(new Circulo(line));
                	    						figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                	    					}
                							else
                    							if(line.charAt(0) == 'e')
                    	    					{
                    	    						figuras.add(new Elipse(line));
                    	    						figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                    	    					}
                    							else
                        							if(line.charAt(0) == 't')
                        	    					{
                        	    						figuras.add(new Texto(line));
                        	    						figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                        	    					}
    				}
    			}
    			catch(Exception err)
    			{
    				err.printStackTrace();
    			}
    		}
    	}
    }
    
    protected class Salvar implements ActionListener
    {
       public void actionPerformed(ActionEvent e)
        {
    	    Socket conexao=null;     
            try 
            {
            	String host = HOST_PADRAO;
                int    porta= PORTA_PADRAO;
            	conexao = new Socket (host, porta);
            }
            catch (Exception erro)
            {
                System.err.println ("Indique o servidor e a porta corretos!\n");
                return;
            }

            ObjectOutputStream transmissor=null;
            try
            {
                transmissor =
                new ObjectOutputStream(conexao.getOutputStream());
            }
            catch (Exception erro)
            {
                System.err.println ("Indique o servidor e a porta corretos!\n");
                return;
            }

            ObjectInputStream receptor=null;
            try
            {
                receptor =
                new ObjectInputStream(conexao.getInputStream());
            }
            catch (Exception erro)
            {
                System.err.println ("Indique o servidor e a porta corretos!\n");
                return;
            }

            Parceiro servidor=null;
            try
            {
                servidor =
                new Parceiro (conexao, receptor, transmissor);
            }
            catch (Exception erro)
            {
                System.err.println ("Indique o servidor e a porta corretos!\n");
                return;
            }

            try
            {
            	Desenho d = new Desenho(figuras);
            }
            
               
        }
    }
 
}
