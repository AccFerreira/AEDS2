import java.io.*;
import java.util.Random;

class aleatoria{
	public static void main (String[] args){
		String linha = ""; //linha do pub.in
		int i = 0;
		Random gerador = new Random();
		gerador.setSeed(4);

		while(i != 1){ //loop para leitura de todo arquivo
			linha = MyIO.readLine(); //criação do array linha
			
			if(linha.charAt(0) == 'F' && linha.charAt(1) == 'I' && linha.charAt(2) == 'M'){  //FIM presente no fim do arquivo
				i = 1; 																		
			}else{
				char seed1 = (char)('a' + Math.abs(gerador.nextInt() % 26)); //criando caracter aleatorio
				char seed2 = (char)('a' + Math.abs(gerador.nextInt() % 26)); //criando caracter aleatorio
				
				linha = linha.replaceAll("" + seed1 , "" + seed2); //trocar todos os caracteres seed1 por seed2
				
				MyIO.println(linha);
			}
		}
	}
}
