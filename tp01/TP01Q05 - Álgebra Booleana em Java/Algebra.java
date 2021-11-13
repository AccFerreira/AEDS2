public class Algebra{

    final static String[] op1 ={
    " ",
    "not(0)",
    "not(1)",
    "and(0,0)",
    "and(1,1)",
    "and(0,1)",
    "and(1,0)",
    "and(0,0,",
    "and(1,1,",
    "and(0,1,",
    "and(1,0,",
    "or(0,0)",
    "or(1,1)",
    "or(0,1)",
    "or(1,0)",
    "or(0,0,",
    "or(1,1,",
    "or(0,1,",
    "or(1,0,"
    };

    final static String[] op2 ={
    "",
    "1",
    "0",
    "0",
    "1",
    "0",
    "0",
    "and(and(0,0),",
    "and(and(1,1),",
    "and(and(0,1),",
    "and(and(1,0),",
    "0",
    "1",
    "1",
    "1",
    "or(or(0,0),",
    "or(or(1,1),",
    "or(or(0,1),",
    "or(or(1,0),"
    };

  //main do programa que chama o metodo ler
  public static void main(String[]args){
    ler();
  }

  //metodo que controla a condicao de parada do programa e tambem chama os demais metodos
  public static void ler(){
    int i = MyIO.readInt();
    if(i == 0){
      return;
    }
    else{
      int[] vetor = new int[i];
      int[] valores = criarArranjo(i,vetor);
      String e1 = MyIO.readLine();
      String e2 = alterLetra(e1, valores);
      MyIO.println(resolve(e2));
      ler();
    }
  }

  //metodo que cria e retorna um arranjo com o as entradas da expressao booleana
  public static int[] criarArranjo(int i, int vetor[]){
    return criarArranjo(i,vetor,0);
  }

  
  //metodo que cria e retorna um arranjo com o as entradas da expressao booleana
  public static int[] criarArranjo(int i,int vetor[], int j){
    if(j < i){
      vetor[j] = MyIO.readInt();
      criarArranjo(i,vetor,j + 1);
    }
    return vetor;
  }

  //metodo para alterar letra
  public static String alterLetra(String e1,int valores[]){
    return alterLetra(e1,valores,0);
  }

  
  //metodo que substitui as letras por 0 ou 1 dependendo da expressao booleana
  public static String alterLetra(String e1,int valores[], int i){
    String r = "";
    if(i >= e1.length()){
      return r;
    }
    else{
      r += alterLetra2(e1,valores,i);
      r += alterLetra(e1,valores, i + 1);
    }
    return r;
  }

  
  //metodo auxiliar do metodo alterLetra2
  public static char alterLetra2(String e1,int valores[],int i){
    return alterLetra2(e1,valores,i,0);
  }

  
  //metodo auxiliar do metodo alterLetra2
  public static char alterLetra2(String e1,int valores[],int i,int c){
    char letra;
    if(c >= valores.length){
      letra = e1.charAt(i);
    }
    else if((char)('A' + c) == e1.charAt(i)){
      letra = (char)(valores[c] + '0');
    }
    else{
      letra = alterLetra2(e1,valores,i,c + 1);
    }
    return letra;
  }

  //metodo que resolve e retorna o valor final da expressao booleana
  public static char resolve(String e2){
    if(e2.charAt(0) == '0' || e2.charAt(0) == '1'){
      return e2.charAt(0);
    }
    else{
      e2 = resolve2(e2);
    }
    return resolve(e2);
  }

  //metodo auxiliar do metodo resolve
  public static String resolve2(String e2){
    return resolve2(e2,0);
  }

  //metodo auxiliar do metodo resolve
  public static String resolve2(String e2, int i){
    if(i >= op1.length){
      return e2;
    }
    else{
      e2 = sub(e2, op1[i], op2[i]);
    }
    return resolve2(e2,i + 1);
  }

  
  //metodo que substitui a expressao booleana por seu resultado
  public static String sub(String frase, String procurando, String lugar){
    return sub(frase,procurando,lugar,0);
  }

  //metodo que substitui a expressao booleana por seu resultado
  public static String sub(String frase, String procurando, String lugar, int i) {
        String nova = "";
        if (i >= frase.length()) {
            nova = "";
        }
        else if (saoIguais(frase, procurando, i)) {
            nova += lugar;
            i += procurando.length() - 1;
            nova += sub(frase, procurando, lugar, i + 1);
        }
        else {
            nova += frase.charAt(i);
            nova += sub(frase, procurando, lugar, i + 1);
        }
        return nova;
    }

  //metodo que verifica se a String frase possui em sua composicao a String procurando
  public static boolean saoIguais(String frase, String procurando, int i){
    boolean t = false;
    int j = i;
    if(frase.length()-i >= procurando.length() && frase.charAt(i) == procurando.charAt(0)){
      j += saoIguais2(frase,procurando,i,j);
      t = (j-i) >= procurando.length();
    }
    return t;
  }

  //metodo auxiliar do metodo saoIguais
  public static int saoIguais2(String frase, String procurando, int i,int j){
    int c;
    if(!(j < frase.length() && j-i < procurando.length() && frase.charAt(j) == procurando.charAt(j-i))){
      c = 0;
    }
    else {
      c = 1 + saoIguais2(frase,procurando,i,j + 1);
    }
    return c;
  }
  
}
