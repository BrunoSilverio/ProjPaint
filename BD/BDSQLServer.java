package BD;

import BD.core.*;
//import BD.daos.*;
//import BD.dbos.*;

public class BDSQLServer
{
    public static final MeuPreparedStatement COMANDO;

    static
    {
    	MeuPreparedStatement comando = null;

    	try
        {
            comando =
            new MeuPreparedStatement (
            "com.microsoft.sqlserver.jdbc.SQLServerDriver",
            "jdbc:sqlserver://127.0.0.1:3306;databasename=paint-Client",
            "root", "12345");
        }
        catch (Exception erro)
        {
            System.err.println ("Problemas de conexao com o Banco de Dados");
            System.exit(0); // aborta o programa
        }
        
        COMANDO = comando;
    }
}