public class CarroMachine {

    private final Carro carro;
    private int marcha = 0;
    private int velocidade = 0;

    public CarroMachine(Carro carro) {
        this.carro = carro;
    }

    public void ligarCarro() {
        if (!carro.isIgnicao()) {
            carro.setIgnicao(true);
            marcha = 0;
            velocidade = 0;
            System.out.println("O carro " + carro.getMarca() + " foi ligado.");
        } else {
            System.out.println("O carro já está ligado.");
        }
    }

    public void desligarCarro() {
        if (carro.isIgnicao() && marcha == 0 && velocidade == 0) {
            carro.setIgnicao(false);
            System.out.println("O carro " + carro.getMarca() + " foi desligado.");
        } else {
            System.out.println("Não é possível desligar o carro agora, diminua a velocidade");
        }
    }

    public void acelerar() {
        if (!carro.isIgnicao()) {
            System.out.println("O carro está desligado.");
            return;
        }

        if (marcha == 0) {
            System.out.println("Não é possível acelerar em ponto morto.");
            return;
        }

        if (velocidade >= 120) {
            System.out.println("Velocidade máxima atingida!");
            return;
        }

        velocidade++;
        if (!validarMarchaVelocidade()) {
            velocidade--;
            System.out.println("A velocidade não é compatível com a marcha atual!");
            return;
        }

        System.out.println("Acelerando... Velocidade atual: " + velocidade + " km/h");
    }

    public void frear() {
        if (!carro.isIgnicao()) {
            System.out.println("O carro está desligado.");
            return;
        }

        if (velocidade > 0) {
            velocidade--;
            System.out.println("Freando... Velocidade atual: " + velocidade + " km/h");
        } else {
            System.out.println("O carro já está parado.");
        }
    }

    public void aumentarMarcha() {
        if (!carro.isIgnicao()) {
            System.out.println("Ligue o carro para engatar a marcha.");
            return;
        }

        if(validarMarchaVelocidade()){
            System.out.println("Aumente a velocidade primeiro");
        }

        if (marcha < 6) {
            marcha++;
            System.out.println("Marcha aumentada para: " + marcha);
        } else {
            System.out.println("Marcha máxima atingida.");
        }
    }

    public void diminuirMarcha() {
        if (!carro.isIgnicao()) {
            System.out.println("Ligue o carro para reduzir a marcha.");
            return;
        }

        if (marcha > 0) {
            marcha--;
            System.out.println("Marcha reduzida para: " + marcha);
        } else {
            System.out.println("O carro já está em ponto morto.");
        }
    }

    public void virar(String direcao) {
        if (!carro.isIgnicao()) {
            System.out.println("O carro está desligado.");
            return;
        }

        if (velocidade < 1 || velocidade > 40) {
            System.out.println("Só é possível virar entre 1km/h e 40km/h.");
            return;
        }

        if (direcao.equalsIgnoreCase("esquerda") || direcao.equalsIgnoreCase("direita")) {
            System.out.println("Virando para a " + direcao + "...");
        } else {
            System.out.println("Direção inválida. Use 'esquerda' ou 'direita'.");
        }
    }

    private boolean validarMarchaVelocidade() {
        return switch (marcha) {
            case 1 -> velocidade >= 0 && velocidade <= 20;
            case 2 -> velocidade >= 21 && velocidade <= 40;
            case 3 -> velocidade >= 41 && velocidade <= 60;
            case 4 -> velocidade >= 61 && velocidade <= 80;
            case 5 -> velocidade >= 81 && velocidade <= 100;
            case 6 -> velocidade >= 101 && velocidade <= 120;
            default -> velocidade == 0; // ponto morto (marcha 0)
        };
    }

    public int getVelocidade() {
        int velocidade1 = velocidade;
        return velocidade1;
    }

    public int getMarcha() {
        int marcha1 = marcha;
        return marcha1;
    }
}
