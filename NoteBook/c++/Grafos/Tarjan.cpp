#include <bits/stdc++.h>
#define endl "\n"

/**
 * Implementación del Algoritmo de Tarjan para hallar Itsmos y Puentes en grafos no dirigidos
 *
 * @author Bashkara's Formulae (team Candelaria):
 *      Gerson Lázaro - Melissa Delgado - Cristhian León
 *      UFPS
*/

using namespace std;

vector<int> ady[1010];
int visitados[1010];
int anterior[1010];
int dfs_low[1010];
int dfs_num[1010];
int itsmos[1010];
int v, e;
int dfsRaiz,hijosRaiz,contador;
vector<pair<int,int>> puentes;

void init(){
    puentes.clear();
    contador=0;
    int i;
    for(i=0; i<v; i++){
        ady[i].clear();
        visitados[i]=0;
        anterior[i]=-1;
        itsmos[i]=0;
        //0 para no visitados
    }

}

void articulationPointAndBridge(int u){
    dfs_low[u]=dfs_num[u]=contador;
    contador++;

    visitados[u]=1; //esto no estaba >.<

    int j, v;
    for(j=0; j<ady[u].size(); j++){
        v=ady[u][j];

        if(visitados[v]==0){
            anterior[v]=u;

            //para el caso especial 
            if(u==dfsRaiz){
                hijosRaiz++;
            }

            articulationPointAndBridge(v);

            //PARA ITSMOS
            if(dfs_low[v]>=dfs_num[u]){
                itsmos[u]=1;
            }

            //PARA PUENTES
            if(dfs_low[v]>dfs_num[u]){
                puentes.push_back(make_pair(min(u,v),max(u,v)));
            }

            dfs_low[u]=min(dfs_low[u], dfs_low[v]);

        }else if(v!=anterior[u]){ //Arco que no sea backtrack
            dfs_low[u]=min(dfs_low[u], dfs_num[v]);
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin>>v>>e;
    int i, src, dest;
    while(v!=0 && e!=0){
        init();
        for(i=0; i<e; i++){
            cin>>src>>dest;
            ady[src].push_back(dest);
            ady[dest].push_back(src);
        }

        for(i=0; i<v; i++){
            if(visitados[i]==0){
                dfsRaiz=i;
                hijosRaiz=0;
                articulationPointAndBridge(i);
                if(hijosRaiz>1){
                    itsmos[dfsRaiz]=1;
                }else{
                    itsmos[dfsRaiz]=0;
                }
            }
        }

        sort(puentes.begin(), puentes.end());
        cout<<puentes.size();
        for(i=0; i<puentes.size(); i++){
            cout<<" "<<puentes[i].first<<" "<<puentes[i].second;    
        }

        cout<<endl;
        cin>>v>>e;
    }
}