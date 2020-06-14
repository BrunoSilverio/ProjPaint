package Servidor;

public class PedidoDeSalvamento extends Comunicado {
	// vetor com os desenhos
    // nome do desenho
	
	private double idCliente; // vai ser o ip
	private Desenhos desenho;
	
	public PedidoDeSalvamento (double idCliente, Desenhos des)
	{
		this.idCliente = idCliente;
		this.desenho = des;
	}
	
	public double getIdCliente ()
	{
		return this.idCliente;
	}
	
	public Desenhos getDesenho ()
	{
		return this.desenho;
	}
	//talvez um getQuantidadeDesenho - para saber quantos desenhos são
    //metodo para acrescentar um desenho
    //metodo adicionar desenho
}
