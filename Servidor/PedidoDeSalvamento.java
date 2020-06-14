package Servidor;

public class PedidoDeSalvamento extends Comunicado {
	// vetor com os desenhos
    // nome do desenho
	
	private double idCliente; // vai ser o ip
	private Desenhos desenho;
	private String nomeDoDesenho;
	
	public PedidoDeSalvamento (double idCliente, Desenhos des, String nome)
	{
		this.idCliente = idCliente;
		this.desenho = des;
		this.nomeDoDesenho = nome;
	}
	
	public double getIdCliente ()
	{
		return this.idCliente;
	}
	
	public Desenhos getDesenho ()
	{
		return this.desenho;
	}
	public double getQuantidadeDesenho()
	{
		return desenho.getQtd();
				
	}
	
    //metodo para acrescentar um desenho
    //metodo adicionar desenho
}
