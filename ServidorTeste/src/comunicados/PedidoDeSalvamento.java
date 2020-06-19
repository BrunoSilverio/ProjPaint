package comunicados;

import java.sql.Date;
import java.util.ArrayList;

import BD.daos.Desenhos;
import BD.dbos.Desenho;

public class PedidoDeSalvamento extends Comunicado {
    private int idDesenho, idControler = 0;
    private String dtCriacao, dtAtualizacao;
    private double ipCliente;
    private ArrayList<String> figs, conteudo;
    private Desenho desenho; //Adicionei
    Desenhos ds = new Desenhos();//Adicionei
	
	public PedidoDeSalvamento (double ipCliente, String dtCriacao, String dtAtualizacao, ArrayList<String> figuras)
	{
		this.ipCliente = ipCliente;
		this.dtCriacao = dtCriacao;
		this.dtAtualizacao = dtAtualizacao;
		this.idDesenho = idControler;//Ele só pode atualizar dpois que passar todos as figuras desse desenho
		this.figs = figuras;
		conteudo = new ArrayList<String>();
		idControler++;
	}
	
	public double getIpCliente ()
	{
		return this.ipCliente;
	}
	
	public int getIdDesenho ()
	{
		return this.idDesenho;
	}
	
	public ArrayList<String> getDesenho ()
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
	
	public ArrayList<String> getConteudo ()
	{
		return this.conteudo;
	}
	
	//ADICIONEI
	public void setIpCliente (double ipCliente) throws Exception
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
