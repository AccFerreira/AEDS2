import java.io.*;

class metodos{
	public static void main (String[] args){
		String linha = ""; //linha do pub.in
		int i = 0;
		boolean resp1 = false, resp2 = false, resp3 = false, resp4 = false;
	
		while(i != 1){ //loop para leitura de todo arquivo
			linha = MyIO.readLine();
			
			if(linha.charAt(0) == 'F' && linha.charAt(1) == 'I' && linha.charAt(2) == 'M'){  //FIM presente no fim do arquivo
				i = 1; 																		
			}else{
				resp1 = vogais(linha);
				resp2 = consoantes(linha);
				resp3 = numero_inteiro(linha);
				resp4 = numero_real(linha);
				
				if(resp1 == true){
					MyIO.print("SIM ");
				}else{
					MyIO.print("NAO ");
				}
				
				if(resp2 == true){
					MyIO.print("SIM ");
				}else{
					MyIO.print("NAO ");
				}
				
				if(resp3 == true){
					MyIO.print("SIM ");
				}else{
					MyIO.print("NAO ");
				}
				
				if(resp4 == true){
					MyIO.println("SIM");
				}else{
					MyIO.println("NAO");
				}
			}
		}
	}
	
	public static boolean vogais(String linha){ //metodo para conferir se a linha possui apenas vogais
		boolean resp0 = false;
		boolean resp1 = true;
		for(int i = 0; i < linha.length(); i++){	//loop q se repete enquanto i < tamanho da linha			
        	if(linha.charAt(i) != 'a' || linha.charAt(i) != 'e' || linha.charAt(i) != 'i' || linha.charAt(i) != 'o' || linha.charAt(i) != 
        	'u' || linha.charAt(i) != 'A' || linha.charAt(i) != 'E' || linha.charAt(i) != 'I' || linha.charAt(i) != 'O' || 
        	linha.charAt(i) != 'U'){
				return resp0;
			}
        }
        return resp1;
	}
	
	public static boolean consoantes(String linha){ //metodo para conferir se a linha possui apenas consoantes	
		boolean resp0 = false;
		boolean resp1 = true;
		for(int i = 0; i < linha.length(); i++){	//loop q se repete enquanto i < tamanho da linha			
        	if(linha.charAt(i) != 'b' || linha.charAt(i) != 'c' || linha.charAt(i) != 'd' || linha.charAt(i) != 'f' || linha.charAt(i) != 
        	'g' || linha.charAt(i) != 'h' ||linha.charAt(i) != 'j' || linha.charAt(i) != 'k' || linha.charAt(i) != 'l' || 
        	linha.charAt(i) != 'm' || linha.charAt(i) != 'n' || linha.charAt(i) != 'p' || linha.charAt(i) != 'q' || linha.charAt(i) != 
        	'r' || linha.charAt(i) != 's' || linha.charAt(i) != 't' || linha.charAt(i) != 'v' || linha.charAt(i) != 'w' || 		
        	linha.charAt(i) != 'x' || linha.charAt(i) != 'y' || linha.charAt(i) != 'z' || linha.charAt(i) != 'B' || linha.charAt(i) != 
        	'C' || linha.charAt(i) != 'D' || linha.charAt(i) != 'F' || linha.charAt(i) != 'G' || linha.charAt(i) != 'H' || 
        	linha.charAt(i) != 'J' || linha.charAt(i) != 'K' || linha.charAt(i) != 'L' || linha.charAt(i) != 'M' || linha.charAt(i) != 
        	'N' || linha.charAt(i) != 'P' || linha.charAt(i) != 'Q' || linha.charAt(i) != 'R' || linha.charAt(i) != 'S' || 
        	linha.charAt(i) != 'T' || linha.charAt(i) != 'V' || linha.charAt(i) != 'W' || linha.charAt(i) != 'X' || linha.charAt(i) != 
        	'Y' || linha.charAt(i) != 'Z'){
				return resp0;
			} 
        }
        return resp1;
	}
	
	public static boolean numero_inteiro(String linha){ //metodo para conferir se a linha possui apenas números inteiros	
		boolean resp0 = false;
		boolean resp1 = true;
		for(int i = 0; i < linha.length(); i++){	//loop q se repete enquanto i < tamanho da linha			
        	if(linha.charAt(i) != 'a' || linha.charAt(i) != 'e' || linha.charAt(i) != 'i' || linha.charAt(i) != 'o' || linha.charAt(i) != 
        	'u' || linha.charAt(i) != 'A' || linha.charAt(i) != 'E' || linha.charAt(i) != 'I' || linha.charAt(i) != 'O' || 
        	linha.charAt(i) != 'U'|| linha.charAt(i) != 'b' || linha.charAt(i) != 'c' || linha.charAt(i) != 'd' || linha.charAt(i) != 'f' 
        	|| linha.charAt(i) != 'g' || linha.charAt(i) != 'h' ||linha.charAt(i) != 'j' || linha.charAt(i) != 'k' || linha.charAt(i) != 
        	'l' || linha.charAt(i) != 'm' || linha.charAt(i) != 'n' || linha.charAt(i) != 'p' || linha.charAt(i) != 'q' || 
        	linha.charAt(i) != 'r' || linha.charAt(i) != 's' || linha.charAt(i) != 't' || linha.charAt(i) != 'v' || linha.charAt(i) != 
        	'w' || linha.charAt(i) != 'x' || linha.charAt(i) != 'y' || linha.charAt(i) != 'z' || linha.charAt(i) != 'B' || 
        	linha.charAt(i) != 'C' || linha.charAt(i) != 'D' || linha.charAt(i) != 'F' || linha.charAt(i) != 'G' || linha.charAt(i) != 
        	'H' || linha.charAt(i) != 'J' || linha.charAt(i) != 'K' || linha.charAt(i) != 'L' || linha.charAt(i) != 'M' || 
        	linha.charAt(i) != 'N' || linha.charAt(i) != 'P' || linha.charAt(i) != 'Q' || linha.charAt(i) != 'R' || linha.charAt(i) != 
        	'S' || linha.charAt(i) != 'T' || linha.charAt(i) != 'V' || linha.charAt(i) != 'W' || linha.charAt(i) != 'X' || 
        	linha.charAt(i) != 'Y' || linha.charAt(i) != 'Z' || linha.charAt(i) == ';' || linha.charAt(i) == ':' || linha.charAt(i) == 
        	'/' || linha.charAt(i) == '?' || linha.charAt(i) == '!' || linha.charAt(i) == '.' || linha.charAt(i) == ','){
				return resp0;
			}
        }
        return resp1;
	}
	
	public static boolean numero_real(String linha){ //metodo para conferir se a linha possui apenas números reais	
		boolean resp0 = false;
		boolean resp1 = true;
		for(int i = 0; i < linha.length(); i++){	//loop q se repete enquanto i < tamanho da linha			
        	if(linha.charAt(i) != 'a' || linha.charAt(i) != 'e' || linha.charAt(i) != 'i' || linha.charAt(i) != 'o' || linha.charAt(i) != 
        	'u' || linha.charAt(i) != 'A' || linha.charAt(i) != 'E' || linha.charAt(i) != 'I' || linha.charAt(i) != 'O' || 
        	linha.charAt(i) != 'U'|| linha.charAt(i) != 'b' || linha.charAt(i) != 'c' || linha.charAt(i) != 'd' || linha.charAt(i) != 'f' 
        	|| linha.charAt(i) != 'g' || linha.charAt(i) != 'h' ||linha.charAt(i) != 'j' || linha.charAt(i) != 'k' || linha.charAt(i) != 
        	'l' || linha.charAt(i) != 'm' || linha.charAt(i) != 'n' || linha.charAt(i) != 'p' || linha.charAt(i) != 'q' || 
        	linha.charAt(i) != 'r' || linha.charAt(i) != 's' || linha.charAt(i) != 't' || linha.charAt(i) != 'v' || linha.charAt(i) != 
        	'w' || linha.charAt(i) != 'x' || linha.charAt(i) != 'y' || linha.charAt(i) != 'z' || linha.charAt(i) != 'B' || 
        	linha.charAt(i) != 'C' || linha.charAt(i) != 'D' || linha.charAt(i) != 'F' || linha.charAt(i) != 'G' || linha.charAt(i) != 
        	'H' || linha.charAt(i) != 'J' || linha.charAt(i) != 'K' || linha.charAt(i) != 'L' || linha.charAt(i) != 'M' || 
        	linha.charAt(i) != 'N' || linha.charAt(i) != 'P' || linha.charAt(i) != 'Q' || linha.charAt(i) != 'R' || linha.charAt(i) != 
        	'S' || linha.charAt(i) != 'T' || linha.charAt(i) != 'V' || linha.charAt(i) != 'W' || linha.charAt(i) != 'X' || 
        	linha.charAt(i) != 'Y' || linha.charAt(i) != 'Z' || linha.charAt(i) == ';' || linha.charAt(i) == ':' || linha.charAt(i) == 
        	'/' || linha.charAt(i) == '?' || linha.charAt(i) == '!'){
				return resp0;
			}
        }
        return resp1;
	}
}










