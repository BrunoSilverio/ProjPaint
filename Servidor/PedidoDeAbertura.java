package Servidor;

import java.util.ArrayList;

public class PedidoDeAbertura extends Comunicado{
	// nome do desenho
    // nome do cliente	
    // datas de criacao e ultima atualizacao
	private String nomeCliente;
	private String nomeDesenho;
	private String dataCriacao;
	private String dataUltimaAtualizacao;
	private ArrayList<String> conteudo;
	
	public PedidoDeAbertura(String nomC, String nomD, String dtCri, String dtUltAtu)
	{
		setNomeC(nomC);
		setNomeD(nomD);
		setDataCriacao(dtCri);
		setDataUltimaAtualizacao(dtUltAtu);

		conteudo = new ArrayList<String>();
	}
    // setters e getters
	// fig vai ter como forma o retorno do metodo toString de alguma das classes
	// herdadas da classe Figura por exemplo, r:11:22:33:44:55:66:77, para uma
	// linha que vai do ponto com coordenada 11,22 ao ponto com coordenada 33,44
	// e com cor 55:66:77 (55 de red, 66 de green e 77 de blue).
	public void addFigura(String fig)
	{
		conteudo.add(fig);
	}
	
	public int getQtd ()
	{
		return conteudo.size();
	}
	
	public String getFigura (int i)
	{
		return conteudo.get(i);
	}
	//nome Cliente
	public String getNomeC() {
		return nomeCliente;
	}
	public void setNomeC(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	//nome desenho
	public String getNomeD() {
		return nomeDesenho;
	}
	public void setNomeD(String nomeDesenho) {
		this.nomeDesenho = nomeDesenho;
	}
	//dataCriacao 
	public String getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	//dataUltimaAtualizacao
	public String getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}
	public void setDataUltimaAtualizacao(String dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}
}
