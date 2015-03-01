
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /*
     Solución propuesta por Nataly Gamboa, William Torres y Melissa Delgado
     al ejercicio H. Ultra Quicksort trabajado en el taller del día 28 de febrero
     El enunciado del problema se encuetra dispobible en LightOJ: http://www.lightoj.com/practice_contest_showproblem.php?contest_id=669&problem=H
     o en UVA: http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1751
     */
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner();

        /* Leemos el primer dato que nos indicara cuantas posiciones va a tener el vector*/
        int n = sc.nextInt();
        int[] datos;
        /* Creamos un vector de una posición donde almacenaremos la cantidad de 
         intercambios necesarios para ordenar el vector de datos.
         */
        long[] swap = new long[1];
        int i;

        while (n != 0) {
            //Inicializamos el vector de datos a ordenar
            datos = new int[n];
            //Inicializamos los swaps en 0
            swap[0] = 0;
            i = 0;

            //Ciclo para leer y asignar los valores del vector a ordenar
            while (i < n) {
                datos[i] = sc.nextInt();
                i++;
            }

            /*Hacemos un llamado al método que se encargará de Ordenar el Vector.
             El método de ordenamiento elegido fue el Mergesort */
            mergeSort(datos, swap);

            System.out.println(swap[0]);
            n = sc.nextInt();

        }

    }

    /*
     Método que se encarga de realizar el Mergesort.
    
     Algo de historia: Fue desarrollado en 1945 por John Von Neumann.

     En que se basa: Conceptualmente, el ordenamiento por mezcla funciona de la siguiente manera:
     1. Si la longitud de la lista es 0 ó 1, entonces ya está ordenada. En otro caso:
     2. Dividir la lista desordenada en dos sublistas de aproximadamente la mitad del tamaño.
     3. Ordenar cada sublista recursivamente aplicando el mismo método.
     4. Mezclar las dos sublistas en una sola lista ordenada.
     */
    public static void mergeSort(int[] v, long[] swap) {
        final int N = v.length;

        /* Paso 1 */
        if (N <= 1) {
            return;
        }

        /* Paso 2 */
        int mitad = N / 2;
        int[] izq = Arrays.copyOfRange(v, 0, mitad);
        int[] der = Arrays.copyOfRange(v, mitad, N);

        /* Paso 3 */
        mergeSort(izq, swap);
        mergeSort(der, swap);

        /* Paso 4 */
        merge(v, izq, der, swap);
    }

    /*
     Método que se encarga del paso 4 del ordenamiento Mergesort: 
     "Mezclar las dos sublistas en una sola lista ordenada"
    
     A esta parte del método fue necesario hacerle una pequeña modificación
     para solucionar el problema propuesto. Es necesario que nosotros contemos la
     cantidad de intercambios necesaria para ordenar el vector.
    
     Recordemos lo siguiente, este método va a unir dos mitades previamente ordenadas.
     Por lo tanto podemos decir que una estructura se encuentra ordenada si toda la
     mitad izquierda es menor a toda la mitad derecha (estando ordenadas cada una de estas)
    
     Por lo tanto, si al momento de hacer la mezcla tengo que tomar primero un elemento 
     de la mitad derecha puedo decir que ahí hubo intercambios con cada uno de los
     elementos de la parte izquierda.
     */
    public static void merge(int[] resp, int[] izq, int[] der, long[] swap) {
        int i = 0; //Controla la mitad izquierda
        int j = 0; //Controla la mitad derecha
        int k = 0; //Controla el "Todo" donde uniremos las partes

        for (k = 0; i < izq.length && j < der.length; k++) {
            if (izq[i] < der[j]) {
                resp[k] = izq[i];
                i++;
            } else {
                /* La linea 113 es la modificación necesaria para el funcionamiento del
                 algoritmo  */
                swap[0] += izq.length - i;
                resp[k] = der[j];
                j++;
            }
        }

        while (i < izq.length) {
            resp[k] = izq[i];
            i++;
            k++;
        }

        while (j < der.length) {
            resp[k] = der[j];
            j++;
            k++;
        }
    }

    /**
     * CLASE para el manejo optimizado de entradas estandar en Java
     */
    static class Scanner {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");

        public String nextLine() throws IOException {
            if (st.hasMoreTokens()) {
                StringBuilder salida = new StringBuilder();
                while (st.hasMoreTokens()) {
                    salida.append(st.nextToken());
                    if (st.countTokens() > 0) {
                        salida.append(" ");
                    }
                }
                return salida.toString();
            }
            return br.readLine();
        }

        public String next() throws IOException {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

    }

}
