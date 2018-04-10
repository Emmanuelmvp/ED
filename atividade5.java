package ListaSequencial;

import java.io.*;

public class Main {
	
	static class No{
        private int conteudo;
        private No prox;
        private No ant;

	public No(){
            setProx(null);
            setAnt(null);
	}

	public int getConteudo() {
            return conteudo;
	}

	public void setConteudo(int conteudo) {
            this.conteudo = conteudo;
	}

	public No getProx() {
            return prox;
	}

	public void setProx(No prox) {
            this.prox = prox;
	}
        
        public No getAnt() {
            return ant;
        }

        public void setAnt(No ant) {
            this.ant = ant;
        }
    }
    
    static class Fila{
        private No inicio;
        private No fim;
        private int nElementos;
        private boolean reversed = false;
        
        public Fila() {
            inicio = null;
            fim = null;
            nElementos = 0;
	}
        
        public void command(String s){
            String[] parts = s.split(" ");
            
            if(parts[0].equals("back")){
                removeBack();
            }
            if(parts[0].equals("front")){
                removeFront();
            }
            if(parts[0].equals("reverse")){
                reverse();
            }
            if(parts[0].equals("push_back")){
                pushBack(parts[1]);
            }
            if(parts[0].equals("toFront")){
                pushFront(parts[1]);
            }
        }
        
        public void pushFront(String s){
            int numb = Integer.parseInt(s);
            No novoNo = new No();
            novoNo.setConteudo(numb);
            
            if(reversed){
                reverse();
                pushBack(s);
                reverse();
            }else{
                if(nElementos == 0){
                    inicio = novoNo;
                    fim = novoNo;
                }else{
                    inicio.setAnt(novoNo);
                    novoNo.setProx(inicio);
                    inicio = novoNo;
                }
            
                nElementos++;
            }
        }
        
        public void pushBack(String s){
            int numb = Integer.parseInt(s);
            No novoNo = new No();
            novoNo.setConteudo(numb);
            
            if(reversed){
                reverse();
                pushFront(s);
                reverse();
            }else{
                if(nElementos == 0){
                    inicio = novoNo;
                }else{
                    novoNo.setAnt(fim);
                    fim.setProx(novoNo);
                }

                fim = novoNo;
                nElementos++;
            }
        }
        
        public void removeFront(){
            
            if(reversed){
                reverse();
                removeBack();
                reverse();
            }else{
            
                if(nElementos == 0){
                    System.out.println("No job for Ada?");
                }else{
                    int aux = inicio.getConteudo();
                    No p = inicio;

                    if(inicio == fim){
                        inicio = null;
                        fim = null;
                    }else{
                        inicio = p.getProx();
                        p.setProx(null);
                        inicio.setAnt(null);
                    }

                    p = null;
                    nElementos--;
                    System.out.println(aux);
                }
            }
        }
            
        public void removeBack(){
            
            if(reversed){
                reverse();
                removeFront();
                reverse();
            }else{
            
                if(nElementos == 0){
                    System.out.println("No job for Ada?");
                }else{
                    int aux = fim.getConteudo();
                    No p = fim;

                    if(inicio == fim){
                        inicio = null;
                        fim = null;
                    }else{
                        fim = p.getAnt();
                        fim.setProx(null);
                    }

                    p = null;
                    nElementos--;
                    System.out.println(aux);
                }
            }
        }
        
        public void reverse(){
           if(nElementos == 0) return;
           
           No aux = inicio;
           inicio = fim;
           fim = aux;
           reversed =  !reversed;
           
        }
    }
    
    public static void main(String[] args) throws IOException{
        try{
            
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(System.in));
            Fila queue = new Fila();
            int length = Integer.parseInt(in.readLine());
            
            for(int i = 0; i < length; i++){
                String a = in.readLine();
                queue.command(a);
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}