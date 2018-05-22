

import java.io.*;

public class Main {
	
	static class No {
		protected char conteudo;
		protected No e; // esquerda
		protected No d; // direita
		
		public No(char conteudo){
			this.conteudo = conteudo;
			e = null;
			d = null;
		}
	}
	
	static class Arvore{
		protected No raiz;
		protected No aux;
		protected int indice = 0;
		
		public Arvore(){
			raiz = null;
		}
		
		public void inserir(char c[]){
			No novoNo = new No(c[indice]);
			raiz = novoNo;
			
			if(c[indice] == 'n'){
				novoNo.e = addFolha(raiz, c[++indice], c);
				novoNo.d = addFolha(raiz, c[++indice], c);
			}
		}
		
		public No addFolha(No pai, char conteudo, char c[]){
			No aux = new No(conteudo);
			
			if(conteudo == 'n'){
				aux.e = addFolha(aux, c[++indice], c);
				aux.d = addFolha(aux, c[++indice], c);
				
			}
			return aux;
		}
		
		public int getProfundidade(No n){
			if(n.conteudo == 'l'){
				return 0;
			}
			
			int eProfundidade = getProfundidade(n.e);
			int dProfundidade = getProfundidade(n.d);
			
			if(eProfundidade > dProfundidade){
				return ++eProfundidade;
			}else {
				return ++dProfundidade;
			}
		}
	}
	public static void main(String[] args) throws IOException{
			try{
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				
				int length = Integer.parseInt(in.readLine());
				int output[] = new int[length];
				
				for(int i = 0; i < length; i++){
					String aux = in.readLine();
					char letters[] = aux.toCharArray();
					Arvore a = new Arvore();
					a.inserir(letters);
					output[i] = a.getProfundidade(a.raiz);
				}
				
				for(int i = 0; i < length; i++){
					System.out.println(output[i]);
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
	}
}
