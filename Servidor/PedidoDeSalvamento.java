package Servidor;

import java.sql.Date;
import java.util.ArrayList;

import BD.daos.Desenhos;
import BD.dbos.Desenho;

public class PedidoDeSalvamento extends Comunicado {
	// vetor com os desenhos
    // nome do desenho
	
	private double idCliente; // vai ser o ip
	private Desenho desenho;
	private Date dataUltimaAtualizacao;
	private ArrayList<String> conteudo;
	
	public PedidoDeSalvamento (double idCliente, Desenho des, Date dataUltimaAtualizacao)
	{
		this.idCliente = idCliente;
		this.desenho = des;
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
		conteudo = new ArrayList<String>();
	}
	
	public double getIdCliente ()
	{
		return this.idCliente;
	}
	
	public Desenho getDesenho ()
	{
		return this.desenho;
	}
	
	public Date getDataUltimaAtualizacao ()
	{
		return this.dataUltimaAtualizacao;
	}
	
	public ArrayList<String> getConteudo ()
	{
		return this.conteudo;
	}
	
    //metodo para acrescentar um desenho
	
	//metodo adicionar desenho
}
