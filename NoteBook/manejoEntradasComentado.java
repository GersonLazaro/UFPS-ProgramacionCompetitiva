
//Imports Obligatorios
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//Imports opcionales: Solo se necesitan con los metodos nextBigDecimal y
//nextBigInteger
import java.math.BigDecimal;
import java.math.BigInteger;


/**
 * Sobreescritura de la libreria Scanner para mejorar la eficiencia
 * en eventos de programación competitiva. 
 * @version 3.0
 */
public class manejoEntradasComentado {

    
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
        
        /**
         * Escanea el siguiente token del stream como un entero.
         * REQUIERE LA ESCRITURA DEL MÉTODO NEXT
         * @return int pasado por el input
         * @throws IOException 
         */
        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        
        /**
         * Escanea el siguiente token del stream como un Long.
         * REQUIERE LA ESCRITURA DEL MÉTODO NEXT
         * @return long pasado por el input
         * @throws IOException 
         */
        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
        
        /**
         * Escanea el siguiente token del stream como un double.
         * REQUIERE LA ESCRITURA DEL MÉTODO NEXT
         * @return double pasado por el input
         * @throws IOException 
         */
        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
        
        /**
         * Escanea el siguiente token del stream como un float.
         * REQUIERE LA ESCRITURA DEL MÉTODO NEXT
         * @return float pasado por el input
         * @throws IOException 
         */
        public float nextFloat() throws IOException {
            return Float.parseFloat(next());
        }
        
        /**
         * Escanea el siguiente token del stream como un short.
         * REQUIERE LA ESCRITURA DEL MÉTODO NEXT
         * @return short pasado por el input
         * @throws IOException 
         */
        public short nextShort() throws IOException {
            return Short.parseShort(next());
        }
        
        /**
         * Escanea el siguiente token del stream como un byte.
         * REQUIERE LA ESCRITURA DEL MÉTODO NEXT
         * @return byte pasado por el input
         * @throws IOException 
         */
        public byte nextByte() throws IOException {
            return Byte.parseByte(next());
        }
        
        /**
         * Escanea el siguiente token del stream como un bigDecimal.
         * REQUIERE LA ESCRITURA DEL MÉTODO NEXT
         * @return bigDecimal pasado por el input
         * @throws IOException 
         */
        public BigDecimal nextBigDecimal() throws IOException{
            return new BigDecimal(next());
        }
        
        /**
         * Escanea el siguiente token del stream como un BigInteger.
         * REQUIERE LA ESCRITURA DEL MÉTODO NEXT
         * @return bigInteger pasado por el input
         * @throws IOException 
         */
        public BigInteger nextBigInteger() throws IOException{
            return new BigInteger(next());
        }
        
        /**
         * Escanea el siguiente token del stream como un StringBuilder.
         * REQUIERE LA ESCRITURA DEL MÉTODO NEXT
         * @return stringBuilder pasado por el input
         * @throws IOException 
         */
        public StringBuilder nextStringBuilder() throws IOException{
            return new StringBuilder(next());
        }
        
    }
}