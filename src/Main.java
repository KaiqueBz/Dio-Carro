
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Carro meuCarro = new Carro("Toyota");
        CarroMachine simulador = new CarroMachine(meuCarro);
        var option = -1;
        System.out.println("\n********* Programa Car ***********");

        try {

            do {
                System.out.println("\nEscolha a opção desejada");
                System.out.println("1- Ligar o carro ");
                System.out.println("2- Desligar o carro");
                System.out.println("3- Acelerar");
                System.out.println("4- Diminuir a velocidade");
                System.out.println("5- Virar o carro para esquerda");
                System.out.println("6- Virar o carro para direita");
                System.out.println("7- Verificar velocidade atual");
                System.out.println("8- Verficar marcha atual");
                System.out.println("9- Subir marcha");
                System.out.println("10- Descer marcha");
                System.out.println("0- Sair\n");

                option = scanner.nextInt();

                switch (option) {
                    case 1 -> simulador.ligarCarro();
                    case 2 -> simulador.desligarCarro();
                    case 3 -> simulador.acelerar();
                    case 4 -> simulador.frear();
                    case 5 -> simulador.virar("esquerda");
                    case 6 -> simulador.virar("direita");
                    case 7 -> System.out.println("Velocidade atual: " + simulador.getVelocidade() + " km/h");
                    case 8 -> System.out.println("Marcha atual: " + simulador.getMarcha());
                    case 9 -> simulador.aumentarMarcha();
                    case 10 -> simulador.diminuirMarcha();
                    case 0 -> System.exit(0);
                    default -> System.out.println("Opção Inválida");
                }
            } while (option != 0);
        }catch (Exception ex){
            System.out.println("Digite um número válido");
        }

    }
}
