#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define endl "\n"

/**
 * Implementación del Algoritmo de Kruskall 
 *
 * @author Bashkara's Formulae (team Candelaria):
 *      Gerson Lázaro - Melissa Delgado - Cristhian León
 *      UFPS
*/

using namespace std;

struct Edge{
    int origen, destino, peso;
};

int v,e;
int parent[10001]; //MAXIMO
int rango[10001]; //MAXIMO
Edge arcos[10001];
Edge rta[10001];

void init(){
    for(int i=0; i<v; i++){
        parent[i]=i;
        rango[i]=0;
    }
}

int cmp(const void* a, const void* b)
{   
    struct Edge* a1 = (struct Edge*)a;
    struct Edge* b1 = (struct Edge*)b;
    return a1->peso > b1->peso;
}


int find(int i){
    if(parent[i]!=i){
        parent[i]=find(parent[i]);
    }
    return parent[i];
}

void unionFind(int x, int y){
    int xroot = find(x);
    int yroot = find(y);
 
    // Attach smaller rango tree under root of high rango tree
    // (Union by rango)
    if (rango[xroot] < rango[yroot])
        parent[xroot] = yroot;
    else if (rango[xroot] > rango[yroot])
        parent[yroot] = xroot;
 
    // If rangos are same, then make one as root and increment
    // its rango by one
    else
    {
        parent[yroot] = xroot;
        rango[xroot]++;
    }
}

void kruskall(){
    Edge actual;
    int aux=0;
    int i=0;
    int x,y;
    qsort(arcos, e, sizeof(arcos[0]), cmp);

    while(aux<v-1){
        actual=arcos[i];

        x=find(actual.origen);
        y=find(actual.destino);

        if(x!=y){
            rta[aux]=actual;
            aux++;
            unionFind(x, y);
        }
        i++;
    }
}

int main(){
    int i, o, d, c;
    scanf("%i %i", &v, &e);

    init();
    
    for(i=0; i<e; i++){
        scanf("%i %i %i", &o, &d, &c);
        arcos[i].origen=o;
        arcos[i].destino=d;
        arcos[i].peso=c;
    }
    
    kruskall();
    
    Edge aux;
    for(i=0; i<v-1; i++){
        aux=rta[i];
        printf("%i %i %i\n", aux.origen, aux.destino, aux.peso);
    }
}