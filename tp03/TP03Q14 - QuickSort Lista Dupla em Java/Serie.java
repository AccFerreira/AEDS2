/* BIBLIOTECA */
import java.text.ParseException;
import java.io.*;

public class Serie{
	final static int tamPubIn = 100;
	final static int tamHtml = 100;
	final static int tamLinha = 10000;
	static int tam = 0;
	static int numComparacoes = 0;
    static int numMovimentacoes = 0;

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
		Arq.openRead("../series/" + linhasPubIn, "UTF-8");
    	FileReader fileReader = new FileReader("../series/" + linhasPubIn);
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

    public static ListaDupla quicksort(ListaDupla listaSeries, int esq, int dir) {
        int i = esq, j = dir;
        CelulaDupla pivo = listaSeries.getCelula(((dir+esq)/2)+1);
        while (i <= j) {
            numComparacoes++;
            while ((listaSeries.getCelula(i).elemento.getPaisDeOrigem().compareTo(pivo.elemento.getPaisDeOrigem()) < 0) || (listaSeries.getCelula(i).elemento.getPaisDeOrigem().compareTo(pivo.elemento.getPaisDeOrigem()) == 0 && listaSeries.getCelula(i).elemento.getNome().compareTo(pivo.elemento.getNome()) < 0)){
                i++;
                numComparacoes++;
            }
            numComparacoes++;
            while ((listaSeries.getCelula(j).elemento.getPaisDeOrigem().compareTo(pivo.elemento.getPaisDeOrigem()) > 0) || (listaSeries.getCelula(j).elemento.getPaisDeOrigem().compareTo(pivo.elemento.getPaisDeOrigem()) == 0 && listaSeries.getCelula(j).elemento.getNome().compareTo(pivo.elemento.getNome()) > 0)){
                j--;
                numComparacoes++;
            }
            if (i <= j) {
				Serie temp = listaSeries.getCelula(i).elemento;
				listaSeries.getCelula(i).elemento = listaSeries.getCelula(j).elemento;
				listaSeries.getCelula(j).elemento = temp;
				numMovimentacoes += 3;
                i++;
                j--;
            }
        }
        if (esq < j)  listaSeries = quicksort(listaSeries, esq, j);
        if (i < dir)  listaSeries = quicksort(listaSeries, i, dir);
        return listaSeries;
    }
	
	/* METODO NECESSARIO PARA FAZER A LEITURA DO PUB.IN */
  	public static String[] leituraPubIn(){
    	String[] linhas = new String[tamPubIn];
      	linhas[tam] = MyIO.readLine();
      	while(conferirFim(linhas[tam]) == false){ /* LEITURA DO ARQUIVO ENQUANTO ESSE Nïż½O CHEGAR NO FIM */
			tam++;
     		linhas[tam] = MyIO.readLine();
		}
		return linhas;
	}
	
	/* MAIN DO CODIGO QUE CHAMA OS METODOS */
	public static void main(String[] args)throws Exception{
		MyIO.setCharset("UTF-8");
		Serie[] S = new Serie[tamPubIn];
		String[] linhasPubIn = leituraPubIn();
		Serie[] linhasRemovidas = new Serie[100];
		Serie[] serie = new Serie[tam];
		int i = 0, pos = 0, j = 0;
		try {
			while(i < tam){
				serie[i] = leituraHtml(linhasPubIn[i]);
				i++;
			}
		}catch(IOException e) {
  			e.printStackTrace();
		}

		ListaDupla listaSeries = new ListaDupla();
		for(i = 0; i < tam; i++){
			listaSeries.inserirFim(serie[i]);	
		}

		long tempoInicial = System.currentTimeMillis();
		ListaDupla listaOrdenada = quicksort(listaSeries, 0, tam-1);
        long tempoTotal = System.currentTimeMillis() - tempoInicial;

		listaOrdenada.mostrar(); 
	}
}

class CelulaDupla {
	public Serie elemento; // Elemento inserido na celula
	public CelulaDupla prox; // Aponta a celula prox
	public CelulaDupla ant; //Aponta a celula ant

    public CelulaDupla(){
    }

	//Construtor da classe
	public CelulaDupla(Serie elemento) {
      	this.elemento = elemento;
      	this.ant = this.prox = null;
	}
}

class ListaDupla {
	private CelulaDupla primeiro;
	private CelulaDupla ultimo;

    //Construtor da classe que cria uma lista sem elementos (somente no cabeca).
	public ListaDupla() {
		primeiro = new CelulaDupla();
		ultimo = primeiro;
	}

    public void inserirInicio(Serie x) {
		CelulaDupla tmp = new CelulaDupla(x);
		tmp.ant = primeiro;
        tmp.prox = primeiro.prox;
		primeiro.prox = tmp;
		if (primeiro == ultimo) {                 
			ultimo = tmp;
		} else {
			tmp.prox.ant = tmp;
		}
        tmp = null;
	}

	public void inserirFim(Serie x) {
		ultimo.prox = new CelulaDupla(x);
		ultimo.prox.ant = ultimo;
		ultimo = ultimo.prox;
	}

	public Serie removerInicio() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		}

        CelulaDupla tmp = primeiro;
		primeiro = primeiro.prox;
		Serie resp = primeiro.elemento;
        tmp.prox = primeiro.ant = null;
        tmp = null;
		return resp;
	}

	public Serie removerFim() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		} 

        Serie resp = ultimo.elemento; 
        ultimo = ultimo.ant; 
		ultimo.prox.ant = null;
      	ultimo.prox = null;
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
            CelulaDupla i = primeiro;
            for(int j = 0; j < pos; j++, i = i.prox);
		
            CelulaDupla tmp = new CelulaDupla(x);
            tmp.ant = i;
			tmp.prox = i.prox;
            tmp.ant.prox = tmp.prox.ant = tmp;
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
            CelulaDupla i = primeiro.prox;
            for(int j = 0; j < pos; j++, i = i.prox);
		
            i.ant.prox = i.prox;
			i.prox.ant = i.ant;
			resp = i.elemento;
			i.prox = i.ant = null;
			i = null;
        }
		return resp;
	}

	public CelulaDupla getCelula(int pos){
		// Caminhar ate a posicao
		CelulaDupla i = primeiro.prox;
		for(int j = 0; j < pos; j++, i = i.prox);
		return i;
	}

	public void mostrar() {
		for (CelulaDupla i = primeiro.prox; i != null; i = i.prox) {
			i.elemento.imprimir();
		}
	}

    public int tamanho() {
        int tamanho = 0; 
        for(CelulaDupla i = primeiro; i != ultimo; i = i.prox, tamanho++);
        return tamanho;
    }
}
