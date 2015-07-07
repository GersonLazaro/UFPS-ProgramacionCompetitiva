#include <bits/stdc++.h>
#define endl "\n"
#define Node pair<int,long long> //(Vertice adyacente, peso)

using namespace std;

/**
 * @author Bashkara's Formulae (team Candelaria):
 *      Gerson Lázaro - Melissa Delgado - Cristhian León
 *      UFPS
*/

int v,e;
vector<Node> ady[100001];
int visitado[100001];
long long distancia[100001];
int previo[100001];

class cmp
{
public:
    bool operator()(Node n1,Node n2)
    {
      if(n1.second>n2.second)
      return true;
      else
      return false;
    }
};

void init(){
    long long max=LLONG_MAX;
    
    for(int j=0; j<=v; j++){
        ady[j].clear();
        visitado[j]=0;
        previo[j]=-1;
        distancia[j]=max;
    }
}

void dijkstra(int inicio){
    priority_queue< Node , vector<Node> , cmp > cPrioridad;
    cPrioridad.push(Node(inicio, 0));//se inserta a la cola el nodo Inicial.
    distancia[inicio]=0;
    int actual, j, adyacente;
    long long peso;

    while(!cPrioridad.empty()){
        actual=cPrioridad.top().first;
        cPrioridad.pop();
        if(visitado[actual]==0){
            visitado[actual]==1;
            for(j=0; j<ady[actual].size(); j++){
                adyacente=ady[actual][j].first;
                peso=ady[actual][j].second;
                if(visitado[adyacente]==0){
                    if(distancia[adyacente]>distancia[actual]+peso){
                         distancia[adyacente]=distancia[actual]+peso;
                         previo[adyacente]=actual;
                         cPrioridad.push(Node(adyacente, distancia[adyacente]));
                     }
                }
            }
        }
    }
}

void imprimirRuta(int posicion){
    if(previo[posicion]==-1){
        if(posicion!=1){
            cout<<-1<<endl;
        }else{
            cout<<posicion<<" ";
        }
    }else{
        imprimirRuta(previo[posicion]);
        if(posicion==v){
            cout<<v<<endl;
        }else{
            cout<<posicion<<" ";
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    int i, inicio, fin;
    cin>>v>>e>>inicio>>fin;
    init();
    i=0;
    
    int src, dest, peso;
    
    while(i<e){
        cin>>src>>dest>>peso;
        ady[src].push_back(Node(dest, peso));
        ady[dest].push_back(Node(src, peso));
        i++;
    }
    
    dijkstra(inicio);
    imprimirRuta(fin);
}