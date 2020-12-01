import java.util.Scanner;

public class coffeecoffee {

    public static String imprime(int[] minutos, int menorTempo) {
        String a = menorTempo + "\n";
        //System.out.printf("%d\n", menorTempo);
        for (int i=0; i<minutos.length; i++) {
            if (minutos[i] == menorTempo) {
                a += i+1 + " ";
                //System.out.printf("%d ", i+1);
            }
        }

        return a;
    }

    public static int minMinutos(int[] minutosPorAndar) {
        int menorTempo = 0;

        for (int i=0; i<minutosPorAndar.length; i++) {
            if (menorTempo == 0 || menorTempo > minutosPorAndar[i]) {
                menorTempo = minutosPorAndar[i];
            }
        }

        return menorTempo;
    }

    public static int[] minutosPorAndar(int[] funcionarios, int andares) {
        int[] minutos = new int[andares];

        for(int i=0; i<andares; i++) {
            minutos[i] = 0;
        }

        for (int i=0; i<andares; i++) {
            for (int j=0; j<andares; j++) {
                if (i == j) {
                    continue;
                }
                minutos[i] = minutos[i] + (Math.abs(i - j) * funcionarios[j]) * 2;
            }
        }

        return minutos;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String a;
        int andares;
        int menorTempo;
        int[] funcionarios;
        int[] minutosPorAndar;

        andares = entrada.nextInt();
        funcionarios = new int[andares];

        for(int i=0; i<andares; i++) {
            funcionarios[i] = entrada.nextInt();
        }

        minutosPorAndar = minutosPorAndar(funcionarios, andares);
        menorTempo = minMinutos(minutosPorAndar);
        a = imprime(minutosPorAndar, menorTempo);
        System.out.printf("%s", a);

    }
}
