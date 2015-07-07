#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define endl "\n"

/**
 * Implementación del Algoritmo de Kruskall para hallar 2 arboles cobertores mínimos
 *
 * @author Bashkara's Formulae (team Candelaria):
 *      Gerson Lázaro - Melissa Delgado - Cristhian León
 *      UFPS
*/

using namespace std;

struct Edge{
    int origen, destino, peso;

    bool operator!=(const Edge& rhs) const{
        if(rhs.origen!=origen || rhs.destino!=destino || rhs.peso!=peso){
            return true;
        }
        return false;
    }
};

int v,e, costo1, costo2;
int parent[305]; //MAXIMO
int rango[305]; //MAXIMO
Edge arcos[10000];
Edge rta[10000];

void init(){
    for(int i=0; i<=v; i++){
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
 
    if (rango[xroot] < rango[yroot])
        parent[xroot] = yroot;
    else if (rango[xroot] > rango[yroot])
        parent[yroot] = xroot;

    else
    {
        parent[yroot] = xroot;
        rango[xroot]++;
    }
}

void kruskall(){
    Edge actual;
    Edge descartado;
    int aux=0;
    int i=0;
    int w=0;
    int x,y, costoAux;
    qsort(arcos, e, sizeof(arcos[0]), cmp);

    while(aux<v-1){
        actual=arcos[i];

        x=find(actual.origen);
        y=find(actual.destino);

        if(x!=y){
            rta[aux]=actual;
            costo1+=actual.peso;
            aux++;
            unionFind(x, y);
        }
        i++;
    }
    
    while(w<v-1){
        init();
        descartado=rta[w];
        aux=0;
        costoAux=0;
        i=0;
        
        while(aux<v-1 && i<e){
            actual=arcos[i];
            if(actual!=(descartado)){
                x=find(actual.origen);
                y=find(actual.destino);
        
                if(x!=y){
                    costoAux+=actual.peso;
                    aux++;
                    unionFind(x, y);
                }
            }
            i++;
        }
        if(aux==v-1 && (costo2==0 || costoAux<costo2)){
            costo2=costoAux;
        }
        w++;
    }
}

int main(){
    int i, o, d, c, tc;
    scanf("%i", &tc);
    while(tc>0){
        scanf("%i %i", &v, &e);    

        init();

        costo1=0;
        costo2=0;

        for(i=0; i<e; i++){
            scanf("%i %i %i", &o, &d, &c);
            arcos[i].origen=o;
            arcos[i].destino=d;
            arcos[i].peso=c;
        }
    
        kruskall();
        printf("%i %i\n", costo1, costo2);
        tc--;
    }
}