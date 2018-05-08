package ListaSequencial;

import java.io.*;

public class Main {
	
	static class No {
		int valor;
		No esq;
		No dir;
		
		public No(int valor){
			this.valor = valor;
			esq = null;
			dir = null;
		}
		
		public int getConteudo(){
			return valor;
		}
		
		public No getEsq(){
			return esq;
		}
		
		public No getDir(){
			return dir;
		}
	}
	
	static class Arovre{
		protected String posStr = "";
		protected static int preIndex = 0;
		
		//method used to build tree using both preOrder and inOrder traversals
		private No buildArvore(String in[], String pre[], int inStrt, int inEnd) 
	    {
	        if (inStrt > inEnd) 
	            return null;
	        
	        int valor = Integer.parseInt(pre[preIndex++]);
	        No tNo = new No(valor);
	 
	        if (inStrt == inEnd)
	            return tNo;
	  
	        int inIndex = search(in, inStrt, inEnd, tNo.valor);
	  
	        tNo.esq = buildArvore(in, pre, inStrt, inIndex - 1);
	        tNo.dir = buildArvore(in, pre, inIndex + 1, inEnd);
	  
	        return tNo;
	    }
		
		//method used to find preOrder element inOrder array 
		private int search(String arr[], int strt, int end, int value) 
	    {
	        int i;
	        for (i = strt; i <= end; i++) 
	        {
	        	int arrValue = Integer.parseInt(arr[i]);
	            if ( arrValue == value)
	                return i;
	        }
	        return i;
	    }
		
		private void posOrderArvore(No no) 
	    {
	        if (no == null) return;
		    
	        posOrderArvore(no.esq);
	  
	        posOrderArvore(no.dir);
	        
	        posStr += no.valor + " ";
	    }
		
		private String equalsStr() {
			return posStr;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		try {
			Arovre arvore = new Arovre();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int size = Integer.parseInt(in.readLine());
		
			String pre = in.readLine();
			String preOrder[] = pre.split(" ");
			
			String pos = in.readLine();
			
			String inOr = in.readLine();
			String inOrder[] = inOr.split(" ");
			
			No root = arvore.buildArvore(inOrder, preOrder, 0, size-1);
			
			arvore.posOrderArvore(root);
			
			String posArvore = arvore.equalsStr();
			
			String posStr = posArvore.substring(0, posArvore.length() - 1);
			if(pos.equals(posStr)) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
