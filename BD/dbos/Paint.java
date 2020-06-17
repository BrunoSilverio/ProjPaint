package BD.dbos;

//import java.util.ArrayList;
import java.sql.*;

//Classe dbo seria um item armazenado na tabela
public class Paint implements Cloneable{
	//ACHO QUE ESSAS SÃO AS VARIAVEIS QUE VAMOS USAR
	private int idCliente; //IP
	private String nomeDesenho;
	private Date dataCriacao;
	private Date dataUltimaAtualizacao;
	private Array conteudo; //FAZER SET GET ********* ArrayList<String>
 
	//SETTERS
    public void setIdCliente (int idCliente) throws Exception
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
    public void setConteudo(Array conteudo) throws Exception 
    {
    	if (conteudo==null)
            throw new Exception ("Desenho NAO fornecido.");

        this.conteudo = conteudo;
    }
    //GETTERS
    public int getIdCliente ()
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
    public Array getConteudo ()//NAO SEI SE TA CORRETO
    {
        return this.conteudo;
    }
    
    public Paint (int idCliente, String nomeDesenho, Date dataCriacao, Date dataUltimaAtualizacao, Array conteudo) throws Exception
    {
        this.setIdCliente (idCliente);
        this.setNomeDesenho (nomeDesenho);
        this.setDataCriacao (dataCriacao);
        this.setDataUltimaAtualizacao (dataUltimaAtualizacao);
        this.setConteudo (conteudo);
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

    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (!(obj instanceof Paint))
            return false;

        Paint liv = (Paint)obj;

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
    //NAO SEI SE PRECISA DESSE METODO hashCode()
    /*public int hashCode ()
    {
        int ret=666;

        ret = 7*ret + new Integer(this.codigo).hashCode();
        ret = 7*ret + this.nome.hashCode();
        ret = 7*ret + new Float(this.preco).hashCode();

        return ret;
    }*/

    public Paint (Paint modelo) throws Exception
    {
        this.idCliente = modelo.idCliente; // nao clono, pq nao eh objeto
        this.nomeDesenho   = modelo.nomeDesenho;   // nao clono, pq nao eh clonavel
        this.dataCriacao  = modelo.dataCriacao;  // nao clono, pq nao eh objeto
        this.dataUltimaAtualizacao  = modelo.dataUltimaAtualizacao;
        this.conteudo  = modelo.conteudo;
    }

    public Object clone ()
    {
        Paint ret=null;

        try
        {
            ret = new Paint (this);
        }
        catch (Exception erro)
        {} // nao trato, pq this nunca é null e construtor de
           // copia da excecao qdo seu parametro for null

        return ret;
    }
}

