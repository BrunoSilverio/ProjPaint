package BD.dbos;

import java.util.ArrayList;
import java.sql.*;

//Classe dbo seria um item armazenado na tabela
public class Desenho implements Cloneable{
	private double idCliente; //IP
	private String nomeDesenho;
	private Date dataCriacao;
	private Date dataUltimaAtualizacao;
	private ArrayList<String> conteudo;
 
    public Desenho (double idCliente, String nomeDesenho, Date dataCriacao, Date dataUltimaAtualizacao) throws Exception
    {
        this.setIdCliente (idCliente);
        this.setNomeDesenho (nomeDesenho);
        this.setDataCriacao (dataCriacao);
        this.setDataUltimaAtualizacao (dataUltimaAtualizacao);
        conteudo = new ArrayList<String>();
    }

    public String toString ()
    {
        String ret="";

        ret+="ID Cliente: "+this.idCliente+"\n";
        ret+="Nome Desenho..: "+this.nomeDesenho  +"\n";
        ret+="Data Criação.: "+this.dataCriacao+"\n";
        ret+="Data Atualização.: "+this.dataUltimaAtualizacao+"\n";
        ret+="Conteudo.: "+this.conteudo;
        
        return ret;
    }

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
    
    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (!(obj instanceof Desenho))
            return false;

        Desenho liv = (Desenho)obj;

        if (this.idCliente!=liv.idCliente)
            return false;

        if (this.nomeDesenho.equals(liv.nomeDesenho))
            return false;

        if (this.dataCriacao!=liv.dataCriacao)
            return false;
        
        if (this.dataUltimaAtualizacao!=liv.dataUltimaAtualizacao)
            return false;
        
        if (this.conteudo!=liv.conteudo)
            return false;
        
        return true;
    }
    
    public int hashCode ()
    {
        int ret=666;

        ret = 7*ret + new Float(this.idCliente).hashCode();
        ret = 7*ret + this.nomeDesenho.hashCode();
        ret = 7*ret + this.dataCriacao.hashCode();
        ret = 7*ret + this.dataUltimaAtualizacao.hashCode();
        ret = 7*ret + this.conteudo.hashCode();

        return ret;
    }

    public Desenho (Desenho modelo) throws Exception
    {
        this.idCliente = modelo.idCliente; // nao clono, pq nao eh objeto
        this.nomeDesenho   = modelo.nomeDesenho;   // nao clono, pq nao eh clonavel
        this.dataCriacao  = modelo.dataCriacao;  // nao clono, pq nao eh objeto
        this.dataUltimaAtualizacao  = modelo.dataUltimaAtualizacao;
        this.conteudo  = modelo.conteudo;
    }

    public Object clone ()
    {
        Desenho ret=null;

        try
        {
            ret = new Desenho (this);
        }
        catch (Exception erro)
        {} // nao trato, pq this nunca é null e construtor de
           // copia da excecao qdo seu parametro for null

        return ret;
    }
    
    //SETTERS
    public void setIdCliente (double idCliente) throws Exception
    {
        if (idCliente <= 0)
            throw new Exception ("ID Cliente INVALIDO!");

        this.idCliente = idCliente;
    }
    public void setNomeDesenho (String nomeDesenho) throws Exception
    {
    	if (nomeDesenho==null || nomeDesenho.equals(""))
            throw new Exception ("Nome do Desenho NAO fornecido.");

        this.nomeDesenho = nomeDesenho;
    }
    public void setDataCriacao(Date dataCriacao) throws Exception 
    {
    	if (dataCriacao==null)
            throw new Exception ("Data do Desenho NAO fornecido.");

        this.dataCriacao = dataCriacao;
    }
    public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) throws Exception 
    {
    	if (dataUltimaAtualizacao==null)
            throw new Exception ("Data da Atualizacao do Desenho NAO fornecido.");

        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }
    public void setConteudo(ArrayList<String> conteudo) throws Exception 
    {
    	if (conteudo==null)
            throw new Exception ("Desenho NAO fornecido.");

        this.conteudo = conteudo;
    }
    //GETTERS
    public double getIdCliente ()
    {
        return this.idCliente;
    }
    public String getNomeDesenho ()
    {
        return this.nomeDesenho;
    }
    public Date getDataCriacao ()
    {
        return this.dataCriacao;
    }
    public Date getDataUltimaAtualizacao ()
    {
        return this.dataUltimaAtualizacao;
    }
    public ArrayList<String> getConteudo ()
    {
        return conteudo;
    }
}

