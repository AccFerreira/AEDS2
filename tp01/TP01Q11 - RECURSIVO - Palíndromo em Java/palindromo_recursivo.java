import java.io.*;

class palindromo_recursivo{
	public static void main (String[] args)throws Exception{
		String frase = "";
		boolean resp;
		int i = 0, tam = 0;
		
		while(i != 1){ //loop para leitura de todo arquivo
			frase = MyIO.readLine();
			if(frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M'){  //FIM presente no fim do arquivo
				i = 1; 																		
			}else{			
				tam = frase.length(); //tamanho do array frase
				tam = tam - 1;
            	resp = testar(frase, tam);
            	
            	if(resp == true){ //condição para printar na tela se é palindromo ou não
                	MyIO.println("SIM");
            	}else{
                	MyIO.println("NAO");
            	}
			}
		}	
	}
	
	public static boolean testar(String frase, int tam)throws Exception{ //metodo para chamar outro metodo com dois parametros a mais
         return testar(frase, tam, 0, true);
	}
	
	public static boolean testar(String frase, int tam, int i, boolean resp)throws Exception{ //metodo para testar se é palindromo
		if(i < tam){ //condição para que o i não seja igual ou maior que tam
			if(frase.charAt(i) != frase.charAt(tam)){ //caso esses caracteres sejam diferentes i = tam e resp é = false
				resp = false;
				i = tam;
			}
			resp = testar(frase, --tam, ++i, resp); //chamar novamente o metodo incrementando o i e decrementando o tam
		}
		return resp;
	}
}









