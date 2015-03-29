/* Los indices primos del array m quedan como false, los demas como true
 */
public static void criba(boolean m[]){
    m[0] = true;
    m[1] = true;
    for(int i = 2; i*i < m.length; i++) {
        if(!m[i]) {
            for(int h = 2; i*h < m.length; h++)
                m[i*h] = true;
        }
    }
}