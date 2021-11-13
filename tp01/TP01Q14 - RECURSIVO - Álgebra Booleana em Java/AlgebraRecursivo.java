public class AlgebraRecursivo{
  
  
  public static void main(String[]args) {
    ler();
  }

  public static void ler(){
    int i = MyIO.readInt();
    while(i != 0){
      int[] valores = criaArranjo(i);
      String expressao = MyIO.readLine();
      String expressao2 = alterLetra(expressao, valores);
      MyIO.println(resolve(expressao2));
      i = MyIO.readInt();
    }
  }

  
  public static int[] criaArranjo(int i){
    int vetor[] = new int[i];
    for(int x = 0; x < i; x++){
      vetor[x] = MyIO.readInt();
    }
    return vetor;
  }

 
  public static String alterLetra(String expressao,int valores[]){
    String r = "";
    for(int i = 0; i < expressao.length(); i++){
      int c = 0;
      while(c < valores.length && (char)('A' + c) != expressao.charAt(i)){
        c++;
      }
      if(c >= valores.length){
        r+= expressao.charAt(i);
      }
      else{
        r+= (char)(valores[c] + '0');
      }
    }
    return r;
  }

  
  public static char resolve(String expressao2){
    String[] opcoes = {
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

    String[] opcoes2 = {
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

    while(expressao2.charAt(0) != '0' && expressao2.charAt(0) != '1'){
      for(int i = 0; i < opcoes.length; i++){
        expressao2 = sub(expressao2, opcoes[i], opcoes2[i]);
      }
    }
    return expressao2.charAt(0);
  }
  public static String sub(String frase, String procura, String lugar){
    String nova = "";
    for(int i = 0; i < frase.length(); i ++){
      if(iguais(frase, procura, i)){
        nova += lugar;
        i += procura.length() - 1;
      }
      else {
        nova += frase.charAt(i);
      }
    }
    return nova;
  }

  public static boolean iguais(String frase, String procura, int i){
    boolean is = false;
    int j = i;
    if(frase.length() - i >= procura.length() && frase.charAt(i) == procura.charAt(0)){

      while(j < frase.length() && j - i < procura.length() && frase.charAt(j) == procura.charAt(j - i)){
        j++;
      }
      is = (j-i) >= procura.length();
    }
    return is;
  }
  
}