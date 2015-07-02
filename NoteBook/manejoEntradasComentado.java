import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Sobreescritura de la libreria Scanner para mejorar la eficiencia
 * en eventos de programación competitiva.
 * @version 4.0
 * @author Bashkara's Formulae (team Candelaria):
 * 		Gerson Lázaro - Melissa Delgado - Cristhian León
 * 		UFPS
 */
public class Main {


    static class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        int espacios = 0;
        /**
         * Devuelve la siguiente linea entera en el stream.
         * @return String con la linea siguiente
         * @throws IOException
         */
        public String nextLine() throws IOException{
        	if(espacios>0){
            	espacios--;
            	return "";
            }else if(st.hasMoreTokens()){
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
         * Devuelve el siguiente token delimitado por espacios o saltos
         * de linea. Es decir, devuelve la siguiente palabra.
         * @return String con el siguiente token
         * @throws IOException
         */
        public String next() throws IOException{
        	espacios=0;
            while (!st.hasMoreTokens() ) {
                st = new StringTokenizer(br.readLine() );
            }
            return st.nextToken();
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
                if(linea.equals("")){
                	espacios++;
                }
                st = new StringTokenizer(linea);
            }
            return true;
        }
        /**
         * Escanea el siguiente token del stream como el tipo de dato numerico
         * requerido.
         * Este tipo de dato puede ser int, long, short, byte, double o float
         * IMPORTANTE: Este metodo es solo una plantilla, debe modificarse
         * para ser utilizado.
         * @require next()
         * @return int pasado por el input
         * @throws IOException
         */
         //public tipo nextTipoDato() throws IOException {
         //	return Tipo.parseTipo(next());
         //}
    }
}
