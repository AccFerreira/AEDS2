#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>
#include<stdbool.h>
#define TAM 1000 //definição de TAM para 1000 para facilitar ajustes no código

bool vogais(char *linha, int tamanho){
	bool resp = true;
	for(int i = 0; i < tamanho; i++){
		if(linha[i] != 'a' || linha[i] != 'e' || linha[i] != 'i' || linha[i] != 'o' || linha[i] != 'u' || linha[i] != 'A' || linha[i] != 
		'E' || linha[i] != 'I' || linha[i] != 'O' || linha[i] != 'U'){
			resp = false;
			return resp;
		}
	}
	return resp;
}

bool consoantes(char *linha, int tamanho){
	bool resp = true;
	for(int i = 0; i < tamanho; i++){
		if(linha[i] != 'b' || linha[i] != 'c' || linha[i] != 'd' || linha[i] != 'f' || linha[i] != 'g' || linha[i] != 'h' || linha[i] != 
		'j' || linha[i] != 'k' || linha[i] != 'l' || linha[i] != 'm' || linha[i] != 'n' || linha[i] != 'p' || linha[i] != 'q' || 
		linha[i] != 'r' || linha[i] != 's' || linha[i] != 't' || linha[i] != 'v' || linha[i] != 'w' || linha[i] != 'x' || linha[i] != 'y' 
		|| linha[i] != 'z' || linha[i] != 'B' || linha[i] != 'C' || linha[i] != 'D' || linha[i] != 'F' || linha[i] != 
		'G' || linha[i] != 'H' || linha[i] != 'J' || linha[i] != 'K' || linha[i] != 'L' || linha[i] != 'M' || linha[i] != 'N' || 
		linha[i] != 'P' || linha[i] != 'Q' || linha[i] != 'R' || linha[i] != 'S' || linha[i] != 'T' || linha[i] != 'V' || linha[i] != 'W' 
		|| linha[i] != 'X' || linha[i] != 'Y' || linha[i] != 'Z'){
			resp = false;
			return resp;
		}
	}
	return resp;
}

bool numeros_inteiros(char *linha, int tamanho){
	bool resp = true;
	for(int i = 0; i < tamanho; i++){
		if(linha[i] == 'a' || linha[i] == 'e' || linha[i] == 'i' || linha[i] == 'o' || linha[i] == 'u' || linha[i] == 'A' || linha[i] == 
		'E' || linha[i] == 'I' || linha[i] == 'O' || linha[i] == 'U' || linha[i] == 'b' || linha[i] == 'c' || linha[i] == 'd' || linha[i] 
		== 'f' || linha[i] == 'g' || linha[i] == 'h' || linha[i] == 'j' || linha[i] == 'k' || linha[i] == 'l' || linha[i] == 'm' || 
		linha[i] == 'n' || linha[i] == 'p' || linha[i] == 'q' || linha[i] == 'r' || linha[i] == 's' || linha[i] == 't' || linha[i] == 'v' 
		|| linha[i] == 'w' || linha[i] == 'x' || linha[i] == 'y' || linha[i] == 'z' || linha[i] == 'B' || linha[i] == 
		'C' || linha[i] == 'D' || linha[i] == 'F' || linha[i] == 'G' || linha[i] == 'H' || linha[i] == 'J' || linha[i] == 'K' || linha[i] 
		== 'L' || linha[i] == 'M' || linha[i] == 'N' || linha[i] == 'P' || linha[i] == 'Q' || linha[i] == 'R' || linha[i] == 'S' || 
		linha[i] == 'T' || linha[i] == 'V' || linha[i] == 'W' || linha[i] == 'X' || linha[i] == 'Y' || linha[i] == 'Z'  
		|| linha[i] == '.' || linha[i] == ',' || linha[i] == ';' || linha[i] == ':' || linha[i] == '/' || linha[i] == '?' || linha[i] == 
		'!'){
			resp = false;
			return resp;
		}
	}
	return resp;
}

bool numeros_reais(char *linha, int tamanho){
	bool resp = true;
	for(int i = 0; i < tamanho; i++){
		if(linha[i] == 'a' || linha[i] == 'e' || linha[i] == 'i' || linha[i] == 'o' || linha[i] == 'u' || linha[i] == 'A' || linha[i] == 
		'E' || linha[i] == 'I' || linha[i] == 'O' || linha[i] == 'U' || linha[i] == 'b' || linha[i] == 'c' || linha[i] == 'd' || linha[i] 
		== 'f' || linha[i] == 'g' || linha[i] == 'h' || linha[i] == 'j' || linha[i] == 'k' || linha[i] == 'l' || linha[i] == 'm' || 
		linha[i] == 'n' || linha[i] == 'p' || linha[i] == 'q' || linha[i] == 'r' || linha[i] == 's' || linha[i] == 't' || linha[i] == 'v' 
		|| linha[i] == 'w' || linha[i] == 'x' || linha[i] == 'y' || linha[i] == 'z' || linha[i] == 'B' || linha[i] == 
		'C' || linha[i] == 'D' || linha[i] == 'F' || linha[i] == 'G' || linha[i] == 'H' || linha[i] == 'J' || linha[i] == 'K' || linha[i] 
		== 'L' || linha[i] == 'M' || linha[i] == 'N' || linha[i] == 'P' || linha[i] == 'Q' || linha[i] == 'R' || linha[i] == 'S' || 
		linha[i] == 'T' || linha[i] == 'V' || linha[i] == 'W' || linha[i] == 'X' || linha[i] == 'Y' || linha[i] == 'Z'  
		|| linha[i] == ';' || linha[i] == ':' || linha[i] == '/' || linha[i] == '?' || linha[i] == '!'){;
			resp = false;
			return resp;
		}
	}
	return resp;
}

int main(){
	char linha[TAM];
    int i = 1, tamanho = 0;
    bool resp1 = false, resp2 = false, resp3 = false, resp4 = false;
    
    scanf(" %[^\n]", linha); //leitura da primeira linha do pub.in

	if(strcmp(linha, "FIM") == 0){ //comparação do array frase com FIM que corresponde à última linha do arquivo pub.in
        i = 0;
    }

    while(i != 0){	//loop para leitura das linhas do arquivo

 		tamanho = strlen(linha); //tamanho do array
 		
 		resp1 = vogais(linha, tamanho);
 		resp2 = consoantes(linha, tamanho);
 		resp3 = numeros_inteiros(linha, tamanho);
 		resp4 = numeros_reais(linha, tamanho);

        if(resp1 == true){ 
            printf("SIM ");
        }else{
            printf("NAO ");
        }
        
		if(resp2 == true){ 
            printf("SIM ");
        }else{
            printf("NAO ");
        } 
        
        if(resp3 == true){ 
            printf("SIM ");
        }else{
            printf("NAO ");
        }
        
        if(resp4 == true){ 
            printf("SIM \n");
        }else{
            printf("NAO \n");
        }
       
        scanf(" %[^\n]", linha); //leitura de linha a linha do array
        
        if(strcmp(linha, "FIM") == 0){ //condição para ver se a frase lida corresponde ao final do arquivo identificado por FIM
            i = 0;
        }
	}
	return 0;
}














