import java.io.*;

class ciframento{
	public static void main (String[] args){
		String linha = "";
		String ciframento = "";
		int tamanho = 0;
		int i = 1;
		
		while(i != 0){ //loop para leitura de todo arquivo
			linha = MyIO.readLine();
			if(linha.charAt(0) == 'F' && linha.charAt(1) == 'I' && linha.charAt(2) == 'M'){ //FIM presente no fim do arquivo
				i = 0;
			}else{
				tamanho = linha.length(); //tamanho do array linha
				
				for(int j = 0; j <= tamanho - 1; j++){ //loop para ler os caracteres da string
            		ciframento = "" + ciframento + "" + (char)(linha.charAt(j) + 3); //concatenando o caractere + 3 com a string ciframento
        		}
        		
        		MyIO.println(ciframento); //printa na tela o valor modificado 
        		ciframento = ""; //reseta o valor dessa string
			}
		}
	}
}
