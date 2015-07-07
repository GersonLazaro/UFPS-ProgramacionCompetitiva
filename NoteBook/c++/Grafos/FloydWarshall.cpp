#include <bits/stdc++.h>
#define endl "\n"
#define Node pair<int,long long> //(Vertice adyacente, peso)

using namespace std;

/**
 * @author Bashkara's Formulae (team Candelaria):
 *      Gerson Lázaro - Melissa Delgado - Cristhian León
 *      UFPS
*/

int v,e,n;
int clon[500][500];

void floydWarshall(){
    int k=0;
    int aux, i ,j;
    
    while(k<n){
        for(i=0; i<n; i++){
            if(i!=k){
                for(j=0; j<n; j++){
                    if(j!=k){
                        aux=clon[i][k]+clon[k][j];
                        if(aux<clon[i][j] && aux>0){ 
                            clon[i][j]=aux;
                        }
                    }
                }
            }
        }
        k++;
    }
}


int main(){
    ios_base::sync_with_stdio(false);

    cin>>n;
    int i,j;

    for(i=0; i<n; i++){
        for(j=0; j<n; j++){
            cin>>clon[i][j];
        }
    }

    floydWarshall();
    
    for(i=0; i<n; i++){
        for(j=0; j<n; j++){
            cout<<clon[i][j]<<" ";
        }
        cout<<endl;
    }
}