/* BIBLIOTECA */
import java.text.ParseException;
import java.io.*;

class Celula {
	public Serie elemento; // Elemento inserido na celula
	public Celula prox; // Aponta a celula prox

    public Celula(){
    }

	//Construtor da classe
	public Celula(Serie elemento) {
      	this.elemento = elemento;
      	this.prox = null;
	}
}

class Lista {
	private Celula primeiro;
	private Celula ultimo;

    //Construtor da classe que cria uma lista sem elementos (somente no cabeca).
	public Lista() {
		primeiro = new Celula();
		ultimo = primeiro;
	}

    public void inserirInicio(Serie x) {
		Celula tmp = new Celula(x);
        tmp.prox = primeiro.prox;
		primeiro.prox = tmp;
		if (primeiro == ultimo) {                 
			ultimo = tmp;
		}
        tmp = null;
	}

	public void inserirFim(Serie x) {
		ultimo.prox = new Celula(x);
		ultimo = ultimo.prox;
	}

	public Serie removerInicio() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		}

        Celula tmp = primeiro;
		primeiro = primeiro.prox;
		Serie resp = primeiro.elemento;
        tmp.prox = null;
        tmp = null;
		return resp;
	}

	public Serie removerFim() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		} 

		// Caminhar ate a penultima celula:
        Celula i;
        for(i = primeiro; i.prox != ultimo; i = i.prox);

        Serie resp = ultimo.elemento; 
        ultimo = i; 
        i = ultimo.prox = null;
      
		return resp;
	}

    public void inserir(Serie x, int pos) throws Exception {
        int tamanho = tamanho();

        if(pos < 0 || pos > tamanho){
			throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
        } else if (pos == 0){
            inserirInicio(x);
        } else if (pos == tamanho){
            inserirFim(x);
        } else {
		    // Caminhar ate a posicao anterior a insercao
            Celula i = primeiro;
            for(int j = 0; j < pos; j++, i = i.prox);
		
            Celula tmp = new Celula(x);
            tmp.prox = i.prox;
            i.prox = tmp;
            tmp = i = null;
        }
    }

	public Serie remover(int pos) throws Exception {
        Serie resp;
        int tamanho = tamanho();

		if (primeiro == ultimo){
			throw new Exception("Erro ao remover (vazia)!");
        } else if(pos < 0 || pos >= tamanho){
			throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
        } else if (pos == 0){
            resp = removerInicio();
        } else if (pos == tamanho - 1){
            resp = removerFim();
        } else {
		    // Caminhar ate a posicao anterior a insercao
            Celula i = primeiro;
            for(int j = 0; j < pos; j++, i = i.prox);
		
            Celula tmp = i.prox;
            resp = tmp.elemento;
            i.prox = tmp.prox;
            tmp.prox = null;
            i = tmp = null;
        }
		return resp;
	}

	public void mostrar() {
		for (Celula i = primeiro.prox; i != null; i = i.prox) {
			i.elemento.imprimir();
		}
	}

    public int tamanho() {
        int tamanho = 0; 
        for(Celula i = primeiro; i != ultimo; i = i.prox, tamanho++);
        return tamanho;
    }
}

public class Serie{
	final static int tamPubIn = 100;
	final static int tamHtml = 100;
	final static int tamLinha = 10000;
	static int tam1 = 0;
	static int tam2 = 0;

	/* ATRIBUTOS */
	private String nome;
  	private String formato;
  	private String duracao;
  	private String paisDeOrigem;
  	private String idiomaOriginal;
 	private String emissoraOriginal;
  	private String transmissaoOriginal;
  	private int numTemporadas;
  	private int numEpisodios;

  	/* CONSTRUTOR PADRAO(PRIMARIO) */
  	public Serie(){
		this.nome = "";
		this.formato = "";
		this.duracao = "";
		this.paisDeOrigem = "";
		this.idiomaOriginal = "";
		this.emissoraOriginal = "";
		this.transmissaoOriginal = "";
		this.numTemporadas = 0;
		this.numEpisodios = 0;
  }

  /* CONSTRUTOR COM PARAMETROS(SECUNDARIO) */
  public Serie(String nome, String formato, String duracao, String paisDeOrigem, String idiomaOriginal, String emissoraOriginal, String transmissaoOriginal, int numTemporadas, int numEpisodios){
		super();
		this.nome = nome;
		this.formato = formato;
		this.duracao = duracao;
		this.paisDeOrigem = paisDeOrigem;
		this.idiomaOriginal = idiomaOriginal;
		this.emissoraOriginal = emissoraOriginal;
		this.transmissaoOriginal = transmissaoOriginal;
		this.numTemporadas = numTemporadas;
		this.numEpisodios = numEpisodios;
	}

  	/* GETS E SETS */
  	public String getNome(){
		return nome;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getFormato(){
		return formato;
	}
	public void setFormato(String formato){
		this.formato = formato;
	}
	public String getDuracao(){
		return duracao;
	}
	public void setDuracao(String duracao){
		this.duracao = duracao;
	}
	public String getPaisDeOrigem(){
		return paisDeOrigem;
	}
	public void setPaisDeOrigem(String paisDeOrigem){
		this.paisDeOrigem = paisDeOrigem;
	}
	public String getIdiomaOriginal(){
		return idiomaOriginal;
	}
	public void setIdiomaOriginal(String idiomaOriginal){
		this.idiomaOriginal = idiomaOriginal;
	}
	public String getEmissoraOriginal(){
		return emissoraOriginal;
	}
	public void setEmissoraOriginal(String emissoraOriginal){
		this.emissoraOriginal = emissoraOriginal;
	}
	public String getTransmissaoOriginal(){
		return transmissaoOriginal;
	}
	public void setTransmissaoOriginal(String transmissaoOriginal){
		this.transmissaoOriginal = transmissaoOriginal;
	}
	public int getNumTemporadas(){
		return numTemporadas;
	}
	public void setNumTemporadas(int numTemporadas){
		this.numTemporadas = numTemporadas;
	}
	public int getNumEpisodios(){
		return numEpisodios;
	}
	public void setNumEpisodios(int numEpisodios){
		this.numEpisodios = numEpisodios;
	}

	/* METODO CLONE */
	public Serie cloneSerie(){
		Serie cloneSerie = new Serie();
		cloneSerie.nome = nome;
		cloneSerie.formato = formato;
		cloneSerie.duracao = duracao;
		cloneSerie.paisDeOrigem = paisDeOrigem;
		cloneSerie.idiomaOriginal = idiomaOriginal;
		cloneSerie.emissoraOriginal = emissoraOriginal;
		cloneSerie.transmissaoOriginal = transmissaoOriginal;
		cloneSerie.numTemporadas = numTemporadas;
		cloneSerie.numEpisodios = numEpisodios;
		return cloneSerie;
	}

	/* METODO PARA CONFERIR SE CHEGOU AO FIM DO ARQUIVO */
	public static boolean conferirFim(String linha){ /* CONDIïż½ïż½O DE PARADA */
		boolean resp;
		if(linha.length()==3 && linha.charAt(0)=='F' && linha.charAt(1)=='I' && linha.charAt(2)=='M'){
			resp = true;
		}else{
			resp = false;
		}
		return resp;
	}
	
	/* METODO PARA IMPRIMIR VALORES NA ORDEM CORRRETA SEGUNDO O PUB.OUT */
	public Serie[] imprimir(){
		Serie[] S = new Serie[tamPubIn];
		MyIO.println(nome + " " + formato + " " + duracao + " " + paisDeOrigem + " " +
		idiomaOriginal + " " + emissoraOriginal + " " + transmissaoOriginal + " " + numTemporadas + " " + numEpisodios );

		return S;
	}
	
	/* MÉTODO PARA VERIFICAR SE É UMA LETRA OU NUMERO */
	public static boolean isLetraOrNumber(char a) {
    	return (a >= '!' || a >= 'a' && a <= 'z' || a >= 'A' && a <= 'Z' || a >= '0' && a <= '9' || a == ')' || a == '(' || a == '-' || a == ';');
  	}
  	
  	/* METODO PARA ENCONTRAR O ATRIBUTO NOME */
  	public static String encontrarNome (String[] linha){
  		String nome = "";
  		for(int i = 2; i < linha.length; i = i+2){
  			if(!linha[i].equals("") && isLetraOrNumber(linha[i].charAt(0))){
  				nome = nome + "" + linha[i] + "";	
  			}
  		}
  		return nome;
  	}
  	
  	/* METODO PARA ENCONTRAR O ATRIBUTO FORMATO */
  	public static String encontrarFormato (String[] linha){
  		String formato = "";
  		for(int i = 2; i < linha.length; i = i+2){
  			if(!linha[i].equals("") && isLetraOrNumber(linha[i].charAt(0))){
  				formato = formato + "" + linha[i] + "";	
  			}
  		}
  		return formato;
  	}
  	
  	/* METODO PARA ENCONTRAR O ATRIBUTO DURACAO */
  	public static String encontrarDuracao (String[] linha){
  		String duracao = "";
  		for(int i = 2; i < linha.length; i = i+2){
  			if(!linha[i].equals("") && isLetraOrNumber(linha[i].charAt(0))){
  				duracao = duracao + "" + linha[i] + "";	
  			}
  		}
  		return duracao;
  	}
  	
  	/* METODO PARA ENCONTRAR O ATRIBUTO PAIS DE ORIGEM */
  	public static String encontrarPaisDeOrigem (String[] linha){
  		String paisDeOrigem = "";
  		for(int i = 2; i < linha.length; i = i+2){
  			if((!linha[i].equals("") && isLetraOrNumber(linha[i].charAt(0))) || (linha[i].length() >= 1 && linha[i].charAt(0) == ' ')){
  				if(!linha[i].equals("&#160;") && !linha[i].equals("&nbsp;")){
  					paisDeOrigem = paisDeOrigem + "" + linha[i] + "";	
  				}
  			} 
  		}
  		return paisDeOrigem;
  	}
  	
  	/* METODO PARA ENCONTRAR O ATRIBUTO IDIOMA ORIGINAL */
  	public static String encontrarIdiomaOriginal (String[] linha){
  		String idiomaOriginal = "";
  		for(int i = 2; i < linha.length; i = i+2){
  			if((!linha[i].equals("") && isLetraOrNumber(linha[i].charAt(0))) || (linha[i].length() > 4 && linha[i].charAt(0) == ' ')){
  				idiomaOriginal = idiomaOriginal + "" + linha[i] + "";	
  			}
  		}
  		return idiomaOriginal;
  	}
  	
  	/* METODO PARA ENCONTRAR O ATRIBUTO EMISSORA ORIGINAL */
  	public static String encontrarEmissora (String[] linha){
  		String emissora = "";
  		for(int i = 2; i < linha.length; i = i+2){
  			if(!linha[i].equals("") && !linha[i].equals(" ") && isLetraOrNumber(linha[i].charAt(0))){
  				emissora = emissora + "" + linha[i] + "";
  			} else if(linha.length > 6 && linha[7].equals("br /")){
  				emissora = emissora + "" + linha[i] + "";
  			} else if(linha.length > 12 && linha[13].equals("br /") && !linha[i].equals(" ")){
  				emissora = emissora + "" + linha[i] + "";
  			}
  		}
  		return emissora;
  	}
  	
  	/* METODO PARA ENCONTRAR O ATRIBUTO TRANSMISSAO ORIGINAL */
  	public static String encontrarTransmissaoOriginal (String[] linha){
  		String transmissao = "";
  		for(int i = 2; i < linha.length; i = i+2){
			linha[i] = linha[i].replace("&#160;(","(");
			linha[i] = linha[i].replace("&nbsp;(","(");
			linha[i] = linha[i].replace(" – ","!");
			linha[i] = linha[i].replace(" - ",";");
			if(linha[i].equals(" de ") || (!linha[i].equals("") && isLetraOrNumber(linha[i].charAt(0)))){
				linha[i] = linha[i].replace("!"," – ");
				linha[i] = linha[i].replace(";"," - ");
				transmissao = transmissao + "" + linha[i] + "";	
			}
  		}
  		return transmissao;
  	}
   	
	/* METODO NECESSERIO PARA FAZER A LEITURA DO HTML */
  	public static Serie leituraHtml(String linhasPubIn) throws IOException {
    	Serie s = new Serie();
    	String linha = new String();
    	String[] aux2 = new String[100];
    	String aux1 = new String();
  		String aux3 = new String();  
		Arq.openRead("/tmp/series/" + linhasPubIn, "UTF-8");
    	FileReader fileReader = new FileReader("/tmp/series/" + linhasPubIn);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
    	while((linha = bufferedReader.readLine()) != null) {
			if(linha.contains("firstHeading") == true){
				aux1 = linha.replace(">","<");
				aux2 = aux1.split("<");
				s.nome = encontrarNome(aux2);
			} else if(linha.contains("<tr>") == true || linha.contains("<tbody><tr>") == true){ 
				linha = bufferedReader.readLine(); 
				if(linha.contains("Formato</td>") == true){
					linha = bufferedReader.readLine(); 
					aux1 = linha.replace(">","<");
					aux2 = aux1.split("<");
					s.formato = encontrarFormato(aux2);
				} else if(linha.contains("Duração") == true){
					linha = bufferedReader.readLine(); 
					aux1 = linha.replace(">","<");
					aux2 = aux1.split("<");
					s.duracao = encontrarDuracao(aux2);
				} else if(linha.contains("País de origem") == true){
					linha = bufferedReader.readLine(); 
					aux1 = linha.replace(">","<");
					aux2 = aux1.split("<");
					s.paisDeOrigem = encontrarPaisDeOrigem(aux2);
				} else if(linha.contains("Idioma original") == true){
					linha = bufferedReader.readLine(); 
					aux1 = linha.replace(">","<");
					aux2 = aux1.split("<");
					s.idiomaOriginal = encontrarIdiomaOriginal(aux2);
				} else if(linha.contains("Emissora de televisão original") == true){
					linha = bufferedReader.readLine(); 
					aux1 = linha.replace(">","<");
					aux2 = aux1.split("<");
					s.emissoraOriginal = encontrarEmissora(aux2);
				} else if(linha.contains("Transmissão original") == true){
					linha = bufferedReader.readLine(); 
					aux1 = linha.replace(">","<");
					aux2 = aux1.split("<");
					s.transmissaoOriginal = encontrarTransmissaoOriginal(aux2);
				} else if(linha.contains("N.º de temporadas") == true){
					linha = bufferedReader.readLine(); 
					aux1 = linha.replace(">","<");
					aux3 = aux1.replace(" ", "<");
					aux2 = aux3.split("<");
					s.numTemporadas = Integer.parseInt(aux2[6]);
				} else if(linha.contains("N.º de episódios") == true){
					linha = bufferedReader.readLine(); 
					aux1 = linha.replace(">","<");
					aux3 = aux1.replace(" ", "<");
					aux2 = aux3.split("<");
					s.numEpisodios = Integer.parseInt(aux2[6]);
				} 
			}
		}
    	//s.imprimir();  
    	bufferedReader.close(); 
    	Arq.close();
    	return s;
	}
	
	/* METODO NECESSARIO PARA FAZER A LEITURA DO PUB.IN */
  	public static String[] leituraPubIn(int i){
    	String[] linhas = new String[tamPubIn];
    	if(i == 1){ 
      		linhas[tam1] = MyIO.readLine();
      		while(conferirFim(linhas[tam1]) == false){ /* LEITURA DO ARQUIVO ENQUANTO ESSE Nïż½O CHEGAR NO FIM */
				tam1++;
     	 		linhas[tam1] = MyIO.readLine();
			}
		} else {
			tam2 = MyIO.readInt();
			int j = 0;
        	while(j < tam2){ /* LEITURA DO ARQUIVO ENQUANTO ESSE Nïż½O CHEGAR NO FIM */
          		linhas[j] = MyIO.readLine();
			 	j++;
			}
		}
		return linhas;
	}
	
	/* MAIN DO CODIGO QUE CHAMA OS METODOS */
	public static void main(String[] args)throws Exception{
		MyIO.setCharset("UTF-8");
		Serie[] S = new Serie[tamPubIn];
		String[] linhasPubIn = leituraPubIn(1);
		String[] linhasLista = leituraPubIn(2); 
		Serie[] linhasRemovidas = new Serie[100];
		Serie[] serie = new Serie[tam1];
		int i = 0, pos = 0, j = 0;
		try {
			while(i < tam1){
				serie[i] = leituraHtml(linhasPubIn[i]);
				i++;
			}
		}catch(IOException e) {
  			e.printStackTrace();
		}
    	Lista listaSeries = new Lista();
		for(i = 0; i < tam1; i++){
			listaSeries.inserirFim(serie[i]);	
		}
		i = 0;
		String[] aux = new String[5];
		while(i < tam2){
			aux = linhasLista[i].split(" ");
			if(aux[0].compareTo("II") == 0){
				listaSeries.inserirInicio(leituraHtml(aux[1]));
			} else if(aux[0].compareTo("IF") == 0){
				listaSeries.inserirFim(leituraHtml(aux[1]));
			} else if(aux[0].compareTo("I*") == 0){
				pos = Integer.parseInt(aux[1]);
				listaSeries.inserir(leituraHtml(aux[2]), pos);
			} else if(aux[0].compareTo("RI") == 0){
				linhasRemovidas[j] = listaSeries.removerInicio();
				j++;
			} else if(aux[0].compareTo("RF") == 0){
				linhasRemovidas[j] = listaSeries.removerFim();
				j++;
			} else if(aux[0].compareTo("R*") == 0){
				pos = Integer.parseInt(aux[1]);
				linhasRemovidas[j] = listaSeries.remover(pos);
				j++;
			} 
			i++;	
		}
		for(i = 0; i < j; i++){
			MyIO.println("(R) " + linhasRemovidas[i].getNome());
		}
		listaSeries.mostrar();
	}
}

