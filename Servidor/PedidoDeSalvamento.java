package Servidor;

import BD.daos.Paints;

public class PedidoDeSalvamento extends Comunicado {
	// vetor com os desenhos
    // nome do desenho
	
	private int idCliente; // vai ser o ip
	private Paints desenho;
	private String nomeDoDesenho;
	
	public PedidoDeSalvamento (int idCliente, Paints des, String nome)
	{
		this.idCliente = idCliente;
		this.desenho = des;
		this.nomeDoDesenho = nome;
	}
	
	public double getIdCliente ()
	{
		return this.idCliente;
	}
	
	public Paints getDesenho ()
	{
		return this.desenho;
	}
	
	/*public double getQuantidadeDesenho()
	{
		return desenho.getQtd();
				
	}*/
	
    //metodo para acrescentar um desenho
    //metodo adicionar desenho
}
