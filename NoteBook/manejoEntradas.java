
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.math.BigDecimal;
import java.math.BigInteger;

public class manejoEntradas {
    
    public static void main(String []args) throws IOException{
        Scanner sc = new Scanner();
        System.out.println(sc.nextBigInteger());
        System.out.println(sc.nextBigDecimal());
    }
    
    static class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        
        
        public String nextLine() throws IOException{
            return br.readLine();
        }
        
        public String next() throws IOException{
            while ( !st.hasMoreTokens() ) {
                st = new StringTokenizer(br.readLine() );
            }
            return st.nextToken();
        }
        
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
        
        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        
        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
        
        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
        
        public double nextFloat() throws IOException {
            return Float.parseFloat(next());
        }
        
        public double nextShort() throws IOException {
            return Short.parseShort(next());
        }
        
        public double nextByte() throws IOException {
            return Byte.parseByte(next());
        }
        
        public BigDecimal nextBigDecimal() throws IOException{
            return new BigDecimal(next());
        }
        
        public BigInteger nextBigInteger() throws IOException{
            return new BigInteger(next());
        }
        
        public StringBuilder nextStringBuilder() throws IOException{
            return new StringBuilder(next());
        }
        
    }
}