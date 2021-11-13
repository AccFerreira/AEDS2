import java.io.*;

class metodos_recursivo{
	public static void main (String[] args){
		String linha = ""; //linha do pub.in
		int i = 0, tam = 0;
		boolean resp1 = false, resp2 = false, resp3 = false, resp4 = false;
	
		while(i != 1){ //loop para leitura de todo arquivo
			linha = MyIO.readLine();
			
			if(linha.charAt(0) == 'F' && linha.charAt(1) == 'I' && linha.charAt(2) == 'M'){  //FIM presente no fim do arquivo
				i = 1; 																		
			}else{
			
				tam = linha.length(); //tamanho de linha
			
				resp1 = vogais(linha, tam);
				resp2 = consoantes(linha, tam);
				resp3 = numero_inteiro(linha, tam);
				resp4 = numero_real(linha, tam);
				
				//condiçoes para printar SIM ou NAO
				
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
	
	//necessario para enviar um parametro(0) a mais
	
	public static boolean vogais(String linha, int tam){
		return vogais(linha, tam, 0);
	}
	
	//metodo para conferir se a linha possui apenas vogais, é feita a recursao somando 1 ao i ate chegar em tam
	
	public static boolean vogais(String linha, int tam, int i){ 
		boolean resp = false;	
        if((linha.charAt(i) != 'a' || linha.charAt(i) != 'e' || linha.charAt(i) != 'i' || linha.charAt(i) != 'o' || linha.charAt(i) != 
        'u' || linha.charAt(i) != 'A' || linha.charAt(i) != 'E' || linha.charAt(i) != 'I' || linha.charAt(i) != 'O' || 
        linha.charAt(i) != 'U') == true){
        	resp = false;
			i = tam + 1;
		}else if(i == tam){
			resp = true;
		}else if(i < tam){
			resp = vogais(linha, tam, i+1); 
		}
		return resp;
	}
	
	//necessario para enviar um parametro(0) a mais
	
	public static boolean consoantes(String linha, int tam){
		return consoantes(linha, tam, 0);
	}
	
	//metodo para conferir se a linha possui apenas consoantes, é feita a recursao somando 1 ao i ate chegar em tam
	
	public static boolean consoantes(String linha, int tam, int i){ //metodo para conferir se a linha possui apenas consoantes	
		boolean resp = false;		
        if((linha.charAt(i) != 'b' || linha.charAt(i) != 'c' || linha.charAt(i) != 'd' || linha.charAt(i) != 'f' || linha.charAt(i) != 
       	'g' || linha.charAt(i) != 'h' ||linha.charAt(i) != 'j' || linha.charAt(i) != 'k' || linha.charAt(i) != 'l' || 
       	linha.charAt(i) != 'm' || linha.charAt(i) != 'n' || linha.charAt(i) != 'p' || linha.charAt(i) != 'q' || linha.charAt(i) != 
       	'r' || linha.charAt(i) != 's' || linha.charAt(i) != 't' || linha.charAt(i) != 'v' || linha.charAt(i) != 'w' || 		
       	linha.charAt(i) != 'x' || linha.charAt(i) != 'y' || linha.charAt(i) != 'z' || linha.charAt(i) != 'B' || linha.charAt(i) != 
       	'C' || linha.charAt(i) != 'D' || linha.charAt(i) != 'F' || linha.charAt(i) != 'G' || linha.charAt(i) != 'H' || 
        linha.charAt(i) != 'J' || linha.charAt(i) != 'K' || linha.charAt(i) != 'L' || linha.charAt(i) != 'M' || linha.charAt(i) != 
        'N' || linha.charAt(i) != 'P' || linha.charAt(i) != 'Q' || linha.charAt(i) != 'R' || linha.charAt(i) != 'S' || 
        linha.charAt(i) != 'T' || linha.charAt(i) != 'V' || linha.charAt(i) != 'W' || linha.charAt(i) != 'X' || linha.charAt(i) != 
        'Y' || linha.charAt(i) != 'Z') == true){
        	resp = false;
			i = tam + 1;
		}else if(i == tam){
			resp = true;
		}else if(i < tam){
			resp = consoantes(linha, tam, i+1); 
		}
		return resp;
	}
	
	//necessario para enviar um parametro(0) a mais
	
	public static boolean numero_inteiro(String linha, int tam){
		return numero_inteiro(linha, tam, 0);
	}
	
	//metodo para conferir se a linha possui apenas numeros inteiros, é feita a recursao somando 1 ao i ate chegar em tam
	
	public static boolean numero_inteiro(String linha, int tam, int i){ // conferir se a linha possui apenas números inteiros	
		boolean resp = false;	
        if((linha.charAt(i) != 'a' && linha.charAt(i) != 'e' && linha.charAt(i) != 'i' && linha.charAt(i) != 'o' && linha.charAt(i) != 
        'u' && linha.charAt(i) != 'A' && linha.charAt(i) != 'E' && linha.charAt(i) != 'I' && linha.charAt(i) != 'O' && 
       	linha.charAt(i) != 'U'&& linha.charAt(i) != 'b' && linha.charAt(i) != 'c' && linha.charAt(i) != 'd' && linha.charAt(i) != 'f' 
       	&& linha.charAt(i) != 'g' && linha.charAt(i) != 'h' && linha.charAt(i) != 'j' && linha.charAt(i) != 'k' && linha.charAt(i) != 
       	'l' && linha.charAt(i) != 'm' && linha.charAt(i) != 'n' && linha.charAt(i) != 'p' && linha.charAt(i) != 'q' && 
       	linha.charAt(i) != 'r' && linha.charAt(i) != 's' && linha.charAt(i) != 't' && linha.charAt(i) != 'v' && linha.charAt(i) != 
       	'w' && linha.charAt(i) != 'x' && linha.charAt(i) != 'y' && linha.charAt(i) != 'z' && linha.charAt(i) != 'B' && 
       	linha.charAt(i) != 'C' && linha.charAt(i) != 'D' && linha.charAt(i) != 'F' && linha.charAt(i) != 'G' && linha.charAt(i) != 
       	'H' && linha.charAt(i) != 'J' && linha.charAt(i) != 'K' && linha.charAt(i) != 'L' && linha.charAt(i) != 'M' && 
        linha.charAt(i) != 'N' && linha.charAt(i) != 'P' && linha.charAt(i) != 'Q' && linha.charAt(i) != 'R' && linha.charAt(i) != 
       	'S' && linha.charAt(i) != 'T' && linha.charAt(i) != 'V' && linha.charAt(i) != 'W' && linha.charAt(i) != 'X' && 
       	linha.charAt(i) != 'Y' && linha.charAt(i) != 'Z' && linha.charAt(i) == ';' && linha.charAt(i) == ':' && linha.charAt(i) == 
       	'/' && linha.charAt(i) == '?' && linha.charAt(i) == '!' && linha.charAt(i) == ',' && linha.charAt(i) == '.') == false){
			resp = false;
			i = tam + 1;
		}else if(i == tam){
			resp = true;
		}else if(i < tam){
			resp = numero_inteiro(linha, tam, i+1); 
		}
		return resp;
	}
	
	//necessario para enviar um parametro(0) a mais
	
	public static boolean numero_real(String linha, int tam){
		return numero_real(linha, tam, 0);
	}
	
	//metodo para conferir se a linha possui apenas numeros reais, é feita a recursao somando 1 ao i ate chegar em tam
	
	public static boolean numero_real(String linha, int tam, int i){ //metodo para conferir se a linha possui apenas números reais	
		boolean resp = false;
        if((linha.charAt(i) != 'a' && linha.charAt(i) != 'e' && linha.charAt(i) != 'i' && linha.charAt(i) != 'o' && linha.charAt(i) != 
        'u' && linha.charAt(i) != 'A' && linha.charAt(i) != 'E' && linha.charAt(i) != 'I' && linha.charAt(i) != 'O' && 
       	linha.charAt(i) != 'U'&& linha.charAt(i) != 'b' && linha.charAt(i) != 'c' && linha.charAt(i) != 'd' && linha.charAt(i) != 'f' 
       	&& linha.charAt(i) != 'g' && linha.charAt(i) != 'h' && linha.charAt(i) != 'j' && linha.charAt(i) != 'k' && linha.charAt(i) != 
       	'l' && linha.charAt(i) != 'm' && linha.charAt(i) != 'n' && linha.charAt(i) != 'p' && linha.charAt(i) != 'q' && 
       	linha.charAt(i) != 'r' && linha.charAt(i) != 's' && linha.charAt(i) != 't' && linha.charAt(i) != 'v' && linha.charAt(i) != 
       	'w' && linha.charAt(i) != 'x' && linha.charAt(i) != 'y' && linha.charAt(i) != 'z' && linha.charAt(i) != 'B' && 
       	linha.charAt(i) != 'C' && linha.charAt(i) != 'D' && linha.charAt(i) != 'F' && linha.charAt(i) != 'G' && linha.charAt(i) != 
       	'H' && linha.charAt(i) != 'J' && linha.charAt(i) != 'K' && linha.charAt(i) != 'L' && linha.charAt(i) != 'M' && 
        linha.charAt(i) != 'N' && linha.charAt(i) != 'P' && linha.charAt(i) != 'Q' && linha.charAt(i) != 'R' && linha.charAt(i) != 
       	'S' && linha.charAt(i) != 'T' && linha.charAt(i) != 'V' && linha.charAt(i) != 'W' && linha.charAt(i) != 'X' && 
       	linha.charAt(i) != 'Y' && linha.charAt(i) != 'Z' && linha.charAt(i) == ';' && linha.charAt(i) == ':' && linha.charAt(i) != 
       	'/' && linha.charAt(i) != '?' && linha.charAt(i) != '!') == false){
			resp = false;
			i = tam + 1;
			return resp;
		}else if(i == tam){
			resp = true;
		}else if(i < tam){
			resp = numero_real(linha, tam, i+1); 
		}
		return resp;
	}
}
