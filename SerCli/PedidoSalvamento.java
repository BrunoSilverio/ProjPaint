package SerCli;

public class PedidoSalvamento extends Comunicado{
	private double idCliente; // vai ser o ip
	private Desenho desenho;
	
	public PedidoSalvamento (double idCliente, Desenho des)
	{
		this.idCliente = idCliente;
		this.desenho = des;
	}
	
	public double getIdCliente ()
	{
		return this.idCliente;
	}
	
	public Desenho getDesenho ()
	{
		return this.desenho;
	}
}
