/*
Función totient o generatriz (φ) de Euler. Para cada posición n del array de
resultados retorna el número de enteros positivos menores o iguales a n que son
coprimos con n (Coprimos: MCD=1)
@param - int n: Tamaño del array
@param - int[] resultados: array donde se guardan los resultados
*/
static void totient(int n, int resultados[]){
	boolean aux[]=new boolean[n];
	for(int i=0; i<n; i++) {
		resultados[i]=i;
	}
	for(int i=2; i<n; i++){
		if(!aux[i]) {
			for(int j=i; j<n ; j+=i){
				aux[j]=true;
				resultados[j]= resultados[j]-(resultados[j]/i) ;
			}
		aux[i] = false;
		}
	}
}
