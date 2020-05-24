import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.util.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Janela extends JFrame 
{
    protected static final long serialVersionUID = 1L;

    protected JButton btnPonto       = new JButton ("Ponto"),
                      btnLinha       = new JButton ("Linha"),
                      btnCirculo     = new JButton ("Circulo"),
                      btnElipse      = new JButton ("Elipse"),
                      
                      btnQuadrado    = new JButton ("Quadrado"),
                      btnRetangulo   = new JButton ("Retangulo"),
                      btnPoligono 	 = new JButton ("Poligono"),
                      btnTexto		 = new JButton ("Texto"),
                      
                      btnCorBorda    = new JButton ("Cor Borda"),
                      btnCorInterna  = new JButton ("Cor Interna"),
                      btnFonte  	 = new JButton ("Fonte"),
                      
                      btnAbrir       = new JButton ("Abrir"),
                      btnSalvar      = new JButton ("Salvar"),
                      btnApagar      = new JButton ("Apagar"),
                      btnSair        = new JButton ("Sair");

    protected MeuJPanel pnlDesenho = new MeuJPanel ();
    
    protected JLabel statusBar1 = new JLabel ("Mensagem:"),
                     statusBar2 = new JLabel ("Coordenada:");

    protected boolean esperaPonto, 
    				  esperaInicioReta, esperaFimReta, 
    				  esperaCentroCirculo, esperaRaioCirculo, 
    				  esperaInicioElipse, esperaFimElipse, 
    				  esperaCentroQuadrado, esperaRaioQuadrado, 
    				  esperaInicioRetangulo, esperaFimRetangulo,
    				  esperaInicioPoligono, esperaFimPoligono,
    				  esperaInicioTexto,
    				  esperaApagar;

    protected Color corAtual = Color.BLACK;
    protected Color corAtualInterna = Color.WHITE;
    
    protected Font fontAtual = new Font("Arial", Font.BOLD,14);
    protected String textoString = new String("null");
    
    protected Ponto p1;
    protected Ponto p1Poligono;
    
    protected Vector<Figura> figuras = new Vector<Figura>();

    public Janela ()
    {
        super("Editor Gráfico");

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
        
        /*try
        {
            Image btnQuadradoImg = ImageIO.read(getClass().getResource("resources/quadrado.jpg"));
            btnQuadrado.setIcon(new ImageIcon(btnQuadradoImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo quadrado.png não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }
        
        try
        {
            Image btnRetanguloImg = ImageIO.read(getClass().getResource("resources/retangulo.jpg"));
            btnRetangulo.setIcon(new ImageIcon(btnRetanguloImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo retangulo.png não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }
        
        try
        {
            Image btnPoligonoImg = ImageIO.read(getClass().getResource("resources/poligono.jpg"));
            btnPoligono.setIcon(new ImageIcon(btnPoligonoImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo retangulo.png não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }*/

        try
        {
            Image btnCoresImg = ImageIO.read(getClass().getResource("resources/cores.jpg"));
            btnCorBorda.setIcon(new ImageIcon(btnCoresImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo cores.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }
        
        try
        {
            Image btnCoresImg = ImageIO.read(getClass().getResource("resources/cores.jpg"));
            btnCorInterna.setIcon(new ImageIcon(btnCoresImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo cores.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

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

        try
        {
            Image btnApagarImg = ImageIO.read(getClass().getResource("resources/apagar.jpg"));
            btnApagar.setIcon(new ImageIcon(btnApagarImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo apagar.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnSairImg = ImageIO.read(getClass().getResource("resources/sair.jpg"));
            btnSair.setIcon(new ImageIcon(btnSairImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo sair.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        btnAbrir.addActionListener (new AbrirImagem());
        btnSalvar.addActionListener (new SalvarImagem());
        
        btnPonto.addActionListener (new DesenhoDePonto());
        btnLinha.addActionListener (new DesenhoDeReta ());
        btnCirculo.addActionListener (new DesenhoDeCirculo());
        btnElipse.addActionListener(new DesenhoDeElipse());
        
        btnQuadrado.addActionListener(new DesenhoDeQuadrado());
        btnRetangulo.addActionListener(new DesenhoDeRetangulo());
        btnPoligono.addActionListener(new DesenhoDePoligono());
        btnTexto.addActionListener(new DesenhoTexto());
        
        btnCorBorda.addActionListener (new SelecaoCorBorda());
        btnCorInterna.addActionListener (new SelecaoCorInterna());
        btnFonte.addActionListener (new SelecaoFonte());
        btnApagar.addActionListener(new SelecaoApagar());
        
        btnSair.addActionListener(new FechamentoDeJanela());

        JPanel     pnlBotoes = new JPanel();
        FlowLayout flwBotoes = new FlowLayout(); 
        pnlBotoes.setLayout (flwBotoes);

        pnlBotoes.add (btnAbrir);
        pnlBotoes.add (btnSalvar);
        pnlBotoes.add (btnPonto);
        pnlBotoes.add (btnLinha);
        pnlBotoes.add (btnCirculo);
        pnlBotoes.add (btnElipse);
        pnlBotoes.add (btnQuadrado);
        pnlBotoes.add (btnRetangulo);
        pnlBotoes.add (btnPoligono);
        pnlBotoes.add (btnTexto);
        pnlBotoes.add (btnCorBorda);
        pnlBotoes.add (btnCorInterna);
        pnlBotoes.add (btnFonte);
        pnlBotoes.add (btnApagar);
        pnlBotoes.add (btnSair);

        JPanel     pnlStatus = new JPanel();
        GridLayout grdStatus = new GridLayout(1,2);
        pnlStatus.setLayout(grdStatus);

        pnlStatus.add(statusBar1);
        pnlStatus.add(statusBar2);

        Container cntForm = this.getContentPane();
        cntForm.setLayout (new BorderLayout());
        cntForm.setBackground(Color.WHITE);
        
        cntForm.add (pnlBotoes,  BorderLayout.NORTH);
        cntForm.add (pnlDesenho, BorderLayout.CENTER);
        cntForm.add (pnlStatus,  BorderLayout.SOUTH);

        this.setSize (1500,800);
        this.setVisible (true);
        this.setLocationRelativeTo (null); //?
    }

    protected class MeuJPanel extends    JPanel 
                              implements MouseListener,MouseMotionListener
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
        {  	//PONTO
            if (esperaPonto)
            {
                figuras.add (new Ponto (e.getX(), e.getY(), corAtual));
                figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                esperaPonto = true;
            }
            //RETA
            else if (esperaInicioReta){
                p1 = new Ponto (e.getX(), e.getY(), corAtual);
                esperaInicioReta = false;
                esperaFimReta = true;
                statusBar1.setText("Mensagem: clique no ponto final da reta.");    
            }
            else if (esperaFimReta){
                esperaInicioReta = true;
                esperaFimReta = false;
                figuras.add (new Linha(p1.getX(), p1.getY(), e.getX(), e.getY(), corAtual));
                figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                statusBar1.setText("Mensagem: clique no ponto inicial da reta.");    
            }
            //CIRCULO
            else if (esperaCentroCirculo){
				p1 = new Ponto (e.getX(), e.getY(), corAtual);
				esperaCentroCirculo = false;
				esperaRaioCirculo = true;
				statusBar1.setText("Mensagem: clique no limite do circulo.");    
			}
			else if (esperaRaioCirculo){
				esperaCentroCirculo = true;
				esperaRaioCirculo = false;
				figuras.add (new Circulo (p1.getX(), p1.getY(), (int)Math.round(Math.sqrt(Math.pow(p1.getX()-e.getX(),2)+Math.pow(p1.getY()-e.getY(),2))), corAtual, corAtualInterna));
				figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
				statusBar1.setText("Mensagem: clique no centro do circulo.");    
			}
            //ELIPSE
			else if (esperaInicioElipse){
				esperaInicioElipse = false;
				esperaFimElipse = true;
				p1 = new Ponto(e.getX(), e.getY(), corAtual);
				statusBar1.setText("Mensagem: clique no ponto final da elipse.");
			}
			else if (esperaFimElipse){
				esperaInicioElipse = true;
				esperaFimElipse = false;
				figuras.add(new Elipse(p1.getX(), p1.getY(), e.getX(), e.getY(), corAtual, corAtualInterna));
				figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
				statusBar1.setText("Mensagem: clique no ponto inical da elipse.");
			}
            //QUADRADO
			else if (esperaCentroQuadrado){
				p1 = new Ponto (e.getX(), e.getY(), corAtual);
				esperaCentroQuadrado = false;
				esperaRaioQuadrado = true;
				statusBar1.setText("Mensagem: clique no limite do quadrado."); 
			}
			else if (esperaRaioQuadrado){
				esperaCentroQuadrado = true;
				esperaRaioQuadrado = false;
				figuras.add(new Quadrado(p1.getX(), p1.getY(), e.getX(), e.getY(), corAtual, corAtualInterna));
				figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
				statusBar1.setText("Mensagem: clique no centro do quadrado.");
			}
            //RETANGULO
			else if (esperaInicioRetangulo){
				p1 = new Ponto (e.getX(), e.getY(), corAtual);
				esperaInicioRetangulo = false;
				esperaFimRetangulo = true;
				statusBar1.setText("Mensagem: clique no limite do retangulo."); 
			}
			else if (esperaFimRetangulo){
				esperaInicioRetangulo = true;
				esperaFimRetangulo = false;
				figuras.add(new Retangulo(p1.getX(), p1.getY(), e.getX(), e.getY(), corAtual, corAtualInterna));
				figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
				statusBar1.setText("Mensagem: clique na ponta do retangulo.");
			}
            //POLIGONO
			else if (esperaInicioPoligono){
				p1Poligono = new Ponto (e.getX(), e.getY(), corAtual);
				p1 = new Ponto (e.getX(), e.getY(), corAtual);
				esperaInicioPoligono = false;
				esperaFimPoligono = true;
				statusBar1.setText("Mensagem: clique no proximo ponto do poligono");
			}
			else if (esperaFimPoligono){
				if (
						((p1Poligono.getX() >= (e.getX()-10)) && (p1Poligono.getX() <= (e.getX()+10)))
							&&
						((p1Poligono.getY() >= (e.getY()-10)) && (p1Poligono.getY() <= (e.getY()+10)))
				){
					esperaInicioPoligono = true;
					esperaInicioReta = false;
					esperaFimReta = false;
					statusBar1.setText("Mensagem: clique na ponta da poligono.");
					figuras.add (new Poligono(p1.getX(), p1.getY(), p1Poligono.getX(), p1Poligono.getY(), corAtual));
				}else{
					esperaInicioReta = false;
					esperaFimReta = false;
					statusBar1.setText("Mensagem: desenhe os lados do poligono, para conclui-lo, clique no ponto inicial dele.");
					figuras.add (new Poligono(p1.getX(), p1.getY(), e.getX(), e.getY(), corAtual));
				}
				figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
				p1 = new Ponto (e.getX(), e.getY(), corAtual);
			}
            //TEXTO
			else if(esperaInicioTexto) {
				textoString = JOptionPane.showInputDialog("Digite o texto: ");
				figuras.add(new Texto(e.getX(), e.getY(), textoString, fontAtual, Color.BLACK));
				figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
				esperaInicioTexto = true;
				statusBar1.setText("Mensagem: Digite o texto."); 

			}
            //APAGAR
			else if(esperaApagar) {
				figuras.add(new Apagar(e.getX(), e.getY(), Color.WHITE));
				figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
				esperaApagar = true;
				statusBar1.setText("Mensagem: Clique onde deseja apagar.");
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
              esperaPonto           = true;
              esperaInicioReta      = false;
              esperaFimReta         = false;
              esperaCentroCirculo   = false;
              esperaRaioCirculo     = false;
              esperaInicioElipse    = false;
              esperaFimElipse	    = false;
              esperaCentroQuadrado  = false;
              esperaRaioQuadrado    = false;
			  esperaInicioRetangulo = false;
			  esperaFimRetangulo	= false;
			  esperaInicioPoligono	= false;
			  esperaFimPoligono		= false;
			  esperaInicioTexto	  	= false;
			  esperaApagar		  	= false;
			  
              statusBar1.setText("Mensagem: clique no local do ponto.");
          }
    }

    protected class DesenhoDeReta implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
            esperaPonto           = false;
            esperaInicioReta      = true;
            esperaFimReta         = false;
            esperaCentroCirculo   = false;
            esperaRaioCirculo     = false;
            esperaInicioElipse    = false;
            esperaFimElipse	  	  = false;
            esperaCentroQuadrado  = false;
            esperaRaioQuadrado    = false;
			esperaInicioRetangulo = false;
			esperaFimRetangulo	  = false;
			esperaInicioPoligono  = false;
			esperaFimPoligono	  = false;
			esperaInicioTexto	  = false;
			esperaApagar		  = false;
			
            statusBar1.setText("Mensagem: clique no ponto inicial da reta.");
        }
    }

	protected class DesenhoDeCirculo implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
        	esperaPonto           = false;
            esperaInicioReta      = false;
            esperaFimReta         = false;
            esperaCentroCirculo   = true;
            esperaRaioCirculo     = false;
            esperaInicioElipse    = false;
            esperaFimElipse	      = false;
            esperaCentroQuadrado  = false;
            esperaRaioQuadrado    = false;
            esperaInicioRetangulo = false;
            esperaFimRetangulo	  = false;
            esperaInicioPoligono  = false;
            esperaFimPoligono	  = false;
            esperaInicioTexto	  = false;
            esperaApagar	   	  = false;
			  
            statusBar1.setText("Mensagem: clique no centro do circulo.");
        }
    }
	
	protected class DesenhoDeElipse implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			esperaPonto           = false;
            esperaInicioReta      = false;
            esperaFimReta         = false;
            esperaCentroCirculo   = false;
            esperaRaioCirculo     = false;
            esperaInicioElipse    = true;
            esperaFimElipse	  	  = false;
            esperaCentroQuadrado  = false;
            esperaRaioQuadrado    = false;
			esperaInicioRetangulo = false;
		    esperaFimRetangulo	  = false;
		    esperaInicioPoligono  = false;
		    esperaFimPoligono	  = false;
		    esperaInicioTexto	  = false;
			esperaApagar		  = false;

          statusBar1.setText("Mensagem: clique no centro da elipse.");
		}
	}
	
	protected class DesenhoDeQuadrado implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			esperaPonto           = false;
            esperaInicioReta      = false;
            esperaFimReta         = false;
            esperaCentroCirculo   = false;
            esperaRaioCirculo     = false;
            esperaInicioElipse    = false;
            esperaFimElipse	  	  = false;
            esperaCentroQuadrado  = true;
            esperaRaioQuadrado    = false;
			esperaInicioRetangulo = false;
		    esperaFimRetangulo	  = false;
		    esperaInicioPoligono  = false;
		    esperaFimPoligono	  = false;
		    esperaInicioTexto	  = false;
			esperaApagar		  = false;
			
          statusBar1.setText("Mensagem: clique no centro do quadrado.");
		}
	}
	
	protected class DesenhoDeRetangulo implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			esperaPonto           = false;
            esperaInicioReta      = false;
            esperaFimReta         = false;
            esperaCentroCirculo   = false;
            esperaRaioCirculo     = false;
            esperaInicioElipse    = false;
            esperaFimElipse	  	  = false;
            esperaCentroQuadrado  = false;
            esperaRaioQuadrado    = false;
			esperaInicioRetangulo = true;
			esperaFimRetangulo	  = false;
			esperaInicioPoligono  = false;
			esperaFimPoligono	  = false;
			esperaInicioTexto	  = false;
			esperaApagar		  = false;
			
          statusBar1.setText("Mensagem: clique na ponta do retangulo.");
		}
	}
	
	protected class DesenhoDePoligono implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			esperaPonto           = false;
            esperaInicioReta      = false;
            esperaFimReta         = false;
            esperaCentroCirculo   = false;
            esperaRaioCirculo     = false;
            esperaInicioElipse    = false;
            esperaFimElipse	  	  = false;
            esperaCentroQuadrado  = false;
            esperaRaioQuadrado    = false;
			esperaInicioRetangulo = false;
			esperaFimRetangulo	  = false;
			esperaInicioPoligono  = true;
			esperaFimPoligono	  = false;
			esperaInicioTexto	  = false;
			esperaApagar		  = false;
			
          statusBar1.setText("Mensagem: clique na ponta da poligono.");
		}
	}
	
	protected class DesenhoTexto implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			esperaPonto           = false;
            esperaInicioReta      = false;
            esperaFimReta         = false;
            esperaCentroCirculo   = false;
            esperaRaioCirculo     = false;
            esperaInicioElipse    = false;
            esperaFimElipse	  	  = false;
            esperaCentroQuadrado  = false;
            esperaRaioQuadrado    = false;
			esperaInicioRetangulo = false;
			esperaFimRetangulo	  = false;
			esperaInicioPoligono  = false;
			esperaFimPoligono	  = false;
			esperaInicioTexto	  = true;
			esperaApagar		  = false;
			
          statusBar1.setText("Mensagem: Clique no local do texto.");
		}
	}
	
	protected class SelecaoCorBorda implements ActionListener
    {
          public void actionPerformed (ActionEvent e)    
          {
        	  corAtual = JColorChooser.showDialog(null,
        	            "JColorChooser", corAtual);
          }
    }
	
	protected class SelecaoCorInterna implements ActionListener
    {
          public void actionPerformed (ActionEvent e)    
          {
        	  corAtualInterna = JColorChooser.showDialog(null,
        	            "JColorChooser", corAtualInterna);
          }
    }
	
	protected class SelecaoFonte implements ActionListener
    {
		/*public void actionPerformed (ActionEvent e) {
			JFontChooser fontChooser = new JFontChooser();
			int result = fontChooser.showDialog(null);
			if (result == JFontChooser.OK_OPTION) {
				Font font = fontChooser.getSelectedFont(); 
				System.out.println("Selected Font : " + font); 
			}
		}*/
		public void actionPerformed (ActionEvent e)    
		{
		  corAtualInterna = JColorChooser.showDialog(null,
		            "JColorChooser", corAtualInterna);
		}
    }

	protected class SelecaoApagar implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			esperaPonto           = false;
            esperaInicioReta      = false;
            esperaFimReta         = false;
            esperaCentroCirculo   = false;
            esperaRaioCirculo     = false;
            esperaInicioElipse    = false;
            esperaFimElipse	  	  = false;
            esperaCentroQuadrado  = false;
            esperaRaioQuadrado    = false;
			esperaInicioRetangulo = false;
			esperaFimRetangulo	  = false;
			esperaInicioPoligono  = false;
			esperaFimPoligono	  = false;
			esperaInicioTexto	  = false;
			esperaApagar		  = true;
			
          statusBar1.setText("Mensagem: clique onde deseja apagar.");
		}
	}
	
	protected class SalvarImagem implements ActionListener
    {
       public void actionPerformed(ActionEvent e)
        {
    	   JFileChooser salvarArquivo = new JFileChooser();
    	   salvarArquivo.setFileFilter(new FileNameExtensionFilter("Paint Files", "paint", ".paint"));    
    	   salvarArquivo.setAcceptAllFileFilterUsed(false);   
                
           int returnVal = salvarArquivo.showSaveDialog(Janela.this);
           
           if (returnVal == JFileChooser.APPROVE_OPTION)
           {
        	   try 
        	   {
        		   String arquivo = salvarArquivo.getSelectedFile().getAbsolutePath();
                   
        		   if(!arquivo.endsWith(".paint"))
                                    arquivo+=".paint";
                    FileWriter fw = new FileWriter(arquivo);
                    
                    for(int k = 0; k<figuras.size(); k++)
                    {
                        fw.write(figuras.elementAt(k).toString());
                        fw.write("\n");
                    }
                    fw.close();
               } catch (Exception ex)
        	   {
                   ex.printStackTrace();
               }
            }     
        }
    }
	
	protected class AbrirImagem implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            JFileChooser abrirArquivo = new JFileChooser();
            FileNameExtensionFilter filtroExt = new FileNameExtensionFilter("Paint Files", "paint");
            abrirArquivo.setFileFilter(filtroExt);
            
            int returnVal = abrirArquivo.showOpenDialog(getContentPane());
            
            if(returnVal == JFileChooser.APPROVE_OPTION)
            {
            	try
            	{
            		FileReader fr = new FileReader(abrirArquivo.getSelectedFile());
            		BufferedReader br = new BufferedReader(fr);
            		String line;
            				
            		while((line = br.readLine()) != null)
            		{
            			if(line.charAt(0) == 'd')
            			{
            				figuras.add(new Ponto(line));
            				figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
            			}
            			else if(line.charAt(0) == 'l')
            			{
            				figuras.add(new Linha(line));
            				figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
            			}
            			else if(line.charAt(0) == 'c')
                        {
                        	figuras.add(new Circulo(line));
                        	figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                        }
            			else if(line.charAt(0) == 'e')
                        {
                            figuras.add(new Elipse(line));
                            figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                        }
            			else if(line.charAt(0) == 'q')
            	    	{
            	    		figuras.add(new Quadrado(line));
            	    		figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
            	    	}
            			else if(line.charAt(0) == 'r')
                	    {
                	    	figuras.add(new Retangulo(line));
                	    	figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                	    }
                		else if(line.charAt(0) == 'p')
                    	{
                    	    figuras.add(new Poligono(line));
                    	    figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                    	}
                        else if(line.charAt(0) == 't')
                        {
                            figuras.add(new Texto(line));
                            figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                        }
                        else if(line.charAt(0) == 'a')
                        {
                            figuras.add(new Apagar(line));
                            figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                        }
            		}
            	}
            	catch(Exception ex)
            	{
            		ex.printStackTrace();
            	}
            }
        }
    }
	
    protected class FechamentoDeJanela implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
}
