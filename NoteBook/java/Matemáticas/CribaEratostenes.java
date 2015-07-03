/* devuelve en un arraylist los números primos menores a n
 */
static ArrayList<Integer> criba(int n){
   boolean criba_bool[] = new boolean[n+5];
   criba_bool[0] = criba_bool[1] = true;
   for (int i = 2; i * i <= n; i ++){
     if (!criba_bool[i]){
       for (int j = i * i; j <= n; j += i){
         criba_bool[j] = true;
       }
     }
   }
   ArrayList<Integer> primos = new ArrayList<Integer>();
   for (int i = 2; i <= n; ++i){
     if (!criba_bool[i]){
       primos.add(i);
     }
   }
   return primos;
}
