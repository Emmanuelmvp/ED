package ListaSequencial;

import java.util.*;
import java.lang.*;
 
class atividade1{
	
	public static void main (String[] args) throws java.lang.Exception
	{
		int nSize, mSize, i, j;
		
		Scanner leitura = new Scanner(System.in);
		
		nSize = leitura.nextInt();
		int[] N = new int[nSize];
		for(i=0;i<nSize;i++){
			N[i] = leitura.nextInt();
		}
		
		mSize = leitura.nextInt();
		int [] M = new int[mSize];
		for(i=0;i<mSize;i++){
			M[i] = leitura.nextInt();
		}
		
		
		boolean match = true;
		for(i=0;i<nSize;i++){
			for(j=0;j<mSize && match;j++){
				match = (N[i] != M[j]);
			}
			if(match){
				System.out.print(N[i] + " ");
			}
			match = true;
		}
	}
}
  