#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>
#define TAM 1000 //definição de TAM para 1000 para facilitar ajustes no código

int main(){
    char frase[TAM];
    int tamanho = 0, i = 0, j = 0, k = 1;
    int resp = 1;
    
    scanf(" %[^\n]", frase); //leitura da primeira linha do array

	if(strcmp(frase, "FIM") == 0){ //comparação do array frase com FIM que corresponde à última linha do arquivo pub.in
        k = 0;
    }

    while(k != 0){	//loop para leitura das linhas do arquivo

 		tamanho = strlen(frase)-1; //tamanho do array

        j = tamanho;

        for(i = 0; i <= j/2; i++){	//leitura do array de tras (J--) pra frente (k++) efeturando comparações ate a metade do array
            if(frase[i] != frase[j-i]){
            	resp = 0;
               i = tamanho + 1;
            }
        }

        if(resp == 1){ //condição para printar se é palindromo ou não baseado nas comparações do for acima
            printf("SIM\n");
        }else{
            printf("NAO\n");
        }
        resp = 1;
       
        scanf(" %[^\n]", frase); //leitura de linha a linha do array
        
        if(strcmp(frase, "FIM") == 0){ //condição para ver se a frase lida corresponde ao final do arquivo identificado por FIM
            k = 0;
        }
        
    }
       
    return 0;
}
