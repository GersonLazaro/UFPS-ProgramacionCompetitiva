
//Imports Obligatorios al usar Scanner
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Esta es la solución para el ejercicio financial management
// Disponible en http://coj.uci.cu/24h/problem.xhtml?pid=1023
// En resumen: Recibo por entrada estandar 12 números decimales
// y debo hallar el promedio entre ellos. El resultado debe darse
// redondeado al segundo decimal.


public class EjercicioSimple{

    public static void main(String[] args) throws IOException {
        
        //Creamos un objeto de tipo Scanner. Este será el encargado de leer
        //los datos que sean pasados.
        Scanner sc = new Scanner();
        
        //El resultado se guardará en un float, por ser decimal
        float resultado=0;
        
        //Como desde un inicio sabemos que se recibirán 12 valores
        //Podemos realizar un for que realice el proceso 12 veces.
        for(int i=0;i<12;i++){
            //Cada nuevo valor lo vamos sumando al resultado.
            resultado+= sc.nextFloat();
        }
        
        //Como es un promedio, necesitamos dividir el resultado en el número
        //de datos. En este caso, son 12 datos.
        resultado = resultado / 12;
        //El ejercicio tiene una caracteristica especial: Pide redondear
        //la parte decimal a 2 números. Esto se soluciona con una variación 
        //sencilla del println, que es printf.
        //El $ es pedido por el ejercicio (el valor debe imprimirse como ($1581.42)
        //El %.2f significa: 
        //   % para indicar que es un valor que se pasará como parametro
        //   .2 indica el número de decimales
        //   f indica que tiene parte decimal (float)
        //El \n es el salto de linea (enter)
        //Por último, se pasa la variable resultado que será impresa
        //Esta reemplazará el %.2f, siendo impresa solo con dos decimales
        System.out.printf("$%.2f\n", resultado);
    }
    //Clase para hacer mas eficiente la lectura de datos 
    static class Scanner {
        //Atributos obligatorios
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");

        //De la libreria pasada, copiamos solo los metodos que utilizaremos
        


        /**
         * Devuelve el siguiente token delimitado por espacios o saltos 
         * de linea. Es decir, devuelve la siguiente palabra.
         * @return String con el siguiente token
         * @throws IOException 
         */
        public String next() throws IOException {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        } 


        /**
         * Escanea el siguiente token del stream como un float.
         * REQUIERE LA ESCRITURA DEL MÉTODO NEXT
         * @return float pasado por el input
         * @throws IOException 
         */    
        public double nextFloat() throws IOException {
            return Float.parseFloat(next());
        }

    }

}
