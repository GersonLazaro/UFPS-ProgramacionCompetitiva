
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    /*
     Solución propuesta al ejercicio List of Conquests propuesto en la reunion del día 23 de febrero
     El enunciado del problema se encuetra dispobible aquí: http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1361
     */
    public static void main(String[] args) throws IOException {

        //Inicializamos el Scanner 
        Scanner sc = new Scanner();
        
        /*Leemos el primer dato de la entrada que nos indica la cantidad de conquistas
        y que nos permitira controlar la lectura de datos*/
        int n = sc.nextInt();
        
        //Iniciamos todas las estructuras necesarias para el procesamiento de datos
        ArrayList<Pais> paises = new ArrayList<Pais>();
        Pais aux;
        int indice;
        
        //Ciclo para realizar la lectura de la información de todas las conquistas
        while (n > 0) {
            /*Creamos un nuevo objeto de tipo pais, leyendo la primera palabra
            de la linea de entrada  */
            aux = new Pais(sc.next());
            
            /*Como el nombre de la conquista no es reelevante para el procesamiento 
            no es necesario almacenarlo, simplemente lo leemos para  continuar la ejecución*/
            sc.nextLine();
            
            /*Buscamos la posición dentro del ArrayList del pais que acabamos de leer. 
            Si este pais no se encuentra aún en la estructura obtendremos un -1
            */
            indice = paises.indexOf(aux);
            
            if (indice == -1) {
                /*Si el pais no se encontraba, lo añadimos al ArrayList*/
                paises.add(aux);
            } else {
                /*Si el pais si estaba en la estructura aumentamos su incidencia*/
                paises.get(indice).incidencia++;
            }
            n--;
        }

        /*Ordenamos el ArrayList*/
        Collections.sort(paises);

        /*Imprimimos cada una de las posiciones del Array de acuerdo al formato
        que nos indicaba el OUTPUT*/
        while (paises.size() > 0) {
            aux = paises.remove(0);
            System.out.println(aux.nombre + " " + aux.incidencia);
        }

    }

    /**
     * CLASE para almacenar los datos de un Pais. Implementa la interface Comparable
     * para poder utilizar el método compareTo necesario para el Collections.sort
     */
    static class Pais implements Comparable<Pais> {

        public String nombre;
        public int incidencia;

        /*Constructor de nuestra clase que asigna el nombre del pais
        de acuerdo a la entrada y su incidencia en 0*/
        public Pais(String nombre) {
            this.nombre = nombre;
            this.incidencia = 1;
        }

        /*Sobreescribimos el método equals para poder utilizar métodos como 
        indexOf de ArrayList. Decimos que un pais es igual a otro si tienen el
        mismo nombre*/
        @Override
        public boolean equals(Object a) {
            Pais aa = (Pais) a;
            if (this.nombre.equals(aa.nombre)) {
                return true;
            }
            return false;
        }

        /*Sobreescribimos el método CompareTo para poder realizar ordenamientos.
        Decimos que un pais es mayor a otro de acuerdo al orden alfábetico de sus nombres        
        */
        @Override
        public int compareTo(Pais o) {
            return this.nombre.compareTo(o.nombre);
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

        public boolean hasNext() throws IOException {
            while (!st.hasMoreTokens()) {
                String linea = br.readLine();
                if (linea == null) {
                    return false;
                }
                st = new StringTokenizer(linea);
            }
            return st.hasMoreTokens();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

    }
}
