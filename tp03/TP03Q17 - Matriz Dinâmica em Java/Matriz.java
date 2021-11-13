/* BIBLIOTECAS */
import java.text.ParseException;
import java.io.*;

/* =============================== CLASSE CELULA =============================== */

class Celula {
    public int elemento;
    public Celula inf, sup, esq, dir;
 
    public Celula(){
        this(0);
    }
 
    public Celula(int elemento){
        this(elemento, null, null, null, null);
    }
 
    public Celula(int elemento, Celula inf, Celula sup, Celula esq, Celula dir){
        this.elemento = elemento;
        this.inf = inf;
        this.sup = sup;
        this.esq = esq;
        this.dir = dir;
    }
}
 
/* =============================== CLASSE MATRIZ =============================== */

public class Matriz {
    private Celula inicio;
    private int linha, coluna;
 
    public Matriz (){
    }
 
    public Matriz (int linha, int coluna, int elemento){ //alocar a matriz com this.linha linhas e this.coluna colunas
        this.linha = linha;
        this.coluna = coluna;
        inicio = new Celula(elemento);
    }
 
 
    /* public Matriz soma (Matriz m) {
        Matriz resp = null;
        
        if(this.linha == m.linha && this.coluna == m.coluna){
           resp = new Matriz(this.linha, this.coluna);
           for(int i = 0; i < linha; i++){
                for(int j = 0; j < coluna; j++){
                   //sendo c (pont em resp), a (em this) e b (em m)
                   c.elemento = a.elemento + b.elemento;
                }
            }
        }
       
        return resp;
    }
 
    public Matriz multiplicacao (Matriz m) {
        Matriz resp = null;
        
        if(){
           //...
        }
       
        return resp;
    }
 
    public boolean isQuadrada(){
        boolean (this.linha == this.coluna);
    }
 
    public void mostrarDiagonalPrincipal (){
        if(isQuadrada() == true){
 
        }
    }
 
    public void mostrarDiagonalSecundaria (){
        if(isQuadrada() == true){
        }
    } */

    public static void completarMatriz(int[][] matriz1, Matriz matriz){
        for(int i = 0; i < matriz.coluna; i++){
            matriz.inicio.dir = new Celula(matriz1[0][i]);
        }
    }

    public static int[][] leituraPubIn(int numLinhas, int numColunas){
        String[][] aux = new String[numLinhas][numColunas];
        int[][] matriz = new int[numLinhas][numColunas];
        for(int i = 0; i < numLinhas; i++){
            String linha = MyIO.readLine();
            aux[i] = linha.split(" ");
        }
        for(int i = 0; i < numLinhas; i++){
            for(int j = 0; j < numColunas; j++){
                matriz[i][j] = Integer.parseInt(aux[i][j]); 
            }
        }
        return matriz;
    }

    public static void main(String[] args)throws ParseException{
        int numTestes = MyIO.readInt();
        int[][] matriz1, matriz2;
        Celula celula;
        int numLinhas = 0, numColunas = 0;
        int i = 0;
        while(i < numTestes){
            numLinhas = MyIO.readInt();
            numColunas = MyIO.readInt();
            matriz1 = leituraPubIn(numLinhas, numColunas);
            Matriz matriz = new Matriz(numLinhas, numColunas, matriz1[0][0]);
            completarMatriz(matriz1, matriz);
        
            numLinhas = MyIO.readInt();
            numColunas = MyIO.readInt();
            matriz2 = leituraPubIn(numLinhas, numColunas);
            i++;
        }
    }
}
 

/*
 * [X] Primeiro Passo: Tratar a entrada por completo e testar
 * [] Segundo Passo: Inserir os elementos na celula e testar
 * [] Terceiro Passo: Implementar o método de soma e testar
 * [] Quarto Passo: Implementar o método de multiplicação e testar
 * [] Quinto Passo: Implementar o método de mostrar diagonal principal e testar
 * [] Sexto Passo: Implementar o método de mostrar diagonal secundaria e testar
 * [] Setimo Passo: Analisar a Saida e fazer a chamada correta dos metodos
 */ 