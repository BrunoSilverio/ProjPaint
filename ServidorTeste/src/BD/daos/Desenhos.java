package BD.daos;

import java.sql.*;
//import java.util.ArrayList;
//import java.util.Vector;

import BD.*;
import BD.core.*;
import BD.dbos.*;

//Contem todos os desenhos
public class Desenhos 
{
	//Nao tem atributos em bd.daos
	
	//BUSCA CLIENTE NO SERVIDOR
	public static boolean cadastrado (String ipCliente) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " + 
            	  "FROM DESENHOS " + 
            	  "WHERE IPCLIENTE = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);
            
            BDSQLServer.COMANDO.setString (1, ipCliente);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            retorno = resultado.first();
        }
        catch (SQLException erro)
        {
            throw new Exception ("ERRO ao procurar o IP Cliente!");
        }
        return retorno;
    }
	
	//INSERE UM CLIENTE NOVO NO BANCO
	public static void salvamento (Desenho cliente) throws Exception
	{
	    if (cliente==null)
	        throw new Exception ("Cliente NAO fornecido!");
	    
	    //INSERT INTO DESENHOS
	    try
	    {
	        String sql;

	        sql = "INSERT INTO DESENHOS " + 
	        	  "(IPCLIENTE,IDDESENHO,DTCRIACAO,DTATUALIZACAO)" + 
	        	  "VALUES " + 
	        	  "(?,?,?,?)";
	        
	        BDSQLServer.COMANDO.prepareStatement (sql);

	        BDSQLServer.COMANDO.setString (1, cliente.getIpCliente ());
	        BDSQLServer.COMANDO.setInt 	  (2, cliente.getIdDesenho ());
	        BDSQLServer.COMANDO.setString (3, cliente.getDtCriacao ());
	        BDSQLServer.COMANDO.setString (4, cliente.getDtAtualizacao ());

	        BDSQLServer.COMANDO.executeUpdate ();
	        BDSQLServer.COMANDO.commit        ();
	    }
	    catch (SQLException erro)
	    {
	    	BDSQLServer.COMANDO.rollback();
	        throw new Exception ("ERRO ao inserir Desenhos!");
	    }
	    //INSERT INTO FIGURAS
	    try
	    {
	        String sql2;

	        sql2 = "INSERT INTO FIGURAS " + 
		          "(IDFIGURA,STRGERADOR,IDDESENHO)" + 
		          "VALUES " + 
		          "(?,?,?)";

	        BDSQLServer.COMANDO.prepareStatement (sql2);

	        BDSQLServer.COMANDO.setInt 	  (1, cliente.getIdFigura ());
	        BDSQLServer.COMANDO.setArray (2, cliente.getStrGerador ()); //Nao sei mexer nesse ArrayList<String>
	        BDSQLServer.COMANDO.setInt 	  (3, cliente.getIdDesenho ());
	        
	        BDSQLServer.COMANDO.executeUpdate ();
	        BDSQLServer.COMANDO.commit        ();
	    }
	    catch (SQLException erro)
	    {
	    	BDSQLServer.COMANDO.rollback();
	        throw new Exception ("ERRO ao inserir Figuras!");
	    }
	}
	
	//ATUALIZA DESENHO NO SERVIDOR
	public static void alterar (Desenho cliente) throws Exception
	{
		if (cliente==null)
	    	throw new Exception ("Cliente NAO fornecido.");

		if (!cadastrado (cliente.getIpCliente()))
	    	throw new Exception ("Cliente NAO cadastrado.");
		
		//UPDATE DO DESENHO
	 	try
	 	{
	    	String sql;

	     	sql = "UPDATE DESENHOS " +
	              "SET DTATUALIZACAO = ? " +
	              "WHERE IDDESENHO = ? " +
	              "WHERE IPCLIENTE = ? ";
	     		     	
	     	BDSQLServer.COMANDO.prepareStatement (sql);
	     	
	     	BDSQLServer.COMANDO.setString (1, cliente.getDtAtualizacao ());
	     	BDSQLServer.COMANDO.setInt 	  (2, cliente.getIdDesenho ());
	     	BDSQLServer.COMANDO.setString (3, cliente.getIpCliente ());

	     	BDSQLServer.COMANDO.executeUpdate ();
	     	BDSQLServer.COMANDO.commit        ();
	 	}
	    catch (SQLException erro)
	    {
			BDSQLServer.COMANDO.rollback();
	    	throw new Exception ("ERRO ao atualizar dados do Desenho!");
	  	}
		//UPDATE DA FIGURA
	 	try
	 	{
	    	String sql2;
	     	
	     	sql2 = "UPDATE FIGURAS " +
		           "SET STRGERADOR = ? " +
		           "WHERE IDFIGURA = ? " +
		           "WHERE IDDESENHO = ? ";
	     	
	     	BDSQLServer.COMANDO.prepareStatement (sql2);
	     	
	     	BDSQLServer.COMANDO.setArray (1, cliente.getStrGerador ()); //Nao sei mexer nesse ArrayList<String>
	     	BDSQLServer.COMANDO.setInt    (2, cliente.getIdFigura ());
	     	BDSQLServer.COMANDO.setInt    (3, cliente.getIdDesenho ());

	     	BDSQLServer.COMANDO.executeUpdate ();
	     	BDSQLServer.COMANDO.commit        ();
	 	}
	    catch (SQLException erro)
	    {
			BDSQLServer.COMANDO.rollback();
	    	throw new Exception ("ERRO ao atualizar dados da Figura!");
	  	}
	}
	
	//RECUPERA OS DESENHOS DE UM CLIENTE ESPECIFICO
	public static Desenho getDesenho (Desenho ipCliente) throws Exception
	{
		Desenho desenho = null;

		try
		{
	    	String sql;

	     	sql = "SELECT STRGERADOR " +
	              "FROM FIGURAS " +
	              "WHERE IDDESENHO = ? "; 

	    	BDSQLServer.COMANDO.prepareStatement (sql);

	     	BDSQLServer.COMANDO.setInt (1, ipCliente.getIdDesenho ());

	     	MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

	    	if (!resultado.first())
	    		throw new Exception ("NAO cadastrado.");

	     	desenho = new Desenho (resultado.getString ("IPCLIENTE"),
	                           	   resultado.getInt	   ("IDDESENHO"),
	                           	   resultado.getString   ("DTCRIACAO"),
	                           	   resultado.getString   ("DTATUALIZACAO")); 
	     							//resultado.getArray ("CONTEUDO")
		}
	    catch (SQLException erro)
		{
	        throw new Exception ("Erro ao procurar livro");
		}

		return desenho;
	}
}
