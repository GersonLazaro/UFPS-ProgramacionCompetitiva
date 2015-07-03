/* devuelve en un arraylist los números primos menores a n
 */
 vector<int> criba(int n){
 	bool criba_bool[n+5];
 	memset(criba_bool, false, sizeof(criba_bool));
 	criba_bool[0] = criba_bool[1] = true;
 	for (int i = 2; i * i <= n; i ++){
 		if (!criba_bool[i]){
 			for (int j = i * i; j <= n; j += i){
 				criba_bool[j] = true;
 			}
 		}
 	}
 	vector<int> primos;
 	for (int i = 2; i <= n; ++i){
 		if (!criba_bool[i]){
 			primos.push_back(i);
 		}
 	}
 	return primos;
 }
