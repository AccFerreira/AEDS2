import java.io.*;

class arquivo{
	public static void main (String[] args)throws Exception{ 
		int n = 0;
		n = MyIO.readInt(); //lê a primeira linha do arquivo que corresponde a um inteiro
		escrever(n); //chama o metodo escrever 
		ler(n);		 //chama o metodo ler 	
	}
	
	public static void escrever (int n)throws Exception{
		Double linha;
		RandomAccessFile raf = new RandomAccessFile("exemplo.txt", "rw"); //abertura do arquivo para escrita
		
		for(int i = 0; i < n; i++){ //for para escrever todas as linhas no arquivo
			linha = MyIO.readDouble(); //leitura da linha
			raf.writeDouble(linha);	 //escrita no arquivo
		}
		
		raf.close(); //fechamento do arquivo
	}
	
	public static void ler (int n)throws Exception{
		RandomAccessFile raf = new RandomAccessFile("exemplo.txt", "r"); //abertura do arquivo para leitura
		double numReal = 0;
		int numInteiro = 0;
		
		for(int i = 0; i < n; n--){ //for para ler o arquivo de tras para frente
			raf.seek((n-1)*8); //setando o ponteiro para a ultima posição do arquivo
			numReal = raf.readDouble(); //leitura do numero real do arquivo
			numInteiro = (int)numReal;
		
			//necessário para a saida não conter numeros alem do real(acrescimo do 0)	 
			if(numReal == (long)numReal){ //condiçao caso o numero real seja igual ao long desse mesmo numero
				MyIO.println(numInteiro); //caso seja printa o valor inteiro
			}else{
				MyIO.println(numReal); //caso nao seja printa o valor real
			}
		}
		raf.close(); //fechamento do arquivo
	}
}












