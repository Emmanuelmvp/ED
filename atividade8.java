//package ListaSequencial;

import java.io.*;

public class Main {

    static Arvore raiz;
    static int count = 0;

    public static Arvore add_util(Arvore no, int valor) {
        if(no == null){
            no = new Arvore(valor);
            return no;
        }
        count++;
        if (valor < no.getValor()) {
                no.setE(add_util(no.getE(), valor));
            } else if (valor > no.getValor()) {
                no.setD(add_util(no.getD(), valor));
            }
        return no;
    }

    public static void add(int valor) {
        raiz = add_util(raiz, valor);
    }

    public static void print_in_order(Arvore raiz) {
        if (raiz != null) {
            print_in_order(raiz.getE());
            System.out.print(raiz.getValor() + " ");
            print_in_order(raiz.getD());
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            add(Integer.parseInt(bufferedReader.readLine()));
            System.out.println(count);
        }
    }


}

class Arvore {
    private int valor;
    private Arvore e;
    private Arvore d;

    public Arvore(int valor) {
        this.valor = valor;
        this.e = null;
        this.d = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Arvore getE() {
        return e;
    }

    public void setE(Arvore e) {
        this.e = e;
    }

    public Arvore getD() {
        return d;
    }

    public void setD(Arvore d) {
        this.d = d;
    }
}