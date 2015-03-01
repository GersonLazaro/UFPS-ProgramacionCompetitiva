import java.util.Scanner;
 
public class Main {
 
    /*
     Solución propuesta por Gustavo Tarazona y Victor Patiño al ejercicio A. Humbertomb Moralomb's Sequence
     trabajado en el taller del día 28 de febrero
     El enunciado del problema se encuetra dispobible en COJ: http://coj.uci.cu/24h/problem.xhtml?pid=2428
     o en LightOJ: http://www.lightoj.com/practice_contest_showproblem.php?contest_id=669&problem=A
     */
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        long aux=sc.nextLong();
        while(aux!=0){
            /*Se calcula la raiz cuadrada del dato de entrada y se aproxima Techo */
            long aux1=(long)Math.ceil(Math.sqrt((double)aux));
            System.out.println(aux1);
            aux=sc.nextLong();
        }
    }
   
}