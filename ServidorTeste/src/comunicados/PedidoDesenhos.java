package comunicados;

import java.sql.Date;
import java.util.ArrayList;

import BD.dbos.Desenho;

public class PedidoDesenhos extends Comunicado{
	private String ipCliente;
	private int idDesenho;
	private ArrayList<Desenho> figs;
	
	public PedidoDesenhos(String ipCliente, int idDesenho)
	{
		this.ipCliente = ipCliente;
		this.idDesenho = idDesenho;
	}
	
	public String getIpCliente() {
		return this.ipCliente;
	}
	public int getIdDesenho() {
		return this.idDesenho;
	}
	public ArrayList<Desenho> getDesenho ()
	{
		return this.figs;
	}
	
	//Adicionei
	public void setIpCliente (String ipCliente) throws Exception
    {
    	this.ipCliente = ipCliente;
    }
    public void setIdDesenho (int idDesenho) throws Exception
    {
        if (idDesenho==0)
            throw new Exception ("ID Desenho NAO fornecido!");

        this.idDesenho = idDesenho;
    }
}
