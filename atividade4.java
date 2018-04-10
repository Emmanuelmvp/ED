package ListaSequencial;

import java.io.*;
import java.util.*;

public class Main {
	static class Pilha{
		private int topo = -1;
		private char[] pilha = new char[400];
		
		public void push(char data){
			pilha[++topo]=data;
		}
		
		public char pop(){
			char valor = pilha[topo];
			topo--;
			return valor;
		}
	}
	
	public static void main(String[] args){
		int i,j = 0;
		
		try{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int quantidade = Integer.parseInt(in.readLine());
			String letra [] = new String[quantidade];
			
			for(i= 0; i < quantidade; i++){
				letra[i] ="";
				String aux = in.readLine();
				int tamanho = aux.length();
				
				char[] caracter = aux.toCharArray();
				Pilha pilha = new Pilha();
				
				for(j =0; j< tamanho; j++){
					if(Character.isAlphabetic(caracter[j])){
						letra[i] += caracter[j];
						
					}else if(caracter[j] == '('){
						pilha.push('(');
						
					}else if(caracter[j] == ')'){
						while(pilha.pilha[pilha.topo] != '('){
							letra[i] += pilha.pop();
						}
						
						pilha.pop();
						
					}else if(caracter[j] == '^'){
						while(pilha.pilha[pilha.topo] == '^'){
							letra[i] += pilha.pop();
						}
						
						pilha.push(caracter[j]);
						
					}else if(caracter[j] == '/' || caracter[j] == '*'){
						while(pilha.pilha[pilha.topo] == '/' || pilha.pilha[pilha.topo] == '*' || pilha.pilha[pilha.topo] == '^'){
							letra[i] += pilha.pop();
						}
						
						pilha.push(caracter[j]);
						
					}else if(caracter[j] == '+' || caracter[j] == '-'){
						while(pilha.pilha[pilha.topo] != '('){
							letra[i] += pilha.pop();
						}
						
						pilha.push(caracter[j]);
					}
				}
			}
			
			for(i = 0; i < quantidade; i++){
				System.out.println(letra[i]);
			}
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}

}
