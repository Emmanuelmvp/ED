import java.io.*;

public class Main {
	static class No{
		private String conteudo;
		private No prox;
		
		public No(){
			prox = null;
		}
		
		public No getProx(){
			return prox;
		}
		public void setProx(No prox){
			this.prox = prox;
		}
		public String getConteudo(){
			return conteudo;
		}
		public void setConteudo(String conteudo){
			this.conteudo = conteudo;
		}	
	}
	
	static class Listas{
		protected No inicio;
		protected int tamanho;
		
		protected boolean vazia;
		
		public Listas(int t){
			inicio = null;
			tamanho = t;
			vazia = true;
		}
		
		public void insere(String s){
			No novoNo = new No();
			novoNo.setConteudo(s);
			novoNo.setProx(null);
			
			if(vazia){
				inicio = novoNo;
				vazia = false;
			}
			else{
				No aux = inicio;
				
				while(aux.getProx() != null){
					aux = aux.getProx();
				}
				aux.setProx(novoNo);
			}
		}
		
		public int buscar(String s){
			int n = 0;
			No aux = inicio;
			
			for(int i= 0; i < tamanho; i++){
				if(aux.getConteudo().startsWith(s)){
					n++;
				}
				aux = aux.getProx();
			}
			return n;
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		int x,y,i,j;
		String prefixo;
		String z;
		String aux;
		BufferedReader in = new BufferedReader(
				new InputStreamReader(System.in));
		
		z = in.readLine();
		String[] partes = z.split(" ");
		x = Integer.parseInt(partes[0]);
		y = Integer.parseInt(partes[1]);
		
		Listas TODO = new Listas(x);

		for(i = 0; i < x; i++){
			aux = in.readLine();
			TODO.insere(aux);
		}

        for(i = 0; i < y; i++){
            prefixo = in.readLine();

            j = TODO.buscar(prefixo);
            System.out.println(j);
        }
	}

}
