import java.io.*;

class ciframento_recursivo{
	public static void main (String[] args){
		String linha = MyIO.readLine();
		String ciframento = "";
		int tamanho = 0;
		int i = 1;
		
		while(i != 0){ //loop para leitura de todo arquivo
			if(linha.charAt(0) == 'F' && linha.charAt(1) == 'I' && linha.charAt(2) == 'M'){ //FIM presente no fim do arquivo
				i = 0;
			}else{
				tamanho = linha.length(); //tamanho do array linha
				
				ciframento = cifrar(linha, tamanho);			
				
				MyIO.println(ciframento); //printa na tela o valor modificado 
				linha = MyIO.readLine();
			}
		}
	}
	
	public static String cifrar(String linha, int tamanho){
		return cifrar(linha, "", tamanho, 0);
	}
	
	public static String cifrar(String linha, String ciframento, int tamanho, int i){
		if(i < tamanho){
			ciframento = "" + ciframento + "" + (char)(linha.charAt(i) + 3); //concatenando o caractere + 3 com a string ciframento
			
			i++;
			ciframento = cifrar(linha, ciframento, tamanho, i);
		}
		
		return ciframento;
	}
}
