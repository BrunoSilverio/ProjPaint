package comunicados;

import java.sql.Date;
import java.util.ArrayList;

public class PedidoDesenhos extends Comunicado{
	private double idCliente;// IP cliente
	//private String nomeDes;// nome do desenho
	//private Date dataCri;// datas de criacao
	//private Date dataUltimaAtua;//ultima atualizacao
	//private ArrayList<String> cont;//Lista desenho
	
	public PedidoDesenhos(double idCliente)
	{
		this.idCliente = idCliente;
	}
    //getters
	//ID Cliente
	public double getIdCliente() {
		return this.idCliente;
	}

	//nome desenho
	/*public String getNomeD() {
		return nomeDes;
	}

	//dataCriacao 
	public Date getDataCriacao() {
		return dataCri;
	}

	//dataUltimaAtualizacao
	public Date getDataUltimaAtualizacao() {
		return dataUltimaAtua;
	}*/
}
