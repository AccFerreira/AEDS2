import java.io.*;

class palindromo{
	public static void main (String[] args){
		String frase = "";
		int i = 0, j = 0, tam = 0, resp = 1;
		
		while(i != 1){ //loop para leitura de todo arquivo
			frase = MyIO.readLine(); //criação do array frase
			
			if(frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M'){  //FIM presente no fim do arquivo
				i = 1;																			
			}else{
							
				tam = frase.length(); //tamanho do array frase
				
				j = tam - 1;
				
				for(int k = 0; k < j; k++, j--){				//leitura do array de tras (J--) pra frente (k++) 
                	if(frase.charAt(k) != frase.charAt(j)){		//efeturando comparações ate a metade do array
                    	resp = 0;
                    	k = j;
                	}
            	}
            	
            	if(resp == 1){ //condição para printar na tela se é palindromo ou não
                	MyIO.println("SIM");
            	}else{
                	MyIO.println("NAO");
            	}
            	resp = 1;
            	
			}
		}	
	}
}
