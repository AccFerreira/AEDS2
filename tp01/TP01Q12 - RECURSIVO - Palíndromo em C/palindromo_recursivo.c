#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>
#include <stdbool.h>
#define TAM 1000 //definição de TAM para 1000 para facilitar ajustes no código

bool testar(char *frase, int dir, int esq, bool resp){ //metodo para conferir se é palindromo
	 if(esq < dir){ //condição para que esq seja menor que dir
     	if(frase[esq] != frase[dir]){ //caso os caracteres sejam diferentes resp = false e esq = tam
     		resp = false;
     		esq = dir;
     	}
     	resp = testar(frase, --dir, ++esq, resp); //chamada ao metodo decrementando dir e incrementando esq
     }	
     return resp;
}

int main(){
    char frase[TAM];
    int tam = 0, i = 1;
    bool resp = true;
    
    scanf(" %[^\n]", frase); //leitura da primeira linha do array

	if(strcmp(frase, "FIM") == 0){ //comparação do array frase com FIM que corresponde à última linha do arquivo pub.in
        i = 0;
    }

    while(i != 0){	//loop para leitura das linhas do arquivo

 		tam = strlen(frase)-1; //tamanho do array
        
        resp = testar(frase, tam, 0, true);

        if(resp == true){ //condição para printar se é palindromo ou não baseado nas comparações do for acima
            printf("SIM\n");
        }else{
            printf("NAO\n");
        }
       
        scanf(" %[^\n]", frase); //leitura de linha a linha do array
        
        if(strcmp(frase, "FIM") == 0){ //condição para ver se a frase lida corresponde ao final do arquivo identificado por FIM
            i = 0;
        }
        
    }
       
    return 0;
}
