
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Solución propuesta al ejercicio Mathematician Ana desarrollada en la reunion del día 23 de febrero
El enunciado del problema se encuetra dispobible aquí: http://www.lightoj.com/practice_contest_showproblem.php?contest_id=662&problem=A&type=pdf
*/
public class Main{

    public static void main(String[] args) throws IOException {
        /*Creamos un vector de booleans de 51 posiciones donde el indice de 
        cada posición correspondera a un número n y la posición del vector en 
        ese indice nos indicara si es primo(false) o si no lo es(true)*/
        boolean valores[] = new boolean[51];
        
        valores[0] = true;  //El número cero no es primo por lo tanto lo inicializamos True
        
        /*En este ciclo lo que vamos a intentar simular es una criba de Eratostenes, en 
        donde iremos "eliminando" gradualmente todos aquellos números que no sean primos.
        Lo recorremos hasta 25 ya que el primer multiplo de 26 será 52 y se sale del rango.        
        */
        for(int i=2;i<=25;i++){
            //Evaluamos si este número no lo hemos "eliminado"
            if(!valores[i]){
                /*Como no lo hemos eliminado lo que haremos será "eliminar" todos sus multiplos
                a traves del siguiente ciclo*/
                for(int j=i+i;j<=50;j+=i){
                    valores[j]=true;
                }
            }
        }
        
        //Inicializamos el Scanner
        Scanner sc=new Scanner();
        
        //Leemos el primer dato a procesar de la entrada
        int n=sc.nextInt();
        long res;
        
        /*Como el INPUT nos decia que procesaramos datos hasta que llegara
        un cero creamos el ciclo que nos permitirá controlar esta situación. */
        while(n!=0){
            //Importante reiniciar los valores de las variables al hacer el procesamiento :)
            res=1;
            
            /*En este ciclo lo que haremos será calcular el Primorial (la ultiplicación de todos los números
            primos menores o iguales a n). Recordemos que en nuestro vector de booleans los números primos son
            aquellos que estan en "False"*/
            for(int i=1; i<=n; i++){
                if(!valores[i]){
                    res*=i;
                }
            }
            
            //Imprimimos la respuesta
            System.out.println(res);
            
            //Realizamos la lectura del siguiente dato :)
            n=sc.nextInt();
        }
        
    }

    /**
     * CLASE para el manejo optimizado de entradas estandar en Java
     */
    static class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        
        /**
         * Devuelve la siguiente linea entera en el stream.
         * @return String con la linea siguiente
         * @throws IOException 
         */
        public String nextLine() throws IOException{
            return br.readLine();
        }
        
        /**
         * Devuelve el siguiente token delimitado por espacios o saltos 
         * de linea. Es decir, devuelve la siguiente palabra.
         * @return String con el siguiente token
         * @throws IOException 
         */
        public String next() throws IOException{            
            while ( !st.hasMoreTokens() ) {
                st = new StringTokenizer(br.readLine() );
            }
            return st.nextToken();
        }
        
        /**
         * Escanea el siguiente token del stream como un entero.
         * REQUIERE LA ESCRITURA DEL MÉTODO NEXT
         * @return int pasado por el input
         * @throws IOException 
         */
        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
