package SerCli;

public class PedidoDesenhos extends Comunicado {
	private double idCliente; // vai ser o ip

	public PedidoDesenhos(double idCliente) {
		this.idCliente = idCliente;
	}

	public double getIdCliente() {
		return this.idCliente;
	}
}
