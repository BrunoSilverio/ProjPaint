package comunicados;

import java.sql.Date;
import java.util.ArrayList;

import BD.daos.Desenhos;
import BD.dbos.Desenho;

public class PedidoDeSalvamento extends Comunicado {
    private int idDesenho, idControler = 0;
    private String dtCriacao, dtAtualizacao;
    private String ipCliente;
    private ArrayList<Desenho> figs, conteudo;
    private Desenho desenho; //Adicionei
    Desenhos ds = new Desenhos();//Adicionei
	
	public PedidoDeSalvamento (String ipCliente, String dtCriacao, String dtAtualizacao, ArrayList<Desenho> figuras)
	{
		this.ipCliente = ipCliente;
		this.dtCriacao = dtCriacao;
		this.dtAtualizacao = dtAtualizacao;
		this.idDesenho = idControler;//Ele s� pode atualizar dpois que passar todos as figuras desse desenho
		this.figs = figuras;
		conteudo = new ArrayList<Desenho>();
		idControler++;
	}
	
	public String getIpCliente ()
	{
		return this.ipCliente;
	}
	
	public int getIdDesenho ()
	{
		return this.idDesenho;
	}
	
	public ArrayList<Desenho> getDesenho ()
	{
		return this.figs;
	}
	
	public String getDtUltimaAtualizacao ()
	{
		return this.dtAtualizacao;
	}
	
	public String getDtCriacao ()
	{
		return this.dtCriacao;
	}
	
	public ArrayList<Desenho> getConteudo ()
	{
		return this.conteudo;
	}
	
	//ADICIONEI
	public void setIpCliente (String ipCliente) throws Exception
    {
        this.ipCliente = ipCliente;
    }

    public void setIdDesenho (int idDesenho) 
    {
    	this.idDesenho = idDesenho;
    }
    public void setDesenho(Desenho des) throws Exception
    {
    	this.desenho = des;
    }
    /*public Desenho getDesenho ()
    {
        return this.desenho;
    }*/
	
    //metodo para acrescentar um desenho
	//metodo adicionar desenho
}
