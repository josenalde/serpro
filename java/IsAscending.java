import java.util.Scanner;

public class IsAscending {
   public static void main(String[] args) {
        //int[] v = {1, 4, 6, 7};
        //int[] v = {1, 4, 2, 7};
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Tamanho de v: ");
        int n = sc.nextInt();
        int v[] = new int[n]; // declaração e alocação de espaço para o vetor "v"
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }
        // se não quiser digitar gerar
        /*
          a[i] = (int)Math.round(Math.random() * 10);
          gera um número inteiro aleatório no intervalo de 0 até 10
         */
        boolean f = true;
        for (int i = 0; i < v.length - 1; i++) {
            if (v[i+1] < v[i]) {
                f = false;
                break;
            }
        }
        if (f) System.out.println("S");
        else System.out.println("N");
        sc.close();
   }
}
