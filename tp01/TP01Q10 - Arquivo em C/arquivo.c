#include <stdio.h>
#include <stdlib.h>

int main(){
    FILE *fp = NULL; //ponteiro aponta para NULL
    double array[100];
    int n = 81; //quanridade de linhas no arquivo, baseado na entrada e saida

    fp = fopen("teste.txt", "w+"); //abertura de um arquivo, caso este não exista um arquivo é criado
    
    for(int i = 0; i < n; i++){ //loop para salvar os valores da entrada em um array de numeros reais
        scanf("%lf", &array[i]);
    }

    fclose(fp); //fechamento de arquivo

    fp = fopen("teste.txt", "w+"); //abertura de um arquivo, caso este não exista um arquivo é criado

    for(int i = n-1; i > 0; i--){ //loop que lê o array de traz para frente
        fprintf(fp ,"%lf\n", array[i]); //printa no arquivo esses valores
        printf("%g\n", array[i]); //printa na tela esses valores
    }

    fclose(fp); //fechamento de arquivo

    return 0;
}
