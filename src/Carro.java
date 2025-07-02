public class Carro {

    private final String marca;

    private boolean ignicao;

    public Carro(String marca){
        this.marca = marca;
        this.ignicao = false;
    }

    public String getMarca() {
        return marca;
    }

    public boolean isIgnicao() {
        return ignicao;
    }

    public void setIgnicao(boolean ignicao) {
        this.ignicao = ignicao;
    }
}
