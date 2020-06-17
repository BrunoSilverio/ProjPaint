package Servidor;

import java.sql.Date;
import java.util.ArrayList;

public class PedidoDeAbertura extends Comunicado{
	private int idCli;// nome do cliente
	private String nomeDes;// nome do desenho
	private Date dataCri;// datas de criacao
	private Date dataUltimaAtua;//ultima atualizacao
	private ArrayList<String> cont;//Lista desenho
	
	public PedidoDeAbertura(int idCli, String nomD, Date dtCri, Date dtUltAtu, ArrayList<String> cont)
	{
		setIdCli(idCli);
		setNomeD(nomD);
		setDataCriacao(dtCri);
		setDataUltimaAtualizacao(dtUltAtu);

		cont = new ArrayList<String>();
	}
    // setters e getters
	// fig vai ter como forma o retorno do metodo toString de alguma das classes
	// herdadas da classe Figura por exemplo, r:11:22:33:44:55:66:77, para uma
	// linha que vai do ponto com coordenada 11,22 ao ponto com coordenada 33,44
	// e com cor 55:66:77 (55 de red, 66 de green e 77 de blue).
	
	//ID Cliente
	public int getIdCli() {
		return idCli;
	}
	public void setIdCli(int idCli) {
		this.idCli = idCli;
	}
	//nome desenho
	public String getNomeD() {
		return nomeDes;
	}
	public void setNomeD(String nomeDes) {
		this.nomeDes = nomeDes;
	}
	//dataCriacao 
	public Date getDataCriacao() {
		return dataCri;
	}
	public void setDataCriacao(Date dataCri) {
		this.dataCri = dataCri;
	}
	//dataUltimaAtualizacao
	public Date getDataUltimaAtualizacao() {
		return dataUltimaAtua;
	}
	public void setDataUltimaAtualizacao(Date dataUltimaAtua) {
		this.dataUltimaAtua = dataUltimaAtua;
	}
	
	public void addFigura(String fig)
	{
		cont.add(fig);
	}
	
	public int getQtd ()
	{
		return cont.size();
	}
	
	public String getFigura (int i)
	{
		return cont.get(i);
	}
}
