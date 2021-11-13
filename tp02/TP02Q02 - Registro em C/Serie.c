// BIBLIOTECAS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

//ESTRUTURA
typedef struct {
    char* nome;
    char* formato;
    char* duracao;
    char* paisOriginal;
    char* idiomaOriginal;
    char* emissoraOriginal;
    char* transmissaoOriginal;
    int numTemporadas;
    int numEpisodios;
}Series;

//PROCEDIMENTOS PARA SETAR A ESTRUTURA
void setNome(char* atributo, Series* serie){
    serie->nome = atributo; 
}
void setFormato(char* atributo, Series* serie){
    serie->formato = atributo; 
}
void setDuracao(char* atributo, Series* serie){
    serie->duracao = atributo; 
}
void setPaisOriginal(char* atributo, Series* serie){
    serie->paisOriginal = atributo; 
}
void setIdiomaOriginal(char* atributo, Series* serie){
    serie->idiomaOriginal = atributo; 
}
void setEmissoraOriginal(char* atributo, Series* serie){
    serie->emissoraOriginal = atributo; 
}
void setTransmissaoOriginal(char* atributo, Series* serie){
    serie->transmissaoOriginal = atributo; 
}
void setNumTemporadas(int atributo, Series* serie){
    serie->numTemporadas = atributo; 
}
void setNumEpisodios(int atributo, Series* serie){
    serie->numEpisodios = atributo; 
}

//FUNCÕES PARA FAZER O GET DA ESTRUTURA
char* getNome(Series* serie){
    return serie->nome;
}
char* getFormato(Series* serie){
    return serie->formato;
}
char* getDuracao(Series* serie){
    return serie->duracao;
}
char* getPaisOriginal(Series* serie){
    return serie->paisOriginal;
}
char* getIdiomaOriginal(Series* serie){
    return serie->idiomaOriginal;
}
char* getEmissoraOriginal(Series* serie){
    return serie->emissoraOriginal ;
}
char* getTransmissoraOriginal(Series* serie){
    return serie->transmissaoOriginal;
}
int getNumTemporadas(Series* serie){
    return serie->numTemporadas;
}
int getNumEpisodios(Series* serie){
    return serie->numEpisodios;    
}

//FUNCAO QUE CONFERE SE CHEGOU AO FIM DO ARQUIVO
bool isFim(char* linha) {
    return (linha[0] == 'F' && linha[1] == 'I' && linha[2] == 'M');
}

//FUNCAO QUE RETORNA SE O CARACTER É UMA LETRA OU UM NUMERO
bool isLetraOrNumber(char* a){
	return (*a >= 'a' && *a <= 'z' || *a >= 'A' && *a <= 'Z' || *a >= '0' && *a <= '9' || *a == ' ' || *a == '(' || *a == ')');
}

//FUNCAO QUE RETORNA SE O CARACTER É UMA LETRA OU UM NUMERO
bool isLetraOrNumber2(char* a){
	return (*a >= 'a' && *a <= 'z' || *a >= 'A' && *a <= 'Z' || *a >= '0' && *a <= '9');
}

//FUNCAO QUE RETORNA SE O CARACTER É UM NUMERO
bool isNumber(char* a){
	return (*a >= '0' && *a <= '9');
}

//FUNCAO DE IMPRIMIR OS ATRIBUTOS NA ORDEM DO PUB.IN
void imprimir(Series* s){
	printf("%s %s %s %s %s %s %s %d %d \n", getNome(s), getFormato(s), getDuracao(s), getPaisOriginal(s), getIdiomaOriginal(s), getEmissoraOriginal(s), getTransmissoraOriginal(s), getNumTemporadas(s), getNumEpisodios(s));
}

//FUNCAO QUE TRATA O ATRIBUTO
char* pegarAtributo(char* linha, int opc){
	int indexAtributo = 0, indexColuna = 0;
	char* atributo = (char*)calloc(100, sizeof(char));
	while(indexColuna < strlen(linha)-1){
		if(linha[indexColuna] == '>'){
			indexColuna++;
			switch (opc){
    			case 1:
					if(isLetraOrNumber2(&linha[indexColuna])){
						while(linha[indexColuna] != '<'){
							atributo[indexAtributo++] = linha[indexColuna++];
						}
					}
					break;
			
				case 2:
					if(isLetraOrNumber(&linha[indexColuna])){
						while(linha[indexColuna] != '<'){
							atributo[indexAtributo++] = linha[indexColuna++];
						}
					} 
					break;
						
				case 3:
					if(isNumber(&linha[indexColuna])){
						while(linha[indexColuna] != '<'){
							atributo[indexAtributo++] = linha[indexColuna++];
						}
					}
					break;
					
				case 4:
					if(isLetraOrNumber(&linha[indexColuna])){
						while(linha[indexColuna] != '<'){
							atributo[indexAtributo++] = linha[indexColuna++];
						}
					} else {
						if(linha[indexColuna++] == '&'){
							atributo[indexAtributo++] = '(';
						}
					}	
					break;
			}			
		}	
		indexColuna++;
	}
	return atributo;
}

//FUNCAO QUE TRATA NOME
char* tratarNome(char** html){
    char *nome = (char *)calloc(50, sizeof(char));
    int indexLinha = 0, indexColuna = 0, indexAtributo = 0;
    while(strstr(html[indexLinha], "firstHeading") == NULL)indexLinha++;
    nome = pegarAtributo(&html[indexLinha][indexColuna], 1);
    return nome;
}

//FUNCAO QUE TRATA FORMATO
char* tratarFormato(char** html){
    char *formato = (char *)calloc(100, sizeof(char));
    int indexLinha = 0, indexColuna = 0, indexAtributo = 0;
    while(strstr(html[indexLinha], "Formato") == NULL)indexLinha++;
    indexLinha++;
    formato = pegarAtributo(&html[indexLinha][indexColuna], 2);
    return formato;
}

//FUNCAO QUE TRATA DURACAO
char* tratarDuracao(char** html){
    char *duracao = (char *)calloc(100, sizeof(char));
    int indexLinha = 0, indexColuna = 0, indexAtributo = 0;
    while(strstr(html[indexLinha], "Duração") == NULL)indexLinha++;
    indexLinha++;
    duracao = pegarAtributo(&html[indexLinha][indexColuna], 2);
    return duracao;
}

//FUNCAO QUE TRATA PAIS ORIGINAL
char* tratarPaisOriginal(char** html){
    char *paisOriginal = (char *)calloc(100, sizeof(char));
    int indexLinha = 0, indexColuna = 0, indexAtributo = 0;
    while(strstr(html[indexLinha], "País de origem") == NULL)indexLinha++;
    indexLinha++;
    paisOriginal = pegarAtributo(&html[indexLinha][indexColuna], 2);
    return paisOriginal;
}

//FUNCAO QUE TRATA IDIOMA ORIGINAL
char* tratarIdiomaOriginal(char** html){
    char *idiomaOriginal = (char *)calloc(100, sizeof(char));
    int indexLinha = 0, indexColuna = 0, indexAtributo = 0;
    while(strstr(html[indexLinha], "Idioma original") == NULL)indexLinha++;
    indexLinha++;
    idiomaOriginal = pegarAtributo(&html[indexLinha][indexColuna], 2);
    return idiomaOriginal;
}

//FUNCAO QUE TRATA EMISSORA ORIGINAL
char* tratarEmissoraOriginal(char** html){
    char *emissoraOriginal = (char *)calloc(100, sizeof(char));
    int indexLinha = 0, indexColuna = 0, indexAtributo = 0;
    while(strstr(html[indexLinha], "Emissora de televisão original") == NULL)indexLinha++;
    indexLinha++;
    emissoraOriginal = pegarAtributo(&html[indexLinha][indexColuna], 2);
    return emissoraOriginal;
}

//FUNCAO QUE TRATA EMISSORA ORIGINAL
char* tratarTransmissoraOriginal(char** html){
    char *transmissoraOriginal = (char *)calloc(100, sizeof(char));
    int indexLinha = 0, indexColuna = 0, indexAtributo = 0;
    while(strstr(html[indexLinha], "Transmissão original") == NULL)indexLinha++;
    indexLinha++;
    transmissoraOriginal = pegarAtributo(&html[indexLinha][indexColuna], 4);
    return transmissoraOriginal;
}

//FUNCAO QUE TRATA NUMERO DE TEMPORADAS
int tratarNumTemporadas(char** html){
    int numTemporadas = 0;
    int indexLinha = 0, indexColuna = 0, indexAtributo = 0;
    while(strstr(html[indexLinha], "N.º de temporadas") == NULL)indexLinha++;
    indexLinha++;
    numTemporadas = atoi(pegarAtributo(&html[indexLinha][indexColuna], 3));
    return numTemporadas;
}

//FUNCAO QUE TRATA NUMERO DE EPISODIOS
int tratarNumEpisodios(char** html){
    int numEpisodios = 0;
    int indexLinha = 0, indexColuna = 0, indexAtributo = 0;
    while(strstr(html[indexLinha], "N.º de episódios") == NULL)indexLinha++;
    indexLinha++;
    numEpisodios = atoi(pegarAtributo(&html[indexLinha][indexColuna], 3));
    return numEpisodios;
}

//FUNCAO DE LEITURA DOS ARQUIVOS HTML
char** lerHtml(char* caminho) {
    char** html = (char**)calloc(3000,sizeof(char*));
    int i = 0;
    for (i = 0; i < 3000; i++) {
        html[i] = (char*)calloc(3000,sizeof(char));
    }
    FILE* arquivo = fopen(caminho, "r");
    if (arquivo != NULL) {
        i = 0;
        while (!feof(arquivo)) {
            fgets(html[i],3000,arquivo);
            i++;
        }
    } else {
        printf("ERRO AO ABRIR ARQUIVO \n");
    }
    fclose(arquivo);
    return html;
}

//FUNCAO QUE CHAMA O METODO DE SETAR A ESTRUTURA
Series* ler(char* caminho, Series* serie){
    char** html = lerHtml(caminho);
    setNome(tratarNome(html), serie);
    setFormato(tratarFormato(html), serie);
    setDuracao(tratarDuracao(html), serie);
    setPaisOriginal(tratarPaisOriginal(html), serie);
    setIdiomaOriginal(tratarIdiomaOriginal(html), serie);
    setEmissoraOriginal(tratarEmissoraOriginal(html), serie);
    setTransmissaoOriginal(tratarTransmissoraOriginal(html), serie);
    setNumTemporadas(tratarNumTemporadas(html), serie);
    setNumEpisodios(tratarNumEpisodios(html), serie); 

    return serie;
}

//MAIN DO CODIGO
int main() {
	Series** series = (Series **)calloc(1000, sizeof(Series *));
	char** caminho = (char**)calloc(100, sizeof(char*));
    char** entradas = (char **)calloc(100 , sizeof(char*));
    int i, k = 0;
    for (i = 0; i < 100; i++) {
        entradas[i] = (char*)calloc(2000 , sizeof(char));
        series[i] = (Series*)calloc(100, sizeof(Series));
    } 
    i = 0;
    fgets(entradas[i], 1000,stdin);
    while (!isFim(entradas[i])) {
        i++; k++;
        fgets(entradas[i], 1000,stdin);
    }
    i = 0;
    while(i < k){
    	caminho[i] = (char*)calloc(15+strlen(entradas[i]), sizeof(char));
    	strcpy(caminho[i],"/tmp/series/"); 
        strcat(caminho[i], entradas[i]);
        caminho[i][strlen(caminho[i])-1] = '\0';
        ler(caminho[i], series[i]);
        i++;
    } 
    for(i = 0; i < k; i++){
    	imprimir(series[i]);
    }
    free(series);
    free(caminho);
    free(entradas);
    
    return 0;
}
