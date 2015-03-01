
import java.util.Scanner;

public class Main {
    /*
     Solución propuesta por Daniel Vega y Eduardo Botello al ejercicio D. How Many Primes trabajado en el taller del día 28 de febrero
     El enunciado del problema se encuetra dispobible en COJ: http://coj.uci.cu/24h/problem.xhtml?pid=2427
     o en LightOJ: http://www.lightoj.com/practice_contest_showproblem.php?contest_id=669&problem=D
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /*false = numeros primos.
         true = los que no son numeros primos.*/
        boolean[] v = new boolean[1000001];

        /*Vector acumulador de la cantidad de primos*/
        int[] cantidad_Primos = new int[1000001];

        /* Se aplico el método de la Criba de Eratostenes trabajado 
        anteriormente para el calculo de todos los números primos
        */
        for (int i = 2; i <= v.length / 2; i++) {
            if (v[i] == false) {
                for (int j = i + i; j < v.length; j += i) {
                    v[j] = true;
                }
            }
        }

        //Variable auxiliar para llevar el acumulado de numeros primos
        int cp = 0;

        //Ciclo para realizar el conteo de los primos
        for (int h = 2; h < cantidad_Primos.length; h++) {
            if (!v[h]) {
                cp++;
            }
            cantidad_Primos[h] = cp;
        }

        //Se realiza la lectura de los dos primeros datos de entrada
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        //Ciclo para el procesado y lectura de datos
        while (a > 0 && b > 0) {

            //Se calcula la cantidad de primos existentes entre estas entradas
            int res = cantidad_Primos[b] - cantidad_Primos[a - 1];

            System.out.println(res);
            a = sc.nextInt();
            b = sc.nextInt();
        }

    }

}
