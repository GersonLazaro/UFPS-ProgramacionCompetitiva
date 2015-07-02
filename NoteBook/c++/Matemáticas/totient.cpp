/*
Función totient o generatriz (φ) de Euler. Para cada posición n del array de
resultados retorna el número de enteros positivos menores o iguales a n que son
coprimos con n (Coprimos: MCD=1)
@param - int n: Tamaño del array
@param - int[] resultados: array donde se guardan los resultados
*/
void totient (int n, int resultados[]) {
	bool aux[n];
	for(int i=0; i<n; i++) {
		resultados[i]=i;
		aux[i]=true ;
	}
	for(int i=2; i<n; i++){
		if(aux[i]) {
			for(int j=i; j<n ; j+=i){
				aux[j]=false ;
				resultados[j]= resultados[j]-(resultados[j]/i) ;
			}
			aux[i] = true ;
		}
	}
}
