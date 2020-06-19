import comunicados.*;

import java.io.*;
import java.net.*;
import java.sql.Array;
import java.sql.Date;
import java.util.*;

import BD.daos.*;
import BD.dbos.*;

public class SupervisoraDeConexao extends Thread
{
    private Parceiro            usuario;
    private Socket              conexao;
    private ArrayList<Parceiro> usuarios;
    
    private double ipCliente=0;
    private int idDesenho=0;
    Desenho d = new Desenho();

    public SupervisoraDeConexao
    (Socket conexao, ArrayList<Parceiro> usuarios)
    throws Exception
    {
        if (conexao==null)
            throw new Exception ("Conexao AUSENTE!");

        if (usuarios==null)
            throw new Exception ("Usuarios AUSENTES!");

        this.conexao  = conexao;
        this.usuarios = usuarios;
    }

    public void run ()
    {

        ObjectOutputStream transmissor;
        try
        {
            transmissor =
            new ObjectOutputStream(
            this.conexao.getOutputStream());
        }
        catch (Exception erro)
        {
            return;
        }
        
        ObjectInputStream receptor=null;
        try
        {
            receptor=
            new ObjectInputStream(
            this.conexao.getInputStream());
        }
        catch (Exception err0)
        {
            try
            {
                transmissor.close();
            }
            catch (Exception falha)
            {} // so tentando fechar antes de acabar a thread
            
            return;
        }

        try
        {
            this.usuario =
            new Parceiro (this.conexao,
                          receptor,
                          transmissor);
        }
        catch (Exception erro)
        {} // sei que passei os parametros corretos

        try
        {
            synchronized (this.usuarios)
            {
                this.usuarios.add (this.usuario);
            }


            for(;;)
            {
                Comunicado comunicado = this.usuario.envie ();
                //CASO comunicado ESTEJA VAZIO
                if (comunicado==null)
                    return;
                //PEDIDO PARA SALVAR O DESENHO
                else if (comunicado instanceof PedidoDeSalvamento)
                {
					// pegar do comunicado o vetor cheio de desenhos
					// e mais o nome do desenho e mais identificacao 
					// cliente, e mandar pro BD usando o DAO e o DBO
					// que voce vai fazer
					// -----
					// desconectar o usuario
                	
                	PedidoDeSalvamento pedidoSalvamento = (PedidoDeSalvamento)comunicado;
                	
                	ipCliente = pedidoSalvamento.getIpCliente();
                	idDesenho  = pedidoSalvamento.getIdDesenho();
                	d = pedidoSalvamento.getDesenho();
                	
                	System.out.print (ipCliente);
                	System.out.print (idDesenho);
                	System.out.print (d);
                	
		        }
                //PEDIDO PARA ABRIR O DESENHO
                else if (comunicado instanceof PedidoDesenhos)
                {
					// pegar do comunicado o nome do desenho e a identificacao
					// cliente, usar o DAO e DBO para recuperar do BD os dados,
					// preencher um objeto do tipo Desenho e vai enviar pro
					// cliente fazendo usuario.receba(desenho)
					// -----
					// desconecta o usuario
                	
                	PedidoDesenhos pedidoAbertura = (PedidoDesenhos)comunicado;
                	
                	idDesenho = pedidoAbertura.getIdDesenho();
                	ipCliente = pedidoAbertura.getIpCliente();
                	usuario.receba(d);
                }
            }
        }
        catch (Exception erro)
        {
            try
            {
                transmissor.close ();
                receptor   .close ();
            }
            catch (Exception falha)
            {} // so tentando fechar antes de acabar a thread

            return;
        }
    }
}
