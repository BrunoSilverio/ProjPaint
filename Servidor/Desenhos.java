package Servidor;

import java.util.ArrayList;
import java.util.Vector;

import Cliente.Figura;

//Contem todos os desenhos
public class Desenhos {
	private ArrayList<Desenhos> desenhos;
	
	public Desenhos(Vector<Figura> figuras)
	{
		desenhos = new ArrayList<Desenhos>();
	}
	//metodo adicionaDesenho - pegar no BD e mandar pro cliente
	public void addDesenho(Desenhos novo)
	{
		desenhos.add(novo);
	}
	
	public double getQtd ()
	{
		return desenhos.size();
	}
	
	public Desenhos getDesenho(int i)
	{
		return desenhos.get(i);
	}
    
}
