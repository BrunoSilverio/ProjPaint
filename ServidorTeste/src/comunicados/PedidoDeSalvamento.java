package comunicados;

import java.sql.Date;
import java.util.ArrayList;

import BD.daos.Desenhos;
import BD.dbos.Desenho;

public class PedidoDeSalvamento extends Comunicado {
	// vetor com os desenhos
    // nome do desenho
	
    private int idDesenho, idControler = 0;
    private String dCri, dAtu, ipCliente;
    private ArrayList<String> figs, conteudo;
	
	public PedidoDeSalvamento (String idCliente, 
							   String dataCriacao, String dataUltimaAtualizacao, ArrayList<String> figuras)
	{
		this.ipCliente = idCliente;
		this.dCri = dataCriacao;
		this.dAtu = dataUltimaAtualizacao;
		this.idDesenho = idControler;//Ele só pode atualizar dpois que passar todos as figuras desse desenho
		this.figs = figuras;
		conteudo = new ArrayList<String>();
		idControler++;
	}
	
	public String getIdCliente ()
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
	
	public String getDataUltimaAtualizacao ()
	{
		return this.dAtu;
	}
	
	public String getDataCriacao ()
	{
		return this.dCri;
	}
	
	public ArrayList<String> getConteudo ()
	{
		return this.conteudo;
	}
	
    //metodo para acrescentar um desenho
	
	//metodo adicionar desenho
}
