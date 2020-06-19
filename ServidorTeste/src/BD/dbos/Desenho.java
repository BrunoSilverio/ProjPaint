package BD.dbos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;
import java.sql.*;

//Classe dbo seria um item armazenado na tabela
public class Desenho implements Cloneable{
	private String ipCliente; 
	private int idDesenho;
	private String dtCriacao;
	private String dtAtualizacao;
	
	private int idFigura;
	private ArrayList<String> strGerador;
	
 
	//Adicionei
	public Desenho()
	{
		// TODO Auto-generated constructor stub
	}
	
    public Desenho (String ipCliente, int idDesenho, String dtCriacao, String dtAtualizacao) throws Exception
    {
        this.setIpCliente (ipCliente);
        this.setIdDesenho (idDesenho);
        this.setDtCriacao (dtCriacao);
        this.setDtAtualizacao (dtAtualizacao);
        strGerador = new ArrayList<String>();
    }

    public String toString ()
    {
        String ret="";

        ret+="IP Cliente: "+this.ipCliente+"\n";
        ret+="ID Desenho..: "+this.idDesenho  +"\n";
        ret+="Data Criação.: "+this.dtCriacao+"\n";
        ret+="Data Atualização.: "+this.dtAtualizacao+"\n";
        ret+="Conteudo.: "+this.strGerador;
        
        return ret;
    }

    public void addFigura(String fig)
    {
    	strGerador.add(fig);
    }
    //Adicionei
    public void addIdDesenho(int idDesenho)
	{
		this.idDesenho = idDesenho;
	}
	public void addDtCriacao(String dtCriacao)
	{
		this.dtCriacao = dtCriacao;
	}
	public void addDtAtualizacao(String dtAtualizacao)
	{
		this.dtAtualizacao = dtAtualizacao;
	}
    
    
    public int getQtd ()
    {
    	return strGerador.size();
    }
    public String getFigura (int i)
    {
    	return strGerador.get(i);
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

        if (this.ipCliente!=liv.ipCliente)
            return false;

        if (this.idDesenho!=liv.idDesenho)
            return false;

        if (this.dtCriacao!=liv.dtCriacao)
            return false;
        
        if (this.dtAtualizacao!=liv.dtAtualizacao)
            return false;
        
        if (this.strGerador!=liv.strGerador)
            return false;
        
        return true;
    }
    
    public int hashCode ()
    {
        int ret=666;

        ret = 7*ret + this.ipCliente.hashCode();
        ret = 7*ret + new Float (this.idDesenho).hashCode();
        ret = 7*ret + this.dtCriacao.hashCode();
        ret = 7*ret + this.dtAtualizacao.hashCode();
        ret = 7*ret + this.strGerador.hashCode();

        return ret;
    }

    public Desenho (Desenho modelo) throws Exception
    {
        this.ipCliente = modelo.ipCliente; // nao clono, pq nao eh objeto
        this.idDesenho   = modelo.idDesenho;   // nao clono, pq nao eh clonavel
        this.dtCriacao  = modelo.dtCriacao;  // nao clono, pq nao eh objeto
        this.dtAtualizacao  = modelo.dtAtualizacao;
        this.strGerador  = modelo.strGerador;
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
    public void setIpCliente (String ipCliente) throws Exception
    {
        if (ipCliente==null || ipCliente==(""))
            throw new Exception ("IP Cliente INVALIDO!");

        this.ipCliente = ipCliente;
    }
    public void setIdDesenho (int idDesenho) throws Exception
    {
    	if (idDesenho<=0)
            throw new Exception ("ID do Desenho NAO fornecido.");

        this.idDesenho = idDesenho;
    }
    public void setDtCriacao(String dtCriacao) throws Exception 
    {
    	if (dtCriacao==null || dtCriacao==(""))
            throw new Exception ("Data do Desenho NAO fornecido.");

        this.dtCriacao = dtCriacao;
    }
    public void setDtAtualizacao(String dtAtualizacao) throws Exception 
    {
    	if (dtAtualizacao==null || dtAtualizacao==(""))
            throw new Exception ("Data da Atualizacao do Desenho NAO fornecido.");

        this.dtAtualizacao = dtAtualizacao;
    }
    public void setStrGerador(ArrayList<String> strGerador) throws Exception 
    {
    	if (strGerador==null)
            throw new Exception ("Desenho NAO fornecido.");

        this.strGerador = strGerador;
    }
    public void setIdFigura (int idFigura) throws Exception
    {
    	if (idFigura<=0)
            throw new Exception ("ID da Figura NAO fornecido.");

        this.idFigura = idFigura;
    }
    
    //GETTERS
    public String getIpCliente ()
    {
        return this.ipCliente;
    }
    public int getIdDesenho ()
    {
        return this.idDesenho;
    }
    public String getDtCriacao ()
    {
        return this.dtCriacao;
    }
    public String getDtAtualizacao ()
    {
        return this.dtAtualizacao;
    }
    public ArrayList<String> getStrGerador ()
    {
        return strGerador;
    }
    public int getIdFigura ()
    {
        return this.idFigura;
    }
    
}

