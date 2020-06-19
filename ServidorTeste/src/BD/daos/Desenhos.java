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
	public static boolean cadastrado (double idCliente) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " + 
            	  "FROM CLIENTES " + 
            	  "WHERE IDCLIENTE = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);
            
            BDSQLServer.COMANDO.setDouble (1, idCliente);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            retorno = resultado.first();
        }
        catch (SQLException erro)
        {
            throw new Exception ("ERRO ao procurar o ID Cliente.");
        }
        return retorno;
    }
	//INSERE UM CLIENTE NOVO NO BANCO
	public static void salvamento (Desenho cliente) throws Exception
	{
	    if (cliente==null)
	        throw new Exception ("Cliente NAO fornecido.");

	    try
	    {
	        String sql;

	        sql = "INSERT INTO CLIENTES " + 
	        	  "(IDCLIENTE,NOMEDESENHO,DATACRIACAO,DATAULTIMAATUALIZACAO,CONTEUDO)" + 
	        	  "VALUES " + 
	        	  "(?,?,?,?,?)";

	        BDSQLServer.COMANDO.prepareStatement (sql);

	        BDSQLServer.COMANDO.setDouble (1, cliente.getIdCliente ());
	        BDSQLServer.COMANDO.setString (2, cliente.getNomeDesenho ());
	        BDSQLServer.COMANDO.setDate   (3, cliente.getDataCriacao ());
	        BDSQLServer.COMANDO.setDate   (4, cliente.getDataUltimaAtualizacao ());
	        BDSQLServer.COMANDO.setArray  (5, (Array) cliente.getConteudo ());//NAO SEI SE TA CERTO O ARRAY

	        BDSQLServer.COMANDO.executeUpdate ();
	        BDSQLServer.COMANDO.commit        ();
	    }
	    catch (SQLException erro)
	    {
	    	BDSQLServer.COMANDO.rollback();
	        throw new Exception ("ERRO ao inserir cliente.");
	    }
	}
	//ATUALIZA DESENHO NO SERVIDOR
	public static void alterar (Desenho cliente) throws Exception
	{
		if (cliente==null)
	    	throw new Exception ("Cliente NAO fornecido.");

		if (!cadastrado (cliente.getIdCliente()))
	    	throw new Exception ("Cliente NAO cadastrado.");

	 	try
	 	{
	    	String sql;

	     	sql = "UPDATE CLIENTES " +
	              "SET DATAULTIMAATUALIZACAO=? " +
	              "SET CONTEUDO=? " +
	              "WHERE IDCLIENTE = ?";

	     	BDSQLServer.COMANDO.prepareStatement (sql);

	     	BDSQLServer.COMANDO.setDate (1, cliente.getDataUltimaAtualizacao ());
	    	BDSQLServer.COMANDO.setArray(2, (Array) cliente.getConteudo ());
	     	BDSQLServer.COMANDO.setDouble  (3, cliente.getIdCliente ());

	     	BDSQLServer.COMANDO.executeUpdate ();
	     	BDSQLServer.COMANDO.commit        ();
	 	}
	    catch (SQLException erro)
	    {
			BDSQLServer.COMANDO.rollback();
	    	throw new Exception ("ERRO ao atualizar dados do cliente.");
	  	}
	}
	//RECUPERA OS DESENHOS DE UM CLIENTE ESPECIFICO
	public static Desenho getDesenho (Desenho idCliente) throws Exception
	{
		Desenho desenho = null;

		try
		{
	    	String sql;

	     	sql = "SELECT CONTEUDO " +
	              "FROM CLIENTES " +
	              "WHERE IDCLIENTE = ?"; 

	    	BDSQLServer.COMANDO.prepareStatement (sql);

	     	BDSQLServer.COMANDO.setDouble (1, idCliente.getIdCliente());

	     	MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

	    	if (!resultado.first())
	    		throw new Exception ("NAO cadastrado.");

	     	desenho = new Desenho (resultado.getInt   ("IDCLIENTE"),
	                           	   resultado.getString("NOMEDESENHO"),
	                           	   resultado.getDate  ("DATACRIACAO"),
	                           	   resultado.getDate  ("DATAULTIMAATUALIZACAO")); 
	     							//resultado.getArray ("CONTEUDO")
		}
	    catch (SQLException erro)
		{
	        throw new Exception ("Erro ao procurar livro");
		}

		return desenho;
	}
	//RECUPERA TODOS OS DESENHOS
	public static MeuResultSet getDesenhos () throws Exception
	{
	 	MeuResultSet resultado = null;

		try
		{
	    	String sql;

	    	sql = "SELECT CONTEUDO " +
	        	  "FROM CLIENTES"; //TALVEZ SELECT EM TODOS DESENHOS PRO CLIENTE VER O Q TEM NO SERVIDOR? SELECT CONTEUDO

	    	BDSQLServer.COMANDO.prepareStatement (sql);

	    	resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
		}
		catch (SQLException erro)
	    {
			throw new Exception ("ERRO ao recuperar clientes.");
		}
		return resultado;
	}
}
