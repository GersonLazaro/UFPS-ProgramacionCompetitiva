
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
Este ejercicio se encuentra disponible en: http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=4719
Se basa en revisar dos cadenas de 5 numeros (0 o 1) separados por espacios
y verificar que cada numero sea distinto a su equivalente en la otra cadena
EJEMPLO:
0 1 0 1 0
1 0 1 0 1
Cumplen la condición
1 1 1 1 1
0 0 0 1 1
Los últimos 2 numeros no complen la condición
Si se cumple imprimir Y, de lo contrario, N
*/
public class machine {
    public static void main(String[] args) throws IOException{
        
        //Se crea una instancia del objeto Scanner para ingresar los datos
        Scanner sc = new Scanner();
        
        //El string a leerá la primera cadena y el string b la segunda
        String a,b;
        
        //Usamos hasNext porque el programa debe leer datos mientras existan
        //Es decir pueden enviar un solo caso de prueba (2 lineas) o 2 casos (4 lineas)
        // o 1000 casos (2000 lineas). El hasNext mantiene el ciclo en ejecución
        //Mientras hayan lineas por leer.
        while(sc.hasNext()){
            
            //Se leen las dos lineas y se guardan en ls variables
            a = sc.nextLine();
            b = sc.nextLine();
            
            //Este boolean será true, si se cumple la condición, false en caso contrario
            boolean rta=true;
            
            //El ciclo recorrerá al tiempo las dos cadenas. El i se aumentará de 2 en 2
            //Para saltar los espacios en blanco entre cada par de numeros
            for(int i=0;i<a.length();i=i+2){
                
                //Se valida si el caracter en una posición especifica de una cadena es igual al de la otra.
                //Si es verdadero, indica que la condición no se cumple. Hace falso el boolean y rompe el ciclo.
                if(a.charAt(i) == b.charAt(i)){
                   rta=false; 
                   break;
                }
                
            }
            //Si rta es true, es porque no se consiguió ningun par de caracteres que incumplieran la condición
            //Por lo tanto se imprime Y. En caso contrario, N.
            if(rta){
                System.out.println("Y");
            }else{
                System.out.println("N");
            }
            
        }
    }
    
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
            if(st.hasMoreTokens()){
                StringBuilder salida = new StringBuilder();
                while(st.hasMoreTokens()){
                    salida.append(st.nextToken());
                    if(st.countTokens()>0){
                        salida.append(" ");
                    }
                }
                return salida.toString();
            }
            return br.readLine();
        }

        
        /**
         * Retorna true si hay mas tokens en el flujo de datos, o falso
         * en caso contrario.
         * @return true si y solo si hay mas tokens
         * @throws IOException 
         */
        public boolean hasNext() throws IOException{
            while (!st.hasMoreTokens()) {
                String linea = br.readLine();
                if (linea == null) {
                    return false;
                }
                st = new StringTokenizer(linea);
            }
            return st.hasMoreTokens();
        }    
    }
}
